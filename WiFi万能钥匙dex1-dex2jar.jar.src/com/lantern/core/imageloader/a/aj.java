package com.lantern.core.imageloader.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;

final class aj
  extends ai
{
  private final Context a;
  
  aj(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public final boolean a(ag paramag)
  {
    if (paramag.b != 0) {}
    for (boolean bool = true;; bool = "android.resource".equals(paramag.a.getScheme())) {
      return bool;
    }
  }
  
  public final ai.a b(ag paramag)
  {
    Resources localResources = at.a(this.a, paramag);
    int i = at.a(localResources, paramag);
    BitmapFactory.Options localOptions = d(paramag);
    if (a(localOptions))
    {
      BitmapFactory.decodeResource(localResources, i, localOptions);
      a(paramag.e, paramag.f, localOptions, paramag);
    }
    return new ai.a(BitmapFactory.decodeResource(localResources, i, localOptions), aa.d.b);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */