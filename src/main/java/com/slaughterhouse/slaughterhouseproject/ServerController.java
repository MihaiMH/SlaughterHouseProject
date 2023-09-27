package com.slaughterhouse.slaughterhouseproject;

import com.slaughterhouse.slaughterhouseproject.utils.Date;
import com.slaughterhouse.slaughterhouseproject.utils.DateInterface;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController public class ServerController
{
  public AnimalListInterface animals = new AnimalList();

  @PutMapping("/animals/registerAnimal") public synchronized void insertAnimal(
      @RequestBody String json)
  {
    Gson gson = new Gson();
    AnimalInterface animal = gson.fromJson(json, Animal.class);
    animals.addAnimal(animal);
  }

  // date has to be in format dd-mm-yyyy
  @GetMapping("/animals/getByDate/{date}") public synchronized ResponseEntity<String> getAnimalsByDate(
      @RequestParam(value = "date") String date)
  {
    Gson gson = new Gson();
    DateInterface dateToCheck = new Date(date);
    ArrayList<AnimalInterface> found = animals.getAnimalsByDate(dateToCheck);
    if (found == null)
    {
      return new ResponseEntity<>(gson.toJson(null), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(gson.toJson(found), HttpStatus.OK);
  }

  @GetMapping("/animals/getByType/{type}") public synchronized ResponseEntity<String> getAnimalsByType(
      @RequestParam(value = "type") String type)
  {
    Gson gson = new Gson();
    ArrayList<AnimalInterface> found = animals.getAnimalsByType(type);
    if (found == null)
    {
      return new ResponseEntity<>(gson.toJson(null), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(gson.toJson(found), HttpStatus.OK);
  }

  @GetMapping("/animals/getById/{id}") public synchronized ResponseEntity<String> getAnimalsById(
      @RequestParam(value = "id") int id)
  {
    Gson gson = new Gson();
    AnimalInterface found = animals.getAnimalByID(id);
    if (found == null)
    {
      return new ResponseEntity<>(gson.toJson(null), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(gson.toJson(found), HttpStatus.OK);
  }

  @GetMapping("/animals") public synchronized ResponseEntity<String> getAnimals()
  {
    Gson gson = new Gson();
    if (animals == null || animals.getAnimals().isEmpty())
    {
      return new ResponseEntity<>(gson.toJson(null), HttpStatus.BAD_REQUEST);
    }
    return new ResponseEntity<>(gson.toJson(animals), HttpStatus.OK);
  }

}
