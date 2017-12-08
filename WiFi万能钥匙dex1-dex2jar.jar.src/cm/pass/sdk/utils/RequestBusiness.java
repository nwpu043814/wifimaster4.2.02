package cm.pass.sdk.utils;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import cm.pass.sdk.account.UserInfo;
import cm.pass.sdk.auth.AuthnHelper;
import cm.pass.sdk.auth.TokenListener;
import cm.pass.sdk.b.b;
import cm.pass.sdk.interfaces.c;
import cm.pass.sdk.interfaces.e;
import cm.pass.sdk.interfaces.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class RequestBusiness
{
  private static final String TAG = "BusinessInternal";
  private static ArrayList<Activity> mActivitySet = null;
  private static RequestBusiness mInstalce = null;
  private List<b.a.a.a> accounts;
  private WeakReference<Context> mContext;
  private boolean mIsChecked;
  
  private RequestBusiness(Context paramContext)
  {
    this.mContext = new WeakReference(paramContext);
    mActivitySet = new ArrayList();
  }
  
  public static RequestBusiness getInstance(Context paramContext)
  {
    try
    {
      if (mInstalce == null) {
        syncInit(paramContext);
      }
      b.a();
      paramContext = mInstalce;
      return paramContext;
    }
    finally {}
  }
  
  private static void syncInit(Context paramContext)
  {
    try
    {
      RequestBusiness localRequestBusiness = new cm/pass/sdk/utils/RequestBusiness;
      localRequestBusiness.<init>(paramContext);
      mInstalce = localRequestBusiness;
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void getAccessTokenByUserInfo(String paramString1, String paramString2, String paramString3, String paramString4, UserInfo paramUserInfo, c paramc)
  {
    if ((paramUserInfo == null) || (TextUtils.isEmpty(paramUserInfo.getAuthToken()))) {
      paramc.a(false, "102", "userinfo is null ", "", "", "", "", "", "", "", "", "", "");
    }
    for (;;)
    {
      return;
      if (this.mContext.get() != null)
      {
        String str6 = System.currentTimeMillis();
        String str1 = m.a((Context)this.mContext.get()).a();
        String str5 = m.a((Context)this.mContext.get()).b();
        String str3 = l.a((Context)this.mContext.get()).c();
        String str4 = l.a((Context)this.mContext.get()).f();
        int i = r.b((Context)this.mContext.get());
        String str2 = q.a((Context)this.mContext.get());
        paramString4 = new RequestBusiness.3(this, paramString1, paramString2, i, str5, str1, str3, str4, new RequestBusiness.2(this, paramc, paramUserInfo, paramString4, paramString3, paramString1, str6), paramc, paramString4, paramString3, paramUserInfo, str6);
        new d().a((Context)this.mContext.get(), paramUserInfo.getPassid(), paramUserInfo.getAuthToken(), paramString3, paramString1, paramString2, paramUserInfo.getTokenNonce(), paramUserInfo.getTimeStamp(), str1, str2, str3, str4, paramString4);
      }
    }
  }
  
  public List<UserInfo> getAllAccounts()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.mContext.get() != null)
    {
      this.accounts = cm.pass.sdk.account.a.a((Context)this.mContext.get()).a();
      if ((this.accounts != null) && (this.accounts.size() > 0))
      {
        Iterator localIterator = this.accounts.iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (b.a.a.a)localIterator.next();
          localObject = cm.pass.sdk.account.a.a((Context)this.mContext.get()).a((b.a.a.a)localObject);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void getKsByAccessToken(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, e parame)
  {
    if (this.mContext.get() != null)
    {
      paramString3 = new RequestBusiness.1(this, paramString3, paramString4, paramString5, paramString6, paramString2);
      new d().a((Context)this.mContext.get(), paramString1, paramString2, paramString5, paramString3);
    }
  }
  
  public void getLoginConfig(Context paramContext, String paramString, i parami)
  {
    j.c("BusinessInternal", "getLoginConfig");
    if (this.mContext.get() != null) {
      new d().a(paramContext, paramString, parami);
    }
  }
  
  public void implicitSMSLogin(String paramString1, String paramString2, String paramString3, int paramInt, c paramc)
  {
    if (this.mContext.get() != null)
    {
      if (l.a((Context)this.mContext.get()).c("android.permission.SEND_SMS")) {
        break label64;
      }
      paramc.a(false, "102205", "应用未授权，请检查发送短信权限【android.permission.SEND_SMS】", "", "", "", "", "", "", "", "", "", "4");
    }
    for (;;)
    {
      return;
      label64:
      String str3 = System.currentTimeMillis();
      String str1 = m.a((Context)this.mContext.get()).a();
      String str2 = t.a();
      sendSms();
      paramString1 = new RequestBusiness.7(this, paramString2, paramString3, paramInt, new RequestBusiness.6(this, paramString2, paramc, paramString1, str3));
      new d().a((Context)this.mContext.get(), paramString2, "2", str1, str2, "", "", paramString1);
    }
  }
  
  public void implicitWapLogin(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean, c paramc)
  {
    String str2 = System.currentTimeMillis();
    String str1 = t.a();
    paramString1 = new RequestBusiness.5(this, paramString2, paramString3, paramInt, new RequestBusiness.4(this, paramc, paramString2, paramString1, str2), paramString1, paramc, str2);
    if (this.mContext.get() != null) {
      new d().a((Context)this.mContext.get(), paramString2, "1", "", str1, "", "", paramString1);
    }
  }
  
  public void onCallbackTokenListener(JSONObject paramJSONObject, int paramInt)
  {
    if ((this.mContext.get() != null) && (AuthnHelper.getInstance((Context)this.mContext.get()).getTokenListener(paramInt) != null)) {
      AuthnHelper.getInstance((Context)this.mContext.get()).getTokenListener(paramInt).onGetTokenComplete(paramJSONObject);
    }
  }
  
  public void sendSms()
  {
    if (this.mContext.get() != null) {
      new d().a((Context)this.mContext.get());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/utils/RequestBusiness.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */