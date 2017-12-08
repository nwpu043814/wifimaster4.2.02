package com.lantern.core.imageloader.a;

import android.graphics.Bitmap;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

public abstract interface r
{
  public abstract a a(Uri paramUri, int paramInt);
  
  public static final class a
  {
    final InputStream a;
    final Bitmap b;
    final boolean c;
    final long d;
    
    public a(InputStream paramInputStream, boolean paramBoolean, long paramLong)
    {
      if (paramInputStream == null) {
        throw new IllegalArgumentException("Stream may not be null.");
      }
      this.a = paramInputStream;
      this.b = null;
      this.c = paramBoolean;
      this.d = paramLong;
    }
  }
  
  public static final class b
    extends IOException
  {
    final boolean a;
    final int b;
    
    public b(String paramString, int paramInt1, int paramInt2)
    {
      super();
      this.a = y.c(paramInt1);
      this.b = paramInt2;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */