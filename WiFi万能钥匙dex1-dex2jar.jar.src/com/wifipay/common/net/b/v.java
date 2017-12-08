package com.wifipay.common.net.b;

import com.wifipay.common.logging.Logger;
import java.util.Locale;

public class v
{
  public static String a = "wujun";
  public static boolean b = Logger.isDebug();
  
  public static void a(String paramString, Object... paramVarArgs)
  {
    if (b) {
      Logger.v(d(paramString, paramVarArgs), new Object[0]);
    }
  }
  
  public static void a(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    Logger.e(d(paramString, paramVarArgs), new Object[] { paramThrowable });
  }
  
  public static void b(String paramString, Object... paramVarArgs)
  {
    Logger.d(d(paramString, paramVarArgs), new Object[0]);
  }
  
  public static void c(String paramString, Object... paramVarArgs)
  {
    Logger.e(d(paramString, paramVarArgs), new Object[0]);
  }
  
  private static String d(String paramString, Object... paramVarArgs)
  {
    int i;
    label20:
    String str;
    if (paramVarArgs == null)
    {
      paramVarArgs = new Throwable().fillInStackTrace().getStackTrace();
      i = 2;
      if (i >= paramVarArgs.length) {
        break label153;
      }
      if (paramVarArgs[i].getClass().equals(v.class)) {
        break label147;
      }
      str = paramVarArgs[i].getClassName();
      str = str.substring(str.lastIndexOf('.') + 1);
      str = str.substring(str.lastIndexOf('$') + 1);
    }
    label147:
    label153:
    for (paramVarArgs = str + "." + paramVarArgs[i].getMethodName();; paramVarArgs = "<unknown>")
    {
      return String.format(Locale.US, "[%d] %s: %s", new Object[] { Long.valueOf(Thread.currentThread().getId()), paramVarArgs, paramString });
      paramString = String.format(Locale.US, paramString, paramVarArgs);
      break;
      i++;
      break label20;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/b/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */