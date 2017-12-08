package com.wifipay.framework.app.ui;

import com.wifipay.framework.service.ITitleBarListener;

class g
  implements ITitleBarListener
{
  g(SuperActivity paramSuperActivity) {}
  
  public boolean onTitleClick(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1 = false;
    if (this.a.f() != -1) {
      bool1 = this.a.c(this.a.f()).onTitleClick(paramInt);
    }
    if (!bool1) {
      if (paramInt == 1)
      {
        bool1 = this.a.a();
        if (bool1) {
          break label77;
        }
        this.a.onBackPressed();
        bool1 = bool2;
      }
    }
    label77:
    for (;;)
    {
      return bool1;
      bool1 = this.a.b();
      continue;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/framework/app/ui/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */