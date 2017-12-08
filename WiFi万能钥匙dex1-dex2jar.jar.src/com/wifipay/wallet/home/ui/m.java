package com.wifipay.wallet.home.ui;

import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.wifipay.R.drawable;
import com.wifipay.R.id;
import com.wifipay.R.string;
import com.wifipay.common.a.b;
import com.wifipay.common.a.d;
import com.wifipay.common.a.g;
import com.wifipay.wallet.home.bean.Banner;
import com.wifipay.wallet.home.widget.BannerViewPager;
import com.wifipay.wallet.home.widget.BannerViewPager.OnItemClickListener;
import java.util.ArrayList;
import java.util.List;

public class m
  implements BannerViewPager.OnItemClickListener
{
  public HomeActivity a;
  public List<Banner> b = new ArrayList();
  public BannerViewPager c;
  private LinearLayout d;
  private List<ImageView> e = new ArrayList();
  private Handler f = new n(this);
  private LinearLayout g;
  
  public m(HomeActivity paramHomeActivity, List<Banner> paramList)
  {
    this.b = paramList;
    this.a = paramHomeActivity;
    this.d = ((LinearLayout)paramHomeActivity.findViewById(R.id.wifipay_home_banner_container));
    this.g = ((LinearLayout)paramHomeActivity.findViewById(R.id.wifipay_home_banner_indicator_container));
  }
  
  public void a()
  {
    if (this.c != null) {
      this.c.a();
    }
    this.f.sendEmptyMessage(0);
  }
  
  public void a(int paramInt)
  {
    this.g.removeAllViews();
    if (this.e.size() > 0) {
      this.e.clear();
    }
    int i = 0;
    if (i < paramInt)
    {
      ImageView localImageView = new ImageView(this.a);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(b.a(this.a, 6.0F), b.a(this.a, 6.0F));
      if (i == 0) {
        localImageView.setBackgroundResource(R.drawable.wifipay_home_banner_indicator_current);
      }
      for (;;)
      {
        localImageView.setLayoutParams(localLayoutParams);
        this.e.add(localImageView);
        this.g.addView(localImageView);
        i++;
        break;
        localImageView.setBackgroundResource(R.drawable.wifipay_home_banner_indicator_normal);
        localLayoutParams.leftMargin = b.a(this.a, 6.0F);
      }
    }
  }
  
  public void b(int paramInt)
  {
    String str2 = ((Banner)this.b.get(paramInt)).link;
    if (com.wifipay.wallet.common.utils.f.b(str2)) {}
    for (;;)
    {
      return;
      String str1 = str2;
      if (str2.contains("#"))
      {
        str1 = str2.substring(str2.lastIndexOf("#") + 1);
        str2 = str2.substring(0, str2.lastIndexOf("#"));
        String[] arrayOfString = str1.split("=");
        if (!g.a(arrayOfString[0], "h5Param")) {
          continue;
        }
        str1 = str2;
        if (!g.a("LOCAL_WEB", arrayOfString[1]))
        {
          if (!g.a("WIFI_WEB", arrayOfString[1])) {
            continue;
          }
          this.a.d(str2);
          continue;
        }
      }
      HomeWebActivity.a(this.a, str1);
    }
  }
  
  public void onItemClick(View paramView)
  {
    if (!d.a(this.a)) {
      this.a.b(com.wifipay.common.a.f.a(R.string.wifipay_home_error_net));
    }
    for (;;)
    {
      return;
      int i = ((Integer)paramView.getTag()).intValue();
      if ((com.wifipay.wallet.common.utils.f.a(this.b)) && (this.b.size() > 0)) {
        b(i);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/ui/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */