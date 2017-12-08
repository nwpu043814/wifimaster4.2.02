package com.wifipay.common.net.b.b;

import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public final class f
  extends HttpEntityEnclosingRequestBase
{
  public f() {}
  
  public f(String paramString)
  {
    setURI(URI.create(paramString));
  }
  
  public final String getMethod()
  {
    return "PATCH";
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/b/b/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */