package com.lantern.core;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.lantern.core.e.a;

final class d
  implements Application.ActivityLifecycleCallbacks
{
  d(c paramc) {}
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity)
  {
    this.a.isAppForeground = true;
    this.a.mCurActivity = paramActivity;
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity)
  {
    if (this.a.mActivityCount <= 0)
    {
      this.a.mActivityCount = 0;
      localObject = Message.obtain();
      ((Message)localObject).what = 128400;
      ((Message)localObject).obj = null;
      c.dispatch((Message)localObject);
    }
    Object localObject = this.a;
    ((c)localObject).mActivityCount += 1;
    this.a.mCurActivity = paramActivity;
    if (TextUtils.isEmpty(this.a.mSeeionId))
    {
      this.a.mSeeionId = String.valueOf(System.currentTimeMillis());
      a.a();
    }
  }
  
  public final void onActivityStopped(Activity paramActivity)
  {
    paramActivity = this.a;
    paramActivity.mActivityCount -= 1;
    if (this.a.mActivityCount <= 0)
    {
      this.a.mCurActivity = null;
      this.a.mSeeionId = "";
      this.a.mActivityCount = 0;
      this.a.isAppForeground = false;
      a.b();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/core/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */