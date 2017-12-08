package com.linksure.apservice.ui.home.a;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.linksure.apservice.R.drawable;
import com.linksure.apservice.R.id;
import com.linksure.apservice.R.layout;
import com.linksure.apservice.ui.home.keyboard.a;
import com.linksure.apservice.utils.c;
import com.linksure.apservice.utils.j;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class b
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  public static String a = "key_emoji_res";
  public static String b = "key_row_num";
  public static String c = "key_col_num";
  private a d;
  private View e;
  private int f;
  private int g;
  private View h;
  private GridView i;
  private List<String> j;
  
  public b(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(R.layout.aps_fragment_emoji, null);
    GridView localGridView = (GridView)localView.findViewById(R.id.aps_keyboard_emoji_grid);
    this.e = localView.findViewById(R.id.aps_keyboard_delete);
    this.e.setOnClickListener(this);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.e.getLayoutParams();
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = 0;
    arrayOfInt[3] = 0;
    arrayOfInt[1] = j.a(paramContext, 168.0F);
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    arrayOfInt[2] = j.a(paramContext, ((int)(localDisplayMetrics.widthPixels / localDisplayMetrics.density) - 24 - 252) / 7 / 2 + 12);
    localLayoutParams.setMargins(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
    localGridView.setOnItemClickListener(this);
    this.d = new a(paramContext);
    this.i = localGridView;
    localGridView.setAdapter(this.d);
    this.h = localView;
  }
  
  public final View a()
  {
    return this.h;
  }
  
  public final void a(String[] paramArrayOfString, int paramInt1, int paramInt2)
  {
    this.j = Arrays.asList(paramArrayOfString);
    this.f = paramInt1;
    this.g = paramInt2;
    this.i.setNumColumns(paramInt2);
    this.d.a(this.j);
  }
  
  public final void onClick(View paramView)
  {
    if (paramView.getId() == R.id.aps_keyboard_delete) {
      a.b("delete");
    }
  }
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    a.a(this.d.a(paramInt));
  }
  
  static final class a
    extends BaseAdapter
  {
    private List<String> a = Collections.EMPTY_LIST;
    private int b;
    private int c;
    private Context d;
    
    public a(Context paramContext)
    {
      this.d = paramContext;
      this.b = j.a(paramContext, 36.0F);
      this.c = this.b;
    }
    
    public final String a(int paramInt)
    {
      return (String)this.a.get(paramInt);
    }
    
    public final void a(List<String> paramList)
    {
      this.a = paramList;
    }
    
    public final int getCount()
    {
      return this.a.size();
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = new ImageView(this.d);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.b, this.c));
        paramView.setScaleType(ImageView.ScaleType.FIT_XY);
        int i = j.a(this.d, 4.0F);
        paramView.setPadding(i, i, i, i);
      }
      for (;;)
      {
        paramView = (ImageView)paramView;
        if (paramInt == this.a.size()) {
          paramView.setImageResource(R.drawable.aps_delete_normal);
        }
        for (;;)
        {
          return paramView;
          paramView.setImageResource(c.a((String)this.a.get(paramInt)));
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/home/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */