package com.wifi.plugin;

import android.app.Activity;
import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.qihoo.util.StubApp1053578832;
import com.wifi.plugin.c.c;
import dalvik.system.DexClassLoader;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class BLActivityProxy
  extends Activity
{
  private com.wifi.plugin.b.b a;
  
  static
  {
    StubApp1053578832.interface11(97);
  }
  
  private void a(com.wifi.plugin.b.b paramb)
  {
    localObject2 = null;
    Resources.Theme localTheme = paramb.f().e.newTheme();
    localTheme.setTo(super.getTheme());
    paramb.a(localTheme);
    Object localObject3 = paramb.f().f;
    Object localObject1 = paramb.a();
    b.c("Before fill Plugin 's Theme,We check the plugin:info = " + localObject3 + "topActivityName = " + (String)localObject1);
    int j = ((PackageInfo)localObject3).applicationInfo.theme;
    ActivityInfo[] arrayOfActivityInfo = ((PackageInfo)localObject3).activities;
    int k = arrayOfActivityInfo.length;
    int i = 0;
    if (i >= k)
    {
      localObject1 = null;
      i = j;
      label109:
      b.c("defaultTheme.theme:" + i);
      localTheme.applyStyle(i, true);
      setTheme(i);
      if (localObject1 != null) {
        getWindow().setSoftInputMode(((ActivityInfo)localObject1).softInputMode);
      }
      if (!a.a) {}
    }
    for (;;)
    {
      try
      {
        paramb = paramb.c();
        localObject1 = getPackageManager();
        localObject3 = d.a(this, paramb);
        if (localObject3 != null) {
          continue;
        }
        paramb = (com.wifi.plugin.b.b)localObject2;
      }
      catch (PackageManager.NameNotFoundException paramb)
      {
        paramb.printStackTrace();
        paramb = (com.wifi.plugin.b.b)localObject2;
        continue;
      }
      if (paramb != null) {
        setTitle(paramb);
      }
      return;
      localObject3 = arrayOfActivityInfo[i];
      if (((ActivityInfo)localObject3).name.equals(localObject1))
      {
        b.c("a.theme:" + ((ActivityInfo)localObject3).theme);
        if (((ActivityInfo)localObject3).theme != 0)
        {
          i = ((ActivityInfo)localObject3).theme;
          localObject1 = localObject3;
          break label109;
        }
        localObject1 = localObject3;
        i = j;
        if (j != 0) {
          break label109;
        }
        if (Build.VERSION.SDK_INT >= 14)
        {
          i = 16974120;
          localObject1 = localObject3;
          break label109;
        }
        i = 16973829;
        localObject1 = localObject3;
        break label109;
      }
      i++;
      break;
      localObject3 = ((PackageInfo)localObject3).applicationInfo;
      if (Build.VERSION.SDK_INT >= 8)
      {
        ((ApplicationInfo)localObject3).sourceDir = paramb;
        ((ApplicationInfo)localObject3).publicSourceDir = paramb;
      }
      paramb = ((PackageManager)localObject1).getApplicationLabel((ApplicationInfo)localObject3);
    }
  }
  
  private static void b(com.wifi.plugin.b.b paramb)
  {
    try
    {
      if (paramb.a() == null)
      {
        localObject2 = paramb.f().f.activities[0].name;
        localObject1 = new java/lang/StringBuilder;
        ((StringBuilder)localObject1).<init>("top----");
        b.c((String)localObject2);
        paramb.a((String)localObject2);
      }
      Object localObject1 = (Activity)paramb.f().g.loadClass(paramb.a()).newInstance();
      Object localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>("myPlugin:");
      b.a(localObject1);
      paramb.a((Activity)localObject1);
      return;
    }
    catch (Exception paramb)
    {
      throw new com.wifi.plugin.d.a(paramb.getMessage());
    }
  }
  
  public void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    if (this.a == null) {}
    for (;;)
    {
      return;
      c localc = this.a.b();
      if (localc != null) {
        localc.a(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
      }
    }
  }
  
  public AssetManager getAssets()
  {
    AssetManager localAssetManager;
    if (this.a == null) {
      localAssetManager = super.getAssets();
    }
    for (;;)
    {
      return localAssetManager;
      if (this.a.f().d == null) {
        localAssetManager = super.getAssets();
      } else {
        localAssetManager = this.a.f().d;
      }
    }
  }
  
  public ClassLoader getClassLoader()
  {
    Object localObject;
    if (this.a == null) {
      localObject = super.getClassLoader();
    }
    for (;;)
    {
      return (ClassLoader)localObject;
      if (this.a.f().a()) {
        localObject = this.a.f().g;
      } else {
        localObject = super.getClassLoader();
      }
    }
  }
  
  public Resources getResources()
  {
    Resources localResources;
    if (this.a == null) {
      localResources = super.getResources();
    }
    for (;;)
    {
      return localResources;
      if (this.a.f().e == null) {
        localResources = super.getResources();
      } else {
        localResources = this.a.f().e;
      }
    }
  }
  
  public Resources.Theme getTheme()
  {
    Resources.Theme localTheme;
    if (this.a == null) {
      localTheme = super.getTheme();
    }
    for (;;)
    {
      return localTheme;
      if (this.a.d() == null) {
        localTheme = super.getTheme();
      } else {
        localTheme = this.a.d();
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.a == null) {}
    for (;;)
    {
      return;
      this.a.b().k().a("onActivityResult", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
    }
  }
  
  public void onAttachFragment(Fragment paramFragment)
  {
    super.onAttachFragment(paramFragment);
    if (this.a == null) {}
    for (;;)
    {
      return;
      this.a.e().onAttachFragment(paramFragment);
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.a == null) {}
    for (;;)
    {
      return;
      this.a.e().onAttachedToWindow();
    }
  }
  
  public void onBackPressed()
  {
    if (this.a == null) {
      super.onBackPressed();
    }
    c localc = this.a.b();
    if (localc != null) {}
    try
    {
      localc.g();
      com.wifi.plugin.e.b.e();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.a == null) {}
    for (;;)
    {
      return;
      c localc = this.a.b();
      if (localc != null) {
        localc.a(paramConfiguration);
      }
    }
  }
  
  public void onContentChanged()
  {
    super.onContentChanged();
    if (this.a == null) {}
    for (;;)
    {
      return;
      this.a.e().onContentChanged();
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  public CharSequence onCreateDescription()
  {
    if (this.a == null) {}
    for (CharSequence localCharSequence = super.onCreateDescription();; localCharSequence = this.a.e().onCreateDescription()) {
      return localCharSequence;
    }
  }
  
  public View onCreatePanelView(int paramInt)
  {
    if (this.a == null) {}
    for (View localView = super.onCreatePanelView(paramInt);; localView = this.a.e().onCreatePanelView(paramInt)) {
      return localView;
    }
  }
  
  public boolean onCreateThumbnail(Bitmap paramBitmap, Canvas paramCanvas)
  {
    if (this.a == null) {}
    for (boolean bool = super.onCreateThumbnail(paramBitmap, paramCanvas);; bool = this.a.e().onCreateThumbnail(paramBitmap, paramCanvas)) {
      return bool;
    }
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (this.a == null) {
      paramView = super.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
    }
    for (;;)
    {
      return paramView;
      c localc = this.a.b();
      if (localc != null) {
        paramView = localc.a(paramView, paramString, paramContext, paramAttributeSet);
      } else {
        paramView = super.onCreateView(paramView, paramString, paramContext, paramAttributeSet);
      }
    }
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (this.a == null) {
      paramString = super.onCreateView(paramString, paramContext, paramAttributeSet);
    }
    for (;;)
    {
      return paramString;
      c localc = this.a.b();
      if (localc != null) {
        paramString = localc.a(paramString, paramContext, paramAttributeSet);
      } else {
        paramString = super.onCreateView(paramString, paramContext, paramAttributeSet);
      }
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.a == null) {}
    for (;;)
    {
      return;
      c localc = this.a.b();
      if (localc != null) {
        try
        {
          localc.c();
          com.wifi.plugin.e.b.f();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    if (this.a == null) {}
    for (;;)
    {
      return;
      c localc = this.a.b();
      if (localc != null) {
        localc.i();
      }
      super.onDetachedFromWindow();
    }
  }
  
  public boolean onGenericMotionEvent(MotionEvent paramMotionEvent)
  {
    if (this.a == null) {}
    for (boolean bool = super.onGenericMotionEvent(paramMotionEvent);; bool = this.a.e().onGenericMotionEvent(paramMotionEvent)) {
      return bool;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if (this.a == null) {
      bool = super.onKeyDown(paramInt, paramKeyEvent);
    }
    for (;;)
    {
      return bool;
      c localc = this.a.b();
      if (localc != null)
      {
        com.wifi.plugin.e.b.a(paramInt, paramKeyEvent);
        bool = localc.a(paramInt, paramKeyEvent);
      }
      else
      {
        bool = super.onKeyDown(paramInt, paramKeyEvent);
      }
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.a == null) {}
    for (boolean bool = super.onKeyUp(paramInt, paramKeyEvent);; bool = this.a.e().onKeyUp(paramInt, paramKeyEvent)) {
      return bool;
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    if (this.a == null) {}
    for (;;)
    {
      return;
      c localc = this.a.b();
      if (localc != null) {
        localc.a(paramIntent);
      }
    }
  }
  
  public void onOptionsMenuClosed(Menu paramMenu)
  {
    super.onOptionsMenuClosed(paramMenu);
    if (this.a == null) {}
    for (;;)
    {
      return;
      this.a.e().onOptionsMenuClosed(paramMenu);
    }
  }
  
  public void onPanelClosed(int paramInt, Menu paramMenu)
  {
    super.onPanelClosed(paramInt, paramMenu);
    if (this.a == null) {}
    for (;;)
    {
      return;
      this.a.e().onPanelClosed(paramInt, paramMenu);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    if (this.a == null) {}
    for (;;)
    {
      return;
      c localc = this.a.b();
      if (localc != null) {
        try
        {
          localc.f();
          com.wifi.plugin.e.b.g();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    if (this.a == null) {}
    for (;;)
    {
      return;
      c localc = this.a.b();
      if (localc != null) {
        localc.h();
      }
    }
  }
  
  protected void onRestart()
  {
    super.onRestart();
    if (this.a == null) {}
    for (;;)
    {
      return;
      c localc = this.a.b();
      if (localc != null) {
        try
        {
          localc.e();
          com.wifi.plugin.e.b.d();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (this.a == null) {}
    for (;;)
    {
      return;
      c localc = this.a.b();
      if (localc != null)
      {
        localc.b();
        com.wifi.plugin.e.b.c();
      }
    }
  }
  
  protected void onStart()
  {
    super.onStart();
    if (this.a == null) {}
    for (;;)
    {
      return;
      c localc = this.a.b();
      if (localc != null) {
        try
        {
          localc.a();
          com.wifi.plugin.e.b.a();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    if (this.a == null) {}
    for (;;)
    {
      return;
      c localc = this.a.b();
      if (localc != null) {
        try
        {
          localc.d();
          com.wifi.plugin.e.b.b();
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public ComponentName startService(Intent paramIntent)
  {
    return super.startService(paramIntent);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/plugin/BLActivityProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */