package com.analysis.model.crash;

import com.analysis.common.a;
import com.analysis.common.upload.h;
import com.analysis.common.upload.k;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class b
  implements a, k, Serializable
{
  private static final long v = 5714218034204312861L;
  public String f;
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
  public String s;
  public String t;
  public String u;
  
  public final void a(h paramh) {}
  
  public String toString()
  {
    com.analysis.common.b localb = new com.analysis.common.b();
    localb.a("crashType:");
    localb.a(this.f);
    localb.a(";");
    localb.a("platform:");
    localb.a(this.h);
    localb.a(";");
    localb.a("sdkVersion:");
    localb.a(this.i);
    localb.a(";");
    localb.a("appVersion:");
    localb.a(this.j);
    localb.a(";");
    localb.a("width_height:");
    localb.a(this.k);
    localb.a(";");
    localb.a("freeMemory:");
    localb.a(this.p);
    localb.a(";");
    localb.a("totalMemory:");
    localb.a(this.q);
    localb.a(";");
    localb.a("cpuFrequency:");
    localb.a(this.l);
    localb.a(";");
    localb.a("cpuModel:");
    localb.a(this.m);
    localb.a(";");
    localb.a("deviceBrand:");
    localb.a(this.n);
    localb.a(";");
    localb.a("deviceModel:");
    localb.a(this.o);
    localb.a(";");
    localb.a("detail:");
    localb.a(this.r);
    localb.a(";");
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("session_id", this.s);
      localJSONObject.put("login_name", this.t);
      localJSONObject.put("appId", this.u);
      localJSONObject.put("happen_time", this.g);
      localb.a("memo:");
      localb.a(localJSONObject.toString());
      return localb.toString();
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/model/crash/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */