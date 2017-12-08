package com.wifi.plugin.c;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;

public final class a
  extends Instrumentation
{
  Instrumentation a;
  com.wifi.plugin.f.a b;
  
  public a(Instrumentation paramInstrumentation)
  {
    this.a = paramInstrumentation;
    this.b = com.wifi.plugin.f.a.a(paramInstrumentation);
  }
  
  public final void callActivityOnCreate(Activity paramActivity, Bundle paramBundle)
  {
    this.a.callActivityOnCreate(paramActivity, paramBundle);
  }
  
  public final void callActivityOnDestroy(Activity paramActivity)
  {
    this.a.callActivityOnDestroy(paramActivity);
  }
  
  public final void callActivityOnNewIntent(Activity paramActivity, Intent paramIntent)
  {
    this.a.callActivityOnNewIntent(paramActivity, paramIntent);
  }
  
  public final void callActivityOnPause(Activity paramActivity)
  {
    this.a.callActivityOnDestroy(paramActivity);
  }
  
  public final void callApplicationOnCreate(Application paramApplication)
  {
    this.a.callApplicationOnCreate(paramApplication);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.a.onCreate(paramBundle);
  }
  
  public final void onDestroy()
  {
    this.a.onDestroy();
  }
  
  public final boolean onException(Object paramObject, Throwable paramThrowable)
  {
    return this.a.onException(paramObject, paramThrowable);
  }
  
  public final void onStart()
  {
    this.a.onStart();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/plugin/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */