package com.lantern.core;

import com.bluefay.b.h;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

final class m
  implements HostnameVerifier
{
  m(l paraml) {}
  
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    h.a("hostname:" + paramString, new Object[0]);
    return true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */