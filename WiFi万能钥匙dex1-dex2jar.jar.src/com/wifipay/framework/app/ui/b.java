package com.wifipay.framework.app.ui;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class b
{
  private static boolean c = false;
  private static final ArrayList<b> d = new ArrayList();
  private Toast a;
  private int b;
  private Object e;
  private Method f;
  private Method g;
  private View h;
  private TextView i;
  private Handler j = new Handler();
  private Runnable k = new c(this);
  
  public b(Context paramContext)
  {
    this.h = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(R.layout.wifipay_custom_toast, null);
    this.i = ((TextView)this.h.findViewById(R.id.wifipay_toast_message));
  }
  
  public static b a(Context paramContext, CharSequence paramCharSequence, int paramInt)
  {
    Toast localToast = Toast.makeText(paramContext, paramCharSequence, paramInt);
    paramContext = new b(paramContext);
    paramContext.a = localToast;
    paramContext.a(paramInt);
    paramContext.a(paramCharSequence);
    d.add(paramContext);
    return paramContext;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 19) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      AppOpsManager localAppOpsManager = (AppOpsManager)paramContext.getSystemService("appops");
      Object localObject = paramContext.getApplicationInfo();
      paramContext = paramContext.getApplicationContext().getPackageName();
      int m = ((ApplicationInfo)localObject).uid;
      try
      {
        localObject = Class.forName(AppOpsManager.class.getName());
        m = ((Integer)((Class)localObject).getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(((Integer)((Class)localObject).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(m), paramContext })).intValue();
        if (m == 0) {
          bool = true;
        } else {
          bool = false;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
        bool = true;
      }
    }
  }
  
  private void b()
  {
    if (!c) {}
    for (;;)
    {
      return;
      try
      {
        this.g.invoke(this.e, new Object[0]);
        c = false;
        d.remove(0);
        if (d.size() <= 0) {
          continue;
        }
        ((b)d.get(0)).a();
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void c()
  {
    try
    {
      Field localField = this.a.getClass().getDeclaredField("mTN");
      localField.setAccessible(true);
      this.e = localField.get(this.a);
      this.f = this.e.getClass().getMethod("show", new Class[0]);
      this.g = this.e.getClass().getMethod("hide", new Class[0]);
      localField = this.e.getClass().getDeclaredField("mParams");
      localField.setAccessible(true);
      ((WindowManager.LayoutParams)localField.get(this.e)).flags = 40;
      localField = this.e.getClass().getDeclaredField("mNextView");
      localField.setAccessible(true);
      localField.set(this.e, this.a.getView());
      this.a.setGravity(81, 0, 100);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a()
  {
    if ((c) || (this.h == null) || (this.i == null) || (TextUtils.isEmpty(this.i.getText().toString().trim()))) {}
    for (;;)
    {
      return;
      c = true;
      this.a.setView(this.h);
      c();
      try
      {
        this.f.invoke(this.e, new Object[0]);
        Handler localHandler = this.j;
        Runnable localRunnable = this.k;
        if (this.b == 2000)
        {
          l = 2000L;
          localHandler.postDelayed(localRunnable, l);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          continue;
          long l = 3500L;
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.i.setText(paramCharSequence);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/app/ui/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */