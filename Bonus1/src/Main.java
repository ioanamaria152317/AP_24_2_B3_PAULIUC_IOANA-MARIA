//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static int calculateCycles(int n){
        int countCycles = 1 + (n - 1) * (n - 2);
        //1 pt contur, n-1 triunghiuri si spre exemplu pt n=5 am cele 4 tr cu 3
        //variante de a crea ciclul: ele, unirea a cate doua, unirea a cate 3.
        //cand le unesc pe toate 4 am conturul
        return countCycles;
    }

    public static void main(String[] args) {
        int n=Integer.parseInt(args[0]);
        //int n=5;
        int[][] matrix=new int[n][n];

        for (int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = 0;        //pun zero uri
            }
        }
        for (int i=1;i<n;i++) {          //pt cel din centru
            matrix[0][i]=1;
            matrix[i][0]=1;              //simetrie sper
        }
        for (int i=1; i<n-1;i++){
            matrix[i][i+1]=1;            //vecina
            matrix[i+1][i]=1;            //merg pana la i=3 pt ca o sa am 3-4 si 4-3 (4 ultima linie )
        }
        matrix[n-1][1]=1;                 //ciclu
        matrix[1][n-1]=1;
        System.out.println("Matrix:\n");
        for (int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println(); //print line
        }
        System.out.println("Number of Cycles:\n"+calculateCycles(n));
        //caut triunghiuri+ala mare(conturul)+combinatii intre ele
        //n-1 triunghiuri
        if(calculateCycles(n)==n*n-(3*n)+3){
            System.out.println("E bineeee!!!!");
        }
       /* System.out.println("Cycles:\n");
        for (int i=1;i<n;i++)
            System.out.print(i);
            System.out.print(1);
        System.out.println("\n");
        for (int i=1;i<n;i++) {
            int[] cicluTrei = new int[4];     //triunghiuri mici
            cicluTrei[0] = i;
            cicluTrei[1] = 0;
            cicluTrei[2] = i + 1;
            cicluTrei[3]=i;

            if (cicluTrei[0]==n-1){
                cicluTrei[1]=0;
                cicluTrei[2]=1;
            }
            for (int j = 0; j < 4; j++) {
                System.out.print(cicluTrei[j]);
            }
            System.out.println("\n");
        }*/
        //succ si +2               //din acest punct nu mai merge pt orice n
        /*for(int i=1;i<n;i++){
            int[] ciclu2TrUnite=new int[n];
            ciclu2TrUnite[0]=i;
            if (i<n-1) ciclu2TrUnite[1]=i+1;
            else ciclu2TrUnite[1]=1;
            ciclu2TrUnite[2]=0;
            if(ciclu2TrUnite[1]<(n-2)) ciclu2TrUnite[3]=ciclu2TrUnite[1]+2;
            else if(ciclu2TrUnite[1]==(n-2)) ciclu2TrUnite[3]=1;
            else {
                ciclu2TrUnite[3] = 2;
            }
            ciclu2TrUnite[4]=i;
            for (int j = 0; j < 5; j++) {
                System.out.print(ciclu2TrUnite[j]);
            }
            System.out.println("\n");
        }*/
        /*for(int i=1;i<n;i++) {
            int[] ciclu3TrUnite = new int[7];
            ciclu3TrUnite[0] = i;
            if (i < n - 1) ciclu3TrUnite[1] = i + 1;
            else ciclu3TrUnite[1] = 1;
            if (ciclu3TrUnite[1] < n - 1) ciclu3TrUnite[2] = ciclu3TrUnite[1] + 1;
            else ciclu3TrUnite[2] = 1;
            if (ciclu3TrUnite[2] < n - 1) ciclu3TrUnite[3] = ciclu3TrUnite[2] + 1;
            else ciclu3TrUnite[3] = 1;
            ciclu3TrUnite[4] = 0;
            ciclu3TrUnite[5] = i;
            for (int j = 0; j < 6; j++) {
                System.out.print(ciclu3TrUnite[j]);
            }
            System.out.println("\n");
        }
        */
        /*for(int i=1;i<n-1;i++)
            for(int j=i+1;j<n;j++){
                //am 2 cicluri intre oricare doua si vreau sa le afisez
                //cum?

                for (int k=0;k<n;k++){
                    int[] ciclu=new int[n];
                    ciclu[k]=
                }
            }*/
    }
}

//fiecare nod are maxim 3 muchii
//un zero pt b b
//zero pt vf la care nu poate ajunge
//deci n-3 zero in total
//n-4 minus ala de pe diag
