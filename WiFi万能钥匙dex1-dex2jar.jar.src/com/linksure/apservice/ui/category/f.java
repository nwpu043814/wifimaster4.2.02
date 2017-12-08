package com.linksure.apservice.ui.category;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.bluefay.a.e;
import com.lantern.core.c;
import com.lantern.core.o;

final class f
  implements View.OnClickListener
{
  f(CategoryFragment paramCategoryFragment, Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    this.a.dismiss();
    CategoryFragment localCategoryFragment = this.b;
    c.getServer().p();
    com.linksure.apservice.a.b.f.a(localCategoryFragment.getActivity());
    paramView = new Intent("wifi.intent.action.ADD_ACCOUNT_MAIN");
    paramView.setPackage(localCategoryFragment.getActivity().getPackageName());
    paramView.putExtra("OON", "2");
    e.a(localCategoryFragment.getActivity(), paramView);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/category/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */