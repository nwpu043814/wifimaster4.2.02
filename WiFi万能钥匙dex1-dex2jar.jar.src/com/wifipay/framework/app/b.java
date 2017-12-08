package com.wifipay.framework.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import java.lang.reflect.Method;

public class b
{
  private static String a;
  private final a b;
  private boolean c;
  private boolean d;
  private boolean e;
  private View f;
  private View g;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    try
    {
      Method localMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[] { String.class });
      localMethod.setAccessible(true);
      a = (String)localMethod.invoke(null, new Object[] { "qemu.hw.mainkeys" });
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        a = null;
      }
    }
  }
  
  public b(Activity paramActivity)
  {
    Window localWindow = paramActivity.getWindow();
    ViewGroup localViewGroup = (ViewGroup)localWindow.getDecorView();
    Object localObject;
    if (Build.VERSION.SDK_INT >= 19) {
      localObject = paramActivity.obtainStyledAttributes(new int[] { 16843759, 16843760 });
    }
    try
    {
      this.c = ((TypedArray)localObject).getBoolean(0, false);
      this.d = ((TypedArray)localObject).getBoolean(1, false);
      ((TypedArray)localObject).recycle();
      localObject = localWindow.getAttributes();
      if ((((WindowManager.LayoutParams)localObject).flags & 0x4000000) != 0) {
        this.c = true;
      }
      if ((((WindowManager.LayoutParams)localObject).flags & 0x8000000) != 0) {
        this.d = true;
      }
      this.b = new a(paramActivity, this.c, this.d, null);
      if (!this.b.c()) {
        this.d = false;
      }
      if (this.c) {
        a(paramActivity, localViewGroup);
      }
      if (this.d) {
        b(paramActivity, localViewGroup);
      }
      return;
    }
    finally
    {
      ((TypedArray)localObject).recycle();
    }
  }
  
  private void a(Context paramContext, ViewGroup paramViewGroup)
  {
    this.f = new View(paramContext);
    paramContext = new FrameLayout.LayoutParams(-1, this.b.b());
    paramContext.gravity = 48;
    if ((this.d) && (!this.b.a())) {
      paramContext.rightMargin = this.b.e();
    }
    this.f.setLayoutParams(paramContext);
    this.f.setBackgroundColor(-1728053248);
    this.f.setVisibility(8);
    paramViewGroup.addView(this.f);
  }
  
  private void b(Context paramContext, ViewGroup paramViewGroup)
  {
    this.g = new View(paramContext);
    if (this.b.a()) {
      paramContext = new FrameLayout.LayoutParams(-1, this.b.d());
    }
    for (paramContext.gravity = 80;; paramContext.gravity = 5)
    {
      this.g.setLayoutParams(paramContext);
      this.g.setBackgroundColor(-1728053248);
      this.g.setVisibility(8);
      paramViewGroup.addView(this.g);
      return;
      paramContext = new FrameLayout.LayoutParams(this.b.e(), -1);
    }
  }
  
  public void a(int paramInt)
  {
    if (this.c) {
      this.f.setBackgroundColor(paramInt);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
    View localView;
    if (this.c)
    {
      localView = this.f;
      if (!paramBoolean) {
        break label29;
      }
    }
    label29:
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void b(int paramInt)
  {
    if (this.c) {
      this.f.setBackgroundResource(paramInt);
    }
  }
  
  public static class a
  {
    private final boolean a;
    private final boolean b;
    private final int c;
    private final int d;
    private final boolean e;
    private final int f;
    private final int g;
    private final boolean h;
    private final float i;
    
    private a(Activity paramActivity, boolean paramBoolean1, boolean paramBoolean2)
    {
      Resources localResources = paramActivity.getResources();
      if (localResources.getConfiguration().orientation == 1)
      {
        bool1 = true;
        this.h = bool1;
        this.i = a(paramActivity);
        this.c = a(localResources, "status_bar_height");
        this.d = a(paramActivity);
        this.f = b(paramActivity);
        this.g = c(paramActivity);
        if (this.f <= 0) {
          break label116;
        }
      }
      label116:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        this.e = bool1;
        this.a = paramBoolean1;
        this.b = paramBoolean2;
        return;
        bool1 = false;
        break;
      }
    }
    
    private float a(Activity paramActivity)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      if (Build.VERSION.SDK_INT >= 16) {
        paramActivity.getWindowManager().getDefaultDisplay().getRealMetrics(localDisplayMetrics);
      }
      for (;;)
      {
        return Math.min(localDisplayMetrics.widthPixels / localDisplayMetrics.density, localDisplayMetrics.heightPixels / localDisplayMetrics.density);
        paramActivity.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
      }
    }
    
    private int a(Context paramContext)
    {
      int j = 0;
      if (Build.VERSION.SDK_INT >= 14)
      {
        TypedValue localTypedValue = new TypedValue();
        paramContext.getTheme().resolveAttribute(16843499, localTypedValue, true);
        j = TypedValue.complexToDimensionPixelSize(localTypedValue.data, paramContext.getResources().getDisplayMetrics());
      }
      return j;
    }
    
    private int a(Resources paramResources, String paramString)
    {
      int j = 0;
      int k = paramResources.getIdentifier(paramString, "dimen", "android");
      if (k > 0) {
        j = paramResources.getDimensionPixelSize(k);
      }
      return j;
    }
    
    private int b(Context paramContext)
    {
      Resources localResources = paramContext.getResources();
      if ((Build.VERSION.SDK_INT >= 14) && (d(paramContext))) {
        if (this.h) {
          paramContext = "navigation_bar_height";
        }
      }
      for (int j = a(localResources, paramContext);; j = 0)
      {
        return j;
        paramContext = "navigation_bar_height_landscape";
        break;
      }
    }
    
    private int c(Context paramContext)
    {
      Resources localResources = paramContext.getResources();
      if ((Build.VERSION.SDK_INT >= 14) && (d(paramContext))) {}
      for (int j = a(localResources, "navigation_bar_width");; j = 0) {
        return j;
      }
    }
    
    private boolean d(Context paramContext)
    {
      boolean bool2 = false;
      Resources localResources = paramContext.getResources();
      int j = localResources.getIdentifier("config_showNavigationBar", "bool", "android");
      boolean bool1;
      if (j != 0)
      {
        bool1 = localResources.getBoolean(j);
        if ("1".equals(b.a())) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        return bool1;
        if ("0".equals(b.a()))
        {
          bool1 = true;
          continue;
          bool1 = bool2;
          if (!ViewConfiguration.get(paramContext).hasPermanentMenuKey()) {
            bool1 = true;
          }
        }
      }
    }
    
    public boolean a()
    {
      if ((this.i >= 600.0F) || (this.h)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public int b()
    {
      return this.c;
    }
    
    public boolean c()
    {
      return this.e;
    }
    
    public int d()
    {
      return this.f;
    }
    
    public int e()
    {
      return this.g;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/app/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */