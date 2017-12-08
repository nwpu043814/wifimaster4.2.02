package com.alipay.sdk.f;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.widget.TextView;
import com.alipay.sdk.j.j;
import com.alipay.sdk.j.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.message.BasicHeader;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class d
{
  private static com.alipay.sdk.e.a c;
  protected boolean a = true;
  protected boolean b = true;
  
  public static String a(HashMap paramHashMap1, HashMap paramHashMap2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    paramHashMap1 = paramHashMap1.entrySet().iterator();
    while (paramHashMap1.hasNext())
    {
      localObject = (Map.Entry)paramHashMap1.next();
      localJSONObject2.put((String)((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue());
    }
    paramHashMap1 = new JSONObject();
    Object localObject = paramHashMap2.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramHashMap2 = (Map.Entry)((Iterator)localObject).next();
      paramHashMap1.put((String)paramHashMap2.getKey(), paramHashMap2.getValue());
    }
    localJSONObject2.put("params", paramHashMap1);
    localJSONObject1.put("data", localJSONObject2);
    return localJSONObject1.toString();
  }
  
  public static JSONObject a(String paramString1, String paramString2)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    localJSONObject2.put("type", paramString1);
    localJSONObject2.put("method", paramString2);
    localJSONObject1.put("action", localJSONObject2);
    return localJSONObject1;
  }
  
  private static boolean a(String paramString)
  {
    boolean bool2 = false;
    boolean bool1;
    if (TextUtils.isEmpty(paramString)) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      try
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(paramString);
        paramString = localJSONObject.getJSONObject("data");
        bool1 = bool2;
        if (paramString.has("params"))
        {
          paramString = paramString.getJSONObject("params").optString("public_key", null);
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramString))
          {
            com.alipay.sdk.h.b.a();
            com.alipay.sdk.c.c.a().a(paramString);
            bool1 = true;
          }
        }
      }
      catch (JSONException paramString)
      {
        bool1 = bool2;
      }
    }
  }
  
  /* Error */
  private static byte[] a(HttpResponse paramHttpResponse)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: sipush 1024
    //   5: newarray <illegal type>
    //   7: astore 5
    //   9: aload_0
    //   10: invokeinterface 119 1 0
    //   15: invokeinterface 125 1 0
    //   20: astore_2
    //   21: new 127	java/io/ByteArrayOutputStream
    //   24: astore 4
    //   26: aload 4
    //   28: invokespecial 128	java/io/ByteArrayOutputStream:<init>	()V
    //   31: aload_2
    //   32: aload 5
    //   34: invokevirtual 134	java/io/InputStream:read	([B)I
    //   37: istore_1
    //   38: iload_1
    //   39: iconst_m1
    //   40: if_icmpeq +37 -> 77
    //   43: aload 4
    //   45: aload 5
    //   47: iconst_0
    //   48: iload_1
    //   49: invokevirtual 138	java/io/ByteArrayOutputStream:write	([BII)V
    //   52: goto -21 -> 31
    //   55: astore_0
    //   56: aload 4
    //   58: astore_3
    //   59: aload_2
    //   60: ifnull +7 -> 67
    //   63: aload_2
    //   64: invokevirtual 141	java/io/InputStream:close	()V
    //   67: aload_3
    //   68: ifnull +7 -> 75
    //   71: aload_3
    //   72: invokevirtual 142	java/io/ByteArrayOutputStream:close	()V
    //   75: aload_0
    //   76: athrow
    //   77: aload 4
    //   79: invokevirtual 146	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   82: astore_0
    //   83: aload_2
    //   84: ifnull +7 -> 91
    //   87: aload_2
    //   88: invokevirtual 141	java/io/InputStream:close	()V
    //   91: aload 4
    //   93: invokevirtual 142	java/io/ByteArrayOutputStream:close	()V
    //   96: aload_0
    //   97: areturn
    //   98: astore_2
    //   99: goto -8 -> 91
    //   102: astore_2
    //   103: goto -7 -> 96
    //   106: astore_2
    //   107: goto -40 -> 67
    //   110: astore_2
    //   111: goto -36 -> 75
    //   114: astore_0
    //   115: aconst_null
    //   116: astore_2
    //   117: goto -58 -> 59
    //   120: astore_0
    //   121: goto -62 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramHttpResponse	HttpResponse
    //   37	12	1	i	int
    //   20	68	2	localInputStream	java.io.InputStream
    //   98	1	2	localException1	Exception
    //   102	1	2	localException2	Exception
    //   106	1	2	localException3	Exception
    //   110	1	2	localException4	Exception
    //   116	1	2	localObject1	Object
    //   1	71	3	localObject2	Object
    //   24	68	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   7	39	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   31	38	55	finally
    //   43	52	55	finally
    //   77	83	55	finally
    //   87	91	98	java/lang/Exception
    //   91	96	102	java/lang/Exception
    //   63	67	106	java/lang/Exception
    //   71	75	110	java/lang/Exception
    //   9	21	114	finally
    //   21	31	120	finally
  }
  
  public b a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, j.a(paramContext), true);
  }
  
  public final b a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject2 = null;
    int i = 0;
    e locale = new e(this.b);
    Object localObject1;
    Object localObject4;
    do
    {
      do
      {
        try
        {
          localObject1 = new com/alipay/sdk/f/b;
          ((b)localObject1).<init>(c(), a(paramString1, a()));
          localObject1 = locale.a((b)localObject1, this.a);
          Object localObject3;
          if (c == null)
          {
            localObject3 = new com/alipay/sdk/e/a;
            ((com.alipay.sdk.e.a)localObject3).<init>(paramContext, paramString2);
            c = (com.alipay.sdk.e.a)localObject3;
          }
          for (;;)
          {
            localObject4 = c;
            localObject3 = a(((c)localObject1).a, paramString1);
            localObject3 = ((com.alipay.sdk.e.a)localObject4).a(((c)localObject1).b, (List)localObject3);
            if (localObject3 != null) {
              break;
            }
            localObject1 = localObject2;
            boolean bool = Boolean.valueOf((String)localObject1).booleanValue();
            localObject1 = a((HttpResponse)localObject3);
            localObject2 = new com/alipay/sdk/f/c;
            ((c)localObject2).<init>(bool, (byte[])localObject1);
            localObject2 = locale.a((c)localObject2);
            localObject1 = localObject2;
            if (localObject2 != null)
            {
              localObject1 = localObject2;
              if (a(((b)localObject2).a))
              {
                localObject1 = localObject2;
                if (paramBoolean) {
                  localObject1 = a(paramContext, paramString1, paramString2, false);
                }
              }
            }
            return (b)localObject1;
            if (!TextUtils.equals(paramString2, c.a)) {
              c.a = paramString2;
            }
          }
          localObject4 = ((HttpResponse)localObject3).getAllHeaders();
        }
        catch (Throwable paramContext)
        {
          throw paramContext;
        }
        localObject1 = localObject2;
      } while (localObject4 == null);
      localObject1 = localObject2;
    } while (localObject4.length <= 0);
    int j = localObject4.length;
    for (;;)
    {
      localObject1 = localObject2;
      if (i >= j) {
        break;
      }
      Object localObject5 = localObject4[i];
      if (localObject5 != null)
      {
        localObject1 = ((Header)localObject5).getName();
        if ((localObject1 != null) && (((String)localObject1).equalsIgnoreCase("msp-gzip")))
        {
          localObject1 = ((Header)localObject5).getValue();
          break;
        }
      }
      i++;
    }
  }
  
  public String a(String paramString, JSONObject paramJSONObject)
  {
    com.alipay.sdk.h.b localb = com.alipay.sdk.h.b.a();
    com.alipay.sdk.i.b localb1 = com.alipay.sdk.i.b.a();
    JSONObject localJSONObject = com.alipay.sdk.j.c.a(new JSONObject(), paramJSONObject);
    for (;;)
    {
      try
      {
        localJSONObject.put("tid", localb1.a);
        com.alipay.sdk.c.c localc = com.alipay.sdk.c.c.a();
        Context localContext = com.alipay.sdk.h.b.a().a;
        localObject3 = com.alipay.sdk.j.b.a(localContext);
        if (TextUtils.isEmpty(localc.a))
        {
          paramJSONObject = k.b();
          localObject1 = k.c();
          localObject2 = k.f(localContext);
          str1 = j.a(localContext);
          str2 = str1.substring(0, str1.indexOf("://"));
          str1 = k.g(localContext);
          localObject4 = new android/widget/TextView;
          ((TextView)localObject4).<init>(localContext);
          localObject4 = Float.toString(((TextView)localObject4).getTextSize());
          localObject5 = new java/lang/StringBuilder;
          ((StringBuilder)localObject5).<init>();
          localc.a = ("Msp/15.2.8" + " (" + paramJSONObject + ";" + (String)localObject1 + ";" + (String)localObject2 + ";" + str2 + ";" + str1 + ";" + (String)localObject4);
        }
        String str2 = com.alipay.sdk.j.b.b(localContext).p;
        String str1 = ((com.alipay.sdk.j.b)localObject3).a();
        Object localObject4 = ((com.alipay.sdk.j.b)localObject3).b();
        localObject5 = com.alipay.sdk.h.b.a().a;
        localObject2 = ((Context)localObject5).getSharedPreferences("virtualImeiAndImsi", 0);
        paramJSONObject = ((SharedPreferences)localObject2).getString("virtual_imsi", null);
        Object localObject1 = paramJSONObject;
        if (TextUtils.isEmpty(paramJSONObject))
        {
          if (!TextUtils.isEmpty(com.alipay.sdk.i.b.a().a)) {
            continue;
          }
          paramJSONObject = com.alipay.sdk.h.b.a().c();
          if (!TextUtils.isEmpty(paramJSONObject)) {
            continue;
          }
          paramJSONObject = com.alipay.sdk.c.c.b();
          ((SharedPreferences)localObject2).edit().putString("virtual_imsi", paramJSONObject).commit();
          localObject1 = paramJSONObject;
        }
        localObject6 = com.alipay.sdk.h.b.a().a;
        localObject5 = ((Context)localObject6).getSharedPreferences("virtualImeiAndImsi", 0);
        localObject2 = ((SharedPreferences)localObject5).getString("virtual_imei", null);
        paramJSONObject = (JSONObject)localObject2;
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          if (!TextUtils.isEmpty(com.alipay.sdk.i.b.a().a)) {
            continue;
          }
          paramJSONObject = com.alipay.sdk.c.c.b();
          ((SharedPreferences)localObject5).edit().putString("virtual_imei", paramJSONObject).commit();
        }
        if (localb1 != null) {
          localc.c = localb1.b;
        }
        localObject5 = Build.MANUFACTURER.replace(";", " ");
        localObject6 = Build.MODEL.replace(";", " ");
        boolean bool = com.alipay.sdk.h.b.b();
        String str3 = ((com.alipay.sdk.j.b)localObject3).a;
        localObject2 = ((WifiManager)localContext.getSystemService("wifi")).getConnectionInfo();
        if (localObject2 == null) {
          continue;
        }
        localObject2 = ((WifiInfo)localObject2).getSSID();
        localObject3 = ((WifiManager)localContext.getSystemService("wifi")).getConnectionInfo();
        if (localObject3 == null) {
          continue;
        }
        localObject3 = ((WifiInfo)localObject3).getBSSID();
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append(localc.a).append(";").append(str2).append(";").append("-1;-1").append(";").append("1").append(";").append(str1).append(";").append((String)localObject4).append(";").append(localc.c).append(";").append((String)localObject5).append(";").append((String)localObject6).append(";").append(bool).append(";").append(str3).append(";-1;-1;").append(localc.b).append(";").append((String)localObject1).append(";").append(paramJSONObject).append(";").append((String)localObject2).append(";").append((String)localObject3);
        if (localb1 != null)
        {
          paramJSONObject = new java/util/HashMap;
          paramJSONObject.<init>();
          paramJSONObject.put("tid", localb1.a);
          paramJSONObject.put("utdid", com.alipay.sdk.h.b.a().c());
          paramJSONObject = localc.b(localContext, paramJSONObject);
          if (!TextUtils.isEmpty(paramJSONObject)) {
            localStringBuilder.append(";").append(paramJSONObject);
          }
        }
        localStringBuilder.append(")");
        localJSONObject.put("user_agent", localStringBuilder.toString());
        localJSONObject.put("has_alipay", k.c(localb.a));
        localJSONObject.put("has_msp_app", k.b(localb.a));
        localJSONObject.put("external_info", paramString);
        localJSONObject.put("app_key", "2014052600006128");
        localJSONObject.put("utdid", localb.c());
        localJSONObject.put("new_client_key", localb1.b);
      }
      catch (Throwable paramString)
      {
        Object localObject3;
        Object localObject2;
        Object localObject5;
        Object localObject6;
        continue;
      }
      return localJSONObject.toString();
      paramJSONObject = paramJSONObject.substring(3, 18);
      continue;
      paramJSONObject = com.alipay.sdk.j.b.a((Context)localObject5).a();
      continue;
      paramJSONObject = com.alipay.sdk.j.b.a((Context)localObject6).b();
      continue;
      localObject2 = "-1";
      continue;
      localObject3 = "00";
    }
  }
  
  public List a(boolean paramBoolean, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new BasicHeader("msp-gzip", String.valueOf(paramBoolean)));
    localArrayList.add(new BasicHeader("Operation-Type", "alipay.msp.cashier.dispatch.bytes"));
    localArrayList.add(new BasicHeader("content-type", "application/octet-stream"));
    localArrayList.add(new BasicHeader("Version", "2.0"));
    localArrayList.add(new BasicHeader("AppId", "TAOBAO"));
    localArrayList.add(new BasicHeader("Msp-Param", a.a(paramString)));
    localArrayList.add(new BasicHeader("des-mode", "CBC"));
    return localArrayList;
  }
  
  public abstract JSONObject a();
  
  public String b()
  {
    return "4.9.0";
  }
  
  public String c()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("device", Build.MODEL);
    localHashMap.put("namespace", "com.alipay.mobilecashier");
    localHashMap.put("api_name", "com.alipay.mcpay");
    localHashMap.put("api_version", b());
    return a(localHashMap, new HashMap());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/f/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */