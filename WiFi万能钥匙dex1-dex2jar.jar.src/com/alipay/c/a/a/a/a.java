package com.alipay.c.a.a.a;

import android.os.Environment;
import android.util.Base64;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

public final class a
{
  public static File a()
  {
    try
    {
      Object localObject1 = new java/lang/String;
      ((String)localObject1).<init>(com.alipay.c.a.a.a.a.a.a("Z2V0RXh0ZXJuYWxTdG9yYWdlRGlyZWN0b3J5"));
      localObject1 = (File)Environment.class.getMethod((String)localObject1, new Class[0]).invoke(null, new Object[0]);
      return (File)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  public static String a(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  public static String a(Map paramMap, String paramString1, String paramString2)
  {
    if (paramMap == null) {}
    for (;;)
    {
      return paramString2;
      paramMap = (String)paramMap.get(paramString1);
      if (paramMap != null) {
        paramString2 = paramMap;
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool2 = false;
    int j;
    boolean bool1;
    if (paramString != null)
    {
      j = paramString.length();
      if (j != 0) {}
    }
    else
    {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      for (int i = 0;; i++)
      {
        if (i >= j) {
          break label47;
        }
        bool1 = bool2;
        if (!Character.isWhitespace(paramString.charAt(i))) {
          break;
        }
      }
      label47:
      bool1 = true;
    }
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool;
    if (paramString1 == null) {
      if (paramString2 == null) {
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      bool = false;
      continue;
      bool = paramString1.equals(paramString2);
    }
  }
  
  public static String b(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = (String)Class.forName("android.os.SystemProperties").getMethod("get", new Class[] { String.class, String.class }).invoke(null, new Object[] { paramString1, paramString2 });
      paramString2 = paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;) {}
    }
    return paramString2;
  }
  
  public static boolean b(String paramString)
  {
    if (!a(paramString)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static String c(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static String d(String paramString)
  {
    localObject1 = null;
    int i = 0;
    for (;;)
    {
      try
      {
        if (!a(paramString)) {
          continue;
        }
        paramString = (String)localObject1;
      }
      catch (Exception paramString)
      {
        Object localObject2;
        paramString = (String)localObject1;
        continue;
      }
      return paramString;
      localObject2 = MessageDigest.getInstance("SHA-1");
      ((MessageDigest)localObject2).update(paramString.getBytes("UTF-8"));
      paramString = ((MessageDigest)localObject2).digest();
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      if (i < paramString.length)
      {
        ((StringBuilder)localObject2).append(String.format("%02x", new Object[] { Byte.valueOf(paramString[i]) }));
        i++;
      }
      else
      {
        paramString = ((StringBuilder)localObject2).toString();
      }
    }
  }
  
  public static String e(String paramString)
  {
    try
    {
      byte[] arrayOfByte = ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(paramString.length()).array();
      ByteArrayOutputStream localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
      localByteArrayOutputStream.<init>(paramString.length());
      GZIPOutputStream localGZIPOutputStream = new java/util/zip/GZIPOutputStream;
      localGZIPOutputStream.<init>(localByteArrayOutputStream);
      localGZIPOutputStream.write(paramString.getBytes("UTF-8"));
      localGZIPOutputStream.close();
      localByteArrayOutputStream.close();
      paramString = new byte[localByteArrayOutputStream.toByteArray().length + 4];
      System.arraycopy(arrayOfByte, 0, paramString, 0, 4);
      System.arraycopy(localByteArrayOutputStream.toByteArray(), 0, paramString, 4, localByteArrayOutputStream.toByteArray().length);
      paramString = Base64.encodeToString(paramString, 8);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = "";
      }
    }
  }
  
  public static String f(String paramString)
  {
    if (a(paramString)) {}
    byte[] arrayOfByte;
    for (paramString = "";; paramString = new String(Base64.encode(arrayOfByte, 2)))
    {
      ByteArrayInputStream localByteArrayInputStream;
      GZIPOutputStream localGZIPOutputStream;
      for (;;)
      {
        return paramString;
        try
        {
          localByteArrayInputStream = new java/io/ByteArrayInputStream;
          localByteArrayInputStream.<init>(paramString.getBytes("utf-8"));
          paramString = new java/io/ByteArrayOutputStream;
          paramString.<init>();
          localGZIPOutputStream = new java/util/zip/GZIPOutputStream;
          localGZIPOutputStream.<init>(paramString);
          arrayOfByte = new byte['Ѐ'];
          for (;;)
          {
            int i = localByteArrayInputStream.read(arrayOfByte, 0, 1024);
            if (i == -1) {
              break;
            }
            localGZIPOutputStream.write(arrayOfByte, 0, i);
          }
        }
        catch (Exception paramString)
        {
          paramString = "";
        }
      }
      localGZIPOutputStream.flush();
      localGZIPOutputStream.close();
      arrayOfByte = paramString.toByteArray();
      paramString.flush();
      paramString.close();
      localByteArrayInputStream.close();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/c/a/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */