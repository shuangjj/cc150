package cc150.chapter1.i1;
class Test1i1 {
    public static void main(String args[]) {
        String str = args[0]; 
        if(isUnique(str)) {
            System.out.println(str + " is unique");
        } else {
            System.out.println(str + " is not unique");
        }
    }
    public static boolean isUnique(String str) {
        int uppermap = 0;
        int lowermap = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if( c >= 'a' && c <= 'z' ) {
                int mask = 1 << (c - 'a');
                if( (lowermap & mask) != 0 ) return false;
                lowermap |= mask;
            }
            else if( c >= 'A' && c <= 'Z') {
                int mask = 1 << (c - 'A');
                if( (uppermap & mask) != 0 ) return false;
                uppermap |= mask;
            }
        }
        return true;
    }
}
