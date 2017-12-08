package com.tencent.wxop.stat.b;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.wxop.stat.g;
import com.tencent.wxop.stat.t;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONObject;

final class e
{
  int L = Build.VERSION.SDK_INT;
  String M = Build.MODEL;
  String a;
  int aQ = 0;
  String aR = null;
  String aS = null;
  String ab = Build.MANUFACTURER;
  String al;
  String b = "2.0.3";
  String bq = Locale.getDefault().getLanguage();
  String br;
  String bs;
  String bt;
  DisplayMetrics cA;
  Context cB = null;
  private String cC = null;
  private String cD = null;
  private String cE = null;
  private String cF = null;
  
  private e(Context paramContext)
  {
    this.cB = paramContext.getApplicationContext();
    this.cA = l.x(this.cB);
    this.a = l.D(this.cB);
    this.br = com.tencent.wxop.stat.c.e(this.cB);
    this.bs = l.C(this.cB);
    this.bt = TimeZone.getDefault().getID();
    this.aQ = l.au();
    this.al = l.H(this.cB);
    this.aR = this.cB.getPackageName();
    if (this.L >= 14) {
      this.cC = l.M(this.cB);
    }
    this.cD = l.az().toString();
    this.cE = l.L(this.cB);
    this.cF = l.ax();
    this.aS = l.R(this.cB);
  }
  
  final void a(JSONObject paramJSONObject, Thread paramThread)
  {
    if (paramThread == null)
    {
      if (this.cA != null)
      {
        paramJSONObject.put("sr", this.cA.widthPixels + "*" + this.cA.heightPixels);
        paramJSONObject.put("dpi", this.cA.xdpi + "*" + this.cA.ydpi);
      }
      if (g.r(this.cB).W())
      {
        paramThread = new JSONObject();
        r.a(paramThread, "bs", r.U(this.cB));
        r.a(paramThread, "ss", r.V(this.cB));
        if (paramThread.length() > 0) {
          r.a(paramJSONObject, "wf", paramThread.toString());
        }
      }
      paramThread = r.X(this.cB);
      if ((paramThread != null) && (paramThread.length() > 0)) {
        r.a(paramJSONObject, "wflist", paramThread.toString());
      }
      r.a(paramJSONObject, "sen", this.cC);
    }
    for (;;)
    {
      r.a(paramJSONObject, "pcn", l.I(this.cB));
      r.a(paramJSONObject, "osn", Build.VERSION.RELEASE);
      r.a(paramJSONObject, "av", this.a);
      r.a(paramJSONObject, "ch", this.br);
      r.a(paramJSONObject, "mf", this.ab);
      r.a(paramJSONObject, "sv", this.b);
      r.a(paramJSONObject, "osd", Build.DISPLAY);
      r.a(paramJSONObject, "prod", Build.PRODUCT);
      r.a(paramJSONObject, "tags", Build.TAGS);
      r.a(paramJSONObject, "id", Build.ID);
      r.a(paramJSONObject, "fng", Build.FINGERPRINT);
      r.a(paramJSONObject, "lch", this.aS);
      r.a(paramJSONObject, "ov", Integer.toString(this.L));
      paramJSONObject.put("os", 1);
      r.a(paramJSONObject, "op", this.bs);
      r.a(paramJSONObject, "lg", this.bq);
      r.a(paramJSONObject, "md", this.M);
      r.a(paramJSONObject, "tz", this.bt);
      if (this.aQ != 0) {
        paramJSONObject.put("jb", this.aQ);
      }
      r.a(paramJSONObject, "sd", this.al);
      r.a(paramJSONObject, "apn", this.aR);
      r.a(paramJSONObject, "cpu", this.cD);
      r.a(paramJSONObject, "abi", Build.CPU_ABI);
      r.a(paramJSONObject, "abi2", Build.CPU_ABI2);
      r.a(paramJSONObject, "ram", this.cE);
      r.a(paramJSONObject, "rom", this.cF);
      return;
      r.a(paramJSONObject, "thn", paramThread.getName());
      r.a(paramJSONObject, "qq", com.tencent.wxop.stat.c.f(this.cB));
      r.a(paramJSONObject, "cui", com.tencent.wxop.stat.c.g(this.cB));
      if ((l.e(this.cE)) && (this.cE.split("/").length == 2)) {
        r.a(paramJSONObject, "fram", this.cE.split("/")[0]);
      }
      if ((l.e(this.cF)) && (this.cF.split("/").length == 2)) {
        r.a(paramJSONObject, "from", this.cF.split("/")[0]);
      }
      if (t.s(this.cB).t(this.cB) != null) {
        paramJSONObject.put("ui", t.s(this.cB).t(this.cB).b());
      }
      r.a(paramJSONObject, "mid", com.tencent.wxop.stat.c.h(this.cB));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/b/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */