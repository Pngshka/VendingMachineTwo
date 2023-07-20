package Terminal;

public class Password
{
    private static  String pass = "567611";
    public static boolean checkPassword(String value)
    {
        return pass.equals(value);
    }
}
