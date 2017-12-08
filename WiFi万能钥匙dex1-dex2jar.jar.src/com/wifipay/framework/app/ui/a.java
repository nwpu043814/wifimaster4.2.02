package com.wifipay.framework.app.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.wifipay.common.eventbus.EventBus;
import com.wifipay.framework.widget.WPAlertDialog.onNegativeListener;
import com.wifipay.framework.widget.WPAlertDialog.onPositiveListener;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class a
{
  private Activity a;
  private d b;
  
  public a(Activity paramActivity)
  {
    this.a = paramActivity;
    EventBus.getDefault().register(paramActivity);
    this.b = new d(paramActivity);
  }
  
  private void a(View paramView)
  {
    if (paramView == null) {}
    for (;;)
    {
      return;
      if ((paramView instanceof ViewGroup))
      {
        localObject = (ViewGroup)paramView;
        int j = ((ViewGroup)localObject).getChildCount();
        for (int i = 0; i < j; i++) {
          a(((ViewGroup)localObject).getChildAt(i));
        }
      }
      Object localObject = paramView.getBackground();
      if (localObject != null) {
        ((Drawable)localObject).setCallback(null);
      }
      paramView.setBackgroundDrawable(null);
      paramView.destroyDrawingCache();
      if ((paramView instanceof ImageView))
      {
        localObject = ((ImageView)paramView).getDrawable();
        if (localObject != null) {
          ((Drawable)localObject).setCallback(null);
        }
        ((ImageView)paramView).setImageDrawable(null);
      }
      else if ((paramView instanceof TextView))
      {
        ((TextView)paramView).setCompoundDrawables(null, null, null, null);
      }
    }
  }
  
  private void f()
  {
    a(((ViewGroup)this.a.findViewById(16908290)).getChildAt(0));
  }
  
  public void a()
  {
    if (EventBus.getDefault().isRegistered(this.a)) {
      EventBus.getDefault().unregister(this.a);
    }
    try
    {
      Class localClass = Class.forName("android.text.TextLine");
      Field localField = localClass.getDeclaredField("sCached");
      localField.setAccessible(true);
      localField.set(null, Array.newInstance(localClass, 3));
      f();
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
  
  protected void a(Intent paramIntent) {}
  
  public void a(String paramString)
  {
    this.b.a(paramString);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, WPAlertDialog.onPositiveListener paramonPositiveListener, String paramString4, WPAlertDialog.onNegativeListener paramonNegativeListener)
  {
    this.b.a(paramString1, paramString2, paramString3, paramonPositiveListener, paramString4, paramonNegativeListener);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, WPAlertDialog.onPositiveListener paramonPositiveListener, String paramString4, WPAlertDialog.onNegativeListener paramonNegativeListener, boolean paramBoolean, View paramView)
  {
    this.b.a(paramString1, paramString2, paramString3, paramonPositiveListener, paramString4, paramonNegativeListener, paramBoolean, paramView);
  }
  
  public void b() {}
  
  public void c()
  {
    this.b.a();
  }
  
  public void d()
  {
    this.b.a();
  }
  
  public void e()
  {
    this.b.b();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/app/ui/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */