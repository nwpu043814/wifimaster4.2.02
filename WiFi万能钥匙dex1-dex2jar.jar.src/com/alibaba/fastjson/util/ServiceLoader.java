package com.alibaba.fastjson.util;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ServiceLoader
{
  private static final String PREFIX = "META-INF/services/";
  private static final Set<String> loadedUrls = new HashSet();
  
  public static <T> Set<T> load(Class<T> paramClass, ClassLoader paramClassLoader)
  {
    if (paramClassLoader == null) {
      paramClass = Collections.emptySet();
    }
    for (;;)
    {
      return paramClass;
      HashSet localHashSet = new HashSet();
      paramClass = paramClass.getName();
      Object localObject = "META-INF/services/" + paramClass;
      paramClass = new HashSet();
      try
      {
        Enumeration localEnumeration = paramClassLoader.getResources((String)localObject);
        while (localEnumeration.hasMoreElements())
        {
          localObject = (URL)localEnumeration.nextElement();
          if (!loadedUrls.contains(((URL)localObject).toString()))
          {
            load((URL)localObject, paramClass);
            loadedUrls.add(((URL)localObject).toString());
          }
        }
      }
      catch (IOException localIOException)
      {
        paramClass = paramClass.iterator();
        while (paramClass.hasNext())
        {
          String str = (String)paramClass.next();
          try
          {
            localHashSet.add(paramClassLoader.loadClass(str).newInstance());
          }
          catch (Exception localException) {}
        }
        paramClass = localHashSet;
      }
    }
  }
  
  /* Error */
  public static void load(URL paramURL, Set<String> paramSet)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_0
    //   3: invokevirtual 110	java/net/URL:openStream	()Ljava/io/InputStream;
    //   6: astore_0
    //   7: new 112	java/io/BufferedReader
    //   10: astore 5
    //   12: new 114	java/io/InputStreamReader
    //   15: astore_3
    //   16: aload_3
    //   17: aload_0
    //   18: ldc 116
    //   20: invokespecial 119	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   23: aload 5
    //   25: aload_3
    //   26: invokespecial 122	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   29: aload 5
    //   31: invokevirtual 125	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   34: astore 4
    //   36: aload 4
    //   38: ifnull +69 -> 107
    //   41: aload 4
    //   43: bipush 35
    //   45: invokevirtual 129	java/lang/String:indexOf	(I)I
    //   48: istore_2
    //   49: aload 4
    //   51: astore_3
    //   52: iload_2
    //   53: iflt +11 -> 64
    //   56: aload 4
    //   58: iconst_0
    //   59: iload_2
    //   60: invokevirtual 133	java/lang/String:substring	(II)Ljava/lang/String;
    //   63: astore_3
    //   64: aload_3
    //   65: invokevirtual 136	java/lang/String:trim	()Ljava/lang/String;
    //   68: astore_3
    //   69: aload_3
    //   70: invokevirtual 140	java/lang/String:length	()I
    //   73: ifeq -44 -> 29
    //   76: aload_1
    //   77: aload_3
    //   78: invokeinterface 83 2 0
    //   83: pop
    //   84: goto -55 -> 29
    //   87: astore 4
    //   89: aload_0
    //   90: astore_3
    //   91: aload 5
    //   93: astore_1
    //   94: aload 4
    //   96: astore_0
    //   97: aload_1
    //   98: invokestatic 146	com/alibaba/fastjson/util/IOUtils:close	(Ljava/io/Closeable;)V
    //   101: aload_3
    //   102: invokestatic 146	com/alibaba/fastjson/util/IOUtils:close	(Ljava/io/Closeable;)V
    //   105: aload_0
    //   106: athrow
    //   107: aload 5
    //   109: invokestatic 146	com/alibaba/fastjson/util/IOUtils:close	(Ljava/io/Closeable;)V
    //   112: aload_0
    //   113: invokestatic 146	com/alibaba/fastjson/util/IOUtils:close	(Ljava/io/Closeable;)V
    //   116: return
    //   117: astore_0
    //   118: aconst_null
    //   119: astore_1
    //   120: goto -23 -> 97
    //   123: astore_1
    //   124: aconst_null
    //   125: astore 4
    //   127: aload_0
    //   128: astore_3
    //   129: aload_1
    //   130: astore_0
    //   131: aload 4
    //   133: astore_1
    //   134: goto -37 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramURL	URL
    //   0	137	1	paramSet	Set<String>
    //   48	12	2	i	int
    //   1	128	3	localObject1	Object
    //   34	23	4	str	String
    //   87	8	4	localObject2	Object
    //   125	7	4	localObject3	Object
    //   10	98	5	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   29	36	87	finally
    //   41	49	87	finally
    //   56	64	87	finally
    //   64	84	87	finally
    //   2	7	117	finally
    //   7	29	123	finally
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/util/ServiceLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */