public class Mitsubishi extends Car{
    public Mitsubishi(int cylinders, String name) {
        super(cylinders, name);
    }

    @Override
    public String accelerate() {
        return "accelerating Mitsubishi";
    }

    @Override
    public String brake() {
        return "braking Mitsubishi";
    }

    @Override
    public String startEngine() {
        return "starting engine on Mitsubishi";
    }
}
