package com.alipay.sdk.e;

import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public final class b
{
  static b a;
  final DefaultHttpClient b;
  
  private b(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams)
  {
    this.b = new DefaultHttpClient(paramClientConnectionManager, paramHttpParams);
  }
  
  private b(HttpParams paramHttpParams)
  {
    this.b = new DefaultHttpClient(paramHttpParams);
  }
  
  public static b a()
  {
    BasicHttpParams localBasicHttpParams;
    if (a == null)
    {
      localBasicHttpParams = new BasicHttpParams();
      HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
      HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, true);
      localBasicHttpParams.setBooleanParameter("http.protocol.expect-continue", false);
      ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 50);
      ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(30));
      ConnManagerParams.setTimeout(localBasicHttpParams, 1000L);
      HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 20000);
      HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
      HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 16384);
      HttpProtocolParams.setUseExpectContinue(localBasicHttpParams, false);
      HttpClientParams.setRedirecting(localBasicHttpParams, true);
      HttpClientParams.setAuthenticating(localBasicHttpParams, false);
      HttpProtocolParams.setUserAgent(localBasicHttpParams, "msp");
    }
    try
    {
      Object localObject1 = SSLSocketFactory.getSocketFactory();
      ((SSLSocketFactory)localObject1).setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
      Object localObject2 = new org/apache/http/conn/scheme/Scheme;
      ((Scheme)localObject2).<init>("https", (SocketFactory)localObject1, 443);
      Scheme localScheme = new org/apache/http/conn/scheme/Scheme;
      localScheme.<init>("http", PlainSocketFactory.getSocketFactory(), 80);
      localObject1 = new org/apache/http/conn/scheme/SchemeRegistry;
      ((SchemeRegistry)localObject1).<init>();
      ((SchemeRegistry)localObject1).register((Scheme)localObject2);
      ((SchemeRegistry)localObject1).register(localScheme);
      localObject2 = new org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
      ((ThreadSafeClientConnManager)localObject2).<init>(localBasicHttpParams, (SchemeRegistry)localObject1);
      localObject1 = new com/alipay/sdk/e/b;
      ((b)localObject1).<init>((ClientConnectionManager)localObject2, localBasicHttpParams);
      a = (b)localObject1;
      return a;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        a = new b(localBasicHttpParams);
      }
    }
  }
  
  public final HttpResponse a(HttpUriRequest paramHttpUriRequest)
  {
    try
    {
      paramHttpUriRequest = this.b.execute(paramHttpUriRequest);
      return paramHttpUriRequest;
    }
    catch (Exception paramHttpUriRequest)
    {
      throw paramHttpUriRequest;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */