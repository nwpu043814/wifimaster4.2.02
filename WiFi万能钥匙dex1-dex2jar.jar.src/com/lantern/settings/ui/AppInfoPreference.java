package com.lantern.settings.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import bluefay.preference.PreferenceCategory;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;

public class AppInfoPreference
  extends PreferenceCategory
{
  private TextView b;
  private String c;
  
  public AppInfoPreference(Context paramContext)
  {
    super(paramContext);
  }
  
  public AppInfoPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AppInfoPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final View a(ViewGroup paramViewGroup)
  {
    return ((LayoutInflater)y().getSystemService("layout_inflater")).inflate(R.layout.settings_preference_appinfo, paramViewGroup, false);
  }
  
  protected final void a(View paramView)
  {
    super.a(paramView);
    if (paramView != null)
    {
      this.b = ((TextView)paramView.findViewById(R.id.settings_about_ver));
      if ((this.c != null) && (this.b != null)) {
        this.b.setText(this.c);
      }
    }
  }
  
  public final void a(String paramString)
  {
    if (paramString != null)
    {
      this.c = paramString;
      if (this.b != null) {
        this.b.setText(this.c);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/ui/AppInfoPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */