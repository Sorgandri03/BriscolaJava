package Briscola;

public class Carta {
    int valore;     //1-10
    char seme;    //D,C,B,S
    float punti;    //0-11

    public Carta(int Valore, char Seme, float Punti){
        valore=Valore;
        seme=Seme;
        punti=Punti;
    }

    public Carta(){
        
    }

    public String getCarta(){
        return(valore+","+seme+","+punti);
    }
}
