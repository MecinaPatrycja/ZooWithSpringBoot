package com.patrycjamecina.model;
import java.util.ArrayList;
import java.util.List;
public class Croft {
    private String name;
    private List<Animal> animals = new ArrayList<>();
    private int size;

    public Croft(String name) {
        this.name = name;
    }

    public Croft() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public int getSize() {
        return size = animals.size();
    }

    public void setSize(int size) {
        this.size = size;
    }

    //stworz metodę dodającą zwierzę do zagrody
    public void addAnimalToCroft(Animal animal) {
        if (animal.isSociable()) {
            animals.add(animal);
        }
    }
}