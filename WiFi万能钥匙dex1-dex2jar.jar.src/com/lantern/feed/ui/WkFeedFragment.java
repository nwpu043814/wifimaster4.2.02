package com.lantern.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import bluefay.app.ViewPagerFragment;
import bluefay.app.w;
import com.bluefay.b.h;
import com.bluefay.d.b;
import com.bluefay.material.SwipeRefreshLayout;
import com.bluefay.widget.ActionTopBarView;
import com.lantern.analytics.a;
import com.lantern.core.c;
import com.lantern.core.config.RedDotConf;
import com.lantern.core.g.j;
import com.lantern.core.g.k;
import com.lantern.core.g.k.b;
import com.lantern.core.imageloader.a.aa;
import com.lantern.core.model.WkAccessPoint;
import com.lantern.feed.R.anim;
import com.lantern.feed.R.id;
import com.lantern.feed.R.layout;
import com.lantern.feed.a.m;
import java.util.Calendar;

public class WkFeedFragment
  extends ViewPagerFragment
{
  private ViewGroup g;
  private WkFeedTabLabel h;
  private SwipeRefreshLayout i;
  private WkFeedListView j;
  private RelativeLayout k;
  private FrameLayout l;
  private FrameLayout m;
  private WkFeedUpdateToastView n;
  private bm o;
  private bi p;
  private RelativeLayout q;
  private ImageView r;
  private Animation s;
  private boolean t;
  private WkAccessPoint u;
  private boolean v;
  private Handler w = new o(this);
  private b x = new p(this, new int[] { 128005, 128030 });
  
  private static boolean a(long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong);
    if (localCalendar.get(5) != Calendar.getInstance().get(5)) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void c()
  {
    if (this.q.getVisibility() != 8) {
      this.q.setVisibility(8);
    }
  }
  
  private WkFeedTabLabel d(Context paramContext)
  {
    if (this.h == null)
    {
      this.h = new WkFeedTabLabel(paramContext);
      this.h.a(new t(this));
    }
    return this.h;
  }
  
  private static boolean d()
  {
    Object localObject = c.getCurActivity();
    boolean bool;
    if ((localObject instanceof w))
    {
      localObject = ((w)localObject).d();
      if (localObject != null)
      {
        localObject = localObject.getClass().getName();
        if (WkFeedFragment.class.getName().equals(localObject))
        {
          bool = true;
          return bool;
        }
        h.a("frag is " + (String)localObject, new Object[0]);
      }
    }
    for (;;)
    {
      bool = false;
      break;
      h.a("fragment is null", new Object[0]);
      continue;
      h.c("activity is not TabActivity");
    }
  }
  
  public final void a(Context paramContext)
  {
    if (((RedDotConf)com.lantern.core.config.d.a(this.e).a(RedDotConf.class)).e())
    {
      if (a(com.lantern.core.p.b(this.e)))
      {
        k.a().a(k.b.t);
        com.lantern.core.p.b(this.e, System.currentTimeMillis());
      }
      if (a(com.lantern.core.p.a(this.e)))
      {
        k.a().a(k.b.u);
        com.lantern.core.p.a(this.e, System.currentTimeMillis());
      }
    }
    a.e().onEvent("disin");
    b().g(8);
    b().a(null);
    b().a(d(paramContext));
    if ((this.q != null) && (this.q.getVisibility() == 0))
    {
      paramContext = j.b(this.e);
      if ((paramContext != null) && (j.b(j.a().a(paramContext))))
      {
        c();
        this.k.setVisibility(0);
        this.r.startAnimation(this.s);
        m.a().e();
      }
    }
  }
  
  public final void b(Context paramContext)
  {
    a.e().onEvent("disout");
    if (this.j != null) {
      this.j.b();
    }
    b().g(0);
    b().b(d(paramContext));
  }
  
  public final void c(Context paramContext)
  {
    super.c(paramContext);
    if ((this.i != null) && (!this.i.a()))
    {
      m.a().g();
      a.e().onEvent("dhlcli");
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.t = true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    com.lantern.feed.d.d.c("");
    if ((paramBundle != null) && ("Connect".equals(paramBundle.getString("tab")))) {
      com.lantern.feed.d.d.c(paramBundle.getString("source"));
    }
    c.addListener(this.x);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.g = ((ViewGroup)paramLayoutInflater.inflate(R.layout.feed_news_content, paramViewGroup, false));
    this.k = ((RelativeLayout)this.g.findViewById(R.id.feed_loading));
    this.s = AnimationUtils.loadAnimation(this.e, R.anim.feed_logo_anim);
    this.r = ((ImageView)this.k.findViewById(R.id.lighting_effect));
    this.r.startAnimation(this.s);
    this.q = ((RelativeLayout)this.g.findViewById(R.id.feed_error_layout));
    ((Button)this.g.findViewById(R.id.error_refresh)).setOnClickListener(new q(this));
    this.n = ((WkFeedUpdateToastView)this.g.findViewById(R.id.feed_update_toast));
    this.i = ((SwipeRefreshLayout)this.g.findViewById(R.id.feed_swipe_refresh_layout));
    this.i.a(new r(this));
    this.j = ((WkFeedListView)this.g.findViewById(R.id.feed_list));
    this.j.a("");
    this.l = ((FrameLayout)this.g.findViewById(R.id.feed_anim_container));
    this.m = ((FrameLayout)this.g.findViewById(R.id.feed_anim_view));
    m.a().a(new s(this));
    m.a().d();
    return this.g;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.t = false;
    if ((this.o != null) && (this.o.isShowing())) {
      this.o.dismiss();
    }
    if ((this.p != null) && (this.p.isShowing())) {
      this.p.dismiss();
    }
    m.a().m();
    aa.a(this.e).a();
    c.removeListener(this.x);
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.t = false;
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.j != null) {
      this.j.b();
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    h.a("onViewCreated", new Object[0]);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/WkFeedFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */