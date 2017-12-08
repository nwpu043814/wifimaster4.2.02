package com.lantern.wifitools.examination;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import bluefay.app.Fragment;
import bluefay.app.u;
import com.bluefay.widget.ActionTopBarView;
import com.lantern.wifiseccheck.protocol.ApMarkResult;
import com.lantern.wifiseccheck.protocol.ApNeighbourRes;
import com.lantern.wifiseccheck.protocol.Neighbour;
import com.lantern.wifitools.R.color;
import com.lantern.wifitools.R.drawable;
import com.lantern.wifitools.R.id;
import com.lantern.wifitools.R.layout;
import com.lantern.wifitools.R.string;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ExamDeviceFragment
  extends Fragment
{
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    c(R.color.exam_blue);
    a(getString(R.string.exam_result_find_devices_title));
    b().a(null);
    Object localObject1 = new u(this.e);
    ((Menu)localObject1).add(101, 1001, 0, "Help").setIcon(R.drawable.checking_device_help);
    a(a, (Menu)localObject1);
    if (getArguments() != null)
    {
      localObject1 = getArguments();
      ApNeighbourRes localApNeighbourRes = ((ExaminationActivity)getActivity()).f().getNeighbourRes();
      paramBundle = localApNeighbourRes.getVendorMap();
      paramViewGroup = (ListView)paramLayoutInflater.inflate(R.layout.wifitools_exam_device, paramViewGroup, false);
      View localView = paramLayoutInflater.inflate(R.layout.wifitools_exam_device_header, paramViewGroup, false);
      paramLayoutInflater = new ArrayList();
      paramBundle = paramBundle.entrySet().iterator();
      Object localObject3;
      Object localObject2;
      b localb;
      while (paramBundle.hasNext())
      {
        localObject3 = (Map.Entry)paramBundle.next();
        localObject2 = (String)((Map.Entry)localObject3).getKey();
        Iterator localIterator = ((List)((Map.Entry)localObject3).getValue()).iterator();
        while (localIterator.hasNext())
        {
          localObject3 = (Neighbour)localIterator.next();
          localb = new b((byte)0);
          localb.c = ((Neighbour)localObject3).getIp();
          localb.a = ((Neighbour)localObject3).getMac();
          localb.b = ((Neighbour)localObject3).getVendor();
          localb.d = ((String)localObject2);
          paramLayoutInflater.add(localb);
        }
      }
      paramBundle = ((WifiManager)com.lantern.core.c.getInstance().getSystemService("wifi")).getConnectionInfo();
      if (paramBundle != null)
      {
        int i = paramBundle.getIpAddress();
        paramBundle = new ArrayList();
        localObject2 = new ArrayList();
        localObject3 = paramLayoutInflater.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localb = (b)((Iterator)localObject3).next();
          if (localb.c == i)
          {
            paramBundle.add(localb);
            ((Iterator)localObject3).remove();
          }
          else if ("UNKNOWN_DEVICE".equals(localb.d))
          {
            ((List)localObject2).add(localb);
            ((Iterator)localObject3).remove();
          }
        }
        paramLayoutInflater = paramLayoutInflater.iterator();
        while (paramLayoutInflater.hasNext()) {
          paramBundle.add((b)paramLayoutInflater.next());
        }
        paramBundle.addAll((Collection)localObject2);
        paramLayoutInflater = paramBundle;
        ((TextView)localView.findViewById(R.id.device_count)).setText(String.format(getString(R.string.exam_device_title), new Object[] { Integer.valueOf(paramLayoutInflater.size()) }));
        ((TextView)localView.findViewById(R.id.wifi_name)).setText(((Bundle)localObject1).getString("ssid"));
        paramViewGroup.addHeaderView(localView);
        paramViewGroup.setAdapter(new a(paramLayoutInflater, localApNeighbourRes));
        paramViewGroup.setDivider(null);
      }
    }
    for (paramLayoutInflater = paramViewGroup;; paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle))
    {
      return paramLayoutInflater;
      break;
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 1001)
    {
      r.a(getActivity(), "http://static.51y5.net/client_page/examination/intro.html");
      com.lantern.analytics.a.e().onEvent("tipscli");
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  private final class a
    extends BaseAdapter
  {
    private List<ExamDeviceFragment.b> b;
    private Map<String, String> c;
    private String d;
    private boolean e;
    
    public a(ApNeighbourRes paramApNeighbourRes)
    {
      this.b = paramApNeighbourRes;
      Object localObject;
      this.c = ((ApNeighbourRes)localObject).getVendorLogo();
      this.d = ("http://eval.swaqds.com:8080/" + ((ApNeighbourRes)localObject).getLogoRelativePath());
      if (((ApNeighbourRes)localObject).getNetState() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.e = bool;
        return;
      }
    }
    
    private ExamDeviceFragment.b a(int paramInt)
    {
      return (ExamDeviceFragment.b)this.b.get(paramInt);
    }
    
    public final int getCount()
    {
      return this.b.size();
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (ExamDeviceFragment.this.getActivity() == null) {}
      for (;;)
      {
        return paramView;
        label128:
        ExamDeviceFragment.b localb;
        label287:
        String str;
        if (paramView == null)
        {
          paramView = LayoutInflater.from(ExamDeviceFragment.this.getActivity()).inflate(R.layout.wifitools_exam_device_item, paramViewGroup, false);
          paramViewGroup = new a((byte)0);
          paramViewGroup.a = ((TextView)paramView.findViewById(R.id.name));
          paramViewGroup.b = ((TextView)paramView.findViewById(R.id.ip));
          paramViewGroup.c = ((TextView)paramView.findViewById(R.id.self));
          paramViewGroup.d = paramView.findViewById(R.id.self_layout);
          paramViewGroup.e = paramView.findViewById(R.id.divider);
          paramViewGroup.f = ((ImageView)paramView.findViewById(R.id.icon));
          paramView.setTag(paramViewGroup);
          localb = a(paramInt);
          if (!this.e) {
            break label470;
          }
          if ((TextUtils.isEmpty(localb.d)) || ("UNKNOWN_DEVICE".equals(localb.d))) {
            localb.d = ExamDeviceFragment.this.getString(R.string.exam_device_unknown);
          }
          paramViewGroup.b.setText(String.format(ExamDeviceFragment.this.getString(R.string.exam_device_ip), new Object[] { r.a(a(paramInt).c) }));
          if (!this.c.containsKey(localb.d)) {
            break label457;
          }
          com.lantern.core.imageloader.c.a(ExamDeviceFragment.this.getActivity(), this.d + (String)this.c.get(localb.d), paramViewGroup.f);
          paramViewGroup.a.setText(localb.d);
          Object localObject = ExamDeviceFragment.this.getActivity();
          str = localb.a;
          localObject = ((Context)localObject).getSharedPreferences("device_remark", 0);
          if ((localObject == null) || (TextUtils.isEmpty(str))) {
            break label518;
          }
          str = ((SharedPreferences)localObject).getString(str, null);
          label350:
          if (!TextUtils.isEmpty(str)) {
            paramViewGroup.a.setText(str);
          }
          if (paramInt != 0) {
            break label524;
          }
          paramViewGroup.c.setText(ExamDeviceFragment.this.getString(R.string.exam_device_mine));
          paramViewGroup.c.setTextColor(ExamDeviceFragment.this.getResources().getColor(R.color.exam_blue));
          paramViewGroup.c.setBackgroundDrawable(null);
          paramViewGroup.d.setOnClickListener(null);
        }
        for (;;)
        {
          if (paramInt != getCount() - 1) {
            break label602;
          }
          paramViewGroup.e.setVisibility(8);
          break;
          paramViewGroup = (a)paramView.getTag();
          break label128;
          label457:
          paramViewGroup.f.setImageResource(R.drawable.icon_default);
          break label287;
          label470:
          localb.d = r.a(localb.c);
          paramViewGroup.b.setText(String.format(ExamDeviceFragment.this.getString(R.string.exam_device_mac), new Object[] { localb.a }));
          break label287;
          label518:
          str = null;
          break label350;
          label524:
          paramViewGroup.c.setText(ExamDeviceFragment.this.getString(R.string.exam_device_remark));
          paramViewGroup.c.setTextColor(ExamDeviceFragment.this.getResources().getColor(R.color.exam_gray));
          paramViewGroup.c.setBackgroundDrawable(ExamDeviceFragment.this.getResources().getDrawable(R.drawable.exam_result_remark_selector));
          paramViewGroup.d.setOnClickListener(new a(this, localb, paramViewGroup));
        }
        label602:
        paramViewGroup.e.setVisibility(0);
      }
    }
    
    private final class a
    {
      TextView a;
      TextView b;
      TextView c;
      View d;
      View e;
      ImageView f;
      
      private a() {}
    }
  }
  
  private final class b
  {
    public String a;
    public String b;
    public int c;
    public String d;
    
    private b() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifitools/examination/ExamDeviceFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */