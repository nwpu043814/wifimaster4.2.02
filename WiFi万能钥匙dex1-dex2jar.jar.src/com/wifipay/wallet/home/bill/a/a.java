package com.wifipay.wallet.home.bill.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.wifipay.R.color;
import com.wifipay.R.id;
import com.wifipay.R.layout;
import com.wifipay.R.string;
import com.wifipay.common.a.f;
import com.wifipay.wallet.home.bill.b;
import com.wifipay.wallet.home.bill.net.dto.BillDetails.Bills;
import com.wifipay.wallet.home.bill.se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class a
  extends BaseAdapter
  implements SectionIndexer, StickyListHeadersAdapter
{
  private final String a = "yyyy-MM-dd HH:mm:ss";
  private Context b;
  private List<BillDetails.Bills> c;
  private int[] d;
  private String[] e;
  private ArrayList<Integer> f;
  private LayoutInflater g;
  private Calendar h;
  private DateFormat i;
  private int j;
  private int k;
  private List<a> l;
  private float m = 0.0F;
  private float n = 0.0F;
  
  public a(Context paramContext)
  {
    this.b = paramContext;
    this.g = LayoutInflater.from(paramContext);
    this.h = Calendar.getInstance();
    this.i = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    this.h.setTime(new Date());
    this.j = this.h.get(1);
    this.k = (this.h.get(2) + 1);
  }
  
  public static String a(BillDetails.Bills paramBills)
  {
    if (paramBills == null) {
      paramBills = "";
    }
    for (;;)
    {
      return paramBills;
      int i1 = Integer.valueOf(paramBills.direction).intValue();
      String str = paramBills.amount;
      if ((i1 == 2) || ("deposit".equals(paramBills.bizCode))) {
        paramBills = "+" + str;
      } else {
        paramBills = "-" + str;
      }
    }
  }
  
  private void a(String paramString)
  {
    this.n = com.wifipay.wallet.home.bill.b.a.a(this.b).a(paramString);
    this.m = com.wifipay.wallet.home.bill.b.a.a(this.b).b(paramString);
  }
  
  private int[] a()
  {
    int i2 = 0;
    ArrayList localArrayList;
    Object localObject;
    int i1;
    if ((this.c != null) && (this.c.size() > 0))
    {
      localArrayList = new ArrayList();
      this.f = new ArrayList();
      localObject = ((BillDetails.Bills)this.c.get(0)).tradeTime;
      localArrayList.add(Integer.valueOf(0));
      Iterator localIterator = this.c.iterator();
      i1 = 0;
      if (localIterator.hasNext())
      {
        String str = ((BillDetails.Bills)localIterator.next()).tradeTime;
        if (b.a(str, (String)localObject, "yyyy-MM")) {
          break label197;
        }
        i1++;
        localArrayList.add(Integer.valueOf(i1));
        localObject = str;
      }
    }
    label197:
    for (;;)
    {
      this.f.add(Integer.valueOf(i1));
      break;
      localObject = new int[localArrayList.size()];
      for (i1 = i2; i1 < localArrayList.size(); i1++) {
        localObject[i1] = ((Integer)localArrayList.get(i1)).intValue();
      }
      for (;;)
      {
        return (int[])localObject;
        localObject = new int[0];
      }
    }
  }
  
  public static int b(BillDetails.Bills paramBills)
  {
    if ((Integer.valueOf(paramBills.direction).intValue() == 2) || ("deposit".equals(paramBills.bizCode))) {}
    for (int i1 = -65536;; i1 = f.b(R.color.wifipay_color_333333)) {
      return i1;
    }
  }
  
  private String b(String paramString)
  {
    if ((paramString != null) && (!paramString.equals("")) && (paramString.length() > 11)) {}
    for (paramString = paramString.substring(0, 11);; paramString = "") {
      return paramString;
    }
  }
  
  private void b()
  {
    Object localObject1;
    int i3;
    int i1;
    Object localObject2;
    int i2;
    if ((this.c != null) && (this.c.size() > 0))
    {
      localObject1 = ((BillDetails.Bills)this.c.get(0)).tradeTime;
      this.l = new ArrayList();
      i3 = this.c.size();
      this.m = 0.0F;
      this.n = 0.0F;
      i1 = 0;
      localObject2 = "";
      if (i1 < i3)
      {
        String str = ((BillDetails.Bills)this.c.get(i1)).tradeTime;
        if (b.a(((BillDetails.Bills)this.c.get(i1)).tradeTime, (String)localObject1, "yyyy-MM")) {
          break label232;
        }
        for (i2 = this.l.size(); i2 < i1; i2++) {
          c();
        }
        this.m = 0.0F;
        this.n = 0.0F;
        localObject1 = str;
      }
    }
    label232:
    for (;;)
    {
      if (!b.a((String)localObject2, (String)localObject1, "yyyy-MM"))
      {
        a(((String)localObject1).substring(0, 7));
        localObject2 = localObject1;
      }
      for (;;)
      {
        if (i3 - 1 == i1) {
          for (i2 = this.l.size(); i2 < i3; i2++) {
            c();
          }
        }
        i1++;
        break;
        return;
      }
    }
  }
  
  private String c(BillDetails.Bills paramBills)
  {
    String str = paramBills.bizDesc;
    if ("transfer".equals(paramBills.bizCode)) {
      if (Integer.valueOf(paramBills.direction).intValue() != 2) {
        break label44;
      }
    }
    label44:
    for (str = this.b.getString(R.string.wifipay_bill_transfer_income_simple);; str = this.b.getString(R.string.wifipay_bill_transfer_out_simple)) {
      return str;
    }
  }
  
  private String c(String paramString)
  {
    String str = "";
    Object localObject = str;
    if (paramString != null)
    {
      localObject = str;
      if (!paramString.equals(""))
      {
        localObject = str;
        if (paramString.length() > 11) {
          localObject = new Date();
        }
      }
    }
    try
    {
      paramString = this.i.parse(paramString);
      this.h.setTime(paramString);
      i1 = this.h.get(1);
      i2 = this.h.get(2) + 1;
      if (i1 < this.j)
      {
        localObject = String.format(this.b.getString(R.string.wifipay_bill_his_month), new Object[] { i1 + "." + i2 });
        return (String)localObject;
      }
    }
    catch (ParseException paramString)
    {
      for (;;)
      {
        int i1;
        int i2;
        paramString.printStackTrace();
        paramString = (String)localObject;
        continue;
        if ((i1 == this.j) && (i2 == this.k)) {
          localObject = this.b.getString(R.string.wifipay_bill_cur_month);
        } else {
          localObject = String.format(this.b.getString(R.string.wifipay_bill_his_month), new Object[] { String.valueOf(i2) });
        }
      }
    }
  }
  
  private void c()
  {
    Object localObject = new DecimalFormat("0.00");
    localObject = new a(((DecimalFormat)localObject).format(this.m), ((DecimalFormat)localObject).format(this.n));
    this.l.add(localObject);
  }
  
  private String[] d()
  {
    String[] arrayOfString;
    if ((this.d != null) && (this.d.length != 0))
    {
      arrayOfString = new String[this.d.length];
      for (int i1 = 0; i1 < this.d.length; i1++) {
        arrayOfString[i1] = ((BillDetails.Bills)this.c.get(this.d[i1])).tradeTime;
      }
    }
    for (;;)
    {
      return arrayOfString;
      arrayOfString = new String[0];
    }
  }
  
  public void a(List<BillDetails.Bills> paramList)
  {
    this.c = paramList;
    this.d = a();
    this.e = d();
    b();
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.c == null) {}
    for (int i1 = 0;; i1 = this.c.size()) {
      return i1;
    }
  }
  
  public long getHeaderId(int paramInt)
  {
    return ((Integer)this.f.get(paramInt)).intValue();
  }
  
  public View getHeaderView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      localObject = new b();
      paramView = this.g.inflate(R.layout.wifipay_home_bill_list_header, paramViewGroup, false);
      ((b)localObject).a = ((TextView)paramView.findViewById(R.id.wifipay_bill_item_header_date));
      ((b)localObject).b = ((TextView)paramView.findViewById(R.id.wifipay_bill_item_header_money));
      paramView.setTag(localObject);
    }
    for (paramViewGroup = (ViewGroup)localObject;; paramViewGroup = (b)paramView.getTag())
    {
      paramViewGroup.a.setText(c(((BillDetails.Bills)this.c.get(paramInt)).tradeTime));
      if ((this.l != null) && (this.l.size() > paramInt))
      {
        localObject = (a)this.l.get(paramInt);
        localObject = this.b.getString(R.string.wifipay_bill_list_pay) + ((a)localObject).a + "  " + this.b.getString(R.string.wifipay_bill_list_income) + ((a)localObject).b;
        paramViewGroup.b.setText((CharSequence)localObject);
      }
      return paramView;
    }
  }
  
  public Object getItem(int paramInt)
  {
    return this.c.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getPositionForSection(int paramInt)
  {
    int i1 = 0;
    if (this.d.length == 0)
    {
      paramInt = i1;
      return paramInt;
    }
    if (paramInt >= this.d.length) {
      i1 = this.d.length - 1;
    }
    for (;;)
    {
      paramInt = this.d[i1];
      break;
      i1 = paramInt;
      if (paramInt < 0) {
        i1 = 0;
      }
    }
  }
  
  public int getSectionForPosition(int paramInt)
  {
    int i1 = 0;
    if (i1 < this.d.length) {
      if (paramInt >= this.d[i1]) {}
    }
    for (paramInt = i1 - 1;; paramInt = this.d.length - 1)
    {
      return paramInt;
      i1++;
      break;
    }
  }
  
  public Object[] getSections()
  {
    return this.e;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      Object localObject = new c();
      paramView = this.g.inflate(R.layout.wifipay_home_bill_list_item, paramViewGroup, false);
      ((c)localObject).a = ((TextView)paramView.findViewById(R.id.wifipay_home_bill_item_title));
      ((c)localObject).b = ((TextView)paramView.findViewById(R.id.wifipay_home_bill_item_status));
      ((c)localObject).c = ((TextView)paramView.findViewById(R.id.wifipay_home_bill_item_time));
      ((c)localObject).d = ((TextView)paramView.findViewById(R.id.wifipay_home_bill_item_money));
      paramView.setTag(localObject);
      paramViewGroup = (ViewGroup)localObject;
      localObject = (BillDetails.Bills)this.c.get(paramInt);
      paramViewGroup.a.setText(c((BillDetails.Bills)localObject));
      paramViewGroup.c.setText(b(((BillDetails.Bills)localObject).tradeTime));
      paramViewGroup.d.setText(a((BillDetails.Bills)localObject));
      paramViewGroup.d.setTextColor(b((BillDetails.Bills)localObject));
      paramViewGroup.b.setText(((BillDetails.Bills)localObject).statusDesc);
      paramInt = Integer.valueOf(((BillDetails.Bills)localObject).status).intValue();
      if ((paramInt != 0) && (paramInt != 3)) {
        break label230;
      }
      paramViewGroup.b.setTextColor(this.b.getResources().getColor(R.color.wifipay_color_ef6f07));
    }
    for (;;)
    {
      return paramView;
      paramViewGroup = (c)paramView.getTag();
      break;
      label230:
      paramViewGroup.b.setTextColor(this.b.getResources().getColor(R.color.wifipay_color_b6b6b6));
    }
  }
  
  class a
  {
    String a;
    String b;
    
    public a(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
  }
  
  class b
  {
    TextView a;
    TextView b;
    
    b() {}
  }
  
  class c
  {
    TextView a;
    TextView b;
    TextView c;
    TextView d;
    
    c() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/wifipay/wallet/home/bill/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */