package ct;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.app.PendingIntent.OnFinished;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.map.geolocation.TencentGeofence;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.TencentLocationRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class bq
  extends BroadcastReceiver
  implements PendingIntent.OnFinished, TencentLocationListener
{
  private final Context a;
  private final ca b;
  private final PowerManager.WakeLock c;
  private final PowerManager.WakeLock d;
  private final a e;
  private final c f;
  private b g = new b();
  private boolean h = false;
  private PendingIntent i;
  private final TencentLocationRequest j = TencentLocationRequest.create().setRequestLevel(0).setInterval(0L).setAllowCache(false);
  private double k = 1.0D;
  
  public bq(Context paramContext)
  {
    this(paramContext, Looper.myLooper());
  }
  
  private bq(Context paramContext, Looper paramLooper)
  {
    this.a = paramContext;
    this.b = new ca(bi.a(paramContext));
    paramContext = (PowerManager)this.a.getSystemService("power");
    this.c = paramContext.newWakeLock(1, "GeofenceManager");
    this.d = paramContext.newWakeLock(1, "tencent_location");
    this.d.setReferenceCounted(false);
    this.e = new a(paramLooper);
    this.f = new c((byte)0);
    paramContext = new IntentFilter();
    paramContext.addAction("android.intent.action.SCREEN_ON");
    paramContext.addAction("com.tencent.map.geolocation.wakeup");
    paramContext.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
    paramContext.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    this.a.registerReceiver(this, paramContext, null, this.e);
  }
  
  private PendingIntent a(long paramLong)
  {
    PendingIntent localPendingIntent = null;
    AlarmManager localAlarmManager = (AlarmManager)this.a.getSystemService("alarm");
    if (localAlarmManager == null) {
      return localPendingIntent;
    }
    String str = Build.MANUFACTURER;
    if (str != null) {}
    for (boolean bool = str.toLowerCase(Locale.US).contains("xiaomi");; bool = false)
    {
      if (this.i != null)
      {
        localAlarmManager.cancel(this.i);
        this.i = null;
        if (bool) {
          this.e.removeMessages(2);
        }
      }
      if (paramLong <= 0L) {
        break;
      }
      localPendingIntent = PendingIntent.getBroadcast(this.a, 0, i(), 134217728);
      this.i = localPendingIntent;
      localAlarmManager.setRepeating(2, SystemClock.elapsedRealtime() + paramLong, paramLong, localPendingIntent);
      if (bool) {
        this.e.sendEmptyMessageDelayed(2, 10000L + paramLong);
      }
      b.a.a("log_to_file", "setLocationAlarm: will triggered after " + paramLong + " ms, isXiaomi=" + bool);
      break;
    }
  }
  
  private void a(PendingIntent paramPendingIntent, Intent arg2)
  {
    this.c.acquire();
    try
    {
      paramPendingIntent.send(this.a, 0, ???, this, null);
      return;
    }
    catch (PendingIntent.CanceledException ???)
    {
      for (;;)
      {
        b.a.a("GeofenceManager", "removeFence: fence=" + null + ", intent=" + paramPendingIntent);
        synchronized (this.g)
        {
          Iterator localIterator = this.g.a.iterator();
          while (localIterator.hasNext()) {
            if (((bp)localIterator.next()).d.equals(paramPendingIntent)) {
              localIterator.remove();
            }
          }
        }
        d("_removeFence: --> schedule update fence");
        this.c.release();
      }
    }
  }
  
  private void a(boolean paramBoolean)
  {
    LinkedList localLinkedList = new LinkedList();
    Object localObject3 = new LinkedList();
    Object localObject4;
    Object localObject5;
    Object localObject6;
    boolean bool;
    double d1;
    double d2;
    long l1;
    long l2;
    for (;;)
    {
      bp localbp;
      double d3;
      int n;
      synchronized (this.g)
      {
        this.g.e = false;
        g();
        localObject4 = h();
        localObject5 = new java/lang/StringBuilder;
        ((StringBuilder)localObject5).<init>("updateFences: fresh_location=");
        b.a.a("log_to_file", localObject4);
        localObject6 = new java/util/ArrayList;
        ((ArrayList)localObject6).<init>();
        localObject5 = this.g.a;
        if (!((List)localObject5).isEmpty())
        {
          bool = true;
          if (localObject4 == null) {
            break label1462;
          }
          b.a.a((Location)localObject4);
          Iterator localIterator = ((List)localObject5).iterator();
          d1 = Double.MAX_VALUE;
          if (!localIterator.hasNext()) {
            break;
          }
          localbp = (bp)localIterator.next();
          if (localObject4 == localbp.g) {
            break label553;
          }
          localbp.g = localObject4;
          d2 = localbp.f;
          d3 = b.a.a(((Location)localObject4).getLatitude(), ((Location)localObject4).getLongitude(), localbp.b.getLatitude(), localbp.b.getLongitude());
          l1 = localbp.b.getTime();
          l2 = ((Location)localObject4).getTime();
          if (l1 == 0L) {
            break label521;
          }
          if (d3 < d2) {
            break label462;
          }
          d2 = 0.0D;
          f1 = (float)d2;
          localbp.b.setTime(l2);
          localbp.b.setSpeed(f1);
          localbp.f = d3;
          n = localbp.e;
          if (localbp.f > localbp.a.getRadius()) {
            break label529;
          }
          m = 1;
          if (m == 0) {
            break label535;
          }
          localbp.e = 1;
          if (n == 1) {
            break label553;
          }
          m = 1;
          if ((m & 0x1) != 0) {
            localLinkedList.add(localbp.d);
          }
          if ((m & 0x2) != 0) {
            ((List)localObject3).add(localbp.d);
          }
          if (Double.compare(localbp.f, Double.MAX_VALUE) != 0) {
            break label559;
          }
          d2 = Double.MAX_VALUE;
          d3 = d1;
          if (d2 < d1) {
            d3 = d2;
          }
          if ((localbp.e == 1) || (localbp.b.getSpeed() < 0.0F)) {
            break label582;
          }
          m = 1;
          d1 = d3;
          if (m == 0) {
            continue;
          }
          ((List)localObject6).add(Float.valueOf(localbp.a()));
          d1 = d3;
        }
      }
      bool = false;
      continue;
      label462:
      if (d3 < d2)
      {
        l1 = Math.abs(l2 - l1) / 1000L;
        d2 = Math.abs(d2 - d3);
        if (l1 != 0L) {}
        for (;;)
        {
          d2 /= l1;
          break;
          l1 += 1L;
        }
      }
      label521:
      d2 = -0.0010000000474974513D;
      continue;
      label529:
      int m = 0;
      continue;
      label535:
      localbp.e = 2;
      if (n == 1)
      {
        m = 2;
      }
      else
      {
        label553:
        m = 0;
        continue;
        label559:
        d2 = Math.abs(localbp.a.getRadius() - localbp.f);
        continue;
        label582:
        m = 0;
      }
    }
    float f1 = 25.0F;
    if (((List)localObject6).size() > 0)
    {
      Collections.sort((List)localObject6);
      Collections.reverse((List)localObject6);
      f1 = ((Float)((List)localObject6).get(0)).floatValue();
    }
    if (this.g.f[0] > 0.0F)
    {
      localObject6 = this.g.f;
      localObject6[0] = (f1 + localObject6[0]);
      localObject6 = this.g.f;
      localObject6[0] = ((float)(localObject6[0] * 0.5D));
      d2 = d1;
    }
    for (;;)
    {
      float f2;
      if (bool)
      {
        f1 = 25.0F;
        if (dh.a(bi.a(this.a)))
        {
          f1 = 15.0F;
          f2 = 1.0F;
          label720:
          float f3 = this.g.f[0];
          if (f3 < f2) {
            break label1144;
          }
          d1 = Math.min(Math.max(f2, f3), 10.0F + f1);
          d1 = (f1 + f2) * 0.1D + d1 * 0.8D;
          if (d1 >= f2) {
            break label1141;
          }
          d1 = f2;
          label786:
          if ((localObject4 == null) || (Double.compare(d2, Double.MAX_VALUE) == 0)) {
            break label1172;
          }
          l2 = Math.min(900000.0D, Math.max(60000.0D, 1000.0D * d2 / d1));
          l1 = l2;
          if (d2 < 1000.0D)
          {
            l1 = l2;
            if (l2 > 305000L) {
              l1 = 305000L;
            }
          }
          label856:
          if ((d1 >= 5.0D) || (d2 <= 800.0D)) {
            break label1180;
          }
          this.k *= 1.02D;
          l2 = (2.0D * this.k * 60000.0D);
          l1 = l2;
          if (l2 > 305000L) {
            l1 = 305000L;
          }
          label918:
          this.g.c = l1;
          if ((!paramBoolean) || (localObject4 != null)) {
            break label1188;
          }
          paramBoolean = true;
          label938:
          b.a.a("log_to_file", String.format(Locale.getDefault(), "updateFences: needUpdates=%s, interval=%d, minDist=%5g, speed=%.2f, reschedule=%s, rate=%.2f", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1), Double.valueOf(d2), Double.valueOf(d1), Boolean.valueOf(paramBoolean), Double.valueOf(this.k) }));
          if (this.g.b) {
            break label1193;
          }
          this.g.b = true;
          this.d.acquire(12000L);
          this.b.a(this.j, this, this.e.getLooper());
        }
      }
      for (;;)
      {
        localObject4 = new java/util/HashMap;
        ((HashMap)localObject4).<init>();
        localObject5 = ((List)localObject5).iterator();
        while (((Iterator)localObject5).hasNext())
        {
          localObject6 = (bp)((Iterator)localObject5).next();
          ((HashMap)localObject4).put(((bp)localObject6).a.getTag(), ((bp)localObject6).toString());
        }
        this.g.f[0] = f1;
        d2 = d1;
        break;
        f2 = 3.0F;
        break label720;
        label1141:
        break label786;
        label1144:
        if (b.a.a(this.a))
        {
          d1 = f1 * 0.3D;
          break label786;
        }
        d1 = f1;
        break label786;
        label1172:
        l1 = 60000L;
        break label856;
        label1180:
        this.k = 1.0D;
        break label918;
        label1188:
        paramBoolean = false;
        break label938;
        label1193:
        if (paramBoolean)
        {
          a(-1L);
          this.g.b = true;
          this.d.acquire(12000L);
          this.b.a(this.j, this, this.e.getLooper());
          continue;
          if (this.g.b)
          {
            this.g.b = false;
            f();
            e();
          }
        }
      }
      this.f.a.add(localObject4);
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (PendingIntent)((Iterator)localObject3).next();
        b.a.a("GeofenceManager", "sendIntentExit: pendingIntent=" + localObject4);
        ??? = new Intent();
        ((Intent)???).putExtra("entering", false);
        a((PendingIntent)localObject4, (Intent)???);
      }
      localObject3 = ((List)localObject1).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ??? = (PendingIntent)((Iterator)localObject3).next();
        b.a.a("GeofenceManager", "sendIntentEnter: pendingIntent=" + ???);
        Intent localIntent = new Intent();
        localIntent.putExtra("entering", true);
        a((PendingIntent)???, localIntent);
      }
      return;
      label1462:
      d2 = Double.MAX_VALUE;
    }
  }
  
  private void c(String paramString)
  {
    if (!b.a.c(this.a)) {
      b.a.a("log_to_file", "no data conn. skip [" + paramString + "]");
    }
    for (;;)
    {
      return;
      if (!this.g.e)
      {
        b.a.a("log_to_file", paramString);
        this.g.e = true;
        this.e.sendEmptyMessage(1);
      }
    }
  }
  
  private void d()
  {
    if (this.h) {
      throw new IllegalStateException("this object has been destroyed!");
    }
  }
  
  private void d(String paramString)
  {
    if (!this.g.e)
    {
      b.a.a("log_to_file", paramString);
      this.g.e = true;
      this.e.sendEmptyMessage(1);
    }
  }
  
  private void e()
  {
    a(-1L);
    this.e.removeMessages(2);
    this.b.c();
  }
  
  private void f()
  {
    b localb = this.g;
    localb.a.clear();
    localb.b = false;
    localb.c = 60000L;
    localb.d = null;
    localb.e = false;
  }
  
  private void g()
  {
    long l = SystemClock.elapsedRealtime();
    Iterator localIterator = this.g.a.iterator();
    while (localIterator.hasNext()) {
      if (((bp)localIterator.next()).c < l) {
        localIterator.remove();
      }
    }
  }
  
  private Location h()
  {
    Object localObject = null;
    Location localLocation2 = this.g.d;
    List localList = this.g.a;
    Location localLocation1 = localLocation2;
    if (localLocation2 == null)
    {
      localLocation1 = localLocation2;
      if (!localList.isEmpty()) {
        localLocation1 = b.a.a(this.b.a());
      }
    }
    if (localLocation1 == null) {}
    for (;;)
    {
      return (Location)localObject;
      if (System.currentTimeMillis() - localLocation1.getTime() < 60000L) {
        localObject = localLocation1;
      }
    }
  }
  
  private static Intent i()
  {
    Intent localIntent = new Intent("com.tencent.map.geolocation.wakeup");
    localIntent.putExtra("com.tencent.map.geolocation.from_alarm", true);
    return localIntent;
  }
  
  public final void a()
  {
    if (!this.h)
    {
      e();
      Arrays.fill(this.g.f, -1.0F);
      this.a.unregisterReceiver(this);
    }
    synchronized (this.g)
    {
      f();
      this.h = true;
      return;
    }
  }
  
  public final void a(TencentGeofence paramTencentGeofence)
  {
    d();
    if (paramTencentGeofence == null) {}
    for (;;)
    {
      return;
      b.a.a("GeofenceManager", "removeFence: fence=" + paramTencentGeofence);
      synchronized (this.g)
      {
        Iterator localIterator = this.g.a.iterator();
        while (localIterator.hasNext()) {
          if (paramTencentGeofence.equals(((bp)localIterator.next()).a)) {
            localIterator.remove();
          }
        }
      }
      d("removeFence: --> schedule update fence");
    }
  }
  
  public final void a(TencentGeofence paramTencentGeofence, PendingIntent paramPendingIntent)
  {
    d();
    if ((paramTencentGeofence == null) || (paramPendingIntent == null)) {
      throw new NullPointerException();
    }
    b.a.a("GeofenceManager", "addFence: , geofence=" + paramTencentGeofence + ", intent=" + paramPendingIntent);
    bp localbp1 = new bp(paramTencentGeofence, paramTencentGeofence.getExpireAt(), paramPendingIntent);
    List localList = this.g.a;
    synchronized (this.g)
    {
      int m = localList.size() - 1;
      if (m >= 0)
      {
        bp localbp2 = (bp)localList.get(m);
        if ((paramTencentGeofence.equals(localbp2.a)) && (paramPendingIntent.equals(localbp2.d))) {
          localList.remove(m);
        }
      }
      else
      {
        localList.add(localbp1);
        d("addFence: --> schedule update fence");
        return;
      }
      m--;
    }
  }
  
  public final void a(String paramString)
  {
    d();
    b.a.a("GeofenceManager", "removeFence: tag=" + paramString);
    synchronized (this.g)
    {
      localObject = this.g.a.iterator();
      while (((Iterator)localObject).hasNext())
      {
        TencentGeofence localTencentGeofence = ((bp)((Iterator)localObject).next()).a;
        if ((localTencentGeofence == null) || (TextUtils.equals(localTencentGeofence.getTag(), paramString))) {
          ((Iterator)localObject).remove();
        }
      }
    }
    Object localObject = new java/lang/StringBuilder;
    ((StringBuilder)localObject).<init>("removeFence: ");
    d(paramString + " removed --> schedule update fence");
  }
  
  public final void b()
  {
    d();
    synchronized (this.g)
    {
      this.b.c();
      f();
      return;
    }
  }
  
  public final void onLocationChanged(TencentLocation arg1, int paramInt, String paramString)
  {
    paramString = b.a.a(???);
    b.a.a("log_to_file", b.a.a(???, paramInt));
    this.b.c();
    if (paramInt == 0) {
      this.f.a(paramInt, ???);
    }
    for (;;)
    {
      synchronized (this.g)
      {
        if (this.g.b) {
          this.g.d = paramString;
        }
        if (this.g.e)
        {
          this.e.removeMessages(1);
          b.a.a("log_to_file", "onLocationChanged: fresh location got --> update fences");
          a(false);
          if (this.g.b)
          {
            b.a.a("log_to_file", "onLocationChanged: set a new repeat alarm, interval=" + this.g.c);
            a(this.g.c);
          }
          if (this.d.isHeld()) {
            this.d.release();
          }
          return;
        }
        this.g.e = true;
      }
      this.g.c = 60000L;
      this.f.a(paramInt, ???);
    }
  }
  
  public final void onReceive(Context arg1, Intent paramIntent)
  {
    int m = 1;
    paramIntent = paramIntent.getAction();
    for (;;)
    {
      synchronized (this.g)
      {
        if (h() == null)
        {
          if ("android.intent.action.SCREEN_ON".equals(paramIntent)) {
            if (m != 0) {
              c("onReceive: screen_on and no_fresh_location --> schedule update fence");
            }
          }
        }
        else
        {
          m = 0;
          continue;
        }
        if ("com.tencent.map.geolocation.wakeup".equals(paramIntent))
        {
          paramIntent = this.a;
          if ((br.a != null) && (br.a.isHeld())) {
            br.a.release();
          }
          paramIntent = ((PowerManager)paramIntent.getSystemService("power")).newWakeLock(1, "WakeLocker");
          br.a = paramIntent;
          paramIntent.acquire(5000L);
          this.e.removeMessages(2);
          d("onReceive: alarm --> schedule update fence");
          if ((br.a != null) && (br.a.isHeld())) {
            br.a.release();
          }
          br.a = null;
        }
      }
      if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(paramIntent))
      {
        if (m != 0) {
          c("onReceive: power_disconnected --> schedule update fence");
        }
      }
      else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramIntent))
      {
        if (!b.a.c(this.a))
        {
          b.a.a("log_to_file", "onReceive: disconnected and stop location updates temporaryly");
          this.g.b = false;
          this.g.c = 60000L;
          e();
        }
        c("onReceive: connected and no_fresh_location --> schedule update fence");
      }
    }
  }
  
  public final void onSendFinished(PendingIntent paramPendingIntent, Intent paramIntent, int paramInt, String paramString, Bundle paramBundle)
  {
    this.c.release();
  }
  
  public final void onStatusUpdate(String paramString1, int paramInt, String paramString2) {}
  
  final class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        return;
        bq.a(bq.this);
        continue;
        bq.b("handleMessage: mock alarm --> wakeup");
        bq.b(bq.this).sendBroadcast(bq.c());
      }
    }
  }
  
  static final class b
  {
    final List<bp> a = new LinkedList();
    boolean b = false;
    long c = 60000L;
    Location d = null;
    boolean e = false;
    final float[] f = { -1.0F, -1.0F };
  }
  
  final class c
  {
    List<Map<String, String>> a = new ArrayList();
    private LinkedList<TencentLocation> b = new LinkedList();
    
    public final void a(int paramInt, TencentLocation paramTencentLocation)
    {
      if (paramInt == 0) {
        this.b.add(paramTencentLocation);
      }
      for (;;)
      {
        return;
        this.b.add(da.a.a(System.currentTimeMillis()));
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/bq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */