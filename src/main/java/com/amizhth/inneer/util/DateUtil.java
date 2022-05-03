package com.amizhth.inneer.util;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateUtil
{
  public static LocalDate addDays(LocalDate date, int workdays)
  {
    if (workdays < 1) {
      return date;
    }
    LocalDate result = date;
    int addedDays = 0;
    while (addedDays < workdays)
    {
      result = result.plusDays(1L);
      if ((result.getDayOfWeek() != DayOfWeek.SATURDAY) && 
        (result.getDayOfWeek() != DayOfWeek.SUNDAY)) {
        addedDays++;
      }
    }
    return result;
  }
}
