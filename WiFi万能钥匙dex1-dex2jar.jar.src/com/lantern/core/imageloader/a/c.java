package com.lantern.core.imageloader.a;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

final class c
  implements Runnable
{
  private static final Object t = new Object();
  private static final ThreadLocal<StringBuilder> u = new d();
  private static final AtomicInteger v = new AtomicInteger();
  private static final ai w = new e();
  final int a = v.incrementAndGet();
  final aa b;
  final p c;
  final j d;
  final ak e;
  final String f;
  final ag g;
  final int h;
  final ai i;
  int j;
  a k;
  List<a> l;
  Bitmap m;
  Future<?> n;
  aa.d o;
  Exception p;
  int q;
  int r;
  int s;
  
  private c(aa paramaa, p paramp, j paramj, ak paramak, a parama, ai paramai)
  {
    this.b = paramaa;
    this.c = paramp;
    this.d = paramj;
    this.e = paramak;
    this.k = parama;
    this.f = parama.i;
    this.g = parama.b;
    this.s = parama.b.p;
    this.h = parama.e;
    this.j = parama.f;
    this.i = paramai;
    this.r = paramai.a();
  }
  
  private static Bitmap a(List<ap> paramList, Bitmap paramBitmap)
  {
    int i2 = paramList.size();
    int i1 = 0;
    ap localap;
    Bitmap localBitmap;
    if (i1 < i2)
    {
      localap = (ap)paramList.get(i1);
      try
      {
        localBitmap = localap.a(paramBitmap);
        if (localBitmap == null)
        {
          paramBitmap = new StringBuilder("Transformation ").append(localap.a()).append(" returned null after ").append(i1).append(" previous transformation(s).\n\nTransformation list:\n");
          paramList = paramList.iterator();
          while (paramList.hasNext())
          {
            paramBitmap.append(((ap)paramList.next()).a()).append('\n');
            continue;
            return paramList;
          }
        }
      }
      catch (RuntimeException paramList)
      {
        aa.a.post(new f(localap, paramList));
        paramList = null;
      }
    }
    for (;;)
    {
      aa.a.post(new g(paramBitmap));
      paramList = null;
      continue;
      if ((localBitmap == paramBitmap) && (paramBitmap.isRecycled()))
      {
        aa.a.post(new h(localap));
        paramList = null;
      }
      else if ((localBitmap != paramBitmap) && (!paramBitmap.isRecycled()))
      {
        aa.a.post(new i(localap));
        paramList = null;
      }
      else
      {
        i1++;
        paramBitmap = localBitmap;
        break;
        paramList = paramBitmap;
      }
    }
  }
  
  static c a(aa paramaa, p paramp, j paramj, ak paramak, a parama)
  {
    ag localag = parama.b;
    List localList = paramaa.b();
    int i1 = 0;
    int i2 = localList.size();
    ai localai;
    if (i1 < i2)
    {
      localai = (ai)localList.get(i1);
      if (!localai.a(localag)) {}
    }
    for (paramaa = new c(paramaa, paramp, paramj, paramak, parama, localai);; paramaa = new c(paramaa, paramp, paramj, paramak, parama, w))
    {
      return paramaa;
      i1++;
      break;
    }
  }
  
  private static boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((!paramBoolean) || (paramInt1 > paramInt3) || (paramInt2 > paramInt4)) {}
    for (paramBoolean = true;; paramBoolean = false) {
      return paramBoolean;
    }
  }
  
  /* Error */
  private Bitmap c()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 38
    //   3: aload_0
    //   4: getfield 109	com/lantern/core/imageloader/a/c:h	I
    //   7: invokestatic 228	com/lantern/core/imageloader/a/x:a	(I)Z
    //   10: ifeq +78 -> 88
    //   13: aload_0
    //   14: getfield 85	com/lantern/core/imageloader/a/c:d	Lcom/lantern/core/imageloader/a/j;
    //   17: aload_0
    //   18: getfield 95	com/lantern/core/imageloader/a/c:f	Ljava/lang/String;
    //   21: invokeinterface 233 2 0
    //   26: astore 40
    //   28: aload 40
    //   30: astore 38
    //   32: aload 40
    //   34: ifnull +54 -> 88
    //   37: aload_0
    //   38: getfield 87	com/lantern/core/imageloader/a/c:e	Lcom/lantern/core/imageloader/a/ak;
    //   41: invokevirtual 237	com/lantern/core/imageloader/a/ak:a	()V
    //   44: aload_0
    //   45: getstatic 241	com/lantern/core/imageloader/a/aa$d:a	Lcom/lantern/core/imageloader/a/aa$d;
    //   48: putfield 243	com/lantern/core/imageloader/a/c:o	Lcom/lantern/core/imageloader/a/aa$d;
    //   51: aload 40
    //   53: astore 39
    //   55: aload_0
    //   56: getfield 81	com/lantern/core/imageloader/a/c:b	Lcom/lantern/core/imageloader/a/aa;
    //   59: getfield 246	com/lantern/core/imageloader/a/aa:l	Z
    //   62: ifeq +23 -> 85
    //   65: ldc -8
    //   67: ldc -6
    //   69: aload_0
    //   70: getfield 99	com/lantern/core/imageloader/a/c:g	Lcom/lantern/core/imageloader/a/ag;
    //   73: invokevirtual 251	com/lantern/core/imageloader/a/ag:a	()Ljava/lang/String;
    //   76: ldc -3
    //   78: invokestatic 258	com/lantern/core/imageloader/a/at:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   81: aload 40
    //   83: astore 39
    //   85: aload 39
    //   87: areturn
    //   88: aload_0
    //   89: getfield 99	com/lantern/core/imageloader/a/c:g	Lcom/lantern/core/imageloader/a/ag;
    //   92: astore 39
    //   94: aload_0
    //   95: getfield 121	com/lantern/core/imageloader/a/c:r	I
    //   98: ifne +1200 -> 1298
    //   101: getstatic 263	com/lantern/core/imageloader/a/y:c	Lcom/lantern/core/imageloader/a/y;
    //   104: getfield 265	com/lantern/core/imageloader/a/y:d	I
    //   107: istore 22
    //   109: aload 39
    //   111: iload 22
    //   113: putfield 266	com/lantern/core/imageloader/a/ag:s	I
    //   116: aload_0
    //   117: getfield 115	com/lantern/core/imageloader/a/c:i	Lcom/lantern/core/imageloader/a/ai;
    //   120: aload_0
    //   121: getfield 99	com/lantern/core/imageloader/a/c:g	Lcom/lantern/core/imageloader/a/ag;
    //   124: invokevirtual 269	com/lantern/core/imageloader/a/ai:b	(Lcom/lantern/core/imageloader/a/ag;)Lcom/lantern/core/imageloader/a/ai$a;
    //   127: astore 40
    //   129: aload 40
    //   131: ifnull +188 -> 319
    //   134: aload_0
    //   135: aload 40
    //   137: invokevirtual 274	com/lantern/core/imageloader/a/ai$a:c	()Lcom/lantern/core/imageloader/a/aa$d;
    //   140: putfield 243	com/lantern/core/imageloader/a/c:o	Lcom/lantern/core/imageloader/a/aa$d;
    //   143: aload_0
    //   144: aload 40
    //   146: invokevirtual 276	com/lantern/core/imageloader/a/ai$a:d	()I
    //   149: putfield 278	com/lantern/core/imageloader/a/c:q	I
    //   152: aload 40
    //   154: invokevirtual 280	com/lantern/core/imageloader/a/ai$a:a	()Landroid/graphics/Bitmap;
    //   157: astore 39
    //   159: aload 39
    //   161: astore 38
    //   163: aload 39
    //   165: ifnonnull +154 -> 319
    //   168: aload 40
    //   170: invokevirtual 283	com/lantern/core/imageloader/a/ai$a:b	()Ljava/io/InputStream;
    //   173: astore 40
    //   175: aload_0
    //   176: getfield 99	com/lantern/core/imageloader/a/c:g	Lcom/lantern/core/imageloader/a/ag;
    //   179: astore 39
    //   181: new 285	com/lantern/core/imageloader/a/v
    //   184: astore 41
    //   186: aload 41
    //   188: aload 40
    //   190: invokespecial 288	com/lantern/core/imageloader/a/v:<init>	(Ljava/io/InputStream;)V
    //   193: aload 41
    //   195: ldc_w 289
    //   198: invokevirtual 292	com/lantern/core/imageloader/a/v:a	(I)J
    //   201: lstore 36
    //   203: aload 39
    //   205: invokestatic 295	com/lantern/core/imageloader/a/ai:d	(Lcom/lantern/core/imageloader/a/ag;)Landroid/graphics/BitmapFactory$Options;
    //   208: astore 38
    //   210: aload 38
    //   212: invokestatic 298	com/lantern/core/imageloader/a/ai:a	(Landroid/graphics/BitmapFactory$Options;)Z
    //   215: istore 35
    //   217: aload 41
    //   219: invokestatic 301	com/lantern/core/imageloader/a/at:c	(Ljava/io/InputStream;)Z
    //   222: istore 34
    //   224: aload 39
    //   226: getfield 303	com/lantern/core/imageloader/a/ag:n	Z
    //   229: ifeq +1078 -> 1307
    //   232: getstatic 308	android/os/Build$VERSION:SDK_INT	I
    //   235: bipush 21
    //   237: if_icmpge +1070 -> 1307
    //   240: iconst_1
    //   241: istore 22
    //   243: aload 41
    //   245: lload 36
    //   247: invokevirtual 311	com/lantern/core/imageloader/a/v:a	(J)V
    //   250: iload 34
    //   252: ifne +8 -> 260
    //   255: iload 22
    //   257: ifeq +1056 -> 1313
    //   260: aload 41
    //   262: invokestatic 314	com/lantern/core/imageloader/a/at:b	(Ljava/io/InputStream;)[B
    //   265: astore 41
    //   267: iload 35
    //   269: ifeq +32 -> 301
    //   272: aload 41
    //   274: iconst_0
    //   275: aload 41
    //   277: arraylength
    //   278: aload 38
    //   280: invokestatic 320	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   283: pop
    //   284: aload 39
    //   286: getfield 321	com/lantern/core/imageloader/a/ag:e	I
    //   289: aload 39
    //   291: getfield 322	com/lantern/core/imageloader/a/ag:f	I
    //   294: aload 38
    //   296: aload 39
    //   298: invokestatic 325	com/lantern/core/imageloader/a/ai:a	(IILandroid/graphics/BitmapFactory$Options;Lcom/lantern/core/imageloader/a/ag;)V
    //   301: aload 41
    //   303: iconst_0
    //   304: aload 41
    //   306: arraylength
    //   307: aload 38
    //   309: invokestatic 320	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   312: astore 38
    //   314: aload 40
    //   316: invokestatic 327	com/lantern/core/imageloader/a/at:a	(Ljava/io/InputStream;)V
    //   319: aload 38
    //   321: astore 39
    //   323: aload 38
    //   325: ifnull -240 -> 85
    //   328: aload_0
    //   329: getfield 81	com/lantern/core/imageloader/a/c:b	Lcom/lantern/core/imageloader/a/aa;
    //   332: getfield 246	com/lantern/core/imageloader/a/aa:l	Z
    //   335: ifeq +17 -> 352
    //   338: ldc -8
    //   340: ldc -6
    //   342: aload_0
    //   343: getfield 99	com/lantern/core/imageloader/a/c:g	Lcom/lantern/core/imageloader/a/ag;
    //   346: invokevirtual 251	com/lantern/core/imageloader/a/ag:a	()Ljava/lang/String;
    //   349: invokestatic 330	com/lantern/core/imageloader/a/at:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   352: aload_0
    //   353: getfield 87	com/lantern/core/imageloader/a/c:e	Lcom/lantern/core/imageloader/a/ak;
    //   356: aload 38
    //   358: invokevirtual 333	com/lantern/core/imageloader/a/ak:a	(Landroid/graphics/Bitmap;)V
    //   361: aload_0
    //   362: getfield 99	com/lantern/core/imageloader/a/c:g	Lcom/lantern/core/imageloader/a/ag;
    //   365: astore 39
    //   367: aload 39
    //   369: invokevirtual 335	com/lantern/core/imageloader/a/ag:d	()Z
    //   372: ifne +11 -> 383
    //   375: aload 39
    //   377: invokevirtual 337	com/lantern/core/imageloader/a/ag:e	()Z
    //   380: ifeq +1016 -> 1396
    //   383: iconst_1
    //   384: istore 22
    //   386: iload 22
    //   388: ifne +14 -> 402
    //   391: aload 38
    //   393: astore 39
    //   395: aload_0
    //   396: getfield 278	com/lantern/core/imageloader/a/c:q	I
    //   399: ifeq -314 -> 85
    //   402: getstatic 56	com/lantern/core/imageloader/a/c:t	Ljava/lang/Object;
    //   405: astore 41
    //   407: aload 41
    //   409: monitorenter
    //   410: aload_0
    //   411: getfield 99	com/lantern/core/imageloader/a/c:g	Lcom/lantern/core/imageloader/a/ag;
    //   414: invokevirtual 335	com/lantern/core/imageloader/a/ag:d	()Z
    //   417: ifne +14 -> 431
    //   420: aload 38
    //   422: astore 40
    //   424: aload_0
    //   425: getfield 278	com/lantern/core/imageloader/a/c:q	I
    //   428: ifeq +778 -> 1206
    //   431: aload_0
    //   432: getfield 99	com/lantern/core/imageloader/a/c:g	Lcom/lantern/core/imageloader/a/ag;
    //   435: astore 39
    //   437: aload_0
    //   438: getfield 278	com/lantern/core/imageloader/a/c:q	I
    //   441: istore 28
    //   443: aload 38
    //   445: invokevirtual 340	android/graphics/Bitmap:getWidth	()I
    //   448: istore 26
    //   450: aload 38
    //   452: invokevirtual 343	android/graphics/Bitmap:getHeight	()I
    //   455: istore 27
    //   457: aload 39
    //   459: getfield 345	com/lantern/core/imageloader/a/ag:i	Z
    //   462: istore 34
    //   464: iconst_0
    //   465: istore 32
    //   467: iconst_0
    //   468: istore 33
    //   470: new 347	android/graphics/Matrix
    //   473: astore 40
    //   475: aload 40
    //   477: invokespecial 348	android/graphics/Matrix:<init>	()V
    //   480: aload 39
    //   482: invokevirtual 335	com/lantern/core/imageloader/a/ag:d	()Z
    //   485: ifne +24 -> 509
    //   488: iload 32
    //   490: istore 25
    //   492: iload 33
    //   494: istore 24
    //   496: iload 26
    //   498: istore 23
    //   500: iload 27
    //   502: istore 22
    //   504: iload 28
    //   506: ifeq +629 -> 1135
    //   509: aload 39
    //   511: getfield 321	com/lantern/core/imageloader/a/ag:e	I
    //   514: istore 23
    //   516: aload 39
    //   518: getfield 322	com/lantern/core/imageloader/a/ag:f	I
    //   521: istore 22
    //   523: aload 39
    //   525: getfield 351	com/lantern/core/imageloader/a/ag:j	F
    //   528: fstore 19
    //   530: fload 19
    //   532: fconst_0
    //   533: fcmpl
    //   534: ifeq +281 -> 815
    //   537: fload 19
    //   539: f2d
    //   540: invokestatic 357	java/lang/Math:toRadians	(D)D
    //   543: invokestatic 360	java/lang/Math:cos	(D)D
    //   546: dstore_1
    //   547: fload 19
    //   549: f2d
    //   550: invokestatic 357	java/lang/Math:toRadians	(D)D
    //   553: invokestatic 363	java/lang/Math:sin	(D)D
    //   556: dstore 9
    //   558: aload 39
    //   560: getfield 365	com/lantern/core/imageloader/a/ag:m	Z
    //   563: ifeq +839 -> 1402
    //   566: aload 40
    //   568: fload 19
    //   570: aload 39
    //   572: getfield 367	com/lantern/core/imageloader/a/ag:k	F
    //   575: aload 39
    //   577: getfield 369	com/lantern/core/imageloader/a/ag:l	F
    //   580: invokevirtual 373	android/graphics/Matrix:setRotate	(FFF)V
    //   583: aload 39
    //   585: getfield 367	com/lantern/core/imageloader/a/ag:k	F
    //   588: f2d
    //   589: dconst_1
    //   590: dload_1
    //   591: dsub
    //   592: dmul
    //   593: aload 39
    //   595: getfield 369	com/lantern/core/imageloader/a/ag:l	F
    //   598: f2d
    //   599: dload 9
    //   601: dmul
    //   602: dadd
    //   603: dstore 13
    //   605: aload 39
    //   607: getfield 369	com/lantern/core/imageloader/a/ag:l	F
    //   610: f2d
    //   611: dconst_1
    //   612: dload_1
    //   613: dsub
    //   614: dmul
    //   615: aload 39
    //   617: getfield 367	com/lantern/core/imageloader/a/ag:k	F
    //   620: f2d
    //   621: dload 9
    //   623: dmul
    //   624: dsub
    //   625: dstore_3
    //   626: aload 39
    //   628: getfield 321	com/lantern/core/imageloader/a/ag:e	I
    //   631: i2d
    //   632: dload_1
    //   633: dmul
    //   634: dload 13
    //   636: dadd
    //   637: dstore 11
    //   639: aload 39
    //   641: getfield 321	com/lantern/core/imageloader/a/ag:e	I
    //   644: i2d
    //   645: dload 9
    //   647: dmul
    //   648: dload_3
    //   649: dadd
    //   650: dstore 7
    //   652: aload 39
    //   654: getfield 321	com/lantern/core/imageloader/a/ag:e	I
    //   657: i2d
    //   658: dload_1
    //   659: dmul
    //   660: dload 13
    //   662: dadd
    //   663: aload 39
    //   665: getfield 322	com/lantern/core/imageloader/a/ag:f	I
    //   668: i2d
    //   669: dload 9
    //   671: dmul
    //   672: dsub
    //   673: dstore 15
    //   675: aload 39
    //   677: getfield 321	com/lantern/core/imageloader/a/ag:e	I
    //   680: i2d
    //   681: dload 9
    //   683: dmul
    //   684: dload_3
    //   685: dadd
    //   686: aload 39
    //   688: getfield 322	com/lantern/core/imageloader/a/ag:f	I
    //   691: i2d
    //   692: dload_1
    //   693: dmul
    //   694: dadd
    //   695: dstore 5
    //   697: dload 13
    //   699: dload 9
    //   701: aload 39
    //   703: getfield 322	com/lantern/core/imageloader/a/ag:f	I
    //   706: i2d
    //   707: dmul
    //   708: dsub
    //   709: dstore 17
    //   711: dload_1
    //   712: aload 39
    //   714: getfield 322	com/lantern/core/imageloader/a/ag:f	I
    //   717: i2d
    //   718: dmul
    //   719: dload_3
    //   720: dadd
    //   721: dstore 9
    //   723: dload 17
    //   725: dload 15
    //   727: dload 13
    //   729: dload 11
    //   731: invokestatic 377	java/lang/Math:max	(DD)D
    //   734: invokestatic 377	java/lang/Math:max	(DD)D
    //   737: invokestatic 377	java/lang/Math:max	(DD)D
    //   740: dstore_1
    //   741: dload 17
    //   743: dload 15
    //   745: dload 13
    //   747: dload 11
    //   749: invokestatic 380	java/lang/Math:min	(DD)D
    //   752: invokestatic 380	java/lang/Math:min	(DD)D
    //   755: invokestatic 380	java/lang/Math:min	(DD)D
    //   758: dstore 13
    //   760: dload 9
    //   762: dload 5
    //   764: dload_3
    //   765: dload 7
    //   767: invokestatic 377	java/lang/Math:max	(DD)D
    //   770: invokestatic 377	java/lang/Math:max	(DD)D
    //   773: invokestatic 377	java/lang/Math:max	(DD)D
    //   776: dstore 11
    //   778: dload 9
    //   780: dload 5
    //   782: dload_3
    //   783: dload 7
    //   785: invokestatic 380	java/lang/Math:min	(DD)D
    //   788: invokestatic 380	java/lang/Math:min	(DD)D
    //   791: invokestatic 380	java/lang/Math:min	(DD)D
    //   794: dstore_3
    //   795: dload_1
    //   796: dload 13
    //   798: dsub
    //   799: invokestatic 383	java/lang/Math:floor	(D)D
    //   802: d2i
    //   803: istore 23
    //   805: dload 11
    //   807: dload_3
    //   808: dsub
    //   809: invokestatic 383	java/lang/Math:floor	(D)D
    //   812: d2i
    //   813: istore 22
    //   815: iload 22
    //   817: istore 30
    //   819: iload 23
    //   821: istore 29
    //   823: iload 28
    //   825: ifeq +175 -> 1000
    //   828: iload 28
    //   830: tableswitch	default:+38->868, 3:+759->1589, 4:+759->1589, 5:+752->1582, 6:+752->1582, 7:+767->1597, 8:+767->1597
    //   868: iconst_0
    //   869: istore 24
    //   871: iload 28
    //   873: tableswitch	default:+39->912, 2:+732->1605, 3:+39->912, 4:+732->1605, 5:+732->1605, 6:+39->912, 7:+732->1605
    //   912: iconst_1
    //   913: istore 31
    //   915: iload 22
    //   917: istore 28
    //   919: iload 23
    //   921: istore 25
    //   923: iload 24
    //   925: ifeq +43 -> 968
    //   928: aload 40
    //   930: iload 24
    //   932: i2f
    //   933: invokevirtual 387	android/graphics/Matrix:preRotate	(F)Z
    //   936: pop
    //   937: iload 24
    //   939: bipush 90
    //   941: if_icmpeq +19 -> 960
    //   944: iload 22
    //   946: istore 28
    //   948: iload 23
    //   950: istore 25
    //   952: iload 24
    //   954: sipush 270
    //   957: if_icmpne +11 -> 968
    //   960: iload 22
    //   962: istore 25
    //   964: iload 23
    //   966: istore 28
    //   968: iload 28
    //   970: istore 30
    //   972: iload 25
    //   974: istore 29
    //   976: iload 31
    //   978: iconst_1
    //   979: if_icmpeq +21 -> 1000
    //   982: aload 40
    //   984: iload 31
    //   986: i2f
    //   987: fconst_1
    //   988: invokevirtual 391	android/graphics/Matrix:postScale	(FF)Z
    //   991: pop
    //   992: iload 25
    //   994: istore 29
    //   996: iload 28
    //   998: istore 30
    //   1000: aload 39
    //   1002: getfield 393	com/lantern/core/imageloader/a/ag:g	Z
    //   1005: ifeq +711 -> 1716
    //   1008: iload 29
    //   1010: ifeq +601 -> 1611
    //   1013: iload 29
    //   1015: i2f
    //   1016: iload 26
    //   1018: i2f
    //   1019: fdiv
    //   1020: fstore 20
    //   1022: iload 30
    //   1024: ifeq +599 -> 1623
    //   1027: iload 30
    //   1029: i2f
    //   1030: iload 27
    //   1032: i2f
    //   1033: fdiv
    //   1034: fstore 19
    //   1036: fload 20
    //   1038: fload 19
    //   1040: fcmpl
    //   1041: ifle +594 -> 1635
    //   1044: iload 27
    //   1046: i2f
    //   1047: fload 19
    //   1049: fload 20
    //   1051: fdiv
    //   1052: fmul
    //   1053: f2d
    //   1054: invokestatic 396	java/lang/Math:ceil	(D)D
    //   1057: d2i
    //   1058: istore 25
    //   1060: iload 27
    //   1062: iload 25
    //   1064: isub
    //   1065: iconst_2
    //   1066: idiv
    //   1067: istore 23
    //   1069: iload 30
    //   1071: i2f
    //   1072: iload 25
    //   1074: i2f
    //   1075: fdiv
    //   1076: fstore 19
    //   1078: iconst_0
    //   1079: istore 22
    //   1081: iload 26
    //   1083: istore 24
    //   1085: iload 34
    //   1087: iload 26
    //   1089: iload 27
    //   1091: iload 29
    //   1093: iload 30
    //   1095: invokestatic 398	com/lantern/core/imageloader/a/c:a	(ZIIII)Z
    //   1098: ifeq +13 -> 1111
    //   1101: aload 40
    //   1103: fload 20
    //   1105: fload 19
    //   1107: invokevirtual 401	android/graphics/Matrix:preScale	(FF)Z
    //   1110: pop
    //   1111: iload 24
    //   1113: istore 27
    //   1115: iload 23
    //   1117: istore 24
    //   1119: iload 22
    //   1121: istore 26
    //   1123: iload 25
    //   1125: istore 22
    //   1127: iload 27
    //   1129: istore 23
    //   1131: iload 26
    //   1133: istore 25
    //   1135: aload 38
    //   1137: iload 25
    //   1139: iload 24
    //   1141: iload 23
    //   1143: iload 22
    //   1145: aload 40
    //   1147: iconst_1
    //   1148: invokestatic 405	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   1151: astore 40
    //   1153: aload 38
    //   1155: astore 39
    //   1157: aload 40
    //   1159: aload 38
    //   1161: if_acmpeq +12 -> 1173
    //   1164: aload 38
    //   1166: invokevirtual 408	android/graphics/Bitmap:recycle	()V
    //   1169: aload 40
    //   1171: astore 39
    //   1173: aload 39
    //   1175: astore 40
    //   1177: aload_0
    //   1178: getfield 81	com/lantern/core/imageloader/a/c:b	Lcom/lantern/core/imageloader/a/aa;
    //   1181: getfield 246	com/lantern/core/imageloader/a/aa:l	Z
    //   1184: ifeq +22 -> 1206
    //   1187: ldc -8
    //   1189: ldc_w 410
    //   1192: aload_0
    //   1193: getfield 99	com/lantern/core/imageloader/a/c:g	Lcom/lantern/core/imageloader/a/ag;
    //   1196: invokevirtual 251	com/lantern/core/imageloader/a/ag:a	()Ljava/lang/String;
    //   1199: invokestatic 330	com/lantern/core/imageloader/a/at:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1202: aload 39
    //   1204: astore 40
    //   1206: aload 40
    //   1208: astore 38
    //   1210: aload_0
    //   1211: getfield 99	com/lantern/core/imageloader/a/c:g	Lcom/lantern/core/imageloader/a/ag;
    //   1214: invokevirtual 337	com/lantern/core/imageloader/a/ag:e	()Z
    //   1217: ifeq +53 -> 1270
    //   1220: aload_0
    //   1221: getfield 99	com/lantern/core/imageloader/a/c:g	Lcom/lantern/core/imageloader/a/ag;
    //   1224: getfield 412	com/lantern/core/imageloader/a/ag:d	Ljava/util/List;
    //   1227: aload 40
    //   1229: invokestatic 414	com/lantern/core/imageloader/a/c:a	(Ljava/util/List;Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   1232: astore 39
    //   1234: aload 39
    //   1236: astore 38
    //   1238: aload_0
    //   1239: getfield 81	com/lantern/core/imageloader/a/c:b	Lcom/lantern/core/imageloader/a/aa;
    //   1242: getfield 246	com/lantern/core/imageloader/a/aa:l	Z
    //   1245: ifeq +25 -> 1270
    //   1248: ldc -8
    //   1250: ldc_w 410
    //   1253: aload_0
    //   1254: getfield 99	com/lantern/core/imageloader/a/c:g	Lcom/lantern/core/imageloader/a/ag;
    //   1257: invokevirtual 251	com/lantern/core/imageloader/a/ag:a	()Ljava/lang/String;
    //   1260: ldc_w 416
    //   1263: invokestatic 258	com/lantern/core/imageloader/a/at:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1266: aload 39
    //   1268: astore 38
    //   1270: aload 41
    //   1272: monitorexit
    //   1273: aload 38
    //   1275: astore 39
    //   1277: aload 38
    //   1279: ifnull -1194 -> 85
    //   1282: aload_0
    //   1283: getfield 87	com/lantern/core/imageloader/a/c:e	Lcom/lantern/core/imageloader/a/ak;
    //   1286: aload 38
    //   1288: invokevirtual 418	com/lantern/core/imageloader/a/ak:b	(Landroid/graphics/Bitmap;)V
    //   1291: aload 38
    //   1293: astore 39
    //   1295: goto -1210 -> 85
    //   1298: aload_0
    //   1299: getfield 113	com/lantern/core/imageloader/a/c:j	I
    //   1302: istore 22
    //   1304: goto -1195 -> 109
    //   1307: iconst_0
    //   1308: istore 22
    //   1310: goto -1067 -> 243
    //   1313: iload 35
    //   1315: ifeq +36 -> 1351
    //   1318: aload 41
    //   1320: aconst_null
    //   1321: aload 38
    //   1323: invokestatic 422	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1326: pop
    //   1327: aload 39
    //   1329: getfield 321	com/lantern/core/imageloader/a/ag:e	I
    //   1332: aload 39
    //   1334: getfield 322	com/lantern/core/imageloader/a/ag:f	I
    //   1337: aload 38
    //   1339: aload 39
    //   1341: invokestatic 325	com/lantern/core/imageloader/a/ai:a	(IILandroid/graphics/BitmapFactory$Options;Lcom/lantern/core/imageloader/a/ag;)V
    //   1344: aload 41
    //   1346: lload 36
    //   1348: invokevirtual 311	com/lantern/core/imageloader/a/v:a	(J)V
    //   1351: aload 41
    //   1353: aconst_null
    //   1354: aload 38
    //   1356: invokestatic 422	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   1359: astore 39
    //   1361: aload 39
    //   1363: astore 38
    //   1365: aload 39
    //   1367: ifnonnull -1053 -> 314
    //   1370: new 424	java/io/IOException
    //   1373: astore 38
    //   1375: aload 38
    //   1377: ldc_w 426
    //   1380: invokespecial 427	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   1383: aload 38
    //   1385: athrow
    //   1386: astore 38
    //   1388: aload 40
    //   1390: invokestatic 327	com/lantern/core/imageloader/a/at:a	(Ljava/io/InputStream;)V
    //   1393: aload 38
    //   1395: athrow
    //   1396: iconst_0
    //   1397: istore 22
    //   1399: goto -1013 -> 386
    //   1402: aload 40
    //   1404: fload 19
    //   1406: invokevirtual 430	android/graphics/Matrix:setRotate	(F)V
    //   1409: aload 39
    //   1411: getfield 321	com/lantern/core/imageloader/a/ag:e	I
    //   1414: i2d
    //   1415: dload_1
    //   1416: dmul
    //   1417: dstore 11
    //   1419: aload 39
    //   1421: getfield 321	com/lantern/core/imageloader/a/ag:e	I
    //   1424: i2d
    //   1425: dload 9
    //   1427: dmul
    //   1428: dstore 5
    //   1430: aload 39
    //   1432: getfield 321	com/lantern/core/imageloader/a/ag:e	I
    //   1435: i2d
    //   1436: dload_1
    //   1437: dmul
    //   1438: aload 39
    //   1440: getfield 322	com/lantern/core/imageloader/a/ag:f	I
    //   1443: i2d
    //   1444: dload 9
    //   1446: dmul
    //   1447: dsub
    //   1448: dstore 13
    //   1450: aload 39
    //   1452: getfield 321	com/lantern/core/imageloader/a/ag:e	I
    //   1455: i2d
    //   1456: dload 9
    //   1458: dmul
    //   1459: aload 39
    //   1461: getfield 322	com/lantern/core/imageloader/a/ag:f	I
    //   1464: i2d
    //   1465: dload_1
    //   1466: dmul
    //   1467: dadd
    //   1468: dstore_3
    //   1469: dload 9
    //   1471: aload 39
    //   1473: getfield 322	com/lantern/core/imageloader/a/ag:f	I
    //   1476: i2d
    //   1477: dmul
    //   1478: dneg
    //   1479: dstore 9
    //   1481: dload_1
    //   1482: aload 39
    //   1484: getfield 322	com/lantern/core/imageloader/a/ag:f	I
    //   1487: i2d
    //   1488: dmul
    //   1489: dstore 7
    //   1491: dload 9
    //   1493: dload 13
    //   1495: dconst_0
    //   1496: dload 11
    //   1498: invokestatic 377	java/lang/Math:max	(DD)D
    //   1501: invokestatic 377	java/lang/Math:max	(DD)D
    //   1504: invokestatic 377	java/lang/Math:max	(DD)D
    //   1507: dstore_1
    //   1508: dload 9
    //   1510: dload 13
    //   1512: dconst_0
    //   1513: dload 11
    //   1515: invokestatic 380	java/lang/Math:min	(DD)D
    //   1518: invokestatic 380	java/lang/Math:min	(DD)D
    //   1521: invokestatic 380	java/lang/Math:min	(DD)D
    //   1524: dstore 11
    //   1526: dload 7
    //   1528: dload_3
    //   1529: dconst_0
    //   1530: dload 5
    //   1532: invokestatic 377	java/lang/Math:max	(DD)D
    //   1535: invokestatic 377	java/lang/Math:max	(DD)D
    //   1538: invokestatic 377	java/lang/Math:max	(DD)D
    //   1541: dstore 9
    //   1543: dload 7
    //   1545: dload_3
    //   1546: dconst_0
    //   1547: dload 5
    //   1549: invokestatic 380	java/lang/Math:min	(DD)D
    //   1552: invokestatic 380	java/lang/Math:min	(DD)D
    //   1555: invokestatic 380	java/lang/Math:min	(DD)D
    //   1558: dstore_3
    //   1559: dload_1
    //   1560: dload 11
    //   1562: dsub
    //   1563: invokestatic 383	java/lang/Math:floor	(D)D
    //   1566: d2i
    //   1567: istore 23
    //   1569: dload 9
    //   1571: dload_3
    //   1572: dsub
    //   1573: invokestatic 383	java/lang/Math:floor	(D)D
    //   1576: d2i
    //   1577: istore 22
    //   1579: goto -764 -> 815
    //   1582: bipush 90
    //   1584: istore 24
    //   1586: goto -715 -> 871
    //   1589: sipush 180
    //   1592: istore 24
    //   1594: goto -723 -> 871
    //   1597: sipush 270
    //   1600: istore 24
    //   1602: goto -731 -> 871
    //   1605: iconst_m1
    //   1606: istore 31
    //   1608: goto -693 -> 915
    //   1611: iload 30
    //   1613: i2f
    //   1614: iload 27
    //   1616: i2f
    //   1617: fdiv
    //   1618: fstore 20
    //   1620: goto -598 -> 1022
    //   1623: iload 29
    //   1625: i2f
    //   1626: iload 26
    //   1628: i2f
    //   1629: fdiv
    //   1630: fstore 19
    //   1632: goto -596 -> 1036
    //   1635: fload 20
    //   1637: fload 19
    //   1639: fcmpg
    //   1640: ifge +47 -> 1687
    //   1643: iload 26
    //   1645: i2f
    //   1646: fload 20
    //   1648: fload 19
    //   1650: fdiv
    //   1651: fmul
    //   1652: f2d
    //   1653: invokestatic 396	java/lang/Math:ceil	(D)D
    //   1656: d2i
    //   1657: istore 24
    //   1659: iload 26
    //   1661: iload 24
    //   1663: isub
    //   1664: iconst_2
    //   1665: idiv
    //   1666: istore 22
    //   1668: iload 29
    //   1670: i2f
    //   1671: iload 24
    //   1673: i2f
    //   1674: fdiv
    //   1675: fstore 20
    //   1677: iload 27
    //   1679: istore 25
    //   1681: iconst_0
    //   1682: istore 23
    //   1684: goto -599 -> 1085
    //   1687: iconst_0
    //   1688: istore 22
    //   1690: fload 19
    //   1692: fstore 21
    //   1694: fload 19
    //   1696: fstore 20
    //   1698: iload 27
    //   1700: istore 25
    //   1702: iconst_0
    //   1703: istore 23
    //   1705: iload 26
    //   1707: istore 24
    //   1709: fload 21
    //   1711: fstore 19
    //   1713: goto -628 -> 1085
    //   1716: aload 39
    //   1718: getfield 432	com/lantern/core/imageloader/a/ag:h	Z
    //   1721: ifeq +139 -> 1860
    //   1724: iload 29
    //   1726: ifeq +103 -> 1829
    //   1729: iload 29
    //   1731: i2f
    //   1732: iload 26
    //   1734: i2f
    //   1735: fdiv
    //   1736: fstore 19
    //   1738: iload 30
    //   1740: ifeq +101 -> 1841
    //   1743: iload 30
    //   1745: i2f
    //   1746: iload 27
    //   1748: i2f
    //   1749: fdiv
    //   1750: fstore 20
    //   1752: fload 19
    //   1754: fload 20
    //   1756: fcmpg
    //   1757: ifge +96 -> 1853
    //   1760: iload 32
    //   1762: istore 25
    //   1764: iload 33
    //   1766: istore 24
    //   1768: iload 26
    //   1770: istore 23
    //   1772: iload 27
    //   1774: istore 22
    //   1776: iload 34
    //   1778: iload 26
    //   1780: iload 27
    //   1782: iload 29
    //   1784: iload 30
    //   1786: invokestatic 398	com/lantern/core/imageloader/a/c:a	(ZIIII)Z
    //   1789: ifeq -654 -> 1135
    //   1792: aload 40
    //   1794: fload 19
    //   1796: fload 19
    //   1798: invokevirtual 401	android/graphics/Matrix:preScale	(FF)Z
    //   1801: pop
    //   1802: iload 32
    //   1804: istore 25
    //   1806: iload 33
    //   1808: istore 24
    //   1810: iload 26
    //   1812: istore 23
    //   1814: iload 27
    //   1816: istore 22
    //   1818: goto -683 -> 1135
    //   1821: astore 38
    //   1823: aload 41
    //   1825: monitorexit
    //   1826: aload 38
    //   1828: athrow
    //   1829: iload 30
    //   1831: i2f
    //   1832: iload 27
    //   1834: i2f
    //   1835: fdiv
    //   1836: fstore 19
    //   1838: goto -100 -> 1738
    //   1841: iload 29
    //   1843: i2f
    //   1844: iload 26
    //   1846: i2f
    //   1847: fdiv
    //   1848: fstore 20
    //   1850: goto -98 -> 1752
    //   1853: fload 20
    //   1855: fstore 19
    //   1857: goto -97 -> 1760
    //   1860: iload 29
    //   1862: ifne +24 -> 1886
    //   1865: iload 32
    //   1867: istore 25
    //   1869: iload 33
    //   1871: istore 24
    //   1873: iload 26
    //   1875: istore 23
    //   1877: iload 27
    //   1879: istore 22
    //   1881: iload 30
    //   1883: ifeq -748 -> 1135
    //   1886: iload 29
    //   1888: iload 26
    //   1890: if_icmpne +26 -> 1916
    //   1893: iload 32
    //   1895: istore 25
    //   1897: iload 33
    //   1899: istore 24
    //   1901: iload 26
    //   1903: istore 23
    //   1905: iload 27
    //   1907: istore 22
    //   1909: iload 30
    //   1911: iload 27
    //   1913: if_icmpeq -778 -> 1135
    //   1916: iload 29
    //   1918: ifeq +87 -> 2005
    //   1921: iload 29
    //   1923: i2f
    //   1924: iload 26
    //   1926: i2f
    //   1927: fdiv
    //   1928: fstore 19
    //   1930: iload 30
    //   1932: ifeq +85 -> 2017
    //   1935: iload 30
    //   1937: i2f
    //   1938: iload 27
    //   1940: i2f
    //   1941: fdiv
    //   1942: fstore 20
    //   1944: iload 32
    //   1946: istore 25
    //   1948: iload 33
    //   1950: istore 24
    //   1952: iload 26
    //   1954: istore 23
    //   1956: iload 27
    //   1958: istore 22
    //   1960: iload 34
    //   1962: iload 26
    //   1964: iload 27
    //   1966: iload 29
    //   1968: iload 30
    //   1970: invokestatic 398	com/lantern/core/imageloader/a/c:a	(ZIIII)Z
    //   1973: ifeq -838 -> 1135
    //   1976: aload 40
    //   1978: fload 19
    //   1980: fload 20
    //   1982: invokevirtual 401	android/graphics/Matrix:preScale	(FF)Z
    //   1985: pop
    //   1986: iload 32
    //   1988: istore 25
    //   1990: iload 33
    //   1992: istore 24
    //   1994: iload 26
    //   1996: istore 23
    //   1998: iload 27
    //   2000: istore 22
    //   2002: goto -867 -> 1135
    //   2005: iload 30
    //   2007: i2f
    //   2008: iload 27
    //   2010: i2f
    //   2011: fdiv
    //   2012: fstore 19
    //   2014: goto -84 -> 1930
    //   2017: iload 29
    //   2019: i2f
    //   2020: iload 26
    //   2022: i2f
    //   2023: fdiv
    //   2024: fstore 20
    //   2026: goto -82 -> 1944
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2029	0	this	c
    //   546	1014	1	d1	double
    //   625	947	3	d2	double
    //   695	853	5	d3	double
    //   650	894	7	d4	double
    //   556	1014	9	d5	double
    //   637	924	11	d6	double
    //   603	908	13	d7	double
    //   673	71	15	d8	double
    //   709	33	17	d9	double
    //   528	1485	19	f1	float
    //   1020	1005	20	f2	float
    //   1692	18	21	f3	float
    //   107	1894	22	i1	int
    //   498	1499	23	i2	int
    //   494	1499	24	i3	int
    //   490	1499	25	i4	int
    //   448	1573	26	i5	int
    //   455	1554	27	i6	int
    //   441	556	28	i7	int
    //   821	1197	29	i8	int
    //   817	1189	30	i9	int
    //   913	694	31	i10	int
    //   465	1522	32	i11	int
    //   468	1523	33	i12	int
    //   222	1739	34	bool1	boolean
    //   215	1099	35	bool2	boolean
    //   201	1146	36	l1	long
    //   1	1383	38	localObject1	Object
    //   1386	8	38	localObject2	Object
    //   1821	6	38	localObject3	Object
    //   53	1664	39	localObject4	Object
    //   26	1951	40	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   175	240	1386	finally
    //   243	250	1386	finally
    //   260	267	1386	finally
    //   272	301	1386	finally
    //   301	314	1386	finally
    //   1318	1351	1386	finally
    //   1351	1361	1386	finally
    //   1370	1386	1386	finally
    //   410	420	1821	finally
    //   424	431	1821	finally
    //   431	464	1821	finally
    //   470	488	1821	finally
    //   509	530	1821	finally
    //   537	815	1821	finally
    //   928	937	1821	finally
    //   982	992	1821	finally
    //   1000	1008	1821	finally
    //   1044	1069	1821	finally
    //   1085	1111	1821	finally
    //   1135	1153	1821	finally
    //   1164	1169	1821	finally
    //   1177	1202	1821	finally
    //   1210	1234	1821	finally
    //   1238	1266	1821	finally
    //   1270	1273	1821	finally
    //   1402	1579	1821	finally
    //   1643	1668	1821	finally
    //   1716	1724	1821	finally
    //   1776	1802	1821	finally
    //   1823	1826	1821	finally
    //   1960	1986	1821	finally
  }
  
  final void a(a parama)
  {
    int i5 = 1;
    int i4 = 0;
    boolean bool;
    if (this.k == parama)
    {
      this.k = null;
      bool = true;
    }
    for (;;)
    {
      int i1;
      int i3;
      label67:
      int i2;
      if ((bool) && (parama.b.p == this.s))
      {
        i1 = aa.e.a;
        if ((this.l != null) && (!this.l.isEmpty()))
        {
          i3 = 1;
          i2 = i5;
          if (this.k == null)
          {
            if (i3 == 0) {
              break label204;
            }
            i2 = i5;
          }
          label85:
          if (i2 == 0) {
            break label209;
          }
          if (this.k == null) {
            break label252;
          }
          i1 = this.k.b.p;
        }
      }
      label129:
      label204:
      label209:
      label249:
      label252:
      for (;;)
      {
        i2 = i1;
        if (i3 != 0)
        {
          i5 = this.l.size();
          i3 = i4;
          i2 = i1;
          if (i3 < i5)
          {
            i2 = ((a)this.l.get(i3)).b.p;
            if (i2 - 1 <= i1 - 1) {
              break label249;
            }
            i1 = i2;
          }
        }
        for (;;)
        {
          i3++;
          break label129;
          if (this.l == null) {
            break label255;
          }
          bool = this.l.remove(parama);
          break;
          i3 = 0;
          break label67;
          i2 = 0;
          break label85;
          i2 = i1;
          this.s = i2;
          if (this.b.l) {
            at.a("Hunter", "removed", parama.b.a(), at.a(this, "from "));
          }
          return;
        }
      }
      label255:
      bool = false;
    }
  }
  
  final boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.k == null) {
      if (this.l != null)
      {
        bool1 = bool2;
        if (!this.l.isEmpty()) {}
      }
      else
      {
        bool1 = bool2;
        if (this.n != null)
        {
          bool1 = bool2;
          if (this.n.cancel(false)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  final boolean b()
  {
    if ((this.n != null) && (this.n.isCancelled())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final void run()
  {
    for (;;)
    {
      try
      {
        localObject1 = this.g;
        if (((ag)localObject1).a != null)
        {
          localObject1 = String.valueOf(((ag)localObject1).a.getPath());
          localObject3 = (StringBuilder)u.get();
          ((StringBuilder)localObject3).ensureCapacity(((String)localObject1).length() + 8);
          ((StringBuilder)localObject3).replace(8, ((StringBuilder)localObject3).length(), (String)localObject1);
          Thread.currentThread().setName(((StringBuilder)localObject3).toString());
          if (this.b.l) {
            at.a("Hunter", "executing", at.a(this));
          }
          this.m = c();
          if (this.m != null) {
            continue;
          }
          this.c.b(this);
          return;
        }
      }
      catch (r.b localb)
      {
        Object localObject1;
        if ((localb.a) && (localb.b == 504)) {
          continue;
        }
        this.p = localb;
        this.c.b(this);
        Thread.currentThread().setName("Picasso-Idle");
        continue;
      }
      catch (z.a locala)
      {
        this.p = locala;
        this.c.a(this);
        Thread.currentThread().setName("Picasso-Idle");
        continue;
      }
      catch (IOException localIOException)
      {
        this.p = localIOException;
        this.c.a(this);
        Thread.currentThread().setName("Picasso-Idle");
        continue;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        Object localObject3 = new java/io/StringWriter;
        ((StringWriter)localObject3).<init>();
        Object localObject5 = this.e;
        Object localObject4 = new com/lantern/core/imageloader/a/am;
        ((am)localObject4).<init>(((ak)localObject5).b.b(), ((ak)localObject5).b.a(), ((ak)localObject5).d, ((ak)localObject5).e, ((ak)localObject5).f, ((ak)localObject5).g, ((ak)localObject5).h, ((ak)localObject5).i, ((ak)localObject5).j, ((ak)localObject5).k, ((ak)localObject5).l, ((ak)localObject5).m, ((ak)localObject5).n, System.currentTimeMillis());
        localObject5 = new java/io/PrintWriter;
        ((PrintWriter)localObject5).<init>((Writer)localObject3);
        ((PrintWriter)localObject5).println("===============BEGIN PICASSO STATS ===============");
        ((PrintWriter)localObject5).println("Memory Cache Stats");
        ((PrintWriter)localObject5).print("  Max Cache Size: ");
        ((PrintWriter)localObject5).println(((am)localObject4).a);
        ((PrintWriter)localObject5).print("  Cache Size: ");
        ((PrintWriter)localObject5).println(((am)localObject4).b);
        ((PrintWriter)localObject5).print("  Cache % Full: ");
        ((PrintWriter)localObject5).println((int)Math.ceil(((am)localObject4).b / ((am)localObject4).a * 100.0F));
        ((PrintWriter)localObject5).print("  Cache Hits: ");
        ((PrintWriter)localObject5).println(((am)localObject4).c);
        ((PrintWriter)localObject5).print("  Cache Misses: ");
        ((PrintWriter)localObject5).println(((am)localObject4).d);
        ((PrintWriter)localObject5).println("Network Stats");
        ((PrintWriter)localObject5).print("  Download Count: ");
        ((PrintWriter)localObject5).println(((am)localObject4).k);
        ((PrintWriter)localObject5).print("  Total Download Size: ");
        ((PrintWriter)localObject5).println(((am)localObject4).e);
        ((PrintWriter)localObject5).print("  Average Download Size: ");
        ((PrintWriter)localObject5).println(((am)localObject4).h);
        ((PrintWriter)localObject5).println("Bitmap Stats");
        ((PrintWriter)localObject5).print("  Total Bitmaps Decoded: ");
        ((PrintWriter)localObject5).println(((am)localObject4).l);
        ((PrintWriter)localObject5).print("  Total Bitmap Size: ");
        ((PrintWriter)localObject5).println(((am)localObject4).f);
        ((PrintWriter)localObject5).print("  Total Transformed Bitmaps: ");
        ((PrintWriter)localObject5).println(((am)localObject4).m);
        ((PrintWriter)localObject5).print("  Total Transformed Bitmap Size: ");
        ((PrintWriter)localObject5).println(((am)localObject4).g);
        ((PrintWriter)localObject5).print("  Average Bitmap Size: ");
        ((PrintWriter)localObject5).println(((am)localObject4).i);
        ((PrintWriter)localObject5).print("  Average Transformed Bitmap Size: ");
        ((PrintWriter)localObject5).println(((am)localObject4).j);
        ((PrintWriter)localObject5).println("===============END PICASSO STATS ===============");
        ((PrintWriter)localObject5).flush();
        localObject4 = new java/lang/RuntimeException;
        ((RuntimeException)localObject4).<init>(((StringWriter)localObject3).toString(), localOutOfMemoryError);
        this.p = ((Exception)localObject4);
        this.c.b(this);
        Thread.currentThread().setName("Picasso-Idle");
        continue;
      }
      catch (Exception localException)
      {
        this.p = localException;
        this.c.b(this);
        Thread.currentThread().setName("Picasso-Idle");
        continue;
      }
      finally
      {
        Thread.currentThread().setName("Picasso-Idle");
      }
      localObject1 = Integer.toHexString(((ag)localObject1).b);
      continue;
      localObject1 = this.c;
      ((p)localObject1).i.sendMessage(((p)localObject1).i.obtainMessage(4, this));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/imageloader/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */