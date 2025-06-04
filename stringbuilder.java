public class StringBuilderDemo {
    public static void main(String[] args) {
        // Create a StringBuilder object
        StringBuilder sb = new StringBuilder("Hello");

        // Append text
        sb.append(" World");
        System.out.println("After append: " + sb);

        // Insert text
        sb.insert(6, "Java ");
        System.out.println("After insert: " + sb);

        // Replace a part of the string
        sb.replace(6, 10, "Beautiful");
        System.out.println("After replace: " + sb);

        // Delete part of the string
        sb.delete(6, 15);
        System.out.println("After delete: " + sb);

        // Reverse the string
        sb.reverse();
        System.out.println("After reverse: " + sb);
    }
}
