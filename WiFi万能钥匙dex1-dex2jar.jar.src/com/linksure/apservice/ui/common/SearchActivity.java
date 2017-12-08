package com.linksure.apservice.ui.common;

import android.os.Bundle;
import android.view.MenuItem;
import com.linksure.apservice.R.anim;
import com.linksure.apservice.utils.b;
import com.qihoo.util.StubApp1053578832;

public class SearchActivity
  extends a
{
  static
  {
    StubApp1053578832.interface11(77);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(R.anim.aps_activity_stay, R.anim.framework_dialog_close_exit);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    b.d("sasrbkcli_key");
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      b.d("sasrbkcli_btn");
      finish();
    }
    for (boolean bool = true;; bool = super.onOptionsItemSelected(paramMenuItem)) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/common/SearchActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */