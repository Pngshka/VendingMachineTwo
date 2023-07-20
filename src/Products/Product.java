package Products;

public abstract class Product
{
    public abstract double getCost();
    public abstract void setCost(int rubles, int penny);
    public abstract String getName();
    public abstract void setName(String new_name);
    public abstract int getCount();
    public abstract void setCount(int new_count);
    public abstract boolean Purchase(); //Проверка на то, можем ли мы купить товар один раз

}
