package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.lantern.core.imageloader.WkImageView;
import com.lantern.feed.R.color;
import com.lantern.feed.R.drawable;
import com.lantern.feed.b.g;
import com.lantern.feed.b.r;
import com.lantern.feed.d.d;
import java.util.List;

public final class cl
  extends a
{
  private WkImageView p;
  private TextView q;
  private WkImageView r;
  private LinearLayout s;
  private TextView t;
  private TextView u;
  private TextView v;
  
  public cl(Context paramContext)
  {
    super(paramContext);
    removeView(this.i);
    this.p = new WkImageView(this.d);
    this.p.setId(4097);
    this.p.setPadding(d.a(this.d, 15.0F), d.a(this.d, 7.0F), d.a(this.d, 12.0F), d.a(this.d, 7.0F));
    this.p.setOnClickListener(new cm(this));
    paramContext = new RelativeLayout.LayoutParams(d.a(this.d, 69.0F), d.a(this.d, 56.0F));
    paramContext.addRule(9);
    paramContext.addRule(10);
    this.h.addView(this.p, paramContext);
    this.v = new TextView(this.d);
    this.v.setId(4098);
    this.v.setTextColor(getResources().getColor(R.color.feed_news_wechat_toptag));
    this.v.setTextSize(13.0F);
    this.v.setGravity(17);
    this.v.setBackgroundColor(getResources().getColor(R.color.feed_news_wechat_toptag_bg));
    this.v.setPadding(d.a(this.d, 13.0F), 0, d.a(this.d, 13.0F), 0);
    paramContext = new RelativeLayout.LayoutParams(-2, d.a(this.d, 24.0F));
    paramContext.leftMargin = d.a(this.d, 7.0F);
    paramContext.topMargin = d.a(this.d, 7.0F);
    paramContext.rightMargin = d.a(this.d, 15.0F);
    paramContext.addRule(11);
    paramContext.addRule(10);
    this.h.addView(this.v, paramContext);
    paramContext = new LinearLayout(this.d);
    paramContext.setOrientation(1);
    Object localObject = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(1, this.p.getId());
    ((RelativeLayout.LayoutParams)localObject).addRule(0, this.v.getId());
    this.h.addView(paramContext, (ViewGroup.LayoutParams)localObject);
    localObject = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject).addRule(11);
    ((RelativeLayout.LayoutParams)localObject).addRule(12);
    ((RelativeLayout.LayoutParams)localObject).rightMargin = d.a(this.d, 15.0F);
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = d.a(this.d, 6.0F);
    this.h.addView(this.g, (ViewGroup.LayoutParams)localObject);
    this.f = new TextView(this.d);
    this.f.setId(4099);
    this.f.setTextColor(getResources().getColor(R.color.feed_news_wechat_title));
    this.f.setTextSize(15.0F);
    this.f.setMaxLines(1);
    this.f.setPadding(0, d.a(this.d, 7.0F), 0, d.a(this.d, 15.0F));
    this.f.setOnClickListener(new cn(this));
    paramContext.addView(this.f);
    this.q = new TextView(this.d);
    this.q.setId(4100);
    this.q.setTextColor(getResources().getColor(R.color.feed_news_wechat_content));
    this.q.setTextSize(13.0F);
    this.q.setMaxLines(4);
    this.q.setPadding(0, 0, 0, d.a(this.d, 9.0F));
    this.q.setOnClickListener(new co(this));
    paramContext.addView(this.q);
    this.r = new WkImageView(this.d);
    this.r.setId(4101);
    this.r.setOnClickListener(new cp(this));
    localObject = new LinearLayout.LayoutParams(d.a(this.d, 180.0F), d.a(this.d, 180.0F));
    paramContext.addView(this.r, (ViewGroup.LayoutParams)localObject);
    this.s = new LinearLayout(this.d);
    this.s.setId(4102);
    this.s.setOrientation(0);
    this.s.setPadding(0, d.a(this.d, 19.0F), 0, d.a(this.d, 13.0F));
    this.s.setOnClickListener(new cq(this));
    paramContext.addView(this.s);
    this.u = new TextView(this.d);
    this.u.setTextColor(getResources().getColor(R.color.feed_news_wechat_address));
    this.u.setTextSize(10.0F);
    this.u.setMaxLines(1);
    this.u.setPadding(0, 0, 0, d.a(this.d, 14.0F));
    this.u.setOnClickListener(new cr(this));
    paramContext.addView(this.u);
    this.t = new TextView(this.d);
    this.t.setTextColor(getResources().getColor(R.color.feed_news_wechat_detail));
    this.t.setTextSize(13.0F);
    this.t.setMaxLines(1);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 16;
    this.s.addView(this.t, paramContext);
    paramContext = new ImageView(this.d);
    paramContext.setImageResource(R.drawable.feed_wechat_detaillink);
    localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    ((LinearLayout.LayoutParams)localObject).leftMargin = d.a(this.d, 7.0F);
    this.s.addView(paramContext, (ViewGroup.LayoutParams)localObject);
  }
  
  public final void b(g paramg)
  {
    label137:
    label178:
    label219:
    int n;
    int i1;
    int m;
    int k;
    int i;
    int j;
    float f;
    if (this.k != null)
    {
      setBackgroundColor(getResources().getColor(R.color.white));
      this.f.setText(this.k.g());
      paramg = this.k.v();
      if (TextUtils.isEmpty(paramg)) {
        break label379;
      }
      if (this.q.getVisibility() != 0) {
        this.q.setVisibility(0);
      }
      this.q.setText(paramg);
      if ((this.k.Q() == null) || (TextUtils.isEmpty(this.k.Q().a()))) {
        break label403;
      }
      if (this.v.getVisibility() != 0) {
        this.v.setVisibility(0);
      }
      this.v.setText(this.k.Q().a());
      paramg = this.k.M();
      if (TextUtils.isEmpty(paramg)) {
        break label427;
      }
      if (this.s.getVisibility() != 0) {
        this.s.setVisibility(0);
      }
      this.t.setText(paramg);
      paramg = this.k.L();
      if (TextUtils.isEmpty(paramg)) {
        break label451;
      }
      if (this.u.getVisibility() != 0) {
        this.u.setVisibility(0);
      }
      this.u.setText(paramg);
      n = this.r.getMeasuredWidth();
      i1 = this.r.getMeasuredHeight();
      m = d.a(this.d, 180.0F);
      k = d.a(this.d, 180.0F);
      int i2 = this.k.u();
      int i3 = this.k.s();
      i = k;
      j = m;
      if (i2 > 0)
      {
        i = k;
        j = m;
        if (i3 > 0)
        {
          f = this.k.u() / this.k.s();
          if (f != 1.0F) {
            break label475;
          }
          j = d.a(this.d, 180.0F);
          i = d.a(this.d, 180.0F);
        }
      }
    }
    for (;;)
    {
      if ((j != n) || (i != i1))
      {
        paramg = new LinearLayout.LayoutParams(j, i);
        this.r.setLayoutParams(paramg);
      }
      return;
      label379:
      if (this.q.getVisibility() == 8) {
        break;
      }
      this.q.setVisibility(8);
      break;
      label403:
      if (this.v.getVisibility() == 8) {
        break label137;
      }
      this.v.setVisibility(8);
      break label137;
      label427:
      if (this.s.getVisibility() == 8) {
        break label178;
      }
      this.s.setVisibility(8);
      break label178;
      label451:
      if (this.u.getVisibility() == 8) {
        break label219;
      }
      this.u.setVisibility(8);
      break label219;
      label475:
      if (f == 1.25F)
      {
        j = d.a(this.d, 180.0F);
        i = d.a(this.d, 144.0F);
      }
      else
      {
        i = k;
        j = m;
        if (f == 0.8F)
        {
          j = d.a(this.d, 144.0F);
          i = d.a(this.d, 180.0F);
        }
      }
    }
  }
  
  public final void c()
  {
    super.c();
    if (!TextUtils.isEmpty(this.k.O())) {
      this.p.a(this.k.O(), d.a(this.d, 42.0F), d.a(this.d, 42.0F));
    }
    if ((this.k.t() != null) && (this.k.t().size() > 0))
    {
      String str = (String)this.k.t().get(0);
      if (!TextUtils.isEmpty(str)) {
        this.r.a(str, this.r.getMeasuredWidth(), this.r.getMeasuredHeight());
      }
    }
  }
  
  public final void d()
  {
    super.d();
    a(4);
    this.p.setImageDrawable(null);
    this.r.setImageDrawable(null);
  }
  
  public final boolean e()
  {
    return true;
  }
  
  public final void onClick(View paramView) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */