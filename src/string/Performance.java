package string;

public class Performance {
    public static void main(String[] args) {
        String series = "";
        for (int i = 0; i < 26; i++) {
             char ch = (char)('a'+i);
             series += ch;
        }
        System.out.println(series);
        /*
    IN HERE, the time complexity is O(N²)
    and so much memory is wasted as well as
    [a, ab, abc,abcd,abcde,.........,abcdef..xy] all these strings objects are created which are not used!
    and are not referred by any reference variable i.e. totally useless
    So to avoid generating so many objects, we have a new datatype known as:
    String Builder, it just created one object and the changes are made to the same object!
     */
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a'+i);
            builder.append(ch);
        }//no need to call .toString() it will be called automatically
        System.out.println(builder);
    }

}
