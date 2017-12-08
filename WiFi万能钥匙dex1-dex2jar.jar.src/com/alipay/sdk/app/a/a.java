package com.alipay.sdk.app.a;

import android.content.Context;
import android.text.TextUtils;

public final class a
{
  private static c a;
  
  public static void a(Context paramContext)
  {
    if (a != null) {}
    for (;;)
    {
      return;
      a = new c(paramContext);
    }
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    for (;;)
    {
      Object localObject2;
      c localc;
      try
      {
        localObject2 = a;
        if (localObject2 == null) {
          return;
        }
        localc = a;
        if (TextUtils.isEmpty(localc.i))
        {
          paramString = "";
          localObject1 = new java/lang/Thread;
          localObject2 = new com/alipay/sdk/app/a/b;
          ((b)localObject2).<init>(paramContext, paramString);
          ((Thread)localObject1).<init>((Runnable)localObject2);
          ((Thread)localObject1).start();
          a = null;
          continue;
        }
        arrayOfString1 = paramString.split("&");
      }
      finally {}
      String[] arrayOfString1;
      if (arrayOfString1 != null)
      {
        int j = arrayOfString1.length;
        int i = 0;
        paramString = null;
        localObject3 = localObject1;
        localObject2 = paramString;
        if (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[i].split("=");
          localObject2 = localObject1;
          localObject3 = paramString;
          if (arrayOfString2 != null)
          {
            localObject2 = localObject1;
            localObject3 = paramString;
            if (arrayOfString2.length == 2)
            {
              if (!arrayOfString2[0].equalsIgnoreCase("partner")) {
                break label198;
              }
              arrayOfString2[1].replace("\"", "");
              localObject3 = paramString;
              localObject2 = localObject1;
            }
          }
          for (;;)
          {
            i++;
            localObject1 = localObject2;
            paramString = (String)localObject3;
            break;
            label198:
            if (arrayOfString2[0].equalsIgnoreCase("out_trade_no"))
            {
              localObject3 = arrayOfString2[1].replace("\"", "");
              localObject2 = localObject1;
            }
            else
            {
              localObject2 = localObject1;
              localObject3 = paramString;
              if (arrayOfString2[0].equalsIgnoreCase("trade_no"))
              {
                localObject2 = arrayOfString2[1].replace("\"", "");
                localObject3 = paramString;
              }
            }
          }
        }
      }
      else
      {
        localObject2 = null;
      }
      paramString = c.a((String)localObject3);
      localObject1 = c.a((String)localObject2);
      localc.b = String.format("%s,%s,-,%s,-,-,-", new Object[] { paramString, localObject1, c.a((String)localObject1) });
      paramString = String.format("[(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s)]", new Object[] { localc.a, localc.b, localc.c, localc.d, localc.e, localc.f, localc.g, localc.h, localc.i, localc.j });
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    if (a == null) {}
    for (;;)
    {
      return;
      a.a(paramString1, paramString2, paramString3);
    }
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (a == null) {}
    for (;;)
    {
      return;
      a.a(paramString1, paramString2, paramThrowable);
    }
  }
  
  public static void a(String paramString, Throwable paramThrowable)
  {
    if (a == null) {}
    for (;;)
    {
      return;
      if (paramThrowable.getClass() != null) {
        a.a(paramString, paramThrowable.getClass().getSimpleName(), paramThrowable);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/app/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */