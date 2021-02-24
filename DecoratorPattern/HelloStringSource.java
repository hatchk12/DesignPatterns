public class HelloStringSource implements StringSource{

    @Override
    public String next() {
        return "Hello world";
    }
}
