package cm.pass.sdk.net.a;

import a.a.a.c.b;
import android.content.Context;
import android.text.TextUtils;
import cm.pass.sdk.interfaces.e;
import cm.pass.sdk.utils.h;
import cm.pass.sdk.utils.j;
import cm.pass.sdk.utils.o;
import cm.pass.sdk.utils.t;
import org.json.JSONObject;

public class c
  extends i
{
  protected String a = "IReceiverGetKs";
  private b.a.a.a b;
  private Context h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private String o;
  private String p;
  private e q;
  private String r;
  private String s = "";
  private String t = "";
  
  public c(Context paramContext, String paramString, e parame)
  {
    this.q = parame;
    this.h = paramContext;
    this.r = paramString;
  }
  
  private String b()
  {
    String str1 = null;
    String str3 = t.b(this.h);
    String str2 = t.a(this.h);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.i).append(str3).append(this.m).append(str2);
    if (this.l.equals("1")) {
      str1 = h.a(localStringBuilder.toString());
    }
    for (;;)
    {
      return str1;
      if (this.l.equals("2")) {
        str1 = h.b(localStringBuilder.toString());
      }
    }
  }
  
  private void b(b paramb)
  {
    this.p = this.j;
    this.o = b();
    paramb = this.j + "@@" + this.k + "@@" + this.i;
    if (TextUtils.isEmpty(this.p)) {
      this.p = this.i;
    }
    this.b = cm.pass.sdk.account.a.a(this.h).a(this.p, paramb, this.o, this.n, this.i, "", this.r);
    o.a().a(this.h, "KEY_MOBILEKEY", "");
    o.a().a(this.h, "key_securityphone", "");
    if (this.b == null) {
      a("保存中间件失败", "810");
    }
    a();
  }
  
  void a()
  {
    if (this.q != null) {
      this.q.a(this.c, this.d, this.e, this.b, this.s, this.t);
    }
  }
  
  public void a(b paramb)
  {
    super.a(paramb);
    try
    {
      if (this.g.has("serviceid")) {
        this.s = this.g.optString("serviceid");
      }
      if (this.g.has("servertime")) {
        this.t = this.g.optString("servertime");
      }
      if (this.c)
      {
        this.i = this.g.getString("passid");
        this.j = this.g.getString("mobilenumber");
        this.k = this.g.getString("emailaddress");
        this.l = this.g.getString("hashtype");
        this.m = this.g.getString("nonce");
        this.n = this.g.getString("expiretime");
        b(paramb);
        return;
      }
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        paramb.printStackTrace();
        a();
      }
    }
  }
  
  void a(String paramString1, String paramString2)
  {
    j.c(this.a, paramString1);
    this.c = false;
    this.d = paramString2;
    this.e = paramString1;
    this.b = null;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */