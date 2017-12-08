package com.wifipay.wallet.cashier.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qihoo.util.StubApp1053578832;
import com.wifipay.R.drawable;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.common.eventbus.EventBus;
import com.wifipay.framework.widget.WPImageView;
import com.wifipay.wallet.BaseActivity;
import com.wifipay.wallet.common.utils.d;
import com.wifipay.wallet.home.widget.image.SmartImageView;
import com.wifipay.wallet.prod.core.model.PayCard;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class SelectCardActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ArrayList<PayCard> h = new ArrayList();
  private b i;
  private int j;
  private int k = -1;
  
  static
  {
    StubApp1053578832.interface11(114);
  }
  
  private void a(List<PayCard> paramList)
  {
    int i2;
    int n;
    Object localObject1;
    int i1;
    int m;
    if ((com.wifipay.wallet.common.utils.f.a(paramList)) && (paramList.size() > 1))
    {
      Collections.sort(paramList, new a(null));
      i2 = paramList.size();
      ListIterator localListIterator2 = paramList.listIterator();
      ListIterator localListIterator1 = paramList.listIterator(i2);
      n = 0;
      Object localObject2 = null;
      localObject1 = null;
      i1 = i2;
      m = 0;
      if ((localObject1 != null) && (!((PayCard)localObject1).isEnable())) {
        break label253;
      }
      m = localListIterator2.nextIndex();
      localObject1 = (PayCard)localListIterator2.next();
      label102:
      if ((localObject2 != null) && (((PayCard)localObject2).isEnable())) {
        break label250;
      }
      i1 = localListIterator1.previousIndex();
      localObject2 = (PayCard)localListIterator1.previous();
      label136:
      if ((((PayCard)localObject1).isEnable()) || (!((PayCard)localObject2).isEnable())) {
        break label259;
      }
      localListIterator2.set(localObject2);
      localListIterator1.set(localObject1);
      Object localObject3 = localObject1;
      localObject1 = localObject2;
      n = 1;
      localObject2 = localObject3;
    }
    label247:
    label250:
    label253:
    label259:
    for (;;)
    {
      if (i1 - m <= 1)
      {
        if (n != 0)
        {
          if (!((PayCard)localObject1).isEnable()) {
            break label247;
          }
          m++;
        }
        for (;;)
        {
          Collections.sort(paramList.subList(0, m), new a(null));
          Collections.sort(paramList.subList(m, i2), new a(null));
          return;
        }
        break label136;
        break label102;
      }
      break;
    }
  }
  
  private void i()
  {
    this.h.clear();
    boolean bool = getIntent().getBooleanExtra("add_card", true);
    ArrayList localArrayList2 = (ArrayList)getIntent().getSerializableExtra("card_list");
    String str = getIntent().getStringExtra("select_card_type");
    ArrayList localArrayList1 = localArrayList2;
    if (bool)
    {
      localArrayList1 = localArrayList2;
      if (com.wifipay.wallet.common.utils.f.b(localArrayList2)) {
        localArrayList1 = new ArrayList(1);
      }
      localArrayList1.add(PayCard.newCard(str));
    }
    a(localArrayList1);
    this.h.addAll(localArrayList1);
    this.i.notifyDataSetChanged();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.wifipay_card_item)
    {
      finish();
      this.j = ((Integer)paramView.getTag(R.id.wifipay_tag2)).intValue();
      EventBus.getDefault().post(new com.wifipay.wallet.a.f((PayCard)this.h.get(this.j)));
    }
  }
  
  protected native void onCreate(Bundle paramBundle);
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    i();
  }
  
  private static class a
    implements Comparator<PayCard>
  {
    public int a(PayCard paramPayCard1, PayCard paramPayCard2)
    {
      return paramPayCard1.seqNum - paramPayCard2.seqNum;
    }
  }
  
  private class b
    extends BaseAdapter
  {
    private Context b;
    
    public b(Context paramContext)
    {
      this.b = paramContext;
    }
    
    public int getCount()
    {
      return SelectCardActivity.a(SelectCardActivity.this).size();
    }
    
    public Object getItem(int paramInt)
    {
      return SelectCardActivity.a(SelectCardActivity.this).get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      label145:
      PayCard localPayCard;
      if (paramView == null)
      {
        paramView = ((LayoutInflater)this.b.getSystemService("layout_inflater")).inflate(R.layout.wifipay_activity_selectcard_item, null);
        paramViewGroup = new a(null);
        paramViewGroup.a = ((SmartImageView)paramView.findViewById(R.id.wifipay_bank_logo));
        paramViewGroup.b = ((TextView)paramView.findViewById(R.id.wifipay_card_item_info));
        paramViewGroup.c = paramView.findViewById(R.id.wifipay_select_item_transtry);
        paramViewGroup.d = ((WPImageView)paramView.findViewById(R.id.wifipay_card_item_btn));
        paramViewGroup.e = ((FrameLayout)paramView.findViewById(R.id.wifipay_select_card_icon));
        paramViewGroup.f = ((ImageView)paramView.findViewById(R.id.wifipay_bank_logo_bg));
        paramView.setTag(R.id.wifipay_tag1, paramViewGroup);
        if (paramInt != SelectCardActivity.a(SelectCardActivity.this).size() - 1) {
          break label334;
        }
        paramView.setBackgroundColor(16777215);
        localPayCard = (PayCard)getItem(paramInt);
        if (localPayCard.getLogo() <= 0) {
          break label359;
        }
        paramViewGroup.e.setVisibility(0);
        if (localPayCard.getLogo() != 1) {
          break label344;
        }
        if (paramViewGroup.a.getTag() == null) {
          paramViewGroup.a.a(d.h(localPayCard.bankCode), R.drawable.wifipay_banklogo_default);
        }
        label208:
        paramViewGroup.a.setTag(Integer.valueOf(localPayCard.getLogo()));
        label223:
        paramViewGroup.b.setText(localPayCard.getName());
        if (!localPayCard.isEnable()) {
          break label371;
        }
        paramView.setEnabled(true);
        paramViewGroup.b.setTextColor(-13421773);
        paramViewGroup.c.setVisibility(8);
        paramViewGroup.f.setVisibility(8);
        label275:
        if ((!localPayCard.isEnable()) || (localPayCard.getLogo() <= 0)) {
          break label404;
        }
        paramViewGroup.d.setVisibility(0);
      }
      for (;;)
      {
        paramView.setTag(R.id.wifipay_tag2, Integer.valueOf(paramInt));
        paramView.setOnClickListener(SelectCardActivity.this);
        return paramView;
        paramViewGroup = (a)paramView.getTag(R.id.wifipay_tag1);
        break;
        label334:
        paramView.setBackgroundResource(R.drawable.wifipay_wallet_card_desk_bg);
        break label145;
        label344:
        paramViewGroup.a.setImageResource(localPayCard.getLogo());
        break label208;
        label359:
        paramViewGroup.e.setVisibility(8);
        break label223;
        label371:
        paramView.setEnabled(false);
        paramViewGroup.b.setTextColor(-3355444);
        paramViewGroup.c.setVisibility(0);
        paramViewGroup.f.setVisibility(0);
        break label275;
        label404:
        paramViewGroup.d.setVisibility(8);
      }
    }
    
    private class a
    {
      SmartImageView a;
      TextView b;
      View c;
      WPImageView d;
      FrameLayout e;
      ImageView f;
      
      private a() {}
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/cashier/ui/SelectCardActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */