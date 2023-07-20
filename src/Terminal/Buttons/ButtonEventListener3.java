package Terminal.Buttons;

import Terminal.Input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEventListener3 implements ActionListener
{
    private Input input;
    public ButtonEventListener3(Input input)
    {
        this.input = input;
    }
    public void actionPerformed(ActionEvent e)
    {
        input.addInputStr("3");
    }
}
