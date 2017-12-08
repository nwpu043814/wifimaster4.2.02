package com.wifi.connect.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import bluefay.app.Fragment;
import com.bluefay.a.e;
import com.bluefay.b.h;
import com.lantern.connect.R.id;
import com.lantern.connect.R.layout;
import com.lantern.core.k;
import java.lang.reflect.Field;

public class BeginnerGuideFragment
  extends Fragment
{
  private View g;
  private ImageView h;
  private RectF i;
  private RectF j;
  private float k;
  
  private int a(float paramFloat)
  {
    if (this.k == 0.0F)
    {
      this.k = this.e.getResources().getDisplayMetrics().density;
      h.a("density:%s", new Object[] { Float.valueOf(this.k) });
    }
    return (int)(this.k * paramFloat + 0.5F);
  }
  
  private static boolean c()
  {
    if ("SD4930UR".equals(Build.MODEL)) {}
    for (boolean bool = false;; bool = k.b()) {
      return bool;
    }
  }
  
  private int d()
  {
    Activity localActivity = getActivity();
    int m;
    if (localActivity == null) {
      m = 0;
    }
    for (;;)
    {
      return m;
      Object localObject1 = new Rect();
      localActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject1);
      int n = ((Rect)localObject1).top;
      m = n;
      if (n == 0) {
        try
        {
          localObject1 = Class.forName("com.android.internal.R$dimen");
          Object localObject2 = ((Class)localObject1).newInstance();
          m = Integer.parseInt(((Class)localObject1).getField("status_bar_height").get(localObject2).toString());
          m = localActivity.getResources().getDimensionPixelSize(m);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          m = n;
        }
      }
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a_(a, 8);
    this.h = ((ImageView)this.g.findViewById(R.id.ivOneKeyQueryGuide));
    paramBundle = getActivity();
    if (paramBundle == null) {
      return;
    }
    int n;
    if (paramBundle.getIntent().getIntExtra("extra_step", 1) == 1)
    {
      n = a(123.0F);
      h.a("141dip = %s px", new Object[] { Integer.valueOf(n) });
      h.a("android_sdk:%s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
      if (!c()) {
        break label286;
      }
    }
    label286:
    for (int m = d() + n;; m = n)
    {
      h.a("targetY:%s", new Object[] { Integer.valueOf(m) });
      paramBundle = new LinearLayout.LayoutParams(-1, -2);
      paramBundle.topMargin = m;
      this.h.setLayoutParams(paramBundle);
      if (c()) {}
      for (m = d();; m = 0)
      {
        this.i = new RectF(a(100.0F), e.a(this.e, 20.0F) + n + m, a(270.0F), n + e.a(this.e, 60.0F) + m);
        this.j = new RectF(a(200.0F), a(370.0F) + m, a(295.0F), m + a(425.0F));
        this.g.setOnTouchListener(new b(this));
        break;
      }
      paramBundle.finish();
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.g == null) {
      this.g = paramLayoutInflater.inflate(R.layout.connect_userguide_onekeyquery, paramViewGroup, false);
    }
    return this.g;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/BeginnerGuideFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */