package com.lantern.browser.ui;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import bluefay.app.Fragment;
import bluefay.app.m;
import com.lantern.analytics.a;
import com.lantern.browser.R.id;
import com.lantern.browser.g;
import com.qihoo.util.StubApp1053578832;

public class WkBrowserAppStoreActivity
  extends m
  implements g
{
  private FragmentManager e;
  private Fragment f;
  private WkBrowserAppStoreFragment g = new WkBrowserAppStoreFragment();
  private WkBrowserAppDetailFragment h = new WkBrowserAppDetailFragment();
  private WkBrowserFragment i = new WkBrowserFragment();
  private boolean j = false;
  
  static
  {
    StubApp1053578832.interface11(12);
  }
  
  private void a(Fragment paramFragment1, Fragment paramFragment2)
  {
    if (paramFragment2 == null) {}
    for (;;)
    {
      return;
      if (this.f != paramFragment2)
      {
        this.f = paramFragment2;
        FragmentTransaction localFragmentTransaction = this.e.beginTransaction();
        if (!paramFragment2.isAdded())
        {
          if (paramFragment1 != null) {
            localFragmentTransaction.hide(paramFragment1);
          }
          localFragmentTransaction.add(R.id.fragment_container, paramFragment2);
          localFragmentTransaction.commitAllowingStateLoss();
        }
        else
        {
          if (paramFragment1 != null) {
            localFragmentTransaction.hide(paramFragment1);
          }
          localFragmentTransaction.show(paramFragment2);
          localFragmentTransaction.commitAllowingStateLoss();
        }
      }
    }
  }
  
  public final void a(Fragment paramFragment)
  {
    if (((paramFragment instanceof WkBrowserAppDetailFragment)) && (this.g.isAdded())) {
      a(paramFragment, this.g);
    }
    for (;;)
    {
      return;
      finish();
    }
  }
  
  public final void a(Fragment paramFragment, String paramString)
  {
    if ((paramFragment instanceof WkBrowserAppStoreFragment))
    {
      a(this.g, this.h);
      this.h.a(paramString);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Fragment localFragment = (Fragment)getFragmentManager().findFragmentByTag(WkBrowserFragment.class.getName());
    if (localFragment != null) {
      localFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (!this.j) {
      a.e().onEvent("bbxout");
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
  
  protected void onSaveInstanceState(Bundle paramBundle) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ui/WkBrowserAppStoreActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */