package Terminal.Buttons;

import Terminal.Input;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEventListener8 implements ActionListener
{
    private Input input;
    public ButtonEventListener8(Input input)
    {
        this.input = input;
    }
    public void actionPerformed(ActionEvent e)
    {
        input.addInputStr("8");
    }
}
