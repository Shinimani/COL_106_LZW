import javax.naming.SizeLimitExceededException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyLzw {

    public static List<Byte> compress(String uncomp) {


        Map<String, Integer> mydictionary = new HashMap<String, Integer>();
        List<Byte> ans = new ArrayList<Byte>();

        for (int i = 0; i < 256; i++) {
            mydictionary.put("" + (char) i, i);
        }
        String w = "";
        int size = 256;
        for (char c : uncomp.toCharArray()) {
            String wc = w + c;
            if (mydictionary.containsKey(wc))
                w = wc;
            else {
//                String s = "" + mydictionary.get(w);
//                Byte b = new Byte(s);
                ans.add(new Byte("" + mydictionary.get(w)));
                mydictionary.put(wc, size++);
                w = "" + c;
            }
        }

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




}
