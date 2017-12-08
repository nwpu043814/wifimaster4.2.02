package com.wifipay.wallet.cashier.b;

import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import com.wifipay.R.string;
import com.wifipay.common.a.f;
import com.wifipay.common.a.g;
import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.framework.app.ui.SuperActivity;
import com.wifipay.wallet.cashier.PayListener;
import com.wifipay.wallet.cashier.ui.NewCardPayActivity;
import com.wifipay.wallet.cashier.ui.PasswordSingleVerifyActivity;
import com.wifipay.wallet.common.info.AppInfo;
import com.wifipay.wallet.paypassword.common.PreRetrievePP;
import com.wifipay.wallet.prod.core.model.PayCard;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import java.util.HashMap;

public class q
  extends a
{
  private String d = null;
  
  public q(SuperActivity paramSuperActivity, PayListener paramPayListener)
  {
    super(paramSuperActivity, paramPayListener);
  }
  
  protected void a(int paramInt, String paramString)
  {
    Object localObject3 = null;
    super.a(paramInt, paramString);
    this.b.d();
    if (this.a == 2) {
      new PreRetrievePP(this.b, null).a(this.b.getResources().getString(R.string.wifipay_found_pwd_title));
    }
    for (;;)
    {
      return;
      if (!this.c.chosenCard.getType().equals("NEW_CARD"))
      {
        boolean bool = "BALANCE".equals(this.c.chosenCard.getType());
        if (bool)
        {
          localObject1 = null;
          label94:
          if (!bool) {
            break label183;
          }
          localObject2 = this.c.chosenCard.paymentType;
          label110:
          if (!bool) {
            break label190;
          }
          paramString = (String)localObject3;
        }
        for (;;)
        {
          this.c.additionalParams.put("agreementNo", localObject1);
          this.c.additionalParams.put("paymentType", localObject2);
          this.c.additionalParams.put("mobile", paramString);
          h();
          break;
          localObject1 = this.c.chosenCard.agreementNo;
          break label94;
          label183:
          localObject2 = "BANK_CARD";
          break label110;
          label190:
          if (g.a(this.c.chosenCard.mobile) == true) {
            paramString = this.c.chosenCard.instMobile;
          } else {
            paramString = this.c.chosenCard.mobile;
          }
        }
      }
      paramString = this.b.getString(R.string.wifipay_new_card_title, new Object[] { f.a(R.string.wifipay_transfer_title) });
      Object localObject2 = new Intent();
      Object localObject1 = new ComponentName(this.b.getPackageName(), NewCardPayActivity.class.getName());
      this.c.additionalParams.put("paymentType", "BANK_CARD");
      ((Intent)localObject2).setComponent((ComponentName)localObject1);
      ((Intent)localObject2).putExtra("pay_params", this.c);
      ((Intent)localObject2).putExtra("title", paramString);
      AppInfo.INSTANCE.setNextIntent((Intent)localObject2);
      localObject1 = new Intent(this.b, PasswordSingleVerifyActivity.class);
      ((Intent)localObject1).putExtra("save_ped", true);
      ((Intent)localObject1).putExtra("title", paramString);
      this.b.startActivity((Intent)localObject1);
    }
  }
  
  public void d()
  {
    c();
    this.b.c("");
    BackgroundExecutor.a(new r(this));
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/b/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */