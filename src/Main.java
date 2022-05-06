public class Main {
    public static void main(String[] args){
       RailAB ab = new RailAB();
       for(int i=0;i<10;i++){
           new Train(ab).start();
       }

    }
}
