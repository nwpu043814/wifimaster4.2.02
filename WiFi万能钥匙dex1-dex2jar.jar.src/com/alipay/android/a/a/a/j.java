package com.alipay.android.a.a.a;

import android.net.SSLCertificateSocketFactory;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Security;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

public final class j
  implements HttpClient
{
  public static long a = 160L;
  private static String[] b = { "text/", "application/xml", "application/json" };
  private static final HttpRequestInterceptor c = new k();
  private final HttpClient d;
  private RuntimeException e = new IllegalStateException("AndroidHttpClient created and never closed");
  private volatile b f;
  
  private j(ClientConnectionManager paramClientConnectionManager, HttpParams paramHttpParams)
  {
    this.d = new l(this, paramClientConnectionManager, paramHttpParams);
  }
  
  public static j a(String paramString)
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
    HttpProtocolParams.setUseExpectContinue(localBasicHttpParams, false);
    HttpConnectionParams.setStaleCheckingEnabled(localBasicHttpParams, true);
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 20000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 8192);
    HttpClientParams.setRedirecting(localBasicHttpParams, true);
    HttpClientParams.setAuthenticating(localBasicHttpParams, false);
    HttpProtocolParams.setUserAgent(localBasicHttpParams, paramString);
    paramString = new SchemeRegistry();
    paramString.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
    paramString.register(new Scheme("https", SSLCertificateSocketFactory.getHttpSocketFactory(30000, null), 443));
    paramString = new ThreadSafeClientConnManager(localBasicHttpParams, paramString);
    ConnManagerParams.setTimeout(localBasicHttpParams, 60000L);
    ConnManagerParams.setMaxConnectionsPerRoute(localBasicHttpParams, new ConnPerRouteBean(10));
    ConnManagerParams.setMaxTotalConnections(localBasicHttpParams, 50);
    Security.setProperty("networkaddress.cache.ttl", "-1");
    HttpsURLConnection.setDefaultHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
    return new j(paramString, localBasicHttpParams);
  }
  
  public static InputStream a(HttpEntity paramHttpEntity)
  {
    InputStream localInputStream = paramHttpEntity.getContent();
    if (localInputStream == null) {
      paramHttpEntity = localInputStream;
    }
    Object localObject;
    do
    {
      do
      {
        return paramHttpEntity;
        localObject = paramHttpEntity.getContentEncoding();
        paramHttpEntity = localInputStream;
      } while (localObject == null);
      localObject = ((Header)localObject).getValue();
      paramHttpEntity = localInputStream;
    } while (localObject == null);
    if (((String)localObject).contains("gzip")) {}
    for (paramHttpEntity = new GZIPInputStream(localInputStream);; paramHttpEntity = localInputStream) {
      break;
    }
  }
  
  public static AbstractHttpEntity a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length < a) {}
    Object localObject;
    for (paramArrayOfByte = new ByteArrayEntity(paramArrayOfByte);; paramArrayOfByte = (byte[])localObject)
    {
      return paramArrayOfByte;
      localObject = new ByteArrayOutputStream();
      GZIPOutputStream localGZIPOutputStream = new GZIPOutputStream((OutputStream)localObject);
      localGZIPOutputStream.write(paramArrayOfByte);
      localGZIPOutputStream.close();
      localObject = new ByteArrayEntity(((ByteArrayOutputStream)localObject).toByteArray());
      ((AbstractHttpEntity)localObject).setContentEncoding("gzip");
      new StringBuilder("gzip size:").append(paramArrayOfByte.length).append("->").append(((AbstractHttpEntity)localObject).getContentLength());
    }
  }
  
  public static void a(HttpRequest paramHttpRequest)
  {
    paramHttpRequest.addHeader("Accept-Encoding", "gzip");
  }
  
  public static long b(String paramString)
  {
    return s.a(paramString);
  }
  
  public static void b(HttpRequest paramHttpRequest)
  {
    paramHttpRequest.addHeader("Connection", "Keep-Alive");
  }
  
  private static boolean b(HttpUriRequest paramHttpUriRequest)
  {
    boolean bool2 = true;
    Object localObject = paramHttpUriRequest.getHeaders("content-encoding");
    int j;
    boolean bool1;
    if (localObject != null)
    {
      j = localObject.length;
      i = 0;
      if (i < j) {
        if ("gzip".equalsIgnoreCase(localObject[i].getValue())) {
          bool1 = bool2;
        }
      }
    }
    Header[] arrayOfHeader;
    do
    {
      return bool1;
      i++;
      break;
      arrayOfHeader = paramHttpUriRequest.getHeaders("content-type");
      bool1 = bool2;
    } while (arrayOfHeader == null);
    int k = arrayOfHeader.length;
    label150:
    for (int i = 0;; i++)
    {
      bool1 = bool2;
      if (i >= k) {
        break;
      }
      paramHttpUriRequest = arrayOfHeader[i];
      localObject = b;
      int m = localObject.length;
      for (j = 0;; j++)
      {
        if (j >= m) {
          break label150;
        }
        String str = localObject[j];
        if (paramHttpUriRequest.getValue().startsWith(str))
        {
          bool1 = false;
          break;
        }
      }
    }
  }
  
  public final void a(HttpRequestRetryHandler paramHttpRequestRetryHandler)
  {
    ((DefaultHttpClient)this.d).setHttpRequestRetryHandler(paramHttpRequestRetryHandler);
  }
  
  public final Object execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler paramResponseHandler)
  {
    return this.d.execute(paramHttpHost, paramHttpRequest, paramResponseHandler);
  }
  
  public final Object execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, ResponseHandler paramResponseHandler, HttpContext paramHttpContext)
  {
    return this.d.execute(paramHttpHost, paramHttpRequest, paramResponseHandler, paramHttpContext);
  }
  
  public final Object execute(HttpUriRequest paramHttpUriRequest, ResponseHandler paramResponseHandler)
  {
    return this.d.execute(paramHttpUriRequest, paramResponseHandler);
  }
  
  public final Object execute(HttpUriRequest paramHttpUriRequest, ResponseHandler paramResponseHandler, HttpContext paramHttpContext)
  {
    return this.d.execute(paramHttpUriRequest, paramResponseHandler, paramHttpContext);
  }
  
  public final HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest)
  {
    return this.d.execute(paramHttpHost, paramHttpRequest);
  }
  
  public final HttpResponse execute(HttpHost paramHttpHost, HttpRequest paramHttpRequest, HttpContext paramHttpContext)
  {
    return this.d.execute(paramHttpHost, paramHttpRequest, paramHttpContext);
  }
  
  public final HttpResponse execute(HttpUriRequest paramHttpUriRequest)
  {
    return this.d.execute(paramHttpUriRequest);
  }
  
  public final HttpResponse execute(HttpUriRequest paramHttpUriRequest, HttpContext paramHttpContext)
  {
    return this.d.execute(paramHttpUriRequest, paramHttpContext);
  }
  
  public final ClientConnectionManager getConnectionManager()
  {
    return this.d.getConnectionManager();
  }
  
  public final HttpParams getParams()
  {
    return this.d.getParams();
  }
  
  private final class a
    implements HttpRequestInterceptor
  {
    private a() {}
    
    public final void process(HttpRequest paramHttpRequest, HttpContext paramHttpContext)
    {
      paramHttpContext = j.a(j.this);
      if ((paramHttpContext != null) && (j.b.a(paramHttpContext)) && ((paramHttpRequest instanceof HttpUriRequest))) {
        j.b.a(paramHttpContext, j.a((HttpUriRequest)paramHttpRequest));
      }
    }
  }
  
  private static final class b
  {
    private final String a;
    private final int b;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/android/a/a/a/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */