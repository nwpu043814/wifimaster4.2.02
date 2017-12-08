package com.bluefay.material;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.bluefay.framework.R.drawable;
import com.bluefay.framework.R.id;
import com.bluefay.framework.R.layout;
import com.bluefay.framework.R.style;

public final class f
  extends Dialog
{
  private int a = 0;
  private View b = LayoutInflater.from(getContext()).inflate(R.layout.framework_progress_dialog, null);
  private MaterialProgressBarNew c;
  private TextView d;
  private b e;
  private i f;
  private Animation.AnimationListener g = new h(this);
  
  public f(Context paramContext)
  {
    this(paramContext, R.style.BL_Theme_Light_CustomDialog);
  }
  
  private f(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.b.setBackgroundResource(R.drawable.framework_progress_dialog_bg);
    this.c = ((MaterialProgressBarNew)this.b.findViewById(R.id.progressbar));
    this.c.a(new g(this));
    this.d = ((TextView)this.b.findViewById(R.id.message));
    setContentView(this.b);
    getWindow().getAttributes().gravity = 17;
  }
  
  private void a(int paramInt)
  {
    this.e.getBackground().setAlpha(paramInt);
    this.f.setAlpha(paramInt);
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    if (this.a != 1) {
      this.d.setText(paramCharSequence);
    }
  }
  
  public final void dismiss()
  {
    this.c.setVisibility(4);
  }
  
  public final void hide() {}
  
  public final void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
  }
  
  public final void show()
  {
    super.show();
    this.c.setVisibility(0);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/material/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */