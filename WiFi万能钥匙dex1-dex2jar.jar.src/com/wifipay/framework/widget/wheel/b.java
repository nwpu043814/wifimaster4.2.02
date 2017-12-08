package com.wifipay.framework.widget.wheel;

import android.content.Context;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public abstract class b
  extends a
{
  protected Context a;
  protected LayoutInflater b;
  protected int c;
  protected int d;
  protected int e;
  private int f = -10987432;
  private int g = 18;
  
  protected b(Context paramContext)
  {
    this(paramContext, -1);
  }
  
  protected b(Context paramContext, int paramInt)
  {
    this(paramContext, paramInt, 0);
  }
  
  protected b(Context paramContext, int paramInt1, int paramInt2)
  {
    this.a = paramContext;
    this.c = paramInt1;
    this.d = paramInt2;
    this.b = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  protected View a(int paramInt, ViewGroup paramViewGroup)
  {
    switch (paramInt)
    {
    default: 
      paramViewGroup = this.b.inflate(paramInt, paramViewGroup, false);
    }
    for (;;)
    {
      return paramViewGroup;
      paramViewGroup = null;
      continue;
      paramViewGroup = new TextView(this.a);
    }
  }
  
  /* Error */
  protected TextView a(View paramView, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: iload_2
    //   3: ifne +17 -> 20
    //   6: aload_1
    //   7: instanceof 56
    //   10: ifeq +10 -> 20
    //   13: aload_1
    //   14: checkcast 56	android/widget/TextView
    //   17: astore_1
    //   18: aload_1
    //   19: areturn
    //   20: iload_2
    //   21: ifeq +12 -> 33
    //   24: aload_1
    //   25: iload_2
    //   26: invokevirtual 67	android/view/View:findViewById	(I)Landroid/view/View;
    //   29: checkcast 56	android/widget/TextView
    //   32: astore_3
    //   33: aload_3
    //   34: astore_1
    //   35: goto -17 -> 18
    //   38: astore_1
    //   39: ldc 69
    //   41: ldc 71
    //   43: invokestatic 76	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   46: pop
    //   47: new 78	java/lang/IllegalStateException
    //   50: dup
    //   51: ldc 80
    //   53: aload_1
    //   54: invokespecial 83	java/lang/IllegalStateException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   57: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	58	0	this	b
    //   0	58	1	paramView	View
    //   0	58	2	paramInt	int
    //   1	33	3	localTextView	TextView
    // Exception table:
    //   from	to	target	type
    //   6	18	38	java/lang/ClassCastException
    //   24	33	38	java/lang/ClassCastException
  }
  
  protected abstract CharSequence a(int paramInt);
  
  protected void a(TextView paramTextView)
  {
    paramTextView.setTextColor(this.f);
    paramTextView.setGravity(17);
    paramTextView.setTextSize(this.g);
    paramTextView.setEllipsize(TextUtils.TruncateAt.END);
    paramTextView.setLines(1);
  }
  
  public View getEmptyItem(View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null) {
      paramView = a(this.e, paramViewGroup);
    }
    for (;;)
    {
      if ((this.e == -1) && ((paramView instanceof TextView))) {
        a((TextView)paramView);
      }
      return paramView;
    }
  }
  
  public View getItem(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if ((paramInt >= 0) && (paramInt < getItemsCount()))
    {
      localView = paramView;
      if (paramView == null) {
        localView = a(this.c, paramViewGroup);
      }
      TextView localTextView = a(localView, this.d);
      paramView = localView;
      if (localTextView != null)
      {
        paramViewGroup = a(paramInt);
        paramView = paramViewGroup;
        if (paramViewGroup == null) {
          paramView = "";
        }
        localTextView.setText(paramView);
        paramView = localView;
        if (this.c == -1) {
          a(localTextView);
        }
      }
    }
    for (paramView = localView;; paramView = null) {
      return paramView;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/widget/wheel/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */