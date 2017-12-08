package com.lantern.settings.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bluefay.preference.Preference;
import com.lantern.settings.R.layout;

public class ExitPreference
  extends Preference
{
  public ExitPreference(Context paramContext)
  {
    super(paramContext);
  }
  
  public ExitPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ExitPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(y()).inflate(R.layout.settings_preference_exit, paramViewGroup, false);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/ExitPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */