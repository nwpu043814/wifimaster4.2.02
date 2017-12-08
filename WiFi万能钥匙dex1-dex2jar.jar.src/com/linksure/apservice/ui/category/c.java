package com.linksure.apservice.ui.category;

import android.os.Message;
import com.bluefay.d.b;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

final class c
  extends b
{
  c(CategoryFragment paramCategoryFragment, int[] paramArrayOfInt)
  {
    super(paramArrayOfInt);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    String str2;
    String str1;
    if (CategoryFragment.a(this.a))
    {
      str2 = (String)paramMessage.obj;
      str1 = "";
      j = -1;
      paramMessage = str1;
    }
    try
    {
      localObject = new org/json/JSONObject;
      paramMessage = str1;
      ((JSONObject)localObject).<init>(str2);
      paramMessage = str1;
      str1 = ((JSONObject)localObject).optString("apsId");
      paramMessage = str1;
      i = ((JSONObject)localObject).optInt("stat");
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        int i = j;
        Message localMessage = paramMessage;
        continue;
        boolean bool = false;
      }
    }
    paramMessage = CategoryFragment.b(this.a).a().iterator();
    while (paramMessage.hasNext())
    {
      localObject = (com.linksure.apservice.b.c)paramMessage.next();
      if (str1.equals(((com.linksure.apservice.b.c)localObject).a))
      {
        if (i != 1) {
          break label151;
        }
        bool = true;
        ((com.linksure.apservice.b.c)localObject).g = bool;
        CategoryFragment.b(this.a).notifyDataSetChanged();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/category/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */