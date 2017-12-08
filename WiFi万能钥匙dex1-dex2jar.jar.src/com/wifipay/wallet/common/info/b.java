package com.wifipay.wallet.common.info;

import android.text.TextUtils;
import com.wifipay.common.a.g;
import com.wifipay.wallet.common.WalletState;

public class b
{
  private static b a;
  private UserInfo b;
  
  public static b a()
  {
    if (a == null) {
      a = new b();
    }
    return a;
  }
  
  public void a(String paramString)
  {
    if (d()) {
      c().setRemainMoney(paramString);
    }
  }
  
  public void b()
  {
    this.b = null;
  }
  
  public void b(String paramString)
  {
    if (d()) {
      c().setRealName(paramString);
    }
  }
  
  public UserInfo c()
  {
    Object localObject1;
    if (!d()) {
      localObject1 = null;
    }
    for (;;)
    {
      return (UserInfo)localObject1;
      UserInfo localUserInfo = this.b;
      localObject1 = localUserInfo;
      if (localUserInfo != null) {
        continue;
      }
      try
      {
        localUserInfo = this.b;
        localObject1 = localUserInfo;
        if (localUserInfo == null)
        {
          localObject1 = new com/wifipay/wallet/common/info/UserInfo;
          ((UserInfo)localObject1).<init>();
          this.b = ((UserInfo)localObject1);
        }
      }
      finally {}
    }
  }
  
  public void c(String paramString)
  {
    if (d()) {
      c().setHeaderImage(paramString);
    }
  }
  
  public boolean d()
  {
    return true;
  }
  
  public String e()
  {
    if (d()) {}
    for (String str = c().getMemberId();; str = null) {
      return str;
    }
  }
  
  public String f()
  {
    if (d()) {}
    for (String str = c().getLoginName();; str = null) {
      return str;
    }
  }
  
  public String g()
  {
    if (d()) {}
    for (String str = c().getAccessToken();; str = null) {
      return str;
    }
  }
  
  public String h()
  {
    if (d()) {}
    for (String str = c().getTrueName();; str = null) {
      return str;
    }
  }
  
  public String i()
  {
    String str = h();
    Object localObject;
    if ((!TextUtils.isEmpty(str)) && (str.length() > 0))
    {
      localObject = new StringBuilder();
      for (int i = 0; (i < str.length() - 1) && (i != 3); i++) {
        ((StringBuilder)localObject).append("*");
      }
      str = str.replace(str.substring(0, str.length() - 1), ((StringBuilder)localObject).toString());
    }
    for (;;)
    {
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "";
      }
      return (String)localObject;
    }
  }
  
  public int j()
  {
    if (d()) {}
    for (int i = c().getWalletState();; i = WalletState.STATE_UNKNOWN.getState()) {
      return i;
    }
  }
  
  public String k()
  {
    if (d()) {}
    for (String str = c().getAvailableBalance();; str = "0") {
      return str;
    }
  }
  
  public String l()
  {
    if (d()) {}
    for (String str = c().getOutToken();; str = null) {
      return str;
    }
  }
  
  public String m()
  {
    if (d()) {}
    for (String str = c().getUhId();; str = null) {
      return str;
    }
  }
  
  public boolean n()
  {
    if ((g.a(l())) || (g.a(m())) || (g.a(g()))) {}
    for (boolean bool = false;; bool = true) {
      return bool;
    }
  }
  
  public String o()
  {
    if (d()) {}
    for (String str = c().getRemainMoney();; str = null) {
      return str;
    }
  }
  
  public String p()
  {
    if (d()) {}
    for (String str = c().getRealName();; str = null) {
      return str;
    }
  }
  
  public String q()
  {
    if (d()) {}
    for (String str = c().getHeaderImage();; str = null) {
      return str;
    }
  }
  
  public String r()
  {
    if (d()) {}
    for (String str = c().getLongi();; str = null) {
      return str;
    }
  }
  
  public String s()
  {
    if (d()) {}
    for (String str = c().getLati();; str = null) {
      return str;
    }
  }
  
  public String t()
  {
    if (d()) {}
    for (String str = c().getMapSP();; str = null) {
      return str;
    }
  }
  
  public String u()
  {
    if (d()) {}
    for (String str = c().getCert();; str = null) {
      return str;
    }
  }
  
  public String v()
  {
    if (d()) {}
    for (String str = c().getCertSerialNo();; str = null) {
      return str;
    }
  }
  
  public String w()
  {
    if (d()) {}
    for (String str = c().getMerchantNo();; str = null) {
      return str;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/common/info/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */