package com.slaughterhouse.slaughterhouseproject;

import com.slaughterhouse.slaughterhouseproject.utils.Date;
import com.slaughterhouse.slaughterhouseproject.utils.DateInterface;

public interface AnimalInterface
{
  public void setId(int id);
  public int getId();
  public void setType(String type);
  public String getType();
  public void setWeight(double weight);
  public double getWeight();
  public void setDateArrived(DateInterface dateArrived);
  public DateInterface getDateArrived();
}
