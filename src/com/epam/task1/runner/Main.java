package com.epam.task1.runner;

import com.epam.task1.entity.Coffee;
import com.epam.task1.entity.Van;
import com.epam.task1.util.AutoVanTest;
import com.epam.task1.util.Helper;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter max amount: ");
        double amount = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter max cost: ");
        double cost = Double.parseDouble(scanner.nextLine());
        Van van = new Van(amount,cost);
        boolean bl = true;
        Helper help = new Helper();
        while(bl){
            switch (help.menu()){
                case 1: help.addCoffee(van); break;
                case 2: help.showVan(van); break;
                case 3: help.sortVan(van); break;
                case 4: help.searchProduct(van); break;
                case 5: help.deleteProduct(van); break;
                case 6: bl=false; break;
                case 7:{
                    new AutoVanTest().run(van);
                    bl=false;
                break;
                }
                default:
                    System.out.println("Incorrect number"); break;
            }
        }

    }
}
