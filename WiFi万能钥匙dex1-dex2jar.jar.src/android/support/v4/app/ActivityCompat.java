package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

public class ActivityCompat
  extends ContextCompat
{
  public static void finishAffinity(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      ActivityCompatJB.finishAffinity(paramActivity);
    }
    for (;;)
    {
      return;
      paramActivity.finish();
    }
  }
  
  public static boolean invalidateOptionsMenu(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      ActivityCompatHoneycomb.invalidateOptionsMenu(paramActivity);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public static void startActivity(Activity paramActivity, Intent paramIntent, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      ActivityCompatJB.startActivity(paramActivity, paramIntent, paramBundle);
    }
    for (;;)
    {
      return;
      paramActivity.startActivity(paramIntent);
    }
  }
  
  public static void startActivityForResult(Activity paramActivity, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16) {
      ActivityCompatJB.startActivityForResult(paramActivity, paramIntent, paramInt, paramBundle);
    }
    for (;;)
    {
      return;
      paramActivity.startActivityForResult(paramIntent, paramInt);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/app/ActivityCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */