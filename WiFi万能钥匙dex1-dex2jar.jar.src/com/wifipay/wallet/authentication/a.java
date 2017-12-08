package com.wifipay.wallet.authentication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.wifipay.R.string;
import com.wifipay.common.a.f;
import com.wifipay.framework.widget.wheel.b;

public class a
  extends b
{
  private int f;
  private int g;
  private String h;
  private String i;
  
  public a(Context paramContext, int paramInt1, int paramInt2, String paramString)
  {
    super(paramContext);
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramString;
  }
  
  public CharSequence a(int paramInt)
  {
    String str;
    if ((paramInt >= 0) && (paramInt < getItemsCount()))
    {
      paramInt = this.f + paramInt;
      if (this.h != null) {
        str = String.format(this.h, new Object[] { Integer.valueOf(paramInt) });
      }
    }
    for (;;)
    {
      return str;
      str = Integer.toString(paramInt);
      continue;
      str = null;
    }
  }
  
  public void a(String paramString)
  {
    this.i = paramString;
  }
  
  public View getItem(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if ((paramInt >= 0) && (paramInt < getItemsCount()))
    {
      localView = paramView;
      if (paramView == null) {
        localView = a(this.c, paramViewGroup);
      }
      TextView localTextView = a(localView, this.d);
      paramView = localView;
      if (localTextView != null)
      {
        paramViewGroup = a(paramInt);
        paramView = paramViewGroup;
        if (paramViewGroup == null) {
          paramView = "";
        }
        localTextView.setText(paramView + this.i);
        if ((paramInt == getItemsCount() - 1) && (f.a(R.string.wifipay_personal_year).equals(this.i))) {
          localTextView.setText(f.a(R.string.wifipay_personal_long_term));
        }
        if ((this.g == 1) && (f.a(R.string.wifipay_personal_month).equals(this.i))) {
          localTextView.setText("--");
        }
        if ((this.g == 1) && (f.a(R.string.wifipay_personal_day).equals(this.i))) {
          localTextView.setText("--");
        }
        paramView = localView;
        if (this.c == -1) {
          a(localTextView);
        }
      }
    }
    for (paramView = localView;; paramView = null) {
      return paramView;
    }
  }
  
  public int getItemsCount()
  {
    return this.g - this.f + 1;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/authentication/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */