public class ReverseDecorator implements StringSource{
    StringSource string;

    public ReverseDecorator(StringSource string) {
        this.string = string;
    }
    public String next(){
        StringBuilder reverse = new StringBuilder();
        String words = string.next();
        for(int i = words.length()-1;i>=0;i--){
            reverse.append(words.charAt(i));
        }
        return reverse.toString();
    }
}
