package com.slaughterhouse.slaughterhouseproject;

import com.slaughterhouse.slaughterhouseproject.utils.Date;
import com.slaughterhouse.slaughterhouseproject.utils.DateInterface;

public class Animal implements AnimalInterface
{
  private int id;
  private double weight;
  private String type;
  private DateInterface dateArrived;

  public Animal(double weight, String type){
    this.id = -1;
    this.weight = weight;
    this.type = type;
  }

  public void setId(int id)
  {
    this.id = id;
  }

  public int getId()
  {
    return id;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public String getType()
  {
    return type;
  }

  public void setWeight(double weight)
  {
    this.weight = weight;
  }

  public double getWeight()
  {
    return weight;
  }

  public void setDateArrived(DateInterface dateArrived)
  {
    this.dateArrived = dateArrived;
  }

  public DateInterface getDateArrived()
  {
    return dateArrived;
  }
}
