package Terminal.Buttons;

import Terminal.Input;
import Terminal.Password;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class ButtonEventListenerOk implements ActionListener
{
    private Input input;
    public ButtonEventListenerOk(Input input)
    {
        this.input = input;
    }
    public void actionPerformed(ActionEvent e)
    {
        if (input.getInputString().length() != 2)
        {
            if (input.getInputString().equals("1234"))
            {
                if (input.getMoney() == 0)
                {
                    JOptionPane.showMessageDialog(input.getPanel(), "Вывод денег невозможен!", "Терминал", 1);
                }
                else
                {
                    JOptionPane.showMessageDialog(input.getPanel(), "Вывод денег!", "Терминал", 1);
                    String tmp_str = String.format("%.2f", input.getMoney());
                    JOptionPane.showMessageDialog(input.getPanel(), "Вывод: " + tmp_str, "Терминал", 1);
                    input.setMoney(0);
                }

            }
            else
            {
                JOptionPane.showMessageDialog(input.getPanel(), "Неверный выбор секции!", "Секция", 1);
            }
            input.setInputstr("");
        }
        else
        {
            try
            {
                int tmp = Integer.parseInt(input.getInputString());
                int i = tmp / 10 - 1;
                int j = tmp % 10 - 1;
                if (i < input.getTerminal().getSLOT() && j < input.getTerminal().getSECTION())
                {
                    if (input.getTerminal().getMachine().getProduct(i, j).Purchase())
                    {
                        if (input.getMoney() > input.getTerminal().getMachine().getProduct(i, j).getCost())
                        {
                            input.setMoney(input.getMoney() - input.getTerminal().getMachine().getProduct(i, j).getCost());
                            input.getTerminal().getMachine().getProduct(i, j).setCount(input.getTerminal().getMachine().getProduct(i, j).getCount() - 1);
                            //Update GUI
                            input.getOutput().Setting_Window(new Container());
                            input.Setting_Window(new Container());
                            String tmp_str = String.format("%.2f", input.getMoney());
                            JOptionPane.showMessageDialog(input.getPanel(), "Покупка прошла успешно! Остаток : " + tmp_str + ". Выберите следующий продукт или выведите деньги! Для вывода денег введите \"1 2 3 4\"!", "Терминал", 1);
                        }
                        else
                        {
                            input.setInputstr("");
                            input.setInputstr(JOptionPane.showInputDialog(input.getPanel(), "Введите наличные!"));
                            try {
                                input.setMoney(input.getMoney() + Integer.parseInt(input.getInputString()));
                                input.setInputstr("");
                                if (input.getMoney() > input.getTerminal().getMachine().getProduct(i, j).getCost())
                                {
                                    input.setMoney(input.getMoney() - input.getTerminal().getMachine().getProduct(i, j).getCost());
                                    input.getTerminal().getMachine().getProduct(i, j).setCount(input.getTerminal().getMachine().getProduct(i, j).getCount() - 1);
                                    //Update GUI
                                    input.getOutput().Setting_Window(new Container());
                                    input.Setting_Window(new Container());
                                    String tmp_str = String.format("%.2f", input.getMoney());
                                    JOptionPane.showMessageDialog(input.getPanel(), "Покупка прошла успешно! Остаток : " + tmp_str + ". Выберите следующий продукт или выведите деньги! Для вывода денег введите \"1 2 3 4\"!", "Терминал", 1);
                                }
                                else
                                {
                                    JOptionPane.showMessageDialog(input.getPanel(), "Недостаточно средств. Для вывода денег введите \"1 2 3 4\"!", "Терминал", 1);
                                }
                            } catch (NumberFormatException e1) {
                                JOptionPane.showMessageDialog(input.getPanel(), "Неверный ввод! Попробуйте ещё.", "Терминал", 1);
                                input.setMoney(0);
                            }
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(input.getPanel(), "В секции нет товара!", "Секция", 1);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(input.getPanel(), "В секции нет товара!", "Секция", 1);
                }
                input.setInputstr("");
            }
            catch (NumberFormatException e1){}
        }
    }
}
