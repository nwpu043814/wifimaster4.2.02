package com.lantern.notifaction.o2o;

import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import com.bluefay.b.h;
import com.lantern.analytics.a;
import com.lantern.core.c;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class e
{
  private final int a = 1;
  private SparseArray<Long> b = new SparseArray();
  private boolean c = false;
  private Context d;
  private NotificationManager e;
  private Notification.Builder f;
  private HashMap<String, Bitmap> g = new HashMap();
  private ArrayList<b> h;
  private a i = a.d;
  private String j;
  private String k;
  private boolean l = false;
  private boolean m = false;
  private Handler n;
  private AtomicInteger o = new AtomicInteger();
  private AtomicInteger p;
  private boolean q = false;
  private Comparator<b> r = new g(this);
  
  public e(Context paramContext)
  {
    this.d = paramContext.getApplicationContext();
    this.e = ((NotificationManager)this.d.getSystemService("notification"));
    this.f = new Notification.Builder(this.d);
    this.f.setSmallIcon(2130838408);
    this.f.setAutoCancel(false);
    this.f.setOngoing(true);
    this.n = new Handler(new f(this));
  }
  
  private RemoteViews a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    paramString1 = a(paramInt1, paramString1, paramString2, false, 0, paramInt3);
    paramString1.setImageViewResource(2131821145, paramInt2);
    return paramString1;
  }
  
  private RemoteViews a(int paramInt1, String paramString1, String paramString2, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    Object localObject = new Intent(c.getInstance(), O2OServiceActivity.class);
    ((Intent)localObject).setPackage(this.d.getPackageName());
    ((Intent)localObject).addFlags(268435456);
    ((Intent)localObject).putExtra("service_type", paramInt1);
    ((Intent)localObject).putExtra("service_url", paramString1);
    ((Intent)localObject).putExtra("key_extra_state", this.q);
    paramString1 = PendingIntent.getActivity(this.d, paramInt3, (Intent)localObject, 134217728);
    localObject = new RemoteViews(this.d.getPackageName(), 2130968805);
    ((RemoteViews)localObject).setOnClickPendingIntent(2131821144, paramString1);
    ((RemoteViews)localObject).setTextViewText(2131821146, paramString2);
    if (paramBoolean) {
      if (paramInt2 > 0)
      {
        ((RemoteViews)localObject).setViewVisibility(2131821147, 0);
        ((RemoteViews)localObject).setViewVisibility(2131821148, 8);
        ((RemoteViews)localObject).setTextViewText(2131821147, String.valueOf(paramInt2));
      }
    }
    for (;;)
    {
      return (RemoteViews)localObject;
      ((RemoteViews)localObject).setViewVisibility(2131821147, 8);
      ((RemoteViews)localObject).setViewVisibility(2131821148, 0);
      continue;
      ((RemoteViews)localObject).setViewVisibility(2131821147, 8);
      ((RemoteViews)localObject).setViewVisibility(2131821148, 8);
    }
  }
  
  private void a(RemoteViews paramRemoteViews)
  {
    h.a("fillDefaultServices", new Object[0]);
    paramRemoteViews.removeAllViews(2131821143);
    if (com.bluefay.a.b.a(this.d, "com.sina.weibo"))
    {
      this.q = false;
      a.e().onEvent("wbicshow_df");
      paramRemoteViews.addView(2131821143, a(1, "", this.d.getString(2131363322), 2130838354, this.p.incrementAndGet()));
    }
    paramRemoteViews.addView(2131821143, a(4, "http://o2o.lianwifi.com/client/redirect.do?redirectUrl=http%3A%2F%2Fo2o.lianwifi.com%2Fap%2Findex.htm%3FapId%3D%7BapRefId%7D", this.d.getString(2131363317), 2130838416, this.p.incrementAndGet()));
  }
  
  /* Error */
  private void a(RemoteViews paramRemoteViews, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 271	com/lantern/notifaction/o2o/e:h	Ljava/util/ArrayList;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 271	com/lantern/notifaction/o2o/e:h	Ljava/util/ArrayList;
    //   13: invokevirtual 276	java/util/ArrayList:size	()I
    //   16: istore_3
    //   17: iload_3
    //   18: ifne +6 -> 24
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: ldc_w 278
    //   27: iconst_1
    //   28: anewarray 4	java/lang/Object
    //   31: dup
    //   32: iconst_0
    //   33: iload_2
    //   34: invokestatic 283	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   37: aastore
    //   38: invokestatic 222	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   41: aload_1
    //   42: ldc -33
    //   44: invokevirtual 227	android/widget/RemoteViews:removeAllViews	(I)V
    //   47: aload_0
    //   48: getfield 271	com/lantern/notifaction/o2o/e:h	Ljava/util/ArrayList;
    //   51: aload_0
    //   52: getfield 82	com/lantern/notifaction/o2o/e:r	Ljava/util/Comparator;
    //   55: invokestatic 289	java/util/Collections:sort	(Ljava/util/List;Ljava/util/Comparator;)V
    //   58: aload_0
    //   59: getfield 90	com/lantern/notifaction/o2o/e:d	Landroid/content/Context;
    //   62: ldc -27
    //   64: invokestatic 234	com/bluefay/a/b:a	(Landroid/content/Context;Ljava/lang/String;)Z
    //   67: istore 9
    //   69: aload_0
    //   70: getfield 73	com/lantern/notifaction/o2o/e:o	Ljava/util/concurrent/atomic/AtomicInteger;
    //   73: iconst_0
    //   74: invokevirtual 292	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   77: iconst_0
    //   78: istore_3
    //   79: aload_0
    //   80: getfield 271	com/lantern/notifaction/o2o/e:h	Ljava/util/ArrayList;
    //   83: invokevirtual 276	java/util/ArrayList:size	()I
    //   86: istore 6
    //   88: iconst_0
    //   89: istore 4
    //   91: iload 4
    //   93: iload 6
    //   95: if_icmpge +508 -> 603
    //   98: aload_0
    //   99: getfield 271	com/lantern/notifaction/o2o/e:h	Ljava/util/ArrayList;
    //   102: iload 4
    //   104: invokevirtual 296	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   107: checkcast 298	com/lantern/notifaction/o2o/b
    //   110: astore 12
    //   112: iload 9
    //   114: ifeq +233 -> 347
    //   117: iload 4
    //   119: iload 6
    //   121: iconst_1
    //   122: isub
    //   123: if_icmpne +224 -> 347
    //   126: aload_0
    //   127: iconst_1
    //   128: putfield 75	com/lantern/notifaction/o2o/e:q	Z
    //   131: invokestatic 239	com/lantern/analytics/a:e	()Lcom/lantern/analytics/a;
    //   134: ldc_w 300
    //   137: invokevirtual 245	com/lantern/analytics/a:onEvent	(Ljava/lang/String;)V
    //   140: aload_0
    //   141: getfield 90	com/lantern/notifaction/o2o/e:d	Landroid/content/Context;
    //   144: invokevirtual 304	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   147: ldc -4
    //   149: invokevirtual 310	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   152: checkcast 312	android/graphics/drawable/BitmapDrawable
    //   155: invokevirtual 316	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   158: astore 10
    //   160: aload 12
    //   162: aload_0
    //   163: getfield 90	com/lantern/notifaction/o2o/e:d	Landroid/content/Context;
    //   166: ldc -8
    //   168: invokevirtual 251	android/content/Context:getString	(I)Ljava/lang/String;
    //   171: invokevirtual 318	com/lantern/notifaction/o2o/b:b	(Ljava/lang/String;)V
    //   174: aload 12
    //   176: iconst_1
    //   177: invokevirtual 320	com/lantern/notifaction/o2o/b:c	(I)V
    //   180: iload 9
    //   182: ifne +42 -> 224
    //   185: iload 4
    //   187: iload 6
    //   189: iconst_1
    //   190: isub
    //   191: if_icmpne +33 -> 224
    //   194: iconst_1
    //   195: aload 12
    //   197: invokevirtual 322	com/lantern/notifaction/o2o/b:g	()I
    //   200: if_icmpne +24 -> 224
    //   203: aload 12
    //   205: iconst_4
    //   206: invokevirtual 320	com/lantern/notifaction/o2o/b:c	(I)V
    //   209: aload 12
    //   211: aload_0
    //   212: getfield 90	com/lantern/notifaction/o2o/e:d	Landroid/content/Context;
    //   215: ldc_w 267
    //   218: invokevirtual 251	android/content/Context:getString	(I)Ljava/lang/String;
    //   221: invokevirtual 318	com/lantern/notifaction/o2o/b:b	(Ljava/lang/String;)V
    //   224: aload 10
    //   226: ifnonnull +250 -> 476
    //   229: ldc_w 324
    //   232: iconst_1
    //   233: anewarray 4	java/lang/Object
    //   236: dup
    //   237: iconst_0
    //   238: aload 12
    //   240: invokevirtual 326	com/lantern/notifaction/o2o/b:a	()Ljava/lang/String;
    //   243: aastore
    //   244: invokestatic 222	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: iconst_1
    //   248: istore_3
    //   249: iload_2
    //   250: ifeq +353 -> 603
    //   253: aload 12
    //   255: invokevirtual 326	com/lantern/notifaction/o2o/b:a	()Ljava/lang/String;
    //   258: astore 10
    //   260: new 328	java/lang/StringBuilder
    //   263: astore 11
    //   265: aload 11
    //   267: ldc_w 330
    //   270: invokespecial 332	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   273: aload 11
    //   275: aload 10
    //   277: invokevirtual 336	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 339	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: iconst_0
    //   284: anewarray 4	java/lang/Object
    //   287: invokestatic 222	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   290: aload 10
    //   292: invokestatic 344	com/lantern/core/g:a	(Ljava/lang/String;)Ljava/lang/String;
    //   295: astore 13
    //   297: aload_0
    //   298: getfield 90	com/lantern/notifaction/o2o/e:d	Landroid/content/Context;
    //   301: invokevirtual 348	android/content/Context:getFilesDir	()Ljava/io/File;
    //   304: invokevirtual 353	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   307: astore 11
    //   309: new 355	com/lantern/notifaction/o2o/h
    //   312: astore 12
    //   314: aload 12
    //   316: aload_0
    //   317: invokespecial 356	com/lantern/notifaction/o2o/h:<init>	(Lcom/lantern/notifaction/o2o/e;)V
    //   320: aload 10
    //   322: aload 11
    //   324: aload 13
    //   326: aload 12
    //   328: invokestatic 361	com/lantern/core/d/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/lantern/core/d/b$a;)V
    //   331: aload_0
    //   332: getfield 73	com/lantern/notifaction/o2o/e:o	Ljava/util/concurrent/atomic/AtomicInteger;
    //   335: invokevirtual 258	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   338: pop
    //   339: iconst_1
    //   340: istore_3
    //   341: iinc 4 1
    //   344: goto -253 -> 91
    //   347: aload 12
    //   349: invokevirtual 326	com/lantern/notifaction/o2o/b:a	()Ljava/lang/String;
    //   352: astore 13
    //   354: ldc_w 363
    //   357: iconst_1
    //   358: anewarray 4	java/lang/Object
    //   361: dup
    //   362: iconst_0
    //   363: aload 13
    //   365: aastore
    //   366: invokestatic 222	com/bluefay/b/h:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   369: aload_0
    //   370: getfield 60	com/lantern/notifaction/o2o/e:g	Ljava/util/HashMap;
    //   373: aload 13
    //   375: invokevirtual 366	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   378: checkcast 368	android/graphics/Bitmap
    //   381: astore 11
    //   383: aload 11
    //   385: ifnull +15 -> 400
    //   388: aload 11
    //   390: astore 10
    //   392: aload 11
    //   394: invokevirtual 372	android/graphics/Bitmap:isRecycled	()Z
    //   397: ifeq +76 -> 473
    //   400: aload 13
    //   402: invokestatic 344	com/lantern/core/g:a	(Ljava/lang/String;)Ljava/lang/String;
    //   405: astore 10
    //   407: new 350	java/io/File
    //   410: astore 14
    //   412: aload 14
    //   414: aload_0
    //   415: getfield 90	com/lantern/notifaction/o2o/e:d	Landroid/content/Context;
    //   418: invokevirtual 348	android/content/Context:getFilesDir	()Ljava/io/File;
    //   421: aload 10
    //   423: invokespecial 375	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   426: aload 11
    //   428: astore 10
    //   430: aload 14
    //   432: invokevirtual 378	java/io/File:exists	()Z
    //   435: ifeq +38 -> 473
    //   438: aload 14
    //   440: invokevirtual 353	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   443: invokestatic 384	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   446: astore 11
    //   448: aload 11
    //   450: astore 10
    //   452: aload 11
    //   454: ifnull +19 -> 473
    //   457: aload_0
    //   458: getfield 60	com/lantern/notifaction/o2o/e:g	Ljava/util/HashMap;
    //   461: aload 13
    //   463: aload 11
    //   465: invokevirtual 388	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   468: pop
    //   469: aload 11
    //   471: astore 10
    //   473: goto -293 -> 180
    //   476: iload_3
    //   477: ifne +106 -> 583
    //   480: aload_0
    //   481: getfield 254	com/lantern/notifaction/o2o/e:p	Ljava/util/concurrent/atomic/AtomicInteger;
    //   484: invokevirtual 258	java/util/concurrent/atomic/AtomicInteger:incrementAndGet	()I
    //   487: istore 7
    //   489: aload 12
    //   491: invokevirtual 322	com/lantern/notifaction/o2o/b:g	()I
    //   494: istore 5
    //   496: aload_0
    //   497: getfield 53	com/lantern/notifaction/o2o/e:b	Landroid/util/SparseArray;
    //   500: iload 5
    //   502: invokevirtual 389	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   505: checkcast 391	java/lang/Long
    //   508: astore 11
    //   510: aload 11
    //   512: ifnull +74 -> 586
    //   515: invokestatic 397	java/lang/System:currentTimeMillis	()J
    //   518: aload 11
    //   520: invokevirtual 400	java/lang/Long:longValue	()J
    //   523: lsub
    //   524: aload 12
    //   526: invokevirtual 402	com/lantern/notifaction/o2o/b:h	()J
    //   529: lcmp
    //   530: ifgt +56 -> 586
    //   533: iconst_0
    //   534: istore 8
    //   536: iconst_0
    //   537: istore 5
    //   539: aload_0
    //   540: aload 12
    //   542: invokevirtual 322	com/lantern/notifaction/o2o/b:g	()I
    //   545: aload 12
    //   547: invokevirtual 404	com/lantern/notifaction/o2o/b:c	()Ljava/lang/String;
    //   550: aload 12
    //   552: invokevirtual 406	com/lantern/notifaction/o2o/b:b	()Ljava/lang/String;
    //   555: iload 8
    //   557: iload 5
    //   559: iload 7
    //   561: invokespecial 133	com/lantern/notifaction/o2o/e:a	(ILjava/lang/String;Ljava/lang/String;ZII)Landroid/widget/RemoteViews;
    //   564: astore 11
    //   566: aload 11
    //   568: ldc -122
    //   570: aload 10
    //   572: invokevirtual 410	android/widget/RemoteViews:setImageViewBitmap	(ILandroid/graphics/Bitmap;)V
    //   575: aload_1
    //   576: ldc -33
    //   578: aload 11
    //   580: invokevirtual 264	android/widget/RemoteViews:addView	(ILandroid/widget/RemoteViews;)V
    //   583: goto -242 -> 341
    //   586: aload 12
    //   588: invokevirtual 412	com/lantern/notifaction/o2o/b:e	()Z
    //   591: istore 8
    //   593: aload 12
    //   595: invokevirtual 414	com/lantern/notifaction/o2o/b:d	()I
    //   598: istore 5
    //   600: goto -61 -> 539
    //   603: iload_3
    //   604: ifeq -583 -> 21
    //   607: aload_1
    //   608: ldc -33
    //   610: invokevirtual 227	android/widget/RemoteViews:removeAllViews	(I)V
    //   613: aload_0
    //   614: aload_1
    //   615: invokespecial 416	com/lantern/notifaction/o2o/e:a	(Landroid/widget/RemoteViews;)V
    //   618: goto -597 -> 21
    //   621: astore_1
    //   622: aload_0
    //   623: monitorexit
    //   624: aload_1
    //   625: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	626	0	this	e
    //   0	626	1	paramRemoteViews	RemoteViews
    //   0	626	2	paramBoolean	boolean
    //   16	588	3	i1	int
    //   89	253	4	i2	int
    //   494	105	5	i3	int
    //   86	105	6	i4	int
    //   487	73	7	i5	int
    //   534	58	8	bool1	boolean
    //   67	114	9	bool2	boolean
    //   158	413	10	localObject1	Object
    //   263	316	11	localObject2	Object
    //   110	484	12	localObject3	Object
    //   295	167	13	str	String
    //   410	29	14	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   2	17	621	finally
    //   24	77	621	finally
    //   79	88	621	finally
    //   98	112	621	finally
    //   126	180	621	finally
    //   194	224	621	finally
    //   229	247	621	finally
    //   253	339	621	finally
    //   347	383	621	finally
    //   392	400	621	finally
    //   400	426	621	finally
    //   430	448	621	finally
    //   457	469	621	finally
    //   480	510	621	finally
    //   515	533	621	finally
    //   539	583	621	finally
    //   586	600	621	finally
    //   607	618	621	finally
  }
  
  private String d()
  {
    Object localObject1 = (WifiManager)this.d.getSystemService("wifi");
    int i1 = ((WifiManager)localObject1).getConnectionInfo().getNetworkId();
    localObject1 = ((WifiManager)localObject1).getConfiguredNetworks();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      for (;;)
      {
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (WifiConfiguration)((Iterator)localObject1).next();
          if (((WifiConfiguration)localObject2).networkId == i1)
          {
            localObject2 = ((WifiConfiguration)localObject2).SSID;
            localObject1 = localObject2;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              i1 = ((String)localObject2).length();
              localObject1 = localObject2;
              if (i1 > 1)
              {
                localObject1 = localObject2;
                if (((String)localObject2).charAt(0) == '"')
                {
                  localObject1 = localObject2;
                  if (((String)localObject2).charAt(i1 - 1) != '"') {
                    break;
                  }
                }
              }
            }
          }
        }
      }
    }
    for (localObject1 = ((String)localObject2).substring(1, i1 - 1);; localObject1 = "") {
      return (String)localObject1;
    }
  }
  
  public final void a()
  {
    try
    {
      this.n.removeMessages(1);
      this.n.sendEmptyMessageDelayed(1, 500L);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  final void a(int paramInt)
  {
    this.b.put(paramInt, Long.valueOf(System.currentTimeMillis()));
    this.c = true;
  }
  
  public final void a(a parama)
  {
    h.a("state:%s", new Object[] { parama });
    this.i = parama;
  }
  
  public final void a(String paramString)
  {
    h.a("ssid:%s", new Object[] { paramString });
    this.j = paramString;
    this.k = null;
  }
  
  public final void a(ArrayList<b> paramArrayList)
  {
    h.a("setO2OServices", new Object[0]);
    if (Build.VERSION.SDK_INT < 14) {}
    for (;;)
    {
      return;
      this.h = paramArrayList;
      this.l = true;
      this.m = true;
    }
  }
  
  public final void b()
  {
    this.e.cancel(2130839353);
  }
  
  public final void b(String paramString)
  {
    h.a("ticker:%s", new Object[] { paramString });
    this.k = paramString;
  }
  
  public final a c()
  {
    return this.i;
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/notifaction/o2o/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */