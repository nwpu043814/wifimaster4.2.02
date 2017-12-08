package com.lantern.push.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class d
{
  private static d a = null;
  private Handler b = new Handler(Looper.getMainLooper());
  private c c = new c();
  private a d = new b();
  private Map<b, String> e = Collections.synchronizedMap(new WeakHashMap());
  private ExecutorService f = Executors.newFixedThreadPool(5);
  
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
    catch (Throwable paramFile)
    {
      for (;;)
      {
        paramFile.printStackTrace();
        paramFile = (File)localObject1;
      }
    }
    return paramFile;
  }
  
  public static d a()
  {
    if (a == null) {}
    try
    {
      if (a == null)
      {
        d locald = new com/lantern/push/a/d;
        locald.<init>();
        a = locald;
      }
      return a;
    }
    finally {}
  }
  
  private static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      for (;;)
      {
        paramCloseable.printStackTrace();
      }
    }
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
  
  /* Error */
  public final Bitmap a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 180	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: getfield 56	com/lantern/push/a/d:d	Lcom/lantern/push/a/a;
    //   11: aload_1
    //   12: invokevirtual 185	com/lantern/push/a/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   15: invokespecial 188	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore 5
    //   20: aload 5
    //   22: invokevirtual 192	java/io/File:exists	()Z
    //   25: ifeq +176 -> 201
    //   28: aload 5
    //   30: invokestatic 194	com/lantern/push/a/d:a	(Ljava/io/File;)Landroid/graphics/Bitmap;
    //   33: astore_2
    //   34: aload_2
    //   35: ifnull +5 -> 40
    //   38: aload_2
    //   39: areturn
    //   40: new 196	java/net/URL
    //   43: astore_2
    //   44: aload_2
    //   45: aload_1
    //   46: invokespecial 197	java/net/URL:<init>	(Ljava/lang/String;)V
    //   49: aload_2
    //   50: invokevirtual 201	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   53: checkcast 203	java/net/HttpURLConnection
    //   56: astore_1
    //   57: aload_1
    //   58: ldc -52
    //   60: invokevirtual 208	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   63: aload_1
    //   64: ldc -52
    //   66: invokevirtual 211	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   69: aload_1
    //   70: iconst_1
    //   71: invokevirtual 215	java/net/HttpURLConnection:setInstanceFollowRedirects	(Z)V
    //   74: aload_1
    //   75: invokevirtual 219	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   78: astore_1
    //   79: new 221	java/io/FileOutputStream
    //   82: astore_2
    //   83: aload_2
    //   84: aload 5
    //   86: invokespecial 222	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   89: aload_2
    //   90: astore 4
    //   92: aload_1
    //   93: astore_3
    //   94: aload_1
    //   95: aload_2
    //   96: invokestatic 224	com/lantern/push/a/d:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   99: aload_2
    //   100: astore 4
    //   102: aload_1
    //   103: astore_3
    //   104: aload_2
    //   105: invokevirtual 225	java/io/OutputStream:close	()V
    //   108: aload_2
    //   109: astore 4
    //   111: aload_1
    //   112: astore_3
    //   113: aload 5
    //   115: invokestatic 194	com/lantern/push/a/d:a	(Ljava/io/File;)Landroid/graphics/Bitmap;
    //   118: astore 5
    //   120: aload 5
    //   122: astore_3
    //   123: aload_2
    //   124: invokestatic 227	com/lantern/push/a/d:a	(Ljava/io/Closeable;)V
    //   127: aload_1
    //   128: invokestatic 227	com/lantern/push/a/d:a	(Ljava/io/Closeable;)V
    //   131: aload_3
    //   132: astore_2
    //   133: goto -95 -> 38
    //   136: astore 5
    //   138: aconst_null
    //   139: astore_2
    //   140: aconst_null
    //   141: astore_1
    //   142: aload_2
    //   143: astore 4
    //   145: aload_1
    //   146: astore_3
    //   147: aload 5
    //   149: invokevirtual 111	java/lang/Throwable:printStackTrace	()V
    //   152: aload_2
    //   153: invokestatic 227	com/lantern/push/a/d:a	(Ljava/io/Closeable;)V
    //   156: aload_1
    //   157: invokestatic 227	com/lantern/push/a/d:a	(Ljava/io/Closeable;)V
    //   160: aconst_null
    //   161: astore_2
    //   162: goto -124 -> 38
    //   165: astore_2
    //   166: aconst_null
    //   167: astore_1
    //   168: aload 4
    //   170: invokestatic 227	com/lantern/push/a/d:a	(Ljava/io/Closeable;)V
    //   173: aload_1
    //   174: invokestatic 227	com/lantern/push/a/d:a	(Ljava/io/Closeable;)V
    //   177: aload_2
    //   178: athrow
    //   179: astore_2
    //   180: goto -12 -> 168
    //   183: astore_2
    //   184: aload_3
    //   185: astore_1
    //   186: goto -18 -> 168
    //   189: astore 5
    //   191: aconst_null
    //   192: astore_2
    //   193: goto -51 -> 142
    //   196: astore 5
    //   198: goto -56 -> 142
    //   201: aconst_null
    //   202: astore_2
    //   203: goto -169 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	d
    //   0	206	1	paramString	String
    //   33	129	2	localObject1	Object
    //   165	13	2	localObject2	Object
    //   179	1	2	localObject3	Object
    //   183	1	2	localObject4	Object
    //   192	11	2	localObject5	Object
    //   93	92	3	localObject6	Object
    //   1	168	4	localObject7	Object
    //   18	103	5	localObject8	Object
    //   136	12	5	localThrowable1	Throwable
    //   189	1	5	localThrowable2	Throwable
    //   196	1	5	localThrowable3	Throwable
    // Exception table:
    //   from	to	target	type
    //   40	79	136	java/lang/Throwable
    //   40	79	165	finally
    //   79	89	179	finally
    //   94	99	183	finally
    //   104	108	183	finally
    //   113	120	183	finally
    //   147	152	183	finally
    //   79	89	189	java/lang/Throwable
    //   94	99	196	java/lang/Throwable
    //   104	108	196	java/lang/Throwable
    //   113	120	196	java/lang/Throwable
  }
  
  public final void a(String paramString, ImageView paramImageView)
  {
    b localb = new b(paramImageView);
    this.e.put(localb, paramString);
    paramImageView = this.c.a(paramString);
    if (paramImageView != null) {
      if (b.a(localb) != null) {
        b.a(localb).setImageBitmap(paramImageView);
      }
    }
    for (;;)
    {
      return;
      paramString = new d(paramString, localb);
      this.f.submit(new e(paramString));
    }
  }
  
  private final class a
    implements Runnable
  {
    Bitmap a;
    d.d b;
    
    public a(Bitmap paramBitmap, d.d paramd)
    {
      this.a = paramBitmap;
      this.b = paramd;
    }
    
    public final void run()
    {
      if (d.a(d.this, this.b)) {}
      for (;;)
      {
        return;
        if (this.a != null)
        {
          ImageView localImageView = d.b.a(this.b.b);
          if (localImageView != null) {
            localImageView.setImageBitmap(this.a);
          }
        }
      }
    }
  }
  
  public static final class b
  {
    private ImageView a;
    
    public b() {}
    
    public b(ImageView paramImageView)
    {
      this.a = paramImageView;
    }
  }
  
  public static abstract interface c {}
  
  private final class d
  {
    public String a;
    public d.b b;
    public d.c c;
    
    public d(String paramString, d.b paramb)
    {
      this.a = paramString;
      this.b = paramb;
      this.c = null;
    }
  }
  
  private final class e
    implements Runnable
  {
    d.d a;
    
    e(d.d paramd)
    {
      this.a = paramd;
    }
    
    public final void run()
    {
      if (d.a(d.this, this.a)) {}
      for (;;)
      {
        return;
        Bitmap localBitmap = d.this.a(this.a.a);
        if (localBitmap != null)
        {
          d.a(d.this).a(this.a.a, localBitmap);
          if (d.a(d.this, this.a)) {
            continue;
          }
          if (d.b.a(this.a.b) != null)
          {
            d.a locala = new d.a(d.this, localBitmap, this.a);
            d.a(d.this, locala);
          }
        }
        if (this.a.c != null) {
          d.a(d.this, new e(this, localBitmap));
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/push/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */