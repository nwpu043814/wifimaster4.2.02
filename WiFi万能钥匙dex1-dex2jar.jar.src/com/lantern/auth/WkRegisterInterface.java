package com.lantern.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import com.bluefay.a.e;
import com.bluefay.d.b;
import com.lantern.analytics.a;
import com.lantern.core.o;
import com.lantern.core.p;
import org.json.JSONObject;

public class WkRegisterInterface
{
  private String fromSource = "";
  private b handler = new m(this, new int[] { 128802 });
  private boolean isLoginForResult;
  private String lastPath = "";
  private Activity mActivity;
  private WebView mWebView;
  private String ret = "4";
  
  public WkRegisterInterface(WebView paramWebView, Activity paramActivity)
  {
    this.mWebView = paramWebView;
    this.mActivity = paramActivity;
    this.isLoginForResult = this.mActivity.getIntent().getBooleanExtra("login_result", false);
  }
  
  public WkRegisterInterface(WebView paramWebView, Activity paramActivity, String paramString)
  {
    this.mWebView = paramWebView;
    this.mActivity = paramActivity;
    this.fromSource = paramString;
    this.isLoginForResult = this.mActivity.getIntent().getBooleanExtra("login_result", false);
    this.lastPath = this.mActivity.getIntent().getStringExtra("lastPath");
  }
  
  private void callToBrowser(int paramInt, String paramString)
  {
    if (paramInt == 1) {
      a.e().onEvent("LoginOn", g.a(this.fromSource, this.lastPath, "1", com.lantern.core.c.getServer().k()));
    }
    try
    {
      JSONObject localJSONObject = new org/json/JSONObject;
      localJSONObject.<init>();
      localJSONObject.put("retCd", paramInt);
      WebView localWebView = this.mWebView;
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>("javascript:");
      localWebView.loadUrl(paramString + "(" + localJSONObject.toString() + ")");
      return;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public void autoRegister(String paramString)
  {
    com.lantern.core.c.addListener(this.handler);
    this.lastPath += "5";
    Intent localIntent = new Intent("com.lantern.auth.ACTION_AUTO_REG");
    localIntent.putExtra("auto_reg", paramString);
    localIntent.putExtra("fromSource", this.fromSource);
    this.mActivity.startService(localIntent);
  }
  
  public void closeWindow()
  {
    this.mActivity.finish();
  }
  
  public Bundle getLoginRet()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("lastPath", this.lastPath);
    localBundle.putString("ret", this.ret);
    return localBundle;
  }
  
  public void webAuthorToken(String paramString)
  {
    if (!this.lastPath.contains("6")) {
      this.lastPath += "6";
    }
    if (!TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      try
      {
        Object localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>("loginObject ");
        com.bluefay.b.h.a(paramString, new Object[0]);
        localObject1 = new org/json/JSONObject;
        ((JSONObject)localObject1).<init>(paramString);
        Object localObject3 = ((JSONObject)localObject1).optString("sessionId");
        paramString = ((JSONObject)localObject1).optString("uhid");
        String str2 = ((JSONObject)localObject1).optString("mobile");
        Object localObject2 = ((JSONObject)localObject1).optString("nickName");
        String str1 = ((JSONObject)localObject1).optString("headImgUrl");
        localObject1 = ((JSONObject)localObject1).optString("userToken");
        p.g(this.mActivity, (String)localObject3);
        localObject3 = new com/lantern/core/model/g;
        ((com.lantern.core.model.g)localObject3).<init>();
        ((com.lantern.core.model.g)localObject3).a = str2;
        ((com.lantern.core.model.g)localObject3).b = paramString;
        ((com.lantern.core.model.g)localObject3).c = com.bluefay.a.c.d(this.mActivity);
        ((com.lantern.core.model.g)localObject3).d = ((String)localObject2);
        ((com.lantern.core.model.g)localObject3).h = ((String)localObject1);
        com.lantern.core.c.getServer().a((com.lantern.core.model.g)localObject3);
        p.k(this.mActivity, str1);
        this.ret = "1";
        com.lantern.core.h.b();
        a.e().onEvent("LoginOn", g.a(this.fromSource, this.lastPath, "1", com.lantern.core.c.getServer().k()));
        if (this.isLoginForResult)
        {
          localObject2 = new android/content/Intent;
          ((Intent)localObject2).<init>();
          ((Intent)localObject2).putExtra("uhid", paramString);
          ((Intent)localObject2).putExtra("userToken", (String)localObject1);
          this.mActivity.setResult(-1, (Intent)localObject2);
        }
        this.mActivity.finish();
        return;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
      e.a(this.mActivity, "Auth Failed");
    }
  }
  
  public void webAuthorToken(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4)))
    {
      p.g(this.mActivity, paramString2);
      paramString1 = new com.lantern.core.model.g();
      paramString1.a = paramString4;
      paramString1.b = paramString3;
      paramString1.c = com.bluefay.a.c.d(this.mActivity);
      com.lantern.core.c.getServer().a(paramString1);
      com.lantern.core.h.b();
      this.mActivity.finish();
    }
    for (;;)
    {
      return;
      e.a(this.mActivity, "Auth Failed");
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/auth/WkRegisterInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */