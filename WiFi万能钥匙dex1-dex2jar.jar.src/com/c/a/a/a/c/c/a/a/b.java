package com.c.a.a.a.c.c.a.a;

import com.b.b.ak.a;
import com.b.b.h;
import com.b.b.m;
import com.b.b.m.a;
import com.b.b.n.b;
import com.b.b.r;
import com.b.b.t;
import com.b.b.u;
import com.b.b.v;
import com.b.b.x;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  public static final class a
    extends m<a, a>
    implements b.b
  {
    private static final a j;
    private static volatile x<a> k;
    private int d;
    private n.b<b> e = h();
    private String f = "";
    private int g;
    private String h = "";
    private String i = "";
    
    static
    {
      a locala = new a();
      j = locala;
      locala.e();
    }
    
    public static a a(byte[] paramArrayOfByte)
    {
      return (a)m.a(j, paramArrayOfByte);
    }
    
    /* Error */
    protected final Object a(int paramInt, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 7
      //   3: iconst_0
      //   4: istore 4
      //   6: getstatic 77	com/c/a/a/a/c/c/a/a/b$1:a	[I
      //   9: iload_1
      //   10: iconst_1
      //   11: isub
      //   12: iaload
      //   13: tableswitch	default:+47->60, 1:+55->68, 2:+65->78, 3:+72->85, 4:+86->99, 5:+98->111, 6:+403->416, 7:+644->657, 8:+651->664
      //   60: new 79	java/lang/UnsupportedOperationException
      //   63: dup
      //   64: invokespecial 80	java/lang/UnsupportedOperationException:<init>	()V
      //   67: athrow
      //   68: new 2	com/c/a/a/a/c/c/a/a/b$a
      //   71: dup
      //   72: invokespecial 42	com/c/a/a/a/c/c/a/a/b$a:<init>	()V
      //   75: astore_2
      //   76: aload_2
      //   77: areturn
      //   78: getstatic 44	com/c/a/a/a/c/c/a/a/b$a:j	Lcom/c/a/a/a/c/c/a/a/b$a;
      //   81: astore_2
      //   82: goto -6 -> 76
      //   85: aload_0
      //   86: getfield 53	com/c/a/a/a/c/c/a/a/b$a:e	Lcom/b/b/n$b;
      //   89: invokeinterface 84 1 0
      //   94: aconst_null
      //   95: astore_2
      //   96: goto -20 -> 76
      //   99: new 12	com/c/a/a/a/c/c/a/a/b$a$a
      //   102: dup
      //   103: iconst_0
      //   104: invokespecial 87	com/c/a/a/a/c/c/a/a/b$a$a:<init>	(B)V
      //   107: astore_2
      //   108: goto -32 -> 76
      //   111: aload_2
      //   112: checkcast 89	com/b/b/m$j
      //   115: astore 8
      //   117: aload_3
      //   118: checkcast 2	com/c/a/a/a/c/c/a/a/b$a
      //   121: astore_3
      //   122: aload_0
      //   123: aload 8
      //   125: aload_0
      //   126: getfield 53	com/c/a/a/a/c/c/a/a/b$a:e	Lcom/b/b/n$b;
      //   129: aload_3
      //   130: getfield 53	com/c/a/a/a/c/c/a/a/b$a:e	Lcom/b/b/n$b;
      //   133: invokeinterface 92 3 0
      //   138: putfield 53	com/c/a/a/a/c/c/a/a/b$a:e	Lcom/b/b/n$b;
      //   141: aload_0
      //   142: getfield 57	com/c/a/a/a/c/c/a/a/b$a:f	Ljava/lang/String;
      //   145: invokevirtual 98	java/lang/String:isEmpty	()Z
      //   148: ifne +220 -> 368
      //   151: iconst_1
      //   152: istore 5
      //   154: aload_0
      //   155: getfield 57	com/c/a/a/a/c/c/a/a/b$a:f	Ljava/lang/String;
      //   158: astore_2
      //   159: aload_3
      //   160: getfield 57	com/c/a/a/a/c/c/a/a/b$a:f	Ljava/lang/String;
      //   163: invokevirtual 98	java/lang/String:isEmpty	()Z
      //   166: ifne +208 -> 374
      //   169: iconst_1
      //   170: istore 6
      //   172: aload_0
      //   173: aload 8
      //   175: iload 5
      //   177: aload_2
      //   178: iload 6
      //   180: aload_3
      //   181: getfield 57	com/c/a/a/a/c/c/a/a/b$a:f	Ljava/lang/String;
      //   184: invokeinterface 101 5 0
      //   189: putfield 57	com/c/a/a/a/c/c/a/a/b$a:f	Ljava/lang/String;
      //   192: aload_0
      //   193: getfield 103	com/c/a/a/a/c/c/a/a/b$a:g	I
      //   196: ifeq +184 -> 380
      //   199: iconst_1
      //   200: istore 5
      //   202: aload_0
      //   203: getfield 103	com/c/a/a/a/c/c/a/a/b$a:g	I
      //   206: istore_1
      //   207: aload_3
      //   208: getfield 103	com/c/a/a/a/c/c/a/a/b$a:g	I
      //   211: ifeq +175 -> 386
      //   214: iconst_1
      //   215: istore 6
      //   217: aload_0
      //   218: aload 8
      //   220: iload 5
      //   222: iload_1
      //   223: iload 6
      //   225: aload_3
      //   226: getfield 103	com/c/a/a/a/c/c/a/a/b$a:g	I
      //   229: invokeinterface 106 5 0
      //   234: putfield 103	com/c/a/a/a/c/c/a/a/b$a:g	I
      //   237: aload_0
      //   238: getfield 59	com/c/a/a/a/c/c/a/a/b$a:h	Ljava/lang/String;
      //   241: invokevirtual 98	java/lang/String:isEmpty	()Z
      //   244: ifne +148 -> 392
      //   247: iconst_1
      //   248: istore 5
      //   250: aload_0
      //   251: getfield 59	com/c/a/a/a/c/c/a/a/b$a:h	Ljava/lang/String;
      //   254: astore_2
      //   255: aload_3
      //   256: getfield 59	com/c/a/a/a/c/c/a/a/b$a:h	Ljava/lang/String;
      //   259: invokevirtual 98	java/lang/String:isEmpty	()Z
      //   262: ifne +136 -> 398
      //   265: iconst_1
      //   266: istore 6
      //   268: aload_0
      //   269: aload 8
      //   271: iload 5
      //   273: aload_2
      //   274: iload 6
      //   276: aload_3
      //   277: getfield 59	com/c/a/a/a/c/c/a/a/b$a:h	Ljava/lang/String;
      //   280: invokeinterface 101 5 0
      //   285: putfield 59	com/c/a/a/a/c/c/a/a/b$a:h	Ljava/lang/String;
      //   288: aload_0
      //   289: getfield 61	com/c/a/a/a/c/c/a/a/b$a:i	Ljava/lang/String;
      //   292: invokevirtual 98	java/lang/String:isEmpty	()Z
      //   295: ifne +109 -> 404
      //   298: iconst_1
      //   299: istore 5
      //   301: aload_0
      //   302: getfield 61	com/c/a/a/a/c/c/a/a/b$a:i	Ljava/lang/String;
      //   305: astore_2
      //   306: aload_3
      //   307: getfield 61	com/c/a/a/a/c/c/a/a/b$a:i	Ljava/lang/String;
      //   310: invokevirtual 98	java/lang/String:isEmpty	()Z
      //   313: ifne +97 -> 410
      //   316: iload 7
      //   318: istore 6
      //   320: aload_0
      //   321: aload 8
      //   323: iload 5
      //   325: aload_2
      //   326: iload 6
      //   328: aload_3
      //   329: getfield 61	com/c/a/a/a/c/c/a/a/b$a:i	Ljava/lang/String;
      //   332: invokeinterface 101 5 0
      //   337: putfield 61	com/c/a/a/a/c/c/a/a/b$a:i	Ljava/lang/String;
      //   340: aload_0
      //   341: astore_2
      //   342: aload 8
      //   344: getstatic 111	com/b/b/m$h:a	Lcom/b/b/m$h;
      //   347: if_acmpne -271 -> 76
      //   350: aload_0
      //   351: aload_0
      //   352: getfield 113	com/c/a/a/a/c/c/a/a/b$a:d	I
      //   355: aload_3
      //   356: getfield 113	com/c/a/a/a/c/c/a/a/b$a:d	I
      //   359: ior
      //   360: putfield 113	com/c/a/a/a/c/c/a/a/b$a:d	I
      //   363: aload_0
      //   364: astore_2
      //   365: goto -289 -> 76
      //   368: iconst_0
      //   369: istore 5
      //   371: goto -217 -> 154
      //   374: iconst_0
      //   375: istore 6
      //   377: goto -205 -> 172
      //   380: iconst_0
      //   381: istore 5
      //   383: goto -181 -> 202
      //   386: iconst_0
      //   387: istore 6
      //   389: goto -172 -> 217
      //   392: iconst_0
      //   393: istore 5
      //   395: goto -145 -> 250
      //   398: iconst_0
      //   399: istore 6
      //   401: goto -133 -> 268
      //   404: iconst_0
      //   405: istore 5
      //   407: goto -106 -> 301
      //   410: iconst_0
      //   411: istore 6
      //   413: goto -93 -> 320
      //   416: aload_2
      //   417: checkcast 115	com/b/b/g
      //   420: astore_2
      //   421: aload_3
      //   422: checkcast 117	com/b/b/j
      //   425: astore_3
      //   426: iload 4
      //   428: istore_1
      //   429: iload_1
      //   430: ifne +227 -> 657
      //   433: aload_2
      //   434: invokevirtual 120	com/b/b/g:a	()I
      //   437: istore 4
      //   439: iload 4
      //   441: lookupswitch	default:+59->500, 0:+73->514, 10:+78->519, 18:+141->582, 24:+183->624, 34:+194->635, 42:+205->646
      //   500: aload_2
      //   501: iload 4
      //   503: invokevirtual 123	com/b/b/g:b	(I)Z
      //   506: ifne -77 -> 429
      //   509: iconst_1
      //   510: istore_1
      //   511: goto -82 -> 429
      //   514: iconst_1
      //   515: istore_1
      //   516: goto -87 -> 429
      //   519: aload_0
      //   520: getfield 53	com/c/a/a/a/c/c/a/a/b$a:e	Lcom/b/b/n$b;
      //   523: invokeinterface 125 1 0
      //   528: ifne +14 -> 542
      //   531: aload_0
      //   532: aload_0
      //   533: getfield 53	com/c/a/a/a/c/c/a/a/b$a:e	Lcom/b/b/n$b;
      //   536: invokestatic 128	com/b/b/m:a	(Lcom/b/b/n$b;)Lcom/b/b/n$b;
      //   539: putfield 53	com/c/a/a/a/c/c/a/a/b$a:e	Lcom/b/b/n$b;
      //   542: aload_0
      //   543: getfield 53	com/c/a/a/a/c/c/a/a/b$a:e	Lcom/b/b/n$b;
      //   546: aload_2
      //   547: invokestatic 132	com/c/a/a/a/c/c/a/a/b$a$b:m	()Lcom/b/b/x;
      //   550: aload_3
      //   551: invokevirtual 135	com/b/b/g:a	(Lcom/b/b/x;Lcom/b/b/j;)Lcom/b/b/u;
      //   554: invokeinterface 139 2 0
      //   559: pop
      //   560: goto -131 -> 429
      //   563: astore_2
      //   564: new 141	java/lang/RuntimeException
      //   567: astore_3
      //   568: aload_3
      //   569: aload_2
      //   570: aload_0
      //   571: invokevirtual 144	com/b/b/o:a	(Lcom/b/b/u;)Lcom/b/b/o;
      //   574: invokespecial 147	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   577: aload_3
      //   578: athrow
      //   579: astore_2
      //   580: aload_2
      //   581: athrow
      //   582: aload_0
      //   583: aload_2
      //   584: invokevirtual 150	com/b/b/g:k	()Ljava/lang/String;
      //   587: putfield 57	com/c/a/a/a/c/c/a/a/b$a:f	Ljava/lang/String;
      //   590: goto -161 -> 429
      //   593: astore_2
      //   594: new 141	java/lang/RuntimeException
      //   597: astore_3
      //   598: new 70	com/b/b/o
      //   601: astore 8
      //   603: aload 8
      //   605: aload_2
      //   606: invokevirtual 153	java/io/IOException:getMessage	()Ljava/lang/String;
      //   609: invokespecial 156	com/b/b/o:<init>	(Ljava/lang/String;)V
      //   612: aload_3
      //   613: aload 8
      //   615: aload_0
      //   616: invokevirtual 144	com/b/b/o:a	(Lcom/b/b/u;)Lcom/b/b/o;
      //   619: invokespecial 147	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   622: aload_3
      //   623: athrow
      //   624: aload_0
      //   625: aload_2
      //   626: invokevirtual 159	com/b/b/g:q	()I
      //   629: putfield 103	com/c/a/a/a/c/c/a/a/b$a:g	I
      //   632: goto -203 -> 429
      //   635: aload_0
      //   636: aload_2
      //   637: invokevirtual 150	com/b/b/g:k	()Ljava/lang/String;
      //   640: putfield 59	com/c/a/a/a/c/c/a/a/b$a:h	Ljava/lang/String;
      //   643: goto -214 -> 429
      //   646: aload_0
      //   647: aload_2
      //   648: invokevirtual 150	com/b/b/g:k	()Ljava/lang/String;
      //   651: putfield 61	com/c/a/a/a/c/c/a/a/b$a:i	Ljava/lang/String;
      //   654: goto -225 -> 429
      //   657: getstatic 44	com/c/a/a/a/c/c/a/a/b$a:j	Lcom/c/a/a/a/c/c/a/a/b$a;
      //   660: astore_2
      //   661: goto -585 -> 76
      //   664: getstatic 161	com/c/a/a/a/c/c/a/a/b$a:k	Lcom/b/b/x;
      //   667: ifnonnull +30 -> 697
      //   670: ldc 2
      //   672: monitorenter
      //   673: getstatic 161	com/c/a/a/a/c/c/a/a/b$a:k	Lcom/b/b/x;
      //   676: ifnonnull +18 -> 694
      //   679: new 163	com/b/b/m$b
      //   682: astore_2
      //   683: aload_2
      //   684: getstatic 44	com/c/a/a/a/c/c/a/a/b$a:j	Lcom/c/a/a/a/c/c/a/a/b$a;
      //   687: invokespecial 166	com/b/b/m$b:<init>	(Lcom/b/b/m;)V
      //   690: aload_2
      //   691: putstatic 161	com/c/a/a/a/c/c/a/a/b$a:k	Lcom/b/b/x;
      //   694: ldc 2
      //   696: monitorexit
      //   697: getstatic 161	com/c/a/a/a/c/c/a/a/b$a:k	Lcom/b/b/x;
      //   700: astore_2
      //   701: goto -625 -> 76
      //   704: astore_2
      //   705: ldc 2
      //   707: monitorexit
      //   708: aload_2
      //   709: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	710	0	this	a
      //   0	710	1	paramInt	int
      //   0	710	2	paramObject1	Object
      //   0	710	3	paramObject2	Object
      //   4	498	4	m	int
      //   152	254	5	bool1	boolean
      //   170	242	6	bool2	boolean
      //   1	316	7	bool3	boolean
      //   115	499	8	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   433	439	563	com/b/b/o
      //   500	509	563	com/b/b/o
      //   519	542	563	com/b/b/o
      //   542	560	563	com/b/b/o
      //   582	590	563	com/b/b/o
      //   624	632	563	com/b/b/o
      //   635	643	563	com/b/b/o
      //   646	654	563	com/b/b/o
      //   433	439	579	finally
      //   500	509	579	finally
      //   519	542	579	finally
      //   542	560	579	finally
      //   564	579	579	finally
      //   582	590	579	finally
      //   594	624	579	finally
      //   624	632	579	finally
      //   635	643	579	finally
      //   646	654	579	finally
      //   433	439	593	java/io/IOException
      //   500	509	593	java/io/IOException
      //   519	542	593	java/io/IOException
      //   542	560	593	java/io/IOException
      //   582	590	593	java/io/IOException
      //   624	632	593	java/io/IOException
      //   635	643	593	java/io/IOException
      //   646	654	593	java/io/IOException
      //   673	694	704	finally
      //   694	697	704	finally
      //   705	708	704	finally
    }
    
    public final void a(h paramh)
    {
      for (int m = 0; m < this.e.size(); m++) {
        paramh.a(1, (u)this.e.get(m));
      }
      if (!this.f.isEmpty()) {
        paramh.a(2, this.f);
      }
      if (this.g != 0) {
        paramh.c(3, this.g);
      }
      if (!this.h.isEmpty()) {
        paramh.a(4, this.h);
      }
      if (!this.i.isEmpty()) {
        paramh.a(5, this.i);
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
        m = 0;
        while (n < this.e.size())
        {
          m += h.b(1, (u)this.e.get(n));
          n++;
        }
        n = m;
        if (!this.f.isEmpty()) {
          n = m + h.b(2, this.f);
        }
        m = n;
        if (this.g != 0) {
          m = n + h.d(3, this.g);
        }
        n = m;
        if (!this.h.isEmpty()) {
          n = m + h.b(4, this.h);
        }
        m = n;
        if (!this.i.isEmpty()) {
          m = n + h.b(5, this.i);
        }
        this.c = m;
      }
    }
    
    public final List<b> l()
    {
      return this.e;
    }
    
    public final String m()
    {
      return this.f;
    }
    
    public final String n()
    {
      return this.h;
    }
    
    public final String o()
    {
      return this.i;
    }
    
    public static final class a
      extends m.a<b.a, a>
      implements b.b
    {
      private a()
      {
        super();
      }
    }
    
    public static final class b
      extends m<b, a>
      implements b.a.c
    {
      private static final b e;
      private static volatile x<b> f;
      private t<String, String> d = t.a();
      
      static
      {
        b localb = new b();
        e = localb;
        localb.e();
      }
      
      public static x<b> m()
      {
        return e.c();
      }
      
      /* Error */
      protected final Object a(int paramInt, Object paramObject1, Object paramObject2)
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore 4
        //   3: getstatic 62	com/c/a/a/a/c/c/a/a/b$1:a	[I
        //   6: iload_1
        //   7: iconst_1
        //   8: isub
        //   9: iaload
        //   10: tableswitch	default:+46->56, 1:+54->64, 2:+64->74, 3:+71->81, 4:+83->93, 5:+95->105, 6:+132->142, 7:+287->297, 8:+294->304
        //   56: new 64	java/lang/UnsupportedOperationException
        //   59: dup
        //   60: invokespecial 65	java/lang/UnsupportedOperationException:<init>	()V
        //   63: athrow
        //   64: new 2	com/c/a/a/a/c/c/a/a/b$a$b
        //   67: dup
        //   68: invokespecial 30	com/c/a/a/a/c/c/a/a/b$a$b:<init>	()V
        //   71: astore_2
        //   72: aload_2
        //   73: areturn
        //   74: getstatic 32	com/c/a/a/a/c/c/a/a/b$a$b:e	Lcom/c/a/a/a/c/c/a/a/b$a$b;
        //   77: astore_2
        //   78: goto -6 -> 72
        //   81: aload_0
        //   82: getfield 43	com/c/a/a/a/c/c/a/a/b$a$b:d	Lcom/b/b/t;
        //   85: invokevirtual 67	com/b/b/t:c	()V
        //   88: aconst_null
        //   89: astore_2
        //   90: goto -18 -> 72
        //   93: new 15	com/c/a/a/a/c/c/a/a/b$a$b$a
        //   96: dup
        //   97: iconst_0
        //   98: invokespecial 70	com/c/a/a/a/c/c/a/a/b$a$b$a:<init>	(B)V
        //   101: astore_2
        //   102: goto -30 -> 72
        //   105: aload_2
        //   106: checkcast 72	com/b/b/m$j
        //   109: astore_2
        //   110: aload_3
        //   111: checkcast 2	com/c/a/a/a/c/c/a/a/b$a$b
        //   114: astore_3
        //   115: aload_0
        //   116: aload_2
        //   117: aload_0
        //   118: getfield 43	com/c/a/a/a/c/c/a/a/b$a$b:d	Lcom/b/b/t;
        //   121: aload_3
        //   122: getfield 43	com/c/a/a/a/c/c/a/a/b$a$b:d	Lcom/b/b/t;
        //   125: invokeinterface 75 3 0
        //   130: putfield 43	com/c/a/a/a/c/c/a/a/b$a$b:d	Lcom/b/b/t;
        //   133: getstatic 80	com/b/b/m$h:a	Lcom/b/b/m$h;
        //   136: astore_2
        //   137: aload_0
        //   138: astore_2
        //   139: goto -67 -> 72
        //   142: aload_2
        //   143: checkcast 82	com/b/b/g
        //   146: astore_2
        //   147: aload_3
        //   148: checkcast 84	com/b/b/j
        //   151: astore_3
        //   152: iload 4
        //   154: istore_1
        //   155: iload_1
        //   156: ifne +141 -> 297
        //   159: aload_2
        //   160: invokevirtual 87	com/b/b/g:a	()I
        //   163: istore 4
        //   165: iload 4
        //   167: lookupswitch	default:+25->192, 0:+39->206, 10:+44->211
        //   192: aload_2
        //   193: iload 4
        //   195: invokevirtual 90	com/b/b/g:b	(I)Z
        //   198: ifne -43 -> 155
        //   201: iconst_1
        //   202: istore_1
        //   203: goto -48 -> 155
        //   206: iconst_1
        //   207: istore_1
        //   208: goto -53 -> 155
        //   211: aload_0
        //   212: getfield 43	com/c/a/a/a/c/c/a/a/b$a$b:d	Lcom/b/b/t;
        //   215: invokevirtual 93	com/b/b/t:d	()Z
        //   218: ifne +14 -> 232
        //   221: aload_0
        //   222: aload_0
        //   223: getfield 43	com/c/a/a/a/c/c/a/a/b$a$b:d	Lcom/b/b/t;
        //   226: invokevirtual 95	com/b/b/t:b	()Lcom/b/b/t;
        //   229: putfield 43	com/c/a/a/a/c/c/a/a/b$a$b:d	Lcom/b/b/t;
        //   232: getstatic 98	com/c/a/a/a/c/c/a/a/b$a$b$b:a	Lcom/b/b/r;
        //   235: aload_0
        //   236: getfield 43	com/c/a/a/a/c/c/a/a/b$a$b:d	Lcom/b/b/t;
        //   239: aload_2
        //   240: aload_3
        //   241: invokevirtual 103	com/b/b/r:a	(Lcom/b/b/t;Lcom/b/b/g;Lcom/b/b/j;)V
        //   244: goto -89 -> 155
        //   247: astore_2
        //   248: new 105	java/lang/RuntimeException
        //   251: astore_3
        //   252: aload_3
        //   253: aload_2
        //   254: aload_0
        //   255: invokevirtual 108	com/b/b/o:a	(Lcom/b/b/u;)Lcom/b/b/o;
        //   258: invokespecial 111	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
        //   261: aload_3
        //   262: athrow
        //   263: astore_2
        //   264: aload_2
        //   265: athrow
        //   266: astore_3
        //   267: new 105	java/lang/RuntimeException
        //   270: astore 5
        //   272: new 55	com/b/b/o
        //   275: astore_2
        //   276: aload_2
        //   277: aload_3
        //   278: invokevirtual 115	java/io/IOException:getMessage	()Ljava/lang/String;
        //   281: invokespecial 118	com/b/b/o:<init>	(Ljava/lang/String;)V
        //   284: aload 5
        //   286: aload_2
        //   287: aload_0
        //   288: invokevirtual 108	com/b/b/o:a	(Lcom/b/b/u;)Lcom/b/b/o;
        //   291: invokespecial 111	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
        //   294: aload 5
        //   296: athrow
        //   297: getstatic 32	com/c/a/a/a/c/c/a/a/b$a$b:e	Lcom/c/a/a/a/c/c/a/a/b$a$b;
        //   300: astore_2
        //   301: goto -229 -> 72
        //   304: getstatic 120	com/c/a/a/a/c/c/a/a/b$a$b:f	Lcom/b/b/x;
        //   307: ifnonnull +30 -> 337
        //   310: ldc 2
        //   312: monitorenter
        //   313: getstatic 120	com/c/a/a/a/c/c/a/a/b$a$b:f	Lcom/b/b/x;
        //   316: ifnonnull +18 -> 334
        //   319: new 122	com/b/b/m$b
        //   322: astore_2
        //   323: aload_2
        //   324: getstatic 32	com/c/a/a/a/c/c/a/a/b$a$b:e	Lcom/c/a/a/a/c/c/a/a/b$a$b;
        //   327: invokespecial 125	com/b/b/m$b:<init>	(Lcom/b/b/m;)V
        //   330: aload_2
        //   331: putstatic 120	com/c/a/a/a/c/c/a/a/b$a$b:f	Lcom/b/b/x;
        //   334: ldc 2
        //   336: monitorexit
        //   337: getstatic 120	com/c/a/a/a/c/c/a/a/b$a$b:f	Lcom/b/b/x;
        //   340: astore_2
        //   341: goto -269 -> 72
        //   344: astore_2
        //   345: ldc 2
        //   347: monitorexit
        //   348: aload_2
        //   349: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	350	0	this	b
        //   0	350	1	paramInt	int
        //   0	350	2	paramObject1	Object
        //   0	350	3	paramObject2	Object
        //   1	193	4	i	int
        //   270	25	5	localRuntimeException	RuntimeException
        // Exception table:
        //   from	to	target	type
        //   159	165	247	com/b/b/o
        //   192	201	247	com/b/b/o
        //   211	232	247	com/b/b/o
        //   232	244	247	com/b/b/o
        //   159	165	263	finally
        //   192	201	263	finally
        //   211	232	263	finally
        //   232	244	263	finally
        //   248	263	263	finally
        //   267	297	263	finally
        //   159	165	266	java/io/IOException
        //   192	201	266	java/io/IOException
        //   211	232	266	java/io/IOException
        //   232	244	266	java/io/IOException
        //   313	334	344	finally
        //   334	337	344	finally
        //   345	348	344	finally
      }
      
      public final void a(h paramh)
      {
        Iterator localIterator = this.d.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          b.a.a(paramh, 1, localEntry.getKey(), localEntry.getValue());
        }
      }
      
      public final int k()
      {
        int i = this.c;
        if (i != -1) {}
        for (;;)
        {
          return i;
          Iterator localIterator = this.d.entrySet().iterator();
          Map.Entry localEntry;
          for (i = 0; localIterator.hasNext(); i = b.a.a(1, localEntry.getKey(), localEntry.getValue()) + i) {
            localEntry = (Map.Entry)localIterator.next();
          }
          this.c = i;
        }
      }
      
      public final Map<String, String> l()
      {
        return Collections.unmodifiableMap(this.d);
      }
      
      public static final class a
        extends m.a<b.a.b, a>
        implements b.a.c
      {
        private a()
        {
          super();
        }
      }
      
      private static final class b
      {
        static final r<String, String> a = r.a(ak.a.i, "", ak.a.i, "");
      }
    }
    
    public static abstract interface c
      extends v
    {}
  }
  
  public static abstract interface b
    extends v
  {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/c/a/a/a/c/c/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */