package com.analysis.model;

import com.analysis.common.tools.c;
import com.analysis.common.upload.h;
import com.analysis.common.upload.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class l
  implements com.analysis.common.a, k, Serializable
{
  private static final long f = 1624661011713566106L;
  public String i;
  public long j = Long.MIN_VALUE;
  public long k = Long.MIN_VALUE;
  public long l = Long.MIN_VALUE;
  public String m;
  public String n;
  public String o;
  public String p;
  public String q;
  
  public void a(h paramh)
  {
    if (c.a(paramh.b)) {
      paramh.b = new ArrayList();
    }
    paramh.b.add(this);
  }
  
  public String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("session_id", this.i);
        if (this.j != Long.MIN_VALUE) {
          continue;
        }
        str = "null";
        localJSONObject.put("app_start_time", str);
        if (this.k != Long.MIN_VALUE) {
          continue;
        }
        str = "null";
        localJSONObject.put("session_start_time", str);
        if (this.l != Long.MIN_VALUE) {
          continue;
        }
        str = "null";
        localJSONObject.put("session_end_time", str);
        localJSONObject.put("netType", this.m);
        localJSONObject.put("location", this.n);
        localJSONObject.put("login_name", this.o);
        localJSONObject.put("imei", this.p);
        localJSONObject.put("appId", this.q);
      }
      catch (JSONException localJSONException)
      {
        String str;
        localJSONException.printStackTrace();
        continue;
      }
      com.analysis.common.tools.a.a("ALInterface", "session = " + localJSONObject.toString());
      return localJSONObject.toString();
      str = c.a(this.j);
      continue;
      str = c.a(this.k);
      continue;
      str = c.a(this.l);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/model/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */