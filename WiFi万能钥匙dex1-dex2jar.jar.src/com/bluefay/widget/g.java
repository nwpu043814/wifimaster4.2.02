package com.bluefay.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.bluefay.b.h;

public final class g
{
  private Context a;
  private String b;
  private String c;
  private Bundle d;
  private android.app.Fragment e;
  private CharSequence f;
  private Drawable g;
  
  public g(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    this.a = paramContext;
    this.b = paramString1;
    this.c = paramString2;
    this.d = paramBundle;
  }
  
  public final CharSequence a()
  {
    return this.f;
  }
  
  public final void a(Drawable paramDrawable)
  {
    this.g = paramDrawable;
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.f = paramCharSequence;
  }
  
  public final Drawable b()
  {
    return this.g;
  }
  
  public final String c()
  {
    return this.b;
  }
  
  public final android.app.Fragment d()
  {
    return this.e;
  }
  
  public final android.app.Fragment e()
  {
    try
    {
      this.e = android.app.Fragment.instantiate(this.a, this.c, this.d);
      if ((this.e instanceof bluefay.app.Fragment)) {
        ((bluefay.app.Fragment)this.e).a_(this.a);
      }
      return this.e;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        h.a(localException);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/widget/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */