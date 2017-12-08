package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import bluefay.app.k.a;
import com.lantern.core.imageloader.WkImageView;
import com.lantern.feed.R.color;
import com.lantern.feed.R.drawable;
import com.lantern.feed.R.string;
import java.util.List;

public final class d
  extends a
{
  private WkImageView p;
  private RelativeLayout q;
  private TextView r;
  private TextView s;
  
  public d(Context paramContext)
  {
    super(paramContext);
    paramContext = new RelativeLayout(this.d);
    paramContext.setId(65541);
    this.p = new WkImageView(this.d);
    this.p.setId(65537);
    Object localObject1 = new RelativeLayout.LayoutParams(com.lantern.feed.d.d.a(this.d, 72.0F), com.lantern.feed.d.d.a(this.d, 72.0F));
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = com.lantern.feed.d.d.a(this.d, 12.0F);
    paramContext.addView(this.p, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new LinearLayout(this.d);
    ((LinearLayout)localObject1).setOrientation(1);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject2).addRule(0, this.p.getId());
    ((RelativeLayout.LayoutParams)localObject2).addRule(15);
    paramContext.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.f = new TextView(this.d);
    this.f.setId(65540);
    this.f.setIncludeFontPadding(false);
    this.f.setTextSize(17.0F);
    this.f.setMaxLines(2);
    this.f.setEllipsize(TextUtils.TruncateAt.END);
    localObject2 = new LinearLayout.LayoutParams(-1, -2);
    ((LinearLayout)localObject1).addView(this.f, (ViewGroup.LayoutParams)localObject2);
    ((LinearLayout)localObject1).addView(new View(this.d), new RelativeLayout.LayoutParams(-1, com.lantern.feed.d.d.a(this.d, 9.0F)));
    this.q = new RelativeLayout(this.d);
    localObject2 = new RelativeLayout.LayoutParams(-1, -2);
    ((LinearLayout)localObject1).addView(this.q, (ViewGroup.LayoutParams)localObject2);
    this.r = new TextView(this.d);
    this.r.setId(65544);
    this.r.setGravity(17);
    this.r.setIncludeFontPadding(false);
    this.r.setText(R.string.feed_download);
    this.r.setTextSize(12.0F);
    this.r.setSingleLine(true);
    this.r.setTextColor(getResources().getColor(R.color.feed_download_text));
    this.r.setOnClickListener(new e(this));
    localObject1 = new RelativeLayout.LayoutParams(com.lantern.feed.d.d.a(this.d, 72.0F), com.lantern.feed.d.d.a(this.d, 30.0F));
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    this.q.addView(this.r, (ViewGroup.LayoutParams)localObject1);
    this.s = new TextView(this.d);
    this.s.setGravity(16);
    this.s.setSingleLine(true);
    this.s.setEllipsize(TextUtils.TruncateAt.END);
    this.s.setTextSize(15.0F);
    this.s.setTextColor(getResources().getColor(R.color.feed_download_desc));
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    ((RelativeLayout.LayoutParams)localObject1).addRule(9);
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, this.r.getId());
    this.q.addView(this.s, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-1, -2);
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = com.lantern.feed.d.d.a(this.d, 15.0F);
    ((RelativeLayout.LayoutParams)localObject1).topMargin = com.lantern.feed.d.d.a(this.d, 12.0F);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = com.lantern.feed.d.d.a(this.d, 15.0F);
    this.h.addView(paramContext, -1, (ViewGroup.LayoutParams)localObject1);
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, paramContext.getId());
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    this.h.addView(this.g, (ViewGroup.LayoutParams)localObject1);
    this.j = new ai(this.d);
    this.j.setId(65542);
    localObject1 = new RelativeLayout.LayoutParams(-1, com.lantern.feed.d.d.a(this.d, 30.0F));
    ((RelativeLayout.LayoutParams)localObject1).addRule(3, paramContext.getId());
    ((RelativeLayout.LayoutParams)localObject1).addRule(0, this.g.getId());
    ((RelativeLayout.LayoutParams)localObject1).leftMargin = com.lantern.feed.d.d.a(this.d, 15.0F);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = com.lantern.feed.d.d.a(this.d, 15.0F);
    this.h.addView(this.j, -1, (ViewGroup.LayoutParams)localObject1);
  }
  
  private void b(int paramInt)
  {
    this.r.setBackgroundResource(R.drawable.feed_tag_bg);
    this.r.setTextColor(getResources().getColor(R.color.feed_download_text));
    int i = getResources().getColor(R.color.feed_download_bg);
    int j = getResources().getColor(R.color.feed_download_pendding_bg);
    switch (paramInt)
    {
    default: 
      paramInt = j;
    }
    for (;;)
    {
      Object localObject = this.r.getBackground();
      if ((localObject instanceof GradientDrawable))
      {
        localObject = (GradientDrawable)localObject;
        ((GradientDrawable)localObject).setColor(i);
        ((GradientDrawable)localObject).setStroke(com.lantern.feed.d.d.a(this.d, 0.5F), paramInt);
      }
      return;
      this.r.setText(R.string.feed_download);
      i = getResources().getColor(R.color.feed_download_bg);
      paramInt = getResources().getColor(R.color.feed_download_pendding_bg);
      continue;
      this.r.setText(R.string.feed_download_pause);
      this.r.setTextColor(getResources().getColor(R.color.feed_downloaded_text));
      i = getResources().getColor(R.color.feed_downloading_bg);
      paramInt = getResources().getColor(R.color.feed_downloading_bg);
      continue;
      this.r.setText(R.string.feed_download_resume);
      i = getResources().getColor(R.color.feed_download_pause_bg);
      paramInt = getResources().getColor(R.color.feed_download_pause_bg);
      continue;
      this.r.setText(R.string.feed_download_install);
      this.r.setTextColor(getResources().getColor(R.color.feed_downloaded_text));
      i = getResources().getColor(R.color.feed_downloaded_bg);
      paramInt = getResources().getColor(R.color.feed_downloaded_bg);
    }
  }
  
  public final void b(com.lantern.feed.b.g paramg)
  {
    if (paramg != null)
    {
      this.f.setText(com.lantern.feed.d.d.d(paramg.g()), TextView.BufferType.SPANNABLE);
      if (!paramg.m()) {
        break label220;
      }
      this.f.setTextColor(getResources().getColor(R.color.feed_title_text_read));
      this.s.setText(paramg.J());
      Object localObject = paramg.H();
      localObject = com.lantern.feed.d.d.a(this.d, (String)localObject);
      if ((TextUtils.isEmpty(paramg.G())) || ((localObject == null) && (!TextUtils.isEmpty(paramg.I())))) {
        break label234;
      }
      localObject = paramg.G();
      this.r.setBackgroundResource(R.drawable.feed_tag_bg);
      this.r.setTextColor(getResources().getColor(R.color.feed_download_text));
      this.r.setText((CharSequence)localObject);
      int j = getResources().getColor(R.color.feed_download_bg);
      int i = getResources().getColor(R.color.feed_download_pendding_bg);
      localObject = this.r.getBackground();
      if ((localObject instanceof GradientDrawable))
      {
        localObject = (GradientDrawable)localObject;
        ((GradientDrawable)localObject).setColor(j);
        ((GradientDrawable)localObject).setStroke(com.lantern.feed.d.d.a(this.d, 0.5F), i);
      }
    }
    for (;;)
    {
      this.j.a(paramg.l());
      return;
      label220:
      this.f.setTextColor(paramg.d());
      break;
      label234:
      b(paramg.E());
    }
  }
  
  public final void c()
  {
    super.c();
    if ((this.k.t() != null) && (this.k.t().size() > 0))
    {
      String str = (String)this.k.t().get(0);
      if (!TextUtils.isEmpty(str)) {
        this.p.a(str, com.lantern.feed.d.d.a(this.d, 72.0F), com.lantern.feed.d.d.a(this.d, 72.0F));
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
    String str = this.k.H();
    int i;
    if ((com.lantern.feed.d.d.a(this.d, str) == null) && (!TextUtils.isEmpty(this.k.I())))
    {
      paramView = new k.a(this.d);
      paramView.a(R.string.feed_download_dlg_title);
      i = R.string.feed_download_dlg_msg;
      switch (this.k.E())
      {
      default: 
        paramView.b(i);
        paramView.a(R.string.feed_btn_ok, new f(this));
        paramView.b(R.string.feed_btn_cancel, new g(this));
        paramView.c();
        paramView.d();
      }
    }
    for (;;)
    {
      this.k.n();
      this.f.setTextColor(getResources().getColor(R.color.feed_title_text_read));
      return;
      i = R.string.feed_download_dlg_msg_install;
      break;
      i = R.string.feed_download_dlg_msg_resume;
      break;
      i = R.string.feed_download_dlg_msg_pause;
      break;
      i = R.string.feed_download_dlg_msg;
      break;
      super.onClick(paramView);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */