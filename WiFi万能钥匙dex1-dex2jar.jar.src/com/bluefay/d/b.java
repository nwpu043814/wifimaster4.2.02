package com.bluefay.d;

import android.os.Handler;
import java.util.HashSet;
import java.util.Set;

public class b
  extends Handler
{
  private Set<Integer> a = new HashSet();
  
  public b()
  {
    this(null);
  }
  
  public b(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt != null)
    {
      int j = paramArrayOfInt.length;
      for (int i = 0; i < j; i++)
      {
        int k = paramArrayOfInt[i];
        this.a.add(Integer.valueOf(k));
      }
    }
  }
  
  public final boolean a(int paramInt)
  {
    try
    {
      boolean bool = this.a.contains(Integer.valueOf(paramInt));
      return bool;
    }
    finally {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/d/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */