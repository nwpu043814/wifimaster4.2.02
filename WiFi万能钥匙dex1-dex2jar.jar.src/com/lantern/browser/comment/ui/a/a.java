package com.lantern.browser.comment.ui.a;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.lantern.browser.R.id;
import com.lantern.browser.R.layout;
import com.lantern.browser.R.string;
import com.lantern.browser.comment.d.g.a;
import com.lantern.browser.comment.d.g.b;
import com.lantern.browser.comment.d.g.c;
import com.lantern.browser.comment.d.i;
import com.lantern.browser.comment.d.j;
import com.lantern.browser.comment.ui.PinnedSectionListView.b;
import com.lantern.browser.comment.ui.WkCommentAvatarView;
import com.lantern.browser.comment.ui.WkCommentFloorView;
import com.lantern.browser.comment.ui.WkCommentFloorView.a;
import com.lantern.browser.comment.ui.WkCommentLikeButton;
import com.lantern.core.p;

public final class a
  extends BaseAdapter
  implements PinnedSectionListView.b
{
  private Context a;
  private com.lantern.browser.comment.d.g b;
  private LayoutInflater c;
  private a d;
  private WkCommentFloorView.a e;
  private Handler f;
  private String g;
  
  public a(Context paramContext)
  {
    this.a = paramContext;
    this.c = LayoutInflater.from(paramContext);
    this.b = null;
    this.f = new Handler();
    this.g = p.c(null);
  }
  
  private void b()
  {
    this.f.post(new f(this));
  }
  
  public final com.lantern.browser.comment.d.g a()
  {
    return this.b;
  }
  
  public final void a(com.lantern.browser.comment.d.g paramg)
  {
    this.b = paramg;
  }
  
  public final void a(WkCommentFloorView.a parama)
  {
    this.e = parama;
  }
  
  public final void a(a parama)
  {
    this.d = parama;
  }
  
  public final boolean a(int paramInt)
  {
    if (paramInt == 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final int getCount()
  {
    if (this.b != null) {}
    for (int i = this.b.a();; i = 0) {
      return i;
    }
  }
  
  public final Object getItem(int paramInt)
  {
    if (this.b != null) {}
    for (Object localObject = this.b.b(paramInt);; localObject = null) {
      return localObject;
    }
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    if (this.b != null) {}
    for (paramInt = this.b.a(paramInt);; paramInt = super.getItemViewType(paramInt)) {
      return paramInt;
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    label57:
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = new b((byte)0);
      switch (i)
      {
      default: 
        paramView.setTag(paramViewGroup);
        localObject = getItem(paramInt);
        switch (i)
        {
        }
        break;
      }
    }
    for (;;)
    {
      return paramView;
      paramView = this.c.inflate(R.layout.browser_comment_detail_reply_tip, null);
      paramViewGroup.a = ((TextView)paramView.findViewById(R.id.tipReplyTitle));
      paramViewGroup.b = paramView.findViewById(R.id.tipReplyImage);
      break;
      paramView = this.c.inflate(R.layout.browser_comment_detail_item, null);
      paramViewGroup.c = ((WkCommentAvatarView)paramView.findViewById(R.id.commentUserAvatar));
      paramViewGroup.d = ((TextView)paramView.findViewById(R.id.commentNickName));
      paramViewGroup.e = ((TextView)paramView.findViewById(R.id.commentTime));
      paramViewGroup.g = ((WkCommentFloorView)paramView.findViewById(R.id.commentContent));
      paramViewGroup.f = ((WkCommentLikeButton)paramView.findViewById(R.id.commentLikeBtn));
      break;
      paramView = this.c.inflate(R.layout.browser_comment_detail_group, null);
      paramViewGroup.h = ((TextView)paramView.findViewById(R.id.groupName));
      paramViewGroup.i = paramView.findViewById(R.id.groupItemCountLayout);
      paramViewGroup.j = ((TextView)paramViewGroup.i.findViewById(R.id.groupItemCount));
      break;
      paramView = this.c.inflate(R.layout.browser_comment_detail_loading, null);
      paramViewGroup.k = ((TextView)paramView.findViewById(R.id.loadingText));
      paramViewGroup.l = paramView.findViewById(R.id.loadingView);
      break;
      paramViewGroup = (b)paramView.getTag();
      break label57;
      localObject = (g.b)localObject;
      paramInt = ((g.b)localObject).a();
      if (paramInt == 0)
      {
        paramViewGroup.a.setText(String.format(this.a.getString(R.string.comment_receive_replyme), new Object[] { Integer.valueOf(((g.b)localObject).b()) }));
        paramViewGroup.b.setVisibility(0);
        paramView.setOnClickListener(new b(this));
      }
      else if (paramInt == 1)
      {
        paramViewGroup.a.setText(R.string.comment_load_ing);
        paramViewGroup.b.setVisibility(8);
        paramView.setOnClickListener(null);
      }
      else if (paramInt == 2)
      {
        paramViewGroup.a.setText(R.string.comment_load_failed);
        paramViewGroup.b.setVisibility(8);
        paramView.setOnClickListener(new c(this));
        continue;
        localObject = (i)localObject;
        j localj = ((i)localObject).e();
        if ((!TextUtils.isEmpty(this.g)) && (this.g.equals(localj.i())))
        {
          paramViewGroup.c.a(p.e(this.a));
          paramViewGroup.d.setText(com.lantern.browser.c.b.a(p.d(this.a), this.g));
        }
        for (;;)
        {
          paramViewGroup.e.setText(com.lantern.browser.c.g.a(this.a, localj.d()));
          paramViewGroup.g.a((i)localObject);
          paramViewGroup.f.a(localj);
          paramViewGroup.g.a(this.e);
          paramViewGroup.f.a(new d(this));
          break;
          paramViewGroup.c.a(localj.k());
          paramViewGroup.d.setText(com.lantern.browser.c.b.a(localj.c(), localj.i()));
        }
        localObject = (g.c)localObject;
        paramViewGroup.h.setText(((g.c)localObject).a());
        if (((g.c)localObject).b() == 0)
        {
          paramViewGroup.i.setVisibility(0);
          paramViewGroup.j.setText(String.valueOf(this.b.g()));
        }
        else
        {
          paramViewGroup.i.setVisibility(8);
          continue;
          localObject = (g.a)localObject;
          paramInt = ((g.a)localObject).a();
          if (paramInt == 0)
          {
            paramViewGroup.k.setText(R.string.comment_loadmore_ing);
            paramViewGroup.l.setVisibility(0);
            ((g.a)localObject).a(1);
            paramView.setOnClickListener(null);
            b();
          }
          else if (paramInt == 1)
          {
            paramViewGroup.k.setText(R.string.comment_loadmore_ing);
            paramViewGroup.l.setVisibility(0);
            paramView.setOnClickListener(null);
          }
          else if (paramInt == 3)
          {
            paramViewGroup.k.setText(R.string.comment_load_failed);
            paramViewGroup.l.setVisibility(8);
            if (this.d != null) {
              paramView.setOnClickListener(new e(this));
            }
          }
          else if (paramInt == 2)
          {
            paramViewGroup.k.setText(R.string.comment_load_nomore);
            paramViewGroup.l.setVisibility(8);
            paramView.setOnClickListener(null);
          }
        }
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 4;
  }
  
  public final void notifyDataSetChanged()
  {
    if (this.b != null) {
      this.b.b();
    }
    super.notifyDataSetChanged();
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
  
  private final class b
  {
    TextView a;
    View b;
    WkCommentAvatarView c;
    TextView d;
    TextView e;
    WkCommentLikeButton f;
    WkCommentFloorView g;
    TextView h;
    View i;
    TextView j;
    TextView k;
    View l;
    
    private b() {}
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/browser/comment/ui/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */