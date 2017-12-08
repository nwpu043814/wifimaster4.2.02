package ct;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.telephony.CellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import java.util.Iterator;
import java.util.List;

public final class b
  extends PhoneStateListener
{
  volatile boolean a;
  private final bi b;
  private CellInfo c = null;
  private SignalStrength d = null;
  private ServiceState e = null;
  private long f;
  private HandlerThread g;
  private Handler h;
  
  public b(bi parambi)
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
  
  private boolean a(CellInfo paramCellInfo)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramCellInfo == null) {
      bool1 = bool2;
    }
    for (;;)
    {
      return bool1;
      bool1 = bool2;
      if (db.a(paramCellInfo))
      {
        bool1 = bool2;
        if (!db.a(this.c, paramCellInfo)) {
          bool1 = true;
        }
      }
    }
  }
  
  private void c()
  {
    if (!this.a) {}
    label116:
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
            break label116;
          }
          this.f = l;
          ck localck = ck.a(this.b, this.c);
          try
          {
            if ((this.h != null) && (localck != null))
            {
              c localc = new ct/b$c;
              localc.<init>(this.b);
              localc.a(localck);
              this.h.post(localc);
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
    int i = 1;
    if (this.a) {}
    label141:
    label144:
    for (;;)
    {
      return;
      if (this.b != null)
      {
        this.g = new HandlerThread("worker");
        if (this.g == null) {
          break label141;
        }
        this.g.start();
        this.h = new b(this.g.getLooper(), (byte)0);
        this.h.sendEmptyMessageDelayed(0, 3000L);
      }
      for (;;)
      {
        if (i == 0) {
          break label144;
        }
        try
        {
          CellInfo localCellInfo = db.a(this.b);
          if (a(localCellInfo))
          {
            ck localck = ck.a(this.b, localCellInfo);
            if (localck != null)
            {
              this.c = localCellInfo;
              this.b.c(localck);
            }
          }
          a(1281);
          this.a = true;
        }
        catch (Exception localException) {}
        break;
        break;
        i = 0;
      }
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
  
  public final void onCellInfoChanged(List<CellInfo> paramList)
  {
    int k = 1;
    Object localObject = null;
    if (paramList == null)
    {
      b.a.b("TxCellProvider", "onCellInfoChanged: cellinfo list is null ");
      c();
      return;
    }
    Iterator localIterator = paramList.iterator();
    label30:
    if (localIterator.hasNext())
    {
      CellInfo localCellInfo = (CellInfo)localIterator.next();
      if (!localCellInfo.isRegistered()) {
        break label194;
      }
      localObject = localCellInfo;
    }
    label74:
    label80:
    label89:
    label134:
    label139:
    label188:
    label194:
    for (;;)
    {
      break label30;
      int i;
      int j;
      if (localObject == null)
      {
        i = 1;
        if (paramList == null) {
          break label134;
        }
        j = 1;
        if (paramList.size() <= 0) {
          break label139;
        }
        if ((j & i & k) == 0) {
          break label188;
        }
      }
      for (paramList = (CellInfo)paramList.get(0);; paramList = (List<CellInfo>)localObject)
      {
        if (a(paramList))
        {
          this.c = paramList;
          c();
          break;
          i = 0;
          break label74;
          j = 0;
          break label80;
          k = 0;
          break label89;
        }
        localObject = new StringBuilder("onCellInfoChanged: illegal cell or same cell ");
        if (paramList == null) {}
        for (paramList = "null cell";; paramList = paramList.toString())
        {
          b.a.b("TxCellProvider", paramList);
          break;
        }
      }
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
  
  final class b
    extends Handler
  {
    private b(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      if (!b.this.a) {}
      for (;;)
      {
        return;
        sendEmptyMessageDelayed(0, 20000L);
        Object localObject = null;
        TelephonyManager localTelephonyManager = b.a(b.this).a();
        paramMessage = (Message)localObject;
        if (localTelephonyManager != null) {}
        try
        {
          paramMessage = localTelephonyManager.getAllCellInfo();
          b.a(b.this, paramMessage);
        }
        catch (Exception paramMessage)
        {
          for (;;)
          {
            b.a.a("TxCellProvider", "cannot get cell location", paramMessage);
            paramMessage = (Message)localObject;
          }
        }
        catch (Error paramMessage)
        {
          for (;;)
          {
            paramMessage = (Message)localObject;
          }
        }
      }
    }
  }
  
  static final class c
    implements Runnable
  {
    private bi a;
    private ck b;
    
    public c(bi parambi)
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


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */