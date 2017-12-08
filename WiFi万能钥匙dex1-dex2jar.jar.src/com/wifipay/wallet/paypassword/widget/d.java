package com.wifipay.wallet.paypassword.widget;

import com.wifipay.framework.api.BackgroundExecutor.a;

class d
  extends BackgroundExecutor.a
{
  d(WPSafeKeyboard paramWPSafeKeyboard, String paramString1, int paramInt, String paramString2)
  {
    super(paramString1, paramInt, paramString2);
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 10	com/wifipay/wallet/paypassword/widget/d:a	Lcom/wifipay/wallet/paypassword/widget/WPSafeKeyboard;
    //   4: invokestatic 23	com/wifipay/wallet/paypassword/widget/WPSafeKeyboard:b	(Lcom/wifipay/wallet/paypassword/widget/WPSafeKeyboard;)Ljava/util/ArrayList;
    //   7: aload_0
    //   8: getfield 10	com/wifipay/wallet/paypassword/widget/d:a	Lcom/wifipay/wallet/paypassword/widget/WPSafeKeyboard;
    //   11: invokestatic 23	com/wifipay/wallet/paypassword/widget/WPSafeKeyboard:b	(Lcom/wifipay/wallet/paypassword/widget/WPSafeKeyboard;)Ljava/util/ArrayList;
    //   14: invokevirtual 29	java/util/ArrayList:size	()I
    //   17: anewarray 31	java/lang/String
    //   20: invokevirtual 35	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   23: checkcast 37	[Ljava/lang/String;
    //   26: aload_0
    //   27: getfield 10	com/wifipay/wallet/paypassword/widget/d:a	Lcom/wifipay/wallet/paypassword/widget/WPSafeKeyboard;
    //   30: invokestatic 41	com/wifipay/wallet/paypassword/widget/WPSafeKeyboard:f	(Lcom/wifipay/wallet/paypassword/widget/WPSafeKeyboard;)I
    //   33: iconst_1
    //   34: invokestatic 47	com/shengpay/crypto/JNICrypto:getTicket	([Ljava/lang/String;IZ)Ljava/lang/String;
    //   37: astore_1
    //   38: ldc 49
    //   40: iconst_1
    //   41: anewarray 51	java/lang/Object
    //   44: dup
    //   45: iconst_0
    //   46: aload_1
    //   47: aastore
    //   48: invokestatic 57	com/wifipay/common/logging/Logger:v	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   51: new 59	org/json/JSONObject
    //   54: astore_3
    //   55: aload_3
    //   56: aload_1
    //   57: invokespecial 62	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   60: new 64	com/wifipay/framework/b/a/a
    //   63: astore_2
    //   64: aload_2
    //   65: invokespecial 66	com/wifipay/framework/b/a/a:<init>	()V
    //   68: aload_2
    //   69: astore_1
    //   70: aload_3
    //   71: ldc 68
    //   73: invokevirtual 72	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   76: ifeq +15 -> 91
    //   79: aload_2
    //   80: astore_1
    //   81: aload_2
    //   82: aload_3
    //   83: ldc 68
    //   85: invokevirtual 76	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   88: putfield 79	com/wifipay/framework/b/a/a:a	Ljava/lang/String;
    //   91: aload_2
    //   92: astore_1
    //   93: aload_3
    //   94: ldc 81
    //   96: invokevirtual 72	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   99: ifeq +15 -> 114
    //   102: aload_2
    //   103: astore_1
    //   104: aload_2
    //   105: aload_3
    //   106: ldc 81
    //   108: invokevirtual 76	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   111: putfield 83	com/wifipay/framework/b/a/a:b	Ljava/lang/String;
    //   114: aload_2
    //   115: astore_1
    //   116: aload_2
    //   117: getfield 79	com/wifipay/framework/b/a/a:a	Ljava/lang/String;
    //   120: ldc 85
    //   122: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   125: ifeq +71 -> 196
    //   128: aload_2
    //   129: astore_1
    //   130: aload_3
    //   131: ldc 91
    //   133: invokevirtual 72	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   136: ifeq +60 -> 196
    //   139: aload_2
    //   140: astore_1
    //   141: new 93	com/wifipay/framework/b/a/a$a
    //   144: astore 4
    //   146: aload_2
    //   147: astore_1
    //   148: aload 4
    //   150: invokespecial 94	com/wifipay/framework/b/a/a$a:<init>	()V
    //   153: aload_2
    //   154: astore_1
    //   155: aload_2
    //   156: aload 4
    //   158: putfield 98	com/wifipay/framework/b/a/a:c	Lcom/wifipay/framework/b/a/a$a;
    //   161: aload_2
    //   162: astore_1
    //   163: aload_3
    //   164: ldc 91
    //   166: invokevirtual 102	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   169: astore_3
    //   170: aload_2
    //   171: astore_1
    //   172: aload_3
    //   173: ldc 104
    //   175: invokevirtual 72	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   178: ifeq +18 -> 196
    //   181: aload_2
    //   182: astore_1
    //   183: aload_2
    //   184: getfield 98	com/wifipay/framework/b/a/a:c	Lcom/wifipay/framework/b/a/a$a;
    //   187: aload_3
    //   188: ldc 104
    //   190: invokevirtual 76	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   193: putfield 105	com/wifipay/framework/b/a/a$a:a	Ljava/lang/String;
    //   196: new 107	android/os/Message
    //   199: dup
    //   200: invokespecial 108	android/os/Message:<init>	()V
    //   203: astore_1
    //   204: aload_2
    //   205: getfield 79	com/wifipay/framework/b/a/a:a	Ljava/lang/String;
    //   208: ldc 85
    //   210: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   213: ifeq +43 -> 256
    //   216: aload_1
    //   217: iconst_1
    //   218: putfield 112	android/os/Message:what	I
    //   221: aload_1
    //   222: aload_2
    //   223: getfield 98	com/wifipay/framework/b/a/a:c	Lcom/wifipay/framework/b/a/a$a;
    //   226: getfield 105	com/wifipay/framework/b/a/a$a:a	Ljava/lang/String;
    //   229: putfield 116	android/os/Message:obj	Ljava/lang/Object;
    //   232: aload_0
    //   233: getfield 10	com/wifipay/wallet/paypassword/widget/d:a	Lcom/wifipay/wallet/paypassword/widget/WPSafeKeyboard;
    //   236: invokestatic 120	com/wifipay/wallet/paypassword/widget/WPSafeKeyboard:e	(Lcom/wifipay/wallet/paypassword/widget/WPSafeKeyboard;)Lcom/wifipay/wallet/paypassword/widget/WPKeyBoardTable;
    //   239: iconst_1
    //   240: putfield 125	com/wifipay/wallet/paypassword/widget/WPKeyBoardTable:a	Z
    //   243: aload_0
    //   244: getfield 10	com/wifipay/wallet/paypassword/widget/d:a	Lcom/wifipay/wallet/paypassword/widget/WPSafeKeyboard;
    //   247: invokestatic 128	com/wifipay/wallet/paypassword/widget/WPSafeKeyboard:a	(Lcom/wifipay/wallet/paypassword/widget/WPSafeKeyboard;)Lcom/wifipay/framework/api/d;
    //   250: aload_1
    //   251: invokevirtual 133	com/wifipay/framework/api/d:a	(Landroid/os/Message;)Z
    //   254: pop
    //   255: return
    //   256: aload_1
    //   257: iconst_0
    //   258: putfield 112	android/os/Message:what	I
    //   261: goto -29 -> 232
    //   264: astore_3
    //   265: aconst_null
    //   266: astore_2
    //   267: aload_2
    //   268: astore_1
    //   269: aload_3
    //   270: invokevirtual 136	org/json/JSONException:printStackTrace	()V
    //   273: new 107	android/os/Message
    //   276: dup
    //   277: invokespecial 108	android/os/Message:<init>	()V
    //   280: astore_1
    //   281: aload_2
    //   282: ifnull +57 -> 339
    //   285: aload_2
    //   286: getfield 79	com/wifipay/framework/b/a/a:a	Ljava/lang/String;
    //   289: ldc 85
    //   291: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   294: ifeq +45 -> 339
    //   297: aload_1
    //   298: iconst_1
    //   299: putfield 112	android/os/Message:what	I
    //   302: aload_1
    //   303: aload_2
    //   304: getfield 98	com/wifipay/framework/b/a/a:c	Lcom/wifipay/framework/b/a/a$a;
    //   307: getfield 105	com/wifipay/framework/b/a/a$a:a	Ljava/lang/String;
    //   310: putfield 116	android/os/Message:obj	Ljava/lang/Object;
    //   313: aload_0
    //   314: getfield 10	com/wifipay/wallet/paypassword/widget/d:a	Lcom/wifipay/wallet/paypassword/widget/WPSafeKeyboard;
    //   317: invokestatic 120	com/wifipay/wallet/paypassword/widget/WPSafeKeyboard:e	(Lcom/wifipay/wallet/paypassword/widget/WPSafeKeyboard;)Lcom/wifipay/wallet/paypassword/widget/WPKeyBoardTable;
    //   320: iconst_1
    //   321: putfield 125	com/wifipay/wallet/paypassword/widget/WPKeyBoardTable:a	Z
    //   324: aload_0
    //   325: getfield 10	com/wifipay/wallet/paypassword/widget/d:a	Lcom/wifipay/wallet/paypassword/widget/WPSafeKeyboard;
    //   328: invokestatic 128	com/wifipay/wallet/paypassword/widget/WPSafeKeyboard:a	(Lcom/wifipay/wallet/paypassword/widget/WPSafeKeyboard;)Lcom/wifipay/framework/api/d;
    //   331: aload_1
    //   332: invokevirtual 133	com/wifipay/framework/api/d:a	(Landroid/os/Message;)Z
    //   335: pop
    //   336: goto -81 -> 255
    //   339: aload_1
    //   340: iconst_0
    //   341: putfield 112	android/os/Message:what	I
    //   344: goto -31 -> 313
    //   347: astore_2
    //   348: aconst_null
    //   349: astore_1
    //   350: new 107	android/os/Message
    //   353: dup
    //   354: invokespecial 108	android/os/Message:<init>	()V
    //   357: astore_3
    //   358: aload_1
    //   359: ifnull +56 -> 415
    //   362: aload_1
    //   363: getfield 79	com/wifipay/framework/b/a/a:a	Ljava/lang/String;
    //   366: ldc 85
    //   368: invokevirtual 89	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   371: ifeq +44 -> 415
    //   374: aload_3
    //   375: iconst_1
    //   376: putfield 112	android/os/Message:what	I
    //   379: aload_3
    //   380: aload_1
    //   381: getfield 98	com/wifipay/framework/b/a/a:c	Lcom/wifipay/framework/b/a/a$a;
    //   384: getfield 105	com/wifipay/framework/b/a/a$a:a	Ljava/lang/String;
    //   387: putfield 116	android/os/Message:obj	Ljava/lang/Object;
    //   390: aload_0
    //   391: getfield 10	com/wifipay/wallet/paypassword/widget/d:a	Lcom/wifipay/wallet/paypassword/widget/WPSafeKeyboard;
    //   394: invokestatic 120	com/wifipay/wallet/paypassword/widget/WPSafeKeyboard:e	(Lcom/wifipay/wallet/paypassword/widget/WPSafeKeyboard;)Lcom/wifipay/wallet/paypassword/widget/WPKeyBoardTable;
    //   397: iconst_1
    //   398: putfield 125	com/wifipay/wallet/paypassword/widget/WPKeyBoardTable:a	Z
    //   401: aload_0
    //   402: getfield 10	com/wifipay/wallet/paypassword/widget/d:a	Lcom/wifipay/wallet/paypassword/widget/WPSafeKeyboard;
    //   405: invokestatic 128	com/wifipay/wallet/paypassword/widget/WPSafeKeyboard:a	(Lcom/wifipay/wallet/paypassword/widget/WPSafeKeyboard;)Lcom/wifipay/framework/api/d;
    //   408: aload_3
    //   409: invokevirtual 133	com/wifipay/framework/api/d:a	(Landroid/os/Message;)Z
    //   412: pop
    //   413: aload_2
    //   414: athrow
    //   415: aload_3
    //   416: iconst_0
    //   417: putfield 112	android/os/Message:what	I
    //   420: goto -30 -> 390
    //   423: astore_2
    //   424: goto -74 -> 350
    //   427: astore_3
    //   428: goto -161 -> 267
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	431	0	this	d
    //   37	344	1	localObject1	Object
    //   63	241	2	locala	com.wifipay.framework.b.a.a
    //   347	67	2	localObject2	Object
    //   423	1	2	localObject3	Object
    //   54	134	3	localJSONObject	org.json.JSONObject
    //   264	6	3	localJSONException1	org.json.JSONException
    //   357	59	3	localMessage	android.os.Message
    //   427	1	3	localJSONException2	org.json.JSONException
    //   144	13	4	locala1	com.wifipay.framework.b.a.a.a
    // Exception table:
    //   from	to	target	type
    //   51	68	264	org/json/JSONException
    //   51	68	347	finally
    //   70	79	423	finally
    //   81	91	423	finally
    //   93	102	423	finally
    //   104	114	423	finally
    //   116	128	423	finally
    //   130	139	423	finally
    //   141	146	423	finally
    //   148	153	423	finally
    //   155	161	423	finally
    //   163	170	423	finally
    //   172	181	423	finally
    //   183	196	423	finally
    //   269	273	423	finally
    //   70	79	427	org/json/JSONException
    //   81	91	427	org/json/JSONException
    //   93	102	427	org/json/JSONException
    //   104	114	427	org/json/JSONException
    //   116	128	427	org/json/JSONException
    //   130	139	427	org/json/JSONException
    //   141	146	427	org/json/JSONException
    //   148	153	427	org/json/JSONException
    //   155	161	427	org/json/JSONException
    //   163	170	427	org/json/JSONException
    //   172	181	427	org/json/JSONException
    //   183	196	427	org/json/JSONException
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/widget/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */