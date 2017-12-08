package com.wifipay.framework.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.wifipay.R.color;
import com.wifipay.R.dimen;
import com.wifipay.R.drawable;
import com.wifipay.R.id;
import com.wifipay.framework.service.ITitleBarListener;

public class WPTitleBar
  extends WPRelativeLayout
  implements View.OnClickListener
{
  private ImageView a;
  private WPTextView b;
  private TextView c;
  private ITitleBarListener d;
  
  public WPTitleBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WPTitleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WPTitleBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  public WPTitleBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setBackgroundDrawable(new ColorDrawable(-16611856));
    Object localObject1 = new WPFrameLayout(paramContext);
    ((WPFrameLayout)localObject1).setId(R.id.wifipay_framework_title_bar_left);
    Object localObject2 = new RelativeLayout.LayoutParams(-2, -1);
    ((WPFrameLayout)localObject1).setBackgroundDrawable(null);
    ((RelativeLayout.LayoutParams)localObject2).addRule(9);
    addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    ((WPFrameLayout)localObject1).setOnClickListener(this);
    this.a = new WPImageView(paramContext);
    this.a.setBackgroundResource(R.drawable.wifipay_framework_title_bar_back_b);
    this.a.setImageResource(R.drawable.wifipay_framework_title_bar_back);
    this.a.setPadding(getResources().getDimensionPixelOffset(R.dimen.wifipay_padding_15), 0, getResources().getDimensionPixelOffset(R.dimen.wifipay_padding_15), 0);
    localObject2 = new FrameLayout.LayoutParams(-2, -1);
    ((FrameLayout.LayoutParams)localObject2).gravity = 17;
    ((WPFrameLayout)localObject1).addView(this.a, (ViewGroup.LayoutParams)localObject2);
    this.b = new WPTextView(paramContext);
    this.b.setId(R.id.wifipay_framework_title_bar_right);
    this.b.setBackgroundDrawable(null);
    this.b.setTextColor(getResources().getColor(R.color.wifipay_color_white));
    this.b.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.wifipay_font_size_54_px));
    this.b.setPadding(getResources().getDimensionPixelOffset(R.dimen.wifipay_padding_10), getResources().getDimensionPixelOffset(R.dimen.wifipay_padding_5), getResources().getDimensionPixelOffset(R.dimen.wifipay_padding_10), getResources().getDimensionPixelOffset(R.dimen.wifipay_padding_5));
    localObject1 = new RelativeLayout.LayoutParams(-2, -2);
    ((RelativeLayout.LayoutParams)localObject1).rightMargin = getResources().getDimensionPixelOffset(R.dimen.wifipay_padding_10);
    ((RelativeLayout.LayoutParams)localObject1).addRule(11);
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    addView(this.b, (ViewGroup.LayoutParams)localObject1);
    this.b.setOnClickListener(this);
    localObject2 = new View(paramContext);
    ((View)localObject2).setId(R.id.wifipay_framework_title_bar_divide);
    ((View)localObject2).setBackgroundDrawable(new ColorDrawable(-973051709));
    localObject1 = new RelativeLayout.LayoutParams(getResources().getDimensionPixelOffset(R.dimen.wifipay_framework_title_bar_divide_width), getResources().getDimensionPixelOffset(R.dimen.wifipay_framework_title_bar_divide_height));
    ((RelativeLayout.LayoutParams)localObject1).addRule(1, R.id.wifipay_framework_title_bar_left);
    ((RelativeLayout.LayoutParams)localObject1).addRule(15);
    addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
    this.c = new TextView(paramContext);
    this.c.setId(R.id.wifipay_framework_title_bar_content);
    this.c.setTextColor(getResources().getColor(R.color.wifipay_color_white));
    this.c.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.wifipay_font_size_54_px));
    this.c.setSingleLine(true);
    this.c.setGravity(19);
    paramContext = new RelativeLayout.LayoutParams(-2, -1);
    paramContext.leftMargin = getResources().getDimensionPixelOffset(R.dimen.wifipay_padding_15);
    paramContext.rightMargin = getResources().getDimensionPixelOffset(R.dimen.wifipay_padding_15);
    paramContext.addRule(1, R.id.wifipay_framework_title_bar_left);
    paramContext.addRule(0, R.id.wifipay_framework_title_bar_right);
    addView(this.c, paramContext);
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.setImageResource(R.drawable.wifipay_framework_title_bar_close);
    }
  }
  
  public CharSequence getRightText()
  {
    if ((this.b != null) && (this.b.getVisibility() == 0)) {}
    for (CharSequence localCharSequence = this.b.getText();; localCharSequence = null) {
      return localCharSequence;
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.d == null) {}
    for (;;)
    {
      return;
      int i = paramView.getId();
      if (i == R.id.wifipay_framework_title_bar_left) {
        this.d.onTitleClick(1);
      } else if (i == R.id.wifipay_framework_title_bar_right) {
        this.d.onTitleClick(2);
      }
    }
  }
  
  public void setContent(CharSequence paramCharSequence)
  {
    if (this.c != null) {
      this.c.setText(paramCharSequence);
    }
  }
  
  public void setLeftVisibility(int paramInt)
  {
    if (this.a != null) {
      this.a.setVisibility(paramInt);
    }
  }
  
  public void setRightBackgroundResource(int paramInt)
  {
    if (this.b != null) {
      this.b.setBackgroundResource(paramInt);
    }
  }
  
  public void setRightText(CharSequence paramCharSequence)
  {
    if (this.b != null) {
      this.b.setText(paramCharSequence);
    }
  }
  
  public void setRightVisibility(int paramInt)
  {
    if (this.b != null) {
      this.b.setVisibility(paramInt);
    }
  }
  
  public void setTitleClickListener(ITitleBarListener paramITitleBarListener)
  {
    this.d = paramITitleBarListener;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/WPTitleBar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */