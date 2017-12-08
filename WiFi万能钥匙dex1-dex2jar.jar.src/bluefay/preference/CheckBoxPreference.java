package bluefay.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import bluefay.widget.SlidingButton;
import com.bluefay.a.e;

public class CheckBoxPreference
  extends TwoStatePreference
{
  private boolean c;
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842895);
  }
  
  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = e.a("com.android.internal.R$styleable", "CheckBoxPreference");
    if (localObject == null) {}
    for (;;)
    {
      return;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject, paramInt, 0);
      paramInt = ((Integer)e.a("com.android.internal.R$styleable", "CheckBoxPreference_summaryOn")).intValue();
      int i = ((Integer)e.a("com.android.internal.R$styleable", "CheckBoxPreference_summaryOff")).intValue();
      int j = ((Integer)e.a("com.android.internal.R$styleable", "CheckBoxPreference_disableDependentsState")).intValue();
      c(paramContext.getString(paramInt));
      d(paramContext.getString(i));
      g(paramContext.getBoolean(j, false));
      paramContext.recycle();
    }
  }
  
  protected void a(View paramView)
  {
    super.a(paramView);
    View localView = paramView.findViewById(16908289);
    if ((localView != null) && ((localView instanceof Checkable)))
    {
      ((Checkable)localView).setChecked(this.b);
      if (((localView instanceof SlidingButton)) && (this.c)) {
        ((SlidingButton)localView).a();
      }
    }
    if ((localView != null) && ((localView instanceof SlidingButton))) {
      ((SlidingButton)localView).a(new a(this));
    }
    b(paramView);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/CheckBoxPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */