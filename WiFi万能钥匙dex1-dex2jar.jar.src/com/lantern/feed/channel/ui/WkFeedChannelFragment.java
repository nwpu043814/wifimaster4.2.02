package com.lantern.feed.channel.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import bluefay.app.Fragment;
import com.bluefay.b.h;
import com.bluefay.material.SwipeRefreshLayout;
import com.bluefay.widget.ActionTopBarView;
import com.lantern.feed.R.anim;
import com.lantern.feed.R.color;
import com.lantern.feed.R.id;
import com.lantern.feed.R.layout;
import com.lantern.feed.a.m;
import com.lantern.feed.b.o;
import com.lantern.feed.ui.WkFeedListView;
import com.lantern.feed.ui.WkFeedTabLabel;
import com.lantern.feed.ui.WkFeedUpdateToastView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class WkFeedChannelFragment
  extends Fragment
{
  private ViewGroup g;
  private WkFeedTabLabel h;
  private SwipeRefreshLayout i;
  private WkFeedListView j;
  private RelativeLayout k;
  private WkFeedUpdateToastView l;
  private RelativeLayout m;
  private ImageView n;
  private Animation o;
  private boolean p;
  private String q;
  private String r;
  private int s;
  private Handler t = new a(this);
  
  private WkFeedTabLabel b(Context paramContext)
  {
    if (this.h == null)
    {
      this.h = new WkFeedTabLabel(paramContext);
      this.h.a(this.q);
      this.h.a(new e(this));
    }
    return this.h;
  }
  
  private void c()
  {
    if (this.m.getVisibility() != 8) {
      this.m.setVisibility(8);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.p = true;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setRetainInstance(true);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      this.q = paramBundle.getString("extra_channel_id");
      this.r = paramBundle.getString("extra_channel_title");
      b(this.e).a(this.q);
    }
    paramBundle = new HashMap();
    paramBundle.put("tabId", this.q);
    com.lantern.analytics.a.e().onEvent("disin", new JSONObject(paramBundle).toString());
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.g = ((ViewGroup)paramLayoutInflater.inflate(R.layout.feed_news_content, paramViewGroup, false));
    this.k = ((RelativeLayout)this.g.findViewById(R.id.feed_loading));
    this.o = AnimationUtils.loadAnimation(this.e, R.anim.feed_logo_anim);
    this.n = ((ImageView)this.k.findViewById(R.id.lighting_effect));
    this.n.startAnimation(this.o);
    this.m = ((RelativeLayout)this.g.findViewById(R.id.feed_error_layout));
    ((Button)this.g.findViewById(R.id.error_refresh)).setOnClickListener(new b(this));
    this.l = ((WkFeedUpdateToastView)this.g.findViewById(R.id.feed_update_toast));
    this.i = ((SwipeRefreshLayout)this.g.findViewById(R.id.feed_swipe_refresh_layout));
    this.i.a(new c(this));
    this.j = ((WkFeedListView)this.g.findViewById(R.id.feed_list));
    this.j.a(this.q);
    com.lantern.feed.channel.a.a.a().a(new d(this));
    com.lantern.feed.channel.a.a.a().a(this.q);
    return this.g;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.p = false;
    com.lantern.feed.channel.a.a.a().d();
    HashMap localHashMap = new HashMap();
    localHashMap.put("tabId", this.q);
    com.lantern.analytics.a.e().onEvent("disout", new JSONObject(localHashMap).toString());
  }
  
  public void onDetach()
  {
    super.onDetach();
    this.p = false;
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
    int i1;
    if (!isDetached())
    {
      paramView = m.a().p();
      if ((paramView == null) || (paramView.a() == null)) {
        break label172;
      }
      paramBundle = b(this.e);
      b().b(8);
      b().g(8);
      b().a(null);
      b().a(paramBundle);
      paramBundle.a(paramView);
      paramView = new ArrayList(paramView.a());
      if (paramView.size() > 0)
      {
        i1 = 0;
        if (i1 < paramView.size())
        {
          if (!((o)paramView.get(i1)).a().equals(this.q)) {
            break label166;
          }
          this.s = i1;
          b(this.e).a(this.s);
        }
      }
    }
    for (;;)
    {
      h.a("onViewCreated", new Object[0]);
      return;
      label166:
      i1++;
      break;
      label172:
      a(this.r);
      b(getResources().getColor(R.color.white));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/channel/ui/WkFeedChannelFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */