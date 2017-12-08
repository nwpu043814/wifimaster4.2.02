package com.linksure.apservice.integration.a;

import com.bluefay.b.h;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a
{
  private static final ConcurrentHashMap<String, b> a = new ConcurrentHashMap();
  
  public static void a(String paramString1, String paramString2, a parama)
  {
    if (a(paramString2)) {
      throw new RuntimeException("saveFolder must be not empty");
    }
    b localb = (b)a.get(paramString1);
    if ((localb == null) || (!localb.a()))
    {
      paramString2 = new b(paramString1, paramString2, parama);
      paramString2.start();
      a.put(paramString1, paramString2);
    }
    for (;;)
    {
      return;
      h.a("already download for url:%S", new Object[] { paramString1 });
      localb.a(parama);
    }
  }
  
  static boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
    
    public abstract void a(boolean paramBoolean, String paramString);
  }
  
  private static final class b
    extends Thread
  {
    private List<a.a> a;
    private File b;
    private String c;
    private boolean d = false;
    private String e;
    private String f;
    private AtomicBoolean g = new AtomicBoolean(false);
    
    public b(String paramString1, String paramString2, a.a parama)
    {
      this.c = paramString1;
      this.g.set(true);
      this.e = paramString2;
      this.f = null;
      this.a = new ArrayList();
      this.a.add(parama);
    }
    
    private String a(HttpURLConnection paramHttpURLConnection)
    {
      int i = 0;
      Object localObject = paramHttpURLConnection.getHeaderField(i);
      if (localObject != null) {
        if ("Content-Disposition".equalsIgnoreCase(paramHttpURLConnection.getHeaderFieldKey(i)))
        {
          localObject = Pattern.compile(".*filename=(.*)").matcher((CharSequence)localObject);
          if (((Matcher)localObject).find())
          {
            paramHttpURLConnection = new String(((Matcher)localObject).group(1).getBytes("iso-8859-1"), "utf-8").replaceAll("\"", "").replace("'", "").trim();
            h.a("-----found file name %s from Content-Disposition", new Object[] { paramHttpURLConnection });
          }
        }
      }
      for (;;)
      {
        return paramHttpURLConnection;
        i++;
        break;
        paramHttpURLConnection = paramHttpURLConnection.getURL().toString();
        h.a("final url:" + paramHttpURLConnection, new Object[0]);
        if (!this.c.equals(paramHttpURLConnection))
        {
          localObject = paramHttpURLConnection.substring(paramHttpURLConnection.lastIndexOf('/') + 1);
          if (!a.a((String)localObject))
          {
            i = ((String)localObject).indexOf("?");
            paramHttpURLConnection = (HttpURLConnection)localObject;
            if (i != -1) {
              paramHttpURLConnection = ((String)localObject).substring(0, i);
            }
            localObject = paramHttpURLConnection.trim();
            paramHttpURLConnection = (HttpURLConnection)localObject;
            if (!a.a((String)localObject)) {
              continue;
            }
          }
        }
        paramHttpURLConnection = URLDecoder.decode(this.c, "utf-8");
        localObject = paramHttpURLConnection.substring(paramHttpURLConnection.lastIndexOf('/') + 1);
        if ((localObject == null) || ("".equals(((String)localObject).trim())))
        {
          paramHttpURLConnection = UUID.randomUUID().toString();
          h.a("-----random file name " + paramHttpURLConnection, new Object[0]);
        }
        else
        {
          i = ((String)localObject).indexOf("?");
          paramHttpURLConnection = (HttpURLConnection)localObject;
          if (i != -1) {
            paramHttpURLConnection = ((String)localObject).substring(0, i);
          }
          localObject = paramHttpURLConnection.trim();
          h.a("-----found file name " + (String)localObject + " from url " + this.c, new Object[0]);
          paramHttpURLConnection = (HttpURLConnection)localObject;
          if (((String)localObject).equals(""))
          {
            h.a("-----file name \"" + (String)localObject + "\" is invalidate,do random UUID----", new Object[0]);
            paramHttpURLConnection = UUID.randomUUID().toString();
            h.a("-----random file name " + paramHttpURLConnection, new Object[0]);
          }
        }
      }
    }
    
    private void a(int paramInt1, int paramInt2)
    {
      if (this.a == null) {}
      for (;;)
      {
        return;
        paramInt1 = paramInt2 * 100 / paramInt1;
        synchronized (this.a)
        {
          Iterator localIterator = this.a.iterator();
          if (localIterator.hasNext()) {
            ((a.a)localIterator.next()).a(paramInt1);
          }
        }
      }
    }
    
    private void a(boolean paramBoolean, String paramString)
    {
      if (this.a == null) {}
      for (;;)
      {
        return;
        synchronized (this.a)
        {
          Iterator localIterator = this.a.iterator();
          if (localIterator.hasNext()) {
            ((a.a)localIterator.next()).a(paramBoolean, paramString);
          }
        }
        this.a.clear();
      }
    }
    
    private static void b(HttpURLConnection paramHttpURLConnection)
    {
      Object localObject2 = new LinkedHashMap();
      Object localObject1;
      for (int i = 0;; i++)
      {
        localObject1 = paramHttpURLConnection.getHeaderField(i);
        if (localObject1 == null) {
          break;
        }
        ((Map)localObject2).put(paramHttpURLConnection.getHeaderFieldKey(i), localObject1);
      }
      localObject2 = ((Map)localObject2).entrySet().iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject1 = (Map.Entry)((Iterator)localObject2).next();
        if (((Map.Entry)localObject1).getKey() != null) {}
        for (paramHttpURLConnection = (String)((Map.Entry)localObject1).getKey() + ":";; paramHttpURLConnection = "")
        {
          h.a(paramHttpURLConnection + (String)((Map.Entry)localObject1).getValue(), new Object[0]);
          break;
        }
      }
    }
    
    public final void a(a.a parama)
    {
      try
      {
        if (this.a == null)
        {
          ArrayList localArrayList = new java/util/ArrayList;
          localArrayList.<init>();
          this.a = localArrayList;
        }
        this.a.add(parama);
        return;
      }
      finally {}
    }
    
    public final boolean a()
    {
      return this.g.get();
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore 7
      //   3: ldc_w 259
      //   6: iconst_1
      //   7: anewarray 126	java/lang/Object
      //   10: dup
      //   11: iconst_0
      //   12: aload_0
      //   13: getfield 35	com/linksure/apservice/integration/a/a$b:c	Ljava/lang/String;
      //   16: aastore
      //   17: invokestatic 131	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   20: new 261	java/io/File
      //   23: astore 4
      //   25: aload 4
      //   27: aload_0
      //   28: getfield 40	com/linksure/apservice/integration/a/a$b:e	Ljava/lang/String;
      //   31: invokespecial 262	java/io/File:<init>	(Ljava/lang/String;)V
      //   34: aload 4
      //   36: invokevirtual 265	java/io/File:exists	()Z
      //   39: ifne +9 -> 48
      //   42: aload 4
      //   44: invokevirtual 268	java/io/File:mkdirs	()Z
      //   47: pop
      //   48: aload 4
      //   50: invokevirtual 265	java/io/File:exists	()Z
      //   53: ifne +129 -> 182
      //   56: new 270	java/lang/RuntimeException
      //   59: astore 4
      //   61: new 142	java/lang/StringBuilder
      //   64: astore 5
      //   66: aload 5
      //   68: ldc_w 272
      //   71: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   74: aload 4
      //   76: aload 5
      //   78: aload_0
      //   79: getfield 40	com/linksure/apservice/integration/a/a$b:e	Ljava/lang/String;
      //   82: invokevirtual 151	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   85: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   88: invokespecial 273	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   91: aload 4
      //   93: athrow
      //   94: astore 8
      //   96: aconst_null
      //   97: astore 5
      //   99: aconst_null
      //   100: astore 4
      //   102: aload 5
      //   104: astore 7
      //   106: aload 4
      //   108: astore 6
      //   110: ldc_w 275
      //   113: aload 8
      //   115: invokestatic 278	com/bluefay/b/h:a	(Ljava/lang/String;Ljava/lang/Exception;)V
      //   118: aload 4
      //   120: ifnull +8 -> 128
      //   123: aload 4
      //   125: invokevirtual 283	java/io/InputStream:close	()V
      //   128: aload 5
      //   130: ifnull +8 -> 138
      //   133: aload 5
      //   135: invokevirtual 286	java/io/FileOutputStream:close	()V
      //   138: aload_0
      //   139: getfield 288	com/linksure/apservice/integration/a/a$b:b	Ljava/io/File;
      //   142: ifnonnull +628 -> 770
      //   145: aconst_null
      //   146: astore 4
      //   148: aload_0
      //   149: aload_0
      //   150: getfield 26	com/linksure/apservice/integration/a/a$b:d	Z
      //   153: aload 4
      //   155: invokespecial 289	com/linksure/apservice/integration/a/a$b:a	(ZLjava/lang/String;)V
      //   158: aload_0
      //   159: getfield 33	com/linksure/apservice/integration/a/a$b:g	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   162: iconst_1
      //   163: iconst_0
      //   164: invokevirtual 293	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
      //   167: ifeq +14 -> 181
      //   170: invokestatic 296	com/linksure/apservice/integration/a/a:a	()Ljava/util/concurrent/ConcurrentHashMap;
      //   173: aload_0
      //   174: getfield 35	com/linksure/apservice/integration/a/a$b:c	Ljava/lang/String;
      //   177: invokevirtual 302	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
      //   180: pop
      //   181: return
      //   182: new 137	java/net/URL
      //   185: astore 4
      //   187: aload 4
      //   189: aload_0
      //   190: getfield 35	com/linksure/apservice/integration/a/a$b:c	Ljava/lang/String;
      //   193: invokespecial 303	java/net/URL:<init>	(Ljava/lang/String;)V
      //   196: aload 4
      //   198: invokevirtual 307	java/net/URL:openConnection	()Ljava/net/URLConnection;
      //   201: checkcast 57	java/net/HttpURLConnection
      //   204: astore 5
      //   206: aload 5
      //   208: sipush 5000
      //   211: invokevirtual 310	java/net/HttpURLConnection:setConnectTimeout	(I)V
      //   214: aload 5
      //   216: sipush 8000
      //   219: invokevirtual 313	java/net/HttpURLConnection:setReadTimeout	(I)V
      //   222: aload 5
      //   224: ldc_w 315
      //   227: invokevirtual 318	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
      //   230: aload 5
      //   232: ldc_w 320
      //   235: ldc_w 322
      //   238: invokevirtual 326	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   241: aload 5
      //   243: ldc_w 328
      //   246: ldc_w 330
      //   249: invokevirtual 326	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   252: aload 5
      //   254: ldc_w 332
      //   257: aload_0
      //   258: getfield 35	com/linksure/apservice/integration/a/a$b:c	Ljava/lang/String;
      //   261: invokevirtual 333	java/lang/String:toString	()Ljava/lang/String;
      //   264: invokevirtual 326	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   267: aload 5
      //   269: ldc_w 335
      //   272: ldc_w 337
      //   275: invokevirtual 326	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   278: aload 5
      //   280: ldc_w 339
      //   283: ldc_w 341
      //   286: invokevirtual 326	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   289: aload 5
      //   291: ldc_w 343
      //   294: ldc_w 345
      //   297: invokevirtual 326	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
      //   300: aload 5
      //   302: invokevirtual 348	java/net/HttpURLConnection:connect	()V
      //   305: aload 5
      //   307: invokestatic 350	com/linksure/apservice/integration/a/a$b:b	(Ljava/net/HttpURLConnection;)V
      //   310: aload_0
      //   311: getfield 42	com/linksure/apservice/integration/a/a$b:f	Ljava/lang/String;
      //   314: invokestatic 164	com/linksure/apservice/integration/a/a:a	(Ljava/lang/String;)Z
      //   317: ifeq +23 -> 340
      //   320: ldc_w 352
      //   323: iconst_0
      //   324: anewarray 126	java/lang/Object
      //   327: invokestatic 131	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   330: aload_0
      //   331: aload_0
      //   332: aload 5
      //   334: invokespecial 354	com/linksure/apservice/integration/a/a$b:a	(Ljava/net/HttpURLConnection;)Ljava/lang/String;
      //   337: putfield 42	com/linksure/apservice/integration/a/a$b:f	Ljava/lang/String;
      //   340: new 261	java/io/File
      //   343: astore 4
      //   345: aload 4
      //   347: aload_0
      //   348: getfield 40	com/linksure/apservice/integration/a/a$b:e	Ljava/lang/String;
      //   351: aload_0
      //   352: getfield 42	com/linksure/apservice/integration/a/a$b:f	Ljava/lang/String;
      //   355: invokespecial 356	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   358: aload_0
      //   359: aload 4
      //   361: putfield 288	com/linksure/apservice/integration/a/a$b:b	Ljava/io/File;
      //   364: new 142	java/lang/StringBuilder
      //   367: astore 4
      //   369: aload 4
      //   371: ldc_w 358
      //   374: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   377: aload 4
      //   379: aload 5
      //   381: invokevirtual 362	java/net/HttpURLConnection:getResponseCode	()I
      //   384: invokevirtual 365	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   387: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   390: iconst_0
      //   391: anewarray 126	java/lang/Object
      //   394: invokestatic 131	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   397: aload 5
      //   399: invokevirtual 362	java/net/HttpURLConnection:getResponseCode	()I
      //   402: sipush 200
      //   405: if_icmpne +298 -> 703
      //   408: aload 5
      //   410: invokevirtual 369	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
      //   413: astore 4
      //   415: aload 5
      //   417: invokevirtual 372	java/net/HttpURLConnection:getContentLength	()I
      //   420: istore_2
      //   421: new 374	java/io/BufferedInputStream
      //   424: astore 9
      //   426: aload 9
      //   428: aload 4
      //   430: invokespecial 377	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
      //   433: sipush 8192
      //   436: newarray <illegal type>
      //   438: astore 8
      //   440: new 285	java/io/FileOutputStream
      //   443: astore 5
      //   445: aload 5
      //   447: aload_0
      //   448: getfield 288	com/linksure/apservice/integration/a/a$b:b	Ljava/io/File;
      //   451: invokespecial 380	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
      //   454: aload 5
      //   456: astore 7
      //   458: aload 4
      //   460: astore 6
      //   462: aload 5
      //   464: invokevirtual 384	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
      //   467: astore 10
      //   469: aload 5
      //   471: astore 7
      //   473: aload 4
      //   475: astore 6
      //   477: aload 10
      //   479: lconst_0
      //   480: invokevirtual 390	java/nio/channels/FileChannel:position	(J)Ljava/nio/channels/FileChannel;
      //   483: pop
      //   484: iconst_0
      //   485: istore_1
      //   486: aload 5
      //   488: astore 7
      //   490: aload 4
      //   492: astore 6
      //   494: aload 9
      //   496: aload 8
      //   498: invokevirtual 394	java/io/BufferedInputStream:read	([B)I
      //   501: istore_3
      //   502: iload_3
      //   503: iconst_m1
      //   504: if_icmpeq +68 -> 572
      //   507: aload 5
      //   509: astore 7
      //   511: aload 4
      //   513: astore 6
      //   515: aload_0
      //   516: getfield 33	com/linksure/apservice/integration/a/a$b:g	Ljava/util/concurrent/atomic/AtomicBoolean;
      //   519: invokevirtual 252	java/util/concurrent/atomic/AtomicBoolean:get	()Z
      //   522: ifeq +50 -> 572
      //   525: aload 5
      //   527: astore 7
      //   529: aload 4
      //   531: astore 6
      //   533: aload 10
      //   535: aload 8
      //   537: iconst_0
      //   538: iload_3
      //   539: invokestatic 400	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
      //   542: invokevirtual 404	java/nio/channels/FileChannel:write	(Ljava/nio/ByteBuffer;)I
      //   545: pop
      //   546: iload_1
      //   547: iload_3
      //   548: iadd
      //   549: istore_1
      //   550: aload 5
      //   552: astore 7
      //   554: aload 4
      //   556: astore 6
      //   558: aload_0
      //   559: iload_2
      //   560: iload_1
      //   561: invokespecial 406	com/linksure/apservice/integration/a/a$b:a	(II)V
      //   564: goto -78 -> 486
      //   567: astore 8
      //   569: goto -467 -> 102
      //   572: aload 5
      //   574: astore 7
      //   576: aload 4
      //   578: astore 6
      //   580: aload 10
      //   582: invokevirtual 407	java/nio/channels/FileChannel:close	()V
      //   585: aload 5
      //   587: astore 7
      //   589: aload 4
      //   591: astore 6
      //   593: aload 5
      //   595: invokevirtual 286	java/io/FileOutputStream:close	()V
      //   598: aload 5
      //   600: astore 7
      //   602: aload 4
      //   604: astore 6
      //   606: aload 4
      //   608: invokevirtual 283	java/io/InputStream:close	()V
      //   611: aload 5
      //   613: astore 7
      //   615: aload 4
      //   617: astore 6
      //   619: new 142	java/lang/StringBuilder
      //   622: astore 8
      //   624: aload 5
      //   626: astore 7
      //   628: aload 4
      //   630: astore 6
      //   632: aload 8
      //   634: ldc_w 409
      //   637: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   640: aload 5
      //   642: astore 7
      //   644: aload 4
      //   646: astore 6
      //   648: aload 8
      //   650: aload_0
      //   651: getfield 288	com/linksure/apservice/integration/a/a$b:b	Ljava/io/File;
      //   654: invokevirtual 412	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   657: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   660: iconst_0
      //   661: anewarray 126	java/lang/Object
      //   664: invokestatic 131	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
      //   667: aload 5
      //   669: astore 7
      //   671: aload 4
      //   673: astore 6
      //   675: aload_0
      //   676: iconst_1
      //   677: putfield 26	com/linksure/apservice/integration/a/a$b:d	Z
      //   680: aload 4
      //   682: ifnull +8 -> 690
      //   685: aload 4
      //   687: invokevirtual 283	java/io/InputStream:close	()V
      //   690: aload 5
      //   692: invokevirtual 286	java/io/FileOutputStream:close	()V
      //   695: goto -557 -> 138
      //   698: astore 4
      //   700: goto -562 -> 138
      //   703: new 270	java/lang/RuntimeException
      //   706: astore 4
      //   708: new 142	java/lang/StringBuilder
      //   711: astore 6
      //   713: aload 6
      //   715: ldc_w 414
      //   718: invokespecial 147	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   721: aload 4
      //   723: aload 6
      //   725: aload 5
      //   727: invokevirtual 362	java/net/HttpURLConnection:getResponseCode	()I
      //   730: invokevirtual 365	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   733: invokevirtual 152	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   736: invokespecial 273	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   739: aload 4
      //   741: athrow
      //   742: astore 5
      //   744: aconst_null
      //   745: astore 4
      //   747: aload 4
      //   749: ifnull +8 -> 757
      //   752: aload 4
      //   754: invokevirtual 283	java/io/InputStream:close	()V
      //   757: aload 7
      //   759: ifnull +8 -> 767
      //   762: aload 7
      //   764: invokevirtual 286	java/io/FileOutputStream:close	()V
      //   767: aload 5
      //   769: athrow
      //   770: aload_0
      //   771: getfield 288	com/linksure/apservice/integration/a/a$b:b	Ljava/io/File;
      //   774: invokevirtual 417	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   777: astore 4
      //   779: goto -631 -> 148
      //   782: astore 4
      //   784: goto -94 -> 690
      //   787: astore 4
      //   789: goto -661 -> 128
      //   792: astore 4
      //   794: goto -656 -> 138
      //   797: astore 4
      //   799: goto -42 -> 757
      //   802: astore 4
      //   804: goto -37 -> 767
      //   807: astore 5
      //   809: goto -62 -> 747
      //   812: astore 5
      //   814: aload 6
      //   816: astore 4
      //   818: goto -71 -> 747
      //   821: astore 8
      //   823: aconst_null
      //   824: astore 5
      //   826: goto -724 -> 102
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	829	0	this	b
      //   485	76	1	i	int
      //   420	140	2	j	int
      //   501	48	3	k	int
      //   23	663	4	localObject1	Object
      //   698	1	4	localIOException1	java.io.IOException
      //   706	72	4	localObject2	Object
      //   782	1	4	localIOException2	java.io.IOException
      //   787	1	4	localIOException3	java.io.IOException
      //   792	1	4	localIOException4	java.io.IOException
      //   797	1	4	localIOException5	java.io.IOException
      //   802	1	4	localIOException6	java.io.IOException
      //   816	1	4	localObject3	Object
      //   64	662	5	localObject4	Object
      //   742	26	5	localObject5	Object
      //   807	1	5	localObject6	Object
      //   812	1	5	localObject7	Object
      //   824	1	5	localObject8	Object
      //   108	707	6	localObject9	Object
      //   1	762	7	localObject10	Object
      //   94	20	8	localException1	Exception
      //   438	98	8	arrayOfByte	byte[]
      //   567	1	8	localException2	Exception
      //   622	27	8	localStringBuilder	StringBuilder
      //   821	1	8	localException3	Exception
      //   424	71	9	localBufferedInputStream	java.io.BufferedInputStream
      //   467	114	10	localFileChannel	java.nio.channels.FileChannel
      // Exception table:
      //   from	to	target	type
      //   20	48	94	java/lang/Exception
      //   48	94	94	java/lang/Exception
      //   182	340	94	java/lang/Exception
      //   340	415	94	java/lang/Exception
      //   703	742	94	java/lang/Exception
      //   462	469	567	java/lang/Exception
      //   477	484	567	java/lang/Exception
      //   494	502	567	java/lang/Exception
      //   515	525	567	java/lang/Exception
      //   533	546	567	java/lang/Exception
      //   558	564	567	java/lang/Exception
      //   580	585	567	java/lang/Exception
      //   593	598	567	java/lang/Exception
      //   606	611	567	java/lang/Exception
      //   619	624	567	java/lang/Exception
      //   632	640	567	java/lang/Exception
      //   648	667	567	java/lang/Exception
      //   675	680	567	java/lang/Exception
      //   690	695	698	java/io/IOException
      //   20	48	742	finally
      //   48	94	742	finally
      //   182	340	742	finally
      //   340	415	742	finally
      //   703	742	742	finally
      //   685	690	782	java/io/IOException
      //   123	128	787	java/io/IOException
      //   133	138	792	java/io/IOException
      //   752	757	797	java/io/IOException
      //   762	767	802	java/io/IOException
      //   415	454	807	finally
      //   110	118	812	finally
      //   462	469	812	finally
      //   477	484	812	finally
      //   494	502	812	finally
      //   515	525	812	finally
      //   533	546	812	finally
      //   558	564	812	finally
      //   580	585	812	finally
      //   593	598	812	finally
      //   606	611	812	finally
      //   619	624	812	finally
      //   632	640	812	finally
      //   648	667	812	finally
      //   675	680	812	finally
      //   415	454	821	java/lang/Exception
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/integration/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */