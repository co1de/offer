package leetcode.altheme;

public class HuiwenString {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z' || c>='0'&& c<='9') {
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }
    public boolean isPalindrome2(String s) {
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toLowerCase().toCharArray()) {
            if (c >= 'a' && c <= 'z' || c>='0'&& c<='9') {
                sb.append(c);
            }
        }
        String filterString = sb.toString();
        int start =0;
        int end = filterString.toLowerCase().length()-1;
        while (start < end) {
            if (filterString.charAt(start) == filterString.charAt(end)) {
                start++;
                end--;
            }else return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(new HuiwenString().isPalindrome2("A man, a plan, a canal: Panama"));
    }
}
