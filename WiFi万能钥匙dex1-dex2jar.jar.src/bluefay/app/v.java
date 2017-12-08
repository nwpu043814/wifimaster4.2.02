package bluefay.app;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import com.bluefay.a.e;

public final class v
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
    for (;;)
    {
      try
      {
        localObject = e.a("android.os.SystemProperties", "get", new Object[] { "qemu.hw.mainkeys" });
        if ((localObject instanceof String))
        {
          localObject = (String)localObject;
          a = (String)localObject;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        a = null;
        continue;
      }
      localObject = "";
    }
  }
  
  public v(Activity paramActivity)
  {
    Object localObject = paramActivity.getWindow();
    ViewGroup localViewGroup = (ViewGroup)((Window)localObject).getDecorView();
    if (Build.VERSION.SDK_INT >= 19)
    {
      localObject = ((Window)localObject).getAttributes();
      if ((((WindowManager.LayoutParams)localObject).flags & 0x4000000) != 0) {
        this.c = true;
      }
      if ((((WindowManager.LayoutParams)localObject).flags & 0x8000000) != 0) {
        this.d = true;
      }
    }
    this.b = new a(paramActivity, this.c, this.d, (byte)0);
    if (!this.b.c()) {
      this.d = false;
    }
    if (this.c)
    {
      this.f = new View(paramActivity);
      localObject = new FrameLayout.LayoutParams(-1, this.b.b());
      ((FrameLayout.LayoutParams)localObject).gravity = 48;
      if ((this.d) && (!this.b.a())) {
        ((FrameLayout.LayoutParams)localObject).rightMargin = this.b.e();
      }
      this.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.f.setBackgroundColor(-1728053248);
      this.f.setVisibility(8);
      localViewGroup.addView(this.f);
    }
    if (this.d)
    {
      this.g = new View(paramActivity);
      if (!this.b.a()) {
        break label285;
      }
      paramActivity = new FrameLayout.LayoutParams(-1, this.b.d());
    }
    for (paramActivity.gravity = 80;; paramActivity.gravity = 5)
    {
      this.g.setLayoutParams(paramActivity);
      this.g.setBackgroundColor(-1728053248);
      this.g.setVisibility(8);
      localViewGroup.addView(this.g);
      return;
      label285:
      paramActivity = new FrameLayout.LayoutParams(this.b.e(), -1);
    }
  }
  
  public final void a()
  {
    this.e = true;
    if (this.c) {
      this.f.setVisibility(0);
    }
  }
  
  public final void a(int paramInt)
  {
    if (this.c) {
      this.f.setBackgroundResource(paramInt);
    }
  }
  
  public final a b()
  {
    return this.b;
  }
  
  public static final class a
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
      Object localObject1 = paramActivity.getResources();
      boolean bool1;
      Object localObject2;
      if (((Resources)localObject1).getConfiguration().orientation == 1)
      {
        bool1 = true;
        this.h = bool1;
        localObject2 = new DisplayMetrics();
        if (Build.VERSION.SDK_INT < 16) {
          break label287;
        }
        e.a(paramActivity.getWindowManager().getDefaultDisplay(), "getRealMetrics", new Object[] { localObject2 });
        label75:
        this.i = Math.min(((DisplayMetrics)localObject2).widthPixels / ((DisplayMetrics)localObject2).density, ((DisplayMetrics)localObject2).heightPixels / ((DisplayMetrics)localObject2).density);
        this.c = a((Resources)localObject1, "status_bar_height");
        if (Build.VERSION.SDK_INT < 14) {
          break label329;
        }
        localObject1 = new TypedValue();
        paramActivity.getTheme().resolveAttribute(16843499, (TypedValue)localObject1, true);
      }
      label202:
      label211:
      label247:
      label287:
      label317:
      label323:
      label329:
      for (int j = TypedValue.complexToDimensionPixelSize(((TypedValue)localObject1).data, paramActivity.getResources().getDisplayMetrics());; j = 0)
      {
        this.d = j;
        localObject2 = paramActivity.getResources();
        if ((Build.VERSION.SDK_INT >= 14) && (a(paramActivity))) {
          if (this.h)
          {
            localObject1 = "navigation_bar_height";
            j = a((Resources)localObject2, (String)localObject1);
            this.f = j;
            localObject1 = paramActivity.getResources();
            if ((Build.VERSION.SDK_INT < 14) || (!a(paramActivity))) {
              break label317;
            }
            j = a((Resources)localObject1, "navigation_bar_width");
            this.g = j;
            if (this.f <= 0) {
              break label323;
            }
          }
        }
        for (bool1 = bool2;; bool1 = false)
        {
          this.e = bool1;
          this.a = paramBoolean1;
          this.b = paramBoolean2;
          return;
          bool1 = false;
          break;
          paramActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
          break label75;
          localObject1 = "navigation_bar_height_landscape";
          break label202;
          j = 0;
          break label211;
          j = 0;
          break label247;
        }
      }
    }
    
    private static int a(Resources paramResources, String paramString)
    {
      int j = 0;
      int k = paramResources.getIdentifier(paramString, "dimen", "android");
      if (k > 0) {
        j = paramResources.getDimensionPixelSize(k);
      }
      return j;
    }
    
    private static boolean a(Context paramContext)
    {
      boolean bool2 = false;
      Resources localResources = paramContext.getResources();
      int j = localResources.getIdentifier("config_showNavigationBar", "bool", "android");
      boolean bool1;
      if (j != 0)
      {
        bool1 = localResources.getBoolean(j);
        if ("1".equals(v.c())) {
          bool1 = bool2;
        }
      }
      for (;;)
      {
        return bool1;
        if ("0".equals(v.c()))
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
    
    public final boolean a()
    {
      if ((this.i >= 600.0F) || (this.h)) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public final int b()
    {
      return this.c;
    }
    
    public final boolean c()
    {
      return this.e;
    }
    
    public final int d()
    {
      return this.f;
    }
    
    public final int e()
    {
      return this.g;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/app/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */