package com.wifipay.wallet.home.setting;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.color;
import com.wifipay.R.id;
import com.wifipay.R.string;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.common.eventbus.ThreadMode;
import com.wifipay.framework.widget.WPEditTextView;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.common.info.AppInfo;
import com.wifipay.wallet.common.info.DeviceInfo;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.home.setting.option.FeedBackService;
import com.wifipay.wallet.home.setting.option.dto.FeedBackResp;

public class FeedbackActivity
  extends BaseActivity
{
  private EditText h;
  private WPEditTextView i;
  private com.wifipay.framework.api.b j;
  private Button k;
  private String l;
  private View.OnClickListener m = new a(this);
  
  static
  {
    StubApp1053578832.interface11(121);
  }
  
  private void i()
  {
    a(com.wifipay.common.a.f.a(R.string.wifipay_me_suggest_feedback));
  }
  
  private void j()
  {
    this.i = ((WPEditTextView)findViewById(R.id.wifipay_feedback_phone));
    this.h = ((EditText)findViewById(R.id.wifipay_feedback_content));
    this.h.setTextColor(getResources().getColor(R.color.wifipay_color_333333));
    this.k = ((Button)findViewById(R.id.wifipay_btn_commit));
    this.k.setOnClickListener(this.m);
    k();
    this.j = new com.wifipay.framework.api.b();
    this.j.a(this.i.getEditText());
    this.j.a(this.h);
    this.j.a(this.k);
    this.h.requestFocus();
  }
  
  private void k()
  {
    this.l = com.wifipay.wallet.common.info.b.a().f();
    if ((com.wifipay.wallet.common.info.b.a().n()) && (com.wifipay.wallet.common.utils.f.a(this.l)))
    {
      this.l = this.l.substring(0, this.l.indexOf("@"));
      this.i.setText(this.l);
      this.i.setEnabled(false);
    }
  }
  
  private void l()
  {
    c("");
    FeedBackService localFeedBackService = (FeedBackService)RpcService.getBgRpcProxy(FeedBackService.class);
    if (!com.wifipay.wallet.common.utils.f.b(this.i.getText()))
    {
      d();
      b(com.wifipay.common.a.f.a(R.string.wifipay_feedback_alert_text));
    }
    for (;;)
    {
      return;
      if (!com.wifipay.wallet.common.info.b.a().n()) {
        b(com.wifipay.common.a.f.a(R.string.wifipay_login_restart));
      } else {
        localFeedBackService.sendSuggest(this.i.getText(), this.h.getText().toString(), this.l, AppInfo.INSTANCE.getAppVersion(), DeviceInfo.INSTANCE.getMobileModel());
      }
    }
  }
  
  @Subscribe(threadMode=ThreadMode.MAIN)
  public void handleHomeInfo(FeedBackResp paramFeedBackResp)
  {
    d();
    if (paramFeedBackResp.resultCode.equals(ResponseCode.SUCCESS.getCode()))
    {
      a(com.wifipay.common.a.f.a(R.string.wifipay_thanks_for_suggest));
      finish();
    }
    for (;;)
    {
      return;
      b(paramFeedBackResp.resultMessage);
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/setting/FeedbackActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */