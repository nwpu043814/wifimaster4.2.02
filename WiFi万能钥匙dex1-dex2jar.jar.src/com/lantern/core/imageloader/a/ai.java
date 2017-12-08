package com.lantern.core.imageloader.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.net.NetworkInfo;
import java.io.InputStream;

public abstract class ai
{
  static void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, BitmapFactory.Options paramOptions, ag paramag)
  {
    int i = 1;
    if ((paramInt4 > paramInt2) || (paramInt3 > paramInt1))
    {
      if (paramInt2 != 0) {
        break label43;
      }
      i = (int)Math.floor(paramInt3 / paramInt1);
    }
    for (;;)
    {
      paramOptions.inSampleSize = i;
      paramOptions.inJustDecodeBounds = false;
      return;
      label43:
      if (paramInt1 == 0)
      {
        i = (int)Math.floor(paramInt4 / paramInt2);
      }
      else
      {
        paramInt2 = (int)Math.floor(paramInt4 / paramInt2);
        paramInt1 = (int)Math.floor(paramInt3 / paramInt1);
        if (paramag.h) {
          i = Math.max(paramInt2, paramInt1);
        } else {
          i = Math.min(paramInt2, paramInt1);
        }
      }
    }
  }
  
  static void a(int paramInt1, int paramInt2, BitmapFactory.Options paramOptions, ag paramag)
  {
    a(paramInt1, paramInt2, paramOptions.outWidth, paramOptions.outHeight, paramOptions, paramag);
  }
  
  static boolean a(BitmapFactory.Options paramOptions)
  {
    if ((paramOptions != null) && (paramOptions.inJustDecodeBounds)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  static BitmapFactory.Options d(ag paramag)
  {
    boolean bool = paramag.c();
    if (paramag.o != null) {}
    for (int i = 1;; i = 0)
    {
      Object localObject = null;
      if ((bool) || (i != 0) || (paramag.n))
      {
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = bool;
        localOptions.inInputShareable = paramag.n;
        localOptions.inPurgeable = paramag.n;
        localObject = localOptions;
        if (i != 0)
        {
          localOptions.inPreferredConfig = paramag.o;
          localObject = localOptions;
        }
      }
      return (BitmapFactory.Options)localObject;
    }
  }
  
  int a()
  {
    return 0;
  }
  
  boolean a(NetworkInfo paramNetworkInfo)
  {
    return false;
  }
  
  public abstract boolean a(ag paramag);
  
  public abstract a b(ag paramag);
  
  boolean b()
  {
    return false;
  }
  
  public static final class a
  {
    private final aa.d a;
    private final Bitmap b;
    private final InputStream c;
    private final int d;
    
    public a(Bitmap paramBitmap, aa.d paramd)
    {
      this((Bitmap)at.a(paramBitmap, "bitmap == null"), null, paramd, 0);
    }
    
    a(Bitmap paramBitmap, InputStream paramInputStream, aa.d paramd, int paramInt)
    {
      int i;
      if (paramBitmap != null)
      {
        i = 1;
        if (paramInputStream == null) {
          break label40;
        }
      }
      for (;;)
      {
        if ((j ^ i) != 0) {
          break label46;
        }
        throw new AssertionError();
        i = 0;
        break;
        label40:
        j = 0;
      }
      label46:
      this.b = paramBitmap;
      this.c = paramInputStream;
      this.a = ((aa.d)at.a(paramd, "loadedFrom == null"));
      this.d = paramInt;
    }
    
    public a(InputStream paramInputStream, aa.d paramd)
    {
      this(null, (InputStream)at.a(paramInputStream, "stream == null"), paramd, 0);
    }
    
    public final Bitmap a()
    {
      return this.b;
    }
    
    public final InputStream b()
    {
      return this.c;
    }
    
    public final aa.d c()
    {
      return this.a;
    }
    
    final int d()
    {
      return this.d;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */