package com.wifipay.framework.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnKeyListener;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.wifipay.R.color;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;

public class WPAlertDialog
  extends Dialog
{
  private CharSequence a;
  private CharSequence b;
  private CharSequence c;
  private CharSequence d;
  private CharSequence e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  private onPositiveListener j;
  private onNegativeListener k;
  private FrameLayout l;
  private LinearLayout m;
  private DialogInterface.OnKeyListener n = new b(this);
  private View.OnClickListener o = new c(this);
  
  private WPAlertDialog(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a()
  {
    View localView = findViewById(R.id.wifipay_alert_parentPanel);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(getContext().getResources().getColor(R.color.wifipay_color_ffffff));
    localGradientDrawable.setCornerRadius(10.0F);
    localView.setBackgroundDrawable(localGradientDrawable);
    this.f = ((TextView)findViewById(R.id.wifipay_alert_title));
    this.f.setVisibility(8);
    this.g = ((TextView)findViewById(R.id.wifipay_alert_message));
    this.i = ((TextView)findViewById(R.id.wifipay_alert_button1));
    this.h = ((TextView)findViewById(R.id.wifipay_alert_button2));
    this.m = ((LinearLayout)findViewById(R.id.wifipay_alert_contentPanel));
    this.l = ((FrameLayout)findViewById(R.id.wifipay_alert_message_fl));
    this.e = getContext().getString(R.string.wifipay_common_confirm);
  }
  
  private void a(ViewGroup paramViewGroup, View paramView)
  {
    if ((paramViewGroup != null) && (paramView != null))
    {
      for (int i1 = 0; i1 < paramViewGroup.getChildCount(); i1++) {
        paramViewGroup.getChildAt(i1).setVisibility(8);
      }
      paramViewGroup.addView(paramView);
    }
  }
  
  private void b()
  {
    this.h.setOnClickListener(this.o);
    this.i.setOnClickListener(this.o);
    if (!TextUtils.isEmpty(this.a))
    {
      this.f.setVisibility(0);
      this.f.setText(this.a);
    }
    this.g.setText(this.b);
    c();
  }
  
  private void c()
  {
    if ((this.c != null) && (this.d != null))
    {
      this.h.setText(this.c);
      this.i.setText(this.d);
      return;
    }
    CharSequence localCharSequence;
    if (this.c != null) {
      localCharSequence = this.c;
    }
    for (;;)
    {
      this.c = localCharSequence;
      this.i.setVisibility(8);
      this.h.setText(this.c);
      break;
      if (this.d != null) {
        localCharSequence = this.d;
      } else {
        localCharSequence = this.e;
      }
    }
  }
  
  public void a(View paramView)
  {
    a(this.m, paramView);
  }
  
  public void a(onNegativeListener paramonNegativeListener)
  {
    this.k = paramonNegativeListener;
  }
  
  public void a(onPositiveListener paramonPositiveListener)
  {
    this.j = paramonPositiveListener;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    this.b = paramCharSequence;
    if (this.g != null) {
      this.g.setText(paramCharSequence);
    }
  }
  
  public void b(View paramView)
  {
    a(this.l, paramView);
  }
  
  public void b(CharSequence paramCharSequence)
  {
    this.c = paramCharSequence;
  }
  
  public void c(CharSequence paramCharSequence)
  {
    this.d = paramCharSequence;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = getWindow();
    paramBundle.requestFeature(1);
    paramBundle.setBackgroundDrawable(new ColorDrawable(0));
    setContentView(R.layout.wifipay_framework_dialog_alert);
    setCanceledOnTouchOutside(false);
    a();
    b();
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    this.a = paramCharSequence;
    if (this.f != null)
    {
      this.f.setVisibility(0);
      this.f.setText(paramCharSequence);
    }
  }
  
  public static class a
  {
    private WPAlertDialog.b a = new WPAlertDialog.b(null);
    private Context b;
    
    public a(Context paramContext)
    {
      this.b = paramContext;
    }
    
    public WPAlertDialog a()
    {
      WPAlertDialog localWPAlertDialog = new WPAlertDialog(this.b, null);
      this.a.a(localWPAlertDialog);
      return localWPAlertDialog;
    }
  }
  
  private static class b
  {
    private CharSequence a;
    private CharSequence b;
    private CharSequence c;
    private CharSequence d;
    private WPAlertDialog.onPositiveListener e;
    private WPAlertDialog.onNegativeListener f;
    
    public void a(WPAlertDialog paramWPAlertDialog)
    {
      if (this.a != null) {
        paramWPAlertDialog.setTitle(this.a);
      }
      if (this.b != null) {
        paramWPAlertDialog.a(this.b);
      }
      if (this.d != null) {
        paramWPAlertDialog.c(this.d);
      }
      if (this.c != null) {
        paramWPAlertDialog.b(this.c);
      }
      paramWPAlertDialog.a(this.e);
      paramWPAlertDialog.a(this.f);
    }
  }
  
  public static abstract interface onNegativeListener
  {
    public abstract void onNegative();
  }
  
  public static abstract interface onPositiveListener
  {
    public abstract void onPositive();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/WPAlertDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */