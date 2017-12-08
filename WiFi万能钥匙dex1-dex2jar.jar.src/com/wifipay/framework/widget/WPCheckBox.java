package com.wifipay.framework.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.wifipay.R.dimen;
import com.wifipay.R.drawable;
import com.wifipay.R.string;
import com.wifipay.R.style;

public class WPCheckBox
  extends WPLinearLayout
{
  private boolean a;
  private ImageView b;
  private int c = R.drawable.wifipay_framework_square_check_on;
  private int d = R.drawable.wifipay_framework_square_check_off;
  private OnCheckListener e;
  private final View.OnClickListener f = new d(this);
  
  public WPCheckBox(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public WPCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public WPCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    setOrientation(0);
    setGravity(16);
    setOnClickListener(this.f);
    this.b = new ImageView(getContext());
    this.b.setBackgroundResource(this.c);
    this.a = true;
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    addView(this.b, localLayoutParams);
    TextView localTextView = new TextView(getContext());
    localTextView.setGravity(16);
    localTextView.setText(R.string.wifipay_common_agree);
    localTextView.setTextAppearance(getContext(), R.style.wifipay_font_333333_36);
    localTextView.setPadding(getResources().getDimensionPixelOffset(R.dimen.wifipay_padding_8), 0, 0, 0);
    addView(localTextView, localLayoutParams);
  }
  
  public boolean a()
  {
    return this.a;
  }
  
  public void setListener(OnCheckListener paramOnCheckListener)
  {
    this.e = paramOnCheckListener;
  }
  
  public static abstract interface OnCheckListener
  {
    public abstract void onChecked(boolean paramBoolean);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/WPCheckBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */