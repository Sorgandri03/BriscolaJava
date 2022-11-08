package Briscola;
import java.util.Scanner;

public class gioco {
    static Mazzodicarte mazzo = new Mazzodicarte("briscola");
    static Carta[] g1 = new Carta[3];
    static Carta[] g2 = new Carta[3];
    static Carta[] estratte = new Carta[40];
    static int e = 0, scelta1, scelta2, g1points, g2points;
    static Carta briscola;
    static boolean gameover = false, esito;


    public static void main(String[] args){
        mazzo.mischia();
        mazzo.mischia();
        setup();
        while(gameover==false){
            display();
            input();
        }
        if(g1points>g2points){
            System.out.println("Vince G1!");
        }
        else if(g1points<g2points){
            System.out.println("Vince G2!");
        }
        else{
            if(g1points>g2points){
                System.out.println("Pari");
            }
        }
    }

    public static void setup(){
        g1points=0;
        g2points=0;
        for(int c=0; c<3; c++){
            g1[c]=mazzo.carte[e];
            e++;
            //System.out.println(g1[c].getCarta());
        }
        System.out.println("");
        for(int c=0; c<3; c++){
            g2[c]=mazzo.carte[e];
            e++;
            //System.out.println(g2[c].getCarta());
        }
        briscola=mazzo.carte[e];
        e++;
        //System.out.println("");
        //System.out.println(briscola.getCarta());
    }

    public static void mano(Carta g[]){
        for(int i=0;i<3;i++){
            System.out.print(i+") ");
            switch(g[i].seme){
                case 'D':
                    if(g[i].valore==1){
                        System.out.println("Il gallinaccio");
                    }
                    else{
                        System.out.println("Il "+g[i].valore+" di denari");
                    }
                    break;
                case 'C':
                    if(g[i].valore==1){
                        System.out.println("L'asso di coppe");
                    }
                    else{
                        System.out.println("Il "+g[i].valore+" di coppe");
                    }
                    break;
                case 'B':
                    if(g[i].valore==1){
                        System.out.println("L'asso di bastoni");
                    }
                    else{
                        System.out.println("Il "+g[i].valore+" di bastoni");
                    }
                    break;
                case 'S':
                    if(g[i].valore==1){
                        System.out.println("L'asso di spade");
                    }
                    else{
                        System.out.println("Il "+g[i].valore+" di spade");
                    }
                    break;
            }
        }
    }

    public static void display(){
        System.out.print("La briscola è ");
        switch(briscola.seme){
            case 'D':
                System.out.print("denari\n\n");
                break;
            case 'S':
                System.out.print("spade\n\n");
                break;
            case 'C':
                System.out.print("coppe\n\n");
                break;
            case 'B':
                System.out.print("bastoni\n\n");
                break;
        }

        System.out.println("G1 hai in mano:");
        mano(g1);

        System.out.println("\nG2 hai in mano:");
        mano(g2);

        esito = input();

        if(esito){
            System.out.println("Prende G1");
            g1points+=g1[scelta1].punti;
        }
        else{
            System.out.println("Prende G2");
            g2points+=g2[scelta2].punti;
        }

        if(e==40){
            gameover=true;
        }

    }

    public static boolean input(){
        System.out.println("\nG1, che giochi?");
        Scanner scan = new Scanner(System.in);
        int scelta1 = scan.nextInt();

        System.out.println("\nG2, che giochi?");
        int scelta2 = scan.nextInt();

        scan.close();

        return logic(g1[scelta1],g2[scelta2]);
    }

    public static boolean logic(Carta a, Carta b){
        if(a.seme==briscola.seme){
            if(b.seme==briscola.seme){
                return false;      //!!
            }
            else{
                return true;
            }
        }
        else{
            if(b.seme==briscola.seme){
                return false;
            }
            else{
                if(a.seme==b.seme){
                    return false;   //!!
                }
                else{
                    return true;
                }
            }
        }

        
        //briscola? vince
        //seme diverso? vince
        //punti più alti? vince
        //valore più alto? vince
    }
}
