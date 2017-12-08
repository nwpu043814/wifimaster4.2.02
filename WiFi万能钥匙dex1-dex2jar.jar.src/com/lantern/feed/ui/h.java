package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.lantern.feed.R.color;
import com.lantern.feed.R.drawable;
import com.lantern.feed.d.d;

public final class h
  extends TextView
{
  public h(Context paramContext)
  {
    super(paramContext);
    setHeight(d.a(getContext(), 30.0F));
    setGravity(17);
    setMaxLines(1);
    setEllipsize(TextUtils.TruncateAt.END);
  }
  
  public final void a()
  {
    setBackgroundResource(R.drawable.feed_dislike_item);
    setTextColor(getResources().getColor(R.color.feed_dislike_item));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */