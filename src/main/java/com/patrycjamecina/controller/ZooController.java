package com.patrycjamecina.controller;
import com.patrycjamecina.model.Animal;
import com.patrycjamecina.model.Croft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.patrycjamecina.service.AnimalsService;

import java.util.List;
import java.util.Map;
@RestController
public class ZooController {
    @Autowired
    private AnimalsService animalsService;

    @RequestMapping("/how-many-food-need-average-animal-per-day")
    public double howManyFoodNeedAverageAnimalPerDay() {
        return animalsService.howManyFoodNeedAverageAnimalPerDay();
    }

    @RequestMapping("/man-or-woman-have-more-animals")
    public String manOrWomanHaveMoreAnimals() {
        return animalsService.manOrWomanHaveMoreAnimals();
    }

    @RequestMapping("/list-of-cats")
    public List<String> listOfCats() {
        return animalsService.listOfCats();
    }

    @RequestMapping("/how-many-food-eats-the-heaviest-animal")
    public double howManyFoodEatsTheHeaviestAnimal() {
        return animalsService.howManyFoodEatsTheHeaviestAnimal();
    }

    @RequestMapping("/create-croft-with-horses")
    public Croft createCroftWithHorses() {
        return animalsService.createCroftWithHorses();
    }

    @RequestMapping("/histogram-of-numbers-ofAnimals-per-zookeeper")
    public Map<Integer, Integer> histogramOfNumbersOfAnimalsPerZookeeper() {
        return animalsService.histogramOfNumbersOfAnimalsPerZookeeper();
    }

    @RequestMapping(value = "/id-of-animal-with-the-specific-name", method = RequestMethod.POST)
    public String idOfAnimalWithTheSpecificName(@RequestBody Animal animal) {
        return animalsService.idOfAnimalWithTheSpecificName(animal.getName());
    }
}
