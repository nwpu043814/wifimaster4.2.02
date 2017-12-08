package com.wifi.connect.widget;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.wifi.WifiConfiguration;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.lantern.connect.R.color;
import com.lantern.connect.R.drawable;
import com.lantern.connect.R.id;
import com.lantern.connect.R.layout;
import com.lantern.connect.R.string;
import com.lantern.connect.R.style;
import com.lantern.core.c;
import com.lantern.core.g.u;
import com.lantern.core.imageloader.a.aa;
import com.lantern.core.imageloader.a.ah;
import com.lantern.core.imageloader.a.an;
import com.wifi.connect.a.d;
import com.wifi.connect.a.e;
import com.wifi.connect.a.g;
import com.wifi.connect.model.AccessPoint;
import com.wifi.connect.model.AccessPointAlias;
import java.util.ArrayList;

public final class n
  extends bluefay.app.k
{
  private static final int[][] b;
  private ImageSpan a = null;
  private AccessPoint c;
  private GridView d;
  private ArrayList<View> e;
  private ListAdapter f = new o(this);
  private a g;
  private Context h;
  private com.lantern.core.imageloader.f i;
  
  static
  {
    int[] arrayOfInt1 = new int[0];
    int[] arrayOfInt2 = { 1, R.drawable.action_magic_conn, R.string.action_magic_conn };//connect entry.
    int[] arrayOfInt3 = { 2, R.drawable.action_connect, R.string.action_connect };
    int i8 = R.drawable.action_input_password;
    int i12 = R.string.action_input_password;
    int[] arrayOfInt4 = { 4, R.drawable.action_dig, R.string.action_dig };
    int[] arrayOfInt5 = { 5, R.drawable.action_disconnect, R.string.action_disconnect };
    int[] arrayOfInt6 = { 6, R.drawable.action_details, R.string.action_details };
    int[] arrayOfInt7 = { 7, R.drawable.action_security_test, R.string.action_security_test };
    int n = R.drawable.connect_wifi_check;
    int i1 = R.string.action_security_test;
    int i4 = R.drawable.action_signalcheck;
    int i11 = R.string.action_signal_detect;
    int i2 = R.drawable.action_backup;
    int i9 = R.string.action_backup;
    int[] arrayOfInt8 = { 11, R.drawable.action_share, R.string.action_share };
    int i10 = R.drawable.action_forget;
    int k = R.string.action_forget;
    int[] arrayOfInt9 = { 13, R.drawable.action_report_phishing, R.string.action_report_phishing };
    int i5 = R.drawable.action_connect_ing;
    int m = R.string.action_connect_ing;
    int i3 = R.drawable.wifi_status_keyed;
    int i7 = R.string.action_magic_conn;
    int i6 = R.drawable.action_business_home;
    int j = R.string.action_business_home;
    int[] arrayOfInt10 = { 17, R.drawable.action_homepage, R.string.action_ap_homepage };
    int[] arrayOfInt11 = { 18, R.drawable.action_speed_test, R.string.action_speed_test };
    b = new int[][] { arrayOfInt1, arrayOfInt2, arrayOfInt3, { 3, i8, i12 }, arrayOfInt4, arrayOfInt5, arrayOfInt6, arrayOfInt7, { 8, n, i1 }, { 9, i4, i11 }, { 10, i2, i9 }, arrayOfInt8, { 12, i10, k }, arrayOfInt9, { 14, i5, m }, { 15, i3, i7 }, { 16, i6, j }, arrayOfInt10, arrayOfInt11 };
  }
  
  public n(Context paramContext, AccessPoint paramAccessPoint, DialogInterface.OnClickListener paramOnClickListener)
  {
    super(paramContext, R.style.BL_Theme_Light_Dialog_Alert_Bottom);
    this.c = paramAccessPoint;
    this.h = paramContext;
    this.a = null;
    Object localObject2 = this.c.a;
    int j = 0;
    Object localObject1;
    if (com.wifi.connect.a.a.a().b(this.c))
    {
      localObject1 = "\n" + (String)localObject2;
      localObject2 = com.wifi.connect.a.a.a().a(this.c).e;
      j = 11;
    }
    for (;;)
    {
      if (u.a(this.c.d))
      {
        localObject1 = this.h.getString(R.string.wifi_dialog_title_weeksignal_tip);
        j = 9;
      }
      if (e.b().a(this.c))
      {
        localObject1 = this.h.getString(R.string.wifi_dialog_title_phoneap_tip);
        if ((com.lantern.core.k.k(this.h) > 480) || (!((String)localObject1).contains("，"))) {
          break label1281;
        }
        localObject1 = ((String)localObject1).substring(0, ((String)localObject1).lastIndexOf("，"));
      }
      label369:
      label952:
      label963:
      label974:
      label1140:
      label1211:
      label1281:
      for (j = 9;; j = 9)
      {
        Object localObject3;
        int k;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          setTitle((CharSequence)localObject2);
          if (!com.wifi.connect.a.a.a().c(paramAccessPoint.a, paramAccessPoint.c)) {
            break label963;
          }
          localObject2 = com.wifi.connect.a.a.a().a(paramAccessPoint);
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            break label952;
          }
          this.i = new p(this);
          j = Math.round(paramContext.getResources().getDisplayMetrics().density * 33.0F);
          localObject3 = c.getAppContext();
          localObject1 = this.i;
          paramAccessPoint = new com.lantern.core.imageloader.a();
          k = R.drawable.shop_avatar_default;
          if (!TextUtils.isEmpty((CharSequence)localObject2))
          {
            localObject2 = aa.a((Context)localObject3).a((String)localObject2);
            ((ah)localObject2).a(paramAccessPoint);
            if ((j > 0) && (j > 0)) {
              ((ah)localObject2).a(j, j);
            }
            if (k != 0) {
              ((ah)localObject2).a(k);
            }
            ((ah)localObject2).a((an)localObject1);
          }
          setCancelable(true);
          setCanceledOnTouchOutside(true);
          a(-2, paramContext.getString(R.string.btn_cancel), paramOnClickListener);
          paramContext = LayoutInflater.from(this.h).inflate(R.layout.connect_wifi_options_dialog, null);
          a(paramContext);
          this.e = new ArrayList();
          if (!this.c.h()) {
            break label974;
          }
          if (com.lantern.core.f.a().a("apgrade2", true)) {
            c(17);
          }
          c(18);
          c(8);
          c(9);
          if ((this.c.c != 0) && (!g.a().a(this.c))) {
            c(11);
          }
          c(13);
          c(12);
          c(5);
        }
        for (;;)
        {
          this.d = ((GridView)paramContext.findViewById(R.id.grid_view));
          this.d.setAdapter(this.f);
          return;
          int m;
          if (!e.b().a(this.c))
          {
            localObject3 = new SpannableString((String)localObject2 + "  " + (String)localObject1);
            k = ((String)localObject2).length();
            m = ((String)localObject1).length();
            ((SpannableString)localObject3).setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), k + 2, k + m + 2, 33);
            ((SpannableString)localObject3).setSpan(new AbsoluteSizeSpan((int)TypedValue.applyDimension(1, j, getContext().getResources().getDisplayMetrics())), k + 2, m + k + 2, 33);
            setTitle((CharSequence)localObject3);
          }
          for (localObject1 = localObject3;; localObject1 = localObject3)
          {
            setTitle((CharSequence)localObject1);
            break;
            String str = this.h.getResources().getString(R.string.dialog_phoneap_desc_2);
            localObject3 = new SpannableString((String)localObject2 + "  " + str + "\n" + (String)localObject1);
            k = ((String)localObject2).length();
            j = ((String)localObject1).length();
            m = str.length();
            ((SpannableString)localObject3).setSpan(new ForegroundColorSpan(Color.parseColor("#fd9531")), k + 2, k + m + 2, 33);
            ((SpannableString)localObject3).setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), k + 2 + m, m + k + j + 2 + 1, 33);
            ((SpannableString)localObject3).setSpan(new AbsoluteSizeSpan((int)TypedValue.applyDimension(1, 10.0F, getContext().getResources().getDisplayMetrics())), k + 2 + m, j + k + 2 + m + 1, 33);
            ((SpannableString)localObject3).setSpan(new AbsoluteSizeSpan((int)TypedValue.applyDimension(1, 12.0F, getContext().getResources().getDisplayMetrics())), k + 2, k + 2 + m + 1, 33);
          }
          b(c());
          break label369;
          b(c());
          break label369;
          if (this.c.i())
          {
            c(14);
            c(9);
            c(13);
            if ((this.c.f() != null) && (this.c.f().networkId != -1)) {
              c(12);
            }
          }
          else
          {
            if (this.c.c != 0) {
              break label1140;
            }
            if ((com.wifi.connect.a.f.a().b(this.c)) || (d.a().a(this.c))) {
              c(15);
            }
            if (!d.a().a(this.c)) {
              c(2);
            }
            c(9);
            c(13);
            if ((this.c.f() != null) && (this.c.f().networkId != -1)) {
              c(12);
            }
          }
        }
        if (this.c.f() != null) {
          if (this.c.f().networkId != -1)
          {
            if (!g.a().a(this.c)) {
              break label1211;
            }
            c(15);
          }
        }
        for (;;)
        {
          c(9);
          if (g.a().a(this.c)) {
            break;
          }
          c(11);
          break;
          c(2);
          continue;
          if (e.b().b(this.c))
          {
            c(15);
            c(3);
          }
          else if (g.a().a(this.c))
          {
            c(15);
          }
          else
          {
            c(1);
            c(3);
          }
        }
      }
      localObject1 = null;
    }
  }
  
  private int c()
  {
    int j;
    if (this.c.c == 0) {
      if ((com.wifi.connect.a.f.a().b(this.c)) || (d.a().a(this.c)) || (g.a().a(this.c))) {
        j = R.drawable.wifi_status_keyed;
      }
    }
    for (;;)
    {
      return j;
      j = 0;
      continue;
      if ((e.b().b(this.c)) || (g.a().a(this.c))) {
        j = R.drawable.wifi_status_keyed;
      } else {
        j = R.drawable.wifi_status_locked;
      }
    }
  }
  
  private void c(int paramInt)
  {
    TextView localTextView = (TextView)LayoutInflater.from(this.h).inflate(R.layout.connect_wifi_option_item, null);
    localTextView.setCompoundDrawablesWithIntrinsicBounds(0, b[paramInt][1], 0, 0);
    localTextView.setText(b[paramInt][2]);
    if (paramInt == 15) {
      localTextView.setTextColor(this.h.getResources().getColor(R.color.framework_primary_color));
    }
    localTextView.setOnClickListener(new q(this, paramInt));
    this.e.add(localTextView);
  }
  
  public final void a(a parama)
  {
    this.g = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onEvent(int paramInt, AccessPoint paramAccessPoint);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifi/connect/widget/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */