package com.linksure.apservice.integration.photochoose.crop;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class a
{
  private Intent a = new Intent();
  
  public a(Uri paramUri)
  {
    this.a.setData(paramUri);
  }
  
  public final a a()
  {
    this.a.putExtra("max_width", 256);
    return this;
  }
  
  public final a a(Uri paramUri)
  {
    this.a.putExtra("output", paramUri);
    return this;
  }
  
  public final void a(Context paramContext, Fragment paramFragment)
  {
    this.a.setClass(paramContext, b.class);
    paramFragment.startActivityForResult(this.a, 6709);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/integration/photochoose/crop/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */