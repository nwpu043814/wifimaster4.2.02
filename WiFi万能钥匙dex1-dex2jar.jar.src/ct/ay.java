package ct;

import android.os.SystemClock;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public final class ay
{
  private static ay a = new ay();
  private int b = 20000;
  private Socket c;
  private int d = -1;
  private az e;
  private s f;
  private OutputStream g;
  private InputStream h;
  private int i = -1;
  private int j = -1;
  private long k = -1L;
  private int l = -1;
  private int m = -1;
  
  public static ay a()
  {
    try
    {
      ay localay = a;
      return localay;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void a(int paramInt)
  {
    try
    {
      a(paramInt, null);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private void a(int paramInt, String paramString)
  {
    try
    {
      if ((paramInt != this.d) && (this.e != null))
      {
        this.e.b = paramInt;
        if (paramString != null) {
          this.e.c = paramString;
        }
      }
      return;
    }
    finally {}
  }
  
  private void b()
  {
    int i1 = 0;
    for (;;)
    {
      long l1;
      Object localObject2;
      int i2;
      try
      {
        l1 = SystemClock.elapsedRealtime();
        try
        {
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>("doReadData: try read data...sk:");
          bb.b("WupTaskController", this.c);
          localObject2 = new byte[4];
          n = i1;
          if (i1 < 4)
          {
            bb.a("WupTaskController", "try read packet size: 4 bytes");
            i2 = this.h.read((byte[])localObject2, i1, 4 - i1);
            if (i2 <= 0) {
              continue;
            }
            this.l = ((int)(SystemClock.elapsedRealtime() - this.k));
            n = i1 + i2;
            i1 = n;
            if (n != 4) {
              continue;
            }
          }
          if (n != 4) {
            continue;
          }
          i1 = bc.a((byte[])localObject2);
          if ((i1 > 4) && (i1 <= 524288)) {
            break label226;
          }
          localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>("packSizeFail:");
          a(-6, i1);
        }
        catch (Exception localException1)
        {
          StringBuilder localStringBuilder;
          localException1.printStackTrace();
          bb.a("WupTaskController", localException1);
          a(-7, bc.a(localException1));
          continue;
        }
        return;
      }
      finally {}
      int n = i1;
      if (i2 != -1)
      {
        continue;
        localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>("readLen fail:");
        a(-6, n);
        continue;
        label226:
        byte[] arrayOfByte = new byte[i1];
        System.arraycopy(localObject2, 0, arrayOfByte, 0, 4);
        long l2 = SystemClock.elapsedRealtime();
        do
        {
          for (;;)
          {
            if (n >= i1) {
              break label335;
            }
            i2 = i1 - n;
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>("try read:");
            bb.a("WupTaskController", i2);
            i2 = this.h.read(arrayOfByte, n, i2);
            localObject2 = new java/lang/StringBuilder;
            ((StringBuilder)localObject2).<init>("read ret:");
            bb.a("WupTaskController", i2);
            if (i2 <= 0) {
              break;
            }
            n += i2;
          }
        } while (i2 != -1);
        label335:
        if (n != i1)
        {
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>("read fail. readLen:");
          bb.c("WupTaskController", n + ",packSize:" + i1);
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>("readLen != packSize,rspBuff:");
          a(-6, bc.b(arrayOfByte));
        }
        else
        {
          this.m = ((int)(SystemClock.elapsedRealtime() - l2));
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>("doSendReceive: read finish,readLen=");
          bb.b("WupTaskController", n);
          localObject2 = new ct/bg;
          ((bg)localObject2).<init>();
          try
          {
            ((bg)localObject2).a(arrayOfByte);
            if (this.e != null)
            {
              this.e.a = ((bg)localObject2);
              this.e.b = 0;
              this.m = ((int)(SystemClock.elapsedRealtime() - l1));
              this.e.f = this.l;
              this.e.d = this.j;
              this.e.g = this.m;
            }
          }
          catch (Exception localException2)
          {
            a(-8, bc.a(localException2));
          }
        }
      }
    }
  }
  
  /* Error */
  private boolean b(az paramaz)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_2
    //   4: iconst_0
    //   5: istore 4
    //   7: iload 4
    //   9: ifne +297 -> 306
    //   12: aload_1
    //   13: ifnull +156 -> 169
    //   16: invokestatic 71	android/os/SystemClock:elapsedRealtime	()J
    //   19: aload_1
    //   20: getfield 172	ct/az:i	J
    //   23: lsub
    //   24: aload_1
    //   25: getfield 173	ct/az:j	I
    //   28: i2l
    //   29: lcmp
    //   30: ifge +139 -> 169
    //   33: iconst_0
    //   34: istore_3
    //   35: iload_3
    //   36: ifne +270 -> 306
    //   39: iload_2
    //   40: iconst_5
    //   41: if_icmpge +265 -> 306
    //   44: iload_2
    //   45: iconst_1
    //   46: iadd
    //   47: istore_3
    //   48: aload_0
    //   49: invokespecial 176	ct/ay:c	()Z
    //   52: istore 5
    //   54: iload 5
    //   56: ifeq +241 -> 297
    //   59: new 73	java/lang/StringBuilder
    //   62: astore 6
    //   64: aload 6
    //   66: ldc -78
    //   68: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   71: ldc 80
    //   73: aload 6
    //   75: aload_1
    //   76: invokevirtual 181	ct/az:k	()I
    //   79: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: ldc -73
    //   84: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_0
    //   88: getfield 82	ct/ay:c	Ljava/net/Socket;
    //   91: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 95	ct/bb:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload_1
    //   101: invokevirtual 186	ct/az:l	()[B
    //   104: astore 7
    //   106: aload_0
    //   107: getfield 188	ct/ay:g	Ljava/io/OutputStream;
    //   110: aload 7
    //   112: iconst_0
    //   113: aload 7
    //   115: arraylength
    //   116: invokevirtual 194	java/io/OutputStream:write	([BII)V
    //   119: aload_0
    //   120: getfield 188	ct/ay:g	Ljava/io/OutputStream;
    //   123: invokevirtual 197	java/io/OutputStream:flush	()V
    //   126: aload_0
    //   127: invokestatic 71	android/os/SystemClock:elapsedRealtime	()J
    //   130: putfield 46	ct/ay:k	J
    //   133: new 73	java/lang/StringBuilder
    //   136: astore 6
    //   138: aload 6
    //   140: ldc -57
    //   142: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   145: ldc 80
    //   147: aload 6
    //   149: aload 7
    //   151: arraylength
    //   152: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   155: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 99	ct/bb:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: iconst_1
    //   162: istore 4
    //   164: iload_3
    //   165: istore_2
    //   166: goto -159 -> 7
    //   169: iconst_1
    //   170: istore_3
    //   171: goto -136 -> 35
    //   174: astore 6
    //   176: ldc 80
    //   178: aload 6
    //   180: invokestatic 126	ct/bb:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   183: aload_1
    //   184: bipush -5
    //   186: putfield 60	ct/az:b	I
    //   189: aload_1
    //   190: aload 6
    //   192: invokestatic 129	ct/bc:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   195: putfield 63	ct/az:c	Ljava/lang/String;
    //   198: iload_3
    //   199: istore_2
    //   200: iload 4
    //   202: ifne -195 -> 7
    //   205: aload_0
    //   206: aload_1
    //   207: getfield 60	ct/az:b	I
    //   210: invokespecial 201	ct/ay:a	(I)V
    //   213: aload_0
    //   214: getfield 188	ct/ay:g	Ljava/io/OutputStream;
    //   217: invokevirtual 204	java/io/OutputStream:close	()V
    //   220: aload_0
    //   221: getfield 82	ct/ay:c	Ljava/net/Socket;
    //   224: invokevirtual 207	java/net/Socket:close	()V
    //   227: aload_0
    //   228: invokespecial 209	ct/ay:e	()V
    //   231: iload_3
    //   232: istore_2
    //   233: goto -226 -> 7
    //   236: astore 6
    //   238: aload 6
    //   240: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   243: iload_3
    //   244: istore_2
    //   245: goto -238 -> 7
    //   248: astore_1
    //   249: aload_0
    //   250: monitorexit
    //   251: aload_1
    //   252: athrow
    //   253: astore 6
    //   255: iload 4
    //   257: ifne +29 -> 286
    //   260: aload_0
    //   261: aload_1
    //   262: getfield 60	ct/az:b	I
    //   265: invokespecial 201	ct/ay:a	(I)V
    //   268: aload_0
    //   269: getfield 188	ct/ay:g	Ljava/io/OutputStream;
    //   272: invokevirtual 204	java/io/OutputStream:close	()V
    //   275: aload_0
    //   276: getfield 82	ct/ay:c	Ljava/net/Socket;
    //   279: invokevirtual 207	java/net/Socket:close	()V
    //   282: aload_0
    //   283: invokespecial 209	ct/ay:e	()V
    //   286: aload 6
    //   288: athrow
    //   289: astore_1
    //   290: aload_1
    //   291: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   294: goto -8 -> 286
    //   297: aload_0
    //   298: invokespecial 209	ct/ay:e	()V
    //   301: iload_3
    //   302: istore_2
    //   303: goto -296 -> 7
    //   306: aload_0
    //   307: monitorexit
    //   308: iload 4
    //   310: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	this	ay
    //   0	311	1	paramaz	az
    //   3	300	2	n	int
    //   34	268	3	i1	int
    //   5	304	4	bool1	boolean
    //   52	3	5	bool2	boolean
    //   62	86	6	localStringBuilder	StringBuilder
    //   174	17	6	localException1	Exception
    //   236	3	6	localException2	Exception
    //   253	34	6	localObject	Object
    //   104	46	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   59	161	174	java/lang/Exception
    //   205	231	236	java/lang/Exception
    //   16	33	248	finally
    //   48	54	248	finally
    //   205	231	248	finally
    //   238	243	248	finally
    //   260	286	248	finally
    //   286	289	248	finally
    //   290	294	248	finally
    //   297	301	248	finally
    //   59	161	253	finally
    //   176	198	253	finally
    //   260	286	289	java/lang/Exception
  }
  
  private boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (this.c != null)
      {
        bool1 = bool2;
        if (this.c.isConnected())
        {
          bool1 = bool2;
          if (!this.c.isClosed())
          {
            OutputStream localOutputStream = this.g;
            bool1 = bool2;
            if (localOutputStream != null) {
              bool1 = true;
            }
          }
        }
      }
      return bool1;
    }
    finally {}
  }
  
  /* Error */
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 101	ct/ay:h	Ljava/io/InputStream;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +15 -> 23
    //   11: aload_0
    //   12: getfield 101	ct/ay:h	Ljava/io/InputStream;
    //   15: invokevirtual 216	java/io/InputStream:close	()V
    //   18: aload_0
    //   19: aconst_null
    //   20: putfield 101	ct/ay:h	Ljava/io/InputStream;
    //   23: aload_0
    //   24: getfield 188	ct/ay:g	Ljava/io/OutputStream;
    //   27: astore_1
    //   28: aload_1
    //   29: ifnull +15 -> 44
    //   32: aload_0
    //   33: getfield 188	ct/ay:g	Ljava/io/OutputStream;
    //   36: invokevirtual 204	java/io/OutputStream:close	()V
    //   39: aload_0
    //   40: aconst_null
    //   41: putfield 188	ct/ay:g	Ljava/io/OutputStream;
    //   44: aload_0
    //   45: getfield 82	ct/ay:c	Ljava/net/Socket;
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull +15 -> 65
    //   53: aload_0
    //   54: getfield 82	ct/ay:c	Ljava/net/Socket;
    //   57: invokevirtual 207	java/net/Socket:close	()V
    //   60: aload_0
    //   61: aconst_null
    //   62: putfield 82	ct/ay:c	Ljava/net/Socket;
    //   65: invokestatic 220	ct/aw:a	()V
    //   68: aload_0
    //   69: monitorexit
    //   70: return
    //   71: astore_1
    //   72: aload_0
    //   73: aconst_null
    //   74: putfield 101	ct/ay:h	Ljava/io/InputStream;
    //   77: goto -54 -> 23
    //   80: astore_1
    //   81: aload_0
    //   82: monitorexit
    //   83: aload_1
    //   84: athrow
    //   85: astore_1
    //   86: aload_0
    //   87: aconst_null
    //   88: putfield 101	ct/ay:h	Ljava/io/InputStream;
    //   91: aload_1
    //   92: athrow
    //   93: astore_1
    //   94: aload_0
    //   95: aconst_null
    //   96: putfield 188	ct/ay:g	Ljava/io/OutputStream;
    //   99: goto -55 -> 44
    //   102: astore_1
    //   103: aload_0
    //   104: aconst_null
    //   105: putfield 188	ct/ay:g	Ljava/io/OutputStream;
    //   108: aload_1
    //   109: athrow
    //   110: astore_1
    //   111: aload_0
    //   112: aconst_null
    //   113: putfield 82	ct/ay:c	Ljava/net/Socket;
    //   116: goto -51 -> 65
    //   119: astore_1
    //   120: aload_0
    //   121: aconst_null
    //   122: putfield 82	ct/ay:c	Ljava/net/Socket;
    //   125: aload_1
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	ay
    //   6	44	1	localObject1	Object
    //   71	1	1	localException1	Exception
    //   80	4	1	localObject2	Object
    //   85	7	1	localObject3	Object
    //   93	1	1	localException2	Exception
    //   102	7	1	localObject4	Object
    //   110	1	1	localException3	Exception
    //   119	7	1	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   11	18	71	java/lang/Exception
    //   2	7	80	finally
    //   18	23	80	finally
    //   23	28	80	finally
    //   39	44	80	finally
    //   44	49	80	finally
    //   60	65	80	finally
    //   65	68	80	finally
    //   72	77	80	finally
    //   86	93	80	finally
    //   94	99	80	finally
    //   103	110	80	finally
    //   111	116	80	finally
    //   120	127	80	finally
    //   11	18	85	finally
    //   32	39	93	java/lang/Exception
    //   32	39	102	finally
    //   53	60	110	java/lang/Exception
    //   53	60	119	finally
  }
  
  /* Error */
  private void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 80
    //   4: ldc -34
    //   6: invokestatic 148	ct/bb:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   9: new 224	ct/ax
    //   12: astore_3
    //   13: aload_3
    //   14: invokespecial 225	ct/ax:<init>	()V
    //   17: aload_0
    //   18: getfield 57	ct/ay:e	Lct/az;
    //   21: getfield 173	ct/az:j	I
    //   24: ifle +358 -> 382
    //   27: aload_3
    //   28: aload_0
    //   29: getfield 57	ct/ay:e	Lct/az;
    //   32: getfield 173	ct/az:j	I
    //   35: putfield 227	ct/ax:c	I
    //   38: invokestatic 232	ct/b$a:b	()Lct/b$a;
    //   41: getfield 235	ct/b$a:b	Lct/e;
    //   44: getfield 238	ct/e:d	I
    //   47: istore_1
    //   48: iload_1
    //   49: ifle +18 -> 67
    //   52: iload_1
    //   53: iconst_4
    //   54: if_icmpge +13 -> 67
    //   57: aload_3
    //   58: iload_1
    //   59: putfield 240	ct/ax:a	I
    //   62: aload_3
    //   63: iload_1
    //   64: putfield 241	ct/ax:b	I
    //   67: getstatic 246	ct/d:a	[I
    //   70: astore 4
    //   72: aload_3
    //   73: ldc -8
    //   75: putfield 250	ct/ax:f	Ljava/lang/String;
    //   78: aload 4
    //   80: invokestatic 253	ct/ax:a	([I)V
    //   83: invokestatic 258	ct/u:a	()Lct/u;
    //   86: ldc -8
    //   88: invokevirtual 261	ct/u:a	(Ljava/lang/String;)Lct/t$a;
    //   91: astore 5
    //   93: aload 5
    //   95: ifnull +30 -> 125
    //   98: new 263	java/util/ArrayList
    //   101: astore 4
    //   103: aload 4
    //   105: invokespecial 264	java/util/ArrayList:<init>	()V
    //   108: aload 4
    //   110: aload 5
    //   112: getfield 269	ct/t$a:c	Ljava/util/List;
    //   115: invokevirtual 273	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   118: pop
    //   119: aload_3
    //   120: aload 4
    //   122: putfield 276	ct/ax:d	Ljava/util/ArrayList;
    //   125: invokestatic 232	ct/b$a:b	()Lct/b$a;
    //   128: getfield 279	ct/b$a:a	Lct/d;
    //   131: getfield 281	ct/d:b	J
    //   134: lconst_0
    //   135: lcmp
    //   136: ifle +11 -> 147
    //   139: invokestatic 71	android/os/SystemClock:elapsedRealtime	()J
    //   142: pop2
    //   143: invokestatic 232	ct/b$a:b	()Lct/b$a;
    //   146: pop
    //   147: aload_3
    //   148: invokestatic 232	ct/b$a:b	()Lct/b$a;
    //   151: getfield 279	ct/b$a:a	Lct/d;
    //   154: invokevirtual 284	ct/d:c	()Ljava/util/ArrayList;
    //   157: putfield 286	ct/ax:e	Ljava/util/ArrayList;
    //   160: aload_0
    //   161: iconst_0
    //   162: putfield 42	ct/ay:j	I
    //   165: aload_3
    //   166: invokevirtual 287	ct/ax:a	()V
    //   169: aload_0
    //   170: aload_3
    //   171: getfield 288	ct/ax:i	I
    //   174: putfield 40	ct/ay:i	I
    //   177: aload_0
    //   178: aload_3
    //   179: getfield 289	ct/ax:j	I
    //   182: putfield 42	ct/ay:j	I
    //   185: aload_0
    //   186: getfield 57	ct/ay:e	Lct/az;
    //   189: aload_0
    //   190: getfield 40	ct/ay:i	I
    //   193: putfield 291	ct/az:e	I
    //   196: aload_0
    //   197: getfield 57	ct/ay:e	Lct/az;
    //   200: aload_0
    //   201: getfield 42	ct/ay:j	I
    //   204: putfield 167	ct/az:d	I
    //   207: aload_3
    //   208: getfield 293	ct/ax:h	I
    //   211: ifne +317 -> 528
    //   214: aload_0
    //   215: aload_3
    //   216: getfield 295	ct/ax:g	Ljava/net/Socket;
    //   219: putfield 82	ct/ay:c	Ljava/net/Socket;
    //   222: aload_0
    //   223: aload_3
    //   224: getfield 297	ct/ax:k	Lct/s;
    //   227: putfield 299	ct/ay:f	Lct/s;
    //   230: aload_0
    //   231: getfield 57	ct/ay:e	Lct/az;
    //   234: aload_0
    //   235: getfield 299	ct/ay:f	Lct/s;
    //   238: putfield 301	ct/az:h	Lct/s;
    //   241: new 73	java/lang/StringBuilder
    //   244: astore_3
    //   245: aload_3
    //   246: ldc_w 303
    //   249: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   252: ldc 80
    //   254: aload_3
    //   255: aload_0
    //   256: getfield 82	ct/ay:c	Ljava/net/Socket;
    //   259: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   262: ldc_w 305
    //   265: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_0
    //   269: getfield 299	ct/ay:f	Lct/s;
    //   272: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 148	ct/bb:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: aload_0
    //   282: getfield 82	ct/ay:c	Ljava/net/Socket;
    //   285: ifnull +174 -> 459
    //   288: aload_0
    //   289: getfield 82	ct/ay:c	Ljava/net/Socket;
    //   292: invokevirtual 212	java/net/Socket:isConnected	()Z
    //   295: ifeq +164 -> 459
    //   298: aload_0
    //   299: getfield 82	ct/ay:c	Ljava/net/Socket;
    //   302: invokevirtual 215	java/net/Socket:isClosed	()Z
    //   305: istore_2
    //   306: iload_2
    //   307: ifne +152 -> 459
    //   310: aload_0
    //   311: getfield 82	ct/ay:c	Ljava/net/Socket;
    //   314: aload_0
    //   315: getfield 36	ct/ay:b	I
    //   318: invokevirtual 308	java/net/Socket:setSoTimeout	(I)V
    //   321: aload_0
    //   322: getfield 82	ct/ay:c	Ljava/net/Socket;
    //   325: ldc 113
    //   327: invokevirtual 311	java/net/Socket:setReceiveBufferSize	(I)V
    //   330: aload_0
    //   331: aload_0
    //   332: getfield 82	ct/ay:c	Ljava/net/Socket;
    //   335: invokevirtual 315	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   338: putfield 188	ct/ay:g	Ljava/io/OutputStream;
    //   341: aload_0
    //   342: aload_0
    //   343: getfield 82	ct/ay:c	Ljava/net/Socket;
    //   346: invokevirtual 319	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   349: putfield 101	ct/ay:h	Ljava/io/InputStream;
    //   352: new 73	java/lang/StringBuilder
    //   355: astore_3
    //   356: aload_3
    //   357: ldc_w 321
    //   360: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   363: ldc 80
    //   365: aload_3
    //   366: aload_0
    //   367: getfield 82	ct/ay:c	Ljava/net/Socket;
    //   370: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   373: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   376: invokestatic 95	ct/bb:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   379: aload_0
    //   380: monitorexit
    //   381: return
    //   382: aload_3
    //   383: invokestatic 232	ct/b$a:b	()Lct/b$a;
    //   386: getfield 235	ct/b$a:b	Lct/e;
    //   389: getfield 322	ct/e:a	I
    //   392: putfield 227	ct/ax:c	I
    //   395: goto -357 -> 38
    //   398: astore_3
    //   399: aload_0
    //   400: monitorexit
    //   401: aload_3
    //   402: athrow
    //   403: astore_3
    //   404: aload_3
    //   405: invokevirtual 123	java/lang/Exception:printStackTrace	()V
    //   408: new 73	java/lang/StringBuilder
    //   411: astore 4
    //   413: aload 4
    //   415: ldc_w 324
    //   418: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   421: ldc 80
    //   423: aload 4
    //   425: aload_0
    //   426: getfield 82	ct/ay:c	Ljava/net/Socket;
    //   429: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   432: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: aload_3
    //   436: invokestatic 327	ct/bb:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   439: aload_0
    //   440: bipush -3
    //   442: aload_3
    //   443: invokestatic 129	ct/bc:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   446: invokespecial 55	ct/ay:a	(ILjava/lang/String;)V
    //   449: aload_0
    //   450: invokespecial 329	ct/ay:d	()V
    //   453: goto -74 -> 379
    //   456: astore_3
    //   457: aload_3
    //   458: athrow
    //   459: aload_0
    //   460: getfield 82	ct/ay:c	Ljava/net/Socket;
    //   463: ifnonnull +15 -> 478
    //   466: aload_0
    //   467: bipush -3
    //   469: ldc_w 331
    //   472: invokespecial 55	ct/ay:a	(ILjava/lang/String;)V
    //   475: goto -96 -> 379
    //   478: new 73	java/lang/StringBuilder
    //   481: astore_3
    //   482: aload_3
    //   483: ldc_w 333
    //   486: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   489: aload_0
    //   490: bipush -3
    //   492: aload_3
    //   493: aload_0
    //   494: getfield 82	ct/ay:c	Ljava/net/Socket;
    //   497: invokevirtual 212	java/net/Socket:isConnected	()Z
    //   500: invokevirtual 336	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   503: ldc_w 338
    //   506: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: aload_0
    //   510: getfield 82	ct/ay:c	Ljava/net/Socket;
    //   513: invokevirtual 215	java/net/Socket:isClosed	()Z
    //   516: invokevirtual 336	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   519: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokespecial 55	ct/ay:a	(ILjava/lang/String;)V
    //   525: goto -146 -> 379
    //   528: invokestatic 342	ct/ba:e	()Z
    //   531: ifeq +55 -> 586
    //   534: ldc_w 344
    //   537: invokestatic 349	ct/j:b	(Ljava/lang/String;)Z
    //   540: ifeq +37 -> 577
    //   543: new 73	java/lang/StringBuilder
    //   546: astore 4
    //   548: aload 4
    //   550: ldc_w 351
    //   553: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   556: aload_0
    //   557: bipush -3
    //   559: aload 4
    //   561: aload_3
    //   562: getfield 293	ct/ax:h	I
    //   565: invokevirtual 118	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   568: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: invokespecial 55	ct/ay:a	(ILjava/lang/String;)V
    //   574: goto -195 -> 379
    //   577: aload_0
    //   578: bipush -16
    //   580: invokespecial 201	ct/ay:a	(I)V
    //   583: goto -204 -> 379
    //   586: aload_0
    //   587: bipush -4
    //   589: invokespecial 201	ct/ay:a	(I)V
    //   592: goto -213 -> 379
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	595	0	this	ay
    //   47	17	1	n	int
    //   305	2	2	bool	boolean
    //   12	371	3	localObject1	Object
    //   398	4	3	localObject2	Object
    //   403	40	3	localException	Exception
    //   456	2	3	localObject3	Object
    //   481	81	3	localStringBuilder	StringBuilder
    //   70	490	4	localObject4	Object
    //   91	20	5	locala	t.a
    // Exception table:
    //   from	to	target	type
    //   2	38	398	finally
    //   38	48	398	finally
    //   57	67	398	finally
    //   67	93	398	finally
    //   98	125	398	finally
    //   125	147	398	finally
    //   147	306	398	finally
    //   382	395	398	finally
    //   457	459	398	finally
    //   459	475	398	finally
    //   478	525	398	finally
    //   528	574	398	finally
    //   577	583	398	finally
    //   586	592	398	finally
    //   310	379	403	java/lang/Exception
    //   310	379	456	finally
    //   404	453	456	finally
  }
  
  public final void a(az paramaz)
  {
    if (paramaz == null) {}
    for (;;)
    {
      return;
      try
      {
        this.e = paramaz;
        this.e.i = SystemClock.elapsedRealtime();
        this.e.j = 22000;
        e();
        if (c())
        {
          b(paramaz);
          b();
          d();
        }
      }
      catch (Exception paramaz) {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/ay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */