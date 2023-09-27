package com.slaughterhouse.slaughterhouseproject;

import com.slaughterhouse.slaughterhouseproject.utils.DateInterface;

import java.util.ArrayList;

public class AnimalList implements AnimalListInterface
{
  private ArrayList<AnimalInterface> animals;

  public AnimalList()
  {
    this.animals = new ArrayList<>();
  }

  public AnimalList(ArrayList<AnimalInterface> animals)
  {
    this.animals = animals;
  }

  public ArrayList<AnimalInterface> getAnimals()
  {
    return animals;
  }

  public void setAnimals(ArrayList<AnimalInterface> animals)
  {
    this.animals = animals;
  }

  public boolean removeAnimal(AnimalInterface animal)
  {
    return animals.remove(animal);
  }

  public boolean removeAnimal(int id)
  {
    for (AnimalInterface animal : animals)
    {
      if (animal.getId() == id)
      {
        return removeAnimal(animal);
      }
    }
    return false;
  }

  public void addAnimal(AnimalInterface animal)
  {
    animals.add(animal);
  }

  public ArrayList<AnimalInterface> getAnimalsByDate(DateInterface date)
  {
    ArrayList<AnimalInterface> temp = new ArrayList<>();
    for (AnimalInterface animal : animals)
    {
      if (animal.getDateArrived().equalDate(date))
        temp.add(animal);
    }
    return temp;
  }

  public ArrayList<AnimalInterface> getAnimalsByType(String type)
  {
    ArrayList<AnimalInterface> temp = new ArrayList<>();
    for (AnimalInterface animal : animals)
    {
      if (animal.getType().equals(type))
        temp.add(animal);
    }
    return temp;
  }

  @Override public AnimalInterface getAnimalByID(int id)
  {
    for (AnimalInterface animal : animals)
    {
      if (animal.getId() == id)
        return animal;
    }
    return null;
  }

}
