import javax.naming.SizeLimitExceededException;
import java.util.*;

public class MyLzw {

    public static List<Short> compress(String uncomp) {


        Map<String, Integer> mydictionary = new HashMap<String, Integer>();
        //This will work as the dictionary
        List<Short> ans = new ArrayList<Short>();
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
                ans.add(new Short("" + mydictionary.get(w)));
                mydictionary.put(wc, size++);
                w = "" + c;
            }
        }

        //if w has something, add it's code to answer
        if (!w.isBlank()) {
            ans.add(new Short("" + mydictionary.get(w)));
        }
        return ans;
    }

    public static String decompress(List<Short> compressed) {
        int size = 256;
        Map<Integer, String> mydictionary = new HashMap<Integer, String>();

        for (int i = 0; i < 256; i++) {
            mydictionary.put(i, "" + (char) i);
        }
//        String ans = "";
        String w = "" + (char) compressed.remove(0).intValue();
        StringBuffer ans = new StringBuffer(w);
        for (Short k : compressed) {
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

    public static List<Integer> shortToInteger (List<Short> shortList)
    {
        List<Integer> ans = new ArrayList<Integer>();

        for(Short k : shortList)
        {
            ans.add(k.intValue());
        }
//        while (!shortList.isEmpty())
//        {
//            ans.add(shortList.remove(0).intValue());
//        }
        return ans;
    }

    public static String printList(List<Integer> listInt)
    {
        StringBuffer an = new StringBuffer("");

        for (Integer k : listInt)
        {
            an.append(k);
            an.append(" ");
        }
//        while(!listInt.isEmpty())
//        {
//            an.append(listInt.remove(0));
//        }

        return an.toString();
    }

    public static void main(String[] args) {

        System.out.println(" It begins here");

        Scanner s = new Scanner(System.in);
        System.out.println("Please enter the string to be compressed: ");
        System.out.println();
        String inp = s.next();

        System.out.println("You entered: " + inp);

        System.out.println();

        List<Short> a = compress(inp);
//        List<Integer> = (byteToInteger(a));

        String compressed = printList(shortToInteger(a));

        System.out.println(compressed);

        System.out.println();
        System.out.println();

        System.out.println(decompress(a));

    }




}
