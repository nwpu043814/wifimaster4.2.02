package com.lantern.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bluefay.preference.Preference;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;

public class UserLevelPreference
  extends Preference
{
  private TextView b;
  private String c;
  
  public UserLevelPreference(Context paramContext)
  {
    super(paramContext);
  }
  
  public UserLevelPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public UserLevelPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(y()).inflate(R.layout.settings_preference_level, paramViewGroup, false);
  }
  
  protected final void a(View paramView)
  {
    super.a(paramView);
    this.b = ((TextView)paramView.findViewById(R.id.level));
    if (this.c != null)
    {
      this.b.setVisibility(0);
      this.b.setText(this.c);
    }
    for (;;)
    {
      return;
      this.b.setVisibility(8);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/widget/UserLevelPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */