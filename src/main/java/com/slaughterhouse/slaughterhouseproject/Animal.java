package com.slaughterhouse.slaughterhouseproject;

import com.slaughterhouse.slaughterhouseproject.utils.Date;

public class Animal
{
  private int id;
  private double weight;
  private String type;
  private Date dateArrived;

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

  public void setDateArrived(Date dateArrived)
  {
    this.dateArrived = dateArrived;
  }

  public Date getDateArrived()
  {
    return dateArrived;
  }
}
