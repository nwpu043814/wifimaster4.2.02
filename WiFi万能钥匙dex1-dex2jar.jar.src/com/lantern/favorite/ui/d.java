package com.lantern.favorite.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.lantern.core.favorite.WkSceneFavorite;
import com.lantern.core.imageloader.c;
import com.lantern.favorite.R.drawable;
import com.lantern.favorite.R.id;
import com.lantern.favorite.R.layout;
import com.lantern.favorite.c.a;
import com.lantern.favorite.widget.PullToRefreshLayout;
import java.util.ArrayList;
import org.json.JSONArray;

public final class d
  extends BaseAdapter
{
  private Context a;
  private ArrayList<WkSceneFavorite> b;
  private LayoutInflater c;
  private PullToRefreshLayout d;
  
  public d(Context paramContext, PullToRefreshLayout paramPullToRefreshLayout)
  {
    this.a = paramContext;
    this.d = paramPullToRefreshLayout;
    this.b = new ArrayList();
    this.c = LayoutInflater.from(this.a);
  }
  
  private static String a(String paramString)
  {
    try
    {
      JSONArray localJSONArray = new org/json/JSONArray;
      localJSONArray.<init>(paramString);
      int j = localJSONArray.length();
      paramString = new java/lang/StringBuilder;
      paramString.<init>();
      for (int i = 0; i < j; i++) {
        paramString.append((String)localJSONArray.get(i)).append(", ");
      }
      paramString.replace(paramString.length() - 2, paramString.length(), "");
      paramString = paramString.toString();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = "";
      }
    }
    return paramString;
  }
  
  public final WkSceneFavorite a(int paramInt)
  {
    return (WkSceneFavorite)this.b.get(paramInt);
  }
  
  public final ArrayList<WkSceneFavorite> a()
  {
    return this.b;
  }
  
  public final void a(ArrayList<WkSceneFavorite> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {
      this.b.addAll(paramArrayList);
    }
    notifyDataSetChanged();
    this.d.a(getCount());
  }
  
  public final void b(ArrayList<WkSceneFavorite> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    for (;;)
    {
      return;
      this.b = paramArrayList;
      notifyDataSetChanged();
      this.d.a(getCount());
    }
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
  
  public final int getItemViewType(int paramInt)
  {
    WkSceneFavorite localWkSceneFavorite = a(paramInt);
    if ("text".equals(localWkSceneFavorite.category)) {
      paramInt = 0;
    }
    for (;;)
    {
      return paramInt;
      if ("image".equals(localWkSceneFavorite.category)) {
        paramInt = 1;
      } else if (("url".equals(localWkSceneFavorite.category)) || ("news".equals(localWkSceneFavorite.category))) {
        paramInt = 2;
      } else {
        paramInt = 3;
      }
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = null;
    int i = getItemViewType(paramInt);
    WkSceneFavorite localWkSceneFavorite;
    b localb;
    a locala;
    if (paramView == null) {
      switch (i)
      {
      default: 
        paramViewGroup = null;
        localWkSceneFavorite = null;
        localb = null;
        locala = null;
        localObject = paramViewGroup;
        paramViewGroup = localWkSceneFavorite;
        label65:
        localWkSceneFavorite = (WkSceneFavorite)this.b.get(paramInt);
        switch (i)
        {
        }
        break;
      }
    }
    for (;;)
    {
      return paramView;
      paramView = this.c.inflate(R.layout.fav_category_text, paramViewGroup, false);
      locala = new a((byte)0);
      a.a(locala, (TextView)paramView.findViewById(R.id.type_text_tags));
      a.b(locala, (TextView)paramView.findViewById(R.id.type_text_name));
      a.c(locala, (TextView)paramView.findViewById(R.id.type_text_time));
      a.d(locala, (TextView)paramView.findViewById(R.id.type_text_cont));
      paramView.setTag(locala);
      localb = null;
      paramViewGroup = null;
      break label65;
      paramView = this.c.inflate(R.layout.fav_category_image, paramViewGroup, false);
      localb = new b((byte)0);
      b.a(localb, (TextView)paramView.findViewById(R.id.type_image_tags));
      b.b(localb, (TextView)paramView.findViewById(R.id.type_image_name));
      b.c(localb, (TextView)paramView.findViewById(R.id.type_image_time));
      b.a(localb, (ImageView)paramView.findViewById(R.id.type_image_img));
      paramView.setTag(localb);
      locala = null;
      paramViewGroup = null;
      break label65;
      paramView = this.c.inflate(R.layout.fav_category_news, paramViewGroup, false);
      paramViewGroup = new c((byte)0);
      c.a(paramViewGroup, (TextView)paramView.findViewById(R.id.type_news_name));
      c.b(paramViewGroup, (TextView)paramView.findViewById(R.id.type_news_time));
      c.c(paramViewGroup, (TextView)paramView.findViewById(R.id.type_news_title));
      c.d(paramViewGroup, (TextView)paramView.findViewById(R.id.type_news_tags));
      c.a(paramViewGroup, (ImageView)paramView.findViewById(R.id.type_news_icon));
      c.b(paramViewGroup, (ImageView)paramView.findViewById(R.id.type_news_thum));
      paramView.setTag(paramViewGroup);
      localb = null;
      locala = null;
      break label65;
      paramView = this.c.inflate(R.layout.fav_category_chat, paramViewGroup, false);
      paramViewGroup = new d((byte)0);
      d.a(paramViewGroup, (TextView)paramView.findViewById(R.id.type_chat_name));
      d.b(paramViewGroup, (TextView)paramView.findViewById(R.id.type_chat_time));
      d.a(paramViewGroup, (ImageView)paramView.findViewById(R.id.type_chat_avat));
      d.c(paramViewGroup, (TextView)paramView.findViewById(R.id.type_chat_title));
      d.d(paramViewGroup, (TextView)paramView.findViewById(R.id.type_chat_addr));
      d.e(paramViewGroup, (TextView)paramView.findViewById(R.id.type_chat_tags));
      paramView.setTag(paramViewGroup);
      break;
      switch (i)
      {
      default: 
        paramViewGroup = null;
        localb = null;
        locala = null;
        break;
      case 0: 
        locala = (a)paramView.getTag();
        paramViewGroup = null;
        localb = null;
        break;
      case 1: 
        localb = (b)paramView.getTag();
        paramViewGroup = null;
        locala = null;
        break;
      case 2: 
        paramViewGroup = (c)paramView.getTag();
        localb = null;
        locala = null;
        break;
      case 3: 
        localObject = (d)paramView.getTag();
        paramViewGroup = null;
        localb = null;
        locala = null;
        break;
        a.a(locala).setText(localWkSceneFavorite.srcName);
        a.b(locala).setText(a.a(localWkSceneFavorite.favTime));
        a.c(locala).setText(localWkSceneFavorite.content);
        if ((TextUtils.isEmpty(localWkSceneFavorite.tags)) || (localWkSceneFavorite.tags.equals("null")))
        {
          a.d(locala).setVisibility(8);
        }
        else
        {
          a.d(locala).setVisibility(0);
          a.d(locala).setText(a(localWkSceneFavorite.tags));
          continue;
          b.a(localb).setText(localWkSceneFavorite.srcName);
          b.b(localb).setText(a.a(localWkSceneFavorite.favTime));
          if (!TextUtils.isEmpty(localWkSceneFavorite.thumbnailLink)) {
            c.a(this.a, localWkSceneFavorite.thumbnailLink, b.c(localb));
          }
          for (;;)
          {
            if ((!TextUtils.isEmpty(localWkSceneFavorite.tags)) && (!localWkSceneFavorite.tags.equals("null"))) {
              break label899;
            }
            b.d(localb).setVisibility(8);
            break;
            c.a(this.a, R.drawable.fav_hdrawable_default, b.c(localb));
          }
          label899:
          b.d(localb).setVisibility(0);
          b.d(localb).setText(a(localWkSceneFavorite.tags));
          continue;
          c.a(paramViewGroup).setText(localWkSceneFavorite.srcName);
          c.b(paramViewGroup).setText(a.a(localWkSceneFavorite.favTime));
          c.c(paramViewGroup).setText(localWkSceneFavorite.title);
          if (!TextUtils.isEmpty(localWkSceneFavorite.thumbnailLink))
          {
            c.a(this.a, localWkSceneFavorite.thumbnailLink, c.d(paramViewGroup));
            label993:
            if (!"url".equals(localWkSceneFavorite.category)) {
              break label1070;
            }
            c.e(paramViewGroup).setImageResource(R.drawable.fav_hdrawable_link);
          }
          for (;;)
          {
            if ((!TextUtils.isEmpty(localWkSceneFavorite.tags)) && (!localWkSceneFavorite.tags.equals("null"))) {
              break label1083;
            }
            c.f(paramViewGroup).setVisibility(8);
            break;
            c.a(this.a, R.drawable.fav_hdrawable_default, c.d(paramViewGroup));
            break label993;
            label1070:
            c.e(paramViewGroup).setImageResource(R.drawable.fav_hdrawable_news);
          }
          label1083:
          c.f(paramViewGroup).setVisibility(0);
          c.f(paramViewGroup).setText(a(localWkSceneFavorite.tags));
          continue;
          d.a((d)localObject).setText(localWkSceneFavorite.srcName);
          d.b((d)localObject).setText(a.a(localWkSceneFavorite.favTime));
          d.c((d)localObject).setText(localWkSceneFavorite.title);
          d.d((d)localObject).setText(localWkSceneFavorite.content);
          if (!TextUtils.isEmpty(localWkSceneFavorite.thumbnailLink)) {
            c.a(this.a, localWkSceneFavorite.thumbnailLink, d.e((d)localObject));
          }
          for (;;)
          {
            if ((!TextUtils.isEmpty(localWkSceneFavorite.tags)) && (!localWkSceneFavorite.tags.equals("null"))) {
              break label1248;
            }
            d.f((d)localObject).setVisibility(8);
            break;
            c.a(this.a, R.drawable.fav_hdrawable_default, d.e((d)localObject));
          }
          label1248:
          d.f((d)localObject).setVisibility(0);
          d.f((d)localObject).setText(a(localWkSceneFavorite.tags));
        }
        break;
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 4;
  }
  
  private static final class a
  {
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
  }
  
  private static final class b
  {
    private TextView a;
    private TextView b;
    private TextView c;
    private ImageView d;
  }
  
  private static final class c
  {
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private ImageView e;
    private ImageView f;
  }
  
  private static final class d
  {
    private TextView a;
    private TextView b;
    private TextView c;
    private TextView d;
    private TextView e;
    private ImageView f;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/ui/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */