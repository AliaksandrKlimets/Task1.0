package com.epam.task1.runner;

import com.epam.task1.entity.Coffee;
import com.epam.task1.entity.Van;
import com.epam.task1.util.AutoVanTest;
import com.epam.task1.util.Helper;
import com.epam.task1.util.parser.SAXParser;
import com.epam.task1.util.parser.XMLValidator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @author Aliaksanr Klimets
 * @version 1.04
 * This class is used to work with methods which is used to work with our van
 * Although, you can test our application by using {@see AutoVanTest#run}
 */

public class Runner {
    public static final Logger LOGGER = Logger.getLogger("com.epam.task1.runner");

    public static void main(String[] args) {
        LOGGER.setResourceBundle(ResourceBundle.getBundle("log4j"));
        Scanner scanner = new Scanner(System.in);
        LOGGER.info("Enter max amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        LOGGER.debug("User enter max amount");
        LOGGER.info("Enter max cost: ");
        double cost = Double.parseDouble(scanner.nextLine());
        LOGGER.debug("User enter max cost");
        Van van = new Van(amount, cost);
        boolean bl = true;
        Helper help = new Helper();
        while (bl) {
            switch (help.menu()) {
                case 1: {
                    LOGGER.debug("User has chosen addCoffee() ");
                    help.addCoffee(van);
                    break;
                }
                case 2: {
                    LOGGER.debug("User has chosen showVan()");
                    help.showVan(van);
                    break;
                }
                case 3: {
                    LOGGER.debug("User has chosen sortVan() ");
                    help.sortVan(van);
                    break;
                }
                case 4: {
                    LOGGER.debug("User has chosen searchVan()");
                    help.searchProduct(van);
                    break;
                }
                case 5: {
                    LOGGER.debug("User has chosen deleteProduct() ");
                    help.deleteProduct(van);
                    break;
                }
                case 6: {
                    LOGGER.debug("User has chosen exit() ");
                    bl = false;
                    break;
                }
                case 7: {
                    LOGGER.debug("User has chosen autoVaTest() ");
                    new AutoVanTest().run(van);
                    bl = false;
                    break;
                }
                case 8: {
                    LOGGER.debug("User has chosen XML add");
                    SAXParser saxParser = new SAXParser();
                    List<Coffee> list;
                    try {
                        list = saxParser.parse("src/cofee.xml");
                        new XMLValidator().validate("src/cofee.xml","src/coffe.xsd");
                        van.setVan(list);
                    } catch (ParserConfigurationException e) {
                        LOGGER.error("Config exception" + e);
                    } catch (SAXException e) {
                        LOGGER.error("SAX exception " + e);
                    } catch (IOException e) {
                        LOGGER.error("IO exception" + e);
                    }
                    break;
                }
                default:
                    LOGGER.error("Incorrect number");
            }
        }

    }
}
