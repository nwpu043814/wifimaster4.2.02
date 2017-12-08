package com.lantern.dm.task;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public final class g
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  SSLContext a = SSLContext.getInstance("TLS");
  
  public g(KeyStore paramKeyStore)
  {
    super(paramKeyStore);
    paramKeyStore = new h(this);
    this.a.init(null, new TrustManager[] { paramKeyStore }, null);
  }
  
  public final Socket createSocket()
  {
    return this.a.getSocketFactory().createSocket();
  }
  
  public final Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return this.a.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/task/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */