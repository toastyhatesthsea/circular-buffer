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

    public void write(E i)throws BufferIOException
    {
        if (totalElements == data.length)
        {
            throw new BufferIOException("Tried to write to full buffer");
        }

        //TODO The read function removes an element!!!

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

    }


    public E read() throws BufferIOException
    {
        E answer = null;

        try
        {
            answer = (E) data[current];
        } catch (IndexOutOfBoundsException e)
        {
            throw new BufferIOException("Tried to read from empty buffer");
        }

        if (answer == null)
        {
            throw new BufferIOException("Tried to read from empty buffer");
        }
        data[current] = null;

        if (current == 0)
        {
            current = data.length - 1;
        }
        else
        {
            current--;
        }

        return answer;
    }

    public void overwrite(E i)
    {


    }
}
