package com.slaughterhouse.slaughterhouseproject;

import com.slaughterhouse.slaughterhouseproject.utils.DateInterface;

import java.util.ArrayList;

public interface AnimalListInterface
{
  ArrayList<AnimalInterface> getAnimals();
  void setAnimals(ArrayList<AnimalInterface> animals);
  boolean removeAnimal(AnimalInterface animal);
  boolean removeAnimal(int id);
  void addAnimal(AnimalInterface animal);
  ArrayList<AnimalInterface> getAnimalsByDate(DateInterface date);
  ArrayList<AnimalInterface> getAnimalsByType(String type);
  AnimalInterface getAnimalByID(int id);
}
