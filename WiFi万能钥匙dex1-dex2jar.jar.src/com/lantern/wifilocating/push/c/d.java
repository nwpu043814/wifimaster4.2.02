package com.lantern.wifilocating.push.c;

import com.lantern.wifilocating.push.c.a.a;
import com.lantern.wifilocating.push.util.j;
import org.json.JSONObject;

public class d
  extends a
{
  private long a = 60000L;
  private boolean b = true;
  private boolean c = true;
  private long d = 7200000L;
  private boolean e = false;
  private boolean f = true;
  private boolean g = true;
  private boolean h = true;
  private boolean i = true;
  
  public final long a()
  {
    return this.a;
  }
  
  protected final void a(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    if (paramJSONObject == null) {}
    do
    {
      do
      {
        return;
        this.a = paramJSONObject.optLong("interval", this.a);
        paramJSONObject = paramJSONObject.optString("event", null);
      } while (paramJSONObject == null);
      paramJSONObject = j.a(paramJSONObject);
    } while (paramJSONObject == null);
    int j;
    if (this.b)
    {
      j = 1;
      label52:
      if (paramJSONObject.optInt("network.switch.bcast", j) != 1) {
        break label255;
      }
      bool1 = true;
      label65:
      this.b = bool1;
      if (!this.e) {
        break label260;
      }
      j = 1;
      label79:
      if (paramJSONObject.optInt("screen.light", j) != 1) {
        break label265;
      }
      bool1 = true;
      label92:
      this.e = bool1;
      if (!this.f) {
        break label270;
      }
      j = 1;
      label106:
      if (paramJSONObject.optInt("power.ext", j) != 1) {
        break label275;
      }
      bool1 = true;
      label119:
      this.f = bool1;
      if (!this.h) {
        break label280;
      }
      j = 1;
      label133:
      if (paramJSONObject.optInt("toggle.fore", j) != 1) {
        break label285;
      }
      bool1 = true;
      label146:
      this.h = bool1;
      if (!this.i) {
        break label290;
      }
      j = 1;
      label160:
      if (paramJSONObject.optInt("reconn", j) != 1) {
        break label295;
      }
      bool1 = true;
      label173:
      this.i = bool1;
      if (!this.g) {
        break label300;
      }
      j = 1;
      label187:
      if (paramJSONObject.optInt("startup", j) != 1) {
        break label305;
      }
      bool1 = true;
      label200:
      this.g = bool1;
      if (!this.c) {
        break label310;
      }
      j = 1;
      label214:
      if (paramJSONObject.optInt("repeat", j) != 1) {
        break label315;
      }
    }
    label255:
    label260:
    label265:
    label270:
    label275:
    label280:
    label285:
    label290:
    label295:
    label300:
    label305:
    label310:
    label315:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.c = bool1;
      this.d = paramJSONObject.optLong("repeat.time", this.d);
      break;
      j = 0;
      break label52;
      bool1 = false;
      break label65;
      j = 0;
      break label79;
      bool1 = false;
      break label92;
      j = 0;
      break label106;
      bool1 = false;
      break label119;
      j = 0;
      break label133;
      bool1 = false;
      break label146;
      j = 0;
      break label160;
      bool1 = false;
      break label173;
      j = 0;
      break label187;
      bool1 = false;
      break label200;
      j = 0;
      break label214;
    }
  }
  
  public final boolean b()
  {
    return this.e;
  }
  
  public final boolean c()
  {
    return this.h;
  }
  
  public final boolean d()
  {
    return this.i;
  }
  
  public final boolean e()
  {
    return this.f;
  }
  
  public final boolean f()
  {
    return this.c;
  }
  
  public final long g()
  {
    return this.d;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifilocating/push/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */