package VendingMachine;

import Products.Beverages.*;
import Products.Chocolate_bars.*;
import Products.NoProduct;
import Products.Product;
import Products.Snacks.*;

import java.util.Random;

public class VendingMachine
{
    private int SLOT;
    private int SECTION;
    private int COUNT;
    private Product products[][];
    private static VendingMachine machine;
    private VendingMachine(int SLOT, int SECTION, int COUNT, boolean flag)
    {
        this.COUNT = COUNT;
        this.SLOT = SLOT;
        this.SECTION = SECTION;
        products = new Product[SLOT][SECTION];
        for(int i = 0; i != SLOT; ++i)
        {
            for(int j = 0; j != SECTION; ++j)
            {
                products[i][j] = new NoProduct();
            }
        }

        products[0][0] = new Lays();
        products[0][1] = new Cheetos();
        products[0][2] = new Chrustim();
        products[0][3] = new Oreo();
        products[0][4] = new Tuc();

        products[1][0] = new Bounty();
        products[1][1] = new Mars();
        products[1][2] = new Picnic();
        products[1][3] = new Snickers();
        products[1][4] = new Twix();

        products[2][0] = new CocaCola();
        products[2][1] = new Fanta();
        products[2][2] = new Lipton();
        products[2][3] = new Pepsi();
        products[2][4] = new Sprite();

        SettingCount(products, flag);
    }

    public synchronized static VendingMachine getInstance(int SLOT, int SECTION, int COUNT, boolean flag)
    {
        if (machine == null)
        {
            machine = new VendingMachine(SLOT, SECTION, COUNT, flag);
        }
        return machine;
    }

    private void SettingCount(Product[][] products, boolean flag)
    {
        if(flag)
        {
            Random random = new Random();
            for(int i = 0; i < SLOT; ++i)
            {
                for(int j = 0; j < SECTION; ++j)
                {
                    products[i][j].setCount(random.nextInt(COUNT));
                }
            }
        }
        else
        {
            for(int i = 0; i < SLOT; ++i)
            {
                for(int j = 0; j < SECTION; ++j)
                {
                    products[i][j].setCount(COUNT);
                }
            }
        }
    }

    public Product getProduct(int i, int j)
    {
        return products[i][j];
    }
    public void setNewSection(int i, int j, Product product, int count)
    {
        products[i][j] = product;
        products[i][j].setCount(count);
    }
}
