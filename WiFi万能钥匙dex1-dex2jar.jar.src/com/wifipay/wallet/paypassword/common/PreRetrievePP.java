package com.wifipay.wallet.paypassword.common;

import android.content.Intent;
import com.wifipay.R.id;
import com.wifipay.common.a.g;
import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.common.info.DeviceInfo;
import com.wifipay.wallet.common.info.UserInfo;
import com.wifipay.wallet.common.info.b;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.common.utils.f;
import com.wifipay.wallet.paypassword.ui.RetrievePPActivity;
import com.wifipay.wallet.prod.security.account.dto.QueryRNInfoResp;
import com.wifipay.wallet.prod.security.account.dto.QueryRNInfoResp.ResultObject;
import com.wifipay.wallet.prod.security.query.QueryHpsCardResp;
import com.wifipay.wallet.prod.security.query.QueryService;
import java.util.ArrayList;
import java.util.HashMap;

public class PreRetrievePP
{
  private SuperActivity a;
  private onListener b;
  private String c;
  private String d;
  
  public PreRetrievePP(SuperActivity paramSuperActivity, onListener paramonListener)
  {
    this.d = "";
    this.a = paramSuperActivity;
    this.b = paramonListener;
  }
  
  public PreRetrievePP(SuperActivity paramSuperActivity, onListener paramonListener, String paramString)
  {
    this.a = paramSuperActivity;
    this.b = paramonListener;
    this.c = paramString;
  }
  
  private boolean a(QueryRNInfoResp paramQueryRNInfoResp)
  {
    if ((ResponseCode.SUCCESS.getCode().equals(paramQueryRNInfoResp.resultCode)) && (paramQueryRNInfoResp.resultObject != null))
    {
      UserInfo localUserInfo = b.a().c();
      localUserInfo.setTrueName(paramQueryRNInfoResp.resultObject.trueName);
      localUserInfo.setCertNo(paramQueryRNInfoResp.resultObject.certNo);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void b()
  {
    this.a.d();
    HashMap localHashMap = new HashMap();
    localHashMap.put("bindcardsource", CashierType.SETPWD.getType());
    localHashMap.put("cashier_type", this.c);
    Intent localIntent = new Intent("com.wifipay.action.BIND_CARD");
    localIntent.putExtra("local_data", localHashMap);
    this.a.startActivity(localIntent);
  }
  
  private void c()
  {
    DeviceInfo.INSTANCE.startCall("", this.a);
  }
  
  private void d()
  {
    a(((QueryService)RpcService.getRpcProxy(QueryService.class)).queryHpsCard(String.valueOf(System.currentTimeMillis())));
  }
  
  public void a()
  {
    this.a.c("");
    BackgroundExecutor.a(new d(this));
  }
  
  public void a(QueryHpsCardResp paramQueryHpsCardResp)
  {
    this.a.d();
    if (ResponseCode.SUCCESS.getCode().equals(paramQueryHpsCardResp.resultCode))
    {
      ArrayList localArrayList = paramQueryHpsCardResp.resultObject;
      if ((f.a(localArrayList)) && (localArrayList.size() > 0))
      {
        paramQueryHpsCardResp = new Intent(this.a, RetrievePPActivity.class);
        if (!g.a(this.d)) {
          paramQueryHpsCardResp.putExtra("retrive", this.d);
        }
        paramQueryHpsCardResp.putExtra("card_list", localArrayList);
        paramQueryHpsCardResp.putExtra("which_fragment", R.id.wifipay_fragment_pp_old);
        paramQueryHpsCardResp.putExtra("cashier_type", this.c);
        this.a.startActivity(paramQueryHpsCardResp);
        if (f.a(this.b)) {
          this.b.afterCheck();
        }
      }
    }
    for (;;)
    {
      return;
      b();
      break;
      this.a.b(paramQueryHpsCardResp.resultMessage);
    }
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
    a();
  }
  
  public static abstract interface onListener
  {
    public abstract void afterCheck();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/paypassword/common/PreRetrievePP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */