package cm.pass.sdk.auth;

import android.util.Log;
import cm.pass.sdk.utils.r;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public static JSONObject a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    JSONObject localJSONObject = new JSONObject();
    paramString7 = r.a(paramString7);
    try
    {
      localJSONObject.put("resultcode", paramString1);
      localJSONObject.put("accessToken", paramString2);
      localJSONObject.put("uniqueid", paramString3);
      localJSONObject.put("expiresIn", paramString4);
      localJSONObject.put("passId", paramString6);
      localJSONObject.put("resultdesc", paramString5);
      localJSONObject.put("authType", paramString7);
      return localJSONObject;
    }
    catch (JSONException paramString1)
    {
      for (;;)
      {
        Log.e("AuthnResult", "JSONException", paramString1);
      }
    }
  }
  
  public static JSONObject a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("resultcode", paramString1);
      localJSONObject.put("resultdesc", paramString2);
      if (paramMap != null)
      {
        paramString1 = paramMap.keySet().iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (String)paramString1.next();
          localJSONObject.put(paramString2, paramMap.get(paramString2));
        }
      }
      return localJSONObject;
    }
    catch (JSONException paramString1)
    {
      Log.e("AuthnResult", "JSONException", paramString1);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/auth/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */