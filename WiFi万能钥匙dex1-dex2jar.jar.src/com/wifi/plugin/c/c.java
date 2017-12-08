package com.wifi.plugin.c;

import android.app.Activity;
import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public final class c
  implements b
{
  Activity a;
  Activity b;
  com.wifi.plugin.f.a c;
  com.wifi.plugin.f.a d;
  Application e;
  Instrumentation f;
  
  public c(Activity paramActivity1, Activity paramActivity2, Application paramApplication)
  {
    this.a = paramActivity1;
    this.b = paramActivity2;
    this.e = paramApplication;
    com.wifi.plugin.b.c("app:" + paramApplication);
    this.f = new Instrumentation();
    this.c = com.wifi.plugin.f.a.a(paramActivity1);
    this.d = com.wifi.plugin.f.a.a(paramActivity2);
  }
  
  public final View a(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.b.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
  }
  
  public final View a(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return this.b.onCreateView(paramString, paramContext, paramAttributeSet);
  }
  
  public final void a()
  {
    this.f.callActivityOnStop(this.b);
  }
  
  public final void a(Intent paramIntent)
  {
    this.f.callActivityOnNewIntent(this.b, paramIntent);
  }
  
  public final void a(Configuration paramConfiguration)
  {
    this.b.onConfigurationChanged(paramConfiguration);
  }
  
  public final void a(Bundle paramBundle)
  {
    Application localApplication = this.b.getApplication();
    com.wifi.plugin.b.c("app:" + localApplication);
    this.f.callActivityOnCreate(this.b, paramBundle);
  }
  
  public final void a(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    this.b.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
  }
  
  public final boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return this.b.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final void b()
  {
    Application localApplication = this.b.getApplication();
    com.wifi.plugin.b.c("app:" + localApplication);
    this.f.callActivityOnResume(this.b);
  }
  
  public final void c()
  {
    this.f.callActivityOnDestroy(this.b);
  }
  
  public final void d()
  {
    this.f.callActivityOnStop(this.b);
  }
  
  public final void e()
  {
    this.f.callActivityOnRestart(this.b);
  }
  
  public final void f()
  {
    this.f.callActivityOnPause(this.b);
  }
  
  public final void g()
  {
    this.b.onBackPressed();
  }
  
  public final void h()
  {
    this.d.c("onPostResume");
  }
  
  public final void i()
  {
    this.b.onDetachedFromWindow();
  }
  
  public final void j()
  {
    if (this.b.getBaseContext() != null) {
      return;
    }
    label358:
    Object localObject2;
    for (;;)
    {
      try
      {
        Object localObject1 = (Instrumentation)this.c.b("mInstrumentation");
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>("SDK_INT:");
        com.wifi.plugin.b.c(Build.VERSION.SDK_INT);
        if (Build.VERSION.SDK_INT != 21) {
          break label379;
        }
        localObject6 = this.d;
        localObject7 = this.a;
        localObject5 = this.c.b("mMainThread");
        localObject4 = new com/wifi/plugin/c/a;
        ((a)localObject4).<init>((Instrumentation)localObject1);
        localObject8 = this.c.b("mToken");
        if (this.c.b("mEmbeddedID") != null) {
          break label358;
        }
        localObject1 = Integer.valueOf(0);
        if (this.e != null) {
          break label371;
        }
        localObject3 = this.a.getApplication();
        ((com.wifi.plugin.f.a)localObject6).a("attach", "com.android.internal.app.IVoiceInteractor", new Object[] { localObject7, localObject5, localObject4, localObject8, localObject1, localObject3, this.a.getIntent(), this.c.b("mActivityInfo"), this.a.getTitle(), this.a.getParent(), this.c.b("mEmbeddedID"), this.a.getLastNonConfigurationInstance(), this.c.b("mCurrentConfig"), null });
        localObject1 = this.b.getApplication();
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>("app:");
        com.wifi.plugin.b.c(localObject1);
        this.d.a("mWindow", this.a.getWindow());
        this.b.getWindow().setCallback(this.b);
        com.wifi.plugin.f.a.a(this.a.getBaseContext()).a("setOuterContext", new Object[] { this.b });
      }
      catch (com.wifi.plugin.f.b localb)
      {
        com.wifi.plugin.b.a(localb);
      }
      break;
      localObject2 = this.c.b("mEmbeddedID");
      continue;
      label371:
      localObject3 = this.e;
    }
    label379:
    if (Build.VERSION.SDK_INT > 23)
    {
      com.wifi.plugin.b.c("Plugin version is for android N or later");
      localObject6 = this.d;
      localObject7 = this.a;
      localObject5 = this.c.b("mMainThread");
      localObject4 = new com/wifi/plugin/c/a;
      ((a)localObject4).<init>((Instrumentation)localObject2);
      localObject8 = this.c.b("mToken");
      if (this.c.b("mEmbeddedID") == null)
      {
        localObject2 = Integer.valueOf(0);
        label452:
        if (this.e != null) {
          break label630;
        }
      }
      label630:
      for (localObject3 = this.a.getApplication();; localObject3 = this.e)
      {
        ((com.wifi.plugin.f.a)localObject6).b("attach", "com.android.internal.app.IVoiceInteractor", new Object[] { localObject7, localObject5, localObject4, localObject8, localObject2, localObject3, this.a.getIntent(), this.c.b("mActivityInfo"), this.a.getTitle(), this.a.getParent(), this.c.b("mEmbeddedID"), this.a.getLastNonConfigurationInstance(), this.c.b("mCurrentConfig"), "", null, this.a.getWindow() });
        break;
        localObject2 = this.c.b("mEmbeddedID");
        break label452;
      }
    }
    if (Build.VERSION.SDK_INT >= 22)
    {
      localObject7 = this.d;
      localObject4 = this.a;
      localObject5 = this.c.b("mMainThread");
      localObject6 = new com/wifi/plugin/c/a;
      ((a)localObject6).<init>((Instrumentation)localObject2);
      localObject8 = this.c.b("mToken");
      if (this.c.b("mEmbeddedID") == null)
      {
        localObject2 = Integer.valueOf(0);
        label707:
        if (this.e != null) {
          break label874;
        }
      }
      label874:
      for (localObject3 = this.a.getApplication();; localObject3 = this.e)
      {
        ((com.wifi.plugin.f.a)localObject7).a("attach", "com.android.internal.app.IVoiceInteractor", new Object[] { localObject4, localObject5, localObject6, localObject8, localObject2, localObject3, this.a.getIntent(), this.c.b("mActivityInfo"), this.a.getTitle(), this.a.getParent(), this.c.b("mEmbeddedID"), this.a.getLastNonConfigurationInstance(), this.c.b("mCurrentConfig"), "", null });
        break;
        localObject2 = this.c.b("mEmbeddedID");
        break label707;
      }
    }
    Object localObject5 = this.d;
    Object localObject4 = this.a;
    Object localObject6 = this.c.b("mMainThread");
    Object localObject7 = new com/wifi/plugin/c/a;
    ((a)localObject7).<init>((Instrumentation)localObject2);
    Object localObject8 = this.c.b("mToken");
    if (this.c.b("mEmbeddedID") == null)
    {
      localObject2 = Integer.valueOf(0);
      label943:
      if (this.e != null) {
        break label1097;
      }
    }
    label1097:
    for (Object localObject3 = this.a.getApplication();; localObject3 = this.e)
    {
      ((com.wifi.plugin.f.a)localObject5).a("attach", new Object[] { localObject4, localObject6, localObject7, localObject8, localObject2, localObject3, this.a.getIntent(), this.c.b("mActivityInfo"), this.a.getTitle(), this.a.getParent(), this.c.b("mEmbeddedID"), this.a.getLastNonConfigurationInstance(), this.c.b("mCurrentConfig") });
      break;
      localObject2 = this.c.b("mEmbeddedID");
      break label943;
    }
  }
  
  public final com.wifi.plugin.f.a k()
  {
    return this.d;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/plugin/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */