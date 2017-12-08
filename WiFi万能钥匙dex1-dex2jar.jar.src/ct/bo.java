package ct;

import android.content.Context;
import android.os.Bundle;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.InputStream;

final class bo
  extends bm
{
  final Context a;
  
  public bo(Context paramContext, String paramString)
  {
    super(paramString, "load libtencentloc.so myself");
    this.a = paramContext;
    new bo.1(this).start();
  }
  
  private static void a(InputStream paramInputStream, BufferedOutputStream paramBufferedOutputStream)
  {
    if ((paramInputStream == null) || (paramBufferedOutputStream == null)) {
      return;
    }
    byte[] arrayOfByte = new byte['က'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramBufferedOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  protected final boolean a(Bundle paramBundle)
  {
    boolean bool = true;
    paramBundle = new File(this.a.getFilesDir(), "libtencentloc.so");
    int i;
    if ((paramBundle.exists()) && (paramBundle.length() > 0L)) {
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        paramBundle.delete();
        b();
      }
      try
      {
        System.load(paramBundle.getAbsolutePath());
        return bool;
        i = 0;
      }
      catch (Error localError)
      {
        for (;;)
        {
          b.a.a("PluginLoadSo", "doWork0: load file(p=" + paramBundle.getAbsolutePath() + ",l=" + paramBundle.length() + ") failed", localError);
          bool = false;
        }
      }
    }
  }
  
  /* Error */
  final void b()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 7
    //   6: new 43	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: getfield 15	ct/bo:a	Landroid/content/Context;
    //   14: invokevirtual 49	android/content/Context:getFilesDir	()Ljava/io/File;
    //   17: ldc 51
    //   19: invokespecial 54	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   22: astore_3
    //   23: aload_0
    //   24: getfield 15	ct/bo:a	Landroid/content/Context;
    //   27: invokevirtual 111	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   30: ldc 113
    //   32: invokevirtual 119	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   35: astore_2
    //   36: new 34	java/io/BufferedOutputStream
    //   39: astore_1
    //   40: new 121	java/io/FileOutputStream
    //   43: astore 4
    //   45: aload 4
    //   47: aload_3
    //   48: invokespecial 124	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   51: aload_1
    //   52: aload 4
    //   54: invokespecial 127	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   57: aload_1
    //   58: astore 5
    //   60: aload_2
    //   61: astore 6
    //   63: aload_2
    //   64: aload_1
    //   65: invokestatic 129	ct/bo:a	(Ljava/io/InputStream;Ljava/io/BufferedOutputStream;)V
    //   68: aload_1
    //   69: invokestatic 132	ct/b$a:a	(Ljava/io/Closeable;)V
    //   72: aload_2
    //   73: invokestatic 132	ct/b$a:a	(Ljava/io/Closeable;)V
    //   76: return
    //   77: astore_3
    //   78: aconst_null
    //   79: astore_1
    //   80: aconst_null
    //   81: astore 4
    //   83: aload_1
    //   84: astore 5
    //   86: aload 4
    //   88: astore 6
    //   90: ldc 80
    //   92: ldc -122
    //   94: aload_3
    //   95: invokestatic 105	ct/b$a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   98: aload_1
    //   99: astore 5
    //   101: aload 4
    //   103: astore 6
    //   105: new 43	java/io/File
    //   108: astore 9
    //   110: aload_1
    //   111: astore 5
    //   113: aload 4
    //   115: astore 6
    //   117: aload 9
    //   119: aload_0
    //   120: getfield 15	ct/bo:a	Landroid/content/Context;
    //   123: invokevirtual 49	android/content/Context:getFilesDir	()Ljava/io/File;
    //   126: ldc 51
    //   128: invokespecial 54	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   131: aload_0
    //   132: invokevirtual 140	java/lang/Object:getClass	()Ljava/lang/Class;
    //   135: ldc -114
    //   137: invokevirtual 147	java/lang/Class:getResourceAsStream	(Ljava/lang/String;)Ljava/io/InputStream;
    //   140: astore_2
    //   141: new 34	java/io/BufferedOutputStream
    //   144: astore_3
    //   145: new 121	java/io/FileOutputStream
    //   148: astore 5
    //   150: aload 5
    //   152: aload 9
    //   154: invokespecial 124	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   157: aload_3
    //   158: aload 5
    //   160: invokespecial 127	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   163: aload_2
    //   164: aload_3
    //   165: invokestatic 129	ct/bo:a	(Ljava/io/InputStream;Ljava/io/BufferedOutputStream;)V
    //   168: aload_1
    //   169: astore 5
    //   171: aload 4
    //   173: astore 6
    //   175: aload_3
    //   176: invokestatic 132	ct/b$a:a	(Ljava/io/Closeable;)V
    //   179: aload_1
    //   180: astore 5
    //   182: aload 4
    //   184: astore 6
    //   186: aload_2
    //   187: invokestatic 132	ct/b$a:a	(Ljava/io/Closeable;)V
    //   190: aload_1
    //   191: invokestatic 132	ct/b$a:a	(Ljava/io/Closeable;)V
    //   194: aload 4
    //   196: invokestatic 132	ct/b$a:a	(Ljava/io/Closeable;)V
    //   199: goto -123 -> 76
    //   202: astore_3
    //   203: aconst_null
    //   204: astore_2
    //   205: ldc 80
    //   207: ldc -107
    //   209: aload_3
    //   210: invokestatic 105	ct/b$a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   213: aload_1
    //   214: astore 5
    //   216: aload 4
    //   218: astore 6
    //   220: aload 7
    //   222: invokestatic 132	ct/b$a:a	(Ljava/io/Closeable;)V
    //   225: aload_1
    //   226: astore 5
    //   228: aload 4
    //   230: astore 6
    //   232: aload_2
    //   233: invokestatic 132	ct/b$a:a	(Ljava/io/Closeable;)V
    //   236: goto -46 -> 190
    //   239: astore_1
    //   240: aload 6
    //   242: astore_2
    //   243: aload 5
    //   245: invokestatic 132	ct/b$a:a	(Ljava/io/Closeable;)V
    //   248: aload_2
    //   249: invokestatic 132	ct/b$a:a	(Ljava/io/Closeable;)V
    //   252: aload_1
    //   253: athrow
    //   254: astore_3
    //   255: aconst_null
    //   256: astore_2
    //   257: aload 8
    //   259: astore 7
    //   261: aload_1
    //   262: astore 5
    //   264: aload 4
    //   266: astore 6
    //   268: aload 7
    //   270: invokestatic 132	ct/b$a:a	(Ljava/io/Closeable;)V
    //   273: aload_1
    //   274: astore 5
    //   276: aload 4
    //   278: astore 6
    //   280: aload_2
    //   281: invokestatic 132	ct/b$a:a	(Ljava/io/Closeable;)V
    //   284: aload_1
    //   285: astore 5
    //   287: aload 4
    //   289: astore 6
    //   291: aload_3
    //   292: athrow
    //   293: astore_1
    //   294: aconst_null
    //   295: astore 5
    //   297: aconst_null
    //   298: astore_2
    //   299: goto -56 -> 243
    //   302: astore_1
    //   303: aconst_null
    //   304: astore 5
    //   306: goto -63 -> 243
    //   309: astore_3
    //   310: aload 8
    //   312: astore 7
    //   314: goto -53 -> 261
    //   317: astore 5
    //   319: aload_3
    //   320: astore 7
    //   322: aload 5
    //   324: astore_3
    //   325: goto -64 -> 261
    //   328: astore_3
    //   329: goto -68 -> 261
    //   332: astore_3
    //   333: goto -128 -> 205
    //   336: astore 5
    //   338: aload_3
    //   339: astore 7
    //   341: aload 5
    //   343: astore_3
    //   344: goto -139 -> 205
    //   347: astore_3
    //   348: aconst_null
    //   349: astore_1
    //   350: aload_2
    //   351: astore 4
    //   353: goto -270 -> 83
    //   356: astore_3
    //   357: aload_2
    //   358: astore 4
    //   360: goto -277 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	363	0	this	bo
    //   39	187	1	localBufferedOutputStream1	BufferedOutputStream
    //   239	46	1	localObject1	Object
    //   293	1	1	localObject2	Object
    //   302	1	1	localObject3	Object
    //   349	1	1	localObject4	Object
    //   35	323	2	localObject5	Object
    //   22	26	3	localFile1	File
    //   77	18	3	localIOException1	java.io.IOException
    //   144	32	3	localBufferedOutputStream2	BufferedOutputStream
    //   202	8	3	localIOException2	java.io.IOException
    //   254	38	3	localObject6	Object
    //   309	11	3	localObject7	Object
    //   324	1	3	localObject8	Object
    //   328	1	3	localObject9	Object
    //   332	7	3	localIOException3	java.io.IOException
    //   343	1	3	localObject10	Object
    //   347	1	3	localIOException4	java.io.IOException
    //   356	1	3	localIOException5	java.io.IOException
    //   43	316	4	localObject11	Object
    //   58	247	5	localObject12	Object
    //   317	6	5	localObject13	Object
    //   336	6	5	localIOException6	java.io.IOException
    //   61	229	6	localObject14	Object
    //   4	336	7	localObject15	Object
    //   1	310	8	localObject16	Object
    //   108	45	9	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   23	36	77	java/io/IOException
    //   131	141	202	java/io/IOException
    //   63	68	239	finally
    //   90	98	239	finally
    //   105	110	239	finally
    //   117	131	239	finally
    //   175	179	239	finally
    //   186	190	239	finally
    //   220	225	239	finally
    //   232	236	239	finally
    //   268	273	239	finally
    //   280	284	239	finally
    //   291	293	239	finally
    //   131	141	254	finally
    //   23	36	293	finally
    //   36	57	302	finally
    //   141	163	309	finally
    //   163	168	317	finally
    //   205	213	328	finally
    //   141	163	332	java/io/IOException
    //   163	168	336	java/io/IOException
    //   36	57	347	java/io/IOException
    //   63	68	356	java/io/IOException
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/bo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */