package com.wifipay.wallet.withdraw.fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.wifipay.framework.widget.WPButton;
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
import com.wifipay.wallet.prod.core.model.PayCard;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.core.model.StartPayParams.ProductInfo;
import com.wifipay.wallet.prod.core.model.WalletCard;
import com.wifipay.wallet.prod.deposit.DepositService;
import com.wifipay.wallet.prod.security.query.QueryPaymentResp;
import com.wifipay.wallet.prod.security.query.QueryPaymentResp.ResultObject;
import com.wifipay.wallet.prod.security.query.QueryService;
import com.wifipay.wallet.prod.security.query.WalletBalanceResp;
import com.wifipay.wallet.prod.withdraw.WithdrawConfirmResp;
import com.wifipay.wallet.prod.withdraw.WithdrawConfirmResp.ResultObject;
import com.wifipay.wallet.withdraw.activity.AmountExplainActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WithdrawInputFragment
  extends BaseFragment
  implements TextWatcher, View.OnClickListener, PayListener
{
  public String a;
  private EditText b;
  private WPButton c;
  private ArrayList<PayCard> d;
  private View e;
  private PayCard f;
  private ImageView g;
  private TextView h;
  private String i;
  private com.wifipay.wallet.cashier.b.a j = null;
  private TextView k;
  private View l;
  private View m;
  private int n;
  private int o;
  
  private void e()
  {
    if (!b.a().n()) {}
    for (;;)
    {
      return;
      b("");
      QueryService localQueryService = (QueryService)RpcService.getBgRpcProxy(QueryService.class);
      localQueryService.queryPaymentByBiz(String.valueOf(System.currentTimeMillis()), "withdraw", "");
      this.o += 1;
      localQueryService.queryWalletBalance(String.valueOf(System.currentTimeMillis()));
      this.o += 1;
    }
  }
  
  private void f()
  {
    if (TextUtils.equals(PayCard.newCard(CashierType.WITHDRAW.getType()).type, (String)this.e.getTag())) {
      new com.wifipay.wallet.card.a.a(c()).a(null);
    }
    for (;;)
    {
      return;
      Intent localIntent = new Intent(c(), SelectCardActivity.class);
      localIntent.putExtra("card_list", this.d);
      localIntent.putExtra("select_card_type", CashierType.WITHDRAW.getType());
      startActivity(localIntent);
    }
  }
  
  private void g()
  {
    if (d.a(this.i, b.a().k()) > 0) {
      a(com.wifipay.common.a.f.a(R.string.wifipay_withdraw_not_exceeding_amount));
    }
    for (;;)
    {
      return;
      StartPayParams localStartPayParams = new StartPayParams();
      localStartPayParams.additionalParams = new HashMap();
      localStartPayParams.productInfo = new StartPayParams.ProductInfo();
      localStartPayParams.type = CashierType.WITHDRAW.getType();
      localStartPayParams.productInfo.productAmount = this.i;
      localStartPayParams.productInfo.productName = getString(R.string.wifipay_app_withdraw_title);
      localStartPayParams.additionalParams.put("amount", this.i);
      localStartPayParams.additionalParams.put("withdrawLabel", this.a);
      localStartPayParams.chosenCard = this.f;
      if (com.wifipay.wallet.common.utils.f.b(this.j)) {
        this.j = com.wifipay.wallet.cashier.a.a(CashierType.WITHDRAW.getType(), c(), this);
      }
      this.j.a(localStartPayParams);
      this.j.d();
    }
  }
  
  private void h()
  {
    int i1;
    Object localObject2;
    if ((com.wifipay.wallet.common.utils.f.a(this.d)) && (!this.d.isEmpty()))
    {
      i1 = 1;
      if (i1 == 0) {
        break label153;
      }
      localObject1 = (PayCard)this.d.get(0);
      Iterator localIterator = this.d.iterator();
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
        localObject1 = PayCard.newCard(CashierType.WITHDRAW.getType());
        this.e.setTag(((PayCard)localObject1).type);
      }
      for (;;)
      {
        this.f = ((PayCard)localObject1);
        d.a((PayCard)localObject1, this.g, this.h);
        return;
        i1 = 0;
        break;
        this.e.setTag(null);
      }
      localObject2 = localObject1;
      break label75;
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.i = g.a(this.b, paramEditable.toString(), this.c);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  @Subscribe(threadMode=ThreadMode.MAIN)
  public void handleBindcardSuc(c paramc)
  {
    b("");
    this.o += 1;
    ((DepositService)RpcService.getBgRpcProxy(DepositService.class)).queryPaymentByBiz(String.valueOf(System.currentTimeMillis()), "deposit", "");
  }
  
  @Subscribe
  public void handlePaymentByBiz(QueryPaymentResp paramQueryPaymentResp)
  {
    int i1 = this.n + 1;
    this.n = i1;
    if (i1 == this.o) {
      d();
    }
    if (TextUtils.equals(paramQueryPaymentResp.resultCode, ResponseCode.SUCCESS.getCode()))
    {
      this.d = paramQueryPaymentResp.resultObject.items;
      h();
    }
    for (;;)
    {
      return;
      a(paramQueryPaymentResp.resultMessage);
    }
  }
  
  @Subscribe
  public void handleWalletBalance(WalletBalanceResp paramWalletBalanceResp)
  {
    int i1 = this.n + 1;
    this.n = i1;
    if (i1 == this.o) {
      d();
    }
    if (ResponseCode.SUCCESS.getCode().equals(paramWalletBalanceResp.resultCode))
    {
      UserInfo localUserInfo = b.a().c();
      localUserInfo.setAvailableBalance(paramWalletBalanceResp.resultObject.availableBalance);
      localUserInfo.setFrozenBalance(paramWalletBalanceResp.resultObject.frozenBalance);
      this.k.setText(getActivity().getString(R.string.wifipay_withdraw_true_amount, new Object[] { paramWalletBalanceResp.resultObject.availableBalance }));
    }
    for (;;)
    {
      return;
      this.k.setText(getActivity().getString(R.string.wifipay_withdraw_true_amount, new Object[] { "0" }));
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Logger.v("zhao == %s", new Object[] { "requestCode" + paramInt1 });
    Logger.v("zhao == %s", new Object[] { "resultCode" + paramInt2 });
    e();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_withdraw_card) {
      f();
    }
    for (;;)
    {
      return;
      if (paramView.getId() == R.id.wifipay_btn_next) {
        g();
      } else if (paramView.getId() == R.id.wifipay_fl_account_today)
      {
        if (!this.m.isSelected())
        {
          this.m.setSelected(true);
          this.l.setSelected(false);
          this.a = "T0";
        }
      }
      else if (paramView.getId() == R.id.wifipay_fl_account_tomorrow)
      {
        if (!this.l.isSelected())
        {
          this.m.setSelected(false);
          this.l.setSelected(true);
          this.a = "T1";
        }
      }
      else if (paramView.getId() == R.id.wifipay_amount_explain) {
        startActivity(new Intent(c(), AmountExplainActivity.class));
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.wifipay_fragment_withdraw_amount_input, null);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.j != null)
    {
      this.j.b();
      this.j = null;
    }
  }
  
  @Subscribe
  public void onEventMainThread(com.wifipay.wallet.a.f paramf)
  {
    this.f = paramf.a;
    d.a(paramf.a, this.g, this.h);
  }
  
  public void onResume()
  {
    super.onResume();
    if (com.wifipay.wallet.common.utils.f.a(this.j)) {
      this.j.a();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.b = ((EditText)paramView.findViewById(R.id.wifipay_input_amount));
    this.c = ((WPButton)paramView.findViewById(R.id.wifipay_btn_next));
    this.e = paramView.findViewById(R.id.wifipay_withdraw_card);
    this.g = ((ImageView)paramView.findViewById(R.id.wifipay_bank_logo));
    this.h = ((TextView)paramView.findViewById(R.id.wifipay_card_item_info));
    paramBundle = (TextView)paramView.findViewById(R.id.wifipay_amount_entry_name);
    this.k = ((TextView)paramView.findViewById(R.id.wifipay_withdraw_balance));
    this.m = paramView.findViewById(R.id.wifipay_fl_account_today);
    this.l = paramView.findViewById(R.id.wifipay_fl_account_tomorrow);
    paramView.findViewById(R.id.wifipay_amount_explain).setOnClickListener(this);
    this.m.setSelected(true);
    this.a = "T0";
    paramBundle.setText(getResources().getString(R.string.wifipay_withdraw_amount));
    this.b.addTextChangedListener(this);
    this.e.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.l.setOnClickListener(this);
    h();
    e();
  }
  
  public void payFinish(int paramInt, BaseResp paramBaseResp)
  {
    HashMap localHashMap;
    Intent localIntent;
    if (com.wifipay.wallet.common.utils.f.a(paramBaseResp))
    {
      paramBaseResp = (WithdrawConfirmResp)paramBaseResp;
      localHashMap = new HashMap();
      localHashMap.put("requestLoginName", b.a().f());
      localHashMap.put("resposePayTime", d.a(System.currentTimeMillis()));
      localHashMap.put("orderResposeCode", paramBaseResp.resultCode);
      localHashMap.put("orderResposeMessage", paramBaseResp.resultMessage);
      localHashMap.put("type", "Withdraw");
      if (!ResponseCode.SUCCESS.getCode().equals(paramBaseResp.resultCode)) {
        break label266;
      }
      localIntent = new Intent(c(), MoneySuccessActivity.class);
      localIntent.putExtra("extra_type", getString(R.string.wifipay_withdraw_title));
      localIntent.putExtra("extra_amoubt", this.i);
      if (paramBaseResp.resultObject != null)
      {
        localIntent.putExtra("extra_bankcode", paramBaseResp.resultObject.cardNo);
        localIntent.putExtra("extra_bankname", paramBaseResp.resultObject.bankName);
        localHashMap.put("orderId", paramBaseResp.resultObject.withdrawId);
        localHashMap.put("orderBankName", paramBaseResp.resultObject.bankName);
        localHashMap.put("orderCardNo", paramBaseResp.resultObject.cardNo);
      }
      com.wifipay.wallet.common.utils.a.a(getActivity(), "Withdraw", localHashMap);
      startActivity(localIntent);
    }
    for (;;)
    {
      return;
      label266:
      com.wifipay.wallet.common.utils.a.a(getActivity(), "Withdraw", localHashMap);
      localIntent = new Intent(c(), MoneyFailActivity.class);
      localIntent.putExtra("extra_type", getString(R.string.wifipay_withdraw_title));
      localIntent.putExtra("reason", paramBaseResp.resultMessage);
      c().startActivity(localIntent);
    }
  }
  
  public void rePay() {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/withdraw/fragment/WithdrawInputFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */