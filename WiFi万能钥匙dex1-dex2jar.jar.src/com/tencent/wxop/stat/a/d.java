package com.tencent.wxop.stat.a;

import android.content.Context;
import com.tencent.a.a.a.a.h;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.r;
import com.tencent.wxop.stat.f;
import com.tencent.wxop.stat.t;
import org.json.JSONObject;

public abstract class d
{
  protected static String bt = null;
  protected int L;
  protected long aZ;
  protected String b = null;
  protected int bf;
  protected com.tencent.wxop.stat.b.c bp = null;
  protected String bq = null;
  protected String br = null;
  protected String bs = null;
  protected boolean bu = false;
  protected Context bv;
  private f bw = null;
  
  d(Context paramContext, int paramInt, f paramf)
  {
    this.bv = paramContext;
    this.aZ = (System.currentTimeMillis() / 1000L);
    this.L = paramInt;
    this.br = com.tencent.wxop.stat.c.e(paramContext);
    this.bs = l.D(paramContext);
    this.b = com.tencent.wxop.stat.c.d(paramContext);
    if (paramf != null)
    {
      this.bw = paramf;
      if (l.e(paramf.S())) {
        this.b = paramf.S();
      }
      if (l.e(paramf.T())) {
        this.br = paramf.T();
      }
      if (l.e(paramf.getVersion())) {
        this.bs = paramf.getVersion();
      }
      this.bu = paramf.U();
    }
    this.bq = com.tencent.wxop.stat.c.g(paramContext);
    this.bp = t.s(paramContext).t(paramContext);
    if (ac() != e.bF) {}
    for (this.bf = l.K(paramContext).intValue();; this.bf = (-e.bF.r()))
    {
      if (!h.e(bt))
      {
        paramContext = com.tencent.wxop.stat.c.h(paramContext);
        bt = paramContext;
        if (!l.e(paramContext)) {
          bt = "0";
        }
      }
      return;
    }
  }
  
  private boolean c(JSONObject paramJSONObject)
  {
    boolean bool1 = false;
    try
    {
      r.a(paramJSONObject, "ky", this.b);
      paramJSONObject.put("et", ac().r());
      if (this.bp != null)
      {
        paramJSONObject.put("ui", this.bp.b());
        r.a(paramJSONObject, "mc", this.bp.ar());
        int i = this.bp.as();
        paramJSONObject.put("ut", i);
        if ((i == 0) && (l.N(this.bv) == 1)) {
          paramJSONObject.put("ia", 1);
        }
      }
      r.a(paramJSONObject, "cui", this.bq);
      if (ac() != e.by)
      {
        r.a(paramJSONObject, "av", this.bs);
        r.a(paramJSONObject, "ch", this.br);
      }
      if (this.bu) {
        paramJSONObject.put("impt", 1);
      }
      r.a(paramJSONObject, "mid", bt);
      paramJSONObject.put("idx", this.bf);
      paramJSONObject.put("si", this.L);
      paramJSONObject.put("ts", this.aZ);
      paramJSONObject.put("dts", l.a(this.bv, false));
      boolean bool2 = b(paramJSONObject);
      bool1 = bool2;
    }
    catch (Throwable paramJSONObject)
    {
      for (;;) {}
    }
    return bool1;
  }
  
  public final Context J()
  {
    return this.bv;
  }
  
  public final boolean X()
  {
    return this.bu;
  }
  
  public abstract e ac();
  
  public final long ad()
  {
    return this.aZ;
  }
  
  public final f ae()
  {
    return this.bw;
  }
  
  public final String af()
  {
    try
    {
      Object localObject = new org/json/JSONObject;
      ((JSONObject)localObject).<init>();
      c((JSONObject)localObject);
      localObject = ((JSONObject)localObject).toString();
      return (String)localObject;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str = "";
      }
    }
  }
  
  public abstract boolean b(JSONObject paramJSONObject);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */