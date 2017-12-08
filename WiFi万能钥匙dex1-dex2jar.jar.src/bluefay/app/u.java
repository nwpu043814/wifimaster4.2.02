package bluefay.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import bluefay.b.a;
import java.util.ArrayList;

public final class u
  implements Menu
{
  private final Context a;
  private final Resources b;
  private ArrayList<a> c;
  
  public u(Context paramContext)
  {
    this.a = paramContext;
    this.b = this.a.getResources();
    this.c = new ArrayList();
  }
  
  public final MenuItem add(int paramInt)
  {
    return add(0, 0, 0, this.b.getString(paramInt));
  }
  
  public final MenuItem add(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return add(paramInt1, paramInt2, paramInt3, this.b.getString(paramInt4));
  }
  
  public final MenuItem add(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    a locala = new a(this.a, paramInt2);
    locala.setTitle(paramCharSequence);
    this.c.add(locala);
    return locala;
  }
  
  public final MenuItem add(CharSequence paramCharSequence)
  {
    return add(0, 0, 0, paramCharSequence);
  }
  
  public final int addIntentOptions(int paramInt1, int paramInt2, int paramInt3, ComponentName paramComponentName, Intent[] paramArrayOfIntent, Intent paramIntent, int paramInt4, MenuItem[] paramArrayOfMenuItem)
  {
    return 0;
  }
  
  public final SubMenu addSubMenu(int paramInt)
  {
    return null;
  }
  
  public final SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return null;
  }
  
  public final SubMenu addSubMenu(int paramInt1, int paramInt2, int paramInt3, CharSequence paramCharSequence)
  {
    return null;
  }
  
  public final SubMenu addSubMenu(CharSequence paramCharSequence)
  {
    return null;
  }
  
  public final void clear() {}
  
  public final void close() {}
  
  public final MenuItem findItem(int paramInt)
  {
    int j = size();
    int i = 0;
    a locala;
    if (i < j)
    {
      locala = (a)this.c.get(i);
      if (locala.getItemId() != paramInt) {}
    }
    for (;;)
    {
      return locala;
      i++;
      break;
      locala = null;
    }
  }
  
  public final MenuItem getItem(int paramInt)
  {
    return (MenuItem)this.c.get(paramInt);
  }
  
  public final boolean hasVisibleItems()
  {
    return false;
  }
  
  public final boolean isShortcutKey(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public final boolean performIdentifierAction(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public final boolean performShortcut(int paramInt1, KeyEvent paramKeyEvent, int paramInt2)
  {
    return false;
  }
  
  public final void removeGroup(int paramInt) {}
  
  public final void removeItem(int paramInt) {}
  
  public final void setGroupCheckable(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void setGroupEnabled(int paramInt, boolean paramBoolean) {}
  
  public final void setGroupVisible(int paramInt, boolean paramBoolean) {}
  
  public final void setQwertyMode(boolean paramBoolean) {}
  
  public final int size()
  {
    return this.c.size();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/app/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */