package com.lantern.wifilocating.push.b.b;

public enum e
{
  private String h;
  
  private e(String paramString)
  {
    this.h = paramString;
  }
  
  public static e a(String paramString)
  {
    e[] arrayOfe = values();
    int k = arrayOfe.length;
    int j = 0;
    e locale;
    if (j < k)
    {
      locale = arrayOfe[j];
      if (!locale.h.equals(paramString)) {}
    }
    for (paramString = locale;; paramString = null)
    {
      return paramString;
      j++;
      break;
    }
  }
  
  public final String a()
  {
    return this.h;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/b/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */