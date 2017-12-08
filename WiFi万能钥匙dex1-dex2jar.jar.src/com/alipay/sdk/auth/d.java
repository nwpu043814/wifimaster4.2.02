package com.alipay.sdk.auth;

import android.webkit.SslErrorHandler;

final class d
  implements Runnable
{
  d(AuthActivity.b paramb, SslErrorHandler paramSslErrorHandler) {}
  
  public final void run()
  {
    com.alipay.sdk.k.d.a(this.b.a, "安全警告", "由于您的设备缺少根证书，将无法校验该访问站点的安全性，可能存在风险，请选择是否继续？", "继续", new e(this), "退出", new f(this));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/auth/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */