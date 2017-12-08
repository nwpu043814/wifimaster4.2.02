package com.wifipay.wallet.home.bill.se.emilsjolander.stickylistheaders;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;

public abstract interface StickyListHeadersAdapter
  extends ListAdapter
{
  public abstract long getHeaderId(int paramInt);
  
  public abstract View getHeaderView(int paramInt, View paramView, ViewGroup paramViewGroup);
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/bill/se/emilsjolander/stickylistheaders/StickyListHeadersAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */