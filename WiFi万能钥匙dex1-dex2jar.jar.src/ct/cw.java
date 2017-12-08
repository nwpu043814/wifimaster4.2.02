package ct;

import org.json.JSONException;
import org.json.JSONObject;

final class cw
{
  public double a;
  public double b;
  public double c;
  public float d;
  public String e;
  public String f;
  
  cw() {}
  
  public cw(JSONObject paramJSONObject)
  {
    try
    {
      this.a = paramJSONObject.getDouble("latitude");
      this.b = paramJSONObject.getDouble("longitude");
      this.c = paramJSONObject.getDouble("altitude");
      this.d = ((float)paramJSONObject.getDouble("accuracy"));
      this.e = paramJSONObject.optString("name");
      this.f = paramJSONObject.optString("addr");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      b.a.a("TencentJson", "json error", paramJSONObject);
      throw paramJSONObject;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */