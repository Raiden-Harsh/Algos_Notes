package recursion.string;

public class SimpleStringQuestion {
    public static void main(String[] args) {
        questionOne("basadak", "");
        System.out.println(skip("badass"));
        System.out.println(skipApple("ikillappleyou"));
        System.out.println(skipAppNotApple("itisanappnotanapple"));
    }

    /*
    Q) Remove all the 'a' from the given String.
    Example: str = basadak answer = bsdk (*_*)
    */
    public static void questionOne(String str, String newString) {
        if (str.isEmpty()) {
            System.out.println(newString);
            return;
        }
        char ch = str.charAt(0);

        if (ch == 'a') {
            questionOne(str.substring(1), newString);
        } else {
            questionOne(str.substring(1), newString + ch);
        }
    }

    // second method
    public static String skip(String str) {
        if (str.isEmpty()) {
            return "";
        }
        char ch = str.charAt(0);
        if (ch == 'a') {
            return skip(str.substring(1));
        } else {
            return ch + skip(str.substring(1));
        }
    }

    // skip a substring like "apple"
    public static String skipApple(String str) {
        if (str.isEmpty()) {
            return "";
        }
        if (str.startsWith("apple")) {
            return skipApple(str.substring(5));
        } else {
            return str.charAt(0) + skipApple(str.substring(1));
        }
    }

    // skip if its "app" but don't skip if it is "apple"
    public static String skipAppNotApple(String str) {
        if (str.isEmpty()) {
            return "";
        }
        if (str.startsWith("app") && !str.startsWith("apple")) {
            return skipAppNotApple(str.substring(3));
        } else {
            return str.charAt(0) + skipAppNotApple(str.substring(1));
        }
    }

}
