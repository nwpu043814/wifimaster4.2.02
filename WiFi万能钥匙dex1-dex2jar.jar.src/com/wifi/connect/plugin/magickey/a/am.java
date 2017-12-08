package com.wifi.connect.plugin.magickey.a;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.bluefay.b.h;
import com.lantern.core.config.ConnectDlgBgConf;
import com.lantern.core.config.d;
import com.lantern.core.model.WkAccessPoint;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class am
{
  private Context a;
  private List<com.wifi.connect.plugin.magickey.b.c> b = new ArrayList();
  private String c;
  private com.wifi.connect.plugin.magickey.e.a d;
  private com.wifi.connect.plugin.magickey.b.c e;
  private int f = 0;
  private int g = 0;
  private int h = 10;
  private boolean i = false;
  private com.wifi.connect.plugin.a.c j;
  private al k;
  private ai l;
  private String m;
  private String n;
  private String o;
  private String p;
  private com.wifi.connect.plugin.a.a q;
  private WkAccessPoint r;
  private Handler s = new ap(this);
  
  public am(Context paramContext, al paramal, WkAccessPoint paramWkAccessPoint, String paramString)
  {
    this.a = paramContext;
    this.k = paramal;
    this.d = new com.wifi.connect.plugin.magickey.e.a();
    this.r = paramWkAccessPoint;
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramal = new org/json/JSONObject;
      paramal.<init>(paramString);
      this.m = paramal.optString("shop_type");
      this.n = paramal.optString("shop_ssid");
      this.o = paramal.optString("shop_alias");
      this.p = paramal.optString("shop_avatar");
      a(paramContext);
      if (!"2".equals(this.m))
      {
        this.j.a(paramWkAccessPoint.a);
        this.l = new ai(paramContext);
        paramContext = (ConnectDlgBgConf)d.a(this.a).a(ConnectDlgBgConf.class);
        if (paramContext != null)
        {
          this.c = paramContext.d();
          if ((!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(paramContext.e())))
          {
            paramContext = this.l.a(this.c, paramContext.e());
            if (paramContext == null) {
              break label373;
            }
            paramContext = "file://" + paramContext;
            this.j.b(paramContext);
            h.a("ConnectDlgBg_Conf start= " + paramContext, new Object[0]);
          }
        }
      }
      paramContext = new HandlerThread("Update Progress");
      paramContext.start();
      this.d = new com.wifi.connect.plugin.magickey.e.a(paramContext.getLooper());
      paramal = this.d;
      paramWkAccessPoint = new ar(this);
      paramContext = paramal.obtainMessage(1000);
      paramContext.arg1 = 100;
      paramContext.arg2 = 30000;
      paramContext.obj = paramWkAccessPoint;
      paramal.sendMessageDelayed(paramContext, 0L);
      return;
    }
    catch (Exception paramal)
    {
      for (;;)
      {
        h.a(paramal);
        continue;
        label373:
        this.i = true;
      }
    }
  }
  
  public final void a(Context paramContext)
  {
    if ("2".equals(this.m))
    {
      if (this.q == null)
      {
        this.q = new com.wifi.connect.plugin.a.a(this.a);
        this.q.a(this.n, this.o, this.p);
        this.q.setCanceledOnTouchOutside(false);
        this.q.setCancelable(true);
        this.q.setOnCancelListener(new an(this));
      }
      if (!this.q.isShowing()) {
        this.q.show();
      }
    }
    for (;;)
    {
      return;
      if (this.j == null)
      {
        this.j = new com.wifi.connect.plugin.a.c(paramContext);
        this.j.setCanceledOnTouchOutside(false);
        this.j.setCancelable(true);
        this.j.setOnCancelListener(new ao(this));
      }
      if (!this.j.isShowing()) {
        this.j.show();
      }
    }
  }
  
  public final void a(String paramString, int paramInt, boolean paramBoolean)
  {
    if ("2".equals(this.m)) {
      if (this.q != null)
      {
        this.g = paramInt;
        this.q.a(paramString);
      }
    }
    for (;;)
    {
      return;
      this.e = new com.wifi.connect.plugin.magickey.b.c();
      this.e.a(paramBoolean);
      this.e.a(paramInt);
      this.e.a(paramString);
      this.b.add(this.e);
      a(this.a);
      this.j.a(this.b);
      this.g = paramInt;
      if ((paramBoolean) && (this.i) && (paramInt == 100) && (!TextUtils.isEmpty(this.c))) {
        this.s.postDelayed(new aq(this), 1000L);
      }
      h.b("msg:%s, progress:%s, isComplete:%s", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.j != null)
    {
      this.j.dismiss();
      if (paramBoolean) {
        this.j = null;
      }
    }
    if (this.q != null)
    {
      this.q.dismiss();
      if (paramBoolean) {
        this.q = null;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/magickey/a/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */