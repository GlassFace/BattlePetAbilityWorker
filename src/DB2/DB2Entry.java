package DB2;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class DB2Entry
{
    protected ByteBuffer buffer;

    public DB2Entry(byte[] array)
    {
        buffer = ByteBuffer.wrap(array);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
    }
}
