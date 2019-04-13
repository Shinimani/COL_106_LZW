import javax.naming.SizeLimitExceededException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyLzw {
    private static final int BITS = 12;
    private static final int MAX_VALUE = (1 << BITS) - 1;
    private static final int MAX_CODE = MAX_VALUE - 1;
    private static final int TABLE_SIZE = 5021;

    public static List<Byte> compress(String uncomp)
    {


        Map<String,Integer> mydictionary = new HashMap<String, Integer>();
        List<Byte> ans = new ArrayList<Byte>();

        for(int i = 0;i<256;i++)
        {
            mydictionary.put("" + (char)i,i);
        }
        String w = "";
        for (char c: uncomp.toCharArray())
        {
            String wc = w+c;
            if(mydictionary.containsKey(wc))
                w=wc;
            else
            {
//                String s = "" + mydictionary.get(w);
//                Byte b = new Byte(s);
                ans.add(new Byte("" + mydictionary.get(w)));

            }
        }

        return ans;

    }

}
