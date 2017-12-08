package bluefay.app;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import com.bluefay.b.h;
import com.bluefay.widget.ActionTopBarView;

public class Fragment
  extends android.app.Fragment
{
  public static int a = b.a;
  public static int b = b.b;
  public static int c = b.c;
  public static int d = b.d;
  protected Context e;
  protected boolean f;
  
  protected void a()
  {
    this.f = true;
    Activity localActivity = getActivity();
    if (localActivity != null) {}
    try
    {
      localActivity.onBackPressed();
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      for (;;)
      {
        h.a(localIllegalStateException);
      }
    }
  }
  
  protected void a(int paramInt)
  {
    if ((this.e != null) && ((this.e instanceof b))) {
      ((b)this.e).setTitle(paramInt);
    }
  }
  
  protected final void a(int paramInt1, int paramInt2, DialogInterface.OnClickListener paramOnClickListener)
  {
    if ((this.e != null) && ((this.e instanceof b)))
    {
      Object localObject = (b)this.e;
      String str2 = ((b)localObject).getString(paramInt1);
      String str1 = ((b)localObject).getString(paramInt2);
      localObject = new k.a((Context)localObject);
      ((k.a)localObject).a(str2);
      if ((str1 != null) && (str1.length() > 0)) {
        ((k.a)localObject).b(str1);
      }
      ((k.a)localObject).a(17039370, paramOnClickListener);
      ((k.a)localObject).b(17039360, null);
      ((k.a)localObject).d();
    }
  }
  
  protected void a(CharSequence paramCharSequence)
  {
    if ((this.e != null) && ((this.e instanceof b))) {
      ((b)this.e).setTitle(paramCharSequence);
    }
  }
  
  protected final boolean a(int paramInt, Menu paramMenu)
  {
    if ((this.e instanceof o)) {}
    for (boolean bool = ((o)this.e).a(paramInt, paramMenu);; bool = false) {
      return bool;
    }
  }
  
  protected final void a_(int paramInt1, int paramInt2)
  {
    if ((this.e instanceof o)) {
      ((o)this.e).a(paramInt1, paramInt2);
    }
  }
  
  public final void a_(Context paramContext)
  {
    this.e = paramContext;
  }
  
  protected final ActionTopBarView b()
  {
    ActionTopBarView localActionTopBarView;
    if (this.e != null) {
      if ((this.e instanceof m)) {
        localActionTopBarView = ((m)this.e).d();
      }
    }
    for (;;)
    {
      return localActionTopBarView;
      if ((this.e instanceof w)) {
        localActionTopBarView = ((w)this.e).f();
      } else {
        localActionTopBarView = null;
      }
    }
  }
  
  protected final void b(int paramInt)
  {
    if ((this.e != null) && ((this.e instanceof b))) {
      ((b)this.e).setTitleColor(paramInt);
    }
  }
  
  protected final boolean b(int paramInt, Menu paramMenu)
  {
    if ((this.e instanceof o)) {}
    for (boolean bool = ((o)this.e).b(paramInt, paramMenu);; bool = false) {
      return bool;
    }
  }
  
  protected final void c(int paramInt)
  {
    if ((this.e != null) && ((this.e instanceof m))) {
      ((m)this.e).b(paramInt);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.e = getActivity();
    this.f = false;
    setHasOptionsMenu(true);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/app/Fragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */