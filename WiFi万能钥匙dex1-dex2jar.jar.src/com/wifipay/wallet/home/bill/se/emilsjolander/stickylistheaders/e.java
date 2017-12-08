package com.wifipay.wallet.home.bill.se.emilsjolander.stickylistheaders;

import android.content.Context;
import android.widget.SectionIndexer;

class e
  extends a
  implements SectionIndexer
{
  SectionIndexer b;
  
  e(Context paramContext, StickyListHeadersAdapter paramStickyListHeadersAdapter)
  {
    super(paramContext, paramStickyListHeadersAdapter);
    this.b = ((SectionIndexer)paramStickyListHeadersAdapter);
  }
  
  public int getPositionForSection(int paramInt)
  {
    return this.b.getPositionForSection(paramInt);
  }
  
  public int getSectionForPosition(int paramInt)
  {
    return this.b.getSectionForPosition(paramInt);
  }
  
  public Object[] getSections()
  {
    return this.b.getSections();
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/bill/se/emilsjolander/stickylistheaders/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */