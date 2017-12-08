package com.alibaba.fastjson.asm;

final class Item
{
  int hashCode;
  int index;
  int intVal;
  long longVal;
  Item next;
  String strVal1;
  String strVal2;
  String strVal3;
  int type;
  
  Item() {}
  
  Item(int paramInt, Item paramItem)
  {
    this.index = paramInt;
    this.type = paramItem.type;
    this.intVal = paramItem.intVal;
    this.longVal = paramItem.longVal;
    this.strVal1 = paramItem.strVal1;
    this.strVal2 = paramItem.strVal2;
    this.strVal3 = paramItem.strVal3;
    this.hashCode = paramItem.hashCode;
  }
  
  final boolean isEqualTo(Item paramItem)
  {
    boolean bool = true;
    switch (this.type)
    {
    case 2: 
    case 9: 
    case 10: 
    case 11: 
    case 14: 
    default: 
      if ((!paramItem.strVal1.equals(this.strVal1)) || (!paramItem.strVal2.equals(this.strVal2)) || (!paramItem.strVal3.equals(this.strVal3))) {
        break;
      }
    }
    for (;;)
    {
      return bool;
      bool = paramItem.strVal1.equals(this.strVal1);
      continue;
      if (paramItem.longVal != this.longVal)
      {
        bool = false;
        continue;
        if (paramItem.intVal != this.intVal)
        {
          bool = false;
          continue;
          if ((!paramItem.strVal1.equals(this.strVal1)) || (!paramItem.strVal2.equals(this.strVal2)))
          {
            bool = false;
            continue;
            bool = false;
          }
        }
      }
    }
  }
  
  final void set(int paramInt)
  {
    this.type = 3;
    this.intVal = paramInt;
    this.hashCode = (0x7FFFFFFF & this.type + paramInt);
  }
  
  final void set(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.type = paramInt;
    this.strVal1 = paramString1;
    this.strVal2 = paramString2;
    this.strVal3 = paramString3;
    switch (paramInt)
    {
    default: 
      this.hashCode = (paramString1.hashCode() * paramString2.hashCode() * paramString3.hashCode() + paramInt & 0x7FFFFFFF);
    }
    for (;;)
    {
      return;
      this.hashCode = (paramString1.hashCode() + paramInt & 0x7FFFFFFF);
      continue;
      this.hashCode = (paramString1.hashCode() * paramString2.hashCode() + paramInt & 0x7FFFFFFF);
    }
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/asm/Item.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */