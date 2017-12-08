package bluefay.preference;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bluefay.framework.R.id;
import com.bluefay.framework.R.layout;

public class ValuePreference
  extends Preference
{
  private int b;
  private boolean c;
  private CharSequence d;
  private int e;
  
  public ValuePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c(R.layout.framework_preference_value);
  }
  
  public final void a(int paramInt)
  {
    a(y().getString(paramInt));
    this.e = paramInt;
  }
  
  protected final void a(View paramView)
  {
    super.a(paramView);
    TextView localTextView = (TextView)paramView.findViewById(R.id.right_value);
    if (localTextView != null)
    {
      CharSequence localCharSequence = this.d;
      if (!TextUtils.isEmpty(localCharSequence))
      {
        localTextView.setText(localCharSequence);
        localTextView.setVisibility(0);
      }
    }
    paramView = (ImageView)paramView.findViewById(R.id.right_arrow);
    if (paramView != null)
    {
      if (!this.c) {
        break label85;
      }
      paramView.setVisibility(0);
    }
    for (;;)
    {
      if (this.b != 0) {
        paramView.setImageResource(this.b);
      }
      return;
      label85:
      paramView.setVisibility(8);
    }
  }
  
  public final void a(String paramString)
  {
    if (((paramString == null) && (this.d != null)) || ((paramString != null) && (!paramString.equals(this.d))))
    {
      this.e = 0;
      this.d = paramString;
      z();
    }
  }
  
  public final CharSequence b()
  {
    return this.d;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/ValuePreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */