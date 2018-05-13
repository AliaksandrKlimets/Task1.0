package com.epam.task1.util;

import com.epam.task1.entity.Coffee;
import com.epam.task1.entity.Van;
import org.apache.log4j.Logger;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * This class is used to work with van
 *
 */

public class Helper {
   public static final Logger logger = Logger.getLogger("com.epam.task1.util");
   private Scanner scanner = new Scanner(System.in);

   /** This method is used to choose the method to work with
    * @return the method number
    */

   public int menu() {
        logger.info("1) Enter product");
      logger.info("2) Show van");
      logger.info("3) Sort van");
      logger.info("4) Search from parameters");
      logger.info("5) Delete product");
      logger.info("6) Exit");
      logger.info("7) Auto test");
        logger.debug("Show menu");
        return Integer.parseInt(scanner.nextLine());
     }

   /**
    * Add entity to van
    * @param van
    */

   public void addCoffee(Van van){
      System.out.print("Enter state - 1) Corn  2) Ground  3) Soluble in cans  4) Soluble in packets: ");
         String physicalState = setPhysicalState(Integer.parseInt(scanner.nextLine()));
      System.out.print("Enter kind - 1) Arabic  2) Liberic  3)Robust :");
         String kind = setKind(Integer.parseInt(scanner.nextLine()));
      System.out.print("Enter amount: ");
         double amount = Double.parseDouble(scanner.nextLine());
      System.out.print("Enter pack amount: ");
         double packAmount = Double.parseDouble(scanner.nextLine());
      System.out.print("Enter cost: ");
         double cost = Double.parseDouble(scanner.nextLine());
      System.out.print("Enter weight: ");
         double weight = Double.parseDouble(scanner.nextLine());
      System.out.print("Enter count: ");
         int count = Integer.parseInt(scanner.nextLine());
            for(int i=0; i<count; i++) {
               if((van.getBalanceCost()-cost)>=0 && (van.getBalanceAmount()-amount-packAmount)>=0) {
                  van.getVan().add(new Coffee(physicalState, kind, amount, packAmount, cost, weight));
                  van.setBalanceCost(van.getBalanceCost()-cost);
                  van.setBalanceAmount(van.getBalanceAmount()-amount-packAmount);
                  logger.info("Prod added");
               }
               else {
                  logger.info("Didn't add. See your params");
                  break;
               }
            }
   }

   /**
    * This method show the contents of van
    * @param van
    */
   public void showVan(Van van){
      logger.debug("Start show van");
      logger.info("Start amount: "+van.getVanAmount());
      logger.info("Your amount: "+van.getBalanceAmount());
      logger.info("Max cost: "+van.getMaxCost());
      logger.info("Your cost: "+van.getBalanceCost());
      for (Coffee coffee : van.getVan()) {
         System.out.println(coffee.toString());
      }
      logger.debug("End show van");
   }

   /**
    * This method is used to sort van
    * @param van_elem
    */
   public void sortVan(Van van_elem){
      logger.debug("Start sort");
      Collections.sort(van_elem.getVan());
      logger.debug("End sort");
   }

   /**
    * This method is used to search van entity by any parameters
    * @param van_elem
    */
   public void searchProduct(Van van_elem){
      List<Coffee> van = van_elem.getVan();
      Search search = new Search();
      logger.info("Search by: 1)Cost 2)Weight 3)Amount 4)State 5)Kind ");
      switch (Integer.parseInt(scanner.nextLine())){
         case 1:logger.debug("User have chosen search by cost");
            search.searchCost(van);
            break;
         case 2:logger.debug("User have chosen search by weight");
            search.searchWeight(van);
            break;
         case 3:logger.debug("User have chosen search by amount");
            search.searchAmount(van);
            break;
         case 4:logger.debug("User have chosen search by state");
            search.searchPhysicalState(van);
            break;
         case 5:logger.debug("User have chosen search by kind");
            search.searchKind(van);
            break;
         default:
            logger.info("Error");
      }
   }

   /**
    * This method is used to delete entity from van
    * @param van_elem
    */
   public void deleteProduct(Van van_elem){
      int i =0;
      List<Coffee> van = van_elem.getVan();
      for (Coffee coffee :van_elem.getVan()) {
         logger.info((i+1)+") ");
         logger.info(coffee.toString());
         i++;

      }
      logger.info("Which one you wanna delete?");
      String buff = scanner.nextLine();
      if(buff.equals("all")) {
         for (int j = 0; j < van.size(); ) {
            van_elem.setBalanceCost(van.get(j).getCost() + van_elem.getBalanceCost());
            van_elem.setBalanceAmount(van.get(j).getAmount()+van.get(j).getPackAmount() + van_elem.getBalanceAmount());
            van.remove(van.get(j));
         }
      }else {
         int index = Integer.parseInt(buff);
         if (index <= van.size()) {
            van_elem.setBalanceCost(van.get(index - 1).getCost() + van_elem.getBalanceCost());
            van_elem.setBalanceAmount(van.get(index - 1).getAmount() + van_elem.getBalanceAmount());
            van.remove(van.get(index - 1));
         } else logger.info("Not right index");
      }

   }

   /**
    * This method is used to choose the coffee kind
    * @param i
    * @return the kind
    */
   public  String setKind(int i){
      switch (i){
         case 1: return "Arabic";
         case 2: return "Liberic";
         case 3: return "Robust";
         default: return "Arabic";
      }
   }

   /**
    * This method is used to choose the coffee state
    * @param i
    * @return the state
    */
   public  String setPhysicalState(int i){
      switch (i){
         case 1: return "Corn";
         case 2: return "Ground";
         case 3: return "Soluble in cans";
         case 4: return "Soluble in packets";
         default: return "Corn";
      }
   }


}
