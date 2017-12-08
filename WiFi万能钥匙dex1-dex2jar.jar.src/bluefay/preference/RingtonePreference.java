package bluefay.preference;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.bluefay.a.e;
import com.bluefay.b.h;
import com.bluefay.framework.R.id;

public class RingtonePreference
  extends Preference
  implements r.b
{
  private int b;
  private boolean c;
  private boolean d;
  private int e;
  
  public RingtonePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842899);
  }
  
  public RingtonePreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Object localObject = e.a("com.android.internal.R$styleable", "RingtonePreference");
    if (localObject == null) {}
    for (;;)
    {
      return;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject, paramInt, 0);
      int j = ((Integer)e.a("com.android.internal.R$styleable", "RingtonePreference_ringtoneType")).intValue();
      int i = ((Integer)e.a("com.android.internal.R$styleable", "RingtonePreference_showDefault")).intValue();
      paramInt = ((Integer)e.a("com.android.internal.R$styleable", "RingtonePreference_showSilent")).intValue();
      this.b = paramContext.getInt(j, 1);
      this.c = paramContext.getBoolean(i, true);
      this.d = paramContext.getBoolean(paramInt, true);
      paramContext.recycle();
    }
  }
  
  private void a(Uri paramUri)
  {
    if (paramUri != null) {}
    for (paramUri = paramUri.toString();; paramUri = "")
    {
      c(paramUri);
      return;
    }
  }
  
  private Uri b()
  {
    Uri localUri = null;
    String str = d(null);
    if (!TextUtils.isEmpty(str)) {
      localUri = Uri.parse(str);
    }
    return localUri;
  }
  
  protected final Object a(TypedArray paramTypedArray, int paramInt)
  {
    return paramTypedArray.getString(paramInt);
  }
  
  protected final void a(View paramView)
  {
    super.a(paramView);
    paramView = paramView.findViewById(R.id.right_value);
    TextView localTextView;
    if (paramView != null)
    {
      localTextView = (TextView)paramView;
      paramView = b();
      h.a("uri:" + paramView, new Object[0]);
      if (paramView != null) {
        break label63;
      }
      paramView = "<unset>";
    }
    for (;;)
    {
      localTextView.setText(paramView);
      return;
      label63:
      paramView = RingtoneManager.getRingtone(y(), paramView);
      if (paramView != null) {
        paramView = paramView.getTitle(y());
      } else {
        paramView = null;
      }
    }
  }
  
  protected final void a(r paramr)
  {
    super.a(paramr);
    paramr.a(this);
    this.e = paramr.j();
  }
  
  protected final void a(boolean paramBoolean, Object paramObject)
  {
    paramObject = (String)paramObject;
    if (paramBoolean) {}
    for (;;)
    {
      return;
      if (!TextUtils.isEmpty((CharSequence)paramObject)) {
        a(Uri.parse((String)paramObject));
      }
    }
  }
  
  public final boolean a(int paramInt, Intent paramIntent)
  {
    boolean bool = false;
    h.a("ringtone onActivityResult:" + paramInt, new Object[0]);
    if (paramInt == this.e)
    {
      if (paramIntent != null)
      {
        paramIntent = (Uri)paramIntent.getParcelableExtra("android.intent.extra.ringtone.PICKED_URI");
        if (paramIntent != null) {
          paramIntent.toString();
        }
        if (x()) {
          a(paramIntent);
        }
      }
      bool = true;
    }
    return bool;
  }
  
  protected final void d()
  {
    Intent localIntent = new Intent("android.intent.action.RINGTONE_PICKER");
    localIntent.putExtra("android.intent.extra.ringtone.EXISTING_URI", b());
    localIntent.putExtra("android.intent.extra.ringtone.SHOW_DEFAULT", this.c);
    if (this.c) {
      localIntent.putExtra("android.intent.extra.ringtone.DEFAULT_URI", RingtoneManager.getDefaultUri(this.b));
    }
    localIntent.putExtra("android.intent.extra.ringtone.SHOW_SILENT", this.d);
    localIntent.putExtra("android.intent.extra.ringtone.TYPE", this.b);
    localIntent.putExtra("android.intent.extra.ringtone.TITLE", r());
    PreferenceFragment localPreferenceFragment = B().a();
    if (localPreferenceFragment != null) {
      localPreferenceFragment.startActivityForResult(localIntent, this.e);
    }
    for (;;)
    {
      return;
      B().g().startActivityForResult(localIntent, this.e);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/RingtonePreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */