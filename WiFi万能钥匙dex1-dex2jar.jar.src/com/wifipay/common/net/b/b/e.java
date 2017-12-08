package com.wifipay.common.net.b.b;

import com.wifipay.common.net.b.k;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

public class e
  implements h
{
  protected HttpClient a;
  
  public e(HttpClient paramHttpClient)
  {
    this.a = paramHttpClient;
    a();
  }
  
  private HttpClient a()
  {
    BasicHttpParams localBasicHttpParams;
    if (this.a == null)
    {
      localBasicHttpParams = new BasicHttpParams();
      HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
      HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, true);
      localBasicHttpParams.setBooleanParameter("http.protocol.expect-continue", false);
      ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 30);
      ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(20));
      ConnManagerParams.setTimeout(localBasicHttpParams, 10000L);
      HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
      HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 20000);
      HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 16384);
      HttpProtocolParams.setUseExpectContinue(localBasicHttpParams, false);
      HttpClientParams.setRedirecting(localBasicHttpParams, true);
      HttpClientParams.setAuthenticating(localBasicHttpParams, false);
      HttpProtocolParams.setUserAgent(localBasicHttpParams, "wifipay");
    }
    try
    {
      Object localObject2 = j.a();
      Object localObject1 = new org/apache/http/conn/scheme/SchemeRegistry;
      ((SchemeRegistry)localObject1).<init>();
      Scheme localScheme = new org/apache/http/conn/scheme/Scheme;
      localScheme.<init>("http", PlainSocketFactory.getSocketFactory(), 80);
      ((SchemeRegistry)localObject1).register(localScheme);
      localScheme = new org/apache/http/conn/scheme/Scheme;
      localScheme.<init>("https", (SocketFactory)localObject2, 443);
      ((SchemeRegistry)localObject1).register(localScheme);
      localObject2 = new org/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
      ((ThreadSafeClientConnManager)localObject2).<init>(localBasicHttpParams, (SchemeRegistry)localObject1);
      localObject1 = new org/apache/http/impl/client/DefaultHttpClient;
      ((DefaultHttpClient)localObject1).<init>((ClientConnectionManager)localObject2, localBasicHttpParams);
      this.a = ((HttpClient)localObject1);
      return this.a;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.a = new DefaultHttpClient(localBasicHttpParams);
      }
    }
  }
  
  private static void a(HttpEntityEnclosingRequestBase paramHttpEntityEnclosingRequestBase, k paramk)
  {
    paramk = paramk.q();
    if (paramk != null) {
      paramHttpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(paramk));
    }
  }
  
  private static void a(HttpUriRequest paramHttpUriRequest, Map paramMap)
  {
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramHttpUriRequest.setHeader(str, (String)paramMap.get(str));
    }
  }
  
  static HttpUriRequest b(k paramk, Map paramMap)
  {
    switch (paramk.a())
    {
    default: 
      throw new IllegalStateException("Unknown request method.");
    case -1: 
      byte[] arrayOfByte = paramk.m();
      if (arrayOfByte != null)
      {
        paramMap = new HttpPost(paramk.e());
        paramMap.addHeader("Content-Type", paramk.l());
        paramMap.setEntity(new ByteArrayEntity(arrayOfByte));
        paramk = paramMap;
      }
      break;
    }
    for (;;)
    {
      return paramk;
      paramk = new HttpGet(paramk.e());
      continue;
      paramk = new HttpGet(paramk.e());
      continue;
      paramk = new HttpDelete(paramk.e());
      continue;
      paramMap = new HttpPost(paramk.e());
      paramMap.addHeader("Content-Type", paramk.p());
      a(paramMap, paramk);
      paramk = paramMap;
      continue;
      paramMap = new HttpPut(paramk.e());
      paramMap.addHeader("Content-Type", paramk.p());
      a(paramMap, paramk);
      paramk = paramMap;
      continue;
      paramk = new HttpHead(paramk.e());
      continue;
      paramk = new HttpOptions(paramk.e());
      continue;
      paramk = new HttpTrace(paramk.e());
      continue;
      paramMap = new f(paramk.e());
      paramMap.addHeader("Content-Type", paramk.p());
      a(paramMap, paramk);
      paramk = paramMap;
    }
  }
  
  public HttpResponse a(k paramk, Map paramMap)
  {
    HttpUriRequest localHttpUriRequest = b(paramk, paramMap);
    a(localHttpUriRequest, paramMap);
    a(localHttpUriRequest, paramk.i());
    a(localHttpUriRequest);
    paramMap = localHttpUriRequest.getParams();
    int i = paramk.t();
    HttpConnectionParams.setConnectionTimeout(paramMap, 30000);
    HttpConnectionParams.setSoTimeout(paramMap, i);
    return this.a.execute(localHttpUriRequest);
  }
  
  protected void a(HttpUriRequest paramHttpUriRequest) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/b/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */