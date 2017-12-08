package ct;

import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import java.util.Collections;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public final class ck
  extends cn
{
  public int a = 0;
  public int b = 0;
  public int c = 0;
  public int d = 0;
  public int e = 0;
  public int f = 0;
  public int g = Integer.MAX_VALUE;
  public int h = Integer.MAX_VALUE;
  private final long i = System.currentTimeMillis();
  private List<NeighboringCellInfo> j;
  
  @Nullable
  public static ck a(bi parambi, CellInfo paramCellInfo)
  {
    int k = -88;
    Object localObject;
    if ((!parambi.d()) || (paramCellInfo == null)) {
      localObject = null;
    }
    for (;;)
    {
      return (ck)localObject;
      TelephonyManager localTelephonyManager = parambi.a();
      ck localck = new ck();
      if ((paramCellInfo instanceof CellInfoCdma)) {}
      try
      {
        paramCellInfo = (CellInfoCdma)paramCellInfo;
        localObject = paramCellInfo.getCellIdentity();
        localck.a = 2;
        localck.a(parambi, localTelephonyManager);
        localck.c = ((CellIdentityCdma)localObject).getSystemId();
        localck.d = ((CellIdentityCdma)localObject).getNetworkId();
        localck.e = ((CellIdentityCdma)localObject).getBasestationId();
        localck.g = ((CellIdentityCdma)localObject).getLatitude();
        localck.h = ((CellIdentityCdma)localObject).getLongitude();
        n = paramCellInfo.getCellSignalStrength().getDbm();
        m = k;
        if (n > -110)
        {
          m = k;
          if (n < -40) {
            m = n;
          }
        }
        localck.f = m;
        localObject = localck;
      }
      catch (Exception parambi)
      {
        int n;
        int m;
        localObject = localck;
        continue;
        if ((paramCellInfo instanceof CellInfoGsm)) {}
        try
        {
          paramCellInfo = (CellInfoGsm)paramCellInfo;
          localck.a = 1;
          localObject = paramCellInfo.getCellIdentity();
          localck.a(parambi, localTelephonyManager);
          localck.d = ((CellIdentityGsm)localObject).getLac();
          localck.e = ((CellIdentityGsm)localObject).getCid();
          localck.b = ((CellIdentityGsm)localObject).getMcc();
          localck.c = ((CellIdentityGsm)localObject).getMnc();
          n = paramCellInfo.getCellSignalStrength().getDbm();
          m = k;
          if (n > -110)
          {
            m = k;
            if (n < -40) {
              m = n;
            }
          }
          localck.f = m;
          localObject = localck;
        }
        catch (Exception parambi)
        {
          localObject = localck;
          continue;
          if ((paramCellInfo instanceof CellInfoWcdma)) {}
          try
          {
            localObject = (CellInfoWcdma)paramCellInfo;
            localck.a = 1;
            paramCellInfo = ((CellInfoWcdma)localObject).getCellIdentity();
            localck.a(parambi, localTelephonyManager);
            localck.d = paramCellInfo.getLac();
            localck.e = paramCellInfo.getCid();
            localck.b = paramCellInfo.getMcc();
            localck.c = paramCellInfo.getMnc();
            n = ((CellInfoWcdma)localObject).getCellSignalStrength().getDbm();
            m = k;
            if (n > -110)
            {
              m = k;
              if (n < -40) {
                m = n;
              }
            }
            localck.f = m;
            localObject = localck;
          }
          catch (Exception parambi)
          {
            localObject = localck;
            continue;
            localObject = localck;
            if ((paramCellInfo instanceof CellInfoLte)) {
              try
              {
                localObject = (CellInfoLte)paramCellInfo;
                localck.a = 1;
                paramCellInfo = ((CellInfoLte)localObject).getCellIdentity();
                localck.a(parambi, localTelephonyManager);
                localck.d = paramCellInfo.getTac();
                localck.e = paramCellInfo.getCi();
                localck.b = paramCellInfo.getMcc();
                localck.c = paramCellInfo.getMnc();
                k = ((CellInfoLte)localObject).getCellSignalStrength().getDbm();
                if ((k > -110) && (k < -40))
                {
                  localck.f = k;
                  localObject = localck;
                }
              }
              catch (Exception parambi)
              {
                for (;;)
                {
                  localObject = localck;
                  break;
                  k = -88;
                }
              }
              catch (Error parambi)
              {
                localObject = localck;
              }
            }
          }
          catch (Error parambi)
          {
            localObject = localck;
          }
        }
        catch (Error parambi)
        {
          localObject = localck;
        }
      }
      catch (Error parambi)
      {
        localObject = localck;
      }
    }
  }
  
  @Nullable
  public static ck a(bi parambi, CellLocation paramCellLocation, SignalStrength paramSignalStrength)
  {
    if ((!parambi.d()) || (paramCellLocation == null)) {
      parambi = null;
    }
    for (;;)
    {
      return parambi;
      TelephonyManager localTelephonyManager = parambi.a();
      ck localck = new ck();
      if ((paramCellLocation instanceof CdmaCellLocation))
      {
        try
        {
          paramCellLocation = (CdmaCellLocation)paramCellLocation;
          localck.a = 2;
          localck.a(parambi, localTelephonyManager);
          localck.c = paramCellLocation.getSystemId();
          localck.d = paramCellLocation.getNetworkId();
          localck.e = paramCellLocation.getBaseStationId();
          localck.g = paramCellLocation.getBaseStationLatitude();
          localck.h = paramCellLocation.getBaseStationLongitude();
          if (paramSignalStrength != null) {
            break label113;
          }
          localck.f = -1;
          parambi = localck;
        }
        catch (Exception parambi)
        {
          parambi = localck;
        }
        continue;
        label113:
        localck.f = paramSignalStrength.getCdmaDbm();
        parambi = localck;
      }
      else
      {
        try
        {
          paramCellLocation = (GsmCellLocation)paramCellLocation;
          localck.a = 1;
          localck.a(parambi, localTelephonyManager);
          localck.d = paramCellLocation.getLac();
          localck.e = paramCellLocation.getCid();
          if (paramSignalStrength != null) {
            break label179;
          }
          localck.f = -1;
          parambi = localck;
        }
        catch (Exception parambi)
        {
          parambi = localck;
        }
        continue;
        label179:
        localck.f = (paramSignalStrength.getGsmSignalStrength() * 2 - 113);
        parambi = localck;
      }
    }
  }
  
  private void a(bi parambi, TelephonyManager paramTelephonyManager)
  {
    bj localbj = parambi.h();
    int m = localbj.k;
    int k = localbj.l;
    if ((m > 0) && (k >= 0))
    {
      this.b = m;
      this.c = k;
    }
    for (;;)
    {
      return;
      parambi = new int[2];
      db.a(paramTelephonyManager, parambi);
      localbj.k = parambi[0];
      localbj.l = parambi[1];
    }
  }
  
  @NonNull
  public final List<NeighboringCellInfo> a()
  {
    try
    {
      if (this.j == null) {
        this.j = Collections.emptyList();
      }
      List localList = this.j;
      return localList;
    }
    finally {}
  }
  
  public final void a(@Nullable List<NeighboringCellInfo> paramList)
  {
    if (paramList != null) {}
    for (;;)
    {
      try
      {
        this.j = Collections.unmodifiableList(paramList);
        return;
      }
      finally {}
      this.j = Collections.emptyList();
    }
  }
  
  public final String toString()
  {
    return "TxCellInfo [PhoneType=" + this.a + ", MCC=" + this.b + ", MNC=" + this.c + ", LAC=" + this.d + ", CID=" + this.e + ", RSSI=" + this.f + ", LAT=" + this.g + ", LNG=" + this.h + ", mTime=" + this.i + "]";
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/ct/ck.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */