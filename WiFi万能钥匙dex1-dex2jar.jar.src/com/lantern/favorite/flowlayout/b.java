package com.lantern.favorite.flowlayout;

import android.content.Context;
import android.widget.Checkable;
import android.widget.FrameLayout;

public final class b
  extends FrameLayout
  implements Checkable
{
  private static final int[] b = { 16842912 };
  private boolean a;
  
  public b(Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean isChecked()
  {
    return this.a;
  }
  
  public final int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, b);
    }
    return arrayOfInt;
  }
  
  public final void setChecked(boolean paramBoolean)
  {
    if (this.a != paramBoolean)
    {
      this.a = paramBoolean;
      refreshDrawableState();
    }
  }
  
  public final void toggle()
  {
    if (!this.a) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/flowlayout/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */