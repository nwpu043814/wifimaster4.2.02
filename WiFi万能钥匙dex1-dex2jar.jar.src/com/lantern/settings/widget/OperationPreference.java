package com.lantern.settings.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import bluefay.preference.Preference;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;

public class OperationPreference
  extends Preference
{
  private ImageView b;
  private Drawable c;
  
  public OperationPreference(Context paramContext)
  {
    super(paramContext);
  }
  
  public OperationPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public OperationPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final View a(ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(y()).inflate(R.layout.settings_preference_operation, paramViewGroup, false);
  }
  
  protected final void a(View paramView)
  {
    super.a(paramView);
    this.b = ((ImageView)paramView.findViewById(R.id.operation_icon));
    if (this.c != null) {
      this.b.setImageDrawable(this.c);
    }
  }
  
  public final void b(Drawable paramDrawable)
  {
    this.c = paramDrawable;
    if (this.b != null) {
      this.b.setImageDrawable(paramDrawable);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/widget/OperationPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */