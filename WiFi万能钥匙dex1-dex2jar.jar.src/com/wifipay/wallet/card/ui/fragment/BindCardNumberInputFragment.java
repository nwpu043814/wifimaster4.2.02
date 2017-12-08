package com.wifipay.wallet.card.ui.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.R.style;
import com.wifipay.common.a.g;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.common.eventbus.ThreadMode;
import com.wifipay.framework.api.b;
import com.wifipay.framework.app.ui.BaseFragment;
import com.wifipay.framework.widget.WPEditTextView;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.common.utils.d;
import com.wifipay.wallet.common.utils.f;
import com.wifipay.wallet.prod.bandcard.BindCardService;
import com.wifipay.wallet.prod.bandcard.dto.BindCardCheckBinResp;
import com.wifipay.wallet.prod.bandcard.dto.BindCardCheckBinResp.ResultObject;
import com.wifipay.wallet.prod.security.account.AccountManagerService;
import com.wifipay.wallet.prod.security.account.dto.QueryRNInfoResp;
import com.wifipay.wallet.prod.security.account.dto.QueryRNInfoResp.ResultObject;
import com.wifipay.wallet.widget.virtualkeyboard.VirtualKeyBoardFlag;
import com.wifipay.wallet.widget.virtualkeyboard.VirtualKeyboardView;
import java.util.HashMap;
import java.util.Map;

public class BindCardNumberInputFragment
  extends BaseFragment
  implements View.OnClickListener
{
  private ImageView a;
  private WPEditTextView b;
  private WPEditTextView c;
  private View d;
  private View e;
  private b f;
  private String g;
  private VirtualKeyboardView h;
  
  private void a(String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cardNumber", this.b.getText());
    localHashMap.put("cardOwner", this.c.getText());
    com.wifipay.wallet.common.utils.a.a(getActivity(), getClass().getSimpleName(), paramString1, paramString2, localHashMap);
  }
  
  private void f()
  {
    this.f.a(this.b.getEditText());
    this.f.a(this.e);
    this.e.setOnClickListener(this);
    this.a.setOnClickListener(this);
    this.b.requestFocus();
    this.h.setNotUseSystemKeyBoard(this.b.getEditText());
    this.h.a(this.b.getEditText(), VirtualKeyBoardFlag.NUMBER.getFlag());
    d.a(this.b.getEditText());
    g();
  }
  
  private void g()
  {
    ((AccountManagerService)RpcService.getBgRpcProxy(AccountManagerService.class)).queryRealName(String.valueOf(System.currentTimeMillis()));
  }
  
  private void h()
  {
    b("");
    ((BindCardService)RpcService.getBgRpcProxy(BindCardService.class)).checkBin(this.b.getText().replace(" ", ""));
  }
  
  public void e()
  {
    a("返回", "");
  }
  
  @Subscribe
  public void handleCheckCardBin(BindCardCheckBinResp paramBindCardCheckBinResp)
  {
    d();
    String str;
    if (g.a(ResponseCode.SUCCESS.getCode(), paramBindCardCheckBinResp.resultCode))
    {
      if (("CR".equals(paramBindCardCheckBinResp.resultObject.cardType)) && ((CashierType.DEPOSIT.getType().equals(this.g)) || (CashierType.TRANSFER.getType().equals(this.g)) || (CashierType.WITHDRAW.getType().equals(this.g))))
      {
        a(getResources().getString(R.string.wifipay_bindcard_un_support));
        return;
      }
      Bundle localBundle = new Bundle(getArguments());
      localBundle.putString("bankName", paramBindCardCheckBinResp.resultObject.bankName);
      localBundle.putString("bankNumber", this.b.getText().replace(" ", ""));
      localBundle.putString("bankCode", paramBindCardCheckBinResp.resultObject.bankCode);
      localBundle.putString("cardType", paramBindCardCheckBinResp.resultObject.cardType);
      localBundle.putString("trueName", this.c.getText());
      if (this.c.getTag(R.id.wifipay_tag1) == null)
      {
        str = null;
        label201:
        localBundle.putString("certNo", str);
        localBundle.putString("bindcardsource", this.g);
        a(R.id.wifipay_fragment_identity_check, localBundle);
      }
    }
    for (;;)
    {
      a("下一步", paramBindCardCheckBinResp.resultMessage);
      break;
      str = (String)this.c.getTag(R.id.wifipay_tag1);
      break label201;
      if (TextUtils.equals(ResponseCode.HPS_AGREEMENTNO_MAX.getCode(), paramBindCardCheckBinResp.resultCode)) {
        a(ResponseCode.HPS_AGREEMENTNO_MAX.getDesc());
      } else {
        a(paramBindCardCheckBinResp.resultMessage);
      }
    }
  }
  
  @Subscribe(threadMode=ThreadMode.MAIN)
  public void handleRealName(QueryRNInfoResp paramQueryRNInfoResp)
  {
    if ((g.a(ResponseCode.SUCCESS.getCode(), paramQueryRNInfoResp.resultCode)) && (paramQueryRNInfoResp.resultObject != null) && (!g.a(paramQueryRNInfoResp.resultObject.trueName)))
    {
      this.d.setVisibility(0);
      if (CashierType.SETPWD.getType().equals(this.g))
      {
        this.c.setText(d.j(paramQueryRNInfoResp.resultObject.trueName));
        this.c.setWPTextAppearance(R.style.wifipay_font_9a9a9a_45);
        this.c.setTag(R.id.wifipay_tag1, paramQueryRNInfoResp.resultObject.certNo);
        this.c.setEnabled(false);
        this.a.setVisibility(0);
      }
    }
    for (;;)
    {
      return;
      this.c.setText(paramQueryRNInfoResp.resultObject.trueName);
      break;
      this.c.setTag(R.id.wifipay_tag1, null);
      this.d.setVisibility(8);
      this.a.setVisibility(8);
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_bindcard_btn_next) {
      h();
    }
    for (;;)
    {
      return;
      if (paramView.getId() == R.id.wifipay_card_own_note) {
        a(getString(R.string.wifipay_remindertitle), getString(R.string.wifipay_band_card_note), getString(R.string.wifipay_alert_btn_i_know), new a(this), null, null);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.f = new b();
    paramBundle = (HashMap)getArguments().getSerializable("local_data");
    if (f.a(paramBundle)) {
      this.g = ((String)paramBundle.get("bindcardsource"));
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.wifipay_fragment_new_card_no, null);
    this.a = ((ImageView)paramLayoutInflater.findViewById(R.id.wifipay_card_own_note));
    this.b = ((WPEditTextView)paramLayoutInflater.findViewById(R.id.wifipay_bindcard_card_id));
    this.c = ((WPEditTextView)paramLayoutInflater.findViewById(R.id.wifipay_card_own));
    this.d = paramLayoutInflater.findViewById(R.id.wifipay_bindcard_card_own_container);
    this.e = paramLayoutInflater.findViewById(R.id.wifipay_bindcard_btn_next);
    this.h = ((VirtualKeyboardView)paramLayoutInflater.findViewById(R.id.wifipay_bottom_virtual_keyboard));
    f();
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/card/ui/fragment/BindCardNumberInputFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */