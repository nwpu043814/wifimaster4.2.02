package com.linksure.apservice.ui.home;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import com.linksure.apservice.R.id;
import com.linksure.apservice.a.i;
import com.linksure.apservice.ui.home.keyboard.KeyboardFragment;
import com.linksure.apservice.ui.home.list.MessageListFragment;
import com.linksure.apservice.ui.profile.ProfileActivity;
import com.linksure.apservice.utils.b;
import com.qihoo.util.StubApp1053578832;
import java.io.PrintStream;
import java.util.ArrayList;

public class ApServiceActivity
  extends com.linksure.apservice.ui.common.a
{
  private String f;
  private String g;
  private boolean h;
  
  static
  {
    StubApp1053578832.interface11(78);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    KeyboardFragment localKeyboardFragment = (KeyboardFragment)getFragmentManager().findFragmentById(R.id.aps_keyboard_placeholder);
    if ((this.h) && (localKeyboardFragment != null))
    {
      View localView = getCurrentFocus();
      if ((!localKeyboardFragment.n()) || (!localKeyboardFragment.a(localView, paramMotionEvent))) {
        break label56;
      }
      localKeyboardFragment.q();
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      label56:
      if ((localKeyboardFragment.l()) && (localKeyboardFragment.a(paramMotionEvent))) {
        localKeyboardFragment.o();
      } else if ((localKeyboardFragment.m()) && (localKeyboardFragment.b(paramMotionEvent))) {
        localKeyboardFragment.o();
      }
    }
  }
  
  public final void f()
  {
    MessageListFragment localMessageListFragment = (MessageListFragment)getFragmentManager().findFragmentById(R.id.aps_msglist_placeholder);
    if ((this.h) && (localMessageListFragment != null)) {
      localMessageListFragment.h();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Log.d("ApServiceActivity", "method onActivityResult() requestCode: " + paramInt1 + ", clearActivity: " + e);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 100) && (e))
    {
      e = false;
      finish();
    }
  }
  
  public void onBackPressed()
  {
    KeyboardFragment localKeyboardFragment = (KeyboardFragment)getFragmentManager().findFragmentById(R.id.aps_keyboard_placeholder);
    if ((this.h) && (localKeyboardFragment != null) && (localKeyboardFragment.i())) {}
    for (;;)
    {
      return;
      super.onBackPressed();
      b.d("saidbkcli_key");
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.h = false;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool = true;
    System.out.println("---DC--APSACTIVITY--onOptionsItemSelected-----");
    if (paramMenuItem.getItemId() == 1002)
    {
      String str = this.f;
      e = false;
      paramMenuItem = new Intent(this, ProfileActivity.class);
      paramMenuItem.putExtra("id", str);
      paramMenuItem.putExtra("refer", "home");
      startActivityForResult(paramMenuItem, 100);
      b.a(str);
    }
    for (;;)
    {
      return bool;
      if (paramMenuItem.getItemId() == 16908332)
      {
        b.d("saidbkcli_btn");
        finish();
      }
      else
      {
        bool = false;
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
    String str = this.f;
    Log.i("king", "------------------->loadCacheApsAccount");
    i.a(this).a(false, str, new a(this, str));
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("aps_id", this.f);
    com.linksure.apservice.b.a locala = i.a(this).a();
    if (locala != null)
    {
      paramBundle.putSerializable("aps_data", locala);
      paramBundle.putSerializable("aps_menu", (ArrayList)locala.a());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/home/ApServiceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */