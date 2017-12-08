package com.lantern.auth.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import bluefay.app.m;
import com.bluefay.a.e;
import com.lantern.account.R.id;
import com.lantern.account.R.string;
import com.lantern.auth.g;
import com.lantern.core.c;
import com.lantern.core.config.AuthConfig;
import com.lantern.core.f;
import com.lantern.core.k;
import com.lantern.core.n;
import com.lantern.core.o;
import com.qihoo.util.StubApp1053578832;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class AddAccountActivity
  extends m
  implements View.OnClickListener
{
  private CheckBox e = null;
  private AuthConfig f;
  private boolean g = false;
  private String h = "";
  private String i = "";
  private com.bluefay.b.a j = new a(this);
  
  static
  {
    StubApp1053578832.interface11(3);
  }
  
  private void a(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("uhid", paramString1);
    localIntent.putExtra("userToken", paramString2);
    com.bluefay.b.h.a("sendInfoForResult  " + paramString1, new Object[0]);
    setResult(-1, localIntent);
    finish();
  }
  
  private void a(boolean paramBoolean)
  {
    Object localObject1 = "";
    Object localObject2;
    StringBuilder localStringBuilder;
    if (getIntent() == null)
    {
      localObject2 = c.getServer().s();
      String str1 = k.f(c.getAppContext());
      ((HashMap)localObject2).put("netOperator", str1);
      String str2 = new JSONObject((Map)localObject2).toString();
      com.bluefay.b.h.a("json=" + str2, new Object[0]);
      ((HashMap)localObject2).clear();
      localObject2 = c.getServer();
      boolean bool = com.lantern.auth.utils.a.b(c.getAppContext());
      str2 = n.a(Uri.encode(str2.trim(), "UTF-8"), ((o)localObject2).l(), ((o)localObject2).m());
      String str3 = ((o)localObject2).k();
      localStringBuilder = new StringBuilder();
      if (!paramBoolean) {
        break label605;
      }
      localStringBuilder.append(com.lantern.auth.h.b());
      localStringBuilder.append("netOperator=" + str1);
      localStringBuilder.append("&");
      localStringBuilder.append("lang=" + k.c());
      localStringBuilder.append("&");
      localStringBuilder.append("state=" + bool);
      localStringBuilder.append("&");
      localStringBuilder.append("ed=" + str2);
      localStringBuilder.append("&");
      localStringBuilder.append("et=" + "a");
      localStringBuilder.append("&");
      localStringBuilder.append("appId=" + str3);
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        localStringBuilder.append("&");
        localStringBuilder.append("origin=" + (String)localObject1);
      }
      if (!TextUtils.isEmpty(this.h)) {
        localStringBuilder.append("&").append("fromSource=" + this.h);
      }
      com.bluefay.b.h.a("url=" + localStringBuilder.toString(), new Object[0]);
      localObject2 = new Intent("wifi.intent.action.BROWSER", Uri.parse(localStringBuilder.toString()));
      ((Intent)localObject2).setPackage(getPackageName());
      if (!this.g) {
        ((Intent)localObject2).addFlags(268435456);
      }
      if (paramBoolean) {
        this.i += "6";
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putBoolean("showclose", true);
      ((Bundle)localObject1).putBoolean("isregister", true);
      ((Bundle)localObject1).putString("fromSource", this.h);
      ((Bundle)localObject1).putString("lastPath", this.i);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      com.lantern.analytics.a.e().onEvent("login_wf");
      if (!this.g) {
        break label685;
      }
      ((Intent)localObject2).putExtra("login_result", true);
      startActivityForResult((Intent)localObject2, 1001);
    }
    for (;;)
    {
      return;
      localObject1 = getIntent().getStringExtra("srcReq");
      break;
      label605:
      localObject2 = f.a(c.getAppContext()).a("ssohost");
      if (localObject2 != null) {}
      for (localObject2 = String.format("%s%s", new Object[] { localObject2, "/sso/open/autoRegister.do?" });; localObject2 = String.format("%s%s", new Object[] { "https://sso.51y5.net", "/sso/open/autoRegister.do?" }))
      {
        localStringBuilder.append((String)localObject2);
        break;
      }
      label685:
      e.a(this, (Intent)localObject2);
      finish();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1001) && (paramInt2 == -1)) {
      a(paramIntent.getStringExtra("uhid"), paramIntent.getStringExtra("userToken"));
    }
    for (;;)
    {
      return;
      finish();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.btn_login_start)
    {
      if (!com.bluefay.a.a.c(this)) {
        e.a(getString(R.string.auth_failed_no_network));
      }
    }
    else {
      return;
    }
    int m = 0;
    int k = m;
    if (this.e.isChecked())
    {
      k = m;
      if (com.lantern.auth.utils.a.c(this)) {
        k = 4;
      }
    }
    if (this.f.g() == 2) {
      k |= 0x2;
    }
    for (;;)
    {
      com.lantern.analytics.a.e().onEvent("login_cmcc", g.a(null, "start", null));
      if (k == 0)
      {
        com.lantern.analytics.a.e().onEvent("login_cmcc", g.a(null, "cancel", null));
        a(true);
        break;
      }
      com.lantern.auth.a.a.a(this, this.j, true, k, this.h, c.getServer().k());
      break;
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4) {
      com.lantern.analytics.a.e().onEvent("LoginEnd", g.a(this.h, "1", "4", c.getServer().k()));
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332) {
      com.lantern.analytics.a.e().onEvent("LoginEnd", g.a(this.h, "1", "4", c.getServer().k()));
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/ui/AddAccountActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */