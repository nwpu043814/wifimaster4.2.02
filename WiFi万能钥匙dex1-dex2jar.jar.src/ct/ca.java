package ct;

import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.map.geolocation.TencentDistanceAnalysis;
import com.tencent.map.geolocation.TencentDistanceListener;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationManagerOptions;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.tencentmap.lbssdk.service.e;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import org.eclipse.jdt.annotation.Nullable;
import org.json.JSONException;

public final class ca
{
  private static SparseArray<String> a;
  private final TencentLocationRequest A = TencentLocationRequest.create();
  private da B;
  private double C;
  private double D;
  private da E;
  private int F = 404;
  private final boolean G;
  private String H;
  private boolean I = false;
  private int b = 1;
  private a c;
  private final bv d;
  private final b e;
  private final boolean f;
  private final bz g;
  private final ci h;
  private final bx i;
  private final cc j;
  private final cg k;
  private ch l;
  private final bk m;
  private ck n;
  private co o;
  private cl p;
  private final bi q;
  private TencentLocationListener r;
  private boolean s = false;
  private double t = 0.0D;
  private int u = 0;
  private int v = 0;
  private int w = 0;
  private TencentLocation x;
  private TencentDistanceListener y;
  private final Object z = new Object();
  
  static
  {
    SparseArray localSparseArray = new SparseArray();
    a = localSparseArray;
    localSparseArray.put(0, "OK");
    a.put(1, "ERROR_NETWORK");
    a.put(2, "BAD_JSON");
    a.put(4, "DEFLECT_FAILED");
  }
  
  public ca(bi parambi)
  {
    this.q = parambi;
    if (parambi.h().t) {
      dc.a(parambi.a);
    }
    this.m = bl.b();
    this.j = new cc(this.q);
    this.k = new cg(this.q);
    this.l = new ch();
    this.i = bx.a(parambi.a);
    boolean bool;
    if (Build.VERSION.SDK_INT >= 17) {
      if (db.a(this.q) != null)
      {
        bool = true;
        this.f = bool;
        if (!this.f) {
          break label291;
        }
        this.d = null;
        this.h = g();
        if (this.q.d()) {
          break label276;
        }
        b.a.b("TxLocationManagerImpl", "createNewCellProvider: failed");
      }
    }
    label276:
    for (parambi = null;; parambi = new b(this.q))
    {
      this.e = parambi;
      localbz = f();
      this.g = localbz;
      this.G = b.a.a(parambi, new Object[] { localbz });
      return;
      b.a.b("TxLocationManagerImpl", "SDK=" + Build.VERSION.SDK_INT + "but get no cell");
      bool = false;
      break;
    }
    label291:
    this.e = null;
    this.h = g();
    if (!this.q.d()) {
      b.a.b("TxLocationManagerImpl", "createCellProvider: failed");
    }
    for (parambi = localbz;; parambi = new bv(this.q))
    {
      this.d = parambi;
      localbz = f();
      this.g = localbz;
      this.G = b.a.a(parambi, new Object[] { localbz });
      break;
    }
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (this.c != null)
    {
      this.c.removeMessages(paramInt);
      this.c.sendEmptyMessageDelayed(paramInt, paramLong);
    }
  }
  
  private void a(int paramInt, da paramda)
  {
    if (paramda == null) {}
    for (;;)
    {
      return;
      if (i())
      {
        this.F = paramInt;
        this.B = paramda;
        if ((paramda.getAccuracy() < 500.0F) && (paramda.getAccuracy() > 0.0F))
        {
          this.l.a(paramda);
          if (this.s) {
            this.x = paramda;
          }
        }
        this.C = paramda.getLatitude();
        this.D = paramda.getLongitude();
        if (this.A.getInterval() > 0L) {
          a(11999, 0L);
        }
      }
      label98:
      while ((paramInt != 0) || (paramda.getLatitude() <= 0.0D) || (paramda.getLongitude() <= 0.0D) || (Math.abs(paramda.getLatitude() - this.C) < 1.0E-7D) || (Math.abs(paramda.getLongitude() - this.D) < 1.0E-7D))
      {
        if ((this.A.getInterval() != 0L) || (!b.a.b(this.r))) {
          break label449;
        }
        b(11998);
        break;
      }
      if (this.l.a(paramda, this.q)) {
        break;
      }
      b.a.a("TxLocationManagerImpl", "discard " + paramda);
    }
    this.C = paramda.getLatitude();
    this.D = paramda.getLongitude();
    if ((paramda.getAccuracy() < 500.0F) && (paramda.getAccuracy() > 0.0F))
    {
      this.l.a(paramda);
      this.l.a(paramda);
      if (this.s)
      {
        if (this.x == null) {
          break label464;
        }
        double d1 = b.a.a(this.x.getLatitude(), this.x.getLongitude(), paramda.getLatitude(), paramda.getLongitude());
        if (((paramda.getProvider().equalsIgnoreCase("network")) && (d1 > 10.0D)) || ((paramda.getProvider().equalsIgnoreCase("gps")) && (d1 > 3.0D)))
        {
          this.t = (d1 + this.t);
          if (!paramda.getProvider().equalsIgnoreCase("network")) {
            break label451;
          }
          this.v += 1;
          label401:
          this.w += 1;
        }
      }
    }
    label449:
    label451:
    label464:
    for (this.x = paramda;; this.x = paramda)
    {
      if (paramda.getProvider().equalsIgnoreCase("network")) {
        da.a(paramda, this.n);
      }
      this.F = paramInt;
      this.B = paramda;
      break label98;
      break;
      this.u += 1;
      break label401;
    }
  }
  
  private final void a(da paramda)
  {
    if (paramda != null)
    {
      if (this.A.isAllowDirection()) {
        paramda.getExtra().putDouble("direction", this.i.c());
      }
      paramda.getExtra().putAll(this.A.getExtras());
    }
  }
  
  private void b(int paramInt)
  {
    if (this.c != null) {
      this.c.sendEmptyMessage(paramInt);
    }
  }
  
  @Nullable
  private bz f()
  {
    if (!this.q.f()) {
      b.a.b("TxLocationManagerImpl", "createGpsProvider: failed");
    }
    for (bz localbz = null;; localbz = new bz(this.q)) {
      return localbz;
    }
  }
  
  @Nullable
  private ci g()
  {
    if (!this.q.e()) {
      b.a.b("TxLocationManagerImpl", "createWifiProvider: failed");
    }
    for (ci localci = null;; localci = new ci(this.q)) {
      return localci;
    }
  }
  
  private void h()
  {
    db.a = false;
    this.q.b(this);
    this.j.b();
    cg localcg = this.k;
    if (localcg.g)
    {
      localcg.g = false;
      localcg.a.clear();
      localcg.a.offer(cg.a.d);
      if (localcg.f != 0L)
      {
        long l2 = SystemClock.elapsedRealtime();
        long l1 = localcg.f;
        b.a.a("TxRequestSender", String.format(Locale.ENGLISH, "shutdown: duration=%ds, sent=%dB, recv=%dB, reqCount=%d", new Object[] { Long.valueOf((l2 - l1) / 1000L), Long.valueOf(localcg.d), Long.valueOf(localcg.e), Long.valueOf(localcg.c) }));
      }
      localcg.c = 0L;
      localcg.d = 0L;
      localcg.e = 0L;
      localcg.f = 0L;
    }
    this.l.a();
    if (b.a.b(this.h)) {
      this.h.a();
    }
    if (this.f) {
      if (b.a.b(this.e)) {
        this.e.b();
      }
    }
    for (;;)
    {
      if (b.a.b(this.g)) {
        this.g.a();
      }
      if (this.A.isAllowDirection()) {
        this.i.b();
      }
      if (b.a.b(this.c)) {
        this.c.a();
      }
      return;
      if (b.a.b(this.d)) {
        this.d.b();
      }
    }
  }
  
  private boolean i()
  {
    if (this.F == 404) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public final int a(TencentDistanceListener paramTencentDistanceListener)
  {
    int i1 = 1;
    if (this.r == null) {}
    for (;;)
    {
      return i1;
      if (this.s)
      {
        i1 = 2;
      }
      else
      {
        this.s = true;
        this.y = paramTencentDistanceListener;
        i1 = 0;
      }
    }
  }
  
  public final int a(TencentLocationRequest paramTencentLocationRequest, TencentLocationListener paramTencentLocationListener, Looper paramLooper)
  {
    int i2 = 1;
    if (TencentLocationManagerOptions.isLoadLibraryEnabled()) {}
    bj localbj;
    int i1;
    try
    {
      System.loadLibrary("tencentloc");
      localbj = this.q.h();
      str = b.a.b(localbj.h);
      if (!str.contains(",")) {
        break label191;
      }
      ??? = str.split(",");
      if ((??? == null) || (???.length <= 1) || (???[0] == null) || (???[1] == null) || (e.w(???[0], ???[1]) <= 0)) {
        break label177;
      }
      i1 = 1;
    }
    catch (Error paramTencentLocationRequest)
    {
      do
      {
        for (;;)
        {
          String str;
          b.a.a("TencentLocationSDK", "load library", paramTencentLocationRequest);
          i1 = 3;
          continue;
          i1 = 0;
          continue;
          ??? = "";
          continue;
          i1 = e.v(str);
          if (i1 >= 0) {
            ??? = Integer.toString(i1);
          } else {
            ??? = "";
          }
        }
        i1 = i2;
      } while (this.G);
      this.F = 404;
      this.o = null;
      this.n = null;
      this.p = null;
      cm.a = 0;
      this.q.a("cell").a();
    }
    if (i1 != 0)
    {
      ??? = ???[0];
      this.H = ((String)???);
      if (!TextUtils.isEmpty(this.H)) {
        break label221;
      }
      b.a.b("TxLocationManagerImpl", "requestLocationUpdates: illegal key [" + str + "]");
      i1 = 2;
      return i1;
    }
    for (;;)
    {
      label177:
      label191:
      label221:
      boolean bool;
      synchronized (this.z)
      {
        this.r = paramTencentLocationListener;
        TencentLocationRequest.copy(this.A, paramTencentLocationRequest);
        localbj.g = paramTencentLocationRequest.getQQ();
        if (TextUtils.isEmpty(b.a.b(localbj.e))) {
          localbj.e = paramTencentLocationRequest.getPhoneNumber();
        }
        localbj.m = Math.max(8000L, paramTencentLocationRequest.getInterval());
        if (b.a.a(this.c))
        {
          this.c = new a(paramLooper);
          h();
          this.q.a(this);
          bool = this.A.getExtras().getBoolean("use_network", true);
          paramTencentLocationRequest = this.c;
          this.j.a();
          paramTencentLocationListener = this.k;
          if (!paramTencentLocationListener.g)
          {
            paramTencentLocationListener.g = true;
            paramTencentLocationListener.b.j().execute(new cg.1(paramTencentLocationListener, paramTencentLocationRequest));
            paramTencentLocationListener.f = SystemClock.elapsedRealtime();
          }
          if (!this.f) {
            break label639;
          }
          if ((bool) && (b.a.b(this.e))) {
            this.e.a();
          }
          if ((bool) && (b.a.b(this.h)))
          {
            paramTencentLocationListener = this.h;
            this.A.getInterval();
            paramTencentLocationListener.a(paramTencentLocationRequest);
          }
          if (b.a.b(this.g))
          {
            cp.d();
            paramTencentLocationListener = this.g;
            if (this.b != 1) {
              break label664;
            }
            bool = true;
            paramTencentLocationListener.a(bool);
            this.g.a(paramTencentLocationRequest, this.A.getInterval() - 2000L);
          }
          if (this.A.isAllowDirection())
          {
            paramTencentLocationListener = this.i;
            paramTencentLocationRequest.getLooper();
            paramTencentLocationListener.a();
          }
          i1 = 0;
        }
      }
      if (this.c.getLooper() != paramLooper)
      {
        this.c = new a(paramLooper);
        continue;
        label639:
        if ((bool) && (b.a.b(this.d)))
        {
          this.d.a();
          continue;
          label664:
          bool = false;
        }
      }
    }
  }
  
  public final TencentLocation a()
  {
    if (this.F == 0) {
      a(this.B);
    }
    for (da localda = this.B;; localda = null) {
      return localda;
    }
  }
  
  public final void a(int paramInt)
  {
    if (this.b == paramInt) {}
    for (;;)
    {
      return;
      synchronized (this.z)
      {
        if (this.r != null)
        {
          IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
          localIllegalStateException.<init>("removeUpdates MUST called before set coordinate type!");
          throw localIllegalStateException;
        }
      }
      this.b = paramInt;
    }
  }
  
  public final TencentDistanceAnalysis b()
  {
    this.y = null;
    this.t = 0.0D;
    this.s = false;
    this.x = null;
    cv localcv = new cv();
    localcv.a(b.a.a((this.u + 1) / (this.w + 1), 4) * 100.0D);
    localcv.a(this.u);
    localcv.b(this.v);
    this.u = 0;
    this.v = 0;
    this.w = 0;
    return localcv;
  }
  
  public final void c()
  {
    h();
    synchronized (this.z)
    {
      this.r = null;
      this.m.a();
      return;
    }
  }
  
  public final int d()
  {
    return this.b;
  }
  
  public final void onCellInfoEvent(ck paramck)
  {
    int i3 = paramck.e;
    int i4 = paramck.f;
    ck localck = this.n;
    if (localck != null) {}
    for (int i1 = localck.f;; i1 = 0)
    {
      this.n = paramck;
      if (this.h != null) {}
      for (int i2 = this.h.b();; i2 = 1)
      {
        if (i2 != 0) {
          this.o = null;
        }
        boolean bool;
        if (i2 == 0) {
          if (i3 != 0)
          {
            bool = true;
            this.I = bool;
            if (this.c != null)
            {
              paramck = this.c.obtainMessage(3999, "wifi_not_received");
              this.c.sendMessageDelayed(paramck, 5000L);
            }
            label109:
            if (i2 != 0) {
              break label191;
            }
          }
        }
        label191:
        for (paramck = "scan wifi";; paramck = "prepare json. wifi is not scannable?")
        {
          b.a.a("TxLocationManagerImpl", String.format("onCellChanged: %d(%d)-->%d(%d) (%d)%s", new Object[] { Integer.valueOf(0), Integer.valueOf(i1), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i2), paramck }));
          return;
          bool = false;
          break;
          b(3999);
          break label109;
        }
      }
    }
  }
  
  public final void onGpsInfoEvent(cl paramcl)
  {
    double d2 = 0.0D;
    int i2;
    int i1;
    da localda;
    Location localLocation;
    Object localObject;
    double d1;
    if (paramcl.a != bw.b)
    {
      this.p = paramcl;
      by.a().a(paramcl);
      i2 = this.b;
      i1 = this.A.getRequestLevel();
      localda = this.E;
      localLocation = new Location(paramcl.a);
      localObject = localLocation.getExtras();
      if (localObject == null) {
        break label284;
      }
      d1 = ((Bundle)localObject).getDouble("lat");
      d2 = ((Bundle)localObject).getDouble("lng");
    }
    for (;;)
    {
      if (b.a.a(i2))
      {
        localObject = new da.a();
        ((da.a)localObject).b = localda;
        ((da.a)localObject).d = "gps";
        ((da.a)localObject).c = i1;
        paramcl = ((da.a)localObject).a(new Location(paramcl.a)).a();
        localLocation.setLatitude(d1);
        localLocation.setLongitude(d2);
        paramcl.a(localLocation);
        a(0, paramcl);
      }
      for (;;)
      {
        if (this.g != null) {
          this.g.b();
        }
        return;
        if (i()) {
          b(3999);
        }
        localObject = new da.a();
        ((da.a)localObject).b = localda;
        ((da.a)localObject).d = "gps";
        ((da.a)localObject).c = i1;
        paramcl = ((da.a)localObject).a(new Location(paramcl.a)).a();
        localLocation.setLatitude(d1);
        localLocation.setLongitude(d2);
        paramcl.a(localLocation);
        a(0, paramcl);
      }
      label284:
      d1 = 0.0D;
    }
  }
  
  public final void onNetworkEvent(Integer paramInteger)
  {
    String str = b.a.b(this.q.a);
    switch (paramInteger.intValue())
    {
    }
    for (;;)
    {
      return;
      b.a.a("TxLocationManagerImpl", "onNetworkEvent: networks not found");
      continue;
      b.a.a("TxLocationManagerImpl", "onNetworkEvent: " + str + " disconnected");
      continue;
      b.a.a("TxLocationManagerImpl", "onNetworkEvent: " + str + " connected");
      a(7999, 1000L);
    }
  }
  
  public final void onStatusEvent(Message paramMessage)
  {
    int i1 = paramMessage.what;
    int i2 = paramMessage.arg1;
    i1 = paramMessage.arg2;
    String str;
    switch (i2)
    {
    default: 
      str = null;
      paramMessage = null;
    }
    for (;;)
    {
      b.a.a("TxLocationManagerImpl", "onStatusChanged: " + paramMessage);
      synchronized (this.z)
      {
        if (this.r != null) {
          this.r.onStatusUpdate(str, i1, paramMessage);
        }
        return;
        str = "gps";
        if (i1 == 1) {
          paramMessage = "gps enabled";
        }
        for (;;)
        {
          break;
          if (i1 == 0) {
            paramMessage = "gps disabled";
          } else {
            paramMessage = "unknown";
          }
        }
        str = "gps";
        if (i1 == 3) {
          paramMessage = "gps available";
        }
        for (;;)
        {
          break;
          if (i1 == 4) {
            paramMessage = "gps unavailable";
          } else {
            paramMessage = "unknown";
          }
        }
        str = "cell";
        if (i1 == 1) {
          paramMessage = "cell enabled";
        }
        for (;;)
        {
          if (db.a)
          {
            paramMessage = "cell permission denied";
            i1 = 2;
            str = "cell";
            break;
            if (i1 == 0)
            {
              paramMessage = "cell disabled";
            }
            else
            {
              paramMessage = "unknown";
              continue;
              str = "wifi";
              if (i1 == 1) {
                paramMessage = "wifi enabled";
              }
              for (;;)
              {
                if (dh.a)
                {
                  paramMessage = "wifi scan permission denied";
                  i1 = 2;
                  str = "wifi";
                  break;
                  if (i1 == 0) {
                    paramMessage = "wifi disabled";
                  } else {
                    paramMessage = "unknown";
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void onWifiInfoEvent(co paramco)
  {
    if (this.c != null) {
      this.c.removeMessages(3999, "wifi_not_received");
    }
    if (paramco == co.a)
    {
      b.a.a("TxLocationManagerImpl", "onWifiChanged --> clear wifi if needed");
      a(555, 1500L);
    }
    for (;;)
    {
      return;
      if ((this.o == null) || (!this.o.a(System.currentTimeMillis(), 45000L)) || (paramco.a().size() < 3) || (this.I) || (!this.o.a(paramco)))
      {
        this.o = paramco;
        b.a.a("TxLocationManagerImpl", "onWifiChanged: --> prepare json");
        b(3999);
      }
      this.I = false;
    }
  }
  
  final class a
    extends Handler
  {
    private final cb a;
    private int b;
    
    a(Looper paramLooper)
    {
      super();
      ca.a(ca.this);
      this.a = bl.c();
    }
    
    public final void a()
    {
      removeCallbacksAndMessages(null);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      int i;
      for (;;)
      {
        long l;
        synchronized (ca.b(ca.this))
        {
          if (ca.c(ca.this) == null) {
            return;
          }
          localObject1 = ca.c(ca.this);
          ??? = ca.d(ca.this);
          i = ((TencentLocationRequest)???).getRequestLevel();
          l = ((TencentLocationRequest)???).getInterval();
          switch (paramMessage.what)
          {
          default: 
            break;
          case 555: 
            ca.q(ca.this);
            sendEmptyMessage(3999);
          }
        }
        if (ca.e(ca.this) != null)
        {
          ca.a(ca.this, ca.e(ca.this));
          ((TencentLocationListener)localObject1).onLocationChanged(ca.e(ca.this), ca.f(ca.this), (String)ca.e().get(ca.f(ca.this)));
          if ((ca.g(ca.this)) && (ca.h(ca.this) != null)) {
            ca.h(ca.this).onDistanceChanged(ca.e(ca.this), b.a.a(ca.i(ca.this) / 1000.0D, 2), ca.f(ca.this), (String)ca.e().get(ca.f(ca.this)));
          }
        }
        if (l > 0L)
        {
          sendEmptyMessageDelayed(11999, l);
          continue;
          if (ca.e(ca.this) != null)
          {
            ca.a(ca.this, ca.e(ca.this));
            ((TencentLocationListener)localObject1).onLocationChanged(ca.e(ca.this), ca.f(ca.this), (String)ca.e().get(ca.f(ca.this)));
            continue;
            if (!ca.j(ca.this))
            {
              b.a.a("TxLocationManagerImpl", "network connected --> prepare json");
              if (paramMessage.obj != null) {
                b.a.b("TxLocationManagerImpl", "wifi error." + paramMessage.obj.toString());
              }
              int j = ca.k(ca.this);
              paramMessage = ca.l(ca.this);
              localObject1 = paramMessage.a(i, ca.m(ca.this), ca.a(ca.this));
              if (!b.a.c((String)localObject1)) {}
              for (i = 1;; i = 0)
              {
                if (i != 0) {
                  b.a.b("TxLocationManagerImpl", "handleMessage: bad json " + (String)localObject1);
                }
                if (i == 0) {
                  break label582;
                }
                this.b += 1;
                if (this.b < 2) {
                  break;
                }
                b.a.b("TxLocationManagerImpl", "handleMessage: bad json " + (String)localObject1);
                ca.a(ca.this, 2, da.a);
                this.b = 0;
                break;
              }
              label582:
              this.b = 0;
              if (ca.n(ca.this) != null) {
                ca.n(ca.this).b();
              }
              localObject1 = ca.o(ca.this).a((String)localObject1);
              if (localObject1 != "[]")
              {
                cp.c();
                if (cp.a) {
                  if (!b.a.c(ca.a(ca.this).a))
                  {
                    ca.a(ca.this, 1, da.a);
                  }
                  else
                  {
                    ca.p(ca.this).a((String)localObject1, paramMessage, j);
                    ca.o(ca.this);
                    System.currentTimeMillis();
                    continue;
                    paramMessage = new cm(null, null, new cl((Location)paramMessage.obj, System.currentTimeMillis(), 3, 3, 0));
                    localObject1 = paramMessage.a(i, ca.m(ca.this), ca.a(ca.this));
                    ca.p(ca.this).a((String)localObject1, paramMessage, ca.k(ca.this));
                  }
                }
              }
            }
          }
        }
      }
      removeMessages(4998);
      Object localObject1 = (Pair)paramMessage.obj;
      ??? = ((Pair)localObject1).first.toString();
      cg.a locala = (cg.a)((Pair)localObject1).second;
      cm localcm = (cm)locala.a;
      localObject1 = locala.b;
      if (localcm.d()) {
        localObject1 = "gps";
      }
      for (;;)
      {
        try
        {
          da.a locala1 = new ct/da$a;
          locala1.<init>();
          locala1.a = ((String)???);
          locala1.c = i;
          locala1.d = ((String)localObject1);
          localObject1 = locala1.a();
          ((da)localObject1).getExtra().putString("resp_json", (String)???);
          da.a((da)localObject1);
          cp.a();
          ((da)localObject1).getExtra().putInt("wifi_ap_num", ((da)localObject1).a());
          if (localcm.a() == null) {
            break label1131;
          }
          i = localcm.a().c;
          ((da)localObject1).getExtra().putInt("sat_num", i);
          ((da)localObject1).getExtra().putLong("req_cost", paramMessage.arg1);
          ((da)localObject1).getExtra().putLong("req_start", locala.c);
          ca.a(ca.this).a("map").b(((da)localObject1).getExtra());
          if ((ca.n(ca.this) == null) || ((ca.n(ca.this) != null) && (!ca.n(ca.this).b()))) {
            ca.a(ca.this, 0, (da)localObject1);
          }
          ca.b(ca.this, (da)localObject1);
          break;
          localObject1 = "network";
          continue;
        }
        catch (JSONException paramMessage)
        {
          b.a.b("TxLocationManagerImpl", "handleMessage: location failed");
          paramMessage = this.a.e();
          if (paramMessage != bw.b)
          {
            obtainMessage(3998, paramMessage).sendToTarget();
            break;
          }
          ca.a(ca.this, 404, da.a);
        }
        break;
        ca.a(ca.this, 1, da.a);
        break;
        label1131:
        i = 0;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/ca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */