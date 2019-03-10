package com.patrycjamecina.model;
public class Animal {
    private String ID;
    private String name;
    private String species;
    private double weight;
    private boolean isSociable;
    private String idOfZookeeper;
    private double kgOfFoodPerDay;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isSociable() {
        return isSociable;
    }

    public void setSociable(boolean sociable) {
        isSociable = sociable;
    }

    public String getIdOfZookeeper() {
        return idOfZookeeper;
    }

    public void setIdOfZookeeper(String idOfZookeeper) {
        this.idOfZookeeper = idOfZookeeper;
    }

    public double getKgOfFoodPerDay() {
        return kgOfFoodPerDay;
    }

    public void setKgOfFoodPerDay(double kgOfFoodPerDay) {
        this.kgOfFoodPerDay = kgOfFoodPerDay;
    }
}
