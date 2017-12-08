package com.wifipay.wallet.transfer.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.a.g;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.common.net.UnifyDispose;
import com.wifipay.common.net.entitybase.BaseResp;
import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.framework.widget.WPAlertDialog;
import com.wifipay.framework.widget.WPAlertDialog.a;
import com.wifipay.framework.widget.WPCircularImage;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.cashier.PayListener;
import com.wifipay.wallet.cashier.ui.SelectCardActivity;
import com.wifipay.wallet.common.info.UserInfo;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.deposit.ui.MoneyFailActivity;
import com.wifipay.wallet.deposit.ui.MoneySuccessActivity;
import com.wifipay.wallet.prod.core.model.PayCard;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.core.model.StartPayParams.ProductInfo;
import com.wifipay.wallet.prod.core.model.WalletCard;
import com.wifipay.wallet.prod.security.query.CreditLevelResp;
import com.wifipay.wallet.prod.security.query.CreditLevelResp.ResultObject;
import com.wifipay.wallet.prod.security.query.QueryPaymentResp;
import com.wifipay.wallet.prod.security.query.QueryPaymentResp.ResultObject;
import com.wifipay.wallet.prod.security.query.QueryService;
import com.wifipay.wallet.prod.security.query.WalletBalanceResp;
import com.wifipay.wallet.prod.transfer.TransConfirm3Resp;
import com.wifipay.wallet.prod.transfer.TransConfirm3Resp.ResultObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Timer;

public class TransferAmountInputActivity
  extends BaseActivity
  implements TextWatcher, View.OnClickListener, PayListener
{
  private Button h;
  private TextView i;
  private String j;
  private PayCard k;
  private TextView l;
  private ArrayList<PayCard> m;
  private com.wifipay.wallet.cashier.b.a n;
  private EditText o;
  private String p;
  private HashMap<String, String> q = new HashMap();
  private int r;
  private int s;
  private String t;
  private String u;
  private String v;
  private EditText w;
  private TextView x;
  private TextView y;
  private EditText z;
  
  static
  {
    StubApp1053578832.interface11(137);
  }
  
  private void d(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(null, getString(R.string.wifipay_name_verify_success), null, null, getString(R.string.wifipay_common_confirm), null);
      this.y.setVisibility(8);
    }
    for (;;)
    {
      return;
      a(null, getString(R.string.wifipay_name_verify_fail), getString(R.string.wifipay_common_repeat), new f(this), getString(R.string.wifipay_common_cancel), null);
    }
  }
  
  private void i()
  {
    c("");
    ((QueryService)RpcService.getBgRpcProxy(QueryService.class)).queryWalletBalance(String.valueOf(System.currentTimeMillis()));
    this.s += 1;
  }
  
  private void j()
  {
    int i1;
    Object localObject1;
    Object localObject2;
    if ((com.wifipay.wallet.common.utils.f.a(this.m)) && (!this.m.isEmpty()))
    {
      i1 = 1;
      if (i1 != 0)
      {
        this.k = ((PayCard)this.m.get(0));
        localObject1 = this.m.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (PayCard)((Iterator)localObject1).next();
          if (((PayCard)localObject2).isDefault()) {
            this.k = ((PayCard)localObject2);
          }
        }
        if (!this.k.isEnable()) {
          this.k = null;
        }
      }
      if (!com.wifipay.wallet.common.utils.f.b(this.k)) {
        break label128;
      }
      this.k = PayCard.newCard(CashierType.TRANSFER.getType());
      label117:
      break label188;
    }
    for (;;)
    {
      l();
      return;
      i1 = 0;
      break;
      label128:
      if ((TextUtils.equals(this.k.paymentType, "BALANCE")) && (Double.valueOf(com.wifipay.wallet.common.info.b.a().c().getAvailableBalance()).doubleValue() <= 0.0D) && (this.m != null) && (!this.m.isEmpty()))
      {
        localObject2 = this.m.iterator();
        label188:
        if (((Iterator)localObject2).hasNext())
        {
          localObject1 = (PayCard)((Iterator)localObject2).next();
          if ((!((PayCard)localObject1).isEnable()) || (TextUtils.equals(((PayCard)localObject1).paymentType, "BALANCE"))) {
            break label117;
          }
          this.k = ((PayCard)localObject1);
        }
      }
    }
  }
  
  private void k()
  {
    this.h = ((Button)findViewById(R.id.wifipay_transfer_btn_confirm));
    this.i = ((TextView)findViewById(R.id.wifipay_transfer_contacts_info));
    TextView localTextView1 = (TextView)findViewById(R.id.wifipay_transfer_contacts_phone);
    this.x = ((TextView)findViewById(R.id.wifipay_paymethod_card));
    Object localObject = (TextView)findViewById(R.id.wifipay_paymethod_change);
    this.l = ((TextView)findViewById(R.id.wifipay_credit_level_limit));
    TextView localTextView2 = (TextView)findViewById(R.id.wifipay_amount_entry_name);
    this.y = ((TextView)findViewById(R.id.wifipay_click_this_check));
    this.o = ((EditText)findViewById(R.id.wifipay_input_remark));
    WPCircularImage localWPCircularImage = (WPCircularImage)findViewById(R.id.wifipay_transfer_pay_head);
    localTextView2.setText(getResources().getString(R.string.wifipay_transfer_to_amount));
    this.h.setOnClickListener(this);
    ((TextView)localObject).setOnClickListener(this);
    this.y.setOnClickListener(this);
    this.h.setEnabled(false);
    this.w = ((EditText)findViewById(R.id.wifipay_input_amount));
    this.w.addTextChangedListener(this);
    this.w.requestFocus();
    if ((!g.a(this.t)) && (!com.wifipay.wallet.common.utils.f.e(this.t)))
    {
      localObject = this.t.replace(this.t.substring(0, 1), "*");
      this.y.setVisibility(0);
    }
    for (;;)
    {
      this.i.setText((CharSequence)localObject);
      if (com.wifipay.wallet.common.utils.f.c(this.u)) {
        break;
      }
      localObject = this.u.replace(this.u.substring(3, 7), "****");
      localTextView1.setText((CharSequence)localObject);
      if (!g.a(this.v)) {
        localWPCircularImage.setImageBitmap(com.wifipay.wallet.common.utils.d.f(this.v));
      }
      return;
      localObject = getResources().getString(R.string.wifipay_no_such_users);
      this.y.setVisibility(8);
    }
    localObject = new StringBuilder(this.u);
    int i1 = ((StringBuilder)localObject).indexOf("@");
    if (i1 > 3) {
      ((StringBuilder)localObject).replace(3, i1, "****");
    }
    for (;;)
    {
      localObject = ((StringBuilder)localObject).toString();
      break;
      if (i1 > 0) {
        ((StringBuilder)localObject).replace(0, i1, "****");
      }
    }
  }
  
  private void l()
  {
    if (this.k == null) {}
    for (;;)
    {
      return;
      if (TextUtils.equals(this.k.type, "NEW_CARD")) {
        this.x.setText(getResources().getString(R.string.wifipay_paymethod_new_card));
      }
      for (;;)
      {
        if (!this.k.getType().equals("CONVENIENCE")) {
          break label174;
        }
        this.l.setVisibility(0);
        m();
        break;
        if (TextUtils.isEmpty(this.k.cardNo)) {
          this.x.setText(getResources().getString(R.string.wifipay_paymethod_balance));
        } else {
          this.x.setText(getResources().getString(R.string.wifipay_paymethod_tv_card, new Object[] { this.k.desc + "(" + this.k.cardNo + ")" }));
        }
      }
      label174:
      this.l.setVisibility(8);
    }
  }
  
  private void m()
  {
    if ((this.k == null) || (TextUtils.isEmpty((CharSequence)this.q.get(this.k.agreementNo)))) {
      BackgroundExecutor.a(new b(this));
    }
    for (;;)
    {
      return;
      this.l.setText((CharSequence)this.q.get(this.k.agreementNo));
    }
  }
  
  private void n()
  {
    Intent localIntent = new Intent(this, SelectCardActivity.class);
    localIntent.putExtra("card_list", this.m);
    localIntent.putExtra("select_card_type", CashierType.TRANSFER.getType());
    startActivity(localIntent);
  }
  
  private void o()
  {
    if (this.k.getType().equals("BALANCE"))
    {
      if (com.wifipay.wallet.common.utils.d.a(this.j, com.wifipay.wallet.common.info.b.a().k()) <= 0) {
        break label98;
      }
      b(com.wifipay.common.a.f.a(R.string.wifipay_wallet_unenough_trade));
    }
    for (;;)
    {
      return;
      if ((this.k.getType().equals("CONVENIENCE")) && (com.wifipay.wallet.common.utils.d.a(this.p, "0") > 0) && (com.wifipay.wallet.common.utils.d.a(this.j, this.p) > 0))
      {
        b(com.wifipay.common.a.f.a(R.string.wifipay_withdraw_not_transfer_amount));
      }
      else
      {
        label98:
        StartPayParams localStartPayParams = new StartPayParams();
        localStartPayParams.productInfo = new StartPayParams.ProductInfo();
        localStartPayParams.additionalParams = new HashMap();
        localStartPayParams.type = CashierType.TRANSFER.getType();
        localStartPayParams.chosenCard = this.k;
        localStartPayParams.productInfo.productName = com.wifipay.common.a.f.a(R.string.wifipay_app_transfer_title);
        localStartPayParams.productInfo.productAmount = this.j;
        localStartPayParams.productInfo.productAccountName = this.i.getText().toString();
        localStartPayParams.additionalParams.put("amount", this.j);
        localStartPayParams.additionalParams.put("payeeLoginName", this.u);
        localStartPayParams.additionalParams.put("bizType", "UT001");
        localStartPayParams.additionalParams.put("memo", this.o.getText().toString());
        localStartPayParams.additionalParams.put("isSign", "false");
        if (com.wifipay.wallet.common.utils.f.b(this.n)) {
          this.n = com.wifipay.wallet.cashier.a.a(CashierType.TRANSFER.getType(), this, this);
        }
        this.n.a(localStartPayParams);
        this.n.d();
      }
    }
  }
  
  private void p()
  {
    WPAlertDialog localWPAlertDialog = new WPAlertDialog.a(this).a();
    localWPAlertDialog.b(getString(R.string.wifipay_common_confirm));
    localWPAlertDialog.a(new c(this));
    localWPAlertDialog.c(getString(R.string.wifipay_common_cancel));
    localWPAlertDialog.a(new d(this));
    localWPAlertDialog.setCanceledOnTouchOutside(false);
    localWPAlertDialog.show();
    localWPAlertDialog.setCancelable(false);
    View localView = LayoutInflater.from(this).inflate(R.layout.wifipay_verify_llview, null);
    this.z = ((EditText)localView.findViewById(R.id.wifipay_verify_llview_edit));
    new Timer().schedule(new e(this), 500L);
    this.z.setFocusableInTouchMode(true);
    this.z.requestFocus();
    ((TextView)localView.findViewById(R.id.wifipay_verify_llview_text)).setText(this.t.substring(1, this.t.length()));
    localWPAlertDialog.a(localView);
  }
  
  protected void a(UnifyDispose paramUnifyDispose)
  {
    d();
    a(paramUnifyDispose.getResponse().resultMessage, getString(R.string.wifipay_btn_confirm), null);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    this.j = g.a(this.w, paramEditable.toString(), this.h);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  @Subscribe
  public void handleQueryLimit(CreditLevelResp paramCreditLevelResp)
  {
    if (paramCreditLevelResp.resultCode.equals(ResponseCode.SUCCESS.getCode()))
    {
      this.p = paramCreditLevelResp.resultObject.limit;
      paramCreditLevelResp = com.wifipay.common.a.f.a(R.string.wifipay_credit_level_limit_text, new Object[] { paramCreditLevelResp.resultObject.limit, paramCreditLevelResp.resultObject.dayLimit });
      this.l.setText(paramCreditLevelResp);
      this.q.put(this.k.agreementNo, paramCreditLevelResp);
    }
    for (;;)
    {
      return;
      b(paramCreditLevelResp.resultMessage);
    }
  }
  
  @Subscribe
  public void handleQueryPaymentByBiz(QueryPaymentResp paramQueryPaymentResp)
  {
    int i1 = this.r + 1;
    this.r = i1;
    if (i1 == this.s) {
      d();
    }
    if (ResponseCode.SUCCESS.getCode().equals(paramQueryPaymentResp.resultCode))
    {
      this.m = paramQueryPaymentResp.resultObject.items;
      j();
    }
    for (;;)
    {
      return;
      d();
    }
  }
  
  @Subscribe
  public void handleWalletBalance(WalletBalanceResp paramWalletBalanceResp)
  {
    ((QueryService)RpcService.getBgRpcProxy(QueryService.class)).queryPaymentByBiz(String.valueOf(System.currentTimeMillis()), "transfer", "");
    this.s += 1;
    int i1 = this.r + 1;
    this.r = i1;
    if (i1 == this.s) {
      d();
    }
    if (ResponseCode.SUCCESS.getCode().equals(paramWalletBalanceResp.resultCode))
    {
      UserInfo localUserInfo = com.wifipay.wallet.common.info.b.a().c();
      localUserInfo.setFrozenBalance(paramWalletBalanceResp.resultObject.frozenBalance);
      if (!TextUtils.equals(localUserInfo.getAvailableBalance(), paramWalletBalanceResp.resultObject.availableBalance))
      {
        localUserInfo.setAvailableBalance(paramWalletBalanceResp.resultObject.availableBalance);
        j();
      }
    }
    for (;;)
    {
      return;
      d();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_paymethod_change) {
      n();
    }
    for (;;)
    {
      return;
      if (paramView.getId() == R.id.wifipay_transfer_btn_confirm) {
        o();
      } else if (paramView.getId() == R.id.wifipay_click_this_check) {
        p();
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout.wifipay_activity_transfer_amount_input);
    a(getResources().getString(R.string.wifipay_app_transfer_info));
    this.t = getIntent().getStringExtra("payeename");
    if (TextUtils.isEmpty(this.t)) {
      a(getString(R.string.wifipay_transfer_unrealname), getString(R.string.wifipay_btn_confirm), new a(this));
    }
    for (;;)
    {
      return;
      this.u = getIntent().getStringExtra("loginname");
      this.v = getIntent().getStringExtra("headimg");
      k();
      j();
      i();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (com.wifipay.wallet.common.utils.f.a(this.n))
    {
      this.n.b();
      this.n = null;
    }
  }
  
  @Subscribe
  public void onEventMainThread(com.wifipay.wallet.a.f paramf)
  {
    this.k = paramf.a;
    l();
  }
  
  protected void onResume()
  {
    super.onResume();
    if (com.wifipay.wallet.common.utils.f.a(this.n)) {
      this.n.a();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void payFinish(int paramInt, BaseResp paramBaseResp)
  {
    TransConfirm3Resp localTransConfirm3Resp;
    HashMap localHashMap;
    if (com.wifipay.wallet.common.utils.f.a(paramBaseResp))
    {
      localTransConfirm3Resp = (TransConfirm3Resp)paramBaseResp;
      localHashMap = new HashMap();
      localHashMap.put("requestLoginName", com.wifipay.wallet.common.info.b.a().f());
      localHashMap.put("resposePayTime", com.wifipay.wallet.common.utils.d.a(System.currentTimeMillis()));
      localHashMap.put("orderResposeCode", localTransConfirm3Resp.resultCode);
      localHashMap.put("orderResposeMessage", localTransConfirm3Resp.resultMessage);
      localHashMap.put("type", "Transfer");
      if (!ResponseCode.SUCCESS.getCode().equals(paramBaseResp.resultCode)) {
        break label340;
      }
      paramBaseResp = new Intent(this, MoneySuccessActivity.class);
      paramBaseResp.putExtra("extra_type", getString(R.string.wifipay_transfer_title));
      paramBaseResp.putExtra("extra_amoubt", this.j);
      if (localTransConfirm3Resp.resultObject != null)
      {
        paramBaseResp.putExtra("extra_bankcode", localTransConfirm3Resp.resultObject.cardNo);
        paramBaseResp.putExtra("extra_bankname", localTransConfirm3Resp.resultObject.bankName);
        localHashMap.put("orderId", localTransConfirm3Resp.resultObject.orderId);
        localHashMap.put("orderBankName", localTransConfirm3Resp.resultObject.bankName);
        localHashMap.put("orderCardNo", localTransConfirm3Resp.resultObject.cardNo);
      }
      paramBaseResp.putExtra("extra_payeename", this.t);
      paramBaseResp.putExtra("extra_payeeloginname", this.u);
      paramBaseResp.putExtra("extra_remark", this.o.getText().toString());
      localHashMap.put("orderLoginName", this.u);
      localHashMap.put("orderPayeeName", this.i.getText().toString());
      com.wifipay.wallet.common.utils.a.a(this, "Transfer", localHashMap);
      startActivity(paramBaseResp);
    }
    for (;;)
    {
      return;
      label340:
      com.wifipay.wallet.common.utils.a.a(this, "Transfer", localHashMap);
      paramBaseResp = new Intent(this, MoneyFailActivity.class);
      paramBaseResp.putExtra("extra_type", getString(R.string.wifipay_transfer_title));
      paramBaseResp.putExtra("reason", localTransConfirm3Resp.resultMessage);
      startActivity(paramBaseResp);
    }
  }
  
  public void rePay() {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/transfer/activity/TransferAmountInputActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */