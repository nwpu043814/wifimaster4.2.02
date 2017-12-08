package com.lantern.notifaction.o2o;

import android.app.Activity;
import android.os.Bundle;
import com.lantern.core.g;
import com.qihoo.util.StubApp1053578832;
import java.util.HashMap;

public class O2OServiceActivity
  extends Activity
{
  static
  {
    StubApp1053578832.interface11(33);
  }
  
  private static String a(int paramInt)
  {
    HashMap localHashMap = a.b();
    localHashMap.put("serviceType", String.valueOf(paramInt));
    localHashMap.put("sign", g.a(localHashMap, "werr#$%adfssf@ss"));
    return a.a(localHashMap);
  }
  
  protected native void onCreate(Bundle paramBundle);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/notifaction/o2o/O2OServiceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */