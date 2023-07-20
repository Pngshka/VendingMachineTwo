package Terminal.Buttons;

import Terminal.Input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEventListener2 implements ActionListener
{
    private Input input;
    public ButtonEventListener2(Input input)
    {
        this.input = input;
    }
    public void actionPerformed(ActionEvent e)
    {
        input.addInputStr("2");
    }
}
