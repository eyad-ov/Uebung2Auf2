public class Train extends Thread{

    private int trainID;
    static int i=0;
    private RailAB trackSection ;
    private boolean direction = true; //east when true
    private boolean leave = false;

    public Train(RailAB ts){
        trackSection = ts;
        trainID = i++;
    }

    public int getTrainID(){
        return trainID;
    }
    public boolean getDirection(){
        return direction;
    }
    @Override
    public void run() {
            double random = Math.random();
            if(random<0.5){
                goEast();
            }
            else{
                goWest();
            }
            //trackSection.enter(this);

            try{
                sleep((long)(Math.random()*5000));
            }
            catch(InterruptedException ex){

            }
            leaveAB(this);

    }

    public void leaveAB(Train train){
        trackSection.leave(this);

    }
    public  void goEast(){
        direction =true;
        System.out.println("East " + trainID);
        trackSection.enter(this);

    }
    public  void goWest(){
        direction = false;
        System.out.println("West " + trainID);
        trackSection.enter(this);


    }
}
