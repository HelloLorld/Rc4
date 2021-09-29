import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите ключ:");
        String keyStr = scanner.nextLine();
        System.out.println("Введите строку:");
        String encrypted = scanner.nextLine();

        boolean flag = true;
        while (flag)
        {
            try
            {
                Rc4Str rc4Str = new Rc4Str(keyStr);

                String cipher = rc4Str.encr(encrypted);
                System.out.println("Зашифрованная строка: " + cipher);
                String original = rc4Str.decr();
                System.out.println("Расшифрованная строка: " + original);
                flag = false;
            } catch (Exception e)
            {
                e.printStackTrace();

                System.out.println("Введите ключ:");
                keyStr = scanner.nextLine();
                System.out.println("Введите строку:");
                encrypted = scanner.nextLine();
            }
        }
    }
}









/*        keyStr="my big key";
        byte[] key = new byte[keyStr.length()];
        try {
            key = keyStr.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Rc4 encoder = new Rc4(key);
        String testString = "Big string !$£%f    -text";

        byte[] testBytes = new byte[testString.length()];
        try {
            testBytes = testString.getBytes("ASCII");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        byte[] result = encoder.encrypt(testBytes);

        Rc4 decoder = new Rc4(key);
        byte[] decryptedBytes = decoder.decrypt(result);
        try {
            System.out.println(new String(result, "ASCII"));
            System.out.println(new String(decryptedBytes, "ASCII"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/