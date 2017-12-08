package com.wifi.connect.plugin.a;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import bluefay.app.k;
import com.lantern.core.imageloader.WkImageView;
import com.wifi.connect.plugin.magickey.R.drawable;
import com.wifi.connect.plugin.magickey.R.id;
import com.wifi.connect.plugin.magickey.R.layout;
import com.wifi.connect.plugin.magickey.R.style;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends k
{
  private View a;
  private ListView b;
  private ProgressBar c;
  private ImageView d;
  private Context e;
  private BaseAdapter f;
  private WkImageView g;
  private List<com.wifi.connect.plugin.magickey.b.c> h = new ArrayList();
  private TextView i;
  private TextView j;
  
  public c(Context paramContext)
  {
    super(paramContext, R.style.PLProgressDialog);
    this.e = paramContext;
    this.a = getLayoutInflater().inflate(R.layout.connect_auto_connect_new_dialog, null);
    a(this.a);
    this.b = ((ListView)this.a.findViewById(R.id.dg_container));
    this.c = ((ProgressBar)this.a.findViewById(R.id.dg_progressbar));
    this.d = ((ImageView)this.a.findViewById(R.id.dg_star_two_iv));
    this.g = ((WkImageView)this.a.findViewById(R.id.dg_default_bg));
    this.i = ((TextView)this.a.findViewById(R.id.dg_container_titile));
    this.j = ((TextView)this.a.findViewById(R.id.dg_ssid));
    this.f = new a((byte)0);
    ((AnimationDrawable)this.d.getBackground()).start();
    this.b.setAdapter(this.f);
  }
  
  public final void a(String paramString)
  {
    this.j.setText(paramString);
  }
  
  public final void a(List<com.wifi.connect.plugin.magickey.b.c> paramList)
  {
    this.h = paramList;
    this.f.notifyDataSetChanged();
  }
  
  public final void b(String paramString)
  {
    this.g.a(paramString);
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
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      return c.a(c.this).size();
    }
    
    public final Object getItem(int paramInt)
    {
      return c.a(c.this).get(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramViewGroup = (com.wifi.connect.plugin.magickey.b.c)c.a(c.this).get(paramInt);
      if (paramViewGroup == null) {
        paramViewGroup = new com.wifi.connect.plugin.magickey.b.c();
      }
      for (;;)
      {
        View localView;
        Object localObject;
        int i;
        if (paramView == null)
        {
          localView = LayoutInflater.from(c.b(c.this)).inflate(R.layout.connect_auto_connect_list_item, null);
          paramView = new a((byte)0);
          a.a(paramView, (TextView)localView.findViewById(R.id.tv_state));
          a.a(paramView, (ImageView)localView.findViewById(R.id.iv_state));
          a.a(paramView, (ProgressBar)localView.findViewById(R.id.pb_state));
          localView.setTag(paramView);
          localObject = paramView;
          a.a((a)localObject).setText(paramViewGroup.a());
          a.b((a)localObject).setVisibility(8);
          a.c((a)localObject).setVisibility(0);
          boolean bool = paramViewGroup.b();
          i = paramViewGroup.c();
          if (bool) {
            break label234;
          }
          if (c.c(c.this).getCount() == paramInt + 1) {
            break label212;
          }
          a.c((a)localObject).setBackgroundResource(R.drawable.connect_popup_dialog_complete);
        }
        for (;;)
        {
          return localView;
          localObject = (a)paramView.getTag();
          localView = paramView;
          break;
          label212:
          a.b((a)localObject).setVisibility(0);
          a.c((a)localObject).setVisibility(8);
          continue;
          label234:
          if (i == 100) {
            a.c((a)localObject).setBackgroundResource(R.drawable.connect_popup_dialog_complete);
          } else {
            a.c((a)localObject).setBackgroundResource(R.drawable.connect_popup_dialog_faile);
          }
        }
      }
    }
    
    private final class a
    {
      private TextView b;
      private ImageView c;
      private ProgressBar d;
      
      private a() {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/plugin/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */