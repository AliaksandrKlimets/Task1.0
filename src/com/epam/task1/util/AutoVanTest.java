package com.epam.task1.util;

import com.epam.task1.entity.Coffee;
import com.epam.task1.entity.Van;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AutoVanTest {
    public void run(Van van){
        List<String> lines;
        File file = new File("src/Example.txt");
        String[] buff;
        try(FileReader reader = new FileReader(file)){
            lines = Files.readAllLines(Paths.get("E:/Example.txt"), StandardCharsets.UTF_8);
            for (String str : lines) {
                buff = str.split(",");
                if((van.getBalanceAmount()-Double.parseDouble(buff[2])-Double.parseDouble(buff[3]))>0 &&
                        (van.getBalanceCost()-Double.parseDouble(buff[4]))>0) {
                    van.getVan().add(new Coffee(buff[0], buff[1], Double.parseDouble(buff[2]),
                            Double.parseDouble(buff[3]), Double.parseDouble(buff[4]),
                            Double.parseDouble(buff[5])));
                    van.setBalanceAmount(van.getBalanceAmount()-Double.parseDouble(buff[2])-Double.parseDouble(buff[3]));
                    van.setBalanceCost(van.getBalanceCost()-Double.parseDouble(buff[4]));
                    System.out.println("added");
                }
                else {
                    System.out.println("Error, Van is full");
                }
            }

        }catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            System.out.println("Error");
        }

        Helper helper = new Helper();
        System.out.println("Entered");
        helper.showVan(van);
        helper.sortVan(van);
        helper.showVan(van);
    }
}
