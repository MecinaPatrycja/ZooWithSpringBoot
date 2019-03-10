package com.patrycjamecina.service;
import com.patrycjamecina.model.Animal;
import com.patrycjamecina.model.Croft;
import com.patrycjamecina.model.Zookeeper;

import java.util.List;
import java.util.Map;
public interface AnimalsService {
    //stwórz metodę obliczjącą średnie dzienne zapotrzebowanie zoo na pokarm dla 1 zwierzęcia
    double howManyFoodNeedAverageAnimalPerDay();

    //stwórz metodę sprawdzającą czy opiekunowie płci męskiej, czy żeńskiej mają więcej przypisanych zwierząt i zwróć Stringa "male" lub "female"
    String manOrWomanHaveMoreAnimals();

    //stworz metode zwracajaca liste imion wszystkich kotow (kotem jest zwierzę, które w nazwie gatunku zawiera słowo "cat")
    List<String> listOfCats();

    //stwórz metodę znjadującą najcięższe zwierzę w zoo i zwracającą ile kg pokarmu dziennie zjada na kg masy ciała
    double howManyFoodEatsTheHeaviestAnimal();

    //stworz zagrodę z końmi, nazwij zagrodę w następujący sposób: nazwaGatunku + " Croft"
    Croft createCroftWithHorses();

    //histogram ma zwracać liczebność opiekunów, którzy posiadaja daną liczbę zwierząt
    //np. jeśli liczba opiekunów, którzy zajmują się tylko 1 zwierzęciem wynosi 3 to zwracamy map(1,3)
    Map<Integer, Integer> histogramOfNumbersOfAnimalsPerZookeeper();

    //zwroc ID zwierzęcia o podanym imieniu, jeśli podane imię nie istnieje zwróc Stringa: animal with this name does not exist
    String idOfAnimalWithTheSpecificName(String name);
}
