package com.wifi.backup.ui;

import android.app.Activity;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import bluefay.app.Fragment;
import com.bluefay.b.h;
import com.lantern.connect.R.id;
import com.lantern.connect.R.layout;
import com.lantern.connect.R.string;
import com.lantern.core.WkSecretKeyNative;
import com.lantern.core.g.u;
import com.lantern.core.model.WkAccessPoint;
import com.wifi.backup.c.a.a;
import com.wifimaster.TanPsw;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public class ApBackupFragment
  extends Fragment
{
  private WifiManager g;
  private com.bluefay.material.f h;
  private int i = 1;
  
  private void a(a parama)
  {
    Object localObject1 = parama.i();
    String str = b(parama.l());
    TanPsw.Password(getActivity(), str);
    if (TextUtils.isEmpty(str)) {
      return;
    }
    Object localObject2 = this.g.getScanResults();
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
    for (localObject1 = u.a(this.e, new WkAccessPoint((ScanResult)localObject2), str);; localObject1 = null)
    {
      if (localObject1 != null)
      {
        h.a("(WifiUtils.getSecurity(config):" + u.a((WifiConfiguration)localObject1), new Object[0]);
        if ((u.a((WifiConfiguration)localObject1) == 2) && (str.length() < 8)) {
          break;
        }
        u.a((WifiConfiguration)localObject1, str);
        if (((WifiConfiguration)localObject1).networkId == -1) {
          if (this.g.addNetwork((WifiConfiguration)localObject1) == -1) {
            this.i = -1;
          }
        }
        for (;;)
        {
          this.g.saveConfiguration();
          break;
          if (this.g.updateNetwork((WifiConfiguration)localObject1) == -1) {
            this.i = -1;
          }
        }
      }
      localObject1 = new WifiConfiguration();
      ((WifiConfiguration)localObject1).SSID = u.b(parama.i());
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
        if (this.g.addNetwork((WifiConfiguration)localObject1) == -1) {
          this.i = -1;
        }
        this.g.saveConfiguration();
        break;
        ((WifiConfiguration)localObject1).allowedKeyManagement.set(0);
        continue;
        ((WifiConfiguration)localObject1).allowedKeyManagement.set(0);
        ((WifiConfiguration)localObject1).allowedAuthAlgorithms.set(0);
        ((WifiConfiguration)localObject1).allowedAuthAlgorithms.set(1);
        if (str.length() != 0)
        {
          int j = str.length();
          if (((j == 10) || (j == 26) || (j == 58)) && (str.matches("[0-9A-Fa-f]*")))
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
      paramString = WkSecretKeyNative.a(paramString, "0");
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.backup_main, paramViewGroup, false);
    a(R.string.conn_backup_actionbar_title);
    this.g = ((WifiManager)getActivity().getSystemService("wifi"));
    paramLayoutInflater.findViewById(R.id.conn_backup_upload_layout).setOnClickListener(new b(this));
    paramLayoutInflater.findViewById(R.id.conn_backup_restore_layout).setOnClickListener(new d(this));
    paramLayoutInflater.findViewById(R.id.conn_backup_bt_backup_layout).setOnClickListener(new f(this));
    paramLayoutInflater.findViewById(R.id.conn_backup_bt_restore_layout).setOnClickListener(new g(this));
    return paramLayoutInflater;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/backup/ui/ApBackupFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */