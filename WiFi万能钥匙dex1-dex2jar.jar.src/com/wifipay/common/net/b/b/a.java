package com.wifipay.common.net.b.b;

import com.wifipay.common.net.b.a.f;
import com.wifipay.common.net.b.k;
import com.wifipay.common.net.b.t;
import com.wifipay.common.net.b.v;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;

public class a
  implements com.wifipay.common.net.b.h
{
  protected static final boolean a = v.b;
  private static int d = 5000;
  private static int e = 4096;
  protected final h b;
  protected final c c;
  
  public a(h paramh)
  {
    this(paramh, new c(e));
  }
  
  public a(h paramh, c paramc)
  {
    this.b = paramh;
    this.c = paramc;
  }
  
  protected static Map a(Header[] paramArrayOfHeader)
  {
    TreeMap localTreeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
    for (int i = 0; i < paramArrayOfHeader.length; i++) {
      localTreeMap.put(paramArrayOfHeader[i].getName(), paramArrayOfHeader[i].getValue());
    }
    return localTreeMap;
  }
  
  private void a(long paramLong, k paramk, byte[] paramArrayOfByte, StatusLine paramStatusLine)
  {
    if ((a) || (paramLong > d)) {
      if (paramArrayOfByte == null) {
        break label82;
      }
    }
    label82:
    for (paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);; paramArrayOfByte = "null")
    {
      v.b("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", new Object[] { paramk, Long.valueOf(paramLong), paramArrayOfByte, Integer.valueOf(paramStatusLine.getStatusCode()), Integer.valueOf(paramk.u().b()) });
      return;
    }
  }
  
  private static void a(String paramString, k paramk, com.wifipay.common.net.b.a.h paramh)
  {
    t localt = paramk.u();
    int i = paramk.t();
    try
    {
      localt.a(paramh);
      paramk.b(String.format("%s-retry [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      return;
    }
    catch (com.wifipay.common.net.b.a.h paramh)
    {
      paramk.b(String.format("%s-timeout-giveup [timeout=%s]", new Object[] { paramString, Integer.valueOf(i) }));
      throw paramh;
    }
  }
  
  private byte[] a(HttpEntity paramHttpEntity)
  {
    i locali = new i(this.c, (int)paramHttpEntity.getContentLength());
    Object localObject2 = null;
    Object localObject1 = localObject2;
    Object localObject4;
    try
    {
      localObject4 = paramHttpEntity.getContent();
      if (localObject4 == null)
      {
        localObject1 = localObject2;
        localObject4 = new com/wifipay/common/net/b/a/f;
        localObject1 = localObject2;
        ((f)localObject4).<init>();
        localObject1 = localObject2;
        throw ((Throwable)localObject4);
      }
    }
    finally {}
    try
    {
      paramHttpEntity.consumeContent();
      this.c.a((byte[])localObject1);
      locali.close();
      throw ((Throwable)localObject3);
      localObject1 = localObject3;
      byte[] arrayOfByte = this.c.a(1024);
      for (;;)
      {
        localObject1 = arrayOfByte;
        int i = ((InputStream)localObject4).read(arrayOfByte);
        if (i == -1) {
          break;
        }
        localObject1 = arrayOfByte;
        locali.write(arrayOfByte, 0, i);
      }
      localObject1 = arrayOfByte;
      localObject4 = locali.toByteArray();
      try
      {
        paramHttpEntity.consumeContent();
        this.c.a(arrayOfByte);
        locali.close();
        return (byte[])localObject4;
      }
      catch (IOException paramHttpEntity)
      {
        for (;;)
        {
          v.a("Error occured when calling consumingContent", new Object[0]);
        }
      }
    }
    catch (IOException paramHttpEntity)
    {
      for (;;)
      {
        v.a("Error occured when calling consumingContent", new Object[0]);
      }
    }
  }
  
  /* Error */
  public com.wifipay.common.net.b.j a(k paramk)
  {
    // Byte code:
    //   0: invokestatic 189	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_3
    //   4: aconst_null
    //   5: astore 6
    //   7: invokestatic 195	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   10: astore 8
    //   12: new 197	java/util/HashMap
    //   15: astore 5
    //   17: aload 5
    //   19: invokespecial 198	java/util/HashMap:<init>	()V
    //   22: aload_0
    //   23: getfield 42	com/wifipay/common/net/b/b/a:b	Lcom/wifipay/common/net/b/b/h;
    //   26: aload_1
    //   27: aload 5
    //   29: invokeinterface 203 3 0
    //   34: astore 5
    //   36: aload 5
    //   38: invokeinterface 209 1 0
    //   43: astore 9
    //   45: aload 9
    //   47: invokeinterface 91 1 0
    //   52: istore_2
    //   53: aload 5
    //   55: invokeinterface 213 1 0
    //   60: invokestatic 215	com/wifipay/common/net/b/b/a:a	([Lorg/apache/http/Header;)Ljava/util/Map;
    //   63: astore 7
    //   65: iload_2
    //   66: sipush 301
    //   69: if_icmpeq +10 -> 79
    //   72: iload_2
    //   73: sipush 302
    //   76: if_icmpne +19 -> 95
    //   79: aload_1
    //   80: aload 7
    //   82: ldc -39
    //   84: invokeinterface 221 2 0
    //   89: checkcast 49	java/lang/String
    //   92: invokevirtual 223	com/wifipay/common/net/b/k:d	(Ljava/lang/String;)V
    //   95: aload 5
    //   97: invokeinterface 227 1 0
    //   102: ifnull +75 -> 177
    //   105: aload_0
    //   106: aload 5
    //   108: invokeinterface 227 1 0
    //   113: invokespecial 229	com/wifipay/common/net/b/b/a:a	(Lorg/apache/http/HttpEntity;)[B
    //   116: astore 6
    //   118: aload_0
    //   119: invokestatic 189	android/os/SystemClock:elapsedRealtime	()J
    //   122: lload_3
    //   123: lsub
    //   124: aload_1
    //   125: aload 6
    //   127: aload 9
    //   129: invokespecial 231	com/wifipay/common/net/b/b/a:a	(JLcom/wifipay/common/net/b/k;[BLorg/apache/http/StatusLine;)V
    //   132: iload_2
    //   133: sipush 200
    //   136: if_icmplt +10 -> 146
    //   139: iload_2
    //   140: sipush 299
    //   143: if_icmple +42 -> 185
    //   146: new 129	java/io/IOException
    //   149: astore 8
    //   151: aload 8
    //   153: invokespecial 232	java/io/IOException:<init>	()V
    //   156: aload 8
    //   158: athrow
    //   159: astore 5
    //   161: ldc -22
    //   163: aload_1
    //   164: new 236	com/wifipay/common/net/b/a/g
    //   167: dup
    //   168: invokespecial 237	com/wifipay/common/net/b/a/g:<init>	()V
    //   171: invokestatic 239	com/wifipay/common/net/b/b/a:a	(Ljava/lang/String;Lcom/wifipay/common/net/b/k;Lcom/wifipay/common/net/b/a/h;)V
    //   174: goto -170 -> 4
    //   177: iconst_0
    //   178: newarray <illegal type>
    //   180: astore 6
    //   182: goto -64 -> 118
    //   185: new 241	com/wifipay/common/net/b/j
    //   188: dup
    //   189: iload_2
    //   190: aload 6
    //   192: aload 7
    //   194: iconst_0
    //   195: invokestatic 189	android/os/SystemClock:elapsedRealtime	()J
    //   198: lload_3
    //   199: lsub
    //   200: invokespecial 244	com/wifipay/common/net/b/j:<init>	(I[BLjava/util/Map;ZJ)V
    //   203: astore 8
    //   205: aload 8
    //   207: areturn
    //   208: astore 5
    //   210: ldc -10
    //   212: aload_1
    //   213: new 236	com/wifipay/common/net/b/a/g
    //   216: dup
    //   217: invokespecial 237	com/wifipay/common/net/b/a/g:<init>	()V
    //   220: invokestatic 239	com/wifipay/common/net/b/b/a:a	(Ljava/lang/String;Lcom/wifipay/common/net/b/k;Lcom/wifipay/common/net/b/a/h;)V
    //   223: goto -219 -> 4
    //   226: astore 5
    //   228: new 248	java/lang/RuntimeException
    //   231: dup
    //   232: new 250	java/lang/StringBuilder
    //   235: dup
    //   236: ldc -4
    //   238: invokespecial 254	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   241: aload_1
    //   242: invokevirtual 256	com/wifipay/common/net/b/k:e	()Ljava/lang/String;
    //   245: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   248: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: aload 5
    //   253: invokespecial 266	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   256: athrow
    //   257: astore 5
    //   259: aconst_null
    //   260: astore 7
    //   262: ldc_w 268
    //   265: new 250	java/lang/StringBuilder
    //   268: dup
    //   269: ldc_w 270
    //   272: invokespecial 254	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   275: aload 5
    //   277: invokevirtual 273	java/io/IOException:getLocalizedMessage	()Ljava/lang/String;
    //   280: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokestatic 279	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
    //   289: pop
    //   290: aload 6
    //   292: ifnull +112 -> 404
    //   295: aload 6
    //   297: invokeinterface 209 1 0
    //   302: invokeinterface 91 1 0
    //   307: istore_2
    //   308: iload_2
    //   309: sipush 301
    //   312: if_icmpeq +10 -> 322
    //   315: iload_2
    //   316: sipush 302
    //   319: if_icmpne +95 -> 414
    //   322: ldc_w 281
    //   325: iconst_2
    //   326: anewarray 4	java/lang/Object
    //   329: dup
    //   330: iconst_0
    //   331: aload_1
    //   332: invokevirtual 284	com/wifipay/common/net/b/k:f	()Ljava/lang/String;
    //   335: aastore
    //   336: dup
    //   337: iconst_1
    //   338: aload_1
    //   339: invokevirtual 256	com/wifipay/common/net/b/k:e	()Ljava/lang/String;
    //   342: aastore
    //   343: invokestatic 286	com/wifipay/common/net/b/v:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   346: aload 7
    //   348: ifnull +136 -> 484
    //   351: new 241	com/wifipay/common/net/b/j
    //   354: dup
    //   355: iload_2
    //   356: aload 7
    //   358: aload 8
    //   360: iconst_0
    //   361: invokestatic 189	android/os/SystemClock:elapsedRealtime	()J
    //   364: lload_3
    //   365: lsub
    //   366: invokespecial 244	com/wifipay/common/net/b/j:<init>	(I[BLjava/util/Map;ZJ)V
    //   369: astore 5
    //   371: iload_2
    //   372: sipush 401
    //   375: if_icmpeq +10 -> 385
    //   378: iload_2
    //   379: sipush 403
    //   382: if_icmpne +59 -> 441
    //   385: ldc_w 288
    //   388: aload_1
    //   389: new 290	com/wifipay/common/net/b/a/a
    //   392: dup
    //   393: aload 5
    //   395: invokespecial 293	com/wifipay/common/net/b/a/a:<init>	(Lcom/wifipay/common/net/b/j;)V
    //   398: invokestatic 239	com/wifipay/common/net/b/b/a:a	(Ljava/lang/String;Lcom/wifipay/common/net/b/k;Lcom/wifipay/common/net/b/a/h;)V
    //   401: goto -397 -> 4
    //   404: new 295	com/wifipay/common/net/b/a/c
    //   407: dup
    //   408: aload 5
    //   410: invokespecial 298	com/wifipay/common/net/b/a/c:<init>	(Ljava/lang/Throwable;)V
    //   413: athrow
    //   414: ldc_w 300
    //   417: iconst_2
    //   418: anewarray 4	java/lang/Object
    //   421: dup
    //   422: iconst_0
    //   423: iload_2
    //   424: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   427: aastore
    //   428: dup
    //   429: iconst_1
    //   430: aload_1
    //   431: invokevirtual 256	com/wifipay/common/net/b/k:e	()Ljava/lang/String;
    //   434: aastore
    //   435: invokestatic 286	com/wifipay/common/net/b/v:c	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   438: goto -92 -> 346
    //   441: iload_2
    //   442: sipush 301
    //   445: if_icmpeq +10 -> 455
    //   448: iload_2
    //   449: sipush 302
    //   452: if_icmpne +22 -> 474
    //   455: ldc_w 302
    //   458: aload_1
    //   459: new 304	com/wifipay/common/net/b/a/e
    //   462: dup
    //   463: aload 5
    //   465: invokespecial 305	com/wifipay/common/net/b/a/e:<init>	(Lcom/wifipay/common/net/b/j;)V
    //   468: invokestatic 239	com/wifipay/common/net/b/b/a:a	(Ljava/lang/String;Lcom/wifipay/common/net/b/k;Lcom/wifipay/common/net/b/a/h;)V
    //   471: goto -467 -> 4
    //   474: new 146	com/wifipay/common/net/b/a/f
    //   477: dup
    //   478: aload 5
    //   480: invokespecial 306	com/wifipay/common/net/b/a/f:<init>	(Lcom/wifipay/common/net/b/j;)V
    //   483: athrow
    //   484: new 308	com/wifipay/common/net/b/a/b
    //   487: dup
    //   488: aload 5
    //   490: invokespecial 309	com/wifipay/common/net/b/a/b:<init>	(Ljava/lang/Throwable;)V
    //   493: athrow
    //   494: astore 7
    //   496: aconst_null
    //   497: astore 9
    //   499: aload 5
    //   501: astore 6
    //   503: aload 7
    //   505: astore 5
    //   507: aload 9
    //   509: astore 7
    //   511: goto -249 -> 262
    //   514: astore 6
    //   516: aload 7
    //   518: astore 8
    //   520: aconst_null
    //   521: astore 9
    //   523: aload 5
    //   525: astore 7
    //   527: aload 6
    //   529: astore 5
    //   531: aload 7
    //   533: astore 6
    //   535: aload 9
    //   537: astore 7
    //   539: goto -277 -> 262
    //   542: astore 9
    //   544: aload 7
    //   546: astore 8
    //   548: aload 6
    //   550: astore 7
    //   552: aload 5
    //   554: astore 6
    //   556: aload 9
    //   558: astore 5
    //   560: goto -298 -> 262
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	563	0	this	a
    //   0	563	1	paramk	k
    //   52	401	2	i	int
    //   3	362	3	l	long
    //   15	92	5	localObject1	Object
    //   159	1	5	localSocketTimeoutException	java.net.SocketTimeoutException
    //   208	1	5	localConnectTimeoutException	org.apache.http.conn.ConnectTimeoutException
    //   226	26	5	localMalformedURLException	java.net.MalformedURLException
    //   257	19	5	localIOException1	IOException
    //   369	190	5	localObject2	Object
    //   5	497	6	localObject3	Object
    //   514	14	6	localIOException2	IOException
    //   533	22	6	localObject4	Object
    //   63	294	7	localMap	Map
    //   494	10	7	localIOException3	IOException
    //   509	42	7	localObject5	Object
    //   10	537	8	localObject6	Object
    //   43	493	9	localStatusLine	StatusLine
    //   542	15	9	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   12	36	159	java/net/SocketTimeoutException
    //   36	65	159	java/net/SocketTimeoutException
    //   79	95	159	java/net/SocketTimeoutException
    //   95	118	159	java/net/SocketTimeoutException
    //   118	132	159	java/net/SocketTimeoutException
    //   146	159	159	java/net/SocketTimeoutException
    //   177	182	159	java/net/SocketTimeoutException
    //   185	205	159	java/net/SocketTimeoutException
    //   12	36	208	org/apache/http/conn/ConnectTimeoutException
    //   36	65	208	org/apache/http/conn/ConnectTimeoutException
    //   79	95	208	org/apache/http/conn/ConnectTimeoutException
    //   95	118	208	org/apache/http/conn/ConnectTimeoutException
    //   118	132	208	org/apache/http/conn/ConnectTimeoutException
    //   146	159	208	org/apache/http/conn/ConnectTimeoutException
    //   177	182	208	org/apache/http/conn/ConnectTimeoutException
    //   185	205	208	org/apache/http/conn/ConnectTimeoutException
    //   12	36	226	java/net/MalformedURLException
    //   36	65	226	java/net/MalformedURLException
    //   79	95	226	java/net/MalformedURLException
    //   95	118	226	java/net/MalformedURLException
    //   118	132	226	java/net/MalformedURLException
    //   146	159	226	java/net/MalformedURLException
    //   177	182	226	java/net/MalformedURLException
    //   185	205	226	java/net/MalformedURLException
    //   12	36	257	java/io/IOException
    //   36	65	494	java/io/IOException
    //   79	95	514	java/io/IOException
    //   95	118	514	java/io/IOException
    //   177	182	514	java/io/IOException
    //   118	132	542	java/io/IOException
    //   146	159	542	java/io/IOException
    //   185	205	542	java/io/IOException
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/b/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */