package com.lantern.browser.ui;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.FragmentManager;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import bluefay.app.Fragment;
import bluefay.app.m;
import com.lantern.analytics.a;
import com.lantern.browser.n;
import com.qihoo.util.StubApp1053578832;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class WkBrowserActivity
  extends m
{
  private boolean e;
  
  static
  {
    StubApp1053578832.interface11(11);
  }
  
  protected final boolean b()
  {
    return false;
  }
  
  public void finish()
  {
    HashMap localHashMap = null;
    int n = 0;
    Intent localIntent = getIntent();
    if (localIntent != null) {}
    for (Object localObject = localIntent.getStringExtra("from");; localObject = null)
    {
      if ((TextUtils.isEmpty((CharSequence)localObject)) || ("mailbox_list".equals(localObject)))
      {
        a.e().onEvent("ddback", "bro");
        super.finish();
        if (this.e) {
          overridePendingTransition(bluefay.R.anim.framework_dialog_close_enter, bluefay.R.anim.framework_dialog_close_exit);
        }
        n.b();
        n.c();
        a.e().onEvent("broout");
        return;
      }
      int i;
      int j;
      int k;
      label107:
      int m;
      ActivityManager.RunningTaskInfo localRunningTaskInfo;
      if ("wkpush".equals(localObject))
      {
        i = 0;
        j = 0;
        k = 1;
        localObject = ((ActivityManager)getSystemService("activity")).getRunningTasks(1);
        m = n;
        if (localObject != null)
        {
          m = n;
          if (((List)localObject).size() > 0)
          {
            localRunningTaskInfo = (ActivityManager.RunningTaskInfo)((List)localObject).get(0);
            localObject = localRunningTaskInfo.baseActivity;
            m = n;
            if (localObject != null)
            {
              if (!"com.lantern.launcher.ui.MainActivityICS".equals(((ComponentName)localObject).getClassName())) {
                break label422;
              }
              m = 1;
            }
          }
        }
        label190:
        if (m == 0) {
          break label468;
        }
        a.e().onEvent("ddback", "back");
      }
      for (;;)
      {
        if (k != 0)
        {
          localObject = localHashMap;
          if (localIntent != null) {
            localObject = localIntent.getStringExtra("push_id");
          }
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localHashMap = new HashMap();
            localHashMap.put("rid", localObject);
            a.e().onEvent("ddbkpu", new JSONObject(localHashMap).toString());
          }
        }
        if (i != 0) {
          a.e().onEvent("msgpbk");
        }
        localObject = new Intent("wifi.intent.action.notification.jump");
        ((Intent)localObject).setPackage(getPackageName());
        ((Intent)localObject).putExtra("extra_jump_tab", "Connect");
        ((Intent)localObject).putExtra("extra_jump_open_main", true);
        ((Intent)localObject).addFlags(268435456);
        startActivity((Intent)localObject);
        overridePendingTransition(com.lantern.browser.R.anim.framework_slide_left_enter, com.lantern.browser.R.anim.framework_slide_right_exit);
        break;
        if ("third".equals(localObject))
        {
          i = 0;
          j = 1;
          k = 0;
          break label107;
        }
        if ("mailbox_push".equals(localObject))
        {
          i = 1;
          j = 0;
          k = 0;
          break label107;
        }
        if ("feed".equals(localObject)) {
          a.e().onEvent("ddback", "feed");
        }
        i = 0;
        j = 0;
        k = 0;
        break label107;
        label422:
        m = n;
        if (localRunningTaskInfo.numActivities <= 1) {
          break label190;
        }
        m = n;
        if (!WkBrowserActivity.class.getName().equals(((ComponentName)localObject).getClassName())) {
          break label190;
        }
        a.e().onEvent("ddback", "bro");
        break;
        label468:
        if (k != 0) {
          a.e().onEvent("ddback", "push");
        } else if (j != 0) {
          a.e().onEvent("ddback", "third");
        }
      }
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
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    return false;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ui/WkBrowserActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */