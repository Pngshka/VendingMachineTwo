import Terminal.Terminal;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        final boolean RANDOM_COUNT = false;

        Terminal terminal = Terminal.getTerminal(RANDOM_COUNT);
        terminal.start();
    }
}