package com.lantern.favorite.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.bluefay.a.e;
import com.bluefay.b.a;

public class WkListView
  extends ListView
  implements AdapterView.OnItemClickListener
{
  private Context a;
  private a b;
  
  private WkListView(Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    setScrollBarStyle(8);
    setBackgroundColor(Color.parseColor("#00000000"));
    setCacheColorHint(Color.parseColor("#00000000"));
    setSelector(new ColorDrawable(Color.parseColor("#00000000")));
    setDivider(new ColorDrawable(Color.parseColor("#D0D0D0")));
    setDividerHeight(e.a(this.a, 0.5F));
    setOnItemClickListener(this);
  }
  
  public WkListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public WkListView(Context paramContext, a parama)
  {
    this(paramContext);
    this.b = parama;
  }
  
  public final <T> void a(int paramInt1, int paramInt2, T[] paramArrayOfT)
  {
    setAdapter(new ArrayAdapter(this.a, paramInt1, paramInt2, paramArrayOfT));
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.b.a(0, null, Integer.valueOf(paramInt));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/widget/WkListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */