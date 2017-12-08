package com.linksure.apservice.ui.home.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.text.TextPaint;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.linksure.apservice.R.color;
import com.linksure.apservice.R.dimen;
import com.linksure.apservice.R.drawable;
import com.linksure.apservice.b.h;
import com.linksure.apservice.utils.j;
import java.util.Iterator;
import java.util.List;

public final class a
  extends PopupWindow
  implements View.OnClickListener
{
  private View.OnClickListener a;
  private Context b;
  private Resources c;
  private View d;
  private int e;
  private int f;
  private int g;
  
  public a(Context paramContext, List<h> paramList)
  {
    super(paramContext);
    this.b = paramContext;
    this.c = paramContext.getResources();
    this.e = a(paramList);
    this.f = j.a(paramContext, 12.0F);
    this.g = j.a(paramContext, 110.0F);
    this.d = b(paramList);
    setWidth(-2);
    setHeight(-2);
    setBackgroundDrawable(new ColorDrawable(0));
    setOutsideTouchable(true);
    setContentView(this.d);
  }
  
  private int a(List<h> paramList)
  {
    TextView localTextView = new TextView(this.b);
    localTextView.setTextSize(0, this.c.getDimensionPixelSize(R.dimen.aps_menu_text));
    TextPaint localTextPaint = localTextView.getPaint();
    Iterator localIterator = paramList.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      paramList = (h)localIterator.next();
      localTextView.setText(paramList.c);
      int j = (int)localTextPaint.measureText(paramList.c);
      if (i >= j) {
        break label100;
      }
      i = j;
    }
    label100:
    for (;;)
    {
      break;
      return i;
    }
  }
  
  private View b(List<h> paramList)
  {
    LinearLayout localLinearLayout = new LinearLayout(this.b);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setGravity(1);
    localLinearLayout.setBackgroundResource(R.drawable.aps_submenu);
    int k = paramList.size();
    int i = 0;
    if (i < k)
    {
      Object localObject = new TextView(this.b);
      int j = j.a(this.b, 110.0F);
      if (this.e != 0)
      {
        j = this.e + this.f * 2;
        if (j > this.g) {
          label99:
          ((TextView)localObject).setWidth(j);
        }
      }
      for (;;)
      {
        ((TextView)localObject).setPadding(this.f, this.f, this.f, this.f);
        ((TextView)localObject).setGravity(1);
        ((TextView)localObject).setTextColor(this.c.getColor(R.color.aps_black));
        ((TextView)localObject).setLines(1);
        ((TextView)localObject).setBackgroundResource(R.drawable.framework_topbar_item_bg);
        ((TextView)localObject).setTextSize(0, this.c.getDimensionPixelSize(R.dimen.aps_menu_text));
        ((TextView)localObject).setTag(paramList.get(i));
        ((TextView)localObject).setText(((h)paramList.get(i)).c);
        ((TextView)localObject).setOnClickListener(this);
        localLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(-2, -2));
        if (i < k - 1)
        {
          localObject = new View(this.b);
          ((View)localObject).setBackgroundColor(this.c.getColor(R.color.aps_light_gray));
          localLinearLayout.addView((View)localObject, new LinearLayout.LayoutParams(-1, 1));
        }
        i++;
        break;
        j = this.g;
        break label99;
        ((TextView)localObject).setMinWidth(j);
      }
    }
    return localLinearLayout;
  }
  
  public final void a(View.OnClickListener paramOnClickListener)
  {
    this.a = paramOnClickListener;
  }
  
  public final void a(View paramView)
  {
    View localView = this.d;
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), i);
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = localView.getMeasuredWidth();
    arrayOfInt[1] = localView.getMeasuredHeight();
    i = (arrayOfInt[0] - paramView.getWidth()) / 2;
    int k = arrayOfInt[1];
    int j = paramView.getHeight();
    int m = j.a(this.b, 6.0F);
    showAsDropDown(paramView, -i, -(k + j + m));
  }
  
  public final void onClick(View paramView)
  {
    if (this.a != null) {
      this.a.onClick(paramView);
    }
    dismiss();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/home/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */