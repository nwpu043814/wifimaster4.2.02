package com.lantern.launcher.ui;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import bluefay.app.w;
import bluefay.widget.BLCheckBox;
import com.bluefay.d.b;
import com.lantern.core.c;
import com.lantern.core.g.k;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.core.p;
import com.lantern.core.q;
import com.lantern.core.t;
import com.qihoo.util.StubApp1053578832;
import java.util.Calendar;

public class MainActivityICS
  extends w
{
  private static int[] g = { 128602, 128601, 128603 };
  private com.bluefay.b.a f = new e(this);
  private b h = new g(this, g);
  private com.lantern.core.g.k.a i = new h(this);
  
  static
  {
    StubApp1053578832.interface11(30);
  }
  
  private static long a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  private void a(Intent paramIntent, boolean paramBoolean)
  {
    if (paramIntent == null) {}
    for (;;)
    {
      return;
      Object localObject;
      if (paramIntent.hasExtra("jump_to_tab"))
      {
        localObject = paramIntent.getStringExtra("jump_to_tab");
        if (TextUtils.isEmpty((CharSequence)localObject)) {}
      }
      try
      {
        b((String)localObject);
        if (((String)localObject).equals("Connect"))
        {
          localObject = paramIntent.getExtras();
          if ((localObject != null) && (paramBoolean))
          {
            localObject = (WkAccessPoint)((Bundle)localObject).getParcelable("extra_jump_connect_ap");
            if (localObject != null) {
              com.lantern.core.h.a((WkAccessPoint)localObject);
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.bluefay.b.h.a(localException);
        }
      }
      if (paramIntent.hasExtra("jump_to_intent"))
      {
        paramIntent = (Intent)paramIntent.getParcelableExtra("jump_to_intent");
        if (paramIntent != null)
        {
          com.bluefay.b.h.a("jumpTo:%s", new Object[] { paramIntent });
          try
          {
            startActivity(paramIntent);
          }
          catch (Exception paramIntent)
          {
            com.bluefay.b.h.a(paramIntent);
          }
        }
      }
    }
  }
  
  private boolean a(Intent paramIntent)
  {
    if ((paramIntent != null) && (paramIntent.hasExtra("tab")))
    {
      paramIntent = paramIntent.getStringExtra("tab");
      "Connect".equals(paramIntent);
      b(paramIntent);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void h()
  {
    if (c.getShareValue().e())
    {
      c.getShareValue().c(false);
      new i(this).start();
    }
  }
  
  public final void a(com.bluefay.widget.g paramg, FragmentTransaction paramFragmentTransaction)
  {
    super.a(paramg, paramFragmentTransaction);
    paramg = paramg.c();
    if ("Connect".equals(paramg)) {
      com.lantern.analytics.a.e();
    }
    for (;;)
    {
      return;
      if ("Connect".equals(paramg)) {
        com.lantern.analytics.a.e();
      } else if ("Mine".equals(paramg)) {
        com.lantern.analytics.a.e();
      } else if ("Dynamic".equals(paramg)) {
        com.lantern.analytics.a.e();
      }
    }
  }
  
  public void onBackPressed()
  {
    if (t.f(this))
    {
      bluefay.app.k.a locala = new bluefay.app.k.a(this);
      locala.a(2131363289);
      View localView = getLayoutInflater().inflate(2130968788, null);
      BLCheckBox localBLCheckBox = (BLCheckBox)localView.findViewById(2131820881);
      locala.a(localView);
      locala.a(2131362755, new l(this, localBLCheckBox));
      locala.b(2131362756, null);
      locala.d();
    }
    for (;;)
    {
      return;
      com.lantern.analytics.a.e().onEvent("qunodisp");
      h();
      super.onBackPressed();
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    k.a().b();
    c.getShareValue().b(false);
    c.removeListener(this.h);
    super.onDestroy();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    a(paramIntent, true);
    a(paramIntent);
    if (paramIntent != null)
    {
      Bundle localBundle = paramIntent.getExtras();
      paramIntent = Message.obtain();
      paramIntent.what = 128310;
      paramIntent.obj = localBundle;
      c.dispatch(paramIntent);
    }
  }
  
  protected void onPause()
  {
    com.lantern.analytics.a.e().a("manout");
    super.onPause();
  }
  
  protected void onResume()
  {
    com.lantern.analytics.a.e().a("manin");
    int j = 2131363287;
    if (TextUtils.isEmpty(p.c(this))) {
      j = 2131363288;
    }
    a("Mine", j);
    super.onResume();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/ui/MainActivityICS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */