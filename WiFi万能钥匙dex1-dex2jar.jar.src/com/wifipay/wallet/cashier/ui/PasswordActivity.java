package com.wifipay.wallet.cashier.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.id;
import com.wifipay.R.string;
import com.wifipay.common.a.g;
import com.wifipay.common.eventbus.EventBus;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.common.eventbus.ThreadMode;
import com.wifipay.common.logging.Logger;
import com.wifipay.common.net.entitybase.BaseResp;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.cashier.PayListener;
import com.wifipay.wallet.paypassword.common.PreRetrievePP;
import com.wifipay.wallet.paypassword.common.PreRetrievePP.onListener;
import com.wifipay.wallet.paypassword.widget.WPSafeKeyboard;
import com.wifipay.wallet.paypassword.widget.WPSafeKeyboard.onPasswordChanged;
import com.wifipay.wallet.paypassword.widget.WPSixInputBox;
import com.wifipay.wallet.paypassword.widget.WPSixInputBox.onCompletedListener;
import com.wifipay.wallet.prod.core.model.PayCard;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.core.model.StartPayParams.ProductInfo;
import java.util.ArrayList;
import java.util.Iterator;

public class PasswordActivity
  extends BaseActivity
  implements View.OnClickListener, PayListener, PreRetrievePP.onListener, WPSafeKeyboard.onPasswordChanged, WPSixInputBox.onCompletedListener
{
  private boolean A = false;
  private int B = 0;
  private ArrayList<PayCard> C;
  private Animation.AnimationListener D = new b(this);
  private View h;
  private View i;
  private View j;
  private View k;
  private WPSafeKeyboard l;
  private WPSixInputBox m;
  private ImageView n;
  private ImageView o;
  private ImageView p;
  private TextView q;
  private TextView r;
  private TextView s;
  private TextView t;
  private TextView u;
  private TextView v;
  private String w;
  private StartPayParams x;
  private String y;
  private FrameLayout z;
  
  static
  {
    StubApp1053578832.interface11(111);
  }
  
  private void j()
  {
    this.h = findViewById(R.id.wifipay_password_cashier_root);
    this.i = findViewById(R.id.wifipay_password_cashier_container);
    this.k = findViewById(R.id.wifipay_password_card_container);
    this.j = findViewById(R.id.wifipay_password_card_info);
    this.v = ((TextView)findViewById(R.id.wifipay_card_item_info));
    this.o = ((ImageView)findViewById(R.id.wifipay_bank_logo));
    this.p = ((ImageView)findViewById(R.id.wifipay_card_item_arrow));
    this.l = ((WPSafeKeyboard)findViewById(R.id.wifipay_password_keyboard));
    this.m = ((WPSixInputBox)findViewById(R.id.wifpay_password_safe_input));
    this.z = ((FrameLayout)findViewById(R.id.wifipay_password_cashier_back));
    this.n = ((ImageView)findViewById(R.id.wifipay_password_cashier_close));
    this.q = ((TextView)findViewById(R.id.wifipay_password_product_name));
    this.r = ((TextView)findViewById(R.id.wifipay_password_product_amount));
    this.s = ((TextView)findViewById(R.id.wifipay_password_product_amount_old));
    this.t = ((TextView)findViewById(R.id.wifipay_password_product_amount_favourable));
    this.u = ((TextView)findViewById(R.id.wifipay_password_found));
    this.z.setOnClickListener(this);
    this.n.setOnClickListener(this);
    this.u.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.m.setListener(this);
    this.l.setListener(this);
    this.c.setAnimationListener(this.D);
    k();
  }
  
  private void k()
  {
    this.x = ((StartPayParams)getIntent().getSerializableExtra("pay_params"));
    this.w = this.x.type;
    if ((g.a(this.w, CashierType.TRANSFER.getType())) || (g.a(this.w, CashierType.WITHDRAW.getType())) || (g.a(this.w, CashierType.DEPOSIT.getType()))) {
      this.k.setVisibility(8);
    }
    for (;;)
    {
      i();
      return;
      this.k.setVisibility(0);
      this.C = this.x.cards;
      l();
    }
  }
  
  private void l()
  {
    int i1;
    int i2;
    label46:
    Object localObject2;
    if (com.wifipay.wallet.common.utils.d.a(this.x.productInfo.productAmount, com.wifipay.wallet.common.info.b.a().k()) > 0)
    {
      i1 = 1;
      if ((!com.wifipay.wallet.common.utils.f.a(this.C)) || (this.C.isEmpty())) {
        break label268;
      }
      i2 = 1;
      if (i2 == 0) {
        break label301;
      }
      if (i1 != 0)
      {
        localObject2 = this.C.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject1 = (PayCard)((Iterator)localObject2).next();
          if (((PayCard)localObject1).paymentType.equals("BALANCE"))
          {
            ((PayCard)localObject1).enabled = "N";
            ((PayCard)localObject1).isDefault = "N";
            ((PayCard)localObject1).seqNum = 99;
          }
        }
      }
      localObject1 = (PayCard)this.C.get(0);
      if ((i1 == 0) || (this.C.size() <= 1)) {
        break label298;
      }
      localObject1 = (PayCard)this.C.get(1);
      label156:
      Iterator localIterator = this.C.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject2 = (PayCard)localIterator.next();
          if (((PayCard)localObject2).isDefault())
          {
            label195:
            localObject1 = localObject2;
            if (((PayCard)localObject2).isEnable()) {
              break;
            }
          }
        }
      }
    }
    label268:
    label298:
    label301:
    for (Object localObject1 = null;; localObject1 = null)
    {
      if (com.wifipay.wallet.common.utils.f.b(localObject1))
      {
        this.p.setVisibility(8);
        this.j.setEnabled(false);
        localObject1 = PayCard.newCard(CashierType.CALLAPPPAY.getType());
      }
      for (;;)
      {
        this.x.chosenCard = ((PayCard)localObject1);
        com.wifipay.wallet.common.utils.d.a((PayCard)localObject1, this.o, this.v);
        return;
        i1 = 0;
        break;
        i2 = 0;
        break label46;
        this.p.setVisibility(0);
        this.j.setEnabled(true);
      }
      localObject2 = localObject1;
      break label195;
      break label156;
    }
  }
  
  private void m()
  {
    Intent localIntent = new Intent(this, SelectCardActivity.class);
    localIntent.putExtra("card_list", this.C);
    localIntent.putExtra("select_card_type", CashierType.CALLAPPPAY.getType());
    startActivity(localIntent);
  }
  
  private void n()
  {
    this.l.deletePassword(true);
  }
  
  private void o()
  {
    this.h.setVisibility(8);
    c("");
    com.wifipay.wallet.cashier.a.a locala = com.wifipay.wallet.cashier.a.a(this, this.x, this);
    if (com.wifipay.wallet.common.utils.f.a(locala)) {
      locala.a(this.y);
    }
    for (;;)
    {
      return;
      a("======");
    }
  }
  
  private void p()
  {
    new PreRetrievePP(this, this, this.w).a();
  }
  
  public void addPassword()
  {
    this.m.c();
  }
  
  public void afterCheck()
  {
    if (!this.w.equals(CashierType.CALLAPPPAY.getType())) {
      finish();
    }
  }
  
  public void deletePassword(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.m.b();
    }
    for (;;)
    {
      return;
      this.m.a();
    }
  }
  
  @Subscribe(threadMode=ThreadMode.MAIN)
  public void handlerRetrievePP(com.wifipay.wallet.a.e parame)
  {
    runOnUiThread(new e(this));
    this.l.a();
  }
  
  protected void i()
  {
    if (this.x.productInfo != null) {
      if (com.wifipay.wallet.common.utils.f.a(this.x.productInfo.productAccountName))
      {
        this.q.setText("向 " + this.x.productInfo.productAccountName + this.x.productInfo.productName);
        if ((g.a(this.x.productInfo.productAmountOld)) || (g.a(this.x.productInfo.productAmountFavourable))) {
          break label190;
        }
        this.s.setVisibility(8);
        this.t.setVisibility(8);
        this.r.setText("¥" + com.wifipay.wallet.common.utils.f.a(this.x.productInfo.productAmountOld));
        this.i.startAnimation(this.b);
      }
    }
    for (;;)
    {
      return;
      this.q.setText(this.x.productInfo.productName);
      break;
      label190:
      this.s.setVisibility(8);
      this.t.setVisibility(8);
      this.r.setText("¥" + com.wifipay.wallet.common.utils.f.a(this.x.productInfo.productAmount));
      this.i.startAnimation(this.b);
    }
  }
  
  public void invokeKeyboard()
  {
    this.l.d();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_password_card_info) {
      m();
    }
    if (paramView.getId() == R.id.wifipay_password_cashier_back)
    {
      this.B = 1;
      this.i.startAnimation(this.c);
    }
    if (paramView.getId() == R.id.wifipay_password_cashier_close)
    {
      this.B = 1;
      this.i.startAnimation(this.c);
    }
    if (paramView.getId() == R.id.wifipay_password_found) {
      p();
    }
  }
  
  public void onCompleted(boolean paramBoolean)
  {
    d();
    if (paramBoolean)
    {
      this.y = this.l.getPassword();
      this.B = 3;
      this.i.startAnimation(this.c);
    }
    for (;;)
    {
      return;
      b(com.wifipay.common.a.f.a(R.string.wifipay_pwd_crypto_error));
      runOnUiThread(new a(this));
    }
  }
  
  public void onCompletedAdd()
  {
    e();
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  @Subscribe
  public void onEventMainThread(com.wifipay.wallet.a.f paramf)
  {
    this.x.chosenCard = paramf.a;
    com.wifipay.wallet.common.utils.d.a(paramf.a, this.o, this.v);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = true;
    if (4 == paramInt)
    {
      bool1 = bool2;
      if (!this.A)
      {
        this.B = 1;
        this.i.startAnimation(this.c);
      }
    }
    for (boolean bool1 = bool2;; bool1 = super.onKeyDown(paramInt, paramKeyEvent)) {
      return bool1;
    }
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    k();
  }
  
  protected void onStart()
  {
    Logger.v("kyo == %s", new Object[] { " onStart == " + this.l });
    if (this.l != null) {}
    try
    {
      n();
      this.l.a();
      super.onStart();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void payFinish(int paramInt, BaseResp paramBaseResp)
  {
    EventBus.getDefault().postSticky(new com.wifipay.wallet.a.d(this.w, paramInt, paramBaseResp));
    finish();
  }
  
  public void rePay()
  {
    runOnUiThread(new d(this));
    this.h.setVisibility(0);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/ui/PasswordActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */