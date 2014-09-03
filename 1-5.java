package cc150.chapter1;
class Test1_5 {
    public static void main(String args[]) {
        String url = "/home/to/my  page/";
        System.out.println(replace_spaces(url, "%20"));
    }
    public static String replace_spaces(String str, String rep) {
        StringBuilder sb = new StringBuilder();
        for( char c : str.toCharArray() ) {
            if(c == ' ') {
                sb.append(rep);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
