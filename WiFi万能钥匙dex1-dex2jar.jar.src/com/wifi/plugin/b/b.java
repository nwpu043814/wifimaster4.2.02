package com.wifi.plugin.b;

import android.app.Activity;
import android.content.res.Resources.Theme;
import com.wifi.plugin.c.c;

public final class b
{
  a a;
  private Resources.Theme b;
  private Activity c;
  private Activity d;
  private String e = null;
  private c f;
  
  public b(Activity paramActivity, String paramString)
  {
    this.c = paramActivity;
    this.a = com.wifi.plugin.e.a.a(paramString);
    this.a.a(paramActivity);
  }
  
  public final String a()
  {
    return this.e;
  }
  
  public final void a(Activity paramActivity)
  {
    this.d = paramActivity;
  }
  
  public final void a(Resources.Theme paramTheme)
  {
    this.b = paramTheme;
  }
  
  public final void a(c paramc)
  {
    this.f = paramc;
  }
  
  public final void a(String paramString)
  {
    this.e = paramString;
  }
  
  public final c b()
  {
    return this.f;
  }
  
  public final String c()
  {
    return this.a.c;
  }
  
  public final Resources.Theme d()
  {
    return this.b;
  }
  
  public final Activity e()
  {
    return this.d;
  }
  
  public final a f()
  {
    return this.a;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/plugin/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */