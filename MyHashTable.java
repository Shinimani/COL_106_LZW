import java.io.File; 
import java.io.FileOutputStream; 
import java.io.OutputStream;

class HashEntry
{
    boolean typ;//true if already present in ascii
    String text;//the text
    byte[] ascode;//the code

    //constructor for one char words
    HashEntry(String text)
    {
        this.typ = (text.length() == 1);
        this.text = text;

        this.ascode = new byte[2];
        this.ascode[0] = 0;
        this.ascode[1] = (int) text.charAt(0);
    }

    //constructor for newly added words or if code generated elsewhere

    HashEntry(String text, int ascode)
    {
        this.typ = (text.length() == 1);
        this.text = text;
        this.ascode = ascode;
    }


}

public class MyHashTable
{
    
    public static void main(String[] args) 
    {
        try
        {
            System.out.println();
            int g = (int) 'g';
            System.err.println(g);

        OutputStream os = new FileOutputStream("a.txt");
        byte b = 55;
        // Byte y = new Byte(h);
        // Byte x = new Byte(b);
        System.out.println(Byte.toString(b) + " ");
        byte[] c = new byte[2];
        c[0] = 97;
        c[1] = 97;
        String x = new String(c);
        System.out.println(x);
        os.write(c);
        String za = "a";
        // int zai = za;
        // System.out.println(zai);
        
        }
        catch (Exception e)
        {
            System.out.println("Exception: " + e);
        }
        // System.out.println(c);
    }
    
    int getHashIndex(String s)
    {
        return 0;
    }


}