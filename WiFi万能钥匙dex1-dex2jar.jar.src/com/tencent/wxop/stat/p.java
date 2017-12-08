package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.l;
import java.util.Map;

final class p
{
  private static volatile long bU = 0L;
  private com.tencent.wxop.stat.a.d bP;
  private d bQ = null;
  private boolean bR = false;
  private Context bS = null;
  private long bT = System.currentTimeMillis();
  
  public p(com.tencent.wxop.stat.a.d paramd)
  {
    this.bP = paramd;
    this.bQ = c.j();
    this.bR = paramd.X();
    this.bS = paramd.J();
  }
  
  private void H()
  {
    if ((t.ai().aI > 0) && (c.ax))
    {
      t.ai().b(this.bP, null, this.bR, true);
      t.ai().b(-1);
    }
    for (;;)
    {
      return;
      a(new s(this));
    }
  }
  
  private void a(aj paramaj)
  {
    ak.Z(e.J()).a(this.bP, paramaj);
  }
  
  public final void ah()
  {
    Integer localInteger1;
    int i;
    if (c.ae > 0)
    {
      if (this.bT > e.P())
      {
        e.Q().clear();
        e.c(this.bT + c.af);
        if (c.k()) {
          e.K().b("clear methodsCalledLimitMap, nextLimitCallClearTime=" + e.P());
        }
      }
      localInteger1 = Integer.valueOf(this.bP.ac().r());
      Integer localInteger2 = (Integer)e.Q().get(localInteger1);
      if (localInteger2 != null)
      {
        e.Q().put(localInteger1, Integer.valueOf(localInteger2.intValue() + 1));
        if (localInteger2.intValue() <= c.ae) {
          break label227;
        }
        if (c.k()) {
          e.K().d("event " + this.bP.af() + " was discard, cause of called limit, current:" + localInteger2 + ", limit:" + c.ae + ", period:" + c.af + " ms");
        }
        i = 1;
        if (i == 0) {
          break label232;
        }
      }
    }
    for (;;)
    {
      return;
      e.Q().put(localInteger1, Integer.valueOf(1));
      label227:
      i = 0;
      break;
      label232:
      if ((c.ay > 0) && (this.bT >= bU))
      {
        e.p(this.bS);
        bU = this.bT + c.az;
        if (c.k()) {
          e.K().b("nextFlushTime=" + bU);
        }
      }
      if (g.r(this.bS).X())
      {
        if (c.k()) {
          e.K().b("sendFailedCount=" + e.aI);
        }
        if (!e.a())
        {
          if ((this.bP.ae() != null) && (this.bP.ae().R())) {
            this.bQ = d.aB;
          }
          if ((c.ah) && (g.r(e.J()).W())) {
            this.bQ = d.aB;
          }
          if (c.k()) {
            e.K().b("strategy=" + this.bQ.name());
          }
          switch (j.bL[this.bQ.ordinal()])
          {
          default: 
            e.K().error("Invalid stat strategy:" + c.j());
            break;
          case 1: 
            H();
            break;
          case 2: 
            t.s(this.bS).b(this.bP, null, this.bR, false);
            if (c.k()) {
              e.K().b("PERIOD currTime=" + this.bT + ",nextPeriodSendTs=" + e.aZ + ",difftime=" + (e.aZ - this.bT));
            }
            if (e.aZ == 0L)
            {
              e.aZ = com.tencent.wxop.stat.b.q.f(this.bS, "last_period_ts");
              if (this.bT > e.aZ) {
                e.q(this.bS);
              }
              long l = this.bT + c.u() * 60 * 1000;
              if (e.aZ > l) {
                e.aZ = l;
              }
              af.Y(this.bS).ah();
            }
            if (c.k()) {
              e.K().b("PERIOD currTime=" + this.bT + ",nextPeriodSendTs=" + e.aZ + ",difftime=" + (e.aZ - this.bT));
            }
            if (this.bT <= e.aZ) {
              continue;
            }
            e.q(this.bS);
            break;
          case 3: 
          case 4: 
            t.s(this.bS).b(this.bP, null, this.bR, false);
            break;
          case 5: 
            t.s(this.bS).b(this.bP, new q(this), this.bR, true);
            break;
          case 6: 
            if (g.r(e.J()).D() == 1)
            {
              H();
              continue;
            }
            t.s(this.bS).b(this.bP, null, this.bR, false);
            break;
          case 7: 
            if (!l.y(this.bS)) {
              continue;
            }
            a(new r(this));
            break;
          }
        }
        else
        {
          t.s(this.bS).b(this.bP, null, this.bR, false);
          if (this.bT - e.aX > 1800000L) {
            e.n(this.bS);
          }
        }
      }
      else
      {
        t.s(this.bS).b(this.bP, null, this.bR, false);
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/tencent/wxop/stat/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */