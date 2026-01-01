public class Palindrome {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println(isPalindrome(args[0]));
        }
    }

    public static boolean isPalindrome(String s) {
        if (s.length() <= 1) {
            return true;
        }
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        return isPalindrome(s.substring(1, s.length() - 1));
    }
}