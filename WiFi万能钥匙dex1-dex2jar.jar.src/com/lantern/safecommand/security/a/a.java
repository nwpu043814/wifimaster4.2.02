package com.lantern.safecommand.security.a;

public final class a
{
  public static final Byte[] a = new Byte[0];
  private static String b = "RemoteApi";
  
  /* Error */
  public static com.lantern.wifiseccheck.protocol.appconf.AppConfRes a(android.content.Context paramContext)
  {
    // Byte code:
    //   0: new 24	com/lantern/wifiseccheck/protocol/appconf/AppConfReq
    //   3: dup
    //   4: invokespecial 27	com/lantern/wifiseccheck/protocol/appconf/AppConfReq:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: invokestatic 33	com/lantern/wifiseccheck/vpn/utils/VpnUtils:getInstance	()Lcom/lantern/wifiseccheck/vpn/utils/VpnUtils;
    //   12: invokevirtual 37	com/lantern/wifiseccheck/vpn/utils/VpnUtils:getLocalAppVersionCode	()I
    //   15: i2d
    //   16: invokevirtual 41	com/lantern/wifiseccheck/protocol/appconf/AppConfReq:setAppversion	(D)V
    //   19: aload_2
    //   20: invokestatic 33	com/lantern/wifiseccheck/vpn/utils/VpnUtils:getInstance	()Lcom/lantern/wifiseccheck/vpn/utils/VpnUtils;
    //   23: invokevirtual 45	com/lantern/wifiseccheck/vpn/utils/VpnUtils:getChannelId	()Ljava/lang/String;
    //   26: invokevirtual 49	com/lantern/wifiseccheck/protocol/appconf/AppConfReq:setChannel	(Ljava/lang/String;)V
    //   29: aload_2
    //   30: aload_0
    //   31: invokestatic 55	com/lantern/wifiseccheck/vpn/utils/UserUtils:getDhid	(Landroid/content/Context;)Ljava/lang/String;
    //   34: invokevirtual 58	com/lantern/wifiseccheck/protocol/appconf/AppConfReq:setDhid	(Ljava/lang/String;)V
    //   37: aload_2
    //   38: aload_0
    //   39: invokestatic 61	com/lantern/wifiseccheck/vpn/utils/UserUtils:getUhid	(Landroid/content/Context;)Ljava/lang/String;
    //   42: invokevirtual 64	com/lantern/wifiseccheck/protocol/appconf/AppConfReq:setUhid	(Ljava/lang/String;)V
    //   45: aload_2
    //   46: aload_0
    //   47: invokestatic 69	com/lantern/wifiseccheck/WifiUtils:getPhoneImei	(Landroid/content/Context;)Ljava/lang/String;
    //   50: invokevirtual 72	com/lantern/wifiseccheck/protocol/appconf/AppConfReq:setImei	(Ljava/lang/String;)V
    //   53: new 74	com/lantern/wifiseccheck/protocol/appconf/AppConfRes
    //   56: dup
    //   57: invokespecial 75	com/lantern/wifiseccheck/protocol/appconf/AppConfRes:<init>	()V
    //   60: astore_0
    //   61: aload_0
    //   62: getstatic 81	com/lantern/wifiseccheck/protocol/appconf/AppConfRes$ReturnCode:FAIL	Lcom/lantern/wifiseccheck/protocol/appconf/AppConfRes$ReturnCode;
    //   65: invokevirtual 85	com/lantern/wifiseccheck/protocol/appconf/AppConfRes:setReturnCode	(Lcom/lantern/wifiseccheck/protocol/appconf/AppConfRes$ReturnCode;)V
    //   68: new 87	com/lantern/wifiseccheck/Chiper
    //   71: dup
    //   72: getstatic 91	com/lantern/wifiseccheck/Chiper:PUBLIC_KEY_CONF	I
    //   75: invokespecial 94	com/lantern/wifiseccheck/Chiper:<init>	(I)V
    //   78: astore_1
    //   79: getstatic 14	com/lantern/safecommand/security/a/a:b	Ljava/lang/String;
    //   82: new 96	java/lang/StringBuilder
    //   85: dup
    //   86: ldc 98
    //   88: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   91: aload_2
    //   92: invokestatic 106	com/alibaba/fastjson/JSON:toJSONString	(Ljava/lang/Object;)Ljava/lang/String;
    //   95: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 119	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_1
    //   105: aload_2
    //   106: invokestatic 106	com/alibaba/fastjson/JSON:toJSONString	(Ljava/lang/Object;)Ljava/lang/String;
    //   109: iconst_0
    //   110: invokevirtual 123	com/lantern/wifiseccheck/Chiper:genReqeustContent	(Ljava/lang/String;Z)[B
    //   113: astore_2
    //   114: getstatic 14	com/lantern/safecommand/security/a/a:b	Ljava/lang/String;
    //   117: new 96	java/lang/StringBuilder
    //   120: dup
    //   121: ldc 125
    //   123: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   126: new 127	java/lang/String
    //   129: dup
    //   130: aload_2
    //   131: invokespecial 130	java/lang/String:<init>	([B)V
    //   134: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   137: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 119	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: ldc -124
    //   145: aload_2
    //   146: invokestatic 135	com/lantern/safecommand/security/a/a:a	(Ljava/lang/String;[B)[B
    //   149: astore 4
    //   151: aload 4
    //   153: ifnull +172 -> 325
    //   156: getstatic 14	com/lantern/safecommand/security/a/a:b	Ljava/lang/String;
    //   159: astore_3
    //   160: new 96	java/lang/StringBuilder
    //   163: astore_2
    //   164: aload_2
    //   165: ldc -119
    //   167: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   170: aload_3
    //   171: aload_2
    //   172: aload 4
    //   174: invokevirtual 138	java/lang/Object:toString	()Ljava/lang/String;
    //   177: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 119	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload_1
    //   187: aload 4
    //   189: iconst_0
    //   190: invokestatic 144	android/util/Base64:decode	([BI)[B
    //   193: invokevirtual 148	com/lantern/wifiseccheck/Chiper:getResponseString	([B)[B
    //   196: astore_2
    //   197: new 127	java/lang/String
    //   200: astore_1
    //   201: aload_1
    //   202: aload_2
    //   203: ldc -106
    //   205: invokespecial 153	java/lang/String:<init>	([BLjava/lang/String;)V
    //   208: aload_1
    //   209: ldc -106
    //   211: invokestatic 158	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   214: astore_2
    //   215: aload_2
    //   216: ldc 74
    //   218: invokestatic 162	com/alibaba/fastjson/JSON:parseObject	(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    //   221: checkcast 74	com/lantern/wifiseccheck/protocol/appconf/AppConfRes
    //   224: astore_1
    //   225: getstatic 14	com/lantern/safecommand/security/a/a:b	Ljava/lang/String;
    //   228: astore_3
    //   229: new 96	java/lang/StringBuilder
    //   232: astore_0
    //   233: aload_0
    //   234: ldc -92
    //   236: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   239: aload_3
    //   240: aload_0
    //   241: aload_2
    //   242: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 119	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: aload_1
    //   252: ifnull +12 -> 264
    //   255: aload_1
    //   256: invokevirtual 168	com/lantern/wifiseccheck/protocol/appconf/AppConfRes:getReturnCode	()Lcom/lantern/wifiseccheck/protocol/appconf/AppConfRes$ReturnCode;
    //   259: pop
    //   260: getstatic 171	com/lantern/wifiseccheck/protocol/appconf/AppConfRes$ReturnCode:SUCC	Lcom/lantern/wifiseccheck/protocol/appconf/AppConfRes$ReturnCode;
    //   263: astore_0
    //   264: getstatic 14	com/lantern/safecommand/security/a/a:b	Ljava/lang/String;
    //   267: astore_0
    //   268: new 96	java/lang/StringBuilder
    //   271: astore_2
    //   272: aload_2
    //   273: ldc -83
    //   275: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   278: aload_0
    //   279: aload_2
    //   280: aload_1
    //   281: invokevirtual 168	com/lantern/wifiseccheck/protocol/appconf/AppConfRes:getReturnCode	()Lcom/lantern/wifiseccheck/protocol/appconf/AppConfRes$ReturnCode;
    //   284: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   287: ldc -78
    //   289: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: aload_1
    //   293: invokevirtual 181	com/lantern/wifiseccheck/protocol/appconf/AppConfRes:getReturnReason	()Ljava/lang/String;
    //   296: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 119	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: aload_1
    //   306: astore_0
    //   307: aload_0
    //   308: areturn
    //   309: astore_1
    //   310: aload_1
    //   311: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   314: goto -7 -> 307
    //   317: astore_2
    //   318: aload_1
    //   319: astore_0
    //   320: aload_2
    //   321: astore_1
    //   322: goto -12 -> 310
    //   325: goto -18 -> 307
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	328	0	paramContext	android.content.Context
    //   78	228	1	localObject1	Object
    //   309	10	1	localException1	Exception
    //   321	1	1	localException2	Exception
    //   7	273	2	localObject2	Object
    //   317	4	2	localException3	Exception
    //   159	81	3	str	String
    //   149	39	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   143	151	309	java/lang/Exception
    //   156	225	309	java/lang/Exception
    //   225	251	317	java/lang/Exception
    //   255	264	317	java/lang/Exception
    //   264	305	317	java/lang/Exception
  }
  
  /* Error */
  private static byte[] a(String paramString, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 186	java/net/URL
    //   6: astore_3
    //   7: aload_3
    //   8: aload_0
    //   9: invokespecial 187	java/net/URL:<init>	(Ljava/lang/String;)V
    //   12: aload_3
    //   13: invokevirtual 191	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   16: checkcast 193	java/net/HttpURLConnection
    //   19: astore_3
    //   20: aload_3
    //   21: ldc -61
    //   23: invokevirtual 198	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   26: aload_3
    //   27: iconst_1
    //   28: invokevirtual 202	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   31: aload_3
    //   32: iconst_1
    //   33: invokevirtual 205	java/net/HttpURLConnection:setDoInput	(Z)V
    //   36: aload_3
    //   37: sipush 5000
    //   40: invokevirtual 208	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   43: aload_3
    //   44: sipush 5000
    //   47: invokevirtual 211	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   50: aload_3
    //   51: ldc -43
    //   53: ldc -41
    //   55: invokevirtual 218	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload_3
    //   59: iconst_0
    //   60: invokevirtual 221	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   63: getstatic 14	com/lantern/safecommand/security/a/a:b	Ljava/lang/String;
    //   66: astore 4
    //   68: new 96	java/lang/StringBuilder
    //   71: astore_0
    //   72: aload_0
    //   73: ldc -33
    //   75: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: aload 4
    //   80: aload_0
    //   81: aload_1
    //   82: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 119	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_3
    //   92: invokevirtual 227	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   95: astore_0
    //   96: aload_0
    //   97: aload_1
    //   98: invokevirtual 232	java/io/OutputStream:write	([B)V
    //   101: aload_0
    //   102: invokevirtual 235	java/io/OutputStream:flush	()V
    //   105: aload_0
    //   106: invokevirtual 238	java/io/OutputStream:close	()V
    //   109: aload_3
    //   110: invokevirtual 241	java/net/HttpURLConnection:getResponseCode	()I
    //   113: istore_2
    //   114: getstatic 14	com/lantern/safecommand/security/a/a:b	Ljava/lang/String;
    //   117: astore_0
    //   118: new 96	java/lang/StringBuilder
    //   121: astore_1
    //   122: aload_1
    //   123: ldc -13
    //   125: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   128: aload_0
    //   129: aload_1
    //   130: iload_2
    //   131: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   134: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 119	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: iload_2
    //   141: sipush 200
    //   144: if_icmpeq +58 -> 202
    //   147: new 248	java/net/MalformedURLException
    //   150: astore_0
    //   151: new 96	java/lang/StringBuilder
    //   154: astore_1
    //   155: aload_1
    //   156: ldc -6
    //   158: invokespecial 100	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: aload_0
    //   162: aload_1
    //   163: iload_2
    //   164: invokevirtual 246	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokespecial 251	java/net/MalformedURLException:<init>	(Ljava/lang/String;)V
    //   173: aload_0
    //   174: athrow
    //   175: astore_1
    //   176: aload_3
    //   177: astore_0
    //   178: getstatic 14	com/lantern/safecommand/security/a/a:b	Ljava/lang/String;
    //   181: ldc -3
    //   183: invokestatic 119	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   186: aload_1
    //   187: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   190: aload_0
    //   191: ifnull +113 -> 304
    //   194: aload_0
    //   195: invokevirtual 256	java/net/HttpURLConnection:disconnect	()V
    //   198: aconst_null
    //   199: astore_0
    //   200: aload_0
    //   201: areturn
    //   202: aload_3
    //   203: ldc_w 258
    //   206: invokevirtual 262	java/net/HttpURLConnection:getHeaderField	(Ljava/lang/String;)Ljava/lang/String;
    //   209: astore_0
    //   210: aload_0
    //   211: ifnull +11 -> 222
    //   214: ldc_w 264
    //   217: aload_0
    //   218: invokevirtual 268	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   221: pop
    //   222: invokestatic 273	com/lantern/wifiseccheck/GzipUtils:getInstance	()Lcom/lantern/wifiseccheck/GzipUtils;
    //   225: aload_3
    //   226: invokevirtual 277	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   229: invokevirtual 281	com/lantern/wifiseccheck/GzipUtils:toByteArray	(Ljava/io/InputStream;)[B
    //   232: astore_0
    //   233: aload_3
    //   234: ifnull +75 -> 309
    //   237: aload_3
    //   238: invokevirtual 256	java/net/HttpURLConnection:disconnect	()V
    //   241: goto -41 -> 200
    //   244: astore_1
    //   245: aload_1
    //   246: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   249: goto -49 -> 200
    //   252: astore_0
    //   253: aload_0
    //   254: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   257: aconst_null
    //   258: astore_0
    //   259: goto -59 -> 200
    //   262: astore_0
    //   263: aload 4
    //   265: astore_1
    //   266: aload_1
    //   267: ifnull +7 -> 274
    //   270: aload_1
    //   271: invokevirtual 256	java/net/HttpURLConnection:disconnect	()V
    //   274: aload_0
    //   275: athrow
    //   276: astore_1
    //   277: aload_1
    //   278: invokevirtual 184	java/lang/Exception:printStackTrace	()V
    //   281: goto -7 -> 274
    //   284: astore_0
    //   285: aload_3
    //   286: astore_1
    //   287: goto -21 -> 266
    //   290: astore_3
    //   291: aload_0
    //   292: astore_1
    //   293: aload_3
    //   294: astore_0
    //   295: goto -29 -> 266
    //   298: astore_1
    //   299: aconst_null
    //   300: astore_0
    //   301: goto -123 -> 178
    //   304: aconst_null
    //   305: astore_0
    //   306: goto -106 -> 200
    //   309: goto -109 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	paramString	String
    //   0	312	1	paramArrayOfByte	byte[]
    //   113	51	2	i	int
    //   6	280	3	localObject1	Object
    //   290	4	3	localObject2	Object
    //   1	263	4	str	String
    // Exception table:
    //   from	to	target	type
    //   20	140	175	java/lang/Exception
    //   147	175	175	java/lang/Exception
    //   202	210	175	java/lang/Exception
    //   214	222	175	java/lang/Exception
    //   222	233	175	java/lang/Exception
    //   237	241	244	java/lang/Exception
    //   194	198	252	java/lang/Exception
    //   3	20	262	finally
    //   270	274	276	java/lang/Exception
    //   20	140	284	finally
    //   147	175	284	finally
    //   202	210	284	finally
    //   214	222	284	finally
    //   222	233	284	finally
    //   178	190	290	finally
    //   3	20	298	java/lang/Exception
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/safecommand/security/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */