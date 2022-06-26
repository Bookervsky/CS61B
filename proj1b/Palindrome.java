public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        char[] l=new char[word.length()];
        ArrayDeque<Character> array=new ArrayDeque<>();
        for(int i=0;i<word.length();i++){
            array.addLast(word.charAt(i));
        }
        return array;
    }
    public boolean isPalindrome(String word){
        /*transfer word to Deque*/
       Deque<Character> array = new Palindrome().wordToDeque(word);
        /*generate and compare ordered and reversed*/
        String ordered = "";
        String reversed = "";
        for(int i=0;i<word.length()/2;i++){
            ordered += array.removeFirst();
            reversed += array.removeLast();
        }
        if(ordered.equals(reversed)){
        return true;}
        return false;
    }
    public boolean isPalindrome(String word,CharacterComparator cc){
        Deque<Character> array = new Palindrome().wordToDeque(word);
        for(int i=0;i<word.length()/2;i++) {
            boolean T = cc.equalChars(array.removeFirst(), array.removeLast());
            if (!T){
                return false;
            }
        }
        return true;
    }
}
