package cc150.chapter1;
import java.util.HashMap;
import java.util.Map;

class Test1_4 {
    public static void main(String args[]) {
       String str1 = args[0]; 
       String str2 = args[1];
       if( isAnagram(str1, str2) ) { 
           System.out.println(String.format("%s and %s are anagrams", str1, str2));
       } else {
           System.out.println(String.format("%s and %s aren't anagrams", str1, str2));
       }
    }
    // Decide if str1 and str2 are anagrams or not
    // Rearranging subject anagram, each character appears exactly once
    
    public static boolean isAnagram(String str1, String str2) {
        Map<Character, Integer> charMap = new HashMap<Character, Integer>();
        // Fill map using str1
        for(char c : str1.toCharArray() ) {
            c = Character.toUpperCase(c);
            if( c > 'A' && c < 'Z' ) {
                if(charMap.containsKey(c)) {
                    charMap.put(c, charMap.get(c)+1);
                } else {
                    charMap.put(c, 1);
                }
            }
        }
        // Examine str2
        for( char c : str2.toCharArray() )  {
            c = Character.toUpperCase(c);
            if( c > 'A' && c < 'Z' ) {
                if( charMap.containsKey(c) ) {
                    int cnt = charMap.get(c);
                    if( cnt == 0 ) return false;
                    else {
                        charMap.put(c, cnt-1);
                    }
                }
                else return false;
            }

        }
        // Check char map
        for( int value : charMap.values() ) {
            if( value > 0 ) return false;
        }
        return true;
    }
}
