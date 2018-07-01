package com.epam.task1.util.parser;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLValidator {
    private static final Logger LOGGER = Logger.getLogger(XMLValidator.class);
    public void validate(String XMLPath, String XSDPath){
        try {
            SchemaFactory factory =
                    SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(XSDPath));
            Validator validator = schema.newValidator();
            Source source = new StreamSource(XMLPath);
            validator.validate(source);
            System.out.println("ok");
        } catch (SAXException e) {
            LOGGER.error("Sax exception"+e);
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.error("IO exception"+e);
            e.printStackTrace();
        }
    }

}



