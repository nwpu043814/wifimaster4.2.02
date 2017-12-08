package com.bluefay.preference;

import android.content.Context;
import android.util.AttributeSet;
import bluefay.preference.PreferenceCategory;
import com.bluefay.framework.R.layout;

public class PSTextPreference
  extends PreferenceCategory
{
  public PSTextPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842892);
  }
  
  public PSTextPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c(R.layout.framework_preference_text);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/preference/PSTextPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */