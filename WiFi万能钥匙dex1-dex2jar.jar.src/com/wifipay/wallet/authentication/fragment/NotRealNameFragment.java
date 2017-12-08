package com.wifipay.wallet.authentication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.framework.app.ui.BaseFragment;
import java.util.HashMap;

public class NotRealNameFragment
  extends BaseFragment
{
  private String a;
  
  private void e()
  {
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.containsKey("cashier_type"))) {
      this.a = localBundle.getString("cashier_type");
    }
  }
  
  private void f()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("bindcardsource", this.a);
    new com.wifipay.wallet.card.a.a(c()).a(localHashMap);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    e();
    return paramLayoutInflater.inflate(R.layout.wifipay_fragment_not_realname, null);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    paramView.findViewById(R.id.wifipay_not_realname_btn_confirm).setOnClickListener(new a(this));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/authentication/fragment/NotRealNameFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */