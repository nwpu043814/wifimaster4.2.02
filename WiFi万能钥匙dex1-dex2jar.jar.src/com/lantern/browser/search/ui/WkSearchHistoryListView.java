package com.lantern.browser.search.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.AbsListView.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.lantern.browser.R.drawable;
import com.lantern.browser.R.layout;
import com.lantern.browser.R.string;
import com.lantern.browser.search.b.a;

public class WkSearchHistoryListView
  extends ListView
{
  private Context a;
  private TextView b;
  private a c;
  
  public WkSearchHistoryListView(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    b();
  }
  
  public WkSearchHistoryListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    b();
  }
  
  public WkSearchHistoryListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    b();
  }
  
  private void b()
  {
    setDivider(null);
    addHeaderView((TextView)LayoutInflater.from(this.a).inflate(R.layout.search_history_header, this, false));
    this.b = new TextView(this.a);
    this.b.setBackgroundResource(R.drawable.search_history_item_bg);
    this.b.setOnTouchListener(new d(this));
    this.b.setOnClickListener(new e(this));
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, com.bluefay.a.e.a(this.a, 44.0F));
    this.b.setLayoutParams(localLayoutParams);
    this.b.setText(R.string.search_clear_all);
    this.b.setTextSize(15.0F);
    this.b.setTextColor(-16611856);
    this.b.setGravity(17);
    addFooterView(this.b);
    this.c = new a();
    setAdapter(this.c);
  }
  
  public final void a()
  {
    this.c.notifyDataSetChanged();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/ui/WkSearchHistoryListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */