package android.support.v4.util;

import java.io.PrintWriter;

public class TimeUtils
{
  public static final int HUNDRED_DAY_FIELD_LEN = 19;
  private static final int SECONDS_PER_DAY = 86400;
  private static final int SECONDS_PER_HOUR = 3600;
  private static final int SECONDS_PER_MINUTE = 60;
  private static char[] sFormatStr = new char[24];
  private static final Object sFormatSync = new Object();
  
  private static int accumField(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if ((paramInt1 > 99) || ((paramBoolean) && (paramInt3 >= 3))) {
      paramInt1 = paramInt2 + 3;
    }
    for (;;)
    {
      return paramInt1;
      if ((paramInt1 > 9) || ((paramBoolean) && (paramInt3 >= 2))) {
        paramInt1 = paramInt2 + 2;
      } else if ((paramBoolean) || (paramInt1 > 0)) {
        paramInt1 = paramInt2 + 1;
      } else {
        paramInt1 = 0;
      }
    }
  }
  
  public static void formatDuration(long paramLong1, long paramLong2, PrintWriter paramPrintWriter)
  {
    if (paramLong1 == 0L) {
      paramPrintWriter.print("--");
    }
    for (;;)
    {
      return;
      formatDuration(paramLong1 - paramLong2, paramPrintWriter, 0);
    }
  }
  
  public static void formatDuration(long paramLong, PrintWriter paramPrintWriter)
  {
    formatDuration(paramLong, paramPrintWriter, 0);
  }
  
  public static void formatDuration(long paramLong, PrintWriter paramPrintWriter, int paramInt)
  {
    synchronized (sFormatSync)
    {
      paramInt = formatDurationLocked(paramLong, paramInt);
      String str = new java/lang/String;
      str.<init>(sFormatStr, 0, paramInt);
      paramPrintWriter.print(str);
      return;
    }
  }
  
  public static void formatDuration(long paramLong, StringBuilder paramStringBuilder)
  {
    synchronized (sFormatSync)
    {
      int i = formatDurationLocked(paramLong, 0);
      paramStringBuilder.append(sFormatStr, 0, i);
      return;
    }
  }
  
  private static int formatDurationLocked(long paramLong, int paramInt)
  {
    if (sFormatStr.length < paramInt) {
      sFormatStr = new char[paramInt];
    }
    char[] arrayOfChar = sFormatStr;
    if (paramLong == 0L)
    {
      while (paramInt - 1 > 0) {
        arrayOfChar[0] = ' ';
      }
      arrayOfChar[0] = '0';
      paramInt = 1;
      return paramInt;
    }
    int i;
    int i4;
    int m;
    int k;
    int j;
    int n;
    if (paramLong > 0L)
    {
      i = 43;
      i4 = (int)(paramLong % 1000L);
      m = (int)Math.floor(paramLong / 1000L);
      k = 0;
      j = m;
      if (m > 86400)
      {
        k = m / 86400;
        j = m - 86400 * k;
      }
      if (j <= 3600) {
        break label572;
      }
      m = j / 3600;
      n = m;
      j -= m * 3600;
    }
    for (;;)
    {
      int i1;
      if (j > 60)
      {
        m = j / 60;
        i1 = m;
      }
      for (m = j - m * 60;; m = j)
      {
        boolean bool;
        if (paramInt != 0)
        {
          j = accumField(k, 1, false, 0);
          if (j > 0)
          {
            bool = true;
            label191:
            j += accumField(n, 1, bool, 2);
            if (j <= 0) {
              break label321;
            }
            bool = true;
            label213:
            j += accumField(i1, 1, bool, 2);
            if (j <= 0) {
              break label327;
            }
            bool = true;
            label235:
            i2 = j + accumField(m, 1, bool, 2);
            if (i2 <= 0) {
              break label333;
            }
          }
          label321:
          label327:
          label333:
          for (j = 3;; j = 0)
          {
            i3 = accumField(i4, 2, true, j);
            j = 0;
            i2 = i3 + 1 + i2;
            for (;;)
            {
              i3 = j;
              if (i2 >= paramInt) {
                break;
              }
              arrayOfChar[j] = ' ';
              i2++;
              j++;
            }
            paramLong = -paramLong;
            i = 45;
            break;
            bool = false;
            break label191;
            bool = false;
            break label213;
            bool = false;
            break label235;
          }
        }
        int i3 = 0;
        arrayOfChar[i3] = i;
        int i2 = i3 + 1;
        if (paramInt != 0)
        {
          paramInt = 1;
          label360:
          k = printField(arrayOfChar, k, 'd', i2, false, 0);
          if (k == i2) {
            break label521;
          }
          bool = true;
          label385:
          if (paramInt == 0) {
            break label527;
          }
          j = 2;
          label392:
          k = printField(arrayOfChar, n, 'h', k, bool, j);
          if (k == i2) {
            break label533;
          }
          bool = true;
          label419:
          if (paramInt == 0) {
            break label539;
          }
          j = 2;
          label426:
          k = printField(arrayOfChar, i1, 'm', k, bool, j);
          if (k == i2) {
            break label545;
          }
          bool = true;
          label453:
          if (paramInt == 0) {
            break label551;
          }
          j = 2;
          label460:
          j = printField(arrayOfChar, m, 's', k, bool, j);
          if ((paramInt == 0) || (j == i2)) {
            break label557;
          }
        }
        label521:
        label527:
        label533:
        label539:
        label545:
        label551:
        label557:
        for (paramInt = 3;; paramInt = 0)
        {
          paramInt = printField(arrayOfChar, i4, 'm', j, true, paramInt);
          arrayOfChar[paramInt] = 's';
          paramInt++;
          break;
          paramInt = 0;
          break label360;
          bool = false;
          break label385;
          j = 0;
          break label392;
          bool = false;
          break label419;
          j = 0;
          break label426;
          bool = false;
          break label453;
          j = 0;
          break label460;
        }
        i1 = 0;
      }
      label572:
      n = 0;
    }
  }
  
  private static int printField(char[] paramArrayOfChar, int paramInt1, char paramChar, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    int i;
    int j;
    if (!paramBoolean)
    {
      i = paramInt2;
      if (paramInt1 <= 0) {}
    }
    else
    {
      if (((!paramBoolean) || (paramInt3 < 3)) && (paramInt1 <= 99)) {
        break label142;
      }
      j = paramInt1 / 100;
      paramArrayOfChar[paramInt2] = ((char)(j + 48));
      i = paramInt2 + 1;
      paramInt1 -= j * 100;
    }
    for (;;)
    {
      if (((!paramBoolean) || (paramInt3 < 2)) && (paramInt1 <= 9))
      {
        j = i;
        paramInt3 = paramInt1;
        if (paramInt2 == i) {}
      }
      else
      {
        paramInt2 = paramInt1 / 10;
        paramArrayOfChar[i] = ((char)(paramInt2 + 48));
        j = i + 1;
        paramInt3 = paramInt1 - paramInt2 * 10;
      }
      paramArrayOfChar[j] = ((char)(paramInt3 + 48));
      paramInt1 = j + 1;
      paramArrayOfChar[paramInt1] = paramChar;
      i = paramInt1 + 1;
      return i;
      label142:
      i = paramInt2;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/android/support/v4/util/TimeUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */