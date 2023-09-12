
package Controller;

import Common.Library;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;
import view.Menu;


public class CountProgramming extends Menu<String> {
    
    static String[] mc = {"Letter Count", "Character Count", "Exit"};
    String str;
    Library l;

    public CountProgramming() {
        super("PROGRAMMING", mc);
        l = new Library();
        str = l.getString("Input string: ");
    }
    
    public void execute(int n) {
        switch (n) {
            case 1:
                countLetter(str);
                break;
            case 2:               
                countCharater(str);
                break;
            case 3:
                System.exit(0);
        }
    }
    /*
    public void countLetter(String str) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();
        String[] strSplit = str.split("\\s"); //str.replaceAll("[^a-zA-Z0-9]", "");
        for (int i = 0; i < strSplit.length; i++) {
            String ch = strSplit[i];
            int count = 0;
            for (int j = 0; j < strSplit.length; j++) {
                if (strSplit[j].equals(ch)) {
                    count++;
                }
            }
            lhm.put(ch, count);
        }
        
        lhm.forEach((key, value) -> {
            System.out.println(key + " -> " + value);
        });
    }
    */
    public void countLetter(String str) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(str," \t\n\r\f!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~");
        
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            int count = lhm.getOrDefault(word, 0);
            lhm.put(word, count + 1);
        }

        lhm.forEach((key, value) -> {
            System.out.println(key + " -> " + value);
        });
    }
       
    public void countCharater(String str) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();
        str = str.replaceAll("\\s+", "");
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j)==ch) {
                    count++;
                }
            }
            lhm.put(ch + "", count);
        }
        
        lhm.forEach((key, value) -> {
            System.out.println(key + " -> " + value);
        });
    }
    
    
}
