package com.lantern.wifilocating.push.c;

import com.lantern.wifilocating.push.c.a.a;
import org.json.JSONObject;

public class b
  extends a
{
  private int a = 5;
  private long b = 60000L;
  private boolean c = true;
  private boolean d = false;
  
  public final int a()
  {
    return this.a;
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    if (paramJSONObject == null) {
      return;
    }
    this.a = paramJSONObject.optInt("reqitv", this.a);
    this.b = paramJSONObject.optLong("mreqitvt", this.b);
    int i;
    if (this.c)
    {
      i = 1;
      label45:
      if (paramJSONObject.optInt("switch", i) != 1) {
        break label99;
      }
      bool1 = true;
      label58:
      this.c = bool1;
      if (!this.d) {
        break label104;
      }
      i = 1;
      label72:
      if (paramJSONObject.optInt("hrl", i) != 1) {
        break label109;
      }
    }
    label99:
    label104:
    label109:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.d = bool1;
      break;
      i = 0;
      break label45;
      bool1 = false;
      break label58;
      i = 0;
      break label72;
    }
  }
  
  public final long b()
  {
    return this.b;
  }
  
  public final boolean c()
  {
    return this.c;
  }
  
  public final boolean d()
  {
    return this.d;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/c/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */