package bluefay.app;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import com.bluefay.framework.R.style;

public class k
  extends Dialog
  implements DialogInterface
{
  private e a;
  private boolean b;
  
  protected k(Context paramContext)
  {
    this(paramContext, a(0));
  }
  
  public k(Context paramContext, int paramInt)
  {
    super(paramContext, a(paramInt));
    if (paramInt == R.style.BL_Theme_Light_Dialog_Alert_Bottom) {
      this.b = true;
    }
    this.a = new e(getContext(), this, getWindow());
    if (this.b) {
      getWindow().setGravity(80);
    }
  }
  
  static int a(int paramInt)
  {
    int i = paramInt;
    if (paramInt <= 0) {
      i = R.style.BL_Theme_Light_Dialog_Alert;
    }
    return i;
  }
  
  public final Button a()
  {
    return this.a.c();
  }
  
  public final void a(int paramInt, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.a.a(paramInt, paramCharSequence, paramOnClickListener, null);
  }
  
  public final void a(Drawable paramDrawable)
  {
    this.a.a(paramDrawable);
  }
  
  public final void a(View paramView)
  {
    this.a.b(paramView);
  }
  
  public final void b()
  {
    this.a.b();
  }
  
  public final void b(int paramInt)
  {
    this.a.a(paramInt);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.a.a();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.a.a(paramKeyEvent)) {}
    for (boolean bool = true;; bool = super.onKeyDown(paramInt, paramKeyEvent)) {
      return bool;
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.a.b(paramKeyEvent)) {}
    for (boolean bool = true;; bool = super.onKeyUp(paramInt, paramKeyEvent)) {
      return bool;
    }
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.a.a(paramCharSequence);
  }
  
  public void show()
  {
    super.show();
  }
  
  public static final class a
  {
    private final e.a a;
    private int b;
    
    public a(Context paramContext)
    {
      this(paramContext, k.a(0));
    }
    
    public a(Context paramContext, int paramInt)
    {
      this.a = new e.a(new ContextThemeWrapper(paramContext, k.a(paramInt)));
      this.b = paramInt;
    }
    
    public final Context a()
    {
      return this.a.a;
    }
    
    public final a a(int paramInt)
    {
      this.a.f = this.a.a.getText(paramInt);
      return this;
    }
    
    public final a a(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.i = this.a.a.getText(paramInt);
      this.a.j = paramOnClickListener;
      return this;
    }
    
    public final a a(DialogInterface.OnCancelListener paramOnCancelListener)
    {
      this.a.p = paramOnCancelListener;
      return this;
    }
    
    public final a a(Drawable paramDrawable)
    {
      this.a.d = paramDrawable;
      return this;
    }
    
    public final a a(View paramView)
    {
      this.a.v = paramView;
      this.a.A = false;
      return this;
    }
    
    public final a a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.a.v = paramView;
      this.a.A = true;
      this.a.w = paramInt1;
      this.a.x = paramInt2;
      this.a.y = paramInt3;
      this.a.z = paramInt4;
      return this;
    }
    
    public final a a(ListAdapter paramListAdapter, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.t = paramListAdapter;
      this.a.u = paramOnClickListener;
      return this;
    }
    
    public final a a(CharSequence paramCharSequence)
    {
      this.a.f = paramCharSequence;
      return this;
    }
    
    public final a a(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.i = paramCharSequence;
      this.a.j = paramOnClickListener;
      return this;
    }
    
    public final a a(CharSequence[] paramArrayOfCharSequence, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.s = paramArrayOfCharSequence;
      this.a.u = paramOnClickListener;
      this.a.E = paramInt;
      this.a.D = true;
      return this;
    }
    
    public final a a(CharSequence[] paramArrayOfCharSequence, boolean[] paramArrayOfBoolean, DialogInterface.OnMultiChoiceClickListener paramOnMultiChoiceClickListener)
    {
      this.a.s = paramArrayOfCharSequence;
      this.a.F = paramOnMultiChoiceClickListener;
      this.a.B = paramArrayOfBoolean;
      this.a.C = true;
      return this;
    }
    
    public final a b()
    {
      this.a.o = false;
      return this;
    }
    
    public final a b(int paramInt)
    {
      this.a.h = this.a.a.getText(paramInt);
      return this;
    }
    
    public final a b(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.k = this.a.a.getText(paramInt);
      this.a.l = paramOnClickListener;
      return this;
    }
    
    public final a b(CharSequence paramCharSequence)
    {
      this.a.h = paramCharSequence;
      return this;
    }
    
    public final a b(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
    {
      this.a.k = paramCharSequence;
      this.a.l = paramOnClickListener;
      return this;
    }
    
    public final k c()
    {
      k localk = new k(this.a.a, this.b);
      e.a locala = this.a;
      e locale = k.a(localk);
      ListView localListView;
      Object localObject;
      if (locala.g != null)
      {
        locale.a(locala.g);
        if (locala.h != null) {
          locale.b(locala.h);
        }
        if (locala.i != null) {
          locale.a(-1, locala.i, locala.j, null);
        }
        if (locala.k != null) {
          locale.a(-2, locala.k, locala.l, null);
        }
        if (locala.m != null) {
          locale.a(-3, locala.m, locala.n, null);
        }
        if (locala.J) {
          locale.b();
        }
        if ((locala.s != null) || (locala.G != null) || (locala.t != null))
        {
          localListView = (ListView)locala.b.inflate(e.i(locale), null);
          if (!locala.C) {
            break label549;
          }
          if (locala.G != null) {
            break label522;
          }
          localObject = new g(locala, locala.a, e.j(locale), locala.s, localListView);
          label243:
          e.a(locale, (ListAdapter)localObject);
          e.a(locale, locala.E);
          if (locala.u == null) {
            break label665;
          }
          localListView.setOnItemClickListener(new i(locala, locale));
          label285:
          if (locala.K != null) {
            localListView.setOnItemSelectedListener(locala.K);
          }
          if (!locala.D) {
            break label694;
          }
          localListView.setChoiceMode(1);
          label317:
          e.a(locale, localListView);
        }
        if (locala.v != null)
        {
          if (!locala.A) {
            break label711;
          }
          locale.a(locala.v, locala.w, locala.x, locala.y, locala.z);
        }
      }
      for (;;)
      {
        localk.setCancelable(this.a.o);
        if (this.a.o) {
          localk.setCanceledOnTouchOutside(true);
        }
        localk.setOnCancelListener(this.a.p);
        localk.setOnDismissListener(this.a.q);
        if (this.a.r != null) {
          localk.setOnKeyListener(this.a.r);
        }
        return localk;
        if (locala.f != null) {
          locale.a(locala.f);
        }
        if (locala.d != null) {
          locale.a(locala.d);
        }
        if (locala.c >= 0) {
          locale.a(locala.c);
        }
        if (locala.e <= 0) {
          break;
        }
        locale.a(locale.b(locala.e));
        break;
        label522:
        localObject = new h(locala, locala.a, locala.G, localListView, locale);
        break label243;
        label549:
        int i;
        if (locala.D) {
          i = e.k(locale);
        }
        for (;;)
        {
          if (locala.G == null)
          {
            if (locala.t != null)
            {
              localObject = locala.t;
              break;
              i = e.l(locale);
              continue;
            }
            localObject = new ArrayAdapter(locala.a, i, 16908308, locala.s);
            break;
          }
        }
        localObject = new SimpleCursorAdapter(locala.a, i, locala.G, new String[] { locala.H }, new int[] { 16908308 });
        break label243;
        label665:
        if (locala.F == null) {
          break label285;
        }
        localListView.setOnItemClickListener(new j(locala, localListView, locale));
        break label285;
        label694:
        if (!locala.C) {
          break label317;
        }
        localListView.setChoiceMode(2);
        break label317;
        label711:
        locale.b(locala.v);
      }
    }
    
    public final k d()
    {
      k localk = c();
      localk.show();
      return localk;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/app/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */