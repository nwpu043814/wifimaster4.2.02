package com.lantern.settings.widget;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.lantern.core.c;
import com.lantern.settings.R.anim;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;
import java.lang.reflect.Field;

public final class e
{
  private static e a;
  private Context b = c.getInstance().getApplicationContext();
  private boolean c = false;
  private int d = 0;
  
  public static e a()
  {
    if (a == null) {
      a = new e();
    }
    return a;
  }
  
  public final void b()
  {
    if (this.c) {}
    for (;;)
    {
      return;
      WindowManager localWindowManager = (WindowManager)this.b.getSystemService("window");
      WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
      a locala = new a(this.b, localWindowManager, localLayoutParams);
      locala.a(new f(this));
      localLayoutParams.flags |= 0x8;
      localLayoutParams.type = 2002;
      localLayoutParams.gravity = 48;
      localLayoutParams.x = 0;
      localLayoutParams.y = this.d;
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      localLayoutParams.format = 1;
      localWindowManager.addView(locala, localLayoutParams);
      this.c = true;
    }
  }
  
  private final class a
    extends FrameLayout
  {
    private WindowManager b = null;
    private WindowManager.LayoutParams c = null;
    private e.b d;
    private int e;
    private Animation f;
    private float g;
    private float h;
    private float i;
    private float j;
    
    public a(Context paramContext, WindowManager paramWindowManager, WindowManager.LayoutParams paramLayoutParams)
    {
      super();
      View localView = LayoutInflater.from(paramContext).inflate(R.layout.settings_follow_weixin_tip, null);
      this$1 = localView.findViewById(R.id.settings_weixin_float_dlg_slide);
      g localg = new g(this, e.this);
      localView.findViewById(R.id.settings_weixin_float_dlg_copy_id).setOnClickListener(new h(this, paramContext, e.this, localg));
      localView.findViewById(R.id.settings_weixin_float_dlg_btn_colse).setOnClickListener(new i(this, e.this, localg));
      addView(localView);
      e.this.post(localg);
      this.e = b();
      this.b = paramWindowManager;
      this.c = paramLayoutParams;
      this.f = AnimationUtils.loadAnimation(paramContext, R.anim.settings_weixin_float_dlg_slide);
    }
    
    private void a()
    {
      this.c.x = ((int)(this.i - this.g));
      this.c.y = ((int)(this.j - this.h));
      this.b.updateViewLayout(this, this.c);
    }
    
    private int b()
    {
      int k = 0;
      try
      {
        Class localClass = Class.forName("com.android.internal.R$dimen");
        Object localObject = localClass.newInstance();
        int m = Integer.parseInt(localClass.getField("status_bar_height").get(localObject).toString());
        m = getContext().getResources().getDimensionPixelSize(m);
        k = m;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
      return k;
    }
    
    public final void a(e.b paramb)
    {
      this.d = paramb;
    }
    
    public final boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      this.i = paramMotionEvent.getRawX();
      this.j = (paramMotionEvent.getRawY() - this.e);
      switch (paramMotionEvent.getAction())
      {
      }
      for (;;)
      {
        return true;
        this.g = paramMotionEvent.getX();
        this.h = paramMotionEvent.getY();
        continue;
        a();
        continue;
        a();
        this.h = 0.0F;
        this.g = 0.0F;
      }
    }
  }
  
  private static abstract class b
  {
    public void a() {}
    
    public void b() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/widget/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */