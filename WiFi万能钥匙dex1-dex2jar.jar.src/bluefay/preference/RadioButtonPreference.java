package bluefay.preference;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import com.bluefay.framework.R.dimen;
import com.bluefay.framework.R.layout;

public class RadioButtonPreference
  extends CheckBoxPreference
{
  public RadioButtonPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(R.layout.framework_preference_radiobutton);
    o();
  }
  
  protected final void a(View paramView)
  {
    super.a(paramView);
    int j = y().getResources().getDimensionPixelSize(R.dimen.framework_preference_item_padding_side);
    if (s() != null) {}
    for (int i = y().getResources().getDimensionPixelSize(R.dimen.framework_preference_icon_padding_side);; i = j)
    {
      paramView.setPadding(paramView.getPaddingLeft() - i, paramView.getPaddingTop(), paramView.getPaddingRight() - j, paramView.getPaddingBottom());
      paramView.findViewById(16908310);
      return;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/RadioButtonPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */