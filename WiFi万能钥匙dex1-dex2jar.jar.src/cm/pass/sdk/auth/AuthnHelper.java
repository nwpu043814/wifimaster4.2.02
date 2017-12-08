package cm.pass.sdk.auth;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import cm.pass.sdk.account.UserInfo;
import cm.pass.sdk.interfaces.c;
import cm.pass.sdk.interfaces.h;
import cm.pass.sdk.utils.RequestBusiness;
import cm.pass.sdk.utils.d;
import cm.pass.sdk.utils.e;
import cm.pass.sdk.utils.i;
import cm.pass.sdk.utils.j;
import cm.pass.sdk.utils.m;
import cm.pass.sdk.utils.o;
import cm.pass.sdk.utils.r;
import cm.pass.sdk.utils.s;
import cm.pass.sdk.utils.t;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class AuthnHelper
{
  public static final int UMC_LOGIN_DISPLAY = 1;
  public static final int UMC_LOGIN_IMPLICIT = 2;
  public static final int UMC_LOGIN_OAUTH = 4;
  private static Handler b;
  private static AuthnHelper c = null;
  private static Context d;
  public boolean a;
  private int e;
  private Map<Integer, TokenListener> f = new Hashtable();
  private boolean g = false;
  private Runnable h = new AuthnHelper.2(this);
  
  private AuthnHelper(Context paramContext)
  {
    j.d("umcsdk", "umcsdk_outer_v1.5.0");
    d = paramContext.getApplicationContext();
    b = new Handler();
    i.a(paramContext);
    cm.pass.sdk.b.b.a();
    paramContext = new AuthnHelper.1(this);
    if (System.currentTimeMillis() - o.a().c(d, "KEY_CONFIG_INFO_TIME") > 604800000L) {
      i = 1;
    }
    if (i != 0)
    {
      j.c("AuthnHelper", "开始获取超时时间");
      RequestBusiness.getInstance(d).getLoginConfig(d, "", paramContext);
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.f.get(Integer.valueOf(paramInt)) != null) {
      ((TokenListener)this.f.get(Integer.valueOf(paramInt))).onGetTokenComplete(a.a(paramString1, "", "", "", paramString2, "", ""));
    }
  }
  
  private void a(String paramString1, String paramString2, TokenListener paramTokenListener, int paramInt)
  {
    j.e("AuthnHelper", "implicitLogin() appid:" + paramString1 + " appkey:" + paramString2);
    String str5 = t.c();
    int i = r.b(d);
    String str1 = t.c(d);
    if (str1.equals("-1")) {
      a("102101", "网络连接异常", paramInt);
    }
    AuthnHelper.4 local4;
    String str3;
    String str4;
    for (;;)
    {
      return;
      this.g = false;
      paramTokenListener = new AuthnHelper.3(this, paramInt);
      local4 = new AuthnHelper.4(this, paramTokenListener, str1, str5, paramString1, paramString2, i);
      str3 = m.a(d).b();
      str4 = m.a(d).a();
      paramInt = 8000;
      if (!TextUtils.isEmpty(str4)) {
        break;
      }
      paramTokenListener.a(false, "102122", "未检测到SIM卡，请使用短信验证码登录", "", "", "", "", "", "", "", "", "", str1);
    }
    String str2 = r.d(d);
    if (str2.equals("1")) {
      paramInt = o.a().b(d, "LOGINDELAY_CM_TIME", 8000);
    }
    for (;;)
    {
      j.c("AuthnHelper", "当前超时时间:" + paramInt);
      b.postDelayed(this.h, paramInt * 1000);
      verifyClientId(paramString1, "", str3, str4, new AuthnHelper.5(this, paramTokenListener, str1, paramString1, paramString2, str5, local4));
      break;
      if (str2.equals("3")) {
        paramInt = o.a().b(d, "LOGINDELAY_CT_TIME", 8000);
      } else if (str2.equals("2")) {
        paramInt = o.a().b(d, "LOGINDELAY_CU_TIME", 8000);
      }
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, c paramc)
  {
    Object localObject = cm.pass.sdk.account.a.a(d).c();
    localObject = cm.pass.sdk.account.a.a(d).a((b.a.a.a)localObject);
    if (localObject == null)
    {
      j.a("AuthnHelper", "中间件不存在");
      paramc.a(false, "102206", "中间件不存在", "", "", "", "", "", "", "", "", "", "");
    }
    for (;;)
    {
      return;
      RequestBusiness.getInstance(d).getAccessTokenByUserInfo(paramString1, paramString2, "2", paramString3, (UserInfo)localObject, paramc);
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt, cm.pass.sdk.interfaces.b paramb)
  {
    new d().a(d, paramString1, paramString3, paramString2, paramString4, paramInt, paramb);
  }
  
  public static AuthnHelper getInstance(Context paramContext)
  {
    if (c == null) {}
    try
    {
      if (c == null)
      {
        AuthnHelper localAuthnHelper = new cm/pass/sdk/auth/AuthnHelper;
        localAuthnHelper.<init>(paramContext);
        c = localAuthnHelper;
      }
      return c;
    }
    finally {}
  }
  
  public static void setTest(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 1;; i = 3)
    {
      e.a(i);
      return;
    }
  }
  
  public boolean checkHasLegalAccounts()
  {
    String str = m.a(d).a();
    ArrayList localArrayList = (ArrayList)RequestBusiness.getInstance(d).getAllAccounts();
    int i;
    if ((localArrayList != null) && (localArrayList.size() > 0))
    {
      int j = localArrayList.size();
      i = 0;
      if (i < j) {
        if (!str.equals(((UserInfo)localArrayList.get(i)).getImsi())) {}
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        cm.pass.sdk.account.a.a(d).b();
      }
      return bool;
      i++;
      break;
    }
  }
  
  public TokenListener getTokenListener(int paramInt)
  {
    return (TokenListener)this.f.get(Integer.valueOf(paramInt));
  }
  
  public void isEnableDataWiFiLogin(boolean paramBoolean)
  {
    e.a = paramBoolean;
  }
  
  public void logOut()
  {
    cm.pass.sdk.account.a.a(d).b();
  }
  
  public void logOut(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return;
      cm.pass.sdk.account.a.a(d).a(paramString);
    }
  }
  
  public void setTestModel(int paramInt)
  {
    e.a(paramInt);
  }
  
  public void silentVerifyMobile(String paramString1, String paramString2, String paramString3, TokenListener paramTokenListener)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      a("102", "appid/appkey 不能为空", 0);
    }
    for (;;)
    {
      return;
      if (!t.c(paramString3))
      {
        paramTokenListener.onGetTokenComplete(a.a("102", "请输入正确的手机号码！", null));
      }
      else
      {
        AuthnHelper.6 local6 = new AuthnHelper.6(this, paramTokenListener);
        String str = t.c(d);
        int i = r.b(d);
        if (str.equals("-1"))
        {
          paramTokenListener.onGetTokenComplete(a.a("102101", "", "", "", "网络连接异常", "", ""));
        }
        else if ((str.equals("3")) || (i == 2))
        {
          s.a().b(d);
          a(paramString1, paramString2, paramString3, "3", 3, local6);
        }
        else
        {
          paramTokenListener.onGetTokenComplete(a.a("102122", "", "", "", "本机号码非移动号码不能使用", "", ""));
        }
      }
    }
  }
  
  public void umcLoginByType(String paramString1, String paramString2, int paramInt, TokenListener paramTokenListener)
  {
    j.e("AuthnHelper", "UMCLoginByType : " + paramInt + "\t appId : " + paramString1 + "\t LoginType : " + paramInt);
    s.a().b(d);
    this.e = paramInt;
    this.f.put(Integer.valueOf(paramInt), paramTokenListener);
    b.removeCallbacks(this.h);
    if (TextUtils.isEmpty(paramString1)) {
      a("102", "appid不能为空", paramInt);
    }
    for (;;)
    {
      return;
      if (TextUtils.isEmpty(paramString2)) {
        a("102", "appkey不能为空", paramInt);
      } else {
        switch (paramInt)
        {
        default: 
          a("102", "登录类型不存在，请检查loginType参数", paramInt);
          break;
        case 2: 
          j.e("AuthnHelper", "implicit login");
          a(paramString1, paramString2, paramTokenListener, paramInt);
        }
      }
    }
  }
  
  public void verifyClientId(String paramString1, String paramString2, String paramString3, String paramString4, h paramh)
  {
    if (TextUtils.isEmpty(paramString3))
    {
      j.a("AuthnHelper", "IMEI 为空");
      paramh.a(false, "102", "IMEI 不能为空", "", "", false);
    }
    for (;;)
    {
      return;
      if ((TextUtils.isEmpty(paramString2)) && (TextUtils.isEmpty(paramString4)))
      {
        if (TextUtils.isEmpty(paramString4)) {
          j.a("AuthnHelper", "IMSI 为空");
        }
        paramh.a(false, "102", "IMSI/ACCOUNT 不能为空", "", "", false);
      }
      else
      {
        new d().a(paramString1, paramString2, paramString3, paramString4, paramh);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/auth/AuthnHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */