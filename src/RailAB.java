import java.util.ArrayList;

public class RailAB {
    ArrayList<Train> trains = new ArrayList<>();

    /*
       0 = neutral
       1 = east
       2 = wast
    */
    int direction = 0;

    public synchronized void enter(Train train){

        while(trains.size()==3 || ( this.direction !=0 && this.direction != train.getDirection() ) ){
                try{
                    wait();
                }

                catch(InterruptedException ex){
                    ex.printStackTrace();
                }
            }

        trains.add(train);
        this.direction = train.getDirection();
        System.out.println("train " + train.getTrainID() + " entered the track section, the direction is " +(direction==1 ?"east":"west"));

    }

    public synchronized void leave(Train train){
        while(trains.get(0)!= train){
            try{
                wait();
            }
            catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
        trains.remove(train);

        if(trains.isEmpty()){
            this.direction=0;
        }
        System.out.println("train " + train.getTrainID() + " left the track section");
        notifyAll();
    }


}
