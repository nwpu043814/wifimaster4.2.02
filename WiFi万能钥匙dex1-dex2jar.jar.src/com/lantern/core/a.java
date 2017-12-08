package com.lantern.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.lantern.core.model.c;
import java.util.ArrayList;

public final class a
{
  protected Context a;
  private c b;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
    paramContext = this.a.getSharedPreferences("WkAppLunchInfo", 0);
    if (paramContext != null)
    {
      paramContext = paramContext.getString("pref_app_lunch_info", "");
      if ((paramContext != null) && (paramContext.length() != 0)) {
        break label64;
      }
      this.b = new c();
    }
    for (;;)
    {
      return;
      paramContext = "";
      break;
      label64:
      this.b = new c(paramContext);
      if (!this.b.b()) {
        this.b = new c();
      }
    }
  }
  
  private boolean b()
  {
    if ((this.b != null) && (this.b.b())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final c a()
  {
    if (!b()) {
      this.b = new c();
    }
    return this.b;
  }
  
  public final void a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (b())
        {
          boolean bool = this.b.a().contains(paramString);
          if (bool) {
            return;
          }
          this.b.a().add(paramString);
          paramString = this.a.getSharedPreferences("WkAppLunchInfo", 0);
          if (paramString == null) {
            continue;
          }
          paramString.edit().putString("pref_app_lunch_info", this.b.toString()).commit();
          continue;
        }
        localc = new com/lantern/core/model/c;
      }
      finally {}
      c localc;
      localc.<init>();
      this.b = localc;
      this.b.a().add(paramString);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */