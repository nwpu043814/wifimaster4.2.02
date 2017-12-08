package com.lantern.browser;

import android.text.TextUtils;
import com.bluefay.b.h;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public final class z
{
  private String a;
  private int b = 3000;
  private int c = 3000;
  
  public z(String paramString)
  {
    this.a = paramString;
  }
  
  public static final String b(Map<String, String> paramMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramMap = paramMap.entrySet().iterator();
    for (;;)
    {
      if (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        if (TextUtils.isEmpty((CharSequence)localEntry.getValue())) {
          continue;
        }
        localStringBuilder.append((String)localEntry.getKey());
        localStringBuilder.append("=");
        try
        {
          localStringBuilder.append(URLEncoder.encode((String)localEntry.getValue(), "UTF-8"));
          localStringBuilder.append("&");
        }
        catch (Exception localException)
        {
          for (;;)
          {
            h.a(localException);
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public final String a()
  {
    HttpGet localHttpGet = new HttpGet(this.a);
    try
    {
      Object localObject = new org/apache/http/params/BasicHttpParams;
      ((BasicHttpParams)localObject).<init>();
      HttpConnectionParams.setConnectionTimeout((HttpParams)localObject, this.b);
      HttpConnectionParams.setSoTimeout((HttpParams)localObject, this.c);
      localHttpGet.setParams((HttpParams)localObject);
      DefaultHttpClient localDefaultHttpClient = new org/apache/http/impl/client/DefaultHttpClient;
      localDefaultHttpClient.<init>((HttpParams)localObject);
      localObject = EntityUtils.toString(localDefaultHttpClient.execute(localHttpGet).getEntity(), "UTF-8");
      return (String)localObject;
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      throw localSocketTimeoutException;
    }
    catch (Exception localException)
    {
      throw new RuntimeException(localException);
    }
  }
  
  /* Error */
  public final String a(Map<String, String> paramMap)
  {
    // Byte code:
    //   0: new 144	org/apache/http/client/methods/HttpPost
    //   3: dup
    //   4: aload_0
    //   5: getfield 20	com/lantern/browser/z:a	Ljava/lang/String;
    //   8: invokespecial 145	org/apache/http/client/methods/HttpPost:<init>	(Ljava/lang/String;)V
    //   11: astore_2
    //   12: aload_1
    //   13: ifnull +102 -> 115
    //   16: new 147	java/util/ArrayList
    //   19: astore_3
    //   20: aload_3
    //   21: invokespecial 148	java/util/ArrayList:<init>	()V
    //   24: aload_1
    //   25: invokeinterface 33 1 0
    //   30: invokeinterface 39 1 0
    //   35: astore 4
    //   37: aload 4
    //   39: invokeinterface 45 1 0
    //   44: ifeq +55 -> 99
    //   47: aload 4
    //   49: invokeinterface 49 1 0
    //   54: checkcast 51	java/util/Map$Entry
    //   57: astore 5
    //   59: new 150	org/apache/http/message/BasicNameValuePair
    //   62: astore_1
    //   63: aload_1
    //   64: aload 5
    //   66: invokeinterface 65 1 0
    //   71: checkcast 67	java/lang/String
    //   74: aload 5
    //   76: invokeinterface 54 1 0
    //   81: checkcast 67	java/lang/String
    //   84: invokespecial 153	org/apache/http/message/BasicNameValuePair:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   87: aload_3
    //   88: aload_1
    //   89: invokevirtual 157	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   92: pop
    //   93: goto -56 -> 37
    //   96: astore_1
    //   97: aload_1
    //   98: athrow
    //   99: new 159	org/apache/http/client/entity/UrlEncodedFormEntity
    //   102: astore_1
    //   103: aload_1
    //   104: aload_3
    //   105: ldc 75
    //   107: invokespecial 162	org/apache/http/client/entity/UrlEncodedFormEntity:<init>	(Ljava/util/List;Ljava/lang/String;)V
    //   110: aload_2
    //   111: aload_1
    //   112: invokevirtual 166	org/apache/http/client/methods/HttpPost:setEntity	(Lorg/apache/http/HttpEntity;)V
    //   115: new 102	org/apache/http/params/BasicHttpParams
    //   118: astore_3
    //   119: aload_3
    //   120: invokespecial 103	org/apache/http/params/BasicHttpParams:<init>	()V
    //   123: aload_3
    //   124: aload_0
    //   125: getfield 16	com/lantern/browser/z:b	I
    //   128: invokestatic 109	org/apache/http/params/HttpConnectionParams:setConnectionTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   131: aload_3
    //   132: aload_0
    //   133: getfield 18	com/lantern/browser/z:c	I
    //   136: invokestatic 112	org/apache/http/params/HttpConnectionParams:setSoTimeout	(Lorg/apache/http/params/HttpParams;I)V
    //   139: aload_2
    //   140: aload_3
    //   141: invokevirtual 167	org/apache/http/client/methods/HttpPost:setParams	(Lorg/apache/http/params/HttpParams;)V
    //   144: new 118	org/apache/http/impl/client/DefaultHttpClient
    //   147: astore_1
    //   148: aload_1
    //   149: aload_3
    //   150: invokespecial 120	org/apache/http/impl/client/DefaultHttpClient:<init>	(Lorg/apache/http/params/HttpParams;)V
    //   153: aload_1
    //   154: aload_2
    //   155: invokeinterface 126 2 0
    //   160: invokeinterface 132 1 0
    //   165: ldc 75
    //   167: invokestatic 137	org/apache/http/util/EntityUtils:toString	(Lorg/apache/http/HttpEntity;Ljava/lang/String;)Ljava/lang/String;
    //   170: astore_1
    //   171: aload_1
    //   172: areturn
    //   173: astore_1
    //   174: new 139	java/lang/RuntimeException
    //   177: dup
    //   178: aload_1
    //   179: invokespecial 142	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	z
    //   0	183	1	paramMap	Map<String, String>
    //   11	144	2	localHttpPost	org.apache.http.client.methods.HttpPost
    //   19	131	3	localObject	Object
    //   35	13	4	localIterator	Iterator
    //   57	18	5	localEntry	Map.Entry
    // Exception table:
    //   from	to	target	type
    //   16	37	96	java/net/SocketTimeoutException
    //   37	93	96	java/net/SocketTimeoutException
    //   99	115	96	java/net/SocketTimeoutException
    //   115	171	96	java/net/SocketTimeoutException
    //   16	37	173	java/lang/Exception
    //   37	93	173	java/lang/Exception
    //   99	115	173	java/lang/Exception
    //   115	171	173	java/lang/Exception
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */