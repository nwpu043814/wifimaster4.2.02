package com.linksure.apservice.ui.home.list;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import bluefay.app.k.a;
import bluefay.support.annotation.Nullable;
import com.lantern.core.imageloader.a.aa;
import com.lantern.core.imageloader.a.ah;
import com.linksure.apservice.R.array;
import com.linksure.apservice.R.dimen;
import com.linksure.apservice.R.drawable;
import com.linksure.apservice.R.id;
import com.linksure.apservice.R.layout;
import com.linksure.apservice.R.string;
import com.linksure.apservice.b.e.a;
import com.linksure.apservice.b.g;
import com.linksure.apservice.ui.common.ImageViewerActivity;
import com.linksure.apservice.ui.common.interceptor.InterceptorFragment;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MessageListFragment
  extends InterceptorFragment
  implements View.OnClickListener, d.b
{
  private static Drawable m;
  private static aa n;
  private static String o = "T_T";
  private View g;
  private TextView i;
  private TextView j;
  private ListView k;
  private a l;
  private d.a p;
  private com.linksure.apservice.b.a q;
  private com.linksure.apservice.ui.home.b.b r;
  
  static int b(Context paramContext)
  {
    return com.linksure.apservice.utils.j.a(paramContext, 120.0F);
  }
  
  public static MessageListFragment b(com.linksure.apservice.b.a parama)
  {
    MessageListFragment localMessageListFragment = new MessageListFragment();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("aps_id", parama);
    localMessageListFragment.setArguments(localBundle);
    return localMessageListFragment;
  }
  
  static int c(Context paramContext)
  {
    return (com.linksure.apservice.utils.j.a(paramContext) - 180) / 2;
  }
  
  public final Dialog a(String paramString)
  {
    com.bluefay.material.f localf = new com.bluefay.material.f(this.e);
    localf.a(paramString);
    localf.setCanceledOnTouchOutside(false);
    return localf;
  }
  
  public final void a(long paramLong)
  {
    new a(getActivity()).a(R.array.aps_item_fail, new k(this, paramLong)).a().b();
  }
  
  public final void a(View paramView, com.linksure.apservice.b.i parami)
  {
    if ((this.r != null) && (this.r.isShowing())) {
      this.r.dismiss();
    }
    paramView = paramView.findViewById(R.id.aps_listitem_text_text);
    paramView.setSelected(true);
    this.r = new com.linksure.apservice.ui.home.b.b(getActivity());
    this.r.a(paramView);
    this.r.a(new i(this, parami));
    this.r.setOnDismissListener(new j(this, paramView));
  }
  
  public final void a(com.linksure.apservice.b.a parama)
  {
    this.i.setText(parama.l);
    if (parama.e)
    {
      this.j.setText(R.string.aps_stat_follow);
      this.j.setSelected(true);
      this.j.setCompoundDrawablesWithIntrinsicBounds(R.drawable.aps_gougou, 0, 0, 0);
    }
    for (;;)
    {
      return;
      this.j.setText(R.string.aps_stat_unfollow);
      this.j.setSelected(false);
      this.j.setCompoundDrawablesWithIntrinsicBounds(R.drawable.aps_jia, 0, 0, 0);
    }
  }
  
  public final void a(com.linksure.apservice.b.f paramf)
  {
    Intent localIntent = new Intent(getActivity(), ImageViewerActivity.class);
    if (!paramf.h)
    {
      localIntent.putExtra("preview image", paramf.a);
      localIntent.putExtra("origin image", paramf.b);
    }
    for (;;)
    {
      startActivity(localIntent);
      return;
      localIntent.putExtra("preview image", paramf.b);
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    this.l.a(paramString1);
    this.l.b(paramString2);
    this.l.notifyDataSetChanged();
  }
  
  public final void a(List<com.linksure.apservice.b.i> paramList, boolean paramBoolean, int paramInt)
  {
    this.l.a(paramList);
    this.l.notifyDataSetChanged();
    if ((paramInt >= 0) && (paramInt <= this.l.getCount()))
    {
      if (!paramBoolean) {
        break label43;
      }
      this.k.smoothScrollToPosition(paramInt);
    }
    for (;;)
    {
      return;
      label43:
      this.k.setSelection(paramInt);
    }
  }
  
  public final void b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = new Intent("wifi.intent.action.BROWSER", Uri.parse(paramString));
      paramString.setPackage(getActivity().getPackageName());
      com.bluefay.a.e.a(getActivity(), paramString);
    }
  }
  
  public final void h()
  {
    View localView = getView();
    if (localView != null) {
      localView.postDelayed(new h(this), 300L);
    }
  }
  
  public final void k_()
  {
    Toast.makeText(getActivity(), R.string.aps_black, 0).show();
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    if ((i1 == R.id.aps_home_follow) || (i1 == R.id.aps_home_toolbar_follow)) {
      this.p.s_();
    }
    for (;;)
    {
      return;
      if (i1 == R.id.aps_home_info) {
        com.linksure.apservice.utils.b.a("saidhncli", ((l)this.p).f);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    l locall = new l(this, com.linksure.apservice.a.i.a(getActivity()), com.linksure.apservice.a.i.b(getActivity()), com.linksure.apservice.a.i.d(getActivity()));
    super.a(locall);
    this.p = locall;
    Log.e("--->", "fragment created:" + paramBundle);
    this.g = getActivity().findViewById(R.id.aps_rich_title_bar);
    this.i = ((TextView)getActivity().findViewById(R.id.aps_toolbar_title));
    this.j = ((TextView)getActivity().findViewById(R.id.aps_home_toolbar_follow));
    this.j.setOnClickListener(this);
    m = com.linksure.apservice.ui.views.custom.a.a(getActivity());
    n = aa.a(getActivity().getApplicationContext());
    if (paramBundle != null)
    {
      this.q = ((com.linksure.apservice.b.a)paramBundle.getSerializable("aps_id"));
      this.p.a_(this.q);
    }
    for (;;)
    {
      return;
      this.q = ((com.linksure.apservice.b.a)getArguments().getSerializable("aps_id"));
      this.p.a_(this.q);
    }
  }
  
  @Nullable
  public View onCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(R.layout.aps_fragment_msglist, null);
    this.k = ((ListView)paramLayoutInflater.findViewById(R.id.aps_listview));
    this.l = new a(getActivity());
    this.l.a(this.q.h);
    this.l.a(this.p);
    this.k.setAdapter(this.l);
    this.k.setOnScrollListener(new e(this));
    this.g.setVisibility(0);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.p.c();
    m = null;
    n = null;
  }
  
  public void onPause()
  {
    super.onPause();
    if ((this.r != null) && (this.r.isShowing())) {
      this.r.dismiss();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    com.linksure.apservice.utils.b.d("seridxshow");
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putSerializable("aps_id", getArguments().getSerializable("aps_id"));
  }
  
  public final void r_()
  {
    k.a locala = new k.a(this.e);
    locala.a(R.string.aps_dialog_title);
    View localView = LayoutInflater.from(this.e).inflate(R.layout.aps_pushmsg_dialog, null, false);
    ((TextView)localView.findViewById(R.id.tv_alert)).setText(this.e.getString(R.string.aps_dialog_msg_push));
    locala.a(localView);
    locala.a(17039370, new f(this));
    locala.b(17039360, null);
    locala.d();
  }
  
  static final class a
    extends BaseAdapter
  {
    private List<com.linksure.apservice.b.i> a = Collections.EMPTY_LIST;
    private String b;
    private String c;
    private Context d;
    private d.a e;
    private boolean f = false;
    
    public a(Context paramContext)
    {
      this.d = paramContext;
    }
    
    public final void a(d.a parama)
    {
      this.e = parama;
    }
    
    public final void a(String paramString)
    {
      this.b = paramString;
    }
    
    public final void a(List<com.linksure.apservice.b.i> paramList)
    {
      this.a = paramList;
    }
    
    final void a(boolean paramBoolean)
    {
      this.f = paramBoolean;
    }
    
    public final void b(String paramString)
    {
      this.c = paramString;
    }
    
    public final int getCount()
    {
      return this.a.size();
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      com.linksure.apservice.b.i locali = (com.linksure.apservice.b.i)this.a.get(paramInt);
      switch (locali.g)
      {
      case 3: 
      case 4: 
      case 6: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      default: 
        paramInt = 0;
      }
      for (;;)
      {
        return paramInt;
        if (locali.h)
        {
          paramInt = 2;
        }
        else
        {
          paramInt = 1;
          continue;
          if (locali.h)
          {
            paramInt = 4;
          }
          else
          {
            paramInt = 3;
            continue;
            paramInt = 5;
            continue;
            paramInt = 14;
            continue;
            paramInt = 7;
            continue;
            paramInt = 8;
          }
        }
      }
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null) {
        switch (getItemViewType(paramInt))
        {
        case 6: 
        case 9: 
        case 10: 
        case 11: 
        case 12: 
        case 13: 
        default: 
          paramViewGroup = LayoutInflater.from(this.d).inflate(R.layout.aps_listitem_message_text_left, null);
          paramView = new MessageListFragment.k(paramViewGroup);
          paramViewGroup.setTag(paramView);
          paramView.a(this.e);
          if (((com.linksure.apservice.b.i)this.a.get(paramInt)).h) {
            paramView.a(this.c);
          }
          break;
        }
      }
      for (;;)
      {
        paramView.a((com.linksure.apservice.b.i)this.a.get(paramInt), this.f);
        return MessageListFragment.c.a(paramView);
        paramViewGroup = LayoutInflater.from(this.d).inflate(R.layout.aps_listitem_message_separator, null);
        paramView = new MessageListFragment.i(paramViewGroup);
        break;
        paramViewGroup = LayoutInflater.from(this.d).inflate(R.layout.aps_listitem_message_text_left, null);
        paramView = new MessageListFragment.k(paramViewGroup);
        break;
        paramViewGroup = LayoutInflater.from(this.d).inflate(R.layout.aps_listitem_message_text_right, null);
        paramView = new MessageListFragment.l(paramViewGroup);
        break;
        paramViewGroup = LayoutInflater.from(this.d).inflate(R.layout.aps_listitem_message_image_left, null);
        paramView = new MessageListFragment.f(paramViewGroup);
        break;
        paramViewGroup = LayoutInflater.from(this.d).inflate(R.layout.aps_listitem_message_image_right, null);
        paramView = new MessageListFragment.g(paramViewGroup);
        break;
        paramViewGroup = LayoutInflater.from(this.d).inflate(R.layout.aps_listitem_message_media, null);
        paramView = new MessageListFragment.h(paramViewGroup);
        break;
        paramViewGroup = LayoutInflater.from(this.d).inflate(R.layout.aps_listitem_message_img_info, null);
        paramView = new MessageListFragment.e(paramViewGroup);
        break;
        paramViewGroup = LayoutInflater.from(this.d).inflate(R.layout.aps_listitem_message_img_card, null);
        paramView = new MessageListFragment.d(paramViewGroup);
        break;
        paramViewGroup = LayoutInflater.from(this.d).inflate(R.layout.aps_listitem_message_text_card, null);
        paramView = new MessageListFragment.j(paramViewGroup);
        break;
        paramView.a(this.b);
        continue;
        paramView = (MessageListFragment.c)paramView.getTag();
      }
    }
    
    public final int getViewTypeCount()
    {
      return 15;
    }
  }
  
  static abstract interface b
  {
    public abstract void a(com.linksure.apservice.b.i parami, boolean paramBoolean);
  }
  
  static abstract class c
    implements MessageListFragment.b
  {
    private d.a a;
    private View b;
    
    public c(View paramView)
    {
      this.b = paramView;
    }
    
    public final void a()
    {
      if (this.a != null) {
        this.a.g();
      }
    }
    
    public final void a(com.linksure.apservice.b.i parami)
    {
      if (this.a != null) {
        this.a.a(parami);
      }
    }
    
    public final void a(d.a parama)
    {
      this.a = parama;
    }
    
    public void a(String paramString) {}
    
    public final View b()
    {
      return this.b;
    }
    
    public final void b(com.linksure.apservice.b.i parami)
    {
      if (this.a != null) {
        this.a.a(this.b, parami);
      }
    }
    
    public final void c(com.linksure.apservice.b.i parami)
    {
      if (this.a != null) {
        this.a.b(parami);
      }
    }
  }
  
  static final class d
    extends MessageListFragment.c
    implements View.OnClickListener, MessageListFragment.b
  {
    private View a;
    private ImageView b;
    private TextView c;
    private ViewGroup d;
    private com.linksure.apservice.b.i e;
    
    public d(View paramView)
    {
      super();
      this.a = paramView.findViewById(R.id.aps_listitem_img_card_topview);
      this.c = ((TextView)paramView.findViewById(R.id.aps_listitem_img_card_title));
      this.b = ((ImageView)paramView.findViewById(R.id.aps_listitem_img_card_image));
      this.d = ((ViewGroup)paramView.findViewById(R.id.aps_listitem_img_card_item_layout));
      this.a.setOnClickListener(this);
      this.a.setTag(Integer.valueOf(0));
    }
    
    public final void a(com.linksure.apservice.b.i parami, boolean paramBoolean)
    {
      this.e = parami;
      e.a[] arrayOfa = ((com.linksure.apservice.b.e)parami).b;
      if ((arrayOfa == null) || (arrayOfa.length == 0)) {
        this.d.removeAllViews();
      }
      for (;;)
      {
        return;
        if ((arrayOfa != null) && (arrayOfa.length > 0))
        {
          this.c.setText(arrayOfa[0].e);
          if (!TextUtils.isEmpty(arrayOfa[0].b)) {
            MessageListFragment.j().a(arrayOfa[0].b).a(R.drawable.aps_fail_image).a(MessageListFragment.i()).a().d().a(this.b);
          }
          this.d.removeAllViews();
          for (int i = 1; i < arrayOfa.length; i++)
          {
            parami = LayoutInflater.from(b().getContext()).inflate(R.layout.aps_listitem_message_img_card_item, null);
            if (i == arrayOfa.length - 1)
            {
              parami.setBackgroundResource(R.drawable.aps_white_corner_small_bottom_bkg);
              parami.setPadding(parami.getPaddingLeft(), parami.getPaddingTop(), parami.getPaddingRight(), parami.getResources().getDimensionPixelSize(R.dimen.aps_msglist_mini_padding));
            }
            parami.setOnClickListener(this);
            parami.setTag(Integer.valueOf(i));
            ((TextView)parami.findViewById(R.id.aps_listitem_img_card_item_title)).setText(arrayOfa[i].e);
            ImageView localImageView = (ImageView)parami.findViewById(R.id.aps_listitem_img_card_item_logo);
            if (!TextUtils.isEmpty(arrayOfa[i].b)) {
              MessageListFragment.j().a(arrayOfa[i].b).a(R.drawable.aps_fail_image).a(MessageListFragment.i()).a().d().a(localImageView);
            }
            this.d.addView(parami);
          }
        }
      }
    }
    
    public final void onClick(View paramView)
    {
      int i = ((Integer)paramView.getTag()).intValue();
      ((com.linksure.apservice.b.e)this.e).a = i;
      a(this.e);
    }
  }
  
  static final class e
    extends MessageListFragment.c
    implements View.OnClickListener, MessageListFragment.b
  {
    TextView a;
    TextView b;
    TextView c;
    View d;
    ImageView e;
    private com.linksure.apservice.b.i f;
    
    public e(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(R.id.aps_listitem_img_info_list_title));
      this.b = ((TextView)paramView.findViewById(R.id.aps_listitem_img_info_list_summary));
      this.d = paramView.findViewById(R.id.aps_listitem_img_info_list_view);
      this.c = ((TextView)paramView.findViewById(R.id.aps_listitem_img_info_list_date));
      this.e = ((ImageView)paramView.findViewById(R.id.aps_listitem_img_info_list_image));
      this.d.setOnClickListener(this);
    }
    
    public final void a(com.linksure.apservice.b.i parami, boolean paramBoolean)
    {
      this.f = parami;
      Object localObject = (com.linksure.apservice.b.e)parami;
      parami = ((com.linksure.apservice.b.e)localObject).b;
      if ((parami != null) && (parami.length > 0))
      {
        this.a.setText(parami[0].e);
        this.b.setText(parami[0].d);
        localObject = new Date(((com.linksure.apservice.b.e)localObject).i);
        localObject = new SimpleDateFormat("yyyy-MM-dd").format((Date)localObject);
        this.c.setText((CharSequence)localObject);
        if (!TextUtils.isEmpty(parami[0].b)) {
          MessageListFragment.j().a(parami[0].b).a(R.drawable.aps_fail_image).a(MessageListFragment.i()).a().d().a(this.e);
        }
      }
    }
    
    public final void onClick(View paramView)
    {
      a(this.f);
    }
  }
  
  static final class f
    extends MessageListFragment.c
    implements View.OnClickListener, MessageListFragment.b
  {
    ImageView a;
    ImageView b;
    private com.linksure.apservice.b.i c;
    
    public f(View paramView)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(R.id.aps_listitem_image_logo));
      this.b = ((ImageView)paramView.findViewById(R.id.aps_listitem_image_image));
      this.b.setMaxHeight(MessageListFragment.b(paramView.getContext()));
      this.b.setMaxWidth(MessageListFragment.c(paramView.getContext()));
      this.b.setOnClickListener(this);
    }
    
    public final void a(com.linksure.apservice.b.i parami, boolean paramBoolean)
    {
      this.c = parami;
      parami = ((com.linksure.apservice.b.f)parami).a;
      if (!TextUtils.isEmpty(parami)) {
        MessageListFragment.j().a(parami).a(MessageListFragment.k()).a(MessageListFragment.i()).a().d().a(this.b);
      }
    }
    
    public final void a(String paramString)
    {
      com.linksure.apservice.utils.e.a(this.a, paramString, R.drawable.aps_dft_logo);
    }
    
    public final void onClick(View paramView)
    {
      a(this.c);
    }
  }
  
  static final class g
    extends MessageListFragment.c
    implements View.OnClickListener, MessageListFragment.b
  {
    ProgressBar a;
    ImageView b;
    ImageView c;
    ImageView d;
    private View e;
    private com.linksure.apservice.b.i f;
    
    public g(View paramView)
    {
      super();
      this.e = paramView.findViewById(R.id.aps_push_layout);
      this.c = ((ImageView)paramView.findViewById(R.id.aps_listitem_image_avatar));
      this.d = ((ImageView)paramView.findViewById(R.id.aps_listitem_image_image));
      this.a = ((ProgressBar)paramView.findViewById(R.id.aps_listitem_busy));
      this.b = ((ImageView)paramView.findViewById(R.id.aps_listitem_fail));
      this.d.setMaxHeight(MessageListFragment.b(paramView.getContext()));
      this.d.setMaxWidth(MessageListFragment.c(paramView.getContext()));
      paramView.findViewById(R.id.aps_push_open).setOnClickListener(this);
      this.d.setOnClickListener(this);
      this.b.setOnClickListener(this);
    }
    
    public final void a(com.linksure.apservice.b.i parami, boolean paramBoolean)
    {
      this.f = parami;
      if (parami.f == 0)
      {
        this.a.setVisibility(8);
        this.b.setVisibility(8);
        if (!paramBoolean) {
          break label154;
        }
        this.e.setVisibility(8);
      }
      for (;;)
      {
        parami = ((com.linksure.apservice.b.f)parami).a;
        if (!TextUtils.isEmpty(parami)) {
          MessageListFragment.j().a(new File(parami)).a(MessageListFragment.k()).a(MessageListFragment.i()).a().d().a(this.d);
        }
        return;
        if (parami.f == 2)
        {
          this.a.setVisibility(0);
          this.b.setVisibility(8);
          break;
        }
        if (parami.f != 1) {
          break;
        }
        this.a.setVisibility(8);
        this.b.setVisibility(0);
        break;
        label154:
        this.e.setVisibility(0);
      }
    }
    
    public final void a(String paramString)
    {
      com.linksure.apservice.utils.e.a(this.c, paramString, R.drawable.aps_avatar120);
    }
    
    public final void onClick(View paramView)
    {
      if (paramView.getId() == R.id.aps_listitem_image_image) {
        a(this.f);
      }
      for (;;)
      {
        return;
        if (paramView.getId() == R.id.aps_listitem_fail) {
          c(this.f);
        } else if (paramView.getId() == R.id.aps_push_open) {
          a();
        }
      }
    }
  }
  
  static final class h
    extends MessageListFragment.c
    implements View.OnClickListener, MessageListFragment.b
  {
    ImageView a;
    ImageView b;
    TextView c;
    private com.linksure.apservice.b.i d;
    
    public h(View paramView)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(R.id.aps_listitem_logo));
      this.b = ((ImageView)paramView.findViewById(R.id.aps_listitem_media_image));
      this.c = ((TextView)paramView.findViewById(R.id.aps_listitem_media_text));
      this.b.setOnClickListener(this);
      this.c.setOnClickListener(this);
    }
    
    public final void a(com.linksure.apservice.b.i parami, boolean paramBoolean)
    {
      this.d = parami;
      parami = (g)parami;
      this.c.setText(parami.a);
      if (!TextUtils.isEmpty(parami.b)) {
        MessageListFragment.j().a(parami.b).a(R.drawable.aps_fail_image).a(MessageListFragment.i()).a().d().a(this.b);
      }
    }
    
    public final void a(String paramString)
    {
      if (this.a == null) {
        Log.e("--->", "fatal error, image is null");
      }
      com.linksure.apservice.utils.e.a(this.a, paramString, R.drawable.aps_dft_logo);
    }
    
    public final void onClick(View paramView)
    {
      a(this.d);
    }
  }
  
  static final class i
    extends MessageListFragment.c
    implements MessageListFragment.b
  {
    TextView a;
    
    public i(View paramView)
    {
      super();
      this.a = ((TextView)paramView.findViewById(R.id.aps_listitem_separator_text));
    }
    
    public final void a(com.linksure.apservice.b.i parami, boolean paramBoolean)
    {
      this.a.setText(parami.j);
    }
  }
  
  static final class j
    extends MessageListFragment.c
    implements View.OnClickListener, MessageListFragment.b
  {
    private View a;
    private TextView b;
    private TextView c;
    private TextView d;
    private com.linksure.apservice.b.i e;
    
    public j(View paramView)
    {
      super();
      this.c = ((TextView)paramView.findViewById(R.id.aps_listitem_text_card_title));
      this.b = ((TextView)paramView.findViewById(R.id.aps_listitem_text_card_summary));
      this.a = paramView.findViewById(R.id.aps_listitem_text_card_view);
      this.d = ((TextView)paramView.findViewById(R.id.aps_listitem_text_card_date));
    }
    
    public final void a(com.linksure.apservice.b.i parami, boolean paramBoolean)
    {
      this.e = parami;
      com.linksure.apservice.b.j localj = (com.linksure.apservice.b.j)parami;
      this.c.setText(localj.a);
      parami = Html.fromHtml(localj.c).toString();
      this.b.setText(parami);
      parami = new Date(localj.i);
      parami = new SimpleDateFormat("yyyy-MM-dd").format(parami);
      this.d.setText(parami);
      this.a.setOnClickListener(this);
    }
    
    public final void onClick(View paramView)
    {
      a(this.e);
    }
  }
  
  static final class k
    extends MessageListFragment.c
    implements View.OnLongClickListener, MessageListFragment.b
  {
    ImageView a;
    TextView b;
    com.linksure.apservice.b.i c;
    
    public k(View paramView)
    {
      super();
      this.a = ((ImageView)paramView.findViewById(R.id.aps_listitem_text_logo));
      this.b = ((TextView)paramView.findViewById(R.id.aps_listitem_text_text));
      this.b.setMovementMethod(LinkMovementMethod.getInstance());
      this.b.setOnLongClickListener(this);
    }
    
    public final void a(com.linksure.apservice.b.i parami, boolean paramBoolean)
    {
      this.c = parami;
      if (parami.k != null) {
        this.b.setText(parami.k);
      }
      for (;;)
      {
        return;
        this.b.setText(parami.j);
      }
    }
    
    public final void a(String paramString)
    {
      com.linksure.apservice.utils.e.a(this.a, paramString, R.drawable.aps_dft_logo);
    }
    
    public final boolean onLongClick(View paramView)
    {
      b(this.c);
      return true;
    }
  }
  
  static final class l
    extends MessageListFragment.c
    implements View.OnClickListener, View.OnLongClickListener, MessageListFragment.b
  {
    ProgressBar a;
    ImageView b;
    ImageView c;
    TextView d;
    com.linksure.apservice.b.i e;
    private View f;
    
    public l(View paramView)
    {
      super();
      this.f = paramView.findViewById(R.id.aps_push_layout);
      this.a = ((ProgressBar)paramView.findViewById(R.id.aps_listitem_busy));
      this.b = ((ImageView)paramView.findViewById(R.id.aps_listitem_fail));
      this.c = ((ImageView)paramView.findViewById(R.id.aps_listitem_text_avatar));
      this.d = ((TextView)paramView.findViewById(R.id.aps_listitem_text_text));
      this.d.setMovementMethod(LinkMovementMethod.getInstance());
      paramView.findViewById(R.id.aps_push_open).setOnClickListener(this);
      this.d.setOnLongClickListener(this);
      this.b.setOnClickListener(this);
    }
    
    public final void a(com.linksure.apservice.b.i parami, boolean paramBoolean)
    {
      this.e = parami;
      if (parami.k != null)
      {
        this.d.setText(parami.k);
        if (!paramBoolean) {
          break label76;
        }
        this.f.setVisibility(8);
        label36:
        if (parami.f != 0) {
          break label87;
        }
        this.a.setVisibility(8);
        this.b.setVisibility(8);
      }
      for (;;)
      {
        return;
        this.d.setText(parami.j);
        break;
        label76:
        this.f.setVisibility(0);
        break label36;
        label87:
        if (parami.f == 2)
        {
          this.a.setVisibility(0);
          this.b.setVisibility(8);
        }
        else if (parami.f == 1)
        {
          this.a.setVisibility(8);
          this.b.setVisibility(0);
        }
      }
    }
    
    public final void a(String paramString)
    {
      com.linksure.apservice.utils.e.a(this.c, paramString, R.drawable.aps_avatar120);
    }
    
    public final void onClick(View paramView)
    {
      if (this.e.f == 1) {
        c(this.e);
      }
      for (;;)
      {
        return;
        if (paramView.getId() == R.id.aps_push_open) {
          a();
        }
      }
    }
    
    public final boolean onLongClick(View paramView)
    {
      b(this.e);
      return true;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/linksure/apservice/ui/home/list/MessageListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */