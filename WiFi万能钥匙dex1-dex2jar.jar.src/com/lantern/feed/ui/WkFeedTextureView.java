package com.lantern.feed.ui;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.TextureView;

public class WkFeedTextureView
  extends TextureView
{
  private Point a;
  
  public WkFeedTextureView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public WkFeedTextureView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.a = new Point(0, 0);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/WkFeedTextureView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */