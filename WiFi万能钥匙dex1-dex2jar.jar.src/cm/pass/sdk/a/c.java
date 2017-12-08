package cm.pass.sdk.a;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.util.AbstractMap;

public class c
{
  private static AbstractMap<String, b> a;
  private static c b;
  private static Context d;
  private static String e = "UMC_SDK";
  private File c;
  
  public static c a()
  {
    try
    {
      if (b == null)
      {
        localc = new cm/pass/sdk/a/c;
        localc.<init>();
        b = localc;
      }
      c localc = b;
      return localc;
    }
    finally {}
  }
  
  private File a(File paramFile, String paramString)
  {
    if (paramString.indexOf(File.separatorChar) < 0) {
      return new File(paramFile, paramString);
    }
    throw new IllegalArgumentException("File " + paramString + " contains a path separator");
  }
  
  private File b()
  {
    try
    {
      if (this.c == null)
      {
        localFile = new java/io/File;
        localFile.<init>(Environment.getExternalStorageDirectory(), e);
        this.c = localFile;
      }
      File localFile = this.c;
      return localFile;
    }
    finally {}
  }
  
  /* Error */
  public a a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 76	cm/pass/sdk/a/c:a	Ljava/util/AbstractMap;
    //   6: ifnonnull +15 -> 21
    //   9: new 78	java/util/HashMap
    //   12: astore_3
    //   13: aload_3
    //   14: invokespecial 79	java/util/HashMap:<init>	()V
    //   17: aload_3
    //   18: putstatic 76	cm/pass/sdk/a/c:a	Ljava/util/AbstractMap;
    //   21: getstatic 76	cm/pass/sdk/a/c:a	Ljava/util/AbstractMap;
    //   24: aload_1
    //   25: invokevirtual 85	java/util/AbstractMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   28: checkcast 87	cm/pass/sdk/a/b
    //   31: astore_3
    //   32: aload_3
    //   33: ifnonnull +37 -> 70
    //   36: aload_0
    //   37: aload_1
    //   38: invokevirtual 90	cm/pass/sdk/a/c:a	(Ljava/lang/String;)Ljava/io/File;
    //   41: astore 4
    //   43: new 87	cm/pass/sdk/a/b
    //   46: astore_3
    //   47: aload_3
    //   48: aload 4
    //   50: iload_2
    //   51: invokespecial 93	cm/pass/sdk/a/b:<init>	(Ljava/io/File;I)V
    //   54: getstatic 76	cm/pass/sdk/a/c:a	Ljava/util/AbstractMap;
    //   57: aload_1
    //   58: aload_3
    //   59: invokevirtual 97	java/util/AbstractMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   62: pop
    //   63: ldc 2
    //   65: monitorexit
    //   66: aload_3
    //   67: astore_1
    //   68: aload_1
    //   69: areturn
    //   70: ldc 2
    //   72: monitorexit
    //   73: aload_3
    //   74: astore_1
    //   75: iload_2
    //   76: iconst_4
    //   77: iand
    //   78: ifeq -10 -> 68
    //   81: aload_3
    //   82: invokevirtual 99	cm/pass/sdk/a/b:b	()V
    //   85: aload_3
    //   86: astore_1
    //   87: goto -19 -> 68
    //   90: astore_1
    //   91: ldc 2
    //   93: monitorexit
    //   94: aload_1
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	c
    //   0	96	1	paramString	String
    //   0	96	2	paramInt	int
    //   12	74	3	localObject	Object
    //   41	8	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   3	21	90	finally
    //   21	32	90	finally
    //   36	66	90	finally
    //   70	73	90	finally
    //   91	94	90	finally
  }
  
  public File a(String paramString)
  {
    return a(b(), paramString + ".xml");
  }
  
  public void a(Context paramContext)
  {
    a(paramContext, e);
  }
  
  public void a(Context paramContext, String paramString)
  {
    d = paramContext.getApplicationContext();
    e = paramString;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */