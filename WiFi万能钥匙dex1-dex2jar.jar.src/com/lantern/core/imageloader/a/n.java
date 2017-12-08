package com.lantern.core.imageloader.a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

class n
  extends ai
{
  final Context a;
  
  n(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public boolean a(ag paramag)
  {
    return "content".equals(paramag.a.getScheme());
  }
  
  public ai.a b(ag paramag)
  {
    return new ai.a(c(paramag), aa.d.b);
  }
  
  final InputStream c(ag paramag)
  {
    return this.a.getContentResolver().openInputStream(paramag.a);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */