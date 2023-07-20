package Terminal.Buttons;

import Terminal.Input;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonEventListenerNo implements ActionListener
{
    private Input input;
    public ButtonEventListenerNo(Input input)
    {
        this.input = input;
    }
    public void actionPerformed(ActionEvent e)
    {
        input.setInputstr("");
    }
}
