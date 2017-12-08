package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class WkFeedUpdateToastView
  extends RelativeLayout
{
  protected float a;
  private Context b;
  private TextView c;
  
  public WkFeedUpdateToastView(Context paramContext)
  {
    super(paramContext);
    this.b = paramContext;
    this.a = getResources().getDisplayMetrics().density;
    a();
  }
  
  public WkFeedUpdateToastView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b = paramContext;
    this.a = getResources().getDisplayMetrics().density;
    a();
  }
  
  public WkFeedUpdateToastView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramContext;
    this.a = getResources().getDisplayMetrics().density;
    a();
  }
  
  private void a()
  {
    setBackgroundColor(-1475118367);
    this.c = new TextView(this.b);
    this.c.setIncludeFontPadding(false);
    this.c.setTextColor(-1);
    this.c.setTextSize(12.0F);
    this.c.setGravity(17);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, (int)(28.0F * this.a));
    localLayoutParams.addRule(13);
    addView(this.c, localLayoutParams);
  }
  
  public final void a(int paramInt, boolean paramBoolean)
  {
    this.c.setText(paramInt);
    if (paramBoolean) {
      setOnClickListener(new ce(this));
    }
    for (;;)
    {
      return;
      setOnClickListener(null);
    }
  }
  
  public final void a(String paramString)
  {
    this.c.setText(paramString);
    setOnClickListener(null);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/WkFeedUpdateToastView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */