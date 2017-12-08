package com.wifipay.wallet.home.a;

import android.content.Context;
import android.os.Environment;
import com.wifipay.wallet.common.info.AppInfo;
import com.wifipay.wallet.common.utils.f;
import java.io.File;

public class c
{
  private static String a()
  {
    if (c()) {}
    for (File localFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath());; localFile = AppInfo.INSTANCE.getContext().getCacheDir())
    {
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return localFile.getAbsolutePath();
    }
  }
  
  private static File b()
  {
    if (f.a(AppInfo.INSTANCE.getContext())) {}
    for (File localFile = AppInfo.INSTANCE.getContext().getDir("", 0);; localFile = new File("")) {
      return localFile;
    }
  }
  
  public static String c(String paramString)
  {
    return a() + d(paramString);
  }
  
  private static boolean c()
  {
    if (Environment.getExternalStorageState().equals("mounted")) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String d(String paramString)
  {
    return new File(b(), paramString).getAbsolutePath();
  }
  
  /* Error */
  public boolean a(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: iconst_0
    //   4: istore 5
    //   6: new 100	java/io/FileInputStream
    //   9: astore 6
    //   11: aload 6
    //   13: aload_1
    //   14: invokespecial 103	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   17: new 105	java/io/FileOutputStream
    //   20: astore_1
    //   21: aload_1
    //   22: aload_2
    //   23: invokespecial 106	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   26: sipush 2048
    //   29: newarray <illegal type>
    //   31: astore_2
    //   32: aload 6
    //   34: aload_2
    //   35: iconst_0
    //   36: sipush 2048
    //   39: invokevirtual 112	java/io/InputStream:read	([BII)I
    //   42: istore_3
    //   43: iload_3
    //   44: ifle +54 -> 98
    //   47: aload_1
    //   48: aload_2
    //   49: iconst_0
    //   50: iload_3
    //   51: invokevirtual 118	java/io/OutputStream:write	([BII)V
    //   54: goto -22 -> 32
    //   57: astore 7
    //   59: aload 6
    //   61: astore_2
    //   62: aload 7
    //   64: astore 6
    //   66: aload 6
    //   68: invokevirtual 121	java/lang/Exception:printStackTrace	()V
    //   71: aload_2
    //   72: ifnull +7 -> 79
    //   75: aload_2
    //   76: invokevirtual 124	java/io/InputStream:close	()V
    //   79: iload 5
    //   81: istore 4
    //   83: aload_1
    //   84: ifnull +11 -> 95
    //   87: aload_1
    //   88: invokevirtual 125	java/io/OutputStream:close	()V
    //   91: iload 5
    //   93: istore 4
    //   95: iload 4
    //   97: ireturn
    //   98: aload_1
    //   99: invokevirtual 128	java/io/OutputStream:flush	()V
    //   102: aload_1
    //   103: invokevirtual 125	java/io/OutputStream:close	()V
    //   106: aload 6
    //   108: invokevirtual 124	java/io/InputStream:close	()V
    //   111: iconst_1
    //   112: istore 4
    //   114: goto -19 -> 95
    //   117: astore_1
    //   118: aload_1
    //   119: invokevirtual 129	java/io/IOException:printStackTrace	()V
    //   122: iload 5
    //   124: istore 4
    //   126: goto -31 -> 95
    //   129: astore_2
    //   130: aconst_null
    //   131: astore_1
    //   132: aconst_null
    //   133: astore 6
    //   135: aload 6
    //   137: ifnull +8 -> 145
    //   140: aload 6
    //   142: invokevirtual 124	java/io/InputStream:close	()V
    //   145: aload_1
    //   146: ifnull +7 -> 153
    //   149: aload_1
    //   150: invokevirtual 125	java/io/OutputStream:close	()V
    //   153: aload_2
    //   154: athrow
    //   155: astore_1
    //   156: aload_1
    //   157: invokevirtual 129	java/io/IOException:printStackTrace	()V
    //   160: goto -7 -> 153
    //   163: astore_2
    //   164: aconst_null
    //   165: astore_1
    //   166: goto -31 -> 135
    //   169: astore_2
    //   170: goto -35 -> 135
    //   173: astore 7
    //   175: aload_2
    //   176: astore 6
    //   178: aload 7
    //   180: astore_2
    //   181: goto -46 -> 135
    //   184: astore 6
    //   186: aconst_null
    //   187: astore_1
    //   188: aload 7
    //   190: astore_2
    //   191: goto -125 -> 66
    //   194: astore_1
    //   195: aconst_null
    //   196: astore 7
    //   198: aload 6
    //   200: astore_2
    //   201: aload_1
    //   202: astore 6
    //   204: aload 7
    //   206: astore_1
    //   207: goto -141 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	c
    //   0	210	1	paramFile1	File
    //   0	210	2	paramFile2	File
    //   42	9	3	i	int
    //   81	44	4	bool1	boolean
    //   4	119	5	bool2	boolean
    //   9	168	6	localObject1	Object
    //   184	15	6	localException1	Exception
    //   202	1	6	localFile	File
    //   1	1	7	localObject2	Object
    //   57	6	7	localException2	Exception
    //   173	16	7	localObject3	Object
    //   196	9	7	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   26	32	57	java/lang/Exception
    //   32	43	57	java/lang/Exception
    //   47	54	57	java/lang/Exception
    //   98	106	57	java/lang/Exception
    //   75	79	117	java/io/IOException
    //   87	91	117	java/io/IOException
    //   6	17	129	finally
    //   140	145	155	java/io/IOException
    //   149	153	155	java/io/IOException
    //   17	26	163	finally
    //   106	111	163	finally
    //   26	32	169	finally
    //   32	43	169	finally
    //   47	54	169	finally
    //   98	106	169	finally
    //   66	71	173	finally
    //   6	17	184	java/lang/Exception
    //   17	26	194	java/lang/Exception
    //   106	111	194	java/lang/Exception
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */