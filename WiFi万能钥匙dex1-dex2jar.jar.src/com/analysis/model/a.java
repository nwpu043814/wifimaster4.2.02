package com.analysis.model;

import com.analysis.common.c;
import com.analysis.common.upload.h;
import com.analysis.common.upload.k;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
  implements com.analysis.common.a, k, Serializable
{
  private static final long s = 649874151670557943L;
  public String f = c.c();
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  public String l;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  public String r;
  
  public final void a(h paramh)
  {
    paramh.a = this;
  }
  
  public final String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("download_time", this.f);
      localJSONObject.put("sdk_version", this.g);
      localJSONObject.put("device_brand", this.h);
      localJSONObject.put("device_model", this.i);
      localJSONObject.put("device_width_height", this.j);
      localJSONObject.put("app_version", this.k);
      localJSONObject.put("channel", this.l);
      localJSONObject.put("imei", this.m);
      localJSONObject.put("imsi", this.n);
      localJSONObject.put("mac", this.o);
      localJSONObject.put("android_id", this.p);
      localJSONObject.put("login_name", this.q);
      localJSONObject.put("appId", this.r);
      com.analysis.common.tools.a.a("ALInterface", "appinfo = " + localJSONObject.toString());
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/model/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */