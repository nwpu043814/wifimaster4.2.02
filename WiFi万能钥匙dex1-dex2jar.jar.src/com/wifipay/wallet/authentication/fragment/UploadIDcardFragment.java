package com.wifipay.wallet.authentication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.wifipay.R.color;
import com.wifipay.R.drawable;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.a.b;
import com.wifipay.common.a.f;
import com.wifipay.framework.app.ui.BaseFragment;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.authentication.activity.TakePhotoActivity;
import com.wifipay.wallet.prod.deposit.QueryRemindResp;
import com.wifipay.wallet.prod.deposit.QueryRemindResp.ResultObject;

public class UploadIDcardFragment
  extends BaseFragment
  implements View.OnClickListener
{
  private final String a = "2";
  private final String b = "3";
  private final String c = "4";
  private final String d = "5";
  private QueryRemindResp e;
  private TextView f;
  private TextView g;
  private Button h;
  private TextView i;
  private ImageView j;
  
  private void e()
  {
    Bundle localBundle = getArguments();
    if ((localBundle != null) && (localBundle.containsKey("extra_param"))) {
      this.e = ((QueryRemindResp)localBundle.getSerializable("extra_param"));
    }
  }
  
  private void f()
  {
    if (this.e == null) {}
    for (;;)
    {
      return;
      String str2 = this.e.resultObject.trueName;
      String str3 = this.e.resultObject.certNo;
      String str1 = this.e.resultObject.identityStatus;
      str2 = "*" + str2.substring(1, str2.length());
      str3 = str3.substring(0, 3) + "********" + str3.substring(str3.length() - 4);
      this.f.setText(str3);
      this.g.setText(str2);
      int k = -1;
      switch (str1.hashCode())
      {
      }
      for (;;)
      {
        switch (k)
        {
        default: 
          break;
        case 0: 
          this.i.setText(f.a(R.string.wifipay_identity_upload_new));
          this.j.setImageResource(R.drawable.wifipay_wallet_identity_add);
          this.h.setVisibility(0);
          this.h.setText(f.a(R.string.wifipay_identity_upload_beginning));
          break;
          if (str1.equals("2"))
          {
            k = 0;
            continue;
            if (str1.equals("3"))
            {
              k = 1;
              continue;
              if (str1.equals("4"))
              {
                k = 2;
                continue;
                if (str1.equals("5")) {
                  k = 3;
                }
              }
            }
          }
          break;
        }
      }
      this.i.setText(f.a(R.string.wifipay_identity_upload_review));
      this.j.setImageResource(R.drawable.wifipay_wallet_identity_auditing);
      this.h.setVisibility(4);
      continue;
      this.i.setText(f.a(R.string.wifipay_identity_upload_success));
      this.i.setTextColor(f.b(R.color.wifipay_color_333333));
      this.i.setTextSize(b.b(c(), 54.0F));
      this.j.setImageResource(R.drawable.wifipay_wallet_identity_success);
      this.h.setVisibility(4);
      continue;
      this.i.setText(f.a(R.string.wifipay_identity_upload_afresh));
      this.j.setImageResource(R.drawable.wifipay_wallet_identity_overdue);
      this.h.setVisibility(0);
      this.h.setText(f.a(R.string.wifipay_identity_upload_id_card));
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_upload_btn_confirm)
    {
      startActivity(new Intent(c(), TakePhotoActivity.class));
      c().finish();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    e();
    return paramLayoutInflater.inflate(R.layout.wifipay_fragment_upload_id_card, null);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    this.f = ((TextView)paramView.findViewById(R.id.wifipay_upload_card_number));
    this.g = ((TextView)paramView.findViewById(R.id.wifipay_upload_true_name));
    this.h = ((Button)paramView.findViewById(R.id.wifipay_upload_btn_confirm));
    this.i = ((TextView)paramView.findViewById(R.id.wifipay_upload_contacts_info));
    this.j = ((ImageView)paramView.findViewById(R.id.wifipay_upload_img_head));
    this.h.setOnClickListener(this);
    f();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/authentication/fragment/UploadIDcardFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */