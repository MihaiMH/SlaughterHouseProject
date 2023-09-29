package com.slaughterhouse.slaughterhouseproject;

import com.slaughterhouse.slaughterhouseproject.utils.Date;

import java.util.ArrayList;

public interface AnimalListInterface
{
  ArrayList<Animal> getAnimals();
  void setAnimals(ArrayList<Animal> animals);
  boolean removeAnimal(Animal animal);
  boolean removeAnimal(int id);
  void addAnimal(Animal animal);
  ArrayList<Animal> getAnimalsByDate(Date date);
  ArrayList<Animal> getAnimalsByType(String type);
  Animal getAnimalByID(int id);
}
