package com.wifipay.wallet.common.utils;

import com.wifipay.common.a.g;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class f
{
  public static String a(int paramInt, String paramString)
  {
    return new BigDecimal(paramString).setScale(paramInt, 4).toPlainString();
  }
  
  public static String a(String paramString)
  {
    return a(2, paramString);
  }
  
  public static boolean a(Object paramObject)
  {
    if (paramObject == null) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public static boolean b(Object paramObject)
  {
    if (!a(paramObject)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static boolean b(String paramString)
  {
    if (g.a(paramString)) {}
    for (boolean bool = false;; bool = Pattern.compile("^((13[0-9])|(14[0-9])|(15[^4,\\D])|(17[0-9])|(18[0-9]))\\d{8}$").matcher(paramString).matches()) {
      return bool;
    }
  }
  
  public static boolean c(String paramString)
  {
    if (g.a(paramString)) {}
    for (boolean bool = false;; bool = Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$").matcher(paramString).matches()) {
      return bool;
    }
  }
  
  public static boolean d(String paramString)
  {
    if (g.a(paramString)) {}
    for (boolean bool = true;; bool = Pattern.compile("^(\\d{17}[0-9xX])").matcher(paramString).matches()) {
      return bool;
    }
  }
  
  public static boolean e(String paramString)
  {
    if (Pattern.compile("[u4e00-u9fa5]").matcher(paramString).find()) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/common/utils/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */