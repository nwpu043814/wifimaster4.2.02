package bluefay.app;

import android.app.Fragment;
import android.app.Fragment.InstantiationException;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import bluefay.b.a;
import com.bluefay.b.h;
import com.bluefay.framework.R.animator;
import com.bluefay.framework.R.color;
import com.bluefay.framework.R.drawable;
import com.bluefay.framework.R.id;
import com.bluefay.framework.R.layout;
import com.bluefay.widget.ActionBottomBarView;
import com.bluefay.widget.ActionTopBarView;

public class m
  extends b
  implements o, p
{
  private ActionTopBarView e;
  private ActionBottomBarView f;
  private t g;
  private t h;
  private View i;
  private ViewGroup j;
  private boolean k;
  private boolean l;
  private v m;
  private com.bluefay.widget.b n = new n(this);
  
  private void a(View paramView)
  {
    this.j.addView(paramView);
  }
  
  public final void a(int paramInt)
  {
    a(getLayoutInflater().inflate(paramInt, this.j, false));
  }
  
  public final void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == a) {
      if (this.e != null) {
        this.e.setVisibility(paramInt2);
      }
    }
    for (;;)
    {
      return;
      if ((paramInt1 == b) && (this.f != null)) {
        this.f.setVisibility(paramInt2);
      }
    }
  }
  
  public final void a(String paramString, Bundle paramBundle)
  {
    a(paramString, paramBundle, true);
  }
  
  public final void a(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    h.a("add:" + paramString, new Object[0]);
    try
    {
      localFragment = Fragment.instantiate(this, paramString, paramBundle);
      paramBundle = getFragmentManager().beginTransaction();
      paramBundle.setTransition(4097);
      if (!this.k) {
        break label100;
      }
      if (!paramBoolean) {
        break label86;
      }
      paramBundle.replace(R.id.fragment_container, localFragment, paramString);
    }
    catch (Fragment.InstantiationException paramString)
    {
      for (;;)
      {
        Fragment localFragment;
        h.c(paramString.getMessage());
        continue;
        paramBundle.replace(R.id.left_fragment_container, localFragment, paramString);
        continue;
        if (paramBoolean) {
          paramBundle.setCustomAnimations(R.animator.framework_fragment_slide_left_enter_no_alpha, R.animator.framework_fragment_slide_left_exit_no_alpha, R.animator.framework_fragment_slide_right_enter_no_alpha, R.animator.framework_fragment_slide_right_exit_no_alpha);
        }
        paramBundle.replace(R.id.fragment_container, localFragment, paramString);
        if (paramBoolean) {
          paramBundle.addToBackStack(":android:fragment");
        }
      }
    }
    paramBundle.commitAllowingStateLoss();
  }
  
  public final boolean a(int paramInt, Menu paramMenu)
  {
    boolean bool2 = true;
    h.a("createPanel:" + paramMenu, new Object[0]);
    boolean bool1;
    if (paramInt == a)
    {
      bool1 = bool2;
      if (paramMenu != null)
      {
        this.g = new t(getBaseContext(), paramMenu);
        this.e.a(this.g);
        bool1 = bool2;
      }
    }
    for (;;)
    {
      return bool1;
      if (paramInt == b)
      {
        bool1 = bool2;
        if (paramMenu != null)
        {
          this.h = new t(getBaseContext(), paramMenu);
          this.f.a(this.h);
          bool1 = bool2;
        }
      }
      else
      {
        bool1 = false;
      }
    }
  }
  
  public final void b(int paramInt)
  {
    this.e.setBackgroundResource(paramInt);
    if ((b()) && (this.m != null)) {
      this.m.a(paramInt);
    }
  }
  
  public final boolean b(int paramInt, Menu paramMenu)
  {
    if (paramInt == a) {
      if ((this.g != null) && (this.e != null))
      {
        this.g.a(paramMenu);
        this.e.b(this.g);
      }
    }
    for (boolean bool = false;; bool = true)
    {
      return bool;
      if (paramInt != b) {
        break;
      }
      if ((this.h != null) && (this.f != null))
      {
        this.h.a(paramMenu);
        this.f.b(this.h);
      }
    }
  }
  
  public final void c(int paramInt)
  {
    this.e.f(paramInt);
  }
  
  public final ActionTopBarView d()
  {
    return this.e;
  }
  
  public final void e()
  {
    this.e.setBackgroundResource(R.drawable.framework_actionbar_bg_dark);
    this.e.a(getResources().getColorStateList(R.color.framework_title_color_white));
    this.e.f(R.drawable.framework_title_bar_back_button_white);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    h.b("onActivityResult requestCode:%d, resultCode:%d, data:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramIntent });
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (this.l)
    {
      if (paramConfiguration.orientation != 2) {
        break label82;
      }
      paramConfiguration = new LinearLayout.LayoutParams(-1, -1);
      paramConfiguration.weight = 3.0F;
      this.i.setLayoutParams(paramConfiguration);
      this.i.setVisibility(0);
      paramConfiguration = new LinearLayout.LayoutParams(-1, -1);
      paramConfiguration.weight = 2.0F;
      this.j.setLayoutParams(paramConfiguration);
      this.k = true;
    }
    for (;;)
    {
      return;
      label82:
      if (paramConfiguration.orientation == 1)
      {
        paramConfiguration = new LinearLayout.LayoutParams(-1, -1);
        paramConfiguration.weight = 0.0F;
        this.i.setLayoutParams(paramConfiguration);
        this.i.setVisibility(8);
        paramConfiguration = new LinearLayout.LayoutParams(-1, -1);
        paramConfiguration.weight = 0.0F;
        this.j.setLayoutParams(paramConfiguration);
        this.k = false;
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.framework_fragment_activity);
    this.e = ((ActionTopBarView)findViewById(R.id.actiontopbar));
    this.e.a();
    this.f = ((ActionBottomBarView)findViewById(R.id.actionbottombar));
    this.f.a(this.n);
    this.e.a(this.n);
    if (b())
    {
      a();
      this.m = new v(this);
      this.m.a();
      this.m.a(R.color.framework_primary_color);
      paramBundle = new LinearLayout.LayoutParams(-1, -2);
      paramBundle.topMargin = this.m.b().b();
      this.e.setLayoutParams(paramBundle);
    }
    this.i = findViewById(R.id.left_fragment_container);
    this.j = ((ViewGroup)findViewById(R.id.fragment_container));
    paramBundle = getIntent();
    if (paramBundle.hasExtra("fragment")) {
      a(paramBundle.getStringExtra("fragment"), paramBundle.getBundleExtra("args"), false);
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
    int i1 = paramMenuItem.getItemId();
    h.a("onOptionsItemSelected id:" + i1);
    if (i1 == 16908332) {
      onBackPressed();
    }
    for (boolean bool = true;; bool = super.onOptionsItemSelected(paramMenuItem)) {
      return bool;
    }
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if ((paramBundle != null) && (paramBundle.containsKey("android:fragments"))) {
      paramBundle.remove("android:fragments");
    }
  }
  
  public void setCustomContentView(View paramView)
  {
    a(paramView);
  }
  
  public void setTitle(int paramInt)
  {
    this.e.h(paramInt);
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.e.a(paramCharSequence);
  }
  
  public void setTitleColor(int paramInt)
  {
    this.e.i(paramInt);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/app/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */