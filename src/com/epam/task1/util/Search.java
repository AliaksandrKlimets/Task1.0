package com.epam.task1.util;

import com.epam.task1.entity.Coffee;

import java.util.List;
import java.util.Scanner;

public class Search {
    private Scanner scanner = new Scanner(System.in);
    public  void searchCost(List<Coffee> van){
        System.out.println("Enter min value");
            double min= Double.parseDouble(scanner.nextLine());
        System.out.println("Enter max value");
            double max = Double.parseDouble(scanner.nextLine());
        for (Coffee coffee :van) {
            if (coffee.getCost()>=min && coffee.getCost()<=max)
                System.out.println(coffee.toString());
        }
    }
    public  void searchWeight(List<Coffee> van){
        System.out.println("Enter min value");
            double min= Double.parseDouble(scanner.nextLine());
        System.out.println("Enter max value");
            double max = Double.parseDouble(scanner.nextLine());
        for (Coffee coffee :van) {
            if (coffee.getWeight()>=min && coffee.getWeight()<=max)
                System.out.println(coffee.toString());
        }
    }
    public  void searchAmount(List<Coffee> van){
        System.out.println("Enter min value");
            double min= Double.parseDouble(scanner.nextLine());
        System.out.println("Enter max value");
            double max = Double.parseDouble(scanner.nextLine());
        for (Coffee coffee :van) {
            if ((coffee.getAmount()+coffee.getPackAmount())>=min && (coffee.getAmount()+coffee.getPackAmount())<=max)
                System.out.println(coffee.toString());
        }
    }
    public  void searchPhysicalState(List<Coffee> van){
        Helper helper = new Helper();
        System.out.print("Enter state - 1) Corn  2) Ground  3) Soluble in cans  4) Soluble in packets: ");
            String buff = helper.setPhysicalState(Integer.parseInt(scanner.nextLine()));
        for (Coffee coffee :van) {
            if (coffee.getPhysicalState().equals(buff))
                System.out.println(coffee.toString());
        }
    }
    public  void searchKind(List<Coffee> van){
        Helper helper = new Helper();
        System.out.print("Enter kind - 1) Arabic  2) Liberic  3)Robust :");
        String buff = helper.setKind(Integer.parseInt(scanner.nextLine()));
        for (Coffee coffee :van) {
            if (coffee.getKind().equals(buff))
                System.out.println(coffee.toString());
        }
    }
}
