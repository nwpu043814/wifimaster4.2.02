package com.linksure.apservice.ui.category;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.linksure.apservice.R.color;
import com.linksure.apservice.R.drawable;
import com.linksure.apservice.R.id;
import com.linksure.apservice.R.layout;
import com.linksure.apservice.R.string;
import com.linksure.apservice.b.c;
import com.linksure.apservice.utils.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class k
  extends BaseAdapter
{
  private Context a;
  private List<c> b;
  private a c;
  private String d = "top";
  private boolean e = false;
  
  public k(Context paramContext)
  {
    this.a = paramContext;
    this.b = new ArrayList();
  }
  
  public final List<c> a()
  {
    if (this.b != null) {}
    for (List localList = this.b;; localList = Collections.EMPTY_LIST) {
      return localList;
    }
  }
  
  public final void a(a parama)
  {
    this.c = parama;
  }
  
  public final void a(List<c> paramList, String paramString)
  {
    if (this.d.equals(paramString)) {
      this.b.addAll(paramList);
    }
    for (;;)
    {
      notifyDataSetChanged();
      return;
      this.d = paramString;
      this.b = paramList;
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public final int getCount()
  {
    if (this.b == null) {}
    for (int i = 0;; i = this.b.size()) {
      return i;
    }
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      Object localObject2 = LayoutInflater.from(this.a).inflate(R.layout.aps_category_lists_adapter, paramViewGroup, false);
      Object localObject1 = new b();
      ((b)localObject1).a = ((ImageView)((View)localObject2).findViewById(R.id.aps_logo));
      ((b)localObject1).b = ((TextView)((View)localObject2).findViewById(R.id.aps_name));
      ((b)localObject1).c = ((TextView)((View)localObject2).findViewById(R.id.aps_numb));
      ((b)localObject1).d = ((Button)((View)localObject2).findViewById(R.id.aps_focu));
      ((b)localObject1).e = ((View)localObject2).findViewById(R.id.aps_line);
      ((View)localObject2).setTag(localObject1);
      paramViewGroup = (ViewGroup)localObject1;
      paramView = (View)localObject2;
      if (this.e)
      {
        int i = ((FrameLayout.LayoutParams)((b)localObject1).b.getLayoutParams()).leftMargin;
        ((FrameLayout.LayoutParams)((b)localObject1).e.getLayoutParams()).setMargins(i, 0, 0, 0);
        paramView = (View)localObject2;
        paramViewGroup = (ViewGroup)localObject1;
      }
      localObject2 = (c)this.b.get(paramInt);
      e.a(paramViewGroup.a, ((c)localObject2).c, R.drawable.aps_dft_logo);
      paramViewGroup.b.setText(((c)localObject2).b);
      paramViewGroup.c.setText(this.a.getResources().getString(R.string.aps_follow_count, new Object[] { Integer.valueOf(((c)localObject2).f) }));
      localObject1 = this.c;
      paramViewGroup.d.setOnClickListener(new l(paramViewGroup, (a)localObject1, (c)localObject2));
      if (((c)localObject2).g) {
        break label342;
      }
      paramViewGroup.d.setTextColor(this.a.getResources().getColor(R.color.aps_white));
      paramViewGroup.d.setSelected(false);
      paramViewGroup.d.setText(R.string.aps_stat_unfollow);
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.aps_white_jia, 0, 0, 0);
    }
    for (;;)
    {
      return paramView;
      paramViewGroup = (b)paramView.getTag();
      break;
      label342:
      paramViewGroup.d.setTextColor(this.a.getResources().getColor(R.color.colorPrimary));
      paramViewGroup.d.setSelected(true);
      paramViewGroup.d.setText(R.string.aps_stat_follow);
      paramViewGroup.d.setCompoundDrawablesWithIntrinsicBounds(R.drawable.aps_blue_gougou, 0, 0, 0);
    }
  }
  
  static abstract interface a
  {
    public abstract void a(c paramc);
  }
  
  static final class b
  {
    ImageView a;
    TextView b;
    TextView c;
    Button d;
    View e;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/category/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */