package com.lantern.feed.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.lantern.analytics.a;
import com.lantern.feed.R.color;
import com.lantern.feed.R.drawable;
import com.lantern.feed.R.string;
import com.lantern.feed.d.d;
import java.util.List;

public class WkFeedSearchLayout
  extends FrameLayout
  implements View.OnClickListener
{
  private Context a;
  private TextView b;
  private List<String> c;
  
  public WkFeedSearchLayout(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    a();
  }
  
  public WkFeedSearchLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = paramContext;
    a();
  }
  
  public WkFeedSearchLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    a();
  }
  
  private void a()
  {
    setBackgroundColor(getResources().getColor(R.color.feed_search_layout_bg));
    LinearLayout localLinearLayout = new LinearLayout(this.a);
    localLinearLayout.setBackgroundResource(R.drawable.feed_search_bg);
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    ((FrameLayout.LayoutParams)localObject).leftMargin = d.a(this.a, 12.0F);
    ((FrameLayout.LayoutParams)localObject).topMargin = d.a(this.a, 10.0F);
    ((FrameLayout.LayoutParams)localObject).rightMargin = d.a(this.a, 12.0F);
    ((FrameLayout.LayoutParams)localObject).bottomMargin = d.a(this.a, 10.0F);
    addView(localLinearLayout, (ViewGroup.LayoutParams)localObject);
    localObject = new ImageView(this.a);
    ((ImageView)localObject).setImageResource(R.drawable.feed_search);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 16;
    localLayoutParams.leftMargin = d.a(this.a, 11.0F);
    localLayoutParams.rightMargin = d.a(this.a, 8.0F);
    localLinearLayout.addView((View)localObject, localLayoutParams);
    this.b = new TextView(this.a);
    this.b.setTextColor(getResources().getColor(R.color.feed_search_text));
    this.b.setTextSize(13.0F);
    this.b.setGravity(16);
    this.b.setText(R.string.feed_search);
    localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).gravity = 16;
    localLinearLayout.addView(this.b, (ViewGroup.LayoutParams)localObject);
    setOnClickListener(this);
  }
  
  public final void a(List<String> paramList)
  {
    this.c = paramList;
    if (paramList.size() > 0) {
      this.b.setText((CharSequence)paramList.get(0));
    }
  }
  
  public void onClick(View paramView)
  {
    String str = "";
    paramView = str;
    if (this.c != null)
    {
      paramView = str;
      if (this.c.size() > 0) {
        paramView = (String)this.c.get(0);
      }
    }
    d.b(paramView);
    a.e().onEvent("dscbcli");
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/feed/ui/WkFeedSearchLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */