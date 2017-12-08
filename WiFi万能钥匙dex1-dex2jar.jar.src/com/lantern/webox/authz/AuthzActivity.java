package com.lantern.webox.authz;

import android.os.Bundle;
import android.view.MenuItem;
import bluefay.R.anim;
import bluefay.app.m;
import com.lantern.webox.b.e;
import com.qihoo.util.StubApp1053578832;

public class AuthzActivity
  extends m
{
  private e e = new e(getClass());
  
  static
  {
    StubApp1053578832.interface11(61);
  }
  
  protected final boolean b()
  {
    return false;
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(R.anim.framework_dialog_close_enter, R.anim.framework_dialog_close_exit);
  }
  
  public native void onCreate(Bundle paramBundle);
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/webox/authz/AuthzActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */