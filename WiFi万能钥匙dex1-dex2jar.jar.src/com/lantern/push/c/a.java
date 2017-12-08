package com.lantern.push.c;

import android.content.ContentResolver;
import android.content.Context;
import android.os.AsyncTask;
import java.util.ArrayList;
import java.util.List;

public final class a
  extends AsyncTask<String, Integer, Integer>
{
  private ContentResolver a;
  private com.bluefay.b.a b;
  private List<com.lantern.push.b.a> c;
  
  public a(Context paramContext, com.bluefay.b.a parama)
  {
    this.a = paramContext.getContentResolver();
    this.b = parama;
    this.c = new ArrayList();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/push/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */