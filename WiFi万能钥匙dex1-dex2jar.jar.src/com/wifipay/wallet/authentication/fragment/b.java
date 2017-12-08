package com.wifipay.wallet.authentication.fragment;

import com.wifipay.common.security.Base64;
import com.wifipay.framework.api.BackgroundExecutor.a;
import com.wifipay.framework.widget.WPTwoTextView;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.prod.user.UploadResp;
import com.wifipay.wallet.prod.user.UserService;

class b
  extends BackgroundExecutor.a
{
  b(UploadShowPhotoFragment paramUploadShowPhotoFragment) {}
  
  public void a()
  {
    UserService localUserService = (UserService)RpcService.getRpcProxy(UserService.class);
    Object localObject = Base64.encode(UploadShowPhotoFragment.a(this.a, UploadShowPhotoFragment.a(this.a)));
    String str = Base64.encode(UploadShowPhotoFragment.a(this.a, UploadShowPhotoFragment.b(this.a)));
    localObject = localUserService.uploadPhotoOne((String)localObject, "jpg", UploadShowPhotoFragment.c(this.a).getText(), UploadShowPhotoFragment.d(this.a).getText());
    if (ResponseCode.SUCCESS.getCode().equals(((UploadResp)localObject).resultCode)) {
      UploadShowPhotoFragment.a(this.a, localUserService.uploadPhotoTwo(str, "jpg", UploadShowPhotoFragment.c(this.a).getText(), UploadShowPhotoFragment.d(this.a).getText()));
    }
    for (;;)
    {
      System.gc();
      return;
      this.a.d();
      this.a.a(((UploadResp)localObject).resultMessage);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/authentication/fragment/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */