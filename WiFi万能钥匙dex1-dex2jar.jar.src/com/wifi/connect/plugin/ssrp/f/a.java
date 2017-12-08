package com.wifi.connect.plugin.ssrp.f;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import bluefay.app.k;
import com.lantern.core.imageloader.WkImageView;
import com.wifi.connect.plugin.ssrp.R.drawable;
import com.wifi.connect.plugin.ssrp.R.id;
import com.wifi.connect.plugin.ssrp.R.layout;
import com.wifi.connect.plugin.ssrp.R.style;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends k
{
  private View a;
  private LinearLayout b;
  private ProgressBar c;
  private ImageView d;
  private Context e;
  private WkImageView f;
  private List<com.wifi.connect.plugin.ssrp.c.a> g = new ArrayList();
  private TextView h;
  private TextView i;
  private View j;
  private a k = null;
  private ScrollView l;
  
  public a(Context paramContext)
  {
    super(paramContext, R.style.PLProgressDialog);
    this.e = paramContext;
    this.a = getLayoutInflater().inflate(R.layout.ssrp_connect_dialog, null);
    a(this.a);
    this.b = ((LinearLayout)this.a.findViewById(R.id.dg_container));
    this.c = ((ProgressBar)this.a.findViewById(R.id.dg_progressbar));
    this.d = ((ImageView)this.a.findViewById(R.id.dg_star_two_iv));
    this.f = ((WkImageView)this.a.findViewById(R.id.dg_default_bg));
    this.h = ((TextView)this.a.findViewById(R.id.dg_container_titile));
    this.l = ((ScrollView)this.a.findViewById(R.id.scroll_view));
    this.i = ((TextView)this.a.findViewById(R.id.dg_ssid));
    ((AnimationDrawable)this.d.getBackground()).start();
    if (this.b != null) {
      this.b.removeAllViews();
    }
  }
  
  public final void a(com.wifi.connect.plugin.ssrp.c.a parama)
  {
    Object localObject = parama;
    if (parama == null) {
      localObject = new com.wifi.connect.plugin.ssrp.c.a();
    }
    boolean bool = ((com.wifi.connect.plugin.ssrp.c.a)localObject).b();
    int m = ((com.wifi.connect.plugin.ssrp.c.a)localObject).c();
    if ((this.j != null) && (this.k != null))
    {
      a.a(this.k).setVisibility(8);
      a.b(this.k).setVisibility(0);
    }
    this.j = LayoutInflater.from(this.e).inflate(R.layout.ssrp_connect_auto_connect_list_item, null);
    this.k = new a((byte)0);
    a.a(this.k, (TextView)this.j.findViewById(R.id.tv_state));
    a.a(this.k, (ImageView)this.j.findViewById(R.id.iv_state));
    a.a(this.k, (ProgressBar)this.j.findViewById(R.id.pb_state));
    this.j.setTag(this.k);
    a.c(this.k).setText(((com.wifi.connect.plugin.ssrp.c.a)localObject).a());
    a.a(this.k).setVisibility(8);
    a.b(this.k).setVisibility(0);
    if (!bool)
    {
      a.a(this.k).setVisibility(0);
      a.b(this.k).setVisibility(8);
    }
    for (;;)
    {
      parama = this.j;
      if (this.b != null)
      {
        localObject = (ViewGroup)parama.getParent();
        if (localObject != null) {
          ((ViewGroup)localObject).removeAllViews();
        }
        this.b.addView(parama);
      }
      this.b.invalidate();
      this.b.post(new b(this));
      return;
      if (m == 100) {
        a.b(this.k).setBackgroundResource(R.drawable.ssrp_connect_popup_dialog_complete);
      } else {
        a.b(this.k).setBackgroundResource(R.drawable.ssrp_connect_popup_dialog_faile);
      }
    }
  }
  
  public final void a(String paramString)
  {
    this.f.a(paramString);
  }
  
  public final void c(int paramInt)
  {
    if (this.c != null) {
      this.c.setProgress(paramInt);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  private final class a
  {
    private TextView b;
    private ImageView c;
    private ProgressBar d;
    
    private a() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/ssrp/f/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */