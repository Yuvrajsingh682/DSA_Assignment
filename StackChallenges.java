public class StackChallenges {

    // Challenge 1: Reverse a string using custom Stack
    public static String reverseString(String str) {
        Stack charStack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            charStack.push(str.charAt(i));
        }

        StringBuilder reversed = new StringBuilder();
        while (!charStack.isEmpty()) {
            reversed.append((char) charStack.pop());
        }
        return reversed.toString();
    }

    // Challenge 2: Check whether a string is a palindrome using Stack
    public static boolean isPalindrome(String str) {
        String cleaned = str.replaceAll("\\s+", "").toLowerCase();
        String reversed = reverseString(cleaned);
        return cleaned.equals(reversed);
    }

    // Challenge 3: Reverse the elements of a Stack using another Stack
    public static Stack reverseStack(Stack original) {
        Stack auxiliary = new Stack();
        while (!original.isEmpty()) {
            auxiliary.push(original.pop());
        }
        return auxiliary;
    }

    public static void main(String[] args) {
        // Test 1: Reverse a String
        String word = "GLAUniversity";
        System.out.println("\n--- Challenge 1: Reverse String ---");
        System.out.println("Original: " + word);
        System.out.println("Reversed: " + reverseString(word));

        // Test 2: Palindrome Check
        String palin = "madam";
        System.out.println("\n--- Challenge 2: Palindrome Check ---");
        System.out.println("Is '" + palin + "' a palindrome? " + isPalindrome(palin));

        // Test 3: Reverse Stack using another Stack
        System.out.println("\n--- Challenge 3: Reverse Stack ---");
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.print("Original Stack: ");
        s.display();
        s = reverseStack(s);
        System.out.print("Reversed Stack: ");
        s.display();

        // Test 4: Find Middle Element of Stack
        System.out.println("\n--- Challenge 4: Middle Element ---");
        s.push(4);
        s.push(5);
        System.out.print("Current Stack: ");
        s.display();
        System.out.println("Middle Element: " + s.findMiddle());
    }
}