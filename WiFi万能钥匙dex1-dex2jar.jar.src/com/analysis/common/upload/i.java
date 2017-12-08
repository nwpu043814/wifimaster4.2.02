package com.analysis.common.upload;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;

public final class i
{
  private static final long b = 10485760L;
  private static final Object c = new Object();
  private static i e = null;
  File a;
  private Context d;
  
  private i(Context paramContext)
  {
    this.d = paramContext.getApplicationContext();
    this.a = new File(this.d.getFilesDir(), ".analytics");
    if (!this.a.exists()) {
      this.a.mkdirs();
    }
  }
  
  public static i a(Context paramContext)
  {
    int i;
    if (e == null)
    {
      i = 0;
      if (i == 0) {
        break label23;
      }
      paramContext = e;
    }
    for (;;)
    {
      return paramContext;
      i = 1;
      break;
      label23:
      if (com.analysis.common.tools.c.a(e)) {}
      synchronized (c)
      {
        if (com.analysis.common.tools.c.a(e))
        {
          i locali = new com/analysis/common/upload/i;
          locali.<init>(paramContext);
          e = locali;
        }
        paramContext = e;
      }
    }
  }
  
  public static String a(File paramFile)
  {
    if ((com.analysis.common.tools.c.a(paramFile)) || (!paramFile.exists())) {}
    StringBuilder localStringBuilder;
    for (paramFile = null;; paramFile = localStringBuilder.toString())
    {
      return paramFile;
      paramFile = new BufferedReader(new FileReader(paramFile));
      localStringBuilder = new StringBuilder();
      for (;;)
      {
        String str = paramFile.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str.trim());
      }
      paramFile.close();
    }
  }
  
  /* Error */
  static void a(File paramFile, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore_2
    //   4: aload_1
    //   5: invokestatic 103	com/analysis/common/tools/c:a	(Ljava/lang/String;)Z
    //   8: ifne +10 -> 18
    //   11: aload_0
    //   12: invokestatic 61	com/analysis/common/tools/c:a	(Ljava/lang/Object;)Z
    //   15: ifeq +4 -> 19
    //   18: return
    //   19: new 105	java/io/FileOutputStream
    //   22: astore 4
    //   24: aload 4
    //   26: aload_0
    //   27: iconst_1
    //   28: invokespecial 108	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   31: aload 4
    //   33: astore_0
    //   34: aload 4
    //   36: aload_1
    //   37: invokevirtual 112	java/lang/String:getBytes	()[B
    //   40: invokevirtual 116	java/io/FileOutputStream:write	([B)V
    //   43: aload 4
    //   45: astore_0
    //   46: aload 4
    //   48: invokevirtual 119	java/io/FileOutputStream:flush	()V
    //   51: aload 4
    //   53: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   56: goto -38 -> 18
    //   59: astore_0
    //   60: aload_0
    //   61: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   64: goto -46 -> 18
    //   67: astore_1
    //   68: aconst_null
    //   69: astore 4
    //   71: aload 4
    //   73: astore_0
    //   74: aload_1
    //   75: invokevirtual 124	java/io/FileNotFoundException:printStackTrace	()V
    //   78: aload 4
    //   80: ifnonnull +23 -> 103
    //   83: iload_2
    //   84: ifeq -66 -> 18
    //   87: aload 4
    //   89: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   92: goto -74 -> 18
    //   95: astore_0
    //   96: aload_0
    //   97: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   100: goto -82 -> 18
    //   103: iconst_1
    //   104: istore_2
    //   105: goto -22 -> 83
    //   108: astore_1
    //   109: aconst_null
    //   110: astore 4
    //   112: aload 4
    //   114: astore_0
    //   115: aload_1
    //   116: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   119: aload 4
    //   121: ifnonnull +25 -> 146
    //   124: iload_3
    //   125: istore_2
    //   126: iload_2
    //   127: ifeq -109 -> 18
    //   130: aload 4
    //   132: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   135: goto -117 -> 18
    //   138: astore_0
    //   139: aload_0
    //   140: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   143: goto -125 -> 18
    //   146: iconst_1
    //   147: istore_2
    //   148: goto -22 -> 126
    //   151: astore_1
    //   152: aconst_null
    //   153: astore_0
    //   154: aload_0
    //   155: ifnonnull +15 -> 170
    //   158: iconst_0
    //   159: istore_2
    //   160: iload_2
    //   161: ifeq +7 -> 168
    //   164: aload_0
    //   165: invokevirtual 120	java/io/FileOutputStream:close	()V
    //   168: aload_1
    //   169: athrow
    //   170: iconst_1
    //   171: istore_2
    //   172: goto -12 -> 160
    //   175: astore_0
    //   176: aload_0
    //   177: invokevirtual 123	java/io/IOException:printStackTrace	()V
    //   180: goto -12 -> 168
    //   183: astore_1
    //   184: goto -30 -> 154
    //   187: astore_1
    //   188: goto -76 -> 112
    //   191: astore_1
    //   192: goto -121 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	paramFile	File
    //   0	195	1	paramString	String
    //   3	169	2	i	int
    //   1	124	3	j	int
    //   22	109	4	localFileOutputStream	java.io.FileOutputStream
    // Exception table:
    //   from	to	target	type
    //   51	56	59	java/io/IOException
    //   19	31	67	java/io/FileNotFoundException
    //   87	92	95	java/io/IOException
    //   19	31	108	java/io/IOException
    //   130	135	138	java/io/IOException
    //   19	31	151	finally
    //   164	168	175	java/io/IOException
    //   34	43	183	finally
    //   46	51	183	finally
    //   74	78	183	finally
    //   115	119	183	finally
    //   34	43	187	java/io/IOException
    //   46	51	187	java/io/IOException
    //   34	43	191	java/io/FileNotFoundException
    //   46	51	191	java/io/FileNotFoundException
  }
  
  private void a(FilenameFilter paramFilenameFilter)
  {
    int j = 0;
    paramFilenameFilter = this.a.listFiles(paramFilenameFilter);
    if (paramFilenameFilter == null) {}
    for (int i = 0; (i != 0) && (paramFilenameFilter.length > 0); i = 1)
    {
      int k = paramFilenameFilter.length;
      for (i = j; i < k; i++) {
        paramFilenameFilter[i].delete();
      }
    }
  }
  
  private void a(String paramString)
  {
    if (com.analysis.common.tools.c.a(paramString)) {}
    for (;;)
    {
      return;
      String str = a();
      a(new File(this.a, str), paramString);
    }
  }
  
  private String b()
  {
    String str = null;
    Object localObject = a();
    localObject = new File(this.a, (String)localObject);
    int i;
    if ((((File)localObject).exists()) && (((File)localObject).length() > 10485760L))
    {
      i = 1;
      if (i == 0) {
        break label56;
      }
      ((File)localObject).delete();
    }
    for (;;)
    {
      return str;
      i = 0;
      break;
      label56:
      if (((File)localObject).exists()) {
        str = a((File)localObject);
      }
    }
  }
  
  private void b(String paramString)
  {
    if (com.analysis.common.tools.c.a(paramString)) {}
    for (;;)
    {
      return;
      String str = "crash_" + System.currentTimeMillis();
      a(new File(this.a, str), paramString);
    }
  }
  
  private static boolean b(File paramFile)
  {
    if ((paramFile.exists()) && (paramFile.length() > 10485760L)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void c()
  {
    int j = 0;
    File[] arrayOfFile = this.a.listFiles();
    if (arrayOfFile == null) {}
    for (int i = 0; (i != 0) && (arrayOfFile.length > 0); i = 1)
    {
      int k = arrayOfFile.length;
      for (i = j; i < k; i++) {
        arrayOfFile[i].delete();
      }
    }
  }
  
  private static String d()
  {
    return "crash_" + System.currentTimeMillis();
  }
  
  final String a()
  {
    return "log_" + com.analysis.common.c.a(this.d) + "_" + com.analysis.common.c.b(this.d);
  }
  
  public final void a(j paramj, FilenameFilter paramFilenameFilter)
  {
    int j = 0;
    if (com.analysis.common.tools.c.a(paramj)) {}
    label79:
    for (;;)
    {
      return;
      paramFilenameFilter = this.a.listFiles(paramFilenameFilter);
      if (paramFilenameFilter == null) {}
      for (int i = 0;; i = 1)
      {
        if ((i == 0) || (paramFilenameFilter.length <= 0)) {
          break label79;
        }
        int k = paramFilenameFilter.length;
        for (i = j; i < k; i++)
        {
          File localFile = paramFilenameFilter[i];
          if (paramj.a(localFile)) {
            localFile.delete();
          }
        }
        break;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/common/upload/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */