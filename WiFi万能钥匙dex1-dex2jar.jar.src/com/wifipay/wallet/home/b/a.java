package com.wifipay.wallet.home.b;

import com.wifipay.wallet.home.a.b;
import java.io.File;

public class a
{
  public static int a = 10000;
  public static String b;
  private static a c = new a();
  private File d;
  
  private a()
  {
    b = b.a() + File.separator + "cache";
    this.d = new File(b);
    if (!this.d.exists()) {
      this.d.mkdirs();
    }
  }
  
  public static a a()
  {
    return c;
  }
  
  public static boolean a(File paramFile, int paramInt)
  {
    boolean bool = true;
    if (System.currentTimeMillis() - paramFile.lastModified() > paramInt) {}
    for (;;)
    {
      return bool;
      if (paramFile.exists()) {
        bool = false;
      }
    }
  }
  
  /* Error */
  public com.wifipay.wallet.home.net.dto.HomeInfoResp a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 37	java/io/File
    //   5: astore 4
    //   7: aload 4
    //   9: getstatic 47	com/wifipay/wallet/home/b/a:b	Ljava/lang/String;
    //   12: aload_1
    //   13: invokestatic 81	com/shengpay/crypto/JNICrypto:sdpEnc1	(Ljava/lang/String;)Ljava/lang/String;
    //   16: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: new 86	java/io/FileInputStream
    //   22: astore_2
    //   23: aload_2
    //   24: aload 4
    //   26: invokespecial 89	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   29: aload_2
    //   30: astore_1
    //   31: new 91	java/io/ObjectInputStream
    //   34: astore_3
    //   35: aload_2
    //   36: astore_1
    //   37: aload_3
    //   38: aload_2
    //   39: invokespecial 94	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   42: aload_2
    //   43: astore_1
    //   44: aload_3
    //   45: invokevirtual 98	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   48: checkcast 100	com/wifipay/wallet/home/net/dto/HomeInfoResp
    //   51: astore_3
    //   52: aload_2
    //   53: invokevirtual 103	java/io/FileInputStream:close	()V
    //   56: aload_3
    //   57: astore_1
    //   58: aload_1
    //   59: areturn
    //   60: astore_1
    //   61: aload_1
    //   62: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   65: aload_3
    //   66: astore_1
    //   67: goto -9 -> 58
    //   70: astore_3
    //   71: aconst_null
    //   72: astore_2
    //   73: aload_2
    //   74: astore_1
    //   75: aload_3
    //   76: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   79: aload_2
    //   80: ifnull +7 -> 87
    //   83: aload_2
    //   84: invokevirtual 103	java/io/FileInputStream:close	()V
    //   87: aconst_null
    //   88: astore_1
    //   89: goto -31 -> 58
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   97: goto -10 -> 87
    //   100: astore_1
    //   101: aload_3
    //   102: astore_2
    //   103: aload_2
    //   104: ifnull +7 -> 111
    //   107: aload_2
    //   108: invokevirtual 103	java/io/FileInputStream:close	()V
    //   111: aload_1
    //   112: athrow
    //   113: astore_2
    //   114: aload_2
    //   115: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   118: goto -7 -> 111
    //   121: astore_3
    //   122: aload_1
    //   123: astore_2
    //   124: aload_3
    //   125: astore_1
    //   126: goto -23 -> 103
    //   129: astore_3
    //   130: goto -57 -> 73
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	a
    //   0	133	1	paramString	String
    //   22	86	2	localObject1	Object
    //   113	2	2	localIOException	java.io.IOException
    //   123	1	2	str	String
    //   1	65	3	localObject2	Object
    //   70	32	3	localException1	Exception
    //   121	4	3	localObject3	Object
    //   129	1	3	localException2	Exception
    //   5	20	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   52	56	60	java/io/IOException
    //   2	29	70	java/lang/Exception
    //   83	87	92	java/io/IOException
    //   2	29	100	finally
    //   107	111	113	java/io/IOException
    //   31	35	121	finally
    //   37	42	121	finally
    //   44	52	121	finally
    //   75	79	121	finally
    //   31	35	129	java/lang/Exception
    //   37	42	129	java/lang/Exception
    //   44	52	129	java/lang/Exception
  }
  
  /* Error */
  public boolean a(String paramString, Object paramObject)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 6
    //   8: astore 4
    //   10: aload_0
    //   11: getfield 52	com/wifipay/wallet/home/b/a:d	Ljava/io/File;
    //   14: invokevirtual 56	java/io/File:exists	()Z
    //   17: ifne +46 -> 63
    //   20: aload 6
    //   22: astore 4
    //   24: new 37	java/io/File
    //   27: astore 7
    //   29: aload 6
    //   31: astore 4
    //   33: aload 7
    //   35: getstatic 47	com/wifipay/wallet/home/b/a:b	Ljava/lang/String;
    //   38: invokespecial 50	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: aload 6
    //   43: astore 4
    //   45: aload_0
    //   46: aload 7
    //   48: putfield 52	com/wifipay/wallet/home/b/a:d	Ljava/io/File;
    //   51: aload 6
    //   53: astore 4
    //   55: aload_0
    //   56: getfield 52	com/wifipay/wallet/home/b/a:d	Ljava/io/File;
    //   59: invokevirtual 59	java/io/File:mkdirs	()Z
    //   62: pop
    //   63: aload 6
    //   65: astore 4
    //   67: new 37	java/io/File
    //   70: astore 7
    //   72: aload 6
    //   74: astore 4
    //   76: aload 7
    //   78: getstatic 47	com/wifipay/wallet/home/b/a:b	Ljava/lang/String;
    //   81: aload_1
    //   82: invokestatic 81	com/shengpay/crypto/JNICrypto:sdpEnc1	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokespecial 84	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: aload 6
    //   90: astore 4
    //   92: new 110	java/io/FileOutputStream
    //   95: astore_1
    //   96: aload 6
    //   98: astore 4
    //   100: aload_1
    //   101: aload 7
    //   103: invokespecial 111	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   106: new 113	java/io/ObjectOutputStream
    //   109: astore 4
    //   111: aload 4
    //   113: aload_1
    //   114: invokespecial 116	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   117: aload 4
    //   119: aload_2
    //   120: invokevirtual 120	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   123: aload_1
    //   124: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   127: iconst_1
    //   128: istore_3
    //   129: iload_3
    //   130: ireturn
    //   131: astore_1
    //   132: aload_1
    //   133: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   136: goto -9 -> 127
    //   139: astore_2
    //   140: aload 5
    //   142: astore_1
    //   143: aload_1
    //   144: astore 4
    //   146: aload_2
    //   147: invokevirtual 107	java/lang/Exception:printStackTrace	()V
    //   150: aload_1
    //   151: ifnull +7 -> 158
    //   154: aload_1
    //   155: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   158: iconst_0
    //   159: istore_3
    //   160: goto -31 -> 129
    //   163: astore_1
    //   164: aload_1
    //   165: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   168: goto -10 -> 158
    //   171: astore_1
    //   172: aload 4
    //   174: ifnull +8 -> 182
    //   177: aload 4
    //   179: invokevirtual 121	java/io/FileOutputStream:close	()V
    //   182: aload_1
    //   183: athrow
    //   184: astore_2
    //   185: aload_2
    //   186: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   189: goto -7 -> 182
    //   192: astore_2
    //   193: aload_1
    //   194: astore 4
    //   196: aload_2
    //   197: astore_1
    //   198: goto -26 -> 172
    //   201: astore_2
    //   202: goto -59 -> 143
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	205	0	this	a
    //   0	205	1	paramString	String
    //   0	205	2	paramObject	Object
    //   128	32	3	bool	boolean
    //   8	187	4	localObject1	Object
    //   4	137	5	localObject2	Object
    //   1	96	6	localObject3	Object
    //   27	75	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   123	127	131	java/io/IOException
    //   10	20	139	java/lang/Exception
    //   24	29	139	java/lang/Exception
    //   33	41	139	java/lang/Exception
    //   45	51	139	java/lang/Exception
    //   55	63	139	java/lang/Exception
    //   67	72	139	java/lang/Exception
    //   76	88	139	java/lang/Exception
    //   92	96	139	java/lang/Exception
    //   100	106	139	java/lang/Exception
    //   154	158	163	java/io/IOException
    //   10	20	171	finally
    //   24	29	171	finally
    //   33	41	171	finally
    //   45	51	171	finally
    //   55	63	171	finally
    //   67	72	171	finally
    //   76	88	171	finally
    //   92	96	171	finally
    //   100	106	171	finally
    //   146	150	171	finally
    //   177	182	184	java/io/IOException
    //   106	123	192	finally
    //   106	123	201	java/lang/Exception
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */