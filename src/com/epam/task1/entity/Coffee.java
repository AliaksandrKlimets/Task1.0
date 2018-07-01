package com.epam.task1.entity;


/**
 * Entity
 */

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

    public void setPhysicalState(String physicalState) {
        this.physicalState = physicalState;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPackAmount(double packAmount) {
        this.packAmount = packAmount;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Coffee coffee){
        double res = ((this.cost/this.weight) - (coffee.cost/coffee.weight));
        if(res<1.0 && res>0) res = 1.0;
        if(res>-1 && res<0) res = -1.0;
        return (int)res;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (null == obj) return false;
        if (getClass() != obj.getClass()) return  false;

        Coffee coffee = (Coffee)obj;
        if (amount != coffee.getAmount()) return  false;
        if (packAmount != coffee.getPackAmount()) return false;
        if (cost != coffee.getCost()) return  false;
        if (weight != coffee.getWeight()) return  false;
        if (!physicalState.equals(coffee.getPhysicalState())) return false;
        if (!kind.equals(coffee.getKind())) return false;
        return true;
    }

    @Override
    public int hashCode(){
        return 31*(int)amount+32*(int)packAmount+33*(int)cost+34*(int)weight+physicalState.hashCode()+kind.hashCode();
    }
}