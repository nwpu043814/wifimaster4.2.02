package com.wifipay.wallet.home.net.dto;

import com.wifipay.common.net.entitybase.BaseResp;
import com.wifipay.wallet.home.bean.Banner;
import com.wifipay.wallet.home.bean.SubApp;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeInfoResp
  extends BaseResp
  implements Serializable
{
  public ResultObject resultObject;
  
  public Banner parseBanner(JSONObject paramJSONObject)
  {
    Banner localBanner = new Banner();
    try
    {
      if (paramJSONObject.has("id")) {
        localBanner.id = paramJSONObject.getString("id");
      }
      if (paramJSONObject.has("src")) {
        localBanner.src = paramJSONObject.getString("src");
      }
      if (paramJSONObject.has("order")) {
        localBanner.order = paramJSONObject.getString("order");
      }
      if (paramJSONObject.has("link")) {
        localBanner.link = paramJSONObject.getString("link");
      }
    }
    catch (JSONException paramJSONObject)
    {
      for (;;)
      {
        paramJSONObject.printStackTrace();
      }
    }
    return localBanner;
  }
  
  public void parseBody(JSONObject paramJSONObject)
  {
    int j = 0;
    try
    {
      if (paramJSONObject.has("resultObject"))
      {
        Object localObject = new com/wifipay/wallet/home/net/dto/HomeInfoResp$ResultObject;
        ((ResultObject)localObject).<init>();
        this.resultObject = ((ResultObject)localObject);
        localObject = paramJSONObject.getJSONObject("resultObject");
        if (((JSONObject)localObject).has("appId")) {
          this.resultObject.appId = ((JSONObject)localObject).getString("appId");
        }
        if (((JSONObject)localObject).has("appName")) {
          this.resultObject.appName = ((JSONObject)localObject).getString("appName");
        }
        if (((JSONObject)localObject).has("version")) {
          this.resultObject.version = ((JSONObject)localObject).getString("version");
        }
        if (((JSONObject)localObject).has("versionName")) {
          this.resultObject.versionName = ((JSONObject)localObject).getString("versionName");
        }
        if (((JSONObject)localObject).has("status")) {
          this.resultObject.status = ((JSONObject)localObject).getString("status");
        }
        if (((JSONObject)localObject).has("forceUpdate")) {
          this.resultObject.forceUpdate = ((JSONObject)localObject).getString("forceUpdate");
        }
        if (((JSONObject)localObject).has("changeLog")) {
          this.resultObject.changeLog = ((JSONObject)localObject).getString("changeLog");
        }
        ArrayList localArrayList;
        int i;
        if (((JSONObject)localObject).has("banners"))
        {
          paramJSONObject = ((JSONObject)localObject).getJSONArray("banners");
          ResultObject localResultObject = this.resultObject;
          localArrayList = new java/util/ArrayList;
          localArrayList.<init>();
          localResultObject.banners = localArrayList;
          for (i = 0; i < paramJSONObject.length(); i++) {
            this.resultObject.banners.add(parseBanner(paramJSONObject.getJSONObject(i)));
          }
        }
        if (((JSONObject)localObject).has("subApps"))
        {
          localObject = ((JSONObject)localObject).getJSONArray("subApps");
          paramJSONObject = this.resultObject;
          localArrayList = new java/util/ArrayList;
          localArrayList.<init>();
          paramJSONObject.subapps = localArrayList;
          for (i = j; i < ((JSONArray)localObject).length(); i++) {
            this.resultObject.subapps.add(parseSubapp(((JSONArray)localObject).getJSONObject(i)));
          }
        }
      }
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public SubApp parseSubapp(JSONObject paramJSONObject)
  {
    SubApp localSubApp = new SubApp();
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("id")) {
          localSubApp.id = paramJSONObject.getString("id");
        }
        if (paramJSONObject.has("name")) {
          localSubApp.name = paramJSONObject.getString("name");
        }
        if (paramJSONObject.has("icon")) {
          localSubApp.icon = paramJSONObject.getString("icon");
        }
        if (paramJSONObject.has("order")) {
          localSubApp.order = paramJSONObject.getString("order");
        }
        if (paramJSONObject.has("tag")) {
          localSubApp.tag = paramJSONObject.getString("tag");
        }
        if (paramJSONObject.has("type")) {
          localSubApp.type = paramJSONObject.getString("type");
        }
        if (paramJSONObject.has("link")) {
          localSubApp.link = paramJSONObject.getString("link");
        }
        if (paramJSONObject.has("version")) {
          localSubApp.version = paramJSONObject.getString("version");
        }
        if (paramJSONObject.has("status")) {
          localSubApp.status = paramJSONObject.getString("status");
        }
        if (paramJSONObject.has("downloadUrl")) {
          localSubApp.downloadUrl = paramJSONObject.getString("downloadUrl");
        }
        boolean bool = paramJSONObject.has("h5Param");
        if (!bool) {}
      }
      catch (JSONException paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        continue;
      }
      try
      {
        localSubApp.h5Param = paramJSONObject.getString("h5Param");
        if (localSubApp.h5Param.contains("h5Type"))
        {
          JSONObject localJSONObject = new org/json/JSONObject;
          localJSONObject.<init>(localSubApp.h5Param);
          if (localJSONObject.has("h5Type")) {
            localSubApp.h5Type = localJSONObject.getString("h5Type");
          }
        }
        if (paramJSONObject.has("nativeParam")) {
          localSubApp.nativeParam = paramJSONObject.getString("nativeParam");
        }
        if (paramJSONObject.has("isInnerApp")) {
          localSubApp.isInnerApp = paramJSONObject.getString("isInnerApp");
        }
        if (paramJSONObject.has("isNeedLogin")) {
          localSubApp.isNeedLogin = paramJSONObject.getString("isNeedLogin");
        }
        if (paramJSONObject.has("subTitle")) {
          localSubApp.subTitle = paramJSONObject.getString("subTitle");
        }
        return localSubApp;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
  
  public static class ResultObject
    implements Serializable
  {
    public String appId;
    public String appName;
    public ArrayList<Banner> banners;
    public String changeLog;
    public String forceUpdate;
    public String status;
    public ArrayList<SubApp> subapps;
    public String version;
    public String versionName;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/net/dto/HomeInfoResp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */