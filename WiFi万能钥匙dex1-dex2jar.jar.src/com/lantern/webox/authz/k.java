package com.lantern.webox.authz;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.b.a.ac;
import com.b.a.af;
import com.b.a.s;
import com.b.a.z;
import com.lantern.webox.b.e;
import com.lantern.webox.domain.AuthzPageConfig;

public class k
{
  private boolean a = false;
  private boolean b = false;
  private boolean c = true;
  private boolean d = false;
  private boolean e = false;
  private boolean f = true;
  private SharedPreferences g;
  private String h = "http://ckw.51y5.net?mode=wk";
  private AuthzPageConfig i;
  private af j = new af();
  private e k = new e(getClass());
  
  private SharedPreferences b(Context paramContext)
  {
    if (this.g == null) {
      this.g = paramContext.getSharedPreferences("webox_authz", 0);
    }
    return this.g;
  }
  
  public final void a(Context paramContext, boolean paramBoolean)
  {
    paramContext = b(paramContext).edit();
    paramContext.putBoolean("show_confirm_on_startup", paramBoolean);
    paramContext.commit();
  }
  
  public final void a(Bundle paramBundle)
  {
    this.i = new AuthzPageConfig();
    this.d = false;
    this.e = false;
    if (paramBundle == null) {}
    for (;;)
    {
      return;
      try
      {
        paramBundle = paramBundle.getString("ext");
        if ((paramBundle != null) && (paramBundle.length() > 0))
        {
          ac localac = (ac)af.a(paramBundle);
          paramBundle = (s)localac.a("authInputId");
          if (paramBundle != null)
          {
            this.i.setPhoNumInput(paramBundle.a(0).c());
            this.i.setAuthzCodeInput(paramBundle.a(1).c());
          }
          paramBundle = (s)localac.a("authButtonId");
          if (paramBundle != null)
          {
            this.d = true;
            this.e = true;
            this.i.setGetAuthzCodeButton(paramBundle.a(0).c());
            this.i.setLoginButton(paramBundle.a(1).c());
          }
        }
      }
      catch (Exception paramBundle)
      {
        new StringBuilder("parse auto config json error : ").append(paramBundle.getMessage());
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.f;
  }
  
  public final boolean a(Context paramContext)
  {
    if (!this.a) {}
    for (boolean bool = false;; bool = b(paramContext).getBoolean("show_confirm_on_startup", true)) {
      return bool;
    }
  }
  
  public final boolean b()
  {
    return this.b;
  }
  
  public final boolean c()
  {
    return this.c;
  }
  
  public final boolean d()
  {
    return this.d;
  }
  
  public final boolean e()
  {
    return this.e;
  }
  
  public final String f()
  {
    return this.h;
  }
  
  public final AuthzPageConfig g()
  {
    return this.i;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/authz/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */