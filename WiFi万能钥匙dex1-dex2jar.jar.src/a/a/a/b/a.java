package a.a.a.b;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class a
{
  public static byte[] a(InputStream paramInputStream)
  {
    localByteArrayOutputStream = new ByteArrayOutputStream();
    try
    {
      byte[] arrayOfByte = new byte['Ѐ'];
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte, 0, 1024);
        if (i == -1) {
          break;
        }
        localByteArrayOutputStream.write(arrayOfByte, 0, i);
      }
      try
      {
        localByteArrayOutputStream.close();
        throw paramInputStream;
        localByteArrayOutputStream.close();
        paramInputStream = localByteArrayOutputStream.toByteArray();
        try
        {
          localByteArrayOutputStream.close();
          return paramInputStream;
        }
        catch (IOException localIOException1)
        {
          for (;;)
          {
            localIOException1.printStackTrace();
          }
        }
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          localIOException2.printStackTrace();
        }
      }
    }
    finally {}
  }
  
  /* Error */
  public static byte[] b(InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 10	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 14	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 4
    //   9: new 40	java/util/zip/GZIPInputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 43	java/util/zip/GZIPInputStream:<init>	(Ljava/io/InputStream;)V
    //   17: astore_2
    //   18: sipush 1024
    //   21: newarray <illegal type>
    //   23: astore_3
    //   24: aload_2
    //   25: aload_3
    //   26: invokevirtual 46	java/util/zip/GZIPInputStream:read	([B)I
    //   29: istore_1
    //   30: iload_1
    //   31: iconst_m1
    //   32: if_icmpeq +31 -> 63
    //   35: aload 4
    //   37: aload_3
    //   38: iconst_0
    //   39: iload_1
    //   40: invokevirtual 24	java/io/ByteArrayOutputStream:write	([BII)V
    //   43: goto -19 -> 24
    //   46: astore_2
    //   47: aload_2
    //   48: invokevirtual 47	java/lang/Exception:printStackTrace	()V
    //   51: aload_0
    //   52: ifnull +7 -> 59
    //   55: aload_0
    //   56: invokevirtual 48	java/io/InputStream:close	()V
    //   59: aconst_null
    //   60: astore_2
    //   61: aload_2
    //   62: areturn
    //   63: aload 4
    //   65: invokevirtual 27	java/io/ByteArrayOutputStream:close	()V
    //   68: aload 4
    //   70: invokevirtual 31	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   73: astore_3
    //   74: aload_3
    //   75: astore_2
    //   76: aload_0
    //   77: ifnull -16 -> 61
    //   80: aload_0
    //   81: invokevirtual 48	java/io/InputStream:close	()V
    //   84: aload_3
    //   85: astore_2
    //   86: goto -25 -> 61
    //   89: astore_2
    //   90: aload_0
    //   91: ifnull +7 -> 98
    //   94: aload_0
    //   95: invokevirtual 48	java/io/InputStream:close	()V
    //   98: aload_2
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	paramInputStream	InputStream
    //   29	11	1	i	int
    //   17	8	2	localGZIPInputStream	java.util.zip.GZIPInputStream
    //   46	2	2	localException	Exception
    //   60	26	2	localObject1	Object
    //   89	10	2	localObject2	Object
    //   23	62	3	arrayOfByte	byte[]
    //   7	62	4	localByteArrayOutputStream	ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   24	30	46	java/lang/Exception
    //   35	43	46	java/lang/Exception
    //   63	74	46	java/lang/Exception
    //   24	30	89	finally
    //   35	43	89	finally
    //   47	51	89	finally
    //   63	74	89	finally
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/a/a/a/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */