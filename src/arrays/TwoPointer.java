package arrays;

public class TwoPointer {
    public static void main(String[] args) {
        System.out.println(reverseStringTwoPointers("willian santos"));

    }

    public static String reverseStringTwoPointers(String word){
        char[] chars = word.toCharArray();
        int l = 0;
        int r =0;

        while(r< chars.length){
            if (chars[r] == ' ') {
                reverse(chars,l,r-1);
                l = r;
            }
            r++;
        }

        l++;
        reverse(chars,l,r-1);

        return new String(chars);
    }

    public static void reverse(char[] chars, int l, int r){
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;

            r--;
            l++;
        }
    }
}
