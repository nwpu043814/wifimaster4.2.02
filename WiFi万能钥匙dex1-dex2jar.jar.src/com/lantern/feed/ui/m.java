package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;
import com.lantern.feed.R.color;
import com.lantern.feed.R.drawable;
import com.lantern.feed.R.string;
import com.lantern.feed.b.d;
import java.util.List;

final class m
  implements AdapterView.OnItemClickListener
{
  m(i parami) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((i.b(this.a) != null) && (paramInt >= 0) && (paramInt < i.b(this.a).size() - 1))
    {
      paramAdapterView = (d)i.b(this.a).get(paramInt + 1);
      if (!i.c(this.a).contains(paramAdapterView)) {
        break label237;
      }
      i.c(this.a).remove(paramAdapterView);
      ((h)paramView).a();
      if (i.c(this.a).size() <= 0) {
        break label280;
      }
      paramView = i.d(this.a) + i.c(this.a).size() + i.e(this.a);
      paramAdapterView = new SpannableString(paramView);
      paramAdapterView.setSpan(new ForegroundColorSpan(this.a.getContext().getResources().getColor(R.color.framework_primary_color)), i.d(this.a).length(), paramView.length() - i.e(this.a).length(), 33);
      i.f(this.a).setText(paramAdapterView);
      i.g(this.a).setText(R.string.feed_btn_ok);
    }
    for (;;)
    {
      return;
      label237:
      i.c(this.a).add(paramAdapterView);
      paramAdapterView = (h)paramView;
      paramAdapterView.setBackgroundResource(R.drawable.feed_dislike_item_selected);
      paramAdapterView.setTextColor(paramAdapterView.getResources().getColor(R.color.framework_primary_color));
      break;
      label280:
      i.f(this.a).setText(R.string.feed_dislike_tip);
      i.g(this.a).setText(((d)i.b(this.a).get(0)).b());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */