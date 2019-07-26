使用Buffer读写数据一般需要循环执行以下四个步骤：

```text
1.写入数据到Buffer
2.调用flip()方法
3.从Buffer中读取数据
4.调用compact()方法
```
例如<code>com.lsm.nio.ChannelCopy</code>

代码片段如下
```java
private static void copy1(ReadableByteChannel src, WritableByteChannel des) throws Exception {

    ByteBuffer tmp = ByteBuffer.allocate(16 * 1024);
    while (src.read(tmp) != -1) {
        tmp.flip();
        des.write(tmp);
        tmp.compact();
    }
    tmp.flip();
    while (tmp.hasRemaining()) {
        des.write(tmp);
    }
}
```
