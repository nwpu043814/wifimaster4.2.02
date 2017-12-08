package com.lantern.core.imageloader.a;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;

final class s
  extends n
{
  s(Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean a(ag paramag)
  {
    return "file".equals(paramag.a.getScheme());
  }
  
  public final ai.a b(ag paramag)
  {
    return new ai.a(null, c(paramag), aa.d.b, new ExifInterface(paramag.a.getPath()).getAttributeInt("Orientation", 1));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */