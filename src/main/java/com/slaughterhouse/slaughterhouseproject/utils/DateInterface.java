package com.slaughterhouse.slaughterhouseproject.utils;

public interface DateInterface
{
  public void setFullDate(int dd, int mm, int yyyy);
  public boolean equalDate(DateInterface dateInterface);
  public void setDay(int dd);
  public void setMonth (int mm);
  public void setYear (int yyyy);
  public int getDay();
  public int getMonth();
  public int getYear();
}
