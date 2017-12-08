package com.lantern.auth.a;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import cm.pass.sdk.auth.AuthnHelper;
import cm.pass.sdk.auth.TokenListener;
import com.lantern.auth.widget.o;
import com.lantern.core.config.AuthConfig;

public final class a
{
  private Context a;
  private AuthnHelper b;
  private com.bluefay.b.a c;
  private o d;
  private Handler e;
  private AuthConfig f;
  private int g = 3;
  private String h = "";
  private String i = "";
  private String j = "";
  private int k = 0;
  private boolean l = false;
  private boolean m = false;
  private Runnable n = new b(this);
  private Runnable o = new d(this);
  private com.bluefay.b.a p = new e(this);
  private TokenListener q = new f(this);
  private TokenListener r = new g(this);
  private TokenListener s = new h(this);
  
  private a(Context paramContext, String paramString1, String paramString2)
  {
    this.b = AuthnHelper.getInstance(paramContext);
    this.a = paramContext;
    this.e = new Handler();
    this.h = paramString1;
    this.j = paramString2;
    this.f = ((AuthConfig)com.lantern.core.config.d.a(paramContext).a(AuthConfig.class));
    if (this.f == null) {
      this.f = new AuthConfig(paramContext);
    }
  }
  
  private long a(String paramString)
  {
    long l1;
    if ("app_auto".equals(paramString)) {
      l1 = this.f.k();
    }
    for (;;)
    {
      return l1;
      if ("app_login".equals(paramString)) {
        l1 = this.f.i();
      } else if ("app_sdk".equals(paramString)) {
        l1 = this.f.j();
      } else {
        l1 = 10000L;
      }
    }
  }
  
  private void a()
  {
    if ((this.a instanceof Activity)) {
      ((Activity)this.a).runOnUiThread(new i(this));
    }
  }
  
  private void a(int paramInt, String paramString1, Object paramObject, String paramString2)
  {
    a();
    this.q = null;
    this.r = null;
    this.s = null;
    if (this.c != null) {
      this.e.post(new k(this, paramInt, paramString2, paramObject, paramString1));
    }
  }
  
  public static void a(Context paramContext, com.bluefay.b.a parama, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    paramContext = new a(paramContext, paramString1, paramString2);
    com.lantern.analytics.a.e().onEvent("umcsta", com.lantern.auth.g.a(paramContext.a));
    paramContext.c = parama;
    int i1;
    if ((paramInt > 0) && (paramInt <= 7))
    {
      i1 = 1;
      if (i1 != 0) {
        break label95;
      }
      paramContext.i += "2";
      paramContext.a(2, null, null, paramContext.i);
    }
    for (;;)
    {
      return;
      i1 = 0;
      break;
      label95:
      paramContext.g = paramInt;
      long l1;
      if ((paramContext.g & 0x1) == 1)
      {
        if (paramBoolean) {
          paramContext.b();
        }
        paramContext.k = 1;
        l1 = paramContext.a(paramContext.h);
        if (l1 > 0L) {
          paramContext.e.postDelayed(paramContext.n, l1);
        }
        paramContext.b.umcLoginByType("300010036245", "B3E5B141D7EBF2B75EBC30862FAA6785", 1, paramContext.r);
      }
      else if ((paramContext.g & 0x4) == 4)
      {
        if (paramBoolean) {
          paramContext.b();
        }
        paramContext.k = 4;
        l1 = paramContext.a(paramContext.h);
        if (l1 > 0L) {
          paramContext.e.postDelayed(paramContext.o, l1);
        }
        paramContext.b.umcLoginByType("300010036245", "B3E5B141D7EBF2B75EBC30862FAA6785", 2, paramContext.q);
      }
      else if ((paramContext.g & 0x2) == 2)
      {
        paramContext.c();
      }
    }
  }
  
  private void b()
  {
    Activity localActivity;
    if ((this.a instanceof Activity))
    {
      localActivity = (Activity)this.a;
      if (!localActivity.isFinishing()) {
        break label26;
      }
    }
    for (;;)
    {
      return;
      label26:
      localActivity.runOnUiThread(new j(this, localActivity));
    }
  }
  
  private void c()
  {
    this.k = 2;
    this.b.umcLoginByType("300010036245", "B3E5B141D7EBF2B75EBC30862FAA6785", 4, this.s);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */