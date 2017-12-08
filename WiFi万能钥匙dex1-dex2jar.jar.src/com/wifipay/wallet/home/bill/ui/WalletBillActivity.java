package com.wifipay.wallet.home.bill.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.common.eventbus.Subscribe;
import com.wifipay.common.eventbus.ThreadMode;
import com.wifipay.framework.api.BackgroundExecutor;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.home.bill.net.dto.BillDetails;
import com.wifipay.wallet.home.bill.net.dto.BillDetails.Bills;
import com.wifipay.wallet.home.bill.se.emilsjolander.stickylistheaders.LoadMoreListener;
import com.wifipay.wallet.home.bill.se.emilsjolander.stickylistheaders.StickyListHeadersListView;
import com.wifipay.wallet.home.bill.se.emilsjolander.stickylistheaders.StickyListHeadersListView.OnStickyHeaderChangedListener;
import com.wifipay.wallet.home.bill.se.emilsjolander.stickylistheaders.StickyListHeadersListView.OnStickyHeaderOffsetChangedListener;
import com.wifipay.wallet.home.bill.se.emilsjolander.stickylistheaders.views.OnRefreshListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WalletBillActivity
  extends BaseActivity
  implements AdapterView.OnItemClickListener, LoadMoreListener, StickyListHeadersListView.OnStickyHeaderChangedListener, StickyListHeadersListView.OnStickyHeaderOffsetChangedListener, OnRefreshListener
{
  protected StickyListHeadersListView h;
  public com.wifipay.wallet.home.bill.a.a i;
  private boolean j = true;
  private int k;
  private List<BillDetails.Bills> l;
  private String m;
  
  static
  {
    StubApp1053578832.interface11(118);
  }
  
  private void a(BillDetails.Bills paramBills)
  {
    Intent localIntent = new Intent(this, WalletBillDetailActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("bill_detail", paramBills);
    localIntent.putExtras(localBundle);
    localIntent.putExtra("wallet_bill", "1");
    startActivity(localIntent);
  }
  
  private void l()
  {
    this.i = new com.wifipay.wallet.home.bill.a.a(this);
  }
  
  private void m()
  {
    this.h.setOnItemClickListener(this);
    this.h.setOnStickyHeaderChangedListener(this);
    this.h.setOnStickyHeaderOffsetChangedListener(this);
    this.h.setFooterView(getLayoutInflater().inflate(R.layout.wifipay_home_bill_main_footer, null));
    this.h.setEmptyView(findViewById(R.id.wifipay_home_bill_no_trade_layout));
    this.h.setDrawingListUnderStickyHeader(true);
    this.h.setAreHeadersSticky(true);
    this.h.setAdapter(this.i);
    this.h.setLoadMoreListener(this);
    this.h.setOnRefreshListener(this);
  }
  
  protected void a(BillDetails paramBillDetails)
  {
    this.h.a();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramBillDetails != null)
    {
      localObject1 = localObject2;
      if (paramBillDetails.resultObject != null)
      {
        int i1 = paramBillDetails.resultObject.size();
        localObject1 = new ArrayList(i1);
        for (int n = 0; n < i1; n++) {
          ((List)localObject1).add((BillDetails.Bills)paramBillDetails.resultObject.get(n));
        }
      }
    }
    com.wifipay.wallet.home.bill.b.a.a(this).a((List)localObject1, this.m);
    j();
    d();
  }
  
  protected void a(List<BillDetails.Bills> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      if ((this.k == 0) || (this.l == null)) {
        this.l = new ArrayList();
      }
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        BillDetails.Bills localBills = (BillDetails.Bills)localIterator.next();
        this.l.add(localBills);
      }
      this.k += 1;
      this.i.a(this.l);
    }
    boolean bool = false;
    if ((paramList == null) || (paramList.size() < 20)) {
      bool = true;
    }
    this.h.a(bool);
    k();
  }
  
  @Subscribe(threadMode=ThreadMode.MAIN)
  public void handleHomeInfo(BillDetails paramBillDetails)
  {
    a(paramBillDetails);
  }
  
  protected void i()
  {
    m();
    c("");
    com.wifipay.wallet.home.bill.b.a.a(this).a();
    com.wifipay.wallet.home.bill.b.a.a(this).e();
    com.wifipay.wallet.home.bill.b.a.a(this).b();
    com.wifipay.wallet.home.bill.b.a.a(this).c();
    com.wifipay.wallet.home.bill.b.a.a(this).d();
    com.wifipay.wallet.home.bill.b.a.a(this).c("reductionAmount");
    com.wifipay.wallet.home.bill.b.a.a(this).c("feeAmount");
    com.wifipay.wallet.home.bill.b.a.a(this).c("isOncentActivity");
    com.wifipay.wallet.home.bill.b.a.a(this).c("oncentCardNo");
    com.wifipay.wallet.home.bill.b.a.a(this).c("oncentPasswd");
    j();
  }
  
  protected void j()
  {
    BackgroundExecutor.a(new a(this));
  }
  
  protected void k()
  {
    BackgroundExecutor.a(new c(this));
  }
  
  public void loadingMore()
  {
    j();
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if ((this.l != null) && (paramInt > 0) && (this.l.size() > paramInt - 1)) {
      a((BillDetails.Bills)this.l.get(paramInt - 1));
    }
  }
  
  public void onRefresh()
  {
    this.j = true;
    k();
  }
  
  public void onStickyHeaderChanged(StickyListHeadersListView paramStickyListHeadersListView, View paramView, int paramInt, long paramLong)
  {
    paramView.setAlpha(1.0F);
  }
  
  public void onStickyHeaderOffsetChanged(StickyListHeadersListView paramStickyListHeadersListView, View paramView, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 11) {
      paramView.setAlpha(1.0F - paramInt / paramView.getMeasuredHeight());
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/bill/ui/WalletBillActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */