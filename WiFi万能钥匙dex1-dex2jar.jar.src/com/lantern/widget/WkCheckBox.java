package com.lantern.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.bluefay.a.e;
import com.snda.wifilocating.R.styleable;

public class WkCheckBox
  extends LinearLayout
{
  private ImageView a;
  private TextView b;
  private boolean c;
  private String d;
  private int e = 14;
  private int f = -16777216;
  private View.OnClickListener g;
  private a h;
  private View.OnClickListener i = new a(this);
  
  public WkCheckBox(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }
  
  public WkCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.a = new ImageView(paramContext);
    this.b = new TextView(paramContext);
    this.b.setIncludeFontPadding(false);
    this.b.setGravity(16);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.setMargins(e.a(paramContext, 3.0F), 0, 0, 0);
    this.b.setLayoutParams(localLayoutParams);
    setOrientation(0);
    addView(this.a);
    addView(this.b);
    setGravity(16);
    if (paramAttributeSet != null)
    {
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.WkCheckBox);
      if (paramContext != null)
      {
        this.c = paramContext.getBoolean(0, false);
        this.d = paramContext.getString(1);
        this.e = paramContext.getDimensionPixelSize(2, this.e);
        this.f = paramContext.getColor(3, this.f);
        paramContext.recycle();
      }
    }
    this.b.setText(this.d);
    this.b.setTextSize(0, this.e);
    this.b.setTextColor(this.f);
    c();
    super.setOnClickListener(this.i);
  }
  
  private void c()
  {
    if (this.c) {
      this.a.setImageResource(2130838344);
    }
    for (;;)
    {
      return;
      this.a.setImageResource(2130838343);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    if (this.c != paramBoolean)
    {
      this.c = paramBoolean;
      c();
    }
  }
  
  public final boolean a()
  {
    return this.c;
  }
  
  public final void b()
  {
    this.b.setSingleLine(true);
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.g = paramOnClickListener;
  }
  
  public static abstract interface a {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/widget/WkCheckBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */