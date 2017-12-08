package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.content.IntentCompat;
import android.util.Log;

public class NavUtils
{
  private static final NavUtilsImpl IMPL;
  public static final String PARENT_ACTIVITY = "android.support.PARENT_ACTIVITY";
  private static final String TAG = "NavUtils";
  
  static
  {
    if (Build.VERSION.SDK_INT >= 16) {}
    for (IMPL = new NavUtilsImplJB();; IMPL = new NavUtilsImplBase()) {
      return;
    }
  }
  
  public static Intent getParentActivityIntent(Activity paramActivity)
  {
    return IMPL.getParentActivityIntent(paramActivity);
  }
  
  public static Intent getParentActivityIntent(Context paramContext, ComponentName paramComponentName)
  {
    String str = getParentActivityName(paramContext, paramComponentName);
    if (str == null) {
      paramContext = null;
    }
    for (;;)
    {
      return paramContext;
      paramComponentName = new ComponentName(paramComponentName.getPackageName(), str);
      if (getParentActivityName(paramContext, paramComponentName) == null) {
        paramContext = IntentCompat.makeMainActivity(paramComponentName);
      } else {
        paramContext = new Intent().setComponent(paramComponentName);
      }
    }
  }
  
  public static Intent getParentActivityIntent(Context paramContext, Class<?> paramClass)
  {
    paramClass = getParentActivityName(paramContext, new ComponentName(paramContext, paramClass));
    if (paramClass == null) {
      paramContext = null;
    }
    for (;;)
    {
      return paramContext;
      paramClass = new ComponentName(paramContext, paramClass);
      if (getParentActivityName(paramContext, paramClass) == null) {
        paramContext = IntentCompat.makeMainActivity(paramClass);
      } else {
        paramContext = new Intent().setComponent(paramClass);
      }
    }
  }
  
  public static String getParentActivityName(Activity paramActivity)
  {
    try
    {
      paramActivity = getParentActivityName(paramActivity, paramActivity.getComponentName());
      return paramActivity;
    }
    catch (PackageManager.NameNotFoundException paramActivity)
    {
      throw new IllegalArgumentException(paramActivity);
    }
  }
  
  public static String getParentActivityName(Context paramContext, ComponentName paramComponentName)
  {
    paramComponentName = paramContext.getPackageManager().getActivityInfo(paramComponentName, 128);
    return IMPL.getParentActivityName(paramContext, paramComponentName);
  }
  
  public static void navigateUpFromSameTask(Activity paramActivity)
  {
    Intent localIntent = getParentActivityIntent(paramActivity);
    if (localIntent == null) {
      throw new IllegalArgumentException("Activity " + paramActivity.getClass().getSimpleName() + " does not have a parent activity name specified. (Did you forget to add the android.support.PARENT_ACTIVITY <meta-data>  element in your manifest?)");
    }
    navigateUpTo(paramActivity, localIntent);
  }
  
  public static void navigateUpTo(Activity paramActivity, Intent paramIntent)
  {
    IMPL.navigateUpTo(paramActivity, paramIntent);
  }
  
  public static boolean shouldUpRecreateTask(Activity paramActivity, Intent paramIntent)
  {
    return IMPL.shouldUpRecreateTask(paramActivity, paramIntent);
  }
  
  static abstract interface NavUtilsImpl
  {
    public abstract Intent getParentActivityIntent(Activity paramActivity);
    
    public abstract String getParentActivityName(Context paramContext, ActivityInfo paramActivityInfo);
    
    public abstract void navigateUpTo(Activity paramActivity, Intent paramIntent);
    
    public abstract boolean shouldUpRecreateTask(Activity paramActivity, Intent paramIntent);
  }
  
  static class NavUtilsImplBase
    implements NavUtils.NavUtilsImpl
  {
    public Intent getParentActivityIntent(Activity paramActivity)
    {
      Object localObject = null;
      String str = NavUtils.getParentActivityName(paramActivity);
      if (str == null) {
        paramActivity = (Activity)localObject;
      }
      for (;;)
      {
        return paramActivity;
        ComponentName localComponentName = new ComponentName(paramActivity, str);
        try
        {
          if (NavUtils.getParentActivityName(paramActivity, localComponentName) == null)
          {
            paramActivity = IntentCompat.makeMainActivity(localComponentName);
          }
          else
          {
            paramActivity = new android/content/Intent;
            paramActivity.<init>();
            paramActivity = paramActivity.setComponent(localComponentName);
          }
        }
        catch (PackageManager.NameNotFoundException paramActivity)
        {
          Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + str + "' in manifest");
          paramActivity = (Activity)localObject;
        }
      }
    }
    
    public String getParentActivityName(Context paramContext, ActivityInfo paramActivityInfo)
    {
      if (paramActivityInfo.metaData == null) {
        paramActivityInfo = null;
      }
      for (;;)
      {
        return paramActivityInfo;
        String str = paramActivityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
        if (str == null)
        {
          paramActivityInfo = null;
        }
        else
        {
          paramActivityInfo = str;
          if (str.charAt(0) == '.') {
            paramActivityInfo = paramContext.getPackageName() + str;
          }
        }
      }
    }
    
    public void navigateUpTo(Activity paramActivity, Intent paramIntent)
    {
      paramIntent.addFlags(67108864);
      paramActivity.startActivity(paramIntent);
      paramActivity.finish();
    }
    
    public boolean shouldUpRecreateTask(Activity paramActivity, Intent paramIntent)
    {
      paramActivity = paramActivity.getIntent().getAction();
      if ((paramActivity != null) && (!paramActivity.equals("android.intent.action.MAIN"))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
  }
  
  static class NavUtilsImplJB
    extends NavUtils.NavUtilsImplBase
  {
    public Intent getParentActivityIntent(Activity paramActivity)
    {
      Intent localIntent2 = NavUtilsJB.getParentActivityIntent(paramActivity);
      Intent localIntent1 = localIntent2;
      if (localIntent2 == null) {
        localIntent1 = superGetParentActivityIntent(paramActivity);
      }
      return localIntent1;
    }
    
    public String getParentActivityName(Context paramContext, ActivityInfo paramActivityInfo)
    {
      String str2 = NavUtilsJB.getParentActivityName(paramActivityInfo);
      String str1 = str2;
      if (str2 == null) {
        str1 = super.getParentActivityName(paramContext, paramActivityInfo);
      }
      return str1;
    }
    
    public void navigateUpTo(Activity paramActivity, Intent paramIntent)
    {
      NavUtilsJB.navigateUpTo(paramActivity, paramIntent);
    }
    
    public boolean shouldUpRecreateTask(Activity paramActivity, Intent paramIntent)
    {
      return NavUtilsJB.shouldUpRecreateTask(paramActivity, paramIntent);
    }
    
    Intent superGetParentActivityIntent(Activity paramActivity)
    {
      return super.getParentActivityIntent(paramActivity);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/app/NavUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */