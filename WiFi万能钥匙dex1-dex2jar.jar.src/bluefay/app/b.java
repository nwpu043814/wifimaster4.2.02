package bluefay.app;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.PopupWindow;
import com.bluefay.b.h;
import com.bluefay.framework.R.dimen;
import com.bluefay.widget.CompactMenuView;

public class b
  extends Activity
{
  public static int a = 0;
  public static int b = 1;
  public static int c = 2;
  public static int d = 3;
  private t e;
  private PopupWindow f;
  private boolean g;
  
  protected final void a()
  {
    Window localWindow = getWindow();
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.flags |= 0x4000000;
    localWindow.setAttributes(localLayoutParams);
  }
  
  public final void a(Menu paramMenu, View paramView)
  {
    CompactMenuView localCompactMenuView = new CompactMenuView(this);
    localCompactMenuView.a(paramMenu);
    localCompactMenuView.a(new d(this));
    localCompactMenuView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    localCompactMenuView.measure(-2, -2);
    h.a("width:" + localCompactMenuView.getMeasuredWidth() + " height:" + localCompactMenuView.getMeasuredHeight(), new Object[0]);
    int i = getResources().getDimensionPixelSize(R.dimen.framework_compact_menu_y_offset);
    this.f = new PopupWindow(this);
    this.f.setBackgroundDrawable(new BitmapDrawable(getResources()));
    this.f.setContentView(localCompactMenuView);
    this.f.setWidth(-2);
    this.f.setHeight(-2);
    this.f.setFocusable(true);
    this.f.setOutsideTouchable(true);
    this.f.showAsDropDown(paramView, 0, -i);
  }
  
  protected boolean b()
  {
    boolean bool = false;
    if ("SD4930UR".equals(Build.MODEL)) {}
    for (;;)
    {
      return bool;
      if (com.bluefay.a.c.b()) {
        bool = true;
      }
    }
  }
  
  public final boolean c()
  {
    return this.g;
  }
  
  public void closeOptionsMenu()
  {
    h.a("closeOptionsMenu", new Object[0]);
    super.closeOptionsMenu();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    h.a("onCreate", new Object[0]);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    h.a("onCreateContextMenu:" + paramContextMenu, new Object[0]);
    super.onCreateContextMenu(paramContextMenu, paramView, paramContextMenuInfo);
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    h.a("onCreateOptionsMenu:" + paramMenu, new Object[0]);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  protected void onDestroy()
  {
    this.g = true;
    super.onDestroy();
    h.a("onDestroy", new Object[0]);
  }
  
  public void onLowMemory()
  {
    super.onLowMemory();
  }
  
  public boolean onMenuOpened(int paramInt, Menu paramMenu)
  {
    h.a("onMenuOpened:" + paramMenu, new Object[0]);
    if ((paramMenu != null) && (paramMenu.size() > 0))
    {
      this.e = new t(getBaseContext(), paramMenu);
      paramMenu = new k.a(this);
      paramMenu.a(this.e, new c(this));
      paramMenu.c().show();
    }
    return false;
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    h.a("onPrepareOptionsMenu:" + paramMenu, new Object[0]);
    return super.onPrepareOptionsMenu(paramMenu);
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onStart()
  {
    super.onStart();
  }
  
  protected void onStop()
  {
    super.onStop();
  }
  
  public void openOptionsMenu()
  {
    h.a("openOptionsMenu", new Object[0]);
    super.openOptionsMenu();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/app/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */