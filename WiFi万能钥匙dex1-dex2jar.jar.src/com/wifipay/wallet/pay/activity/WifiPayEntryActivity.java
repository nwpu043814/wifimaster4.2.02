package com.wifipay.wallet.pay.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.analysis.analytics.ALInterface;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.a.g;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.common.logging.Logger;
import com.wifipay.common.net.entitybase.BaseResp;
import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.WalletApi;
import com.wifipay.wallet.cashier.CashierType;
import com.wifipay.wallet.cashier.PayListener;
import com.wifipay.wallet.cashier.PayStatus;
import com.wifipay.wallet.common.info.DeviceInfo;
import com.wifipay.wallet.common.info.UserInfo;
import com.wifipay.wallet.common.rpc.ResponseCode;
import com.wifipay.wallet.common.rpc.RpcService;
import com.wifipay.wallet.home.net.dto.HomeCztInfoResp;
import com.wifipay.wallet.home.net.dto.HomeCztInfoResp.ResultObject;
import com.wifipay.wallet.openapi.ActionType;
import com.wifipay.wallet.openapi.WalletParams;
import com.wifipay.wallet.pay.SPayResp;
import com.wifipay.wallet.pay.SyncResp;
import com.wifipay.wallet.prod.core.model.StartPayParams;
import com.wifipay.wallet.prod.core.model.StartPayParams.ProductInfo;
import com.wifipay.wallet.prod.core.model.WalletCard;
import com.wifipay.wallet.prod.pay.NewResultResp;
import com.wifipay.wallet.prod.pay.NewResultResp.ResultObject;
import com.wifipay.wallet.prod.pay.WifiPayReq;
import com.wifipay.wallet.prod.paypassword.PPService;
import com.wifipay.wallet.prod.paypassword.QueryDigitPwdResp;
import com.wifipay.wallet.prod.security.account.AccountManagerService;
import com.wifipay.wallet.prod.security.account.dto.CheckTokenResp;
import com.wifipay.wallet.prod.security.account.dto.CheckTokenResp.ResultObject;
import com.wifipay.wallet.prod.security.account.dto.QueryRNInfoResp;
import com.wifipay.wallet.prod.security.account.dto.QueryRNInfoResp.ResultObject;
import com.wifipay.wallet.prod.security.query.QueryPaymentResp;
import com.wifipay.wallet.prod.security.query.QueryPaymentResp.ResultObject;
import com.wifipay.wallet.prod.security.query.QueryService;
import com.wifipay.wallet.prod.security.query.WalletBalanceResp;
import com.wifipay.wallet.prod.user.ThirdLoginResp;
import com.wifipay.wallet.prod.user.ThirdLoginResp.ResultObject;
import com.wifipay.wallet.prod.user.UserService;
import com.wifipay.wallet.wifiactivity.activity.WifiActivityOrderUI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WifiPayEntryActivity
  extends BaseActivity
  implements Handler.Callback, PayListener
{
  private boolean A;
  private com.wifipay.framework.api.d h = new com.wifipay.framework.api.d(this);
  private StartPayParams i;
  private com.wifipay.wallet.cashier.b.a j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private String q;
  private String r;
  private String s;
  private String t;
  private String u;
  private String v;
  private String w;
  private String x;
  private int y = 0;
  private SPayResp z = new SPayResp();
  
  static
  {
    StubApp1053578832.interface11(127);
  }
  
  private String a(CheckTokenResp paramCheckTokenResp)
  {
    if (ResponseCode.SUCCESS.getCode().equals(paramCheckTokenResp.resultCode))
    {
      UserInfo localUserInfo = com.wifipay.wallet.common.info.b.a().c();
      localUserInfo.setAutoLogin(true);
      localUserInfo.setOperatorId(paramCheckTokenResp.resultObject.operatorId);
      localUserInfo.setLoginName(paramCheckTokenResp.resultObject.loginName);
      localUserInfo.setMemberId(paramCheckTokenResp.resultObject.memberId);
      this.n = paramCheckTokenResp.resultObject.memberId;
    }
    for (;;)
    {
      return paramCheckTokenResp.resultCode;
      if (ResponseCode.TOKEN_INVALID.getCode().equals(paramCheckTokenResp.resultCode)) {
        this.h.a(1);
      }
    }
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(com.wifipay.wallet.common.info.b.a().u())) {
      BackgroundExecutor.a(new b(this, paramString1, paramString2));
    }
    for (;;)
    {
      return;
      b(paramString1, paramString2);
    }
  }
  
  private boolean a(HomeCztInfoResp paramHomeCztInfoResp)
  {
    if (ResponseCode.SUCCESS.getCode().equals(paramHomeCztInfoResp.resultCode))
    {
      UserInfo localUserInfo = com.wifipay.wallet.common.info.b.a().c();
      b(paramHomeCztInfoResp);
      if ((!g.a(paramHomeCztInfoResp.resultObject.trueName)) && (!g.a(paramHomeCztInfoResp.resultObject.certNo)))
      {
        localUserInfo.setTrueName(paramHomeCztInfoResp.resultObject.trueName);
        localUserInfo.setCertNo(paramHomeCztInfoResp.resultObject.certNo);
      }
      if (!g.a(paramHomeCztInfoResp.resultObject.availableBalance)) {
        localUserInfo.setRemainMoney(paramHomeCztInfoResp.resultObject.availableBalance);
      }
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean a(QueryDigitPwdResp paramQueryDigitPwdResp)
  {
    String str = paramQueryDigitPwdResp.resultCode;
    int i1 = -1;
    if (ResponseCode.ACCOUNT_NOT_EXISTS.getCode().equals(str)) {
      i1 = 1;
    }
    for (;;)
    {
      if (i1 == 4) {
        this.x = paramQueryDigitPwdResp.resultMessage;
      }
      com.wifipay.wallet.common.info.b.a().c().setWalletState(i1);
      return true;
      if (ResponseCode.NO_DIGIT_PWD.getCode().equals(str)) {
        i1 = 2;
      } else if (ResponseCode.SUCCESS.getCode().equals(str)) {
        i1 = 3;
      } else if ((ResponseCode.ACCOUNT_FREEZE_REALNAME.getCode().equals(str)) || (ResponseCode.ACCOUNT_FREEZE_NOT_REALNAME.getCode().equals(str))) {
        i1 = 4;
      }
    }
  }
  
  private boolean a(QueryRNInfoResp paramQueryRNInfoResp)
  {
    if ((ResponseCode.SUCCESS.getCode().equals(paramQueryRNInfoResp.resultCode)) && (paramQueryRNInfoResp.resultObject != null))
    {
      UserInfo localUserInfo = com.wifipay.wallet.common.info.b.a().c();
      localUserInfo.setTrueName(paramQueryRNInfoResp.resultObject.trueName);
      localUserInfo.setCertNo(paramQueryRNInfoResp.resultObject.certNo);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean a(QueryPaymentResp paramQueryPaymentResp)
  {
    if (ResponseCode.SUCCESS.getCode().equals(paramQueryPaymentResp.resultCode)) {
      this.i.cards = paramQueryPaymentResp.resultObject.items;
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean a(WalletBalanceResp paramWalletBalanceResp)
  {
    if (ResponseCode.SUCCESS.getCode().equals(paramWalletBalanceResp.resultCode))
    {
      UserInfo localUserInfo = com.wifipay.wallet.common.info.b.a().c();
      localUserInfo.setAvailableBalance(paramWalletBalanceResp.resultObject.availableBalance);
      localUserInfo.setFrozenBalance(paramWalletBalanceResp.resultObject.frozenBalance);
    }
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private void b(HomeCztInfoResp paramHomeCztInfoResp)
  {
    int i1;
    if (g.a(paramHomeCztInfoResp.resultObject.isSetDigitPwd, "Y")) {
      i1 = 3;
    }
    for (;;)
    {
      if (i1 == 4) {
        this.x = paramHomeCztInfoResp.resultMessage;
      }
      com.wifipay.wallet.common.info.b.a().c().setWalletState(i1);
      return;
      if (g.a(paramHomeCztInfoResp.resultObject.isSetDigitPwd, "N")) {
        i1 = 2;
      } else {
        i1 = 4;
      }
    }
  }
  
  private void b(String paramString1, String paramString2)
  {
    ((UserService)RpcService.getBgRpcProxy(UserService.class)).thirdLogin(paramString1, paramString2);
  }
  
  private void e(int paramInt)
  {
    QueryService localQueryService = null;
    AccountManagerService localAccountManagerService = (AccountManagerService)RpcService.getRpcProxy(AccountManagerService.class);
    Object localObject;
    if (paramInt == 0)
    {
      paramInt = 1;
      localObject = a(localAccountManagerService.checkToken(this.m, String.valueOf(System.currentTimeMillis())));
      if (!ResponseCode.TOKEN_INVALID.getCode().equals(localObject)) {
        break label63;
      }
    }
    label63:
    boolean bool1;
    for (;;)
    {
      return;
      paramInt = 0;
      break;
      bool2 = ResponseCode.SUCCESS.getCode().equals(localObject);
      localObject = localQueryService;
      if (bool2)
      {
        localObject = localQueryService;
        if (this.A)
        {
          localObject = localQueryService;
          if (paramInt != 0)
          {
            localObject = localAccountManagerService.queryRealName(String.valueOf(System.currentTimeMillis()));
            if (com.wifipay.wallet.common.utils.f.b(((QueryRNInfoResp)localObject).resultObject))
            {
              q();
              continue;
            }
          }
        }
      }
      bool1 = bool2;
      if (bool2) {
        bool1 = a(((PPService)RpcService.getRpcProxy(PPService.class)).queryDigitPwd(String.valueOf(System.currentTimeMillis())));
      }
      if ((paramInt != 0) && (com.wifipay.wallet.common.info.b.a().j() == 2))
      {
        this.h.a(0);
      }
      else
      {
        if ((paramInt == 0) || (com.wifipay.wallet.common.info.b.a().j() != 4)) {
          break label217;
        }
        g(this.x);
      }
    }
    label217:
    localQueryService = (QueryService)RpcService.getRpcProxy(QueryService.class);
    boolean bool2 = bool1;
    if (paramInt != 0)
    {
      bool2 = bool1;
      if (bool1) {
        bool2 = a(localQueryService.queryPaymentByBiz("100000", "DEFAULT_PAY", ""));
      }
    }
    if (bool2) {
      if (com.wifipay.wallet.common.utils.f.b(localObject)) {
        bool1 = a(localAccountManagerService.queryRealName(String.valueOf(System.currentTimeMillis())));
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (bool1) {
        bool2 = a(localQueryService.queryWalletBalance(String.valueOf(System.currentTimeMillis())));
      }
      if (paramInt != 0)
      {
        if (!bool2)
        {
          d();
          o();
          finish();
          break;
          bool1 = a((QueryRNInfoResp)localObject);
          continue;
        }
        this.h.a(0);
        break;
      }
      this.h.a(2);
      break;
      bool1 = bool2;
    }
  }
  
  private void e(String paramString)
  {
    a(paramString);
    n();
    finish();
  }
  
  private void f(String paramString)
  {
    a(paramString, com.wifipay.common.a.f.a(R.string.wifipay_alert_btn_i_know), new d(this));
  }
  
  private void g(String paramString)
  {
    a(paramString, com.wifipay.common.a.f.a(R.string.wifipay_alert_btn_i_know), new e(this));
  }
  
  private void i()
  {
    setContentView(R.layout.wifipay_activity_stub_entry);
  }
  
  private void j()
  {
    AccountManagerService localAccountManagerService = (AccountManagerService)RpcService.getRpcProxy(AccountManagerService.class);
    String str = a(localAccountManagerService.checkToken(this.m, String.valueOf(System.currentTimeMillis())));
    if (ResponseCode.TOKEN_INVALID.getCode().equals(str)) {}
    for (;;)
    {
      return;
      if (ResponseCode.SUCCESS.getCode().equals(str)) {
        a(localAccountManagerService.queryHomeCztInfo());
      }
      this.h.a(2);
    }
  }
  
  private void k()
  {
    d();
    this.i.productInfo = new StartPayParams.ProductInfo();
    this.i.productInfo.productName = this.q;
    this.i.productInfo.productAmount = this.k;
    this.i.productInfo.productAmountOld = this.u;
    this.i.productInfo.productAmountFavourable = this.v;
    this.i.additionalParams.put("orderName", this.q);
    this.i.additionalParams.put("amount", this.k);
    this.i.additionalParams.put("memberId", this.n);
    this.i.additionalParams.put("merchantName", this.w);
    this.i.additionalParams.put("loginName", this.o);
    this.i.additionalParams.put("merchantOrderNo", this.r);
    this.i.additionalParams.put("merchantNo", this.p);
    this.i.additionalParams.put("notifyUrl", this.l);
    this.i.type = CashierType.CALLAPPPAY.getType();
    if (com.wifipay.wallet.common.utils.f.b(this.j)) {
      this.j = com.wifipay.wallet.cashier.a.a(CashierType.CALLAPPPAY.getType(), this, this);
    }
    this.j.a(this.i);
    this.j.d();
  }
  
  private void l()
  {
    Object localObject = getIntent().getExtras();
    this.y = ((Bundle)localObject).getInt("enter_type");
    e();
    Logger.v("zhongjiaji == %s", new Object[] { Integer.valueOf(this.y) });
    WifiPayReq localWifiPayReq;
    if (this.y == 0)
    {
      i();
      localWifiPayReq = new WifiPayReq();
      localWifiPayReq.fromBundle((Bundle)localObject);
      this.k = localWifiPayReq.orderAmount;
      this.q = localWifiPayReq.goodsName;
      this.p = localWifiPayReq.merchantNo;
      this.w = localWifiPayReq.merchantName;
      this.r = localWifiPayReq.merchantOrderNo;
      this.u = localWifiPayReq.orderAmountOld;
      this.v = localWifiPayReq.orderAmountFavourable;
      this.l = localWifiPayReq.notifyUrl;
      this.A = localWifiPayReq.isActivity;
      boolean bool = localWifiPayReq.isLogin;
      localObject = com.wifipay.wallet.common.info.b.a().c();
      if (!g.a(this.p)) {
        ((UserInfo)localObject).setMerchantNo(this.p);
      }
      if (this.A)
      {
        try
        {
          localObject = new java/util/HashMap;
          ((HashMap)localObject).<init>();
          if ((!g.a(this.p)) && (!g.a(this.r))) {
            ((Map)localObject).put("activityMerchantNo", this.p);
          }
          ((Map)localObject).put("activityMerchantOrderNo", this.r);
          ((Map)localObject).put("eventTime", com.wifipay.wallet.common.utils.d.a(System.currentTimeMillis()));
          com.wifipay.wallet.common.utils.a.a(this, "activityMerchant", (Map)localObject);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
          }
        }
        if (!bool) {
          p();
        }
      }
    }
    for (;;)
    {
      return;
      this.m = com.wifipay.wallet.common.info.b.a().g();
      if (TextUtils.isEmpty(this.m)) {
        com.wifipay.wallet.wifilogin.a.a.a(new WalletParams(localWifiPayReq.wifi_token, localWifiPayReq.uhId));
      }
      if (com.wifipay.wallet.common.info.b.a().n())
      {
        BackgroundExecutor.a(new a(this));
      }
      else
      {
        m();
        continue;
        if (this.y == 2)
        {
          r();
        }
        else
        {
          this.s = getIntent().getStringExtra("nativeParam");
          this.t = getIntent().getStringExtra("intent_action");
          m();
        }
      }
    }
  }
  
  private void m()
  {
    String str2 = com.wifipay.wallet.common.info.b.a().l();
    String str1 = com.wifipay.wallet.common.info.b.a().m();
    Logger.v("zhao == %s", new Object[] { "outToken" + str2 });
    Logger.v("zhao == %s", new Object[] { "outToken" + str2 });
    if ((g.a(str2)) || (g.a(str1))) {
      g();
    }
    for (;;)
    {
      return;
      a(str2, str1);
    }
  }
  
  private void n()
  {
    this.z.resultCode = "-3";
    if (this.A) {
      this.z.pay_source = 1;
    }
    SyncResp.a(this.z);
    SyncResp.b();
  }
  
  private void o()
  {
    this.z.resultCode = "-2";
    if (this.A) {
      this.z.pay_source = 1;
    }
    SyncResp.a(this.z);
    SyncResp.b();
  }
  
  private void p()
  {
    if (TextUtils.isEmpty(com.wifipay.wallet.common.info.b.a().u())) {
      BackgroundExecutor.a(new f(this));
    }
    for (;;)
    {
      return;
      q();
    }
  }
  
  private void q()
  {
    d();
    this.i.productInfo = new StartPayParams.ProductInfo();
    this.i.productInfo.productName = this.q;
    this.i.productInfo.productAmount = this.k;
    this.i.productInfo.productAmountOld = this.u;
    this.i.productInfo.productAmountFavourable = this.v;
    this.i.additionalParams.put("orderName", this.q);
    this.i.additionalParams.put("amount", this.k);
    this.i.additionalParams.put("memberId", this.n);
    this.i.additionalParams.put("loginName", this.o);
    this.i.additionalParams.put("merchantOrderNo", this.r);
    this.i.additionalParams.put("merchantNo", this.p);
    this.i.additionalParams.put("notifyUrl", this.l);
    this.i.additionalParams.put("imei", DeviceInfo.INSTANCE.getIMEI());
    this.i.additionalParams.put("clientIp", DeviceInfo.INSTANCE.getMacAddress());
    Intent localIntent = new Intent(this, WifiActivityOrderUI.class);
    localIntent.putExtra("pay_params", this.i);
    startActivity(localIntent);
    finish();
  }
  
  private void r()
  {
    Object localObject = (WalletParams)getIntent().getExtras().getSerializable("wifiParam");
    this.t = getIntent().getStringExtra("intent_action");
    String str = com.wifipay.wallet.common.info.b.a().g();
    Logger.v("mCztAction == %s", new Object[] { this.t });
    Logger.v("accessToken == %s", new Object[] { str });
    if (TextUtils.isEmpty(str))
    {
      com.wifipay.wallet.wifilogin.a.a.a((WalletParams)localObject);
      str = com.wifipay.wallet.common.info.b.a().c().getOutToken();
      localObject = com.wifipay.wallet.common.info.b.a().c().getUhId();
      if (((g.a(str)) || (g.a((CharSequence)localObject))) && ((g.a(this.t, ActionType.DEPOSIT.getAction())) || (g.a(this.t, ActionType.TRANSFER.getAction())) || (g.a(this.t, ActionType.WITHDRAW.getAction()))))
      {
        com.wifipay.common.a.a.a(this, "wifiPersonal", "null", this.t);
        g();
      }
    }
    for (;;)
    {
      return;
      s();
    }
  }
  
  private void s()
  {
    Logger.v("enterHomeCZT 2 == %s", new Object[] { this.t });
    if (!g.a(this.t))
    {
      Intent localIntent = new Intent(this.t);
      localIntent.putExtra("nativeParam", this.s);
      startActivity(localIntent);
    }
    finish();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      com.wifipay.wallet.wifilogin.a.a.a();
      g();
    }
    for (;;)
    {
      return true;
      if (paramMessage.what == 2)
      {
        if ((this.y == 1) || (this.y == 0)) {
          d();
        }
        s();
      }
      else
      {
        k();
      }
    }
  }
  
  @Subscribe
  public void handlerFinishSubscribe(com.wifipay.wallet.paypassword.widget.a parama)
  {
    Logger.v("zhao == %s", new Object[] { "handlerFinishSubscribe" });
    n();
    finish();
  }
  
  public void handlerNullSubscribe(com.wifipay.framework.a.a parama)
  {
    super.handlerNullSubscribe(parama);
    Logger.v("zhao == %s", new Object[] { "handlerNullSubscribe" });
    n();
    finish();
  }
  
  @Subscribe
  public void handlerThirdLogin(ThirdLoginResp paramThirdLoginResp)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("thirdLoginResposeCode", paramThirdLoginResp.resultCode);
    localHashMap.put("thirdLoginResposeMessage", paramThirdLoginResp.resultMessage);
    if (paramThirdLoginResp.resultObject != null)
    {
      localHashMap.put("thirdLoginResposeName", paramThirdLoginResp.resultObject.loginName);
      localHashMap.put("thirdLoginResposeMemberId", paramThirdLoginResp.resultObject.memberId);
      ALInterface.onSignIn(this, paramThirdLoginResp.resultObject.loginName);
    }
    com.wifipay.wallet.common.utils.a.a(this, "thirdLoginRespose", localHashMap);
    if ((paramThirdLoginResp != null) && (paramThirdLoginResp.resultCode.equals(ResponseCode.SUCCESS.getCode()))) {
      if (paramThirdLoginResp.resultObject != null)
      {
        com.wifipay.wallet.common.info.b.a().c().setAccessToken(paramThirdLoginResp.resultObject.thirdToken);
        com.wifipay.wallet.common.info.b.a().c().setLoginName(paramThirdLoginResp.resultObject.loginName);
        com.wifipay.wallet.common.info.b.a().c().setMemberId(paramThirdLoginResp.resultObject.memberId);
        this.m = paramThirdLoginResp.resultObject.thirdToken;
        this.n = paramThirdLoginResp.resultObject.memberId;
        this.o = paramThirdLoginResp.resultObject.loginName;
        BackgroundExecutor.a(new c(this));
      }
    }
    for (;;)
    {
      return;
      if ((paramThirdLoginResp != null) && (ResponseCode.TOKEN_INVALID.getCode().equals(paramThirdLoginResp.resultCode))) {
        this.h.a(1);
      } else if ((paramThirdLoginResp != null) && (ResponseCode.VERSION_INVALID.getCode().equals(paramThirdLoginResp.resultCode))) {
        f(paramThirdLoginResp.resultMessage);
      } else {
        e(paramThirdLoginResp.resultMessage);
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    String str1;
    String str2;
    if ((paramInt2 == -1) && (paramInt1 == 10201))
    {
      str1 = paramIntent.getStringExtra("uhid");
      str2 = paramIntent.getStringExtra("userToken");
      Logger.v("zhongjiaji uhid  =%s", new Object[] { str1 });
      Logger.v("zhongjiaji userToken = %s", new Object[] { str2 });
      UserInfo localUserInfo = com.wifipay.wallet.common.info.b.a().c();
      localUserInfo.setOutToken(str2);
      localUserInfo.setUhId(str1);
      if ((g.a(this.t, ActionType.DEPOSIT.getAction())) || (g.a(this.t, ActionType.TRANSFER.getAction())) || (g.a(this.t, ActionType.WITHDRAW.getAction()))) {
        s();
      }
    }
    for (;;)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
      a(str2, str1);
      continue;
      n();
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    WalletApi.init(this);
    a(8);
    this.i = new StartPayParams();
    this.i.additionalParams = new HashMap();
    this.i.cards = new ArrayList();
    l();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (com.wifipay.wallet.common.utils.f.a(this.j))
    {
      this.j.b();
      this.j = null;
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (4 == paramInt) {}
    for (boolean bool = true;; bool = super.onKeyDown(paramInt, paramKeyEvent)) {
      return bool;
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (com.wifipay.wallet.common.utils.f.a(this.j)) {
      this.j.a();
    }
  }
  
  public void payFinish(int paramInt, BaseResp paramBaseResp)
  {
    NewResultResp localNewResultResp;
    if (com.wifipay.wallet.common.utils.f.a(paramBaseResp))
    {
      localNewResultResp = (NewResultResp)paramBaseResp;
      if (ResponseCode.SUCCESS.getCode().equals(paramBaseResp.resultCode))
      {
        Logger.v("zhao == %s ", new Object[] { "成功支付 isActivity = " + this.A });
        if (this.A)
        {
          paramBaseResp = new SPayResp();
          paramBaseResp.resultCode = "0";
          paramBaseResp.merchantOrederNo = localNewResultResp.resultObject.merchantOrderNo;
          paramBaseResp.telNo = localNewResultResp.resultObject.mobileNo;
          paramBaseResp.pay_source = 1;
          SyncResp.a(paramBaseResp);
          SyncResp.b();
          finish();
        }
      }
    }
    for (;;)
    {
      return;
      paramBaseResp = new Intent(this, PayResultActivity.class);
      paramInt = PayStatus.findStatus(localNewResultResp.resultObject.payStatus);
      paramBaseResp.putExtra("goodsInfo", this.q);
      paramBaseResp.putExtra("tradeAmount", this.k);
      paramBaseResp.putExtra("merchantName", this.w);
      paramBaseResp.putExtra("tradeTime", localNewResultResp.resultObject.payTime);
      paramBaseResp.putExtra("bankName", localNewResultResp.resultObject.bankName);
      paramBaseResp.putExtra("cardNo", localNewResultResp.resultObject.cardNo);
      paramBaseResp.putExtra("orderId", localNewResultResp.resultObject.orderId);
      paramBaseResp.putExtra("merchantOrderNo", this.r);
      paramBaseResp.putExtra("mOrderAmountOld", this.u);
      paramBaseResp.putExtra("mOrderAmountFavourable", this.v);
      if (paramInt == PayStatus.PAY_SUCCESS.getStatus()) {
        paramBaseResp.putExtra("which_fragment", R.id.wifipay_fragment_success);
      }
      for (;;)
      {
        startActivity(paramBaseResp);
        finish();
        break;
        if (paramInt == PayStatus.PAYING.getStatus()) {
          paramBaseResp.putExtra("which_fragment", R.id.wifipay_fragment_default);
        } else {
          paramBaseResp.putExtra("which_fragment", R.id.wifipay_fragment_fail);
        }
      }
      Logger.v("zhao == %s ", new Object[] { "失败支付" });
      a(paramBaseResp.resultMessage);
      o();
      finish();
      continue;
      Logger.v("zhao == %s ", new Object[] { "取消支付" });
      n();
      finish();
    }
  }
  
  public void rePay() {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/pay/activity/WifiPayEntryActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */