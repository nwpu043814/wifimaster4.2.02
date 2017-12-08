package ct;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;

public final class bv
  extends PhoneStateListener
{
  volatile boolean a;
  private final bi b;
  private CellLocation c = null;
  private SignalStrength d = null;
  private ServiceState e = null;
  private long f;
  private HandlerThread g;
  private Handler h;
  
  public bv(bi parambi)
  {
    this.b = parambi;
  }
  
  private void a(int paramInt)
  {
    TelephonyManager localTelephonyManager = this.b.a();
    try
    {
      localTelephonyManager.listen(this, paramInt);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        b.a.a("TxCellProvider", "listenCellState: failed! flags=" + paramInt, localException);
      }
    }
  }
  
  private boolean a(CellLocation paramCellLocation)
  {
    boolean bool;
    if (paramCellLocation == null) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      try
      {
        GsmCellLocation localGsmCellLocation = (GsmCellLocation)paramCellLocation;
        if (localGsmCellLocation.getCid() == 0)
        {
          int i = localGsmCellLocation.getLac();
          if (i == 0) {
            bool = false;
          }
        }
      }
      catch (ClassCastException localClassCastException)
      {
        if (db.a(paramCellLocation) < 0)
        {
          bool = false;
        }
        else if (db.a(this.c, paramCellLocation))
        {
          bool = false;
        }
        else
        {
          paramCellLocation = ck.a(this.b, paramCellLocation, null);
          if (paramCellLocation == null) {}
          for (bool = true;; bool = db.a(paramCellLocation))
          {
            if (!bool) {
              break label100;
            }
            bool = true;
            break;
          }
          label100:
          bool = false;
        }
      }
    }
  }
  
  private void c()
  {
    if (!this.a) {}
    label120:
    for (;;)
    {
      return;
      if (this.c != null)
      {
        long l = System.currentTimeMillis();
        if (l - this.f > 2000L) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0) {
            break label120;
          }
          this.f = l;
          ck localck = ck.a(this.b, this.c, this.d);
          try
          {
            if ((this.h != null) && (localck != null))
            {
              b localb = new ct/bv$b;
              localb.<init>(this.b);
              localb.a(localck);
              this.h.post(localb);
            }
            break;
          }
          finally {}
        }
      }
    }
  }
  
  public final void a()
  {
    if (this.a) {}
    for (;;)
    {
      return;
      this.a = true;
      this.g = new HandlerThread("worker");
      this.g.start();
      this.h = new a(this.g.getLooper(), (byte)0);
      this.h.sendEmptyMessageDelayed(0, 3000L);
      CellLocation localCellLocation = db.b(this.b);
      if (a(localCellLocation))
      {
        ck localck = ck.a(this.b, localCellLocation, null);
        if (localck != null)
        {
          this.c = localCellLocation;
          this.b.c(localck);
        }
      }
      a(273);
      b.a.a("TxCellProvider", "startup: state=[start]");
    }
  }
  
  public final void b()
  {
    if (!this.a) {}
    for (;;)
    {
      return;
      this.a = false;
      a(0);
      try
      {
        if (this.h != null)
        {
          this.h.removeCallbacksAndMessages(null);
          this.h = null;
        }
        this.g.quit();
        this.g = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = 0L;
        b.a.a("TxCellProvider", "shutdown: state=[shutdown]");
      }
      finally {}
    }
  }
  
  public final void onCellLocationChanged(CellLocation paramCellLocation)
  {
    super.onCellLocationChanged(paramCellLocation);
    if (a(paramCellLocation))
    {
      this.c = paramCellLocation;
      c();
    }
    for (;;)
    {
      return;
      b.a.b("TxCellProvider", "onCellLocationChanged: illegal cell or same cell " + paramCellLocation);
    }
  }
  
  public final void onServiceStateChanged(ServiceState paramServiceState)
  {
    int j = 1;
    super.onServiceStateChanged(paramServiceState);
    if (paramServiceState == null) {}
    do
    {
      ServiceState localServiceState;
      do
      {
        return;
        localServiceState = this.e;
      } while ((localServiceState != null) && (localServiceState.getState() == paramServiceState.getState()));
      this.e = paramServiceState;
    } while (!this.a);
    int i;
    label66:
    boolean bool;
    if (this.e != null) {
      if (this.e.getState() == 0)
      {
        i = 1;
        paramServiceState = this.b.a();
        bool = db.a(this.b.a);
        if (paramServiceState == null) {
          break label173;
        }
        if (paramServiceState.getSimState() != 5) {
          break label168;
        }
      }
    }
    for (;;)
    {
      if ((bool) || (j == 0)) {
        i = 0;
      }
      paramServiceState = new Message();
      paramServiceState.what = 12999;
      paramServiceState.arg1 = 12003;
      paramServiceState.arg2 = i;
      this.b.c(paramServiceState);
      break;
      if (this.e.getState() == 1)
      {
        i = 0;
        break label66;
      }
      i = -1;
      break label66;
      label168:
      j = 0;
      continue;
      label173:
      j = 0;
    }
  }
  
  public final void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
  {
    super.onSignalStrengthsChanged(paramSignalStrength);
    if (paramSignalStrength == null) {}
    for (;;)
    {
      return;
      SignalStrength localSignalStrength = this.d;
      int i = this.b.h().b;
      if ((localSignalStrength == null) || (db.a(i, localSignalStrength, paramSignalStrength)))
      {
        this.d = paramSignalStrength;
        c();
      }
    }
  }
  
  final class a
    extends Handler
  {
    private a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if (!bv.this.a) {}
      for (;;)
      {
        return;
        sendEmptyMessageDelayed(0, 20000L);
        paramMessage = db.b(bv.a(bv.this));
        bv.a(bv.this, paramMessage);
      }
    }
  }
  
  static final class b
    implements Runnable
  {
    private bi a;
    private ck b;
    
    public b(bi parambi)
    {
      this.a = parambi;
    }
    
    public final void a(ck paramck)
    {
      this.b = paramck;
    }
    
    public final void run()
    {
      bi localbi = this.a;
      ck localck = this.b;
      if (localck != null)
      {
        localck.a(db.c(localbi));
        localbi.c(localck);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/bv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */