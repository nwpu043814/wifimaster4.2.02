package com.lantern.push.ui;

import android.app.FragmentManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import bluefay.app.Fragment;
import bluefay.app.m;
import com.qihoo.util.StubApp1053578832;

public class MessageActivity
  extends m
{
  static
  {
    StubApp1053578832.interface11(43);
  }
  
  private void a(Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("MESSAGE_ID");
    paramIntent = paramIntent.getStringExtra("MESSAGE_URL");
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      new com.lantern.push.utils.e(getApplicationContext(), (String)localObject);
      if (!TextUtils.isEmpty(paramIntent))
      {
        localObject = new Intent("wifi.intent.action.BROWSER", Uri.parse(paramIntent));
        ((Intent)localObject).setPackage(getPackageName());
        paramIntent = new Bundle();
        paramIntent.putBoolean("allowbannerad", false);
        ((Intent)localObject).putExtras(paramIntent);
        com.bluefay.a.e.a(this, (Intent)localObject);
      }
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onNewIntent(Intent paramIntent)
  {
    Fragment localFragment = (Fragment)getFragmentManager().findFragmentByTag(MessageFragment.class.getName());
    if ((localFragment instanceof MessageFragment)) {
      ((MessageFragment)localFragment).c();
    }
    a(paramIntent);
    super.onNewIntent(paramIntent);
  }
  
  protected void onResume()
  {
    super.onResume();
    Fragment localFragment = (Fragment)getFragmentManager().findFragmentByTag(MessageFragment.class.getName());
    if ((localFragment instanceof MessageFragment)) {
      ((MessageFragment)localFragment).c();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/push/ui/MessageActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */