package bluefay.b;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public final class a
  implements MenuItem
{
  private CharSequence a;
  private Drawable b;
  private int c;
  private int d;
  private boolean e;
  private boolean f;
  private Context g;
  private Intent h;
  
  public a(int paramInt)
  {
    this.c = paramInt;
    this.f = true;
    this.e = true;
  }
  
  public a(Context paramContext, int paramInt)
  {
    this.g = paramContext;
    this.c = paramInt;
    this.f = true;
    this.e = true;
  }
  
  public final boolean collapseActionView()
  {
    return false;
  }
  
  public final boolean expandActionView()
  {
    return false;
  }
  
  public final ActionProvider getActionProvider()
  {
    return null;
  }
  
  public final View getActionView()
  {
    return null;
  }
  
  public final char getAlphabeticShortcut()
  {
    return '\000';
  }
  
  public final int getGroupId()
  {
    return this.d;
  }
  
  public final Drawable getIcon()
  {
    return this.b;
  }
  
  public final Intent getIntent()
  {
    return this.h;
  }
  
  public final int getItemId()
  {
    return this.c;
  }
  
  public final ContextMenu.ContextMenuInfo getMenuInfo()
  {
    return null;
  }
  
  public final char getNumericShortcut()
  {
    return '\000';
  }
  
  public final int getOrder()
  {
    return 0;
  }
  
  public final SubMenu getSubMenu()
  {
    return null;
  }
  
  public final CharSequence getTitle()
  {
    return this.a;
  }
  
  public final CharSequence getTitleCondensed()
  {
    return this.a;
  }
  
  public final boolean hasSubMenu()
  {
    return false;
  }
  
  public final boolean isActionViewExpanded()
  {
    return false;
  }
  
  public final boolean isCheckable()
  {
    return false;
  }
  
  public final boolean isChecked()
  {
    return false;
  }
  
  public final boolean isEnabled()
  {
    return this.e;
  }
  
  public final boolean isVisible()
  {
    return this.f;
  }
  
  public final MenuItem setActionProvider(ActionProvider paramActionProvider)
  {
    return null;
  }
  
  public final MenuItem setActionView(int paramInt)
  {
    return null;
  }
  
  public final MenuItem setActionView(View paramView)
  {
    return null;
  }
  
  public final MenuItem setAlphabeticShortcut(char paramChar)
  {
    return null;
  }
  
  public final MenuItem setCheckable(boolean paramBoolean)
  {
    return null;
  }
  
  public final MenuItem setChecked(boolean paramBoolean)
  {
    return null;
  }
  
  public final MenuItem setEnabled(boolean paramBoolean)
  {
    this.e = paramBoolean;
    return this;
  }
  
  public final MenuItem setIcon(int paramInt)
  {
    if (paramInt > 0) {
      this.b = this.g.getResources().getDrawable(paramInt);
    }
    return this;
  }
  
  public final MenuItem setIcon(Drawable paramDrawable)
  {
    this.b = paramDrawable;
    return this;
  }
  
  public final MenuItem setIntent(Intent paramIntent)
  {
    this.h = paramIntent;
    return this;
  }
  
  public final MenuItem setNumericShortcut(char paramChar)
  {
    return null;
  }
  
  public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener paramOnActionExpandListener)
  {
    return null;
  }
  
  public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    return null;
  }
  
  public final MenuItem setShortcut(char paramChar1, char paramChar2)
  {
    return null;
  }
  
  public final void setShowAsAction(int paramInt) {}
  
  public final MenuItem setShowAsActionFlags(int paramInt)
  {
    return null;
  }
  
  public final MenuItem setTitle(int paramInt)
  {
    if (paramInt > 0) {
      this.a = this.g.getString(paramInt);
    }
    return this;
  }
  
  public final MenuItem setTitle(CharSequence paramCharSequence)
  {
    this.a = paramCharSequence;
    return this;
  }
  
  public final MenuItem setTitleCondensed(CharSequence paramCharSequence)
  {
    this.a = paramCharSequence;
    return this;
  }
  
  public final MenuItem setVisible(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */