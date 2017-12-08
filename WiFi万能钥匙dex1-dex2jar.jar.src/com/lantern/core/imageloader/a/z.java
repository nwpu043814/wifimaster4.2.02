package com.lantern.core.imageloader.a;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Handler;
import java.io.IOException;
import java.io.InputStream;

final class z
  extends ai
{
  private final r a;
  private final ak b;
  
  public z(r paramr, ak paramak)
  {
    this.a = paramr;
    this.b = paramak;
  }
  
  final int a()
  {
    return 2;
  }
  
  final boolean a(NetworkInfo paramNetworkInfo)
  {
    if ((paramNetworkInfo == null) || (paramNetworkInfo.isConnected())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean a(ag paramag)
  {
    paramag = paramag.a.getScheme();
    if (("http".equals(paramag)) || ("https".equals(paramag))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final ai.a b(ag paramag)
  {
    r.a locala = this.a.a(paramag.a, paramag.s);
    Object localObject;
    if (locala.c)
    {
      paramag = aa.d.b;
      localObject = locala.b;
      if (localObject == null) {
        break label63;
      }
      paramag = new ai.a((Bitmap)localObject, paramag);
    }
    for (;;)
    {
      return paramag;
      paramag = aa.d.c;
      break;
      label63:
      localObject = locala.a;
      if (localObject == null)
      {
        paramag = null;
      }
      else
      {
        if ((paramag == aa.d.b) && (locala.d == 0L))
        {
          at.a((InputStream)localObject);
          throw new a("Received response with 0 content-length header.");
        }
        if ((paramag == aa.d.c) && (locala.d > 0L))
        {
          ak localak = this.b;
          long l = locala.d;
          localak.c.sendMessage(localak.c.obtainMessage(4, Long.valueOf(l)));
        }
        paramag = new ai.a((InputStream)localObject, paramag);
      }
    }
  }
  
  final boolean b()
  {
    return true;
  }
  
  static final class a
    extends IOException
  {
    public a(String paramString)
    {
      super();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */