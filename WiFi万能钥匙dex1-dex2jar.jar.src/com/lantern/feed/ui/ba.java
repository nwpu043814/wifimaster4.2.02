package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.lantern.core.imageloader.WkImageView;
import com.lantern.feed.R.color;
import com.lantern.feed.b.g;
import com.lantern.feed.d.d;
import java.util.List;

public final class ba
  extends a
{
  private WkImageView p;
  private WkImageView q;
  private WkImageView r;
  private TextView s;
  private TextView t;
  private TextView u;
  
  public ba(Context paramContext)
  {
    super(paramContext);
    paramContext = new RelativeLayout(this.d);
    paramContext.setId(65543);
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = d.a(this.d, 15.0F);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = d.a(this.d, 14.0F);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = d.a(this.d, 15.0F);
    this.h.addView(paramContext, (ViewGroup.LayoutParams)localObject1);
    Object localObject3 = new FrameLayout(this.d);
    ((FrameLayout)localObject3).setOnClickListener(new bb(this));
    localObject1 = new RelativeLayout.LayoutParams(o, n);
    ((RelativeLayout.LayoutParams)localObject1).addRule(9);
    paramContext.addView((View)localObject3, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new FrameLayout(this.d);
    ((FrameLayout)localObject1).setOnClickListener(new bc(this));
    Object localObject2 = new RelativeLayout.LayoutParams(o, n);
    ((RelativeLayout.LayoutParams)localObject2).addRule(14);
    paramContext.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = new FrameLayout(this.d);
    ((FrameLayout)localObject2).setOnClickListener(new bd(this));
    Object localObject4 = new RelativeLayout.LayoutParams(o, n);
    ((RelativeLayout.LayoutParams)localObject4).addRule(11);
    paramContext.addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
    this.p = new WkImageView(this.d);
    ((FrameLayout)localObject3).addView(this.p);
    this.s = new TextView(this.d);
    this.s.setIncludeFontPadding(false);
    this.s.setTextSize(15.0F);
    this.s.setTextColor(getResources().getColor(R.color.white));
    this.s.setMaxLines(1);
    this.s.setGravity(17);
    this.s.setBackgroundColor(getResources().getColor(R.color.feed_video_time_bg));
    this.s.setPadding(d.a(this.d, 4.0F), 0, d.a(this.d, 4.0F), 0);
    localObject4 = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject4).gravity = 80;
    ((FrameLayout)localObject3).addView(this.s, (ViewGroup.LayoutParams)localObject4);
    this.q = new WkImageView(this.d);
    ((FrameLayout)localObject1).addView(this.q);
    this.t = new TextView(this.d);
    this.t.setIncludeFontPadding(false);
    this.t.setTextSize(15.0F);
    this.t.setTextColor(getResources().getColor(R.color.white));
    this.t.setMaxLines(1);
    this.t.setGravity(17);
    this.t.setBackgroundColor(getResources().getColor(R.color.feed_video_time_bg));
    this.t.setPadding(d.a(this.d, 4.0F), 0, d.a(this.d, 4.0F), 0);
    localObject3 = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject3).gravity = 80;
    ((FrameLayout)localObject1).addView(this.t, (ViewGroup.LayoutParams)localObject3);
    this.r = new WkImageView(this.d);
    ((FrameLayout)localObject2).addView(this.r);
    this.u = new TextView(this.d);
    this.u.setIncludeFontPadding(false);
    this.u.setTextSize(15.0F);
    this.u.setTextColor(getResources().getColor(R.color.white));
    this.u.setMaxLines(1);
    this.u.setGravity(17);
    this.u.setBackgroundColor(getResources().getColor(R.color.feed_video_time_bg));
    this.u.setPadding(d.a(this.d, 4.0F), 0, d.a(this.d, 4.0F), 0);
    localObject1 = new FrameLayout.LayoutParams(-1, -2);
    ((FrameLayout.LayoutParams)localObject1).gravity = 80;
    ((FrameLayout)localObject2).addView(this.u, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, paramContext.getId());
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    this.h.addView(this.g, (ViewGroup.LayoutParams)localObject1);
    this.j = new ai(this.d);
    this.j.setId(65542);
    localObject1 = new RelativeLayout.LayoutParams(-1, d.a(this.d, 30.0F));
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, paramContext.getId());
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, this.g.getId());
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = d.a(this.d, 15.0F);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = d.a(this.d, 15.0F);
    this.h.addView(this.j, (ViewGroup.LayoutParams)localObject1);
  }
  
  public final void b(g paramg)
  {
    String str;
    if (paramg != null)
    {
      setBackgroundColor(getResources().getColor(R.color.white));
      str = paramg.d(0);
      if (!TextUtils.isEmpty(str)) {
        break label132;
      }
      if (this.s.getVisibility() != 8) {
        this.s.setVisibility(8);
      }
      str = paramg.d(1);
      if (!TextUtils.isEmpty(str)) {
        break label161;
      }
      if (this.t.getVisibility() != 8) {
        this.t.setVisibility(8);
      }
      label86:
      str = paramg.d(2);
      if (!TextUtils.isEmpty(str)) {
        break label190;
      }
      if (this.u.getVisibility() != 8) {
        this.u.setVisibility(8);
      }
    }
    for (;;)
    {
      this.j.a(paramg.l());
      return;
      label132:
      if (this.s.getVisibility() != 0) {
        this.s.setVisibility(0);
      }
      this.s.setText(str);
      break;
      label161:
      if (this.t.getVisibility() != 0) {
        this.t.setVisibility(0);
      }
      this.t.setText(str);
      break label86;
      label190:
      if (this.u.getVisibility() != 0) {
        this.u.setVisibility(0);
      }
      this.u.setText(str);
    }
  }
  
  public final void c()
  {
    super.c();
    Object localObject = this.k.k(0);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (String)((List)localObject).get(0);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.p.a((String)localObject, o, n);
      }
    }
    localObject = this.k.k(1);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (String)((List)localObject).get(0);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.q.a((String)localObject, o, n);
      }
    }
    localObject = this.k.k(2);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (String)((List)localObject).get(0);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        this.r.a((String)localObject, o, n);
      }
    }
  }
  
  public final void d()
  {
    super.d();
    a(4);
    this.p.setImageDrawable(null);
    this.q.setImageDrawable(null);
    this.r.setImageDrawable(null);
  }
  
  public final boolean e()
  {
    return true;
  }
  
  public final void onClick(View paramView) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */