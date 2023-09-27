package com.slaughterhouse.slaughterhouseproject.utils;

public class Date implements DateInterface
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
    String dd_string = date.substring(0,2);
    date = date.replace(dd_string+"-", "");
    String mm_string = date.substring(0,2);
    date = date.replace(mm_string+"-", "");
    String yyyy_string = date.substring(0,4);

    dd = Integer.parseInt(dd_string);
    mm = Integer.parseInt(mm_string);
    yyyy = Integer.parseInt(yyyy_string);
  }

  @Override public void setFullDate(int dd, int mm, int yyyy)
  {
    this.dd = dd;
    this.mm = mm;
    this.yyyy = yyyy;
  }

  @Override public boolean equalDate(DateInterface dateInterface)
  {
    if (dateInterface.getDay() == dd && dateInterface.getMonth() == mm
        && dateInterface.getYear() == yyyy)
    {
      return true;
    }
    return false;
  }

  @Override public void setDay(int dd)
  {
    this.dd = dd;
  }

  @Override public void setMonth(int mm)
  {
    this.mm = mm;
  }

  @Override public void setYear(int yyyy)
  {
    this.yyyy = yyyy;
  }

  @Override public int getDay()
  {
    return dd;
  }

  @Override public int getMonth()
  {
    return mm;
  }

  @Override public int getYear()
  {
    return yyyy;
  }
}
