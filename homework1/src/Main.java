import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static int calculateK(int number) {
        int a=number;
        int k=0;
        while (a>=10) {
            k=0;
            while (a>0){
                 k += (a % 10) * (a % 10);
                 a /= 10;
            }
            a=k;
        }
        return k;
    }
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        //Scanner first_scanner=new Scanner(System.in); //creez un scanner obj
       // System.out.println("Introduce your variables:");
        //String numbers=first_scanner.nextLine();   //citesc input
        //System.out.println("Introduced variables are:\n" + numbers);

        //String[] number=numbers.split(" ");
        //for (String a:number) {
            //System.out.println(a);
        //}
        int a=Integer.parseInt(args[0]);
        int b=Integer.parseInt(args[1]);
        int k=Integer.parseInt(args[2]);

        //System.out.print("\n" + a);
        //System.out.print("\n" + b);
        //System.out.print("\n" + k);
        StringBuffer K_RED = new StringBuffer(b-a+1); //POT MODIFICA FARA A CREA UN NOU OBIECT
        for (int i=a; i<=b; i++) {
            if (calculateK(i)==k) {
                K_RED.append(i + " ");
            }
           }
        System.out.printf("%d-reductible numbers between %d and %d\n",k,a,b);
            System.out.println(K_RED);

        //System.out.println("\n" +calculateK(20));

       long startTime=System.nanoTime();
       long endTime=System.nanoTime();
       long totalTime=endTime-startTime;
       System.out.println("Running time: " + totalTime);
    }
}

//println=print new line
//dc o data mi a dat running time 100 si in rest 200???!!!!
//javac Main.java=compilare
//java Main + arg= eu rulez clasa ca sa execut programul