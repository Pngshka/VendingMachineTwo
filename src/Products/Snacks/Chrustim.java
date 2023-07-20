package Products.Snacks;

import java.util.Random;

public class Chrustim extends Snack
{
    private String name = "Chrustim 200 г";
    private int rubles = 45;
    private int penny = 19;
    private int count;

    public String getName()
    {
        return name;
    }

    public void setName(String new_name)
    {
        name = new_name;
    }

    public double getCost()
    {
        return rubles + penny / 100.0;
    }

    public void setCost(int rubles, int penny)
    {
        this.rubles = rubles;
        this.penny = penny;
    }
    public int getCount()
    {
        return count;
    }

    public void setCount(int new_count)
    {
        if (new_count > 0)
        {
            count = new_count;
        }
        else
        {
            count = 0;
        }
    }

    public boolean Purchase()
    {
        if (count > 0)
        {
            return true;
        }
        return false;
    }
}
