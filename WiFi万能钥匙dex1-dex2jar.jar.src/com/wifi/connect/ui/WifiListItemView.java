package com.wifi.connect.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bluefay.b.h;
import com.lantern.connect.R.dimen;
import com.lantern.connect.R.drawable;
import com.lantern.connect.R.id;
import com.lantern.core.model.WkAccessPoint;
import com.wifi.connect.a.a;
import com.wifi.connect.a.d;
import com.wifi.connect.a.g;
import com.wifi.connect.model.AccessPoint;
import com.wifi.connect.model.AccessPointAlias;

public class WifiListItemView
  extends LinearLayout
{
  private int a;
  private AccessPoint b;
  private ImageView c;
  private TextView d;
  private TextView e;
  private ImageView f;
  private ImageView g;
  private FrameLayout h;
  private ImageView i;
  private Drawable j;
  private Drawable k;
  private Drawable l;
  private Drawable m;
  private Drawable n;
  
  public WifiListItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public WifiListItemView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WifiListItemView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static void b() {}
  
  public final AccessPoint a()
  {
    return this.b;
  }
  
  public final void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void a(AccessPoint paramAccessPoint, WkAccessPoint paramWkAccessPoint)
  {
    this.b = paramAccessPoint;
    Object localObject1 = { R.drawable.connect_signal_level_0, R.drawable.connect_signal_level_1, R.drawable.connect_signal_level_2, R.drawable.connect_signal_level_3 };
    int i7 = R.drawable.connect_locked_signal_level_0;
    int i6 = R.drawable.connect_locked_signal_level_1;
    int i5 = R.drawable.connect_locked_signal_level_2;
    int i4 = R.drawable.connect_locked_signal_level_3;
    int i2;
    if (paramAccessPoint.c == 0)
    {
      i2 = 0;
      int i3 = paramAccessPoint.e();
      int i1 = i3;
      if (i3 > 3) {
        i1 = 3;
      }
      i3 = i1;
      if (i1 < 0) {
        i3 = 0;
      }
      this.c.setImageResource(new int[][] { localObject1, { i7, i6, i5, i4 } }[i2][i3]);
      localObject2 = getLayoutParams();
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new AbsListView.LayoutParams(-1, -2);
        setLayoutParams((ViewGroup.LayoutParams)localObject1);
        h.a("crate a new LayoutParams for list item", new Object[0]);
      }
      this.i.setVisibility(8);
      this.h.setVisibility(8);
      if (!com.lantern.core.f.a().a("shoplist_imageshow", false)) {
        break label854;
      }
    }
    label398:
    label440:
    label533:
    label695:
    label725:
    label854:
    for (Object localObject2 = a.a().a(paramAccessPoint);; localObject2 = null)
    {
      if ((localObject2 != null) && (a.a().c(((AccessPointAlias)localObject2).a(), ((WkAccessPoint)localObject2).c)))
      {
        this.h.setVisibility(0);
        this.g.setVisibility(0);
        this.f.setVisibility(8);
        if (!TextUtils.isEmpty(((AccessPointAlias)localObject2).i)) {
          com.lantern.core.imageloader.c.a(getContext(), ((AccessPointAlias)localObject2).l, this.g, null, R.drawable.shop_avatar_default);
        }
      }
      a locala = a.a();
      if ((locala.b(paramAccessPoint)) && (!TextUtils.isEmpty(locala.a(paramAccessPoint).e)) && (!paramAccessPoint.a.equals(locala.a(paramAccessPoint).e)))
      {
        this.d.setText(locala.a(paramAccessPoint).e);
        this.e.setText(paramAccessPoint.a);
        this.e.setVisibility(0);
        ((ViewGroup.LayoutParams)localObject1).height = getResources().getDimensionPixelSize(R.dimen.wifi_list_item_height_shop);
        this.f.setImageResource(R.drawable.wifi_status_keyed);
        this.f.setVisibility(0);
        if (!com.wifi.connect.a.f.a().b(paramAccessPoint)) {
          break label533;
        }
        this.d.setCompoundDrawables(null, null, this.k, null);
        if (!paramAccessPoint.h()) {
          break label725;
        }
        if ((localObject2 == null) || (!a.a().c(((AccessPointAlias)localObject2).a(), ((WkAccessPoint)localObject2).c))) {
          break label695;
        }
        this.i.setVisibility(0);
        this.f.setVisibility(8);
      }
      for (;;)
      {
        return;
        i2 = 1;
        break;
        this.d.setText(paramAccessPoint.a);
        this.e.setVisibility(8);
        ((ViewGroup.LayoutParams)localObject1).height = getResources().getDimensionPixelSize(R.dimen.wifi_list_item_height);
        break label398;
        if (g.a().a(paramAccessPoint))
        {
          this.d.setCompoundDrawables(null, null, this.l, null);
          break label440;
        }
        if (d.a().a(paramAccessPoint))
        {
          this.d.setCompoundDrawables(null, null, this.j, null);
          break label440;
        }
        if (com.wifi.connect.a.e.b().a(paramAccessPoint))
        {
          this.d.setCompoundDrawables(null, null, this.m, null);
          break label440;
        }
        if (com.wifi.connect.a.e.b().b(paramAccessPoint))
        {
          if ((com.wifi.connect.a.e.b().c(paramAccessPoint) > 0) && (paramAccessPoint.e() >= 2))
          {
            this.d.setCompoundDrawables(null, null, this.n, null);
            break label440;
          }
          this.d.setCompoundDrawables(null, null, null, null);
          break label440;
        }
        this.f.setVisibility(4);
        this.d.setCompoundDrawables(null, null, null, null);
        break label440;
        this.f.setImageResource(R.drawable.wifi_status_connected);
        this.f.setVisibility(0);
        this.i.setVisibility(8);
        continue;
        if ((paramAccessPoint.i()) || ((paramWkAccessPoint != null) && (paramAccessPoint.a.equals(paramWkAccessPoint.a)) && (paramAccessPoint.c == paramWkAccessPoint.c)))
        {
          this.i.setVisibility(8);
          this.h.setVisibility(8);
          this.f.setImageResource(R.drawable.connect_progress_rotate_new);
          if (com.bluefay.a.c.a())
          {
            paramAccessPoint = this.f.getDrawable();
            com.bluefay.a.e.a(paramAccessPoint, "setFramesCount", new Object[] { Integer.valueOf(36) });
            com.bluefay.a.e.a(paramAccessPoint, "setFramesDuration", new Object[] { Integer.valueOf(20) });
          }
          this.f.setVisibility(0);
        }
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.c = ((ImageView)findViewById(R.id.signal_level));
    this.d = ((TextView)findViewById(R.id.title));
    this.e = ((TextView)findViewById(R.id.sub_title));
    this.h = ((FrameLayout)findViewById(R.id.shop_layout));
    this.g = ((ImageView)findViewById(R.id.shop_image_avatar));
    this.i = ((ImageView)findViewById(R.id.shop_image_state));
    this.f = ((ImageView)findViewById(R.id.status));
    this.k = getResources().getDrawable(R.drawable.connect_ap_type_plugin);
    this.k.setBounds(0, 0, this.k.getMinimumWidth(), this.k.getMinimumHeight());
    this.l = getResources().getDrawable(R.drawable.connect_ap_type_ssrp);
    this.l.setBounds(0, 0, this.l.getMinimumWidth(), this.l.getMinimumHeight());
    this.m = getResources().getDrawable(R.drawable.connect_ap_type_phoneap);
    this.m.setBounds(0, 0, this.m.getMinimumWidth(), this.m.getMinimumHeight());
    this.n = getResources().getDrawable(R.drawable.connect_ap_type_recommend);
    this.n.setBounds(0, 0, this.n.getMinimumWidth(), this.n.getMinimumHeight());
    this.j = getResources().getDrawable(R.drawable.connect_ap_type_http_auth);
    this.j.setBounds(0, 0, this.j.getMinimumWidth(), this.j.getMinimumHeight());
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/WifiListItemView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */