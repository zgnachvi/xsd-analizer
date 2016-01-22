package xsd;

import com.sun.xml.xsom.XSElementDecl;
import com.sun.xml.xsom.XSSchema;
import com.sun.xml.xsom.XSSchemaSet;
import com.sun.xml.xsom.XSType;
import com.sun.xml.xsom.parser.XSOMParser;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by niko on 1/22/16.
 */
public class Main {
    public static void main(String[] args) throws IOException, SAXException {
        XSOMParser parser = new XSOMParser();
//        parser.setErrorHandler(...);
//        parser.setEntityResolver(...);

        parser.parse(new File("BatchResponseSchema.xsd"));

        XSSchemaSet sset = parser.getResult();
        Iterator<XSSchema> schemasIterator = sset.iterateSchema();
        while (schemasIterator.hasNext()) {
            XSSchema schema = schemasIterator.next();
            Iterator<XSElementDecl> schemaAttributeIterator = schema.iterateElementDecls();
            while (schemaAttributeIterator.hasNext()) {

                XSElementDecl attributeDecl = schemaAttributeIterator.next();
                XSType type = attributeDecl.getType();
                attributeDecl.visit(new SimpleXsVisitor());
            }
        }
    }
}