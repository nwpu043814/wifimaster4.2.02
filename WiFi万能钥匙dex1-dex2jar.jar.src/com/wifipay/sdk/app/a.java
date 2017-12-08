package com.wifipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.wifipay.sdk.a.a.a;
import com.wifipay.sdk.a.a.d;
import com.wifipay.sdk.modelpay.PayResp;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  implements Handler.Callback
{
  private static int h = 0;
  private static int i = 1;
  private static int j = 2;
  public Activity a;
  public com.wifipay.sdk.c.g b;
  public g c = new g(this);
  public String d;
  private LinkedHashMap e = new LinkedHashMap(4);
  private String f;
  private ExecutorService g;
  private int k = h;
  private boolean l = false;
  
  public a(Activity paramActivity)
  {
    this.a = paramActivity;
    this.g = Executors.newCachedThreadPool();
    i();
    this.b = new com.wifipay.sdk.c.g(paramActivity);
  }
  
  private void d(String paramString)
  {
    com.wifipay.sdk.util.c.a("kyo", "-exec-args-" + paramString);
    Object localObject = paramString.split("&");
    paramString = localObject[0];
    if (paramString.equals("back")) {
      this.a.onBackPressed();
    }
    for (;;)
    {
      return;
      if (paramString.equals("dial")) {
        e(localObject[1]);
      } else {
        try
        {
          this.f = localObject[1];
          CharSequence localCharSequence = localObject[2];
          if (!TextUtils.isEmpty(localCharSequence))
          {
            localObject = new org/json/JSONObject;
            ((JSONObject)localObject).<init>(localCharSequence);
            this.b.a(a.d.h);
            c().a(paramString, (JSONObject)localObject);
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
        }
      }
    }
  }
  
  private void e(String paramString)
  {
    String str = paramString;
    if (com.a.a.a.a.e.a(paramString)) {
      str = "400-720-8888";
    }
    paramString = a.d.d + str;
    str = str.replaceAll("-", "");
    this.b.a(a.d.e, paramString, a.d.f, new b(this, str), a.d.g, null);
  }
  
  private void i()
  {
    Object localObject = new com.wifipay.sdk.b.a.e(this);
    this.e.put(((com.wifipay.sdk.b.a)localObject).a(), localObject);
    localObject = new com.wifipay.sdk.b.a.a(this);
    this.e.put(((com.wifipay.sdk.b.a)localObject).a(), localObject);
    localObject = new com.wifipay.sdk.b.a.c(this);
    this.e.put(((com.wifipay.sdk.b.a)localObject).a(), localObject);
  }
  
  public void a()
  {
    this.k = i;
  }
  
  public boolean a(Intent paramIntent)
  {
    boolean bool = false;
    if ((a.a.e.equals(paramIntent.getStringExtra(a.a.f))) || (!TextUtils.isEmpty(paramIntent.getStringExtra(a.a.g))))
    {
      paramIntent.putExtra(a.a.h, false);
      b("wechat").a(paramIntent);
      bool = true;
    }
    return bool;
  }
  
  public boolean a(String paramString)
  {
    try
    {
      String str = URLDecoder.decode(paramString, "UTF-8");
      paramString = str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
        continue;
        boolean bool = false;
      }
    }
    if (paramString.toLowerCase().startsWith(a.a.i.toLowerCase()))
    {
      d(paramString.replace(a.a.i, ""));
      bool = true;
      return bool;
    }
  }
  
  public com.wifipay.sdk.b.a b(String paramString)
  {
    return (com.wifipay.sdk.b.a)this.e.get(paramString);
  }
  
  public void b()
  {
    if (e()) {}
    for (;;)
    {
      return;
      this.k = h;
      this.b.a();
    }
  }
  
  public boolean b(Intent paramIntent)
  {
    boolean bool = true;
    if (e()) {}
    for (;;)
    {
      return bool;
      if ((a.a.e.equals(paramIntent.getStringExtra(a.a.f))) || (!TextUtils.isEmpty(paramIntent.getStringExtra(a.a.g))))
      {
        paramIntent.putExtra(a.a.h, true);
        b("wechat").a(paramIntent);
      }
      else
      {
        this.k = h;
        this.f = null;
        bool = false;
      }
    }
  }
  
  public com.wifipay.sdk.b.a c()
  {
    return (com.wifipay.sdk.b.a)this.e.get(this.f);
  }
  
  public void c(String paramString)
  {
    this.d = paramString;
  }
  
  public void d()
  {
    this.l = true;
    if (this.b != null)
    {
      this.b.a();
      this.b = null;
    }
    if ((this.g != null) && (!this.g.isShutdown())) {
      this.g.shutdown();
    }
  }
  
  public boolean e()
  {
    return this.l;
  }
  
  public void f()
  {
    if ((this.k != i) || (!"wechat".equals(this.f)) || (e())) {}
    for (;;)
    {
      return;
      PayResp localPayResp = new PayResp();
      localPayResp.errCode = -5;
      localPayResp.errMsg = "";
      c().a(localPayResp, false);
      this.k = h;
      this.f = null;
    }
  }
  
  public void g()
  {
    if (e()) {}
    for (;;)
    {
      return;
      this.k = h;
      this.b.b(a.d.l);
      this.f = null;
    }
  }
  
  public ExecutorService h()
  {
    return this.g;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    boolean bool;
    if (e()) {
      bool = true;
    }
    for (;;)
    {
      return bool;
      Iterator localIterator = this.e.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext()) {
          if (((com.wifipay.sdk.b.a)((Map.Entry)localIterator.next()).getValue()).a(paramMessage))
          {
            bool = true;
            break;
          }
        }
      }
      if (paramMessage.what == 100)
      {
        this.b.a();
        bool = true;
      }
      else
      {
        bool = false;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/sdk/app/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */