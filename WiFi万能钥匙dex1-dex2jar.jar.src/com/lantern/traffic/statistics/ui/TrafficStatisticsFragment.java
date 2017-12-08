package com.lantern.traffic.statistics.ui;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.os.AsyncTask.Status;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.lantern.base.ui.BaseFragment;
import com.lantern.settings.R.id;
import com.lantern.settings.R.layout;
import com.lantern.settings.R.string;
import com.lantern.traffic.statistics.b.c;
import com.lantern.traffic.statistics.ui.widget.WaveView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TrafficStatisticsFragment
  extends BaseFragment
{
  private ListView g;
  private com.lantern.traffic.statistics.ui.a.a h;
  private TextView i;
  private TextView j;
  private TextView k;
  private TextView l;
  private WaveView m;
  private WaveView n;
  private a o;
  private PackageManager p;
  private boolean q = true;
  private View.OnClickListener r = new a(this);
  
  private boolean b(String paramString)
  {
    boolean bool = false;
    try
    {
      paramString = this.p.getApplicationInfo(paramString, 0);
      if (paramString != null) {
        bool = true;
      }
      return bool;
    }
    catch (PackageManager.NameNotFoundException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramString = null;
      }
    }
  }
  
  private void d(int paramInt)
  {
    if (this.o == null)
    {
      this.o = new a((byte)0);
      if (paramInt != 1) {
        break label83;
      }
      this.o.execute(new Integer[] { Integer.valueOf(paramInt) });
    }
    for (;;)
    {
      return;
      if (this.o.getStatus() != AsyncTask.Status.FINISHED) {
        this.o.cancel(true);
      }
      this.o = new a((byte)0);
      break;
      label83:
      if (paramInt == 2) {
        this.o.execute(new Integer[] { Integer.valueOf(paramInt) });
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.p = this.e.getPackageManager();
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.traffic_fragment_statistics, paramViewGroup, false);
    a(R.string.traffic_statistics_title);
    this.m = ((WaveView)paramLayoutInflater.findViewById(R.id.waveView));
    this.n = ((WaveView)paramLayoutInflater.findViewById(R.id.waveView2));
    this.n.setAlpha(0.5F);
    this.m.a(4000);
    this.n.a(7000);
    this.j = ((TextView)paramLayoutInflater.findViewById(R.id.saveTrafficDescription));
    this.k = ((TextView)paramLayoutInflater.findViewById(R.id.getTrafficByDay));
    this.l = ((TextView)paramLayoutInflater.findViewById(R.id.getTrafficByMonth));
    this.i = ((TextView)paramLayoutInflater.findViewById(R.id.saveTrafficCount));
    this.g = ((ListView)paramLayoutInflater.findViewById(R.id.listView));
    this.h = new com.lantern.traffic.statistics.ui.a.a(getActivity());
    this.g.setAdapter(this.h);
    this.l.setOnClickListener(this.r);
    this.k.setOnClickListener(this.r);
    d(2);
    return paramLayoutInflater;
  }
  
  private final class a
    extends AsyncTask<Integer, Void, Void>
  {
    private List<c> b;
    private long[] c;
    private int d;
    private long e = 0L;
    
    private a() {}
    
    private Void a(Integer... paramVarArgs)
    {
      if (TrafficStatisticsFragment.c(TrafficStatisticsFragment.this))
      {
        com.lantern.traffic.statistics.c.a.a().h();
        TrafficStatisticsFragment.d(TrafficStatisticsFragment.this);
      }
      this.d = paramVarArgs[0].intValue();
      Object localObject = Calendar.getInstance();
      paramVarArgs = com.lantern.traffic.statistics.a.a.a(this.d, ((Calendar)localObject).get(1), ((Calendar)localObject).get(2) + 1, ((Calendar)localObject).get(5));
      this.c = com.lantern.traffic.statistics.a.a.b(this.d, ((Calendar)localObject).get(1), ((Calendar)localObject).get(2) + 1, ((Calendar)localObject).get(5));
      this.b = new ArrayList();
      paramVarArgs = paramVarArgs.iterator();
      while (paramVarArgs.hasNext())
      {
        localObject = (c)paramVarArgs.next();
        if (localObject != null) {
          if ((!TextUtils.isEmpty(((c)localObject).b())) && (TrafficStatisticsFragment.b(TrafficStatisticsFragment.this, ((c)localObject).b())))
          {
            this.b.add(localObject);
          }
          else
          {
            long[] arrayOfLong = this.c;
            arrayOfLong[0] -= ((c)localObject).d();
            arrayOfLong = this.c;
            arrayOfLong[1] -= ((c)localObject).e();
          }
        }
      }
      Collections.sort(this.b, new b(this));
      long l = System.currentTimeMillis();
      if (l - this.e < 500L) {}
      try
      {
        Thread.sleep(500L - (l - this.e));
        return null;
      }
      catch (Exception paramVarArgs)
      {
        for (;;) {}
      }
    }
    
    protected final void onPreExecute()
    {
      this.e = System.currentTimeMillis();
      TrafficStatisticsFragment.a(TrafficStatisticsFragment.this, TrafficStatisticsFragment.this.getString(R.string.traffic_statistics_loading));
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/traffic/statistics/ui/TrafficStatisticsFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */