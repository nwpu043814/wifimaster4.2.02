package com.a.a.a.a;

import java.io.UnsupportedEncodingException;

public class b
{
  static
  {
    if (!b.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt)
  {
    label179:
    label184:
    label201:
    for (;;)
    {
      int j;
      c localc;
      int i;
      try
      {
        j = paramArrayOfByte.length;
        localc = new com/a/a/a/a/b$c;
        localc.<init>(paramInt);
        i = j / 3 * 4;
        if (localc.d)
        {
          paramInt = i;
          if (j % 3 > 0) {
            paramInt = i + 4;
          }
          if ((!localc.e) || (j <= 0)) {
            break label201;
          }
          int k = (j - 1) / 57;
          if (!localc.f) {
            break label179;
          }
          i = 2;
          paramInt = i * (k + 1) + paramInt;
          localc.a = new byte[paramInt];
          localc.a(paramArrayOfByte, j);
          if ((a) || (localc.b == paramInt)) {
            break label184;
          }
          paramArrayOfByte = new java/lang/AssertionError;
          paramArrayOfByte.<init>();
          throw paramArrayOfByte;
        }
      }
      catch (UnsupportedEncodingException paramArrayOfByte)
      {
        throw new AssertionError(paramArrayOfByte);
      }
      paramInt = i;
      switch (j % 3)
      {
      case 0: 
      default: 
        paramInt = i;
        break;
      case 1: 
        paramInt = i + 2;
        break;
      case 2: 
        paramInt = i + 3;
        continue;
        i = 1;
        continue;
        paramArrayOfByte = new String(localc.a, "US-ASCII");
        return paramArrayOfByte;
      }
    }
  }
  
  public static byte[] a(String paramString)
  {
    paramString = paramString.getBytes();
    int i = paramString.length;
    b localb = new b(new byte[i * 3 / 4]);
    if (!localb.a(paramString, i)) {
      throw new IllegalArgumentException("bad base-64");
    }
    if (localb.b == localb.a.length) {
      paramString = localb.a;
    }
    for (;;)
    {
      return paramString;
      paramString = new byte[localb.b];
      System.arraycopy(localb.a, 0, paramString, 0, localb.b);
    }
  }
  
  static abstract class a
  {
    public byte[] a;
    public int b;
  }
  
  static final class b
    extends b.a
  {
    private static final int[] c;
    private static final int[] d;
    private int e;
    private int f;
    private final int[] g;
    
    static
    {
      int[] arrayOfInt = new int['Ā'];
      arrayOfInt[0] = -1;
      arrayOfInt[1] = -1;
      arrayOfInt[2] = -1;
      arrayOfInt[3] = -1;
      arrayOfInt[4] = -1;
      arrayOfInt[5] = -1;
      arrayOfInt[6] = -1;
      arrayOfInt[7] = -1;
      arrayOfInt[8] = -1;
      arrayOfInt[9] = -1;
      arrayOfInt[10] = -1;
      arrayOfInt[11] = -1;
      arrayOfInt[12] = -1;
      arrayOfInt[13] = -1;
      arrayOfInt[14] = -1;
      arrayOfInt[15] = -1;
      arrayOfInt[16] = -1;
      arrayOfInt[17] = -1;
      arrayOfInt[18] = -1;
      arrayOfInt[19] = -1;
      arrayOfInt[20] = -1;
      arrayOfInt[21] = -1;
      arrayOfInt[22] = -1;
      arrayOfInt[23] = -1;
      arrayOfInt[24] = -1;
      arrayOfInt[25] = -1;
      arrayOfInt[26] = -1;
      arrayOfInt[27] = -1;
      arrayOfInt[28] = -1;
      arrayOfInt[29] = -1;
      arrayOfInt[30] = -1;
      arrayOfInt[31] = -1;
      arrayOfInt[32] = -1;
      arrayOfInt[33] = -1;
      arrayOfInt[34] = -1;
      arrayOfInt[35] = -1;
      arrayOfInt[36] = -1;
      arrayOfInt[37] = -1;
      arrayOfInt[38] = -1;
      arrayOfInt[39] = -1;
      arrayOfInt[40] = -1;
      arrayOfInt[41] = -1;
      arrayOfInt[42] = -1;
      arrayOfInt[43] = 62;
      arrayOfInt[44] = -1;
      arrayOfInt[45] = -1;
      arrayOfInt[46] = -1;
      arrayOfInt[47] = 63;
      arrayOfInt[48] = 52;
      arrayOfInt[49] = 53;
      arrayOfInt[50] = 54;
      arrayOfInt[51] = 55;
      arrayOfInt[52] = 56;
      arrayOfInt[53] = 57;
      arrayOfInt[54] = 58;
      arrayOfInt[55] = 59;
      arrayOfInt[56] = 60;
      arrayOfInt[57] = 61;
      arrayOfInt[58] = -1;
      arrayOfInt[59] = -1;
      arrayOfInt[60] = -1;
      arrayOfInt[61] = -2;
      arrayOfInt[62] = -1;
      arrayOfInt[63] = -1;
      arrayOfInt[64] = -1;
      arrayOfInt[66] = 1;
      arrayOfInt[67] = 2;
      arrayOfInt[68] = 3;
      arrayOfInt[69] = 4;
      arrayOfInt[70] = 5;
      arrayOfInt[71] = 6;
      arrayOfInt[72] = 7;
      arrayOfInt[73] = 8;
      arrayOfInt[74] = 9;
      arrayOfInt[75] = 10;
      arrayOfInt[76] = 11;
      arrayOfInt[77] = 12;
      arrayOfInt[78] = 13;
      arrayOfInt[79] = 14;
      arrayOfInt[80] = 15;
      arrayOfInt[81] = 16;
      arrayOfInt[82] = 17;
      arrayOfInt[83] = 18;
      arrayOfInt[84] = 19;
      arrayOfInt[85] = 20;
      arrayOfInt[86] = 21;
      arrayOfInt[87] = 22;
      arrayOfInt[88] = 23;
      arrayOfInt[89] = 24;
      arrayOfInt[90] = 25;
      arrayOfInt[91] = -1;
      arrayOfInt[92] = -1;
      arrayOfInt[93] = -1;
      arrayOfInt[94] = -1;
      arrayOfInt[95] = -1;
      arrayOfInt[96] = -1;
      arrayOfInt[97] = 26;
      arrayOfInt[98] = 27;
      arrayOfInt[99] = 28;
      arrayOfInt[100] = 29;
      arrayOfInt[101] = 30;
      arrayOfInt[102] = 31;
      arrayOfInt[103] = 32;
      arrayOfInt[104] = 33;
      arrayOfInt[105] = 34;
      arrayOfInt[106] = 35;
      arrayOfInt[107] = 36;
      arrayOfInt[108] = 37;
      arrayOfInt[109] = 38;
      arrayOfInt[110] = 39;
      arrayOfInt[111] = 40;
      arrayOfInt[112] = 41;
      arrayOfInt[113] = 42;
      arrayOfInt[114] = 43;
      arrayOfInt[115] = 44;
      arrayOfInt[116] = 45;
      arrayOfInt[117] = 46;
      arrayOfInt[118] = 47;
      arrayOfInt[119] = 48;
      arrayOfInt[120] = 49;
      arrayOfInt[121] = 50;
      arrayOfInt[122] = 51;
      arrayOfInt[123] = -1;
      arrayOfInt[124] = -1;
      arrayOfInt[125] = -1;
      arrayOfInt[126] = -1;
      arrayOfInt[127] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[' '] = -1;
      arrayOfInt['¡'] = -1;
      arrayOfInt['¢'] = -1;
      arrayOfInt['£'] = -1;
      arrayOfInt['¤'] = -1;
      arrayOfInt['¥'] = -1;
      arrayOfInt['¦'] = -1;
      arrayOfInt['§'] = -1;
      arrayOfInt['¨'] = -1;
      arrayOfInt['©'] = -1;
      arrayOfInt['ª'] = -1;
      arrayOfInt['«'] = -1;
      arrayOfInt['¬'] = -1;
      arrayOfInt['­'] = -1;
      arrayOfInt['®'] = -1;
      arrayOfInt['¯'] = -1;
      arrayOfInt['°'] = -1;
      arrayOfInt['±'] = -1;
      arrayOfInt['²'] = -1;
      arrayOfInt['³'] = -1;
      arrayOfInt['´'] = -1;
      arrayOfInt['µ'] = -1;
      arrayOfInt['¶'] = -1;
      arrayOfInt['·'] = -1;
      arrayOfInt['¸'] = -1;
      arrayOfInt['¹'] = -1;
      arrayOfInt['º'] = -1;
      arrayOfInt['»'] = -1;
      arrayOfInt['¼'] = -1;
      arrayOfInt['½'] = -1;
      arrayOfInt['¾'] = -1;
      arrayOfInt['¿'] = -1;
      arrayOfInt['À'] = -1;
      arrayOfInt['Á'] = -1;
      arrayOfInt['Â'] = -1;
      arrayOfInt['Ã'] = -1;
      arrayOfInt['Ä'] = -1;
      arrayOfInt['Å'] = -1;
      arrayOfInt['Æ'] = -1;
      arrayOfInt['Ç'] = -1;
      arrayOfInt['È'] = -1;
      arrayOfInt['É'] = -1;
      arrayOfInt['Ê'] = -1;
      arrayOfInt['Ë'] = -1;
      arrayOfInt['Ì'] = -1;
      arrayOfInt['Í'] = -1;
      arrayOfInt['Î'] = -1;
      arrayOfInt['Ï'] = -1;
      arrayOfInt['Ð'] = -1;
      arrayOfInt['Ñ'] = -1;
      arrayOfInt['Ò'] = -1;
      arrayOfInt['Ó'] = -1;
      arrayOfInt['Ô'] = -1;
      arrayOfInt['Õ'] = -1;
      arrayOfInt['Ö'] = -1;
      arrayOfInt['×'] = -1;
      arrayOfInt['Ø'] = -1;
      arrayOfInt['Ù'] = -1;
      arrayOfInt['Ú'] = -1;
      arrayOfInt['Û'] = -1;
      arrayOfInt['Ü'] = -1;
      arrayOfInt['Ý'] = -1;
      arrayOfInt['Þ'] = -1;
      arrayOfInt['ß'] = -1;
      arrayOfInt['à'] = -1;
      arrayOfInt['á'] = -1;
      arrayOfInt['â'] = -1;
      arrayOfInt['ã'] = -1;
      arrayOfInt['ä'] = -1;
      arrayOfInt['å'] = -1;
      arrayOfInt['æ'] = -1;
      arrayOfInt['ç'] = -1;
      arrayOfInt['è'] = -1;
      arrayOfInt['é'] = -1;
      arrayOfInt['ê'] = -1;
      arrayOfInt['ë'] = -1;
      arrayOfInt['ì'] = -1;
      arrayOfInt['í'] = -1;
      arrayOfInt['î'] = -1;
      arrayOfInt['ï'] = -1;
      arrayOfInt['ð'] = -1;
      arrayOfInt['ñ'] = -1;
      arrayOfInt['ò'] = -1;
      arrayOfInt['ó'] = -1;
      arrayOfInt['ô'] = -1;
      arrayOfInt['õ'] = -1;
      arrayOfInt['ö'] = -1;
      arrayOfInt['÷'] = -1;
      arrayOfInt['ø'] = -1;
      arrayOfInt['ù'] = -1;
      arrayOfInt['ú'] = -1;
      arrayOfInt['û'] = -1;
      arrayOfInt['ü'] = -1;
      arrayOfInt['ý'] = -1;
      arrayOfInt['þ'] = -1;
      arrayOfInt['ÿ'] = -1;
      c = arrayOfInt;
      arrayOfInt = new int['Ā'];
      arrayOfInt[0] = -1;
      arrayOfInt[1] = -1;
      arrayOfInt[2] = -1;
      arrayOfInt[3] = -1;
      arrayOfInt[4] = -1;
      arrayOfInt[5] = -1;
      arrayOfInt[6] = -1;
      arrayOfInt[7] = -1;
      arrayOfInt[8] = -1;
      arrayOfInt[9] = -1;
      arrayOfInt[10] = -1;
      arrayOfInt[11] = -1;
      arrayOfInt[12] = -1;
      arrayOfInt[13] = -1;
      arrayOfInt[14] = -1;
      arrayOfInt[15] = -1;
      arrayOfInt[16] = -1;
      arrayOfInt[17] = -1;
      arrayOfInt[18] = -1;
      arrayOfInt[19] = -1;
      arrayOfInt[20] = -1;
      arrayOfInt[21] = -1;
      arrayOfInt[22] = -1;
      arrayOfInt[23] = -1;
      arrayOfInt[24] = -1;
      arrayOfInt[25] = -1;
      arrayOfInt[26] = -1;
      arrayOfInt[27] = -1;
      arrayOfInt[28] = -1;
      arrayOfInt[29] = -1;
      arrayOfInt[30] = -1;
      arrayOfInt[31] = -1;
      arrayOfInt[32] = -1;
      arrayOfInt[33] = -1;
      arrayOfInt[34] = -1;
      arrayOfInt[35] = -1;
      arrayOfInt[36] = -1;
      arrayOfInt[37] = -1;
      arrayOfInt[38] = -1;
      arrayOfInt[39] = -1;
      arrayOfInt[40] = -1;
      arrayOfInt[41] = -1;
      arrayOfInt[42] = -1;
      arrayOfInt[43] = -1;
      arrayOfInt[44] = -1;
      arrayOfInt[45] = 62;
      arrayOfInt[46] = -1;
      arrayOfInt[47] = -1;
      arrayOfInt[48] = 52;
      arrayOfInt[49] = 53;
      arrayOfInt[50] = 54;
      arrayOfInt[51] = 55;
      arrayOfInt[52] = 56;
      arrayOfInt[53] = 57;
      arrayOfInt[54] = 58;
      arrayOfInt[55] = 59;
      arrayOfInt[56] = 60;
      arrayOfInt[57] = 61;
      arrayOfInt[58] = -1;
      arrayOfInt[59] = -1;
      arrayOfInt[60] = -1;
      arrayOfInt[61] = -2;
      arrayOfInt[62] = -1;
      arrayOfInt[63] = -1;
      arrayOfInt[64] = -1;
      arrayOfInt[66] = 1;
      arrayOfInt[67] = 2;
      arrayOfInt[68] = 3;
      arrayOfInt[69] = 4;
      arrayOfInt[70] = 5;
      arrayOfInt[71] = 6;
      arrayOfInt[72] = 7;
      arrayOfInt[73] = 8;
      arrayOfInt[74] = 9;
      arrayOfInt[75] = 10;
      arrayOfInt[76] = 11;
      arrayOfInt[77] = 12;
      arrayOfInt[78] = 13;
      arrayOfInt[79] = 14;
      arrayOfInt[80] = 15;
      arrayOfInt[81] = 16;
      arrayOfInt[82] = 17;
      arrayOfInt[83] = 18;
      arrayOfInt[84] = 19;
      arrayOfInt[85] = 20;
      arrayOfInt[86] = 21;
      arrayOfInt[87] = 22;
      arrayOfInt[88] = 23;
      arrayOfInt[89] = 24;
      arrayOfInt[90] = 25;
      arrayOfInt[91] = -1;
      arrayOfInt[92] = -1;
      arrayOfInt[93] = -1;
      arrayOfInt[94] = -1;
      arrayOfInt[95] = 63;
      arrayOfInt[96] = -1;
      arrayOfInt[97] = 26;
      arrayOfInt[98] = 27;
      arrayOfInt[99] = 28;
      arrayOfInt[100] = 29;
      arrayOfInt[101] = 30;
      arrayOfInt[102] = 31;
      arrayOfInt[103] = 32;
      arrayOfInt[104] = 33;
      arrayOfInt[105] = 34;
      arrayOfInt[106] = 35;
      arrayOfInt[107] = 36;
      arrayOfInt[108] = 37;
      arrayOfInt[109] = 38;
      arrayOfInt[110] = 39;
      arrayOfInt[111] = 40;
      arrayOfInt[112] = 41;
      arrayOfInt[113] = 42;
      arrayOfInt[114] = 43;
      arrayOfInt[115] = 44;
      arrayOfInt[116] = 45;
      arrayOfInt[117] = 46;
      arrayOfInt[118] = 47;
      arrayOfInt[119] = 48;
      arrayOfInt[120] = 49;
      arrayOfInt[121] = 50;
      arrayOfInt[122] = 51;
      arrayOfInt[123] = -1;
      arrayOfInt[124] = -1;
      arrayOfInt[125] = -1;
      arrayOfInt[126] = -1;
      arrayOfInt[127] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[''] = -1;
      arrayOfInt[' '] = -1;
      arrayOfInt['¡'] = -1;
      arrayOfInt['¢'] = -1;
      arrayOfInt['£'] = -1;
      arrayOfInt['¤'] = -1;
      arrayOfInt['¥'] = -1;
      arrayOfInt['¦'] = -1;
      arrayOfInt['§'] = -1;
      arrayOfInt['¨'] = -1;
      arrayOfInt['©'] = -1;
      arrayOfInt['ª'] = -1;
      arrayOfInt['«'] = -1;
      arrayOfInt['¬'] = -1;
      arrayOfInt['­'] = -1;
      arrayOfInt['®'] = -1;
      arrayOfInt['¯'] = -1;
      arrayOfInt['°'] = -1;
      arrayOfInt['±'] = -1;
      arrayOfInt['²'] = -1;
      arrayOfInt['³'] = -1;
      arrayOfInt['´'] = -1;
      arrayOfInt['µ'] = -1;
      arrayOfInt['¶'] = -1;
      arrayOfInt['·'] = -1;
      arrayOfInt['¸'] = -1;
      arrayOfInt['¹'] = -1;
      arrayOfInt['º'] = -1;
      arrayOfInt['»'] = -1;
      arrayOfInt['¼'] = -1;
      arrayOfInt['½'] = -1;
      arrayOfInt['¾'] = -1;
      arrayOfInt['¿'] = -1;
      arrayOfInt['À'] = -1;
      arrayOfInt['Á'] = -1;
      arrayOfInt['Â'] = -1;
      arrayOfInt['Ã'] = -1;
      arrayOfInt['Ä'] = -1;
      arrayOfInt['Å'] = -1;
      arrayOfInt['Æ'] = -1;
      arrayOfInt['Ç'] = -1;
      arrayOfInt['È'] = -1;
      arrayOfInt['É'] = -1;
      arrayOfInt['Ê'] = -1;
      arrayOfInt['Ë'] = -1;
      arrayOfInt['Ì'] = -1;
      arrayOfInt['Í'] = -1;
      arrayOfInt['Î'] = -1;
      arrayOfInt['Ï'] = -1;
      arrayOfInt['Ð'] = -1;
      arrayOfInt['Ñ'] = -1;
      arrayOfInt['Ò'] = -1;
      arrayOfInt['Ó'] = -1;
      arrayOfInt['Ô'] = -1;
      arrayOfInt['Õ'] = -1;
      arrayOfInt['Ö'] = -1;
      arrayOfInt['×'] = -1;
      arrayOfInt['Ø'] = -1;
      arrayOfInt['Ù'] = -1;
      arrayOfInt['Ú'] = -1;
      arrayOfInt['Û'] = -1;
      arrayOfInt['Ü'] = -1;
      arrayOfInt['Ý'] = -1;
      arrayOfInt['Þ'] = -1;
      arrayOfInt['ß'] = -1;
      arrayOfInt['à'] = -1;
      arrayOfInt['á'] = -1;
      arrayOfInt['â'] = -1;
      arrayOfInt['ã'] = -1;
      arrayOfInt['ä'] = -1;
      arrayOfInt['å'] = -1;
      arrayOfInt['æ'] = -1;
      arrayOfInt['ç'] = -1;
      arrayOfInt['è'] = -1;
      arrayOfInt['é'] = -1;
      arrayOfInt['ê'] = -1;
      arrayOfInt['ë'] = -1;
      arrayOfInt['ì'] = -1;
      arrayOfInt['í'] = -1;
      arrayOfInt['î'] = -1;
      arrayOfInt['ï'] = -1;
      arrayOfInt['ð'] = -1;
      arrayOfInt['ñ'] = -1;
      arrayOfInt['ò'] = -1;
      arrayOfInt['ó'] = -1;
      arrayOfInt['ô'] = -1;
      arrayOfInt['õ'] = -1;
      arrayOfInt['ö'] = -1;
      arrayOfInt['÷'] = -1;
      arrayOfInt['ø'] = -1;
      arrayOfInt['ù'] = -1;
      arrayOfInt['ú'] = -1;
      arrayOfInt['û'] = -1;
      arrayOfInt['ü'] = -1;
      arrayOfInt['ý'] = -1;
      arrayOfInt['þ'] = -1;
      arrayOfInt['ÿ'] = -1;
      d = arrayOfInt;
    }
    
    public b(byte[] paramArrayOfByte)
    {
      this.a = paramArrayOfByte;
      this.g = c;
      this.e = 0;
      this.f = 0;
    }
    
    public final boolean a(byte[] paramArrayOfByte, int paramInt)
    {
      boolean bool;
      if (this.e == 6) {
        bool = false;
      }
      for (;;)
      {
        return bool;
        int i2 = paramInt + 0;
        int i = this.e;
        int j = this.f;
        byte[] arrayOfByte = this.a;
        int[] arrayOfInt = this.g;
        paramInt = 0;
        int k = 0;
        label48:
        int n;
        if (paramInt >= i2)
        {
          n = j;
          j = k;
          label62:
          paramInt = j;
        }
        switch (i)
        {
        default: 
          paramInt = j;
        case 0: 
        case 1: 
        case 2: 
        case 3: 
          for (;;)
          {
            this.e = i;
            this.b = paramInt;
            bool = true;
            break;
            int m = k;
            n = j;
            int i1 = paramInt;
            if (i == 0)
            {
              m = paramInt;
              paramInt = j;
              label140:
              if (m + 4 <= i2)
              {
                paramInt = arrayOfInt[(paramArrayOfByte[m] & 0xFF)] << 18 | arrayOfInt[(paramArrayOfByte[(m + 1)] & 0xFF)] << 12 | arrayOfInt[(paramArrayOfByte[(m + 2)] & 0xFF)] << 6 | arrayOfInt[(paramArrayOfByte[(m + 3)] & 0xFF)];
                if (paramInt >= 0) {
                  break label311;
                }
              }
              j = k;
              n = paramInt;
              if (m >= i2) {
                break label62;
              }
              i1 = m;
              n = paramInt;
              m = k;
            }
            paramInt = i1 + 1;
            j = arrayOfInt[(paramArrayOfByte[i1] & 0xFF)];
            switch (i)
            {
            }
            label311:
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        k = m;
                        j = n;
                        break;
                        arrayOfByte[(k + 2)] = ((byte)paramInt);
                        arrayOfByte[(k + 1)] = ((byte)(paramInt >> 8));
                        arrayOfByte[k] = ((byte)(paramInt >> 16));
                        k += 3;
                        m += 4;
                        break label140;
                        if (j >= 0)
                        {
                          i++;
                          k = m;
                          break;
                        }
                      } while (j == -1);
                      this.e = 6;
                      bool = false;
                      break;
                      if (j >= 0)
                      {
                        j = n << 6 | j;
                        i++;
                        k = m;
                        break label48;
                      }
                    } while (j == -1);
                    this.e = 6;
                    bool = false;
                    break;
                    if (j >= 0)
                    {
                      j = n << 6 | j;
                      i++;
                      k = m;
                      break label48;
                    }
                    if (j == -2)
                    {
                      arrayOfByte[m] = ((byte)(n >> 4));
                      i = 4;
                      k = m + 1;
                      j = n;
                      break label48;
                    }
                  } while (j == -1);
                  this.e = 6;
                  bool = false;
                  break;
                  if (j >= 0)
                  {
                    j = n << 6 | j;
                    arrayOfByte[(m + 2)] = ((byte)j);
                    arrayOfByte[(m + 1)] = ((byte)(j >> 8));
                    arrayOfByte[m] = ((byte)(j >> 16));
                    k = m + 3;
                    i = 0;
                    break label48;
                  }
                  if (j == -2)
                  {
                    arrayOfByte[(m + 1)] = ((byte)(n >> 2));
                    arrayOfByte[m] = ((byte)(n >> 10));
                    k = m + 2;
                    i = 5;
                    j = n;
                    break label48;
                  }
                } while (j == -1);
                this.e = 6;
                bool = false;
                break;
                if (j == -2)
                {
                  i++;
                  k = m;
                  j = n;
                  break label48;
                }
              } while (j == -1);
              this.e = 6;
              bool = false;
              break;
            } while (j == -1);
            this.e = 6;
            bool = false;
            break;
            this.e = 6;
            bool = false;
            break;
            arrayOfByte[j] = ((byte)(n >> 4));
            paramInt = j + 1;
            continue;
            k = j + 1;
            arrayOfByte[j] = ((byte)(n >> 10));
            paramInt = k + 1;
            arrayOfByte[k] = ((byte)(n >> 2));
          }
        }
        this.e = 6;
        bool = false;
      }
    }
  }
  
  static final class c
    extends b.a
  {
    private static final byte[] h;
    private static final byte[] i;
    int c;
    public final boolean d;
    public final boolean e;
    public final boolean f;
    private final byte[] j;
    private int k;
    private final byte[] l;
    
    static
    {
      if (!b.class.desiredAssertionStatus()) {}
      for (boolean bool = true;; bool = false)
      {
        g = bool;
        h = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47 };
        i = new byte[] { 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95 };
        return;
      }
    }
    
    public c(int paramInt)
    {
      this.a = null;
      boolean bool1;
      label32:
      label45:
      byte[] arrayOfByte;
      if ((paramInt & 0x1) == 0)
      {
        bool1 = true;
        this.d = bool1;
        if ((paramInt & 0x2) != 0) {
          break label101;
        }
        bool1 = true;
        this.e = bool1;
        if ((paramInt & 0x4) == 0) {
          break label106;
        }
        bool1 = bool2;
        this.f = bool1;
        if ((paramInt & 0x8) != 0) {
          break label111;
        }
        arrayOfByte = h;
        label62:
        this.l = arrayOfByte;
        this.j = new byte[2];
        this.c = 0;
        if (!this.e) {
          break label119;
        }
      }
      label101:
      label106:
      label111:
      label119:
      for (paramInt = 19;; paramInt = -1)
      {
        this.k = paramInt;
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label32;
        bool1 = false;
        break label45;
        arrayOfByte = i;
        break label62;
      }
    }
    
    public final boolean a(byte[] paramArrayOfByte, int paramInt)
    {
      int n = 0;
      byte[] arrayOfByte1 = this.l;
      byte[] arrayOfByte2 = this.a;
      int i1 = this.k;
      int i5 = paramInt + 0;
      int m;
      label60:
      int i2;
      switch (this.c)
      {
      default: 
        paramInt = -1;
        m = 0;
        if (paramInt != -1)
        {
          arrayOfByte2[0] = arrayOfByte1[(paramInt >> 18 & 0x3F)];
          arrayOfByte2[1] = arrayOfByte1[(paramInt >> 12 & 0x3F)];
          arrayOfByte2[2] = arrayOfByte1[(paramInt >> 6 & 0x3F)];
          i2 = 4;
          arrayOfByte2[3] = arrayOfByte1[(paramInt & 0x3F)];
          i1--;
          if (i1 == 0)
          {
            paramInt = i2;
            if (this.f)
            {
              paramInt = 5;
              arrayOfByte2[4] = 13;
            }
            i2 = paramInt + 1;
            arrayOfByte2[paramInt] = 10;
            i1 = 19;
            paramInt = i2;
          }
        }
        break;
      }
      for (;;)
      {
        label204:
        int i3;
        if (m + 3 > i5)
        {
          if (m - this.c != i5 - 1) {
            break label661;
          }
          if (this.c <= 0) {
            break label647;
          }
          i2 = this.j[0];
          n = 1;
          i2 = (i2 & 0xFF) << 4;
          this.c -= n;
          i3 = paramInt + 1;
          arrayOfByte2[paramInt] = arrayOfByte1[(i2 >> 6 & 0x3F)];
          n = i3 + 1;
          arrayOfByte2[i3] = arrayOfByte1[(i2 & 0x3F)];
          paramInt = n;
          if (this.d)
          {
            i2 = n + 1;
            arrayOfByte2[n] = 61;
            paramInt = i2 + 1;
            arrayOfByte2[i2] = 61;
          }
          if (!this.e) {
            break label1015;
          }
          n = paramInt;
          if (this.f)
          {
            arrayOfByte2[paramInt] = 13;
            n = paramInt + 1;
          }
          paramInt = n + 1;
          arrayOfByte2[n] = 10;
          n = paramInt;
          i2 = m;
          label345:
          if ((g) || (this.c == 0)) {
            break label968;
          }
          throw new AssertionError();
          paramInt = -1;
          m = 0;
          break label60;
          if (2 > i5) {
            break;
          }
          m = this.j[0];
          i2 = paramArrayOfByte[0];
          paramInt = paramArrayOfByte[1];
          this.c = 0;
          paramInt = (m & 0xFF) << 16 | (i2 & 0xFF) << 8 | paramInt & 0xFF;
          m = 2;
          break label60;
          if (i5 <= 0) {
            break;
          }
          m = this.j[0];
          i2 = this.j[1];
          paramInt = paramArrayOfByte[0];
          this.c = 0;
          paramInt = (m & 0xFF) << 16 | (i2 & 0xFF) << 8 | paramInt & 0xFF;
          m = 1;
          break label60;
        }
        i2 = (paramArrayOfByte[m] & 0xFF) << 16 | (paramArrayOfByte[(m + 1)] & 0xFF) << 8 | paramArrayOfByte[(m + 2)] & 0xFF;
        arrayOfByte2[paramInt] = arrayOfByte1[(i2 >> 18 & 0x3F)];
        arrayOfByte2[(paramInt + 1)] = arrayOfByte1[(i2 >> 12 & 0x3F)];
        arrayOfByte2[(paramInt + 2)] = arrayOfByte1[(i2 >> 6 & 0x3F)];
        arrayOfByte2[(paramInt + 3)] = arrayOfByte1[(i2 & 0x3F)];
        m += 3;
        paramInt += 4;
        i1--;
        if (i1 == 0)
        {
          if (this.f)
          {
            i1 = paramInt + 1;
            arrayOfByte2[paramInt] = 13;
            paramInt = i1;
          }
          for (;;)
          {
            i1 = paramInt + 1;
            arrayOfByte2[paramInt] = 10;
            i2 = 19;
            paramInt = i1;
            i1 = i2;
            break;
            label647:
            i2 = paramArrayOfByte[m];
            n = 0;
            m++;
            break label204;
            label661:
            label693:
            int i4;
            if (m - this.c == i5 - 2) {
              if (this.c > 1)
              {
                i3 = this.j[0];
                n = 1;
                if (this.c <= 0) {
                  break label874;
                }
                i4 = this.j[n];
                n++;
                i2 = m;
                m = i4;
                label718:
                m = (m & 0xFF) << 2 | (i3 & 0xFF) << 10;
                this.c -= n;
                n = paramInt + 1;
                arrayOfByte2[paramInt] = arrayOfByte1[(m >> 12 & 0x3F)];
                i3 = n + 1;
                arrayOfByte2[n] = arrayOfByte1[(m >> 6 & 0x3F)];
                paramInt = i3 + 1;
                arrayOfByte2[i3] = arrayOfByte1[(m & 0x3F)];
                if (!this.d) {
                  break label1012;
                }
                m = paramInt + 1;
                arrayOfByte2[paramInt] = 61;
                paramInt = m;
              }
            }
            label874:
            label968:
            label1012:
            for (;;)
            {
              if (this.e)
              {
                m = paramInt;
                if (this.f)
                {
                  arrayOfByte2[paramInt] = 13;
                  m = paramInt + 1;
                }
                n = m + 1;
                arrayOfByte2[m] = 10;
                break;
                i3 = paramArrayOfByte[m];
                m++;
                break label693;
                i2 = paramArrayOfByte[m];
                i4 = m + 1;
                m = i2;
                i2 = i4;
                break label718;
                i2 = m;
                n = paramInt;
                if (!this.e) {
                  break;
                }
                i2 = m;
                n = paramInt;
                if (paramInt <= 0) {
                  break;
                }
                i2 = m;
                n = paramInt;
                if (i1 == 19) {
                  break;
                }
                if (this.f)
                {
                  n = paramInt + 1;
                  arrayOfByte2[paramInt] = 13;
                  paramInt = n;
                }
                for (;;)
                {
                  n = paramInt + 1;
                  arrayOfByte2[paramInt] = 10;
                  i2 = m;
                  break;
                  if ((!g) && (i2 != i5)) {
                    throw new AssertionError();
                  }
                  this.b = n;
                  this.k = i1;
                  return true;
                }
              }
              n = paramInt;
              break;
            }
            label1015:
            i2 = m;
            n = paramInt;
            break label345;
          }
        }
        continue;
        paramInt = 4;
        continue;
        paramInt = 0;
      }
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/a/a/a/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */