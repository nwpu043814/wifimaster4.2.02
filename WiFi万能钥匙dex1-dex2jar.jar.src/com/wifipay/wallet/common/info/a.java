package com.wifipay.wallet.common.info;

import com.wifipay.common.a.g;
import java.util.HashMap;

public class a
{
  private static volatile a a = null;
  private static Object c = new Object();
  private HashMap<String, String> b = new HashMap();
  
  public static a a()
  {
    if (a == null) {}
    synchronized (c)
    {
      a locala = new com/wifipay/wallet/common/info/a;
      locala.<init>();
      a = locala;
      return a;
    }
  }
  
  public String a(String paramString)
  {
    if (!g.a(paramString)) {}
    for (paramString = (String)this.b.get(paramString);; paramString = null) {
      return paramString;
    }
  }
  
  public void a(String... paramVarArgs)
  {
    if (paramVarArgs.length % 2 != 0) {
      throw new IllegalArgumentException();
    }
    for (int i = 0; i < paramVarArgs.length; i += 2)
    {
      String str1 = paramVarArgs[i];
      String str2 = paramVarArgs[(i + 1)];
      this.b.put(str1, str2);
    }
  }
  
  public String b(String paramString)
  {
    String str = null;
    if (!g.a(paramString))
    {
      str = (String)this.b.get(paramString);
      this.b.remove(paramString);
    }
    return str;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/common/info/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */