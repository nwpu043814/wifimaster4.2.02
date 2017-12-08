package com.lantern.wifiseccheck;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.lantern.safecommand.service.SvpnShared;
import com.lantern.wifiseccheck.item.CheckItemARP;
import com.lantern.wifiseccheck.item.CheckItemDNS;
import com.lantern.wifiseccheck.item.CheckItemLocation;
import com.lantern.wifiseccheck.item.CheckItemNeighbor;
import com.lantern.wifiseccheck.item.CheckItemSSL;
import com.lantern.wifiseccheck.item.CheckItemWebMd5;
import com.lantern.wifiseccheck.item.ICheckItem;
import com.lantern.wifiseccheck.protocol.ApMarkResult;
import com.lantern.wifiseccheck.protocol.DomainResult;
import com.lantern.wifiseccheck.protocol.Neighbour;
import com.lantern.wifiseccheck.protocol.TreatmentRecommendations;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class WifiSecCheckImpl$HandlerThread$1
  extends Handler
{
  WifiSecCheckImpl$HandlerThread$1(WifiSecCheckImpl.HandlerThread paramHandlerThread) {}
  
  public void handleMessage(Message arg1)
  {
    LogUtils.d("WifiSecCheckImpl", "get msg " + ???.what);
    switch (???.what)
    {
    }
    label1445:
    for (;;)
    {
      return;
      LogUtils.d("WifiSecCheckImpl", "MSG_COLLECT_TIME_OUT" + this);
      WifiSecCheckImpl.access$502(this.this$1.this$0, true);
      ??? = (CheckItemNeighbor)WifiSecCheckImpl.access$600(this.this$1.this$0).getNoCheckItem(5);
      LogUtils.d("WifiSecCheckImpl", "get msg " + ???);
      if (??? != null)
      {
        LogUtils.d("WifiSecCheckImpl", "receive MSG_COLLECT_TIME_OUT but detect neighbour is not finish reset it ");
        WifiSecCheckImpl.access$700(this.this$1.this$0).resetJNI();
        LogUtils.d("WifiSecCheckImpl", " MSG_COLLECT_TIME_OUT reset finish");
      }
      else
      {
        sendEmptyMessage(11);
        continue;
        if (WifiSecCheckImpl.access$000(this.this$1.this$0) != WifiSecCheckImpl.access$100(this.this$1.this$0))
        {
          ((CheckItemLocation)WifiSecCheckImpl.access$600(this.this$1.this$0).getNoCheckItem(6)).setLocation(WifiSecCheckImpl.access$000(this.this$1.this$0).getLocation());
          WifiSecCheckImpl.access$800(this.this$1.this$0);
        }
        else
        {
          WifiSecCheckImpl.access$900(this.this$1.this$0).sendEmptyMessage(4);
          continue;
          LogUtils.d("WifiSecCheckImpl", "MSG_DETECT_NEIGHBOUR " + ???.arg1);
          Object localObject1 = (ArrayList)???.obj;
          Object localObject3;
          Object localObject4;
          if (localObject1 != null)
          {
            localObject3 = ((ArrayList)localObject1).iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (NeighbourItem)((Iterator)localObject3).next();
              if (((NeighbourItem)localObject4).ip != WifiSecCheckImpl.access$1000(this.this$1.this$0))
              {
                localObject1 = new Neighbour();
                ((Neighbour)localObject1).setIp(((NeighbourItem)localObject4).ip);
                ((Neighbour)localObject1).setMac(((NeighbourItem)localObject4).arp);
                WifiSecCheckImpl.access$200(this.this$1.this$0).add(localObject1);
              }
            }
          }
          if (???.arg1 == 2) {
            switch (WifiSecCheckImpl.8.$SwitchMap$com$lantern$wifiseccheck$WifiSecCheckImpl$CheckModel[WifiSecCheckImpl.access$1100(this.this$1.this$0).ordinal()])
            {
            }
          }
          for (;;)
          {
            WifiSecCheckImpl.access$900(this.this$1.this$0).obtainMessage(6, WifiSecCheckImpl.access$200(this.this$1.this$0).size() - 1, ???.arg1, Integer.valueOf(???.arg2)).sendToTarget();
            break;
            if (WifiSecCheckImpl.access$600(this.this$1.this$0) == null) {
              break;
            }
            localObject1 = (CheckItemNeighbor)WifiSecCheckImpl.access$600(this.this$1.this$0).getNoCheckItem(5);
            if (localObject1 == null) {
              break;
            }
            ((CheckItemNeighbor)localObject1).putNeighbours(WifiSecCheckImpl.access$200(this.this$1.this$0));
            ((CheckItemNeighbor)localObject1).setPercent(???.arg2);
            WifiSecCheckImpl.access$1200(this.this$1.this$0, 5);
            continue;
            if (WifiSecCheckImpl.access$000(this.this$1.this$0) == null)
            {
              LogUtils.d("WifiSecCheckImpl", "checkListener = NULL");
              WifiSecCheckImpl.access$700(this.this$1.this$0).resetJNI();
              WifiSecCheckImpl.access$900(this.this$1.this$0).sendEmptyMessage(4);
              break;
            }
            LogUtils.d("WifiSecCheckImpl", "do Group");
            WifiSecCheckImpl.access$1300(this.this$1.this$0);
          }
          if (!WifiSecCheckImpl.access$500(this.this$1.this$0))
          {
            ((CheckItemARP)WifiSecCheckImpl.access$600(this.this$1.this$0).getNoCheckItem(1)).setHasArp(true);
            continue;
            if (!WifiSecCheckImpl.access$500(this.this$1.this$0))
            {
              localObject1 = new ArrayList();
              localObject4 = ((ArrayList)???.obj).iterator();
              while (((Iterator)localObject4).hasNext())
              {
                localObject3 = (HostItem)((Iterator)localObject4).next();
                ??? = new DomainResult();
                ???.setDomainName(((HostItem)localObject3).domains);
                LogUtils.d("WifiSecCheckImpl", "Utils.intToIp(item.ips) " + Utils.intToIp(((HostItem)localObject3).ips));
                ???.setIps(Utils.intToIp(((HostItem)localObject3).ips));
                ((List)localObject1).add(???);
              }
              ??? = (CheckItemDNS)WifiSecCheckImpl.access$600(this.this$1.this$0).getNoCheckItem(2);
              if (??? != null)
              {
                ???.setDomainResults((List)localObject1);
                WifiSecCheckImpl.access$1200(this.this$1.this$0, 2);
                continue;
                ??? = (ApMarkResult)???.obj;
                if (??? != null) {}
                try
                {
                  if (???.getNetState() == 4)
                  {
                    this.this$1.this$0.initAbnormalInfoData(???, WifiSecCheckImpl.access$600(this.this$1.this$0).getClientInfo());
                    if (???.getRecommend() == null) {
                      ???.setRecommend(TreatmentRecommendations.JUST_SHOW);
                    }
                  }
                  WifiSecCheckImpl.access$700(this.this$1.this$0).resetJNI();
                  WifiSecCheckImpl.access$600(this.this$1.this$0).reset();
                  WifiSecCheckImpl.access$900(this.this$1.this$0).sendEmptyMessage(1);
                }
                catch (Exception ???)
                {
                  for (;;)
                  {
                    ???.printStackTrace();
                    LogUtils.d("WifiSecCheckImpl", "MSG_GET_CHECK_RESULT get exception" + ???.getMessage());
                  }
                }
                SvpnShared.getInstance().notify_netstate(???.arg1);
                continue;
                WifiSecCheckImpl.access$1400(this.this$1.this$0);
                continue;
                removeMessages(2);
                synchronized (this.this$1.this$0)
                {
                  if (WifiSecCheckImpl.access$700(this.this$1.this$0) != null) {
                    WifiSecCheckImpl.access$700(this.this$1.this$0).resetJNI();
                  }
                  WifiSecCheckImpl.access$1500(this.this$1.this$0);
                  WifiSecCheckImpl.access$1602(this.this$1.this$0, false);
                  localObject1 = new java/lang/StringBuilder;
                  ((StringBuilder)localObject1).<init>("isChecking //////");
                  LogUtils.d("WifiSecCheckImpl", WifiSecCheckImpl.access$1600(this.this$1.this$0));
                  getLooper().quit();
                }
                WifiSecCheckImpl.access$700(this.this$1.this$0).resetJNI();
                WifiSecCheckImpl.access$900(this.this$1.this$0).sendEmptyMessage(2);
                continue;
                if (WifiSecCheckImpl.access$700(this.this$1.this$0) != null)
                {
                  WifiSecCheckImpl.access$700(this.this$1.this$0).resetJNI();
                  continue;
                  WifiSecCheckImpl.access$1700(this.this$1.this$0);
                  continue;
                  WifiSecCheckImpl.ItemResult localItemResult = (WifiSecCheckImpl.ItemResult)???.obj;
                  localObject3 = WifiSecCheckImpl.access$600(this.this$1.this$0).getNoCheckItem(???.arg1);
                  if (WifiSecCheckImpl.access$000(this.this$1.this$0) == WifiSecCheckImpl.access$100(this.this$1.this$0))
                  {
                    if (localObject3 != null)
                    {
                      ((ICheckItem)localObject3).setFinish(true);
                      WifiSecCheckImpl.access$1200(this.this$1.this$0, ???.arg1);
                    }
                  }
                  else if ((WifiSecCheckImpl.access$1600(this.this$1.this$0)) && (!WifiSecCheckImpl.access$500(this.this$1.this$0)) && (localObject3 != null))
                  {
                    LogUtils.d("WifiSecCheckImpl", "url " + localItemResult.key + " ir.value = " + localItemResult.value);
                    boolean bool;
                    if ((localObject3 instanceof CheckItemSSL)) {
                      bool = ((CheckItemSSL)localObject3).setSSLCert(localItemResult.key, localItemResult.value);
                    }
                    for (;;)
                    {
                      if (!bool) {
                        break label1445;
                      }
                      WifiSecCheckImpl.access$1200(this.this$1.this$0, ???.arg1);
                      break;
                      if ((localObject3 instanceof CheckItemWebMd5)) {
                        bool = ((CheckItemWebMd5)localObject3).setWebResult(localItemResult.key, localItemResult.value);
                      } else {
                        bool = false;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/lantern/wifiseccheck/WifiSecCheckImpl$HandlerThread$1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */