package com.a.a.a.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.Random;

public final class d
{
  private static String a()
  {
    int m = (int)(System.currentTimeMillis() / 1000L);
    int j = (int)System.nanoTime();
    int i = new Random().nextInt();
    int k = new Random().nextInt();
    byte[] arrayOfByte3 = c.a(m);
    byte[] arrayOfByte1 = c.a(j);
    byte[] arrayOfByte2 = c.a(i);
    byte[] arrayOfByte4 = c.a(k);
    byte[] arrayOfByte5 = new byte[16];
    System.arraycopy(arrayOfByte3, 0, arrayOfByte5, 0, 4);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte5, 4, 4);
    System.arraycopy(arrayOfByte2, 0, arrayOfByte5, 8, 4);
    System.arraycopy(arrayOfByte4, 0, arrayOfByte5, 12, 4);
    return b.a(arrayOfByte5, 2);
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null)
        {
          paramContext = paramContext.getDeviceId();
          Object localObject = paramContext;
          if (e.a(paramContext)) {
            localObject = a();
          }
          return (String)localObject;
        }
      }
      catch (Exception paramContext) {}
      paramContext = null;
    }
  }
  
  public static String b(Context paramContext)
  {
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null)
        {
          paramContext = paramContext.getSubscriberId();
          Object localObject = paramContext;
          if (e.a(paramContext)) {
            localObject = a();
          }
          return (String)localObject;
        }
      }
      catch (Exception paramContext) {}
      paramContext = null;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/a/a/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */