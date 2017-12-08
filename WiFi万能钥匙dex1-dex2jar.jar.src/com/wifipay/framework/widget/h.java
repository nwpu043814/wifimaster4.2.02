package com.wifipay.framework.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.wifipay.R.color;
import com.wifipay.R.drawable;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.common.a.b;
import com.wifipay.framework.api.d;
import java.util.ArrayList;
import java.util.List;

public class h
  extends Dialog
{
  public Context a;
  private LinearLayout b;
  private List<ImageView> c = new ArrayList();
  private d d;
  private int e;
  private a f;
  
  public h(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    this.d = new d();
  }
  
  public void a(int paramInt)
  {
    this.b.removeAllViews();
    if (this.c.size() > 0) {
      this.c.clear();
    }
    int i = 0;
    if (i < paramInt)
    {
      ImageView localImageView = new ImageView(this.a);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
      if (i == 0) {
        localImageView.setBackgroundResource(R.drawable.wifipay_framework_loading_dot_select);
      }
      for (;;)
      {
        localImageView.setLayoutParams(localLayoutParams);
        this.c.add(localImageView);
        this.b.addView(localImageView);
        i++;
        break;
        localImageView.setBackgroundResource(R.drawable.wifipay_framework_loading_dot_normal);
        localLayoutParams.leftMargin = b.a(this.a, 7.0F);
      }
    }
  }
  
  public void dismiss()
  {
    super.dismiss();
    this.d.a(null);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.setBackgroundDrawable(new ColorDrawable(0));
    paramBundle.requestFeature(1);
    if (Build.VERSION.SDK_INT >= 14) {
      paramBundle.setDimAmount(0.0F);
    }
    setContentView(R.layout.wifipay_framework_dialog_pay_loading);
    View localView = findViewById(R.id.wifipay_pay_loading_parentPanel);
    setCanceledOnTouchOutside(false);
    setCancelable(false);
    paramBundle = new GradientDrawable();
    paramBundle.setCornerRadius(b.a(getContext(), 7.0F));
    paramBundle.setColor(getContext().getResources().getColor(R.color.wifipay_color_8c000000));
    localView.setBackgroundDrawable(paramBundle);
    this.b = ((LinearLayout)findViewById(R.id.wifipay_framework_pay_loading_dots));
    a(3);
    if (this.f == null) {
      this.f = new a(null);
    }
    this.d.a(this.f, 200L);
  }
  
  public void show()
  {
    super.show();
  }
  
  private class a
    implements Runnable
  {
    private int b = 1;
    
    private a() {}
    
    public void run()
    {
      ((ImageView)h.b(h.this).get(h.a(h.this))).setBackgroundResource(R.drawable.wifipay_framework_loading_dot_normal);
      h.a(h.this, this.b % h.b(h.this).size());
      ((ImageView)h.b(h.this).get(this.b % h.b(h.this).size())).setBackgroundResource(R.drawable.wifipay_framework_loading_dot_select);
      this.b += 1;
      h.d(h.this).a(h.c(h.this), 200L);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */