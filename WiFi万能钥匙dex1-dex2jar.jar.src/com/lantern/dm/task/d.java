package com.lantern.dm.task;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.util.Pair;
import com.bluefay.b.h;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;

public final class d
  extends Thread
{
  private Context a;
  private a b;
  private i c;
  
  public d(Context paramContext, i parami, a parama)
  {
    this.a = paramContext;
    this.c = parami;
    this.b = parama;
  }
  
  private InputStream a(c paramc, HttpResponse paramHttpResponse)
  {
    try
    {
      paramHttpResponse = paramHttpResponse.getEntity().getContent();
      return paramHttpResponse;
    }
    catch (IOException paramHttpResponse)
    {
      b();
      throw new d(b(paramc), "while getting entity: " + paramHttpResponse.toString(), paramHttpResponse);
    }
  }
  
  private HttpResponse a(c paramc, HttpClient paramHttpClient, HttpGet paramHttpGet)
  {
    try
    {
      HttpProtocolParams.setUseExpectContinue(paramHttpClient.getParams(), false);
      paramHttpClient = paramHttpClient.execute(paramHttpGet);
      return paramHttpClient;
    }
    catch (IllegalArgumentException paramc)
    {
      throw new d(495, "while trying to execute request: " + paramc.toString(), paramc);
    }
    catch (IOException paramHttpClient)
    {
      b();
      throw new d(b(paramc), "while trying to execute request: " + paramHttpClient.toString(), paramHttpClient);
    }
  }
  
  private void a()
  {
    int i = 196;
    int j = this.b.c();
    if (j != 1)
    {
      String str;
      if (j == 3) {
        switch (j)
        {
        default: 
          str = "unknown error with network connectivity";
        }
      }
      for (;;)
      {
        throw new d(i, str);
        if (j == 4) {
          break;
        }
        i = 195;
        break;
        str = "download size exceeds recommended limit for mobile network";
        continue;
        str = "download size exceeds limit for mobile network";
        continue;
        str = "no network connection available";
        continue;
        str = "download cannot use the current network connection because it is roaming";
        continue;
        str = "download was requested to not use the current network type";
      }
    }
  }
  
  private void a(a parama, HttpGet paramHttpGet)
  {
    Iterator localIterator = this.b.a().iterator();
    while (localIterator.hasNext())
    {
      Pair localPair = (Pair)localIterator.next();
      paramHttpGet.addHeader((String)localPair.first, (String)localPair.second);
    }
    if (parama.c)
    {
      if (parama.b != null) {
        paramHttpGet.addHeader("If-Match", parama.b);
      }
      paramHttpGet.addHeader("Range", "bytes=" + parama.a + "-");
    }
  }
  
  private static void a(c paramc)
  {
    try
    {
      if (paramc.b != null)
      {
        paramc.b.close();
        paramc.b = null;
      }
      return;
    }
    catch (IOException paramc)
    {
      for (;;)
      {
        h.c("exception when closing the file after download : " + paramc);
      }
    }
  }
  
  private void a(c paramc, a parama, byte[] paramArrayOfByte, InputStream paramInputStream)
  {
    int i = 1;
    do
    {
      int j = b(paramc, parama, paramArrayOfByte, paramInputStream);
      if (j == -1)
      {
        paramArrayOfByte = new ContentValues();
        paramArrayOfByte.put("current_bytes", Integer.valueOf(parama.a));
        if (parama.d == null) {
          paramArrayOfByte.put("total_bytes", Integer.valueOf(parama.a));
        }
        this.a.getContentResolver().update(this.b.d(), paramArrayOfByte, null, null);
        if ((parama.d != null) && (parama.a != Integer.parseInt(parama.d))) {}
        for (;;)
        {
          if (i == 0) {
            return;
          }
          if (!a(parama)) {
            break;
          }
          throw new d(489, "mismatched content length");
          i = 0;
        }
        throw new d(b(paramc), "closed socket before end of file");
      }
      paramc.h = true;
      try
      {
        if (paramc.b == null)
        {
          ??? = new java/io/FileOutputStream;
          ((FileOutputStream)???).<init>(paramc.a, true);
          paramc.b = ((FileOutputStream)???);
        }
        paramc.b.write(paramArrayOfByte, 0, j);
        if (this.b.g == 0) {
          a(paramc);
        }
        parama.a = (j + parama.a);
        long l = this.c.a();
        if ((parama.a - parama.g > 4096) && (l - parama.h > 1500L))
        {
          ??? = new ContentValues();
          if (this.b.j != 192) {
            ((ContentValues)???).put("status", Integer.valueOf(192));
          }
          ((ContentValues)???).put("current_bytes", Integer.valueOf(parama.a));
          this.a.getContentResolver().update(this.b.d(), (ContentValues)???, null, null);
          parama.g = parama.a;
          parama.h = l;
        }
        synchronized (this.b)
        {
          if (this.b.i == 1)
          {
            paramc = new com/lantern/dm/task/d$d;
            paramc.<init>(this, 193, "download paused by owner");
            throw paramc;
          }
        }
      }
      catch (IOException parama)
      {
        if (!e.a()) {
          throw new d(499, "external media not mounted while writing destination file");
        }
        if (e.a(e.a(paramc.a)) < j) {
          throw new d(498, "insufficient space while writing destination file", parama);
        }
        throw new d(492, "while writing destination file: " + parama.toString(), parama);
      }
    } while (this.b.j != 490);
    throw new d(490, "download canceled");
  }
  
  private boolean a(a parama)
  {
    if ((parama.a > 0) && (!this.b.c) && (parama.b == null)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private int b(c paramc)
  {
    int i;
    if (!e.a(this.c)) {
      i = 195;
    }
    for (;;)
    {
      return i;
      if (this.b.k <= 0)
      {
        paramc.d = true;
        i = 194;
      }
      else
      {
        h.a("reached max retries for " + this.b.a, new Object[0]);
        i = 495;
      }
    }
  }
  
  private int b(c paramc, a parama, byte[] paramArrayOfByte, InputStream paramInputStream)
  {
    try
    {
      int i = paramInputStream.read(paramArrayOfByte);
      return i;
    }
    catch (IOException paramInputStream)
    {
      b();
      paramArrayOfByte = new ContentValues();
      paramArrayOfByte.put("current_bytes", Integer.valueOf(parama.a));
      this.a.getContentResolver().update(this.b.d(), paramArrayOfByte, null, null);
      if (a(parama)) {
        throw new d(489, "while reading response: " + paramInputStream.toString() + ", can't resume interrupted download with no ETag", paramInputStream);
      }
      throw new d(b(paramc), "while reading response: " + paramInputStream.toString(), paramInputStream);
    }
  }
  
  private static String b(String paramString)
  {
    try
    {
      String str = paramString.trim().toLowerCase(Locale.ENGLISH);
      int i = str.indexOf(';');
      paramString = str;
      if (i != -1) {
        paramString = str.substring(0, i);
      }
    }
    catch (NullPointerException paramString)
    {
      for (;;)
      {
        paramString = null;
      }
    }
    return paramString;
  }
  
  private void b()
  {
    if (e.a(this.c)) {}
    for (String str = "Up";; str = "Down")
    {
      h.a("Net " + str, new Object[0]);
      return;
    }
  }
  
  private static HttpClient c()
  {
    try
    {
      Object localObject1 = KeyStore.getInstance(KeyStore.getDefaultType());
      ((KeyStore)localObject1).load(null, null);
      Object localObject2 = new com/lantern/dm/task/g;
      ((g)localObject2).<init>((KeyStore)localObject1);
      ((SSLSocketFactory)localObject2).setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
      BasicHttpParams localBasicHttpParams = new org/apache/http/params/BasicHttpParams;
      localBasicHttpParams.<init>();
      HttpProtocolParams.setVersion(localBasicHttpParams, HttpVersion.HTTP_1_1);
      HttpProtocolParams.setContentCharset(localBasicHttpParams, "UTF-8");
      localObject1 = new org/apache/http/conn/scheme/SchemeRegistry;
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
      return (HttpClient)localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
      }
    }
  }
  
  /* Error */
  public final void run()
  {
    // Byte code:
    //   0: bipush 10
    //   2: invokestatic 459	android/os/Process:setThreadPriority	(I)V
    //   5: new 12	com/lantern/dm/task/d$c
    //   8: dup
    //   9: aload_0
    //   10: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   13: invokespecial 462	com/lantern/dm/task/d$c:<init>	(Lcom/lantern/dm/task/a;)V
    //   16: astore 14
    //   18: aconst_null
    //   19: astore 7
    //   21: aconst_null
    //   22: astore 6
    //   24: aload_0
    //   25: getfield 26	com/lantern/dm/task/d:a	Landroid/content/Context;
    //   28: ldc_w 464
    //   31: invokevirtual 468	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   34: checkcast 470	android/os/PowerManager
    //   37: iconst_1
    //   38: ldc_w 472
    //   41: invokevirtual 476	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   44: astore 8
    //   46: aload 8
    //   48: astore 6
    //   50: aload 6
    //   52: invokevirtual 481	android/os/PowerManager$WakeLock:acquire	()V
    //   55: new 53	java/lang/StringBuilder
    //   58: astore 8
    //   60: aload 8
    //   62: ldc_w 483
    //   65: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   68: aload 8
    //   70: aload_0
    //   71: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   74: getfield 484	com/lantern/dm/task/a:b	Ljava/lang/String;
    //   77: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   83: iconst_0
    //   84: anewarray 313	java/lang/Object
    //   87: invokestatic 316	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: invokestatic 486	com/lantern/dm/task/d:c	()Lorg/apache/http/client/HttpClient;
    //   93: astore 9
    //   95: aload 6
    //   97: astore 10
    //   99: aload 9
    //   101: astore 8
    //   103: aload 9
    //   105: invokeinterface 82 1 0
    //   110: astore 12
    //   112: aload 6
    //   114: astore 10
    //   116: aload 9
    //   118: astore 8
    //   120: aload_0
    //   121: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   124: getfield 489	com/lantern/dm/task/a:r	Ljava/lang/String;
    //   127: astore 11
    //   129: aload 11
    //   131: astore 7
    //   133: aload 11
    //   135: ifnonnull +8 -> 143
    //   138: ldc_w 491
    //   141: astore 7
    //   143: aload 6
    //   145: astore 10
    //   147: aload 9
    //   149: astore 8
    //   151: aload 12
    //   153: ldc_w 493
    //   156: aload 7
    //   158: invokeinterface 499 3 0
    //   163: pop
    //   164: iconst_0
    //   165: istore_2
    //   166: iload_2
    //   167: ifne +2749 -> 2916
    //   170: aload 6
    //   172: astore 10
    //   174: aload 9
    //   176: astore 8
    //   178: new 53	java/lang/StringBuilder
    //   181: astore 7
    //   183: aload 6
    //   185: astore 10
    //   187: aload 9
    //   189: astore 8
    //   191: aload 7
    //   193: ldc_w 483
    //   196: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   199: aload 6
    //   201: astore 10
    //   203: aload 9
    //   205: astore 8
    //   207: aload 7
    //   209: aload_0
    //   210: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   213: getfield 308	com/lantern/dm/task/a:a	J
    //   216: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   219: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: iconst_0
    //   223: anewarray 313	java/lang/Object
    //   226: invokestatic 316	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   229: aload 6
    //   231: astore 10
    //   233: aload 9
    //   235: astore 8
    //   237: new 148	org/apache/http/client/methods/HttpGet
    //   240: astore 11
    //   242: aload 6
    //   244: astore 10
    //   246: aload 9
    //   248: astore 8
    //   250: aload 11
    //   252: aload 14
    //   254: getfield 501	com/lantern/dm/task/d$c:i	Ljava/lang/String;
    //   257: invokespecial 502	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   260: new 6	com/lantern/dm/task/d$a
    //   263: astore 8
    //   265: aload 8
    //   267: iconst_0
    //   268: invokespecial 505	com/lantern/dm/task/d$a:<init>	(B)V
    //   271: sipush 4096
    //   274: newarray <illegal type>
    //   276: astore 10
    //   278: aload 14
    //   280: getfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   283: invokestatic 511	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   286: ifne +620 -> 906
    //   289: aload 14
    //   291: getfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   294: invokestatic 514	com/lantern/dm/task/e:b	(Ljava/lang/String;)Z
    //   297: ifne +560 -> 857
    //   300: new 15	com/lantern/dm/task/d$d
    //   303: astore 7
    //   305: aload 7
    //   307: aload_0
    //   308: sipush 492
    //   311: ldc_w 516
    //   314: invokespecial 105	com/lantern/dm/task/d$d:<init>	(Lcom/lantern/dm/task/d;ILjava/lang/String;)V
    //   317: aload 7
    //   319: athrow
    //   320: astore 7
    //   322: aload 6
    //   324: astore 10
    //   326: aload 9
    //   328: astore 8
    //   330: aload 11
    //   332: invokevirtual 519	org/apache/http/client/methods/HttpGet:abort	()V
    //   335: goto -169 -> 166
    //   338: astore 8
    //   340: aload 9
    //   342: astore 7
    //   344: new 53	java/lang/StringBuilder
    //   347: astore 9
    //   349: aload 9
    //   351: ldc_w 521
    //   354: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   357: aload 9
    //   359: aload_0
    //   360: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   363: getfield 308	com/lantern/dm/task/a:a	J
    //   366: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   369: ldc_w 523
    //   372: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload 8
    //   377: invokevirtual 526	com/lantern/dm/task/d$d:getMessage	()Ljava/lang/String;
    //   380: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 190	com/bluefay/b/h:c	(Ljava/lang/String;)V
    //   389: aload 8
    //   391: getfield 527	com/lantern/dm/task/d$d:a	I
    //   394: istore_1
    //   395: aload 6
    //   397: ifnull +8 -> 405
    //   400: aload 6
    //   402: invokevirtual 530	android/os/PowerManager$WakeLock:release	()V
    //   405: aload 7
    //   407: ifnull +25 -> 432
    //   410: aload 7
    //   412: invokeinterface 534 1 0
    //   417: ifnull +15 -> 432
    //   420: aload 7
    //   422: invokeinterface 534 1 0
    //   427: invokeinterface 539 1 0
    //   432: aload 14
    //   434: invokestatic 256	com/lantern/dm/task/d:a	(Lcom/lantern/dm/task/d$c;)V
    //   437: aload 14
    //   439: getfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   442: ifnull +32 -> 474
    //   445: iload_1
    //   446: invokestatic 544	com/lantern/core/model/a:a	(I)Z
    //   449: ifeq +25 -> 474
    //   452: new 546	java/io/File
    //   455: dup
    //   456: aload 14
    //   458: getfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   461: invokespecial 547	java/io/File:<init>	(Ljava/lang/String;)V
    //   464: invokevirtual 550	java/io/File:delete	()Z
    //   467: pop
    //   468: aload 14
    //   470: aconst_null
    //   471: putfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   474: aload 14
    //   476: getfield 552	com/lantern/dm/task/d$c:g	Ljava/lang/String;
    //   479: astore 9
    //   481: aload 14
    //   483: getfield 554	com/lantern/dm/task/d$c:c	Ljava/lang/String;
    //   486: astore 10
    //   488: new 53	java/lang/StringBuilder
    //   491: dup
    //   492: ldc_w 556
    //   495: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   498: iload_1
    //   499: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   502: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: iconst_0
    //   506: anewarray 313	java/lang/Object
    //   509: invokestatic 316	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   512: iload_1
    //   513: sipush 200
    //   516: if_icmpne +19 -> 535
    //   519: invokestatic 562	com/lantern/analytics/a:e	()Lcom/lantern/analytics/a;
    //   522: ldc_w 564
    //   525: aload_0
    //   526: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   529: getfield 484	com/lantern/dm/task/a:b	Ljava/lang/String;
    //   532: invokevirtual 567	com/lantern/analytics/a:onEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   535: new 196	android/content/ContentValues
    //   538: dup
    //   539: invokespecial 197	android/content/ContentValues:<init>	()V
    //   542: astore 11
    //   544: aload 11
    //   546: ldc_w 272
    //   549: iload_1
    //   550: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   553: invokevirtual 209	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   556: aload 11
    //   558: ldc_w 569
    //   561: iconst_1
    //   562: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   565: invokevirtual 209	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   568: aload_0
    //   569: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   572: getfield 571	com/lantern/dm/task/a:e	Ljava/lang/String;
    //   575: astore 6
    //   577: aload 6
    //   579: astore 8
    //   581: iload_1
    //   582: sipush 200
    //   585: if_icmpne +161 -> 746
    //   588: aload 6
    //   590: astore 7
    //   592: aload 6
    //   594: invokestatic 511	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   597: ifne +78 -> 675
    //   600: aload 6
    //   602: astore 7
    //   604: aload 6
    //   606: ldc_w 573
    //   609: invokevirtual 576	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   612: ifeq +63 -> 675
    //   615: aload 6
    //   617: iconst_0
    //   618: aload 6
    //   620: invokevirtual 579	java/lang/String:length	()I
    //   623: iconst_5
    //   624: isub
    //   625: invokevirtual 349	java/lang/String:substring	(II)Ljava/lang/String;
    //   628: astore 7
    //   630: aload 7
    //   632: astore 6
    //   634: new 546	java/io/File
    //   637: astore 8
    //   639: aload 8
    //   641: aload_0
    //   642: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   645: getfield 571	com/lantern/dm/task/a:e	Ljava/lang/String;
    //   648: invokespecial 547	java/io/File:<init>	(Ljava/lang/String;)V
    //   651: new 546	java/io/File
    //   654: astore 7
    //   656: aload 7
    //   658: aload 6
    //   660: invokespecial 547	java/io/File:<init>	(Ljava/lang/String;)V
    //   663: aload 8
    //   665: aload 7
    //   667: invokevirtual 583	java/io/File:renameTo	(Ljava/io/File;)Z
    //   670: pop
    //   671: aload 6
    //   673: astore 7
    //   675: aload 7
    //   677: astore 8
    //   679: aload_0
    //   680: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   683: getfield 586	com/lantern/dm/task/a:A	Ljava/lang/String;
    //   686: invokestatic 511	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   689: ifne +57 -> 746
    //   692: aload 7
    //   694: astore 8
    //   696: aload_0
    //   697: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   700: getfield 586	com/lantern/dm/task/a:A	Ljava/lang/String;
    //   703: ldc_w 573
    //   706: invokevirtual 576	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   709: ifeq +37 -> 746
    //   712: aload_0
    //   713: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   716: getfield 586	com/lantern/dm/task/a:A	Ljava/lang/String;
    //   719: astore 6
    //   721: aload 11
    //   723: ldc_w 588
    //   726: aload 6
    //   728: iconst_0
    //   729: aload 6
    //   731: invokevirtual 579	java/lang/String:length	()I
    //   734: iconst_5
    //   735: isub
    //   736: invokevirtual 349	java/lang/String:substring	(II)Ljava/lang/String;
    //   739: invokevirtual 590	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   742: aload 7
    //   744: astore 8
    //   746: aload 11
    //   748: ldc_w 592
    //   751: aload 8
    //   753: invokevirtual 590	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   756: aload 9
    //   758: ifnull +13 -> 771
    //   761: aload 11
    //   763: ldc_w 594
    //   766: aload 9
    //   768: invokevirtual 590	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   771: aload 11
    //   773: ldc_w 596
    //   776: aload 10
    //   778: invokevirtual 590	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   781: aload 11
    //   783: ldc_w 598
    //   786: aload_0
    //   787: getfield 28	com/lantern/dm/task/d:c	Lcom/lantern/dm/task/i;
    //   790: invokeinterface 261 1 0
    //   795: invokestatic 603	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   798: invokevirtual 606	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   801: aload_0
    //   802: getfield 26	com/lantern/dm/task/d:a	Landroid/content/Context;
    //   805: invokevirtual 219	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   808: aload_0
    //   809: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   812: invokevirtual 222	com/lantern/dm/task/a:d	()Landroid/net/Uri;
    //   815: aload 11
    //   817: aconst_null
    //   818: aconst_null
    //   819: invokevirtual 228	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   822: pop
    //   823: iload_1
    //   824: invokestatic 608	com/lantern/core/model/a:b	(I)Z
    //   827: ifne +10 -> 837
    //   830: iload_1
    //   831: invokestatic 544	com/lantern/core/model/a:a	(I)Z
    //   834: ifeq +10 -> 844
    //   837: aload_0
    //   838: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   841: invokevirtual 609	com/lantern/dm/task/a:b	()V
    //   844: aload_0
    //   845: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   848: astore 6
    //   850: aload 6
    //   852: iconst_0
    //   853: putfield 612	com/lantern/dm/task/a:G	Z
    //   856: return
    //   857: new 546	java/io/File
    //   860: astore 7
    //   862: aload 7
    //   864: aload 14
    //   866: getfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   869: invokespecial 547	java/io/File:<init>	(Ljava/lang/String;)V
    //   872: aload 7
    //   874: invokevirtual 615	java/io/File:exists	()Z
    //   877: ifeq +29 -> 906
    //   880: aload 7
    //   882: invokevirtual 617	java/io/File:length	()J
    //   885: lstore 4
    //   887: lload 4
    //   889: lconst_0
    //   890: lcmp
    //   891: ifne +604 -> 1495
    //   894: aload 7
    //   896: invokevirtual 550	java/io/File:delete	()Z
    //   899: pop
    //   900: aload 14
    //   902: aconst_null
    //   903: putfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   906: aload 14
    //   908: getfield 176	com/lantern/dm/task/d$c:b	Ljava/io/FileOutputStream;
    //   911: ifnull +18 -> 929
    //   914: aload_0
    //   915: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   918: getfield 254	com/lantern/dm/task/a:g	I
    //   921: ifne +8 -> 929
    //   924: aload 14
    //   926: invokestatic 256	com/lantern/dm/task/d:a	(Lcom/lantern/dm/task/d$c;)V
    //   929: aload_0
    //   930: aload 8
    //   932: aload 11
    //   934: invokespecial 619	com/lantern/dm/task/d:a	(Lcom/lantern/dm/task/d$a;Lorg/apache/http/client/methods/HttpGet;)V
    //   937: aload_0
    //   938: invokespecial 621	com/lantern/dm/task/d:a	()V
    //   941: aload_0
    //   942: aload 14
    //   944: aload 9
    //   946: aload 11
    //   948: invokespecial 623	com/lantern/dm/task/d:a	(Lcom/lantern/dm/task/d$c;Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpGet;)Lorg/apache/http/HttpResponse;
    //   951: astore 12
    //   953: aload 12
    //   955: invokeinterface 627 1 0
    //   960: invokeinterface 632 1 0
    //   965: istore_3
    //   966: new 53	java/lang/StringBuilder
    //   969: astore 7
    //   971: aload 7
    //   973: ldc_w 634
    //   976: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   979: aload 7
    //   981: iload_3
    //   982: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   985: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   988: iconst_0
    //   989: anewarray 313	java/lang/Object
    //   992: invokestatic 316	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   995: iload_3
    //   996: sipush 503
    //   999: if_icmpne +752 -> 1751
    //   1002: aload_0
    //   1003: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   1006: getfield 302	com/lantern/dm/task/a:k	I
    //   1009: ifgt +742 -> 1751
    //   1012: ldc_w 636
    //   1015: iconst_0
    //   1016: anewarray 313	java/lang/Object
    //   1019: invokestatic 316	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1022: aload 14
    //   1024: iconst_1
    //   1025: putfield 304	com/lantern/dm/task/d$c:d	Z
    //   1028: aload 12
    //   1030: ldc_w 638
    //   1033: invokeinterface 642 2 0
    //   1038: astore 8
    //   1040: aload 8
    //   1042: ifnull +67 -> 1109
    //   1045: new 53	java/lang/StringBuilder
    //   1048: astore 7
    //   1050: aload 7
    //   1052: ldc_w 644
    //   1055: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1058: aload 7
    //   1060: aload 8
    //   1062: invokeinterface 649 1 0
    //   1067: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1073: iconst_0
    //   1074: anewarray 313	java/lang/Object
    //   1077: invokestatic 316	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1080: aload 14
    //   1082: aload 8
    //   1084: invokeinterface 649 1 0
    //   1089: invokestatic 232	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   1092: putfield 651	com/lantern/dm/task/d$c:e	I
    //   1095: aload 14
    //   1097: getfield 651	com/lantern/dm/task/d$c:e	I
    //   1100: ifge +571 -> 1671
    //   1103: aload 14
    //   1105: iconst_0
    //   1106: putfield 651	com/lantern/dm/task/d$c:e	I
    //   1109: new 15	com/lantern/dm/task/d$d
    //   1112: astore 7
    //   1114: aload 7
    //   1116: aload_0
    //   1117: sipush 194
    //   1120: ldc_w 653
    //   1123: invokespecial 105	com/lantern/dm/task/d$d:<init>	(Lcom/lantern/dm/task/d;ILjava/lang/String;)V
    //   1126: aload 7
    //   1128: athrow
    //   1129: astore 7
    //   1131: aload 6
    //   1133: astore 10
    //   1135: aload 9
    //   1137: astore 8
    //   1139: aload 11
    //   1141: invokevirtual 519	org/apache/http/client/methods/HttpGet:abort	()V
    //   1144: aload 6
    //   1146: astore 10
    //   1148: aload 9
    //   1150: astore 8
    //   1152: aload 7
    //   1154: athrow
    //   1155: astore 7
    //   1157: aload 6
    //   1159: astore 10
    //   1161: aload 9
    //   1163: astore 8
    //   1165: new 53	java/lang/StringBuilder
    //   1168: astore 11
    //   1170: aload 6
    //   1172: astore 10
    //   1174: aload 9
    //   1176: astore 8
    //   1178: aload 11
    //   1180: ldc_w 655
    //   1183: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1186: aload 6
    //   1188: astore 10
    //   1190: aload 9
    //   1192: astore 8
    //   1194: aload 11
    //   1196: aload_0
    //   1197: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   1200: getfield 308	com/lantern/dm/task/a:a	J
    //   1203: invokevirtual 311	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1206: ldc_w 523
    //   1209: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1212: aload 7
    //   1214: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1217: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1220: invokestatic 190	com/bluefay/b/h:c	(Ljava/lang/String;)V
    //   1223: aload 6
    //   1225: ifnull +8 -> 1233
    //   1228: aload 6
    //   1230: invokevirtual 530	android/os/PowerManager$WakeLock:release	()V
    //   1233: aload 9
    //   1235: ifnull +25 -> 1260
    //   1238: aload 9
    //   1240: invokeinterface 534 1 0
    //   1245: ifnull +15 -> 1260
    //   1248: aload 9
    //   1250: invokeinterface 534 1 0
    //   1255: invokeinterface 539 1 0
    //   1260: aload 14
    //   1262: invokestatic 256	com/lantern/dm/task/d:a	(Lcom/lantern/dm/task/d$c;)V
    //   1265: aload 14
    //   1267: getfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   1270: ifnull +34 -> 1304
    //   1273: sipush 491
    //   1276: invokestatic 544	com/lantern/core/model/a:a	(I)Z
    //   1279: ifeq +25 -> 1304
    //   1282: new 546	java/io/File
    //   1285: dup
    //   1286: aload 14
    //   1288: getfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   1291: invokespecial 547	java/io/File:<init>	(Ljava/lang/String;)V
    //   1294: invokevirtual 550	java/io/File:delete	()Z
    //   1297: pop
    //   1298: aload 14
    //   1300: aconst_null
    //   1301: putfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   1304: aload 14
    //   1306: getfield 552	com/lantern/dm/task/d$c:g	Ljava/lang/String;
    //   1309: astore 6
    //   1311: aload 14
    //   1313: getfield 554	com/lantern/dm/task/d$c:c	Ljava/lang/String;
    //   1316: astore 7
    //   1318: new 53	java/lang/StringBuilder
    //   1321: dup
    //   1322: ldc_w 556
    //   1325: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1328: sipush 491
    //   1331: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1334: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1337: iconst_0
    //   1338: anewarray 313	java/lang/Object
    //   1341: invokestatic 316	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1344: new 196	android/content/ContentValues
    //   1347: dup
    //   1348: invokespecial 197	android/content/ContentValues:<init>	()V
    //   1351: astore 8
    //   1353: aload 8
    //   1355: ldc_w 272
    //   1358: sipush 491
    //   1361: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1364: invokevirtual 209	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1367: aload 8
    //   1369: ldc_w 569
    //   1372: iconst_1
    //   1373: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1376: invokevirtual 209	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   1379: aload 8
    //   1381: ldc_w 592
    //   1384: aload_0
    //   1385: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   1388: getfield 571	com/lantern/dm/task/a:e	Ljava/lang/String;
    //   1391: invokevirtual 590	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1394: aload 6
    //   1396: ifnull +13 -> 1409
    //   1399: aload 8
    //   1401: ldc_w 594
    //   1404: aload 6
    //   1406: invokevirtual 590	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1409: aload 8
    //   1411: ldc_w 596
    //   1414: aload 7
    //   1416: invokevirtual 590	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   1419: aload 8
    //   1421: ldc_w 598
    //   1424: aload_0
    //   1425: getfield 28	com/lantern/dm/task/d:c	Lcom/lantern/dm/task/i;
    //   1428: invokeinterface 261 1 0
    //   1433: invokestatic 603	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   1436: invokevirtual 606	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   1439: aload_0
    //   1440: getfield 26	com/lantern/dm/task/d:a	Landroid/content/Context;
    //   1443: invokevirtual 219	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   1446: aload_0
    //   1447: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   1450: invokevirtual 222	com/lantern/dm/task/a:d	()Landroid/net/Uri;
    //   1453: aload 8
    //   1455: aconst_null
    //   1456: aconst_null
    //   1457: invokevirtual 228	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   1460: pop
    //   1461: sipush 491
    //   1464: invokestatic 608	com/lantern/core/model/a:b	(I)Z
    //   1467: ifne +12 -> 1479
    //   1470: sipush 491
    //   1473: invokestatic 544	com/lantern/core/model/a:a	(I)Z
    //   1476: ifeq +10 -> 1486
    //   1479: aload_0
    //   1480: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   1483: invokevirtual 609	com/lantern/dm/task/a:b	()V
    //   1486: aload_0
    //   1487: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   1490: astore 6
    //   1492: goto -642 -> 850
    //   1495: aload_0
    //   1496: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   1499: getfield 658	com/lantern/dm/task/a:v	Ljava/lang/String;
    //   1502: ifnonnull +39 -> 1541
    //   1505: aload_0
    //   1506: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   1509: getfield 296	com/lantern/dm/task/a:c	Z
    //   1512: ifne +29 -> 1541
    //   1515: aload 7
    //   1517: invokevirtual 550	java/io/File:delete	()Z
    //   1520: pop
    //   1521: new 15	com/lantern/dm/task/d$d
    //   1524: astore 7
    //   1526: aload 7
    //   1528: aload_0
    //   1529: sipush 489
    //   1532: ldc_w 660
    //   1535: invokespecial 105	com/lantern/dm/task/d$d:<init>	(Lcom/lantern/dm/task/d;ILjava/lang/String;)V
    //   1538: aload 7
    //   1540: athrow
    //   1541: new 178	java/io/FileOutputStream
    //   1544: astore 7
    //   1546: aload 7
    //   1548: aload 14
    //   1550: getfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   1553: iconst_1
    //   1554: invokespecial 247	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   1557: aload 14
    //   1559: aload 7
    //   1561: putfield 176	com/lantern/dm/task/d$c:b	Ljava/io/FileOutputStream;
    //   1564: lload 4
    //   1566: l2i
    //   1567: istore_1
    //   1568: aload 8
    //   1570: iload_1
    //   1571: putfield 167	com/lantern/dm/task/d$a:a	I
    //   1574: aload_0
    //   1575: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   1578: getfield 663	com/lantern/dm/task/a:t	J
    //   1581: ldc2_w 664
    //   1584: lcmp
    //   1585: ifeq +18 -> 1603
    //   1588: aload 8
    //   1590: aload_0
    //   1591: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   1594: getfield 663	com/lantern/dm/task/a:t	J
    //   1597: invokestatic 668	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1600: putfield 211	com/lantern/dm/task/d$a:d	Ljava/lang/String;
    //   1603: aload 8
    //   1605: aload_0
    //   1606: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   1609: getfield 658	com/lantern/dm/task/a:v	Ljava/lang/String;
    //   1612: putfield 158	com/lantern/dm/task/d$a:b	Ljava/lang/String;
    //   1615: aload 8
    //   1617: iconst_1
    //   1618: putfield 155	com/lantern/dm/task/d$a:c	Z
    //   1621: goto -715 -> 906
    //   1624: astore 8
    //   1626: new 15	com/lantern/dm/task/d$d
    //   1629: astore 10
    //   1631: new 53	java/lang/StringBuilder
    //   1634: astore 7
    //   1636: aload 7
    //   1638: ldc_w 670
    //   1641: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1644: aload 10
    //   1646: aload_0
    //   1647: sipush 492
    //   1650: aload 7
    //   1652: aload 8
    //   1654: invokevirtual 671	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   1657: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1660: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1663: aload 8
    //   1665: invokespecial 70	com/lantern/dm/task/d$d:<init>	(Lcom/lantern/dm/task/d;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1668: aload 10
    //   1670: athrow
    //   1671: aload 14
    //   1673: getfield 651	com/lantern/dm/task/d$c:e	I
    //   1676: bipush 30
    //   1678: if_icmpge +51 -> 1729
    //   1681: aload 14
    //   1683: bipush 30
    //   1685: putfield 651	com/lantern/dm/task/d$c:e	I
    //   1688: aload 14
    //   1690: aload 14
    //   1692: getfield 651	com/lantern/dm/task/d$c:e	I
    //   1695: getstatic 674	com/lantern/dm/task/e:a	Ljava/util/Random;
    //   1698: bipush 31
    //   1700: invokevirtual 679	java/util/Random:nextInt	(I)I
    //   1703: iadd
    //   1704: putfield 651	com/lantern/dm/task/d$c:e	I
    //   1707: aload 14
    //   1709: aload 14
    //   1711: getfield 651	com/lantern/dm/task/d$c:e	I
    //   1714: sipush 1000
    //   1717: imul
    //   1718: putfield 651	com/lantern/dm/task/d$c:e	I
    //   1721: goto -612 -> 1109
    //   1724: astore 7
    //   1726: goto -617 -> 1109
    //   1729: aload 14
    //   1731: getfield 651	com/lantern/dm/task/d$c:e	I
    //   1734: ldc_w 680
    //   1737: if_icmple -49 -> 1688
    //   1740: aload 14
    //   1742: ldc_w 680
    //   1745: putfield 651	com/lantern/dm/task/d$c:e	I
    //   1748: goto -60 -> 1688
    //   1751: iload_3
    //   1752: sipush 301
    //   1755: if_icmpeq +24 -> 1779
    //   1758: iload_3
    //   1759: sipush 302
    //   1762: if_icmpeq +17 -> 1779
    //   1765: iload_3
    //   1766: sipush 303
    //   1769: if_icmpeq +10 -> 1779
    //   1772: iload_3
    //   1773: sipush 307
    //   1776: if_icmpne +283 -> 2059
    //   1779: new 53	java/lang/StringBuilder
    //   1782: astore 7
    //   1784: aload 7
    //   1786: ldc_w 682
    //   1789: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1792: aload 7
    //   1794: iload_3
    //   1795: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1798: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1801: iconst_0
    //   1802: anewarray 313	java/lang/Object
    //   1805: invokestatic 316	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1808: aload 14
    //   1810: getfield 685	com/lantern/dm/task/d$c:f	I
    //   1813: iconst_5
    //   1814: if_icmplt +23 -> 1837
    //   1817: new 15	com/lantern/dm/task/d$d
    //   1820: astore 7
    //   1822: aload 7
    //   1824: aload_0
    //   1825: sipush 497
    //   1828: ldc_w 687
    //   1831: invokespecial 105	com/lantern/dm/task/d$d:<init>	(Lcom/lantern/dm/task/d;ILjava/lang/String;)V
    //   1834: aload 7
    //   1836: athrow
    //   1837: aload 12
    //   1839: ldc_w 689
    //   1842: invokeinterface 642 2 0
    //   1847: astore 7
    //   1849: aload 7
    //   1851: ifnull +208 -> 2059
    //   1854: new 53	java/lang/StringBuilder
    //   1857: astore 8
    //   1859: aload 8
    //   1861: ldc_w 691
    //   1864: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1867: aload 8
    //   1869: aload 7
    //   1871: invokeinterface 649 1 0
    //   1876: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1879: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1882: iconst_0
    //   1883: anewarray 313	java/lang/Object
    //   1886: invokestatic 316	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   1889: new 693	java/net/URI
    //   1892: astore 10
    //   1894: aload 10
    //   1896: aload_0
    //   1897: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   1900: getfield 484	com/lantern/dm/task/a:b	Ljava/lang/String;
    //   1903: invokespecial 694	java/net/URI:<init>	(Ljava/lang/String;)V
    //   1906: new 693	java/net/URI
    //   1909: astore 8
    //   1911: aload 8
    //   1913: aload 7
    //   1915: invokeinterface 649 1 0
    //   1920: invokespecial 694	java/net/URI:<init>	(Ljava/lang/String;)V
    //   1923: aload 10
    //   1925: aload 8
    //   1927: invokevirtual 698	java/net/URI:resolve	(Ljava/net/URI;)Ljava/net/URI;
    //   1930: invokevirtual 699	java/net/URI:toString	()Ljava/lang/String;
    //   1933: astore 8
    //   1935: aload 14
    //   1937: aload 14
    //   1939: getfield 685	com/lantern/dm/task/d$c:f	I
    //   1942: iconst_1
    //   1943: iadd
    //   1944: putfield 685	com/lantern/dm/task/d$c:f	I
    //   1947: aload 14
    //   1949: aload 8
    //   1951: putfield 501	com/lantern/dm/task/d$c:i	Ljava/lang/String;
    //   1954: iload_3
    //   1955: sipush 301
    //   1958: if_icmpeq +10 -> 1968
    //   1961: iload_3
    //   1962: sipush 303
    //   1965: if_icmpne +10 -> 1975
    //   1968: aload 14
    //   1970: aload 8
    //   1972: putfield 552	com/lantern/dm/task/d$c:g	Ljava/lang/String;
    //   1975: new 9	com/lantern/dm/task/d$b
    //   1978: astore 7
    //   1980: aload 7
    //   1982: aload_0
    //   1983: iconst_0
    //   1984: invokespecial 702	com/lantern/dm/task/d$b:<init>	(Lcom/lantern/dm/task/d;B)V
    //   1987: aload 7
    //   1989: athrow
    //   1990: astore 8
    //   1992: new 53	java/lang/StringBuilder
    //   1995: astore 8
    //   1997: aload 8
    //   1999: ldc_w 704
    //   2002: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2005: aload 8
    //   2007: aload 7
    //   2009: invokeinterface 649 1 0
    //   2014: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2017: ldc_w 706
    //   2020: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2023: aload_0
    //   2024: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   2027: getfield 484	com/lantern/dm/task/a:b	Ljava/lang/String;
    //   2030: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2033: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2036: invokestatic 190	com/bluefay/b/h:c	(Ljava/lang/String;)V
    //   2039: new 15	com/lantern/dm/task/d$d
    //   2042: astore 7
    //   2044: aload 7
    //   2046: aload_0
    //   2047: sipush 495
    //   2050: ldc_w 708
    //   2053: invokespecial 105	com/lantern/dm/task/d$d:<init>	(Lcom/lantern/dm/task/d;ILjava/lang/String;)V
    //   2056: aload 7
    //   2058: athrow
    //   2059: aload 8
    //   2061: getfield 155	com/lantern/dm/task/d$a:c	Z
    //   2064: ifeq +58 -> 2122
    //   2067: sipush 206
    //   2070: istore_1
    //   2071: iload_3
    //   2072: iload_1
    //   2073: if_icmpeq +106 -> 2179
    //   2076: iload_3
    //   2077: invokestatic 544	com/lantern/core/model/a:a	(I)Z
    //   2080: ifeq +49 -> 2129
    //   2083: iload_3
    //   2084: istore_1
    //   2085: new 15	com/lantern/dm/task/d$d
    //   2088: astore 8
    //   2090: new 53	java/lang/StringBuilder
    //   2093: astore 7
    //   2095: aload 7
    //   2097: ldc_w 710
    //   2100: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2103: aload 8
    //   2105: aload_0
    //   2106: iload_1
    //   2107: aload 7
    //   2109: iload_3
    //   2110: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2113: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2116: invokespecial 105	com/lantern/dm/task/d$d:<init>	(Lcom/lantern/dm/task/d;ILjava/lang/String;)V
    //   2119: aload 8
    //   2121: athrow
    //   2122: sipush 200
    //   2125: istore_1
    //   2126: goto -55 -> 2071
    //   2129: iload_3
    //   2130: sipush 300
    //   2133: if_icmplt +17 -> 2150
    //   2136: iload_3
    //   2137: sipush 400
    //   2140: if_icmpge +10 -> 2150
    //   2143: sipush 493
    //   2146: istore_1
    //   2147: goto -62 -> 2085
    //   2150: aload 8
    //   2152: getfield 155	com/lantern/dm/task/d$a:c	Z
    //   2155: ifeq +17 -> 2172
    //   2158: iload_3
    //   2159: sipush 200
    //   2162: if_icmpne +10 -> 2172
    //   2165: sipush 489
    //   2168: istore_1
    //   2169: goto -84 -> 2085
    //   2172: sipush 494
    //   2175: istore_1
    //   2176: goto -91 -> 2085
    //   2179: new 53	java/lang/StringBuilder
    //   2182: astore 7
    //   2184: aload 7
    //   2186: ldc_w 712
    //   2189: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2192: aload 7
    //   2194: aload_0
    //   2195: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   2198: getfield 484	com/lantern/dm/task/a:b	Ljava/lang/String;
    //   2201: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2204: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2207: iconst_0
    //   2208: anewarray 313	java/lang/Object
    //   2211: invokestatic 316	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   2214: aload 8
    //   2216: getfield 155	com/lantern/dm/task/d$a:c	Z
    //   2219: ifne +582 -> 2801
    //   2222: aload 12
    //   2224: ldc_w 714
    //   2227: invokeinterface 642 2 0
    //   2232: astore 7
    //   2234: aload 7
    //   2236: ifnull +15 -> 2251
    //   2239: aload 8
    //   2241: aload 7
    //   2243: invokeinterface 649 1 0
    //   2248: putfield 715	com/lantern/dm/task/d$a:e	Ljava/lang/String;
    //   2251: aload 12
    //   2253: ldc_w 717
    //   2256: invokeinterface 642 2 0
    //   2261: astore 7
    //   2263: aload 7
    //   2265: ifnull +15 -> 2280
    //   2268: aload 8
    //   2270: aload 7
    //   2272: invokeinterface 649 1 0
    //   2277: putfield 719	com/lantern/dm/task/d$a:f	Ljava/lang/String;
    //   2280: aload 14
    //   2282: getfield 554	com/lantern/dm/task/d$c:c	Ljava/lang/String;
    //   2285: ifnonnull +35 -> 2320
    //   2288: aload 12
    //   2290: ldc_w 721
    //   2293: invokeinterface 642 2 0
    //   2298: astore 7
    //   2300: aload 7
    //   2302: ifnull +18 -> 2320
    //   2305: aload 14
    //   2307: aload 7
    //   2309: invokeinterface 649 1 0
    //   2314: invokestatic 73	com/lantern/dm/task/d:b	(Ljava/lang/String;)Ljava/lang/String;
    //   2317: putfield 554	com/lantern/dm/task/d$c:c	Ljava/lang/String;
    //   2320: aload 12
    //   2322: ldc_w 723
    //   2325: invokeinterface 642 2 0
    //   2330: astore 7
    //   2332: aload 7
    //   2334: ifnull +15 -> 2349
    //   2337: aload 8
    //   2339: aload 7
    //   2341: invokeinterface 649 1 0
    //   2346: putfield 158	com/lantern/dm/task/d$a:b	Ljava/lang/String;
    //   2349: aconst_null
    //   2350: astore 7
    //   2352: aload 12
    //   2354: ldc_w 725
    //   2357: invokeinterface 642 2 0
    //   2362: astore 13
    //   2364: aload 13
    //   2366: ifnull +12 -> 2378
    //   2369: aload 13
    //   2371: invokeinterface 649 1 0
    //   2376: astore 7
    //   2378: aload 7
    //   2380: ifnonnull +107 -> 2487
    //   2383: aload 12
    //   2385: ldc_w 727
    //   2388: invokeinterface 642 2 0
    //   2393: astore 13
    //   2395: aload 13
    //   2397: ifnull +30 -> 2427
    //   2400: aload 8
    //   2402: aload 13
    //   2404: invokeinterface 649 1 0
    //   2409: putfield 211	com/lantern/dm/task/d$a:d	Ljava/lang/String;
    //   2412: aload_0
    //   2413: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   2416: aload 8
    //   2418: getfield 211	com/lantern/dm/task/d$a:d	Ljava/lang/String;
    //   2421: invokestatic 731	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2424: putfield 663	com/lantern/dm/task/a:t	J
    //   2427: aload 8
    //   2429: getfield 211	com/lantern/dm/task/d$a:d	Ljava/lang/String;
    //   2432: ifnonnull +68 -> 2500
    //   2435: aload 7
    //   2437: ifnull +14 -> 2451
    //   2440: aload 7
    //   2442: ldc_w 733
    //   2445: invokevirtual 736	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   2448: ifne +52 -> 2500
    //   2451: iconst_1
    //   2452: istore_1
    //   2453: aload_0
    //   2454: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   2457: getfield 296	com/lantern/dm/task/a:c	Z
    //   2460: ifne +45 -> 2505
    //   2463: iload_1
    //   2464: ifeq +41 -> 2505
    //   2467: new 15	com/lantern/dm/task/d$d
    //   2470: astore 7
    //   2472: aload 7
    //   2474: aload_0
    //   2475: sipush 495
    //   2478: ldc_w 738
    //   2481: invokespecial 105	com/lantern/dm/task/d$d:<init>	(Lcom/lantern/dm/task/d;ILjava/lang/String;)V
    //   2484: aload 7
    //   2486: athrow
    //   2487: ldc_w 740
    //   2490: iconst_0
    //   2491: anewarray 313	java/lang/Object
    //   2494: invokestatic 316	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   2497: goto -70 -> 2427
    //   2500: iconst_0
    //   2501: istore_1
    //   2502: goto -49 -> 2453
    //   2505: aload_0
    //   2506: getfield 26	com/lantern/dm/task/d:a	Landroid/content/Context;
    //   2509: astore 15
    //   2511: aload_0
    //   2512: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   2515: getfield 484	com/lantern/dm/task/a:b	Ljava/lang/String;
    //   2518: astore 16
    //   2520: aload_0
    //   2521: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   2524: getfield 741	com/lantern/dm/task/a:d	Ljava/lang/String;
    //   2527: astore 13
    //   2529: aload 14
    //   2531: getfield 554	com/lantern/dm/task/d$c:c	Ljava/lang/String;
    //   2534: astore 7
    //   2536: aload_0
    //   2537: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   2540: getfield 254	com/lantern/dm/task/a:g	I
    //   2543: istore_1
    //   2544: aload 8
    //   2546: getfield 211	com/lantern/dm/task/d$a:d	Ljava/lang/String;
    //   2549: ifnull +288 -> 2837
    //   2552: aload 8
    //   2554: getfield 211	com/lantern/dm/task/d$a:d	Ljava/lang/String;
    //   2557: invokestatic 731	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   2560: lstore 4
    //   2562: aload 14
    //   2564: aload 15
    //   2566: aload 16
    //   2568: aload 13
    //   2570: aload 7
    //   2572: iload_1
    //   2573: lload 4
    //   2575: aload_0
    //   2576: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   2579: getfield 744	com/lantern/dm/task/a:x	Z
    //   2582: invokestatic 747	com/lantern/dm/task/e:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IJZ)Ljava/lang/String;
    //   2585: putfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   2588: new 53	java/lang/StringBuilder
    //   2591: astore 7
    //   2593: aload 7
    //   2595: invokespecial 748	java/lang/StringBuilder:<init>	()V
    //   2598: aload 14
    //   2600: aload 7
    //   2602: aload 14
    //   2604: getfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   2607: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2610: ldc_w 573
    //   2613: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2616: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2619: putfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   2622: new 178	java/io/FileOutputStream
    //   2625: astore 7
    //   2627: aload 7
    //   2629: aload 14
    //   2631: getfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   2634: invokespecial 749	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   2637: aload 14
    //   2639: aload 7
    //   2641: putfield 176	com/lantern/dm/task/d$c:b	Ljava/io/FileOutputStream;
    //   2644: new 53	java/lang/StringBuilder
    //   2647: astore 7
    //   2649: aload 7
    //   2651: ldc_w 751
    //   2654: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2657: aload 7
    //   2659: aload_0
    //   2660: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   2663: getfield 484	com/lantern/dm/task/a:b	Ljava/lang/String;
    //   2666: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2669: ldc_w 753
    //   2672: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2675: aload 14
    //   2677: getfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   2680: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2683: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2686: iconst_0
    //   2687: anewarray 313	java/lang/Object
    //   2690: invokestatic 316	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   2693: new 196	android/content/ContentValues
    //   2696: astore 7
    //   2698: aload 7
    //   2700: invokespecial 197	android/content/ContentValues:<init>	()V
    //   2703: aload 7
    //   2705: ldc_w 592
    //   2708: aload 14
    //   2710: getfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   2713: invokevirtual 590	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2716: aload 8
    //   2718: getfield 158	com/lantern/dm/task/d$a:b	Ljava/lang/String;
    //   2721: ifnull +16 -> 2737
    //   2724: aload 7
    //   2726: ldc_w 755
    //   2729: aload 8
    //   2731: getfield 158	com/lantern/dm/task/d$a:b	Ljava/lang/String;
    //   2734: invokevirtual 590	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2737: aload 14
    //   2739: getfield 554	com/lantern/dm/task/d$c:c	Ljava/lang/String;
    //   2742: ifnull +16 -> 2758
    //   2745: aload 7
    //   2747: ldc_w 596
    //   2750: aload 14
    //   2752: getfield 554	com/lantern/dm/task/d$c:c	Ljava/lang/String;
    //   2755: invokevirtual 590	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   2758: aload 7
    //   2760: ldc -43
    //   2762: aload_0
    //   2763: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   2766: getfield 663	com/lantern/dm/task/a:t	J
    //   2769: invokestatic 603	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   2772: invokevirtual 606	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   2775: aload_0
    //   2776: getfield 26	com/lantern/dm/task/d:a	Landroid/content/Context;
    //   2779: invokevirtual 219	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   2782: aload_0
    //   2783: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   2786: invokevirtual 222	com/lantern/dm/task/a:d	()Landroid/net/Uri;
    //   2789: aload 7
    //   2791: aconst_null
    //   2792: aconst_null
    //   2793: invokevirtual 228	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   2796: pop
    //   2797: aload_0
    //   2798: invokespecial 621	com/lantern/dm/task/d:a	()V
    //   2801: aload_0
    //   2802: aload 14
    //   2804: aload 8
    //   2806: aload 10
    //   2808: aload_0
    //   2809: aload 14
    //   2811: aload 12
    //   2813: invokespecial 757	com/lantern/dm/task/d:a	(Lcom/lantern/dm/task/d$c;Lorg/apache/http/HttpResponse;)Ljava/io/InputStream;
    //   2816: invokespecial 759	com/lantern/dm/task/d:a	(Lcom/lantern/dm/task/d$c;Lcom/lantern/dm/task/d$a;[BLjava/io/InputStream;)V
    //   2819: aload 6
    //   2821: astore 10
    //   2823: aload 9
    //   2825: astore 8
    //   2827: aload 11
    //   2829: invokevirtual 519	org/apache/http/client/methods/HttpGet:abort	()V
    //   2832: iconst_1
    //   2833: istore_2
    //   2834: goto -2668 -> 166
    //   2837: lconst_0
    //   2838: lstore 4
    //   2840: goto -278 -> 2562
    //   2843: astore 8
    //   2845: new 15	com/lantern/dm/task/d$d
    //   2848: astore 7
    //   2850: aload 7
    //   2852: aload_0
    //   2853: aload 8
    //   2855: getfield 760	com/lantern/dm/task/e$a:a	I
    //   2858: aload 8
    //   2860: getfield 761	com/lantern/dm/task/e$a:b	Ljava/lang/String;
    //   2863: invokespecial 105	com/lantern/dm/task/d$d:<init>	(Lcom/lantern/dm/task/d;ILjava/lang/String;)V
    //   2866: aload 7
    //   2868: athrow
    //   2869: astore 8
    //   2871: new 15	com/lantern/dm/task/d$d
    //   2874: astore 7
    //   2876: new 53	java/lang/StringBuilder
    //   2879: astore 10
    //   2881: aload 10
    //   2883: ldc_w 763
    //   2886: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2889: aload 7
    //   2891: aload_0
    //   2892: sipush 492
    //   2895: aload 10
    //   2897: aload 8
    //   2899: invokevirtual 671	java/io/FileNotFoundException:toString	()Ljava/lang/String;
    //   2902: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2905: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2908: aload 8
    //   2910: invokespecial 70	com/lantern/dm/task/d$d:<init>	(Lcom/lantern/dm/task/d;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   2913: aload 7
    //   2915: athrow
    //   2916: aconst_null
    //   2917: astore 12
    //   2919: aconst_null
    //   2920: astore 13
    //   2922: aconst_null
    //   2923: astore 10
    //   2925: aconst_null
    //   2926: astore 11
    //   2928: aload 10
    //   2930: astore 8
    //   2932: new 178	java/io/FileOutputStream
    //   2935: astore 7
    //   2937: aload 10
    //   2939: astore 8
    //   2941: aload 7
    //   2943: aload 14
    //   2945: getfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   2948: iconst_1
    //   2949: invokespecial 247	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   2952: aload 7
    //   2954: astore 8
    //   2956: aload 7
    //   2958: invokevirtual 767	java/io/FileOutputStream:getFD	()Ljava/io/FileDescriptor;
    //   2961: invokevirtual 772	java/io/FileDescriptor:sync	()V
    //   2964: aload 7
    //   2966: ifnull +16 -> 2982
    //   2969: aload 6
    //   2971: astore 10
    //   2973: aload 9
    //   2975: astore 8
    //   2977: aload 7
    //   2979: invokevirtual 181	java/io/FileOutputStream:close	()V
    //   2982: aload 6
    //   2984: ifnull +8 -> 2992
    //   2987: aload 6
    //   2989: invokevirtual 530	android/os/PowerManager$WakeLock:release	()V
    //   2992: aload 9
    //   2994: ifnull +25 -> 3019
    //   2997: aload 9
    //   2999: invokeinterface 534 1 0
    //   3004: ifnull +15 -> 3019
    //   3007: aload 9
    //   3009: invokeinterface 534 1 0
    //   3014: invokeinterface 539 1 0
    //   3019: aload 14
    //   3021: invokestatic 256	com/lantern/dm/task/d:a	(Lcom/lantern/dm/task/d$c;)V
    //   3024: aload 14
    //   3026: getfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   3029: ifnull +34 -> 3063
    //   3032: sipush 200
    //   3035: invokestatic 544	com/lantern/core/model/a:a	(I)Z
    //   3038: ifeq +25 -> 3063
    //   3041: new 546	java/io/File
    //   3044: dup
    //   3045: aload 14
    //   3047: getfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   3050: invokespecial 547	java/io/File:<init>	(Ljava/lang/String;)V
    //   3053: invokevirtual 550	java/io/File:delete	()Z
    //   3056: pop
    //   3057: aload 14
    //   3059: aconst_null
    //   3060: putfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   3063: aload 14
    //   3065: getfield 552	com/lantern/dm/task/d$c:g	Ljava/lang/String;
    //   3068: astore 8
    //   3070: aload 14
    //   3072: getfield 554	com/lantern/dm/task/d$c:c	Ljava/lang/String;
    //   3075: astore 10
    //   3077: new 53	java/lang/StringBuilder
    //   3080: dup
    //   3081: ldc_w 556
    //   3084: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3087: sipush 200
    //   3090: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3093: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3096: iconst_0
    //   3097: anewarray 313	java/lang/Object
    //   3100: invokestatic 316	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   3103: invokestatic 562	com/lantern/analytics/a:e	()Lcom/lantern/analytics/a;
    //   3106: ldc_w 564
    //   3109: aload_0
    //   3110: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   3113: getfield 484	com/lantern/dm/task/a:b	Ljava/lang/String;
    //   3116: invokevirtual 567	com/lantern/analytics/a:onEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   3119: new 196	android/content/ContentValues
    //   3122: dup
    //   3123: invokespecial 197	android/content/ContentValues:<init>	()V
    //   3126: astore 9
    //   3128: aload 9
    //   3130: ldc_w 272
    //   3133: sipush 200
    //   3136: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3139: invokevirtual 209	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3142: aload 9
    //   3144: ldc_w 569
    //   3147: iconst_1
    //   3148: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3151: invokevirtual 209	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3154: aload_0
    //   3155: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   3158: getfield 571	com/lantern/dm/task/a:e	Ljava/lang/String;
    //   3161: astore 6
    //   3163: aload 6
    //   3165: astore 7
    //   3167: aload 6
    //   3169: invokestatic 511	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3172: ifne +78 -> 3250
    //   3175: aload 6
    //   3177: astore 7
    //   3179: aload 6
    //   3181: ldc_w 573
    //   3184: invokevirtual 576	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3187: ifeq +63 -> 3250
    //   3190: aload 6
    //   3192: iconst_0
    //   3193: aload 6
    //   3195: invokevirtual 579	java/lang/String:length	()I
    //   3198: iconst_5
    //   3199: isub
    //   3200: invokevirtual 349	java/lang/String:substring	(II)Ljava/lang/String;
    //   3203: astore 7
    //   3205: aload 7
    //   3207: astore 6
    //   3209: new 546	java/io/File
    //   3212: astore 7
    //   3214: aload 7
    //   3216: aload_0
    //   3217: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   3220: getfield 571	com/lantern/dm/task/a:e	Ljava/lang/String;
    //   3223: invokespecial 547	java/io/File:<init>	(Ljava/lang/String;)V
    //   3226: new 546	java/io/File
    //   3229: astore 11
    //   3231: aload 11
    //   3233: aload 6
    //   3235: invokespecial 547	java/io/File:<init>	(Ljava/lang/String;)V
    //   3238: aload 7
    //   3240: aload 11
    //   3242: invokevirtual 583	java/io/File:renameTo	(Ljava/io/File;)Z
    //   3245: pop
    //   3246: aload 6
    //   3248: astore 7
    //   3250: aload_0
    //   3251: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   3254: getfield 586	com/lantern/dm/task/a:A	Ljava/lang/String;
    //   3257: invokestatic 511	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   3260: ifne +49 -> 3309
    //   3263: aload_0
    //   3264: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   3267: getfield 586	com/lantern/dm/task/a:A	Ljava/lang/String;
    //   3270: ldc_w 573
    //   3273: invokevirtual 576	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   3276: ifeq +33 -> 3309
    //   3279: aload_0
    //   3280: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   3283: getfield 586	com/lantern/dm/task/a:A	Ljava/lang/String;
    //   3286: astore 6
    //   3288: aload 9
    //   3290: ldc_w 588
    //   3293: aload 6
    //   3295: iconst_0
    //   3296: aload 6
    //   3298: invokevirtual 579	java/lang/String:length	()I
    //   3301: iconst_5
    //   3302: isub
    //   3303: invokevirtual 349	java/lang/String:substring	(II)Ljava/lang/String;
    //   3306: invokevirtual 590	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3309: aload 9
    //   3311: ldc_w 592
    //   3314: aload 7
    //   3316: invokevirtual 590	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3319: aload 8
    //   3321: ifnull +13 -> 3334
    //   3324: aload 9
    //   3326: ldc_w 594
    //   3329: aload 8
    //   3331: invokevirtual 590	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3334: aload 9
    //   3336: ldc_w 596
    //   3339: aload 10
    //   3341: invokevirtual 590	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3344: aload 9
    //   3346: ldc_w 598
    //   3349: aload_0
    //   3350: getfield 28	com/lantern/dm/task/d:c	Lcom/lantern/dm/task/i;
    //   3353: invokeinterface 261 1 0
    //   3358: invokestatic 603	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3361: invokevirtual 606	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3364: aload_0
    //   3365: getfield 26	com/lantern/dm/task/d:a	Landroid/content/Context;
    //   3368: invokevirtual 219	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   3371: aload_0
    //   3372: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   3375: invokevirtual 222	com/lantern/dm/task/a:d	()Landroid/net/Uri;
    //   3378: aload 9
    //   3380: aconst_null
    //   3381: aconst_null
    //   3382: invokevirtual 228	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   3385: pop
    //   3386: sipush 200
    //   3389: invokestatic 608	com/lantern/core/model/a:b	(I)Z
    //   3392: ifne +12 -> 3404
    //   3395: sipush 200
    //   3398: invokestatic 544	com/lantern/core/model/a:a	(I)Z
    //   3401: ifeq +10 -> 3411
    //   3404: aload_0
    //   3405: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   3408: invokevirtual 609	com/lantern/dm/task/a:b	()V
    //   3411: aload_0
    //   3412: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   3415: astore 6
    //   3417: goto -2567 -> 850
    //   3420: astore 10
    //   3422: aconst_null
    //   3423: astore 7
    //   3425: aload 7
    //   3427: astore 8
    //   3429: new 53	java/lang/StringBuilder
    //   3432: astore 11
    //   3434: aload 7
    //   3436: astore 8
    //   3438: aload 11
    //   3440: ldc_w 774
    //   3443: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3446: aload 7
    //   3448: astore 8
    //   3450: aload 11
    //   3452: aload 14
    //   3454: getfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   3457: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3460: ldc_w 776
    //   3463: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3466: aload 10
    //   3468: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3471: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3474: invokestatic 190	com/bluefay/b/h:c	(Ljava/lang/String;)V
    //   3477: aload 7
    //   3479: ifnull -497 -> 2982
    //   3482: aload 6
    //   3484: astore 10
    //   3486: aload 9
    //   3488: astore 8
    //   3490: aload 7
    //   3492: invokevirtual 181	java/io/FileOutputStream:close	()V
    //   3495: goto -513 -> 2982
    //   3498: astore 7
    //   3500: aload 6
    //   3502: astore 10
    //   3504: aload 9
    //   3506: astore 8
    //   3508: ldc_w 778
    //   3511: aload 7
    //   3513: invokestatic 781	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   3516: goto -534 -> 2982
    //   3519: astore 7
    //   3521: aload 10
    //   3523: astore 6
    //   3525: aload 6
    //   3527: ifnull +8 -> 3535
    //   3530: aload 6
    //   3532: invokevirtual 530	android/os/PowerManager$WakeLock:release	()V
    //   3535: aload 8
    //   3537: ifnull +25 -> 3562
    //   3540: aload 8
    //   3542: invokeinterface 534 1 0
    //   3547: ifnull +15 -> 3562
    //   3550: aload 8
    //   3552: invokeinterface 534 1 0
    //   3557: invokeinterface 539 1 0
    //   3562: aload 14
    //   3564: invokestatic 256	com/lantern/dm/task/d:a	(Lcom/lantern/dm/task/d$c;)V
    //   3567: aload 14
    //   3569: getfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   3572: ifnull +34 -> 3606
    //   3575: sipush 491
    //   3578: invokestatic 544	com/lantern/core/model/a:a	(I)Z
    //   3581: ifeq +25 -> 3606
    //   3584: new 546	java/io/File
    //   3587: dup
    //   3588: aload 14
    //   3590: getfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   3593: invokespecial 547	java/io/File:<init>	(Ljava/lang/String;)V
    //   3596: invokevirtual 550	java/io/File:delete	()Z
    //   3599: pop
    //   3600: aload 14
    //   3602: aconst_null
    //   3603: putfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   3606: aload 14
    //   3608: getfield 552	com/lantern/dm/task/d$c:g	Ljava/lang/String;
    //   3611: astore 6
    //   3613: aload 14
    //   3615: getfield 554	com/lantern/dm/task/d$c:c	Ljava/lang/String;
    //   3618: astore 8
    //   3620: new 53	java/lang/StringBuilder
    //   3623: dup
    //   3624: ldc_w 556
    //   3627: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3630: sipush 491
    //   3633: invokevirtual 170	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3636: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3639: iconst_0
    //   3640: anewarray 313	java/lang/Object
    //   3643: invokestatic 316	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   3646: new 196	android/content/ContentValues
    //   3649: dup
    //   3650: invokespecial 197	android/content/ContentValues:<init>	()V
    //   3653: astore 9
    //   3655: aload 9
    //   3657: ldc_w 272
    //   3660: sipush 491
    //   3663: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3666: invokevirtual 209	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3669: aload 9
    //   3671: ldc_w 569
    //   3674: iconst_1
    //   3675: invokestatic 205	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3678: invokevirtual 209	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   3681: aload 9
    //   3683: ldc_w 592
    //   3686: aload_0
    //   3687: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   3690: getfield 571	com/lantern/dm/task/a:e	Ljava/lang/String;
    //   3693: invokevirtual 590	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3696: aload 6
    //   3698: ifnull +13 -> 3711
    //   3701: aload 9
    //   3703: ldc_w 594
    //   3706: aload 6
    //   3708: invokevirtual 590	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3711: aload 9
    //   3713: ldc_w 596
    //   3716: aload 8
    //   3718: invokevirtual 590	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   3721: aload 9
    //   3723: ldc_w 598
    //   3726: aload_0
    //   3727: getfield 28	com/lantern/dm/task/d:c	Lcom/lantern/dm/task/i;
    //   3730: invokeinterface 261 1 0
    //   3735: invokestatic 603	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   3738: invokevirtual 606	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   3741: aload_0
    //   3742: getfield 26	com/lantern/dm/task/d:a	Landroid/content/Context;
    //   3745: invokevirtual 219	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   3748: aload_0
    //   3749: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   3752: invokevirtual 222	com/lantern/dm/task/a:d	()Landroid/net/Uri;
    //   3755: aload 9
    //   3757: aconst_null
    //   3758: aconst_null
    //   3759: invokevirtual 228	android/content/ContentResolver:update	(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   3762: pop
    //   3763: sipush 491
    //   3766: invokestatic 608	com/lantern/core/model/a:b	(I)Z
    //   3769: ifne +12 -> 3781
    //   3772: sipush 491
    //   3775: invokestatic 544	com/lantern/core/model/a:a	(I)Z
    //   3778: ifeq +10 -> 3788
    //   3781: aload_0
    //   3782: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   3785: invokevirtual 609	com/lantern/dm/task/a:b	()V
    //   3788: aload_0
    //   3789: getfield 30	com/lantern/dm/task/d:b	Lcom/lantern/dm/task/a;
    //   3792: iconst_0
    //   3793: putfield 612	com/lantern/dm/task/a:G	Z
    //   3796: aload 7
    //   3798: athrow
    //   3799: astore 10
    //   3801: aload 11
    //   3803: astore 7
    //   3805: aload 7
    //   3807: astore 8
    //   3809: new 53	java/lang/StringBuilder
    //   3812: astore 11
    //   3814: aload 7
    //   3816: astore 8
    //   3818: aload 11
    //   3820: ldc_w 774
    //   3823: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3826: aload 7
    //   3828: astore 8
    //   3830: aload 11
    //   3832: aload 14
    //   3834: getfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   3837: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3840: ldc_w 783
    //   3843: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3846: aload 10
    //   3848: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3851: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3854: invokestatic 190	com/bluefay/b/h:c	(Ljava/lang/String;)V
    //   3857: aload 7
    //   3859: ifnull -877 -> 2982
    //   3862: aload 6
    //   3864: astore 10
    //   3866: aload 9
    //   3868: astore 8
    //   3870: aload 7
    //   3872: invokevirtual 181	java/io/FileOutputStream:close	()V
    //   3875: goto -893 -> 2982
    //   3878: astore 7
    //   3880: aload 6
    //   3882: astore 10
    //   3884: aload 9
    //   3886: astore 8
    //   3888: ldc_w 778
    //   3891: aload 7
    //   3893: invokestatic 781	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   3896: goto -914 -> 2982
    //   3899: astore 10
    //   3901: aload 12
    //   3903: astore 7
    //   3905: aload 7
    //   3907: astore 8
    //   3909: new 53	java/lang/StringBuilder
    //   3912: astore 11
    //   3914: aload 7
    //   3916: astore 8
    //   3918: aload 11
    //   3920: ldc_w 785
    //   3923: invokespecial 58	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3926: aload 7
    //   3928: astore 8
    //   3930: aload 11
    //   3932: aload 14
    //   3934: getfield 244	com/lantern/dm/task/d$c:a	Ljava/lang/String;
    //   3937: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3940: ldc_w 523
    //   3943: invokevirtual 66	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3946: aload 10
    //   3948: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3951: invokevirtual 67	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3954: invokestatic 190	com/bluefay/b/h:c	(Ljava/lang/String;)V
    //   3957: aload 7
    //   3959: ifnull -977 -> 2982
    //   3962: aload 6
    //   3964: astore 10
    //   3966: aload 9
    //   3968: astore 8
    //   3970: aload 7
    //   3972: invokevirtual 181	java/io/FileOutputStream:close	()V
    //   3975: goto -993 -> 2982
    //   3978: astore 7
    //   3980: aload 6
    //   3982: astore 10
    //   3984: aload 9
    //   3986: astore 8
    //   3988: ldc_w 778
    //   3991: aload 7
    //   3993: invokestatic 781	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   3996: goto -1014 -> 2982
    //   3999: astore 10
    //   4001: aload 13
    //   4003: astore 7
    //   4005: aload 7
    //   4007: astore 8
    //   4009: ldc_w 787
    //   4012: aload 10
    //   4014: invokestatic 781	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   4017: aload 7
    //   4019: ifnull -1037 -> 2982
    //   4022: aload 6
    //   4024: astore 10
    //   4026: aload 9
    //   4028: astore 8
    //   4030: aload 7
    //   4032: invokevirtual 181	java/io/FileOutputStream:close	()V
    //   4035: goto -1053 -> 2982
    //   4038: astore 7
    //   4040: aload 6
    //   4042: astore 10
    //   4044: aload 9
    //   4046: astore 8
    //   4048: ldc_w 778
    //   4051: aload 7
    //   4053: invokestatic 781	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   4056: goto -1074 -> 2982
    //   4059: astore 7
    //   4061: aload 8
    //   4063: astore 11
    //   4065: aload 11
    //   4067: ifnull +16 -> 4083
    //   4070: aload 6
    //   4072: astore 10
    //   4074: aload 9
    //   4076: astore 8
    //   4078: aload 11
    //   4080: invokevirtual 181	java/io/FileOutputStream:close	()V
    //   4083: aload 6
    //   4085: astore 10
    //   4087: aload 9
    //   4089: astore 8
    //   4091: aload 7
    //   4093: athrow
    //   4094: astore 7
    //   4096: aload 7
    //   4098: invokestatic 790	com/bluefay/b/h:a	(Ljava/lang/Exception;)V
    //   4101: goto -3430 -> 671
    //   4104: astore 11
    //   4106: aload 6
    //   4108: astore 10
    //   4110: aload 9
    //   4112: astore 8
    //   4114: ldc_w 778
    //   4117: aload 11
    //   4119: invokestatic 781	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   4122: goto -39 -> 4083
    //   4125: astore 11
    //   4127: aload 6
    //   4129: astore 10
    //   4131: aload 9
    //   4133: astore 8
    //   4135: ldc_w 792
    //   4138: aload 11
    //   4140: invokestatic 781	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   4143: goto -60 -> 4083
    //   4146: astore 7
    //   4148: aload 6
    //   4150: astore 10
    //   4152: aload 9
    //   4154: astore 8
    //   4156: ldc_w 792
    //   4159: aload 7
    //   4161: invokestatic 781	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   4164: goto -1182 -> 2982
    //   4167: astore 7
    //   4169: aload 7
    //   4171: invokestatic 790	com/bluefay/b/h:a	(Ljava/lang/Exception;)V
    //   4174: goto -928 -> 3246
    //   4177: astore 7
    //   4179: aload 6
    //   4181: astore 10
    //   4183: aload 9
    //   4185: astore 8
    //   4187: ldc_w 792
    //   4190: aload 7
    //   4192: invokestatic 781	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   4195: goto -1213 -> 2982
    //   4198: astore 7
    //   4200: aload 6
    //   4202: astore 10
    //   4204: aload 9
    //   4206: astore 8
    //   4208: ldc_w 792
    //   4211: aload 7
    //   4213: invokestatic 781	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   4216: goto -1234 -> 2982
    //   4219: astore 7
    //   4221: aload 6
    //   4223: astore 10
    //   4225: aload 9
    //   4227: astore 8
    //   4229: ldc_w 792
    //   4232: aload 7
    //   4234: invokestatic 781	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   4237: goto -1255 -> 2982
    //   4240: astore 7
    //   4242: aload 6
    //   4244: astore 10
    //   4246: aload 9
    //   4248: astore 8
    //   4250: ldc_w 778
    //   4253: aload 7
    //   4255: invokestatic 781	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   4258: goto -1276 -> 2982
    //   4261: astore 7
    //   4263: aload 6
    //   4265: astore 10
    //   4267: aload 9
    //   4269: astore 8
    //   4271: ldc_w 792
    //   4274: aload 7
    //   4276: invokestatic 781	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
    //   4279: goto -1297 -> 2982
    //   4282: astore 7
    //   4284: goto -115 -> 4169
    //   4287: astore 7
    //   4289: goto -193 -> 4096
    //   4292: astore 7
    //   4294: aconst_null
    //   4295: astore 6
    //   4297: aconst_null
    //   4298: astore 8
    //   4300: goto -775 -> 3525
    //   4303: astore 7
    //   4305: aconst_null
    //   4306: astore 8
    //   4308: goto -783 -> 3525
    //   4311: astore 9
    //   4313: aload 7
    //   4315: astore 8
    //   4317: aload 9
    //   4319: astore 7
    //   4321: goto -796 -> 3525
    //   4324: astore 7
    //   4326: aconst_null
    //   4327: astore 6
    //   4329: aconst_null
    //   4330: astore 9
    //   4332: goto -3175 -> 1157
    //   4335: astore 7
    //   4337: aconst_null
    //   4338: astore 9
    //   4340: goto -3183 -> 1157
    //   4343: astore 8
    //   4345: goto -4001 -> 344
    //   4348: astore 8
    //   4350: goto -4006 -> 344
    //   4353: astore 7
    //   4355: aload 8
    //   4357: astore 11
    //   4359: goto -294 -> 4065
    //   4362: astore 10
    //   4364: goto -359 -> 4005
    //   4367: astore 10
    //   4369: goto -464 -> 3905
    //   4372: astore 10
    //   4374: goto -569 -> 3805
    //   4377: astore 10
    //   4379: goto -954 -> 3425
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4382	0	this	d
    //   394	2179	1	i	int
    //   165	2669	2	j	int
    //   965	1198	3	k	int
    //   885	1954	4	l	long
    //   22	4306	6	localObject1	Object
    //   19	299	7	localObject2	Object
    //   320	1	7	localb	b
    //   342	785	7	localObject3	Object
    //   1129	24	7	localObject4	Object
    //   1155	58	7	localThrowable1	Throwable
    //   1316	335	7	localObject5	Object
    //   1724	1	7	localNumberFormatException	NumberFormatException
    //   1782	1709	7	localObject6	Object
    //   3498	14	7	localIOException1	IOException
    //   3519	278	7	localObject7	Object
    //   3803	68	7	localObject8	Object
    //   3878	14	7	localIOException2	IOException
    //   3903	68	7	localObject9	Object
    //   3978	14	7	localIOException3	IOException
    //   4003	28	7	localObject10	Object
    //   4038	14	7	localIOException4	IOException
    //   4059	33	7	localObject11	Object
    //   4094	3	7	localException1	Exception
    //   4146	14	7	localRuntimeException1	RuntimeException
    //   4167	3	7	localException2	Exception
    //   4177	14	7	localRuntimeException2	RuntimeException
    //   4198	14	7	localRuntimeException3	RuntimeException
    //   4219	14	7	localRuntimeException4	RuntimeException
    //   4240	14	7	localIOException5	IOException
    //   4261	14	7	localRuntimeException5	RuntimeException
    //   4282	1	7	localException3	Exception
    //   4287	1	7	localException4	Exception
    //   4292	1	7	localObject12	Object
    //   4303	11	7	localObject13	Object
    //   4319	1	7	localObject14	Object
    //   4324	1	7	localThrowable2	Throwable
    //   4335	1	7	localThrowable3	Throwable
    //   4353	1	7	localObject15	Object
    //   44	285	8	localObject16	Object
    //   338	52	8	locald1	d
    //   579	1037	8	localObject17	Object
    //   1624	40	8	localFileNotFoundException1	java.io.FileNotFoundException
    //   1857	114	8	localObject18	Object
    //   1990	1	8	localURISyntaxException	java.net.URISyntaxException
    //   1995	831	8	localObject19	Object
    //   2843	16	8	locala	e.a
    //   2869	40	8	localFileNotFoundException2	java.io.FileNotFoundException
    //   2930	1386	8	localObject20	Object
    //   4343	1	8	locald2	d
    //   4348	8	8	locald3	d
    //   93	4175	9	localObject21	Object
    //   4311	7	9	localObject22	Object
    //   4330	9	9	localObject23	Object
    //   97	3243	10	localObject24	Object
    //   3420	47	10	localFileNotFoundException3	java.io.FileNotFoundException
    //   3484	38	10	localObject25	Object
    //   3799	48	10	localSyncFailedException1	java.io.SyncFailedException
    //   3864	19	10	localObject26	Object
    //   3899	48	10	localIOException6	IOException
    //   3964	19	10	localObject27	Object
    //   3999	14	10	localRuntimeException6	RuntimeException
    //   4024	242	10	localObject28	Object
    //   4362	1	10	localRuntimeException7	RuntimeException
    //   4367	1	10	localIOException7	IOException
    //   4372	1	10	localSyncFailedException2	java.io.SyncFailedException
    //   4377	1	10	localFileNotFoundException4	java.io.FileNotFoundException
    //   127	3952	11	localObject29	Object
    //   4104	14	11	localIOException8	IOException
    //   4125	14	11	localRuntimeException8	RuntimeException
    //   4357	1	11	locald4	d
    //   110	3792	12	localObject30	Object
    //   2362	1640	13	localObject31	Object
    //   16	3917	14	localc	c
    //   2509	56	15	localContext	Context
    //   2518	49	16	str	String
    // Exception table:
    //   from	to	target	type
    //   260	320	320	com/lantern/dm/task/d$b
    //   857	887	320	com/lantern/dm/task/d$b
    //   894	906	320	com/lantern/dm/task/d$b
    //   906	929	320	com/lantern/dm/task/d$b
    //   929	995	320	com/lantern/dm/task/d$b
    //   1002	1040	320	com/lantern/dm/task/d$b
    //   1045	1109	320	com/lantern/dm/task/d$b
    //   1109	1129	320	com/lantern/dm/task/d$b
    //   1495	1541	320	com/lantern/dm/task/d$b
    //   1541	1564	320	com/lantern/dm/task/d$b
    //   1568	1603	320	com/lantern/dm/task/d$b
    //   1603	1621	320	com/lantern/dm/task/d$b
    //   1626	1671	320	com/lantern/dm/task/d$b
    //   1671	1688	320	com/lantern/dm/task/d$b
    //   1688	1721	320	com/lantern/dm/task/d$b
    //   1729	1748	320	com/lantern/dm/task/d$b
    //   1779	1837	320	com/lantern/dm/task/d$b
    //   1837	1849	320	com/lantern/dm/task/d$b
    //   1854	1889	320	com/lantern/dm/task/d$b
    //   1889	1935	320	com/lantern/dm/task/d$b
    //   1935	1954	320	com/lantern/dm/task/d$b
    //   1968	1975	320	com/lantern/dm/task/d$b
    //   1975	1990	320	com/lantern/dm/task/d$b
    //   1992	2059	320	com/lantern/dm/task/d$b
    //   2059	2067	320	com/lantern/dm/task/d$b
    //   2076	2083	320	com/lantern/dm/task/d$b
    //   2085	2122	320	com/lantern/dm/task/d$b
    //   2150	2158	320	com/lantern/dm/task/d$b
    //   2179	2234	320	com/lantern/dm/task/d$b
    //   2239	2251	320	com/lantern/dm/task/d$b
    //   2251	2263	320	com/lantern/dm/task/d$b
    //   2268	2280	320	com/lantern/dm/task/d$b
    //   2280	2300	320	com/lantern/dm/task/d$b
    //   2305	2320	320	com/lantern/dm/task/d$b
    //   2320	2332	320	com/lantern/dm/task/d$b
    //   2337	2349	320	com/lantern/dm/task/d$b
    //   2352	2364	320	com/lantern/dm/task/d$b
    //   2369	2378	320	com/lantern/dm/task/d$b
    //   2383	2395	320	com/lantern/dm/task/d$b
    //   2400	2427	320	com/lantern/dm/task/d$b
    //   2427	2435	320	com/lantern/dm/task/d$b
    //   2440	2451	320	com/lantern/dm/task/d$b
    //   2453	2463	320	com/lantern/dm/task/d$b
    //   2467	2487	320	com/lantern/dm/task/d$b
    //   2487	2497	320	com/lantern/dm/task/d$b
    //   2505	2562	320	com/lantern/dm/task/d$b
    //   2562	2622	320	com/lantern/dm/task/d$b
    //   2622	2644	320	com/lantern/dm/task/d$b
    //   2644	2737	320	com/lantern/dm/task/d$b
    //   2737	2758	320	com/lantern/dm/task/d$b
    //   2758	2801	320	com/lantern/dm/task/d$b
    //   2801	2819	320	com/lantern/dm/task/d$b
    //   2845	2869	320	com/lantern/dm/task/d$b
    //   2871	2916	320	com/lantern/dm/task/d$b
    //   103	112	338	com/lantern/dm/task/d$d
    //   120	129	338	com/lantern/dm/task/d$d
    //   151	164	338	com/lantern/dm/task/d$d
    //   178	183	338	com/lantern/dm/task/d$d
    //   191	199	338	com/lantern/dm/task/d$d
    //   207	229	338	com/lantern/dm/task/d$d
    //   237	242	338	com/lantern/dm/task/d$d
    //   250	260	338	com/lantern/dm/task/d$d
    //   330	335	338	com/lantern/dm/task/d$d
    //   1139	1144	338	com/lantern/dm/task/d$d
    //   1152	1155	338	com/lantern/dm/task/d$d
    //   2827	2832	338	com/lantern/dm/task/d$d
    //   2977	2982	338	com/lantern/dm/task/d$d
    //   3490	3495	338	com/lantern/dm/task/d$d
    //   3508	3516	338	com/lantern/dm/task/d$d
    //   3870	3875	338	com/lantern/dm/task/d$d
    //   3888	3896	338	com/lantern/dm/task/d$d
    //   3970	3975	338	com/lantern/dm/task/d$d
    //   3988	3996	338	com/lantern/dm/task/d$d
    //   4030	4035	338	com/lantern/dm/task/d$d
    //   4048	4056	338	com/lantern/dm/task/d$d
    //   4078	4083	338	com/lantern/dm/task/d$d
    //   4091	4094	338	com/lantern/dm/task/d$d
    //   4114	4122	338	com/lantern/dm/task/d$d
    //   4135	4143	338	com/lantern/dm/task/d$d
    //   4156	4164	338	com/lantern/dm/task/d$d
    //   4187	4195	338	com/lantern/dm/task/d$d
    //   4208	4216	338	com/lantern/dm/task/d$d
    //   4229	4237	338	com/lantern/dm/task/d$d
    //   4250	4258	338	com/lantern/dm/task/d$d
    //   4271	4279	338	com/lantern/dm/task/d$d
    //   260	320	1129	finally
    //   857	887	1129	finally
    //   894	906	1129	finally
    //   906	929	1129	finally
    //   929	995	1129	finally
    //   1002	1040	1129	finally
    //   1045	1109	1129	finally
    //   1109	1129	1129	finally
    //   1495	1541	1129	finally
    //   1541	1564	1129	finally
    //   1568	1603	1129	finally
    //   1603	1621	1129	finally
    //   1626	1671	1129	finally
    //   1671	1688	1129	finally
    //   1688	1721	1129	finally
    //   1729	1748	1129	finally
    //   1779	1837	1129	finally
    //   1837	1849	1129	finally
    //   1854	1889	1129	finally
    //   1889	1935	1129	finally
    //   1935	1954	1129	finally
    //   1968	1975	1129	finally
    //   1975	1990	1129	finally
    //   1992	2059	1129	finally
    //   2059	2067	1129	finally
    //   2076	2083	1129	finally
    //   2085	2122	1129	finally
    //   2150	2158	1129	finally
    //   2179	2234	1129	finally
    //   2239	2251	1129	finally
    //   2251	2263	1129	finally
    //   2268	2280	1129	finally
    //   2280	2300	1129	finally
    //   2305	2320	1129	finally
    //   2320	2332	1129	finally
    //   2337	2349	1129	finally
    //   2352	2364	1129	finally
    //   2369	2378	1129	finally
    //   2383	2395	1129	finally
    //   2400	2427	1129	finally
    //   2427	2435	1129	finally
    //   2440	2451	1129	finally
    //   2453	2463	1129	finally
    //   2467	2487	1129	finally
    //   2487	2497	1129	finally
    //   2505	2562	1129	finally
    //   2562	2622	1129	finally
    //   2622	2644	1129	finally
    //   2644	2737	1129	finally
    //   2737	2758	1129	finally
    //   2758	2801	1129	finally
    //   2801	2819	1129	finally
    //   2845	2869	1129	finally
    //   2871	2916	1129	finally
    //   103	112	1155	java/lang/Throwable
    //   120	129	1155	java/lang/Throwable
    //   151	164	1155	java/lang/Throwable
    //   178	183	1155	java/lang/Throwable
    //   191	199	1155	java/lang/Throwable
    //   207	229	1155	java/lang/Throwable
    //   237	242	1155	java/lang/Throwable
    //   250	260	1155	java/lang/Throwable
    //   330	335	1155	java/lang/Throwable
    //   1139	1144	1155	java/lang/Throwable
    //   1152	1155	1155	java/lang/Throwable
    //   2827	2832	1155	java/lang/Throwable
    //   2977	2982	1155	java/lang/Throwable
    //   3490	3495	1155	java/lang/Throwable
    //   3508	3516	1155	java/lang/Throwable
    //   3870	3875	1155	java/lang/Throwable
    //   3888	3896	1155	java/lang/Throwable
    //   3970	3975	1155	java/lang/Throwable
    //   3988	3996	1155	java/lang/Throwable
    //   4030	4035	1155	java/lang/Throwable
    //   4048	4056	1155	java/lang/Throwable
    //   4078	4083	1155	java/lang/Throwable
    //   4091	4094	1155	java/lang/Throwable
    //   4114	4122	1155	java/lang/Throwable
    //   4135	4143	1155	java/lang/Throwable
    //   4156	4164	1155	java/lang/Throwable
    //   4187	4195	1155	java/lang/Throwable
    //   4208	4216	1155	java/lang/Throwable
    //   4229	4237	1155	java/lang/Throwable
    //   4250	4258	1155	java/lang/Throwable
    //   4271	4279	1155	java/lang/Throwable
    //   1541	1564	1624	java/io/FileNotFoundException
    //   1045	1109	1724	java/lang/NumberFormatException
    //   1671	1688	1724	java/lang/NumberFormatException
    //   1688	1721	1724	java/lang/NumberFormatException
    //   1729	1748	1724	java/lang/NumberFormatException
    //   1889	1935	1990	java/net/URISyntaxException
    //   2505	2562	2843	com/lantern/dm/task/e$a
    //   2562	2622	2843	com/lantern/dm/task/e$a
    //   2622	2644	2869	java/io/FileNotFoundException
    //   2932	2937	3420	java/io/FileNotFoundException
    //   2941	2952	3420	java/io/FileNotFoundException
    //   3490	3495	3498	java/io/IOException
    //   103	112	3519	finally
    //   120	129	3519	finally
    //   151	164	3519	finally
    //   178	183	3519	finally
    //   191	199	3519	finally
    //   207	229	3519	finally
    //   237	242	3519	finally
    //   250	260	3519	finally
    //   330	335	3519	finally
    //   1139	1144	3519	finally
    //   1152	1155	3519	finally
    //   1165	1170	3519	finally
    //   1178	1186	3519	finally
    //   1194	1223	3519	finally
    //   2827	2832	3519	finally
    //   2977	2982	3519	finally
    //   3490	3495	3519	finally
    //   3508	3516	3519	finally
    //   3870	3875	3519	finally
    //   3888	3896	3519	finally
    //   3970	3975	3519	finally
    //   3988	3996	3519	finally
    //   4030	4035	3519	finally
    //   4048	4056	3519	finally
    //   4078	4083	3519	finally
    //   4091	4094	3519	finally
    //   4114	4122	3519	finally
    //   4135	4143	3519	finally
    //   4156	4164	3519	finally
    //   4187	4195	3519	finally
    //   4208	4216	3519	finally
    //   4229	4237	3519	finally
    //   4250	4258	3519	finally
    //   4271	4279	3519	finally
    //   2932	2937	3799	java/io/SyncFailedException
    //   2941	2952	3799	java/io/SyncFailedException
    //   3870	3875	3878	java/io/IOException
    //   2932	2937	3899	java/io/IOException
    //   2941	2952	3899	java/io/IOException
    //   3970	3975	3978	java/io/IOException
    //   2932	2937	3999	java/lang/RuntimeException
    //   2941	2952	3999	java/lang/RuntimeException
    //   4030	4035	4038	java/io/IOException
    //   2932	2937	4059	finally
    //   2941	2952	4059	finally
    //   3809	3814	4059	finally
    //   3818	3826	4059	finally
    //   3830	3857	4059	finally
    //   3909	3914	4059	finally
    //   3918	3926	4059	finally
    //   3930	3957	4059	finally
    //   4009	4017	4059	finally
    //   592	600	4094	java/lang/Exception
    //   604	630	4094	java/lang/Exception
    //   4078	4083	4104	java/io/IOException
    //   4078	4083	4125	java/lang/RuntimeException
    //   3490	3495	4146	java/lang/RuntimeException
    //   3167	3175	4167	java/lang/Exception
    //   3179	3205	4167	java/lang/Exception
    //   3870	3875	4177	java/lang/RuntimeException
    //   3970	3975	4198	java/lang/RuntimeException
    //   4030	4035	4219	java/lang/RuntimeException
    //   2977	2982	4240	java/io/IOException
    //   2977	2982	4261	java/lang/RuntimeException
    //   3209	3246	4282	java/lang/Exception
    //   634	671	4287	java/lang/Exception
    //   24	46	4292	finally
    //   50	95	4303	finally
    //   344	395	4311	finally
    //   24	46	4324	java/lang/Throwable
    //   50	95	4335	java/lang/Throwable
    //   24	46	4343	com/lantern/dm/task/d$d
    //   50	95	4348	com/lantern/dm/task/d$d
    //   2956	2964	4353	finally
    //   3429	3434	4353	finally
    //   3438	3446	4353	finally
    //   3450	3477	4353	finally
    //   2956	2964	4362	java/lang/RuntimeException
    //   2956	2964	4367	java/io/IOException
    //   2956	2964	4372	java/io/SyncFailedException
    //   2956	2964	4377	java/io/FileNotFoundException
  }
  
  private static final class a
  {
    public int a = 0;
    public String b;
    public boolean c = false;
    public String d;
    public String e;
    public String f;
    public int g = 0;
    public long h = 0L;
  }
  
  private final class b
    extends Throwable
  {
    private b() {}
  }
  
  private static final class c
  {
    public String a;
    public FileOutputStream b;
    public String c;
    public boolean d = false;
    public int e = 0;
    public int f = 0;
    public String g;
    public boolean h = false;
    public String i;
    
    public c(a parama)
    {
      if (parama.d.endsWith(".apk")) {}
      for (this.c = "application/vnd.android.package-archive";; this.c = d.a(parama.f))
      {
        this.i = parama.b;
        this.a = parama.e;
        return;
      }
    }
  }
  
  private final class d
    extends Throwable
  {
    public int a;
    
    public d(int paramInt, String paramString)
    {
      super();
      this.a = paramInt;
    }
    
    public d(int paramInt, String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
      this.a = paramInt;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/task/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */