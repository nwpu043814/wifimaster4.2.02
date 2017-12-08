package cm.pass.sdk.net.a;

import a.a.a.c.b;
import org.json.JSONObject;

public class g
  extends i
{
  private cm.pass.sdk.interfaces.g a;
  
  public g(cm.pass.sdk.interfaces.g paramg)
  {
    this.a = paramg;
  }
  
  public void a(b paramb)
  {
    super.a(paramb);
    Object localObject1 = "";
    Object localObject2 = "";
    Object localObject6 = "";
    paramb = (b)localObject1;
    Object localObject4 = localObject1;
    Object localObject5 = localObject2;
    Object localObject3 = localObject6;
    try
    {
      if (this.g.has("serviceid"))
      {
        localObject4 = localObject1;
        localObject5 = localObject2;
        localObject3 = localObject6;
        paramb = this.g.optString("serviceid");
      }
      localObject1 = localObject2;
      localObject4 = paramb;
      localObject5 = localObject2;
      localObject3 = localObject6;
      if (this.g.has("servertime"))
      {
        localObject4 = paramb;
        localObject5 = localObject2;
        localObject3 = localObject6;
        localObject1 = this.g.optString("servertime");
      }
      localObject2 = localObject6;
      localObject4 = paramb;
      localObject5 = localObject1;
      localObject3 = localObject6;
      if (this.g.has("successauthtype"))
      {
        localObject4 = paramb;
        localObject5 = localObject1;
        localObject3 = localObject6;
        localObject2 = this.g.optString("successauthtype");
      }
      localObject4 = paramb;
      localObject5 = localObject1;
      localObject3 = localObject2;
      localObject6 = paramb;
      localObject7 = localObject1;
      localObject8 = localObject2;
      if (this.c)
      {
        localObject4 = paramb;
        localObject5 = localObject1;
        localObject3 = localObject2;
        localObject6 = this.g.optString("publickey");
        localObject4 = paramb;
        localObject5 = localObject1;
        localObject3 = localObject2;
        localObject8 = this.g.optString("keytoken");
        localObject4 = paramb;
        localObject5 = localObject1;
        localObject3 = localObject2;
        localObject7 = this.g.optString("account");
        localObject4 = paramb;
        localObject5 = localObject1;
        localObject3 = localObject2;
        this.a.a(this.c, this.d, this.e, (String)localObject6, (String)localObject8, (String)localObject7, paramb, (String)localObject1, (String)localObject2);
        return;
      }
    }
    catch (Exception paramb)
    {
      for (;;)
      {
        paramb.printStackTrace();
        Object localObject8 = localObject3;
        Object localObject7 = localObject5;
        localObject6 = localObject4;
        this.a.a(false, this.d, this.e, "", "", "", (String)localObject6, (String)localObject7, (String)localObject8);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/cm/pass/sdk/net/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */