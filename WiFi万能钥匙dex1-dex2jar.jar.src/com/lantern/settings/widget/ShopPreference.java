package com.lantern.settings.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import bluefay.preference.Preference;
import com.lantern.core.imageloader.a;
import com.lantern.core.imageloader.c;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;

public class ShopPreference
  extends Preference
{
  private ImageView b;
  private FrameLayout c;
  private String d;
  
  public ShopPreference(Context paramContext)
  {
    super(paramContext);
  }
  
  public ShopPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ShopPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(y()).inflate(R.layout.settings_preference_shop, paramViewGroup, false);
  }
  
  protected final void a(View paramView)
  {
    super.a(paramView);
    this.c = ((FrameLayout)paramView.findViewById(R.id.img_layout));
    this.b = ((ImageView)paramView.findViewById(R.id.image1));
    if (!TextUtils.isEmpty(this.d))
    {
      this.c.setVisibility(0);
      c.a(y(), this.d, this.b, null, null);
    }
  }
  
  public final void a(String paramString)
  {
    this.d = paramString;
    if (this.c != null)
    {
      this.c.setVisibility(0);
      c.a(y(), paramString, this.b, null, new a());
    }
  }
  
  public final void b()
  {
    this.d = null;
    this.c.setVisibility(8);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/widget/ShopPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */