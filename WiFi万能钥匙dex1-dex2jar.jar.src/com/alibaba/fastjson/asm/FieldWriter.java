package com.alibaba.fastjson.asm;

final class FieldWriter
  implements FieldVisitor
{
  private final int access;
  private final int desc;
  private final int name;
  FieldWriter next;
  
  FieldWriter(ClassWriter paramClassWriter, int paramInt, String paramString1, String paramString2)
  {
    if (paramClassWriter.firstField == null) {
      paramClassWriter.firstField = this;
    }
    for (;;)
    {
      paramClassWriter.lastField = this;
      this.access = paramInt;
      this.name = paramClassWriter.newUTF8(paramString1);
      this.desc = paramClassWriter.newUTF8(paramString2);
      return;
      paramClassWriter.lastField.next = this;
    }
  }
  
  final int getSize()
  {
    return 8;
  }
  
  final void put(ByteVector paramByteVector)
  {
    paramByteVector.putShort(((0x60000 | (this.access & 0x40000) / 64) ^ 0xFFFFFFFF) & this.access).putShort(this.name).putShort(this.desc);
    paramByteVector.putShort(0);
  }
  
  public final void visitEnd() {}
}


/* Location:              /Users/hanlian/Downloads/WiFi万能钥匙dex1-dex2jar.jar!/com/alibaba/fastjson/asm/FieldWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */