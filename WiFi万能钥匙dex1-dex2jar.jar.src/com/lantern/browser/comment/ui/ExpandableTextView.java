package com.lantern.browser.comment.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.bluefay.a.e;
import com.lantern.browser.R.drawable;
import com.lantern.browser.R.string;

public class ExpandableTextView
  extends LinearLayout
  implements View.OnClickListener
{
  private static int a;
  private static int b;
  private Context c;
  private TextView d;
  private ImageView e;
  private View f;
  private boolean g;
  private boolean h = true;
  private int i;
  private int j;
  private Drawable k;
  private Drawable l;
  private a m;
  
  public ExpandableTextView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ExpandableTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ExpandableTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.c = paramContext;
    this.j = Integer.MAX_VALUE;
    if (this.k == null) {
      this.k = b(R.drawable.news_comment_openup_blue);
    }
    if (this.l == null) {
      this.l = b(R.drawable.news_comment_openup_blue);
    }
    if (a == 0)
    {
      a = e.a(this.c, 4.0F);
      b = e.a(this.c, 2.0F);
    }
    setOrientation(1);
    this.d = new TextView(this.c);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    this.d.setTextColor(-10066330);
    this.d.setTextSize(16.0F);
    this.d.setLineSpacing(b, 1.0F);
    this.d.setTextSize(16.0F);
    this.d.setTextColor(-11513776);
    this.d.setIncludeFontPadding(false);
    this.d.setEllipsize(TextUtils.TruncateAt.END);
    addView(this.d, paramContext);
    this.i = this.d.getPaint().getFlags();
    LinearLayout localLinearLayout = new LinearLayout(this.c);
    localLinearLayout.setGravity(16);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setPadding(0, b, 0, a);
    paramContext = new TextView(this.c);
    paramContext.setTextSize(12.0F);
    paramContext.setTextColor(-16611856);
    paramContext.setText(R.string.comment_click_to_show_full_comment);
    localLinearLayout.addView(paramContext);
    this.e = new ImageView(this.c);
    ImageView localImageView = this.e;
    if (this.h) {}
    for (paramContext = this.k;; paramContext = this.l)
    {
      localImageView.setImageDrawable(paramContext);
      paramContext = new LinearLayout.LayoutParams(-2, -2);
      paramContext.setMargins(a, 0, 0, 0);
      localLinearLayout.addView(this.e, paramContext);
      localLinearLayout.setOnClickListener(this);
      addView(localLinearLayout, new LinearLayout.LayoutParams(-2, -2));
      this.f = localLinearLayout;
      return;
    }
  }
  
  private Drawable b(int paramInt)
  {
    return this.c.getResources().getDrawable(paramInt);
  }
  
  public final TextView a()
  {
    return this.d;
  }
  
  public final void a(int paramInt)
  {
    this.j = paramInt;
    this.d.setMaxLines(paramInt);
  }
  
  public final void a(a parama)
  {
    this.m = parama;
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.g = true;
    this.d.setText(paramCharSequence);
  }
  
  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.d.getPaint().setFlags(this.i | 0x10);
      this.d.setTextColor(-3881788);
    }
    for (;;)
    {
      return;
      this.d.getPaint().setFlags(this.i);
      this.d.setTextColor(-10066330);
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    if (this.f.getVisibility() != 0) {}
    label31:
    do
    {
      return;
      this.f.setVisibility(8);
      if (this.h) {
        break;
      }
      bool1 = true;
      this.h = bool1;
      this.d.setMaxLines(Integer.MAX_VALUE);
      requestLayout();
    } while (this.m == null);
    paramView = this.m;
    if (!this.h) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramView.a(bool1);
      break;
      bool1 = false;
      break label31;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (!this.g) {
      super.onMeasure(paramInt1, paramInt2);
    }
    for (;;)
    {
      return;
      this.g = false;
      this.f.setVisibility(8);
      this.d.setMaxLines(Integer.MAX_VALUE);
      this.d.setEllipsize(null);
      super.onMeasure(paramInt1, paramInt2);
      if (this.d.getLineCount() <= this.j)
      {
        this.h = false;
      }
      else
      {
        this.h = true;
        this.d.setMaxLines(this.j);
        this.f.setVisibility(0);
        this.d.setEllipsize(TextUtils.TruncateAt.END);
        super.onMeasure(paramInt1, paramInt2);
      }
    }
  }
  
  public void setOrientation(int paramInt)
  {
    if (paramInt == 0) {
      throw new IllegalArgumentException("ExpandableTextView only supports Vertical Orientation.");
    }
    super.setOrientation(paramInt);
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/ExpandableTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */