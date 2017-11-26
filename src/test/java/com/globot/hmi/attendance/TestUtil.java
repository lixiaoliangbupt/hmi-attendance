package com.globot.hmi.attendance;/**
 * Created by lixiaoliang on 2017/11/15.
 */

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

/**
 * User: lixiaoliang
 * Date: 2017/11/15
 * Time: 上午11:03
 */
public class TestUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestUtil.class);

    public TestUtil() {
    }

    public static String calculateWebResourcesDir() {
        String classpathDir = TestUtil.class.getResource("/").getFile();
        File webResources = new File(classpathDir, "../../src/main/webapp");
        return tryFolder(webResources, "webapp");
    }

    public static String calculateJavaCodeDir() {
        String classpathDir = TestUtil.class.getResource("/").getFile();
        File javaCode = new File(classpathDir, "../../src/main/java");
        return tryFolder(javaCode, "java源码");
    }

    public static String calculateResourcesDir() {
        String classpathDir = TestUtil.class.getResource("/").getFile();
        File resources = new File(classpathDir, "../../src/main/resources");
        return tryFolder(resources, "resources");
    }

    public static String calculateJavaTestCodeDir() {
        String classpathDir = TestUtil.class.getResource("/").getFile();
        File javaTestCode = new File(classpathDir, "../../src/test/java");
        return tryFolder(javaTestCode, "java测试源码");
    }

    public static String calculateTestResourcesDir() {
        String classpathDir = TestUtil.class.getResource("/").getFile();
        File testResources = new File(classpathDir, "../../src/test/resources");
        return tryFolder(testResources, "测试resources");
    }

    public static List<String> calculateAllResourcePaths() {
        ArrayList allResourcesPath = Lists.newArrayList();
        allResourcesPath.addAll(calculateResourcePaths());
        allResourcesPath.addAll(calculateTestResourcePaths());
        return allResourcesPath;
    }

    public static List<String> calculateResourcePaths() {
        return getPathsFromClasspath(new Predicate<URL>() {
            public boolean apply(URL input) {
                return input != null && StringUtils.isNotEmpty(input.getFile()) && !input.getFile().contains("test-classes");
            }
        });
    }

    public static List<String> calculateTestResourcePaths() {
        return getPathsFromClasspath(new Predicate<URL>() {
            public boolean apply(URL input) {
                return input != null && StringUtils.isNotEmpty(input.getFile()) && input.getFile().contains("test-classes");
            }
        });
    }

    private static List<String> getPathsFromClasspath(Predicate<URL> predicate) {
        return Lists.newArrayList(Iterables.transform(Iterables.filter(getClasspathUrls(), predicate), new Function<URL, String>() {
            public String apply(URL input) {
                return input.getFile();
            }
        }));
    }

    private static String tryFolder(File folder, String folderDesc) {
        try {
            LOGGER.info("尝试用[{}]目录作为[{}]目录", folder.getCanonicalPath(), folderDesc);
            if(folder.exists()) {
                return folder.getCanonicalPath();
            }

            LOGGER.info("目录[{}]不存在,无法设为[{}]目录", folder.getCanonicalPath(), folderDesc);
        } catch (Exception var3) {
            LOGGER.error(MessageFormatter.format("不能使用路径[{}]作为[{}]目录", new Object[]{folder.getAbsolutePath(), folderDesc}).getMessage(), var3);
        }

        return null;
    }

    private static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;

        try {
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable var2) {
            LOGGER.warn(var2.getMessage(), var2);
        }

        if(cl == null) {
            cl = ClassUtils.class.getClassLoader();
        }

        return cl;
    }

    private static List<URL> getClasspathUrls() {
        ClassLoader defaultClassLoader = getDefaultClassLoader();
        if(defaultClassLoader instanceof URLClassLoader) {
            URL[] allClasspathUrls = ((URLClassLoader)defaultClassLoader).getURLs();
            return Lists.newArrayList(Iterables.filter(Lists.newArrayList(allClasspathUrls), new Predicate<URL>() {
                public boolean apply(URL input) {
                    String path = input.getFile();
                    return path != null && path.endsWith("/") && "file".equals(input.getProtocol());
                }
            }));
        } else if(defaultClassLoader.getResource("/") != null) {
            return Lists.newArrayList(new URL[]{defaultClassLoader.getResource("/")});
        } else if(defaultClassLoader.getResource("") != null) {
            return Lists.newArrayList(new URL[]{defaultClassLoader.getResource("")});
        } else {
            throw new RuntimeException("无法找到classpath目录,此方法只适用于web项目,普通java项目请用其他方式制定resources目录");
        }
    }
}
