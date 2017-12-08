package com.linksure.apservice.ui.apslist;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageButton;
import bluefay.support.annotation.Nullable;
import com.lantern.core.c;
import com.linksure.apservice.ui.apslist.list.ApsListFragment;
import com.linksure.apservice.ui.apslist.loading.LoadingFragment;
import com.linksure.apservice.ui.apslist.recommend.RecommendFragment;
import com.linksure.apservice.ui.category.CategoryActivity;
import com.qihoo.util.StubApp1053578832;
import java.io.PrintStream;

public class ApsListActivity
  extends com.linksure.apservice.ui.common.a
{
  private static final int[] h = { 128500 };
  private String f = "";
  private ImageButton g;
  private com.bluefay.d.b i = new a(this, h);
  
  static
  {
    StubApp1053578832.interface11(73);
  }
  
  public final void a(boolean paramBoolean)
  {
    System.out.println("setSettingMenuVisible()---visible: " + paramBoolean);
    ImageButton localImageButton = this.g;
    if (paramBoolean) {}
    for (int j = 0;; j = 4)
    {
      localImageButton.setVisibility(j);
      return;
    }
  }
  
  final void f()
  {
    startActivity(new Intent(this, CategoryActivity.class));
  }
  
  public final void g()
  {
    this.f = ApsListFragment.class.getName();
    a(ApsListFragment.class.getName(), null, false);
  }
  
  public final void h()
  {
    this.f = RecommendFragment.class.getName();
    a(RecommendFragment.class.getName(), null, false);
  }
  
  public final void i()
  {
    this.f = LoadingFragment.class.getName();
    a(LoadingFragment.class.getName(), null, false);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    if (this.f.equals(ApsListFragment.class.getName())) {
      com.linksure.apservice.utils.b.d("saadbkcli_key");
    }
    for (;;)
    {
      return;
      if (this.f.equals(RecommendFragment.class.getName())) {
        com.linksure.apservice.utils.b.d("saadnbkcli_key");
      }
    }
  }
  
  protected native void onCreate(@Nullable Bundle paramBundle);
  
  protected void onDestroy()
  {
    super.onDestroy();
    c.removeListener(this.i);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramMenuItem.getItemId() == 1002)
    {
      f();
      if (this.f.equals(ApsListFragment.class.getName()))
      {
        com.linksure.apservice.utils.b.d("saadmrcli");
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (this.f.equals(RecommendFragment.class.getName()))
      {
        com.linksure.apservice.utils.b.d("saadnmrcli");
        bool1 = bool2;
        continue;
        if (paramMenuItem.getItemId() == 16908332)
        {
          if (this.f.equals(ApsListFragment.class.getName())) {
            com.linksure.apservice.utils.b.d("saadbkcli_btn");
          }
          for (;;)
          {
            finish();
            bool1 = bool2;
            break;
            if (this.f.equals(RecommendFragment.class.getName())) {
              com.linksure.apservice.utils.b.d("saadnbkcli_btn");
            }
          }
        }
        bool1 = false;
      }
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    com.lantern.analytics.a.a(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    com.lantern.analytics.a.b(this);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/apslist/ApsListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */