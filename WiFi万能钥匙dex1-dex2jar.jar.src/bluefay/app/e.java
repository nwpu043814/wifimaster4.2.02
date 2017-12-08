package bluefay.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bluefay.framework.R.attr;
import com.bluefay.framework.R.dimen;
import com.bluefay.framework.R.id;
import com.bluefay.framework.R.layout;
import com.bluefay.framework.R.styleable;
import java.lang.ref.WeakReference;

public final class e
{
  private ImageView A;
  private TextView B;
  private TextView C;
  private View D;
  private boolean E;
  private ListAdapter F;
  private int G = -1;
  private int H;
  private int I;
  private int J;
  private int K;
  private int L;
  private Handler M;
  View.OnClickListener a = new f(this);
  private final Context b;
  private final DialogInterface c;
  private final Window d;
  private CharSequence e;
  private CharSequence f;
  private ListView g;
  private View h;
  private int i;
  private int j;
  private int k;
  private int l;
  private boolean m = false;
  private View n;
  private Button o;
  private CharSequence p;
  private Message q;
  private Button r;
  private CharSequence s;
  private Message t;
  private Button u;
  private CharSequence v;
  private Message w;
  private ScrollView x;
  private int y = -1;
  private Drawable z;
  
  public e(Context paramContext, DialogInterface paramDialogInterface, Window paramWindow)
  {
    this.b = paramContext;
    this.c = paramDialogInterface;
    this.d = paramWindow;
    this.M = new b(paramDialogInterface);
    paramContext = paramContext.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
    this.H = paramContext.getResourceId(10, R.layout.framework_alert_dialog);
    this.I = paramContext.getResourceId(11, R.layout.framework_select_dialog);
    this.J = paramContext.getResourceId(12, R.layout.framework_select_dialog_multichoice);
    this.K = paramContext.getResourceId(13, R.layout.framework_select_dialog_singlechoice);
    this.L = paramContext.getResourceId(14, R.layout.framework_select_dialog_item);
    paramContext.recycle();
  }
  
  private static void a(Button paramButton)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramButton.getLayoutParams();
    localLayoutParams.gravity = 1;
    localLayoutParams.weight = 0.5F;
    paramButton.setLayoutParams(localLayoutParams);
  }
  
  private static boolean c(View paramView)
  {
    boolean bool = true;
    if (paramView.onCheckIsTextEditor()) {}
    for (;;)
    {
      return bool;
      if (!(paramView instanceof ViewGroup))
      {
        bool = false;
      }
      else
      {
        paramView = (ViewGroup)paramView;
        int i1 = paramView.getChildCount();
        for (;;)
        {
          if (i1 > 0)
          {
            int i2 = i1 - 1;
            i1 = i2;
            if (c(paramView.getChildAt(i2))) {
              break;
            }
          }
        }
        bool = false;
      }
    }
  }
  
  public final void a()
  {
    int i5 = 1;
    this.d.requestFeature(1);
    if ((this.h == null) || (!c(this.h))) {
      this.d.setFlags(131072, 131072);
    }
    this.d.setContentView(this.H);
    Object localObject1 = (LinearLayout)this.d.findViewById(R.id.contentPanel);
    this.x = ((ScrollView)this.d.findViewById(R.id.scrollView));
    this.x.setFocusable(false);
    this.C = ((TextView)this.d.findViewById(R.id.message));
    int i1;
    label196:
    label243:
    label290:
    label302:
    int i2;
    label314:
    int i3;
    label326:
    int i4;
    label339:
    label367:
    label373:
    Object localObject3;
    if (this.C != null)
    {
      if (this.f != null) {
        this.C.setText(this.f);
      }
    }
    else
    {
      this.o = ((Button)this.d.findViewById(R.id.button1));
      this.o.setOnClickListener(this.a);
      this.n = this.d.findViewById(R.id.divider);
      if (!TextUtils.isEmpty(this.p)) {
        break label723;
      }
      this.o.setVisibility(8);
      i1 = 0;
      this.r = ((Button)this.d.findViewById(R.id.button2));
      this.r.setOnClickListener(this.a);
      if (!TextUtils.isEmpty(this.s)) {
        break label747;
      }
      this.r.setVisibility(8);
      this.u = ((Button)this.d.findViewById(R.id.button3));
      this.u.setOnClickListener(this.a);
      if (!TextUtils.isEmpty(this.v)) {
        break label773;
      }
      this.u.setVisibility(8);
      if (i1 != 1) {
        break label799;
      }
      a(this.o);
      if (this.o.getVisibility() != 0) {
        break label829;
      }
      i2 = 1;
      if (this.r.getVisibility() != 0) {
        break label834;
      }
      i3 = 1;
      if (this.u.getVisibility() != 0) {
        break label839;
      }
      i4 = 1;
      if (this.n != null)
      {
        if ((i2 == 0) || (i3 == 0) || (i4 != 0)) {
          break label845;
        }
        this.n.setVisibility(0);
      }
      if (i1 == 0) {
        break label857;
      }
      i1 = 1;
      localObject3 = (LinearLayout)this.d.findViewById(R.id.topPanel);
      localObject1 = this.b.obtainStyledAttributes(null, R.styleable.AlertDialog, R.attr.alertDialogStyle, 0);
      if (this.D == null) {
        break label862;
      }
      Object localObject2 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout)localObject3).addView(this.D, 0, (ViewGroup.LayoutParams)localObject2);
      this.d.findViewById(R.id.title_template).setVisibility(8);
      i2 = i5;
      label454:
      localObject2 = this.d.findViewById(R.id.buttonPanel);
      if (i1 == 0) {
        ((View)localObject2).setVisibility(8);
      }
      if (this.h == null) {
        break label1069;
      }
      localObject2 = (FrameLayout)this.d.findViewById(R.id.customPanel);
      localObject3 = (FrameLayout)this.d.findViewById(16908331);
      ((FrameLayout)localObject3).addView(this.h, new ViewGroup.LayoutParams(-1, -1));
      if (this.m) {
        ((FrameLayout)localObject3).setPadding(this.i, this.j, this.k, this.l);
      }
      if (this.g != null) {
        ((LinearLayout.LayoutParams)((FrameLayout)localObject2).getLayoutParams()).weight = 0.0F;
      }
      label579:
      if ((i2 != 0) && (this.g != null)) {
        this.d.findViewById(R.id.top_divider).setVisibility(0);
      }
      if (i1 == 0) {
        break label1087;
      }
      if (this.g != null) {
        this.d.findViewById(R.id.bottom_divider).setVisibility(0);
      }
    }
    for (;;)
    {
      ((TypedArray)localObject1).recycle();
      return;
      this.C.setVisibility(8);
      this.x.removeView(this.C);
      if (this.g != null)
      {
        ((LinearLayout)localObject1).removeView(this.d.findViewById(R.id.scrollView));
        ((LinearLayout)localObject1).addView(this.g, new LinearLayout.LayoutParams(-1, -1));
        ((LinearLayout)localObject1).setLayoutParams(new LinearLayout.LayoutParams(-1, 0, 1.0F));
        break;
      }
      ((LinearLayout)localObject1).setVisibility(8);
      break;
      label723:
      this.o.setText(this.p);
      this.o.setVisibility(0);
      i1 = 1;
      break label196;
      label747:
      this.r.setText(this.s);
      this.r.setVisibility(0);
      i1 |= 0x2;
      break label243;
      label773:
      this.u.setText(this.v);
      this.u.setVisibility(0);
      i1 |= 0x4;
      break label290;
      label799:
      if (i1 == 2)
      {
        a(this.u);
        break label302;
      }
      if (i1 != 4) {
        break label302;
      }
      a(this.u);
      break label302;
      label829:
      i2 = 0;
      break label314;
      label834:
      i3 = 0;
      break label326;
      label839:
      i4 = 0;
      break label339;
      label845:
      this.n.setVisibility(8);
      break label367;
      label857:
      i1 = 0;
      break label373;
      label862:
      if (!TextUtils.isEmpty(this.e)) {}
      for (i2 = 1;; i2 = 0)
      {
        this.A = ((ImageView)this.d.findViewById(R.id.icon));
        if (i2 == 0) {
          break label1033;
        }
        this.B = ((TextView)this.d.findViewById(R.id.alertTitle));
        a(this.e);
        if (this.y <= 0) {
          break label949;
        }
        this.A.setImageResource(this.y);
        i2 = i5;
        break;
      }
      label949:
      if (this.z != null)
      {
        this.A.setImageDrawable(this.z);
        i2 = i5;
        break label454;
      }
      i2 = i5;
      if (this.y != 0) {
        break label454;
      }
      this.B.setPadding(this.A.getPaddingLeft(), this.A.getPaddingTop(), this.A.getPaddingRight(), this.A.getPaddingBottom());
      this.A.setVisibility(8);
      i2 = i5;
      break label454;
      label1033:
      this.d.findViewById(R.id.title_template).setVisibility(8);
      this.A.setVisibility(8);
      ((LinearLayout)localObject3).setVisibility(8);
      i2 = 0;
      break label454;
      label1069:
      this.d.findViewById(R.id.customPanel).setVisibility(8);
      break label579;
      label1087:
      this.d.findViewById(R.id.bottom_divider).setVisibility(8);
    }
  }
  
  public final void a(int paramInt)
  {
    this.y = paramInt;
    if (this.A != null)
    {
      if (paramInt <= 0) {
        break label28;
      }
      this.A.setImageResource(this.y);
    }
    for (;;)
    {
      return;
      label28:
      if (paramInt == 0) {
        this.A.setVisibility(8);
      }
    }
  }
  
  public final void a(int paramInt, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener, Message paramMessage)
  {
    if (paramOnClickListener != null) {
      paramMessage = this.M.obtainMessage(paramInt, paramOnClickListener);
    }
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Button does not exist");
    case -1: 
      this.p = paramCharSequence;
      this.q = paramMessage;
    }
    for (;;)
    {
      return;
      this.s = paramCharSequence;
      this.t = paramMessage;
      continue;
      this.v = paramCharSequence;
      this.w = paramMessage;
    }
  }
  
  public final void a(Drawable paramDrawable)
  {
    this.z = paramDrawable;
    if ((this.A != null) && (this.z != null)) {
      this.A.setImageDrawable(paramDrawable);
    }
  }
  
  public final void a(View paramView)
  {
    this.D = paramView;
  }
  
  public final void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.h = paramView;
    this.m = true;
    this.i = paramInt1;
    this.j = paramInt2;
    this.k = paramInt3;
    this.l = paramInt4;
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.e = paramCharSequence;
    if (this.B != null)
    {
      if ((paramCharSequence != null) && (paramCharSequence.toString().contains("\n")))
      {
        LinearLayout localLinearLayout = (LinearLayout)this.d.findViewById(R.id.topPanel);
        ViewGroup.LayoutParams localLayoutParams = localLinearLayout.getLayoutParams();
        localLayoutParams.height = this.b.getResources().getDimensionPixelSize(R.dimen.framework_alert_dialog_title_two_lines_height);
        localLinearLayout.setLayoutParams(localLayoutParams);
      }
      this.B.setText(paramCharSequence);
    }
  }
  
  public final boolean a(KeyEvent paramKeyEvent)
  {
    if ((this.x != null) && (this.x.executeKeyEvent(paramKeyEvent))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final int b(int paramInt)
  {
    TypedValue localTypedValue = new TypedValue();
    this.b.getTheme().resolveAttribute(paramInt, localTypedValue, true);
    return localTypedValue.resourceId;
  }
  
  public final void b()
  {
    this.E = true;
  }
  
  public final void b(View paramView)
  {
    this.h = paramView;
    this.m = false;
  }
  
  public final void b(CharSequence paramCharSequence)
  {
    this.f = paramCharSequence;
    if (this.C != null) {
      this.C.setText(paramCharSequence);
    }
  }
  
  public final boolean b(KeyEvent paramKeyEvent)
  {
    if ((this.x != null) && (this.x.executeKeyEvent(paramKeyEvent))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final Button c()
  {
    return this.o;
  }
  
  public static final class a
  {
    public boolean A = false;
    public boolean[] B;
    public boolean C;
    public boolean D;
    public int E = -1;
    public DialogInterface.OnMultiChoiceClickListener F;
    public Cursor G;
    public String H;
    public String I;
    public boolean J;
    public AdapterView.OnItemSelectedListener K;
    public boolean L = true;
    public final Context a;
    public final LayoutInflater b;
    public int c = 0;
    public Drawable d;
    public int e = 0;
    public CharSequence f;
    public View g;
    public CharSequence h;
    public CharSequence i;
    public DialogInterface.OnClickListener j;
    public CharSequence k;
    public DialogInterface.OnClickListener l;
    public CharSequence m;
    public DialogInterface.OnClickListener n;
    public boolean o;
    public DialogInterface.OnCancelListener p;
    public DialogInterface.OnDismissListener q;
    public DialogInterface.OnKeyListener r;
    public CharSequence[] s;
    public ListAdapter t;
    public DialogInterface.OnClickListener u;
    public View v;
    public int w;
    public int x;
    public int y;
    public int z;
    
    public a(Context paramContext)
    {
      this.a = paramContext;
      this.o = true;
      this.b = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    }
  }
  
  private static final class b
    extends Handler
  {
    private WeakReference<DialogInterface> a;
    
    public b(DialogInterface paramDialogInterface)
    {
      this.a = new WeakReference(paramDialogInterface);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        return;
        ((DialogInterface.OnClickListener)paramMessage.obj).onClick((DialogInterface)this.a.get(), paramMessage.what);
        continue;
        ((DialogInterface)paramMessage.obj).dismiss();
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/app/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */