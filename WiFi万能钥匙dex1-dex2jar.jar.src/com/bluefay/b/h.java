package com.bluefay.b;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

public final class h
{
  public static int a = 0;
  public static int b = 1;
  private static OutputStream c;
  private static Logger d = Logger.getLogger("BLLog");
  
  public static void a(int paramInt)
  {
    a = paramInt;
  }
  
  public static void a(int paramInt, OutputStream paramOutputStream)
  {
    b = paramInt;
    c = paramOutputStream;
  }
  
  public static void a(Exception paramException)
  {
    if (4 >= a)
    {
      StringWriter localStringWriter = new StringWriter();
      paramException.printStackTrace(new PrintWriter(localStringWriter, true));
      e(localStringWriter.toString());
    }
  }
  
  public static void a(String paramString)
  {
    if (2 >= a) {
      e(paramString);
    }
  }
  
  public static void a(String paramString, Exception paramException)
  {
    if (4 >= a) {
      e(paramString + paramException);
    }
  }
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (1 >= a)
    {
      if (paramVarArgs.length != 0) {
        break label17;
      }
      e(paramString);
    }
    for (;;)
    {
      return;
      label17:
      e(String.format(paramString, paramVarArgs));
    }
  }
  
  public static void b(String paramString)
  {
    if (3 >= a) {
      e(paramString);
    }
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    if (2 >= a)
    {
      if (paramVarArgs.length != 0) {
        break label17;
      }
      e(paramString);
    }
    for (;;)
    {
      return;
      label17:
      e(String.format(paramString, paramVarArgs));
    }
  }
  
  public static void c(String paramString)
  {
    if (4 >= a) {
      e(paramString);
    }
  }
  
  public static void c(String paramString, Object... paramVarArgs)
  {
    if (3 >= a) {
      e(String.format(paramString, paramVarArgs));
    }
  }
  
  public static void d(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      d = Logger.getLogger(paramString);
    }
  }
  
  private static void e(String paramString)
  {
    Object localObject = new Throwable().fillInStackTrace().getStackTrace()[2];
    localObject = String.format("[%s,%d,%s] %s", new Object[] { ((StackTraceElement)localObject).getFileName(), Integer.valueOf(((StackTraceElement)localObject).getLineNumber()), ((StackTraceElement)localObject).getMethodName(), paramString });
    switch (b)
    {
    }
    for (;;)
    {
      return;
      System.out.println((String)localObject);
      continue;
      d.warning((String)localObject);
      continue;
      if (c != null) {
        try
        {
          paramString = ((String)localObject).getBytes("utf-8");
          c.write(paramString, 0, paramString.length);
          if (!((String)localObject).endsWith("\n")) {
            c.write("\n".getBytes());
          }
        }
        catch (IOException paramString)
        {
          d.warning(paramString.getMessage());
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */