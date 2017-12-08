package com.lantern.core.imageloader.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import java.util.List;

final class b
  extends ai
{
  private static final int a = 22;
  private final AssetManager b;
  
  public b(Context paramContext)
  {
    this.b = paramContext.getAssets();
  }
  
  public final boolean a(ag paramag)
  {
    boolean bool2 = false;
    paramag = paramag.a;
    boolean bool1 = bool2;
    if ("file".equals(paramag.getScheme()))
    {
      bool1 = bool2;
      if (!paramag.getPathSegments().isEmpty())
      {
        bool1 = bool2;
        if ("android_asset".equals(paramag.getPathSegments().get(0))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public final ai.a b(ag paramag)
  {
    return new ai.a(this.b.open(paramag.a.toString().substring(a)), aa.d.b);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */