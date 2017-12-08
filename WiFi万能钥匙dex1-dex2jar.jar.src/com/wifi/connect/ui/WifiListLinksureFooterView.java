package com.wifi.connect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.lantern.connect.R.layout;

public class WifiListLinksureFooterView
  extends LinearLayout
{
  private View a;
  
  public WifiListLinksureFooterView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WifiListLinksureFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WifiListLinksureFooterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(R.layout.connect_list_linksure_footer, this);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/WifiListLinksureFooterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */