package com.lantern.dm.a;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class c
{
  private static c a = null;
  private d b = new d();
  private a c = new b();
  private Map<ImageView, String> d = Collections.synchronizedMap(new WeakHashMap());
  private ExecutorService e = Executors.newFixedThreadPool(5);
  
  private static Bitmap a(File paramFile)
  {
    int j = 1;
    localObject1 = null;
    try
    {
      Object localObject2 = new android/graphics/BitmapFactory$Options;
      ((BitmapFactory.Options)localObject2).<init>();
      ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
      Object localObject3 = new java/io/FileInputStream;
      ((FileInputStream)localObject3).<init>(paramFile);
      BitmapFactory.decodeStream((InputStream)localObject3, null, (BitmapFactory.Options)localObject2);
      int k = ((BitmapFactory.Options)localObject2).outWidth;
      int i = ((BitmapFactory.Options)localObject2).outHeight;
      while ((k / 2 >= 100) && (i / 2 >= 100))
      {
        k /= 2;
        i /= 2;
        j *= 2;
      }
      localObject3 = new android/graphics/BitmapFactory$Options;
      ((BitmapFactory.Options)localObject3).<init>();
      ((BitmapFactory.Options)localObject3).inSampleSize = j;
      localObject2 = new java/io/FileInputStream;
      ((FileInputStream)localObject2).<init>(paramFile);
      paramFile = BitmapFactory.decodeStream((InputStream)localObject2, null, (BitmapFactory.Options)localObject3);
    }
    catch (FileNotFoundException paramFile)
    {
      for (;;)
      {
        paramFile.printStackTrace();
        paramFile = (File)localObject1;
      }
    }
    return paramFile;
  }
  
  public static c a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        c localc = new com/lantern/dm/a/c;
        localc.<init>();
        a = localc;
      }
      return a;
    }
    finally {}
  }
  
  private static void a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    try
    {
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte, 0, 1024);
        if (i == -1) {
          break;
        }
        paramOutputStream.write(arrayOfByte, 0, i);
      }
      return;
    }
    catch (Exception paramInputStream)
    {
      paramInputStream.printStackTrace();
    }
  }
  
  public final Bitmap a(String paramString)
  {
    File localFile = new File(this.c.a(paramString));
    if (localFile.exists()) {}
    for (Object localObject = a(localFile);; localObject = null)
    {
      if (localObject != null) {}
      for (;;)
      {
        return (Bitmap)localObject;
        try
        {
          localObject = new java/net/URL;
          ((URL)localObject).<init>(paramString);
          paramString = (HttpURLConnection)((URL)localObject).openConnection();
          paramString.setConnectTimeout(50000);
          paramString.setReadTimeout(50000);
          paramString.setInstanceFollowRedirects(true);
          localObject = paramString.getInputStream();
          paramString = new java/io/FileOutputStream;
          paramString.<init>(localFile);
          a((InputStream)localObject, paramString);
          paramString.close();
          localObject = a(localFile);
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
          localObject = null;
        }
      }
    }
  }
  
  public final void a(String paramString, ImageView paramImageView)
  {
    this.d.put(paramImageView, paramString);
    Bitmap localBitmap = this.b.a(paramString);
    if (localBitmap != null) {
      paramImageView.setImageBitmap(localBitmap);
    }
    for (;;)
    {
      return;
      paramString = new b(paramString, paramImageView);
      this.e.submit(new c(paramString));
    }
  }
  
  private final class a
    implements Runnable
  {
    Bitmap a;
    c.b b;
    
    public a(Bitmap paramBitmap, c.b paramb)
    {
      this.a = paramBitmap;
      this.b = paramb;
    }
    
    public final void run()
    {
      if (c.a(c.this, this.b)) {}
      for (;;)
      {
        return;
        if (this.a != null) {
          this.b.b.setImageBitmap(this.a);
        }
      }
    }
  }
  
  private final class b
  {
    public String a;
    public ImageView b;
    
    public b(String paramString, ImageView paramImageView)
    {
      this.a = paramString;
      this.b = paramImageView;
    }
  }
  
  private final class c
    implements Runnable
  {
    c.b a;
    
    c(c.b paramb)
    {
      this.a = paramb;
    }
    
    public final void run()
    {
      if (c.a(c.this, this.a)) {}
      for (;;)
      {
        return;
        Object localObject = c.this.a(this.a.a);
        c.a(c.this).a(this.a.a, (Bitmap)localObject);
        if (!c.a(c.this, this.a))
        {
          localObject = new c.a(c.this, (Bitmap)localObject, this.a);
          ((Activity)this.a.b.getContext()).runOnUiThread((Runnable)localObject);
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */