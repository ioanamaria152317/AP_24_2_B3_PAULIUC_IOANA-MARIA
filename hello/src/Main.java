/*string urile sunt obiecte*/

public class Main {
    public static void main(String[] args) {

        System.out.print("Hello world!\n");

        String[] languages;
        languages= new String[]{"C",
                "C++",
                "C#",
                "Python",
                "Go",
                "Rust",
                "JavaScript",
                "PHP",
                "Swift",
                "Java"};

        int n = (int) (Math.random() * 1_000_000);
        int result=n;
        result*=3;
        result+=Integer.parseInt("10101",2);
        result+=Integer.parseInt("FF",16);
        result*=6;

            while(result>=10) {
                int sum = 0;
                while (result> 0) {
                    sum += result % 10;
                    result /= 10;
                }
                result=sum;
            }
        System.out.print("Willy-nilly, this semester I will learn " +
                             languages[result]);
    }
}