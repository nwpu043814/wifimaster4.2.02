package com.alipay.android.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.Callable;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public final class aa
  implements Callable
{
  private static final HttpRequestRetryHandler e = new i();
  protected u a;
  protected Context b;
  protected y c;
  String d;
  private HttpUriRequest f;
  private HttpContext g = new BasicHttpContext();
  private CookieStore h = new BasicCookieStore();
  private CookieManager i;
  private AbstractHttpEntity j;
  private HttpHost k;
  private URL l;
  private int m = 0;
  private boolean n = false;
  private boolean o = false;
  private String p = null;
  private String q;
  
  public aa(u paramu, y paramy)
  {
    this.a = paramu;
    this.b = this.a.a;
    this.c = paramy;
  }
  
  private static long a(String[] paramArrayOfString)
  {
    int i1 = 0;
    if (i1 < paramArrayOfString.length) {
      if ((!"max-age".equalsIgnoreCase(paramArrayOfString[i1])) || (paramArrayOfString[(i1 + 1)] == null)) {}
    }
    for (;;)
    {
      try
      {
        l1 = Long.parseLong(paramArrayOfString[(i1 + 1)]);
        return l1;
      }
      catch (Exception localException) {}
      i1++;
      break;
      long l1 = 0L;
    }
  }
  
  private ae a(HttpResponse paramHttpResponse, int paramInt, String paramString)
  {
    localByteArrayOutputStream = null;
    localObject2 = null;
    new StringBuilder("开始handle，handleResponse-1,").append(Thread.currentThread().getId());
    Object localObject1 = paramHttpResponse.getEntity();
    if ((localObject1 != null) && (paramHttpResponse.getStatusLine().getStatusCode() == 200))
    {
      new StringBuilder("200，开始处理，handleResponse-2,threadid = ").append(Thread.currentThread().getId());
      long l1;
      byte[] arrayOfByte;
      label224:
      try
      {
        localByteArrayOutputStream = new java/io/ByteArrayOutputStream;
        localByteArrayOutputStream.<init>();
      }
      finally {}
    }
    try
    {
      l1 = System.currentTimeMillis();
      a((HttpEntity)localObject1, localByteArrayOutputStream);
      arrayOfByte = localByteArrayOutputStream.toByteArray();
      this.o = false;
      this.a.c(System.currentTimeMillis() - l1);
      this.a.a(arrayOfByte.length);
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>("res:");
      ((StringBuilder)localObject1).append(arrayOfByte.length);
      localObject1 = new com/alipay/android/a/a/a/z;
      ((z)localObject1).<init>(a(paramHttpResponse), paramInt, paramString, arrayOfByte);
      l1 = b(paramHttpResponse);
      paramHttpResponse = paramHttpResponse.getEntity().getContentType();
      if (paramHttpResponse == null) {
        break label337;
      }
      paramHttpResponse = a(paramHttpResponse.getValue());
      paramString = (String)paramHttpResponse.get("charset");
      paramHttpResponse = (String)paramHttpResponse.get("Content-Type");
    }
    finally
    {
      for (;;)
      {
        paramString = localByteArrayOutputStream;
      }
      paramHttpResponse = null;
      paramString = (String)localObject2;
      break label224;
    }
    ((z)localObject1).b(paramHttpResponse);
    ((z)localObject1).a(paramString);
    ((z)localObject1).a(System.currentTimeMillis());
    ((z)localObject1).b(l1);
    for (;;)
    {
      try
      {
        localByteArrayOutputStream.close();
        paramString = (String)localObject1;
        return paramString;
      }
      catch (IOException paramHttpResponse)
      {
        throw new RuntimeException("ArrayOutputStream close error!", paramHttpResponse.getCause());
      }
      if (paramString != null) {}
      try
      {
        paramString.close();
        throw paramHttpResponse;
      }
      catch (IOException paramHttpResponse)
      {
        throw new RuntimeException("ArrayOutputStream close error!", paramHttpResponse.getCause());
      }
      paramString = localByteArrayOutputStream;
      if (localObject1 == null)
      {
        paramHttpResponse.getStatusLine().getStatusCode();
        paramString = localByteArrayOutputStream;
      }
    }
  }
  
  private static x a(HttpResponse paramHttpResponse)
  {
    x localx = new x();
    for (Object localObject : paramHttpResponse.getAllHeaders()) {
      localx.a(((Header)localObject).getName(), ((Header)localObject).getValue());
    }
    return localx;
  }
  
  private static HashMap a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    String[] arrayOfString = paramString.split(";");
    int i2 = arrayOfString.length;
    int i1 = 0;
    if (i1 < i2)
    {
      String str = arrayOfString[i1];
      if (str.indexOf('=') == -1)
      {
        paramString = new String[2];
        paramString[0] = "Content-Type";
        paramString[1] = str;
      }
      for (;;)
      {
        localHashMap.put(paramString[0], paramString[1]);
        i1++;
        break;
        paramString = str.split("=");
      }
    }
    return localHashMap;
  }
  
  private void a(HttpEntity paramHttpEntity, OutputStream paramOutputStream)
  {
    InputStream localInputStream = j.a(paramHttpEntity);
    long l1 = paramHttpEntity.getContentLength();
    try
    {
      paramHttpEntity = new byte['ࠀ'];
      for (;;)
      {
        int i1 = localInputStream.read(paramHttpEntity);
        if ((i1 == -1) || (this.c.h())) {
          break;
        }
        paramOutputStream.write(paramHttpEntity, 0, i1);
        if ((this.c.f() == null) || (l1 <= 0L)) {}
      }
      paramOutputStream.flush();
      return;
    }
    catch (Exception paramHttpEntity)
    {
      paramHttpEntity.getCause();
      paramOutputStream = new java/io/IOException;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("HttpWorker Request Error!");
      paramOutputStream.<init>(paramHttpEntity.getLocalizedMessage());
      throw paramOutputStream;
    }
    finally
    {
      ab.a(localInputStream);
    }
  }
  
  private static long b(HttpResponse paramHttpResponse)
  {
    long l2 = 0L;
    Object localObject = paramHttpResponse.getFirstHeader("Cache-Control");
    if (localObject != null)
    {
      localObject = ((Header)localObject).getValue().split("=");
      if (localObject.length < 2) {}
    }
    for (;;)
    {
      try
      {
        l1 = a((String[])localObject);
        return l1;
      }
      catch (NumberFormatException localNumberFormatException) {}
      paramHttpResponse = paramHttpResponse.getFirstHeader("Expires");
      long l1 = l2;
      if (paramHttpResponse != null) {
        l1 = j.b(paramHttpResponse.getValue()) - System.currentTimeMillis();
      }
    }
  }
  
  private URI b()
  {
    String str = this.c.a();
    if (this.d != null) {
      str = this.d;
    }
    if (str == null) {
      throw new RuntimeException("url should not be null");
    }
    return new URI(str);
  }
  
  private HttpUriRequest c()
  {
    Object localObject1;
    if (this.f != null)
    {
      localObject1 = this.f;
      return (HttpUriRequest)localObject1;
    }
    if (this.j == null)
    {
      localObject1 = this.c.b();
      localObject2 = this.c.b("gzip");
      if (localObject1 != null)
      {
        if (!TextUtils.equals((CharSequence)localObject2, "true")) {
          break label115;
        }
        this.j = j.a((byte[])localObject1);
        label62:
        this.j.setContentType(this.c.c());
      }
    }
    Object localObject2 = this.j;
    if (localObject2 != null)
    {
      localObject1 = new HttpPost(b());
      ((HttpPost)localObject1).setEntity((HttpEntity)localObject2);
    }
    for (this.f = ((HttpUriRequest)localObject1);; this.f = new HttpGet(b()))
    {
      localObject1 = this.f;
      break;
      label115:
      this.j = new ByteArrayEntity((byte[])localObject1);
      break label62;
    }
  }
  
  /* Error */
  private ae d()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 75	com/alipay/android/a/a/a/aa:b	Landroid/content/Context;
    //   4: ldc_w 398
    //   7: invokevirtual 404	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   10: checkcast 406	android/net/ConnectivityManager
    //   13: invokevirtual 410	android/net/ConnectivityManager:getAllNetworkInfo	()[Landroid/net/NetworkInfo;
    //   16: astore 8
    //   18: aload 8
    //   20: ifnonnull +51 -> 71
    //   23: iconst_0
    //   24: istore_1
    //   25: iload_1
    //   26: ifne +94 -> 120
    //   29: new 374	com/alipay/android/a/a/a/t
    //   32: astore 7
    //   34: aload 7
    //   36: iconst_1
    //   37: invokestatic 416	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: ldc_w 418
    //   43: invokespecial 421	com/alipay/android/a/a/a/t:<init>	(Ljava/lang/Integer;Ljava/lang/String;)V
    //   46: aload 7
    //   48: athrow
    //   49: astore 7
    //   51: aload_0
    //   52: invokespecial 423	com/alipay/android/a/a/a/aa:e	()V
    //   55: new 99	java/lang/StringBuilder
    //   58: dup
    //   59: invokespecial 424	java/lang/StringBuilder:<init>	()V
    //   62: aload 7
    //   64: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 7
    //   70: athrow
    //   71: aload 8
    //   73: arraylength
    //   74: istore_2
    //   75: iconst_0
    //   76: istore_1
    //   77: iload_1
    //   78: iload_2
    //   79: if_icmpge +1533 -> 1612
    //   82: aload 8
    //   84: iload_1
    //   85: aaload
    //   86: astore 7
    //   88: aload 7
    //   90: ifnull +24 -> 114
    //   93: aload 7
    //   95: invokevirtual 432	android/net/NetworkInfo:isAvailable	()Z
    //   98: ifeq +16 -> 114
    //   101: aload 7
    //   103: invokevirtual 435	android/net/NetworkInfo:isConnectedOrConnecting	()Z
    //   106: ifeq +8 -> 114
    //   109: iconst_1
    //   110: istore_1
    //   111: goto -86 -> 25
    //   114: iinc 1 1
    //   117: goto -40 -> 77
    //   120: aload_0
    //   121: getfield 77	com/alipay/android/a/a/a/aa:c	Lcom/alipay/android/a/a/a/y;
    //   124: invokevirtual 438	com/alipay/android/a/a/a/y:d	()Ljava/util/ArrayList;
    //   127: astore 7
    //   129: aload 7
    //   131: ifnull +72 -> 203
    //   134: aload 7
    //   136: invokevirtual 443	java/util/ArrayList:isEmpty	()Z
    //   139: ifne +64 -> 203
    //   142: aload 7
    //   144: invokevirtual 447	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   147: astore 7
    //   149: aload 7
    //   151: invokeinterface 452 1 0
    //   156: ifeq +47 -> 203
    //   159: aload 7
    //   161: invokeinterface 456 1 0
    //   166: checkcast 180	org/apache/http/Header
    //   169: astore 8
    //   171: aload_0
    //   172: invokespecial 458	com/alipay/android/a/a/a/aa:c	()Lorg/apache/http/client/methods/HttpUriRequest;
    //   175: aload 8
    //   177: invokeinterface 464 2 0
    //   182: goto -33 -> 149
    //   185: astore 7
    //   187: new 209	java/lang/RuntimeException
    //   190: dup
    //   191: ldc_w 466
    //   194: aload 7
    //   196: invokevirtual 467	java/net/URISyntaxException:getCause	()Ljava/lang/Throwable;
    //   199: invokespecial 218	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   202: athrow
    //   203: aload_0
    //   204: invokespecial 458	com/alipay/android/a/a/a/aa:c	()Lorg/apache/http/client/methods/HttpUriRequest;
    //   207: invokestatic 470	com/alipay/android/a/a/a/j:a	(Lorg/apache/http/HttpRequest;)V
    //   210: aload_0
    //   211: invokespecial 458	com/alipay/android/a/a/a/aa:c	()Lorg/apache/http/client/methods/HttpUriRequest;
    //   214: invokestatic 472	com/alipay/android/a/a/a/j:b	(Lorg/apache/http/HttpRequest;)V
    //   217: aload_0
    //   218: invokespecial 458	com/alipay/android/a/a/a/aa:c	()Lorg/apache/http/client/methods/HttpUriRequest;
    //   221: ldc_w 474
    //   224: aload_0
    //   225: invokespecial 477	com/alipay/android/a/a/a/aa:i	()Landroid/webkit/CookieManager;
    //   228: aload_0
    //   229: getfield 77	com/alipay/android/a/a/a/aa:c	Lcom/alipay/android/a/a/a/y;
    //   232: invokevirtual 314	com/alipay/android/a/a/a/y:a	()Ljava/lang/String;
    //   235: invokevirtual 482	android/webkit/CookieManager:getCookie	(Ljava/lang/String;)Ljava/lang/String;
    //   238: invokeinterface 484 3 0
    //   243: aload_0
    //   244: getfield 54	com/alipay/android/a/a/a/aa:g	Lorg/apache/http/protocol/HttpContext;
    //   247: ldc_w 486
    //   250: aload_0
    //   251: getfield 59	com/alipay/android/a/a/a/aa:h	Lorg/apache/http/client/CookieStore;
    //   254: invokeinterface 492 3 0
    //   259: aload_0
    //   260: getfield 69	com/alipay/android/a/a/a/aa:a	Lcom/alipay/android/a/a/a/u;
    //   263: invokevirtual 495	com/alipay/android/a/a/a/u:a	()Lcom/alipay/android/a/a/a/j;
    //   266: getstatic 46	com/alipay/android/a/a/a/aa:e	Lorg/apache/http/client/HttpRequestRetryHandler;
    //   269: invokevirtual 498	com/alipay/android/a/a/a/j:a	(Lorg/apache/http/client/HttpRequestRetryHandler;)V
    //   272: invokestatic 144	java/lang/System:currentTimeMillis	()J
    //   275: lstore_3
    //   276: new 99	java/lang/StringBuilder
    //   279: astore 7
    //   281: aload 7
    //   283: ldc_w 500
    //   286: invokespecial 104	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   289: aload 7
    //   291: aload_0
    //   292: invokespecial 502	com/alipay/android/a/a/a/aa:f	()Ljava/lang/String;
    //   295: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: ldc_w 504
    //   301: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload_0
    //   305: getfield 325	com/alipay/android/a/a/a/aa:f	Lorg/apache/http/client/methods/HttpUriRequest;
    //   308: invokeinterface 507 1 0
    //   313: invokevirtual 508	java/net/URI:toString	()Ljava/lang/String;
    //   316: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload_0
    //   321: getfield 69	com/alipay/android/a/a/a/aa:a	Lcom/alipay/android/a/a/a/u;
    //   324: invokevirtual 495	com/alipay/android/a/a/a/u:a	()Lcom/alipay/android/a/a/a/j;
    //   327: invokevirtual 512	com/alipay/android/a/a/a/j:getParams	()Lorg/apache/http/params/HttpParams;
    //   330: astore 9
    //   332: aload_0
    //   333: getfield 75	com/alipay/android/a/a/a/aa:b	Landroid/content/Context;
    //   336: ldc_w 398
    //   339: invokevirtual 404	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   342: checkcast 406	android/net/ConnectivityManager
    //   345: invokevirtual 516	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   348: astore 7
    //   350: aload 7
    //   352: ifnull +1254 -> 1606
    //   355: aload 7
    //   357: invokevirtual 432	android/net/NetworkInfo:isAvailable	()Z
    //   360: ifeq +1246 -> 1606
    //   363: invokestatic 521	android/net/Proxy:getDefaultHost	()Ljava/lang/String;
    //   366: astore 8
    //   368: invokestatic 524	android/net/Proxy:getDefaultPort	()I
    //   371: istore_1
    //   372: aload 8
    //   374: ifnull +1232 -> 1606
    //   377: new 526	org/apache/http/HttpHost
    //   380: astore 7
    //   382: aload 7
    //   384: aload 8
    //   386: iload_1
    //   387: invokespecial 529	org/apache/http/HttpHost:<init>	(Ljava/lang/String;I)V
    //   390: aload 7
    //   392: astore 8
    //   394: aload 7
    //   396: ifnull +39 -> 435
    //   399: aload 7
    //   401: astore 8
    //   403: aload 7
    //   405: invokevirtual 532	org/apache/http/HttpHost:getHostName	()Ljava/lang/String;
    //   408: ldc_w 534
    //   411: invokestatic 342	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   414: ifeq +21 -> 435
    //   417: aload 7
    //   419: astore 8
    //   421: aload 7
    //   423: invokevirtual 537	org/apache/http/HttpHost:getPort	()I
    //   426: sipush 8087
    //   429: if_icmpne +6 -> 435
    //   432: aconst_null
    //   433: astore 8
    //   435: aload 9
    //   437: ldc_w 539
    //   440: aload 8
    //   442: invokeinterface 545 3 0
    //   447: pop
    //   448: aload_0
    //   449: getfield 547	com/alipay/android/a/a/a/aa:k	Lorg/apache/http/HttpHost;
    //   452: ifnull +311 -> 763
    //   455: aload_0
    //   456: getfield 547	com/alipay/android/a/a/a/aa:k	Lorg/apache/http/HttpHost;
    //   459: astore 7
    //   461: aload_0
    //   462: invokespecial 549	com/alipay/android/a/a/a/aa:g	()I
    //   465: bipush 80
    //   467: if_icmpne +20 -> 487
    //   470: new 526	org/apache/http/HttpHost
    //   473: astore 7
    //   475: aload 7
    //   477: aload_0
    //   478: invokespecial 552	com/alipay/android/a/a/a/aa:h	()Ljava/net/URL;
    //   481: invokevirtual 557	java/net/URL:getHost	()Ljava/lang/String;
    //   484: invokespecial 558	org/apache/http/HttpHost:<init>	(Ljava/lang/String;)V
    //   487: aload_0
    //   488: getfield 69	com/alipay/android/a/a/a/aa:a	Lcom/alipay/android/a/a/a/u;
    //   491: invokevirtual 495	com/alipay/android/a/a/a/u:a	()Lcom/alipay/android/a/a/a/j;
    //   494: aload 7
    //   496: aload_0
    //   497: getfield 325	com/alipay/android/a/a/a/aa:f	Lorg/apache/http/client/methods/HttpUriRequest;
    //   500: aload_0
    //   501: getfield 54	com/alipay/android/a/a/a/aa:g	Lorg/apache/http/protocol/HttpContext;
    //   504: invokevirtual 562	com/alipay/android/a/a/a/j:execute	(Lorg/apache/http/HttpHost;Lorg/apache/http/HttpRequest;Lorg/apache/http/protocol/HttpContext;)Lorg/apache/http/HttpResponse;
    //   507: astore 8
    //   509: invokestatic 144	java/lang/System:currentTimeMillis	()J
    //   512: lstore 5
    //   514: aload_0
    //   515: getfield 69	com/alipay/android/a/a/a/aa:a	Lcom/alipay/android/a/a/a/u;
    //   518: lload 5
    //   520: lload_3
    //   521: lsub
    //   522: invokevirtual 563	com/alipay/android/a/a/a/u:b	(J)V
    //   525: aload_0
    //   526: getfield 59	com/alipay/android/a/a/a/aa:h	Lorg/apache/http/client/CookieStore;
    //   529: invokeinterface 569 1 0
    //   534: astore 7
    //   536: aload_0
    //   537: getfield 77	com/alipay/android/a/a/a/aa:c	Lcom/alipay/android/a/a/a/y;
    //   540: invokevirtual 571	com/alipay/android/a/a/a/y:e	()Z
    //   543: ifeq +10 -> 553
    //   546: aload_0
    //   547: invokespecial 477	com/alipay/android/a/a/a/aa:i	()Landroid/webkit/CookieManager;
    //   550: invokevirtual 574	android/webkit/CookieManager:removeAllCookie	()V
    //   553: aload 7
    //   555: invokeinterface 577 1 0
    //   560: ifne +256 -> 816
    //   563: aload 7
    //   565: invokeinterface 578 1 0
    //   570: astore 9
    //   572: aload 9
    //   574: invokeinterface 452 1 0
    //   579: ifeq +237 -> 816
    //   582: aload 9
    //   584: invokeinterface 456 1 0
    //   589: checkcast 580	org/apache/http/cookie/Cookie
    //   592: astore 7
    //   594: aload 7
    //   596: invokeinterface 583 1 0
    //   601: ifnull -29 -> 572
    //   604: new 99	java/lang/StringBuilder
    //   607: astore 10
    //   609: aload 10
    //   611: invokespecial 424	java/lang/StringBuilder:<init>	()V
    //   614: aload 10
    //   616: aload 7
    //   618: invokeinterface 584 1 0
    //   623: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   626: ldc -8
    //   628: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: aload 7
    //   633: invokeinterface 585 1 0
    //   638: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: ldc_w 587
    //   644: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: aload 7
    //   649: invokeinterface 583 1 0
    //   654: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: astore 10
    //   659: aload 7
    //   661: invokeinterface 590 1 0
    //   666: ifeq +142 -> 808
    //   669: ldc_w 592
    //   672: astore 7
    //   674: aload 10
    //   676: aload 7
    //   678: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   681: invokevirtual 296	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   684: astore 7
    //   686: aload_0
    //   687: invokespecial 477	com/alipay/android/a/a/a/aa:i	()Landroid/webkit/CookieManager;
    //   690: aload_0
    //   691: getfield 77	com/alipay/android/a/a/a/aa:c	Lcom/alipay/android/a/a/a/y;
    //   694: invokevirtual 314	com/alipay/android/a/a/a/y:a	()Ljava/lang/String;
    //   697: aload 7
    //   699: invokevirtual 595	android/webkit/CookieManager:setCookie	(Ljava/lang/String;Ljava/lang/String;)V
    //   702: invokestatic 601	android/webkit/CookieSyncManager:getInstance	()Landroid/webkit/CookieSyncManager;
    //   705: invokevirtual 604	android/webkit/CookieSyncManager:sync	()V
    //   708: goto -136 -> 572
    //   711: astore 7
    //   713: aload_0
    //   714: invokespecial 423	com/alipay/android/a/a/a/aa:e	()V
    //   717: aload_0
    //   718: getfield 77	com/alipay/android/a/a/a/aa:c	Lcom/alipay/android/a/a/a/y;
    //   721: invokevirtual 276	com/alipay/android/a/a/a/y:f	()Lcom/alipay/android/a/a/a/h;
    //   724: ifnull +9 -> 733
    //   727: aload 7
    //   729: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   732: pop
    //   733: new 99	java/lang/StringBuilder
    //   736: dup
    //   737: invokespecial 424	java/lang/StringBuilder:<init>	()V
    //   740: aload 7
    //   742: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   745: pop
    //   746: new 374	com/alipay/android/a/a/a/t
    //   749: dup
    //   750: iconst_2
    //   751: invokestatic 416	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   754: aload 7
    //   756: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   759: invokespecial 421	com/alipay/android/a/a/a/t:<init>	(Ljava/lang/Integer;Ljava/lang/String;)V
    //   762: athrow
    //   763: aload_0
    //   764: invokespecial 552	com/alipay/android/a/a/a/aa:h	()Ljava/net/URL;
    //   767: astore 7
    //   769: new 526	org/apache/http/HttpHost
    //   772: astore 8
    //   774: aload 8
    //   776: aload 7
    //   778: invokevirtual 557	java/net/URL:getHost	()Ljava/lang/String;
    //   781: aload_0
    //   782: invokespecial 549	com/alipay/android/a/a/a/aa:g	()I
    //   785: aload 7
    //   787: invokevirtual 610	java/net/URL:getProtocol	()Ljava/lang/String;
    //   790: invokespecial 613	org/apache/http/HttpHost:<init>	(Ljava/lang/String;ILjava/lang/String;)V
    //   793: aload_0
    //   794: aload 8
    //   796: putfield 547	com/alipay/android/a/a/a/aa:k	Lorg/apache/http/HttpHost;
    //   799: aload_0
    //   800: getfield 547	com/alipay/android/a/a/a/aa:k	Lorg/apache/http/HttpHost;
    //   803: astore 7
    //   805: goto -344 -> 461
    //   808: ldc_w 615
    //   811: astore 7
    //   813: goto -139 -> 674
    //   816: aload 8
    //   818: invokeinterface 128 1 0
    //   823: invokeinterface 134 1 0
    //   828: istore_2
    //   829: aload 8
    //   831: invokeinterface 128 1 0
    //   836: invokeinterface 618 1 0
    //   841: astore 7
    //   843: iload_2
    //   844: sipush 200
    //   847: if_icmpeq +113 -> 960
    //   850: iload_2
    //   851: sipush 304
    //   854: if_icmpne +101 -> 955
    //   857: iconst_1
    //   858: istore_1
    //   859: iload_1
    //   860: ifne +100 -> 960
    //   863: new 374	com/alipay/android/a/a/a/t
    //   866: astore 7
    //   868: aload 7
    //   870: aload 8
    //   872: invokeinterface 128 1 0
    //   877: invokeinterface 134 1 0
    //   882: invokestatic 416	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   885: aload 8
    //   887: invokeinterface 128 1 0
    //   892: invokeinterface 618 1 0
    //   897: invokespecial 421	com/alipay/android/a/a/a/t:<init>	(Ljava/lang/Integer;Ljava/lang/String;)V
    //   900: aload 7
    //   902: athrow
    //   903: astore 7
    //   905: aload_0
    //   906: invokespecial 423	com/alipay/android/a/a/a/aa:e	()V
    //   909: aload_0
    //   910: getfield 77	com/alipay/android/a/a/a/aa:c	Lcom/alipay/android/a/a/a/y;
    //   913: invokevirtual 276	com/alipay/android/a/a/a/y:f	()Lcom/alipay/android/a/a/a/h;
    //   916: ifnull +9 -> 925
    //   919: aload 7
    //   921: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   924: pop
    //   925: new 99	java/lang/StringBuilder
    //   928: dup
    //   929: invokespecial 424	java/lang/StringBuilder:<init>	()V
    //   932: aload 7
    //   934: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   937: pop
    //   938: new 374	com/alipay/android/a/a/a/t
    //   941: dup
    //   942: iconst_2
    //   943: invokestatic 416	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   946: aload 7
    //   948: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   951: invokespecial 421	com/alipay/android/a/a/a/t:<init>	(Ljava/lang/Integer;Ljava/lang/String;)V
    //   954: athrow
    //   955: iconst_0
    //   956: istore_1
    //   957: goto -98 -> 859
    //   960: aload_0
    //   961: aload 8
    //   963: iload_2
    //   964: aload 7
    //   966: invokespecial 620	com/alipay/android/a/a/a/aa:a	(Lorg/apache/http/HttpResponse;ILjava/lang/String;)Lcom/alipay/android/a/a/a/ae;
    //   969: astore 7
    //   971: ldc2_w 621
    //   974: lstore 5
    //   976: lload 5
    //   978: lstore_3
    //   979: aload 7
    //   981: ifnull +22 -> 1003
    //   984: lload 5
    //   986: lstore_3
    //   987: aload 7
    //   989: invokevirtual 625	com/alipay/android/a/a/a/ae:b	()[B
    //   992: ifnull +11 -> 1003
    //   995: aload 7
    //   997: invokevirtual 625	com/alipay/android/a/a/a/ae:b	()[B
    //   1000: arraylength
    //   1001: i2l
    //   1002: lstore_3
    //   1003: lload_3
    //   1004: ldc2_w 621
    //   1007: lcmp
    //   1008: ifne +33 -> 1041
    //   1011: aload 7
    //   1013: instanceof 163
    //   1016: ifeq +25 -> 1041
    //   1019: aload 7
    //   1021: checkcast 163	com/alipay/android/a/a/a/z
    //   1024: astore 8
    //   1026: aload 8
    //   1028: invokevirtual 628	com/alipay/android/a/a/a/z:a	()Lcom/alipay/android/a/a/a/x;
    //   1031: ldc_w 630
    //   1034: invokevirtual 632	com/alipay/android/a/a/a/x:a	(Ljava/lang/String;)Ljava/lang/String;
    //   1037: invokestatic 94	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   1040: pop2
    //   1041: aload_0
    //   1042: getfield 77	com/alipay/android/a/a/a/aa:c	Lcom/alipay/android/a/a/a/y;
    //   1045: invokevirtual 314	com/alipay/android/a/a/a/y:a	()Ljava/lang/String;
    //   1048: astore 8
    //   1050: aload 8
    //   1052: ifnull +44 -> 1096
    //   1055: aload_0
    //   1056: invokespecial 502	com/alipay/android/a/a/a/aa:f	()Ljava/lang/String;
    //   1059: invokestatic 635	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1062: ifne +34 -> 1096
    //   1065: new 99	java/lang/StringBuilder
    //   1068: astore 9
    //   1070: aload 9
    //   1072: invokespecial 424	java/lang/StringBuilder:<init>	()V
    //   1075: aload 9
    //   1077: aload 8
    //   1079: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1082: ldc_w 637
    //   1085: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1088: aload_0
    //   1089: invokespecial 502	com/alipay/android/a/a/a/aa:f	()Ljava/lang/String;
    //   1092: invokevirtual 293	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: pop
    //   1096: aload 7
    //   1098: areturn
    //   1099: astore 7
    //   1101: aload_0
    //   1102: invokespecial 423	com/alipay/android/a/a/a/aa:e	()V
    //   1105: aload_0
    //   1106: getfield 77	com/alipay/android/a/a/a/aa:c	Lcom/alipay/android/a/a/a/y;
    //   1109: invokevirtual 276	com/alipay/android/a/a/a/y:f	()Lcom/alipay/android/a/a/a/h;
    //   1112: ifnull +9 -> 1121
    //   1115: aload 7
    //   1117: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1120: pop
    //   1121: new 99	java/lang/StringBuilder
    //   1124: dup
    //   1125: invokespecial 424	java/lang/StringBuilder:<init>	()V
    //   1128: aload 7
    //   1130: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1133: pop
    //   1134: new 374	com/alipay/android/a/a/a/t
    //   1137: dup
    //   1138: bipush 6
    //   1140: invokestatic 416	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1143: aload 7
    //   1145: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1148: invokespecial 421	com/alipay/android/a/a/a/t:<init>	(Ljava/lang/Integer;Ljava/lang/String;)V
    //   1151: athrow
    //   1152: astore 7
    //   1154: aload_0
    //   1155: invokespecial 423	com/alipay/android/a/a/a/aa:e	()V
    //   1158: aload_0
    //   1159: getfield 77	com/alipay/android/a/a/a/aa:c	Lcom/alipay/android/a/a/a/y;
    //   1162: invokevirtual 276	com/alipay/android/a/a/a/y:f	()Lcom/alipay/android/a/a/a/h;
    //   1165: ifnull +9 -> 1174
    //   1168: aload 7
    //   1170: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1173: pop
    //   1174: new 99	java/lang/StringBuilder
    //   1177: dup
    //   1178: invokespecial 424	java/lang/StringBuilder:<init>	()V
    //   1181: aload 7
    //   1183: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1186: pop
    //   1187: new 374	com/alipay/android/a/a/a/t
    //   1190: dup
    //   1191: iconst_3
    //   1192: invokestatic 416	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1195: aload 7
    //   1197: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1200: invokespecial 421	com/alipay/android/a/a/a/t:<init>	(Ljava/lang/Integer;Ljava/lang/String;)V
    //   1203: athrow
    //   1204: astore 7
    //   1206: aload_0
    //   1207: invokespecial 423	com/alipay/android/a/a/a/aa:e	()V
    //   1210: aload_0
    //   1211: getfield 77	com/alipay/android/a/a/a/aa:c	Lcom/alipay/android/a/a/a/y;
    //   1214: invokevirtual 276	com/alipay/android/a/a/a/y:f	()Lcom/alipay/android/a/a/a/h;
    //   1217: ifnull +9 -> 1226
    //   1220: aload 7
    //   1222: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1225: pop
    //   1226: new 99	java/lang/StringBuilder
    //   1229: dup
    //   1230: invokespecial 424	java/lang/StringBuilder:<init>	()V
    //   1233: aload 7
    //   1235: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1238: pop
    //   1239: new 374	com/alipay/android/a/a/a/t
    //   1242: dup
    //   1243: iconst_3
    //   1244: invokestatic 416	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1247: aload 7
    //   1249: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1252: invokespecial 421	com/alipay/android/a/a/a/t:<init>	(Ljava/lang/Integer;Ljava/lang/String;)V
    //   1255: athrow
    //   1256: astore 7
    //   1258: aload_0
    //   1259: invokespecial 423	com/alipay/android/a/a/a/aa:e	()V
    //   1262: aload_0
    //   1263: getfield 77	com/alipay/android/a/a/a/aa:c	Lcom/alipay/android/a/a/a/y;
    //   1266: invokevirtual 276	com/alipay/android/a/a/a/y:f	()Lcom/alipay/android/a/a/a/h;
    //   1269: ifnull +9 -> 1278
    //   1272: aload 7
    //   1274: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1277: pop
    //   1278: new 99	java/lang/StringBuilder
    //   1281: dup
    //   1282: invokespecial 424	java/lang/StringBuilder:<init>	()V
    //   1285: aload 7
    //   1287: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1290: pop
    //   1291: new 374	com/alipay/android/a/a/a/t
    //   1294: dup
    //   1295: iconst_4
    //   1296: invokestatic 416	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1299: aload 7
    //   1301: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1304: invokespecial 421	com/alipay/android/a/a/a/t:<init>	(Ljava/lang/Integer;Ljava/lang/String;)V
    //   1307: athrow
    //   1308: astore 7
    //   1310: aload_0
    //   1311: invokespecial 423	com/alipay/android/a/a/a/aa:e	()V
    //   1314: aload_0
    //   1315: getfield 77	com/alipay/android/a/a/a/aa:c	Lcom/alipay/android/a/a/a/y;
    //   1318: invokevirtual 276	com/alipay/android/a/a/a/y:f	()Lcom/alipay/android/a/a/a/h;
    //   1321: ifnull +9 -> 1330
    //   1324: aload 7
    //   1326: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1329: pop
    //   1330: new 99	java/lang/StringBuilder
    //   1333: dup
    //   1334: invokespecial 424	java/lang/StringBuilder:<init>	()V
    //   1337: aload 7
    //   1339: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1342: pop
    //   1343: new 374	com/alipay/android/a/a/a/t
    //   1346: dup
    //   1347: iconst_5
    //   1348: invokestatic 416	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1351: aload 7
    //   1353: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1356: invokespecial 421	com/alipay/android/a/a/a/t:<init>	(Ljava/lang/Integer;Ljava/lang/String;)V
    //   1359: athrow
    //   1360: astore 7
    //   1362: aload_0
    //   1363: invokespecial 423	com/alipay/android/a/a/a/aa:e	()V
    //   1366: aload_0
    //   1367: getfield 77	com/alipay/android/a/a/a/aa:c	Lcom/alipay/android/a/a/a/y;
    //   1370: invokevirtual 276	com/alipay/android/a/a/a/y:f	()Lcom/alipay/android/a/a/a/h;
    //   1373: ifnull +9 -> 1382
    //   1376: aload 7
    //   1378: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1381: pop
    //   1382: new 374	com/alipay/android/a/a/a/t
    //   1385: dup
    //   1386: bipush 8
    //   1388: invokestatic 416	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1391: aload 7
    //   1393: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1396: invokespecial 421	com/alipay/android/a/a/a/t:<init>	(Ljava/lang/Integer;Ljava/lang/String;)V
    //   1399: athrow
    //   1400: astore 7
    //   1402: aload_0
    //   1403: invokespecial 423	com/alipay/android/a/a/a/aa:e	()V
    //   1406: aload_0
    //   1407: getfield 77	com/alipay/android/a/a/a/aa:c	Lcom/alipay/android/a/a/a/y;
    //   1410: invokevirtual 276	com/alipay/android/a/a/a/y:f	()Lcom/alipay/android/a/a/a/h;
    //   1413: ifnull +9 -> 1422
    //   1416: aload 7
    //   1418: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1421: pop
    //   1422: new 99	java/lang/StringBuilder
    //   1425: dup
    //   1426: invokespecial 424	java/lang/StringBuilder:<init>	()V
    //   1429: aload 7
    //   1431: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1434: pop
    //   1435: new 374	com/alipay/android/a/a/a/t
    //   1438: dup
    //   1439: bipush 9
    //   1441: invokestatic 416	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1444: aload 7
    //   1446: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1449: invokespecial 421	com/alipay/android/a/a/a/t:<init>	(Ljava/lang/Integer;Ljava/lang/String;)V
    //   1452: athrow
    //   1453: astore 7
    //   1455: aload_0
    //   1456: invokespecial 423	com/alipay/android/a/a/a/aa:e	()V
    //   1459: aload_0
    //   1460: getfield 77	com/alipay/android/a/a/a/aa:c	Lcom/alipay/android/a/a/a/y;
    //   1463: invokevirtual 276	com/alipay/android/a/a/a/y:f	()Lcom/alipay/android/a/a/a/h;
    //   1466: ifnull +9 -> 1475
    //   1469: aload 7
    //   1471: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1474: pop
    //   1475: new 99	java/lang/StringBuilder
    //   1478: dup
    //   1479: invokespecial 424	java/lang/StringBuilder:<init>	()V
    //   1482: aload 7
    //   1484: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1487: pop
    //   1488: new 374	com/alipay/android/a/a/a/t
    //   1491: dup
    //   1492: bipush 6
    //   1494: invokestatic 416	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1497: aload 7
    //   1499: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1502: invokespecial 421	com/alipay/android/a/a/a/t:<init>	(Ljava/lang/Integer;Ljava/lang/String;)V
    //   1505: athrow
    //   1506: astore 7
    //   1508: aload_0
    //   1509: invokespecial 423	com/alipay/android/a/a/a/aa:e	()V
    //   1512: aload_0
    //   1513: getfield 61	com/alipay/android/a/a/a/aa:m	I
    //   1516: ifgt +16 -> 1532
    //   1519: aload_0
    //   1520: aload_0
    //   1521: getfield 61	com/alipay/android/a/a/a/aa:m	I
    //   1524: iconst_1
    //   1525: iadd
    //   1526: putfield 61	com/alipay/android/a/a/a/aa:m	I
    //   1529: goto -1529 -> 0
    //   1532: new 99	java/lang/StringBuilder
    //   1535: dup
    //   1536: invokespecial 424	java/lang/StringBuilder:<init>	()V
    //   1539: aload 7
    //   1541: invokevirtual 427	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1544: pop
    //   1545: new 374	com/alipay/android/a/a/a/t
    //   1548: dup
    //   1549: iconst_0
    //   1550: invokestatic 416	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1553: aload 7
    //   1555: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1558: invokespecial 421	com/alipay/android/a/a/a/t:<init>	(Ljava/lang/Integer;Ljava/lang/String;)V
    //   1561: athrow
    //   1562: astore 7
    //   1564: aload_0
    //   1565: invokespecial 423	com/alipay/android/a/a/a/aa:e	()V
    //   1568: aload_0
    //   1569: getfield 77	com/alipay/android/a/a/a/aa:c	Lcom/alipay/android/a/a/a/y;
    //   1572: invokevirtual 276	com/alipay/android/a/a/a/y:f	()Lcom/alipay/android/a/a/a/h;
    //   1575: ifnull +9 -> 1584
    //   1578: aload 7
    //   1580: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1583: pop
    //   1584: new 374	com/alipay/android/a/a/a/t
    //   1587: dup
    //   1588: iconst_0
    //   1589: invokestatic 416	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1592: aload 7
    //   1594: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   1597: invokespecial 421	com/alipay/android/a/a/a/t:<init>	(Ljava/lang/Integer;Ljava/lang/String;)V
    //   1600: athrow
    //   1601: astore 8
    //   1603: goto -562 -> 1041
    //   1606: aconst_null
    //   1607: astore 7
    //   1609: goto -1219 -> 390
    //   1612: iconst_0
    //   1613: istore_1
    //   1614: goto -1589 -> 25
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1617	0	this	aa
    //   24	1590	1	i1	int
    //   74	890	2	i2	int
    //   275	729	3	l1	long
    //   512	473	5	l2	long
    //   32	15	7	localt1	t
    //   49	20	7	localt2	t
    //   86	74	7	localObject1	Object
    //   185	10	7	localURISyntaxException	java.net.URISyntaxException
    //   279	419	7	localObject2	Object
    //   711	44	7	localSSLHandshakeException	javax.net.ssl.SSLHandshakeException
    //   767	134	7	localObject3	Object
    //   903	62	7	localSSLPeerUnverifiedException	javax.net.ssl.SSLPeerUnverifiedException
    //   969	128	7	localae	ae
    //   1099	45	7	localSSLException	javax.net.ssl.SSLException
    //   1152	44	7	localConnectionPoolTimeoutException	org.apache.http.conn.ConnectionPoolTimeoutException
    //   1204	44	7	localConnectTimeoutException	org.apache.http.conn.ConnectTimeoutException
    //   1256	44	7	localSocketTimeoutException	java.net.SocketTimeoutException
    //   1308	44	7	localNoHttpResponseException	org.apache.http.NoHttpResponseException
    //   1360	32	7	localHttpHostConnectException	org.apache.http.conn.HttpHostConnectException
    //   1400	45	7	localUnknownHostException	java.net.UnknownHostException
    //   1453	45	7	localIOException	IOException
    //   1506	48	7	localNullPointerException	NullPointerException
    //   1562	31	7	localException1	Exception
    //   1607	1	7	localObject4	Object
    //   16	1062	8	localObject5	Object
    //   1601	1	8	localException2	Exception
    //   330	746	9	localObject6	Object
    //   607	68	10	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   0	18	49	com/alipay/android/a/a/a/t
    //   29	49	49	com/alipay/android/a/a/a/t
    //   71	75	49	com/alipay/android/a/a/a/t
    //   93	109	49	com/alipay/android/a/a/a/t
    //   120	129	49	com/alipay/android/a/a/a/t
    //   134	149	49	com/alipay/android/a/a/a/t
    //   149	182	49	com/alipay/android/a/a/a/t
    //   203	350	49	com/alipay/android/a/a/a/t
    //   355	372	49	com/alipay/android/a/a/a/t
    //   377	390	49	com/alipay/android/a/a/a/t
    //   403	417	49	com/alipay/android/a/a/a/t
    //   421	432	49	com/alipay/android/a/a/a/t
    //   435	461	49	com/alipay/android/a/a/a/t
    //   461	487	49	com/alipay/android/a/a/a/t
    //   487	553	49	com/alipay/android/a/a/a/t
    //   553	572	49	com/alipay/android/a/a/a/t
    //   572	669	49	com/alipay/android/a/a/a/t
    //   674	708	49	com/alipay/android/a/a/a/t
    //   763	805	49	com/alipay/android/a/a/a/t
    //   816	843	49	com/alipay/android/a/a/a/t
    //   863	903	49	com/alipay/android/a/a/a/t
    //   960	971	49	com/alipay/android/a/a/a/t
    //   987	1003	49	com/alipay/android/a/a/a/t
    //   1011	1026	49	com/alipay/android/a/a/a/t
    //   1026	1041	49	com/alipay/android/a/a/a/t
    //   1041	1050	49	com/alipay/android/a/a/a/t
    //   1055	1096	49	com/alipay/android/a/a/a/t
    //   0	18	185	java/net/URISyntaxException
    //   29	49	185	java/net/URISyntaxException
    //   71	75	185	java/net/URISyntaxException
    //   93	109	185	java/net/URISyntaxException
    //   120	129	185	java/net/URISyntaxException
    //   134	149	185	java/net/URISyntaxException
    //   149	182	185	java/net/URISyntaxException
    //   203	350	185	java/net/URISyntaxException
    //   355	372	185	java/net/URISyntaxException
    //   377	390	185	java/net/URISyntaxException
    //   403	417	185	java/net/URISyntaxException
    //   421	432	185	java/net/URISyntaxException
    //   435	461	185	java/net/URISyntaxException
    //   461	487	185	java/net/URISyntaxException
    //   487	553	185	java/net/URISyntaxException
    //   553	572	185	java/net/URISyntaxException
    //   572	669	185	java/net/URISyntaxException
    //   674	708	185	java/net/URISyntaxException
    //   763	805	185	java/net/URISyntaxException
    //   816	843	185	java/net/URISyntaxException
    //   863	903	185	java/net/URISyntaxException
    //   960	971	185	java/net/URISyntaxException
    //   987	1003	185	java/net/URISyntaxException
    //   1011	1026	185	java/net/URISyntaxException
    //   1026	1041	185	java/net/URISyntaxException
    //   1041	1050	185	java/net/URISyntaxException
    //   1055	1096	185	java/net/URISyntaxException
    //   0	18	711	javax/net/ssl/SSLHandshakeException
    //   29	49	711	javax/net/ssl/SSLHandshakeException
    //   71	75	711	javax/net/ssl/SSLHandshakeException
    //   93	109	711	javax/net/ssl/SSLHandshakeException
    //   120	129	711	javax/net/ssl/SSLHandshakeException
    //   134	149	711	javax/net/ssl/SSLHandshakeException
    //   149	182	711	javax/net/ssl/SSLHandshakeException
    //   203	350	711	javax/net/ssl/SSLHandshakeException
    //   355	372	711	javax/net/ssl/SSLHandshakeException
    //   377	390	711	javax/net/ssl/SSLHandshakeException
    //   403	417	711	javax/net/ssl/SSLHandshakeException
    //   421	432	711	javax/net/ssl/SSLHandshakeException
    //   435	461	711	javax/net/ssl/SSLHandshakeException
    //   461	487	711	javax/net/ssl/SSLHandshakeException
    //   487	553	711	javax/net/ssl/SSLHandshakeException
    //   553	572	711	javax/net/ssl/SSLHandshakeException
    //   572	669	711	javax/net/ssl/SSLHandshakeException
    //   674	708	711	javax/net/ssl/SSLHandshakeException
    //   763	805	711	javax/net/ssl/SSLHandshakeException
    //   816	843	711	javax/net/ssl/SSLHandshakeException
    //   863	903	711	javax/net/ssl/SSLHandshakeException
    //   960	971	711	javax/net/ssl/SSLHandshakeException
    //   987	1003	711	javax/net/ssl/SSLHandshakeException
    //   1011	1026	711	javax/net/ssl/SSLHandshakeException
    //   1026	1041	711	javax/net/ssl/SSLHandshakeException
    //   1041	1050	711	javax/net/ssl/SSLHandshakeException
    //   1055	1096	711	javax/net/ssl/SSLHandshakeException
    //   0	18	903	javax/net/ssl/SSLPeerUnverifiedException
    //   29	49	903	javax/net/ssl/SSLPeerUnverifiedException
    //   71	75	903	javax/net/ssl/SSLPeerUnverifiedException
    //   93	109	903	javax/net/ssl/SSLPeerUnverifiedException
    //   120	129	903	javax/net/ssl/SSLPeerUnverifiedException
    //   134	149	903	javax/net/ssl/SSLPeerUnverifiedException
    //   149	182	903	javax/net/ssl/SSLPeerUnverifiedException
    //   203	350	903	javax/net/ssl/SSLPeerUnverifiedException
    //   355	372	903	javax/net/ssl/SSLPeerUnverifiedException
    //   377	390	903	javax/net/ssl/SSLPeerUnverifiedException
    //   403	417	903	javax/net/ssl/SSLPeerUnverifiedException
    //   421	432	903	javax/net/ssl/SSLPeerUnverifiedException
    //   435	461	903	javax/net/ssl/SSLPeerUnverifiedException
    //   461	487	903	javax/net/ssl/SSLPeerUnverifiedException
    //   487	553	903	javax/net/ssl/SSLPeerUnverifiedException
    //   553	572	903	javax/net/ssl/SSLPeerUnverifiedException
    //   572	669	903	javax/net/ssl/SSLPeerUnverifiedException
    //   674	708	903	javax/net/ssl/SSLPeerUnverifiedException
    //   763	805	903	javax/net/ssl/SSLPeerUnverifiedException
    //   816	843	903	javax/net/ssl/SSLPeerUnverifiedException
    //   863	903	903	javax/net/ssl/SSLPeerUnverifiedException
    //   960	971	903	javax/net/ssl/SSLPeerUnverifiedException
    //   987	1003	903	javax/net/ssl/SSLPeerUnverifiedException
    //   1011	1026	903	javax/net/ssl/SSLPeerUnverifiedException
    //   1026	1041	903	javax/net/ssl/SSLPeerUnverifiedException
    //   1041	1050	903	javax/net/ssl/SSLPeerUnverifiedException
    //   1055	1096	903	javax/net/ssl/SSLPeerUnverifiedException
    //   0	18	1099	javax/net/ssl/SSLException
    //   29	49	1099	javax/net/ssl/SSLException
    //   71	75	1099	javax/net/ssl/SSLException
    //   93	109	1099	javax/net/ssl/SSLException
    //   120	129	1099	javax/net/ssl/SSLException
    //   134	149	1099	javax/net/ssl/SSLException
    //   149	182	1099	javax/net/ssl/SSLException
    //   203	350	1099	javax/net/ssl/SSLException
    //   355	372	1099	javax/net/ssl/SSLException
    //   377	390	1099	javax/net/ssl/SSLException
    //   403	417	1099	javax/net/ssl/SSLException
    //   421	432	1099	javax/net/ssl/SSLException
    //   435	461	1099	javax/net/ssl/SSLException
    //   461	487	1099	javax/net/ssl/SSLException
    //   487	553	1099	javax/net/ssl/SSLException
    //   553	572	1099	javax/net/ssl/SSLException
    //   572	669	1099	javax/net/ssl/SSLException
    //   674	708	1099	javax/net/ssl/SSLException
    //   763	805	1099	javax/net/ssl/SSLException
    //   816	843	1099	javax/net/ssl/SSLException
    //   863	903	1099	javax/net/ssl/SSLException
    //   960	971	1099	javax/net/ssl/SSLException
    //   987	1003	1099	javax/net/ssl/SSLException
    //   1011	1026	1099	javax/net/ssl/SSLException
    //   1026	1041	1099	javax/net/ssl/SSLException
    //   1041	1050	1099	javax/net/ssl/SSLException
    //   1055	1096	1099	javax/net/ssl/SSLException
    //   0	18	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   29	49	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   71	75	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   93	109	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   120	129	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   134	149	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   149	182	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   203	350	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   355	372	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   377	390	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   403	417	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   421	432	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   435	461	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   461	487	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   487	553	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   553	572	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   572	669	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   674	708	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   763	805	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   816	843	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   863	903	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   960	971	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   987	1003	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   1011	1026	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   1026	1041	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   1041	1050	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   1055	1096	1152	org/apache/http/conn/ConnectionPoolTimeoutException
    //   0	18	1204	org/apache/http/conn/ConnectTimeoutException
    //   29	49	1204	org/apache/http/conn/ConnectTimeoutException
    //   71	75	1204	org/apache/http/conn/ConnectTimeoutException
    //   93	109	1204	org/apache/http/conn/ConnectTimeoutException
    //   120	129	1204	org/apache/http/conn/ConnectTimeoutException
    //   134	149	1204	org/apache/http/conn/ConnectTimeoutException
    //   149	182	1204	org/apache/http/conn/ConnectTimeoutException
    //   203	350	1204	org/apache/http/conn/ConnectTimeoutException
    //   355	372	1204	org/apache/http/conn/ConnectTimeoutException
    //   377	390	1204	org/apache/http/conn/ConnectTimeoutException
    //   403	417	1204	org/apache/http/conn/ConnectTimeoutException
    //   421	432	1204	org/apache/http/conn/ConnectTimeoutException
    //   435	461	1204	org/apache/http/conn/ConnectTimeoutException
    //   461	487	1204	org/apache/http/conn/ConnectTimeoutException
    //   487	553	1204	org/apache/http/conn/ConnectTimeoutException
    //   553	572	1204	org/apache/http/conn/ConnectTimeoutException
    //   572	669	1204	org/apache/http/conn/ConnectTimeoutException
    //   674	708	1204	org/apache/http/conn/ConnectTimeoutException
    //   763	805	1204	org/apache/http/conn/ConnectTimeoutException
    //   816	843	1204	org/apache/http/conn/ConnectTimeoutException
    //   863	903	1204	org/apache/http/conn/ConnectTimeoutException
    //   960	971	1204	org/apache/http/conn/ConnectTimeoutException
    //   987	1003	1204	org/apache/http/conn/ConnectTimeoutException
    //   1011	1026	1204	org/apache/http/conn/ConnectTimeoutException
    //   1026	1041	1204	org/apache/http/conn/ConnectTimeoutException
    //   1041	1050	1204	org/apache/http/conn/ConnectTimeoutException
    //   1055	1096	1204	org/apache/http/conn/ConnectTimeoutException
    //   0	18	1256	java/net/SocketTimeoutException
    //   29	49	1256	java/net/SocketTimeoutException
    //   71	75	1256	java/net/SocketTimeoutException
    //   93	109	1256	java/net/SocketTimeoutException
    //   120	129	1256	java/net/SocketTimeoutException
    //   134	149	1256	java/net/SocketTimeoutException
    //   149	182	1256	java/net/SocketTimeoutException
    //   203	350	1256	java/net/SocketTimeoutException
    //   355	372	1256	java/net/SocketTimeoutException
    //   377	390	1256	java/net/SocketTimeoutException
    //   403	417	1256	java/net/SocketTimeoutException
    //   421	432	1256	java/net/SocketTimeoutException
    //   435	461	1256	java/net/SocketTimeoutException
    //   461	487	1256	java/net/SocketTimeoutException
    //   487	553	1256	java/net/SocketTimeoutException
    //   553	572	1256	java/net/SocketTimeoutException
    //   572	669	1256	java/net/SocketTimeoutException
    //   674	708	1256	java/net/SocketTimeoutException
    //   763	805	1256	java/net/SocketTimeoutException
    //   816	843	1256	java/net/SocketTimeoutException
    //   863	903	1256	java/net/SocketTimeoutException
    //   960	971	1256	java/net/SocketTimeoutException
    //   987	1003	1256	java/net/SocketTimeoutException
    //   1011	1026	1256	java/net/SocketTimeoutException
    //   1026	1041	1256	java/net/SocketTimeoutException
    //   1041	1050	1256	java/net/SocketTimeoutException
    //   1055	1096	1256	java/net/SocketTimeoutException
    //   0	18	1308	org/apache/http/NoHttpResponseException
    //   29	49	1308	org/apache/http/NoHttpResponseException
    //   71	75	1308	org/apache/http/NoHttpResponseException
    //   93	109	1308	org/apache/http/NoHttpResponseException
    //   120	129	1308	org/apache/http/NoHttpResponseException
    //   134	149	1308	org/apache/http/NoHttpResponseException
    //   149	182	1308	org/apache/http/NoHttpResponseException
    //   203	350	1308	org/apache/http/NoHttpResponseException
    //   355	372	1308	org/apache/http/NoHttpResponseException
    //   377	390	1308	org/apache/http/NoHttpResponseException
    //   403	417	1308	org/apache/http/NoHttpResponseException
    //   421	432	1308	org/apache/http/NoHttpResponseException
    //   435	461	1308	org/apache/http/NoHttpResponseException
    //   461	487	1308	org/apache/http/NoHttpResponseException
    //   487	553	1308	org/apache/http/NoHttpResponseException
    //   553	572	1308	org/apache/http/NoHttpResponseException
    //   572	669	1308	org/apache/http/NoHttpResponseException
    //   674	708	1308	org/apache/http/NoHttpResponseException
    //   763	805	1308	org/apache/http/NoHttpResponseException
    //   816	843	1308	org/apache/http/NoHttpResponseException
    //   863	903	1308	org/apache/http/NoHttpResponseException
    //   960	971	1308	org/apache/http/NoHttpResponseException
    //   987	1003	1308	org/apache/http/NoHttpResponseException
    //   1011	1026	1308	org/apache/http/NoHttpResponseException
    //   1026	1041	1308	org/apache/http/NoHttpResponseException
    //   1041	1050	1308	org/apache/http/NoHttpResponseException
    //   1055	1096	1308	org/apache/http/NoHttpResponseException
    //   0	18	1360	org/apache/http/conn/HttpHostConnectException
    //   29	49	1360	org/apache/http/conn/HttpHostConnectException
    //   71	75	1360	org/apache/http/conn/HttpHostConnectException
    //   93	109	1360	org/apache/http/conn/HttpHostConnectException
    //   120	129	1360	org/apache/http/conn/HttpHostConnectException
    //   134	149	1360	org/apache/http/conn/HttpHostConnectException
    //   149	182	1360	org/apache/http/conn/HttpHostConnectException
    //   203	350	1360	org/apache/http/conn/HttpHostConnectException
    //   355	372	1360	org/apache/http/conn/HttpHostConnectException
    //   377	390	1360	org/apache/http/conn/HttpHostConnectException
    //   403	417	1360	org/apache/http/conn/HttpHostConnectException
    //   421	432	1360	org/apache/http/conn/HttpHostConnectException
    //   435	461	1360	org/apache/http/conn/HttpHostConnectException
    //   461	487	1360	org/apache/http/conn/HttpHostConnectException
    //   487	553	1360	org/apache/http/conn/HttpHostConnectException
    //   553	572	1360	org/apache/http/conn/HttpHostConnectException
    //   572	669	1360	org/apache/http/conn/HttpHostConnectException
    //   674	708	1360	org/apache/http/conn/HttpHostConnectException
    //   763	805	1360	org/apache/http/conn/HttpHostConnectException
    //   816	843	1360	org/apache/http/conn/HttpHostConnectException
    //   863	903	1360	org/apache/http/conn/HttpHostConnectException
    //   960	971	1360	org/apache/http/conn/HttpHostConnectException
    //   987	1003	1360	org/apache/http/conn/HttpHostConnectException
    //   1011	1026	1360	org/apache/http/conn/HttpHostConnectException
    //   1026	1041	1360	org/apache/http/conn/HttpHostConnectException
    //   1041	1050	1360	org/apache/http/conn/HttpHostConnectException
    //   1055	1096	1360	org/apache/http/conn/HttpHostConnectException
    //   0	18	1400	java/net/UnknownHostException
    //   29	49	1400	java/net/UnknownHostException
    //   71	75	1400	java/net/UnknownHostException
    //   93	109	1400	java/net/UnknownHostException
    //   120	129	1400	java/net/UnknownHostException
    //   134	149	1400	java/net/UnknownHostException
    //   149	182	1400	java/net/UnknownHostException
    //   203	350	1400	java/net/UnknownHostException
    //   355	372	1400	java/net/UnknownHostException
    //   377	390	1400	java/net/UnknownHostException
    //   403	417	1400	java/net/UnknownHostException
    //   421	432	1400	java/net/UnknownHostException
    //   435	461	1400	java/net/UnknownHostException
    //   461	487	1400	java/net/UnknownHostException
    //   487	553	1400	java/net/UnknownHostException
    //   553	572	1400	java/net/UnknownHostException
    //   572	669	1400	java/net/UnknownHostException
    //   674	708	1400	java/net/UnknownHostException
    //   763	805	1400	java/net/UnknownHostException
    //   816	843	1400	java/net/UnknownHostException
    //   863	903	1400	java/net/UnknownHostException
    //   960	971	1400	java/net/UnknownHostException
    //   987	1003	1400	java/net/UnknownHostException
    //   1011	1026	1400	java/net/UnknownHostException
    //   1026	1041	1400	java/net/UnknownHostException
    //   1041	1050	1400	java/net/UnknownHostException
    //   1055	1096	1400	java/net/UnknownHostException
    //   0	18	1453	java/io/IOException
    //   29	49	1453	java/io/IOException
    //   71	75	1453	java/io/IOException
    //   93	109	1453	java/io/IOException
    //   120	129	1453	java/io/IOException
    //   134	149	1453	java/io/IOException
    //   149	182	1453	java/io/IOException
    //   203	350	1453	java/io/IOException
    //   355	372	1453	java/io/IOException
    //   377	390	1453	java/io/IOException
    //   403	417	1453	java/io/IOException
    //   421	432	1453	java/io/IOException
    //   435	461	1453	java/io/IOException
    //   461	487	1453	java/io/IOException
    //   487	553	1453	java/io/IOException
    //   553	572	1453	java/io/IOException
    //   572	669	1453	java/io/IOException
    //   674	708	1453	java/io/IOException
    //   763	805	1453	java/io/IOException
    //   816	843	1453	java/io/IOException
    //   863	903	1453	java/io/IOException
    //   960	971	1453	java/io/IOException
    //   987	1003	1453	java/io/IOException
    //   1011	1026	1453	java/io/IOException
    //   1026	1041	1453	java/io/IOException
    //   1041	1050	1453	java/io/IOException
    //   1055	1096	1453	java/io/IOException
    //   0	18	1506	java/lang/NullPointerException
    //   29	49	1506	java/lang/NullPointerException
    //   71	75	1506	java/lang/NullPointerException
    //   93	109	1506	java/lang/NullPointerException
    //   120	129	1506	java/lang/NullPointerException
    //   134	149	1506	java/lang/NullPointerException
    //   149	182	1506	java/lang/NullPointerException
    //   203	350	1506	java/lang/NullPointerException
    //   355	372	1506	java/lang/NullPointerException
    //   377	390	1506	java/lang/NullPointerException
    //   403	417	1506	java/lang/NullPointerException
    //   421	432	1506	java/lang/NullPointerException
    //   435	461	1506	java/lang/NullPointerException
    //   461	487	1506	java/lang/NullPointerException
    //   487	553	1506	java/lang/NullPointerException
    //   553	572	1506	java/lang/NullPointerException
    //   572	669	1506	java/lang/NullPointerException
    //   674	708	1506	java/lang/NullPointerException
    //   763	805	1506	java/lang/NullPointerException
    //   816	843	1506	java/lang/NullPointerException
    //   863	903	1506	java/lang/NullPointerException
    //   960	971	1506	java/lang/NullPointerException
    //   987	1003	1506	java/lang/NullPointerException
    //   1011	1026	1506	java/lang/NullPointerException
    //   1026	1041	1506	java/lang/NullPointerException
    //   1041	1050	1506	java/lang/NullPointerException
    //   1055	1096	1506	java/lang/NullPointerException
    //   0	18	1562	java/lang/Exception
    //   29	49	1562	java/lang/Exception
    //   71	75	1562	java/lang/Exception
    //   93	109	1562	java/lang/Exception
    //   120	129	1562	java/lang/Exception
    //   134	149	1562	java/lang/Exception
    //   149	182	1562	java/lang/Exception
    //   203	350	1562	java/lang/Exception
    //   355	372	1562	java/lang/Exception
    //   377	390	1562	java/lang/Exception
    //   403	417	1562	java/lang/Exception
    //   421	432	1562	java/lang/Exception
    //   435	461	1562	java/lang/Exception
    //   461	487	1562	java/lang/Exception
    //   487	553	1562	java/lang/Exception
    //   553	572	1562	java/lang/Exception
    //   572	669	1562	java/lang/Exception
    //   674	708	1562	java/lang/Exception
    //   763	805	1562	java/lang/Exception
    //   816	843	1562	java/lang/Exception
    //   863	903	1562	java/lang/Exception
    //   960	971	1562	java/lang/Exception
    //   987	1003	1562	java/lang/Exception
    //   1011	1026	1562	java/lang/Exception
    //   1041	1050	1562	java/lang/Exception
    //   1055	1096	1562	java/lang/Exception
    //   1026	1041	1601	java/lang/Exception
  }
  
  private void e()
  {
    if (this.f != null) {
      this.f.abort();
    }
  }
  
  private String f()
  {
    if (!TextUtils.isEmpty(this.q)) {}
    for (String str = this.q;; str = this.q)
    {
      return str;
      this.q = this.c.b("operationType");
    }
  }
  
  private int g()
  {
    URL localURL = h();
    if (localURL.getPort() == -1) {}
    for (int i1 = localURL.getDefaultPort();; i1 = localURL.getPort()) {
      return i1;
    }
  }
  
  private URL h()
  {
    if (this.l != null) {}
    for (URL localURL = this.l;; localURL = this.l)
    {
      return localURL;
      this.l = new URL(this.c.a());
    }
  }
  
  private CookieManager i()
  {
    if (this.i != null) {}
    for (CookieManager localCookieManager = this.i;; localCookieManager = this.i)
    {
      return localCookieManager;
      this.i = CookieManager.getInstance();
    }
  }
  
  public final y a()
  {
    return this.c;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/android/a/a/a/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */