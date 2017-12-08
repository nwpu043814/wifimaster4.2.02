package com.wifi.connect.e;

import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewSwitcher.ViewFactory;

final class d
  implements ViewSwitcher.ViewFactory
{
  d(c paramc) {}
  
  public final View makeView()
  {
    TextView localTextView = new TextView(c.a(this.a));
    localTextView.setGravity(19);
    localTextView.setTextColor(Color.parseColor("#0285f0"));
    localTextView.setSingleLine(true);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    return localTextView;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/e/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */