package com.epam.task1.runner;

import com.epam.task1.entity.Van;
import com.epam.task1.util.AutoVanTest;
import com.epam.task1.util.Helper;
import org.apache.log4j.Logger;

import java.util.ResourceBundle;
import java.util.Scanner;

/**
 * @version 1.04
 * This class is used to work with methods which is used to work with our van
 * Although, you can test our application by using {@see AutoVanTest#run}
 * @author Aliaksanr Klimets
 */

public class Runner {
    public static final Logger logger = Logger.getLogger("com.epam.task1.runner");

    public static void main(String[] args) {
        logger.setResourceBundle(ResourceBundle.getBundle("log4j"));
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter max amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        logger.info("User enter max amount");
        System.out.print("Enter max cost: ");
        double cost = Double.parseDouble(scanner.nextLine());
        logger.info("User enter max cost");
        Van van = new Van(amount,cost);
        boolean bl = true;
        Helper help = new Helper();
        while(bl){
            switch (help.menu()){
                case 1: {
                    logger.info("User have chosen addCoffee() ");
                    help.addCoffee(van);
                    break;}
                case 2: {
                    logger.info("User have chosen showVan()");
                    help.showVan(van);
                    break;}
                case 3: {
                    logger.info("User have chosen sortVan() ");
                    help.sortVan(van);
                    break;}
                case 4: {
                    logger.info("User have chosen searchVan()");
                    help.searchProduct(van);
                    break;}
                case 5: {
                    logger.info("User have chosen deleteProduct() ");
                    help.deleteProduct(van);
                    break;}
                case 6: {
                    logger.info("User have chosen exit() ");
                    bl=false;
                    break;}
                case 7:{logger.info("User have chosen autoVaTest() ");
                    new AutoVanTest().run(van);
                    bl=false;
                break;
                }
                default:
                   logger.error("Incorrect number");
            }
        }

    }
}
