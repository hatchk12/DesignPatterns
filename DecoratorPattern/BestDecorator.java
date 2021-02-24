public class BestDecorator implements StringSource{
    StringSource string;

    public BestDecorator(StringSource string) {
        this.string = string;
    }
    public String next(){
        return string.next() + " is the best.";
    }
}
