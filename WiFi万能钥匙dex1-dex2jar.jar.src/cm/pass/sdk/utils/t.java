package cm.pass.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class t
{
  public static String a()
  {
    return UUID.randomUUID().toString().replaceAll("-", "");
  }
  
  public static String a(Context paramContext)
  {
    return o.a().a(paramContext, "UMC_KS_TIME_STAMP");
  }
  
  public static String a(String paramString)
  {
    String str;
    if (paramString.equals("3")) {
      str = "1";
    }
    for (;;)
    {
      return str;
      if (paramString.equals("4"))
      {
        str = "2";
      }
      else
      {
        str = paramString;
        if (paramString.equals("2")) {
          str = "3";
        }
      }
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    paramString1 = b.a(paramString1, 2);
    try
    {
      paramString2 = h.b(paramString2.getBytes("utf-8"), paramString1);
      paramString1 = new java/lang/String;
      paramString1.<init>(b.c(paramString2, 2));
      return paramString1;
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
        paramString1 = null;
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return o.a().a(paramContext, "UMC_KS_TIME_STAMP", paramString);
  }
  
  public static String b()
  {
    return new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date());
  }
  
  public static String b(Context paramContext)
  {
    return o.a().a(paramContext, "UMC_KS_CNONCE");
  }
  
  /* Error */
  public static String b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 108	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +8 -> 12
    //   7: ldc 19
    //   9: astore_3
    //   10: aload_3
    //   11: areturn
    //   12: new 110	org/json/JSONObject
    //   15: astore_3
    //   16: aload_3
    //   17: aload_0
    //   18: invokespecial 111	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   21: aload_3
    //   22: ldc 113
    //   24: invokevirtual 117	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   27: astore 5
    //   29: aload 5
    //   31: invokevirtual 123	org/json/JSONArray:length	()I
    //   34: istore_2
    //   35: ldc 19
    //   37: astore_0
    //   38: iconst_0
    //   39: istore_1
    //   40: aload_0
    //   41: astore_3
    //   42: iload_1
    //   43: iload_2
    //   44: if_icmpge -34 -> 10
    //   47: aload_0
    //   48: astore_3
    //   49: aload 5
    //   51: iload_1
    //   52: invokevirtual 127	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   55: astore 6
    //   57: aload_0
    //   58: astore_3
    //   59: new 129	java/lang/StringBuilder
    //   62: astore 4
    //   64: aload_0
    //   65: astore_3
    //   66: aload 4
    //   68: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   71: aload_0
    //   72: astore_3
    //   73: aload 4
    //   75: aload_0
    //   76: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload 6
    //   81: ldc -120
    //   83: invokevirtual 139	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   86: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: astore 4
    //   94: aload 4
    //   96: astore_0
    //   97: iload_1
    //   98: iload_2
    //   99: iconst_1
    //   100: isub
    //   101: if_icmpeq +35 -> 136
    //   104: aload 4
    //   106: astore_3
    //   107: new 129	java/lang/StringBuilder
    //   110: astore_0
    //   111: aload 4
    //   113: astore_3
    //   114: aload_0
    //   115: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   118: aload 4
    //   120: astore_3
    //   121: aload_0
    //   122: aload 4
    //   124: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc -114
    //   129: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: astore_0
    //   136: iinc 1 1
    //   139: goto -99 -> 40
    //   142: astore_0
    //   143: ldc 19
    //   145: astore_3
    //   146: aload_0
    //   147: invokevirtual 81	java/lang/Exception:printStackTrace	()V
    //   150: goto -140 -> 10
    //   153: astore_0
    //   154: goto -8 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	paramString	String
    //   39	98	1	i	int
    //   34	67	2	j	int
    //   9	137	3	localObject1	Object
    //   62	61	4	localObject2	Object
    //   27	23	5	localJSONArray	org.json.JSONArray
    //   55	25	6	localJSONObject	org.json.JSONObject
    // Exception table:
    //   from	to	target	type
    //   12	35	142	java/lang/Exception
    //   49	57	153	java/lang/Exception
    //   59	64	153	java/lang/Exception
    //   66	71	153	java/lang/Exception
    //   73	94	153	java/lang/Exception
    //   107	111	153	java/lang/Exception
    //   114	118	153	java/lang/Exception
    //   121	136	153	java/lang/Exception
  }
  
  public static String b(String paramString1, String paramString2)
  {
    return new String(b.c(h.a(paramString1.getBytes(), paramString2.getBytes()), 2));
  }
  
  public static boolean b(Context paramContext, String paramString)
  {
    return o.a().a(paramContext, "UMC_KS_CNONCE", paramString);
  }
  
  public static String c()
  {
    int j = 0;
    StringBuffer localStringBuffer = new StringBuffer();
    Random localRandom = new Random();
    localStringBuffer.append(new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
    for (int i = 0; i < 6; i++) {
      localStringBuffer.append("0123456789".charAt(localRandom.nextInt(10)));
    }
    for (i = j; i < 4 - "1".length(); i++) {
      localStringBuffer.append("0");
    }
    localStringBuffer.append("1");
    return localStringBuffer.toString();
  }
  
  public static String c(Context paramContext)
  {
    int i = r.b(paramContext);
    j.a("networkType", String.valueOf(i));
    if (i == -1)
    {
      j.d("LoginType", "无网络");
      paramContext = "-1";
    }
    for (;;)
    {
      return paramContext;
      if (i == 3)
      {
        j.d("LoginType", "wap接入");
        paramContext = "3";
      }
      else if (r.c(paramContext))
      {
        Log.e("LoginType", "数据短信");
        paramContext = "4";
      }
      else
      {
        Log.e("LoginType", "短信验证码方式");
        paramContext = "2";
      }
    }
  }
  
  public static boolean c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (boolean bool = false;; bool = Pattern.compile("^1[0-9]{10}$").matcher(paramString).matches()) {
      return bool;
    }
  }
  
  public static String d(Context paramContext)
  {
    String str2 = m.a(paramContext).a();
    String str1 = o.a().b(paramContext, "KEY_IMSI" + str2);
    long l = o.a().d(paramContext, "KEY_IMSI_TIME" + str2);
    if ((!"".equals(str1)) && (System.currentTimeMillis() - l < 82800000L)) {}
    for (paramContext = "0";; paramContext = "1") {
      return paramContext;
    }
  }
  
  public static String e(Context paramContext)
  {
    paramContext = r.d(paramContext);
    j.a("operator", paramContext);
    if ("1".equals(paramContext)) {
      paramContext = "106581021";
    }
    for (;;)
    {
      return paramContext;
      if ("3".equals(paramContext)) {
        paramContext = "1065987711";
      } else if ("2".equals(paramContext)) {
        paramContext = "1065553610039";
      } else {
        paramContext = "";
      }
    }
  }
  
  public static boolean f(Context paramContext)
  {
    if ("0".equals(l.a(paramContext).g())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */