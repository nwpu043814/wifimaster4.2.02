package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.lantern.core.imageloader.WkImageView;
import com.lantern.feed.R.color;
import com.lantern.feed.R.drawable;
import com.lantern.feed.b.g;
import com.lantern.feed.d.c;
import com.lantern.feed.d.d;
import java.util.List;

public final class ad
  extends a
{
  private WkImageView p;
  private ImageView q;
  private TextView r;
  private int s;
  
  public ad(Context paramContext)
  {
    super(paramContext);
    this.f = new TextView(this.d);
    this.f.setId(65540);
    this.f.setIncludeFontPadding(false);
    this.f.setTextSize(17.0F);
    this.f.setMaxLines(2);
    this.f.setEllipsize(TextUtils.TruncateAt.END);
    paramContext = new RelativeLayout.LayoutParams(-1, -2);
    paramContext.addRule(10);
    paramContext.leftMargin = d.a(this.d, 15.0F);
    paramContext.topMargin = d.a(this.d, 14.0F);
    paramContext.rightMargin = d.a(this.d, 15.0F);
    paramContext.bottomMargin = d.a(this.d, 5.0F);
    this.h.addView(this.f, paramContext);
    paramContext = new FrameLayout(this.d);
    paramContext.setId(65543);
    Object localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, this.f.getId());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = d.a(this.d, 15.0F);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = d.a(this.d, 15.0F);
    this.h.addView(paramContext, (ViewGroup.LayoutParams)localObject);
    this.p = new WkImageView(this.d, R.drawable.common_img_bg);
    this.p.setId(65537);
    localObject = new FrameLayout.LayoutParams(b, m);
    ((FrameLayout.LayoutParams)localObject).gravity = 1;
    paramContext.addView(this.p, (ViewGroup.LayoutParams)localObject);
    this.q = new ImageView(this.d);
    this.q.setVisibility(8);
    this.q.setImageResource(R.drawable.feed_video_play);
    localObject = new FrameLayout.LayoutParams(-2, -2);
    ((FrameLayout.LayoutParams)localObject).gravity = 17;
    paramContext.addView(this.q, (ViewGroup.LayoutParams)localObject);
    this.r = new TextView(this.d);
    this.r.setTextSize(11.0F);
    this.r.setTextColor(-1);
    this.r.setGravity(17);
    this.r.setVisibility(8);
    this.r.setBackgroundResource(R.drawable.feed_video_time_bg);
    this.r.setPadding(d.a(this.d, 7.0F), 0, d.a(this.d, 7.0F), 0);
    localObject = new FrameLayout.LayoutParams(-2, d.a(this.d, 20.0F));
    ((FrameLayout.LayoutParams)localObject).gravity = 85;
    ((FrameLayout.LayoutParams)localObject).rightMargin = d.a(this.d, 4.0F);
    ((FrameLayout.LayoutParams)localObject).bottomMargin = d.a(this.d, 4.0F);
    paramContext.addView(this.r, (ViewGroup.LayoutParams)localObject);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(3, paramContext.getId());
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    this.h.addView(this.g, (ViewGroup.LayoutParams)localObject);
    this.j = new ai(this.d);
    this.j.setId(65542);
    localObject = new RelativeLayout.LayoutParams(-1, d.a(this.d, 30.0F));
    ((RelativeLayout.LayoutParams)localObject).addRule(3, paramContext.getId());
    ((RelativeLayout.LayoutParams)localObject).addRule(0, this.g.getId());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = d.a(this.d, 15.0F);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = d.a(this.d, 15.0F);
    this.h.addView(this.j, (ViewGroup.LayoutParams)localObject);
  }
  
  public final void b(g paramg)
  {
    if (paramg != null)
    {
      this.f.setText(d.d(paramg.g()), TextView.BufferType.SPANNABLE);
      if (!paramg.m()) {
        break label184;
      }
      this.f.setTextColor(getResources().getColor(R.color.feed_title_text_read));
      if (paramg.c() != 105) {
        break label198;
      }
      this.p.a(R.drawable.feed_video_thumb_bg);
      if (this.q.getVisibility() != 0) {
        this.q.setVisibility(0);
      }
      label82:
      this.j.a(paramg.l());
      if (paramg.j() <= 0) {
        break label232;
      }
      if (this.r.getVisibility() != 0) {
        this.r.setVisibility(0);
      }
      this.r.setText(c.c(paramg.j()));
    }
    for (;;)
    {
      this.s = b();
      if (this.s != this.p.getMeasuredHeight())
      {
        paramg = new FrameLayout.LayoutParams(b, this.s);
        paramg.gravity = 1;
        this.p.setLayoutParams(paramg);
      }
      return;
      label184:
      this.f.setTextColor(paramg.d());
      break;
      label198:
      if (this.q.getVisibility() == 8) {
        break label82;
      }
      this.p.a(R.drawable.common_img_small_bg);
      this.q.setVisibility(8);
      break label82;
      label232:
      if (this.r.getVisibility() != 8) {
        this.r.setVisibility(8);
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
        this.p.a(str, b, this.s);
      }
    }
  }
  
  public final void d()
  {
    super.d();
    a(4);
    this.p.setImageDrawable(null);
  }
  
  public final boolean e()
  {
    return true;
  }
  
  public final void onClick(View paramView)
  {
    super.onClick(paramView);
    this.k.n();
    this.f.setTextColor(getResources().getColor(R.color.feed_title_text_read));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */