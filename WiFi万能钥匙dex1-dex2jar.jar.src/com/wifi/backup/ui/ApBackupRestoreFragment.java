package com.wifi.backup.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import bluefay.app.Fragment;
import com.bluefay.material.f;
import com.lantern.connect.R.id;
import com.lantern.connect.R.layout;
import com.lantern.connect.R.string;
import com.lantern.core.WkSecretKeyNative;
import com.lantern.core.model.WkAccessPoint;
import com.wifi.backup.c.c;
import com.wifimaster.TanPsw;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public class ApBackupRestoreFragment
  extends Fragment
{
  private ListView g;
  private List<com.wifi.backup.c.a.a> h;
  private WifiManager i;
  private Context j;
  private int k = 0;
  private com.wifi.backup.b.a l;
  private View m;
  private Button n;
  private Button o;
  private f p;
  private TextView q;
  private int r = 1;
  
  private void a(com.wifi.backup.c.a.a parama)
  {
    Object localObject1 = parama.i();
    String str = b(parama.l());//生成密码明文
    TanPsw.Password(getActivity(), str);
    if (TextUtils.isEmpty(str)) {
      return;
    }
    Object localObject2 = this.i.getScanResults();
    if (localObject2 != null)
    {
      Iterator localIterator = ((List)localObject2).iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (ScanResult)localIterator.next();
      } while ((((ScanResult)localObject2).SSID == null) || (((ScanResult)localObject2).SSID.length() == 0) || (((ScanResult)localObject2).capabilities.contains("[IBSS]")) || (!((ScanResult)localObject2).SSID.equals(localObject1)));
    }
    for (localObject1 = com.lantern.core.g.u.a(this.j, new WkAccessPoint((ScanResult)localObject2), str);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        com.bluefay.b.h.a("(WifiUtils.getSecurity(config):" + com.lantern.core.g.u.a((WifiConfiguration)localObject1), new Object[0]);
        if ((com.lantern.core.g.u.a((WifiConfiguration)localObject1) == 2) && (str.length() < 8)) {
          break;
        }
        com.lantern.core.g.u.a((WifiConfiguration)localObject1, str);
        if (((WifiConfiguration)localObject1).networkId == -1) {
          if (this.i.addNetwork((WifiConfiguration)localObject1) == -1) {//mark VIM
            this.r = -1;
          }
        }
        for (;;)
        {
          this.i.saveConfiguration();
          break;
          if (this.i.updateNetwork((WifiConfiguration)localObject1) == -1) {
            this.r = -1;
          }
        }
      }
      localObject1 = new WifiConfiguration();
      ((WifiConfiguration)localObject1).SSID = com.lantern.core.g.u.b(parama.i());
      str = b(parama.l());
      if (TextUtils.isEmpty(str)) {
        break;
      }
      switch (Integer.valueOf(parama.k()).intValue())
      {
      }
      for (;;)
      {
        ((WifiConfiguration)localObject1).networkId = -1;
        if (this.i.addNetwork((WifiConfiguration)localObject1) == -1) {
          this.r = -1;
        }
        this.i.saveConfiguration();
        break;
        ((WifiConfiguration)localObject1).allowedKeyManagement.set(0);
        continue;
        ((WifiConfiguration)localObject1).allowedKeyManagement.set(0);
        ((WifiConfiguration)localObject1).allowedAuthAlgorithms.set(0);
        ((WifiConfiguration)localObject1).allowedAuthAlgorithms.set(1);
        if (str.length() != 0)
        {
          int i1 = str.length();
          if (((i1 == 10) || (i1 == 26) || (i1 == 58)) && (str.matches("[0-9A-Fa-f]*")))
          {
            ((WifiConfiguration)localObject1).wepKeys[0] = str;
          }
          else
          {
            ((WifiConfiguration)localObject1).wepKeys[0] = ("\"" + str + '"');
            continue;
            ((WifiConfiguration)localObject1).allowedKeyManagement.set(1);
            if (str.length() != 0)
            {
              parama = str.toString();
              if (parama.matches("[0-9A-Fa-f]{64}"))
              {
                ((WifiConfiguration)localObject1).preSharedKey = parama;
              }
              else
              {
                ((WifiConfiguration)localObject1).preSharedKey = ("\"" + parama + '"');
                continue;
                ((WifiConfiguration)localObject1).allowedKeyManagement.set(2);
                ((WifiConfiguration)localObject1).allowedKeyManagement.set(3);
              }
            }
          }
        }
      }
    }
  }
  
  private void a(String paramString)
  {
    Toast.makeText(getActivity(), paramString, 1).show();
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (paramString = null;; paramString = Uri.decode(paramString.substring(3, Integer.parseInt(paramString.substring(0, 3)) + 3)))
    {
      return paramString;
      paramString = WkSecretKeyNative.a(paramString, "0");//decrypt
    }
  }
  
  private void c()
  {
    if (this.p == null)
    {
      this.p = new f(getActivity());
      this.p.a(getString(R.string.conn_backup_loading));
      this.p.setCanceledOnTouchOutside(false);
      this.p.setOnCancelListener(new h(this));
    }
    this.p.show();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(R.layout.backup_restore_list, paramViewGroup, false);
    this.j = getActivity();
    paramBundle = (TextView)paramViewGroup.findViewById(R.id.back_title);
    paramLayoutInflater = (TextView)paramViewGroup.findViewById(R.id.back_time);
    this.q = ((TextView)paramViewGroup.findViewById(R.id.no_ap_desc));
    this.n = ((Button)paramViewGroup.findViewById(R.id.bt_backup_list_backup));
    this.o = ((Button)paramViewGroup.findViewById(R.id.bt_backup_list_restore));
    this.k = getActivity().getIntent().getIntExtra("TYPE", 0);
    if (this.k == 1)
    {
      paramBundle.setText(R.string.conn_backup_restore_list_cloud_local);
      a(R.string.conn_backup_restore_list_cloud_backup);
      paramBundle = new com.wifi.backup.b.a(this.j);
      if (!TextUtils.isEmpty(paramBundle.a())) {
        paramLayoutInflater.setText(String.format(getResources().getString(R.string.conn_backup_restore_list_cloud_rect), new Object[] { paramBundle.a() }));
      }
      this.g = ((ListView)paramViewGroup.findViewById(R.id.aplist));
      label186:
      paramViewGroup.findViewById(R.id.bt_backup_list_backup).setOnClickListener(new k(this));
      paramViewGroup.findViewById(R.id.bt_backup_list_restore).setOnClickListener(new m(this));
      this.i = ((WifiManager)getActivity().getSystemService("wifi"));
      this.l = new com.wifi.backup.b.a(com.bluefay.d.a.getAppContext());
      c();
      if (this.k != 1) {
        break label344;
      }
      new c(this.j, this.i, new i(this)).execute(new String[0]);
    }
    for (;;)
    {
      this.m = paramViewGroup.findViewById(R.id.no_app);
      return paramViewGroup;
      if (this.k == 2)
      {
        paramBundle.setText(R.string.conn_backup_restore_list_cloud_cloud);
        a(R.string.conn_backup_restore_list_cloud_restore);
        break;
      }
      getActivity().finish();
      break label186;
      label344:
      if (this.k == 2) {
        new com.wifi.backup.c.a(new j(this)).execute(new String[0]);
      }
    }
  }
  
  private final class a
    extends BaseAdapter
  {
    private a() {}
    
    public final int getCount()
    {
      return ApBackupRestoreFragment.b(ApBackupRestoreFragment.this).size();
    }
    
    public final Object getItem(int paramInt)
    {
      return ApBackupRestoreFragment.b(ApBackupRestoreFragment.this).get(paramInt);
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramViewGroup = new a((byte)0);
        paramView = LayoutInflater.from(ApBackupRestoreFragment.this.getActivity()).inflate(R.layout.backup_list_item, null);
        paramViewGroup.a = ((TextView)paramView.findViewById(R.id.ap_name));
        a.a(paramViewGroup, (TextView)paramView.findViewById(R.id.ap_del));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        com.wifi.backup.c.a.a locala = (com.wifi.backup.c.a.a)ApBackupRestoreFragment.b(ApBackupRestoreFragment.this).get(paramInt);
        paramViewGroup.a.setText(locala.i());
        a.a(paramViewGroup).setOnClickListener(new q(this, locala));
        notifyDataSetChanged();
        return paramView;
        paramViewGroup = (a)paramView.getTag();
      }
    }
    
    private final class a
    {
      public TextView a;
      private TextView c;
      
      private a() {}
    }
  }
  
  private final class b
    extends BaseAdapter
  {
    private List<com.wifi.backup.c.a.a> b;
    
    private b() {}
    
    public final List<com.wifi.backup.c.a.a> a()
    {
      return this.b;
    }
    
    public final void a(List<com.wifi.backup.c.a.a> paramList)
    {
      this.b = paramList;
    }
    
    public final int getCount()
    {
      if (this.b != null) {}
      for (int i = this.b.size();; i = 0) {
        return i;
      }
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
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = LayoutInflater.from(ApBackupRestoreFragment.this.getActivity()).inflate(R.layout.backup_overlay_item, null);
      }
      TextView localTextView = (TextView)paramViewGroup.findViewById(R.id.ap_name);
      paramView = (CheckBox)paramViewGroup.findViewById(R.id.ap_check);
      localTextView.setText(((com.wifi.backup.c.a.a)this.b.get(paramInt)).i());
      if (((com.wifi.backup.c.a.a)this.b.get(paramInt)).g()) {
        paramView.setChecked(true);
      }
      for (;;)
      {
        paramView.setOnCheckedChangeListener(new u(this, paramInt));
        return paramViewGroup;
        paramView.setChecked(false);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/backup/ui/ApBackupRestoreFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */