package com.epam.task1.entity;


public class Coffee implements Comparable<Coffee>{
    private String physicalState;
    private String kind;
    private double amount;
    private double packAmount;
    private double cost;
    private double weight;

    public Coffee(){
        this.physicalState="Arabic";
        this.kind="In packet";
        this.amount=1;
        this.packAmount=1;
        this.cost=1;
        this.weight=1;
    }

    public Coffee(String physicalState, String kind, double amount, double packAmount, double cost, double weight){
        this.physicalState=physicalState;
        this.kind=kind;
        this.amount=amount;
        this.packAmount=packAmount;
        this.cost=cost;
        this.weight=weight;
    }

    public double getAmount() {
        return amount;
    }

    public double getPackAmount() {
        return packAmount;
    }

    public double getCost() {
        return cost;
    }

    public double getWeight() {
        return weight;
    }

    public String getKind() {
        return kind;
    }

    public String getPhysicalState() {
        return physicalState;
    }

    @Override
    public String toString(){
        return "State " + physicalState
                + "; Kind " + kind
                + "; Sum amount " + (amount+packAmount)
                + "; Cost " + cost
                + "; Weight" + weight
                + "; Cost/weight" + (cost/weight);
    }

    @Override
    public int compareTo(Coffee coffee){
        double res = ((this.cost/this.weight) - (coffee.cost/coffee.weight));
        if(res<1.0 && res>0) res = 1.0;
        if(res>-1 && res<0) res = -1.0;
        return (int)res;
    }
}