package com.wifi.connect.plugin.magickey.c;

import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public String A;
  public long B;
  public long C;
  public boolean D;
  public String E;
  public long F;
  public long G;
  public boolean H;
  public String I;
  public long J;
  public long K;
  public boolean L;
  public String M;
  public boolean N;
  public String O;
  public long P;
  public String Q;
  public String a = "wk" + UUID.randomUUID().toString();
  public long b = System.currentTimeMillis();
  public String c;
  public String d;
  public int e;
  public boolean f;
  public boolean g;
  public long h;
  public String i;
  public long j;
  public boolean k;
  public String l;
  public long m;
  public boolean n;
  public String o;
  public long p;
  public String q;
  public String r;
  public boolean s;
  public long t;
  public String u;
  public int v = -1;
  public int w = -1;
  public long x;
  public long y;
  public boolean z;
  
  private JSONObject b()
  {
    localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("eventId", this.a);
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        localJSONObject.put("autoconnTime", this.b);
        localJSONObject.put("autoconnSsid", this.c);
        localJSONObject.put("autoconnBssid", this.d);
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        localJSONObject.put("autoconnDbm", this.e);
        if (!this.f) {
          continue;
        }
        localObject1 = "1";
        localJSONObject.put("displayKeyIcon", localObject1);
        if (!this.g) {
          continue;
        }
        localObject1 = "1";
        localJSONObject.put("wkFlag", localObject1);
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        localJSONObject.put("dqryTime", this.h);
        if (this.i != null) {
          localJSONObject.put("keyusedType", this.i);
        }
        if (this.Q != null) {
          localJSONObject.put("dsendfailReason", this.Q);
        }
        if (this.j > 0L)
        {
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          localJSONObject.put("chknetTime", this.j);
          if (!this.k) {
            continue;
          }
          localObject1 = "S";
          localJSONObject.put("chknetStatus", localObject1);
          localJSONObject.put("chknetNetmodel", this.l);
        }
        if (this.m > 0L)
        {
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          localJSONObject.put("fixnetTime", this.m);
          if (!this.n) {
            continue;
          }
          localObject1 = "S";
          localJSONObject.put("fixnetResult", localObject1);
          localJSONObject.put("fixnetNetmodel", this.o);
        }
        if (this.p <= 0L) {
          continue;
        }
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        localJSONObject.put("retTime", this.p);
        localJSONObject.put("retStatus", this.q);
        localJSONObject.put("retReason", this.r);
        if (!this.s) {
          continue;
        }
        localObject1 = "1";
        localJSONObject.put("retKeyflag", localObject1);
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        localJSONObject.put("retSystime", this.t);
        localJSONObject.put("retQid", this.u);
        if (this.x <= 0L) {
          continue;
        }
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        localJSONObject.put("lconn1Time", this.x);
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>();
        localJSONObject.put("lconn1resultTime", this.y);
        if (!this.z) {
          continue;
        }
        localObject1 = "S";
      }
      catch (JSONException localJSONException)
      {
        Object localObject1;
        localJSONException.printStackTrace();
        Object localObject2 = null;
        continue;
        localObject2 = "F";
        continue;
        localJSONObject.put("lconn1Time", "");
        localJSONObject.put("lconn1resultTime", "");
        localJSONObject.put("lconn1resultStatus", "");
        localJSONObject.put("lconn1resultReason", "");
        continue;
        localObject2 = "F";
        continue;
        localJSONObject.put("lconn2Time", "");
        localJSONObject.put("lconn2resultTime", "");
        localJSONObject.put("lconn2resultStatus", "");
        localJSONObject.put("lconn2resultReason", "");
        continue;
        localObject2 = "F";
        continue;
        localJSONObject.put("nconn1Time", "");
        localJSONObject.put("nconn1resultTime", "");
        localJSONObject.put("nconn1resultStatus", "");
        localJSONObject.put("nconn1resultReason", "");
        continue;
        localObject2 = "F";
        continue;
        localJSONObject.put("nconn2Time", "");
        localJSONObject.put("nconn2resultTime", "");
        localJSONObject.put("nconn2resultStatus", "");
        localJSONObject.put("nconn2resultReason", "");
        continue;
        localObject2 = "F";
        continue;
        localJSONObject.put("connResultTime", "");
        localJSONObject.put("connResult", "");
        localJSONObject.put("connResultReason", "");
        localObject2 = localJSONObject;
        continue;
      }
      localJSONObject.put("lconn1resultStatus", localObject1);
      localJSONObject.put("lconn1resultReason", this.A);
      if (this.B <= 0L) {
        continue;
      }
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      localJSONObject.put("lconn2Time", this.B);
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      localJSONObject.put("lconn2resultTime", this.C);
      if (!this.D) {
        continue;
      }
      localObject1 = "S";
      localJSONObject.put("lconn2resultStatus", localObject1);
      localJSONObject.put("lconn2resultReason", this.E);
      if (this.F <= 0L) {
        continue;
      }
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      localJSONObject.put("nconn1Time", this.F);
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      localJSONObject.put("nconn1resultTime", this.G);
      if (!this.H) {
        continue;
      }
      localObject1 = "S";
      localJSONObject.put("nconn1resultStatus", localObject1);
      localJSONObject.put("nconn1resultReason", this.I);
      if (this.J <= 0L) {
        continue;
      }
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      localJSONObject.put("nconn2Time", this.J);
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      localJSONObject.put("nconn2resultTime", this.K);
      if (!this.L) {
        continue;
      }
      localObject1 = "S";
      localJSONObject.put("nconn2resultStatus", localObject1);
      localJSONObject.put("nconn2resultReason", this.M);
      if (this.w >= 0)
      {
        localJSONObject.put("usover", String.valueOf(this.v));
        localJSONObject.put("usoverdate", String.valueOf(this.w + 1));
      }
      if (this.P <= 0L) {
        continue;
      }
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      localJSONObject.put("connResultTime", this.P);
      if (!this.N) {
        continue;
      }
      localObject1 = "S";
      localJSONObject.put("connResult", localObject1);
      localJSONObject.put("connResultReason", this.O);
      localObject1 = localJSONObject;
      return (JSONObject)localObject1;
      localObject1 = "0";
      continue;
      localObject1 = "0";
      continue;
      localObject1 = "F";
      continue;
      localObject1 = "F";
      continue;
      localObject1 = "0";
      continue;
      localJSONObject.put("retTime", "");
      localJSONObject.put("retStatus", "");
      localJSONObject.put("retReason", "");
      localJSONObject.put("retKeyflag", "");
      localJSONObject.put("retSystime", "");
      localJSONObject.put("retQid", "");
    }
  }
  
  public final JSONArray a()
  {
    JSONObject localJSONObject = b();
    JSONArray localJSONArray;
    if (localJSONObject != null)
    {
      localJSONArray = new JSONArray();
      localJSONArray.put(localJSONObject);
    }
    for (;;)
    {
      return localJSONArray;
      localJSONArray = null;
    }
  }
  
  public final String toString()
  {
    Object localObject = b();
    if (localObject != null) {}
    for (localObject = ((JSONObject)localObject).toString();; localObject = "{}") {
      return (String)localObject;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */