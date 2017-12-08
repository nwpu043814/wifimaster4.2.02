package com.lantern.dm.model;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import com.lantern.dm.R.dimen;
import com.lantern.dm.R.id;
import com.lantern.dm.ui.b.b;

public class CompItem
  extends RelativeLayout
{
  private static float a = -1.0F;
  private boolean b = false;
  private CheckBox c;
  private long d;
  private b.b e;
  
  public CompItem(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public CompItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public CompItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    if (a == -1.0F) {
      a = getResources().getDimensionPixelSize(R.dimen.load_checkmark_area);
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.c = ((CheckBox)findViewById(R.id.dm_cb_item));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    switch (paramMotionEvent.getAction())
    {
    case 2: 
    default: 
      bool1 = false;
    }
    for (;;)
    {
      if (bool1)
      {
        postInvalidate();
        label50:
        return bool1;
        if (paramMotionEvent.getX() >= a) {
          break;
        }
        this.b = true;
        continue;
        this.b = false;
        bool1 = false;
        continue;
        if ((!this.b) || (paramMotionEvent.getX() >= a)) {
          break label154;
        }
        this.c.toggle();
        bool1 = bool2;
        if (this.e != null) {
          this.e.a(this.d, this.c.isChecked());
        }
      }
    }
    label154:
    for (bool1 = bool2;; bool1 = false)
    {
      this.b = false;
      break;
      bool1 = super.onTouchEvent(paramMotionEvent);
      break label50;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/dm/model/CompItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */