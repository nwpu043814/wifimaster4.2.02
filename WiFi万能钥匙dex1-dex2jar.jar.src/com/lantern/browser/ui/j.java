package com.lantern.browser.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.bluefay.a.e;
import com.lantern.browser.R.drawable;
import com.lantern.browser.R.string;
import com.lantern.browser.bp;
import com.lantern.browser.comment.d.n;
import java.util.List;

public final class j
  extends LinearLayout
{
  private a a;
  private int b = 0;
  private int c = 0;
  private LinearLayout d = new LinearLayout(getContext());
  private Drawable e;
  private String f;
  
  public j(Context paramContext)
  {
    super(paramContext);
    this.d.setOrientation(1);
    this.d.setBackgroundResource(R.drawable.browser_relate_news_bg);
    int i = e.a(getContext(), 9.0F);
    this.d.setPadding(i, 0, i, 0);
    paramContext = new LinearLayout.LayoutParams(-1, -2);
    i = e.a(getContext(), 16.0F);
    setPadding(i, e.a(getContext(), 25.0F), i, i);
    addView(this.d, paramContext);
    this.e = getResources().getDrawable(R.drawable.browser_news_list_dot);
  }
  
  private void a()
  {
    View localView = new View(getContext());
    localView.setBackgroundColor(-1776412);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 1);
    this.d.addView(localView, localLayoutParams);
  }
  
  private TextView b()
  {
    TextView localTextView = new TextView(getContext());
    localTextView.setSingleLine(true);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, this.b);
    this.d.addView(localTextView, localLayoutParams);
    return localTextView;
  }
  
  public final void a(a parama)
  {
    this.a = parama;
  }
  
  public final void a(String paramString, List<n> paramList)
  {
    this.d.removeAllViewsInLayout();
    this.f = paramString;
    int i;
    int j;
    label75:
    TextView localTextView;
    if (paramList != null)
    {
      i = paramList.size();
      if (i <= 0) {
        return;
      }
      paramString = b();
      paramString.setGravity(80);
      paramString.setPadding(0, 0, 0, this.c);
      paramString.setText(R.string.browser_relate_news);
      paramString.setTextSize(13.0F);
      paramString.setTextColor(-6710887);
      a();
      j = 0;
      if (j >= i) {
        return;
      }
      paramString = (n)paramList.get(j);
      if (paramString != null)
      {
        localTextView = b();
        localTextView.setGravity(16);
        localTextView.setText(paramString.b());
        localTextView.setCompoundDrawablesWithIntrinsicBounds(this.e, null, null, null);
        localTextView.setCompoundDrawablePadding(e.a(getContext(), 5.0F));
        if (!bp.i(paramString.a())) {
          break label206;
        }
        localTextView.setTextColor(-6710887);
      }
    }
    for (;;)
    {
      localTextView.setTextSize(16.0F);
      localTextView.setOnClickListener(new k(this, paramString));
      if (j + 1 < i) {
        a();
      }
      j++;
      break label75;
      i = 0;
      break;
      label206:
      localTextView.setTextColor(-11711412);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(n paramn);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/ui/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */