package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.c.c;
import com.alipay.sdk.j.e;
import com.alipay.sdk.j.h;
import com.alipay.sdk.j.i;
import com.alipay.sdk.j.k;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

public class PayTask
{
  static final Object a = e.class;
  private Activity b;
  private com.alipay.sdk.k.a c;
  private String d = "wappaygw.alipay.com/service/rest.htm";
  private String e = "mclient.alipay.com/service/rest.htm";
  private String f = "mclient.alipay.com/home/exterfaceAssign.htm";
  private Map g = new HashMap();
  
  public PayTask(Activity paramActivity)
  {
    this.b = paramActivity;
    com.alipay.sdk.h.b localb = com.alipay.sdk.h.b.a();
    Activity localActivity = this.b;
    c.a();
    localb.a(localActivity);
    com.alipay.sdk.app.a.a.a(paramActivity);
    this.c = new com.alipay.sdk.k.a(paramActivity, "去支付宝付款");
  }
  
  private String a(com.alipay.sdk.g.b paramb)
  {
    String[] arrayOfString = paramb.b;
    paramb = new Intent(this.b, H5PayActivity.class);
    ??? = new Bundle();
    ((Bundle)???).putString("url", arrayOfString[0]);
    if (arrayOfString.length == 2) {
      ((Bundle)???).putString("cookie", arrayOfString[1]);
    }
    paramb.putExtras((Bundle)???);
    this.b.startActivity(paramb);
    synchronized (a)
    {
      try
      {
        a.wait();
        ??? = j.a;
        paramb = (com.alipay.sdk.g.b)???;
        if (TextUtils.isEmpty((CharSequence)???)) {
          paramb = j.a();
        }
      }
      catch (InterruptedException paramb)
      {
        for (;;)
        {
          paramb = j.a();
        }
      }
      return paramb;
    }
  }
  
  /* Error */
  private String a(String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: invokespecial 134	com/alipay/sdk/app/PayTask:a	()V
    //   6: new 136	com/alipay/sdk/f/a/d
    //   9: astore 4
    //   11: aload 4
    //   13: invokespecial 137	com/alipay/sdk/f/a/d:<init>	()V
    //   16: aload 4
    //   18: aload_0
    //   19: getfield 48	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   22: invokevirtual 141	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   25: aload_1
    //   26: invokevirtual 144	com/alipay/sdk/f/a/d:a	(Landroid/content/Context;Ljava/lang/String;)Lcom/alipay/sdk/f/b;
    //   29: invokevirtual 149	com/alipay/sdk/f/b:a	()Lorg/json/JSONObject;
    //   32: ldc -105
    //   34: invokevirtual 157	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   37: ldc -97
    //   39: invokevirtual 157	org/json/JSONObject:optJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   42: invokestatic 162	com/alipay/sdk/g/b:a	(Lorg/json/JSONObject;)Ljava/util/List;
    //   45: astore_1
    //   46: iconst_0
    //   47: istore_2
    //   48: iload_2
    //   49: aload_1
    //   50: invokeinterface 168 1 0
    //   55: if_icmpge +266 -> 321
    //   58: aload_1
    //   59: iload_2
    //   60: invokeinterface 172 2 0
    //   65: checkcast 78	com/alipay/sdk/g/b
    //   68: getfield 175	com/alipay/sdk/g/b:a	Lcom/alipay/sdk/g/a;
    //   71: getstatic 179	com/alipay/sdk/g/a:c	Lcom/alipay/sdk/g/a;
    //   74: if_acmpne +70 -> 144
    //   77: aload_1
    //   78: iload_2
    //   79: invokeinterface 172 2 0
    //   84: checkcast 78	com/alipay/sdk/g/b
    //   87: getfield 81	com/alipay/sdk/g/b:b	[Ljava/lang/String;
    //   90: astore 4
    //   92: aload 4
    //   94: arraylength
    //   95: iconst_3
    //   96: if_icmpne +48 -> 144
    //   99: ldc -75
    //   101: aload 4
    //   103: iconst_0
    //   104: aaload
    //   105: invokestatic 185	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   108: ifeq +36 -> 144
    //   111: invokestatic 53	com/alipay/sdk/h/b:a	()Lcom/alipay/sdk/h/b;
    //   114: getfield 188	com/alipay/sdk/h/b:a	Landroid/content/Context;
    //   117: astore 5
    //   119: invokestatic 193	com/alipay/sdk/i/b:a	()Lcom/alipay/sdk/i/b;
    //   122: astore 6
    //   124: aload 4
    //   126: iconst_1
    //   127: aaload
    //   128: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   131: ifne +13 -> 144
    //   134: aload 4
    //   136: iconst_2
    //   137: aaload
    //   138: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   141: ifeq +9 -> 150
    //   144: iinc 2 1
    //   147: goto -99 -> 48
    //   150: aload 6
    //   152: aload 4
    //   154: iconst_1
    //   155: aaload
    //   156: putfield 194	com/alipay/sdk/i/b:a	Ljava/lang/String;
    //   159: aload 6
    //   161: aload 4
    //   163: iconst_2
    //   164: aaload
    //   165: putfield 196	com/alipay/sdk/i/b:b	Ljava/lang/String;
    //   168: new 198	com/alipay/sdk/i/a
    //   171: astore 4
    //   173: aload 4
    //   175: aload 5
    //   177: invokespecial 200	com/alipay/sdk/i/a:<init>	(Landroid/content/Context;)V
    //   180: aload 4
    //   182: aload 5
    //   184: invokestatic 205	com/alipay/sdk/j/b:a	(Landroid/content/Context;)Lcom/alipay/sdk/j/b;
    //   187: invokevirtual 206	com/alipay/sdk/j/b:a	()Ljava/lang/String;
    //   190: aload 5
    //   192: invokestatic 205	com/alipay/sdk/j/b:a	(Landroid/content/Context;)Lcom/alipay/sdk/j/b;
    //   195: invokevirtual 208	com/alipay/sdk/j/b:b	()Ljava/lang/String;
    //   198: aload 6
    //   200: getfield 194	com/alipay/sdk/i/b:a	Ljava/lang/String;
    //   203: aload 6
    //   205: getfield 196	com/alipay/sdk/i/b:b	Ljava/lang/String;
    //   208: invokevirtual 211	com/alipay/sdk/i/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   211: aload 4
    //   213: invokevirtual 214	com/alipay/sdk/i/a:close	()V
    //   216: goto -72 -> 144
    //   219: astore 4
    //   221: getstatic 219	com/alipay/sdk/app/k:d	Lcom/alipay/sdk/app/k;
    //   224: getfield 223	com/alipay/sdk/app/k:h	I
    //   227: invokestatic 226	com/alipay/sdk/app/k:a	(I)Lcom/alipay/sdk/app/k;
    //   230: astore_1
    //   231: ldc -28
    //   233: aload 4
    //   235: invokestatic 231	com/alipay/sdk/app/a/a:a	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   238: aload_0
    //   239: invokespecial 233	com/alipay/sdk/app/PayTask:b	()V
    //   242: aload_1
    //   243: astore 4
    //   245: aload_1
    //   246: ifnonnull +14 -> 260
    //   249: getstatic 235	com/alipay/sdk/app/k:b	Lcom/alipay/sdk/app/k;
    //   252: getfield 223	com/alipay/sdk/app/k:h	I
    //   255: invokestatic 226	com/alipay/sdk/app/k:a	(I)Lcom/alipay/sdk/app/k;
    //   258: astore 4
    //   260: aload 4
    //   262: getfield 223	com/alipay/sdk/app/k:h	I
    //   265: aload 4
    //   267: getfield 238	com/alipay/sdk/app/k:i	Ljava/lang/String;
    //   270: ldc -16
    //   272: invokestatic 243	com/alipay/sdk/app/j:a	(ILjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   275: astore_1
    //   276: aload_1
    //   277: areturn
    //   278: astore 5
    //   280: aload 4
    //   282: invokevirtual 214	com/alipay/sdk/i/a:close	()V
    //   285: goto -141 -> 144
    //   288: astore_1
    //   289: ldc -11
    //   291: ldc -9
    //   293: aload_1
    //   294: invokestatic 250	com/alipay/sdk/app/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   297: aload_0
    //   298: invokespecial 233	com/alipay/sdk/app/PayTask:b	()V
    //   301: aconst_null
    //   302: astore_1
    //   303: goto -61 -> 242
    //   306: astore_1
    //   307: aload 4
    //   309: invokevirtual 214	com/alipay/sdk/i/a:close	()V
    //   312: aload_1
    //   313: athrow
    //   314: astore_1
    //   315: aload_0
    //   316: invokespecial 233	com/alipay/sdk/app/PayTask:b	()V
    //   319: aload_1
    //   320: athrow
    //   321: aload_0
    //   322: invokespecial 233	com/alipay/sdk/app/PayTask:b	()V
    //   325: iload_3
    //   326: istore_2
    //   327: iload_2
    //   328: aload_1
    //   329: invokeinterface 168 1 0
    //   334: if_icmpge +50 -> 384
    //   337: aload_1
    //   338: iload_2
    //   339: invokeinterface 172 2 0
    //   344: checkcast 78	com/alipay/sdk/g/b
    //   347: getfield 175	com/alipay/sdk/g/b:a	Lcom/alipay/sdk/g/a;
    //   350: getstatic 252	com/alipay/sdk/g/a:b	Lcom/alipay/sdk/g/a;
    //   353: if_acmpne +25 -> 378
    //   356: aload_0
    //   357: aload_1
    //   358: iload_2
    //   359: invokeinterface 172 2 0
    //   364: checkcast 78	com/alipay/sdk/g/b
    //   367: invokespecial 254	com/alipay/sdk/app/PayTask:a	(Lcom/alipay/sdk/g/b;)Ljava/lang/String;
    //   370: astore_1
    //   371: aload_0
    //   372: invokespecial 233	com/alipay/sdk/app/PayTask:b	()V
    //   375: goto -99 -> 276
    //   378: iinc 2 1
    //   381: goto -54 -> 327
    //   384: aload_0
    //   385: invokespecial 233	com/alipay/sdk/app/PayTask:b	()V
    //   388: aconst_null
    //   389: astore_1
    //   390: goto -148 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	393	0	this	PayTask
    //   0	393	1	paramString	String
    //   47	332	2	i	int
    //   1	325	3	j	int
    //   9	203	4	localObject1	Object
    //   219	15	4	localIOException	java.io.IOException
    //   243	65	4	localObject2	Object
    //   117	74	5	localContext	android.content.Context
    //   278	1	5	localException	Exception
    //   122	82	6	localb	com.alipay.sdk.i.b
    // Exception table:
    //   from	to	target	type
    //   6	46	219	java/io/IOException
    //   48	144	219	java/io/IOException
    //   150	180	219	java/io/IOException
    //   211	216	219	java/io/IOException
    //   280	285	219	java/io/IOException
    //   307	314	219	java/io/IOException
    //   321	325	219	java/io/IOException
    //   327	371	219	java/io/IOException
    //   180	211	278	java/lang/Exception
    //   6	46	288	java/lang/Throwable
    //   48	144	288	java/lang/Throwable
    //   150	180	288	java/lang/Throwable
    //   211	216	288	java/lang/Throwable
    //   280	285	288	java/lang/Throwable
    //   307	314	288	java/lang/Throwable
    //   321	325	288	java/lang/Throwable
    //   327	371	288	java/lang/Throwable
    //   180	211	306	finally
    //   6	46	314	finally
    //   48	144	314	finally
    //   150	180	314	finally
    //   211	216	314	finally
    //   221	238	314	finally
    //   280	285	314	finally
    //   289	297	314	finally
    //   307	314	314	finally
    //   321	325	314	finally
    //   327	371	314	finally
  }
  
  private void a()
  {
    if (this.c != null) {
      this.c.a();
    }
  }
  
  private static boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString, StringBuilder paramStringBuilder, Map paramMap, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    String str;
    if (i < j)
    {
      str = paramVarArgs[i];
      if (TextUtils.isEmpty((CharSequence)paramMap.get(str))) {}
    }
    for (paramMap = (String)paramMap.get(str);; paramMap = "")
    {
      if (TextUtils.isEmpty(paramMap))
      {
        if (!paramBoolean2) {
          break label109;
        }
        paramBoolean1 = false;
        return paramBoolean1;
        i++;
        break;
      }
      if (paramBoolean1) {
        paramStringBuilder.append("&").append(paramString).append("=\"").append(paramMap).append("\"");
      }
      for (;;)
      {
        label109:
        paramBoolean1 = true;
        break;
        paramStringBuilder.append(paramString).append("=\"").append(paramMap).append("\"");
      }
    }
  }
  
  private void b()
  {
    if (this.c != null)
    {
      this.c.b();
      this.c = null;
    }
  }
  
  public String fetchOrderInfoFromH5PayUrl(String paramString)
  {
    for (;;)
    {
      try
      {
        if (TextUtils.isEmpty(paramString)) {
          continue;
        }
        localObject1 = paramString.trim();
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>("https://");
        if (!((String)localObject1).startsWith(this.d))
        {
          localObject3 = new java/lang/StringBuilder;
          ((StringBuilder)localObject3).<init>("http://");
          if (!((String)localObject1).startsWith(this.d)) {
            continue;
          }
        }
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>("(http|https)://");
        localObject3 = ((String)localObject1).replaceFirst(this.d + "\\?", "").trim();
        if (TextUtils.isEmpty((CharSequence)localObject3)) {
          continue;
        }
        localObject1 = k.a("<request_token>", "</request_token>", (String)k.a((String)localObject3).get("req_data"));
        paramString = new java/lang/StringBuilder;
        paramString.<init>("_input_charset=\"utf-8\"&ordertoken=\"");
        localObject1 = paramString.append((String)localObject1).append("\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"");
        paramString = new com/alipay/sdk/h/a;
        paramString.<init>(this.b);
        paramString = paramString.a("sc", "h5tonative") + "\"";
      }
      catch (Throwable paramString)
      {
        Object localObject1;
        Object localObject3;
        boolean bool;
        Map localMap;
        Object localObject2;
        paramString = "";
        continue;
      }
      finally {}
      return paramString;
      localObject3 = new java/lang/StringBuilder;
      ((StringBuilder)localObject3).<init>("https://");
      if (!((String)localObject1).startsWith(this.e))
      {
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>("http://");
        if (!((String)localObject1).startsWith(this.e)) {}
      }
      else
      {
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>("(http|https)://");
        localObject3 = ((String)localObject1).replaceFirst(this.e + "\\?", "").trim();
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject1 = k.a("<request_token>", "</request_token>", (String)k.a((String)localObject3).get("req_data"));
          paramString = new java/lang/StringBuilder;
          paramString.<init>("_input_charset=\"utf-8\"&ordertoken=\"");
          localObject1 = paramString.append((String)localObject1).append("\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"");
          paramString = new com/alipay/sdk/h/a;
          paramString.<init>(this.b);
          paramString = paramString.a("sc", "h5tonative") + "\"";
          continue;
        }
      }
      localObject3 = new java/lang/StringBuilder;
      ((StringBuilder)localObject3).<init>("https://");
      if (!((String)localObject1).startsWith(this.f))
      {
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>("http://");
        if (!((String)localObject1).startsWith(this.f)) {}
      }
      else if (((String)localObject1).contains("alipay.wap.create.direct.pay.by.user"))
      {
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>("(http|https)://");
        bool = TextUtils.isEmpty(((String)localObject1).replaceFirst(this.f + "\\?", "").trim());
        if (!bool) {
          try
          {
            localObject1 = new org/json/JSONObject;
            ((JSONObject)localObject1).<init>();
            ((JSONObject)localObject1).put("url", paramString);
            localObject3 = new com/alipay/sdk/h/a;
            ((com.alipay.sdk.h.a)localObject3).<init>(this.b);
            ((JSONObject)localObject1).put("bizcontext", ((com.alipay.sdk.h.a)localObject3).a("sc", "h5tonative"));
            localObject3 = new java/lang/StringBuilder;
            ((StringBuilder)localObject3).<init>("new_external_info==");
            localObject1 = ((JSONObject)localObject1).toString();
            paramString = (String)localObject1;
          }
          catch (Throwable localThrowable) {}
        }
      }
      if (!Pattern.compile("^(http|https)://(maliprod\\.alipay\\.com\\/w\\/trade_pay\\.do.?|mali\\.alipay\\.com\\/w\\/trade_pay\\.do.?|mclient\\.alipay\\.com\\/w\\/trade_pay\\.do.?)").matcher(paramString).find()) {
        continue;
      }
      paramString = k.a("?", "", paramString);
      if (TextUtils.isEmpty(paramString)) {
        continue;
      }
      localMap = k.a(paramString);
      localObject3 = new java/lang/StringBuilder;
      ((StringBuilder)localObject3).<init>();
      if (!a(false, true, "trade_no", (StringBuilder)localObject3, localMap, new String[] { "trade_no", "alipay_trade_no" })) {
        continue;
      }
      a(true, false, "pay_phase_id", (StringBuilder)localObject3, localMap, new String[] { "payPhaseId", "pay_phase_id", "out_relation_id" });
      ((StringBuilder)localObject3).append("&biz_sub_type=\"TRADE\"");
      ((StringBuilder)localObject3).append("&biz_type=\"trade\"");
      localObject2 = (String)localMap.get("app_name");
      if ((TextUtils.isEmpty((CharSequence)localObject2)) && (!TextUtils.isEmpty((CharSequence)localMap.get("cid"))))
      {
        paramString = "ali1688";
        localObject2 = new java/lang/StringBuilder;
        ((StringBuilder)localObject2).<init>("&app_name=\"");
        ((StringBuilder)localObject3).append(paramString + "\"");
        if (!a(true, true, "extern_token", (StringBuilder)localObject3, localMap, new String[] { "extern_token", "cid", "sid", "s_id" })) {
          paramString = "";
        }
      }
      else
      {
        paramString = (String)localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        if (TextUtils.isEmpty((CharSequence)localMap.get("sid")))
        {
          paramString = (String)localObject2;
          if (TextUtils.isEmpty((CharSequence)localMap.get("s_id"))) {
            continue;
          }
        }
        paramString = "tb";
        continue;
      }
      a(true, false, "appenv", (StringBuilder)localObject3, localMap, new String[] { "appenv" });
      ((StringBuilder)localObject3).append("&pay_channel_id=\"alipay_sdk\"");
      localObject2 = new com/alipay/sdk/app/PayTask$a;
      ((a)localObject2).<init>(this, (byte)0);
      ((a)localObject2).a = ((String)localMap.get("return_url"));
      ((a)localObject2).b = ((String)localMap.get("pay_order_id"));
      paramString = new java/lang/StringBuilder;
      paramString.<init>();
      localObject3 = paramString.append(((StringBuilder)localObject3).toString()).append("&bizcontext=\"");
      paramString = new com/alipay/sdk/h/a;
      paramString.<init>(this.b);
      paramString = paramString.a("sc", "h5tonative") + "\"";
      this.g.put(paramString, localObject2);
    }
  }
  
  public String fetchTradeToken()
  {
    try
    {
      String str = h.b(this.b.getApplicationContext(), "pref_trade_token", "");
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public String getVersion()
  {
    return "15.2.8";
  }
  
  public com.alipay.sdk.j.a h5Pay(String paramString, boolean paramBoolean)
  {
    int i = 0;
    for (;;)
    {
      com.alipay.sdk.j.a locala;
      String[] arrayOfString;
      Object localObject1;
      int j;
      String str1;
      try
      {
        locala = new com/alipay/sdk/j/a;
        locala.<init>();
      }
      finally {}
      try
      {
        paramString.trim();
        arrayOfString = pay(paramString, paramBoolean).split(";");
        localObject1 = new java/util/HashMap;
        ((HashMap)localObject1).<init>();
        j = arrayOfString.length;
        if (i < j)
        {
          String str2 = arrayOfString[i];
          str1 = str2.substring(0, str2.indexOf("={"));
          Object localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>();
          localObject2 = str1 + "={";
          int k = str2.indexOf((String)localObject2);
          ((Map)localObject1).put(str1, str2.substring(((String)localObject2).length() + k, str2.lastIndexOf("}")));
          i++;
          continue;
        }
        if (((Map)localObject1).containsKey("resultStatus")) {
          locala.b((String)((Map)localObject1).get("resultStatus"));
        }
        if (!((Map)localObject1).containsKey("callBackUrl")) {
          continue;
        }
        locala.a((String)((Map)localObject1).get("callBackUrl"));
      }
      catch (Throwable paramString)
      {
        continue;
        continue;
      }
      return locala;
      paramBoolean = ((Map)localObject1).containsKey("result");
      if (paramBoolean)
      {
        try
        {
          str1 = (String)((Map)localObject1).get("result");
          if (str1.length() <= 15) {
            break label500;
          }
          localObject1 = (a)this.g.get(paramString);
          if (localObject1 != null)
          {
            if (TextUtils.isEmpty(((a)localObject1).b))
            {
              locala.a(((a)localObject1).a);
              this.g.remove(paramString);
              continue;
            }
            locala.a(com.alipay.sdk.c.a.b().b.replace("$OrderId$", ((a)localObject1).b));
            continue;
          }
        }
        catch (Throwable paramString) {}
        localObject1 = k.a("&callBackUrl=\"", "\"", str1);
        paramString = (String)localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        localObject1 = k.a("&call_back_url=\"", "\"", str1);
        paramString = (String)localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        localObject1 = k.a("&return_url=\"", "\"", str1);
        paramString = (String)localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        localObject1 = URLDecoder.decode(k.a("&return_url=", "&", str1), "utf-8");
        paramString = (String)localObject1;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          break;
        }
        paramString = URLDecoder.decode(k.a("&callBackUrl=", "&", str1), "utf-8");
        localObject1 = paramString;
        if (TextUtils.isEmpty(paramString)) {
          localObject1 = com.alipay.sdk.c.a.b().b;
        }
        locala.a(URLDecoder.decode((String)localObject1, "utf-8"));
        continue;
        label500:
        localObject1 = (a)this.g.get(paramString);
        if (localObject1 != null)
        {
          locala.a(((a)localObject1).a);
          this.g.remove(paramString);
        }
      }
    }
  }
  
  /* Error */
  public String pay(String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aload_0
    //   7: monitorenter
    //   8: iload_2
    //   9: ifeq +7 -> 16
    //   12: aload_0
    //   13: invokespecial 134	com/alipay/sdk/app/PayTask:a	()V
    //   16: new 325	com/alipay/sdk/h/a
    //   19: astore 5
    //   21: aload 5
    //   23: aload_0
    //   24: getfield 48	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   27: invokespecial 326	com/alipay/sdk/h/a:<init>	(Landroid/content/Context;)V
    //   30: aload 5
    //   32: aload_1
    //   33: invokevirtual 510	com/alipay/sdk/h/a:a	(Ljava/lang/String;)Ljava/lang/String;
    //   36: astore 9
    //   38: aload 9
    //   40: ldc_w 512
    //   43: invokevirtual 337	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   46: ifne +155 -> 201
    //   49: aload_0
    //   50: getfield 48	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   53: invokestatic 515	com/alipay/sdk/j/k:c	(Landroid/content/Context;)Z
    //   56: ifeq +145 -> 201
    //   59: new 22	com/alipay/sdk/j/e
    //   62: astore 5
    //   64: aload_0
    //   65: getfield 48	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   68: astore 10
    //   70: new 517	com/alipay/sdk/app/i
    //   73: astore 8
    //   75: aload 8
    //   77: aload_0
    //   78: invokespecial 519	com/alipay/sdk/app/i:<init>	(Lcom/alipay/sdk/app/PayTask;)V
    //   81: aload 5
    //   83: aload 10
    //   85: aload 8
    //   87: invokespecial 522	com/alipay/sdk/j/e:<init>	(Landroid/app/Activity;Lcom/alipay/sdk/j/e$a;)V
    //   90: aload 5
    //   92: aload 9
    //   94: invokevirtual 523	com/alipay/sdk/j/e:a	(Ljava/lang/String;)Ljava/lang/String;
    //   97: astore 8
    //   99: aload 5
    //   101: aconst_null
    //   102: putfield 525	com/alipay/sdk/j/e:a	Landroid/app/Activity;
    //   105: aload 8
    //   107: ldc_w 527
    //   110: invokestatic 185	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   113: ifne +88 -> 201
    //   116: aload 8
    //   118: astore 5
    //   120: aload 8
    //   122: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   125: ifeq +8 -> 133
    //   128: invokestatic 125	com/alipay/sdk/app/j:a	()Ljava/lang/String;
    //   131: astore 5
    //   133: aload_0
    //   134: getfield 48	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   137: invokevirtual 141	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   140: astore 8
    //   142: aload 5
    //   144: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   147: ifeq +65 -> 212
    //   150: aload 7
    //   152: invokestatic 122	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   155: ifne +13 -> 168
    //   158: aload 8
    //   160: ldc_w 421
    //   163: aload 7
    //   165: invokestatic 530	com/alipay/sdk/j/h:a	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    //   168: invokestatic 484	com/alipay/sdk/c/a:b	()Lcom/alipay/sdk/c/a;
    //   171: aload_0
    //   172: getfield 48	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   175: invokevirtual 141	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   178: invokevirtual 531	com/alipay/sdk/c/a:a	(Landroid/content/Context;)V
    //   181: aload_0
    //   182: invokespecial 233	com/alipay/sdk/app/PayTask:b	()V
    //   185: aload_0
    //   186: getfield 48	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   189: invokevirtual 141	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   192: aload_1
    //   193: invokestatic 534	com/alipay/sdk/app/a/a:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   196: aload_0
    //   197: monitorexit
    //   198: aload 5
    //   200: areturn
    //   201: aload_0
    //   202: aload 9
    //   204: invokespecial 535	com/alipay/sdk/app/PayTask:a	(Ljava/lang/String;)Ljava/lang/String;
    //   207: astore 5
    //   209: goto -76 -> 133
    //   212: aload 5
    //   214: ldc_w 440
    //   217: invokevirtual 444	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   220: astore 9
    //   222: iconst_0
    //   223: istore_3
    //   224: aload 6
    //   226: astore 7
    //   228: iload_3
    //   229: aload 9
    //   231: arraylength
    //   232: if_icmpge -82 -> 150
    //   235: aload 6
    //   237: astore 7
    //   239: aload 9
    //   241: iload_3
    //   242: aaload
    //   243: ldc_w 537
    //   246: invokevirtual 295	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   249: ifeq +111 -> 360
    //   252: aload 6
    //   254: astore 7
    //   256: aload 9
    //   258: iload_3
    //   259: aaload
    //   260: ldc_w 459
    //   263: invokevirtual 540	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   266: ifeq +94 -> 360
    //   269: aload 9
    //   271: iload_3
    //   272: aaload
    //   273: bipush 8
    //   275: aload 9
    //   277: iload_3
    //   278: aaload
    //   279: invokevirtual 457	java/lang/String:length	()I
    //   282: iconst_1
    //   283: isub
    //   284: invokevirtual 454	java/lang/String:substring	(II)Ljava/lang/String;
    //   287: ldc_w 268
    //   290: invokevirtual 444	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   293: astore 10
    //   295: iconst_0
    //   296: istore 4
    //   298: aload 6
    //   300: astore 7
    //   302: iload 4
    //   304: aload 10
    //   306: arraylength
    //   307: if_icmpge +53 -> 360
    //   310: aload 10
    //   312: iload 4
    //   314: aaload
    //   315: ldc_w 542
    //   318: invokevirtual 295	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   321: ifeq +49 -> 370
    //   324: aload 10
    //   326: iload 4
    //   328: aaload
    //   329: ldc_w 278
    //   332: invokevirtual 540	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   335: ifeq +35 -> 370
    //   338: aload 10
    //   340: iload 4
    //   342: aaload
    //   343: bipush 13
    //   345: aload 10
    //   347: iload 4
    //   349: aaload
    //   350: invokevirtual 457	java/lang/String:length	()I
    //   353: iconst_1
    //   354: isub
    //   355: invokevirtual 454	java/lang/String:substring	(II)Ljava/lang/String;
    //   358: astore 7
    //   360: iinc 3 1
    //   363: aload 7
    //   365: astore 6
    //   367: goto -143 -> 224
    //   370: aload 10
    //   372: iload 4
    //   374: aaload
    //   375: ldc_w 544
    //   378: invokevirtual 295	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   381: ifeq +18 -> 399
    //   384: aload 10
    //   386: iload 4
    //   388: aaload
    //   389: bipush 12
    //   391: invokevirtual 547	java/lang/String:substring	(I)Ljava/lang/String;
    //   394: astore 7
    //   396: goto -36 -> 360
    //   399: iinc 4 1
    //   402: goto -104 -> 298
    //   405: astore 6
    //   407: ldc -11
    //   409: ldc_w 549
    //   412: aload 6
    //   414: invokestatic 250	com/alipay/sdk/app/a/a:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   417: goto -249 -> 168
    //   420: astore 5
    //   422: invokestatic 125	com/alipay/sdk/app/j:a	()Ljava/lang/String;
    //   425: astore 5
    //   427: invokestatic 484	com/alipay/sdk/c/a:b	()Lcom/alipay/sdk/c/a;
    //   430: aload_0
    //   431: getfield 48	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   434: invokevirtual 141	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   437: invokevirtual 531	com/alipay/sdk/c/a:a	(Landroid/content/Context;)V
    //   440: aload_0
    //   441: invokespecial 233	com/alipay/sdk/app/PayTask:b	()V
    //   444: aload_0
    //   445: getfield 48	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   448: invokevirtual 141	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   451: aload_1
    //   452: invokestatic 534	com/alipay/sdk/app/a/a:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   455: goto -259 -> 196
    //   458: astore_1
    //   459: aload_0
    //   460: monitorexit
    //   461: aload_1
    //   462: athrow
    //   463: astore 5
    //   465: invokestatic 484	com/alipay/sdk/c/a:b	()Lcom/alipay/sdk/c/a;
    //   468: aload_0
    //   469: getfield 48	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   472: invokevirtual 141	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   475: invokevirtual 531	com/alipay/sdk/c/a:a	(Landroid/content/Context;)V
    //   478: aload_0
    //   479: invokespecial 233	com/alipay/sdk/app/PayTask:b	()V
    //   482: aload_0
    //   483: getfield 48	com/alipay/sdk/app/PayTask:b	Landroid/app/Activity;
    //   486: invokevirtual 141	android/app/Activity:getApplicationContext	()Landroid/content/Context;
    //   489: aload_1
    //   490: invokestatic 534	com/alipay/sdk/app/a/a:a	(Landroid/content/Context;Ljava/lang/String;)V
    //   493: aload 5
    //   495: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	496	0	this	PayTask
    //   0	496	1	paramString	String
    //   0	496	2	paramBoolean	boolean
    //   223	138	3	i	int
    //   296	104	4	j	int
    //   19	194	5	localObject1	Object
    //   420	1	5	localThrowable1	Throwable
    //   425	1	5	str	String
    //   463	31	5	localObject2	Object
    //   1	365	6	localObject3	Object
    //   405	8	6	localThrowable2	Throwable
    //   4	391	7	localObject4	Object
    //   73	86	8	localObject5	Object
    //   36	240	9	localObject6	Object
    //   68	317	10	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   142	150	405	java/lang/Throwable
    //   150	168	405	java/lang/Throwable
    //   212	222	405	java/lang/Throwable
    //   228	235	405	java/lang/Throwable
    //   239	252	405	java/lang/Throwable
    //   256	295	405	java/lang/Throwable
    //   302	360	405	java/lang/Throwable
    //   370	396	405	java/lang/Throwable
    //   16	116	420	java/lang/Throwable
    //   120	133	420	java/lang/Throwable
    //   133	142	420	java/lang/Throwable
    //   201	209	420	java/lang/Throwable
    //   407	417	420	java/lang/Throwable
    //   12	16	458	finally
    //   168	196	458	finally
    //   427	455	458	finally
    //   465	496	458	finally
    //   16	116	463	finally
    //   120	133	463	finally
    //   133	142	463	finally
    //   142	150	463	finally
    //   150	168	463	finally
    //   201	209	463	finally
    //   212	222	463	finally
    //   228	235	463	finally
    //   239	252	463	finally
    //   256	295	463	finally
    //   302	360	463	finally
    //   370	396	463	finally
    //   407	417	463	finally
    //   422	427	463	finally
  }
  
  public Map payV2(String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = i.a(pay(paramString, paramBoolean));
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private final class a
  {
    String a = "";
    String b = "";
    
    private a() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/app/PayTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */