package cc150.chapter1.i2;
class Test {
    public static void main(String args[]) {
        String str = "abcd";
        System.out.println(reverse(str)); 
    }
    public static String reverse(String str) {
        char[] strchars = str.toCharArray();
        for(int i = 0, j = str.length()-1; i < j; i++, j--) {
            char tmp = strchars[i];
            strchars[i] = strchars[j];
            strchars[j] = tmp;
        }
        return new String(strchars);
    }
    
}
