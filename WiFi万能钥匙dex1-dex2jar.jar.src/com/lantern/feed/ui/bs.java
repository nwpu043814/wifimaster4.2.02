package com.lantern.feed.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.CountDownTimer;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.lantern.feed.b.m;

public final class bs
  extends FrameLayout
  implements WkFeedFloatView.a
{
  private TextView a;
  private Context b;
  private CountDownTimer c;
  private WkFeedFloatView d;
  private m e;
  private WebView f;
  private Bitmap g;
  
  public final void a()
  {
    if ((this.g != null) && (!this.g.isRecycled()))
    {
      this.g.recycle();
      this.g = null;
    }
    if (this.f != null) {
      this.f.destroy();
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */