package com.linksure.apservice.ui.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.linksure.apservice.a.a;
import com.linksure.apservice.a.g;
import com.linksure.apservice.ui.home.ApServiceActivity;
import com.linksure.apservice.ui.profile.ProfileActivity;
import com.qihoo.util.StubApp1053578832;
import org.json.JSONObject;

public class RouterActivity
  extends Activity
{
  private g a;
  private a b;
  private String c = "";
  
  static
  {
    StubApp1053578832.interface11(76);
  }
  
  private static String a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("stat", 1);
      localJSONObject.put("apsId", paramString);
      return localJSONObject.toString();
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
  }
  
  final void a()
  {
    Intent localIntent = new Intent(this, ProfileActivity.class);
    localIntent.putExtra("id", this.c);
    startActivity(localIntent);
    finish();
  }
  
  final void b()
  {
    Intent localIntent = new Intent(this, ApServiceActivity.class);
    localIntent.putExtra("aps_id", this.c);
    startActivity(localIntent);
    finish();
  }
  
  protected native void onCreate(Bundle paramBundle);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/common/RouterActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */