package bluefay.preference;

import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.TypedArray;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.provider.Settings.System;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.Window;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import com.bluefay.a.e;
import com.bluefay.b.h;
import com.bluefay.framework.R.id;

public class VolumePreference
  extends SeekBarDialogPreference
  implements View.OnKeyListener, r.c
{
  private int b;
  private a c;
  
  public VolumePreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    Object localObject = e.a("com.android.internal.R$styleable", "VolumePreference");
    if (localObject == null) {}
    for (;;)
    {
      return;
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, (int[])localObject, 0, 0);
      this.b = paramContext.getInt(((Integer)e.a("com.android.internal.R$styleable", "VolumePreference_streamType")).intValue(), 0);
      paramContext.recycle();
    }
  }
  
  protected final void a(Parcelable paramParcelable)
  {
    if ((paramParcelable == null) || (!paramParcelable.getClass().equals(SavedState.class))) {
      super.a(paramParcelable);
    }
    for (;;)
    {
      return;
      paramParcelable = (SavedState)paramParcelable;
      super.a(paramParcelable.getSuperState());
      if (this.c != null) {
        this.c.b(paramParcelable.a);
      }
    }
  }
  
  protected final void a(a parama)
  {
    if ((this.c != null) && (parama != this.c)) {
      this.c.c();
    }
  }
  
  protected final void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if ((!paramBoolean) && (this.c != null)) {
      this.c.b();
    }
    B().b(this);
    if (this.c != null)
    {
      Object localObject = f();
      if ((localObject != null) && (((Dialog)localObject).isShowing()))
      {
        localObject = ((Dialog)localObject).getWindow().getDecorView().findViewById(R.id.seekbar);
        if (localObject != null) {
          ((View)localObject).setOnKeyListener(null);
        }
        this.c.b();
      }
      this.c.a();
      this.c = null;
    }
  }
  
  public final void a_()
  {
    if (this.c != null) {
      a.a(this.c);
    }
  }
  
  protected final void b(View paramView)
  {
    super.b(paramView);
    SeekBar localSeekBar = (SeekBar)paramView.findViewById(R.id.seekbar);
    this.c = new a(y(), localSeekBar, this.b);
    B().a(this);
    paramView.setOnKeyListener(this);
    paramView.setFocusableInTouchMode(true);
    paramView.requestFocus();
  }
  
  protected final Parcelable h()
  {
    Object localObject = super.h();
    if (w()) {}
    for (;;)
    {
      return (Parcelable)localObject;
      localObject = new SavedState((Parcelable)localObject);
      if (this.c != null) {
        this.c.a(((SavedState)localObject).a);
      }
    }
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool2 = true;
    boolean bool1;
    if (this.c == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      label14:
      return bool1;
      if (paramKeyEvent.getAction() == 0) {}
      for (int i = 1;; i = 0) {
        switch (paramInt)
        {
        default: 
          bool1 = false;
          break label14;
        }
      }
      bool1 = bool2;
      if (i != 0)
      {
        this.c.a(-1);
        bool1 = bool2;
        continue;
        bool1 = bool2;
        if (i != 0)
        {
          this.c.a(1);
          bool1 = bool2;
          continue;
          bool1 = bool2;
          if (i != 0)
          {
            this.c.d();
            bool1 = bool2;
          }
        }
      }
    }
  }
  
  private static class SavedState
    extends Preference.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new v();
    VolumePreference.b a = new VolumePreference.b();
    
    public SavedState(Parcel paramParcel)
    {
      super();
      this.a.a = paramParcel.readInt();
      this.a.b = paramParcel.readInt();
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.a.a);
      paramParcel.writeInt(this.a.b);
    }
  }
  
  public final class a
    implements Handler.Callback, SeekBar.OnSeekBarChangeListener
  {
    private Context b;
    private Handler c;
    private AudioManager d;
    private int e;
    private int f;
    private Ringtone g;
    private int h = -1;
    private SeekBar i;
    private int j = -1;
    private ContentObserver k = new w(this, this.c);
    
    public a(Context paramContext, SeekBar paramSeekBar, int paramInt)
    {
      this(paramContext, paramSeekBar, paramInt, (byte)0);
    }
    
    private a(Context paramContext, SeekBar paramSeekBar, int paramInt, byte paramByte)
    {
      this.b = paramContext;
      this.d = ((AudioManager)paramContext.getSystemService("audio"));
      this.e = paramInt;
      this.i = paramSeekBar;
      this$1 = new HandlerThread("VolumePreference.CallbackHandler");
      VolumePreference.this.start();
      this.c = new Handler(VolumePreference.this.getLooper(), this);
      paramSeekBar.setMax(this.d.getStreamMaxVolume(this.e));
      this.f = this.d.getStreamVolume(this.e);
      paramSeekBar.setProgress(this.f);
      paramSeekBar.setOnSeekBarChangeListener(this);
      this.b.getContentResolver().registerContentObserver(Settings.System.getUriFor(Settings.System.VOLUME_SETTINGS[this.e]), false, this.k);
      if (this.e == 2) {
        this$1 = Settings.System.DEFAULT_RINGTONE_URI;
      }
      for (;;)
      {
        this.g = RingtoneManager.getRingtone(this.b, VolumePreference.this);
        if (this.g != null) {
          this.g.setStreamType(this.e);
        }
        return;
        if (this.e == 5) {
          this$1 = Settings.System.DEFAULT_NOTIFICATION_URI;
        } else {
          this$1 = Settings.System.DEFAULT_ALARM_ALERT_URI;
        }
      }
    }
    
    private void b(int paramInt)
    {
      this.h = paramInt;
      this.c.removeMessages(0);
      this.c.sendMessage(this.c.obtainMessage(0));
    }
    
    private void e()
    {
      this.c.removeMessages(1);
      Handler localHandler = this.c;
      Message localMessage = this.c.obtainMessage(1);
      if (g()) {}
      for (long l = 1000L;; l = 0L)
      {
        localHandler.sendMessageDelayed(localMessage, l);
        return;
      }
    }
    
    private void f()
    {
      this.c.removeMessages(1);
      this.c.removeMessages(2);
      this.c.sendMessage(this.c.obtainMessage(2));
    }
    
    private boolean g()
    {
      if ((this.g != null) && (this.g.isPlaying())) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public final void a()
    {
      f();
      this.b.getContentResolver().unregisterContentObserver(this.k);
      this.i.setOnSeekBarChangeListener(null);
    }
    
    public final void a(int paramInt)
    {
      this.i.incrementProgressBy(paramInt);
      b(this.i.getProgress());
      e();
      this.j = -1;
    }
    
    public final void a(VolumePreference.b paramb)
    {
      if (this.h >= 0)
      {
        paramb.a = this.h;
        paramb.b = this.f;
      }
    }
    
    public final void b()
    {
      this.d.setStreamVolume(this.e, this.f, 0);
    }
    
    public final void b(VolumePreference.b paramb)
    {
      if (paramb.a != -1)
      {
        this.f = paramb.b;
        this.h = paramb.a;
        b(this.h);
      }
    }
    
    public final void c()
    {
      f();
    }
    
    public final void d()
    {
      if (this.j != -1)
      {
        this.i.setProgress(this.j);
        b(this.j);
        e();
        this.j = -1;
      }
      for (;;)
      {
        return;
        this.j = this.i.getProgress();
        this.i.setProgress(0);
        f();
        b(0);
      }
    }
    
    public final boolean handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        h.c("invalid SeekBarVolumizer message: " + paramMessage.what);
      }
      for (;;)
      {
        return true;
        this.d.setStreamVolume(this.e, this.h, 0);
        continue;
        if (!g())
        {
          VolumePreference.this.a(this);
          if (this.g != null)
          {
            this.g.play();
            continue;
            if (this.g != null) {
              this.g.stop();
            }
          }
        }
      }
    }
    
    public final void onProgressChanged(SeekBar paramSeekBar, int paramInt, boolean paramBoolean)
    {
      if (!paramBoolean) {}
      for (;;)
      {
        return;
        b(paramInt);
      }
    }
    
    public final void onStartTrackingTouch(SeekBar paramSeekBar) {}
    
    public final void onStopTrackingTouch(SeekBar paramSeekBar)
    {
      e();
    }
  }
  
  public static final class b
  {
    public int a = -1;
    public int b = -1;
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/bluefay/preference/VolumePreference.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */