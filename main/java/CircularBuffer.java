public class CircularBuffer <E>
{

    private Object[] data;
    private int current;
    private int totalElements;

    public CircularBuffer(int i)
    {
        data = new Object[i];
        current = 0;
        totalElements = 0;
    }

    public void write(E i)throws BufferIOException
    {
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
    }

    public void clear()
    {

    }


    public E read() throws BufferIOException
    {
        E answer;

        answer = (E)data[current];

        if (answer == null)
        {
            throw new BufferIOException("Tried to read from empty buffer");
        }

        return answer;
    }

    public void overwrite(E i)
    {


    }
}
