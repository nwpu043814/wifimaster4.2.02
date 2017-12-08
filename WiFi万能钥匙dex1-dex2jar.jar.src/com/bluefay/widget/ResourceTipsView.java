package com.bluefay.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bluefay.framework.R.id;
import com.bluefay.framework.R.layout;
import com.bluefay.material.MaterialProgressBar;

public class ResourceTipsView
  extends FrameLayout
{
  protected View a;
  protected View b;
  protected MaterialProgressBar c;
  protected TextView d;
  protected TextView e;
  protected ImageView f;
  
  public ResourceTipsView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ResourceTipsView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    LayoutInflater.from(paramContext).inflate(R.layout.framework_resource_tip, this, true);
  }
  
  protected void onFinishInflate()
  {
    this.a = findViewById(R.id.tips);
    this.b = findViewById(R.id.progress);
    this.c = ((MaterialProgressBar)findViewById(R.id.progress_icon));
    this.d = ((TextView)findViewById(R.id.progress_text));
    this.e = ((TextView)findViewById(R.id.tips_text));
    this.f = ((ImageView)findViewById(R.id.tips_icon));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/bluefay/widget/ResourceTipsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */