package com.wifi.plugin.b;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.wifi.plugin.b;
import com.wifi.plugin.e.l;
import dalvik.system.DexClassLoader;

public final class a
{
  public String a;
  public Application b;
  public String c;
  public AssetManager d;
  public Resources e;
  public PackageInfo f;
  public DexClassLoader g;
  
  public final void a(Context paramContext)
  {
    String str = this.c;
    if (l.a() == null) {}
    for (ClassLoader localClassLoader = paramContext.getClassLoader();; localClassLoader = l.a())
    {
      this.g = l.a(str, paramContext, localClassLoader);
      return;
    }
  }
  
  public final boolean a()
  {
    if ((this.f != null) && (this.g != null) && (this.c != null)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final void b()
  {
    b.a("Plugin Path = " + this.c);
    b.a("Plugin Resources = " + this.e);
    b.a("Plugin Assets = " + this.d);
    b.a("Plugin Loader = " + this.g);
    b.a("Plugin PackageInfo = " + this.f);
    b.a("Plugin Application name = " + this.a);
    b.a("Plugin Application = " + this.b);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/plugin/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */