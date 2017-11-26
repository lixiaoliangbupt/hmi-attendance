package com.globot.hmi.attendance;/**
 * Created by lixiaoliang on 2017/11/14.
 */

import com.google.common.base.Preconditions;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.xml.Attribute;
import org.mybatis.generator.api.dom.xml.Element;
import org.mybatis.generator.api.dom.xml.TextElement;
import org.mybatis.generator.api.dom.xml.XmlElement;

import java.util.Iterator;

/**
 * User: lixiaoliang
 * Date: 2017/11/14
 * Time: 下午8:15
 */
public abstract class PageablePlugin extends PluginAdapter {

    public static final String PAGE_CLASS_PROPERTY_NAME = "pageClass";
    protected FullyQualifiedJavaType pageClass;
    protected boolean canPageNullable;
    protected String pageStartName;
    protected String pageSizeName;

    public PageablePlugin() {
    }

    public void initialized(IntrospectedTable introspectedTable) {
        super.initialized(introspectedTable);
        Preconditions.checkState(this.properties.containsKey("canPageNullable"), "canPageNullable(生成的方法的分页参数是否可以为null)为必填");
        Preconditions.checkState(this.properties.containsKey("pageClass"), "SearchSelectivePlugins:pageClass(分页的实体)为必填");
        Preconditions.checkState(this.properties.containsKey("pageStartName"), "SearchSelectivePlugins:pageStartName(分页实体内代表分页初始位置的属性名)为必填");
        Preconditions.checkState(this.properties.containsKey("pageSizeName"), "SearchSelectivePlugins:pageStartName(分页实体内代表每页条数的属性名)为必填");
        String canPageNullable = this.properties.getProperty("canPageNullable").toLowerCase();
        Preconditions.checkState(canPageNullable.equals("true") || canPageNullable.equals("false"), "canPageNullable为boolean类型");
        this.canPageNullable = Boolean.valueOf(canPageNullable).booleanValue();
        String pageClass = this.properties.getProperty("pageClass");
        this.pageClass = new FullyQualifiedJavaType(pageClass);
        this.pageStartName = this.properties.getProperty("pageStartName");
        this.pageSizeName = this.properties.getProperty("pageSizeName");
    }

    protected Parameter createPageParameter() {
        return new Parameter(this.pageClass, "page", "@Param(\"page\")");
    }

    protected void appendLimit(XmlElement newElement) {
        if(this.canPageNullable) {
            XmlElement pageElement = new XmlElement("if");
            pageElement.addAttribute(new Attribute("test", "page != null"));
            pageElement.addElement(new TextElement("limit #{page." + this.pageStartName + "}, #{page." + this.pageSizeName + "}"));
            newElement.addElement(pageElement);
        } else {
            newElement.addElement(new TextElement("limit #{page." + this.pageStartName + "}, #{page." + this.pageSizeName + "}"));
        }

    }

    protected void removeType(XmlElement newElement) {
        Iterator iterator = newElement.getAttributes().iterator();

        while(iterator.hasNext()) {
            Attribute attribute = (Attribute)iterator.next();
            if("parameterType".equals(attribute.getName())) {
                iterator.remove();
                break;
            }
        }

    }

    protected void removeXmlElement(XmlElement element, String elementName, String innerElementContent) {
        Iterator iterator = element.getElements().iterator();

        while(iterator.hasNext()) {
            Element innerElement = (Element)iterator.next();
            if(innerElement instanceof XmlElement) {
                XmlElement xmlElement = (XmlElement)innerElement;
                if(xmlElement.getName().equals(elementName) && xmlElement.getElements().size() == 1) {
                    Element childElement = (Element)xmlElement.getElements().get(0);
                    if(childElement instanceof TextElement) {
                        TextElement textElement = (TextElement)childElement;
                        if(textElement.getContent().equals(innerElementContent)) {
                            iterator.remove();
                        }
                    }
                }
            }
        }

    }
}
