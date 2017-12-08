package com.wifipay.common.logging;

public final class Logger
{
  private static final boolean DEFAULT_DEBUG = false;
  private static final String DEFAULT_TAG = "wifipay";
  private static e printer = new d(false);
  
  public static void clear()
  {
    printer.c();
  }
  
  public static void d(String paramString, Object... paramVarArgs)
  {
    printer.a(paramString, paramVarArgs);
  }
  
  public static void e(String paramString, Object... paramVarArgs)
  {
    printer.a(null, paramString, paramVarArgs);
  }
  
  public static void e(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    printer.a(paramThrowable, paramString, paramVarArgs);
  }
  
  public static void i(String paramString, Object... paramVarArgs)
  {
    printer.d(paramString, paramVarArgs);
  }
  
  public static f init()
  {
    return init("wifipay", false);
  }
  
  public static f init(String paramString, boolean paramBoolean)
  {
    d locald = new d(paramBoolean);
    printer = locald;
    return locald.a(paramString);
  }
  
  public static boolean isDebug()
  {
    return printer.b();
  }
  
  public static void json(String paramString)
  {
    printer.b(paramString);
  }
  
  public static e t(int paramInt)
  {
    return printer.a(null, paramInt);
  }
  
  public static e t(String paramString)
  {
    return printer.a(paramString, printer.a().a());
  }
  
  public static e t(String paramString, int paramInt)
  {
    return printer.a(paramString, paramInt);
  }
  
  public static void v(String paramString, Object... paramVarArgs)
  {
    printer.e(paramString, paramVarArgs);
  }
  
  public static void w(String paramString, Object... paramVarArgs)
  {
    printer.c(paramString, paramVarArgs);
  }
  
  public static void wtf(String paramString, Object... paramVarArgs)
  {
    printer.f(paramString, paramVarArgs);
  }
  
  public static void xml(String paramString)
  {
    printer.c(paramString);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/logging/Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */