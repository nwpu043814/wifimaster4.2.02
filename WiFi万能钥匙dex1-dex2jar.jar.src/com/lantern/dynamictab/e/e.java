package com.lantern.dynamictab.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.lantern.core.c;
import com.lantern.core.n;
import com.lantern.dynamictab.b.a.a;
import java.util.ArrayList;
import java.util.HashMap;

public final class e
{
  private HashMap<String, com.lantern.dynamictab.b.b> a = new HashMap();
  private Context b;
  
  public e(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    Object localObject = null;
    paramString1 = b.a().b(paramString1);
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = (String)localObject;
    }
    for (;;)
    {
      return paramString1;
      try
      {
        paramString1 = n.a(paramString2, paramString1);
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = (String)localObject;
      }
    }
  }
  
  public final int a(String paramString)
  {
    paramString = (com.lantern.dynamictab.b.b)this.a.get(paramString);
    int i;
    if (paramString != null) {
      if (paramString.e < 0) {
        i = 0;
      }
    }
    for (;;)
    {
      return i;
      i = paramString.e;
      continue;
      i = 0;
    }
  }
  
  public final void a(String paramString, com.lantern.dynamictab.b.b paramb)
  {
    if (!b.a().a(paramString)) {}
    for (;;)
    {
      return;
      this.a.put(paramString, paramb);
    }
  }
  
  public final boolean a(String paramString, boolean paramBoolean)
  {
    Object localObject = (com.lantern.dynamictab.b.b)this.a.get(paramString);
    if (localObject == null)
    {
      if (paramBoolean) {
        break label123;
      }
      long l = c.getInstance().getSharedPreferences("sp_dy_msg", 0).getLong(paramString, 0L);
      localObject = b.a().c(paramString);
      if (System.currentTimeMillis() - l < ((a.a)localObject).i * 60 * 60 * 1000) {
        paramBoolean = false;
      }
    }
    for (;;)
    {
      return paramBoolean;
      localObject = new com.lantern.dynamictab.b.b();
      ((com.lantern.dynamictab.b.b)localObject).a = paramString;
      ((com.lantern.dynamictab.b.b)localObject).f = true;
      this.a.put(paramString, localObject);
      paramBoolean = true;
      continue;
      paramBoolean = ((com.lantern.dynamictab.b.b)localObject).f;
      continue;
      label123:
      paramBoolean = false;
    }
  }
  
  public final com.lantern.dynamictab.b.b b(String paramString)
  {
    return (com.lantern.dynamictab.b.b)this.a.get(paramString);
  }
  
  public final void c(String paramString)
  {
    boolean bool = f.a(paramString);
    if (!bool) {
      this.b.getSharedPreferences("sp_dy_msg", 0).edit().putLong(paramString, System.currentTimeMillis()).commit();
    }
    paramString = (com.lantern.dynamictab.b.b)this.a.get(paramString);
    if (paramString == null) {}
    for (;;)
    {
      return;
      paramString.b = "";
      paramString.c = "";
      paramString.f = false;
      if (!bool)
      {
        paramString.e = 0;
        paramString.d = null;
      }
      com.lantern.dynamictab.a.a();
      b.a().a(null, true);
    }
  }
  
  public final void d(String paramString)
  {
    com.lantern.dynamictab.b.a locala = b.a().c();
    if ((locala == null) || (locala.a == null) || (locala.a.size() == 0)) {
      this.a.clear();
    }
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = (com.lantern.dynamictab.b.b)this.a.get(paramString);
        if (paramString != null)
        {
          paramString.b = "";
          paramString.c = "";
          paramString.f = false;
          paramString.e = 0;
          paramString.d = null;
          com.lantern.dynamictab.a.a();
          b.a().a(null, true);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dynamictab/e/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */