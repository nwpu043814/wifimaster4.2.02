package com.lantern.mailbox.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import com.lantern.core.imageloader.b;
import java.util.List;

final class c
  implements b
{
  c(a parama, ImageView paramImageView1, List paramList, Bitmap paramBitmap, int paramInt, com.lantern.mailbox.d.a parama1, ImageView paramImageView2) {}
  
  public final void a()
  {
    Bitmap localBitmap = ((BitmapDrawable)this.a.getDrawable()).getBitmap();
    this.b.add(Bitmap.createScaledBitmap(localBitmap, this.c.getWidth(), this.c.getHeight(), true));
    if (this.b.size() == this.d) {
      a.a(this.e, this.f, this.b);
    }
  }
  
  public final void b()
  {
    this.b.add(this.c);
    if (this.b.size() == this.d) {
      a.a(this.e, this.f, this.b);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/mailbox/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */