package com.wifipay.wallet.pay.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.wifipay.R.drawable;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.a.f;
import com.wifipay.framework.app.ui.BaseFragment;
import com.wifipay.wallet.pay.SPayResp;
import com.wifipay.wallet.pay.SyncResp;

public class PayDetailsFailFragment
  extends BaseFragment
{
  private void e()
  {
    SPayResp localSPayResp = new SPayResp();
    localSPayResp.resultCode = "-2";
    SyncResp.a(localSPayResp);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.wifipay_fragment_pay_result, null);
    ((ImageView)paramLayoutInflater.findViewById(R.id.wifipay_result_icon)).setImageResource(R.drawable.wifipay_wallet_pay_result_fail);
    paramViewGroup = f.a(R.string.wifipay_payee_fail);
    ((TextView)paramLayoutInflater.findViewById(R.id.wifipay_result_status)).setText(paramViewGroup);
    e();
    return paramLayoutInflater;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/pay/fragment/PayDetailsFailFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */