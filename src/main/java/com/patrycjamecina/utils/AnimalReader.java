package com.patrycjamecina.utils;
import com.patrycjamecina.model.Animal;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class AnimalReader {
    public Map<String, Animal> fillStructureAnimals() throws URISyntaxException, IOException {
        Map<String, Animal> animalMap = new HashMap<>();
        List<String> lines = Files.readAllLines(Paths.get(getClass().getClassLoader().getResource("animal").toURI()));
        lines.remove(0);
        for (String line : lines) {
            String[] source = line.split("\t");
            Animal animal = new Animal();
            animal.setID(source[0]);
            animal.setSpecies(source[1]);
            animal.setName(source[2]);
            animal.setWeight(Double.parseDouble(source[3]));
            animal.setIdOfZookeeper(source[4]);
            animal.setKgOfFoodPerDay(Double.parseDouble(source[5]));
            animal.setSociable(Boolean.parseBoolean(source[6]));
            animalMap.put(source[0], animal);
        }
        return animalMap;
    }
}
