package com.slaughterhouse.slaughterhouseproject;

import com.slaughterhouse.slaughterhouseproject.utils.Date;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController public class ServerController
{
  public AnimalListInterface animals = new AnimalList();

  @PutMapping("/animals/registerAnimal") public synchronized void insertAnimal(
      @RequestBody String json)
  {
    Gson gson = new Gson();
    Animal animal = gson.fromJson(json, Animal.class);
    animals.addAnimal(animal);
    System.out.println("Added animal "+ animal);
  }

  // date has to be in format dd-mm-yyyy
  @GetMapping("/animals/getByDate/{date}") public synchronized ResponseEntity<String> getAnimalsByDate(
      @PathVariable(value = "date") String date)
  {
    Gson gson = new Gson();
    Date dateToCheck = new Date(date);
    AnimalListInterface found = new AnimalList(animals.getAnimalsByDate(dateToCheck));
    if (found == null)
    {
      return new ResponseEntity<>(gson.toJson(null), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(gson.toJson(found), HttpStatus.OK);
  }

  @GetMapping("/animals/getByType/{type}") public synchronized ResponseEntity<String> getAnimalsByType(
      @PathVariable(value = "type") String type)
  {
    Gson gson = new Gson();
    AnimalListInterface found = new AnimalList(animals.getAnimalsByType(type));
    if (found == null)
    {
      return new ResponseEntity<>(gson.toJson(null), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(gson.toJson(found), HttpStatus.OK);
  }

  @GetMapping("/animals/getById/{id}") public synchronized ResponseEntity<String> getAnimalById(
      @PathVariable(value = "id") String id)
  {
    Gson gson = new Gson();
    Animal found = animals.getAnimalByID(Integer.parseInt(id));
    System.out.println(id);
    System.out.println(found);
    System.out.println(gson.toJson(found));
    if (found == null)
    {
      return new ResponseEntity<>(gson.toJson(null), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(gson.toJson(found), HttpStatus.OK);
  }

  @GetMapping("/animals") public synchronized ResponseEntity<String> getAnimals()
  {
    Gson gson = new Gson();
    System.out.println(gson.toJson(animals));
    if (animals == null || animals.getAnimals().isEmpty())
    {
      System.out.println(animals);
      return new ResponseEntity<>(gson.toJson(null), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(gson.toJson((AnimalList)animals), HttpStatus.OK);
  }

}
