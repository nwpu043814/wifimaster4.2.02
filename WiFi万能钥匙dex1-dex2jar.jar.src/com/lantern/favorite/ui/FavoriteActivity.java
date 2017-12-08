package com.lantern.favorite.ui;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import bluefay.app.Fragment;
import bluefay.app.m;
import com.qihoo.util.StubApp1053578832;

public class FavoriteActivity
  extends m
{
  public boolean e = false;
  public boolean f = false;
  public int g = 0;
  public int h = 0;
  public int i = 1;
  public com.lantern.favorite.a j;
  private com.bluefay.b.a k = new c(this);
  
  static
  {
    StubApp1053578832.interface11(17);
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    com.lantern.favorite.b.a locala = new com.lantern.favorite.b.a(this.j, paramInt1, paramInt2, this.k);
    locala.a(new a(this));
    locala.execute(new Void[0]);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Fragment localFragment = (Fragment)getFragmentManager().findFragmentByTag(FavoriteFragment.class.getName());
    if (localFragment != null) {
      localFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    this.e = true;
    super.onDestroy();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/ui/FavoriteActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */