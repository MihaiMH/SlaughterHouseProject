package com.slaughterhouse.slaughterhouseproject;

import com.google.gson.Gson;
import com.slaughterhouse.slaughterhouseproject.utils.Date;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication public class ClientStart
{
  private static final String ROOT = "http://localhost:8080/";

  private static RestTemplate rest = new RestTemplate();

  public static void main(String[] args)
  {
    new ClientStart().run();
  }

  public static void run()
  {
    Gson gson = new Gson();

    // Register 5 animals
    addAnimal(1, 125.6, "Cow", 29,9, 2023);
    addAnimal(2, 155.6, "Cow", 28,9, 2023);
    addAnimal(3, 135.6, "Pig", 29,9, 2023);
    addAnimal(4, 145.6, "Pig", 26,9, 2023);
    addAnimal(5, 3.6, "Chicken", 26,9, 2023);

    // Get animals from the date 29-9-2023
    AnimalListInterface animals = getAnimalsByDate(29,9,2023);
    String answer = gson.toJson(animals.getAnimals());
    System.out.println(answer);

    System.out.println("----");
    // Get animals from the date 26-9-2023
    AnimalListInterface animals2 = getAnimalsByDate(26,9,2023);
    String answer2 = gson.toJson(animals2.getAnimals());
    System.out.println(answer2);

    System.out.println("----");
    // Get animals by type "Cow"
    AnimalListInterface animals3 = getAnimalsByType("Pig");
    String answer3 = gson.toJson(animals3.getAnimals());
    System.out.println(answer3);

    System.out.println("----");
    // Get animals by type "Chicken"
    AnimalListInterface animals4 = getAnimalsByType("Chicken");
    String answer4 = gson.toJson(animals4.getAnimals());
    System.out.println(answer4);

    System.out.println("----");
    // Get animal with the ID 2
    Animal animal = getAnimalById(1);
    String answer5 = gson.toJson(animal);
    System.out.println(answer5);

    System.out.println("----");
    // Get all animals
    AnimalListInterface animals5 = getAnimals();
    String answer6 = gson.toJson(animals5);
    System.out.println(answer6);
  }

  private static void addAnimal(int id, double weight, String type, int dd,
      int mm, int yyyy)
  {
    Date date = new Date(dd, mm, yyyy);
    Animal animal = new Animal(weight, type);
    animal.setId(id);
    animal.setDateArrived(date);
    Gson gson = new Gson();
    rest.put(ROOT + "animals/registerAnimal", gson.toJson(animal));
  }

  private static AnimalListInterface getAnimalsByDate(int dd, int mm, int yyyy)
  {
    try
    {
      Gson gson = new Gson();
      ResponseEntity<String> response = rest.getForEntity(
          ROOT + "animals/getByDate/" + dd + "-" + mm + "-" + yyyy,
          String.class);
      AnimalListInterface found = gson.fromJson(response.getBody(),
          AnimalList.class);
      return found;
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
      System.out.println(
          "No animals from the date: " + dd + " " + mm + " " + yyyy);
      return new AnimalList();
    }
  }

  private static AnimalListInterface getAnimalsByType(String type)
  {
    try
    {
      Gson gson = new Gson();
      ResponseEntity<String> response = rest.getForEntity(
          ROOT + "animals/getByType/" + type, String.class);
      AnimalListInterface found = gson.fromJson(response.getBody(),
          AnimalList.class);
      return found;
    }
    catch (Exception e)
    {
      System.out.println("No animals with the type: " + type);
      return new AnimalList();
    }
  }

  private static Animal getAnimalById(int id)
  {
    try
    {
      Gson gson = new Gson();

      ResponseEntity<String> response = rest.getForEntity(
          ROOT + "animals/getById/" + id, String.class);
      Animal found = gson.fromJson(response.getBody(), Animal.class);
      return found;
    }
    catch (Exception e)
    {
      System.out.println("No animals with the ID: " + id);
      return null;
    }
  }

  private static AnimalListInterface getAnimals()
  {
    try
    {
      Gson gson = new Gson();
      ResponseEntity<String> response = rest.getForEntity(ROOT + "animals",
          String.class);
      AnimalListInterface found = gson.fromJson(response.getBody(),
          AnimalList.class);
      return found;
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
      System.out.println("No animals");
      return new AnimalList();
    }
  }

}
