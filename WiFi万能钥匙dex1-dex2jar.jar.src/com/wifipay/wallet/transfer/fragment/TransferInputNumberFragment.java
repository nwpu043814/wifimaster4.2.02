package com.wifipay.wallet.transfer.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.common.logging.Logger;
import com.wifipay.framework.app.ui.BaseFragment;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.framework.widget.WPClearEditText;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.transfer.TransQueryContactsResp;
import com.wifipay.wallet.prod.transfer.TransQueryContactsResp.ResultObject;
import com.wifipay.wallet.prod.transfer.TransQueryPayeeResp;
import com.wifipay.wallet.prod.transfer.TransQueryPayeeResp.ResultObject;
import com.wifipay.wallet.prod.transfer.TransferService;
import com.wifipay.wallet.prod.user.HeadimgResp;
import com.wifipay.wallet.prod.user.HeadimgResp.ResultObject;
import com.wifipay.wallet.prod.user.UserService;
import com.wifipay.wallet.transfer.ContactsDetail;
import com.wifipay.wallet.transfer.a;
import com.wifipay.wallet.transfer.activity.TransferAmountInputActivity;
import java.util.ArrayList;

public class TransferInputNumberFragment
  extends BaseFragment
  implements View.OnClickListener, AdapterView.OnItemClickListener
{
  private WPClearEditText a;
  private ListView b;
  private a c;
  private ArrayList<ContactsDetail> d;
  private String e;
  private ContactsDetail f;
  private View g;
  
  private void c(String paramString)
  {
    String str2 = com.wifipay.wallet.common.info.b.a().f();
    String str1 = str2;
    if (str2.length() > 11) {
      str1 = str2.substring(0, 11);
    }
    if ((com.wifipay.wallet.common.utils.f.b(str1)) && (TextUtils.equals(str1, paramString))) {
      a(com.wifipay.common.a.f.a(R.string.wifipay_transfer_payee_different), com.wifipay.common.a.f.a(R.string.wifipay_btn_confirm), null);
    }
    for (;;)
    {
      return;
      b("");
      this.e = paramString;
      ((TransferService)RpcService.getBgRpcProxy(TransferService.class)).queryPayee(paramString);
    }
  }
  
  private void e()
  {
    if (!com.wifipay.wallet.common.info.b.a().n()) {}
    for (;;)
    {
      return;
      this.c = new a(c());
      this.b.setOnItemClickListener(this);
      b("");
      ((TransferService)RpcService.getBgRpcProxy(TransferService.class)).queryContacts(String.valueOf(System.currentTimeMillis()));
    }
  }
  
  @Subscribe
  public void handleHeadImg(HeadimgResp paramHeadimgResp)
  {
    d();
    Intent localIntent = new Intent(c(), TransferAmountInputActivity.class);
    localIntent.putExtra("payeename", this.f.payeeName);
    localIntent.putExtra("loginname", this.f.payeeLoginName);
    if (paramHeadimgResp.resultObject != null) {
      localIntent.putExtra("headimg", paramHeadimgResp.resultObject.icon);
    }
    startActivity(localIntent);
  }
  
  @Subscribe
  public void handleQueryContacts(TransQueryContactsResp paramTransQueryContactsResp)
  {
    d();
    if ((ResponseCode.SUCCESS.getCode().equals(paramTransQueryContactsResp.resultCode)) && (com.wifipay.wallet.common.utils.f.a(paramTransQueryContactsResp.resultObject)))
    {
      this.d = paramTransQueryContactsResp.resultObject.contactList;
      this.g.setVisibility(0);
      this.c.a(this.d);
      this.b.setAdapter(this.c);
    }
    for (;;)
    {
      return;
      this.g.setVisibility(8);
    }
  }
  
  @Subscribe
  public void handleQueryPayee(TransQueryPayeeResp paramTransQueryPayeeResp)
  {
    if (ResponseCode.SUCCESS.getCode().equals(paramTransQueryPayeeResp.resultCode)) {
      if ((paramTransQueryPayeeResp.resultObject != null) && (!TextUtils.isEmpty(paramTransQueryPayeeResp.resultObject.trueName)))
      {
        if (this.f == null) {
          this.f = new ContactsDetail();
        }
        this.f.payeeLoginName = this.e;
        this.f.payeeName = paramTransQueryPayeeResp.resultObject.trueName;
        ((UserService)RpcService.getBgRpcProxy(UserService.class)).getHeadImg(this.f.payeeLoginName);
      }
    }
    for (;;)
    {
      return;
      c().a(getString(R.string.wifipay_transfer_unrealname), getString(R.string.wifipay_btn_confirm), null);
      continue;
      a(paramTransQueryPayeeResp.resultMessage, com.wifipay.common.a.f.a(R.string.wifipay_btn_confirm), null);
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
    if (paramView.getId() == R.id.wifipay_btn_next)
    {
      if (com.wifipay.wallet.common.utils.f.b(this.a.getText().toString())) {
        break label44;
      }
      a(com.wifipay.common.a.f.a(R.string.wifipay_transfer_payee_phone), com.wifipay.common.a.f.a(R.string.wifipay_btn_confirm), null);
    }
    for (;;)
    {
      return;
      label44:
      c(this.a.getText().toString());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return paramLayoutInflater.inflate(R.layout.wifipay_fragment_transfer_account_input, null);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.d != null)
    {
      b("");
      c(((ContactsDetail)this.d.get(paramInt)).payeeLoginName);
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    paramBundle = (Button)paramView.findViewById(R.id.wifipay_btn_next);
    this.a = ((WPClearEditText)paramView.findViewById(R.id.wifipay_payee_account));
    this.b = ((ListView)paramView.findViewById(R.id.wifipay_transfer_linkman_list));
    this.g = paramView.findViewById(R.id.wifipay_transfer_more_fl);
    paramBundle.setOnClickListener(this);
    this.b.setOnItemClickListener(this);
    paramView = new com.wifipay.framework.api.b();
    paramView.a(this.a);
    paramView.a(paramBundle);
    this.a.requestFocus();
    e();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/transfer/fragment/TransferInputNumberFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */