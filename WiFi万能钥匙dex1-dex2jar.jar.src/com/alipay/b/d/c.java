package com.alipay.b.d;

import android.content.Context;
import com.alipay.b.f.e;
import com.alipay.b.f.f;
import com.alipay.c.a.a.b.b;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class c
{
  public static Map a(Context paramContext)
  {
    b localb = b.a();
    HashMap localHashMap = new HashMap();
    Object localObject8 = e.a(paramContext);
    Object localObject2 = b.a(paramContext);
    Object localObject3 = b.b(paramContext);
    Object localObject4 = b.l(paramContext);
    Object localObject5 = b.o(paramContext);
    Object localObject7 = b.n(paramContext);
    Object localObject1;
    if (localObject8 != null)
    {
      localObject1 = localObject2;
      if (com.alipay.c.a.a.a.a.a((String)localObject2)) {
        localObject1 = ((f)localObject8).a();
      }
      localObject2 = localObject3;
      if (com.alipay.c.a.a.a.a.a((String)localObject3)) {
        localObject2 = ((f)localObject8).b();
      }
      localObject3 = localObject4;
      if (com.alipay.c.a.a.a.a.a((String)localObject4)) {
        localObject3 = ((f)localObject8).c();
      }
      localObject4 = localObject5;
      if (com.alipay.c.a.a.a.a.a((String)localObject5)) {
        localObject4 = ((f)localObject8).d();
      }
      localObject5 = localObject7;
      if (com.alipay.c.a.a.a.a.a((String)localObject7)) {
        localObject5 = ((f)localObject8).e();
      }
      Object localObject9 = localObject2;
      localObject8 = localObject1;
      localObject7 = localObject5;
      localObject1 = localObject4;
      localObject2 = localObject3;
      localObject3 = localObject9;
      localObject4 = localObject8;
    }
    for (;;)
    {
      localObject5 = new f((String)localObject4, (String)localObject3, (String)localObject2, (String)localObject1, (String)localObject7);
      if (paramContext != null) {}
      try
      {
        localObject8 = new org/json/JSONObject;
        ((JSONObject)localObject8).<init>();
        ((JSONObject)localObject8).put("imei", ((f)localObject5).a());
        ((JSONObject)localObject8).put("imsi", ((f)localObject5).b());
        ((JSONObject)localObject8).put("mac", ((f)localObject5).c());
        ((JSONObject)localObject8).put("bluetoothmac", ((f)localObject5).d());
        ((JSONObject)localObject8).put("gsi", ((f)localObject5).e());
        localObject5 = ((JSONObject)localObject8).toString();
        com.alipay.b.h.a.a("device_feature_file_name", "device_feature_file_key", (String)localObject5);
        com.alipay.b.h.a.a(paramContext, "device_feature_prefs_name", "device_feature_prefs_key", (String)localObject5);
        localHashMap.put("AD1", localObject4);
        localHashMap.put("AD2", localObject3);
        localHashMap.put("AD3", b.g(paramContext));
        localHashMap.put("AD5", b.i(paramContext));
        localHashMap.put("AD6", b.j(paramContext));
        localHashMap.put("AD7", b.k(paramContext));
        localHashMap.put("AD8", localObject2);
        localHashMap.put("AD9", b.m(paramContext));
        localHashMap.put("AD10", localObject7);
        localHashMap.put("AD11", b.d());
        localHashMap.put("AD12", localb.e());
        localHashMap.put("AD13", b.f());
        localHashMap.put("AD14", b.h());
        localHashMap.put("AD15", b.i());
        localHashMap.put("AD16", b.j());
        localHashMap.put("AD17", "");
        localHashMap.put("AD18", localObject1);
        localHashMap.put("AD19", b.p(paramContext));
        localHashMap.put("AD20", b.k());
        localHashMap.put("AD21", b.f(paramContext));
        localHashMap.put("AD22", "");
        localHashMap.put("AD23", b.l());
        localHashMap.put("AD24", com.alipay.c.a.a.a.a.f(b.h(paramContext)));
        localHashMap.put("AD26", b.e(paramContext));
        localHashMap.put("AD27", b.q());
        localHashMap.put("AD28", b.s());
        localHashMap.put("AD29", b.u());
        localHashMap.put("AD30", b.r());
        localHashMap.put("AD31", b.t());
        localHashMap.put("AD32", b.o());
        localHashMap.put("AD33", b.p());
        localHashMap.put("AD34", b.s(paramContext));
        localHashMap.put("AD35", b.t(paramContext));
        localHashMap.put("AD36", b.r(paramContext));
        localHashMap.put("AD37", b.n());
        localHashMap.put("AD38", b.m());
        localHashMap.put("AD39", b.c(paramContext));
        localHashMap.put("AD40", b.d(paramContext));
        localHashMap.put("AD41", b.b());
        localHashMap.put("AD42", b.c());
        localHashMap.put("AL3", b.q(paramContext));
        return localHashMap;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.alipay.b.c.a.a(localException);
        }
      }
      localObject1 = localException;
      Object localObject6 = localObject4;
      localObject4 = localObject2;
      localObject2 = localObject6;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/b/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */