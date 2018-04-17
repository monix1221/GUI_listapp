public class EmptyItemException extends Exception {

    public EmptyItemException() {
        super();
        System.out.println("Can't add empty item!");
    }
}
