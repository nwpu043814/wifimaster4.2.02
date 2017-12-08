package com.lantern.wifiseccheck.vpn.server;

import c.a.a.f;
import com.lantern.wifiseccheck.LogUtils;
import com.lantern.wifiseccheck.protocol.AppBaseAttr;
import com.lantern.wifiseccheck.protocol.AuthProtocolRequest;
import com.lantern.wifiseccheck.protocol.AuthProtocolResult;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SafeAuthServerImpl
{
  private static String PATTERN_IP = "(\\d*\\.){3}\\d*";
  private static int PUBLIC_KEY_NUMBER_VPN_AUTH = 1;
  private ArrayList<String> inetAddressList;
  private double m_adContentVer;
  private int m_appVersion;
  private AppBaseAttr m_baseAttr;
  private String m_channel;
  private double m_clientDnsHelperVer;
  private double m_disallowedApplicationVer;
  private final SafeAuthServer m_serverSet;
  private String m_url;
  private double m_vpnRuleVer;
  
  SafeAuthServerImpl(SafeAuthServer paramSafeAuthServer)
  {
    this.m_serverSet = paramSafeAuthServer;
  }
  
  /* Error */
  private AuthProtocolResult getAuthProtocolRequest(String paramString, AuthProtocolResult paramAuthProtocolResult, AuthProtocolRequest paramAuthProtocolRequest)
  {
    // Byte code:
    //   0: ldc 62
    //   2: new 64	java/lang/StringBuilder
    //   5: dup
    //   6: ldc 66
    //   8: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   11: aload_1
    //   12: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   18: invokestatic 83	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: new 85	java/net/URL
    //   24: astore 5
    //   26: aload 5
    //   28: aload_1
    //   29: invokespecial 86	java/net/URL:<init>	(Ljava/lang/String;)V
    //   32: aload 5
    //   34: invokevirtual 90	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   37: checkcast 92	java/net/HttpURLConnection
    //   40: astore 5
    //   42: aload 5
    //   44: ldc 94
    //   46: invokevirtual 97	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   49: aload 5
    //   51: iconst_1
    //   52: invokevirtual 101	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   55: aload 5
    //   57: iconst_1
    //   58: invokevirtual 104	java/net/HttpURLConnection:setDoInput	(Z)V
    //   61: aload 5
    //   63: sipush 5000
    //   66: invokevirtual 108	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   69: aload 5
    //   71: sipush 5000
    //   74: invokevirtual 111	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   77: aload 5
    //   79: ldc 113
    //   81: ldc 115
    //   83: invokevirtual 118	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload 5
    //   88: iconst_0
    //   89: invokevirtual 121	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   92: aload_3
    //   93: invokestatic 127	com/alibaba/fastjson/JSON:toJSONString	(Ljava/lang/Object;)Ljava/lang/String;
    //   96: astore_1
    //   97: new 64	java/lang/StringBuilder
    //   100: astore_3
    //   101: aload_3
    //   102: ldc -127
    //   104: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   107: ldc 62
    //   109: aload_3
    //   110: aload_1
    //   111: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 83	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: new 131	com/lantern/wifiseccheck/vpn/server/AuthInfoChiper
    //   123: astore 6
    //   125: aload 6
    //   127: invokespecial 132	com/lantern/wifiseccheck/vpn/server/AuthInfoChiper:<init>	()V
    //   130: aload 6
    //   132: aload_1
    //   133: getstatic 27	com/lantern/wifiseccheck/vpn/server/SafeAuthServerImpl:PUBLIC_KEY_NUMBER_VPN_AUTH	I
    //   136: invokevirtual 136	com/lantern/wifiseccheck/vpn/server/AuthInfoChiper:getReqeustContent	(Ljava/lang/String;I)[B
    //   139: astore_1
    //   140: new 64	java/lang/StringBuilder
    //   143: astore 7
    //   145: aload 7
    //   147: ldc -118
    //   149: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   152: new 140	java/lang/String
    //   155: astore_3
    //   156: aload_3
    //   157: aload_1
    //   158: invokespecial 143	java/lang/String:<init>	([B)V
    //   161: ldc 62
    //   163: aload 7
    //   165: aload_3
    //   166: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   172: invokestatic 83	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   175: aload 5
    //   177: invokevirtual 147	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   180: astore_3
    //   181: aload_3
    //   182: aload_1
    //   183: invokevirtual 152	java/io/OutputStream:write	([B)V
    //   186: aload_3
    //   187: invokevirtual 155	java/io/OutputStream:flush	()V
    //   190: aload_3
    //   191: invokevirtual 158	java/io/OutputStream:close	()V
    //   194: aload 5
    //   196: invokevirtual 162	java/net/HttpURLConnection:getResponseCode	()I
    //   199: istore 4
    //   201: new 64	java/lang/StringBuilder
    //   204: astore_1
    //   205: aload_1
    //   206: ldc -92
    //   208: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   211: ldc 62
    //   213: aload_1
    //   214: iload 4
    //   216: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   219: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 83	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   225: iload 4
    //   227: sipush 200
    //   230: if_icmpeq +81 -> 311
    //   233: new 54	java/net/MalformedURLException
    //   236: astore_1
    //   237: new 64	java/lang/StringBuilder
    //   240: astore_3
    //   241: aload_3
    //   242: ldc -87
    //   244: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   247: aload_1
    //   248: aload_3
    //   249: iload 4
    //   251: invokevirtual 167	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   254: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokespecial 170	java/net/MalformedURLException:<init>	(Ljava/lang/String;)V
    //   260: aload_1
    //   261: athrow
    //   262: astore_1
    //   263: aload 5
    //   265: astore_3
    //   266: aload_1
    //   267: astore 5
    //   269: aload_3
    //   270: astore_1
    //   271: ldc 62
    //   273: aload 5
    //   275: invokevirtual 173	java/net/MalformedURLException:getMessage	()Ljava/lang/String;
    //   278: invokestatic 83	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: aload_3
    //   282: astore_1
    //   283: aload 5
    //   285: invokevirtual 176	java/net/MalformedURLException:printStackTrace	()V
    //   288: aload_3
    //   289: astore_1
    //   290: ldc -78
    //   292: ldc -76
    //   294: invokestatic 83	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: aload_2
    //   298: astore_1
    //   299: aload_3
    //   300: ifnull +9 -> 309
    //   303: aload_3
    //   304: invokevirtual 183	java/net/HttpURLConnection:disconnect	()V
    //   307: aload_2
    //   308: astore_1
    //   309: aload_1
    //   310: areturn
    //   311: aload 5
    //   313: ldc -71
    //   315: invokevirtual 189	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   318: astore_3
    //   319: aload_3
    //   320: ifnull +14 -> 334
    //   323: aload_3
    //   324: astore_1
    //   325: ldc -65
    //   327: aload_3
    //   328: invokevirtual 195	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   331: ifeq +6 -> 337
    //   334: ldc 115
    //   336: astore_1
    //   337: aload 5
    //   339: invokevirtual 199	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   342: astore 7
    //   344: new 201	java/io/InputStreamReader
    //   347: astore_3
    //   348: aload_3
    //   349: aload 7
    //   351: aload_1
    //   352: invokespecial 204	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   355: new 64	java/lang/StringBuilder
    //   358: astore_1
    //   359: aload_1
    //   360: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   363: aload_3
    //   364: invokevirtual 208	java/io/InputStreamReader:read	()I
    //   367: istore 4
    //   369: iload 4
    //   371: iconst_m1
    //   372: if_icmpeq +74 -> 446
    //   375: aload_1
    //   376: iload 4
    //   378: i2c
    //   379: invokevirtual 211	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: goto -20 -> 363
    //   386: astore_1
    //   387: aload 5
    //   389: astore_3
    //   390: aload_1
    //   391: astore 5
    //   393: aload_3
    //   394: astore_1
    //   395: ldc 62
    //   397: aload 5
    //   399: invokevirtual 212	java/io/IOException:getMessage	()Ljava/lang/String;
    //   402: invokestatic 83	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   405: aload_3
    //   406: astore_1
    //   407: aload 5
    //   409: invokevirtual 213	java/io/IOException:printStackTrace	()V
    //   412: aload_3
    //   413: astore_1
    //   414: ldc -78
    //   416: ldc -41
    //   418: invokestatic 83	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   421: aload_2
    //   422: astore_1
    //   423: aload_3
    //   424: ifnull -115 -> 309
    //   427: aload_3
    //   428: invokevirtual 183	java/net/HttpURLConnection:disconnect	()V
    //   431: aload_2
    //   432: astore_1
    //   433: goto -124 -> 309
    //   436: astore_1
    //   437: aload_1
    //   438: invokevirtual 216	java/lang/Exception:printStackTrace	()V
    //   441: aload_2
    //   442: astore_1
    //   443: goto -134 -> 309
    //   446: aload_1
    //   447: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: astore_1
    //   451: new 64	java/lang/StringBuilder
    //   454: astore_3
    //   455: aload_3
    //   456: ldc -38
    //   458: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   461: ldc 62
    //   463: aload_3
    //   464: aload_1
    //   465: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   471: invokestatic 83	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   474: aload 6
    //   476: aload_1
    //   477: invokevirtual 221	com/lantern/wifiseccheck/vpn/server/AuthInfoChiper:getResponseString	(Ljava/lang/String;)Ljava/lang/String;
    //   480: astore_3
    //   481: new 64	java/lang/StringBuilder
    //   484: astore_1
    //   485: aload_1
    //   486: ldc -33
    //   488: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   491: ldc 62
    //   493: aload_1
    //   494: aload_3
    //   495: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   501: invokestatic 83	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   504: aload_3
    //   505: invokestatic 229	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   508: ifne +275 -> 783
    //   511: aload_3
    //   512: ldc -25
    //   514: invokestatic 235	com/alibaba/fastjson/JSON:parseObject	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   517: checkcast 231	com/lantern/wifiseccheck/protocol/AuthProtocolResult
    //   520: astore_1
    //   521: new 64	java/lang/StringBuilder
    //   524: astore_2
    //   525: aload_2
    //   526: ldc -19
    //   528: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   531: ldc 62
    //   533: aload_2
    //   534: aload_1
    //   535: invokevirtual 241	com/lantern/wifiseccheck/protocol/AuthProtocolResult:getResult	()Lcom/lantern/wifiseccheck/protocol/AuthProtocolResult$AuthResult;
    //   538: invokevirtual 244	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   541: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokestatic 83	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   547: new 64	java/lang/StringBuilder
    //   550: astore_2
    //   551: aload_2
    //   552: ldc -10
    //   554: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   557: ldc 62
    //   559: aload_2
    //   560: aload_1
    //   561: invokevirtual 249	com/lantern/wifiseccheck/protocol/AuthProtocolResult:getVpnServer	()Ljava/lang/String;
    //   564: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokestatic 83	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   573: new 64	java/lang/StringBuilder
    //   576: astore_2
    //   577: aload_2
    //   578: ldc -5
    //   580: invokespecial 69	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   583: ldc 62
    //   585: aload_2
    //   586: aload_1
    //   587: invokevirtual 254	com/lantern/wifiseccheck/protocol/AuthProtocolResult:getDisallowedApplication	()Ljava/lang/String;
    //   590: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: invokestatic 83	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   599: aload 5
    //   601: ifnull +179 -> 780
    //   604: aload 5
    //   606: invokevirtual 183	java/net/HttpURLConnection:disconnect	()V
    //   609: goto -300 -> 309
    //   612: astore_2
    //   613: aload_2
    //   614: invokevirtual 216	java/lang/Exception:printStackTrace	()V
    //   617: goto -308 -> 309
    //   620: astore_1
    //   621: aload_1
    //   622: invokevirtual 216	java/lang/Exception:printStackTrace	()V
    //   625: aload_2
    //   626: astore_1
    //   627: goto -318 -> 309
    //   630: astore 5
    //   632: aconst_null
    //   633: astore_3
    //   634: aload_3
    //   635: astore_1
    //   636: ldc 62
    //   638: aload 5
    //   640: invokevirtual 255	com/alibaba/fastjson/JSONException:getMessage	()Ljava/lang/String;
    //   643: invokestatic 83	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   646: aload_3
    //   647: astore_1
    //   648: aload 5
    //   650: invokevirtual 256	com/alibaba/fastjson/JSONException:printStackTrace	()V
    //   653: aload_3
    //   654: astore_1
    //   655: ldc -78
    //   657: ldc_w 258
    //   660: invokestatic 83	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   663: aload_2
    //   664: astore_1
    //   665: aload_3
    //   666: ifnull -357 -> 309
    //   669: aload_3
    //   670: invokevirtual 183	java/net/HttpURLConnection:disconnect	()V
    //   673: aload_2
    //   674: astore_1
    //   675: goto -366 -> 309
    //   678: astore_1
    //   679: aload_1
    //   680: invokevirtual 216	java/lang/Exception:printStackTrace	()V
    //   683: aload_2
    //   684: astore_1
    //   685: goto -376 -> 309
    //   688: astore_2
    //   689: aconst_null
    //   690: astore_1
    //   691: aload_1
    //   692: ifnull +7 -> 699
    //   695: aload_1
    //   696: invokevirtual 183	java/net/HttpURLConnection:disconnect	()V
    //   699: aload_2
    //   700: athrow
    //   701: astore_1
    //   702: aload_1
    //   703: invokevirtual 216	java/lang/Exception:printStackTrace	()V
    //   706: goto -7 -> 699
    //   709: astore_2
    //   710: aload 5
    //   712: astore_1
    //   713: goto -22 -> 691
    //   716: astore_2
    //   717: goto -26 -> 691
    //   720: astore_1
    //   721: aload 5
    //   723: astore_3
    //   724: aload_1
    //   725: astore 5
    //   727: goto -93 -> 634
    //   730: astore_2
    //   731: aload 5
    //   733: astore_3
    //   734: aload_2
    //   735: astore 5
    //   737: aload_1
    //   738: astore_2
    //   739: goto -105 -> 634
    //   742: astore 5
    //   744: aconst_null
    //   745: astore_3
    //   746: goto -353 -> 393
    //   749: astore_2
    //   750: aload 5
    //   752: astore_3
    //   753: aload_2
    //   754: astore 5
    //   756: aload_1
    //   757: astore_2
    //   758: goto -365 -> 393
    //   761: astore 5
    //   763: aconst_null
    //   764: astore_3
    //   765: goto -496 -> 269
    //   768: astore_2
    //   769: aload 5
    //   771: astore_3
    //   772: aload_2
    //   773: astore 5
    //   775: aload_1
    //   776: astore_2
    //   777: goto -508 -> 269
    //   780: goto -471 -> 309
    //   783: aload_2
    //   784: astore_1
    //   785: goto -264 -> 521
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	788	0	this	SafeAuthServerImpl
    //   0	788	1	paramString	String
    //   0	788	2	paramAuthProtocolResult	AuthProtocolResult
    //   0	788	3	paramAuthProtocolRequest	AuthProtocolRequest
    //   199	178	4	i	int
    //   24	581	5	localObject1	Object
    //   630	92	5	localJSONException	com.alibaba.fastjson.JSONException
    //   725	11	5	localObject2	Object
    //   742	9	5	localIOException	java.io.IOException
    //   754	1	5	localAuthProtocolResult1	AuthProtocolResult
    //   761	9	5	localMalformedURLException	MalformedURLException
    //   773	1	5	localAuthProtocolResult2	AuthProtocolResult
    //   123	352	6	localAuthInfoChiper	AuthInfoChiper
    //   143	207	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   42	225	262	java/net/MalformedURLException
    //   233	262	262	java/net/MalformedURLException
    //   311	319	262	java/net/MalformedURLException
    //   325	334	262	java/net/MalformedURLException
    //   337	363	262	java/net/MalformedURLException
    //   363	369	262	java/net/MalformedURLException
    //   375	383	262	java/net/MalformedURLException
    //   446	521	262	java/net/MalformedURLException
    //   42	225	386	java/io/IOException
    //   233	262	386	java/io/IOException
    //   311	319	386	java/io/IOException
    //   325	334	386	java/io/IOException
    //   337	363	386	java/io/IOException
    //   363	369	386	java/io/IOException
    //   375	383	386	java/io/IOException
    //   446	521	386	java/io/IOException
    //   427	431	436	java/lang/Exception
    //   604	609	612	java/lang/Exception
    //   303	307	620	java/lang/Exception
    //   21	42	630	com/alibaba/fastjson/JSONException
    //   669	673	678	java/lang/Exception
    //   21	42	688	finally
    //   695	699	701	java/lang/Exception
    //   42	225	709	finally
    //   233	262	709	finally
    //   311	319	709	finally
    //   325	334	709	finally
    //   337	363	709	finally
    //   363	369	709	finally
    //   375	383	709	finally
    //   446	521	709	finally
    //   521	599	709	finally
    //   271	281	716	finally
    //   283	288	716	finally
    //   290	297	716	finally
    //   395	405	716	finally
    //   407	412	716	finally
    //   414	421	716	finally
    //   636	646	716	finally
    //   648	653	716	finally
    //   655	663	716	finally
    //   42	225	720	com/alibaba/fastjson/JSONException
    //   233	262	720	com/alibaba/fastjson/JSONException
    //   311	319	720	com/alibaba/fastjson/JSONException
    //   325	334	720	com/alibaba/fastjson/JSONException
    //   337	363	720	com/alibaba/fastjson/JSONException
    //   363	369	720	com/alibaba/fastjson/JSONException
    //   375	383	720	com/alibaba/fastjson/JSONException
    //   446	521	720	com/alibaba/fastjson/JSONException
    //   521	599	730	com/alibaba/fastjson/JSONException
    //   21	42	742	java/io/IOException
    //   521	599	749	java/io/IOException
    //   21	42	761	java/net/MalformedURLException
    //   521	599	768	java/net/MalformedURLException
  }
  
  private static boolean isIp(String paramString)
  {
    if (Pattern.compile(PATTERN_IP).matcher(paramString).find()) {
      LogUtils.d("safe", "[HttpUtil][getCookieDomain] match ip.");
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void startTask(AuthProtocolRequest paramAuthProtocolRequest)
  {
    new SafeAuthServerImpl.1(this, paramAuthProtocolRequest).start();
  }
  
  public void domainNameResolution(String paramString)
  {
    this.inetAddressList = new ArrayList();
    LogUtils.d("safe", "domainNameResolution domains:" + paramString);
    String str;
    try
    {
      localObject1 = new java/net/URL;
      ((URL)localObject1).<init>(paramString);
      localObject1 = ((URL)localObject1).getHost();
      paramString = paramString.replace((CharSequence)localObject1, "%s");
      LogUtils.d("safe", "domainNameResolution host:" + (String)localObject1);
      LogUtils.d("safe", "domainNameResolution after replace domains:" + paramString);
      if (!isIp((String)localObject1)) {
        LogUtils.d("safe", "domainNameResolution host is domain;");
      }
    }
    catch (MalformedURLException localMalformedURLException)
    {
      try
      {
        Object localObject1;
        InetAddress[] arrayOfInetAddress = f.b((String)localObject1);
        int i = 0;
        while (i < arrayOfInetAddress.length)
        {
          Object localObject2 = arrayOfInetAddress[i].getHostAddress();
          Object localObject3 = new java/lang/StringBuilder;
          ((StringBuilder)localObject3).<init>("domainNameResolution ipp:");
          LogUtils.d("safe", (String)localObject2);
          localObject3 = String.format(paramString, new Object[] { localObject2 });
          this.inetAddressList.add(localObject3);
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>("domainNameResolution remote_get_params_url:");
          LogUtils.d("safe", (String)localObject3);
          i++;
          continue;
          localMalformedURLException = localMalformedURLException;
          localMalformedURLException.printStackTrace();
          str = null;
        }
      }
      catch (UnknownHostException paramString)
      {
        LogUtils.d("safe", "domainNameResolution throw UnknownHostException:" + str + paramString.getMessage());
        paramString.printStackTrace();
      }
    }
    for (;;)
    {
      return;
      paramString = String.format(paramString, new Object[] { str });
      LogUtils.d("safe", "domainNameResolution host is ip;" + paramString);
      this.inetAddressList.add(paramString);
    }
  }
  
  public void request(String paramString1, String paramString2)
  {
    AuthProtocolRequest localAuthProtocolRequest = new AuthProtocolRequest();
    localAuthProtocolRequest.setUhid(paramString1);
    localAuthProtocolRequest.setDhid(paramString2);
    localAuthProtocolRequest.setChannel(this.m_channel);
    localAuthProtocolRequest.setVpnRuleVer(this.m_vpnRuleVer);
    localAuthProtocolRequest.setAppversion(this.m_appVersion);
    localAuthProtocolRequest.setClientDnsHelperVer(this.m_clientDnsHelperVer);
    localAuthProtocolRequest.setAdContentVer(this.m_adContentVer);
    localAuthProtocolRequest.setDisallowedApplicationVer(this.m_disallowedApplicationVer);
    localAuthProtocolRequest.setBaseAttr(this.m_baseAttr);
    startTask(localAuthProtocolRequest);
  }
  
  protected void requestCb(AuthProtocolResult paramAuthProtocolResult)
  {
    if (this.m_serverSet != null) {
      this.m_serverSet.requestCb(paramAuthProtocolResult);
    }
  }
  
  public void setAdContentVer(double paramDouble)
  {
    this.m_adContentVer = paramDouble;
  }
  
  void setAppVersion(int paramInt)
  {
    this.m_appVersion = paramInt;
  }
  
  public void setBaseAttr(AppBaseAttr paramAppBaseAttr)
  {
    this.m_baseAttr = paramAppBaseAttr;
  }
  
  public void setChannel(String paramString)
  {
    this.m_channel = paramString;
  }
  
  public void setClientDnsHelperVer(double paramDouble)
  {
    this.m_clientDnsHelperVer = paramDouble;
  }
  
  public void setDisallowedApplicationVer(double paramDouble)
  {
    this.m_disallowedApplicationVer = paramDouble;
  }
  
  void setRequestServerAddr(String paramString)
  {
    this.m_url = paramString;
  }
  
  void setVpnRule(double paramDouble)
  {
    this.m_vpnRuleVer = paramDouble;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/vpn/server/SafeAuthServerImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */