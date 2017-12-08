package com.wifipay.wallet.home.widget.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class e
  implements SmartImage
{
  private static f b;
  public String a;
  private int c;
  
  public e(String paramString)
  {
    this.a = paramString;
  }
  
  public e(String paramString, int paramInt)
  {
    this.a = paramString;
    this.c = paramInt;
  }
  
  private Bitmap a(String paramString)
  {
    try
    {
      URL localURL = new java/net/URL;
      localURL.<init>(paramString);
      paramString = localURL.openConnection();
      paramString.setConnectTimeout(5000);
      paramString.setReadTimeout(10000);
      paramString = BitmapFactory.decodeStream((InputStream)paramString.getContent());
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  public Bitmap getBitmap(Context paramContext)
  {
    if (b == null) {
      b = new f(paramContext);
    }
    Object localObject = null;
    if (this.a != null)
    {
      Bitmap localBitmap = b.a(this.a);
      localObject = localBitmap;
      if (localBitmap == null)
      {
        localObject = a(this.a);
        if (localObject == null) {
          break label69;
        }
        b.a(this.a, (Bitmap)localObject);
      }
    }
    for (;;)
    {
      return (Bitmap)localObject;
      label69:
      if (this.c != 0) {
        localObject = BitmapFactory.decodeResource(paramContext.getResources(), this.c);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/widget/image/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */