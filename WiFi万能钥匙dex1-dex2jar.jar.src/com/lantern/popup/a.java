package com.lantern.popup;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class a
{
  public static String a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("ASCII");
      return new String(a(paramString));
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("ASCII is not supported!", paramString);
    }
  }
  
  private static void a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  /* Error */
  private static byte[] a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 50	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 51	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_1
    //   9: new 53	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 56	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore_0
    //   17: new 58	com/lantern/popup/b
    //   20: astore_2
    //   21: aload_2
    //   22: aload_1
    //   23: invokespecial 61	com/lantern/popup/b:<init>	(Ljava/io/InputStream;)V
    //   26: aload_2
    //   27: aload_0
    //   28: invokestatic 63	com/lantern/popup/a:a	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   31: aload_1
    //   32: invokevirtual 66	java/io/ByteArrayInputStream:close	()V
    //   35: aload_0
    //   36: invokevirtual 67	java/io/ByteArrayOutputStream:close	()V
    //   39: aload_0
    //   40: invokevirtual 71	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   43: areturn
    //   44: astore_3
    //   45: new 25	java/lang/RuntimeException
    //   48: astore_2
    //   49: aload_2
    //   50: ldc 73
    //   52: aload_3
    //   53: invokespecial 30	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   56: aload_2
    //   57: athrow
    //   58: astore_2
    //   59: aload_1
    //   60: invokevirtual 66	java/io/ByteArrayInputStream:close	()V
    //   63: aload_0
    //   64: invokevirtual 67	java/io/ByteArrayOutputStream:close	()V
    //   67: aload_2
    //   68: athrow
    //   69: astore_1
    //   70: goto -35 -> 35
    //   73: astore_1
    //   74: goto -35 -> 39
    //   77: astore_1
    //   78: goto -15 -> 63
    //   81: astore_0
    //   82: goto -15 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	paramArrayOfByte	byte[]
    //   8	52	1	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   69	1	1	localThrowable1	Throwable
    //   73	1	1	localThrowable2	Throwable
    //   77	1	1	localThrowable3	Throwable
    //   20	37	2	localObject1	Object
    //   58	10	2	localObject2	Object
    //   44	9	3	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   17	31	44	java/io/IOException
    //   17	31	58	finally
    //   45	58	58	finally
    //   31	35	69	java/lang/Throwable
    //   35	39	73	java/lang/Throwable
    //   59	63	77	java/lang/Throwable
    //   63	67	81	java/lang/Throwable
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/popup/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */