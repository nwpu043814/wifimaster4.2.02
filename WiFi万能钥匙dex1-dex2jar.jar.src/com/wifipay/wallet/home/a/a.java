package com.wifipay.wallet.home.a;

import java.io.File;

public class a
{
  private final String a = ".zip";
  private final String b = "_tmp";
  private b c = new b();
  
  private String a(String paramString)
  {
    return paramString + "_tmp.zip";
  }
  
  private boolean a(File paramFile, String paramString)
  {
    if (paramFile != null) {}
    for (boolean bool = this.c.a(paramFile, paramString);; bool = false) {
      return bool;
    }
  }
  
  /* Error */
  public boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 51	java/net/URL
    //   3: astore 4
    //   5: aload 4
    //   7: aload_1
    //   8: invokespecial 54	java/net/URL:<init>	(Ljava/lang/String;)V
    //   11: aload 4
    //   13: invokevirtual 58	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   16: invokevirtual 64	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   19: astore 5
    //   21: new 66	java/io/File
    //   24: astore_1
    //   25: aload_1
    //   26: aload_2
    //   27: invokestatic 68	com/wifipay/wallet/home/a/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   30: aload_0
    //   31: aload_2
    //   32: invokespecial 69	com/wifipay/wallet/home/a/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   35: invokespecial 72	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_1
    //   39: invokevirtual 76	java/io/File:exists	()Z
    //   42: ifne +8 -> 50
    //   45: aload_1
    //   46: invokevirtual 79	java/io/File:createNewFile	()Z
    //   49: pop
    //   50: new 81	java/io/FileOutputStream
    //   53: astore 4
    //   55: aload 4
    //   57: aload_1
    //   58: invokespecial 84	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   61: sipush 4096
    //   64: newarray <illegal type>
    //   66: astore 6
    //   68: aload 5
    //   70: aload 6
    //   72: invokevirtual 90	java/io/InputStream:read	([B)I
    //   75: istore_3
    //   76: iload_3
    //   77: iconst_m1
    //   78: if_icmpeq +23 -> 101
    //   81: aload 4
    //   83: aload 6
    //   85: iconst_0
    //   86: iload_3
    //   87: invokevirtual 94	java/io/FileOutputStream:write	([BII)V
    //   90: aload 5
    //   92: aload 6
    //   94: invokevirtual 90	java/io/InputStream:read	([B)I
    //   97: istore_3
    //   98: goto -22 -> 76
    //   101: aload 4
    //   103: invokevirtual 97	java/io/FileOutputStream:flush	()V
    //   106: aload 4
    //   108: invokevirtual 100	java/io/FileOutputStream:close	()V
    //   111: aload 5
    //   113: invokevirtual 101	java/io/InputStream:close	()V
    //   116: aload_0
    //   117: aload_1
    //   118: aload_2
    //   119: invokespecial 102	com/wifipay/wallet/home/a/a:a	(Ljava/io/File;Ljava/lang/String;)Z
    //   122: ireturn
    //   123: astore 4
    //   125: aconst_null
    //   126: astore_1
    //   127: aload 4
    //   129: invokevirtual 105	java/net/MalformedURLException:printStackTrace	()V
    //   132: goto -16 -> 116
    //   135: astore 4
    //   137: aconst_null
    //   138: astore_1
    //   139: aload 4
    //   141: invokevirtual 106	java/io/IOException:printStackTrace	()V
    //   144: goto -28 -> 116
    //   147: astore 4
    //   149: goto -10 -> 139
    //   152: astore 4
    //   154: goto -27 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	a
    //   0	157	1	paramString1	String
    //   0	157	2	paramString2	String
    //   75	23	3	i	int
    //   3	104	4	localObject	Object
    //   123	5	4	localMalformedURLException1	java.net.MalformedURLException
    //   135	5	4	localIOException1	java.io.IOException
    //   147	1	4	localIOException2	java.io.IOException
    //   152	1	4	localMalformedURLException2	java.net.MalformedURLException
    //   19	93	5	localInputStream	java.io.InputStream
    //   66	27	6	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	38	123	java/net/MalformedURLException
    //   0	38	135	java/io/IOException
    //   38	50	147	java/io/IOException
    //   50	76	147	java/io/IOException
    //   81	98	147	java/io/IOException
    //   101	116	147	java/io/IOException
    //   38	50	152	java/net/MalformedURLException
    //   50	76	152	java/net/MalformedURLException
    //   81	98	152	java/net/MalformedURLException
    //   101	116	152	java/net/MalformedURLException
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */