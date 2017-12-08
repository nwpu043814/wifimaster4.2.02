package bluefay.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.bluefay.framework.R.drawable;
import com.bluefay.framework.R.layout;
import com.bluefay.framework.R.style;

public class ButtonPreference
  extends PreferenceCategory
{
  private int b;
  
  public ButtonPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ButtonPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(R.layout.framework_preference_button);
  }
  
  protected final void a(View paramView)
  {
    super.a(paramView);
    paramView = (TextView)paramView.findViewById(16908310);
    if (paramView != null)
    {
      if (this.b != 1) {
        break label46;
      }
      paramView.setTextAppearance(y(), R.style.BL_TextAppearance_Button_Warn);
      paramView.setBackgroundResource(R.drawable.framework_btn_bg_positive_warn_single);
    }
    for (;;)
    {
      return;
      label46:
      if (this.b == 2)
      {
        paramView.setTextAppearance(y(), R.style.BL_TextAppearance_Button_Warn);
        paramView.setBackgroundResource(R.drawable.framework_btn_bg_negative_warn_single);
      }
      else
      {
        paramView.setTextAppearance(y(), R.style.BL_TextAppearance_Button);
        paramView.setBackgroundResource(R.drawable.framework_btn_bg_single);
      }
    }
  }
  
  public final boolean a()
  {
    return true;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/ButtonPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */