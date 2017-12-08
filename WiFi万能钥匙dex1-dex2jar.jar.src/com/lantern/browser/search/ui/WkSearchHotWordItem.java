package com.lantern.browser.search.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.widget.TextView;
import com.bluefay.a.e;
import com.lantern.browser.R.color;
import com.lantern.browser.R.drawable;
import com.lantern.browser.search.b.d;

public class WkSearchHotWordItem
  extends TextView
{
  private Context a;
  private d b;
  
  public WkSearchHotWordItem(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    b();
  }
  
  public WkSearchHotWordItem(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    b();
  }
  
  public WkSearchHotWordItem(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    b();
  }
  
  private void b()
  {
    setPadding(e.a(this.a, 14.0F), 0, e.a(this.a, 14.0F), 0);
    setTextSize(14.0F);
    setSingleLine(true);
    setEllipsize(TextUtils.TruncateAt.END);
    setBackgroundResource(R.drawable.search_hotword_item_bg);
    setTextColor(getResources().getColor(R.color.search_hotword));
    setGravity(17);
  }
  
  public final d a()
  {
    return this.b;
  }
  
  public final void a(d paramd)
  {
    this.b = paramd;
    if (this.b != null) {
      setText(this.b.a());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/search/ui/WkSearchHotWordItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */