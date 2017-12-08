package com.wifipay.framework.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.wifipay.R.color;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.styleable;
import com.wifipay.common.a.g;

public class WPTwoTextView
  extends WPLinearLayout
{
  private TextView a;
  private TextView b;
  
  public WPTwoTextView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WPTwoTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }
  
  public WPTwoTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a(Context paramContext)
  {
    setOrientation(1);
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.wifipay_framework_two_text_view, this, true);
    this.a = ((TextView)paramContext.findViewById(R.id.wifipay_bar_title));
    this.b = ((TextView)paramContext.findViewById(R.id.wifipay_bar_content));
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    a(paramContext);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.WPTwoTextView);
    this.a.setText(paramAttributeSet.getText(R.styleable.WPTwoTextView_wifipay_barTitle));
    this.a.setGravity(paramAttributeSet.getInt(R.styleable.WPTwoTextView_wifipay_barTitle_gravity, 8388611));
    paramContext = paramAttributeSet.getText(R.styleable.WPTwoTextView_wifipay_barContent);
    if (g.a(paramContext))
    {
      this.b.setHint(paramAttributeSet.getText(R.styleable.WPTwoTextView_android_hint));
      this.b.setHintTextColor(getResources().getColor(R.color.wifipay_color_b7b7b7));
    }
    for (;;)
    {
      this.b.setTextColor(paramAttributeSet.getColor(R.styleable.WPTwoTextView_wifipay_contentColor, -16777216));
      this.b.setGravity(paramAttributeSet.getInt(R.styleable.WPTwoTextView_wifipay_barContent_gravity, 8388613));
      paramAttributeSet.recycle();
      return;
      this.b.setText(paramContext);
    }
  }
  
  public String getText()
  {
    return this.b.getText().toString();
  }
  
  public TextView getTextView()
  {
    return this.b;
  }
  
  public void setBarTitle(CharSequence paramCharSequence)
  {
    if (this.a != null) {
      this.a.setText(paramCharSequence);
    }
  }
  
  public void setHint(CharSequence paramCharSequence)
  {
    this.b.setHint(paramCharSequence);
  }
  
  public void setText(int paramInt)
  {
    this.b.setText(paramInt);
  }
  
  public void setText(CharSequence paramCharSequence)
  {
    this.b.setText(paramCharSequence);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/WPTwoTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */