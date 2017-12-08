package com.lantern.auth.a;

import android.content.Context;
import android.text.TextUtils;
import com.lantern.core.h;
import com.lantern.core.k;
import com.lantern.core.model.g;
import com.lantern.core.o;
import com.lantern.core.p;
import java.util.HashMap;
import org.json.JSONObject;

final class e
  implements com.bluefay.b.a
{
  e(a parama) {}
  
  public final void a(int paramInt, String paramString, Object paramObject)
  {
    a.f(this.a);
    a.a(this.a, "4");
    Object localObject1;
    Object localObject2;
    if ((paramInt == 1) && (paramObject != null))
    {
      localObject1 = (JSONObject)paramObject;
      p.g(a.b(this.a), ((JSONObject)localObject1).optString("sessionId"));
      localObject2 = new g();
      ((g)localObject2).a = ((JSONObject)localObject1).optString("mobile");
      ((g)localObject2).b = ((JSONObject)localObject1).optString("uhid");
      ((g)localObject2).c = com.bluefay.a.c.d(a.b(this.a));
      ((g)localObject2).d = ((JSONObject)localObject1).optString("nickName");
      ((g)localObject2).g = ((JSONObject)localObject1).optString("headImgUrl");
      ((g)localObject2).h = ((JSONObject)localObject1).optString("userToken");
      if (TextUtils.isEmpty(((g)localObject2).a)) {
        paramInt = 0;
      }
      while (paramInt != 0)
      {
        com.lantern.core.c.getServer().a((g)localObject2);
        com.lantern.analytics.a.e().onEvent("umcwfsuc");
        h.b();
        a.a(this.a, 1, paramString, paramObject, a.d(this.a));
        return;
        if (TextUtils.isEmpty(((g)localObject2).h)) {
          paramInt = 0;
        } else if (TextUtils.isEmpty(((g)localObject2).b)) {
          paramInt = 0;
        } else {
          paramInt = 1;
        }
      }
    }
    if (paramObject != null)
    {
      localObject1 = ((JSONObject)paramObject).optString("retCd");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {}
    }
    for (;;)
    {
      com.lantern.analytics.a locala = com.lantern.analytics.a.e();
      localObject2 = a.b(this.a);
      HashMap localHashMap = new HashMap();
      localHashMap.put("netModel", k.n((Context)localObject2));
      localHashMap.put("netOperator", k.f((Context)localObject2));
      localHashMap.put("reason", localObject1);
      locala.onEvent("umcwffa", new JSONObject(localHashMap).toString());
      if (((a.g(this.a) == 1) || (a.g(this.a) == 4)) && ((a.h(this.a) & 0x2) == 2))
      {
        a.i(this.a);
        break;
      }
      a.a(this.a, 10, paramString, paramObject, a.d(this.a));
      break;
      localObject1 = paramString;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */