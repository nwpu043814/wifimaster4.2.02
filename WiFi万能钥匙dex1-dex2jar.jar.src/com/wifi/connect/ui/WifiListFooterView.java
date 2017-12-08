package com.wifi.connect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.lantern.connect.R.id;
import com.lantern.connect.R.layout;

public class WifiListFooterView
  extends LinearLayout
  implements View.OnClickListener
{
  private View a;
  private a b;
  
  public WifiListFooterView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WifiListFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WifiListFooterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(R.layout.connect_list_footer, this);
    this.a.findViewById(R.id.check_permission).setOnClickListener(this);
    this.a.findViewById(R.id.frag_wifilist_checksetting).setOnClickListener(this);
    this.a.findViewById(R.id.frag_wifilist_refreshlist).setOnClickListener(this);
  }
  
  public final void a(a parama)
  {
    this.b = parama;
  }
  
  public void onClick(View paramView)
  {
    if (this.b != null)
    {
      if (paramView.getId() != R.id.frag_wifilist_checksetting) {
        break label27;
      }
      this.b.onCheckSettingEvent();
    }
    for (;;)
    {
      return;
      label27:
      if (paramView.getId() == R.id.frag_wifilist_refreshlist) {
        this.b.onRefreshListEvent(this.a);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void onCheckSettingEvent();
    
    public abstract void onEvent();
    
    public abstract void onRefreshListEvent(View paramView);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/WifiListFooterView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */