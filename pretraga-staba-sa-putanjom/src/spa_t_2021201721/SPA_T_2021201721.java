package spa_t_2021201721;

import java.util.Random;
import java.util.Scanner;

public class SPA_T_2021201721 {
    public static void main(String[] args) {
        /*Scanner s = new Scanner(System.in);
        System.out.print("Molim vas unesite broj redova vaše matrice: ");
        int i = 0;
        i = s.nextInt();
        s.nextLine();
        System.out.print("Molim vas unesite broj kolona vaše matrice: ");
        int j = 0;
        j = s.nextInt();
        s.nextLine();
        s.close();
        int[][] matrica = generisiMatricu(i, j);
        int[] niz = maksimum(matrica);
        for(int h:niz){
            System.out.println(h);
        }*/
        //Matrica iz njegovog primera zadatka a gore je prikazano kako zapravo treba da izgleda zadatak.
        int[][] temp = new int[4][3];
        temp[0][0] = 1;
        temp[1][0] = 7;
        temp[2][0] = 4;
        temp[3][0] = -4;
        temp[0][1] = 3;
        temp[1][1] = 2;
        temp[2][1] = -5;
        temp[3][1] = -9;
        temp[0][2] = -5;
        temp[1][2] = 8;
        temp[2][2] = 7;
        temp[3][2] = 9;
        int[] niz = maksimum(temp);
        for(int i:niz){
            System.out.println(i);
        }
    }
    
    public static int[][] generisiMatricu(int broj_redova, int broj_kolona) {
        if(broj_redova < 2 || broj_kolona < 2) throw new IllegalArgumentException("Broj kolona ili redova ne sme biti manji od 2.");
        int[][] matrica = new int[broj_redova][broj_kolona];
        Random r = new Random();
        for(int i = 0; i<matrica.length; i++){
            for(int j = 0; j<matrica[0].length;j++){
                matrica[i][j] = r.nextInt(61);
                matrica[i][j] -= 30;
            }
        }
        return matrica;
    }
    
    public static int[] maksimum(int[][] matrica){
        if(matrica.length < 2 || matrica[0].length < 2) throw new IllegalArgumentException("Broj kolona ili redova ne sme biti manji od 2.");
        int x1, y1, x2, y2, maksimum;
        x1 = 0;x2 = 0;y1 = 0;y2 = 0; maksimum = 0;
        int[] najvece_koordinate = new int[4];
        //Neka X budu kolone a Y redovi.
        while(true) { //Izlaz će biti return.
            int temp;
            int[] koordinate = {x1,x2,y1,y2};
            temp = getSabirak(matrica, koordinate);
            if(temp > maksimum){
                najvece_koordinate[0] = x1;najvece_koordinate[1] = x2;najvece_koordinate[2] = y1;najvece_koordinate[3] = y2;
                maksimum = temp;
            }
            x2++;
            if(x2 >= matrica[0].length){
                x2 = 0;
                y2++;
                if(y2 >= matrica.length){
                    y2 = 0;
                    x1++;
                    if(x1 >= matrica[0].length){
                        x1 = 0;
                        y1++;
                        if(y1 >= matrica.length){
                            break;
                        }
                    }
                }
            }
        }
        return najvece_koordinate;
    }
    
    public static int getSabirak(int[][] matrica, int[] koordinate){
        int sabirak = 0;
        for(int i = koordinate[0]; i <= koordinate[1]; i++){
            for(int j = koordinate[2]; j <= koordinate[3]; j++){
                //Ako nam je X kolona a Y red onda ćemo matrici da pristupamo prvo sa Y pa sa X jer su matrice u vidu red kolona
                sabirak += matrica[j][i];
            }
        }
        return sabirak;
    }
}
