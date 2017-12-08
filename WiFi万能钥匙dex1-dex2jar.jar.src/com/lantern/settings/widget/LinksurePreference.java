package com.lantern.settings.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bluefay.preference.PreferenceCategory;
import com.lantern.settings.R.layout;

public class LinksurePreference
  extends PreferenceCategory
{
  public LinksurePreference(Context paramContext)
  {
    super(paramContext);
  }
  
  public LinksurePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LinksurePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(y()).inflate(R.layout.settings_preference_more_linksure, paramViewGroup, false);
  }
  
  protected final void a(View paramView)
  {
    super.a(paramView);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/widget/LinksurePreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */