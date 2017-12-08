package cm.pass.sdk.net;

import a.a.a.c.a;
import a.a.a.c.b;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import cm.pass.sdk.utils.j;
import cm.pass.sdk.utils.r;
import java.io.IOException;
import java.security.SecureRandom;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.X509TrustManager;

public class i
  extends a
{
  public static String a = "PostCommunicationSSL";
  private static int e = 5000;
  private static int f = 5000;
  private static MyX509TrustManager g = new MyX509TrustManager();
  private static MyHostnameVerifier h = new MyHostnameVerifier();
  cm.pass.sdk.utils.i b;
  Network c;
  
  public i(b paramb)
  {
    super(paramb);
  }
  
  /* Error */
  private void a(Network paramNetwork)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 7
    //   3: aconst_null
    //   4: astore 8
    //   6: aconst_null
    //   7: astore 6
    //   9: aconst_null
    //   10: astore 5
    //   12: getstatic 23	cm/pass/sdk/net/i:a	Ljava/lang/String;
    //   15: ldc 55
    //   17: invokestatic 60	cm/pass/sdk/utils/j:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   20: invokestatic 62	cm/pass/sdk/net/i:c	()V
    //   23: new 64	java/net/URL
    //   26: astore 4
    //   28: aload 4
    //   30: aload_0
    //   31: getfield 48	cm/pass/sdk/net/i:d	La/a/a/c/b;
    //   34: getfield 68	a/a/a/c/b:h	Ljava/lang/String;
    //   37: invokespecial 71	java/net/URL:<init>	(Ljava/lang/String;)V
    //   40: getstatic 23	cm/pass/sdk/net/i:a	Ljava/lang/String;
    //   43: astore 10
    //   45: new 73	java/lang/StringBuilder
    //   48: astore 9
    //   50: aload 9
    //   52: ldc 75
    //   54: invokespecial 76	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: aload 10
    //   59: aload 9
    //   61: aload_0
    //   62: getfield 48	cm/pass/sdk/net/i:d	La/a/a/c/b;
    //   65: getfield 68	a/a/a/c/b:h	Ljava/lang/String;
    //   68: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 86	cm/pass/sdk/utils/j:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   77: invokestatic 91	a/a/a/c/a/c:a	()La/a/a/c/a/c;
    //   80: invokevirtual 94	a/a/a/c/a/c:b	()La/a/a/c/a/b;
    //   83: astore 9
    //   85: getstatic 23	cm/pass/sdk/net/i:a	Ljava/lang/String;
    //   88: ldc 96
    //   90: invokestatic 60	cm/pass/sdk/utils/j:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: getstatic 101	android/os/Build$VERSION:SDK_INT	I
    //   96: bipush 21
    //   98: if_icmplt +156 -> 254
    //   101: aload_1
    //   102: ifnull +152 -> 254
    //   105: getstatic 23	cm/pass/sdk/net/i:a	Ljava/lang/String;
    //   108: ldc 103
    //   110: invokestatic 60	cm/pass/sdk/utils/j:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   113: aload_1
    //   114: aload 4
    //   116: invokevirtual 109	android/net/Network:openConnection	(Ljava/net/URL;)Ljava/net/URLConnection;
    //   119: checkcast 111	java/net/HttpURLConnection
    //   122: astore_1
    //   123: aload_0
    //   124: getfield 48	cm/pass/sdk/net/i:d	La/a/a/c/b;
    //   127: getfield 115	a/a/a/c/b:l	Ljava/util/Map;
    //   130: astore 4
    //   132: aload 4
    //   134: ifnull +223 -> 357
    //   137: aload 4
    //   139: invokeinterface 121 1 0
    //   144: ifne +213 -> 357
    //   147: aload 4
    //   149: invokeinterface 125 1 0
    //   154: invokeinterface 131 1 0
    //   159: astore 10
    //   161: aload 10
    //   163: invokeinterface 136 1 0
    //   168: ifeq +189 -> 357
    //   171: aload 10
    //   173: invokeinterface 140 1 0
    //   178: checkcast 142	java/lang/String
    //   181: astore 9
    //   183: aload_1
    //   184: aload 9
    //   186: aload 4
    //   188: aload 9
    //   190: invokeinterface 146 2 0
    //   195: checkcast 142	java/lang/String
    //   198: invokevirtual 149	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   201: goto -40 -> 161
    //   204: astore 7
    //   206: aconst_null
    //   207: astore 4
    //   209: aload 4
    //   211: astore 9
    //   213: aload 5
    //   215: astore 6
    //   217: aload_1
    //   218: astore 8
    //   220: aload 7
    //   222: invokevirtual 152	java/lang/Exception:printStackTrace	()V
    //   225: aload 5
    //   227: ifnull +8 -> 235
    //   230: aload 5
    //   232: invokevirtual 157	java/io/InputStream:close	()V
    //   235: aload 4
    //   237: ifnull +8 -> 245
    //   240: aload 4
    //   242: invokevirtual 160	java/io/OutputStream:close	()V
    //   245: aload_1
    //   246: ifnull +7 -> 253
    //   249: aload_1
    //   250: invokevirtual 163	java/net/HttpURLConnection:disconnect	()V
    //   253: return
    //   254: getstatic 23	cm/pass/sdk/net/i:a	Ljava/lang/String;
    //   257: ldc -91
    //   259: invokestatic 60	cm/pass/sdk/utils/j:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload 9
    //   264: ifnull +26 -> 290
    //   267: aload 9
    //   269: getfield 168	a/a/a/c/a/b:a	Ljava/lang/String;
    //   272: astore_1
    //   273: aload_1
    //   274: ifnull +10 -> 284
    //   277: aload_1
    //   278: invokevirtual 172	java/lang/String:length	()I
    //   281: ifne +21 -> 302
    //   284: iconst_1
    //   285: istore_2
    //   286: iload_2
    //   287: ifne +20 -> 307
    //   290: aload 4
    //   292: invokevirtual 175	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   295: checkcast 111	java/net/HttpURLConnection
    //   298: astore_1
    //   299: goto -176 -> 123
    //   302: iconst_0
    //   303: istore_2
    //   304: goto -18 -> 286
    //   307: new 177	java/net/Proxy
    //   310: astore_1
    //   311: getstatic 183	java/net/Proxy$Type:HTTP	Ljava/net/Proxy$Type;
    //   314: astore 10
    //   316: new 185	java/net/InetSocketAddress
    //   319: astore 11
    //   321: aload 11
    //   323: aload 9
    //   325: getfield 168	a/a/a/c/a/b:a	Ljava/lang/String;
    //   328: aload 9
    //   330: getfield 187	a/a/a/c/a/b:b	I
    //   333: invokespecial 190	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   336: aload_1
    //   337: aload 10
    //   339: aload 11
    //   341: invokespecial 193	java/net/Proxy:<init>	(Ljava/net/Proxy$Type;Ljava/net/SocketAddress;)V
    //   344: aload 4
    //   346: aload_1
    //   347: invokevirtual 196	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   350: checkcast 111	java/net/HttpURLConnection
    //   353: astore_1
    //   354: goto -231 -> 123
    //   357: aload_1
    //   358: ldc -58
    //   360: ldc -56
    //   362: invokevirtual 149	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   365: aload_1
    //   366: getstatic 25	cm/pass/sdk/net/i:e	I
    //   369: invokevirtual 204	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   372: aload_1
    //   373: getstatic 27	cm/pass/sdk/net/i:f	I
    //   376: invokevirtual 207	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   379: aload_1
    //   380: ldc -47
    //   382: invokevirtual 212	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   385: aload_1
    //   386: iconst_1
    //   387: invokevirtual 216	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   390: aload_1
    //   391: invokevirtual 220	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   394: astore 4
    //   396: aload 8
    //   398: astore 5
    //   400: aload_0
    //   401: getfield 48	cm/pass/sdk/net/i:d	La/a/a/c/b;
    //   404: invokevirtual 222	a/a/a/c/b:e	()Ljava/lang/String;
    //   407: ifnull +67 -> 474
    //   410: aload 8
    //   412: astore 5
    //   414: ldc -32
    //   416: aload_0
    //   417: getfield 48	cm/pass/sdk/net/i:d	La/a/a/c/b;
    //   420: invokevirtual 222	a/a/a/c/b:e	()Ljava/lang/String;
    //   423: invokevirtual 227	java/lang/String:trim	()Ljava/lang/String;
    //   426: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   429: ifne +45 -> 474
    //   432: aload 8
    //   434: astore 5
    //   436: aload_0
    //   437: getfield 48	cm/pass/sdk/net/i:d	La/a/a/c/b;
    //   440: invokevirtual 222	a/a/a/c/b:e	()Ljava/lang/String;
    //   443: ldc -23
    //   445: invokevirtual 237	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   448: astore 6
    //   450: aload 8
    //   452: astore 5
    //   454: aload 4
    //   456: aload 6
    //   458: iconst_0
    //   459: aload 6
    //   461: arraylength
    //   462: invokevirtual 241	java/io/OutputStream:write	([BII)V
    //   465: aload 8
    //   467: astore 5
    //   469: aload 4
    //   471: invokevirtual 244	java/io/OutputStream:flush	()V
    //   474: aload 8
    //   476: astore 5
    //   478: aload_1
    //   479: invokevirtual 247	java/net/HttpURLConnection:getResponseCode	()I
    //   482: istore_3
    //   483: aload 8
    //   485: astore 5
    //   487: aload_0
    //   488: getfield 48	cm/pass/sdk/net/i:d	La/a/a/c/b;
    //   491: iload_3
    //   492: putfield 250	a/a/a/c/b:k	I
    //   495: iload_3
    //   496: sipush 200
    //   499: if_icmpeq +161 -> 660
    //   502: aload 8
    //   504: astore 5
    //   506: aload_0
    //   507: getfield 48	cm/pass/sdk/net/i:d	La/a/a/c/b;
    //   510: ldc -4
    //   512: putfield 255	a/a/a/c/b:j	Ljava/lang/String;
    //   515: aload 7
    //   517: astore 5
    //   519: aload 4
    //   521: astore 9
    //   523: aload 7
    //   525: astore 6
    //   527: aload_1
    //   528: astore 8
    //   530: getstatic 23	cm/pass/sdk/net/i:a	Ljava/lang/String;
    //   533: astore 10
    //   535: aload 7
    //   537: astore 5
    //   539: aload 4
    //   541: astore 9
    //   543: aload 7
    //   545: astore 6
    //   547: aload_1
    //   548: astore 8
    //   550: new 73	java/lang/StringBuilder
    //   553: astore 11
    //   555: aload 7
    //   557: astore 5
    //   559: aload 4
    //   561: astore 9
    //   563: aload 7
    //   565: astore 6
    //   567: aload_1
    //   568: astore 8
    //   570: aload 11
    //   572: ldc_w 257
    //   575: invokespecial 76	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   578: aload 7
    //   580: astore 5
    //   582: aload 4
    //   584: astore 9
    //   586: aload 7
    //   588: astore 6
    //   590: aload_1
    //   591: astore 8
    //   593: aload 10
    //   595: aload 11
    //   597: iload_3
    //   598: invokevirtual 260	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   601: ldc_w 262
    //   604: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: aload_0
    //   608: getfield 48	cm/pass/sdk/net/i:d	La/a/a/c/b;
    //   611: getfield 265	a/a/a/c/b:m	Ljava/lang/String;
    //   614: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: ldc_w 267
    //   620: invokevirtual 80	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: invokestatic 60	cm/pass/sdk/utils/j:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   629: aload 7
    //   631: ifnull +8 -> 639
    //   634: aload 7
    //   636: invokevirtual 157	java/io/InputStream:close	()V
    //   639: aload 4
    //   641: ifnull +8 -> 649
    //   644: aload 4
    //   646: invokevirtual 160	java/io/OutputStream:close	()V
    //   649: aload_1
    //   650: ifnull -397 -> 253
    //   653: aload_1
    //   654: invokevirtual 163	java/net/HttpURLConnection:disconnect	()V
    //   657: goto -404 -> 253
    //   660: aload 8
    //   662: astore 5
    //   664: aload_0
    //   665: getfield 48	cm/pass/sdk/net/i:d	La/a/a/c/b;
    //   668: aload_1
    //   669: invokevirtual 271	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   672: putfield 274	a/a/a/c/b:n	Ljava/util/Map;
    //   675: aload 8
    //   677: astore 5
    //   679: aload_1
    //   680: invokevirtual 278	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   683: astore 7
    //   685: aload 7
    //   687: astore 5
    //   689: aload 4
    //   691: astore 9
    //   693: aload 7
    //   695: astore 6
    //   697: aload_1
    //   698: astore 8
    //   700: aload_0
    //   701: getfield 48	cm/pass/sdk/net/i:d	La/a/a/c/b;
    //   704: getfield 274	a/a/a/c/b:n	Ljava/util/Map;
    //   707: invokevirtual 281	java/lang/Object:toString	()Ljava/lang/String;
    //   710: astore 10
    //   712: aload 10
    //   714: ifnull +417 -> 1131
    //   717: aload 7
    //   719: astore 5
    //   721: aload 4
    //   723: astore 9
    //   725: aload 7
    //   727: astore 6
    //   729: aload_1
    //   730: astore 8
    //   732: aload 10
    //   734: invokevirtual 284	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   737: ldc_w 286
    //   740: invokevirtual 290	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   743: iconst_m1
    //   744: if_icmpeq +387 -> 1131
    //   747: iconst_1
    //   748: istore_2
    //   749: iload_2
    //   750: ifeq +200 -> 950
    //   753: aload 7
    //   755: astore 5
    //   757: aload 4
    //   759: astore 9
    //   761: aload 7
    //   763: astore 6
    //   765: aload_1
    //   766: astore 8
    //   768: aload 7
    //   770: invokestatic 295	a/a/a/b/a:b	(Ljava/io/InputStream;)[B
    //   773: astore 10
    //   775: aload 10
    //   777: astore 5
    //   779: aload 5
    //   781: astore 10
    //   783: aload 5
    //   785: ifnonnull +23 -> 808
    //   788: aload 7
    //   790: astore 5
    //   792: aload 4
    //   794: astore 9
    //   796: aload 7
    //   798: astore 6
    //   800: aload_1
    //   801: astore 8
    //   803: iconst_0
    //   804: newarray <illegal type>
    //   806: astore 10
    //   808: aload 7
    //   810: astore 5
    //   812: aload 4
    //   814: astore 9
    //   816: aload 7
    //   818: astore 6
    //   820: aload_1
    //   821: astore 8
    //   823: aload_0
    //   824: getfield 48	cm/pass/sdk/net/i:d	La/a/a/c/b;
    //   827: astore 12
    //   829: aload 7
    //   831: astore 5
    //   833: aload 4
    //   835: astore 9
    //   837: aload 7
    //   839: astore 6
    //   841: aload_1
    //   842: astore 8
    //   844: new 142	java/lang/String
    //   847: astore 11
    //   849: aload 7
    //   851: astore 5
    //   853: aload 4
    //   855: astore 9
    //   857: aload 7
    //   859: astore 6
    //   861: aload_1
    //   862: astore 8
    //   864: aload 11
    //   866: aload 10
    //   868: ldc -23
    //   870: invokespecial 298	java/lang/String:<init>	([BLjava/lang/String;)V
    //   873: aload 7
    //   875: astore 5
    //   877: aload 4
    //   879: astore 9
    //   881: aload 7
    //   883: astore 6
    //   885: aload_1
    //   886: astore 8
    //   888: aload 12
    //   890: aload 11
    //   892: putfield 265	a/a/a/c/b:m	Ljava/lang/String;
    //   895: aload 7
    //   897: astore 5
    //   899: aload 4
    //   901: astore 9
    //   903: aload 7
    //   905: astore 6
    //   907: aload_1
    //   908: astore 8
    //   910: aload_0
    //   911: getfield 48	cm/pass/sdk/net/i:d	La/a/a/c/b;
    //   914: ldc_w 300
    //   917: putfield 255	a/a/a/c/b:j	Ljava/lang/String;
    //   920: aload 7
    //   922: astore 5
    //   924: aload 4
    //   926: astore 9
    //   928: aload 7
    //   930: astore 6
    //   932: aload_1
    //   933: astore 8
    //   935: aload_0
    //   936: getfield 48	cm/pass/sdk/net/i:d	La/a/a/c/b;
    //   939: invokevirtual 302	a/a/a/c/b:f	()V
    //   942: goto -427 -> 515
    //   945: astore 7
    //   947: goto -738 -> 209
    //   950: aload 7
    //   952: astore 5
    //   954: aload 4
    //   956: astore 9
    //   958: aload 7
    //   960: astore 6
    //   962: aload_1
    //   963: astore 8
    //   965: aload 7
    //   967: invokestatic 304	a/a/a/b/a:a	(Ljava/io/InputStream;)[B
    //   970: astore 10
    //   972: aload 10
    //   974: astore 5
    //   976: goto -197 -> 779
    //   979: astore 5
    //   981: aload 5
    //   983: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   986: goto -347 -> 639
    //   989: astore 4
    //   991: aload 4
    //   993: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   996: goto -347 -> 649
    //   999: astore 5
    //   1001: aload 5
    //   1003: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   1006: goto -771 -> 235
    //   1009: astore 4
    //   1011: aload 4
    //   1013: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   1016: goto -771 -> 245
    //   1019: astore 4
    //   1021: aconst_null
    //   1022: astore 5
    //   1024: aconst_null
    //   1025: astore_1
    //   1026: aload 5
    //   1028: ifnull +8 -> 1036
    //   1031: aload 5
    //   1033: invokevirtual 157	java/io/InputStream:close	()V
    //   1036: aload 6
    //   1038: ifnull +8 -> 1046
    //   1041: aload 6
    //   1043: invokevirtual 160	java/io/OutputStream:close	()V
    //   1046: aload_1
    //   1047: ifnull +7 -> 1054
    //   1050: aload_1
    //   1051: invokevirtual 163	java/net/HttpURLConnection:disconnect	()V
    //   1054: aload 4
    //   1056: athrow
    //   1057: astore 5
    //   1059: aload 5
    //   1061: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   1064: goto -28 -> 1036
    //   1067: astore 5
    //   1069: aload 5
    //   1071: invokevirtual 305	java/io/IOException:printStackTrace	()V
    //   1074: goto -28 -> 1046
    //   1077: astore 4
    //   1079: aconst_null
    //   1080: astore 5
    //   1082: goto -56 -> 1026
    //   1085: astore 5
    //   1087: aconst_null
    //   1088: astore 7
    //   1090: aload 4
    //   1092: astore 6
    //   1094: aload 5
    //   1096: astore 4
    //   1098: aload 7
    //   1100: astore 5
    //   1102: goto -76 -> 1026
    //   1105: astore 4
    //   1107: aload 6
    //   1109: astore 5
    //   1111: aload 9
    //   1113: astore 6
    //   1115: aload 8
    //   1117: astore_1
    //   1118: goto -92 -> 1026
    //   1121: astore 7
    //   1123: aconst_null
    //   1124: astore 4
    //   1126: aconst_null
    //   1127: astore_1
    //   1128: goto -919 -> 209
    //   1131: iconst_0
    //   1132: istore_2
    //   1133: goto -384 -> 749
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1136	0	this	i
    //   0	1136	1	paramNetwork	Network
    //   285	848	2	i	int
    //   482	116	3	j	int
    //   26	929	4	localObject1	Object
    //   989	3	4	localIOException1	IOException
    //   1009	3	4	localIOException2	IOException
    //   1019	36	4	localObject2	Object
    //   1077	14	4	localObject3	Object
    //   1096	1	4	localObject4	Object
    //   1105	1	4	localObject5	Object
    //   1124	1	4	localObject6	Object
    //   10	965	5	localObject7	Object
    //   979	3	5	localIOException3	IOException
    //   999	3	5	localIOException4	IOException
    //   1022	10	5	localObject8	Object
    //   1057	3	5	localIOException5	IOException
    //   1067	3	5	localIOException6	IOException
    //   1080	1	5	localObject9	Object
    //   1085	10	5	localObject10	Object
    //   1100	10	5	localObject11	Object
    //   7	1107	6	localObject12	Object
    //   1	1	7	localObject13	Object
    //   204	431	7	localException1	Exception
    //   683	246	7	localInputStream	java.io.InputStream
    //   945	21	7	localException2	Exception
    //   1088	11	7	localObject14	Object
    //   1121	1	7	localException3	Exception
    //   4	1112	8	localNetwork	Network
    //   48	1064	9	localObject15	Object
    //   43	930	10	localObject16	Object
    //   319	572	11	localObject17	Object
    //   827	62	12	localb	b
    // Exception table:
    //   from	to	target	type
    //   123	132	204	java/lang/Exception
    //   137	161	204	java/lang/Exception
    //   161	201	204	java/lang/Exception
    //   357	396	204	java/lang/Exception
    //   400	410	945	java/lang/Exception
    //   414	432	945	java/lang/Exception
    //   436	450	945	java/lang/Exception
    //   454	465	945	java/lang/Exception
    //   469	474	945	java/lang/Exception
    //   478	483	945	java/lang/Exception
    //   487	495	945	java/lang/Exception
    //   506	515	945	java/lang/Exception
    //   530	535	945	java/lang/Exception
    //   550	555	945	java/lang/Exception
    //   570	578	945	java/lang/Exception
    //   593	629	945	java/lang/Exception
    //   664	675	945	java/lang/Exception
    //   679	685	945	java/lang/Exception
    //   700	712	945	java/lang/Exception
    //   732	747	945	java/lang/Exception
    //   768	775	945	java/lang/Exception
    //   803	808	945	java/lang/Exception
    //   823	829	945	java/lang/Exception
    //   844	849	945	java/lang/Exception
    //   864	873	945	java/lang/Exception
    //   888	895	945	java/lang/Exception
    //   910	920	945	java/lang/Exception
    //   935	942	945	java/lang/Exception
    //   965	972	945	java/lang/Exception
    //   634	639	979	java/io/IOException
    //   644	649	989	java/io/IOException
    //   230	235	999	java/io/IOException
    //   240	245	1009	java/io/IOException
    //   23	101	1019	finally
    //   105	123	1019	finally
    //   254	262	1019	finally
    //   267	273	1019	finally
    //   277	284	1019	finally
    //   290	299	1019	finally
    //   307	354	1019	finally
    //   1031	1036	1057	java/io/IOException
    //   1041	1046	1067	java/io/IOException
    //   123	132	1077	finally
    //   137	161	1077	finally
    //   161	201	1077	finally
    //   357	396	1077	finally
    //   400	410	1085	finally
    //   414	432	1085	finally
    //   436	450	1085	finally
    //   454	465	1085	finally
    //   469	474	1085	finally
    //   478	483	1085	finally
    //   487	495	1085	finally
    //   506	515	1085	finally
    //   664	675	1085	finally
    //   679	685	1085	finally
    //   220	225	1105	finally
    //   530	535	1105	finally
    //   550	555	1105	finally
    //   570	578	1105	finally
    //   593	629	1105	finally
    //   700	712	1105	finally
    //   732	747	1105	finally
    //   768	775	1105	finally
    //   803	808	1105	finally
    //   823	829	1105	finally
    //   844	849	1105	finally
    //   864	873	1105	finally
    //   888	895	1105	finally
    //   910	920	1105	finally
    //   935	942	1105	finally
    //   965	972	1105	finally
    //   23	101	1121	java/lang/Exception
    //   105	123	1121	java/lang/Exception
    //   254	262	1121	java/lang/Exception
    //   267	273	1121	java/lang/Exception
    //   277	284	1121	java/lang/Exception
    //   290	299	1121	java/lang/Exception
    //   307	354	1121	java/lang/Exception
  }
  
  private static void c()
  {
    Object localObject = null;
    try
    {
      SSLContext localSSLContext = SSLContext.getInstance("SSL");
      localObject = localSSLContext;
      MyX509TrustManager localMyX509TrustManager = g;
      localObject = localSSLContext;
      SecureRandom localSecureRandom = new java/security/SecureRandom;
      localObject = localSSLContext;
      localSecureRandom.<init>();
      localObject = localSSLContext;
      localSSLContext.init(null, new X509TrustManager[] { localMyX509TrustManager }, localSecureRandom);
      localObject = localSSLContext;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    if (localObject != null) {
      HttpsURLConnection.setDefaultSSLSocketFactory(((SSLContext)localObject).getSocketFactory());
    }
    HttpsURLConnection.setDefaultHostnameVerifier(h);
  }
  
  protected void a()
  {
    int i = 0;
    this.b = cm.pass.sdk.utils.i.a(null);
    j.c(a, "send");
    if (r.a()) {
      if (Build.VERSION.SDK_INT >= 21)
      {
        this.c = cm.pass.sdk.utils.i.a();
        if (this.c == null) {
          cm.pass.sdk.utils.i.a(new i.1(this));
        }
      }
    }
    for (;;)
    {
      return;
      a(this.c);
      this.d.h();
      continue;
      cm.pass.sdk.utils.i.a.startUsingNetworkFeature(0, "enableHIPRI");
      for (;;)
      {
        if (i < 30) {
          try
          {
            if (cm.pass.sdk.utils.i.a.getNetworkInfo(5).getState().compareTo(NetworkInfo.State.CONNECTED) != 0)
            {
              Thread.sleep(1000L);
              i++;
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            j.a(a, "check hipri failed");
          }
        }
      }
      i = cm.pass.sdk.utils.i.a(cm.pass.sdk.utils.i.b(this.d.h));
      boolean bool = cm.pass.sdk.utils.i.a.requestRouteToHost(5, i);
      j.c(a, "切换数据网络结果 >>> " + bool);
      if (bool)
      {
        a(null);
        j.c(a, "sendrequest");
        this.d.h();
      }
      else
      {
        j.a(a, "切换网络失败or无数据网络");
        this.d.h();
        continue;
        a(null);
        this.d.h();
      }
    }
  }
  
  protected void a(IOException paramIOException)
  {
    paramIOException.printStackTrace();
    paramIOException = paramIOException.getMessage();
    if ((paramIOException != null) && (paramIOException.indexOf("Connection timed out") >= 0)) {
      this.d.j = "网络超时";
    }
    for (;;)
    {
      return;
      if ((paramIOException != null) && (paramIOException.indexOf("Connection refused") >= 0)) {
        this.d.j = "服务器错误";
      } else {
        this.d.j = "网络错误";
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */