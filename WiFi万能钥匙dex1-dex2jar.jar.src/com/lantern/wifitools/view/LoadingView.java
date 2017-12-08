package com.lantern.wifitools.view;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.lantern.wifitools.R.layout;

public class LoadingView
  extends LinearLayout
{
  private ImageView a;
  private ImageView b;
  private ImageView c;
  private Handler d;
  private boolean e;
  
  public LoadingView(Context paramContext)
  {
    super(paramContext);
    c();
  }
  
  public LoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }
  
  public LoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }
  
  private void a(long paramLong, int paramInt)
  {
    if (paramInt == 3) {}
    for (paramInt = 1;; paramInt++)
    {
      this.d.postAtTime(new e(this, paramInt, paramLong), paramLong);
      return;
    }
  }
  
  private void c()
  {
    this.d = new Handler();
    this.a = ((ImageView)LayoutInflater.from(getContext()).inflate(R.layout.wifitools_speed_dot_view, this, false));
    this.b = ((ImageView)LayoutInflater.from(getContext()).inflate(R.layout.wifitools_speed_dot_view, this, false));
    this.c = ((ImageView)LayoutInflater.from(getContext()).inflate(R.layout.wifitools_speed_dot_view, this, false));
    addView(this.a);
    addView(this.b);
    addView(this.c);
  }
  
  public final void a()
  {
    this.e = false;
    setVisibility(0);
    a(SystemClock.uptimeMillis(), 0);
  }
  
  public final void b()
  {
    this.e = true;
    setVisibility(8);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/view/LoadingView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */