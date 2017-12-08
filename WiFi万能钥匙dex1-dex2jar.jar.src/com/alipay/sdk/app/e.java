package com.alipay.sdk.app;

import android.webkit.SslErrorHandler;
import com.alipay.sdk.k.d;

final class e
  implements Runnable
{
  e(c paramc, SslErrorHandler paramSslErrorHandler) {}
  
  public final void run()
  {
    d.a(c.a(this.b), "安全警告", "安全连接证书校验无效，将无法保证访问数据的安全性，可能存在风险，请选择是否继续？", "继续", new f(this), "退出", new g(this));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/app/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */