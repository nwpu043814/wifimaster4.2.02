package com.lantern.settings.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.TextView;
import bluefay.preference.PreferenceCategory;
import com.bluefay.b.a;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;

public class ProtocalPreference
  extends PreferenceCategory
{
  private TextView b;
  private a c;
  
  public ProtocalPreference(Context paramContext)
  {
    super(paramContext);
  }
  
  public ProtocalPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ProtocalPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected final View a(ViewGroup paramViewGroup)
  {
    View localView1 = ((LayoutInflater)y().getSystemService("layout_inflater")).inflate(R.layout.settings_preference_protocal, paramViewGroup, false);
    View localView2 = paramViewGroup.getChildAt(paramViewGroup.getChildCount() - 1);
    Rect localRect1 = new Rect();
    Rect localRect2 = new Rect();
    localView2.getLocalVisibleRect(localRect1);
    paramViewGroup.getLocalVisibleRect(localRect2);
    int i = localRect1.bottom;
    int j = localRect2.bottom;
    if (j > i) {
      localView1.setLayoutParams(new AbsListView.LayoutParams(-1, j - i - 30));
    }
    this.b = ((TextView)localView1.findViewById(R.id.settings_about_protocal));
    if (this.b != null) {
      this.b.setOnClickListener(new b(this));
    }
    return localView1;
  }
  
  public final void a(a parama)
  {
    this.c = parama;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/settings/widget/ProtocalPreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */