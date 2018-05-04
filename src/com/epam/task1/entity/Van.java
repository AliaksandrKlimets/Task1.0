package com.epam.task1.entity;

import java.util.ArrayList;
import java.util.List;


/**
 * Entity container
 */
public class Van {
    private double maxCost;
    private double balanceCost;
    private double vanAmount;
    private double balanceAmount;
    private List<Coffee> van;

    public Van(double vanAmount, double maxCost){
        this.vanAmount = vanAmount;
        this.maxCost = maxCost;
        balanceAmount=vanAmount;
        balanceCost=maxCost;
        van = new ArrayList<>();
    }

    public double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public double getBalanceCost() {
        return balanceCost;
    }

    public void setBalanceCost(double balanceCost) {
        this.balanceCost = balanceCost;
    }

    public List<Coffee> getVan() {
        return van;
    }

    public double getVanAmount() {
        return vanAmount;
    }

    public double getMaxCost() {
        return maxCost;
    }
}
