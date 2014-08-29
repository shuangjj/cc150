package cc150.chapter1;
class Test1_3 {
    public static void main(String args[]) {
        String str = "abccdfb";
        str = deduplicate(str);
        System.out.println(str);
    }
    public static String deduplicate(String str) {
        char[] strchar = str.toCharArray();
        int uppermap = 0;
        int lowermap = 0;
        int len = strchar.length;
        for( int i = 0; i < len; i++) {
            char c = strchar[i];
            if( c >= 'a' && c <= 'z' ) {    // Lower case
                int mask = 1 << (c - 'a');
                if( (lowermap & mask) != 0 ) {
                    // Move one step left the following chars
                    for( int j = i; j < len-1; j++ ) {
                        strchar[j] = strchar[j+1];
                    }
                    len--;
                    i--;
                } else {
                    lowermap |= mask;
                }
            }
            else if( c >= 'A' && c <= 'Z' ) {   // Upper case
                int mask = 1 << ( c - 'A' );
                if( (uppermap & mask) != 0 ) {
                    for( int j = i; j < len-1; j++ ) {
                        strchar[j] = strchar[j+1];
                    }
                    len--;
                    i--;
                } else {
                    uppermap |= mask;
                }
            }
        }
        return String.valueOf(strchar, 0, len);
    }
}
