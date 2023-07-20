package Products;

public class NoProduct extends Product
{
    private final String name = "Неопределённый продукт!";
    private int rubles = 0;
    private int penny = 0;
    private int count;

    public String getName()
    {
        return name;
    }

    public void setName(String new_name) {}

    public double getCost()
    {
        return rubles + penny / 100.0;
    }

    public void setCost(int rubles, int penny) {}
    public int getCount()
    {
        return count;
    }

    public void setCount(int new_count)
    {
            count = 0;
    }

    public boolean Purchase()
    {
        return false;
    }
}
