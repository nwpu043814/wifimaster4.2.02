package com.wifipay.wallet.home.widget.image;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class f
{
  private ConcurrentHashMap<String, SoftReference<Bitmap>> a = new ConcurrentHashMap();
  private String b;
  private boolean c = false;
  private ExecutorService d;
  
  public f(Context paramContext)
  {
    paramContext = paramContext.getApplicationContext();
    this.b = (paramContext.getCacheDir().getAbsolutePath() + "/web_image_cache/");
    paramContext = new File(this.b);
    paramContext.mkdirs();
    this.c = paramContext.exists();
    this.d = Executors.newSingleThreadExecutor();
  }
  
  private Bitmap b(String paramString)
  {
    paramString = (SoftReference)this.a.get(e(paramString));
    if (paramString != null) {}
    for (paramString = (Bitmap)paramString.get();; paramString = null) {
      return paramString;
    }
  }
  
  private void b(String paramString, Bitmap paramBitmap)
  {
    this.a.put(e(paramString), new SoftReference(paramBitmap));
  }
  
  private Bitmap c(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.c)
    {
      paramString = d(paramString);
      localObject1 = localObject2;
      if (new File(paramString).exists()) {
        localObject1 = BitmapFactory.decodeFile(paramString);
      }
    }
    return (Bitmap)localObject1;
  }
  
  private void c(String paramString, Bitmap paramBitmap)
  {
    this.d.execute(new g(this, paramString, paramBitmap));
  }
  
  private String d(String paramString)
  {
    return this.b + e(paramString);
  }
  
  private String e(String paramString)
  {
    if (paramString == null) {
      throw new RuntimeException("Null url passed in");
    }
    return paramString.replaceAll("[.:/,%?&=]", "+").replaceAll("[+]+", "+");
  }
  
  public Bitmap a(String paramString)
  {
    Bitmap localBitmap2 = b(paramString);
    Bitmap localBitmap1 = localBitmap2;
    if (localBitmap2 == null)
    {
      localBitmap2 = c(paramString);
      localBitmap1 = localBitmap2;
      if (localBitmap2 != null)
      {
        b(paramString, localBitmap2);
        localBitmap1 = localBitmap2;
      }
    }
    return localBitmap1;
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    b(paramString, paramBitmap);
    c(paramString, paramBitmap);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/widget/image/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */