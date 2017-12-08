package com.lantern.browser.comment.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.widget.ListView;
import com.lantern.browser.comment.c.a.b;
import com.lantern.browser.comment.d.a;
import com.lantern.browser.comment.d.a.a;

public final class aj
  extends ListView
{
  private a a;
  
  public aj(Context paramContext)
  {
    super(paramContext);
    setBackgroundColor(-460552);
    setOverScrollMode(2);
    setDivider(null);
    setSelector(new ColorDrawable(0));
    this.a = new a(getContext());
  }
  
  public final void a()
  {
    if (getAdapter() == null) {
      setAdapter(this.a);
    }
    for (;;)
    {
      return;
      this.a.notifyDataSetChanged();
    }
  }
  
  public final void a(a.b paramb)
  {
    this.a.a(paramb);
  }
  
  public final void a(a.a parama)
  {
    if (this.a != null) {
      this.a.a(parama);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */