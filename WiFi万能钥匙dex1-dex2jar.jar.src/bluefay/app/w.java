package bluefay.app;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout.LayoutParams;
import bluefay.b.a;
import com.bluefay.framework.R.color;
import com.bluefay.framework.R.drawable;
import com.bluefay.framework.R.id;
import com.bluefay.framework.R.layout;
import com.bluefay.widget.ActionTopBarView;
import com.bluefay.widget.TabBarView;
import com.bluefay.widget.g;
import java.util.ArrayList;

public class w
  extends b
  implements o, p, com.bluefay.widget.h
{
  protected ArrayList<Fragment> e;
  private ActionTopBarView f;
  private t g;
  private TabBarView h;
  private v i;
  private com.bluefay.widget.b j = new x(this);
  
  public final int a(String paramString)
  {
    return this.h.b(paramString);
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == a) && (this.f != null)) {
      this.f.setVisibility(paramInt2);
    }
  }
  
  public final void a(int paramInt, g paramg)
  {
    this.h.a(paramInt, paramg);
  }
  
  public final void a(g paramg)
  {
    paramg = paramg.d();
    if ((paramg != null) && ((paramg instanceof q))) {
      ((q)paramg).c(this);
    }
  }
  
  public void a(g paramg, FragmentTransaction paramFragmentTransaction)
  {
    Fragment localFragment = paramg.d();
    if (localFragment == null)
    {
      localFragment = paramg.e();
      if (localFragment != null)
      {
        this.e.add(localFragment);
        paramFragmentTransaction.add(R.id.fragment_container, localFragment, paramg.c());
        if ((localFragment instanceof q)) {
          ((q)localFragment).a(this);
        }
      }
    }
    for (;;)
    {
      return;
      paramFragmentTransaction.show(localFragment);
      if ((localFragment instanceof q)) {
        ((q)localFragment).a(this);
      }
    }
  }
  
  public final void a(String paramString, int paramInt)
  {
    this.h.a(paramString, paramInt);
  }
  
  public final void a(String paramString1, Drawable paramDrawable, String paramString2, String paramString3, Bundle paramBundle)
  {
    paramString2 = new g(this, paramString2, paramString3, paramBundle);
    paramString2.a(paramDrawable);
    paramString2.a(paramString1);
    this.h.a(paramString2);
  }
  
  public final void a(String paramString, Bundle paramBundle) {}
  
  public final void a(String paramString1, String paramString2)
  {
    this.h.a(paramString1, paramString2);
  }
  
  public final boolean a(int paramInt, Menu paramMenu)
  {
    boolean bool = false;
    if (paramInt == a)
    {
      com.bluefay.b.h.a("onCreateActionBottomMenu:" + paramMenu, new Object[0]);
      if (paramMenu != null)
      {
        this.g = new t(getBaseContext(), paramMenu);
        this.f.a(this.g);
      }
      bool = true;
    }
    return bool;
  }
  
  public final void b(g paramg, FragmentTransaction paramFragmentTransaction)
  {
    Fragment localFragment = paramg.d();
    if (localFragment != null)
    {
      paramFragmentTransaction.hide(paramg.d());
      if ((localFragment instanceof q)) {
        ((q)localFragment).b(this);
      }
    }
  }
  
  public final void b(String paramString)
  {
    if (!c()) {
      this.h.c(paramString);
    }
  }
  
  public final boolean b(int paramInt, Menu paramMenu)
  {
    if (paramInt == a) {
      if ((this.g != null) && (this.f != null))
      {
        this.g.a(paramMenu);
        this.f.b(this.g);
      }
    }
    for (boolean bool = false;; bool = true)
    {
      return bool;
      if (paramInt != b) {
        break;
      }
    }
  }
  
  public final void c(int paramInt)
  {
    this.f.f(paramInt);
  }
  
  public final void c(String paramString)
  {
    this.h.a(paramString);
  }
  
  public final Fragment d()
  {
    if (this.h.a() != null) {}
    for (Fragment localFragment = this.h.a().d();; localFragment = null) {
      return localFragment;
    }
  }
  
  public final void e()
  {
    this.f.b();
  }
  
  public final ActionTopBarView f()
  {
    return this.f;
  }
  
  public final void g()
  {
    this.f.setBackgroundResource(R.drawable.framework_actionbar_bg_dark);
    this.f.a(getResources().getColorStateList(R.color.framework_title_color_white));
    this.f.f(R.drawable.framework_title_bar_back_button_white);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.bluefay.b.h.b("onActivityResult requestCode:%d, resultCode:%d, data:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.e = new ArrayList();
    setContentView(R.layout.framework_tab_activity);
    this.h = ((TabBarView)findViewById(R.id.tabbar));
    this.h.a(getFragmentManager());
    this.h.a(this);
    this.f = ((ActionTopBarView)findViewById(R.id.actiontopbar));
    this.f.a(this.j);
    if (b())
    {
      a();
      this.i = new v(this);
      this.i.a();
      this.i.a(R.color.framework_primary_color);
      paramBundle = new LinearLayout.LayoutParams(-1, -2);
      paramBundle.topMargin = this.i.b().b();
      this.f.setLayoutParams(paramBundle);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool;
    if (paramInt == 4) {
      if (!onMenuItemSelected(0, new a(17039360))) {
        bool = super.onKeyDown(paramInt, paramKeyEvent);
      }
    }
    for (;;)
    {
      return bool;
      bool = true;
      continue;
      bool = super.onKeyDown(paramInt, paramKeyEvent);
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int k = paramMenuItem.getItemId();
    com.bluefay.b.h.a("onOptionsItemSelected id:" + k);
    if (k == 16908332) {
      onBackPressed();
    }
    for (boolean bool = true;; bool = super.onOptionsItemSelected(paramMenuItem)) {
      return bool;
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    com.bluefay.b.h.a("onRestoreInstanceState", new Object[0]);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if ((paramBundle != null) && (paramBundle.containsKey("android:fragments"))) {
      paramBundle.remove("android:fragments");
    }
  }
  
  public void setTitle(int paramInt)
  {
    this.f.h(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.f.a(paramCharSequence);
  }
  
  public void setTitleColor(int paramInt)
  {
    this.f.i(paramInt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/app/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */