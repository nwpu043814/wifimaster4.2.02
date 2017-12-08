package com.lantern.wifiseccheck;

import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.fastjson.JSON;
import com.lantern.wifiseccheck.protocol.ApMarkResult;
import com.lantern.wifiseccheck.protocol.ApNeighbourRes;
import com.lantern.wifiseccheck.protocol.TreatmentRecommendations;
import com.lantern.wifiseccheck.protocol.WifiSecInfoReq;
import com.lantern.wifiseccheck.protocol.WifiSecInfoRes;
import com.lantern.wifiseccheck.protocol.WifiSecInfoRes.RiskType;
import com.lantern.wifiseccheck.protocol.WifiSecInfoRes.WifiSecInfo;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SecCheckHttpApi
{
  public static final String REMOTE_BASE_URL = "http://eval.swaqds.com:8080";
  private static final String REMOTE_POST_CHECK = "/WifiSafetyDecisionMaker/wifi-safety/decision";
  private static final String REMOTE_POST_ERROR_COLLECTOR = "/WifiSafetyDecisionMaker/wifi-safety/collector";
  private static final String REMOTE_POST_LOAD_DEVICES = "/WifiSafetyDecisionMaker/wifi-safety/mac";
  private static final String REMOTE_POST_SEC_LEVEL = "/WifiSafetyDecisionMaker/wifi-safety/wifi_sec";
  private static final String TAG = "SecCheckHttpApi";
  
  public static ApMarkResult getApMarkResult(String paramString)
  {
    LogUtils.d("SecCheckHttpApi", "wifi check request = \n" + paramString);
    Object localObject2 = new Chiper(Chiper.PUBLIC_KEY_CHECK);
    long l1 = System.currentTimeMillis();
    Object localObject1 = ((Chiper)localObject2).genReqeustContent(paramString, true);
    paramString = new ApMarkResult();
    paramString.setNetState(1);
    paramString.setRecommend(TreatmentRecommendations.JUST_SHOW);
    try
    {
      localObject3 = new java/net/URL;
      ((URL)localObject3).<init>(getUrl("/WifiSafetyDecisionMaker/wifi-safety/decision"));
      localObject3 = getResultFromServer((byte[])localObject1, (URL)localObject3);
      if (localObject3 != null)
      {
        LogUtils.d("SecCheckHttpApi", "sRes.code =" + ((ServerRes)localObject3).resCode);
        if (((ServerRes)localObject3).resCode == 200)
        {
          localObject1 = paramString;
          if (((ServerRes)localObject3).result != null)
          {
            localObject1 = ((Chiper)localObject2).getResponseString(((ServerRes)localObject3).result);
            long l2 = System.currentTimeMillis();
            LogUtils.d("SecCheckHttpApi", "enc need time:" + (l2 - l1));
          }
          String str1;
          localException2.printStackTrace();
        }
      }
    }
    catch (MalformedURLException localException2)
    {
      for (;;)
      {
        try
        {
          localObject1 = GzipUtils.getInstance().unGZip((byte[])localObject1);
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>("decryptedRe size ");
          LogUtils.d("SecCheckHttpApi", localObject1.length);
          localObject2 = new java/lang/String;
          ((String)localObject2).<init>((byte[])localObject1, "UTF-8");
          localObject2 = URLDecoder.decode((String)localObject2, "UTF-8");
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label448;
          }
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>("result ");
          LogUtils.d("SecCheckHttpApi", (String)localObject2 + " length " + ((String)localObject2).length());
        }
        catch (Exception localException2)
        {
          try
          {
            localException1.printStackTrace();
            paramString.setNetState(3);
            str2 = paramString;
          }
          catch (Exception localException3)
          {
            Object localObject3;
            for (;;) {}
          }
          localException2 = localException2;
        }
        try
        {
          localObject1 = (ApMarkResult)JSON.parseObject((String)localObject2, ApMarkResult.class);
        }
        catch (Exception localException1) {}
        try
        {
          ((ApMarkResult)localObject1).setNetState(4);
          return (ApMarkResult)localObject1;
        }
        catch (Exception localException5)
        {
          paramString = localException3;
          Exception localException4 = localException5;
          continue;
        }
        localMalformedURLException = localMalformedURLException;
        localMalformedURLException.printStackTrace();
        str1 = paramString;
      }
    }
    label448:
    for (;;)
    {
      String str2;
      paramString.setNetState(3);
      String str3 = paramString;
      break;
      if ((((ServerRes)localObject3).resCode >= 300) && (((ServerRes)localObject3).resCode < 400))
      {
        paramString.setNetState(2);
        str3 = paramString;
        break;
      }
      str3 = paramString;
      if (((ServerRes)localObject3).resCode < 400) {
        break;
      }
      paramString.setNetState(3);
      str3 = paramString;
      break;
      LogUtils.d("SecCheckHttpApi", "get apmark result from server failed!!!!!!!");
      str3 = paramString;
      break;
    }
  }
  
  public static ApNeighbourRes getApNeighbourResult(String paramString)
  {
    LogUtils.d("SecCheckHttpApi", "wifi load device request = \n" + paramString);
    Object localObject = new Chiper(Chiper.PUBLIC_KEY_CHECK);
    ApNeighbourRes localApNeighbourRes = new ApNeighbourRes();
    localApNeighbourRes.setNetState(1);
    paramString = ((Chiper)localObject).genReqeustContent(paramString, true);
    LogUtils.d("SecCheckHttpApi", "after encryption, wifi load device request = \n" + new String(paramString));
    for (;;)
    {
      try
      {
        URL localURL = new java/net/URL;
        localURL.<init>(getUrl("/WifiSafetyDecisionMaker/wifi-safety/mac"));
        paramString = getResultFromServer(paramString, localURL);
        if (paramString != null) {
          continue;
        }
        LogUtils.e("SecCheckHttpApi", "getResultFromServer failed");
        paramString = localApNeighbourRes;
      }
      catch (MalformedURLException paramString)
      {
        paramString.printStackTrace();
        paramString = localApNeighbourRes;
        continue;
        LogUtils.d("SecCheckHttpApi", "sRes.resCode " + paramString.resCode);
        if (paramString.resCode != 200) {
          break;
        }
      }
      return paramString;
      if (paramString.result == null) {
        break label320;
      }
      LogUtils.d("SecCheckHttpApi", "before decrypt " + paramString.result);
      paramString = ((Chiper)localObject).getResponseString(Base64.decode(paramString.result, 0));
      try
      {
        localObject = GzipUtils.getInstance().unGZip(paramString);
        paramString = new java/lang/String;
        paramString.<init>((byte[])localObject, "UTF-8");
        if (!TextUtils.isEmpty(paramString))
        {
          localObject = new java/lang/StringBuilder;
          ((StringBuilder)localObject).<init>("result=================\n");
          LogUtils.d("SecCheckHttpApi", paramString);
        }
      }
      catch (Exception localException4)
      {
        for (;;)
        {
          label270:
          paramString = localException2;
          localException3 = localException4;
        }
      }
      try
      {
        paramString = (ApNeighbourRes)JSON.parseObject(paramString, ApNeighbourRes.class);
        try
        {
          paramString.setNetState(4);
        }
        catch (Exception localException1) {}
      }
      catch (Exception localException5)
      {
        paramString = localException3;
        localException3 = localException5;
        break label270;
      }
      try
      {
        localException1.printStackTrace();
        paramString.setNetState(3);
      }
      catch (Exception localException2) {}
      localException2.printStackTrace();
      paramString.setNetState(3);
    }
    if ((paramString.resCode >= 300) && (paramString.resCode < 400)) {
      localException2.setNetState(2);
    }
    for (;;)
    {
      label320:
      paramString = localException2;
      break;
      if (paramString.resCode >= 400) {
        localException2.setNetState(3);
      }
    }
  }
  
  /* Error */
  public static java.security.cert.Certificate[] getHostCertsViaConnection(String paramString)
  {
    // Byte code:
    //   0: new 98	java/net/URL
    //   3: astore_3
    //   4: aload_3
    //   5: aload_0
    //   6: invokespecial 103	java/net/URL:<init>	(Ljava/lang/String;)V
    //   9: aload_3
    //   10: invokevirtual 220	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   13: checkcast 222	javax/net/ssl/HttpsURLConnection
    //   16: astore_3
    //   17: aload_3
    //   18: invokevirtual 225	javax/net/ssl/HttpsURLConnection:connect	()V
    //   21: aload_3
    //   22: invokevirtual 229	javax/net/ssl/HttpsURLConnection:getServerCertificates	()[Ljava/security/cert/Certificate;
    //   25: astore 4
    //   27: aload 4
    //   29: astore_3
    //   30: aload 4
    //   32: ifnull +146 -> 178
    //   35: aload 4
    //   37: arraylength
    //   38: istore_2
    //   39: iconst_0
    //   40: istore_1
    //   41: aload 4
    //   43: astore_3
    //   44: iload_1
    //   45: iload_2
    //   46: if_icmpge +132 -> 178
    //   49: aload 4
    //   51: iload_1
    //   52: aaload
    //   53: astore 5
    //   55: new 42	java/lang/StringBuilder
    //   58: astore_3
    //   59: aload_3
    //   60: ldc -25
    //   62: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   65: ldc -23
    //   67: aload_3
    //   68: aload_0
    //   69: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc -21
    //   74: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 61	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   83: ldc -23
    //   85: aload 5
    //   87: invokestatic 239	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   90: invokestatic 61	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: ldc -23
    //   95: ldc -15
    //   97: invokestatic 61	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload 5
    //   102: invokevirtual 247	java/security/cert/Certificate:getEncoded	()[B
    //   105: iconst_0
    //   106: invokestatic 251	android/util/Base64:encodeToString	([BI)Ljava/lang/String;
    //   109: astore_3
    //   110: aload_3
    //   111: ldc -3
    //   113: ldc -1
    //   115: invokevirtual 258	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   118: astore 5
    //   120: new 42	java/lang/StringBuilder
    //   123: astore_3
    //   124: aload_3
    //   125: ldc_w 260
    //   128: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   131: ldc 29
    //   133: aload_3
    //   134: aload_0
    //   135: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: ldc_w 262
    //   141: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   144: aload 5
    //   146: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokestatic 61	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: iinc 1 1
    //   158: goto -117 -> 41
    //   161: astore_3
    //   162: aload_3
    //   163: invokevirtual 263	java/security/cert/CertificateEncodingException:printStackTrace	()V
    //   166: aconst_null
    //   167: astore_3
    //   168: goto -58 -> 110
    //   171: astore_0
    //   172: aload_0
    //   173: invokevirtual 175	java/net/MalformedURLException:printStackTrace	()V
    //   176: aconst_null
    //   177: astore_3
    //   178: aload_3
    //   179: areturn
    //   180: astore_0
    //   181: aload_0
    //   182: invokevirtual 264	java/io/IOException:printStackTrace	()V
    //   185: goto -9 -> 176
    //   188: astore_0
    //   189: aload_0
    //   190: invokevirtual 176	java/lang/Exception:printStackTrace	()V
    //   193: goto -17 -> 176
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	paramString	String
    //   40	116	1	i	int
    //   38	9	2	j	int
    //   3	131	3	localObject1	Object
    //   161	2	3	localCertificateEncodingException	java.security.cert.CertificateEncodingException
    //   167	12	3	arrayOfCertificate1	java.security.cert.Certificate[]
    //   25	25	4	arrayOfCertificate2	java.security.cert.Certificate[]
    //   53	92	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   55	110	161	java/security/cert/CertificateEncodingException
    //   0	27	171	java/net/MalformedURLException
    //   35	39	171	java/net/MalformedURLException
    //   55	110	171	java/net/MalformedURLException
    //   110	155	171	java/net/MalformedURLException
    //   162	166	171	java/net/MalformedURLException
    //   0	27	180	java/io/IOException
    //   35	39	180	java/io/IOException
    //   55	110	180	java/io/IOException
    //   110	155	180	java/io/IOException
    //   162	166	180	java/io/IOException
    //   0	27	188	java/lang/Exception
    //   35	39	188	java/lang/Exception
    //   55	110	188	java/lang/Exception
    //   110	155	188	java/lang/Exception
    //   162	166	188	java/lang/Exception
  }
  
  public static String getHtml(String paramString)
  {
    paramString = (HttpURLConnection)new URL(paramString).openConnection();
    paramString.setRequestMethod("GET");
    paramString.setConnectTimeout(5000);
    return new String(readInputStream(paramString.getInputStream()));
  }
  
  public static String getIconUrl(String paramString1, String paramString2)
  {
    return "http://eval.swaqds.com:8080/" + paramString1 + paramString2;
  }
  
  /* Error */
  public static ServerRes getResultFromServer(byte[] paramArrayOfByte, URL paramURL)
  {
    // Byte code:
    //   0: ldc 29
    //   2: new 42	java/lang/StringBuilder
    //   5: dup
    //   6: ldc_w 288
    //   9: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: aload_0
    //   13: arraylength
    //   14: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: invokestatic 61	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: aload_1
    //   24: invokevirtual 220	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   27: checkcast 267	java/net/HttpURLConnection
    //   30: astore 4
    //   32: aload 4
    //   34: sipush 7000
    //   37: invokevirtual 275	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   40: aload 4
    //   42: iconst_1
    //   43: invokevirtual 292	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   46: aload 4
    //   48: ldc_w 294
    //   51: invokevirtual 272	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   54: aload 4
    //   56: ldc_w 296
    //   59: ldc_w 298
    //   62: invokevirtual 301	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload 4
    //   67: ldc_w 303
    //   70: ldc_w 305
    //   73: invokevirtual 301	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   76: aload 4
    //   78: ldc_w 307
    //   81: ldc -113
    //   83: invokevirtual 301	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   86: aload 4
    //   88: ldc_w 309
    //   91: ldc_w 311
    //   94: invokevirtual 301	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   97: aload 4
    //   99: ldc_w 313
    //   102: ldc_w 315
    //   105: invokevirtual 301	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload 4
    //   110: sipush 7000
    //   113: invokevirtual 318	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   116: aload 4
    //   118: invokevirtual 322	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   121: astore_1
    //   122: aload_1
    //   123: astore_3
    //   124: aload_1
    //   125: aload_0
    //   126: invokevirtual 327	java/io/OutputStream:write	([B)V
    //   129: aload_1
    //   130: astore_3
    //   131: aload_1
    //   132: invokevirtual 330	java/io/OutputStream:close	()V
    //   135: aload_1
    //   136: astore_3
    //   137: aload 4
    //   139: invokevirtual 333	java/net/HttpURLConnection:getResponseCode	()I
    //   142: istore_2
    //   143: aload_1
    //   144: astore_3
    //   145: new 42	java/lang/StringBuilder
    //   148: astore_0
    //   149: aload_1
    //   150: astore_3
    //   151: aload_0
    //   152: ldc_w 335
    //   155: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   158: aload_1
    //   159: astore_3
    //   160: ldc 29
    //   162: aload_0
    //   163: iload_2
    //   164: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 61	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: iload_2
    //   174: sipush 200
    //   177: if_icmpne +204 -> 381
    //   180: aload_1
    //   181: astore_3
    //   182: invokestatic 134	com/lantern/wifiseccheck/GzipUtils:getInstance	()Lcom/lantern/wifiseccheck/GzipUtils;
    //   185: aload 4
    //   187: invokevirtual 279	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   190: invokevirtual 338	com/lantern/wifiseccheck/GzipUtils:toByteArray	(Ljava/io/InputStream;)[B
    //   193: astore_0
    //   194: aload_1
    //   195: astore_3
    //   196: new 42	java/lang/StringBuilder
    //   199: astore 4
    //   201: aload_1
    //   202: astore_3
    //   203: aload 4
    //   205: ldc_w 340
    //   208: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   211: aload_1
    //   212: astore_3
    //   213: ldc 29
    //   215: aload 4
    //   217: aload_0
    //   218: arraylength
    //   219: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   222: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 61	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   228: aload_1
    //   229: astore_3
    //   230: new 9	com/lantern/wifiseccheck/SecCheckHttpApi$ServerRes
    //   233: astore 4
    //   235: aload_1
    //   236: astore_3
    //   237: aload 4
    //   239: aconst_null
    //   240: invokespecial 343	com/lantern/wifiseccheck/SecCheckHttpApi$ServerRes:<init>	(Lcom/lantern/wifiseccheck/SecCheckHttpApi$1;)V
    //   243: aload_1
    //   244: astore_3
    //   245: aload 4
    //   247: iload_2
    //   248: putfield 112	com/lantern/wifiseccheck/SecCheckHttpApi$ServerRes:resCode	I
    //   251: aload_1
    //   252: astore_3
    //   253: aload 4
    //   255: aload_0
    //   256: putfield 119	com/lantern/wifiseccheck/SecCheckHttpApi$ServerRes:result	[B
    //   259: aload 4
    //   261: astore_0
    //   262: aload_1
    //   263: ifnull +10 -> 273
    //   266: aload_1
    //   267: invokevirtual 330	java/io/OutputStream:close	()V
    //   270: aload 4
    //   272: astore_0
    //   273: aload_0
    //   274: areturn
    //   275: astore_0
    //   276: aload_0
    //   277: invokevirtual 264	java/io/IOException:printStackTrace	()V
    //   280: aload 4
    //   282: astore_0
    //   283: goto -10 -> 273
    //   286: astore_0
    //   287: aconst_null
    //   288: astore_1
    //   289: aload_1
    //   290: astore_3
    //   291: new 42	java/lang/StringBuilder
    //   294: astore 4
    //   296: aload_1
    //   297: astore_3
    //   298: aload 4
    //   300: ldc_w 345
    //   303: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   306: aload_1
    //   307: astore_3
    //   308: ldc 29
    //   310: aload 4
    //   312: aload_0
    //   313: invokevirtual 348	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   316: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   319: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   322: invokestatic 61	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: aload_1
    //   326: astore_3
    //   327: aload_0
    //   328: invokevirtual 176	java/lang/Exception:printStackTrace	()V
    //   331: aload_1
    //   332: ifnull +7 -> 339
    //   335: aload_1
    //   336: invokevirtual 330	java/io/OutputStream:close	()V
    //   339: aconst_null
    //   340: astore_0
    //   341: goto -68 -> 273
    //   344: astore_0
    //   345: aload_0
    //   346: invokevirtual 264	java/io/IOException:printStackTrace	()V
    //   349: goto -10 -> 339
    //   352: astore_0
    //   353: aconst_null
    //   354: astore_3
    //   355: aload_3
    //   356: ifnull +7 -> 363
    //   359: aload_3
    //   360: invokevirtual 330	java/io/OutputStream:close	()V
    //   363: aload_0
    //   364: athrow
    //   365: astore_1
    //   366: aload_1
    //   367: invokevirtual 264	java/io/IOException:printStackTrace	()V
    //   370: goto -7 -> 363
    //   373: astore_0
    //   374: goto -19 -> 355
    //   377: astore_0
    //   378: goto -89 -> 289
    //   381: aconst_null
    //   382: astore_0
    //   383: goto -155 -> 228
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	paramArrayOfByte	byte[]
    //   0	386	1	paramURL	URL
    //   142	106	2	i	int
    //   123	237	3	localURL	URL
    //   30	281	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   266	270	275	java/io/IOException
    //   23	122	286	java/lang/Exception
    //   335	339	344	java/io/IOException
    //   23	122	352	finally
    //   359	363	365	java/io/IOException
    //   124	129	373	finally
    //   131	135	373	finally
    //   137	143	373	finally
    //   145	149	373	finally
    //   151	158	373	finally
    //   160	173	373	finally
    //   182	194	373	finally
    //   196	201	373	finally
    //   203	211	373	finally
    //   213	228	373	finally
    //   230	235	373	finally
    //   237	243	373	finally
    //   245	251	373	finally
    //   253	259	373	finally
    //   291	296	373	finally
    //   298	306	373	finally
    //   308	325	373	finally
    //   327	331	373	finally
    //   124	129	377	java/lang/Exception
    //   131	135	377	java/lang/Exception
    //   137	143	377	java/lang/Exception
    //   145	149	377	java/lang/Exception
    //   151	158	377	java/lang/Exception
    //   160	173	377	java/lang/Exception
    //   182	194	377	java/lang/Exception
    //   196	201	377	java/lang/Exception
    //   203	211	377	java/lang/Exception
    //   213	228	377	java/lang/Exception
    //   230	235	377	java/lang/Exception
    //   237	243	377	java/lang/Exception
    //   245	251	377	java/lang/Exception
    //   253	259	377	java/lang/Exception
  }
  
  public static String getResultFromServerWithEncrypt(String paramString1, String paramString2, boolean paramBoolean)
  {
    Chiper localChiper = new Chiper(Chiper.PUBLIC_KEY_CHECK);
    paramString1 = localChiper.genReqeustContent(paramString1, paramBoolean);
    try
    {
      URL localURL = new java/net/URL;
      localURL.<init>(paramString2);
      paramString1 = getResultFromServer(paramString1, localURL);
      if (paramString1 != null) {
        LogUtils.d("SecCheckHttpApi", "sRes.resultCode" + paramString1.resCode);
      }
      if ((paramString1 != null) && (paramString1.resCode == 200)) {
        break label93;
      }
      paramString1 = null;
    }
    catch (MalformedURLException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        paramString1 = null;
      }
      label93:
      paramString1 = localChiper.getResponseString(paramString1.result);
      if (!paramBoolean) {
        break label140;
      }
    }
    return paramString1;
    paramString1 = GzipUtils.getInstance().unGZip(paramString1);
    label140:
    for (;;)
    {
      try
      {
        paramString2 = new java/lang/String;
        paramString2.<init>(paramString1, "UTF-8");
        paramString1 = paramString2;
      }
      catch (UnsupportedEncodingException paramString1)
      {
        paramString1.printStackTrace();
        paramString1 = null;
      }
      break;
    }
  }
  
  private static String getUrl(String paramString)
  {
    String str = WifiSecCheckManager.getInstance().getRemoteBaseUrl();
    if (str == null) {}
    for (paramString = "http://eval.swaqds.com:8080" + paramString;; paramString = str + paramString) {
      return paramString;
    }
  }
  
  public static WifiSecInfoRes getWifiSecLevel(WifiSecInfoReq paramWifiSecInfoReq)
  {
    String str1 = null;
    Object localObject = null;
    LogUtils.d("SecCheckHttpApi", "wifi check request getWifiSecLevel req= \n" + JSON.toJSONString(paramWifiSecInfoReq));
    if (paramWifiSecInfoReq == null) {
      paramWifiSecInfoReq = (WifiSecInfoReq)localObject;
    }
    for (;;)
    {
      return paramWifiSecInfoReq;
      localObject = getResultFromServerWithEncrypt(JSON.toJSONString(paramWifiSecInfoReq), getUrl("/WifiSafetyDecisionMaker/wifi-safety/wifi_sec"), true);
      LogUtils.d("SecCheckHttpApi", "wifi check request getWifiSecLevel response= \n" + (String)localObject);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        paramWifiSecInfoReq = paramWifiSecInfoReq.getWifiMap();
        localObject = new HashMap();
        Iterator localIterator = paramWifiSecInfoReq.entrySet().iterator();
        paramWifiSecInfoReq = str1;
        while (localIterator.hasNext())
        {
          paramWifiSecInfoReq = (Map.Entry)localIterator.next();
          str1 = (String)paramWifiSecInfoReq.getKey();
          String str2 = (String)paramWifiSecInfoReq.getValue();
          paramWifiSecInfoReq = new WifiSecInfoRes();
          WifiSecInfoRes.WifiSecInfo localWifiSecInfo = new WifiSecInfoRes.WifiSecInfo();
          localWifiSecInfo.setBssid(str1);
          localWifiSecInfo.setRiskType(WifiSecInfoRes.RiskType.NO_CHECK);
          localWifiSecInfo.setSsid(str2);
          ((Map)localObject).put(str1, localWifiSecInfo);
          paramWifiSecInfoReq.setWifiSecInfos((Map)localObject);
          paramWifiSecInfoReq.setRecommand(TreatmentRecommendations.JUST_SHOW);
        }
      }
      else
      {
        paramWifiSecInfoReq = (WifiSecInfoRes)JSON.parseObject((String)localObject, WifiSecInfoRes.class);
      }
    }
  }
  
  /* Error */
  public static void postAbnormalInfo(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: ldc_w 450
    //   9: new 42	java/lang/StringBuilder
    //   12: dup
    //   13: ldc_w 452
    //   16: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   19: aload_0
    //   20: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 61	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   29: new 63	com/lantern/wifiseccheck/Chiper
    //   32: dup
    //   33: getstatic 67	com/lantern/wifiseccheck/Chiper:PUBLIC_KEY_CHECK	I
    //   36: invokespecial 70	com/lantern/wifiseccheck/Chiper:<init>	(I)V
    //   39: aload_0
    //   40: iconst_1
    //   41: invokevirtual 80	com/lantern/wifiseccheck/Chiper:genReqeustContent	(Ljava/lang/String;Z)[B
    //   44: astore 6
    //   46: new 42	java/lang/StringBuilder
    //   49: astore_0
    //   50: aload_0
    //   51: ldc_w 454
    //   54: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   57: ldc_w 450
    //   60: aload_0
    //   61: ldc 20
    //   63: invokestatic 102	com/lantern/wifiseccheck/SecCheckHttpApi:getUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   66: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokestatic 61	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   75: new 98	java/net/URL
    //   78: astore_3
    //   79: aload_3
    //   80: ldc 20
    //   82: invokestatic 102	com/lantern/wifiseccheck/SecCheckHttpApi:getUrl	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokespecial 103	java/net/URL:<init>	(Ljava/lang/String;)V
    //   88: aload 4
    //   90: astore_2
    //   91: aload 5
    //   93: astore_0
    //   94: aload_3
    //   95: invokevirtual 220	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   98: checkcast 267	java/net/HttpURLConnection
    //   101: astore 7
    //   103: aload 4
    //   105: astore_2
    //   106: aload 5
    //   108: astore_0
    //   109: aload 7
    //   111: sipush 7000
    //   114: invokevirtual 275	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   117: aload 4
    //   119: astore_2
    //   120: aload 5
    //   122: astore_0
    //   123: aload 7
    //   125: iconst_1
    //   126: invokevirtual 292	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   129: aload 4
    //   131: astore_2
    //   132: aload 5
    //   134: astore_0
    //   135: aload 7
    //   137: ldc_w 294
    //   140: invokevirtual 272	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   143: aload 4
    //   145: astore_2
    //   146: aload 5
    //   148: astore_0
    //   149: aload 7
    //   151: ldc_w 296
    //   154: ldc_w 298
    //   157: invokevirtual 301	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: aload 4
    //   162: astore_2
    //   163: aload 5
    //   165: astore_0
    //   166: aload 7
    //   168: ldc_w 303
    //   171: ldc_w 305
    //   174: invokevirtual 301	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   177: aload 4
    //   179: astore_2
    //   180: aload 5
    //   182: astore_0
    //   183: aload 7
    //   185: ldc_w 307
    //   188: ldc -113
    //   190: invokevirtual 301	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload 4
    //   195: astore_2
    //   196: aload 5
    //   198: astore_0
    //   199: aload 7
    //   201: ldc_w 309
    //   204: ldc_w 311
    //   207: invokevirtual 301	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload 4
    //   212: astore_2
    //   213: aload 5
    //   215: astore_0
    //   216: aload 7
    //   218: sipush 7000
    //   221: invokevirtual 318	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   224: aload 4
    //   226: astore_2
    //   227: aload 5
    //   229: astore_0
    //   230: aload 7
    //   232: invokevirtual 322	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   235: astore_3
    //   236: aload_3
    //   237: astore_2
    //   238: aload_3
    //   239: astore_0
    //   240: aload_3
    //   241: aload 6
    //   243: invokevirtual 327	java/io/OutputStream:write	([B)V
    //   246: aload_3
    //   247: astore_2
    //   248: aload_3
    //   249: astore_0
    //   250: aload_3
    //   251: invokevirtual 330	java/io/OutputStream:close	()V
    //   254: aload_3
    //   255: astore_2
    //   256: aload_3
    //   257: astore_0
    //   258: aload 7
    //   260: invokevirtual 333	java/net/HttpURLConnection:getResponseCode	()I
    //   263: istore_1
    //   264: aload_3
    //   265: astore_2
    //   266: aload_3
    //   267: astore_0
    //   268: new 42	java/lang/StringBuilder
    //   271: astore 4
    //   273: aload_3
    //   274: astore_2
    //   275: aload_3
    //   276: astore_0
    //   277: aload 4
    //   279: ldc_w 335
    //   282: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   285: aload_3
    //   286: astore_2
    //   287: aload_3
    //   288: astore_0
    //   289: ldc_w 450
    //   292: aload 4
    //   294: iload_1
    //   295: invokevirtual 115	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   298: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 61	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   304: iload_1
    //   305: sipush 200
    //   308: if_icmpne +35 -> 343
    //   311: aload_3
    //   312: astore_2
    //   313: aload_3
    //   314: astore_0
    //   315: ldc_w 450
    //   318: ldc_w 456
    //   321: invokestatic 61	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   324: aload_3
    //   325: ifnull +7 -> 332
    //   328: aload_3
    //   329: invokevirtual 330	java/io/OutputStream:close	()V
    //   332: return
    //   333: astore_0
    //   334: aload_0
    //   335: invokevirtual 175	java/net/MalformedURLException:printStackTrace	()V
    //   338: aconst_null
    //   339: astore_3
    //   340: goto -252 -> 88
    //   343: aload_3
    //   344: astore_2
    //   345: aload_3
    //   346: astore_0
    //   347: ldc_w 450
    //   350: ldc_w 458
    //   353: invokestatic 61	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: goto -32 -> 324
    //   359: astore_3
    //   360: aload_2
    //   361: astore_0
    //   362: new 42	java/lang/StringBuilder
    //   365: astore 4
    //   367: aload_2
    //   368: astore_0
    //   369: aload 4
    //   371: ldc_w 460
    //   374: invokespecial 47	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   377: aload_2
    //   378: astore_0
    //   379: ldc_w 450
    //   382: aload 4
    //   384: aload_3
    //   385: invokevirtual 348	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   388: invokevirtual 51	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: invokevirtual 55	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokestatic 61	com/lantern/wifiseccheck/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   397: aload_2
    //   398: astore_0
    //   399: aload_3
    //   400: invokevirtual 176	java/lang/Exception:printStackTrace	()V
    //   403: aload_2
    //   404: ifnull -72 -> 332
    //   407: aload_2
    //   408: invokevirtual 330	java/io/OutputStream:close	()V
    //   411: goto -79 -> 332
    //   414: astore_0
    //   415: aload_0
    //   416: invokevirtual 264	java/io/IOException:printStackTrace	()V
    //   419: goto -87 -> 332
    //   422: astore_0
    //   423: aload_0
    //   424: invokevirtual 264	java/io/IOException:printStackTrace	()V
    //   427: goto -95 -> 332
    //   430: astore_2
    //   431: aload_0
    //   432: ifnull +7 -> 439
    //   435: aload_0
    //   436: invokevirtual 330	java/io/OutputStream:close	()V
    //   439: aload_2
    //   440: athrow
    //   441: astore_0
    //   442: aload_0
    //   443: invokevirtual 264	java/io/IOException:printStackTrace	()V
    //   446: goto -7 -> 439
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	449	0	paramString	String
    //   263	46	1	i	int
    //   90	318	2	localObject1	Object
    //   430	10	2	localObject2	Object
    //   78	268	3	localObject3	Object
    //   359	41	3	localException	Exception
    //   4	379	4	localStringBuilder	StringBuilder
    //   1	227	5	localObject4	Object
    //   44	198	6	arrayOfByte	byte[]
    //   101	158	7	localHttpURLConnection	HttpURLConnection
    // Exception table:
    //   from	to	target	type
    //   46	88	333	java/net/MalformedURLException
    //   94	103	359	java/lang/Exception
    //   109	117	359	java/lang/Exception
    //   123	129	359	java/lang/Exception
    //   135	143	359	java/lang/Exception
    //   149	160	359	java/lang/Exception
    //   166	177	359	java/lang/Exception
    //   183	193	359	java/lang/Exception
    //   199	210	359	java/lang/Exception
    //   216	224	359	java/lang/Exception
    //   230	236	359	java/lang/Exception
    //   240	246	359	java/lang/Exception
    //   250	254	359	java/lang/Exception
    //   258	264	359	java/lang/Exception
    //   268	273	359	java/lang/Exception
    //   277	285	359	java/lang/Exception
    //   289	304	359	java/lang/Exception
    //   315	324	359	java/lang/Exception
    //   347	356	359	java/lang/Exception
    //   407	411	414	java/io/IOException
    //   328	332	422	java/io/IOException
    //   94	103	430	finally
    //   109	117	430	finally
    //   123	129	430	finally
    //   135	143	430	finally
    //   149	160	430	finally
    //   166	177	430	finally
    //   183	193	430	finally
    //   199	210	430	finally
    //   216	224	430	finally
    //   230	236	430	finally
    //   240	246	430	finally
    //   250	254	430	finally
    //   258	264	430	finally
    //   268	273	430	finally
    //   277	285	430	finally
    //   289	304	430	finally
    //   315	324	430	finally
    //   347	356	430	finally
    //   362	367	430	finally
    //   369	377	430	finally
    //   379	397	430	finally
    //   399	403	430	finally
    //   435	439	441	java/io/IOException
  }
  
  public static byte[] readInputStream(InputStream paramInputStream)
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      localByteArrayOutputStream.write(arrayOfByte, 0, i);
    }
    paramInputStream.close();
    return localByteArrayOutputStream.toByteArray();
  }
  
  public class NetState
  {
    public static final int CHECK_OK = 4;
    public static final int CHECK_VPN_OPEN = 5;
    public static final int NET_DISABLED = 2;
    public static final int SERVER_DISABLED = 3;
    public static final int TIME_OUTSTATE = 1;
    
    public NetState() {}
  }
  
  private static class ServerRes
  {
    int resCode;
    byte[] result;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/SecCheckHttpApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */