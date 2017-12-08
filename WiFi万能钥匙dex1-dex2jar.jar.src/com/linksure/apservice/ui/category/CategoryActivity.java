package com.linksure.apservice.ui.category;

import android.os.Bundle;
import android.view.MenuItem;
import com.linksure.apservice.ui.common.a;
import com.linksure.apservice.utils.b;
import com.qihoo.util.StubApp1053578832;

public class CategoryActivity
  extends a
{
  static
  {
    StubApp1053578832.interface11(74);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    b.d("salsbkcli_key");
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      b.d("salsbkcli_btn");
      finish();
    }
    for (boolean bool = true;; bool = super.onOptionsItemSelected(paramMenuItem)) {
      return bool;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/category/CategoryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */