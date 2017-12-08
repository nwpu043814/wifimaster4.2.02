package com.lantern.favorite.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import com.lantern.favorite.R.anim;
import com.lantern.favorite.widget.PhotoView;
import com.qihoo.util.StubApp1053578832;

public class PhotoBrowse
  extends Activity
{
  private PhotoView a;
  
  static
  {
    StubApp1053578832.interface11(22);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, R.anim.zoomout);
    this.a.clearAnimation();
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(200L);
    localScaleAnimation.setInterpolator(new LinearInterpolator());
    localScaleAnimation.setFillAfter(true);
    localScaleAnimation.setRepeatCount(0);
    this.a.startAnimation(localScaleAnimation);
  }
  
  protected native void onCreate(Bundle paramBundle);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/ui/PhotoBrowse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */