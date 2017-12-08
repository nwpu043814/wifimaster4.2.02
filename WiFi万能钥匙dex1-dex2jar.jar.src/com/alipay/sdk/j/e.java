package com.alipay.sdk.j;

import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import com.alipay.android.app.IAlixPay;
import com.alipay.android.app.IRemoteServiceCallback;
import com.alipay.sdk.app.a.a;

public class e
{
  public Activity a;
  private IAlixPay b;
  private final Object c = IAlixPay.class;
  private boolean d;
  private a e;
  private ServiceConnection f = new f(this);
  private IRemoteServiceCallback g = new g(this);
  
  public e(Activity paramActivity, a parama)
  {
    this.a = paramActivity;
    this.e = parama;
  }
  
  /* Error */
  private String b(String paramString)
  {
    // Byte code:
    //   0: new 58	android/content/Intent
    //   3: dup
    //   4: invokespecial 59	android/content/Intent:<init>	()V
    //   7: astore_3
    //   8: aload_3
    //   9: invokestatic 64	com/alipay/sdk/j/k:a	()Ljava/lang/String;
    //   12: invokevirtual 68	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   15: pop
    //   16: aload_3
    //   17: ldc 70
    //   19: invokevirtual 73	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   22: pop
    //   23: aload_0
    //   24: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   27: invokestatic 77	com/alipay/sdk/j/k:h	(Landroid/content/Context;)Ljava/lang/String;
    //   30: astore_2
    //   31: aload_0
    //   32: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   35: invokevirtual 83	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   38: aload_3
    //   39: aload_0
    //   40: getfield 36	com/alipay/sdk/j/e:f	Landroid/content/ServiceConnection;
    //   43: iconst_1
    //   44: invokevirtual 89	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   47: pop
    //   48: aload_0
    //   49: getfield 29	com/alipay/sdk/j/e:c	Ljava/lang/Object;
    //   52: astore_3
    //   53: aload_3
    //   54: monitorenter
    //   55: aload_0
    //   56: getfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   59: astore 4
    //   61: aload 4
    //   63: ifnonnull +17 -> 80
    //   66: aload_0
    //   67: getfield 29	com/alipay/sdk/j/e:c	Ljava/lang/Object;
    //   70: invokestatic 94	com/alipay/sdk/c/a:b	()Lcom/alipay/sdk/c/a;
    //   73: invokevirtual 97	com/alipay/sdk/c/a:a	()I
    //   76: i2l
    //   77: invokevirtual 101	java/lang/Object:wait	(J)V
    //   80: aload_3
    //   81: monitorexit
    //   82: aload_0
    //   83: getfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   86: ifnonnull +182 -> 268
    //   89: aload_0
    //   90: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   93: invokestatic 77	com/alipay/sdk/j/k:h	(Landroid/content/Context;)Ljava/lang/String;
    //   96: astore_3
    //   97: aload_0
    //   98: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   101: invokestatic 104	com/alipay/sdk/j/k:i	(Landroid/content/Context;)Ljava/lang/String;
    //   104: astore_1
    //   105: new 106	java/lang/StringBuilder
    //   108: astore 4
    //   110: aload 4
    //   112: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   115: ldc 109
    //   117: ldc 111
    //   119: aload 4
    //   121: aload_2
    //   122: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: ldc 117
    //   127: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_3
    //   131: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: ldc 117
    //   136: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: aload_1
    //   140: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   143: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 125	com/alipay/sdk/app/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   149: ldc 127
    //   151: astore_2
    //   152: aload_0
    //   153: getfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   156: aload_0
    //   157: getfield 41	com/alipay/sdk/j/e:g	Lcom/alipay/android/app/IRemoteServiceCallback;
    //   160: invokeinterface 131 2 0
    //   165: aload_0
    //   166: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   169: invokevirtual 83	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   172: aload_0
    //   173: getfield 36	com/alipay/sdk/j/e:f	Landroid/content/ServiceConnection;
    //   176: invokevirtual 135	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   179: aload_0
    //   180: aconst_null
    //   181: putfield 45	com/alipay/sdk/j/e:e	Lcom/alipay/sdk/j/e$a;
    //   184: aload_0
    //   185: aconst_null
    //   186: putfield 41	com/alipay/sdk/j/e:g	Lcom/alipay/android/app/IRemoteServiceCallback;
    //   189: aload_0
    //   190: aconst_null
    //   191: putfield 36	com/alipay/sdk/j/e:f	Landroid/content/ServiceConnection;
    //   194: aload_0
    //   195: aconst_null
    //   196: putfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   199: aload_2
    //   200: astore_1
    //   201: aload_0
    //   202: getfield 137	com/alipay/sdk/j/e:d	Z
    //   205: ifeq +27 -> 232
    //   208: aload_2
    //   209: astore_1
    //   210: aload_0
    //   211: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   214: ifnull +18 -> 232
    //   217: aload_0
    //   218: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   221: iconst_0
    //   222: invokevirtual 141	android/app/Activity:setRequestedOrientation	(I)V
    //   225: aload_0
    //   226: iconst_0
    //   227: putfield 137	com/alipay/sdk/j/e:d	Z
    //   230: aload_2
    //   231: astore_1
    //   232: aload_1
    //   233: areturn
    //   234: astore_1
    //   235: ldc 109
    //   237: ldc -113
    //   239: aload_1
    //   240: invokestatic 146	com/alipay/sdk/app/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   243: ldc 127
    //   245: astore_1
    //   246: goto -14 -> 232
    //   249: astore 4
    //   251: ldc 109
    //   253: ldc -108
    //   255: aload 4
    //   257: invokestatic 146	com/alipay/sdk/app/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   260: goto -180 -> 80
    //   263: astore_1
    //   264: aload_3
    //   265: monitorexit
    //   266: aload_1
    //   267: athrow
    //   268: aload_0
    //   269: getfield 45	com/alipay/sdk/j/e:e	Lcom/alipay/sdk/j/e$a;
    //   272: ifnull +12 -> 284
    //   275: aload_0
    //   276: getfield 45	com/alipay/sdk/j/e:e	Lcom/alipay/sdk/j/e$a;
    //   279: invokeinterface 150 1 0
    //   284: aload_0
    //   285: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   288: invokevirtual 153	android/app/Activity:getRequestedOrientation	()I
    //   291: ifne +16 -> 307
    //   294: aload_0
    //   295: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   298: iconst_1
    //   299: invokevirtual 141	android/app/Activity:setRequestedOrientation	(I)V
    //   302: aload_0
    //   303: iconst_1
    //   304: putfield 137	com/alipay/sdk/j/e:d	Z
    //   307: aload_0
    //   308: getfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   311: aload_0
    //   312: getfield 41	com/alipay/sdk/j/e:g	Lcom/alipay/android/app/IRemoteServiceCallback;
    //   315: invokeinterface 156 2 0
    //   320: aload_0
    //   321: getfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   324: aload_1
    //   325: invokeinterface 159 2 0
    //   330: astore_2
    //   331: aload_0
    //   332: getfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   335: aload_0
    //   336: getfield 41	com/alipay/sdk/j/e:g	Lcom/alipay/android/app/IRemoteServiceCallback;
    //   339: invokeinterface 131 2 0
    //   344: aload_0
    //   345: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   348: invokevirtual 83	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   351: aload_0
    //   352: getfield 36	com/alipay/sdk/j/e:f	Landroid/content/ServiceConnection;
    //   355: invokevirtual 135	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   358: aload_0
    //   359: aconst_null
    //   360: putfield 45	com/alipay/sdk/j/e:e	Lcom/alipay/sdk/j/e$a;
    //   363: aload_0
    //   364: aconst_null
    //   365: putfield 41	com/alipay/sdk/j/e:g	Lcom/alipay/android/app/IRemoteServiceCallback;
    //   368: aload_0
    //   369: aconst_null
    //   370: putfield 36	com/alipay/sdk/j/e:f	Landroid/content/ServiceConnection;
    //   373: aload_0
    //   374: aconst_null
    //   375: putfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   378: aload_2
    //   379: astore_1
    //   380: aload_0
    //   381: getfield 137	com/alipay/sdk/j/e:d	Z
    //   384: ifeq -152 -> 232
    //   387: aload_2
    //   388: astore_1
    //   389: aload_0
    //   390: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   393: ifnull -161 -> 232
    //   396: aload_0
    //   397: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   400: iconst_0
    //   401: invokevirtual 141	android/app/Activity:setRequestedOrientation	(I)V
    //   404: aload_0
    //   405: iconst_0
    //   406: putfield 137	com/alipay/sdk/j/e:d	Z
    //   409: aload_2
    //   410: astore_1
    //   411: goto -179 -> 232
    //   414: astore_1
    //   415: ldc 109
    //   417: ldc -95
    //   419: aload_1
    //   420: invokestatic 146	com/alipay/sdk/app/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   423: invokestatic 164	com/alipay/sdk/app/j:a	()Ljava/lang/String;
    //   426: astore_2
    //   427: aload_0
    //   428: getfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   431: aload_0
    //   432: getfield 41	com/alipay/sdk/j/e:g	Lcom/alipay/android/app/IRemoteServiceCallback;
    //   435: invokeinterface 131 2 0
    //   440: aload_0
    //   441: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   444: invokevirtual 83	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   447: aload_0
    //   448: getfield 36	com/alipay/sdk/j/e:f	Landroid/content/ServiceConnection;
    //   451: invokevirtual 135	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   454: aload_0
    //   455: aconst_null
    //   456: putfield 45	com/alipay/sdk/j/e:e	Lcom/alipay/sdk/j/e$a;
    //   459: aload_0
    //   460: aconst_null
    //   461: putfield 41	com/alipay/sdk/j/e:g	Lcom/alipay/android/app/IRemoteServiceCallback;
    //   464: aload_0
    //   465: aconst_null
    //   466: putfield 36	com/alipay/sdk/j/e:f	Landroid/content/ServiceConnection;
    //   469: aload_0
    //   470: aconst_null
    //   471: putfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   474: aload_2
    //   475: astore_1
    //   476: aload_0
    //   477: getfield 137	com/alipay/sdk/j/e:d	Z
    //   480: ifeq -248 -> 232
    //   483: aload_2
    //   484: astore_1
    //   485: aload_0
    //   486: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   489: ifnull -257 -> 232
    //   492: aload_0
    //   493: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   496: iconst_0
    //   497: invokevirtual 141	android/app/Activity:setRequestedOrientation	(I)V
    //   500: aload_0
    //   501: iconst_0
    //   502: putfield 137	com/alipay/sdk/j/e:d	Z
    //   505: aload_2
    //   506: astore_1
    //   507: goto -275 -> 232
    //   510: astore_1
    //   511: aload_0
    //   512: getfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   515: aload_0
    //   516: getfield 41	com/alipay/sdk/j/e:g	Lcom/alipay/android/app/IRemoteServiceCallback;
    //   519: invokeinterface 131 2 0
    //   524: aload_0
    //   525: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   528: invokevirtual 83	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   531: aload_0
    //   532: getfield 36	com/alipay/sdk/j/e:f	Landroid/content/ServiceConnection;
    //   535: invokevirtual 135	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   538: aload_0
    //   539: aconst_null
    //   540: putfield 45	com/alipay/sdk/j/e:e	Lcom/alipay/sdk/j/e$a;
    //   543: aload_0
    //   544: aconst_null
    //   545: putfield 41	com/alipay/sdk/j/e:g	Lcom/alipay/android/app/IRemoteServiceCallback;
    //   548: aload_0
    //   549: aconst_null
    //   550: putfield 36	com/alipay/sdk/j/e:f	Landroid/content/ServiceConnection;
    //   553: aload_0
    //   554: aconst_null
    //   555: putfield 49	com/alipay/sdk/j/e:b	Lcom/alipay/android/app/IAlixPay;
    //   558: aload_0
    //   559: getfield 137	com/alipay/sdk/j/e:d	Z
    //   562: ifeq +23 -> 585
    //   565: aload_0
    //   566: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   569: ifnull +16 -> 585
    //   572: aload_0
    //   573: getfield 43	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   576: iconst_0
    //   577: invokevirtual 141	android/app/Activity:setRequestedOrientation	(I)V
    //   580: aload_0
    //   581: iconst_0
    //   582: putfield 137	com/alipay/sdk/j/e:d	Z
    //   585: aload_1
    //   586: athrow
    //   587: astore_2
    //   588: goto -50 -> 538
    //   591: astore_2
    //   592: goto -68 -> 524
    //   595: astore_1
    //   596: goto -142 -> 454
    //   599: astore_1
    //   600: goto -160 -> 440
    //   603: astore_1
    //   604: goto -246 -> 358
    //   607: astore_1
    //   608: goto -264 -> 344
    //   611: astore_1
    //   612: goto -433 -> 179
    //   615: astore_1
    //   616: goto -451 -> 165
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	619	0	this	e
    //   0	619	1	paramString	String
    //   30	476	2	str	String
    //   587	1	2	localThrowable1	Throwable
    //   591	1	2	localThrowable2	Throwable
    //   7	258	3	localObject1	Object
    //   59	61	4	localObject2	Object
    //   249	7	4	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   31	48	234	java/lang/Throwable
    //   66	80	249	java/lang/InterruptedException
    //   55	61	263	finally
    //   66	80	263	finally
    //   80	82	263	finally
    //   251	260	263	finally
    //   82	149	414	java/lang/Throwable
    //   268	284	414	java/lang/Throwable
    //   284	307	414	java/lang/Throwable
    //   307	331	414	java/lang/Throwable
    //   82	149	510	finally
    //   268	284	510	finally
    //   284	307	510	finally
    //   307	331	510	finally
    //   415	427	510	finally
    //   524	538	587	java/lang/Throwable
    //   511	524	591	java/lang/Throwable
    //   440	454	595	java/lang/Throwable
    //   427	440	599	java/lang/Throwable
    //   344	358	603	java/lang/Throwable
    //   331	344	607	java/lang/Throwable
    //   165	179	611	java/lang/Throwable
    //   152	165	615	java/lang/Throwable
  }
  
  public final String a(String paramString)
  {
    for (;;)
    {
      try
      {
        localObject = k.a(this.a);
        if (((k.a)localObject).a())
        {
          paramString = "failed";
          return paramString;
        }
        if (localObject != null)
        {
          int i = ((k.a)localObject).b;
          if (i > 78) {
            continue;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        Intent localIntent;
        a.a("biz", "CheckClientSignEx", localThrowable);
        continue;
      }
      paramString = b(paramString);
      continue;
      localObject = k.a();
      localIntent = new android/content/Intent;
      localIntent.<init>();
      localIntent.setClassName((String)localObject, "com.alipay.android.app.TransProcessPayActivity");
      this.a.startActivity(localIntent);
      Thread.sleep(200L);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/j/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */