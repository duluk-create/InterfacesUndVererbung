import javax.management.ListenerNotFoundException;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class SpaceInvaders {
   public static Random r = new Random();

    public static Point raumschiff = new Point(r.nextInt(7), 4);


    public static ArrayList<Integer> xSchuesse = new ArrayList<>();
    public static ArrayList<Integer> ySchuesse = new ArrayList<>();


    public static boolean weiter = true;

    public static void main(String[] args) {
        while(weiter) {
            spielFeld();
            schiesseBewege();
            leseListe();
        }
    }

    private static void leseListe() {

        List<Integer> shots = new ArrayList();
        for(int i =0; i< xSchuesse.size(); i++){
            if(ySchuesse.get(i) == 0 && !shots.contains(xSchuesse.get(i))){

                shots.add(xSchuesse.get(i));
            }
               if(shots.size() == 8){
                   weiter = false;
                   System.out.println("Du hast gewonnen!");
               }
        }

    }


    private static void schiesseBewege() {
        Scanner scanner = new Scanner(System.in);
        String in = scanner.next();
        String bewegung = scanner.next();


        if(in.equals("s")){
            xSchuesse.add(raumschiff.x);
            ySchuesse.add(3);
        }

        if(bewegung.equals("a")){
            if(raumschiff.x > 0)
                raumschiff.x--;
        }
        else if(bewegung.equals("d")){
            if(raumschiff.x < 7)
                raumschiff.x++;
        }
        else if(bewegung.equals("x")){
            weiter = false;
        }

    }


    public static void spielFeld() {
        for(int y=0; y < 5; y ++){
            for(int x=0; x < 8; x++){
                boolean shot = true;

                   for(int s=0; s<xSchuesse.size(); s++){
                   int sx = xSchuesse.get(s);
                   int sy = ySchuesse.get(s);

                       if(sy == 0 && y == 0 && x == sx){
                           System.out.print(" ");
                           shot = false;
                       }
                       else if(x == sx && y == sy){
                           System.out.print("|");
                           shot = false;
                       }

               }

                    if(y == 0 && shot)
                       System.out.print("o");
                   else if(y == 4){
                       if(raumschiff.x == x)
                           System.out.print("V");
                       else
                           System.out.print(" ");
                   }
                   else if(shot){
                       System.out.print(" ");
                   }
            }
            System.out.println();
        }
        for(int w=0; w<ySchuesse.size(); w++){
            int wy = ySchuesse.get(w);

            if(wy > 0){
                ySchuesse.set(w, wy - 1);
            }

        }

    }

}
