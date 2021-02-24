public class main {
    public static void main(String[] args) {
        StringSource example1 = new NounStringSource();
        StringSource example2 = new HelloStringSource();
        System.out.println("String one: " + example1.next() + "\tString two: " + example2.next());
        example1 = new BestDecorator(example1);
        example2 = new UppercaseDecorator(example2);
        System.out.println("String one: " + example1.next() + "\tString two: " + example2.next());
        example1 = new UppercaseDecorator(example1);
        example2 = new ReverseDecorator(example2);
        System.out.println("String one: " + example1.next() + "\tString two: " + example2.next());
    }
}

