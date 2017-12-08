package com.lantern.dm.a;

import android.graphics.Bitmap;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class d
{
  private Map<String, Bitmap> a = Collections.synchronizedMap(new LinkedHashMap(10, 1.5F, true));
  private long b = 0L;
  private long c = 1000000L;
  
  private static long a(Bitmap paramBitmap)
  {
    if (paramBitmap == null) {}
    for (long l = 0L;; l = paramBitmap.getRowBytes() * paramBitmap.getHeight()) {
      return l;
    }
  }
  
  public final Bitmap a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (this.a.containsKey(paramString)) {
          continue;
        }
        paramString = null;
      }
      catch (NullPointerException paramString)
      {
        paramString = null;
        continue;
      }
      return paramString;
      paramString = (Bitmap)this.a.get(paramString);
    }
  }
  
  public final void a(String paramString, Bitmap paramBitmap)
  {
    try
    {
      if (this.a.containsKey(paramString)) {
        this.b -= a((Bitmap)this.a.get(paramString));
      }
      this.a.put(paramString, paramBitmap);
      this.b += a(paramBitmap);
      if (this.b > this.c)
      {
        paramString = this.a.entrySet().iterator();
        long l1;
        long l2;
        do
        {
          if (!paramString.hasNext()) {
            break;
          }
          paramBitmap = (Map.Entry)paramString.next();
          this.b -= a((Bitmap)paramBitmap.getValue());
          paramString.remove();
          l1 = this.b;
          l2 = this.c;
        } while (l1 > l2);
      }
      return;
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */