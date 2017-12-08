package com.alibaba.fastjson.parser;

import com.alibaba.fastjson.JSON;

public class SymbolTable
{
  public static final int DEFAULT_TABLE_SIZE = 256;
  public static final int MAX_BUCKET_LENTH = 8;
  public static final int MAX_SIZE = 2048;
  private final Entry[] buckets;
  private final int indexMask;
  private int size = 0;
  private final String[] symbols;
  private final char[][] symbols_char;
  
  public SymbolTable()
  {
    this(256);
    addSymbol("$ref", 0, 4, "$ref".hashCode());
    addSymbol(JSON.DEFAULT_TYPE_KEY, 0, 4, JSON.DEFAULT_TYPE_KEY.hashCode());
  }
  
  public SymbolTable(int paramInt)
  {
    this.indexMask = (paramInt - 1);
    this.buckets = new Entry[paramInt];
    this.symbols = new String[paramInt];
    this.symbols_char = new char[paramInt][];
  }
  
  public static final int hash(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int j = 0;
    int i = 0;
    while (j < paramInt2)
    {
      i = i * 31 + paramArrayOfChar[paramInt1];
      j++;
      paramInt1++;
    }
    return i;
  }
  
  public String addSymbol(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    int m = paramInt3 & this.indexMask;
    Object localObject = this.symbols[m];
    char[] arrayOfChar;
    int i;
    if (localObject != null) {
      if (((String)localObject).length() == paramInt2)
      {
        arrayOfChar = this.symbols_char[m];
        for (i = 0;; i++)
        {
          if (i >= paramInt2) {
            break label328;
          }
          if (paramString.charAt(paramInt1 + i) != arrayOfChar[i])
          {
            i = 0;
            if (i == 0) {
              break;
            }
            paramString = (String)localObject;
            return paramString;
          }
        }
      }
    }
    for (;;)
    {
      label85:
      localObject = this.buckets[m];
      int j = 0;
      label97:
      if (localObject != null)
      {
        arrayOfChar = ((Entry)localObject).characters;
        k = j;
        if (paramInt2 == arrayOfChar.length)
        {
          k = j;
          if (paramInt3 == ((Entry)localObject).hashCode)
          {
            k = 0;
            label137:
            if (k >= paramInt2) {
              break label322;
            }
            if (paramString.charAt(paramInt1 + k) == arrayOfChar[k]) {
              break label193;
            }
          }
        }
      }
      label193:
      label322:
      for (int k = 0;; k = 1)
      {
        if (k == 0)
        {
          k = j + 1;
          localObject = ((Entry)localObject).next;
          j = k;
          break label97;
          i = 0;
          break label85;
          k++;
          break label137;
        }
        paramString = ((Entry)localObject).symbol;
        break;
        if (j >= 8)
        {
          paramString = paramString.substring(paramInt1, paramInt1 + paramInt2);
          break;
        }
        if (this.size >= 2048)
        {
          paramString = paramString.substring(paramInt1, paramInt1 + paramInt2);
          break;
        }
        paramString = new Entry(paramString, paramInt1, paramInt2, paramInt3, this.buckets[m]);
        this.buckets[m] = paramString;
        if (i != 0)
        {
          this.symbols[m] = paramString.symbol;
          this.symbols_char[m] = paramString.characters;
        }
        this.size += 1;
        paramString = paramString.symbol;
        break;
      }
      label328:
      i = 1;
      break;
      i = 1;
    }
  }
  
  public String addSymbol(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    return addSymbol(paramArrayOfChar, paramInt1, paramInt2, hash(paramArrayOfChar, paramInt1, paramInt2));
  }
  
  public String addSymbol(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3)
  {
    int m = paramInt3 & this.indexMask;
    Object localObject = this.symbols[m];
    char[] arrayOfChar;
    int i;
    if (localObject != null) {
      if (((String)localObject).length() == paramInt2)
      {
        arrayOfChar = this.symbols_char[m];
        for (i = 0;; i++)
        {
          if (i >= paramInt2) {
            break label328;
          }
          if (paramArrayOfChar[(paramInt1 + i)] != arrayOfChar[i])
          {
            i = 0;
            if (i == 0) {
              break;
            }
            paramArrayOfChar = (char[])localObject;
            return paramArrayOfChar;
          }
        }
      }
    }
    for (;;)
    {
      label83:
      localObject = this.buckets[m];
      int j = 0;
      label95:
      if (localObject != null)
      {
        arrayOfChar = ((Entry)localObject).characters;
        k = j;
        if (paramInt2 == arrayOfChar.length)
        {
          k = j;
          if (paramInt3 == ((Entry)localObject).hashCode)
          {
            k = 0;
            label135:
            if (k >= paramInt2) {
              break label322;
            }
            if (paramArrayOfChar[(paramInt1 + k)] == arrayOfChar[k]) {
              break label189;
            }
          }
        }
      }
      label189:
      label322:
      for (int k = 0;; k = 1)
      {
        if (k == 0)
        {
          k = j + 1;
          localObject = ((Entry)localObject).next;
          j = k;
          break label95;
          i = 0;
          break label83;
          k++;
          break label135;
        }
        paramArrayOfChar = ((Entry)localObject).symbol;
        break;
        if (j >= 8)
        {
          paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
          break;
        }
        if (this.size >= 2048)
        {
          paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
          break;
        }
        paramArrayOfChar = new Entry(paramArrayOfChar, paramInt1, paramInt2, paramInt3, this.buckets[m]);
        this.buckets[m] = paramArrayOfChar;
        if (i != 0)
        {
          this.symbols[m] = paramArrayOfChar.symbol;
          this.symbols_char[m] = paramArrayOfChar.characters;
        }
        this.size += 1;
        paramArrayOfChar = paramArrayOfChar.symbol;
        break;
      }
      label328:
      i = 1;
      break;
      i = 1;
    }
  }
  
  public int size()
  {
    return this.size;
  }
  
  protected static final class Entry
  {
    public final byte[] bytes;
    public final char[] characters;
    public final int hashCode;
    public Entry next;
    public final String symbol;
    
    public Entry(String paramString, int paramInt1, int paramInt2, int paramInt3, Entry paramEntry)
    {
      this.symbol = paramString.substring(paramInt1, paramInt1 + paramInt2).intern();
      this.characters = this.symbol.toCharArray();
      this.next = paramEntry;
      this.hashCode = paramInt3;
      this.bytes = null;
    }
    
    public Entry(char[] paramArrayOfChar, int paramInt1, int paramInt2, int paramInt3, Entry paramEntry)
    {
      this.characters = new char[paramInt2];
      System.arraycopy(paramArrayOfChar, paramInt1, this.characters, 0, paramInt2);
      this.symbol = new String(this.characters).intern();
      this.next = paramEntry;
      this.hashCode = paramInt3;
      this.bytes = null;
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/parser/SymbolTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */