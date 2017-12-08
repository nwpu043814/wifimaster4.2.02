package com.analysis.model;

import com.analysis.common.tools.c;
import com.analysis.common.upload.h;
import com.analysis.common.upload.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class g
  implements com.analysis.common.a, k, Serializable
{
  private static final long l = 8021629764230533353L;
  public String f;
  String g;
  long h = Long.MIN_VALUE;
  long i = Long.MIN_VALUE;
  public String j;
  String k;
  
  private void a(long paramLong)
  {
    this.h = paramLong;
  }
  
  private void a(String paramString)
  {
    this.f = paramString;
  }
  
  private void b(long paramLong)
  {
    this.i = paramLong;
  }
  
  private void b(String paramString)
  {
    this.g = paramString;
  }
  
  private void c(String paramString)
  {
    this.k = paramString;
  }
  
  private void d(String paramString)
  {
    this.j = paramString;
  }
  
  public final void a(h paramh)
  {
    if (c.a(paramh.c)) {
      paramh.c = new ArrayList();
    }
    paramh.c.add(this);
  }
  
  public String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("session_id", this.f);
        localJSONObject.put("page_name", this.g);
        if (this.h != Long.MIN_VALUE) {
          continue;
        }
        str = "null";
        localJSONObject.put("page_start_time", str);
        if (this.i != Long.MIN_VALUE) {
          continue;
        }
        str = "null";
        localJSONObject.put("page_end_time", str);
        localJSONObject.put("login_name", this.j);
        localJSONObject.put("appId", this.k);
      }
      catch (JSONException localJSONException)
      {
        String str;
        localJSONException.printStackTrace();
        continue;
      }
      com.analysis.common.tools.a.a("ALInterface", "page = " + localJSONObject.toString());
      return localJSONObject.toString();
      str = c.b(this.h);
      continue;
      str = c.b(this.i);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/model/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */