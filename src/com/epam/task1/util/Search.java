package com.epam.task1.util;

import com.epam.task1.entity.Coffee;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Scanner;


/**
 * This class contains of methods to search entities by any parameters
 *
 */
public class Search {
    public static final Logger logger = Logger.getLogger("com.epam.task1.util");
    private Scanner scanner = new Scanner(System.in);
    public  void searchCost(List<Coffee> van){
        logger.debug("Start search by cost");
        logger.info("Enter min value");
            double min= Double.parseDouble(scanner.nextLine());
        logger.info("Enter max value");
            double max = Double.parseDouble(scanner.nextLine());
        for (Coffee coffee :van) {
            if (coffee.getCost()>=min && coffee.getCost()<=max)
                System.out.println(coffee.toString());
        }
        logger.debug("End search by cost");
    }
    public  void searchWeight(List<Coffee> van){
        logger.debug("Start search by weight");
        logger.info("Enter min value");
            double min= Double.parseDouble(scanner.nextLine());
        logger.info("Enter max value");
            double max = Double.parseDouble(scanner.nextLine());
        for (Coffee coffee :van) {
            if (coffee.getWeight()>=min && coffee.getWeight()<=max)
                System.out.println(coffee.toString());
        }
        logger.debug("End search by weight");
    }
    public  void searchAmount(List<Coffee> van){
        logger.debug("Start search by amount");
        System.out.println("Enter min value");
            double min= Double.parseDouble(scanner.nextLine());
        logger.info("Enter max value");
            double max = Double.parseDouble(scanner.nextLine());
        for (Coffee coffee :van) {
            if ((coffee.getAmount()+coffee.getPackAmount())>=min && (coffee.getAmount()+coffee.getPackAmount())<=max)
                System.out.println(coffee.toString());
        }
        logger.debug("End search by amount");
    }
    public  void searchPhysicalState(List<Coffee> van){
        logger.debug("Start search by state");
        Helper helper = new Helper();
        logger.info("Enter state - 1) Corn  2) Ground  3) Soluble in cans  4) Soluble in packets: ");
            String buff = helper.setPhysicalState(Integer.parseInt(scanner.nextLine()));
        for (Coffee coffee :van) {
            if (coffee.getPhysicalState().equals(buff))
                System.out.println(coffee.toString());
        }
        logger.debug("End search by state");
    }
    public  void searchKind(List<Coffee> van){
        logger.debug("Start search by kind");
        Helper helper = new Helper();
        logger.info("Enter kind - 1) Arabic  2) Liberic  3)Robust :");
        String buff = helper.setKind(Integer.parseInt(scanner.nextLine()));
        for (Coffee coffee :van) {
            if (coffee.getKind().equals(buff))
                System.out.println(coffee.toString());
        }
        logger.debug("End search by kind");
    }

}
