package com.linksure.apservice.ui.home.b;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.linksure.apservice.R.id;
import com.linksure.apservice.R.layout;
import com.linksure.apservice.utils.j;

public final class b
  extends PopupWindow
  implements View.OnClickListener
{
  private a a;
  private Context b;
  
  public b(Context paramContext)
  {
    super(paramContext);
    this.b = paramContext;
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.aps_list_ctxmenu, null);
    paramContext.findViewById(R.id.aps_list_menu_copy).setOnClickListener(this);
    setContentView(paramContext);
    setBackgroundDrawable(new ColorDrawable(0));
    setOutsideTouchable(true);
    setWidth(-2);
    setHeight(-2);
  }
  
  public final void a(View paramView)
  {
    View localView = getContentView();
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    localView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), i);
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = localView.getMeasuredWidth();
    arrayOfInt[1] = localView.getMeasuredHeight();
    int k = (arrayOfInt[0] - paramView.getWidth()) / 2;
    int j = arrayOfInt[1];
    int m = paramView.getMeasuredHeight();
    i = j.a(this.b, 2.0F);
    showAsDropDown(paramView, -k, -(j + m - i));
  }
  
  public final void a(a parama)
  {
    this.a = parama;
  }
  
  public final void onClick(View paramView)
  {
    dismiss();
    if ((this.a != null) && (paramView.getId() == R.id.aps_list_menu_copy)) {
      this.a.a();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/home/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */