package com.lantern.launcher.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.bluefay.b.h;
import com.jiangwei.Wraper;
import com.lantern.a.a.e;
import com.lantern.core.f;
import com.lantern.core.g;
import com.lantern.core.k;
import com.lantern.core.o;
import com.lantern.core.p;
import com.qihoo.util.StubApp1053578832;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

public class MainActivity
  extends Activity
{
  View.OnClickListener a = new b(this);
  View.OnClickListener b = new c(this);
  private boolean c;
  private boolean d;
  private boolean e = false;
  private boolean f = false;
  private com.lantern.a.a.c g;
  private e h;
  private Context i;
  private TextView j;
  private ImageView k;
  private boolean l;
  private boolean m;
  private Handler n = new a(this);
  private com.bluefay.b.a o = new d(this);
  
  static
  {
    StubApp1053578832.interface11(29);
  }
  
  private void a()
  {
    if (this.h.b) {
      this.j.setVisibility(0);
    }
    Object localObject3;
    Object localObject4;
    if ((this.h.b()) && (this.g != null) && (this.m))
    {
      localObject3 = this.k;
      localObject4 = this.g;
    }
    for (;;)
    {
      boolean bool;
      Object localObject2;
      try
      {
        ((ImageView)localObject3).setImageDrawable(Drawable.createFromPath(((com.lantern.a.a.c)localObject4).j()));
        int i1 = ((com.lantern.a.a.c)localObject4).g();
        Object localObject1 = Message.obtain(this.n, 100, i1, 0);
        this.n.sendMessage((Message)localObject1);
        if ((((com.lantern.a.a.c)localObject4).i()) && (!this.e))
        {
          bool = true;
          this.f = bool;
          com.lantern.analytics.a locala = com.lantern.analytics.a.e();
          Object localObject5 = new StringBuilder("welskip_");
          if (!this.f) {
            continue;
          }
          localObject1 = "y";
          localObject5 = (String)localObject1;
          if (this.g != null) {
            continue;
          }
          localObject1 = "";
          locala.onEvent((String)localObject5, (String)localObject1);
          if (!this.f) {
            continue;
          }
          this.j.setOnClickListener(this.a);
          this.j.setVisibility(0);
          a(i1);
          if (!TextUtils.isEmpty(((com.lantern.a.a.c)localObject4).m())) {
            ((ImageView)localObject3).setOnClickListener(this.b);
          }
          com.lantern.analytics.a.e().onEvent("kpAD_show");
          c();
          this.h.b(g.a(this.g.c()));
          this.h.a(this.g);
          this.h.a = true;
          if (this.l) {
            com.lantern.core.config.d.a(com.lantern.core.c.getAppContext()).a(true);
          }
          if (!this.d) {
            break label673;
          }
          com.lantern.analytics.a.e().onEvent("actrdflg_n");
          com.lantern.core.c.getServer().t();
          if (TextUtils.isEmpty(p.j(this.i)))
          {
            localObject1 = new SimpleDateFormat("yyMMdd", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
            localObject3 = new StringBuilder().append((String)localObject1);
            if (!this.d) {
              break label666;
            }
            localObject1 = "0";
            localObject1 = (String)localObject1;
            p.n(this.i, (String)localObject1);
            com.lantern.launcher.b.a(com.lantern.core.c.getInstance());
          }
          if ((!this.e) || (!this.l)) {
            break label685;
          }
          com.lantern.bindapp.a.a(this.i);
        }
      }
      catch (Throwable localThrowable)
      {
        ((ImageView)localObject3).setImageResource(2130838356);
        h.c(localThrowable.getMessage());
        continue;
        bool = false;
        continue;
        localObject2 = "n";
        continue;
        localObject2 = this.g.b();
        continue;
        this.j.setVisibility(8);
        continue;
      }
      if ((!this.h.c()) && (this.m))
      {
        this.k.setImageResource(2130838356);
        localObject2 = Message.obtain(this.n, 100, 3, 0);
        this.n.sendMessage((Message)localObject2);
        if (!this.e)
        {
          bool = true;
          label540:
          this.f = bool;
          localObject4 = com.lantern.analytics.a.e();
          localObject3 = new StringBuilder("weldft_");
          if (!this.f) {
            break label625;
          }
        }
        label625:
        for (localObject2 = "y";; localObject2 = "n")
        {
          ((com.lantern.analytics.a)localObject4).onEvent((String)localObject2);
          if (!this.f) {
            break label632;
          }
          this.j.setOnClickListener(this.a);
          this.j.setVisibility(0);
          a(3);
          break;
          bool = false;
          break label540;
        }
        label632:
        this.j.setVisibility(8);
      }
      else
      {
        this.l = false;
        a(null);
        com.lantern.analytics.a.e().onEvent("nosplash");
        continue;
        label666:
        localObject2 = "1";
        continue;
        label673:
        com.lantern.analytics.a.e().onEvent("actrdflg_y");
        continue;
        label685:
        if ((this.e) && (!this.l)) {
          com.lantern.analytics.a.e().onEvent("bndrdno2");
        }
      }
    }
  }
  
  private void a(int paramInt)
  {
    if ((this.j == null) || (this.j.getVisibility() == 8)) {}
    for (;;)
    {
      return;
      this.j.setText(getString(2131363304, new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  private void a(Intent paramIntent)
  {
    int i2 = 1;
    Intent localIntent2 = getIntent();
    if (localIntent2 != null) {
      localIntent2.getBooleanExtra("showad", true);
    }
    for (int i1 = 0;; i1 = 1)
    {
      Intent localIntent1;
      if ((this.e) && (i1 != 0))
      {
        localIntent1 = new Intent(this.i, UserGuideActivity.class);
        if (p.a("prev_version") < f.h())
        {
          i1 = 1;
          if (i1 != 0) {
            i2 = 2;
          }
          localIntent1.putExtra("upgrade_type", i2);
          localIntent1.addFlags(67108864);
          startActivity(localIntent1);
          if (paramIntent != null) {
            startActivity(paramIntent);
          }
        }
      }
      for (;;)
      {
        finish();
        return;
        i1 = 0;
        break;
        p.b("prev_version", k.b(this.i));
        localIntent1 = new Intent(this.i, MainActivityICS.class);
        if ((localIntent2 != null) && (localIntent2.hasExtra("tab"))) {
          localIntent1.putExtras(localIntent2);
        }
        this.i.startActivity(localIntent1);
        if (paramIntent != null) {
          startActivity(paramIntent);
        }
      }
    }
  }
  
  private boolean b()
  {
    int i1 = p.a("prev_version");
    if (k.b(this.i) != i1) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void c()
  {
    if (this.g == null) {}
    for (;;)
    {
      return;
      Object localObject = this.g.k();
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.h.a((String)localObject);
      }
      localObject = this.g.n();
      if (localObject != null)
      {
        Iterator localIterator = ((ArrayList)localObject).iterator();
        while (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            this.h.a((String)localObject);
          }
        }
      }
    }
  }
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
    Wraper.hookPMS(paramContext);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(2131034142, 2131034145);
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.c = true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/launcher/ui/MainActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */