package com.alipay.android.a.a.a;

import java.io.IOException;
import java.net.SocketException;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

public class i
  implements HttpRequestRetryHandler
{
  static final String a = i.class.getSimpleName();
  
  public boolean retryRequest(IOException paramIOException, int paramInt, HttpContext paramHttpContext)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramInt >= 3) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      if ((paramIOException instanceof NoHttpResponseException))
      {
        bool1 = true;
      }
      else if (!(paramIOException instanceof SocketException))
      {
        bool1 = bool2;
        if (!(paramIOException instanceof SSLException)) {}
      }
      else
      {
        bool1 = bool2;
        if (paramIOException.getMessage() != null)
        {
          bool1 = bool2;
          if (paramIOException.getMessage().contains("Broken pipe")) {
            bool1 = true;
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/android/a/a/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */