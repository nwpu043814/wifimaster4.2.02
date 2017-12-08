package com.wifi.connect.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import bluefay.app.k;
import com.lantern.connect.R.drawable;
import com.lantern.connect.R.id;
import com.lantern.connect.R.layout;
import com.lantern.connect.R.string;

public final class a
  extends k
{
  private ScrollView a;
  private LinearLayout b;
  private View c;
  
  public a(Context paramContext)
  {
    super(paramContext);
    setTitle(R.string.act_autoconnect_dlg_title);
    paramContext = getLayoutInflater().inflate(R.layout.connect_auto_connect_dialog, null);
    a(paramContext);
    this.a = ((ScrollView)paramContext.findViewById(R.id.scroll_view));
    this.b = ((LinearLayout)this.a.findViewById(R.id.state_container));
    this.c = null;
  }
  
  public final void c(int paramInt)
  {
    String str = getContext().getString(paramInt);
    if (this.c != null)
    {
      if (((TextView)this.c.findViewById(R.id.tv_state)).getText().toString().equals(str)) {
        return;
      }
      localObject = this.c.findViewById(R.id.pb_state);
      if (((View)localObject).getVisibility() == 0)
      {
        ((View)localObject).setVisibility(8);
        ((ImageView)this.c.findViewById(R.id.iv_state)).setVisibility(0);
        ((ImageView)this.c.findViewById(R.id.iv_state)).setImageResource(R.drawable.auto_connect_state_success);
      }
    }
    View localView = getLayoutInflater().inflate(R.layout.connect_auto_connect_process_item, null);
    ImageView localImageView = (ImageView)localView.findViewById(R.id.iv_state);
    ProgressBar localProgressBar = (ProgressBar)localView.findViewById(R.id.pb_state);
    Object localObject = (TextView)localView.findViewById(R.id.tv_state);
    localImageView.setVisibility(8);
    localProgressBar.setVisibility(0);
    ((TextView)localObject).setText(str);
    this.b.addView(localView);
    this.c = localView;
    this.b.invalidate();
    this.b.post(new b(this));
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/widget/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */