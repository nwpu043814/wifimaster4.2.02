package com.lantern.browser.comment.b;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import bluefay.app.k;
import com.lantern.browser.R.id;
import com.lantern.browser.R.layout;
import com.lantern.browser.R.style;

public final class a
  extends k
{
  private Animation a;
  private View b;
  
  public a(Context paramContext)
  {
    super(paramContext, R.style.WkCommentFullScreenDialog);
  }
  
  public final void onAttachedToWindow()
  {
    this.b.startAnimation(this.a);
    super.onAttachedToWindow();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.dialog_browser_loading);
    this.b = findViewById(R.id.progressImageView);
    this.a = new RotateAnimation(0.0F, 360.0F, 1, 0.5F, 1, 0.5F);
    this.a.setInterpolator(new LinearInterpolator());
    this.a.setRepeatCount(-1);
    this.a.setDuration(500L);
  }
  
  public final void onDetachedFromWindow()
  {
    this.b.clearAnimation();
    this.a.cancel();
    super.onDetachedFromWindow();
  }
  
  public final void show()
  {
    getWindow().setWindowAnimations(R.style.dialogWindowNoAnim);
    super.show();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */