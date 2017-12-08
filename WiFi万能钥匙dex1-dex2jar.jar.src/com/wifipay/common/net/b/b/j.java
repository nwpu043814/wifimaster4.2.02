package com.wifipay.common.net.b.b;

import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

public class j
  extends org.apache.http.conn.ssl.SSLSocketFactory
{
  SSLContext a = SSLContext.getInstance("TLS");
  
  public j(KeyStore paramKeyStore)
  {
    super(paramKeyStore);
    paramKeyStore = new k(this);
    this.a.init(null, new TrustManager[] { paramKeyStore }, null);
  }
  
  /* Error */
  public static org.apache.http.conn.ssl.SSLSocketFactory a()
  {
    // Byte code:
    //   0: invokestatic 41	java/security/KeyStore:getDefaultType	()Ljava/lang/String;
    //   3: invokestatic 44	java/security/KeyStore:getInstance	(Ljava/lang/String;)Ljava/security/KeyStore;
    //   6: astore_1
    //   7: aload_1
    //   8: aconst_null
    //   9: aconst_null
    //   10: invokevirtual 48	java/security/KeyStore:load	(Ljava/io/InputStream;[C)V
    //   13: new 2	com/wifipay/common/net/b/b/j
    //   16: astore_0
    //   17: aload_0
    //   18: aload_1
    //   19: invokespecial 49	com/wifipay/common/net/b/b/j:<init>	(Ljava/security/KeyStore;)V
    //   22: aload_0
    //   23: getstatic 53	org/apache/http/conn/ssl/SSLSocketFactory:ALLOW_ALL_HOSTNAME_VERIFIER	Lorg/apache/http/conn/ssl/X509HostnameVerifier;
    //   26: invokevirtual 57	org/apache/http/conn/ssl/SSLSocketFactory:setHostnameVerifier	(Lorg/apache/http/conn/ssl/X509HostnameVerifier;)V
    //   29: aload_0
    //   30: areturn
    //   31: astore_1
    //   32: aconst_null
    //   33: astore_0
    //   34: aload_1
    //   35: invokevirtual 61	java/lang/Exception:printStackTrace	()V
    //   38: goto -9 -> 29
    //   41: astore_1
    //   42: goto -8 -> 34
    // Local variable table:
    //   start	length	slot	name	signature
    //   16	18	0	localj	j
    //   6	13	1	localKeyStore	KeyStore
    //   31	4	1	localException1	Exception
    //   41	1	1	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	22	31	java/lang/Exception
    //   22	29	41	java/lang/Exception
  }
  
  public Socket createSocket()
  {
    return this.a.getSocketFactory().createSocket();
  }
  
  public Socket createSocket(Socket paramSocket, String paramString, int paramInt, boolean paramBoolean)
  {
    return this.a.getSocketFactory().createSocket(paramSocket, paramString, paramInt, paramBoolean);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/b/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */