package com.alipay.c.a.a.e;

import com.alipay.c.a.a.a.a;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class d
{
  private static String a = "";
  private static String b = "";
  private static String c = "";
  
  public static void a(String paramString)
  {
    try
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>();
      localArrayList.add(paramString);
      a(localArrayList);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      a = paramString1;
      b = paramString2;
      c = paramString3;
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  /* Error */
  public static void a(Throwable paramThrowable)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: new 22	java/util/ArrayList
    //   6: astore_1
    //   7: aload_1
    //   8: invokespecial 25	java/util/ArrayList:<init>	()V
    //   11: aload_0
    //   12: ifnull +46 -> 58
    //   15: new 38	java/io/StringWriter
    //   18: astore_3
    //   19: aload_3
    //   20: invokespecial 39	java/io/StringWriter:<init>	()V
    //   23: new 41	java/io/PrintWriter
    //   26: astore_2
    //   27: aload_2
    //   28: aload_3
    //   29: invokespecial 44	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   32: aload_0
    //   33: aload_2
    //   34: invokevirtual 50	java/lang/Throwable:printStackTrace	(Ljava/io/PrintWriter;)V
    //   37: aload_3
    //   38: invokevirtual 54	java/lang/Object:toString	()Ljava/lang/String;
    //   41: astore_0
    //   42: aload_1
    //   43: aload_0
    //   44: invokeinterface 31 2 0
    //   49: pop
    //   50: aload_1
    //   51: invokestatic 34	com/alipay/c/a/a/e/d:a	(Ljava/util/List;)V
    //   54: ldc 2
    //   56: monitorexit
    //   57: return
    //   58: ldc 12
    //   60: astore_0
    //   61: goto -19 -> 42
    //   64: astore_0
    //   65: ldc 2
    //   67: monitorexit
    //   68: aload_0
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	paramThrowable	Throwable
    //   6	45	1	localArrayList	ArrayList
    //   26	8	2	localPrintWriter	java.io.PrintWriter
    //   18	20	3	localStringWriter	java.io.StringWriter
    // Exception table:
    //   from	to	target	type
    //   3	11	64	finally
    //   15	42	64	finally
    //   42	54	64	finally
  }
  
  private static void a(List paramList)
  {
    StringBuffer localStringBuffer;
    Object localObject;
    try
    {
      if (!a.a(b))
      {
        boolean bool = a.a(c);
        if (!bool) {}
      }
      else
      {
        return;
      }
      localStringBuffer = new java/lang/StringBuffer;
      localStringBuffer.<init>();
      localStringBuffer.append(c);
      localObject = paramList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramList = (String)((Iterator)localObject).next();
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>(", ");
        localStringBuffer.append(paramList);
      }
      localStringBuffer.append("\n");
    }
    finally {}
    for (;;)
    {
      try
      {
        paramList = new java/io/File;
        paramList.<init>(a);
        if (!paramList.exists()) {
          paramList.mkdirs();
        }
        localObject = new java/io/File;
        ((File)localObject).<init>(a, b);
        if (!((File)localObject).exists()) {
          ((File)localObject).createNewFile();
        }
        if (((File)localObject).length() + localStringBuffer.length() > 51200L) {
          break label210;
        }
        paramList = new java/io/FileWriter;
        paramList.<init>((File)localObject, true);
        paramList.write(localStringBuffer.toString());
        paramList.flush();
        paramList.close();
      }
      catch (Exception paramList) {}
      break;
      label210:
      paramList = new FileWriter((File)localObject);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/c/a/a/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */