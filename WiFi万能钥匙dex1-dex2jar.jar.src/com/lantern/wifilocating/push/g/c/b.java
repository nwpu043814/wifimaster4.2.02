package com.lantern.wifilocating.push.g.c;

import android.util.SparseArray;
import com.lantern.wifilocating.push.util.h;

public final class b
{
  private static final SparseArray<Class<? extends c>> a;
  
  static
  {
    SparseArray localSparseArray = new SparseArray();
    a = localSparseArray;
    localSparseArray.put(1, com.lantern.wifilocating.push.i.b.class);
    a.put(4, com.lantern.wifilocating.push.i.b.class);
    a.put(2, e.class);
    a.put(6, e.class);
    a.put(5, a.class);
  }
  
  public static c a(int paramInt)
  {
    Object localObject1 = (Class)a.get(paramInt);
    if (localObject1 != null) {}
    for (;;)
    {
      try
      {
        localObject1 = (c)((Class)localObject1).newInstance();
        return (c)localObject1;
      }
      catch (Exception localException)
      {
        h.a(localException);
      }
      Object localObject2 = null;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/g/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */