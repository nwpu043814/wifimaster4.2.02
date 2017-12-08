package com.lantern.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.bluefay.a.e;
import com.bluefay.d.b;
import com.lantern.core.c;
import com.lantern.feed.R.color;
import com.lantern.feed.R.drawable;
import com.lantern.feed.R.string;
import com.lantern.feed.b.g;
import com.lantern.feed.b.r;
import com.lantern.feed.d.d;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public final class aw
  extends a
{
  private RelativeLayout p;
  private bu q;
  private FrameLayout r;
  private ImageView s;
  private TextView t;
  private bw u;
  private TextView v;
  private TextView w;
  private TextView x;
  private b y = new ax(this, new int[] { 128500 });
  
  public aw(Context paramContext)
  {
    super(paramContext);
    paramContext = new RelativeLayout(this.d);
    paramContext.setId(65541);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, d.a(this.d, 90.0F));
    ((RelativeLayout.LayoutParams)localObject1).addRule(10);
    addView(paramContext, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new View(this.d);
    ((View)localObject1).setId(65543);
    ((View)localObject1).setBackgroundColor(getResources().getColor(R.color.feed_service_line));
    Object localObject2 = new RelativeLayout.LayoutParams(-1, 1);
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, paramContext.getId());
    addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.p = new RelativeLayout(this.d);
    this.p.setId(65538);
    this.p.setOnClickListener(new ay(this));
    localObject2 = new RelativeLayout.LayoutParams(-1, d.a(this.d, 37.0F));
    ((RelativeLayout.LayoutParams)localObject2).addRule(3, ((View)localObject1).getId());
    ((RelativeLayout.LayoutParams)localObject2).leftMargin = d.a(this.d, 15.0F);
    ((RelativeLayout.LayoutParams)localObject2).rightMargin = d.a(this.d, 15.0F);
    addView(this.p, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new View(this.d);
    ((View)localObject2).setBackgroundColor(getResources().getColor(R.color.feed_tip_bg));
    localObject1 = new RelativeLayout.LayoutParams(-1, d.a(this.d, 9.0F));
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, this.p.getId());
    addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    removeView(this.i);
    this.q = new bu(this.d);
    this.q.setId(65537);
    localObject1 = new RelativeLayout.LayoutParams(d.a(this.d, 49.0F), d.a(this.d, 46.0F));
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((RelativeLayout.LayoutParams)localObject1).addRule(9);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = d.a(this.d, 15.0F);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = d.a(this.d, 15.0F);
    paramContext.addView(this.q, (ViewGroup.LayoutParams)localObject1);
    this.r = new FrameLayout(this.d);
    this.r.setId(65544);
    this.r.setOnClickListener(new az(this));
    localObject1 = new RelativeLayout.LayoutParams(d.a(this.d, 66.0F), d.a(this.d, 25.0F));
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = d.a(this.d, 15.0F);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = d.a(this.d, 15.0F);
    paramContext.addView(this.r, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new LinearLayout(this.d);
    localObject2 = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject2).gravity = 17;
    this.r.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.s = new ImageView(this.d);
    this.s.setImageResource(R.drawable.feed_add_follow);
    this.s.setVisibility(8);
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).gravity = 16;
    ((LinearLayout.LayoutParams)localObject2).rightMargin = d.a(this.d, 6.0F);
    ((LinearLayout)localObject1).addView(this.s, (ViewGroup.LayoutParams)localObject2);
    this.t = new TextView(this.d);
    this.t.setTextSize(12.0F);
    this.t.setGravity(17);
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject2).gravity = 16;
    ((LinearLayout)localObject1).addView(this.t, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new LinearLayout(this.d);
    ((LinearLayout)localObject1).setOrientation(1);
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    ((RelativeLayout.LayoutParams)localObject2).addRule(1, this.q.getId());
    ((RelativeLayout.LayoutParams)localObject2).addRule(0, this.r.getId());
    paramContext.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    paramContext = new LinearLayout(this.d);
    localObject2 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject2).bottomMargin = d.a(this.d, 6.0F);
    ((LinearLayout)localObject1).addView(paramContext, (ViewGroup.LayoutParams)localObject2);
    this.u = new bw(this.d);
    localObject2 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout)localObject1).addView(this.u, (ViewGroup.LayoutParams)localObject2);
    this.v = new TextView(this.d);
    this.v.setTextSize(10.0F);
    this.v.setTextColor(getResources().getColor(R.color.feed_service_tag_text));
    this.v.setMaxLines(1);
    this.v.setGravity(17);
    this.v.setBackgroundResource(R.drawable.feed_service_tag_bg);
    localObject1 = new LinearLayout.LayoutParams(d.a(this.d, 26.0F), d.a(this.d, 15.0F));
    ((LinearLayout.LayoutParams)localObject1).gravity = 16;
    ((LinearLayout.LayoutParams)localObject1).rightMargin = d.a(this.d, 6.0F);
    paramContext.addView(this.v, (ViewGroup.LayoutParams)localObject1);
    this.f = new TextView(this.d);
    this.f.setTextSize(16.0F);
    this.f.setTextColor(getResources().getColor(R.color.feed_service_title));
    this.f.setMaxLines(1);
    this.f.setEllipsize(TextUtils.TruncateAt.END);
    localObject1 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject1).gravity = 16;
    paramContext.addView(this.f, (ViewGroup.LayoutParams)localObject1);
    paramContext = new ImageView(this.d);
    paramContext.setId(65543);
    paramContext.setImageResource(R.drawable.feed_service_louder);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(9);
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    this.p.addView(paramContext, (ViewGroup.LayoutParams)localObject1);
    this.x = new TextView(this.d);
    this.x.setId(65542);
    this.x.setTextSize(12.0F);
    this.x.setTextColor(getResources().getColor(R.color.feed_service_msg));
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    this.p.addView(this.x, (ViewGroup.LayoutParams)localObject1);
    this.w = new TextView(this.d);
    this.w.setTextSize(12.0F);
    this.w.setTextColor(getResources().getColor(R.color.feed_service_msg));
    this.w.setMaxLines(1);
    this.w.setEllipsize(TextUtils.TruncateAt.END);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, paramContext.getId());
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, this.x.getId());
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = d.a(this.d, 12.0F);
    this.p.addView(this.w, (ViewGroup.LayoutParams)localObject1);
    c.addListener(this.y);
  }
  
  private void f()
  {
    if (this.k.R())
    {
      if (this.s.getVisibility() != 8) {
        this.s.setVisibility(8);
      }
      this.t.setText(R.string.feed_service_followed);
      this.t.setTextColor(getResources().getColor(R.color.white));
      this.r.setBackgroundResource(R.drawable.feed_service_followed_bg);
    }
    for (;;)
    {
      return;
      if (this.s.getVisibility() != 0) {
        this.s.setVisibility(0);
      }
      this.t.setText(R.string.feed_service_follow);
      this.t.setTextColor(getResources().getColor(R.color.framework_primary_color));
      this.r.setBackgroundResource(R.drawable.feed_service_follow_bg);
    }
  }
  
  private void g()
  {
    Intent localIntent = new Intent("com.linksure.aps.action.VIEW");
    localIntent.setPackage(c.getAppContext().getPackageName());
    localIntent.addFlags(268435456);
    localIntent.putExtra("refer", "feeds");
    localIntent.putExtra("aps_id", this.k.U());
    e.a(c.getAppContext(), localIntent);
  }
  
  public final void b(g paramg)
  {
    Object localObject;
    if (paramg != null)
    {
      localObject = paramg.T();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label106;
      }
      if (this.v.getVisibility() != 0) {
        this.v.setVisibility(0);
      }
      this.v.setText((CharSequence)localObject);
    }
    label106:
    label248:
    label259:
    for (;;)
    {
      this.f.setText(paramg.g());
      this.u.a(paramg.S());
      f();
      paramg = paramg.l();
      if ((paramg == null) || (paramg.size() == 0)) {
        if (this.p.getVisibility() != 8) {
          this.p.setVisibility(8);
        }
      }
      for (;;)
      {
        return;
        if (this.v.getVisibility() == 8) {
          break label259;
        }
        this.v.setVisibility(8);
        break;
        if (this.p.getVisibility() != 0) {
          this.p.setVisibility(0);
        }
        localObject = (List)paramg.get(1);
        if ((localObject != null) && (((List)localObject).size() > 0)) {
          this.x.setText(((r)((List)localObject).get(0)).a());
        }
        for (;;)
        {
          paramg = (List)paramg.get(0);
          if ((paramg == null) || (paramg.size() <= 0)) {
            break label248;
          }
          this.w.setText(((r)paramg.get(0)).a());
          break;
          this.x.setText("");
        }
        this.w.setText("");
      }
    }
  }
  
  public final void c()
  {
    super.c();
    if ((this.k.t() != null) && (this.k.t().size() > 0))
    {
      String str = (String)this.k.t().get(0);
      if (!TextUtils.isEmpty(str)) {
        this.q.a(str);
      }
    }
  }
  
  public final void d()
  {
    a(4);
    this.q.a();
  }
  
  public final boolean e()
  {
    return true;
  }
  
  public final void onClick(View paramView)
  {
    g();
    paramView = new HashMap();
    paramView.put("dataType", String.valueOf(this.k.b()));
    paramView.put("id", this.k.r());
    paramView.put("pageNo", String.valueOf(this.k.o()));
    paramView.put("pos", String.valueOf(this.k.p()));
    paramView.put("template", String.valueOf(this.k.c()));
    paramView.put("fv", "1018");
    com.lantern.analytics.a.e().onEvent("doacli", new JSONObject(paramView).toString());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */