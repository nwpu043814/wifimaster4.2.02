package com.wifi.connect.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lantern.connect.R.drawable;
import com.lantern.connect.R.id;
import com.lantern.connect.R.layout;
import com.lantern.connect.R.string;
import com.lantern.widget.StarSmallViewGroup;
import com.wifi.connect.widget.ProgressTextView;

public class WifiListHeaderView
  extends LinearLayout
  implements View.OnClickListener
{
  private int a = -1;
  private ProgressTextView b;
  private TextView c;
  private TextView d;
  private ImageView e;
  private a f;
  private FrameLayout g;
  private HorizontalScrollView h;
  private StarSmallViewGroup i;
  private TextView j;
  private ImageView k;
  
  public WifiListHeaderView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WifiListHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WifiListHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(R.layout.connect_list_header, this);
    this.b = ((ProgressTextView)paramContext.findViewById(R.id.status));
    this.c = ((TextView)paramContext.findViewById(R.id.location));
    this.d = ((TextView)paramContext.findViewById(R.id.one_key_query));
    this.e = ((ImageView)paramContext.findViewById(R.id.auth_icon));
    this.d.setOnClickListener(this);
    findViewById(R.id.wifi_member).setOnClickListener(this);
    this.g = ((FrameLayout)paramContext.findViewById(R.id.small_scrollview));
    this.k = ((ImageView)paramContext.findViewById(R.id.shop_entrance_arrow));
    this.h = ((HorizontalScrollView)paramContext.findViewById(R.id.location_scrollview));
    this.i = ((StarSmallViewGroup)paramContext.findViewById(R.id.small_stars));
    this.j = ((TextView)paramContext.findViewById(R.id.no_socre));
    this.g.setOnClickListener(this);
    this.b.setOnClickListener(this);
    this.k.setOnClickListener(this);
  }
  
  private String b(int paramInt, Object... paramVarArgs)
  {
    return String.format(getResources().getString(paramInt), paramVarArgs);
  }
  
  public final void a(int paramInt)
  {
    this.g.setVisibility(8);
    this.k.setVisibility(8);
    this.h.setVisibility(0);
    this.c.setText(paramInt);
  }
  
  public final void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 6)
    {
      this.g.setVisibility(8);
      this.h.setVisibility(0);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.a = paramInt;
      return;
      this.b.a(b(R.string.wifi_disabled, paramVarArgs));
      this.b.b();
      continue;
      this.b.a(b(R.string.wifi_enabling, paramVarArgs));
      this.b.b();
      continue;
      this.b.a(b(R.string.wifi_enabled_scaning, paramVarArgs));
      this.b.b();
      continue;
      this.b.a(b(R.string.wifi_not_found, new Object[0]));
      this.b.b();
      continue;
      this.b.a(b(R.string.wifi_found, paramVarArgs));
      this.b.b();
      continue;
      this.b.a(b(R.string.key_querying, paramVarArgs));
      if (this.a != paramInt)
      {
        this.k.setVisibility(8);
        this.b.a();
        continue;
        this.b.b();
        continue;
        this.b.a(b(R.string.wifi_connecting, paramVarArgs));
        if (this.a != paramInt)
        {
          this.b.a();
          continue;
          this.b.a(b(R.string.wifi_connected, paramVarArgs));
          this.b.b();
        }
      }
    }
  }
  
  public final void a(a parama)
  {
    this.f = parama;
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.g.setVisibility(8);
    this.k.setVisibility(8);
    this.h.setVisibility(0);
    this.c.setText(paramCharSequence);
  }
  
  public final void a(String paramString)
  {
    this.g.setVisibility(0);
    this.i.setVisibility(0);
    this.k.setVisibility(0);
    this.h.setVisibility(8);
    this.j.setVisibility(8);
    this.i.a(paramString);
  }
  
  public final boolean a()
  {
    if (this.a == 3) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final void b(int paramInt)
  {
    if (this.e != null) {
      this.e.setVisibility(paramInt);
    }
  }
  
  public final boolean b()
  {
    if (this.a == 5) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final void c()
  {
    this.g.setVisibility(0);
    this.k.setVisibility(0);
    this.h.setVisibility(8);
    this.i.setVisibility(8);
    this.j.setVisibility(0);
  }
  
  public final void d()
  {
    if (this.d != null)
    {
      this.d.setEnabled(false);
      this.d.setClickable(false);
      this.d.setBackgroundResource(R.drawable.one_key_query_background_normal);
    }
  }
  
  public final void e()
  {
    if (this.d != null)
    {
      this.d.setEnabled(true);
      this.d.setClickable(true);
      this.d.setBackgroundResource(R.drawable.one_key_query_background);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.one_key_query) {
      if (this.f != null) {
        this.f.a();
      }
    }
    for (;;)
    {
      return;
      if (paramView.getId() == R.id.wifi_member)
      {
        if (this.f != null) {
          this.f.b();
        }
      }
      else if (paramView.getId() == R.id.small_scrollview)
      {
        if (this.f != null) {
          this.f.c();
        }
      }
      else if (paramView.getId() == R.id.status)
      {
        if ((this.f != null) && (this.g.getVisibility() == 0)) {
          this.f.c();
        }
      }
      else if ((paramView.getId() == R.id.shop_entrance_arrow) && (this.f != null) && (this.g.getVisibility() == 0)) {
        this.f.c();
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
    
    public abstract void c();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/WifiListHeaderView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */