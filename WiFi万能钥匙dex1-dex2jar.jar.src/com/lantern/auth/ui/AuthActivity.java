package com.lantern.auth.ui;

import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import bluefay.app.m;
import com.lantern.account.R.anim;
import com.lantern.account.R.string;
import com.lantern.auth.WkParamsConfig;
import com.lantern.auth.widget.WkAuthView;
import com.lantern.auth.widget.WkRegsView;
import com.lantern.core.c;
import com.lantern.core.config.AuthConfig;
import com.lantern.core.o;
import com.qihoo.util.StubApp1053578832;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class AuthActivity
  extends m
{
  private String e;
  private com.bluefay.material.f f;
  private WkParamsConfig g;
  private com.lantern.auth.utils.b h;
  private com.lantern.sdk.stub.a i;
  private WeakReference<WkRegsView> j = null;
  private WeakReference<WkAuthView> k = null;
  private AuthConfig l = null;
  private String m = "";
  private com.bluefay.b.a n = new e(this);
  private com.bluefay.b.a o = new g(this);
  private com.bluefay.b.a p = new h(this);
  private com.bluefay.b.a q = new i(this);
  private com.bluefay.b.a r = new j(this);
  private boolean s = false;
  
  static
  {
    StubApp1053578832.interface11(4);
  }
  
  private static String a(String paramString)
  {
    String str = "BASE";
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>(paramString);
      paramString = str;
      if (localJSONObject.has("scope")) {
        paramString = localJSONObject.getString("scope");
      }
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString = "BASE";
      }
    }
    return paramString;
  }
  
  private void b(String paramString)
  {
    this.s = true;
    com.lantern.analytics.a.e().onEvent("LoginEnd", com.lantern.auth.g.a("app_sdk", this.m, paramString, this.g.mThirdAppId));
  }
  
  private void f()
  {
    this.m = "";
    this.l = ((AuthConfig)com.lantern.core.config.d.a(this).a(AuthConfig.class));
    if (this.l == null) {
      this.l = new AuthConfig(this);
    }
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.i = com.lantern.sdk.stub.a.a(localIntent);
      com.bluefay.b.h.a("init mReq " + this.i, new Object[0]);
      this.g = ((WkParamsConfig)localIntent.getExtras().getSerializable("key_params_config"));
      com.bluefay.b.h.a("init mParamsConfig " + this.g, new Object[0]);
      if (this.g == null)
      {
        this.g = new WkParamsConfig();
        this.g.mAppIcon = "";
        this.g.mAppName = "";
        this.g.mThirdAppId = this.i.b;
        this.g.mScope = a(this.i.d);
      }
      g();
    }
  }
  
  private void g()
  {
    if (c.getServer().q())
    {
      this.e = "login";
      h();
    }
    for (;;)
    {
      return;
      if (!com.bluefay.a.a.c(this))
      {
        com.lantern.analytics.a.e().onEvent("oauthnf", com.lantern.auth.g.a(this.g.mThirdAppId));
        this.n.a(1003, null, Boolean.valueOf(true));
      }
      else
      {
        com.lantern.analytics.a.e().onEvent("LoginStart", com.lantern.auth.g.a("app_sdk", null, null, this.g.mThirdAppId));
        if ((!com.lantern.auth.utils.a.c(this)) || (this.l.d() == 4))
        {
          com.lantern.analytics.a.e().onEvent("oauth_ul", com.lantern.auth.g.a("4", "failed", this.g.mThirdAppId));
          k();
        }
        else if (this.l.d() == 2)
        {
          com.lantern.analytics.a.e().onEvent("oauth_cmcc", com.lantern.auth.g.a(null, "start", this.g.mThirdAppId));
          com.lantern.auth.a.a.a(this, this.r, true, 4, "app_sdk", this.g.mThirdAppId);
        }
        else
        {
          this.m += "5";
          j();
          this.h = new com.lantern.auth.utils.b(this, this.p);
          com.lantern.auth.c.b localb = new com.lantern.auth.c.b(this.o, "app_sdk", this.g.mThirdAppId);
          this.m = "5";
          localb.execute(new String[0]);
        }
      }
    }
  }
  
  private void h()
  {
    if ((this.i != null) && ("pay".equals(this.i.a)))
    {
      com.lantern.sdk.pay.a.a(this, getIntent());
      finish();
    }
    for (;;)
    {
      return;
      j();
      new com.lantern.auth.c.a(new b(this)).execute(new String[] { this.g.mThirdAppId, this.g.mScope });
    }
  }
  
  private void i()
  {
    try
    {
      if ((this.f != null) && (this.f.isShowing()))
      {
        this.f.dismiss();
        this.f = null;
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void j()
  {
    try
    {
      Object localObject = new com/bluefay/material/f;
      ((com.bluefay.material.f)localObject).<init>(this);
      this.f = ((com.bluefay.material.f)localObject);
      this.f.a(getString(R.string.auth_loading_code));
      this.f.setCanceledOnTouchOutside(false);
      this.f.show();
      com.bluefay.material.f localf = this.f;
      localObject = new com/lantern/auth/ui/f;
      ((f)localObject).<init>(this);
      localf.setOnCancelListener((DialogInterface.OnCancelListener)localObject);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void k()
  {
    i();
    l();
  }
  
  private void l()
  {
    com.lantern.analytics.a.e().onEvent("oauth_dl", com.lantern.auth.g.a("1", "start", this.g.mThirdAppId));
    i();
    WkRegsView localWkRegsView = new WkRegsView(this, this.g.mThirdAppId, "app_sdk", this.m);
    localWkRegsView.a(new d(this));
    this.j = new WeakReference((WkRegsView)localWkRegsView);
    this.m += "6";
    setCustomContentView((View)this.j.get());
  }
  
  protected final boolean b()
  {
    return false;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, R.anim.framework_slide_right_exit);
    try
    {
      this.h.a();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    super.onDestroy();
    if ((this.j != null) && (this.j.get() != null)) {
      ((WkRegsView)this.j.get()).a();
    }
    if ((this.k != null) && (this.k.get() != null)) {
      ((WkAuthView)this.k.get()).a();
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if ((!this.s) && (!TextUtils.isEmpty(this.m))) {
        b("4");
      }
      this.n.a(1005, null, Boolean.valueOf(true));
    }
    return false;
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    f();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      if ((!this.s) && (!TextUtils.isEmpty(this.m))) {
        b("4");
      }
      this.n.a(1005, null, Boolean.valueOf(true));
    }
    return false;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/ui/AuthActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */