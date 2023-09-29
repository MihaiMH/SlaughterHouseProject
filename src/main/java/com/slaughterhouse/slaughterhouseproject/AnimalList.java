package com.slaughterhouse.slaughterhouseproject;

import com.slaughterhouse.slaughterhouseproject.utils.Date;

import java.util.ArrayList;

public class AnimalList implements AnimalListInterface
{
  private ArrayList<Animal> animals;

  public AnimalList()
  {
    this.animals = new ArrayList<>();
  }

  public AnimalList(ArrayList<Animal> animals)
  {
    this.animals = animals;
  }

  public ArrayList<Animal> getAnimals()
  {
    return animals;
  }

  public void setAnimals(ArrayList<Animal> animals)
  {
    this.animals = animals;
  }

  public boolean removeAnimal(Animal animal)
  {
    return animals.remove(animal);
  }

  public boolean removeAnimal(int id)
  {
    for (Animal animal : animals)
    {
      if (animal.getId() == id)
      {
        return removeAnimal(animal);
      }
    }
    return false;
  }

  public void addAnimal(Animal animal)
  {
    animals.add(animal);
  }

  public ArrayList<Animal> getAnimalsByDate(Date date)
  {
    ArrayList<Animal> temp = new ArrayList<>();
    for (Animal animal : animals)
    {
      if (animal.getDateArrived().equalDate(date))
        temp.add(animal);
    }
    return temp;
  }

  public ArrayList<Animal> getAnimalsByType(String type)
  {
    ArrayList<Animal> temp = new ArrayList<>();
    for (Animal animal : animals)
    {
      if (animal.getType().equals(type))
        temp.add(animal);
    }
    return temp;
  }

  @Override public Animal getAnimalByID(int id)
  {
    for (Animal animal : animals)
    {
      if (animal.getId() == id)
        return animal;
    }
    return null;
  }

}
