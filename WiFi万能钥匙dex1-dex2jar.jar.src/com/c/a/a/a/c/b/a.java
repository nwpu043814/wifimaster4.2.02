package com.c.a.a.a.c.b;

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
    private static final a h;
    private static volatile x<a> i;
    private String d = "";
    private String e = "";
    private String f = "";
    private String g = "";
    
    static
    {
      a locala = new a();
      h = locala;
      locala.e();
    }
    
    public static a l()
    {
      return (a)h.g();
    }
    
    /* Error */
    protected final Object a(int paramInt, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 7
      //   3: iconst_0
      //   4: istore 4
      //   6: getstatic 66	com/c/a/a/a/c/b/a$1:a	[I
      //   9: iload_1
      //   10: iconst_1
      //   11: isub
      //   12: iaload
      //   13: tableswitch	default:+47->60, 1:+55->68, 2:+65->78, 3:+72->85, 4:+77->90, 5:+89->102, 6:+365->378, 7:+547->560, 8:+554->567
      //   60: new 68	java/lang/UnsupportedOperationException
      //   63: dup
      //   64: invokespecial 69	java/lang/UnsupportedOperationException:<init>	()V
      //   67: athrow
      //   68: new 2	com/c/a/a/a/c/b/a$a
      //   71: dup
      //   72: invokespecial 27	com/c/a/a/a/c/b/a$a:<init>	()V
      //   75: astore_2
      //   76: aload_2
      //   77: areturn
      //   78: getstatic 29	com/c/a/a/a/c/b/a$a:h	Lcom/c/a/a/a/c/b/a$a;
      //   81: astore_2
      //   82: goto -6 -> 76
      //   85: aconst_null
      //   86: astore_2
      //   87: goto -11 -> 76
      //   90: new 12	com/c/a/a/a/c/b/a$a$a
      //   93: dup
      //   94: iconst_0
      //   95: invokespecial 72	com/c/a/a/a/c/b/a$a$a:<init>	(B)V
      //   98: astore_2
      //   99: goto -23 -> 76
      //   102: aload_2
      //   103: checkcast 74	com/b/b/m$j
      //   106: astore_2
      //   107: aload_3
      //   108: checkcast 2	com/c/a/a/a/c/b/a$a
      //   111: astore_3
      //   112: aload_0
      //   113: getfield 37	com/c/a/a/a/c/b/a$a:d	Ljava/lang/String;
      //   116: invokevirtual 80	java/lang/String:isEmpty	()Z
      //   119: ifne +211 -> 330
      //   122: iconst_1
      //   123: istore 5
      //   125: aload_0
      //   126: getfield 37	com/c/a/a/a/c/b/a$a:d	Ljava/lang/String;
      //   129: astore 8
      //   131: aload_3
      //   132: getfield 37	com/c/a/a/a/c/b/a$a:d	Ljava/lang/String;
      //   135: invokevirtual 80	java/lang/String:isEmpty	()Z
      //   138: ifne +198 -> 336
      //   141: iconst_1
      //   142: istore 6
      //   144: aload_0
      //   145: aload_2
      //   146: iload 5
      //   148: aload 8
      //   150: iload 6
      //   152: aload_3
      //   153: getfield 37	com/c/a/a/a/c/b/a$a:d	Ljava/lang/String;
      //   156: invokeinterface 83 5 0
      //   161: putfield 37	com/c/a/a/a/c/b/a$a:d	Ljava/lang/String;
      //   164: aload_0
      //   165: getfield 39	com/c/a/a/a/c/b/a$a:e	Ljava/lang/String;
      //   168: invokevirtual 80	java/lang/String:isEmpty	()Z
      //   171: ifne +171 -> 342
      //   174: iconst_1
      //   175: istore 5
      //   177: aload_0
      //   178: getfield 39	com/c/a/a/a/c/b/a$a:e	Ljava/lang/String;
      //   181: astore 8
      //   183: aload_3
      //   184: getfield 39	com/c/a/a/a/c/b/a$a:e	Ljava/lang/String;
      //   187: invokevirtual 80	java/lang/String:isEmpty	()Z
      //   190: ifne +158 -> 348
      //   193: iconst_1
      //   194: istore 6
      //   196: aload_0
      //   197: aload_2
      //   198: iload 5
      //   200: aload 8
      //   202: iload 6
      //   204: aload_3
      //   205: getfield 39	com/c/a/a/a/c/b/a$a:e	Ljava/lang/String;
      //   208: invokeinterface 83 5 0
      //   213: putfield 39	com/c/a/a/a/c/b/a$a:e	Ljava/lang/String;
      //   216: aload_0
      //   217: getfield 41	com/c/a/a/a/c/b/a$a:f	Ljava/lang/String;
      //   220: invokevirtual 80	java/lang/String:isEmpty	()Z
      //   223: ifne +131 -> 354
      //   226: iconst_1
      //   227: istore 5
      //   229: aload_0
      //   230: getfield 41	com/c/a/a/a/c/b/a$a:f	Ljava/lang/String;
      //   233: astore 8
      //   235: aload_3
      //   236: getfield 41	com/c/a/a/a/c/b/a$a:f	Ljava/lang/String;
      //   239: invokevirtual 80	java/lang/String:isEmpty	()Z
      //   242: ifne +118 -> 360
      //   245: iconst_1
      //   246: istore 6
      //   248: aload_0
      //   249: aload_2
      //   250: iload 5
      //   252: aload 8
      //   254: iload 6
      //   256: aload_3
      //   257: getfield 41	com/c/a/a/a/c/b/a$a:f	Ljava/lang/String;
      //   260: invokeinterface 83 5 0
      //   265: putfield 41	com/c/a/a/a/c/b/a$a:f	Ljava/lang/String;
      //   268: aload_0
      //   269: getfield 43	com/c/a/a/a/c/b/a$a:g	Ljava/lang/String;
      //   272: invokevirtual 80	java/lang/String:isEmpty	()Z
      //   275: ifne +91 -> 366
      //   278: iconst_1
      //   279: istore 5
      //   281: aload_0
      //   282: getfield 43	com/c/a/a/a/c/b/a$a:g	Ljava/lang/String;
      //   285: astore 8
      //   287: aload_3
      //   288: getfield 43	com/c/a/a/a/c/b/a$a:g	Ljava/lang/String;
      //   291: invokevirtual 80	java/lang/String:isEmpty	()Z
      //   294: ifne +78 -> 372
      //   297: iload 7
      //   299: istore 6
      //   301: aload_0
      //   302: aload_2
      //   303: iload 5
      //   305: aload 8
      //   307: iload 6
      //   309: aload_3
      //   310: getfield 43	com/c/a/a/a/c/b/a$a:g	Ljava/lang/String;
      //   313: invokeinterface 83 5 0
      //   318: putfield 43	com/c/a/a/a/c/b/a$a:g	Ljava/lang/String;
      //   321: getstatic 88	com/b/b/m$h:a	Lcom/b/b/m$h;
      //   324: astore_2
      //   325: aload_0
      //   326: astore_2
      //   327: goto -251 -> 76
      //   330: iconst_0
      //   331: istore 5
      //   333: goto -208 -> 125
      //   336: iconst_0
      //   337: istore 6
      //   339: goto -195 -> 144
      //   342: iconst_0
      //   343: istore 5
      //   345: goto -168 -> 177
      //   348: iconst_0
      //   349: istore 6
      //   351: goto -155 -> 196
      //   354: iconst_0
      //   355: istore 5
      //   357: goto -128 -> 229
      //   360: iconst_0
      //   361: istore 6
      //   363: goto -115 -> 248
      //   366: iconst_0
      //   367: istore 5
      //   369: goto -88 -> 281
      //   372: iconst_0
      //   373: istore 6
      //   375: goto -74 -> 301
      //   378: aload_2
      //   379: checkcast 90	com/b/b/g
      //   382: astore_2
      //   383: iload 4
      //   385: istore_1
      //   386: iload_1
      //   387: ifne +173 -> 560
      //   390: aload_2
      //   391: invokevirtual 93	com/b/b/g:a	()I
      //   394: istore 4
      //   396: iload 4
      //   398: lookupswitch	default:+50->448, 0:+64->462, 10:+69->467, 18:+99->497, 26:+140->538, 34:+151->549
      //   448: aload_2
      //   449: iload 4
      //   451: invokevirtual 96	com/b/b/g:b	(I)Z
      //   454: ifne -68 -> 386
      //   457: iconst_1
      //   458: istore_1
      //   459: goto -73 -> 386
      //   462: iconst_1
      //   463: istore_1
      //   464: goto -78 -> 386
      //   467: aload_0
      //   468: aload_2
      //   469: invokevirtual 100	com/b/b/g:k	()Ljava/lang/String;
      //   472: putfield 37	com/c/a/a/a/c/b/a$a:d	Ljava/lang/String;
      //   475: goto -89 -> 386
      //   478: astore_3
      //   479: new 102	java/lang/RuntimeException
      //   482: astore_2
      //   483: aload_2
      //   484: aload_3
      //   485: aload_0
      //   486: invokevirtual 105	com/b/b/o:a	(Lcom/b/b/u;)Lcom/b/b/o;
      //   489: invokespecial 108	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   492: aload_2
      //   493: athrow
      //   494: astore_2
      //   495: aload_2
      //   496: athrow
      //   497: aload_0
      //   498: aload_2
      //   499: invokevirtual 100	com/b/b/g:k	()Ljava/lang/String;
      //   502: putfield 39	com/c/a/a/a/c/b/a$a:e	Ljava/lang/String;
      //   505: goto -119 -> 386
      //   508: astore 8
      //   510: new 102	java/lang/RuntimeException
      //   513: astore_3
      //   514: new 59	com/b/b/o
      //   517: astore_2
      //   518: aload_2
      //   519: aload 8
      //   521: invokevirtual 111	java/io/IOException:getMessage	()Ljava/lang/String;
      //   524: invokespecial 114	com/b/b/o:<init>	(Ljava/lang/String;)V
      //   527: aload_3
      //   528: aload_2
      //   529: aload_0
      //   530: invokevirtual 105	com/b/b/o:a	(Lcom/b/b/u;)Lcom/b/b/o;
      //   533: invokespecial 108	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   536: aload_3
      //   537: athrow
      //   538: aload_0
      //   539: aload_2
      //   540: invokevirtual 100	com/b/b/g:k	()Ljava/lang/String;
      //   543: putfield 41	com/c/a/a/a/c/b/a$a:f	Ljava/lang/String;
      //   546: goto -160 -> 386
      //   549: aload_0
      //   550: aload_2
      //   551: invokevirtual 100	com/b/b/g:k	()Ljava/lang/String;
      //   554: putfield 43	com/c/a/a/a/c/b/a$a:g	Ljava/lang/String;
      //   557: goto -171 -> 386
      //   560: getstatic 29	com/c/a/a/a/c/b/a$a:h	Lcom/c/a/a/a/c/b/a$a;
      //   563: astore_2
      //   564: goto -488 -> 76
      //   567: getstatic 116	com/c/a/a/a/c/b/a$a:i	Lcom/b/b/x;
      //   570: ifnonnull +30 -> 600
      //   573: ldc 2
      //   575: monitorenter
      //   576: getstatic 116	com/c/a/a/a/c/b/a$a:i	Lcom/b/b/x;
      //   579: ifnonnull +18 -> 597
      //   582: new 118	com/b/b/m$b
      //   585: astore_2
      //   586: aload_2
      //   587: getstatic 29	com/c/a/a/a/c/b/a$a:h	Lcom/c/a/a/a/c/b/a$a;
      //   590: invokespecial 121	com/b/b/m$b:<init>	(Lcom/b/b/m;)V
      //   593: aload_2
      //   594: putstatic 116	com/c/a/a/a/c/b/a$a:i	Lcom/b/b/x;
      //   597: ldc 2
      //   599: monitorexit
      //   600: getstatic 116	com/c/a/a/a/c/b/a$a:i	Lcom/b/b/x;
      //   603: astore_2
      //   604: goto -528 -> 76
      //   607: astore_2
      //   608: ldc 2
      //   610: monitorexit
      //   611: aload_2
      //   612: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	613	0	this	a
      //   0	613	1	paramInt	int
      //   0	613	2	paramObject1	Object
      //   0	613	3	paramObject2	Object
      //   4	446	4	j	int
      //   123	245	5	bool1	boolean
      //   142	232	6	bool2	boolean
      //   1	297	7	bool3	boolean
      //   129	177	8	str	String
      //   508	12	8	localIOException	java.io.IOException
      // Exception table:
      //   from	to	target	type
      //   390	396	478	com/b/b/o
      //   448	457	478	com/b/b/o
      //   467	475	478	com/b/b/o
      //   497	505	478	com/b/b/o
      //   538	546	478	com/b/b/o
      //   549	557	478	com/b/b/o
      //   390	396	494	finally
      //   448	457	494	finally
      //   467	475	494	finally
      //   479	494	494	finally
      //   497	505	494	finally
      //   510	538	494	finally
      //   538	546	494	finally
      //   549	557	494	finally
      //   390	396	508	java/io/IOException
      //   448	457	508	java/io/IOException
      //   467	475	508	java/io/IOException
      //   497	505	508	java/io/IOException
      //   538	546	508	java/io/IOException
      //   549	557	508	java/io/IOException
      //   576	597	607	finally
      //   597	600	607	finally
      //   608	611	607	finally
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
    }
    
    public final int k()
    {
      int k = this.c;
      if (k != -1) {}
      for (;;)
      {
        return k;
        int j = 0;
        if (!this.d.isEmpty()) {
          j = h.b(1, this.d) + 0;
        }
        k = j;
        if (!this.e.isEmpty()) {
          k = j + h.b(2, this.e);
        }
        j = k;
        if (!this.f.isEmpty()) {
          j = k + h.b(3, this.f);
        }
        k = j;
        if (!this.g.isEmpty()) {
          k = j + h.b(4, this.g);
        }
        this.c = k;
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
    }
  }
  
  public static abstract interface b
    extends v
  {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/c/a/a/a/c/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */