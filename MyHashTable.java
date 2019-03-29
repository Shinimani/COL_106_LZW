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
        byte x = (byte) text.charAt(0);

        this.ascode = new byte[2];
        this.ascode[0] = 0;
        this.ascode[1] = x;
    }

    //constructor for newly added words or if code generated elsewhere

    HashEntry(String text, byte[] acode)
    {
        this.typ = (text.length() == 1);
        this.text = text;
        this.ascode = acode;
    }


}

public class MyHashTable
{
    HashEntry[] table;
    int lab;//lowest available space in the table
    byte labbyte;//lowest available byte, will be incremented at each step
    // byte counter;//the counter which will be added
    
    //constructor specific to our dictionary, initialises first 128 entries
    MyHashTable()
    {   
        table = new HashEntry[256];
        for(int i = 0; i<128;i++)
        {
            String temptext = Character.toString((char)i);
            HashEntry temp = new HashEntry(temptext);
            this.table[i] = temp;
        }
        this.lab = 128;
        // this.counter = 0;
        this.labbyte = -128;

        // this.labbyte = labbyte + (byte) (lab - 128);
    }

    public boolean contains(String str)
    {
        boolean ans = false;
        for(int i = 0;i<this.lab;i++)
        {
            HashEntry temp = table[i];
            String tempstring = temp.text;
            if (tempstring.equals(str))
            {
                ans = true;
                break;
            }
        }
        return ans;
    }


    /*
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
    */
    
    int getHashIndex(String s)
    {
        return 0;
    }


}