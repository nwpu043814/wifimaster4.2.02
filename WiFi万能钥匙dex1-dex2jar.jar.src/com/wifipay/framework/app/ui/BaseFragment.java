package com.wifipay.framework.app.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.wifipay.common.eventbus.EventBus;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.framework.a.a;
import com.wifipay.framework.service.IFragmentSwitchListener;
import com.wifipay.framework.service.ITitleBarListener;
import com.wifipay.framework.widget.WPAlertDialog.onNegativeListener;
import com.wifipay.framework.widget.WPAlertDialog.onPositiveListener;

public class BaseFragment
  extends Fragment
  implements ITitleBarListener
{
  private IFragmentSwitchListener a;
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (this.a != null) {
      this.a.onSwitch(paramInt, paramBundle);
    }
  }
  
  void a(Bundle paramBundle)
  {
    getArguments().putAll(paramBundle);
  }
  
  void a(IFragmentSwitchListener paramIFragmentSwitchListener)
  {
    this.a = paramIFragmentSwitchListener;
  }
  
  public void a(String paramString)
  {
    if (c() != null) {
      c().b(paramString);
    }
  }
  
  public void a(String paramString1, String paramString2, WPAlertDialog.onPositiveListener paramonPositiveListener)
  {
    if (c() != null) {
      c().a(paramString1, paramString2, paramonPositiveListener);
    }
  }
  
  public void a(String paramString1, String paramString2, WPAlertDialog.onPositiveListener paramonPositiveListener, View paramView)
  {
    if (c() != null) {
      c().a(paramString1, paramString2, paramonPositiveListener, paramView);
    }
  }
  
  public void a(String paramString1, String paramString2, String paramString3, WPAlertDialog.onPositiveListener paramonPositiveListener, String paramString4, WPAlertDialog.onNegativeListener paramonNegativeListener)
  {
    if (c() != null) {
      c().a(paramString1, paramString2, paramString3, paramonPositiveListener, paramString4, paramonNegativeListener);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b(String paramString)
  {
    if (c() != null) {
      c().c(paramString);
    }
  }
  
  public boolean b()
  {
    return false;
  }
  
  public SuperActivity c()
  {
    return (SuperActivity)getActivity();
  }
  
  public void d()
  {
    if (c() != null) {
      c().d();
    }
  }
  
  @Subscribe
  public void handlerNullSubscribe(a parama) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    EventBus.getDefault().register(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    EventBus.getDefault().unregister(this);
  }
  
  @Deprecated
  public boolean onTitleClick(int paramInt)
  {
    if (paramInt == 1) {}
    for (boolean bool = a();; bool = b()) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/app/ui/BaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */