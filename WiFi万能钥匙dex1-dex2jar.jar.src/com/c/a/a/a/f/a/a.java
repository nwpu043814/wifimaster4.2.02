package com.c.a.a.a.f.a;

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
    private static final a f;
    private static volatile x<a> g;
    private String d = "";
    private String e = "";
    
    static
    {
      a locala = new a();
      f = locala;
      locala.e();
    }
    
    public static a l()
    {
      return (a)f.g();
    }
    
    /* Error */
    protected final Object a(int paramInt, Object paramObject1, Object paramObject2)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 7
      //   3: iconst_0
      //   4: istore 4
      //   6: getstatic 59	com/c/a/a/a/f/a/a$1:a	[I
      //   9: iload_1
      //   10: iconst_1
      //   11: isub
      //   12: iaload
      //   13: tableswitch	default:+47->60, 1:+55->68, 2:+65->78, 3:+72->85, 4:+77->90, 5:+89->102, 6:+237->250, 7:+382->395, 8:+389->402
      //   60: new 61	java/lang/UnsupportedOperationException
      //   63: dup
      //   64: invokespecial 62	java/lang/UnsupportedOperationException:<init>	()V
      //   67: athrow
      //   68: new 2	com/c/a/a/a/f/a/a$a
      //   71: dup
      //   72: invokespecial 25	com/c/a/a/a/f/a/a$a:<init>	()V
      //   75: astore_2
      //   76: aload_2
      //   77: areturn
      //   78: getstatic 27	com/c/a/a/a/f/a/a$a:f	Lcom/c/a/a/a/f/a/a$a;
      //   81: astore_2
      //   82: goto -6 -> 76
      //   85: aconst_null
      //   86: astore_2
      //   87: goto -11 -> 76
      //   90: new 12	com/c/a/a/a/f/a/a$a$a
      //   93: dup
      //   94: iconst_0
      //   95: invokespecial 65	com/c/a/a/a/f/a/a$a$a:<init>	(B)V
      //   98: astore_2
      //   99: goto -23 -> 76
      //   102: aload_2
      //   103: checkcast 67	com/b/b/m$j
      //   106: astore_2
      //   107: aload_3
      //   108: checkcast 2	com/c/a/a/a/f/a/a$a
      //   111: astore_3
      //   112: aload_0
      //   113: getfield 35	com/c/a/a/a/f/a/a$a:d	Ljava/lang/String;
      //   116: invokevirtual 73	java/lang/String:isEmpty	()Z
      //   119: ifne +107 -> 226
      //   122: iconst_1
      //   123: istore 5
      //   125: aload_0
      //   126: getfield 35	com/c/a/a/a/f/a/a$a:d	Ljava/lang/String;
      //   129: astore 8
      //   131: aload_3
      //   132: getfield 35	com/c/a/a/a/f/a/a$a:d	Ljava/lang/String;
      //   135: invokevirtual 73	java/lang/String:isEmpty	()Z
      //   138: ifne +94 -> 232
      //   141: iconst_1
      //   142: istore 6
      //   144: aload_0
      //   145: aload_2
      //   146: iload 5
      //   148: aload 8
      //   150: iload 6
      //   152: aload_3
      //   153: getfield 35	com/c/a/a/a/f/a/a$a:d	Ljava/lang/String;
      //   156: invokeinterface 76 5 0
      //   161: putfield 35	com/c/a/a/a/f/a/a$a:d	Ljava/lang/String;
      //   164: aload_0
      //   165: getfield 37	com/c/a/a/a/f/a/a$a:e	Ljava/lang/String;
      //   168: invokevirtual 73	java/lang/String:isEmpty	()Z
      //   171: ifne +67 -> 238
      //   174: iconst_1
      //   175: istore 5
      //   177: aload_0
      //   178: getfield 37	com/c/a/a/a/f/a/a$a:e	Ljava/lang/String;
      //   181: astore 8
      //   183: aload_3
      //   184: getfield 37	com/c/a/a/a/f/a/a$a:e	Ljava/lang/String;
      //   187: invokevirtual 73	java/lang/String:isEmpty	()Z
      //   190: ifne +54 -> 244
      //   193: iload 7
      //   195: istore 6
      //   197: aload_0
      //   198: aload_2
      //   199: iload 5
      //   201: aload 8
      //   203: iload 6
      //   205: aload_3
      //   206: getfield 37	com/c/a/a/a/f/a/a$a:e	Ljava/lang/String;
      //   209: invokeinterface 76 5 0
      //   214: putfield 37	com/c/a/a/a/f/a/a$a:e	Ljava/lang/String;
      //   217: getstatic 81	com/b/b/m$h:a	Lcom/b/b/m$h;
      //   220: astore_2
      //   221: aload_0
      //   222: astore_2
      //   223: goto -147 -> 76
      //   226: iconst_0
      //   227: istore 5
      //   229: goto -104 -> 125
      //   232: iconst_0
      //   233: istore 6
      //   235: goto -91 -> 144
      //   238: iconst_0
      //   239: istore 5
      //   241: goto -64 -> 177
      //   244: iconst_0
      //   245: istore 6
      //   247: goto -50 -> 197
      //   250: aload_2
      //   251: checkcast 83	com/b/b/g
      //   254: astore_2
      //   255: iload 4
      //   257: istore_1
      //   258: iload_1
      //   259: ifne +136 -> 395
      //   262: aload_2
      //   263: invokevirtual 86	com/b/b/g:a	()I
      //   266: istore 4
      //   268: iload 4
      //   270: lookupswitch	default:+34->304, 0:+48->318, 10:+53->323, 18:+83->353
      //   304: aload_2
      //   305: iload 4
      //   307: invokevirtual 89	com/b/b/g:b	(I)Z
      //   310: ifne -52 -> 258
      //   313: iconst_1
      //   314: istore_1
      //   315: goto -57 -> 258
      //   318: iconst_1
      //   319: istore_1
      //   320: goto -62 -> 258
      //   323: aload_0
      //   324: aload_2
      //   325: invokevirtual 93	com/b/b/g:k	()Ljava/lang/String;
      //   328: putfield 35	com/c/a/a/a/f/a/a$a:d	Ljava/lang/String;
      //   331: goto -73 -> 258
      //   334: astore_2
      //   335: new 95	java/lang/RuntimeException
      //   338: astore_3
      //   339: aload_3
      //   340: aload_2
      //   341: aload_0
      //   342: invokevirtual 98	com/b/b/o:a	(Lcom/b/b/u;)Lcom/b/b/o;
      //   345: invokespecial 101	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   348: aload_3
      //   349: athrow
      //   350: astore_2
      //   351: aload_2
      //   352: athrow
      //   353: aload_0
      //   354: aload_2
      //   355: invokevirtual 93	com/b/b/g:k	()Ljava/lang/String;
      //   358: putfield 37	com/c/a/a/a/f/a/a$a:e	Ljava/lang/String;
      //   361: goto -103 -> 258
      //   364: astore_3
      //   365: new 95	java/lang/RuntimeException
      //   368: astore 8
      //   370: new 52	com/b/b/o
      //   373: astore_2
      //   374: aload_2
      //   375: aload_3
      //   376: invokevirtual 104	java/io/IOException:getMessage	()Ljava/lang/String;
      //   379: invokespecial 107	com/b/b/o:<init>	(Ljava/lang/String;)V
      //   382: aload 8
      //   384: aload_2
      //   385: aload_0
      //   386: invokevirtual 98	com/b/b/o:a	(Lcom/b/b/u;)Lcom/b/b/o;
      //   389: invokespecial 101	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
      //   392: aload 8
      //   394: athrow
      //   395: getstatic 27	com/c/a/a/a/f/a/a$a:f	Lcom/c/a/a/a/f/a/a$a;
      //   398: astore_2
      //   399: goto -323 -> 76
      //   402: getstatic 109	com/c/a/a/a/f/a/a$a:g	Lcom/b/b/x;
      //   405: ifnonnull +30 -> 435
      //   408: ldc 2
      //   410: monitorenter
      //   411: getstatic 109	com/c/a/a/a/f/a/a$a:g	Lcom/b/b/x;
      //   414: ifnonnull +18 -> 432
      //   417: new 111	com/b/b/m$b
      //   420: astore_2
      //   421: aload_2
      //   422: getstatic 27	com/c/a/a/a/f/a/a$a:f	Lcom/c/a/a/a/f/a/a$a;
      //   425: invokespecial 114	com/b/b/m$b:<init>	(Lcom/b/b/m;)V
      //   428: aload_2
      //   429: putstatic 109	com/c/a/a/a/f/a/a$a:g	Lcom/b/b/x;
      //   432: ldc 2
      //   434: monitorexit
      //   435: getstatic 109	com/c/a/a/a/f/a/a$a:g	Lcom/b/b/x;
      //   438: astore_2
      //   439: goto -363 -> 76
      //   442: astore_2
      //   443: ldc 2
      //   445: monitorexit
      //   446: aload_2
      //   447: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	448	0	this	a
      //   0	448	1	paramInt	int
      //   0	448	2	paramObject1	Object
      //   0	448	3	paramObject2	Object
      //   4	302	4	i	int
      //   123	117	5	bool1	boolean
      //   142	104	6	bool2	boolean
      //   1	193	7	bool3	boolean
      //   129	264	8	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   262	268	334	com/b/b/o
      //   304	313	334	com/b/b/o
      //   323	331	334	com/b/b/o
      //   353	361	334	com/b/b/o
      //   262	268	350	finally
      //   304	313	350	finally
      //   323	331	350	finally
      //   335	350	350	finally
      //   353	361	350	finally
      //   365	395	350	finally
      //   262	268	364	java/io/IOException
      //   304	313	364	java/io/IOException
      //   323	331	364	java/io/IOException
      //   353	361	364	java/io/IOException
      //   411	432	442	finally
      //   432	435	442	finally
      //   443	446	442	finally
    }
    
    public final void a(h paramh)
    {
      if (!this.d.isEmpty()) {
        paramh.a(1, this.d);
      }
      if (!this.e.isEmpty()) {
        paramh.a(2, this.e);
      }
    }
    
    public final int k()
    {
      int i = this.c;
      if (i != -1) {}
      for (;;)
      {
        return i;
        int j = 0;
        if (!this.d.isEmpty()) {
          j = h.b(1, this.d) + 0;
        }
        i = j;
        if (!this.e.isEmpty()) {
          i = j + h.b(2, this.e);
        }
        this.c = i;
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
    }
  }
  
  public static abstract interface b
    extends v
  {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/c/a/a/a/f/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */