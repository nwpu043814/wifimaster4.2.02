package com.bluefay.preference;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import bluefay.preference.Preference;

public class PSChildPaneSpecifier
  extends Preference
{
  private int b;
  
  public PSChildPaneSpecifier(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842894);
  }
  
  public PSChildPaneSpecifier(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.b = paramAttributeSet.getAttributeResourceValue("http://schemas.android.com/apk/res/android", "fragment", 0);
    b(PSChildPaneSpecifierFragement.class.getName());
    m().putInt("file", this.b);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/preference/PSChildPaneSpecifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */