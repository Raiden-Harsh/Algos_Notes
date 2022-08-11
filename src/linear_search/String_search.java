package linear_search;

public class String_search {
    public static void main(String[] args) {
        String s = "Harsh Vardhan Sharma";
        char target = 'v';
        boolean ans = searchString(s,target);
        System.out.println("String contains target: "+ans);
        System.out.println("from 2nd "+search2(s,target));

    }
    static boolean searchString(String str,char target){
        if(str.length() == 0)
            return false;
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == target)
                return true;
        }
        return false;
    }
    //Using for each !
    static boolean search2(String str,char target){
        if(str.length()==0)
            return false;
        for(char c : str.toCharArray()){
            if(target == c)
                return true;
        }
        return false;
    }
}
