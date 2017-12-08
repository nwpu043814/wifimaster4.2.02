package com.alipay.sdk.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;

public final class a
{
  public String a;
  private Context b;
  
  public a(Context paramContext, String paramString)
  {
    this.b = paramContext;
    this.a = paramString;
  }
  
  private URL a()
  {
    try
    {
      URL localURL = new java/net/URL;
      localURL.<init>(this.a);
      return localURL;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  private NetworkInfo b()
  {
    try
    {
      NetworkInfo localNetworkInfo = ((ConnectivityManager)this.b.getSystemService("connectivity")).getActiveNetworkInfo();
      return localNetworkInfo;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
  
  private String c()
  {
    for (;;)
    {
      try
      {
        localObject = b();
        if ((localObject == null) || (!((NetworkInfo)localObject).isAvailable())) {
          continue;
        }
        if (((NetworkInfo)localObject).getType() != 1) {
          continue;
        }
        localObject = "wifi";
      }
      catch (Exception localException)
      {
        Object localObject;
        String str = "none";
        continue;
      }
      return (String)localObject;
      localObject = ((NetworkInfo)localObject).getExtraInfo().toLowerCase();
      continue;
      localObject = "none";
    }
  }
  
  public final HttpResponse a(byte[] paramArrayOfByte, List paramList)
  {
    ByteArrayEntity localByteArrayEntity = null;
    Object localObject1 = null;
    new StringBuilder("requestUrl : ").append(this.a);
    b localb = b.a();
    if (localb == null) {
      paramArrayOfByte = (byte[])localObject1;
    }
    for (;;)
    {
      return paramArrayOfByte;
      for (;;)
      {
        try
        {
          HttpParams localHttpParams = localb.b.getParams();
          if (Build.VERSION.SDK_INT < 11) {
            break label259;
          }
          localObject1 = c();
          if ((localObject1 == null) || (((String)localObject1).contains("wap"))) {
            break label188;
          }
          localObject1 = localByteArrayEntity;
          if (localObject1 != null) {
            localHttpParams.setParameter("http.route.default-proxy", localObject1);
          }
          if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
            break label331;
          }
          paramArrayOfByte = new org/apache/http/client/methods/HttpGet;
          paramArrayOfByte.<init>(this.a);
          if (paramList == null) {
            break;
          }
          paramList = paramList.iterator();
          if (!paramList.hasNext()) {
            break;
          }
          paramArrayOfByte.addHeader((Header)paramList.next());
          continue;
          try
          {
            paramList = localb.b.getConnectionManager();
            if (paramList != null)
            {
              paramList.shutdown();
              b.a = null;
            }
          }
          catch (Throwable paramList)
          {
            Object localObject2;
            String str;
            int i;
            for (;;) {}
          }
        }
        catch (Throwable paramArrayOfByte)
        {
          if (localb == null) {}
        }
        throw paramArrayOfByte;
        label188:
        localObject2 = a();
        localObject1 = localByteArrayEntity;
        if (localObject2 != null)
        {
          "https".equalsIgnoreCase(((URL)localObject2).getProtocol());
          localObject2 = System.getProperty("https.proxyHost");
          str = System.getProperty("https.proxyPort");
          localObject1 = localByteArrayEntity;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject1 = new HttpHost((String)localObject2, Integer.parseInt(str));
            continue;
            label259:
            localObject2 = b();
            localObject1 = localByteArrayEntity;
            if (localObject2 != null)
            {
              localObject1 = localByteArrayEntity;
              if (((NetworkInfo)localObject2).isAvailable())
              {
                localObject1 = localByteArrayEntity;
                if (((NetworkInfo)localObject2).getType() == 0)
                {
                  localObject2 = Proxy.getDefaultHost();
                  i = Proxy.getDefaultPort();
                  localObject1 = localByteArrayEntity;
                  if (localObject2 != null)
                  {
                    localObject1 = new HttpHost((String)localObject2, i);
                    continue;
                    label331:
                    localObject1 = new org/apache/http/client/methods/HttpPost;
                    ((HttpPost)localObject1).<init>(this.a);
                    localByteArrayEntity = new org/apache/http/entity/ByteArrayEntity;
                    localByteArrayEntity.<init>(paramArrayOfByte);
                    localByteArrayEntity.setContentType("application/octet-stream;binary/octet-stream");
                    ((HttpPost)localObject1).setEntity(localByteArrayEntity);
                    ((HttpUriRequest)localObject1).addHeader("Accept-Charset", "UTF-8");
                    ((HttpUriRequest)localObject1).addHeader("Connection", "Keep-Alive");
                    ((HttpUriRequest)localObject1).addHeader("Keep-Alive", "timeout=180, max=100");
                    paramArrayOfByte = (byte[])localObject1;
                  }
                }
              }
            }
          }
        }
      }
      paramList = localb.a(paramArrayOfByte);
      paramArrayOfByte = paramList.getHeaders("X-Hostname");
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (paramArrayOfByte[0] != null)) {
        paramList.getHeaders("X-Hostname")[0].toString();
      }
      localObject1 = paramList.getHeaders("X-ExecuteTime");
      paramArrayOfByte = paramList;
      if (localObject1 != null)
      {
        paramArrayOfByte = paramList;
        if (localObject1.length > 0)
        {
          paramArrayOfByte = paramList;
          if (localObject1[0] != null)
          {
            paramList.getHeaders("X-ExecuteTime")[0].toString();
            paramArrayOfByte = paramList;
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */