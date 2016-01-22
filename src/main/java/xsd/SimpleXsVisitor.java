package xsd;

import com.sun.xml.xsom.*;
import com.sun.xml.xsom.visitor.XSVisitor;


/**
 * Created by niko on 1/22/16.
 */
public class SimpleXsVisitor implements XSVisitor {
    @Override
    public void annotation(XSAnnotation xsAnnotation) {

    }

    @Override
    public void attGroupDecl(XSAttGroupDecl xsAttGroupDecl) {

    }

    @Override
    public void attributeDecl(XSAttributeDecl xsAttributeDecl) {

    }

    @Override
    public void attributeUse(XSAttributeUse xsAttributeUse) {

    }

    @Override
    public void complexType(XSComplexType xsComplexType) {

        System.out.println("(");
        xsComplexType.getContentType().visit(this);
        System.out.println(")");
        System.out.println(";]");
    }

    @Override
    public void schema(XSSchema xsSchema) {

    }

    @Override
    public void facet(XSFacet xsFacet) {

    }

    @Override
    public void notation(XSNotation xsNotation) {

    }

    @Override
    public void identityConstraint(XSIdentityConstraint xsIdentityConstraint) {

    }

    @Override
    public void xpath(XSXPath xsxPath) {

    }

    @Override
    public void simpleType(XSSimpleType xsSimpleType) {
        System.out.println(xsSimpleType.getPrimitiveType().getName() + ",");
    }

    @Override
    public void particle(XSParticle xsParticle) {
        xsParticle.getTerm().visit(this);
    }

    @Override
    public void empty(XSContentType xsContentType) {

    }

    @Override
    public void wildcard(XSWildcard xsWildcard) {
        throw new RuntimeException("Not Supported");
    }

    @Override
    public void modelGroupDecl(XSModelGroupDecl xsModelGroupDecl) {
        throw new RuntimeException("Not Supported");
    }

    @Override
    public void modelGroup(XSModelGroup xsModelGroup) {
        xsModelGroup.forEach((t)->t.visit(this));
    }

    @Override
    public void elementDecl(XSElementDecl xsElementDecl) {
        if (xsElementDecl.getType().isComplexType()) {
            System.out.println("[CREATE TABLE ");
        }
        System.out.print(xsElementDecl.getName() + " ");
        xsElementDecl.getType().visit(this);
    }
}
