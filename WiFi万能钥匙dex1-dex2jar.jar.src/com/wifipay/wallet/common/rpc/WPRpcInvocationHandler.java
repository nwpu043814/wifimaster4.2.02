package com.wifipay.wallet.common.rpc;

import com.shengpay.crypto.JNICrypto;
import com.wifipay.common.a.e;
import com.wifipay.common.logging.Logger;
import com.wifipay.common.net.RpcInvocationHandler;
import com.wifipay.common.security.Base64;
import com.wifipay.wallet.common.info.AppInfo;
import com.wifipay.wallet.common.info.DeviceInfo;
import com.wifipay.wallet.common.info.b;
import java.math.BigInteger;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPublicKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class WPRpcInvocationHandler
  extends RpcInvocationHandler
{
  private static final String HEADER_KEY_APP_ID = "app_id";
  private static final String HEADER_KEY_APP_VERSION = "app_version";
  private static final String HEADER_KEY_BINDCARDSOURCE = "bindCardSource";
  private static final String HEADER_KEY_BRAND = "brand";
  private static final String HEADER_KEY_CERTNO = "certSerialNo";
  private static final String HEADER_KEY_DEVICE_ID = "app_device_info";
  private static final String HEADER_KEY_IMEI = "imei";
  private static final String HEADER_KEY_LATI = "lati";
  private static final String HEADER_KEY_LONGI = "longi";
  private static final String HEADER_KEY_MAPSP = "mapSP";
  private static final String HEADER_KEY_MODEL = "model";
  private static final String HEADER_KEY_OS_TYPE = "app_os_type";
  private static final String HEADER_KEY_OS_VERSION = "os_version";
  private static final String HEADER_KEY_OUT_TOKEN = "outToken";
  private static final String HEADER_KEY_SOURCE_APP = "sourceApp";
  private static final String HEADER_KEY_TOKEN = "app_access_token";
  private static final String HEADER_KEY_UHID = "uhId";
  private static final int KEY_LENGTH = 24;
  private static final String PARAM_KEY_ENDATA = "enData";
  private static final String PARAM_KEY_ENKEY = "enKey";
  private static final String PARAM_KEY_MAC = "mac";
  private static final String PARAM_KEY_PARAM = "param";
  
  public WPRpcInvocationHandler(String paramString)
  {
    super(paramString);
  }
  
  public WPRpcInvocationHandler(String paramString, Boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  private String getX509Certificate()
  {
    String str = b.a().u();
    if (str != null) {}
    for (str = ((RSAPublicKey)Base64.getX509CertFromBase64Cert(str).getPublicKey()).getModulus().toString(10);; str = "") {
      return str;
    }
  }
  
  private String toJson(Map<String, String> paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0)) {}
    JSONObject localJSONObject;
    for (paramMap = null;; paramMap = localJSONObject.toString()) {
      for (;;)
      {
        return paramMap;
        try
        {
          localJSONObject = new org/json/JSONObject;
          localJSONObject.<init>();
          Iterator localIterator = paramMap.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localJSONObject.put(str, paramMap.get(str));
          }
        }
        catch (JSONException paramMap)
        {
          paramMap.printStackTrace();
          paramMap = null;
        }
      }
    }
  }
  
  protected Map<String, String> defaultHeaders(String paramString)
  {
    paramString = new HashMap();
    paramString.put("app_os_type", AppInfo.INSTANCE.getOSType());
    paramString.put("imei", DeviceInfo.INSTANCE.getIMEI());
    paramString.put("app_device_info", DeviceInfo.INSTANCE.getMacAddress());
    paramString.put("os_version", DeviceInfo.INSTANCE.getOsVersion());
    paramString.put("app_access_token", b.a().g());
    paramString.put("app_id", AppInfo.INSTANCE.getAppId());
    paramString.put("app_version", AppInfo.INSTANCE.getAppVersion());
    paramString.put("sourceApp", AppInfo.INSTANCE.getSourceApp());
    paramString.put("outToken", b.a().l());
    paramString.put("uhId", b.a().m());
    paramString.put("longi", b.a().r());
    paramString.put("lati", b.a().s());
    paramString.put("mapSP", b.a().t());
    paramString.put("certSerialNo", b.a().v());
    paramString.put("bindCardSource", b.a().w());
    Logger.v("requestHeader params == %s", new Object[] { paramString.toString() });
    return paramString;
  }
  
  protected Map<String, String> defaultParams(String paramString)
  {
    if (!paramString.equals("/getKey.htm"))
    {
      paramString = new HashMap(2);
      paramString.put("_", String.valueOf(System.currentTimeMillis()));
    }
    for (;;)
    {
      return paramString;
      paramString = super.defaultParams(paramString);
    }
  }
  
  protected Map encryptParams(Map paramMap)
  {
    if ((paramMap == null) || (paramMap.size() == 0) || (paramMap.containsKey("skipTime"))) {
      paramMap = super.encryptParams(paramMap);
    }
    for (;;)
    {
      return paramMap;
      Object localObject = new HashMap();
      String str2 = toJson(paramMap);
      Logger.v("wujun params = %s", new Object[] { str2 });
      String str1 = e.a(24);
      str2 = JNICrypto.sdpEnc3(str2, str1);
      str1 = JNICrypto.sdpEnc2(str1, getX509Certificate());
      ((HashMap)localObject).put("enKey", str1);
      ((HashMap)localObject).put("enData", str2);
      ((HashMap)localObject).put("mac", JNICrypto.sdpEnc1(str2 + str1));
      localObject = toJson((Map)localObject);
      paramMap.clear();
      paramMap.put("param", localObject);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/common/rpc/WPRpcInvocationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */