package Terminal;

import Products.Product;
import VendingMachine.VendingMachine;

import javax.swing.*;
import java.awt.*;

public class Terminal
{
    private final int SLOT = 5;
    private final int SECTION = 5;
    private final int COUNT = 10;
    private boolean flag;
    private static Terminal terminal;
    private int Admin;
    private Input input;
    private Output output;
    private final VendingMachine machine;

    public int getSLOT()
    {
        return SLOT;
    }
    public int getSECTION()
    {
        return SECTION;
    }
    public int getCOUNT()
    {
        return COUNT;
    }
    public VendingMachine getMachine()
    {
        return machine;
    }
    public static synchronized Terminal getTerminal(boolean FLAG)
    {
        if(terminal == null)
        {
            terminal = new Terminal(FLAG);
        }
        return terminal;
    }
    private Terminal(boolean FLAG)
    {
        this.flag = FLAG;
        Admin = 0;
        machine = VendingMachine.getInstance(SLOT, SECTION, COUNT, flag);
    }
    public void start() throws InterruptedException
    {
        if (output == null)
        {
            output = new Output(this);
            output.Setting_Window(new Container());
            output.Setting_Window(new Container());
            output.Setting_Window(new Container());
            output.setVisible(true);
            Thread.sleep(1000);
            input = new Input(this, output);
        }
    }
    public void addSECTION(int i, int j, Product product, int count)
    {
        i -= 1;
        j -= 1;
        if (i < 0 || j < 0 || i >= SLOT || j >= SECTION || count > COUNT || output == null)
        {
            return;
        }
        if (Admin == 0)
        {
            if (Password.checkPassword(JOptionPane.showInputDialog(input.getPanel(), "Введите пароль!")))
            {
                Admin = 1;
                machine.setNewSection(i, j, product, count);
                output.Setting_Window(new Container());
                input.Setting_Window(new Container());
            }
            else
            {
                JOptionPane.showMessageDialog(input.getPanel(), "Неверный пароль!", "Терминал", 1);
                Admin = -1;
            }
        }
        else if (Admin == 1)
        {
            machine.setNewSection(i, j, product, count);
            output.Setting_Window(new Container());
            input.Setting_Window(new Container());
        }
    }
}
