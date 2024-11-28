import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class PageHeader {
    public byte[] rawHeader;
    public static final int SIZE = 24;
    long pg_lsn;
    short pd_checksum;
    short pg_flags;
    short pd_lower;
    short pd_upper;
    short pd_special;
    short pd_pagesize_version;
    int pd_prune_xid;

    public PageHeader()
    {
        rawHeader = new byte[SIZE];
    }
    public void ParseAndFill() {
        pg_lsn = BytesToLong(rawHeader, 0);
        pd_checksum = BytesToShort(rawHeader, 8);
        pg_flags = BytesToShort(rawHeader, 10);
        pd_lower = BytesToShort(rawHeader, 12);
        pd_upper = BytesToShort(rawHeader, 14);
        pd_special = BytesToShort(rawHeader, 16);
        pd_pagesize_version = BytesToShort(rawHeader, 18);
        pd_prune_xid = BytesToInt(rawHeader, 20);
    }

    private long BytesToLong(byte[] bytes, int offset) {
        // Проверяем, что массив достаточно большой
        if (bytes.length < offset + 8) {
            throw new IllegalArgumentException("Byte array is too small to contain a long value");
        }

        // Используем ByteBuffer для преобразования байт в long
        ByteBuffer buffer = ByteBuffer.allocate(8);
        buffer.order(ByteOrder.LITTLE_ENDIAN); // Устанавливаем порядок байт (BIG_ENDIAN или LITTLE_ENDIAN)
        buffer.put(bytes, offset, 8);
        buffer.flip();

        return buffer.getLong();
    }

    private int BytesToInt(byte[] bytes, int offset) {
        // Проверяем, что массив достаточно большой
        if (bytes.length < offset + 4) {
            throw new IllegalArgumentException("Byte array is too small to contain a long value");
        }

        // Используем ByteBuffer для преобразования байт в long
        ByteBuffer buffer = ByteBuffer.allocate(4);
        buffer.order(ByteOrder.LITTLE_ENDIAN); // Устанавливаем порядок байт (BIG_ENDIAN или LITTLE_ENDIAN)
        buffer.put(bytes, offset, 4);
        buffer.flip();

        return buffer.getInt();
    }

    private short BytesToShort(byte[] bytes, int offset) {
        // Проверяем, что массив достаточно большой
        if (bytes.length < offset + 2) {
            throw new IllegalArgumentException("Byte array is too small to contain a long value");
        }

        // Используем ByteBuffer для преобразования байт в long
        ByteBuffer buffer = ByteBuffer.allocate(2);
        buffer.order(ByteOrder.LITTLE_ENDIAN); // Устанавливаем порядок байт (BIG_ENDIAN или LITTLE_ENDIAN)
        buffer.put(bytes, offset, 2);
        buffer.flip();

        return buffer.getShort();
    }
}
