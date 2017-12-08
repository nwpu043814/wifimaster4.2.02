package com.lantern.favorite.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.bluefay.b.h;
import com.lantern.core.favorite.WkSceneFavorite;
import com.lantern.favorite.a;
import com.qihoo.util.StubApp1053578832;
import java.lang.reflect.Field;
import org.json.JSONObject;

public class FavoriteRequest
  extends Activity
{
  private a a;
  
  static
  {
    StubApp1053578832.interface11(19);
  }
  
  private static WkSceneFavorite a(Intent paramIntent)
  {
    int i = 0;
    paramIntent = paramIntent.getStringExtra("data");
    h.a("json=" + paramIntent, new Object[0]);
    JSONObject localJSONObject = new JSONObject(paramIntent);
    WkSceneFavorite localWkSceneFavorite = (WkSceneFavorite)WkSceneFavorite.class.newInstance();
    Field[] arrayOfField = WkSceneFavorite.class.getDeclaredFields();
    int j = arrayOfField.length;
    if (i < j)
    {
      Field localField = arrayOfField[i];
      localField.setAccessible(true);
      paramIntent = localField.getType().getName();
      if (paramIntent.contains("String")) {
        if (localJSONObject.has(localField.getName())) {
          localField.set(localWkSceneFavorite, localJSONObject.getString(localField.getName()));
        }
      }
      for (;;)
      {
        i++;
        break;
        if (paramIntent.contains("int"))
        {
          if (localJSONObject.has(localField.getName())) {
            localField.set(localWkSceneFavorite, Integer.valueOf(localJSONObject.getInt(localField.getName())));
          }
        }
        else if ((paramIntent.contains("long")) && (localJSONObject.has(localField.getName()))) {
          localField.set(localWkSceneFavorite, Long.valueOf(localJSONObject.getLong(localField.getName())));
        }
      }
    }
    return localWkSceneFavorite;
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onDestroy()
  {
    if (this.a != null) {
      this.a.c();
    }
    super.onDestroy();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/favorite/ui/FavoriteRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */