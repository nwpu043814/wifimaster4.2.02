package com.wifipay.wallet.home.bill.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.array;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.a.g;
import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.framework.widget.WPRelativeLayout;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.common.info.DeviceInfo;
import com.wifipay.wallet.home.bill.net.dto.BillDetails.Bills;
import com.wifipay.wallet.widget.ScrollListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WalletBillDetailActivity
  extends BaseActivity
{
  protected TextView h;
  protected ScrollListView i;
  protected String j;
  private String k = "";
  private BillDetails.Bills l;
  private WPRelativeLayout m;
  private com.wifipay.wallet.home.bill.a n;
  private String o;
  
  static
  {
    StubApp1053578832.interface11(119);
  }
  
  public static String a(BillDetails.Bills paramBills)
  {
    if (paramBills == null) {
      paramBills = "";
    }
    for (;;)
    {
      return paramBills;
      int i1 = Integer.valueOf(paramBills.direction).intValue();
      String str = paramBills.amount;
      if ((i1 == 2) || ("deposit".equals(paramBills.bizCode))) {
        paramBills = "¥" + str;
      } else {
        paramBills = "¥" + str;
      }
    }
  }
  
  private Map<String, Object> a(String paramString1, String paramString2)
  {
    if (g.a(paramString2)) {}
    HashMap localHashMap;
    for (paramString1 = null;; paramString1 = localHashMap)
    {
      return paramString1;
      localHashMap = new HashMap();
      localHashMap.put("bill_type", paramString1);
      localHashMap.put("bill_content", paramString2);
    }
  }
  
  private void a(List<Map<String, Object>> paramList, Map<String, Object> paramMap)
  {
    if (paramMap != null) {
      paramList.add(paramMap);
    }
  }
  
  private void a(String[] paramArrayOfString, List<Map<String, Object>> paramList)
  {
    if (g.a(this.l.reductionAmount)) {}
    for (;;)
    {
      return;
      a(paramList, a(paramArrayOfString[12], "随机立减¥ " + this.l.reductionAmount));
    }
  }
  
  private void b(String[] paramArrayOfString, List<Map<String, Object>> paramList)
  {
    if (((!"transfer".equals(this.l.bizCode)) && (!"f2fpay".equals(this.l.bizCode))) || (g.a(this.l.memo))) {}
    for (;;)
    {
      return;
      a(paramList, a(paramArrayOfString[8], this.l.memo));
    }
  }
  
  private void c(String[] paramArrayOfString, List<Map<String, Object>> paramList)
  {
    if (("spm_wifi_payment".equals(this.l.bizCode)) && (g.a(this.l.isOncentActivity, "Y")))
    {
      if (g.a(this.l.oncentCardNo)) {
        break label95;
      }
      a(paramList, a(paramArrayOfString[11], this.l.oncentCardNo));
      if (g.a(this.l.oncentPasswd)) {
        a(paramList, a("", this.l.oncentPasswd));
      }
    }
    for (;;)
    {
      return;
      label95:
      if (!g.a(this.l.oncentPasswd)) {
        a(paramList, a(paramArrayOfString[11], this.l.oncentPasswd));
      }
    }
  }
  
  private void d(String[] paramArrayOfString, List<Map<String, Object>> paramList)
  {
    if ((!"expense".equals(this.l.bizCode)) || (g.a(this.l.merchantOrderNo))) {}
    for (;;)
    {
      return;
      a(paramList, a(paramArrayOfString[9], this.l.merchantOrderNo));
    }
  }
  
  private void e(String[] paramArrayOfString, List<Map<String, Object>> paramList)
  {
    String str1 = paramArrayOfString[0];
    String str3;
    String str2;
    if (("transfer".equals(this.l.bizCode)) || ("f2fpay".equals(this.l.bizCode)))
    {
      if (Integer.valueOf(this.l.direction).intValue() == 2) {
        str1 = paramArrayOfString[1];
      }
      str3 = this.l.party;
      str2 = this.l.partyName;
      if (com.wifipay.wallet.common.utils.f.b(str3)) {
        return;
      }
      if ((str3.equalsIgnoreCase(str2)) || (g.a(str2))) {
        if (str3.indexOf("@") == -1) {
          paramArrayOfString = com.wifipay.wallet.common.utils.d.g(str3);
        }
      }
    }
    for (;;)
    {
      a(paramList, a(str1, paramArrayOfString));
      break;
      paramArrayOfString = com.wifipay.wallet.common.utils.d.g(str3.substring(0, str3.indexOf("@")));
      continue;
      paramArrayOfString = str2;
      if (str2.length() > 1) {
        paramArrayOfString = str2.substring(1);
      }
      if (str3.indexOf("@") == -1)
      {
        paramArrayOfString = com.wifipay.wallet.common.utils.d.g(str3) + " (*" + paramArrayOfString + ")";
      }
      else
      {
        paramArrayOfString = com.wifipay.wallet.common.utils.d.g(str3.substring(0, str3.indexOf("@"))) + " (*" + paramArrayOfString + ")";
        continue;
        if (("expense".equals(this.l.bizCode)) || ("spm_wifi_payment".equals(this.l.bizCode)))
        {
          if (Integer.valueOf(this.l.direction).intValue() == 1) {
            str1 = paramArrayOfString[3];
          }
          str3 = this.l.party;
          str2 = this.l.partyName;
          if (com.wifipay.wallet.common.utils.f.b(str3)) {
            break;
          }
          if ((str3.equalsIgnoreCase(str2)) || (g.a(str2)))
          {
            if (str3.indexOf("@") == -1)
            {
              paramArrayOfString = com.wifipay.wallet.common.utils.d.g(str3);
              continue;
            }
            paramArrayOfString = com.wifipay.wallet.common.utils.d.g(str3.substring(0, str3.indexOf("@")));
            continue;
          }
          paramArrayOfString = str2;
          if (str2.length() > 1) {
            paramArrayOfString = str2.substring(1);
          }
          if (str3.indexOf("@") == -1)
          {
            paramArrayOfString = com.wifipay.wallet.common.utils.d.g(str3) + " (*" + paramArrayOfString + ")";
            continue;
          }
          paramArrayOfString = com.wifipay.wallet.common.utils.d.g(str3.substring(0, str3.indexOf("@"))) + " (*" + paramArrayOfString + ")";
          continue;
        }
        paramArrayOfString = "";
      }
    }
  }
  
  private void f(String[] paramArrayOfString, List<Map<String, Object>> paramList)
  {
    if ("spm_wifi".equals(this.l.bizCode)) {
      return;
    }
    String str2 = paramArrayOfString[5];
    String str3 = this.l.partyName;
    String str1;
    if (("transfer".equals(this.l.bizCode)) || ("f2fpay".equals(this.l.bizCode)) || ("expense".equals(this.l.bizCode)) || ("spm_wifi_payment".equals(this.l.bizCode))) {
      if (Integer.valueOf(this.l.direction).intValue() != 2)
      {
        paramArrayOfString = this.l.transType;
        str1 = str2;
      }
    }
    for (;;)
    {
      a(paramList, a(str1, paramArrayOfString));
      break;
      paramArrayOfString = "";
      str1 = str2;
      continue;
      if ("deposit".equals(this.l.bizCode))
      {
        paramArrayOfString = str3;
        str1 = str2;
        if (!g.a(this.l.cardNo))
        {
          paramArrayOfString = str3 + " (" + this.l.cardNo + ")";
          str1 = str2;
        }
      }
      else if ("withdraw".equals(this.l.bizCode))
      {
        str2 = paramArrayOfString[6];
        paramArrayOfString = str3;
        str1 = str2;
        if (!g.a(this.l.cardNo))
        {
          paramArrayOfString = str3 + " (" + this.l.cardNo + ")";
          str1 = str2;
        }
      }
      else
      {
        paramArrayOfString = str3;
        str1 = str2;
        if ("fund".equals(this.l.bizCode)) {
          if (!g.a(this.l.cardNo))
          {
            paramArrayOfString = str3 + " (" + this.l.cardNo + ")";
            str1 = str2;
          }
          else
          {
            paramArrayOfString = getString(R.string.wifipay_wallet_bill_wallet_balance);
            str1 = str2;
          }
        }
      }
    }
  }
  
  private void l()
  {
    setContentView(R.layout.wifipay_home_bill_details);
    this.h = ((TextView)findViewById(R.id.wifipay_bill_trade_amount));
    this.i = ((ScrollListView)findViewById(R.id.wifipay_bill_trade_details));
    this.m = ((WPRelativeLayout)findViewById(R.id.wifipay_bill_details_helper));
    this.m.setOnClickListener(new d(this));
  }
  
  private void m()
  {
    DeviceInfo.INSTANCE.startCall("", this);
  }
  
  private void n()
  {
    this.k = getString(R.string.wifipay_home_header_content_remain);
    this.l = ((BillDetails.Bills)getIntent().getSerializableExtra("bill_detail"));
  }
  
  private void o()
  {
    this.n = new com.wifipay.wallet.home.bill.a(q(), p(), this);
    this.i.setAdapter(this.n);
  }
  
  private boolean p()
  {
    if (Integer.valueOf(this.l.status).intValue() == 3) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private List<Map<String, Object>> q()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.l != null)
    {
      String[] arrayOfString = com.wifipay.common.a.f.c(R.array.wifipay_bill_details_type);
      a(arrayOfString, localArrayList);
      e(arrayOfString, localArrayList);
      a(localArrayList, a(arrayOfString[2], r()));
      c(arrayOfString, localArrayList);
      a(localArrayList, a(arrayOfString[3], s()));
      a(localArrayList, a(arrayOfString[10], this.l.statusDesc));
      a(localArrayList, a(arrayOfString[4], this.l.tradeTime));
      f(arrayOfString, localArrayList);
      d(arrayOfString, localArrayList);
      a(localArrayList, a(arrayOfString[7], this.l.orderId));
      b(arrayOfString, localArrayList);
    }
    return localArrayList;
  }
  
  private String r()
  {
    String str2 = this.l.bizDesc;
    String str1;
    if (("transfer".equals(this.l.bizCode)) || ("f2fpay".equals(this.l.bizCode))) {
      if (Integer.valueOf(this.l.direction).intValue() == 2) {
        str1 = getString(R.string.wifipay_bill_transfer_income);
      }
    }
    for (;;)
    {
      return str1;
      str1 = getString(R.string.wifipay_bill_transfer_out);
      continue;
      if ("spm_wifi".equals(this.l.bizCode))
      {
        str1 = this.l.partyName;
      }
      else if (!"expense".equals(this.l.bizCode))
      {
        str1 = str2;
        if (!"spm_wifi_payment".equals(this.l.bizCode)) {}
      }
      else
      {
        str1 = str2;
        if (Integer.valueOf(this.l.direction).intValue() == 1) {
          str1 = this.l.goodsInfo;
        }
      }
    }
  }
  
  private String s()
  {
    return "";
  }
  
  protected void a(List<BillDetails.Bills> paramList)
  {
    BackgroundExecutor.a(new e(this, paramList));
  }
  
  protected void i()
  {
    a(com.wifipay.common.a.f.a(R.string.wifipay_bill_detail_title));
  }
  
  protected void j()
  {
    a(com.wifipay.wallet.home.bill.b.a.a(this).a(0));
  }
  
  protected void k()
  {
    c("");
    if ((this.l != null) && (this.l.status != null))
    {
      d();
      this.h.setText(a(this.l));
    }
    o();
  }
  
  protected native void onCreate(Bundle paramBundle);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/bill/ui/WalletBillDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */