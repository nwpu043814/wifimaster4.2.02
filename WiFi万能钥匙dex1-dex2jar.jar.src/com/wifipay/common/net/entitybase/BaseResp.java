package com.wifipay.common.net.entitybase;

import com.shengpay.crypto.JNICrypto;
import com.wifipay.common.logging.Logger;
import org.json.JSONException;
import org.json.JSONObject;

public class BaseResp
{
  public String resultCode;
  public String resultMessage;
  
  private void parseHead(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      this.resultCode = paramJSONObject.getString("resultCode");
      for (this.resultMessage = paramJSONObject.getString("resultMessage");; this.resultMessage = "系统异常 (errCode = 40000)")
      {
        return;
        this.resultCode = "40000";
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
      }
    }
  }
  
  public void parse(String paramString)
  {
    try
    {
      String[] arrayOfString = paramString.split("&");
      Object localObject = JNICrypto.sdpEnc4(Base64.decode(arrayOfString[0]));
      paramString = new java/lang/String;
      paramString.<init>((byte[])localObject, "UTF-8");
      boolean bool = JNICrypto.sdpEnc5(paramString, arrayOfString[1]);
      localObject = new org/json/JSONObject;
      ((JSONObject)localObject).<init>(paramString);
      parseHead((JSONObject)localObject, bool);
      if (bool) {
        parseBody((JSONObject)localObject);
      }
      paramString = new java/lang/StringBuilder;
      paramString.<init>("jsonObject= ");
      Logger.d(((JSONObject)localObject).toString(), new Object[0]);
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void parse(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      parse(paramString);
    }
    for (;;)
    {
      return;
      try
      {
        JSONObject localJSONObject = new org/json/JSONObject;
        localJSONObject.<init>(paramString);
        paramString = localJSONObject;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          paramString = null;
        }
      }
      parseHead(paramString, true);
      parseBody(paramString);
    }
  }
  
  public void parseBody(JSONObject paramJSONObject) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/common/net/entitybase/BaseResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */