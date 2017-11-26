package com.globot.hmi.attendance;
/**
 * Created by lixiaoliang on 2017/11/14.
 */

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.api.ProgressCallback;
import org.mybatis.generator.config.*;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: lixiaoliang
 * Date: 2017/11/14
 * Time: 下午8:13
 */
public class ExecuteGenerator {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExecuteGenerator.class);
    private boolean overwrite = true;
    private List<String> warnings = Lists.newArrayList();
    private Class pageClass;
    private String databaseUrl;
    private String databaseUsername;
    private String databasePassword;
    private String javaCodeBasePath;
    private String resourcesBasePath;
    private String domainPackage;
    private String mapperPackage;
    private String mapperXmlFolder;

    public ExecuteGenerator() {
    }

    public void invoke() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        Configuration configuration = this.createConfigurationParser();
        this.setConnectionConfig(configuration);
        this.setPageClass(configuration);
        this.setDomainConfig(configuration);
        this.setMapperConfig(configuration);
        this.setMapperXmlConfig(configuration);
        if(this.overwrite) {
            this.clearOriginMapperXml(configuration);
        }

        DefaultShellCallback callback = new DefaultShellCallback(this.overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, callback, this.warnings);
        myBatisGenerator.generate((ProgressCallback)null);
    }

    private Configuration createConfigurationParser() throws IOException, XMLParserException {
        URL generatorConfig = this.getClass().getClassLoader().getResource("generatorConfig.xml");
        Preconditions.checkNotNull(generatorConfig, "无法找到generator的配置文件,默认使用resources下的generatorConfig.xml文件");
        ConfigurationParser cp = new ConfigurationParser(this.warnings);
        return cp.parseConfiguration(new File(generatorConfig.getFile()));
    }

    private void setConnectionConfig(Configuration configuration) {
        Iterator var2 = configuration.getContexts().iterator();

        while(var2.hasNext()) {
            Context context = (Context)var2.next();
            JDBCConnectionConfiguration jdbcConfig = context.getJdbcConnectionConfiguration();
            jdbcConfig.setDriverClass("com.mysql.jdbc.Driver");
            if(StringUtils.isNotEmpty(this.databaseUrl)) {
                jdbcConfig.setConnectionURL(this.databaseUrl);
            }

            if(StringUtils.isNotEmpty(this.databaseUsername)) {
                jdbcConfig.setUserId(this.databaseUsername);
            }

            if(StringUtils.isNotEmpty(this.databasePassword)) {
                jdbcConfig.setPassword(this.databasePassword);
            }
        }

    }

    private void setPageClass(Configuration configuration) {
        Iterator var2 = configuration.getContexts().iterator();

        while(var2.hasNext()) {
            Context context = (Context)var2.next();

            try {
                Field e = Context.class.getDeclaredField("pluginConfigurations");
                e.setAccessible(true);
                List pluginConfigs = (List)e.get(context);
                Iterator var6 = pluginConfigs.iterator();

                while(var6.hasNext()) {
                    PluginConfiguration pluginConfig = (PluginConfiguration)var6.next();
                    if(PageablePlugin.class.isAssignableFrom(Class.forName(pluginConfig.getConfigurationType())) && this.pageClass != null) {
                        pluginConfig.getProperties().setProperty("pageClass", this.pageClass.getName());
                    }
                }
            } catch (Exception var8) {
                var8.printStackTrace();
            }
        }

    }

    private void setDomainConfig(Configuration configuration) {
        Iterator var2 = configuration.getContexts().iterator();

        while(var2.hasNext()) {
            Context context = (Context)var2.next();
            JavaModelGeneratorConfiguration javaModelConfig = context.getJavaModelGeneratorConfiguration();
            if(StringUtils.isNotEmpty(this.javaCodeBasePath)) {
                javaModelConfig.setTargetProject(this.javaCodeBasePath);
            }

            if(StringUtils.isNotEmpty(this.domainPackage)) {
                javaModelConfig.setTargetPackage(this.domainPackage);
            }
        }

    }

    private void setMapperXmlConfig(Configuration configuration) {
        Iterator var2 = configuration.getContexts().iterator();

        while(var2.hasNext()) {
            Context context = (Context)var2.next();
            SqlMapGeneratorConfiguration mapperXmlConfig = context.getSqlMapGeneratorConfiguration();
            if(StringUtils.isNotEmpty(this.resourcesBasePath)) {
                mapperXmlConfig.setTargetProject(this.resourcesBasePath);
            }

            if(StringUtils.isNotEmpty(this.mapperXmlFolder)) {
                mapperXmlConfig.setTargetPackage(this.mapperXmlFolder);
            }
        }

    }

    private void setMapperConfig(Configuration configuration) {
        Iterator var2 = configuration.getContexts().iterator();

        while(var2.hasNext()) {
            Context context = (Context)var2.next();
            JavaClientGeneratorConfiguration mapperConfig = context.getJavaClientGeneratorConfiguration();
            if(StringUtils.isNotEmpty(this.javaCodeBasePath)) {
                mapperConfig.setTargetProject(this.javaCodeBasePath);
            }

            if(StringUtils.isNotEmpty(this.mapperPackage)) {
                mapperConfig.setTargetPackage(this.mapperPackage);
            }
        }

    }

    private void clearOriginMapperXml(Configuration configuration) {
        Iterator var2 = configuration.getContexts().iterator();

        while(true) {
            while(var2.hasNext()) {
                Context context = (Context)var2.next();
                SqlMapGeneratorConfiguration mapperXmlConfig = context.getSqlMapGeneratorConfiguration();
                File mapperFolder = new File(mapperXmlConfig.getTargetProject(), mapperXmlConfig.getTargetPackage());
                if(mapperFolder.exists() && mapperFolder.isDirectory()) {
                    ArrayList mapperXmls = Lists.newArrayList(Iterables.filter(Lists.newArrayList(mapperFolder.listFiles()), new Predicate<File>() {
                        public boolean apply(File input) {
                            return input.isFile() && input.getName().endsWith(".xml");
                        }
                    }));
                    LOGGER.info("清除原来存在的mapper xml文件,文件有:{}", Lists.newArrayList(Iterables.transform(mapperXmls, new Function<File,String>() {
                        public String apply(File input) {
                            return input.getAbsolutePath();
                        }
                    })));
                    ArrayList failDeleteXml = Lists.newArrayList(Iterables.filter(mapperXmls, new Predicate<File>() {
                        public boolean apply(File input) {
                            return !input.delete();
                        }
                    }));
                    Preconditions.checkState(CollectionUtils.isEmpty(failDeleteXml), MessageFormatter.format("有部份xml文件清楚失败,请检查,失败文件:[{}]", Lists.newArrayList(Iterables.transform(failDeleteXml, new Function<File, String>() {
                        public String apply(File input) {
                            return input.getAbsolutePath();
                        }
                    }))).getMessage());
                } else {
                    LOGGER.error("无法清除原来存在的mapper xml文件,因为路径[{}]不存在或不是一个文件夹", mapperFolder.getAbsoluteFile());
                }
            }

            return;
        }
    }

    public ExecuteGenerator setOverwrite(boolean overwrite) {
        if(!overwrite) {
            LOGGER.warn("!!!!!!!!!!!!!! 如果想将override设为false需要谨慎操作 !!!!!!!!!!!!!!");
            LOGGER.warn("因为mapper xml文件总是以追加的形式重新生成的,有可能导致内容重复而在启动时报Result Maps collection already contains value异常");
        }

        this.overwrite = overwrite;
        return this;
    }

    public ExecuteGenerator setWarnings(List<String> warnings) {
        this.warnings = warnings;
        return this;
    }

    public ExecuteGenerator setPageClass(Class pageClass) {
        this.pageClass = pageClass;
        return this;
    }

    public ExecuteGenerator setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
        return this;
    }

    public ExecuteGenerator setDatabaseUsername(String databaseUsername) {
        this.databaseUsername = databaseUsername;
        return this;
    }

    public ExecuteGenerator setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
        return this;
    }

    public ExecuteGenerator setJavaCodeBasePath(String javaCodeBasePath) {
        this.javaCodeBasePath = javaCodeBasePath;
        return this;
    }

    public ExecuteGenerator setResourcesBasePath(String resourcesBasePath) {
        this.resourcesBasePath = resourcesBasePath;
        return this;
    }

    public ExecuteGenerator setDomainPackage(String domainPackage) {
        this.domainPackage = domainPackage;
        return this;
    }

    public ExecuteGenerator setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
        return this;
    }

    public ExecuteGenerator setMapperXmlFolder(String mapperXmlFolder) {
        this.mapperXmlFolder = mapperXmlFolder;
        return this;
    }
}
