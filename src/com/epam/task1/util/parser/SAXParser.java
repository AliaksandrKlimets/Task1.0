package com.epam.task1.util.parser;

import com.epam.task1.entity.Coffee;
import org.apache.log4j.Logger;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SAXParser {
    public static final Logger LOGGER = Logger.getLogger("com.epam.task1.runner");
    private List<Coffee> coffeeList;
    private Coffee coffee;
    private CoffeeTagName tagName;

    public List<Coffee> parse(String XMLPath)
            throws ParserConfigurationException, IOException, SAXException {
        LOGGER.debug("Start parsing");
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        javax.xml.parsers.SAXParser saxParser = saxParserFactory.newSAXParser();

        DefaultHandler defaultHandler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                if (!qName.equalsIgnoreCase(CoffeeTagName.COFFEEELEMENTS.name())) {
                    tagName = CoffeeTagName.valueOf(qName.toUpperCase());
                }

                if (tagName == CoffeeTagName.COFFEE) {
                    coffee = new Coffee();
                    if (coffeeList == null) coffeeList = new ArrayList<>();
                }
            }

            @Override
            public void endElement(String uri, String localName, String qName) {
                if(qName.equalsIgnoreCase(CoffeeTagName.COFFEE.name())){
                    coffeeList.add(coffee);
                }
            }

            @Override
            public void characters(char ch[], int start, int length) {
                if(tagName!=null){
                    switch (tagName){
                        case PHYSICALSTATE:
                            coffee.setPhysicalState(new String(ch,start,length));
                            break;
                        case KIND:
                            coffee.setKind(new String(ch,start,length));
                            break;
                        case AMOUNT:
                            coffee.setAmount(Double.parseDouble(new String(ch,start,length)));
                            break;
                        case PACKAMOUNT:
                            coffee.setPackAmount(Double.parseDouble(new String(ch,start,length)));
                            break;
                        case COST:
                            coffee.setCost(Double.parseDouble(new String(ch,start,length)));
                            break;
                        case WEIGHT:
                            coffee.setWeight(Double.parseDouble(new String(ch,start,length)));
                            break;
                    }
                    tagName = null;
                }
            }
        };

        saxParser.parse(new File(XMLPath),defaultHandler);
        return coffeeList;
    }
}
