package com.alipay.sdk.f.a;

import android.content.Context;
import com.alipay.sdk.f.b;
import com.alipay.sdk.f.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.message.BasicHeader;
import org.json.JSONObject;

public final class c
  extends d
{
  public final b a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, "http://mcgw.alipay.com/sdklog.do", true);
  }
  
  protected final String a(String paramString, JSONObject paramJSONObject)
  {
    return paramString;
  }
  
  protected final List a(boolean paramBoolean, String paramString)
  {
    paramString = new ArrayList();
    paramString.add(new BasicHeader("msp-gzip", String.valueOf(paramBoolean)));
    paramString.add(new BasicHeader("content-type", "application/octet-stream"));
    paramString.add(new BasicHeader("des-mode", "CBC"));
    return paramString;
  }
  
  protected final JSONObject a()
  {
    return null;
  }
  
  protected final String c()
  {
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("api_name", "/sdk/log");
    localHashMap1.put("api_version", "1.0.0");
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("log_v", "1.0");
    return a(localHashMap1, localHashMap2);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/f/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */