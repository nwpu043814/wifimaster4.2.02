package com.alibaba.fastjson.asm;

public class ClassWriter
{
  static final int ACC_SYNTHETIC_ATTRIBUTE = 262144;
  static final int CLASS = 7;
  public static final int COMPUTE_FRAMES = 2;
  public static final int COMPUTE_MAXS = 1;
  static final int DOUBLE = 6;
  static final int FIELD = 9;
  static final int FIELDORMETH_INSN = 6;
  static final int FLOAT = 4;
  static final int IINC_INSN = 12;
  static final int IMETH = 11;
  static final int IMPLVAR_INSN = 4;
  static final int INT = 3;
  static final int ITFDYNMETH_INSN = 7;
  static final int LABELW_INSN = 9;
  static final int LABEL_INSN = 8;
  static final int LDCW_INSN = 11;
  static final int LDC_INSN = 10;
  static final int LONG = 5;
  static final int LOOK_INSN = 14;
  static final int MANA_INSN = 15;
  static final int METH = 10;
  static final int NAME_TYPE = 12;
  static final int NOARG_INSN = 0;
  static final int SBYTE_INSN = 1;
  static final int SHORT_INSN = 2;
  static final int STR = 8;
  static final int TABL_INSN = 13;
  static final byte[] TYPE;
  static final int TYPE_INSN = 5;
  static final int TYPE_MERGED = 15;
  static final int TYPE_NORMAL = 13;
  static final int TYPE_UNINIT = 14;
  static final int UTF8 = 1;
  static final int VAR_INSN = 3;
  static final int WIDE_INSN = 16;
  private int access;
  FieldWriter firstField;
  MethodWriter firstMethod;
  int index = 1;
  private int interfaceCount;
  private int[] interfaces;
  Item[] items = new Item['Ā'];
  final Item key = new Item();
  final Item key2 = new Item();
  final Item key3 = new Item();
  FieldWriter lastField;
  MethodWriter lastMethod;
  private int name;
  final ByteVector pool = new ByteVector();
  private int superName;
  String thisName;
  int threshold = (int)(0.75D * this.items.length);
  Item[] typeTable;
  int version;
  
  static
  {
    byte[] arrayOfByte = new byte['Ü'];
    for (int i = 0; i < 220; i++) {
      arrayOfByte[i] = ((byte)("AAAAAAAAAAAAAAAABCKLLDDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAADDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAMAAAAAAAAAAAAAAAAAAAAIIIIIIIIIIIIIIIIDNOAAAAAAGGGGGGGHHFBFAAFFAAQPIIJJIIIIIIIIIIIIIIIIII".charAt(i) - 'A'));
    }
    TYPE = arrayOfByte;
  }
  
  public ClassWriter()
  {
    this(0);
  }
  
  private ClassWriter(int paramInt) {}
  
  private Item get(Item paramItem)
  {
    for (Item localItem = this.items[(paramItem.hashCode % this.items.length)]; (localItem != null) && ((localItem.type != paramItem.type) || (!paramItem.isEqualTo(localItem))); localItem = localItem.next) {}
    return localItem;
  }
  
  private Item newString(String paramString)
  {
    this.key2.set(8, paramString, null, null);
    Item localItem2 = get(this.key2);
    Item localItem1 = localItem2;
    if (localItem2 == null)
    {
      this.pool.put12(8, newUTF8(paramString));
      int i = this.index;
      this.index = (i + 1);
      localItem1 = new Item(i, this.key2);
      put(localItem1);
    }
    return localItem1;
  }
  
  private void put(Item paramItem)
  {
    if (this.index > this.threshold)
    {
      i = this.items.length;
      int j = i * 2 + 1;
      Item[] arrayOfItem = new Item[j];
      i--;
      while (i >= 0)
      {
        Item localItem;
        for (Object localObject = this.items[i]; localObject != null; localObject = localItem)
        {
          int k = ((Item)localObject).hashCode % j;
          localItem = ((Item)localObject).next;
          ((Item)localObject).next = arrayOfItem[k];
          arrayOfItem[k] = localObject;
        }
        i--;
      }
      this.items = arrayOfItem;
      this.threshold = ((int)(j * 0.75D));
    }
    int i = paramItem.hashCode % this.items.length;
    paramItem.next = this.items[i];
    this.items[i] = paramItem;
  }
  
  private void put122(int paramInt1, int paramInt2, int paramInt3)
  {
    this.pool.put12(paramInt1, paramInt2).putShort(paramInt3);
  }
  
  public int newClass(String paramString)
  {
    return newClassItem(paramString).index;
  }
  
  Item newClassItem(String paramString)
  {
    this.key2.set(7, paramString, null, null);
    Item localItem2 = get(this.key2);
    Item localItem1 = localItem2;
    if (localItem2 == null)
    {
      this.pool.put12(7, newUTF8(paramString));
      int i = this.index;
      this.index = (i + 1);
      localItem1 = new Item(i, this.key2);
      put(localItem1);
    }
    return localItem1;
  }
  
  Item newConstItem(Object paramObject)
  {
    if ((paramObject instanceof Integer)) {}
    for (paramObject = newInteger(((Integer)paramObject).intValue());; paramObject = newString((String)paramObject))
    {
      return (Item)paramObject;
      if (!(paramObject instanceof String)) {
        break;
      }
    }
    if ((paramObject instanceof Type))
    {
      paramObject = (Type)paramObject;
      if (((Type)paramObject).getSort() == 10) {}
      for (paramObject = ((Type)paramObject).getInternalName();; paramObject = ((Type)paramObject).getDescriptor())
      {
        paramObject = newClassItem((String)paramObject);
        break;
      }
    }
    throw new IllegalArgumentException("value " + paramObject);
  }
  
  Item newFieldItem(String paramString1, String paramString2, String paramString3)
  {
    this.key3.set(9, paramString1, paramString2, paramString3);
    Item localItem2 = get(this.key3);
    Item localItem1 = localItem2;
    if (localItem2 == null)
    {
      put122(9, newClass(paramString1), newNameType(paramString2, paramString3));
      int i = this.index;
      this.index = (i + 1);
      localItem1 = new Item(i, this.key3);
      put(localItem1);
    }
    return localItem1;
  }
  
  Item newInteger(int paramInt)
  {
    this.key.set(paramInt);
    Item localItem2 = get(this.key);
    Item localItem1 = localItem2;
    if (localItem2 == null)
    {
      this.pool.putByte(3).putInt(paramInt);
      paramInt = this.index;
      this.index = (paramInt + 1);
      localItem1 = new Item(paramInt, this.key);
      put(localItem1);
    }
    return localItem1;
  }
  
  Item newMethodItem(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    int i;
    Item localItem;
    if (paramBoolean)
    {
      i = 11;
      this.key3.set(i, paramString1, paramString2, paramString3);
      localItem = get(this.key3);
      if (localItem != null) {
        break label95;
      }
      put122(i, newClass(paramString1), newNameType(paramString2, paramString3));
      i = this.index;
      this.index = (i + 1);
      paramString1 = new Item(i, this.key3);
      put(paramString1);
    }
    for (;;)
    {
      return paramString1;
      i = 10;
      break;
      label95:
      paramString1 = localItem;
    }
  }
  
  public int newNameType(String paramString1, String paramString2)
  {
    return newNameTypeItem(paramString1, paramString2).index;
  }
  
  Item newNameTypeItem(String paramString1, String paramString2)
  {
    this.key2.set(12, paramString1, paramString2, null);
    Item localItem2 = get(this.key2);
    Item localItem1 = localItem2;
    if (localItem2 == null)
    {
      put122(12, newUTF8(paramString1), newUTF8(paramString2));
      int i = this.index;
      this.index = (i + 1);
      localItem1 = new Item(i, this.key2);
      put(localItem1);
    }
    return localItem1;
  }
  
  public int newUTF8(String paramString)
  {
    this.key.set(1, paramString, null, null);
    Item localItem2 = get(this.key);
    Item localItem1 = localItem2;
    if (localItem2 == null)
    {
      this.pool.putByte(1).putUTF8(paramString);
      int i = this.index;
      this.index = (i + 1);
      localItem1 = new Item(i, this.key);
      put(localItem1);
    }
    return localItem1.index;
  }
  
  public byte[] toByteArray()
  {
    int i = this.interfaceCount * 2 + 24;
    Object localObject = this.firstField;
    for (int j = 0; localObject != null; j++)
    {
      i += ((FieldWriter)localObject).getSize();
      localObject = ((FieldWriter)localObject).next;
    }
    localObject = this.firstMethod;
    int m = 0;
    int k = i;
    for (i = m; localObject != null; i++)
    {
      k += ((MethodWriter)localObject).getSize();
      localObject = ((MethodWriter)localObject).next;
    }
    ByteVector localByteVector = new ByteVector(this.pool.length + k);
    localByteVector.putInt(-889275714).putInt(this.version);
    localByteVector.putShort(this.index).putByteArray(this.pool.data, 0, this.pool.length);
    localByteVector.putShort(((0x60000 | (this.access & 0x40000) / 64) ^ 0xFFFFFFFF) & this.access).putShort(this.name).putShort(this.superName);
    localByteVector.putShort(this.interfaceCount);
    for (k = 0; k < this.interfaceCount; k++) {
      localByteVector.putShort(this.interfaces[k]);
    }
    localByteVector.putShort(j);
    for (localObject = this.firstField; localObject != null; localObject = ((FieldWriter)localObject).next) {
      ((FieldWriter)localObject).put(localByteVector);
    }
    localByteVector.putShort(i);
    for (localObject = this.firstMethod; localObject != null; localObject = ((MethodWriter)localObject).next) {
      ((MethodWriter)localObject).put(localByteVector);
    }
    localByteVector.putShort(0);
    return localByteVector.data;
  }
  
  public void visit(int paramInt1, int paramInt2, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    int i = 0;
    this.version = paramInt1;
    this.access = paramInt2;
    this.name = newClass(paramString1);
    this.thisName = paramString1;
    if (paramString2 == null) {}
    for (paramInt1 = 0;; paramInt1 = newClass(paramString2))
    {
      this.superName = paramInt1;
      if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0)) {
        break;
      }
      this.interfaceCount = paramArrayOfString.length;
      this.interfaces = new int[this.interfaceCount];
      for (paramInt1 = i; paramInt1 < this.interfaceCount; paramInt1++) {
        this.interfaces[paramInt1] = newClass(paramArrayOfString[paramInt1]);
      }
    }
  }
  
  public FieldVisitor visitField(int paramInt, String paramString1, String paramString2)
  {
    return new FieldWriter(this, paramInt, paramString1, paramString2);
  }
  
  public MethodVisitor visitMethod(int paramInt, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
  {
    return new MethodWriter(this, paramInt, paramString1, paramString2, paramString3, paramArrayOfString);
  }
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/asm/ClassWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */