package com.globot.hmi.attendance;/**
 * Created by lixiaoliang on 2017/11/14.
 */

import org.mybatis.generator.api.FullyQualifiedTable;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.Parameter;
import org.mybatis.generator.api.dom.xml.*;

import java.util.*;

/**
 * User: lixiaoliang
 * Date: 2017/11/14
 * Time: 下午8:14
 */
public class PageableFindPlugin extends PageablePlugin{
    private boolean hadAddXml = false;
    private Map<FullyQualifiedTable, List<XmlElement>> elementsToAdd = new HashMap();

    public PageableFindPlugin() {
    }

    public boolean validate(List<String> warnings) {
        return true;
    }

    public boolean clientSelectByExampleWithBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        if(introspectedTable.getTargetRuntime() == IntrospectedTable.TargetRuntime.MYBATIS3) {
            this.addParamNameToSelectByExample(method, interfaze);
            this.copyAndAddMethod(method, interfaze);
        }

        return true;
    }

    public boolean clientSelectByExampleWithoutBLOBsMethodGenerated(Method method, Interface interfaze, IntrospectedTable introspectedTable) {
        if(introspectedTable.getTargetRuntime() == IntrospectedTable.TargetRuntime.MYBATIS3) {
            this.addParamNameToSelectByExample(method, interfaze);
            this.copyAndAddMethod(method, interfaze);
        }

        return true;
    }

    public boolean sqlMapSelectByExampleWithoutBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        if(introspectedTable.getTargetRuntime() == IntrospectedTable.TargetRuntime.MYBATIS3) {
            this.copyAndSaveElement(element, introspectedTable.getFullyQualifiedTable());
            this.addParamNameToSelectByExampleElement(element, introspectedTable.getFullyQualifiedTable());
        }

        return true;
    }

    public boolean sqlMapSelectByExampleWithBLOBsElementGenerated(XmlElement element, IntrospectedTable introspectedTable) {
        if(introspectedTable.getTargetRuntime() == IntrospectedTable.TargetRuntime.MYBATIS3) {
            this.copyAndSaveElement(element, introspectedTable.getFullyQualifiedTable());
            this.addParamNameToSelectByExampleElement(element, introspectedTable.getFullyQualifiedTable());
        }

        return true;
    }

    public boolean sqlMapDocumentGenerated(Document document, IntrospectedTable introspectedTable) {
        document.getRootElement().getElements().add(2, this.addWhereClause(document));
        List elements = (List)this.elementsToAdd.get(introspectedTable.getFullyQualifiedTable());
        if(elements != null) {
            Iterator var4 = elements.iterator();

            while(var4.hasNext()) {
                XmlElement element = (XmlElement)var4.next();
                document.getRootElement().addElement(element);
            }
        }

        return true;
    }

    private XmlElement addWhereClause(Document document) {
        Iterator var2 = document.getRootElement().getElements().iterator();

        while(var2.hasNext()) {
            Element rootElement = (Element)var2.next();
            if(rootElement instanceof XmlElement) {
                XmlElement root = (XmlElement)rootElement;
                if(root.getName().equals("sql") && root.getAttributes().size() == 1 && ((Attribute)root.getAttributes().get(0)).getValue().equals("Example_Where_Clause")) {
                    XmlElement newElement = new XmlElement("sql");
                    newElement.addAttribute(new Attribute("id", "Example_Where_Clause_With_Alias"));
                    XmlElement where = new XmlElement("where");
                    XmlElement whereContent = new XmlElement((XmlElement)((XmlElement)root.getElements().get(root.getElements().size() - 1)).getElements().get(0));
                    Iterator iterator = whereContent.getAttributes().iterator();

                    while(iterator.hasNext()) {
                        Attribute attribute = (Attribute)iterator.next();
                        if(attribute.getName().equals("collection")) {
                            iterator.remove();
                        }
                    }

                    whereContent.addAttribute(new Attribute("collection", "example.oredCriteria"));
                    where.addElement(whereContent);
                    newElement.addElement(where);
                    return newElement;
                }
            }
        }

        throw new IllegalStateException("mapper xml里不包含Example_Where_Clause节点");
    }

    private void addParamNameToSelectByExample(Method method, Interface interfaze) {
        if("selectByExample".equals(method.getName()) && method.getParameters().size() == 1) {
            Parameter oriParameter = (Parameter)method.getParameters().get(0);
            oriParameter.addAnnotation("@Param(\"example\")");
        }

    }

    private void copyAndAddMethod(Method method, Interface interfaze) {
        Method newMethod = new Method(method);
        newMethod.setName(method.getName() + "WithPage");
        Parameter oriParameter = (Parameter)method.getParameters().get(0);
        newMethod.getParameters().clear();
        newMethod.addParameter(new Parameter(oriParameter.getType(), oriParameter.getName(), "@Param(\"example\")"));
        newMethod.addParameter(this.createPageParameter());
        interfaze.addMethod(newMethod);
        interfaze.addImportedType(this.pageClass);
    }

    private void addParamNameToSelectByExampleElement(XmlElement element, FullyQualifiedTable fqt) {
        XmlElement selectByExampleElement = new XmlElement(element);
        if("select".equals(selectByExampleElement.getName())) {
            Iterator var4 = selectByExampleElement.getAttributes().iterator();

            while(true) {
                Attribute attribute;
                do {
                    do {
                        if(!var4.hasNext()) {
                            return;
                        }

                        attribute = (Attribute)var4.next();
                    } while(!"id".equals(attribute.getName()));
                } while(!"selectByExample".equals(attribute.getValue()));

                Iterator var6 = selectByExampleElement.getElements().iterator();

                while(var6.hasNext()) {
                    Element innerElement = (Element)var6.next();
                    if(innerElement instanceof XmlElement) {
                        XmlElement ifOrderByClauseElement = (XmlElement)innerElement;
                        if("if".equals(ifOrderByClauseElement.getName()) && ifOrderByClauseElement.getAttributes().size() == 1) {
                            Attribute conditionAttribute = (Attribute)ifOrderByClauseElement.getAttributes().get(0);
                            if("test".equals(conditionAttribute.getName()) && "orderByClause != null".equals(conditionAttribute.getValue())) {
                                ifOrderByClauseElement.getAttributes().set(0, new Attribute("test", "example.orderByClause != null"));
                                ifOrderByClauseElement.getElements().set(0, new TextElement("order by ${example.orderByClause}"));
                            }
                        }
                    }
                }
            }
        }
    }

    private void copyAndSaveElement(XmlElement element, FullyQualifiedTable fqt) {
        XmlElement newElement = new XmlElement(element);
        Iterator elements = newElement.getAttributes().iterator();

        while(elements.hasNext()) {
            Attribute attribute = (Attribute)elements.next();
            if("id".equals(attribute.getName())) {
                elements.remove();
                Attribute newAttribute = new Attribute("id", attribute.getValue() + "WithPage");
                newElement.addAttribute(newAttribute);
                break;
            }
        }

        this.removeType(newElement);
        this.removeOrderElement(newElement);
        this.replaceDistinct(element);
        this.replaceWhere(newElement);
        this.appendOrder(newElement);
        this.appendLimit(newElement);
        List elements1 = (List)this.elementsToAdd.get(fqt);
        if(elements1 == null) {
            elements1 = new ArrayList();
            this.elementsToAdd.put(fqt, elements1);
        }

        ((List)elements1).add(newElement);
    }

    private void replaceWhere(XmlElement element) {
        Iterator var2 = element.getElements().iterator();

        while(var2.hasNext()) {
            Element innerElement = (Element)var2.next();
            if(innerElement instanceof XmlElement) {
                XmlElement xmlElement = (XmlElement)innerElement;
                if(xmlElement.getName().equals("if") && xmlElement.getAttributes().size() == 1 && ((Attribute)xmlElement.getAttributes().get(0)).getValue().equals("_parameter != null")) {
                    xmlElement.getAttributes().clear();
                    xmlElement.addAttribute(new Attribute("test", "example != null"));
                    xmlElement.getElements().clear();
                    XmlElement includeElement = new XmlElement("include");
                    includeElement.addAttribute(new Attribute("refid", "Example_Where_Clause_With_Alias"));
                    xmlElement.addElement(includeElement);
                }
            }
        }

    }

    private void replaceDistinct(XmlElement element) {
        Iterator var2 = element.getElements().iterator();

        while(var2.hasNext()) {
            Element innerElement = (Element)var2.next();
            if(innerElement instanceof XmlElement) {
                XmlElement xmlElement = (XmlElement)innerElement;
                if(xmlElement.getName().equals("if") && xmlElement.getElements().size() == 1) {
                    Element childElement = (Element)xmlElement.getElements().get(0);
                    if(childElement instanceof TextElement) {
                        TextElement textElement = (TextElement)childElement;
                        if(textElement.getContent().equals("distinct")) {
                            xmlElement.getAttributes().clear();
                            xmlElement.getAttributes().add(new Attribute("test", "example.distinct"));
                            break;
                        }
                    }
                }
            }
        }

    }

    private void appendOrder(XmlElement newElement) {
        XmlElement pageElement = new XmlElement("if");
        pageElement.addAttribute(new Attribute("test", "example.orderByClause != null"));
        pageElement.addElement(new TextElement("order by ${example.orderByClause}"));
        newElement.addElement(pageElement);
    }

    private void removeOrderElement(XmlElement newElement) {
        this.removeXmlElement(newElement, "if", "order by ${orderByClause}");
    }
}
