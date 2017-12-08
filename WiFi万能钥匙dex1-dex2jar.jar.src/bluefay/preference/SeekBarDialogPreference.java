package bluefay.preference;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

public class SeekBarDialogPreference
  extends DialogPreference
{
  private Drawable b;
  
  public SeekBarDialogPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(17039370);
    b(17039360);
    this.b = c();
    b();
  }
  
  protected void b(View paramView)
  {
    super.b(paramView);
    paramView = (ImageView)paramView.findViewById(16908294);
    if (this.b != null) {
      paramView.setImageDrawable(this.b);
    }
    for (;;)
    {
      return;
      paramView.setVisibility(8);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/SeekBarDialogPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */