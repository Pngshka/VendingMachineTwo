package Terminal;

import VendingMachine.VendingMachine;

import javax.swing.*;
import java.awt.*;

public class Output extends JFrame
{
    private Terminal terminal;
    private int SLOT;
    private int SECTION;
    private int COUNT;
    private VendingMachine machine;
    private JPanel panel;
    private Container container;



    public Output(Terminal terminal)
    {
        super("Vending Machine");
        Setting_Window(new Container());
        this.terminal = terminal;
        SLOT = this.terminal.getSLOT();
        SECTION = this.terminal.getSECTION();
        COUNT = this.terminal.getCOUNT();
        machine = this.terminal.getMachine();
        panel = new JPanel(new FlowLayout());
    }
    public void Setting_Window(Container new_container)
    {
        this.setContentPane(new_container);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container = new_container;
        container = this.getContentPane();
        container.setLayout(null);

        for(int i = 0; i != SLOT; ++i)
        {
            for(int j = 0; j != SECTION; ++j)
            {
                JLabel section = new JLabel("Секция [" + (i + 1) + "][" + (j + 1) +"]");
                section.setBounds(200 * i + 225, 125 * j + 50, 200, 30);
                container.add(section);
                JLabel product = new JLabel(machine.getProduct(i,j).getName());
                product.setBounds(200 * i + 225, 125 * j + 75, 200, 30);
                container.add(product);
                JLabel price = new JLabel("" + machine.getProduct(i,j).getCost());
                price.setBounds(200 * i + 225, 125 * j + 100, 200, 30);
                container.add(price);
                JLabel count = new JLabel("Кол-во " + machine.getProduct(i, j).getCount());
                count.setBounds(200 * i + 225, 125 * j + 125, 200, 30);
                container.add(count);
                JLabel empty = new JLabel("                                        ");
                empty.setBounds(200 * i + 225, 125 * j + 150, 200, 30);
                container.add(empty);
            }
        }

        this.setVisible(true);
    }
}
