package com.patrycjamecina.service;
import com.patrycjamecina.model.Animal;
import com.patrycjamecina.model.Croft;
import com.patrycjamecina.model.Zookeeper;
import com.patrycjamecina.utils.AnimalReader;
import com.patrycjamecina.utils.ZookeeperReader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class AnimalsServiceImpl implements AnimalsService {
    @Override
    public double howManyFoodNeedAverageAnimalPerDay() {
        double sumOfFood = 0;
        double averageFood;
        AnimalReader animalReader = new AnimalReader();
        Map<String, Animal> animalMap = new HashMap<>();
        try {
            animalMap = animalReader.fillStructureAnimals();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Animal value : animalMap.values()) {
            sumOfFood += value.getKgOfFoodPerDay();
        }
        averageFood = sumOfFood / animalMap.size();
        return averageFood;
    }

    @Override
    public String manOrWomanHaveMoreAnimals() {
        String manOrWomen;
        int femaleCounter = 0;
        int maleCounter = 0;
        AnimalReader animalReader = new AnimalReader();
        Map<String, Animal> animalMap = new HashMap<>();
        Map<String, Zookeeper> zookeeperMap = new HashMap<>();
        ZookeeperReader zookeeperReader = new ZookeeperReader();
        try {
            animalMap = animalReader.fillStructureAnimals();
            zookeeperMap = zookeeperReader.fillStructureZookeeper();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Animal animal : animalMap.values()) {
            Zookeeper zookeeper = zookeeperMap.get(animal.getIdOfZookeeper());
            if (zookeeper.getGender().equals("Female")) {
                femaleCounter++;
            } else {
                maleCounter++;
            }
        }
        if (femaleCounter > maleCounter) {
            manOrWomen = "female";
        } else {
            manOrWomen = "male";
        }
        return manOrWomen;
    }

    @Override
    public List<String> listOfCats() {
        List<String> namesOfCats = new ArrayList<>();
        AnimalReader animalReader = new AnimalReader();
        Map<String, Animal> animalMap = new HashMap<>();
        try {
            animalMap = animalReader.fillStructureAnimals();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : animalMap.keySet()) {
            String cats = animalMap.get(s).getSpecies();
            if (cats.contains("Cat") || cats.contains("cat")) {
                namesOfCats.add(animalMap.get(s).getName());
            }
        }
        return namesOfCats;
    }

    @Override
    public double howManyFoodEatsTheHeaviestAnimal() {
        double result;
        double maxWeight = 0;
        double food = 0;
        double weight = 0;
        AnimalReader animalReader = new AnimalReader();
        Map<String, Animal> animalMap = new HashMap<>();
        try {
            animalMap = animalReader.fillStructureAnimals();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Animal value : animalMap.values()) {
            if (value.getWeight() > maxWeight) {
                maxWeight = value.getWeight();
                food = value.getKgOfFoodPerDay();
                weight = value.getWeight();
            }
        }
        result = food / weight;
        return result;
    }

    @Override
    public Croft createCroftWithHorses() {
        Croft croft = new Croft();
        AnimalReader animalReader = new AnimalReader();
        Map<String, Animal> animalMap = new HashMap<>();
        try {
            animalMap = animalReader.fillStructureAnimals();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Animal value : animalMap.values()) {
            String horse = value.getSpecies();
            if (horse.equals("Horse") || horse.equals("horse")) {
                croft.addAnimalToCroft(value);
                croft.setName(value.getSpecies() + " Croft");
            }
        }
        return croft;
    }

    @Override
    public Map<Integer, Integer> histogramOfNumbersOfAnimalsPerZookeeper() {
        Map<Integer, Integer> histogram = new HashMap<>();
        Map<String, List<Animal>> animalsByZookeeperId = new HashMap<>();
        AnimalReader animalReader = new AnimalReader();
        Map<String, Animal> animalMap = new HashMap<>();
        try {
            animalMap = animalReader.fillStructureAnimals();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Animal animal : animalMap.values()) {
            if (animalsByZookeeperId.containsKey(animal.getIdOfZookeeper())) {
                animalsByZookeeperId.get(animal.getIdOfZookeeper()).add(animal);
            } else {
                List<Animal> animals = new ArrayList<>();
                animals.add(animal);
                animalsByZookeeperId.put(animal.getIdOfZookeeper(), animals);
            }
        }
        for (String idOfZookeeper : animalsByZookeeperId.keySet()) {
            int countOfAnimalsPerZookeeper = animalsByZookeeperId.get(idOfZookeeper).size();
            if (!histogram.containsKey(countOfAnimalsPerZookeeper)) {
                histogram.put(countOfAnimalsPerZookeeper, 1);
            } else {
                Integer newValue = histogram.get(countOfAnimalsPerZookeeper) + 1;
                histogram.put(countOfAnimalsPerZookeeper, newValue);
            }
        }
        return histogram;
    }

    @Override
    public String idOfAnimalWithTheSpecificName(String name) {
        String idOfAnimal = "Animal with this name does not exist.";
        AnimalReader animalReader = new AnimalReader();
        Map<String, Animal> animalMap = new HashMap<>();
        try {
            animalMap = animalReader.fillStructureAnimals();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : animalMap.keySet()) {
            if (animalMap.get(s).getName().equals(name)) {
                idOfAnimal = s;
                break;
            }
        }
        return "ID of animal with this name is: " + idOfAnimal;
    }
}
