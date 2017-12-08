package com.lantern.feed.ui;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.lantern.core.imageloader.WkImageView;
import com.lantern.feed.a.aj;
import com.lantern.feed.b.g;
import com.lantern.feed.d.d;
import java.util.List;

public final class an
  extends a
{
  private WkImageView p;
  private TextView q;
  private TextView r;
  
  public an(Context paramContext)
  {
    super(paramContext);
    paramContext = new RelativeLayout(this.d);
    paramContext.setId(65541);
    Object localObject2 = new FrameLayout(this.d);
    ((FrameLayout)localObject2).setId(65543);
    ((FrameLayout)localObject2).setOnClickListener(new ao(this));
    ((FrameLayout)localObject2).setPadding(d.a(this.d, 27.0F), d.a(this.d, 26.0F), 0, 0);
    Object localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    paramContext.addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    this.p = new WkImageView(this.d);
    localObject1 = new RelativeLayout.LayoutParams(d.a(this.d, 60.0F), d.a(this.d, 60.0F));
    ((FrameLayout)localObject2).addView(this.p, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new LinearLayout(this.d);
    ((LinearLayout)localObject1).setOrientation(1);
    Object localObject3 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject3).addRule(0, ((FrameLayout)localObject2).getId());
    ((RelativeLayout.LayoutParams)localObject3).topMargin = d.a(this.d, 19.0F);
    paramContext.addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
    localObject2 = new LinearLayout(this.d);
    this.q = new TextView(this.d);
    this.q.setIncludeFontPadding(false);
    this.q.setTextSize(9.0F);
    this.q.setMaxLines(1);
    this.q.setEllipsize(TextUtils.TruncateAt.END);
    this.q.setGravity(16);
    this.q.setPadding(d.a(this.d, 4.0F), 0, d.a(this.d, 5.0F), 0);
    localObject3 = new LinearLayout.LayoutParams(-2, d.a(this.d, 18.0F));
    ((LinearLayout.LayoutParams)localObject3).gravity = 16;
    ((LinearLayout.LayoutParams)localObject3).rightMargin = d.a(this.d, 3.0F);
    ((LinearLayout)localObject2).addView(this.q, (ViewGroup.LayoutParams)localObject3);
    this.f = new TextView(this.d);
    this.f.setId(65540);
    this.f.setIncludeFontPadding(false);
    this.f.setTextSize(17.0F);
    this.f.setMaxLines(1);
    this.f.setEllipsize(TextUtils.TruncateAt.END);
    localObject3 = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject3).gravity = 16;
    ((LinearLayout)localObject2).addView(this.f, (ViewGroup.LayoutParams)localObject3);
    ((LinearLayout)localObject1).addView((View)localObject2, new LinearLayout.LayoutParams(-1, -2));
    this.r = new TextView(this.d);
    this.r.setIncludeFontPadding(false);
    this.r.setTextSize(12.0F);
    this.r.setMaxLines(3);
    this.r.setEllipsize(TextUtils.TruncateAt.END);
    localObject2 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout.LayoutParams)localObject2).topMargin = d.a(this.d, 12.0F);
    ((LinearLayout)localObject1).addView(this.r, (ViewGroup.LayoutParams)localObject2);
    localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = d.a(this.d, 15.0F);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = d.a(this.d, 15.0F);
    this.h.addView(paramContext, -1, (ViewGroup.LayoutParams)localObject1);
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
    this.h.addView(this.j, -1, (ViewGroup.LayoutParams)localObject1);
  }
  
  public final void b(g paramg)
  {
    if (paramg != null)
    {
      if (TextUtils.isEmpty(paramg.C())) {
        break label148;
      }
      if (this.q.getVisibility() != 0) {
        this.q.setVisibility(0);
      }
      this.q.setText(paramg.C());
      TextView localTextView = this.q;
      aj.a();
      localTextView.setTextColor(aj.e(paramg.f()));
      localTextView = this.q;
      aj.a();
      localTextView.setBackgroundResource(aj.f(paramg.f()));
    }
    for (;;)
    {
      this.f.setText(d.d(paramg.g()), TextView.BufferType.SPANNABLE);
      this.f.setTextColor(paramg.d());
      this.r.setText(this.k.v());
      this.r.setTextColor(paramg.x());
      this.j.a(paramg.l());
      return;
      label148:
      if (this.q.getVisibility() != 8) {
        this.q.setVisibility(8);
      }
    }
  }
  
  public final void c()
  {
    super.c();
    if ((this.k.t() != null) && (this.k.t().size() > 0)) {
      if (this.k.t().size() <= 1) {
        break label96;
      }
    }
    label96:
    for (String str = (String)this.k.t().get(1);; str = (String)this.k.t().get(0))
    {
      if (!TextUtils.isEmpty(str)) {
        this.p.a(str, d.a(this.d, 60.0F), d.a(this.d, 60.0F));
      }
      return;
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
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/an.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */