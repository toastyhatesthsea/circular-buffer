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

    public void write(E i)
    {

    }

    public void clear()
    {

    }


    public E read()
    {

        return null;
    }

    public void overwrite(E i)
    {


    }
}
