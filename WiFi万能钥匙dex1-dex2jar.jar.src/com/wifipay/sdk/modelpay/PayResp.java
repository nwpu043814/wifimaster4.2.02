package com.wifipay.sdk.modelpay;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONObject;

public class PayResp
{
  public int errCode;
  public String errMsg;
  public String ext;
  public String third_pkg;
  
  public static String getJSParams(PayResp paramPayResp)
  {
    if (paramPayResp == null) {
      paramPayResp = "";
    }
    for (;;)
    {
      return paramPayResp;
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        localJSONObject1.put("errMsg", paramPayResp.errMsg);
        localJSONObject1.put("errCode", paramPayResp.errCode);
        if (!TextUtils.isEmpty(paramPayResp.ext))
        {
          JSONObject localJSONObject2 = new org/json/JSONObject;
          localJSONObject2.<init>(paramPayResp.ext);
          localJSONObject1.put("ext", localJSONObject2);
        }
        paramPayResp = localJSONObject1.toString();
      }
      catch (Exception paramPayResp)
      {
        for (;;)
        {
          paramPayResp.printStackTrace();
        }
      }
    }
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    this.errCode = paramBundle.getInt("_wifipay_errCode", -2);
    this.errMsg = paramBundle.getString("_wifipay_errMsg");
    this.third_pkg = paramBundle.getString("_wifipay_third_pkg");
    this.ext = paramBundle.getString("_wifipay_ext");
  }
  
  public void toBundle(Bundle paramBundle)
  {
    paramBundle.putInt("_wifipay_errCode", this.errCode);
    paramBundle.putString("_wifipay_errMsg", this.errMsg);
    paramBundle.putString("_wifipay_third_pkg", this.third_pkg);
    paramBundle.putString("_wifipay_ext", this.ext);
  }
  
  public static abstract interface ErrCode
  {
    public static final int ERR_CANCEL = -3;
    public static final int ERR_FAIL = -2;
    public static final int ERR_OK = 0;
    public static final int ERR_UNKNOWN = -5;
    public static final int ERR_UNSUPPORT = -4;
    public static final int ERR_WAIT = -1;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/modelpay/PayResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */