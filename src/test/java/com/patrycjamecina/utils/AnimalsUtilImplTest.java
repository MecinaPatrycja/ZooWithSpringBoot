package com.patrycjamecina.utils;
import com.patrycjamecina.model.Animal;
import com.patrycjamecina.model.Croft;
import com.patrycjamecina.model.Zookeeper;
import org.junit.Before;
import org.junit.Test;
import com.patrycjamecina.service.AnimalsServiceImpl;
import java.util.*;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;
public class AnimalsUtilImplTest {
    private AnimalReader animalReader = new AnimalReader();
    private AnimalsServiceImpl animalsUtil = new AnimalsServiceImpl();
    private ZookeeperReader zookeeperReader = new ZookeeperReader();
    private Map<String, Animal> animalMap;
    private Map<String, Zookeeper> zookeeperMap;
    private Croft croft;
    private List<String> cats;
    private Map<Integer, Integer> histogramTest;
    private String name;
    private String nameNoExist;

    @Before
    public void setUp() throws Exception {
        animalMap = animalReader.fillStructureAnimals();
        zookeeperMap = zookeeperReader.fillStructureZookeeper();
        String catName1 = "Luna";
        String catName2 = "Chester";
        String catName3 = "Remy";
        String catName4 = "Hayden";
        croft = new Croft("Horse Croft");
        cats = new ArrayList<>();
        cats.add(catName1);
        cats.add(catName2);
        cats.add(catName3);
        cats.add(catName4);
        histogramTest = new HashMap<>();
        histogramTest.put(1, 7);
        histogramTest.put(2, 13);
        histogramTest.put(3, 16);
        histogramTest.put(4, 2);
        histogramTest.put(5, 1);
        histogramTest.put(6, 1);
        name = "Rick";
        nameNoExist = "Zenon";
    }

    @Test
    public void howManyFoodNeedAverageAnimalPerDay() {
        assertEquals(4.18, animalsUtil.howManyFoodNeedAverageAnimalPerDay(), 0.1);
    }

    @Test
    public void manOrWomanHaveMoreAnimals1() {
        assertEquals("female", animalsUtil.manOrWomanHaveMoreAnimals());
    }

    @Test
    public void listOfCats1() {
        assertEquals(4, animalsUtil.listOfCats().size());
    }

    @Test
    public void listOfCats2() {
        assertThat(cats, containsInAnyOrder(animalsUtil.listOfCats().toArray()));
    }


    @Test
    public void howManyFoodEatsTheHeaviestAnimal2() {
        assertEquals(0.016894096, animalsUtil.howManyFoodEatsTheHeaviestAnimal(), 0.000000001);
    }

    @Test
    public void createCroftWithHorses() {
        assertEquals(croft.getName(), animalsUtil.createCroftWithHorses().getName());
    }

    @Test
    public void createCroftWithHorses2() {
        List<Animal> animalsInCroft = animalsUtil.createCroftWithHorses().getAnimals();
        for (Animal animal : animalsInCroft) {
            assertTrue(animal.getSpecies().toLowerCase().equals("horse"));
        }
        assertEquals(4, animalsInCroft.size());
    }

    @Test
    public void histogramOfNumbersOfAnimalsPerZookeeper1() {
        assertEquals(histogramTest, animalsUtil.histogramOfNumbersOfAnimalsPerZookeeper());
    }

    @Test
    public void histogramOfNumbersOfAnimalsPerZookeeper2() {
        assertEquals(histogramTest.size(), animalsUtil.histogramOfNumbersOfAnimalsPerZookeeper().size());
    }

    @Test
    public void idOfAnimalWithTheSpecificName1() {
        assertEquals("ID of animal with this name is: 2", animalsUtil.idOfAnimalWithTheSpecificName(name));
    }

    @Test
    public void idOfAnimalWithTheSpecificName2() {
        assertEquals("ID of animal with this name is: Animal with this name does not exist.", animalsUtil.idOfAnimalWithTheSpecificName(nameNoExist));
    }
}