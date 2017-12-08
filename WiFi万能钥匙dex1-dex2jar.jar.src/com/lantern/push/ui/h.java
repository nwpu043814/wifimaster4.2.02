package com.lantern.push.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lantern.push.a.d;
import com.lantern.push.b.a;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;
import com.lantern.settings.R.string;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public final class h
  extends BaseAdapter
{
  private Context a;
  private List<a> b;
  private d c;
  private RelativeLayout d;
  private SimpleDateFormat e = new SimpleDateFormat("HH:mm", Locale.getDefault());
  private SimpleDateFormat f = new SimpleDateFormat("MM-dd HH:mm", Locale.getDefault());
  private final long g = 3600000L;
  private final long h = 86400000L;
  private String i;
  private String j;
  private String k;
  
  public h(Context paramContext)
  {
    this.a = paramContext;
    this.b = new ArrayList();
    this.c = d.a();
    this.i = this.a.getString(R.string.settings_time_before_few_minute);
    this.j = this.a.getString(R.string.settings_time_morning);
    this.k = this.a.getString(R.string.settings_time_afternoon);
  }
  
  private String a(long paramLong)
  {
    for (;;)
    {
      try
      {
        localObject1 = new java/util/Date;
        ((Date)localObject1).<init>(paramLong);
        localObject2 = Calendar.getInstance();
        ((Calendar)localObject2).setTime((Date)localObject1);
        localCalendar = Calendar.getInstance();
        paramLong = localCalendar.getTimeInMillis();
        l = ((Calendar)localObject2).getTimeInMillis();
        if (paramLong - l > 3600000L) {
          continue;
        }
        localObject1 = String.format(this.i, new Object[] { Long.valueOf((paramLong - l) / 60000L + 1L) });
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject2;
        Calendar localCalendar;
        long l;
        int m;
        String str = "";
        continue;
      }
      return (String)localObject1;
      m = ((Calendar)localObject2).get(5);
      if ((localCalendar.get(5) == m) && (paramLong - l <= 86400000L))
      {
        if (((Calendar)localObject2).get(11) <= 12)
        {
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>();
          localObject1 = this.j + this.e.format((Date)localObject1);
        }
        else
        {
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>();
          localObject1 = this.k + this.e.format((Date)localObject1);
        }
      }
      else {
        localObject1 = this.f.format((Date)localObject1);
      }
    }
  }
  
  public static boolean b(List<a> paramList)
  {
    boolean bool = false;
    int m = 0;
    if (m < paramList.size()) {
      if (((a)paramList.get(m)).b() != 0) {}
    }
    for (;;)
    {
      return bool;
      m++;
      break;
      bool = true;
    }
  }
  
  public final void a()
  {
    for (int m = 0; m < this.b.size(); m++)
    {
      a locala = (a)this.b.get(m);
      if (locala.b() == 0) {
        locala.b(1);
      }
    }
    notifyDataSetChanged();
  }
  
  public final void a(int paramInt)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (paramInt == ((a)localIterator.next()).a()) {
        localIterator.remove();
      }
    }
    notifyDataSetChanged();
    if ((this.b.size() == 0) && (this.d != null)) {
      this.d.setVisibility(0);
    }
  }
  
  public final void a(RelativeLayout paramRelativeLayout)
  {
    this.d = paramRelativeLayout;
  }
  
  public final void a(List<a> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (;;)
    {
      return;
      this.b = paramList;
      notifyDataSetChanged();
    }
  }
  
  public final int getCount()
  {
    return this.b.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.b.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    a locala;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.a).inflate(R.layout.settings_push_message_list_adapter, null);
      paramViewGroup = new a(paramView);
      paramView.setTag(paramViewGroup);
      locala = (a)this.b.get(paramInt);
      if (locala.b() != 0) {
        break label169;
      }
      paramViewGroup.a.setVisibility(0);
      label64:
      String str = locala.g();
      if ((str == null) || (str.length() <= 0)) {
        break label181;
      }
      paramViewGroup.d.setVisibility(0);
      paramViewGroup.d.setImageDrawable(null);
      this.c.a(locala.g(), paramViewGroup.d);
    }
    for (;;)
    {
      paramViewGroup.b.setText(locala.e());
      paramViewGroup.c.setText(a(locala.h()));
      paramViewGroup.e.setText(locala.f());
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label169:
      paramViewGroup.a.setVisibility(8);
      break label64;
      label181:
      paramViewGroup.d.setVisibility(8);
    }
  }
  
  static final class a
  {
    View a;
    TextView b;
    TextView c;
    ImageView d;
    TextView e;
    
    a(View paramView)
    {
      this.a = paramView.findViewById(R.id.settings_iv_new);
      this.b = ((TextView)paramView.findViewById(R.id.settings_tv_title));
      this.c = ((TextView)paramView.findViewById(R.id.settings_tv_time));
      this.d = ((ImageView)paramView.findViewById(R.id.settings_iv_icon));
      this.e = ((TextView)paramView.findViewById(R.id.settings_tv_content));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/push/ui/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */