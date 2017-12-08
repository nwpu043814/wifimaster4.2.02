package com.wifipay.wallet.home.bill;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class b
{
  public static long a(String paramString)
  {
    return a(paramString, "yyyy-MM-dd HH:mm:ss");
  }
  
  public static long a(String paramString1, String paramString2)
  {
    try
    {
      SimpleDateFormat localSimpleDateFormat = new java/text/SimpleDateFormat;
      localSimpleDateFormat.<init>(paramString2);
      l = localSimpleDateFormat.parse(paramString1).getTime();
      return l;
    }
    catch (ParseException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        long l = 0L;
      }
    }
  }
  
  public static String a(long paramLong)
  {
    return a(paramLong, "yyyy-MM-dd HH:mm:ss");
  }
  
  public static String a(long paramLong, String paramString)
  {
    Date localDate = new Date();
    paramString = new SimpleDateFormat(paramString);
    long l = paramLong;
    if (paramLong < 1000000000000L) {
      l = paramLong * 1000L;
    }
    localDate.setTime(l);
    return paramString.format(localDate);
  }
  
  public static boolean a(String paramString1, String paramString2, String paramString3)
  {
    boolean bool = false;
    paramString3 = new SimpleDateFormat(paramString3);
    try
    {
      paramString1 = paramString3.parse(paramString1);
      paramString2 = paramString3.parse(paramString2);
      long l1 = paramString1.getTime();
      long l2 = paramString2.getTime();
      if (l1 - l2 == 0L) {
        bool = true;
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
    return bool;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/bill/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */