package com.wifipay.wallet.home.a;

import com.wifipay.wallet.common.utils.f;
import java.io.File;

public class b
  extends c
{
  private final String a = ".zip";
  private final String b = ".tmp";
  private final String c = "desc";
  
  public static String a()
  {
    return c("wallet_webapp/webapp/");
  }
  
  public static String a(String paramString)
  {
    paramString = new File(a() + File.separator + paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    return paramString.getAbsolutePath();
  }
  
  /* Error */
  private boolean b(File paramFile1, File paramFile2)
  {
    // Byte code:
    //   0: sipush 8192
    //   3: newarray <illegal type>
    //   5: astore 6
    //   7: new 66	java/util/zip/ZipFile
    //   10: astore 5
    //   12: aload 5
    //   14: aload_1
    //   15: invokespecial 69	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   18: aload 5
    //   20: astore_1
    //   21: aload 5
    //   23: invokevirtual 73	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   26: astore 7
    //   28: aload 5
    //   30: astore_1
    //   31: aload 7
    //   33: invokeinterface 78 1 0
    //   38: ifeq +250 -> 288
    //   41: aload 5
    //   43: astore_1
    //   44: aload 7
    //   46: invokeinterface 82 1 0
    //   51: checkcast 84	java/util/zip/ZipEntry
    //   54: astore 9
    //   56: aload 5
    //   58: astore_1
    //   59: new 33	java/io/File
    //   62: astore 8
    //   64: aload 5
    //   66: astore_1
    //   67: new 35	java/lang/StringBuilder
    //   70: astore 10
    //   72: aload 5
    //   74: astore_1
    //   75: aload 10
    //   77: invokespecial 36	java/lang/StringBuilder:<init>	()V
    //   80: aload 5
    //   82: astore_1
    //   83: aload 8
    //   85: aload 10
    //   87: aload_2
    //   88: invokevirtual 61	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   91: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: getstatic 45	java/io/File:separator	Ljava/lang/String;
    //   97: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: aload 9
    //   102: invokevirtual 87	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   105: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokespecial 51	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: aload 5
    //   116: astore_1
    //   117: aload 9
    //   119: invokevirtual 90	java/util/zip/ZipEntry:isDirectory	()Z
    //   122: ifeq +43 -> 165
    //   125: aload 5
    //   127: astore_1
    //   128: aload 8
    //   130: invokevirtual 58	java/io/File:mkdirs	()Z
    //   133: pop
    //   134: goto -106 -> 28
    //   137: astore_1
    //   138: aload 5
    //   140: astore_2
    //   141: aload_1
    //   142: astore 5
    //   144: aload_2
    //   145: astore_1
    //   146: aload 5
    //   148: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   151: aload_2
    //   152: ifnull +7 -> 159
    //   155: aload_2
    //   156: invokevirtual 96	java/util/zip/ZipFile:close	()V
    //   159: iconst_0
    //   160: istore 4
    //   162: iload 4
    //   164: ireturn
    //   165: aload 5
    //   167: astore_1
    //   168: aload 8
    //   170: invokevirtual 100	java/io/File:getParentFile	()Ljava/io/File;
    //   173: invokevirtual 55	java/io/File:exists	()Z
    //   176: ifne +15 -> 191
    //   179: aload 5
    //   181: astore_1
    //   182: aload 8
    //   184: invokevirtual 100	java/io/File:getParentFile	()Ljava/io/File;
    //   187: invokevirtual 58	java/io/File:mkdirs	()Z
    //   190: pop
    //   191: aload 5
    //   193: astore_1
    //   194: new 102	java/io/FileOutputStream
    //   197: astore 10
    //   199: aload 5
    //   201: astore_1
    //   202: aload 10
    //   204: aload 8
    //   206: invokespecial 103	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   209: aload 5
    //   211: astore_1
    //   212: aload 5
    //   214: aload 9
    //   216: invokevirtual 107	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   219: astore 8
    //   221: aload 5
    //   223: astore_1
    //   224: aload 8
    //   226: aload 6
    //   228: invokevirtual 113	java/io/InputStream:read	([B)I
    //   231: istore_3
    //   232: iload_3
    //   233: ifle +36 -> 269
    //   236: aload 5
    //   238: astore_1
    //   239: aload 10
    //   241: aload 6
    //   243: iconst_0
    //   244: iload_3
    //   245: invokevirtual 119	java/io/OutputStream:write	([BII)V
    //   248: goto -27 -> 221
    //   251: astore_2
    //   252: aload_1
    //   253: astore 5
    //   255: aload_2
    //   256: astore_1
    //   257: aload 5
    //   259: ifnull +8 -> 267
    //   262: aload 5
    //   264: invokevirtual 96	java/util/zip/ZipFile:close	()V
    //   267: aload_1
    //   268: athrow
    //   269: aload 5
    //   271: astore_1
    //   272: aload 10
    //   274: invokevirtual 120	java/io/OutputStream:close	()V
    //   277: aload 5
    //   279: astore_1
    //   280: aload 8
    //   282: invokevirtual 121	java/io/InputStream:close	()V
    //   285: goto -257 -> 28
    //   288: aload 5
    //   290: invokevirtual 96	java/util/zip/ZipFile:close	()V
    //   293: iconst_1
    //   294: istore 4
    //   296: goto -134 -> 162
    //   299: astore_1
    //   300: aload_1
    //   301: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   304: goto -11 -> 293
    //   307: astore_1
    //   308: aload_1
    //   309: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   312: goto -153 -> 159
    //   315: astore_2
    //   316: aload_2
    //   317: invokevirtual 93	java/io/IOException:printStackTrace	()V
    //   320: goto -53 -> 267
    //   323: astore_1
    //   324: aconst_null
    //   325: astore 5
    //   327: goto -70 -> 257
    //   330: astore 5
    //   332: aconst_null
    //   333: astore_2
    //   334: goto -190 -> 144
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	337	0	this	b
    //   0	337	1	paramFile1	File
    //   0	337	2	paramFile2	File
    //   231	14	3	i	int
    //   160	135	4	bool	boolean
    //   10	316	5	localObject1	Object
    //   330	1	5	localIOException	java.io.IOException
    //   5	237	6	arrayOfByte	byte[]
    //   26	19	7	localEnumeration	java.util.Enumeration
    //   62	219	8	localObject2	Object
    //   54	161	9	localZipEntry	java.util.zip.ZipEntry
    //   70	203	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   21	28	137	java/io/IOException
    //   31	41	137	java/io/IOException
    //   44	56	137	java/io/IOException
    //   59	64	137	java/io/IOException
    //   67	72	137	java/io/IOException
    //   75	80	137	java/io/IOException
    //   83	114	137	java/io/IOException
    //   117	125	137	java/io/IOException
    //   128	134	137	java/io/IOException
    //   168	179	137	java/io/IOException
    //   182	191	137	java/io/IOException
    //   194	199	137	java/io/IOException
    //   202	209	137	java/io/IOException
    //   212	221	137	java/io/IOException
    //   224	232	137	java/io/IOException
    //   239	248	137	java/io/IOException
    //   272	277	137	java/io/IOException
    //   280	285	137	java/io/IOException
    //   21	28	251	finally
    //   31	41	251	finally
    //   44	56	251	finally
    //   59	64	251	finally
    //   67	72	251	finally
    //   75	80	251	finally
    //   83	114	251	finally
    //   117	125	251	finally
    //   128	134	251	finally
    //   146	151	251	finally
    //   168	179	251	finally
    //   182	191	251	finally
    //   194	199	251	finally
    //   202	209	251	finally
    //   212	221	251	finally
    //   224	232	251	finally
    //   239	248	251	finally
    //   272	277	251	finally
    //   280	285	251	finally
    //   288	293	299	java/io/IOException
    //   155	159	307	java/io/IOException
    //   262	267	315	java/io/IOException
    //   7	18	323	finally
    //   7	18	330	java/io/IOException
  }
  
  private String e(String paramString)
  {
    return paramString + ".zip";
  }
  
  public boolean a(File paramFile, String paramString)
  {
    if (b(paramFile, paramString)) {}
    for (boolean bool = b(paramString);; bool = false) {
      return bool;
    }
  }
  
  public boolean b(File paramFile, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (f.a(paramFile))
    {
      if (paramFile.exists()) {
        break label25;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      label25:
      File localFile = new File(a(paramString), e(paramString) + ".tmp");
      bool1 = bool2;
      if (a(paramFile, localFile))
      {
        paramFile.delete();
        paramFile = new File(a(paramString), e(paramString));
        if (paramFile.exists()) {
          paramFile.delete();
        }
        bool1 = localFile.renameTo(paramFile);
      }
    }
  }
  
  public boolean b(String paramString)
  {
    boolean bool2 = false;
    Object localObject = new File(a(paramString));
    paramString = new File(a(paramString), "desc");
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
    localObject = ((File)localObject).listFiles();
    int j = localObject.length;
    for (int i = 0;; i++)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        File localFile = localObject[i];
        if ((localFile != null) && (localFile.isFile()) && (!localFile.getName().endsWith(".tmp"))) {
          bool1 = b(localFile, paramString);
        }
      }
      else
      {
        return bool1;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */