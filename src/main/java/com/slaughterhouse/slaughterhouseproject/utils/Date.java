package com.slaughterhouse.slaughterhouseproject.utils;

public class Date
{
  private int dd;
  private int mm;
  private int yyyy;

  public Date(int dd, int mm, int yyyy)
  {
    setFullDate(dd, mm, yyyy);
  }

  public Date(String date)
  {
    String[] aux = date.split("-");

    dd = Integer.parseInt(aux[0]);
    mm = Integer.parseInt(aux[1]);
    yyyy = Integer.parseInt(aux[2]);
  }

  public void setFullDate(int dd, int mm, int yyyy)
  {
    this.dd = dd;
    this.mm = mm;
    this.yyyy = yyyy;
  }

  public boolean equalDate(Date dateInterface)
  {
    if (dateInterface.getDay() == dd && dateInterface.getMonth() == mm
        && dateInterface.getYear() == yyyy)
    {
      return true;
    }
    return false;
  }

  public void setDay(int dd)
  {
    this.dd = dd;
  }

  public void setMonth(int mm)
  {
    this.mm = mm;
  }

  public void setYear(int yyyy)
  {
    this.yyyy = yyyy;
  }

  public int getDay()
  {
    return dd;
  }

  public int getMonth()
  {
    return mm;
  }

  public int getYear()
  {
    return yyyy;
  }
}
