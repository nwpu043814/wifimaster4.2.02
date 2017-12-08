package com.bluefay.preference;

import android.os.Bundle;

public class PSChildPaneSpecifierFragement
  extends PSPreferenceFragment
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getArguments();
    if (paramBundle != null)
    {
      int i = paramBundle.getInt("file");
      if (i > 0) {
        d(i);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/preference/PSChildPaneSpecifierFragement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */