package com.alipay.sdk.h;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.alipay.sdk.j.k;
import org.json.JSONObject;

public final class a
{
  private String a = "";
  private String b = "";
  private Context c = null;
  
  public a(Context paramContext)
  {
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      this.a = localPackageInfo.versionName;
      this.b = localPackageInfo.packageName;
      this.c = paramContext.getApplicationContext();
      return;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = null;
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = (String)localObject;
      return paramString1;
    }
    paramString1 = paramString1.split(paramString2);
    int i = 0;
    label23:
    if (i < paramString1.length) {
      if ((TextUtils.isEmpty(paramString1[i])) || (!paramString1[i].startsWith(paramString3))) {}
    }
    for (paramString1 = paramString1[i];; paramString1 = null)
    {
      break;
      i++;
      break label23;
    }
  }
  
  private String b(String paramString)
  {
    for (;;)
    {
      try
      {
        localObject = a(paramString, "&", "bizcontext=");
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        localObject = paramString + "&" + b("bizcontext=", "");
        paramString = (String)localObject;
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int i;
        String str2;
        String str1;
        StringBuilder localStringBuilder;
        continue;
      }
      return paramString;
      i = paramString.indexOf((String)localObject);
      str2 = paramString.substring(0, i);
      str1 = paramString.substring(i + ((String)localObject).length());
      localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localObject = str2 + b((String)localObject, "bizcontext=", "") + str1;
      paramString = (String)localObject;
    }
  }
  
  private String b(String paramString1, String paramString2)
  {
    String str = a("", "");
    return paramString1 + str + paramString2;
  }
  
  private String b(String paramString1, String paramString2, String paramString3)
  {
    paramString1 = paramString1.substring(paramString2.length());
    paramString1 = new JSONObject(paramString1.substring(0, paramString1.length() - paramString3.length()));
    if (!paramString1.has("appkey")) {
      paramString1.put("appkey", "2014052600006128");
    }
    if (!paramString1.has("ty")) {
      paramString1.put("ty", "and_lite");
    }
    if (!paramString1.has("sv")) {
      paramString1.put("sv", "h.a.3.2.8");
    }
    if ((!paramString1.has("an")) && ((!this.b.contains("setting")) || (!k.d(this.c)))) {
      paramString1.put("an", this.b);
    }
    if (!paramString1.has("av")) {
      paramString1.put("av", this.a);
    }
    if (!paramString1.has("sdk_start_time")) {
      paramString1.put("sdk_start_time", System.currentTimeMillis());
    }
    paramString1 = paramString1.toString();
    return paramString2 + paramString1 + paramString3;
  }
  
  private String c(String paramString)
  {
    for (;;)
    {
      try
      {
        str1 = a(paramString, "\"&", "bizcontext=\"");
        if (!TextUtils.isEmpty(str1)) {
          continue;
        }
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        localObject = paramString + "&" + b("bizcontext=\"", "\"");
        paramString = (String)localObject;
      }
      catch (Throwable localThrowable)
      {
        String str1;
        Object localObject;
        int i;
        String str2;
        StringBuilder localStringBuilder;
        continue;
      }
      return paramString;
      localObject = str1;
      if (!str1.endsWith("\""))
      {
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>();
        localObject = str1 + "\"";
      }
      i = paramString.indexOf((String)localObject);
      str1 = paramString.substring(0, i);
      str2 = paramString.substring(i + ((String)localObject).length());
      localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localObject = str1 + b((String)localObject, "bizcontext=\"", "\"") + str2;
      paramString = (String)localObject;
    }
  }
  
  public final String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = paramString;
    }
    for (;;)
    {
      return str;
      str = paramString;
      if (!paramString.startsWith("new_external_info=="))
      {
        if (!paramString.contains("\"&")) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label51;
          }
          str = b(paramString);
          break;
        }
        label51:
        str = c(paramString);
      }
    }
  }
  
  public final String a(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>();
      localJSONObject.put("appkey", "2014052600006128");
      localJSONObject.put("ty", "and_lite");
      localJSONObject.put("sv", "h.a.3.2.8");
      if ((!this.b.contains("setting")) || (!k.d(this.c))) {
        localJSONObject.put("an", this.b);
      }
      localJSONObject.put("av", this.a);
      localJSONObject.put("sdk_start_time", System.currentTimeMillis());
      if (!TextUtils.isEmpty(paramString1)) {
        localJSONObject.put(paramString1, paramString2);
      }
      paramString1 = localJSONObject.toString();
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        paramString1 = "";
      }
    }
    return paramString1;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */