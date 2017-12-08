package com.alipay.sdk.g;

import android.text.TextUtils;

public enum a
{
  private String d;
  
  private a(String paramString1)
  {
    this.d = paramString1;
  }
  
  public static a a(String paramString)
  {
    Object localObject;
    if (TextUtils.isEmpty(paramString)) {
      localObject = a;
    }
    for (;;)
    {
      return (a)localObject;
      a locala2 = a;
      a[] arrayOfa = values();
      int j = arrayOfa.length;
      for (int i = 0;; i++)
      {
        if (i >= j) {
          break label61;
        }
        a locala1 = arrayOfa[i];
        localObject = locala1;
        if (paramString.startsWith(locala1.d)) {
          break;
        }
      }
      label61:
      localObject = locala2;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */