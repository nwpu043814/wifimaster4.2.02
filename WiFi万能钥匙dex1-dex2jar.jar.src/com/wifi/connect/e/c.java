package com.wifi.connect.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextSwitcher;
import com.bluefay.b.h;
import com.lantern.connect.R.anim;
import com.lantern.connect.R.drawable;
import com.lantern.core.k;
import com.wifi.connect.d.j;
import com.wifi.connect.model.h.a;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

public final class c
{
  private final int a = 1;
  private final int b = 2;
  private final String c = "cached_data";
  private final String d = "id";
  private final String e = "title";
  private final String f = "source";
  private final String g = "color";
  private final String h = "url";
  private final byte[] i = new byte[0];
  private Context j;
  private View k;
  private View l;
  private TextSwitcher m;
  private ArrayList<h.a> n;
  private h.a o;
  private int p;
  private Handler q;
  private int r = 7100;
  private boolean s = false;
  private HashSet<String> t;
  
  public c(Context paramContext, View paramView)
  {
    this.j = paramContext;
    this.k = paramView;
    this.t = new HashSet();
    this.n = new ArrayList();
    this.p = -1;
    for (;;)
    {
      try
      {
        paramView = this.j.getSharedPreferences(e(), 0).getString("cached_data", "");
        boolean bool = TextUtils.isEmpty(paramView);
        if (!bool) {
          continue;
        }
      }
      catch (Exception paramContext)
      {
        h.a(paramContext);
        continue;
      }
      paramView = new ImageView(this.j);
      paramContext = new LinearLayout.LayoutParams(-2, -2);
      paramContext.gravity = 19;
      paramContext.setMargins(0, 0, (int)TypedValue.applyDimension(1, 12.0F, this.j.getResources().getDisplayMetrics()), 0);
      paramContext.gravity = 16;
      paramView.setImageResource(R.drawable.connect_trumpet_icon);
      paramView.setLayoutParams(paramContext);
      ((ViewGroup)this.k).addView(paramView);
      this.m = new TextSwitcher(this.j);
      this.m.setFactory(new d(this));
      paramView = AnimationUtils.loadAnimation(this.j, R.anim.connect_bottom_in);
      paramContext = AnimationUtils.loadAnimation(this.j, R.anim.connect_top_out);
      this.m.setInAnimation(paramView);
      this.m.setOutAnimation(paramContext);
      this.m.setOnClickListener(new e(this));
      ((ViewGroup)this.k).addView(this.m);
      paramContext = new LinearLayout.LayoutParams(-2, -2);
      this.m.setLayoutParams(paramContext);
      this.q = new Handler(new f(this));
      this.k.setVisibility(8);
      if (this.n.size() > 0)
      {
        this.q.sendEmptyMessageDelayed(1, this.r);
        this.s = true;
      }
      return;
      paramContext = new org/json/JSONArray;
      paramContext.<init>(paramView);
      this.n = a(paramContext);
    }
  }
  
  private static ArrayList<h.a> a(JSONArray paramJSONArray)
  {
    Object localObject;
    if (paramJSONArray.length() == 0)
    {
      localObject = null;
      return (ArrayList<h.a>)localObject;
    }
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    int i2 = paramJSONArray.length();
    for (;;)
    {
      localObject = localArrayList;
      if (i1 >= i2) {
        break;
      }
      localObject = paramJSONArray.optJSONObject(i1);
      if (localObject != null)
      {
        h.a locala = new h.a();
        locala.a = ((JSONObject)localObject).optString("id");
        locala.b = ((JSONObject)localObject).optString("title");
        locala.c = ((JSONObject)localObject).optString("source");
        locala.d = ((JSONObject)localObject).optString("color");
        locala.e = ((JSONObject)localObject).optString("url");
        localArrayList.add(locala);
      }
      i1++;
    }
  }
  
  private static String e()
  {
    if (k.c().equalsIgnoreCase("cn")) {}
    for (String str = "trumpet_json_cn";; str = "trumpet_json_en") {
      return str;
    }
  }
  
  public final void a()
  {
    new j(new g(this)).execute(new String[0]);
  }
  
  public final void a(View paramView)
  {
    this.l = paramView;
  }
  
  public final void b()
  {
    h.a("onResume", new Object[0]);
    if ((this.s) || (this.n.size() == 0)) {}
    for (;;)
    {
      return;
      this.s = true;
      this.q.removeMessages(1);
      this.q.sendEmptyMessageDelayed(1, this.r);
    }
  }
  
  public final void c()
  {
    h.a("onPause", new Object[0]);
    this.s = false;
    this.q.removeCallbacksAndMessages(null);
    this.t.clear();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/e/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */