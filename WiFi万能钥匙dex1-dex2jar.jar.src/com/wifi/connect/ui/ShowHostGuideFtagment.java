package com.wifi.connect.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
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
import com.bluefay.b.h;
import com.lantern.connect.R.id;
import com.lantern.connect.R.layout;
import com.lantern.core.k;
import java.lang.reflect.Field;

public class ShowHostGuideFtagment
  extends Fragment
{
  private View g;
  private ImageView h;
  private float i;
  
  private int c()
  {
    Activity localActivity = getActivity();
    int j;
    if (localActivity == null) {
      j = 0;
    }
    for (;;)
    {
      return j;
      Object localObject = new Rect();
      localActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
      int k = ((Rect)localObject).top;
      j = k;
      if (k == 0) {
        try
        {
          Class localClass = Class.forName("com.android.internal.R$dimen");
          localObject = localClass.newInstance();
          j = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
          j = localActivity.getResources().getDimensionPixelSize(j);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          j = k;
        }
      }
    }
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    a_(a, 8);
    this.h = ((ImageView)this.g.findViewById(R.id.ivOneKeyQueryGuide));
    if (this.i == 0.0F)
    {
      this.i = this.e.getResources().getDisplayMetrics().density;
      h.a("density:%s", new Object[] { Float.valueOf(this.i) });
    }
    int k = (int)(4.0F * this.i + 0.5F);
    h.a("141dip = %s px", new Object[] { Integer.valueOf(k) });
    h.a("android_sdk:%s", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT) });
    h.a("buildmodel" + Build.MODEL, new Object[0]);
    if ("SD4930UR".equals(Build.MODEL)) {}
    for (boolean bool = false;; bool = k.b())
    {
      int j = k;
      if (bool) {
        j = k + c();
      }
      h.a("targetY:%s", new Object[] { Integer.valueOf(j) });
      paramBundle = new LinearLayout.LayoutParams(-1, -2);
      paramBundle.topMargin = j;
      paramBundle.rightMargin = 0;
      this.h.setLayoutParams(paramBundle);
      return;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (this.g == null) {
      this.g = paramLayoutInflater.inflate(R.layout.connect_show_host_guide, paramViewGroup, false);
    }
    return this.g;
  }
  
  public void onResume()
  {
    super.onResume();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/ui/ShowHostGuideFtagment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */