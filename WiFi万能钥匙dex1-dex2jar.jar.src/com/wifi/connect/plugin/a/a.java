package com.wifi.connect.plugin.a;

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
import com.lantern.core.imageloader.c;
import com.wifi.connect.plugin.magickey.R.drawable;
import com.wifi.connect.plugin.magickey.R.id;
import com.wifi.connect.plugin.magickey.R.layout;
import com.wifi.connect.plugin.magickey.R.style;

public final class a
  extends k
{
  private ScrollView a;
  private LinearLayout b;
  private TextView c;
  private TextView d;
  private ImageView e;
  private ProgressBar f;
  private View g;
  private Context h;
  
  public a(Context paramContext)
  {
    super(paramContext, R.style.PLProgressDialog);
    this.h = paramContext;
    paramContext = getLayoutInflater().inflate(R.layout.connect_auto_connect_dialog_shop, null);
    a(paramContext);
    this.c = ((TextView)paramContext.findViewById(R.id.shop_ssid_alias));
    this.d = ((TextView)paramContext.findViewById(R.id.shop_ssid));
    this.e = ((ImageView)paramContext.findViewById(R.id.shop_avatar));
    this.f = ((ProgressBar)paramContext.findViewById(R.id.dg_progressbar));
    this.a = ((ScrollView)paramContext.findViewById(R.id.scroll_view));
    this.a.setVerticalScrollBarEnabled(true);
    this.b = ((LinearLayout)this.a.findViewById(R.id.state_container));
    this.g = null;
  }
  
  public final void a(String paramString)
  {
    if (this.g != null) {
      if (!((TextView)this.g.findViewById(R.id.tv_state)).getText().toString().equals(paramString)) {}
    }
    for (;;)
    {
      return;
      View localView = this.g.findViewById(R.id.pb_state);
      if (localView.getVisibility() == 0)
      {
        localView.setVisibility(8);
        ((ImageView)this.g.findViewById(R.id.iv_state)).setVisibility(0);
        ((ImageView)this.g.findViewById(R.id.iv_state)).setImageResource(R.drawable.connect_popup_dialog_complete);
      }
      localView = getLayoutInflater().inflate(R.layout.connect_auto_connect_process_item_shop, null);
      ImageView localImageView = (ImageView)localView.findViewById(R.id.iv_state);
      ProgressBar localProgressBar = (ProgressBar)localView.findViewById(R.id.pb_state);
      TextView localTextView = (TextView)localView.findViewById(R.id.tv_state);
      localImageView.setVisibility(8);
      localProgressBar.setVisibility(0);
      localTextView.setText(paramString);
      this.b.addView(localView);
      this.g = localView;
      this.b.invalidate();
      this.b.post(new b(this));
    }
  }
  
  public final void a(String paramString1, String paramString2, String paramString3)
  {
    this.c.setText(paramString2);
    this.d.setText(paramString1);
    c.a(this.h, paramString3, this.e, new com.lantern.core.imageloader.a(), R.drawable.connect_auto_connect_shop_avatar_default);
  }
  
  public final void c(int paramInt)
  {
    if (this.f != null) {
      this.f.setProgress(paramInt);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */