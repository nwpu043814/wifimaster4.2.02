package com.wifipay.wallet.deposit.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.a.g;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.common.eventbus.ThreadMode;
import com.wifipay.common.logging.Logger;
import com.wifipay.common.net.entitybase.BaseResp;
import com.wifipay.framework.app.ui.BaseFragment;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.a.c;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.cashier.PayListener;
import com.wifipay.wallet.cashier.ui.SelectCardActivity;
import com.wifipay.wallet.common.info.UserInfo;
import com.wifipay.wallet.common.info.b;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.common.utils.d;
import com.wifipay.wallet.deposit.ui.MoneyFailActivity;
import com.wifipay.wallet.deposit.ui.MoneySuccessActivity;
import com.wifipay.wallet.home.widget.image.SmartImageView;
import com.wifipay.wallet.prod.core.model.PayCard;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.core.model.StartPayParams.ProductInfo;
import com.wifipay.wallet.prod.core.model.WalletCard;
import com.wifipay.wallet.prod.deposit.DepositOrderCreateResp;
import com.wifipay.wallet.prod.deposit.DepositOrderCreateResp.ResultObject;
import com.wifipay.wallet.prod.deposit.DepositService;
import com.wifipay.wallet.prod.security.query.CreditLevelResp;
import com.wifipay.wallet.prod.security.query.CreditLevelResp.ResultObject;
import com.wifipay.wallet.prod.security.query.QueryPaymentResp;
import com.wifipay.wallet.prod.security.query.QueryPaymentResp.ResultObject;
import com.wifipay.wallet.prod.security.query.QueryService;
import com.wifipay.wallet.prod.security.query.WalletBalanceResp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DepositInputFragment
  extends BaseFragment
  implements TextWatcher, View.OnClickListener, PayListener
{
  private EditText a;
  private TextView b;
  private Button c;
  private SmartImageView d;
  private String e;
  private ArrayList<PayCard> f = new ArrayList();
  private PayCard g;
  private com.wifipay.wallet.cashier.b.a h = null;
  private String i;
  private int j;
  private int k;
  private View l;
  private TextView m;
  
  private void e()
  {
    int n;
    Object localObject2;
    if ((com.wifipay.wallet.common.utils.f.a(this.f)) && (!this.f.isEmpty()))
    {
      n = 1;
      if (n == 0) {
        break label153;
      }
      localObject1 = (PayCard)this.f.get(0);
      Iterator localIterator = this.f.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject2 = (PayCard)localIterator.next();
          if (((PayCard)localObject2).isDefault())
          {
            label75:
            localObject1 = localObject2;
            if (((PayCard)localObject2).isEnable()) {
              break;
            }
          }
        }
      }
    }
    label153:
    for (Object localObject1 = null;; localObject1 = null)
    {
      if (com.wifipay.wallet.common.utils.f.b(localObject1))
      {
        localObject1 = PayCard.newCard(CashierType.DEPOSIT.getType());
        this.l.setTag(((PayCard)localObject1).type);
      }
      for (;;)
      {
        this.g = ((PayCard)localObject1);
        d.a((PayCard)localObject1, this.d, this.m);
        return;
        n = 0;
        break;
        this.l.setTag(null);
      }
      localObject2 = localObject1;
      break label75;
    }
  }
  
  private void f()
  {
    if ((d.a(this.i, "0") > 0) && (d.a(this.e, this.i) > 0)) {
      a(com.wifipay.common.a.f.a(R.string.wifipay_withdraw_not_deposit_amount));
    }
    for (;;)
    {
      return;
      StartPayParams localStartPayParams = new StartPayParams();
      localStartPayParams.additionalParams = new HashMap();
      localStartPayParams.productInfo = new StartPayParams.ProductInfo();
      localStartPayParams.type = CashierType.DEPOSIT.getType();
      localStartPayParams.chosenCard = this.g;
      localStartPayParams.additionalParams.put("amount", this.e);
      localStartPayParams.additionalParams.put("isSign", "false");
      localStartPayParams.productInfo.productAmount = this.e;
      localStartPayParams.productInfo.productName = getString(R.string.wifipay_deposit_name);
      if (this.h == null) {
        this.h = com.wifipay.wallet.cashier.a.a(CashierType.DEPOSIT.getType(), c(), this);
      }
      this.h.a(localStartPayParams);
      this.h.d();
    }
  }
  
  private void g()
  {
    if (TextUtils.equals(PayCard.newCard(CashierType.DEPOSIT.getType()).type, (String)this.l.getTag())) {
      new com.wifipay.wallet.card.a.a(c()).a(null);
    }
    for (;;)
    {
      return;
      Intent localIntent = new Intent(c(), SelectCardActivity.class);
      localIntent.putExtra("card_list", this.f);
      localIntent.putExtra("select_card_type", CashierType.DEPOSIT.getType());
      startActivity(localIntent);
    }
  }
  
  private void h()
  {
    if (!b.a().n()) {}
    for (;;)
    {
      return;
      b("");
      DepositService localDepositService = (DepositService)RpcService.getBgRpcProxy(DepositService.class);
      localDepositService.queryCreditLevel(String.valueOf(System.currentTimeMillis()));
      this.k += 1;
      localDepositService.queryPaymentByBiz(String.valueOf(System.currentTimeMillis()), "deposit", "");
      this.k += 1;
      ((QueryService)RpcService.getBgRpcProxy(QueryService.class)).queryWalletBalance(String.valueOf(System.currentTimeMillis()));
      this.k += 1;
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.e = g.a(this.a, paramEditable.toString(), this.c);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  @Subscribe(threadMode=ThreadMode.MAIN)
  public void handleBindcardSuc(c paramc)
  {
    b("");
    this.k += 1;
    ((DepositService)RpcService.getBgRpcProxy(DepositService.class)).queryPaymentByBiz(String.valueOf(System.currentTimeMillis()), "deposit", "");
  }
  
  @Subscribe
  public void handleCreditLevel(CreditLevelResp paramCreditLevelResp)
  {
    int n = this.j + 1;
    this.j = n;
    if (n == this.k) {
      d();
    }
    if (paramCreditLevelResp.resultCode.equals(ResponseCode.SUCCESS.getCode()))
    {
      this.i = paramCreditLevelResp.resultObject.limit;
      paramCreditLevelResp = com.wifipay.common.a.f.a(R.string.wifipay_deposit_upper_limit, new Object[] { this.i, paramCreditLevelResp.resultObject.dayLimit });
      this.b.setVisibility(0);
      this.b.setText(paramCreditLevelResp);
    }
    for (;;)
    {
      return;
      a(paramCreditLevelResp.resultMessage);
    }
  }
  
  @Subscribe(threadMode=ThreadMode.MAIN)
  public void handleHpsCard(QueryPaymentResp paramQueryPaymentResp)
  {
    int n = this.j + 1;
    this.j = n;
    if (n == this.k) {
      d();
    }
    if (TextUtils.equals(paramQueryPaymentResp.resultCode, ResponseCode.SUCCESS.getCode())) {
      this.f = paramQueryPaymentResp.resultObject.items;
    }
    for (;;)
    {
      e();
      return;
      a(paramQueryPaymentResp.resultMessage);
    }
  }
  
  @Subscribe
  public void handleWalletBalance(WalletBalanceResp paramWalletBalanceResp)
  {
    int n = this.j + 1;
    this.j = n;
    if (n == this.k) {
      d();
    }
    if (ResponseCode.SUCCESS.getCode().equals(paramWalletBalanceResp.resultCode))
    {
      UserInfo localUserInfo = b.a().c();
      localUserInfo.setAvailableBalance(paramWalletBalanceResp.resultObject.availableBalance);
      localUserInfo.setFrozenBalance(paramWalletBalanceResp.resultObject.frozenBalance);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Logger.v("zhao == %s", new Object[] { "requestCode" + paramInt1 });
    Logger.v("zhao == %s", new Object[] { "resultCode" + paramInt2 });
    h();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_btn_next) {
      f();
    }
    for (;;)
    {
      return;
      if (paramView.getId() == R.id.wifipay_card_item) {
        g();
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    return paramLayoutInflater.inflate(R.layout.wifipay_fragment_deposit_input, null);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (com.wifipay.wallet.common.utils.f.a(this.h))
    {
      this.h.b();
      this.h = null;
    }
  }
  
  @Subscribe
  public void onEventMainThread(com.wifipay.wallet.a.f paramf)
  {
    this.g = paramf.a;
    d.a(paramf.a, this.d, this.m);
  }
  
  public void onResume()
  {
    super.onResume();
    if (com.wifipay.wallet.common.utils.f.a(this.h)) {
      this.h.a();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.a = ((EditText)paramView.findViewById(R.id.wifipay_input_amount));
    this.b = ((TextView)paramView.findViewById(R.id.wifipay_withdraw_balance));
    this.l = paramView.findViewById(R.id.wifipay_card_item);
    this.d = ((SmartImageView)paramView.findViewById(R.id.wifipay_bank_logo));
    this.c = ((Button)paramView.findViewById(R.id.wifipay_btn_next));
    this.m = ((TextView)paramView.findViewById(R.id.wifipay_card_item_info));
    ((TextView)paramView.findViewById(R.id.wifipay_amount_entry_name)).setText("转入金额");
    paramView.findViewById(R.id.wifipay_amount_explain).setVisibility(8);
    this.a.addTextChangedListener(this);
    this.c.setOnClickListener(this);
    this.l.setOnClickListener(this);
    e();
    h();
  }
  
  public void payFinish(int paramInt, BaseResp paramBaseResp)
  {
    DepositOrderCreateResp localDepositOrderCreateResp;
    HashMap localHashMap;
    if (com.wifipay.wallet.common.utils.f.a(paramBaseResp))
    {
      localDepositOrderCreateResp = (DepositOrderCreateResp)paramBaseResp;
      localHashMap = new HashMap();
      localHashMap.put("requestLoginName", b.a().f());
      localHashMap.put("resposePayTime", d.a(System.currentTimeMillis()));
      localHashMap.put("orderResposeCode", localDepositOrderCreateResp.resultCode);
      localHashMap.put("orderResposeMessage", localDepositOrderCreateResp.resultMessage);
      localHashMap.put("type", "Deposit");
      if (!ResponseCode.SUCCESS.getCode().equals(paramBaseResp.resultCode)) {
        break label269;
      }
      paramBaseResp = new Intent(c(), MoneySuccessActivity.class);
      paramBaseResp.putExtra("extra_type", getString(R.string.wifipay_deposit_title));
      paramBaseResp.putExtra("extra_amoubt", this.e);
      if (localDepositOrderCreateResp.resultObject != null)
      {
        paramBaseResp.putExtra("extra_bankname", localDepositOrderCreateResp.resultObject.bankName);
        paramBaseResp.putExtra("extra_bankcode", localDepositOrderCreateResp.resultObject.cardNo);
        localHashMap.put("orderId", localDepositOrderCreateResp.resultObject.depositId);
        localHashMap.put("orderBankName", localDepositOrderCreateResp.resultObject.bankName);
        localHashMap.put("orderCardNo", localDepositOrderCreateResp.resultObject.cardNo);
      }
      com.wifipay.wallet.common.utils.a.a(getActivity(), "Deposit", localHashMap);
      c().startActivity(paramBaseResp);
    }
    for (;;)
    {
      return;
      label269:
      com.wifipay.wallet.common.utils.a.a(getActivity(), "Deposit", localHashMap);
      paramBaseResp = new Intent(c(), MoneyFailActivity.class);
      paramBaseResp.putExtra("extra_type", getString(R.string.wifipay_deposit_title));
      paramBaseResp.putExtra("reason", localDepositOrderCreateResp.resultMessage);
      c().startActivity(paramBaseResp);
    }
  }
  
  public void rePay() {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/deposit/fragment/DepositInputFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */