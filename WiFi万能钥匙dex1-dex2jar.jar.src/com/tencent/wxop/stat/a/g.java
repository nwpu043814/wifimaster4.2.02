package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.r;
import com.tencent.wxop.stat.f;
import org.json.JSONObject;

public final class g
  extends d
{
  private static String a = null;
  private String aR = null;
  private String aS = null;
  
  public g(Context paramContext, int paramInt, f paramf)
  {
    super(paramContext, paramInt, paramf);
    this.aR = com.tencent.wxop.stat.g.r(paramContext).b();
    if (a == null) {
      a = l.C(paramContext);
    }
  }
  
  public final e ac()
  {
    return e.bE;
  }
  
  public final void b(String paramString)
  {
    this.aS = paramString;
  }
  
  public final boolean b(JSONObject paramJSONObject)
  {
    r.a(paramJSONObject, "op", a);
    r.a(paramJSONObject, "cn", this.aR);
    paramJSONObject.put("sp", this.aS);
    return true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */