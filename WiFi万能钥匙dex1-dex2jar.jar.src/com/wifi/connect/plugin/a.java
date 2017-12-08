package com.wifi.connect.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import bluefay.app.k.a;
import com.lantern.connect.R.string;
import com.lantern.core.o;
import com.wifi.connect.model.PluginAp;
import java.io.File;

public final class a
{
  private com.wifi.connect.widget.a a;
  private Context b;
  private com.bluefay.b.a c;
  private PluginAp d;
  private boolean e = false;
  private File f;
  private File g;
  private com.bluefay.b.a h = new b(this);
  private com.bluefay.b.a i = new c(this);
  private com.bluefay.b.a j = new j(this);
  
  public a(Context paramContext)
  {
    this.b = paramContext;
    this.f = new File(paramContext.getFilesDir(), "plugins");
    if (!this.f.exists()) {
      this.f.mkdir();
    }
    this.g = new File(com.lantern.core.c.getAppExternalRootDir(), "plugins");
    if (!this.g.exists()) {
      this.g.mkdir();
    }
  }
  
  private void a()
  {
    b();
    this.a.c(R.string.tips_plugin_downloading);
    this.c.a(3, "Downloading", null);
    this.e = true;
    new k(this.d, this.j).execute(new String[0]);
  }
  
  private void a(int paramInt, String paramString, Object paramObject)
  {
    Object localObject;
    int k;
    if (paramInt == 1)
    {
      localObject = (PluginAp)paramObject;
      if ((localObject != null) && (!a((PluginAp)localObject)))
      {
        a(false);
        localObject = "Download success but verifysign failed";
        k = 0;
      }
    }
    for (;;)
    {
      this.c.a(k, (String)localObject, paramObject);
      return;
      a(true);
      k = paramInt;
      localObject = paramString;
      continue;
      k = paramInt;
      localObject = paramString;
      if (paramInt == 0)
      {
        a(false);
        k = paramInt;
        localObject = paramString;
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.a != null) {
        this.a.c(R.string.tips_plugin_download_success);
      }
    }
    for (;;)
    {
      b(true);
      return;
      com.bluefay.a.e.a(this.b, R.string.tips_plugin_download_failed);
      if (this.a != null) {
        this.a.c(R.string.tips_plugin_download_failed);
      }
    }
  }
  
  private static boolean a(PluginAp paramPluginAp)
  {
    boolean bool = true;
    String str = com.bluefay.b.i.a(new File(paramPluginAp.m));
    if (str.equals(paramPluginAp.l.toUpperCase())) {}
    for (;;)
    {
      return bool;
      com.bluefay.b.h.b("file sign:%s expect:%s", new Object[] { str, paramPluginAp.l });
      bool = false;
    }
  }
  
  private void b()
  {
    if (this.a == null)
    {
      this.a = new com.wifi.connect.widget.a(this.b);
      this.a.setCancelable(true);
      this.a.setOnCancelListener(new d(this));
    }
    if (!this.a.isShowing()) {
      this.a.show();
    }
  }
  
  private void b(boolean paramBoolean)
  {
    if (this.a != null)
    {
      this.a.dismiss();
      if (paramBoolean) {
        this.a = null;
      }
    }
  }
  
  public final void a(com.bluefay.b.a parama)
  {
    b(false);
    k.a locala = new k.a(this.b);
    locala.a(R.string.dialog_manually_enable_mobile_connection_title);
    locala.b(R.string.dialog_manually_enable_mobile_connection_message);
    locala.a(R.string.btn_yes, new e(this, parama));
    locala.a(new f(this, parama));
    locala.c().show();
  }
  
  public final void a(PluginAp paramPluginAp, com.bluefay.b.a parama)
  {
    if (this.e) {
      b();
    }
    for (;;)
    {
      return;
      this.d = paramPluginAp;
      this.c = parama;
      com.lantern.analytics.a.e().onEvent("exregchk");
      if (!com.lantern.core.c.getServer().j())
      {
        com.lantern.analytics.a.e().onEvent("exregchkn");
        com.bluefay.a.e.a(this.b.getString(R.string.tips_plugin_need_register));
        parama = this.b;
        com.lantern.analytics.a.e().onEvent("exguide");
        paramPluginAp = new Intent("wifi.intent.action.ADD_ACCOUNT_MAIN");
        paramPluginAp.setPackage(parama.getPackageName());
        com.bluefay.a.e.a(parama, paramPluginAp);
        this.c.a(0, "No UHID", this.d);
      }
      else
      {
        com.lantern.analytics.a.e().onEvent("exregchky");
        com.lantern.analytics.a.e().onEvent("excach");
        Object localObject = com.bluefay.b.b.d(paramPluginAp.i);
        parama = com.bluefay.b.b.b(paramPluginAp.i);
        String str = String.format("%s-%d.%s", new Object[] { localObject, Integer.valueOf(paramPluginAp.g), parama });
        localObject = new File(this.f, str);
        parama = (com.bluefay.b.a)localObject;
        if (!((File)localObject).exists())
        {
          localObject = new File(this.g, str);
          parama = (com.bluefay.b.a)localObject;
          if (!((File)localObject).exists()) {
            parama = new File(this.f, str);
          }
        }
        paramPluginAp.m = parama.getAbsolutePath();
        com.bluefay.b.h.a("plugin file:" + parama.getAbsolutePath(), new Object[0]);
        if (parama.exists())
        {
          com.lantern.analytics.a.e().onEvent("excachy");
          if (a(paramPluginAp))
          {
            a(1, paramPluginAp.m, this.d);
          }
          else
          {
            a(0, "The verifysign failed", null);
            parama.delete();
          }
        }
        else
        {
          com.lantern.analytics.a.e().onEvent("excachn");
          b();
          if (!com.bluefay.a.a.c(this.b))
          {
            if (Build.VERSION.SDK_INT >= 21) {
              a(this.h);
            } else {
              b(this.h);
            }
          }
          else if (com.bluefay.a.a.a(this.b))
          {
            this.a.c(R.string.tips_network_status_checking);
            com.lantern.core.g.j.a().a(this.i);
          }
          else if (com.bluefay.a.a.b(this.b))
          {
            a();
          }
          else
          {
            a(0, "Unkown Error", null);
          }
        }
      }
    }
  }
  
  public final void b(com.bluefay.b.a parama)
  {
    b(false);
    k.a locala = new k.a(this.b);
    locala.a(R.string.dlg_whether_open_mobile_conn_title);
    locala.b(R.string.dlg_whether_open_mobile_conn_msg);
    locala.a(R.string.btn_yes, new g(this, parama));
    locala.b(R.string.btn_no, new h(this, parama));
    locala.a(new i(this, parama));
    locala.c().show();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */