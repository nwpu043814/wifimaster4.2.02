package com.c.a.a.a.b.a.a;

import com.b.b.h;
import com.b.b.m;
import com.b.b.m.a;
import com.b.b.v;
import com.b.b.x;

public final class a
{
  public static final class a
    extends m<a, a>
    implements a.b
  {
    private static final a j;
    private static volatile x<a> k;
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    private String h = "";
    private String i = "";
    
    static
    {
      a locala = new a();
      j = locala;
      locala.e();
    }
    
    public static a l()
    {
      return (a)j.g();
    }
    
    /* Error */
    protected final Object a(int paramInt, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 7
      //   3: iconst_0
      //   4: istore 4
      //   6: getstatic 72	com/c/a/a/a/b/a/a/a$1:a	[I
      //   9: iload_1
      //   10: iconst_1
      //   11: isub
      //   12: iaload
      //   13: tableswitch	default:+47->60, 1:+55->68, 2:+65->78, 3:+72->85, 4:+77->90, 5:+89->102, 6:+493->506, 7:+714->727, 8:+721->734
      //   60: new 74	java/lang/UnsupportedOperationException
      //   63: dup
      //   64: invokespecial 75	java/lang/UnsupportedOperationException:<init>	()V
      //   67: athrow
      //   68: new 2	com/c/a/a/a/b/a/a/a$a
      //   71: dup
      //   72: invokespecial 29	com/c/a/a/a/b/a/a/a$a:<init>	()V
      //   75: astore_2
      //   76: aload_2
      //   77: areturn
      //   78: getstatic 31	com/c/a/a/a/b/a/a/a$a:j	Lcom/c/a/a/a/b/a/a/a$a;
      //   81: astore_2
      //   82: goto -6 -> 76
      //   85: aconst_null
      //   86: astore_2
      //   87: goto -11 -> 76
      //   90: new 12	com/c/a/a/a/b/a/a/a$a$a
      //   93: dup
      //   94: iconst_0
      //   95: invokespecial 78	com/c/a/a/a/b/a/a/a$a$a:<init>	(B)V
      //   98: astore_2
      //   99: goto -23 -> 76
      //   102: aload_2
      //   103: checkcast 80	com/b/b/m$j
      //   106: astore_2
      //   107: aload_3
      //   108: checkcast 2	com/c/a/a/a/b/a/a/a$a
      //   111: astore_3
      //   112: aload_0
      //   113: getfield 39	com/c/a/a/a/b/a/a/a$a:d	Ljava/lang/String;
      //   116: invokevirtual 86	java/lang/String:isEmpty	()Z
      //   119: ifne +315 -> 434
      //   122: iconst_1
      //   123: istore 5
      //   125: aload_0
      //   126: getfield 39	com/c/a/a/a/b/a/a/a$a:d	Ljava/lang/String;
      //   129: astore 8
      //   131: aload_3
      //   132: getfield 39	com/c/a/a/a/b/a/a/a$a:d	Ljava/lang/String;
      //   135: invokevirtual 86	java/lang/String:isEmpty	()Z
      //   138: ifne +302 -> 440
      //   141: iconst_1
      //   142: istore 6
      //   144: aload_0
      //   145: aload_2
      //   146: iload 5
      //   148: aload 8
      //   150: iload 6
      //   152: aload_3
      //   153: getfield 39	com/c/a/a/a/b/a/a/a$a:d	Ljava/lang/String;
      //   156: invokeinterface 89 5 0
      //   161: putfield 39	com/c/a/a/a/b/a/a/a$a:d	Ljava/lang/String;
      //   164: aload_0
      //   165: getfield 41	com/c/a/a/a/b/a/a/a$a:e	Ljava/lang/String;
      //   168: invokevirtual 86	java/lang/String:isEmpty	()Z
      //   171: ifne +275 -> 446
      //   174: iconst_1
      //   175: istore 5
      //   177: aload_0
      //   178: getfield 41	com/c/a/a/a/b/a/a/a$a:e	Ljava/lang/String;
      //   181: astore 8
      //   183: aload_3
      //   184: getfield 41	com/c/a/a/a/b/a/a/a$a:e	Ljava/lang/String;
      //   187: invokevirtual 86	java/lang/String:isEmpty	()Z
      //   190: ifne +262 -> 452
      //   193: iconst_1
      //   194: istore 6
      //   196: aload_0
      //   197: aload_2
      //   198: iload 5
      //   200: aload 8
      //   202: iload 6
      //   204: aload_3
      //   205: getfield 41	com/c/a/a/a/b/a/a/a$a:e	Ljava/lang/String;
      //   208: invokeinterface 89 5 0
      //   213: putfield 41	com/c/a/a/a/b/a/a/a$a:e	Ljava/lang/String;
      //   216: aload_0
      //   217: getfield 43	com/c/a/a/a/b/a/a/a$a:f	Ljava/lang/String;
      //   220: invokevirtual 86	java/lang/String:isEmpty	()Z
      //   223: ifne +235 -> 458
      //   226: iconst_1
      //   227: istore 5
      //   229: aload_0
      //   230: getfield 43	com/c/a/a/a/b/a/a/a$a:f	Ljava/lang/String;
      //   233: astore 8
      //   235: aload_3
      //   236: getfield 43	com/c/a/a/a/b/a/a/a$a:f	Ljava/lang/String;
      //   239: invokevirtual 86	java/lang/String:isEmpty	()Z
      //   242: ifne +222 -> 464
      //   245: iconst_1
      //   246: istore 6
      //   248: aload_0
      //   249: aload_2
      //   250: iload 5
      //   252: aload 8
      //   254: iload 6
      //   256: aload_3
      //   257: getfield 43	com/c/a/a/a/b/a/a/a$a:f	Ljava/lang/String;
      //   260: invokeinterface 89 5 0
      //   265: putfield 43	com/c/a/a/a/b/a/a/a$a:f	Ljava/lang/String;
      //   268: aload_0
      //   269: getfield 45	com/c/a/a/a/b/a/a/a$a:g	Ljava/lang/String;
      //   272: invokevirtual 86	java/lang/String:isEmpty	()Z
      //   275: ifne +195 -> 470
      //   278: iconst_1
      //   279: istore 5
      //   281: aload_0
      //   282: getfield 45	com/c/a/a/a/b/a/a/a$a:g	Ljava/lang/String;
      //   285: astore 8
      //   287: aload_3
      //   288: getfield 45	com/c/a/a/a/b/a/a/a$a:g	Ljava/lang/String;
      //   291: invokevirtual 86	java/lang/String:isEmpty	()Z
      //   294: ifne +182 -> 476
      //   297: iconst_1
      //   298: istore 6
      //   300: aload_0
      //   301: aload_2
      //   302: iload 5
      //   304: aload 8
      //   306: iload 6
      //   308: aload_3
      //   309: getfield 45	com/c/a/a/a/b/a/a/a$a:g	Ljava/lang/String;
      //   312: invokeinterface 89 5 0
      //   317: putfield 45	com/c/a/a/a/b/a/a/a$a:g	Ljava/lang/String;
      //   320: aload_0
      //   321: getfield 47	com/c/a/a/a/b/a/a/a$a:h	Ljava/lang/String;
      //   324: invokevirtual 86	java/lang/String:isEmpty	()Z
      //   327: ifne +155 -> 482
      //   330: iconst_1
      //   331: istore 5
      //   333: aload_0
      //   334: getfield 47	com/c/a/a/a/b/a/a/a$a:h	Ljava/lang/String;
      //   337: astore 8
      //   339: aload_3
      //   340: getfield 47	com/c/a/a/a/b/a/a/a$a:h	Ljava/lang/String;
      //   343: invokevirtual 86	java/lang/String:isEmpty	()Z
      //   346: ifne +142 -> 488
      //   349: iconst_1
      //   350: istore 6
      //   352: aload_0
      //   353: aload_2
      //   354: iload 5
      //   356: aload 8
      //   358: iload 6
      //   360: aload_3
      //   361: getfield 47	com/c/a/a/a/b/a/a/a$a:h	Ljava/lang/String;
      //   364: invokeinterface 89 5 0
      //   369: putfield 47	com/c/a/a/a/b/a/a/a$a:h	Ljava/lang/String;
      //   372: aload_0
      //   373: getfield 49	com/c/a/a/a/b/a/a/a$a:i	Ljava/lang/String;
      //   376: invokevirtual 86	java/lang/String:isEmpty	()Z
      //   379: ifne +115 -> 494
      //   382: iconst_1
      //   383: istore 5
      //   385: aload_0
      //   386: getfield 49	com/c/a/a/a/b/a/a/a$a:i	Ljava/lang/String;
      //   389: astore 8
      //   391: aload_3
      //   392: getfield 49	com/c/a/a/a/b/a/a/a$a:i	Ljava/lang/String;
      //   395: invokevirtual 86	java/lang/String:isEmpty	()Z
      //   398: ifne +102 -> 500
      //   401: iload 7
      //   403: istore 6
      //   405: aload_0
      //   406: aload_2
      //   407: iload 5
      //   409: aload 8
      //   411: iload 6
      //   413: aload_3
      //   414: getfield 49	com/c/a/a/a/b/a/a/a$a:i	Ljava/lang/String;
      //   417: invokeinterface 89 5 0
      //   422: putfield 49	com/c/a/a/a/b/a/a/a$a:i	Ljava/lang/String;
      //   425: getstatic 94	com/b/b/m$h:a	Lcom/b/b/m$h;
      //   428: astore_2
      //   429: aload_0
      //   430: astore_2
      //   431: goto -355 -> 76
      //   434: iconst_0
      //   435: istore 5
      //   437: goto -312 -> 125
      //   440: iconst_0
      //   441: istore 6
      //   443: goto -299 -> 144
      //   446: iconst_0
      //   447: istore 5
      //   449: goto -272 -> 177
      //   452: iconst_0
      //   453: istore 6
      //   455: goto -259 -> 196
      //   458: iconst_0
      //   459: istore 5
      //   461: goto -232 -> 229
      //   464: iconst_0
      //   465: istore 6
      //   467: goto -219 -> 248
      //   470: iconst_0
      //   471: istore 5
      //   473: goto -192 -> 281
      //   476: iconst_0
      //   477: istore 6
      //   479: goto -179 -> 300
      //   482: iconst_0
      //   483: istore 5
      //   485: goto -152 -> 333
      //   488: iconst_0
      //   489: istore 6
      //   491: goto -139 -> 352
      //   494: iconst_0
      //   495: istore 5
      //   497: goto -112 -> 385
      //   500: iconst_0
      //   501: istore 6
      //   503: goto -98 -> 405
      //   506: aload_2
      //   507: checkcast 96	com/b/b/g
      //   510: astore_2
      //   511: iload 4
      //   513: istore_1
      //   514: iload_1
      //   515: ifne +212 -> 727
      //   518: aload_2
      //   519: invokevirtual 99	com/b/b/g:a	()I
      //   522: istore 4
      //   524: iload 4
      //   526: lookupswitch	default:+66->592, 0:+80->606, 10:+85->611, 18:+115->641, 26:+157->683, 34:+168->694, 42:+179->705, 50:+190->716
      //   592: aload_2
      //   593: iload 4
      //   595: invokevirtual 102	com/b/b/g:b	(I)Z
      //   598: ifne -84 -> 514
      //   601: iconst_1
      //   602: istore_1
      //   603: goto -89 -> 514
      //   606: iconst_1
      //   607: istore_1
      //   608: goto -94 -> 514
      //   611: aload_0
      //   612: aload_2
      //   613: invokevirtual 105	com/b/b/g:k	()Ljava/lang/String;
      //   616: putfield 39	com/c/a/a/a/b/a/a/a$a:d	Ljava/lang/String;
      //   619: goto -105 -> 514
      //   622: astore_2
      //   623: new 107	java/lang/RuntimeException
      //   626: astore_3
      //   627: aload_3
      //   628: aload_2
      //   629: aload_0
      //   630: invokevirtual 110	com/b/b/o:a	(Lcom/b/b/u;)Lcom/b/b/o;
      //   633: invokespecial 113	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   636: aload_3
      //   637: athrow
      //   638: astore_2
      //   639: aload_2
      //   640: athrow
      //   641: aload_0
      //   642: aload_2
      //   643: invokevirtual 105	com/b/b/g:k	()Ljava/lang/String;
      //   646: putfield 41	com/c/a/a/a/b/a/a/a$a:e	Ljava/lang/String;
      //   649: goto -135 -> 514
      //   652: astore_2
      //   653: new 107	java/lang/RuntimeException
      //   656: astore 8
      //   658: new 65	com/b/b/o
      //   661: astore_3
      //   662: aload_3
      //   663: aload_2
      //   664: invokevirtual 116	java/io/IOException:getMessage	()Ljava/lang/String;
      //   667: invokespecial 119	com/b/b/o:<init>	(Ljava/lang/String;)V
      //   670: aload 8
      //   672: aload_3
      //   673: aload_0
      //   674: invokevirtual 110	com/b/b/o:a	(Lcom/b/b/u;)Lcom/b/b/o;
      //   677: invokespecial 113	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   680: aload 8
      //   682: athrow
      //   683: aload_0
      //   684: aload_2
      //   685: invokevirtual 105	com/b/b/g:k	()Ljava/lang/String;
      //   688: putfield 43	com/c/a/a/a/b/a/a/a$a:f	Ljava/lang/String;
      //   691: goto -177 -> 514
      //   694: aload_0
      //   695: aload_2
      //   696: invokevirtual 105	com/b/b/g:k	()Ljava/lang/String;
      //   699: putfield 45	com/c/a/a/a/b/a/a/a$a:g	Ljava/lang/String;
      //   702: goto -188 -> 514
      //   705: aload_0
      //   706: aload_2
      //   707: invokevirtual 105	com/b/b/g:k	()Ljava/lang/String;
      //   710: putfield 47	com/c/a/a/a/b/a/a/a$a:h	Ljava/lang/String;
      //   713: goto -199 -> 514
      //   716: aload_0
      //   717: aload_2
      //   718: invokevirtual 105	com/b/b/g:k	()Ljava/lang/String;
      //   721: putfield 49	com/c/a/a/a/b/a/a/a$a:i	Ljava/lang/String;
      //   724: goto -210 -> 514
      //   727: getstatic 31	com/c/a/a/a/b/a/a/a$a:j	Lcom/c/a/a/a/b/a/a/a$a;
      //   730: astore_2
      //   731: goto -655 -> 76
      //   734: getstatic 121	com/c/a/a/a/b/a/a/a$a:k	Lcom/b/b/x;
      //   737: ifnonnull +30 -> 767
      //   740: ldc 2
      //   742: monitorenter
      //   743: getstatic 121	com/c/a/a/a/b/a/a/a$a:k	Lcom/b/b/x;
      //   746: ifnonnull +18 -> 764
      //   749: new 123	com/b/b/m$b
      //   752: astore_2
      //   753: aload_2
      //   754: getstatic 31	com/c/a/a/a/b/a/a/a$a:j	Lcom/c/a/a/a/b/a/a/a$a;
      //   757: invokespecial 126	com/b/b/m$b:<init>	(Lcom/b/b/m;)V
      //   760: aload_2
      //   761: putstatic 121	com/c/a/a/a/b/a/a/a$a:k	Lcom/b/b/x;
      //   764: ldc 2
      //   766: monitorexit
      //   767: getstatic 121	com/c/a/a/a/b/a/a/a$a:k	Lcom/b/b/x;
      //   770: astore_2
      //   771: goto -695 -> 76
      //   774: astore_2
      //   775: ldc 2
      //   777: monitorexit
      //   778: aload_2
      //   779: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	780	0	this	a
      //   0	780	1	paramInt	int
      //   0	780	2	paramObject1	Object
      //   0	780	3	paramObject2	Object
      //   4	590	4	m	int
      //   123	373	5	bool1	boolean
      //   142	360	6	bool2	boolean
      //   1	401	7	bool3	boolean
      //   129	552	8	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   518	524	622	com/b/b/o
      //   592	601	622	com/b/b/o
      //   611	619	622	com/b/b/o
      //   641	649	622	com/b/b/o
      //   683	691	622	com/b/b/o
      //   694	702	622	com/b/b/o
      //   705	713	622	com/b/b/o
      //   716	724	622	com/b/b/o
      //   518	524	638	finally
      //   592	601	638	finally
      //   611	619	638	finally
      //   623	638	638	finally
      //   641	649	638	finally
      //   653	683	638	finally
      //   683	691	638	finally
      //   694	702	638	finally
      //   705	713	638	finally
      //   716	724	638	finally
      //   518	524	652	java/io/IOException
      //   592	601	652	java/io/IOException
      //   611	619	652	java/io/IOException
      //   641	649	652	java/io/IOException
      //   683	691	652	java/io/IOException
      //   694	702	652	java/io/IOException
      //   705	713	652	java/io/IOException
      //   716	724	652	java/io/IOException
      //   743	764	774	finally
      //   764	767	774	finally
      //   775	778	774	finally
    }
    
    public final void a(h paramh)
    {
      if (!this.d.isEmpty()) {
        paramh.a(1, this.d);
      }
      if (!this.e.isEmpty()) {
        paramh.a(2, this.e);
      }
      if (!this.f.isEmpty()) {
        paramh.a(3, this.f);
      }
      if (!this.g.isEmpty()) {
        paramh.a(4, this.g);
      }
      if (!this.h.isEmpty()) {
        paramh.a(5, this.h);
      }
      if (!this.i.isEmpty()) {
        paramh.a(6, this.i);
      }
    }
    
    public final int k()
    {
      int m = this.c;
      if (m != -1) {}
      for (;;)
      {
        return m;
        int n = 0;
        if (!this.d.isEmpty()) {
          n = h.b(1, this.d) + 0;
        }
        m = n;
        if (!this.e.isEmpty()) {
          m = n + h.b(2, this.e);
        }
        n = m;
        if (!this.f.isEmpty()) {
          n = m + h.b(3, this.f);
        }
        m = n;
        if (!this.g.isEmpty()) {
          m = n + h.b(4, this.g);
        }
        n = m;
        if (!this.h.isEmpty()) {
          n = m + h.b(5, this.h);
        }
        m = n;
        if (!this.i.isEmpty()) {
          m = n + h.b(6, this.i);
        }
        this.c = m;
      }
    }
    
    public static final class a
      extends m.a<a.a, a>
      implements a.b
    {
      private a()
      {
        super();
      }
      
      public final a a(String paramString)
      {
        b();
        a.a.a((a.a)this.a, paramString);
        return this;
      }
      
      public final a b(String paramString)
      {
        b();
        a.a.b((a.a)this.a, paramString);
        return this;
      }
      
      public final a c(String paramString)
      {
        b();
        a.a.c((a.a)this.a, paramString);
        return this;
      }
      
      public final a d(String paramString)
      {
        b();
        a.a.d((a.a)this.a, paramString);
        return this;
      }
      
      public final a e(String paramString)
      {
        b();
        a.a.e((a.a)this.a, paramString);
        return this;
      }
      
      public final a f(String paramString)
      {
        b();
        a.a.f((a.a)this.a, paramString);
        return this;
      }
    }
  }
  
  public static abstract interface b
    extends v
  {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/c/a/a/a/b/a/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */