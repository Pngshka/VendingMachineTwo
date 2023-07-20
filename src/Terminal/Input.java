package Terminal;
import Terminal.Buttons.*;

import javax.swing.*;
import java.awt.*;

public class Input extends JFrame
{
    private String inputstr;
    private double money;
    private Container container;
    private JPanel panel;
    private Terminal terminal;
    private Output output;


    public Input(Terminal terminal, Output output)
    {
        super("Input");
        Setting_Window(new Container());
        inputstr = "";
        money = 0;
        this.output = output;
        this.terminal = terminal;
        panel = new JPanel(new FlowLayout());
    }
    public Terminal getTerminal()
    {
        return terminal;
    }
    public Output getOutput()
    {
        return output;
    }
    public String getInputString()
    {
        return inputstr;
    }
    public double getMoney()
    {
        return money;
    }
    public void addInputStr(String str)
    {
        inputstr += str;
    }
    public void setInputstr(String str)
    {
        inputstr = str;
    }
    public void setMoney(double money)
    {
        this.money = money;
    }
    public JPanel getPanel()
    {
        return panel;
    }
    public void Setting_Window(Container new_container)
    {
        this.setContentPane(new_container);
        this.setBounds(1300, 200, 165, 285);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container = new_container;
        container = this.getContentPane();
        container.setLayout(null);

        JButton button1 = new JButton("" + 1);
        button1.setBounds(0, 0, 50, 50);
        button1.addActionListener(new ButtonEventListener1(this));
        container.add(button1);

        JButton button2 = new JButton("" + 2);
        button2.setBounds(50, 0, 50, 50);
        button2.addActionListener(new ButtonEventListener2(this));
        container.add(button2);

        JButton button3 = new JButton("" + 3);
        button3.setBounds(100, 0, 50, 50);
        button3.addActionListener(new ButtonEventListener3(this));
        container.add(button3);

        JButton button4 = new JButton("" + 4);
        button4.setBounds(0, 50, 50, 50);
        button4.addActionListener(new ButtonEventListener4(this));
        container.add(button4);

        JButton button5 = new JButton("" + 5);
        button5.setBounds(50, 50, 50, 50);
        button5.addActionListener(new ButtonEventListener5(this));
        container.add(button5);

        JButton button6 = new JButton("" + 6);
        button6.setBounds(100, 50, 50, 50);
        button6.addActionListener(new ButtonEventListener6(this));
        container.add(button6);

        JButton button7 = new JButton("" + 7);
        button7.setBounds(0, 100, 50, 50);
        button7.addActionListener(new ButtonEventListener7(this));
        container.add(button7);

        JButton button8 = new JButton("" + 8);
        button8.setBounds(50, 100, 50, 50);
        button8.addActionListener(new ButtonEventListener8(this));
        container.add(button8);

        JButton button9 = new JButton("" + 9);
        button9.setBounds(100, 100, 50, 50);
        button9.addActionListener(new ButtonEventListener9(this));
        container.add(button9);

        JButton buttonOk = new JButton("OK");
        buttonOk.setBounds(0, 150, 150, 50);
        buttonOk.addActionListener(new ButtonEventListenerOk(this));
        container.add(buttonOk);

        JButton buttonNO = new JButton("Отмена");
        buttonNO.setBounds(0, 200, 150, 50);
        buttonNO.addActionListener(new ButtonEventListenerNo(this));
        container.add(buttonNO);

        this.setVisible(true);
    }
}
