package com.wifi.connect.plugin.magickey.b;

import com.bluefay.b.h;
import com.lantern.core.model.e;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  extends e
{
  public String a;
  public long b;
  public boolean c;
  public ArrayList<a> d;
  private int e = -1;
  
  public b()
  {
    super(null);
    this.d = new ArrayList();
  }
  
  public b(b paramb)
  {
    super(null);
    this.a = paramb.a;
    this.b = paramb.b;
    this.c = paramb.c;
    this.e = -1;
    this.d = new ArrayList();
    this.d.add(paramb.j());
  }
  
  public final a a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.d.size())) {}
    for (a locala = (a)this.d.get(paramInt);; locala = null) {
      return locala;
    }
  }
  
  public final JSONObject f()
  {
    JSONObject localJSONObject = super.f();
    JSONArray localJSONArray;
    try
    {
      localJSONObject.put("qid", this.a);
      localJSONObject.put("sysTime", this.b);
      localJSONObject.put("s", this.c);
      localJSONArray = new org/json/JSONArray;
      localJSONArray.<init>();
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
      {
        localJSONArray.put((a)localIterator.next());
        continue;
        return localJSONObject;
      }
    }
    catch (JSONException localJSONException)
    {
      h.a(localJSONException);
    }
    for (;;)
    {
      localJSONObject.put("aps", localJSONArray);
    }
  }
  
  public final boolean g()
  {
    if (("H.RISK.0001".equals(a())) || ("H.AP.RISK.0002".equals(a())) || ("H.AP.RISK.0001".equals(a()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final boolean h()
  {
    if (this.d.size() > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final a i()
  {
    this.e += 1;
    return a(this.e);
  }
  
  public final a j()
  {
    return a(this.e);
  }
  
  public final boolean k()
  {
    int i = this.e + 1;
    if ((i >= 0) && (i < this.d.size())) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final int l()
  {
    return this.e;
  }
  
  public final void m()
  {
    this.e = -1;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */