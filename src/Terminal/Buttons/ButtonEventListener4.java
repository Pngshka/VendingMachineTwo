package Terminal.Buttons;

import Terminal.Input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEventListener4 implements ActionListener
{
    private Input input;
    public ButtonEventListener4(Input input)
    {
        this.input = input;
    }
    public void actionPerformed(ActionEvent e)
    {
        input.addInputStr("4");
    }
}
