package com.wifi.connect.e;

import com.bluefay.b.a;

final class g
  implements a
{
  g(c paramc) {}
  
  /* Error */
  public final void a(int paramInt, String arg2, Object paramObject)
  {
    // Byte code:
    //   0: iload_1
    //   1: iconst_1
    //   2: if_icmpne +15 -> 17
    //   5: aload_3
    //   6: checkcast 21	com/wifi/connect/model/h
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual 25	com/wifi/connect/model/h:c	()Z
    //   14: ifne +4 -> 18
    //   17: return
    //   18: aload_2
    //   19: invokevirtual 29	com/wifi/connect/model/h:g	()Ljava/util/ArrayList;
    //   22: astore_3
    //   23: aload_3
    //   24: invokevirtual 35	java/util/ArrayList:size	()I
    //   27: ifle +262 -> 289
    //   30: aload_3
    //   31: ifnull +10 -> 41
    //   34: aload_3
    //   35: invokevirtual 35	java/util/ArrayList:size	()I
    //   38: ifne +116 -> 154
    //   41: aconst_null
    //   42: astore_2
    //   43: aload_0
    //   44: getfield 12	com/wifi/connect/e/g:a	Lcom/wifi/connect/e/c;
    //   47: invokestatic 40	com/wifi/connect/e/c:a	(Lcom/wifi/connect/e/c;)Landroid/content/Context;
    //   50: invokestatic 44	com/wifi/connect/e/c:d	()Ljava/lang/String;
    //   53: iconst_0
    //   54: invokevirtual 50	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   57: invokeinterface 56 1 0
    //   62: ldc 58
    //   64: aload_2
    //   65: invokeinterface 64 3 0
    //   70: invokeinterface 67 1 0
    //   75: aload_0
    //   76: getfield 12	com/wifi/connect/e/g:a	Lcom/wifi/connect/e/c;
    //   79: invokestatic 71	com/wifi/connect/e/c:f	(Lcom/wifi/connect/e/c;)[B
    //   82: astore_2
    //   83: aload_2
    //   84: monitorenter
    //   85: aload_0
    //   86: getfield 12	com/wifi/connect/e/g:a	Lcom/wifi/connect/e/c;
    //   89: invokestatic 75	com/wifi/connect/e/c:i	(Lcom/wifi/connect/e/c;)Ljava/util/ArrayList;
    //   92: invokevirtual 78	java/util/ArrayList:clear	()V
    //   95: aload_0
    //   96: getfield 12	com/wifi/connect/e/g:a	Lcom/wifi/connect/e/c;
    //   99: invokestatic 75	com/wifi/connect/e/c:i	(Lcom/wifi/connect/e/c;)Ljava/util/ArrayList;
    //   102: aload_3
    //   103: invokevirtual 82	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   106: pop
    //   107: aload_2
    //   108: monitorexit
    //   109: aload_0
    //   110: getfield 12	com/wifi/connect/e/g:a	Lcom/wifi/connect/e/c;
    //   113: invokestatic 86	com/wifi/connect/e/c:m	(Lcom/wifi/connect/e/c;)Landroid/os/Handler;
    //   116: iconst_1
    //   117: invokevirtual 92	android/os/Handler:removeMessages	(I)V
    //   120: aload_0
    //   121: getfield 12	com/wifi/connect/e/g:a	Lcom/wifi/connect/e/c;
    //   124: invokestatic 86	com/wifi/connect/e/c:m	(Lcom/wifi/connect/e/c;)Landroid/os/Handler;
    //   127: iconst_1
    //   128: ldc2_w 93
    //   131: invokevirtual 98	android/os/Handler:sendEmptyMessageDelayed	(IJ)Z
    //   134: pop
    //   135: goto -118 -> 17
    //   138: astore_2
    //   139: aload_2
    //   140: invokestatic 103	com/bluefay/b/h:a	(Ljava/lang/Exception;)V
    //   143: goto -126 -> 17
    //   146: astore_2
    //   147: aload_2
    //   148: invokestatic 103	com/bluefay/b/h:a	(Ljava/lang/Exception;)V
    //   151: goto -134 -> 17
    //   154: new 105	org/json/JSONArray
    //   157: astore 5
    //   159: aload 5
    //   161: invokespecial 106	org/json/JSONArray:<init>	()V
    //   164: aload_3
    //   165: invokevirtual 110	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   168: astore_2
    //   169: aload_2
    //   170: invokeinterface 115 1 0
    //   175: ifeq +100 -> 275
    //   178: aload_2
    //   179: invokeinterface 119 1 0
    //   184: checkcast 121	com/wifi/connect/model/h$a
    //   187: astore 4
    //   189: new 123	org/json/JSONObject
    //   192: astore 6
    //   194: aload 6
    //   196: invokespecial 124	org/json/JSONObject:<init>	()V
    //   199: aload 6
    //   201: ldc 126
    //   203: aload 4
    //   205: getfield 129	com/wifi/connect/model/h$a:a	Ljava/lang/String;
    //   208: invokevirtual 133	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   211: pop
    //   212: aload 6
    //   214: ldc -121
    //   216: aload 4
    //   218: getfield 138	com/wifi/connect/model/h$a:b	Ljava/lang/String;
    //   221: invokevirtual 133	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   224: pop
    //   225: aload 6
    //   227: ldc -116
    //   229: aload 4
    //   231: getfield 142	com/wifi/connect/model/h$a:c	Ljava/lang/String;
    //   234: invokevirtual 133	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   237: pop
    //   238: aload 6
    //   240: ldc -112
    //   242: aload 4
    //   244: getfield 146	com/wifi/connect/model/h$a:d	Ljava/lang/String;
    //   247: invokevirtual 133	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   250: pop
    //   251: aload 6
    //   253: ldc -108
    //   255: aload 4
    //   257: getfield 151	com/wifi/connect/model/h$a:e	Ljava/lang/String;
    //   260: invokevirtual 133	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   263: pop
    //   264: aload 5
    //   266: aload 6
    //   268: invokevirtual 154	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   271: pop
    //   272: goto -103 -> 169
    //   275: aload 5
    //   277: invokevirtual 157	org/json/JSONArray:toString	()Ljava/lang/String;
    //   280: astore_2
    //   281: goto -238 -> 43
    //   284: astore_3
    //   285: aload_2
    //   286: monitorexit
    //   287: aload_3
    //   288: athrow
    //   289: aload_0
    //   290: getfield 12	com/wifi/connect/e/g:a	Lcom/wifi/connect/e/c;
    //   293: invokestatic 86	com/wifi/connect/e/c:m	(Lcom/wifi/connect/e/c;)Landroid/os/Handler;
    //   296: iconst_1
    //   297: invokevirtual 92	android/os/Handler:removeMessages	(I)V
    //   300: aload_0
    //   301: getfield 12	com/wifi/connect/e/g:a	Lcom/wifi/connect/e/c;
    //   304: invokestatic 86	com/wifi/connect/e/c:m	(Lcom/wifi/connect/e/c;)Landroid/os/Handler;
    //   307: iconst_2
    //   308: invokevirtual 161	android/os/Handler:sendEmptyMessage	(I)Z
    //   311: pop
    //   312: goto -295 -> 17
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	315	0	this	g
    //   0	315	1	paramInt	int
    //   0	315	3	paramObject	Object
    //   187	69	4	locala	com.wifi.connect.model.h.a
    //   157	119	5	localJSONArray	org.json.JSONArray
    //   192	75	6	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   18	30	138	java/lang/Exception
    //   34	41	138	java/lang/Exception
    //   43	85	138	java/lang/Exception
    //   109	135	138	java/lang/Exception
    //   154	169	138	java/lang/Exception
    //   169	272	138	java/lang/Exception
    //   275	281	138	java/lang/Exception
    //   287	289	138	java/lang/Exception
    //   289	312	138	java/lang/Exception
    //   139	143	146	java/lang/Exception
    //   85	109	284	finally
    //   285	287	284	finally
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/e/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */