package com.b.a;

import com.b.a.c.a;
import com.b.a.c.c;
import com.b.a.c.e;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public final class af
{
  /* Error */
  private static z a(a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 22	com/b/a/c/a:a	()Z
    //   4: istore_1
    //   5: aload_0
    //   6: iconst_1
    //   7: invokevirtual 25	com/b/a/c/a:a	(Z)V
    //   10: aload_0
    //   11: invokestatic 29	com/b/a/bd:a	(Lcom/b/a/c/a;)Lcom/b/a/z;
    //   14: astore_2
    //   15: aload_0
    //   16: iload_1
    //   17: invokevirtual 25	com/b/a/c/a:a	(Z)V
    //   20: aload_2
    //   21: areturn
    //   22: astore_2
    //   23: new 17	com/b/a/ae
    //   26: astore_3
    //   27: new 31	java/lang/StringBuilder
    //   30: astore 4
    //   32: aload 4
    //   34: ldc 33
    //   36: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: aload_3
    //   40: aload 4
    //   42: aload_0
    //   43: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: ldc 42
    //   48: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: aload_2
    //   55: invokespecial 52	com/b/a/ae:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   58: aload_3
    //   59: athrow
    //   60: astore_2
    //   61: aload_0
    //   62: iload_1
    //   63: invokevirtual 25	com/b/a/c/a:a	(Z)V
    //   66: aload_2
    //   67: athrow
    //   68: astore 4
    //   70: new 17	com/b/a/ae
    //   73: astore_3
    //   74: new 31	java/lang/StringBuilder
    //   77: astore_2
    //   78: aload_2
    //   79: ldc 33
    //   81: invokespecial 36	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   84: aload_3
    //   85: aload_2
    //   86: aload_0
    //   87: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   90: ldc 42
    //   92: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: aload 4
    //   100: invokespecial 52	com/b/a/ae:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   103: aload_3
    //   104: athrow
    //   105: astore_2
    //   106: aload_2
    //   107: invokevirtual 56	com/b/a/ae:getCause	()Ljava/lang/Throwable;
    //   110: instanceof 58
    //   113: ifeq +15 -> 128
    //   116: invokestatic 63	com/b/a/ab:a	()Lcom/b/a/ab;
    //   119: astore_2
    //   120: aload_0
    //   121: iload_1
    //   122: invokevirtual 25	com/b/a/c/a:a	(Z)V
    //   125: goto -105 -> 20
    //   128: aload_2
    //   129: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	parama	a
    //   4	118	1	bool	boolean
    //   14	7	2	localz	z
    //   22	33	2	localStackOverflowError	StackOverflowError
    //   60	7	2	localObject	Object
    //   77	9	2	localStringBuilder1	StringBuilder
    //   105	2	2	localae1	ae
    //   119	10	2	localab	ab
    //   26	78	3	localae2	ae
    //   30	11	4	localStringBuilder2	StringBuilder
    //   68	31	4	localOutOfMemoryError	OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   10	15	22	java/lang/StackOverflowError
    //   10	15	60	finally
    //   23	60	60	finally
    //   70	105	60	finally
    //   106	120	60	finally
    //   128	130	60	finally
    //   10	15	68	java/lang/OutOfMemoryError
    //   10	15	105	com/b/a/ae
  }
  
  private static z a(Reader paramReader)
  {
    try
    {
      a locala = new com/b/a/c/a;
      locala.<init>(paramReader);
      paramReader = a(locala);
      if ((!(paramReader instanceof ab)) && (locala.g() != c.j))
      {
        paramReader = new com/b/a/al;
        paramReader.<init>("Did not consume the entire document.");
        throw paramReader;
      }
    }
    catch (e paramReader)
    {
      throw new al(paramReader);
    }
    catch (IOException paramReader)
    {
      throw new aa(paramReader);
    }
    catch (NumberFormatException paramReader)
    {
      throw new al(paramReader);
    }
    return paramReader;
  }
  
  public static z a(String paramString)
  {
    return a(new StringReader(paramString));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/b/a/af.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */