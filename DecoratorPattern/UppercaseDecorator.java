public class UppercaseDecorator implements StringSource {
    StringSource string;

    public UppercaseDecorator(StringSource string) {
        this.string = string;
    }
    public String next(){
        return string.next().toUpperCase();
    }
}
