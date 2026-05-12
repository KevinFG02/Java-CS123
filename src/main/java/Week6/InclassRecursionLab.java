package Week6;

import javax.imageio.ImageTranscoder;

public class InclassRecursionLab {
    public static void main(String[] args){
        System.out.println(power(2,5));
        System.out.println(bunnyEars(6));
        System.out.println(weirdBunnyEars(3));
        System.out.println(parensMatch("(((()))"));
        System.out.println(countHi("nzxbiahinanshi"));
        System.out.println(countDigits(123));
        System.out.println(palindrome("racecar"));
    }

    public static int power(int base, int exp){
        if(exp == 1){
            return base;
        } else {
            return base * power(base, exp - 1);
        }
    }

    public static int bunnyEars(int bunnies){
        if(bunnies == 1){
            return 2;
        } else {
            return bunnyEars(bunnies - 1) + 2;
        }
    }

    public static int weirdBunnyEars(int bunnies){
        if(bunnies == 1){
            return 3;
        } else {
            if(bunnies % 2 == 0){
                return weirdBunnyEars(bunnies - 1) + 2;
            } else {
                return weirdBunnyEars(bunnies - 1) + 3;
            }
        }
    }

    public static boolean parensMatch(String test){
        if(test.length() <= 1){
            return false;
        }

        if(test.equals("()")){
            return true;
        } else {
            if(test.charAt(0) == '(' && test.charAt(test.length() - 1) == ')'){
                return parensMatch(test.substring(1,test.length() - 1));
            } else {
                return false;
            }
        }
    }

    public static int countHi(String msg){
        if(msg.isEmpty() || msg.length() == 1){
            return 0;
        } else {
            if(msg.charAt(0) == 'h' && msg.charAt(1) == 'i'){
                return countHi(msg.substring(1)) + 1;
            } else {
                return countHi(msg.substring(1)) + 0;
            }
        }
    }

    public static int countDigits(int num){
        if(num <= 0){
            return 0;
        } else {
            int remainer = num % 10;
            return countDigits(num / 10) + remainer;
        }
    }

    public static boolean palindrome(String input){
        if(input.isEmpty()){
            return false;
        }
        else if(input.length() == 1){
            return true;
        } else {
            if(input.charAt(0) == input.charAt(input.length()-1)){
                return palindrome(input.substring(1, input.length() - 1));
            } else {
                return false;
            }
        }
    }

}
