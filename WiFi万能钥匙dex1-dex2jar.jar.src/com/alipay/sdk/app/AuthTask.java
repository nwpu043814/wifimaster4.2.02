package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.sdk.c.c;
import com.alipay.sdk.j.e;
import com.alipay.sdk.j.e.a;
import com.alipay.sdk.j.i;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class AuthTask
{
  static final Object a = e.class;
  private Activity b;
  private com.alipay.sdk.k.a c;
  
  public AuthTask(Activity paramActivity)
  {
    this.b = paramActivity;
    com.alipay.sdk.h.b localb = com.alipay.sdk.h.b.a();
    Activity localActivity = this.b;
    c.a();
    localb.a(localActivity);
    com.alipay.sdk.app.a.a.a(paramActivity);
    this.c = new com.alipay.sdk.k.a(paramActivity, "去支付宝授权");
  }
  
  private String a(Activity paramActivity, String paramString)
  {
    a();
    for (;;)
    {
      try
      {
        com.alipay.sdk.f.a.a locala = new com/alipay/sdk/f/a/a;
        locala.<init>();
        paramActivity = com.alipay.sdk.g.b.a(locala.a(paramActivity, paramString).a().optJSONObject("form").optJSONObject("onload"));
        b();
        int i = 0;
        if (i < paramActivity.size())
        {
          if (((com.alipay.sdk.g.b)paramActivity.get(i)).a == com.alipay.sdk.g.a.b)
          {
            paramActivity = a((com.alipay.sdk.g.b)paramActivity.get(i));
            return paramActivity;
          }
          i++;
          continue;
        }
        b();
        paramActivity = null;
      }
      catch (IOException paramString)
      {
        paramActivity = k.a(k.d.h);
        com.alipay.sdk.app.a.a.a("net", paramString);
        b();
        continue;
      }
      catch (Throwable paramActivity)
      {
        com.alipay.sdk.app.a.a.a("biz", "H5AuthDataAnalysisError", paramActivity);
        b();
        paramActivity = null;
        continue;
      }
      finally
      {
        b();
      }
      paramString = paramActivity;
      if (paramActivity == null) {
        paramString = k.a(k.b.h);
      }
      paramActivity = j.a(paramString.h, paramString.i, "");
    }
  }
  
  private String a(com.alipay.sdk.g.b paramb)
  {
    ??? = paramb.b;
    paramb = new Bundle();
    paramb.putString("url", ???[0]);
    ??? = new Intent(this.b, a.class);
    ((Intent)???).putExtras(paramb);
    this.b.startActivity((Intent)???);
    synchronized (a)
    {
      try
      {
        a.wait();
        ??? = j.a;
        paramb = (com.alipay.sdk.g.b)???;
        if (TextUtils.isEmpty((CharSequence)???)) {
          paramb = j.a();
        }
      }
      catch (InterruptedException paramb)
      {
        for (;;)
        {
          paramb = j.a();
        }
      }
      return paramb;
    }
  }
  
  private void a()
  {
    if (this.c != null) {
      this.c.a();
    }
  }
  
  private static boolean a(Context paramContext)
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        paramContext = paramContext.getPackageManager().getPackageInfo(com.alipay.sdk.j.k.a(), 128);
        if (paramContext != null) {
          continue;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        int i;
        continue;
      }
      return bool;
      i = paramContext.versionCode;
      if (i >= 73) {
        bool = true;
      }
    }
  }
  
  private void b()
  {
    if (this.c != null) {
      this.c.b();
    }
  }
  
  public String auth(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        a();
        localObject1 = com.alipay.sdk.h.b.a();
        localObject3 = this.b;
        c.a();
        ((com.alipay.sdk.h.b)localObject1).a((Context)localObject3);
        localObject3 = j.a();
        try
        {
          localObject1 = this.b;
          Object localObject4 = new com/alipay/sdk/h/a;
          ((com.alipay.sdk.h.a)localObject4).<init>(this.b);
          str = ((com.alipay.sdk.h.a)localObject4).a(paramString);
          if (!a((Context)localObject1)) {
            continue;
          }
          e locale = new com/alipay/sdk/j/e;
          localObject4 = new com/alipay/sdk/app/d;
          ((d)localObject4).<init>(this);
          locale.<init>((Activity)localObject1, (e.a)localObject4);
          localObject4 = locale.a(str);
          if (TextUtils.equals((CharSequence)localObject4, "failed")) {
            continue;
          }
          localObject1 = localObject4;
          if (TextUtils.isEmpty((CharSequence)localObject4)) {
            localObject1 = j.a();
          }
          com.alipay.sdk.c.a.b().a(this.b);
          b();
          com.alipay.sdk.app.a.a.a(this.b, paramString);
          paramString = (String)localObject1;
        }
        catch (Exception localException)
        {
          String str;
          com.alipay.sdk.c.a.b().a(this.b);
          b();
          com.alipay.sdk.app.a.a.a(this.b, paramString);
          paramString = (String)localObject3;
          continue;
        }
        finally
        {
          com.alipay.sdk.c.a.b().a(this.b);
          b();
          com.alipay.sdk.app.a.a.a(this.b, paramString);
        }
        return paramString;
      }
      finally {}
      Object localObject1 = a((Activity)localObject1, str);
    }
  }
  
  public Map authV2(String paramString, boolean paramBoolean)
  {
    try
    {
      paramString = i.a(auth(paramString, paramBoolean));
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alipay/sdk/app/AuthTask.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */