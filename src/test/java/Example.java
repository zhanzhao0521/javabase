public class Example {
    public static void main(String[] args) {
        Object obj = new Object(){
            public int hashCode(){
                return 42;
            }
        };
        System.out.println(obj.hashCode());
    }
}
