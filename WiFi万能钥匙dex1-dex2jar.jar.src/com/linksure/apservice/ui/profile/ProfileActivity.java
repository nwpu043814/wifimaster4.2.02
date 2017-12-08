package com.linksure.apservice.ui.profile;

import android.os.Bundle;
import android.view.MenuItem;
import bluefay.support.annotation.Nullable;
import com.bluefay.a.d;
import com.lantern.core.c;
import com.linksure.apservice.ui.profile.detail.ProfileFragment;
import com.qihoo.util.StubApp1053578832;
import java.io.PrintStream;

public class ProfileActivity
  extends com.linksure.apservice.ui.common.a
{
  private static final int[] j = { 128500 };
  private com.linksure.apservice.b.a f;
  private String g;
  private String h;
  private String i;
  private com.bluefay.d.b k = new f(this, j);
  
  static
  {
    StubApp1053578832.interface11(79);
  }
  
  public final void a(com.linksure.apservice.b.a parama)
  {
    d.a(this, "aps_cache", "aps_cache_account", true);
    this.f = parama;
  }
  
  public final void b(com.linksure.apservice.b.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("aps", parama);
    a(ProfileFragment.class.getName(), localBundle, false);
    this.i = ProfileFragment.class.getName();
  }
  
  public final void c(com.linksure.apservice.b.a parama)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("id", parama.k);
    a(ComplainFragment.class.getName(), localBundle, true);
    this.i = ComplainFragment.class.getName();
  }
  
  public final String f()
  {
    return this.h;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    if (this.f == null) {}
    for (;;)
    {
      return;
      if (this.f.e) {
        com.linksure.apservice.utils.b.a("saifbkcli_key", this.f.k);
      } else {
        com.linksure.apservice.utils.b.d("saifnbkcli_key");
      }
    }
  }
  
  protected native void onCreate(@Nullable Bundle paramBundle);
  
  protected void onDestroy()
  {
    super.onDestroy();
    c.removeListener(this.k);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332) {
      if (this.f != null)
      {
        if (this.f.e)
        {
          System.out.println("---DC--PFA--onOptionsItemSelected-----TAG_PROFILE_ACTION_BAR_BACK");
          com.linksure.apservice.utils.b.a("saifbkcli_btn", this.f.k);
        }
      }
      else
      {
        if (!ComplainFragment.class.getName().equals(this.i)) {
          break label87;
        }
        super.onBackPressed();
      }
    }
    label67:
    for (boolean bool = true;; bool = super.onOptionsItemSelected(paramMenuItem))
    {
      return bool;
      System.out.println("---DC--PFA--onOptionsItemSelected-----TAG_INFON_ACTION_BAR_BACK");
      com.linksure.apservice.utils.b.d("saifnbkcli_btn");
      break;
      label87:
      finish();
      break label67;
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
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putSerializable("aps", this.f);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/profile/ProfileActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */