package com.lantern.launcher.ui;

import android.text.TextUtils;
import com.bluefay.b.a;
import com.lantern.core.model.g;
import com.lantern.core.p;
import com.lantern.settings.a.e;

final class j
  implements a
{
  j(MainActivityICS paramMainActivityICS) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return;
      if ((paramObject instanceof g))
      {
        paramString = (g)paramObject;
        p.i(this.a.getApplicationContext(), paramString.d);
        p.j(this.a.getApplicationContext(), paramString.e);
        p.k(this.a.getApplicationContext(), paramString.g);
        if (!TextUtils.isEmpty(paramString.a))
        {
          p.a(this.a.getApplicationContext(), paramString.a);
          if (!TextUtils.isEmpty(paramString.d)) {
            new e(paramString.a, paramString.b, paramString.d).execute(new Void[0]);
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/ui/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */