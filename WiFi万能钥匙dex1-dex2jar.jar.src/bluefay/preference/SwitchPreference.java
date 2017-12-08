package bluefay.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.bluefay.a.e;

public class SwitchPreference
  extends TwoStatePreference
{
  private CharSequence c;
  private CharSequence d;
  private final a e = new a((byte)0);
  
  public SwitchPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16843629);
  }
  
  public SwitchPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = e.a("com.android.internal.R$styleable", "SwitchPreference");
    if (localObject == null) {}
    for (;;)
    {
      return;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject, paramInt, 0);
      paramInt = ((Integer)e.a("com.android.internal.R$styleable", "SwitchPreference_summaryOn")).intValue();
      int m = ((Integer)e.a("com.android.internal.R$styleable", "SwitchPreference_summaryOff")).intValue();
      int j = ((Integer)e.a("com.android.internal.R$styleable", "SwitchPreference_switchTextOn")).intValue();
      int i = ((Integer)e.a("com.android.internal.R$styleable", "SwitchPreference_switchTextOff")).intValue();
      int k = ((Integer)e.a("com.android.internal.R$styleable", "SwitchPreference_disableDependentsState")).intValue();
      c(paramContext.getString(paramInt));
      d(paramContext.getString(m));
      this.c = paramContext.getString(j);
      z();
      this.d = paramContext.getString(i);
      z();
      g(paramContext.getBoolean(k, false));
      paramContext.recycle();
    }
  }
  
  protected final void a(View paramView)
  {
    super.a(paramView);
  }
  
  private final class a
    implements CompoundButton.OnCheckedChangeListener
  {
    private a() {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if (!SwitchPreference.this.x()) {
        if (!paramBoolean)
        {
          paramBoolean = true;
          paramCompoundButton.setChecked(paramBoolean);
        }
      }
      for (;;)
      {
        return;
        paramBoolean = false;
        break;
        SwitchPreference.this.a(paramBoolean);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/SwitchPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */