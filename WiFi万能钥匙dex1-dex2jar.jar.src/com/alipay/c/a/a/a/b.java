package com.alipay.c.a.a.a;

public final class b
{
  /* Error */
  public static String a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 12	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 16	java/lang/StringBuilder:<init>	()V
    //   11: astore 4
    //   13: new 18	java/io/File
    //   16: astore 5
    //   18: aload 5
    //   20: aload_0
    //   21: aload_1
    //   22: invokespecial 21	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: aload 5
    //   27: invokevirtual 25	java/io/File:exists	()Z
    //   30: ifne +7 -> 37
    //   33: aload_3
    //   34: astore_0
    //   35: aload_0
    //   36: areturn
    //   37: new 27	java/io/BufferedReader
    //   40: astore_0
    //   41: new 29	java/io/InputStreamReader
    //   44: astore_1
    //   45: new 31	java/io/FileInputStream
    //   48: astore_3
    //   49: aload_3
    //   50: aload 5
    //   52: invokespecial 34	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   55: aload_1
    //   56: aload_3
    //   57: ldc 36
    //   59: invokespecial 39	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   62: aload_0
    //   63: aload_1
    //   64: invokespecial 42	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   67: aload_0
    //   68: invokevirtual 46	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   71: astore_1
    //   72: aload_1
    //   73: ifnull +31 -> 104
    //   76: aload 4
    //   78: aload_1
    //   79: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: goto -16 -> 67
    //   86: astore_1
    //   87: aload_0
    //   88: ifnull +7 -> 95
    //   91: aload_0
    //   92: invokevirtual 53	java/io/BufferedReader:close	()V
    //   95: aload 4
    //   97: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   100: astore_0
    //   101: goto -66 -> 35
    //   104: aload_0
    //   105: invokevirtual 53	java/io/BufferedReader:close	()V
    //   108: goto -13 -> 95
    //   111: astore_0
    //   112: goto -17 -> 95
    //   115: astore_1
    //   116: aconst_null
    //   117: astore_0
    //   118: aload_0
    //   119: ifnull +7 -> 126
    //   122: aload_0
    //   123: invokevirtual 53	java/io/BufferedReader:close	()V
    //   126: aload_1
    //   127: athrow
    //   128: astore_0
    //   129: goto -34 -> 95
    //   132: astore_0
    //   133: goto -7 -> 126
    //   136: astore_1
    //   137: goto -19 -> 118
    //   140: astore_0
    //   141: aload_2
    //   142: astore_0
    //   143: goto -56 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramString1	String
    //   0	146	1	paramString2	String
    //   1	141	2	localObject	Object
    //   3	54	3	localFileInputStream	java.io.FileInputStream
    //   11	85	4	localStringBuilder	StringBuilder
    //   16	35	5	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   67	72	86	java/io/IOException
    //   76	83	86	java/io/IOException
    //   104	108	111	java/lang/Throwable
    //   13	33	115	finally
    //   37	67	115	finally
    //   91	95	128	java/lang/Throwable
    //   122	126	132	java/lang/Throwable
    //   67	72	136	finally
    //   76	83	136	finally
    //   13	33	140	java/io/IOException
    //   37	67	140	java/io/IOException
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/c/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */