public class Train extends Thread{

    private int trainID;
    static int i=0;
    private RailAB trackSection ;
    private int direction = 1; //east when 1, west when 2

    public Train(RailAB ts){
        trackSection = ts;
        trainID = i++;
    }

    public int getTrainID(){
        return trainID;
    }

    public int getDirection(){
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
        direction =1;
        trackSection.enter(this);

    }
    public  void goWest(){
        direction = 2;
        trackSection.enter(this);


    }
}
