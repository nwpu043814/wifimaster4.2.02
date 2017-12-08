package com.lantern.browser.search.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantern.browser.R.id;
import com.lantern.browser.R.layout;
import com.lantern.browser.search.b.c;

public class WkSearchHistoryItem
  extends FrameLayout
  implements View.OnClickListener
{
  private Context a;
  private TextView b;
  private ImageView c;
  private c d;
  
  public WkSearchHistoryItem(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    a();
  }
  
  public WkSearchHistoryItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }
  
  public WkSearchHistoryItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a();
  }
  
  private void a()
  {
    inflate(this.a, R.layout.search_history_item, this);
    this.b = ((TextView)findViewById(R.id.searchHistory));
    this.b.setOnClickListener(this);
    this.c = ((ImageView)findViewById(R.id.searchHistoryDelete));
    this.c.setOnClickListener(this);
    setOnClickListener(this);
  }
  
  public final void a(c paramc)
  {
    this.d = paramc;
    if (this.d != null) {
      this.b.setText(this.d.a());
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == this.b.getId())
    {
      com.lantern.browser.search.a.a.a().b(this.d);
      com.lantern.analytics.a.e().onEvent("sohiscli");
    }
    for (;;)
    {
      return;
      if (i == this.c.getId())
      {
        com.lantern.browser.search.a.a.a().a(this.d);
        com.lantern.analytics.a.e().onEvent("sohisdel");
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/ui/WkSearchHistoryItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */