package com.alipay.sdk.h;

import android.content.Context;
import android.text.TextUtils;
import com.a.a.a.a.e;
import java.io.File;

public final class b
{
  private static b b;
  public Context a;
  
  public static b a()
  {
    if (b == null) {
      b = new b();
    }
    return b;
  }
  
  /* Error */
  private static String a(String[] paramArrayOfString)
  {
    // Byte code:
    //   0: new 24	java/lang/ProcessBuilder
    //   3: astore_1
    //   4: aload_1
    //   5: aload_0
    //   6: invokespecial 27	java/lang/ProcessBuilder:<init>	([Ljava/lang/String;)V
    //   9: aload_1
    //   10: iconst_0
    //   11: invokevirtual 31	java/lang/ProcessBuilder:redirectErrorStream	(Z)Ljava/lang/ProcessBuilder;
    //   14: pop
    //   15: aload_1
    //   16: invokevirtual 35	java/lang/ProcessBuilder:start	()Ljava/lang/Process;
    //   19: astore_1
    //   20: new 37	java/io/DataOutputStream
    //   23: astore_2
    //   24: aload_2
    //   25: aload_1
    //   26: invokevirtual 43	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   29: invokespecial 46	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   32: new 48	java/io/DataInputStream
    //   35: astore_0
    //   36: aload_0
    //   37: aload_1
    //   38: invokevirtual 52	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   41: invokespecial 55	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   44: aload_0
    //   45: invokevirtual 59	java/io/DataInputStream:readLine	()Ljava/lang/String;
    //   48: astore_0
    //   49: aload_2
    //   50: ldc 61
    //   52: invokevirtual 65	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   55: aload_2
    //   56: invokevirtual 68	java/io/DataOutputStream:flush	()V
    //   59: aload_1
    //   60: invokevirtual 72	java/lang/Process:waitFor	()I
    //   63: pop
    //   64: aload_1
    //   65: invokevirtual 75	java/lang/Process:destroy	()V
    //   68: aload_0
    //   69: areturn
    //   70: astore_0
    //   71: aconst_null
    //   72: astore_1
    //   73: ldc 77
    //   75: astore_0
    //   76: aload_1
    //   77: invokevirtual 75	java/lang/Process:destroy	()V
    //   80: goto -12 -> 68
    //   83: astore_1
    //   84: goto -16 -> 68
    //   87: astore_0
    //   88: aconst_null
    //   89: astore_1
    //   90: aload_1
    //   91: invokevirtual 75	java/lang/Process:destroy	()V
    //   94: aload_0
    //   95: athrow
    //   96: astore_1
    //   97: goto -29 -> 68
    //   100: astore_1
    //   101: goto -7 -> 94
    //   104: astore_0
    //   105: goto -15 -> 90
    //   108: astore_0
    //   109: ldc 77
    //   111: astore_0
    //   112: goto -36 -> 76
    //   115: astore_2
    //   116: goto -40 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	paramArrayOfString	String[]
    //   3	74	1	localObject1	Object
    //   83	1	1	localException1	Exception
    //   89	2	1	localObject2	Object
    //   96	1	1	localException2	Exception
    //   100	1	1	localException3	Exception
    //   23	33	2	localDataOutputStream	java.io.DataOutputStream
    //   115	1	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   0	20	70	java/lang/Throwable
    //   76	80	83	java/lang/Exception
    //   0	20	87	finally
    //   64	68	96	java/lang/Exception
    //   90	94	100	java/lang/Exception
    //   20	49	104	finally
    //   49	64	104	finally
    //   20	49	108	java/lang/Throwable
    //   49	64	115	java/lang/Throwable
  }
  
  public static boolean b()
  {
    boolean bool = true;
    int i = 0;
    if (i < 5) {}
    for (;;)
    {
      try
      {
        Object localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        String str = new String[] { "/system/xbin/", "/system/bin/", "/system/sbin/", "/sbin/", "/vendor/bin/" }[i] + "su";
        localObject = new java/io/File;
        ((File)localObject).<init>(str);
        if (((File)localObject).exists())
        {
          localObject = a(new String[] { "ls", "-l", str });
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            int j = ((String)localObject).indexOf("root");
            i = ((String)localObject).lastIndexOf("root");
            if (j != i) {}
          }
          else
          {
            bool = false;
          }
          return bool;
        }
        i++;
      }
      catch (Exception localException) {}
      bool = false;
    }
  }
  
  public final void a(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }
  
  public final String c()
  {
    for (Object localObject1 = "";; localObject1 = localObject2)
    {
      try
      {
        localObject2 = com.a.a.c.b.a(this.a);
        if ((localObject2 != null) && (!e.a(((com.a.a.c.a)localObject2).e()))) {
          break label30;
        }
        localObject1 = "ffffffffffffffffffffffff";
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          Object localObject2;
          label30:
          com.alipay.sdk.app.a.a.a("third", "GetUtdidEx", localThrowable);
        }
      }
      return (String)localObject1;
      localObject2 = ((com.a.a.c.a)localObject2).e();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/h/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */