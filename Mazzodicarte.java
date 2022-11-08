package Briscola;
import java.util.Random;

public class Mazzodicarte {
    Carta[] carte = new Carta[40];

    public Mazzodicarte(String gioco){
        switch(gioco.toLowerCase()){
            case "briscola":
                char[] semi={'D','C','S','B'};
                int[] valori={1,2,3,4,5,6,7,8,9,10};
                float[] punti={11,0,10,0,0,0,0,2,3,4};
                int c,v,a=0;
                for(v=0;v<4;v++){
                    for(c=0;c<10;c++){
                        Carta carta = new Carta(valori[c],semi[v],punti[c]);
                        carte[c+a]= carta;
                    }
                    a+=10;
                }
                break;
            
            default:
                break;
        }

    }

    public Carta pesca(){
        Random rand= new Random();
        int b = rand.nextInt(40);
        return carte[b];
    }

    public void mischia(){
        Random rand= new Random();
        for(int i=0;i<40;i++){
            int primo = rand.nextInt(40);
			Carta temp = carte[primo];
			carte[primo] = carte[i];
			carte[i] = temp;
        }
    }
}
