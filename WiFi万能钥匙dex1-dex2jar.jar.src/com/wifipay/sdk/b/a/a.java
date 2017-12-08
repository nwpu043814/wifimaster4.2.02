package com.wifipay.sdk.b.a;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.wifipay.sdk.a.a.d;
import com.wifipay.sdk.app.g;
import com.wifipay.sdk.modelpay.PayResp;
import com.wifipay.sdk.util.c;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  extends com.wifipay.sdk.b.a
{
  private String b;
  
  public a(com.wifipay.sdk.app.a parama)
  {
    super(parama);
    this.b = parama.a.getIntent().getExtras().getString("_wifipay_merchantOrderNo");
  }
  
  private String a(String paramString1, String paramString2)
  {
    paramString2 = paramString2 + "={";
    int i = paramString1.indexOf(paramString2);
    return paramString1.substring(paramString2.length() + i, paramString1.lastIndexOf("}"));
  }
  
  private void a(String paramString)
  {
    if ((this.a == null) || (this.a.e())) {}
    for (;;)
    {
      return;
      this.a.h().execute(new b(this, paramString));
    }
  }
  
  public String a()
  {
    return "alipay";
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    Message localMessage = new Message();
    localMessage.what = 2;
    localMessage.obj = paramObject;
    this.a.c.a(localMessage);
  }
  
  public boolean a(Message paramMessage)
  {
    String str1;
    boolean bool;
    if (paramMessage.what == 2)
    {
      c.a("kyo", "alipay result = " + paramMessage.obj);
      str1 = (String)paramMessage.obj;
      if (TextUtils.isEmpty(str1))
      {
        a(com.wifipay.sdk.openapi.a.a(), true);
        bool = true;
      }
    }
    for (;;)
    {
      return bool;
      paramMessage = new PayResp();
      String[] arrayOfString = str1.split(";");
      HashMap localHashMap = new HashMap();
      localHashMap.put("merchantOrderNo", this.b);
      int j = arrayOfString.length;
      int i = 0;
      if (i < j)
      {
        String str2 = arrayOfString[i];
        if (str2.startsWith("resultStatus"))
        {
          str1 = a(str2, "resultStatus");
          localHashMap.put("alipayResultStatus", str1);
          if (!TextUtils.equals(str1, "9000")) {
            break label236;
          }
          paramMessage.errCode = 0;
          paramMessage.errMsg = a.d.u;
        }
        for (;;)
        {
          if (str2.startsWith("result")) {
            localHashMap.put("alipayResult", a(str2, "result"));
          }
          if (str2.startsWith("memo")) {
            localHashMap.put("alipayMemo", a(str2, "memo"));
          }
          i++;
          break;
          label236:
          if (TextUtils.equals(str1, "8000"))
          {
            paramMessage.errCode = -1;
            paramMessage.errMsg = a.d.x;
          }
          else if (TextUtils.equals(str1, "6001"))
          {
            paramMessage.errCode = -3;
            paramMessage.errMsg = a.d.w;
          }
          else
          {
            paramMessage.errCode = -2;
            paramMessage.errMsg = a.d.v;
          }
        }
      }
      com.wifipay.sdk.util.a.a(this.a.a, "alipay", localHashMap);
      a(paramMessage, true);
      bool = true;
      continue;
      bool = false;
    }
  }
  
  public boolean a(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      a(paramJSONObject.getString("paymentType"));
      bool = true;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        boolean bool = false;
      }
    }
    return bool;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */