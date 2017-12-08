package com.alipay.android.a.a.a;

import android.text.format.Time;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class s
{
  private static final Pattern a = Pattern.compile("([0-9]{1,2})[- ]([A-Za-z]{3,9})[- ]([0-9]{2,4})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])");
  private static final Pattern b = Pattern.compile("[ ]([A-Za-z]{3,9})[ ]+([0-9]{1,2})[ ]([0-9]{1,2}:[0-9][0-9]:[0-9][0-9])[ ]([0-9]{2,4})");
  
  public static long a(String paramString)
  {
    int m = 1;
    Object localObject = a.matcher(paramString);
    int k;
    int j;
    int i;
    if (((Matcher)localObject).find())
    {
      k = b(((Matcher)localObject).group(1));
      j = c(((Matcher)localObject).group(2));
      i = d(((Matcher)localObject).group(3));
      paramString = e(((Matcher)localObject).group(4));
      if (i < 2038) {
        break label182;
      }
      i = 2038;
      j = 0;
      k = m;
    }
    label182:
    for (;;)
    {
      localObject = new Time("UTC");
      ((Time)localObject).set(paramString.c, paramString.b, paramString.a, k, j, i);
      return ((Time)localObject).toMillis(false);
      localObject = b.matcher(paramString);
      if (((Matcher)localObject).find())
      {
        j = c(((Matcher)localObject).group(1));
        k = b(((Matcher)localObject).group(2));
        paramString = e(((Matcher)localObject).group(3));
        i = d(((Matcher)localObject).group(4));
        break;
      }
      throw new IllegalArgumentException();
    }
  }
  
  private static int b(String paramString)
  {
    if (paramString.length() == 2) {}
    for (int i = (paramString.charAt(0) - '0') * 10 + (paramString.charAt(1) - '0');; i = paramString.charAt(0) - '0') {
      return i;
    }
  }
  
  private static int c(String paramString)
  {
    int i = 0;
    switch (Character.toLowerCase(paramString.charAt(0)) + Character.toLowerCase(paramString.charAt(1)) + Character.toLowerCase(paramString.charAt(2)) - 291)
    {
    default: 
      throw new IllegalArgumentException();
    case 10: 
      i = 1;
    }
    for (;;)
    {
      return i;
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 6;
      continue;
      i = 7;
      continue;
      i = 8;
      continue;
      i = 9;
      continue;
      i = 10;
      continue;
      i = 11;
    }
  }
  
  private static int d(String paramString)
  {
    int i;
    if (paramString.length() == 2)
    {
      i = (paramString.charAt(0) - '0') * 10 + (paramString.charAt(1) - '0');
      if (i >= 70) {
        i += 1900;
      }
    }
    for (;;)
    {
      return i;
      i += 2000;
      continue;
      if (paramString.length() == 3) {
        i = (paramString.charAt(0) - '0') * 100 + (paramString.charAt(1) - '0') * 10 + (paramString.charAt(2) - '0') + 1900;
      } else if (paramString.length() == 4) {
        i = (paramString.charAt(0) - '0') * 1000 + (paramString.charAt(1) - '0') * 100 + (paramString.charAt(2) - '0') * 10 + (paramString.charAt(3) - '0');
      } else {
        i = 1970;
      }
    }
  }
  
  private static a e(String paramString)
  {
    int i = paramString.charAt(0) - '0';
    int j;
    if (paramString.charAt(1) != ':')
    {
      j = 2;
      i = i * 10 + (paramString.charAt(1) - '0');
    }
    for (;;)
    {
      j++;
      int m = j + 1;
      int k = paramString.charAt(j);
      j = paramString.charAt(m);
      m = m + 1 + 1;
      return new a(i, (k - 48) * 10 + (j - 48), (paramString.charAt(m) - '0') * 10 + (paramString.charAt(m + 1) - '0'));
      j = 1;
    }
  }
  
  private static final class a
  {
    int a;
    int b;
    int c;
    
    a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/android/a/a/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */