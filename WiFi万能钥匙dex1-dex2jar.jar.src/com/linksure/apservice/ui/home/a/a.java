package com.linksure.apservice.ui.home.a;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import com.linksure.apservice.ui.views.integration.d;
import java.util.ArrayList;

public final class a
{
  private int a = 4;
  private int b = 7;
  private int c;
  private int d;
  private String[] e;
  private Context f;
  
  public a(Context paramContext)
  {
    this.f = paramContext;
  }
  
  private static ArrayList<View> a(b[] paramArrayOfb)
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfb.length);
    int j = paramArrayOfb.length;
    for (int i = 0; i < j; i++) {
      localArrayList.add(paramArrayOfb[i].a());
    }
    return localArrayList;
  }
  
  public final PagerAdapter a()
  {
    this.d = (this.a * this.b - 1);
    this.c = (this.e.length / this.d);
    if (this.e.length % this.d != 0) {
      this.c += 1;
    }
    b[] arrayOfb = new b[this.c];
    int i = 0;
    if (i < this.c)
    {
      arrayOfb[i] = new b(this.f);
      b localb = arrayOfb[i];
      int j = i * this.d;
      String[] arrayOfString;
      if (this.d + j > this.e.length)
      {
        arrayOfString = new String[this.e.length - j];
        System.arraycopy(this.e, j, arrayOfString, 0, arrayOfString.length);
      }
      for (;;)
      {
        localb.a(arrayOfString, this.a, this.b);
        i++;
        break;
        arrayOfString = new String[this.d];
        System.arraycopy(this.e, j, arrayOfString, 0, arrayOfString.length);
      }
    }
    return new d(a(arrayOfb));
  }
  
  public final a a(String[] paramArrayOfString)
  {
    this.e = paramArrayOfString;
    return this;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/home/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */