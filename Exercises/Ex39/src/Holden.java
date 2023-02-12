public class Holden extends Car{
    public Holden(int cylinders, String name){
        super(cylinders, name);
    }

    @Override
    public String startEngine() {
        return "starting engine on Holden";
    }

    @Override
    public String brake() {
        return "braking on Holden";
    }

    @Override
    public String accelerate() {
        return "accelerating on Holden";
    }
}
