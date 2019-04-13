import javax.naming.SizeLimitExceededException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyLzw {

    public static List<Byte> compress(String uncomp) {


        Map<String, Integer> mydictionary = new HashMap<String, Integer>();
        //This will work as the dictionary
        List<Byte> ans = new ArrayList<Byte>();
        //this will store my answer bytes

        //initialising the dictionary
        for (int i = 0; i < 256; i++) {
            mydictionary.put("" + (char) i, i);
        }

        //working string
        String w = "";

        int size = 256;

        //for loop in the Input string
        for (char c : uncomp.toCharArray()) {

            //P + C
            String wc = w + c;
            if (mydictionary.containsKey(wc))
                w = wc;
            //if P+C  already in the dictionary, make P = P+C
            else {
//                String s = "" + mydictionary.get(w);
//                Byte b = new Byte(s);

                //if P+C not in the dictionary, add it to the dictionary and then output the code for P, then make P as C
                ans.add(new Byte("" + mydictionary.get(w)));
                mydictionary.put(wc, size++);
                w = "" + c;
            }
        }

        //if w has something, add it's code to answer
        if (!w.isBlank()) {
            ans.add(new Byte("" + mydictionary.get(w)));
        }
        return ans;
    }

    public static String decompress(List<Byte> compressed) {
        int size = 256;
        Map<Integer, String> mydictionary = new HashMap<Integer, String>();

        for (int i = 0; i < 256; i++) {
            mydictionary.put(i, "" + (char) i);
        }
//        String ans = "";
        String w = "" + (char) compressed.remove(0).intValue();
        StringBuffer ans = new StringBuffer(w);
        for (Byte k : compressed) {
            int ki = k.intValue();
            String newentry = "";
            if (mydictionary.containsKey(ki)) {
                newentry = mydictionary.get(ki);
            } else if (ki == size) {
                newentry = w + w.charAt(0);
            } else System.out.println("Wrongly compressed at " + ki);

            ans.append(newentry);

            mydictionary.put(size++, w + newentry.charAt(0));

            w = newentry;

        }


//        String anss = ans;
        return ans.toString();


    }

    public static List<Integer> byteToInteger (List<Byte> byteList)
    {
        List<Integer> ans = new ArrayList<Integer>();
        while (!byteList.isEmpty())
        {
            ans.add(byteList.remove(0).intValue());
        }
        return ans;
    }

    public static String printList(List<Integer> listInt)
    {
        StringBuffer an = new StringBuffer("");
        while(!listInt.isEmpty())
        {
            an.append(listInt.remove(0));
        }

        return an.toString();
    }

    public static void main(String[] args) {

        System.out.println(" It begins here");

        System.out.println("The string is BABAABAAA");

        System.out.println();

        List<Byte> a = compress("BABAABAAA");
//        List<Integer> = (byteToInteger(a));

        String compressed = printList(byteToInteger(a));

        System.out.println(compressed);

        System.out.println();
        System.out.println();

        System.out.println(decompress(a));

    }




}
