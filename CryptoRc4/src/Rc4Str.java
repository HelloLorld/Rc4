import java.nio.charset.StandardCharsets;

public class Rc4Str
{
    private final byte[] key;
    private byte[] cipher = null;

    Rc4Str(String key)
    {
        this.key = key.getBytes(StandardCharsets.US_ASCII);
    }

    public String encr(String encrypted)
    {
        if (isRussian(encrypted)) throw new IllegalArgumentException("Only english!");
        Rc4 rc4 = new Rc4(key);
        byte[] encryptedByte = encrypted.getBytes(StandardCharsets.US_ASCII);
        byte[] cipher = rc4.encrypt(encryptedByte);
        this.cipher = cipher;
        return new String(cipher, StandardCharsets.US_ASCII);
    }

    public String decr()
    {
        if (this.cipher == null) throw new IllegalArgumentException("Cipher is null");
        Rc4 rc4 = new Rc4(key);
        byte[] cipherByte = cipher;
        byte[] original = rc4.decrypt(cipherByte);
        return new String(original, StandardCharsets.US_ASCII);
    }

    private boolean isRussian(String str)
    {
        for (char a : str.toCharArray())
        {
            if (Character.UnicodeBlock.of(a) == Character.UnicodeBlock.CYRILLIC) return true;
        }
        return false;
    }
}
