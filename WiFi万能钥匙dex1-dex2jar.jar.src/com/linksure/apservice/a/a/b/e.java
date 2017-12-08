package com.linksure.apservice.a.a.b;

import com.lantern.core.o;
import com.linksure.apservice.a.a.a.b;
import com.linksure.apservice.a.a.c.a.a.a;
import com.linksure.apservice.a.a.c.a.a.b;
import com.linksure.apservice.a.a.f;
import com.linksure.apservice.a.d.a.c;

public final class e
  implements f
{
  private b a;
  private o b;
  
  public e(b paramb, o paramo)
  {
    this.a = paramb;
    this.b = paramo;
  }
  
  /* Error */
  private static long c(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 26	java/net/URL
    //   6: astore 4
    //   8: aload 4
    //   10: aload_0
    //   11: invokespecial 29	java/net/URL:<init>	(Ljava/lang/String;)V
    //   14: aload 4
    //   16: invokevirtual 33	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   19: checkcast 35	java/net/HttpURLConnection
    //   22: astore_0
    //   23: aload_0
    //   24: sipush 3000
    //   27: invokevirtual 39	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   30: aload_0
    //   31: sipush 5000
    //   34: invokevirtual 42	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   37: aload_0
    //   38: ldc 44
    //   40: invokevirtual 47	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   43: aload_0
    //   44: invokevirtual 51	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   47: astore 4
    //   49: aload_0
    //   50: invokevirtual 55	java/net/HttpURLConnection:getContentLength	()I
    //   53: istore_1
    //   54: iload_1
    //   55: i2l
    //   56: lstore_2
    //   57: aload 4
    //   59: ifnull +8 -> 67
    //   62: aload 4
    //   64: invokevirtual 60	java/io/InputStream:close	()V
    //   67: aload_0
    //   68: ifnull +7 -> 75
    //   71: aload_0
    //   72: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   75: lload_2
    //   76: lreturn
    //   77: astore_0
    //   78: aconst_null
    //   79: astore 4
    //   81: aload 4
    //   83: ifnull +8 -> 91
    //   86: aload 4
    //   88: invokevirtual 60	java/io/InputStream:close	()V
    //   91: aload 5
    //   93: ifnull +8 -> 101
    //   96: aload 5
    //   98: invokevirtual 63	java/net/HttpURLConnection:disconnect	()V
    //   101: aload_0
    //   102: athrow
    //   103: astore 4
    //   105: goto -38 -> 67
    //   108: astore 4
    //   110: goto -19 -> 91
    //   113: astore 6
    //   115: aconst_null
    //   116: astore 4
    //   118: aload_0
    //   119: astore 5
    //   121: aload 6
    //   123: astore_0
    //   124: goto -43 -> 81
    //   127: astore 6
    //   129: aload_0
    //   130: astore 5
    //   132: aload 6
    //   134: astore_0
    //   135: goto -54 -> 81
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	paramString	String
    //   53	2	1	i	int
    //   56	20	2	l	long
    //   6	81	4	localObject1	Object
    //   103	1	4	localException1	Exception
    //   108	1	4	localException2	Exception
    //   116	1	4	localObject2	Object
    //   1	130	5	str	String
    //   113	9	6	localObject3	Object
    //   127	6	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   3	23	77	finally
    //   62	67	103	java/lang/Exception
    //   86	91	108	java/lang/Exception
    //   23	49	113	finally
    //   49	54	127	finally
  }
  
  public final String a(String paramString)
  {
    paramString = new a.a(paramString);
    paramString = (a.b)this.a.a(paramString, a.b.class);
    if (paramString.a == 0) {
      return (String)paramString.c;
    }
    throw new c(paramString.b);
  }
  
  public final long b(String paramString)
  {
    try
    {
      long l = c(paramString);
      return l;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      throw new c("unknown err:" + paramString);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/a/a/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */