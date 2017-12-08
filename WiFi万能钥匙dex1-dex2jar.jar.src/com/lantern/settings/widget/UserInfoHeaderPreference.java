package com.lantern.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import bluefay.preference.Preference;
import com.lantern.settings.R.layout;

public class UserInfoHeaderPreference
  extends Preference
{
  private View b;
  private View c;
  private View.OnClickListener d;
  
  public UserInfoHeaderPreference(Context paramContext)
  {
    super(paramContext);
  }
  
  public UserInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public UserInfoHeaderPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final View a(ViewGroup paramViewGroup)
  {
    this.c = LayoutInflater.from(y()).inflate(R.layout.settings_preference_user_info_avatar, paramViewGroup, false);
    return this.c;
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    if (this.b != null) {
      this.b.setOnClickListener(paramOnClickListener);
    }
    this.d = paramOnClickListener;
  }
  
  protected final void a(View paramView)
  {
    super.a(paramView);
    this.b = paramView.findViewById(16908294);
    if (this.d != null) {
      this.b.setOnClickListener(this.d);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/widget/UserInfoHeaderPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */