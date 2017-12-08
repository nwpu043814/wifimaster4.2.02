package com.wifipay.wallet.card.ui.fragment;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.wifipay.R.drawable;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.a.f;
import com.wifipay.common.eventbus.EventBus;
import com.wifipay.framework.app.ui.BaseFragment;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.a.c;

public class BindCardSuccFragment
  extends BaseFragment
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_bindcard_result_btn)
    {
      c().finish();
      EventBus.getDefault().post(new c());
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout.wifipay_fragment_bindcard_result, null);
    ((ImageView)localView.findViewById(R.id.wifipay_bindcard_result_icon)).setImageResource(R.drawable.wifipay_wallet_identity_submit);
    ((TextView)localView.findViewById(R.id.wifipay_bindcard_result_status_text)).setText(f.a(R.string.wifipay_bindcard_result_success));
    paramLayoutInflater = (TextView)localView.findViewById(R.id.wifipay_bindcard_result_note);
    paramViewGroup = c().getResources().getString(R.string.wifipay_bindcard_result_success_note);
    paramBundle = getArguments().getString("bankName");
    paramLayoutInflater.setText(paramViewGroup.replace("[number]", getArguments().getString("bankNo")).replace("[name]", paramBundle));
    ((Button)localView.findViewById(R.id.wifipay_bindcard_result_btn)).setOnClickListener(this);
    return localView;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/card/ui/fragment/BindCardSuccFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */