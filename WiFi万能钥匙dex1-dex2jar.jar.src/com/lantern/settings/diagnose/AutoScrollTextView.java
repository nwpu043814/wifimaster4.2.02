package com.lantern.settings.diagnose;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.ScrollView;
import android.widget.TextView;

public class AutoScrollTextView
  extends TextView
{
  public ScrollView a;
  
  public AutoScrollTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AutoScrollTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AutoScrollTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawColor(251592703);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null) {
      this.a.smoothScrollTo(0, getHeight() - this.a.getHeight());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/diagnose/AutoScrollTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */