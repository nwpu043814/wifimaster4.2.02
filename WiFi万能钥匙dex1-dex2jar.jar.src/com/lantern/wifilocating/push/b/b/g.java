package com.lantern.wifilocating.push.b.b;

import android.content.Context;
import com.lantern.wifilocating.push.c;
import com.lantern.wifilocating.push.util.j;

public final class g
  extends a
{
  public g()
  {
    super(e.c);
  }
  
  public final int a()
  {
    int j = 10000;
    Object localObject = c.a();
    int i = j;
    if (localObject != null)
    {
      localObject = j.a((Context)localObject);
      i = j;
      if (localObject != null)
      {
        if (!((String)localObject).equals("WIFI")) {
          break label40;
        }
        i = 3000;
      }
    }
    for (;;)
    {
      return i;
      label40:
      if (((String)localObject).equals("4G"))
      {
        i = 5000;
      }
      else if (((String)localObject).equals("3G"))
      {
        i = 7000;
      }
      else
      {
        i = j;
        if (((String)localObject).equals("2G")) {
          i = j;
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/b/b/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */