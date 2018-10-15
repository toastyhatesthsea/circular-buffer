/**
 * A circular ring buffer data structure
 * @param <E>
 */
public class CircularBuffer <E>
{

    private Object[] data;
    private int current;
    private int currentRead;
    private int totalElements;

    public CircularBuffer(int i)
    {
        data = new Object[i];
        current = 0;
        currentRead = 0;
        totalElements = 0;
    }

    /**
     * Writes element to front of buffer. When buffer is full will no longer write.
     * @param i
     * @throws BufferIOException
     */
    public void write(E i)throws BufferIOException
    {
        //currentRead = current;
        if (totalElements == data.length)
        {
            throw new BufferIOException("Tried to write to full buffer");
        }
        data[current] = i;

        if (current == data.length - 1)
        {
            current = 0;
        }
        else
        {
            current++;
        }
        totalElements++;
    }

    public void clear()
    {
        data = new Object[data.length];
        currentRead = 0;
        current = 0;
        totalElements = 0;
    }


    /**
     * Removes oldest element and returns it.
     * @return E
     * @throws BufferIOException
     */
    public E read() throws BufferIOException
    {
        E answer = null;

        try
        {
            answer = (E) data[currentRead];
        } catch (IndexOutOfBoundsException e)
        {
            throw new BufferIOException("Tried to read from empty buffer");
        }

        if (answer == null)
        {
            throw new BufferIOException("Tried to read from empty buffer");
        }
        //current = currentRead;
        data[currentRead] = null;

        if (currentRead == data.length-1)
        {
            currentRead = 0;
            totalElements--;
        }
        else
        {
            currentRead++;
            totalElements--;
        }
        return answer;
    }

    /**
     * Acts as normal write function if buffer is not full. If full, removes oldest element and overwrites the newest.
     * @param i E
     * @throws BufferIOException
     */
    public void overwrite(E i)throws BufferIOException
    {
        if (totalElements < data.length)
        {
            write(i);
        }
        else
        {
            read();
            write(i);
        }
    }
}
