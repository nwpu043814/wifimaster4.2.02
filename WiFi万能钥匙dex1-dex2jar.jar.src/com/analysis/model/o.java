package com.analysis.model;

import com.analysis.common.tools.c;
import com.analysis.common.upload.h;
import com.analysis.common.upload.k;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class o
  implements com.analysis.common.a, k, Serializable
{
  private static final long k = 5825751583581718143L;
  public int f;
  public int g;
  public String h;
  public String i;
  public String j;
  
  private o(int paramInt1, int paramInt2)
  {
    this.f = paramInt1;
    this.g = paramInt2;
  }
  
  public o(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
  {
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramString1;
    this.i = paramString2;
    this.j = paramString3;
  }
  
  public final void a(h paramh)
  {
    if (c.a(paramh.e)) {
      paramh.e = new ArrayList();
    }
    paramh.e.add(this);
  }
  
  public final String toString()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("session_id", this.h);
      localJSONObject.put("login_name", this.i);
      localJSONObject.put("uptr", this.f);
      localJSONObject.put("dntr", this.g);
      localJSONObject.put("appId", this.j);
      com.analysis.common.tools.a.a("ALInterface", "traffic = " + localJSONObject.toString());
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/analysis/model/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */