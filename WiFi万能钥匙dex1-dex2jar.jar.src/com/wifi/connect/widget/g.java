package com.wifi.connect.widget;

import android.content.Context;
import android.graphics.Color;
import android.net.wifi.WifiConfiguration;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.lantern.connect.R.drawable;
import com.lantern.connect.R.id;
import com.lantern.connect.R.string;
import com.lantern.core.c;
import com.lantern.core.g.u;
import com.wifi.connect.model.AccessPoint;
import java.util.BitSet;

public final class g
  implements TextWatcher
{
  private final k a;
  private final View b;
  private final AccessPoint c;
  private boolean d;
  private TextView e;
  private int f;
  private TextView g;
  private Button h;
  private boolean i;
  private TextView j;
  private final int k = -1;
  private final Handler l;
  
  public g(k paramk, View paramView, AccessPoint paramAccessPoint, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.a = paramk;
    this.b = paramView;
    this.c = paramAccessPoint;
    int m;
    if (paramAccessPoint == null)
    {
      m = 0;
      this.f = m;
      this.d = paramBoolean1;
      this.i = paramBoolean3;
      this.l = new Handler();
      paramk = this.a.getContext();
      if (this.c != null) {
        break label186;
      }
      this.a.setTitle(R.string.wifi_add_network);
      this.e = ((TextView)this.b.findViewById(R.id.ssid));
      this.e.addTextChangedListener(this);
      this.b.findViewById(R.id.type).setVisibility(0);
      this.a.a(paramk.getString(R.string.wifi_save));
    }
    label186:
    label223:
    label272:
    label377:
    label626:
    label645:
    label705:
    for (;;)
    {
      this.a.c(paramk.getString(R.string.wifi_cancel));
      if (this.a.u_() != null) {
        a();
      }
      return;
      m = paramAccessPoint.c;
      break;
      if (paramBoolean2)
      {
        this.a.setTitle(c.getAppContext().getString(R.string.wifi_dialog_title_for_share, new Object[] { this.c.a }));
        m = this.c.e();
        if ((this.c.e == -1) || (this.d))
        {
          if (this.f != 0) {
            break label377;
          }
          this.b.findViewById(R.id.security_fields).setVisibility(8);
        }
        if (!this.d) {
          break label645;
        }
        if (!paramBoolean2) {
          break label626;
        }
        this.a.a(paramk.getString(R.string.wifi_share));
      }
      for (;;)
      {
        if (!this.i) {
          break label705;
        }
        this.g.setBackgroundResource(R.drawable.connect_edit_text_bg_red);
        this.g.setHintTextColor(Color.parseColor("#f74238"));
        this.g.setHint(R.string.wifi_password_dialog_hint_error_pwd);
        break;
        this.a.setTitle(c.getAppContext().getString(R.string.wifi_dialog_title_for_connect, new Object[] { this.c.a }));
        break label223;
        this.b.findViewById(R.id.security_fields).setVisibility(0);
        if (this.j == null) {
          this.j = ((TextView)this.b.findViewById(R.id.wepap));
        }
        if (this.g != null) {
          break label272;
        }
        this.g = ((TextView)this.b.findViewById(R.id.password));
        this.g.addTextChangedListener(this);
        this.h = ((Button)this.b.findViewById(R.id.show_password_button));
        this.h.setOnClickListener(new h(this));
        this.g.setOnClickListener(new i(this));
        if ((this.c != null) && (this.c.e != -1)) {
          this.g.setHint(R.string.wifi_password_dialog_hint);
        }
        if (this.c == null) {
          break label272;
        }
        this.b.findViewById(R.id.wepap).setVisibility(8);
        if (this.c.c == 1)
        {
          this.g.setFilters(new InputFilter[] { new InputFilter.LengthFilter(16) });
          this.j.setVisibility(0);
          break label272;
        }
        if (this.c.c != 2) {
          break label272;
        }
        this.g.setFilters(new InputFilter[] { new InputFilter.LengthFilter(64) });
        break label272;
        this.a.a(paramk.getString(R.string.wifi_connect));
        continue;
        if ((!this.c.j()) && (m != -1)) {
          this.a.a(paramk.getString(R.string.wifi_connect));
        }
        if (this.c.e != -1) {
          this.a.b(paramk.getString(R.string.wifi_forget));
        }
      }
    }
  }
  
  final void a()
  {
    boolean bool2 = false;
    Button localButton = this.a.u_();
    if (localButton == null) {
      return;
    }
    if ((this.g != null) && (((this.f == 1) && (this.g.length() == 0)) || ((this.f == 2) && (this.g.length() < 8)))) {}
    for (int m = 1;; m = 0)
    {
      boolean bool1;
      if (this.e != null)
      {
        bool1 = bool2;
        if (this.e.length() == 0) {}
      }
      else
      {
        bool1 = bool2;
        if (m == 0) {
          bool1 = true;
        }
      }
      localButton.setEnabled(bool1);
      localButton.setEnabled(bool1);
      break;
    }
  }
  
  public final void afterTextChanged(Editable paramEditable)
  {
    this.l.post(new j(this));
  }
  
  public final String b()
  {
    if (this.g.length() != 0) {}
    for (String str = this.g.getText().toString();; str = "") {
      return str;
    }
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final WifiConfiguration c()
  {
    Object localObject1;
    if (this.c == null) {
      localObject1 = null;
    }
    for (;;)
    {
      label9:
      return (WifiConfiguration)localObject1;
      if ((this.c != null) && (this.c.e != -1) && (!this.d))
      {
        localObject1 = null;
      }
      else
      {
        localObject1 = this.c.f();
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new WifiConfiguration();
        }
        if (this.c == null)
        {
          ((WifiConfiguration)localObject2).SSID = u.b(this.e.getText().toString());
          ((WifiConfiguration)localObject2).hiddenSSID = true;
        }
        for (;;)
        {
          switch (this.f)
          {
          default: 
            localObject1 = null;
            break label9;
            if (this.c.e == -1)
            {
              ((WifiConfiguration)localObject2).SSID = u.b(this.c.a);
              if ((this.c.a != null) && (this.c.a.length() != this.c.a.getBytes().length))
              {
                com.bluefay.b.h.a("contains chinese ssid:" + this.c.a);
                ((WifiConfiguration)localObject2).BSSID = this.c.b;
              }
            }
            else
            {
              ((WifiConfiguration)localObject2).SSID = u.b(this.c.a);
              ((WifiConfiguration)localObject2).BSSID = this.c.b;
              ((WifiConfiguration)localObject2).networkId = this.c.e;
            }
            break;
          }
        }
        ((WifiConfiguration)localObject2).allowedKeyManagement.set(0);
        localObject1 = localObject2;
        continue;
        ((WifiConfiguration)localObject2).allowedKeyManagement.set(0);
        ((WifiConfiguration)localObject2).allowedAuthAlgorithms.set(0);
        ((WifiConfiguration)localObject2).allowedAuthAlgorithms.set(1);
        localObject1 = localObject2;
        if (this.g.length() != 0)
        {
          int m = this.g.length();
          localObject1 = this.g.getText().toString();
          if (((m == 10) || (m == 26) || (m == 58)) && (((String)localObject1).matches("[0-9A-Fa-f]*")))
          {
            ((WifiConfiguration)localObject2).wepKeys[0] = localObject1;
            localObject1 = localObject2;
          }
          else
          {
            ((WifiConfiguration)localObject2).wepKeys[0] = ("\"" + (String)localObject1 + '"');
            localObject1 = localObject2;
            continue;
            ((WifiConfiguration)localObject2).allowedKeyManagement.set(1);
            localObject1 = localObject2;
            if (this.g.length() != 0)
            {
              localObject1 = this.g.getText().toString();
              if (((String)localObject1).matches("[0-9A-Fa-f]{64}"))
              {
                ((WifiConfiguration)localObject2).preSharedKey = ((String)localObject1);
                localObject1 = localObject2;
              }
              else
              {
                ((WifiConfiguration)localObject2).preSharedKey = ("\"" + (String)localObject1 + '"');
                localObject1 = localObject2;
                continue;
                ((WifiConfiguration)localObject2).allowedKeyManagement.set(2);
                ((WifiConfiguration)localObject2).allowedKeyManagement.set(3);
                localObject1 = localObject2;
              }
            }
          }
        }
      }
    }
  }
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/widget/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */