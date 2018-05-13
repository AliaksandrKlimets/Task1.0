package com.epam.task1.util;

import com.epam.task1.entity.Coffee;
import com.epam.task1.entity.Van;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AutoVanTest {

    /**
     * This method is used to test the work of our application
     * @param van
     */
    public static final Logger logger = Logger.getLogger("com.epam.task1.util");
    public void run(Van van){

        List<String> lines;
        File file = new File("src/example.txt");
        String[] buff;
        van.getVan().clear();
        try(FileReader reader = new FileReader(file)){
            lines = Files.readAllLines(Paths.get("src/example.txt"), StandardCharsets.UTF_8);
            logger.debug("Read lines from file");
            for (String str : lines) {
                buff = str.split(",");
                if((van.getBalanceAmount()-Double.parseDouble(buff[2])-Double.parseDouble(buff[3]))>0 &&
                        (van.getBalanceCost()-Double.parseDouble(buff[4]))>0) {
                    van.getVan().add(new Coffee(buff[0], buff[1], Double.parseDouble(buff[2]),
                            Double.parseDouble(buff[3]), Double.parseDouble(buff[4]),
                            Double.parseDouble(buff[5])));
                    van.setBalanceAmount(van.getBalanceAmount()-Double.parseDouble(buff[2])-Double.parseDouble(buff[3]));
                    van.setBalanceCost(van.getBalanceCost()-Double.parseDouble(buff[4]));
                    logger.info("Product has been added");
                }
                else {
                    logger.info("Error, Van is full");
                }
            }

        }catch (FileNotFoundException e){
            logger.error("File not found "+ e);
        } catch (IOException e){
            logger.error("Error "+e);
        }
        logger.debug("Create object");
        Helper helper = new Helper();
        logger.debug("Show");
        helper.showVan(van);
        logger.debug("Sort");
        helper.sortVan(van);
        logger.debug("Show");
        helper.showVan(van);

        for (Coffee coffee :van.getVan()) {
            for (Coffee coffee1 :van.getVan()) {
                System.out.println(coffee.equals(coffee1));
            }
        }

    }
}
