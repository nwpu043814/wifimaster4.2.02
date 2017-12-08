package ct;

import android.text.TextUtils;

public final class u
{
  private static u b;
  public v a = w.a();
  private t c;
  
  private u()
  {
    a(false);
  }
  
  public static u a()
  {
    try
    {
      if (b == null)
      {
        localu = new ct/u;
        localu.<init>();
        b = localu;
      }
      u localu = b;
      return localu;
    }
    finally {}
  }
  
  /* Error */
  public final t.a a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_0
    //   4: invokevirtual 24	ct/u:a	(Z)V
    //   7: aload_0
    //   8: getfield 32	ct/u:c	Lct/t;
    //   11: ifnull +40 -> 51
    //   14: aload_0
    //   15: getfield 32	ct/u:c	Lct/t;
    //   18: getfield 37	ct/t:a	Ljava/lang/String;
    //   21: invokestatic 42	ct/ba:a	()Ljava/lang/String;
    //   24: invokevirtual 48	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   27: ifeq +24 -> 51
    //   30: aload_0
    //   31: getfield 32	ct/u:c	Lct/t;
    //   34: getfield 51	ct/t:b	Ljava/util/Map;
    //   37: aload_1
    //   38: invokeinterface 57 2 0
    //   43: checkcast 59	ct/t$a
    //   46: astore_1
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_1
    //   50: areturn
    //   51: aconst_null
    //   52: astore_1
    //   53: goto -6 -> 47
    //   56: astore_1
    //   57: aload_0
    //   58: monitorexit
    //   59: aload_1
    //   60: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	61	0	this	u
    //   0	61	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	47	56	finally
  }
  
  /* Error */
  public final void a(t paramt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 62
    //   4: ldc 64
    //   6: invokestatic 69	ct/bb:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_1
    //   10: ifnonnull +13 -> 23
    //   13: ldc 62
    //   15: ldc 71
    //   17: invokestatic 73	ct/bb:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: aload_1
    //   25: putfield 32	ct/u:c	Lct/t;
    //   28: aload_0
    //   29: getfield 21	ct/u:a	Lct/v;
    //   32: aload_1
    //   33: invokeinterface 77 2 0
    //   38: goto -18 -> 20
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	u
    //   0	46	1	paramt	t
    // Exception table:
    //   from	to	target	type
    //   2	9	41	finally
    //   13	20	41	finally
    //   23	38	41	finally
  }
  
  public final void a(boolean paramBoolean)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        String str1 = ba.a();
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("try updateCacheInfo...currentApn:");
        bb.a("AccessSchedulerStorageManager", str1);
        if ((TextUtils.isEmpty(str1)) || (str1.equals("unknown")))
        {
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>("updateCacheInfo failed... get current apn from ApnInfo:");
          bb.c("AccessSchedulerStorageManager", str1);
          return;
        }
        if ((this.c != null) && (this.c.a.equals(str1)) && (!paramBoolean)) {
          break label174;
        }
        this.c = this.a.a(str1);
        if (this.c != null)
        {
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>("cache succ for current apn:");
          bb.a("AccessSchedulerStorageManager", str1);
          continue;
        }
        localStringBuilder = new java/lang/StringBuilder;
      }
      finally {}
      localStringBuilder.<init>("cache failed for apn:");
      bb.c("AccessSchedulerStorageManager", str2);
      continue;
      label174:
      bb.b("AccessSchedulerStorageManager", "same apn. no need update.");
    }
  }
  
  /* Error */
  public final boolean a(java.util.Set paramSet)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 62
    //   4: ldc 115
    //   6: invokestatic 69	ct/bb:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: aload_0
    //   10: iconst_0
    //   11: invokevirtual 24	ct/u:a	(Z)V
    //   14: aload_0
    //   15: getfield 32	ct/u:c	Lct/t;
    //   18: ifnonnull +16 -> 34
    //   21: ldc 62
    //   23: ldc 117
    //   25: invokestatic 69	ct/bb:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: iconst_1
    //   29: istore_2
    //   30: aload_0
    //   31: monitorexit
    //   32: iload_2
    //   33: ireturn
    //   34: aload_0
    //   35: getfield 32	ct/u:c	Lct/t;
    //   38: getfield 51	ct/t:b	Ljava/util/Map;
    //   41: astore_3
    //   42: aload_3
    //   43: ifnonnull +15 -> 58
    //   46: ldc 62
    //   48: ldc 119
    //   50: invokestatic 69	ct/bb:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: iconst_1
    //   54: istore_2
    //   55: goto -25 -> 30
    //   58: aload_3
    //   59: invokeinterface 123 1 0
    //   64: aload_1
    //   65: invokeinterface 126 1 0
    //   70: if_icmpge +36 -> 106
    //   73: new 79	java/lang/StringBuilder
    //   76: astore_1
    //   77: aload_1
    //   78: ldc -128
    //   80: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   83: ldc 62
    //   85: aload_1
    //   86: aload_3
    //   87: invokeinterface 123 1 0
    //   92: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   95: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 69	ct/bb:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   101: iconst_1
    //   102: istore_2
    //   103: goto -73 -> 30
    //   106: aload_1
    //   107: invokeinterface 135 1 0
    //   112: astore 4
    //   114: aload 4
    //   116: invokeinterface 141 1 0
    //   121: ifeq +72 -> 193
    //   124: aload 4
    //   126: invokeinterface 145 1 0
    //   131: checkcast 44	java/lang/String
    //   134: astore_1
    //   135: aload_3
    //   136: aload_1
    //   137: invokeinterface 57 2 0
    //   142: checkcast 59	ct/t$a
    //   145: astore 5
    //   147: aload 5
    //   149: ifnull +11 -> 160
    //   152: aload 5
    //   154: invokevirtual 147	ct/t$a:b	()Z
    //   157: ifeq -43 -> 114
    //   160: new 79	java/lang/StringBuilder
    //   163: astore_3
    //   164: aload_3
    //   165: ldc -107
    //   167: invokespecial 84	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   170: ldc 62
    //   172: aload_3
    //   173: aload_1
    //   174: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc -105
    //   179: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 69	ct/bb:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: iconst_1
    //   189: istore_2
    //   190: goto -160 -> 30
    //   193: iconst_0
    //   194: istore_2
    //   195: goto -165 -> 30
    //   198: astore_1
    //   199: aload_0
    //   200: monitorexit
    //   201: aload_1
    //   202: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	203	0	this	u
    //   0	203	1	paramSet	java.util.Set
    //   29	166	2	bool	boolean
    //   41	132	3	localObject	Object
    //   112	13	4	localIterator	java.util.Iterator
    //   145	8	5	locala	t.a
    // Exception table:
    //   from	to	target	type
    //   2	28	198	finally
    //   34	42	198	finally
    //   46	53	198	finally
    //   58	101	198	finally
    //   106	114	198	finally
    //   114	147	198	finally
    //   152	160	198	finally
    //   160	188	198	finally
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */