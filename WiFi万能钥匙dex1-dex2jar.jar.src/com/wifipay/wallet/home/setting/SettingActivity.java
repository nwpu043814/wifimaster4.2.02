package com.wifipay.wallet.home.setting;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.drawable;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.a.g;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.common.eventbus.ThreadMode;
import com.wifipay.framework.widget.WPCircularImage;
import com.wifipay.framework.widget.WPRelativeLayout;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.common.info.DeviceInfo;
import com.wifipay.wallet.common.info.b;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.common.utils.f;
import com.wifipay.wallet.home.ui.AccountWebActivity;
import com.wifipay.wallet.paypassword.common.PreRetrievePP;
import com.wifipay.wallet.paypassword.common.a;
import com.wifipay.wallet.prod.security.account.AccountManagerService;
import com.wifipay.wallet.prod.security.account.dto.QueryRNInfoResp;
import com.wifipay.wallet.prod.security.account.dto.QueryRNInfoResp.ResultObject;
import com.wifipay.wallet.prod.user.HeadimgResp;
import com.wifipay.wallet.prod.user.HeadimgResp.ResultObject;

public class SettingActivity
  extends BaseActivity
{
  private WPRelativeLayout h;
  private WPCircularImage i;
  private TextView j;
  private TextView k;
  private ImageView l;
  private TextView m;
  private LinearLayout n;
  private String o;
  
  static
  {
    StubApp1053578832.interface11(122);
  }
  
  private void e(String paramString)
  {
    DeviceInfo.INSTANCE.startCall(paramString, this);
  }
  
  private void i()
  {
    if (b.a().n())
    {
      String str = b.a().f();
      this.o = b.a().q();
      Object localObject = str;
      if (f.a(str)) {
        localObject = str.substring(0, str.indexOf("@"));
      }
      if (f.a(localObject)) {
        this.k.setText(com.wifipay.wallet.common.utils.d.g((String)localObject));
      }
      if (f.a(this.o))
      {
        localObject = com.wifipay.wallet.common.utils.d.f(this.o);
        this.i.setImageBitmap((Bitmap)localObject);
      }
      j();
    }
    for (;;)
    {
      return;
      this.j.setText(getResources().getString(R.string.wifipay_setting_no_login));
      this.k.setVisibility(4);
    }
  }
  
  private void j()
  {
    String str = b.a().p();
    if (f.a(str))
    {
      this.n.setVisibility(0);
      this.j.setText(str);
      if (!g.a(str, getResources().getString(R.string.wifipay_setting_no_approve))) {
        break label85;
      }
      this.l.setImageDrawable(getResources().getDrawable(R.drawable.wifipay_home_setting_approve_no));
    }
    for (;;)
    {
      ((AccountManagerService)RpcService.getBgRpcProxy(AccountManagerService.class)).queryRealName(String.valueOf(System.currentTimeMillis()));
      return;
      label85:
      this.l.setImageDrawable(getResources().getDrawable(R.drawable.wifipay_home_setting_approve_ok));
    }
  }
  
  private void k()
  {
    setContentView(R.layout.wifipay_home_setting_main);
    a("支付管理");
    this.h = ((WPRelativeLayout)findViewById(R.id.wifipay_setting_header));
    this.n = ((LinearLayout)findViewById(R.id.wifipay_setting_header_group));
    this.i = ((WPCircularImage)findViewById(R.id.wifipay_setting_header_image));
    this.j = ((TextView)findViewById(R.id.wifipay_setting_header_title));
    this.k = ((TextView)findViewById(R.id.wifipay_setting_header_number));
    this.l = ((ImageView)findViewById(R.id.wifipay_setting_header_approve));
    this.m = ((TextView)findViewById(R.id.wifipay_contact_number));
  }
  
  private void l()
  {
    startActivity(new Intent(this, FeedbackActivity.class));
  }
  
  public void clickSkip(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_setting_call) {
      e(this.m.getText().toString());
    }
    for (;;)
    {
      return;
      if (!com.wifipay.common.a.d.a(this))
      {
        b(getResources().getString(R.string.wifipay_home_no_net));
      }
      else
      {
        if (paramView.getId() == R.id.wifipay_setting_name_approve)
        {
          Intent localIntent = new Intent(this, AccountWebActivity.class);
          localIntent.putExtra("title", "账户等级");
          localIntent.putExtra("webViewType", "web");
          localIntent.putExtra("webViewName", "https://rnauth.shengpay.com/mobile/accountLevel/view/level.html");
          startActivity(localIntent);
        }
        if (paramView.getId() == R.id.wifipay_setting_alter_password) {
          new a(this).a();
        }
        if (paramView.getId() == R.id.wifipay_setting_forget_password) {
          new PreRetrievePP(this, null).a();
        }
        if (paramView.getId() == R.id.wifipay_setting_opinion) {
          l();
        }
      }
    }
  }
  
  @Subscribe(threadMode=ThreadMode.MAIN)
  public void handleHeadImg(HeadimgResp paramHeadimgResp)
  {
    if ((f.a(paramHeadimgResp.resultObject)) && (ResponseCode.SUCCESS.getCode().equals(paramHeadimgResp.resultCode)) && (!g.a(paramHeadimgResp.resultObject.icon)))
    {
      Bitmap localBitmap = com.wifipay.wallet.common.utils.d.f(paramHeadimgResp.resultObject.icon);
      b.a().c(paramHeadimgResp.resultObject.icon);
      this.i.setImageBitmap(localBitmap);
    }
  }
  
  @Subscribe(threadMode=ThreadMode.MAIN)
  public void handleRealName(QueryRNInfoResp paramQueryRNInfoResp)
  {
    if ((f.a(paramQueryRNInfoResp)) && (ResponseCode.SUCCESS.getCode().equals(paramQueryRNInfoResp.resultCode)))
    {
      this.n.setVisibility(0);
      if (f.a(paramQueryRNInfoResp.resultObject))
      {
        b.a().b(paramQueryRNInfoResp.resultObject.trueName);
        this.j.setText(paramQueryRNInfoResp.resultObject.trueName);
        this.l.setImageDrawable(getResources().getDrawable(R.drawable.wifipay_home_setting_approve_ok));
      }
    }
    for (;;)
    {
      return;
      b.a().b(getResources().getString(R.string.wifipay_setting_no_approve));
      this.j.setText(getResources().getString(R.string.wifipay_setting_no_approve));
      this.l.setImageDrawable(getResources().getDrawable(R.drawable.wifipay_home_setting_approve_no));
      continue;
      b(paramQueryRNInfoResp.resultMessage);
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onStart()
  {
    super.onStart();
    i();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/setting/SettingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */