package com.lantern.e.a;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.lantern.wifiseccheck.LogUtils;
import com.lantern.wifiseccheck.vpn.utils.ResTool;
import com.lantern.wifiseccheck.vpn.utils.UIUtils;

public abstract class a
  extends Activity
  implements View.OnClickListener
{
  protected LinearLayout a;
  protected LinearLayout b;
  protected ImageView c;
  
  protected void a() {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == ResTool.getViewId("act_title", this))
    {
      LogUtils.d("BaseAct", "act_title onClick");
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    getWindow().requestFeature(1);
    this.b = new LinearLayout(this);
    paramBundle = new LinearLayout.LayoutParams(-1, UIUtils.getStatusBarHeight(this), 0.0F);
    this.b.setLayoutParams(paramBundle);
    this.b.setBackgroundColor(getResources().getColor(ResTool.getColorId("splsh_bg", this)));
    paramBundle = getResources();
    Configuration localConfiguration = new Configuration();
    localConfiguration.setToDefaults();
    paramBundle.updateConfiguration(localConfiguration, paramBundle.getDisplayMetrics());
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onStart()
  {
    super.onStart();
    this.a = ((LinearLayout)findViewById(ResTool.getViewId("layout_title", this)));
    this.c = ((ImageView)findViewById(ResTool.getViewId("act_title", this)));
    if (this.c != null) {
      this.c.setOnClickListener(this);
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      getWindow().addFlags(67108864);
      if (this.a != null)
      {
        this.a.removeView(this.b);
        this.a.addView(this.b, 0);
      }
    }
    a();
  }
  
  protected void onStop()
  {
    super.onStop();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/e/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */