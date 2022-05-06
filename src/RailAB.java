public class RailAB {
    // first time all west waiting!?
    int trains = 3;
    boolean direction = true; //east when true

    public synchronized void enter(Train train){

        while(trains == 0 || this.direction != train.getDirection()){
                try{
                    wait();
                }

                catch(InterruptedException ex){}

                if(trains == 3){
                    this.direction = train.getDirection();
                }
            }

        notifyAll(); // wichtig !?
        trains--;
        System.out.println("train " + train.getTrainID() + " entered the track section, the direction is " +(direction ?"east":"west"));

    }

    public synchronized void leave(Train train){
        // rheinfolge achten
        trains++;
        System.out.println("train " + train.getTrainID() + " left the track section");
        notifyAll();
    }


}
