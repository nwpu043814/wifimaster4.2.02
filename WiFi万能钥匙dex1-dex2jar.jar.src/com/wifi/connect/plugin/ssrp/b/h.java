package com.wifi.connect.plugin.ssrp.b;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import bluefay.app.b;
import com.lantern.core.config.ConnectDlgBgConf;
import com.lantern.core.config.d;
import java.util.ArrayList;
import java.util.List;

public final class h
{
  private Context a;
  private List<com.wifi.connect.plugin.ssrp.c.a> b = new ArrayList();
  private String c;
  private com.wifi.connect.plugin.ssrp.e.a d;
  private com.wifi.connect.plugin.ssrp.c.a e;
  private int f = 0;
  private int g = 0;
  private int h = 10;
  private a i;
  private boolean j = false;
  private com.wifi.connect.plugin.ssrp.f.a k;
  private Handler l = new j(this);
  
  public h(Context paramContext, a parama)
  {
    this.i = parama;
    this.a = paramContext;
    this.d = new com.wifi.connect.plugin.ssrp.e.a();
    a(paramContext);
    paramContext = (ConnectDlgBgConf)d.a(this.a).a(ConnectDlgBgConf.class);
    if (paramContext != null)
    {
      this.c = paramContext.d();
      if ((!TextUtils.isEmpty(this.c)) && (!TextUtils.isEmpty(paramContext.e())))
      {
        paramContext = e.a(this.a).a(this.c, paramContext.e());
        if (paramContext == null) {
          break label270;
        }
        paramContext = "file://" + paramContext;
        this.k.a(paramContext);
        com.bluefay.b.h.a("ConnectDlgBg_Conf start= " + paramContext, new Object[0]);
      }
    }
    for (;;)
    {
      paramContext = new HandlerThread("Update Progress");
      paramContext.start();
      this.d = new com.wifi.connect.plugin.ssrp.e.a(paramContext.getLooper());
      paramContext = this.d;
      parama = new l(this);
      Message localMessage = paramContext.obtainMessage(1000);
      localMessage.arg1 = 100;
      localMessage.arg2 = 30000;
      localMessage.obj = parama;
      paramContext.sendMessageDelayed(localMessage, 0L);
      return;
      label270:
      this.j = true;
    }
  }
  
  public final void a()
  {
    if (this.k != null)
    {
      this.k.dismiss();
      this.k = null;
      if (this.a != null) {
        ((b)this.a).finish();
      }
    }
  }
  
  public final void a(Context paramContext)
  {
    if (this.k == null)
    {
      this.k = new com.wifi.connect.plugin.ssrp.f.a(paramContext);
      this.k.setCanceledOnTouchOutside(false);
      this.k.setCancelable(true);
      this.k.setOnCancelListener(new i(this));
    }
    if (!this.k.isShowing()) {
      this.k.show();
    }
  }
  
  public final void a(String paramString, int paramInt, boolean paramBoolean)
  {
    this.e = new com.wifi.connect.plugin.ssrp.c.a();
    this.e.a(paramBoolean);
    this.e.a(paramInt);
    this.e.a(paramString);
    a(this.a);
    this.k.a(this.e);
    this.g = paramInt;
    if ((paramBoolean) && (this.j) && (paramInt == 100) && (!TextUtils.isEmpty(this.c))) {
      this.l.postDelayed(new k(this), 1000L);
    }
    com.bluefay.b.h.b("msg:%s, progress:%s, isComplete:%s", new Object[] { paramString, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/ssrp/b/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */