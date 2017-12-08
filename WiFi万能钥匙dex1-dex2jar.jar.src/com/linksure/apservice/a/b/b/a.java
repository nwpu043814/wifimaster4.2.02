package com.linksure.apservice.a.b.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.bluefay.b.i;
import com.linksure.apservice.utils.j;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public final class a
  implements com.linksure.apservice.a.b.c
{
  public static final String a = com.linksure.apservice.integration.photochoose.b.a().c() + File.separator + "WifiMasterKey" + File.separator + "aps";
  public static final String b = a + File.separator + "thumb";
  public static final String c = a + File.separator + "origin";
  public static final String d = a + File.separator + "cache";
  private int e;
  private int f;
  private int g;
  private int h;
  private Context i;
  
  public a(Context paramContext)
  {
    this.i = paramContext;
    File localFile = new File(a);
    if ((!localFile.exists()) && (!localFile.isDirectory())) {
      localFile.mkdirs();
    }
    localFile = new File(b);
    if ((!localFile.exists()) && (!localFile.isDirectory())) {
      localFile.mkdir();
    }
    localFile = new File(c);
    if ((!localFile.exists()) && (!localFile.isDirectory())) {
      localFile.mkdir();
    }
    localFile = new File(d);
    if ((!localFile.exists()) && (!localFile.isDirectory())) {
      localFile.mkdir();
    }
    int j = j.a(paramContext);
    int k = j.b(paramContext);
    this.e = (j / 4);
    this.f = (k / 4);
    this.g = j;
    this.h = k;
  }
  
  private static void a(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (Exception paramInputStream)
    {
      for (;;) {}
    }
  }
  
  private static void a(OutputStream paramOutputStream)
  {
    if (paramOutputStream != null) {}
    try
    {
      paramOutputStream.flush();
      paramOutputStream.close();
      return;
    }
    catch (Exception paramOutputStream)
    {
      for (;;) {}
    }
  }
  
  private static void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    Object localObject = bluefay.a.a.a(paramString1);
    if ((((BitmapFactory.Options)localObject).outWidth <= paramInt1) && (((BitmapFactory.Options)localObject).outHeight <= paramInt2)) {
      d(paramString1, paramString2);
    }
    for (;;)
    {
      return;
      int m = ((BitmapFactory.Options)localObject).outHeight;
      int n = ((BitmapFactory.Options)localObject).outWidth;
      int k = 1;
      int j = 1;
      if ((m > paramInt2) || (n > paramInt1))
      {
        m /= 2;
        n /= 2;
        for (;;)
        {
          k = j;
          if (m / j <= paramInt2) {
            break;
          }
          k = j;
          if (n / j <= paramInt1) {
            break;
          }
          j *= 2;
        }
      }
      ((BitmapFactory.Options)localObject).inSampleSize = k;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      paramString1 = BitmapFactory.decodeFile(paramString1, (BitmapFactory.Options)localObject);
      localObject = new ByteArrayOutputStream();
      paramString1.compress(Bitmap.CompressFormat.JPEG, 100, (OutputStream)localObject);
      System.out.println(((ByteArrayOutputStream)localObject).toByteArray().length);
      for (paramInt1 = 100; ((ByteArrayOutputStream)localObject).toByteArray().length / 1024 > paramInt3; paramInt1 -= 10)
      {
        ((ByteArrayOutputStream)localObject).reset();
        paramString1.compress(Bitmap.CompressFormat.JPEG, paramInt1, (OutputStream)localObject);
      }
      com.linksure.apservice.a.f.c.a((ByteArrayOutputStream)localObject, paramString2);
      paramString1.recycle();
    }
  }
  
  private String b(String paramString1, String paramString2)
  {
    paramString1 = b + File.separator + d(paramString1);
    try
    {
      a(paramString2, paramString1, this.e, this.f, 100);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
      throw new com.linksure.apservice.a.d.a.a("fail to create thumb: " + paramString1.getMessage());
    }
  }
  
  private String c(String paramString1, String paramString2)
  {
    paramString1 = c + File.separator + d(paramString1);
    try
    {
      a(paramString2, paramString1, this.g, this.h, 500);
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      paramString1.printStackTrace();
      throw new com.linksure.apservice.a.d.a.b("fail to create origin: " + paramString1.getMessage());
    }
  }
  
  private static String d(String paramString)
  {
    return i.a(paramString) + ".jpg";
  }
  
  /* Error */
  private static void d(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 221	java/io/BufferedInputStream
    //   8: astore_2
    //   9: new 223	java/io/FileInputStream
    //   12: astore 5
    //   14: new 39	java/io/File
    //   17: astore 6
    //   19: aload 6
    //   21: aload_0
    //   22: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: aload 5
    //   27: aload 6
    //   29: invokespecial 226	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: aload_2
    //   33: aload 5
    //   35: invokespecial 228	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   38: new 230	java/io/BufferedOutputStream
    //   41: astore_0
    //   42: new 232	java/io/FileOutputStream
    //   45: astore 5
    //   47: new 39	java/io/File
    //   50: astore 4
    //   52: aload 4
    //   54: aload_1
    //   55: invokespecial 71	java/io/File:<init>	(Ljava/lang/String;)V
    //   58: aload 5
    //   60: aload 4
    //   62: invokespecial 233	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   65: aload_0
    //   66: aload 5
    //   68: invokespecial 235	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   71: aload_2
    //   72: aload_0
    //   73: invokestatic 240	bluefay/a/c:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   76: pop
    //   77: aload_2
    //   78: invokestatic 242	com/linksure/apservice/a/b/b/a:a	(Ljava/io/InputStream;)V
    //   81: aload_0
    //   82: invokestatic 244	com/linksure/apservice/a/b/b/a:a	(Ljava/io/OutputStream;)V
    //   85: return
    //   86: astore_2
    //   87: aconst_null
    //   88: astore_0
    //   89: aload 4
    //   91: astore_1
    //   92: aload_2
    //   93: invokevirtual 245	java/lang/Exception:printStackTrace	()V
    //   96: aload_1
    //   97: invokestatic 242	com/linksure/apservice/a/b/b/a:a	(Ljava/io/InputStream;)V
    //   100: aload_0
    //   101: invokestatic 244	com/linksure/apservice/a/b/b/a:a	(Ljava/io/OutputStream;)V
    //   104: goto -19 -> 85
    //   107: astore_0
    //   108: aconst_null
    //   109: astore_2
    //   110: aload_3
    //   111: astore_1
    //   112: aload_2
    //   113: invokestatic 242	com/linksure/apservice/a/b/b/a:a	(Ljava/io/InputStream;)V
    //   116: aload_1
    //   117: invokestatic 244	com/linksure/apservice/a/b/b/a:a	(Ljava/io/OutputStream;)V
    //   120: aload_0
    //   121: athrow
    //   122: astore_0
    //   123: aload_3
    //   124: astore_1
    //   125: goto -13 -> 112
    //   128: astore_1
    //   129: aload_0
    //   130: astore_3
    //   131: aload_1
    //   132: astore_0
    //   133: aload_3
    //   134: astore_1
    //   135: goto -23 -> 112
    //   138: astore_3
    //   139: aload_1
    //   140: astore_2
    //   141: aload_0
    //   142: astore_1
    //   143: aload_3
    //   144: astore_0
    //   145: goto -33 -> 112
    //   148: astore_0
    //   149: aconst_null
    //   150: astore_3
    //   151: aload_2
    //   152: astore_1
    //   153: aload_0
    //   154: astore_2
    //   155: aload_3
    //   156: astore_0
    //   157: goto -65 -> 92
    //   160: astore_3
    //   161: aload_2
    //   162: astore_1
    //   163: aload_3
    //   164: astore_2
    //   165: goto -73 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	168	0	paramString1	String
    //   0	168	1	paramString2	String
    //   8	70	2	localBufferedInputStream	java.io.BufferedInputStream
    //   86	7	2	localException1	Exception
    //   109	56	2	localObject1	Object
    //   1	133	3	str	String
    //   138	6	3	localObject2	Object
    //   150	6	3	localObject3	Object
    //   160	4	3	localException2	Exception
    //   3	87	4	localFile1	File
    //   12	55	5	localObject4	Object
    //   17	11	6	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   5	38	86	java/lang/Exception
    //   5	38	107	finally
    //   38	71	122	finally
    //   71	77	128	finally
    //   92	96	138	finally
    //   38	71	148	java/lang/Exception
    //   71	77	160	java/lang/Exception
  }
  
  public final String a(String paramString)
  {
    com.linksure.apservice.a.f.a.a(paramString);
    return b(paramString + System.currentTimeMillis(), paramString);
  }
  
  public final String a(String paramString1, String paramString2)
  {
    com.linksure.apservice.a.f.a.a(paramString2);
    String str = d + File.separator + d(paramString1);
    paramString1 = new File(paramString2);
    paramString1.setWritable(true);
    if (!paramString1.renameTo(new File(str)))
    {
      d(paramString2, str);
      new File(paramString2).delete();
    }
    return str;
  }
  
  public final String b(String paramString)
  {
    com.linksure.apservice.a.f.a.a(paramString);
    return c(paramString + System.currentTimeMillis(), paramString);
  }
  
  public final String c(String paramString)
  {
    Object localObject = null;
    if (paramString == null) {
      paramString = (String)localObject;
    }
    for (;;)
    {
      return paramString;
      paramString = d(paramString);
      String str = d + File.separator + paramString;
      paramString = (String)localObject;
      if (new File(str).exists()) {
        paramString = str;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/b/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */