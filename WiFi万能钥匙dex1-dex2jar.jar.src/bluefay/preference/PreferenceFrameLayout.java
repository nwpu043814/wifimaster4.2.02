package bluefay.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class PreferenceFrameLayout
  extends FrameLayout
{
  private int a;
  private int b;
  private int c;
  private int d;
  private boolean e;
  
  public PreferenceFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public PreferenceFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private LayoutParams a(AttributeSet paramAttributeSet)
  {
    return new LayoutParams(getContext(), paramAttributeSet);
  }
  
  public void addView(View paramView)
  {
    int m = getPaddingTop();
    int k = getPaddingBottom();
    int j = getPaddingLeft();
    int i = getPaddingRight();
    LayoutParams localLayoutParams;
    int n;
    int i1;
    int i2;
    if ((paramView.getLayoutParams() instanceof LayoutParams))
    {
      localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      if ((localLayoutParams == null) || (!localLayoutParams.a)) {
        break label182;
      }
      if (!this.e) {
        break label241;
      }
      n = this.a;
      i1 = this.b;
      i2 = this.c;
      i -= this.d;
      this.e = false;
      j -= i2;
      k -= i1;
      m -= n;
    }
    label182:
    label241:
    for (;;)
    {
      i2 = getPaddingTop();
      n = getPaddingBottom();
      int i3 = getPaddingLeft();
      i1 = getPaddingRight();
      if ((i2 != m) || (n != k) || (i3 != j) || (i1 != i)) {
        setPadding(j, m, i, k);
      }
      super.addView(paramView);
      return;
      localLayoutParams = null;
      break;
      if (!this.e)
      {
        n = this.a;
        i1 = this.b;
        i2 = this.c;
        i = this.d + i;
        this.e = true;
        j += i2;
        k += i1;
        m += n;
      }
    }
  }
  
  public static class LayoutParams
    extends FrameLayout.LayoutParams
  {
    public boolean a = false;
    
    public LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/PreferenceFrameLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */