import java.util.ArrayList;

public class RailAB {
    // first time all west waiting!?
    //int trains = 3;
    ArrayList<Train> trains = new ArrayList<Train>();
    boolean direction = true; //east when true

    public synchronized void enter(Train train){

        while(trains.size()==3 || this.direction != train.getDirection()){
                try{
                    wait();
                }

                catch(InterruptedException ex){}

                if(trains.isEmpty()){
                    this.direction = train.getDirection();
                }
            }

        notifyAll(); // wichtig !?
        trains.add(train);
        System.out.println("train " + train.getTrainID() + " entered the track section, the direction is " +(direction ?"east":"west"));

    }

    public synchronized void leave(Train train){
        // rheinfolge achten
        while(trains.get(0)!= train){
            try{
                wait();
            }
            catch(InterruptedException ex){
                ex.printStackTrace();
            }
        }
        trains.remove(train);
        System.out.println("train " + train.getTrainID() + " left the track section");
        notifyAll();
    }


}
