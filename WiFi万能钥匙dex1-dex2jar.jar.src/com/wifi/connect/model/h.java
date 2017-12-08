package com.wifi.connect.model;

import com.lantern.core.model.e;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class h
  extends e
{
  private ArrayList<a> a = new ArrayList();
  
  private h(JSONObject paramJSONObject)
  {
    super(paramJSONObject);
  }
  
  public static h c(String paramString)
  {
    JSONObject localJSONObject = new JSONObject(paramString);
    paramString = new h(localJSONObject);
    JSONArray localJSONArray = localJSONObject.optJSONArray("list");
    if ((localJSONArray == null) || (localJSONArray.length() == 0)) {}
    for (;;)
    {
      return paramString;
      int i = 0;
      int j = localJSONArray.length();
      while (i < j)
      {
        localJSONObject = localJSONArray.optJSONObject(i);
        a locala = new a();
        locala.a = localJSONObject.optString("id", "");
        locala.b = localJSONObject.optString("title", "");
        locala.c = localJSONObject.optString("source", "");
        locala.d = localJSONObject.optString("color", "");
        locala.e = localJSONObject.optString("url", "");
        paramString.a.add(locala);
        i++;
      }
    }
  }
  
  public final ArrayList<a> g()
  {
    return this.a;
  }
  
  public static final class a
  {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/model/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */