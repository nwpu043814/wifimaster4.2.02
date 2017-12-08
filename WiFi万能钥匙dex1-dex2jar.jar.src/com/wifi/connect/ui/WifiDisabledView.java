package com.wifi.connect.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lantern.connect.R.drawable;
import com.lantern.connect.R.id;
import com.lantern.connect.R.string;

public class WifiDisabledView
  extends RelativeLayout
{
  private int a;
  private ImageView b;
  private TextView c;
  private a d;
  
  public WifiDisabledView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WifiDisabledView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WifiDisabledView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void a(int paramInt)
  {
    this.a = paramInt;
    if (this.a == 4) {
      setVisibility(4);
    }
    for (;;)
    {
      return;
      setVisibility(0);
      if (this.a == 1)
      {
        this.b.setImageResource(R.drawable.connect_hotspot_enabled);
        this.c.setEnabled(true);
        this.c.setText(R.string.disable_hotspot);
      }
      else if (this.a == 3)
      {
        AnimationDrawable localAnimationDrawable = (AnimationDrawable)getResources().getDrawable(R.drawable.enable_wifi_animation);
        this.b.setImageDrawable(localAnimationDrawable);
        localAnimationDrawable.start();
        this.c.setEnabled(false);
        this.c.setText(R.string.enabling_wifi);
      }
      else
      {
        this.b.setImageResource(R.drawable.wifi_disabled);
        this.c.setEnabled(true);
        this.c.setText(R.string.enable_wifi);
      }
    }
  }
  
  public final void a(a parama)
  {
    this.d = parama;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.b = ((ImageView)findViewById(R.id.wifi_disabled));
    this.c = ((TextView)findViewById(R.id.enable_wifi));
    this.c.setOnClickListener(new as(this));
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/WifiDisabledView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */