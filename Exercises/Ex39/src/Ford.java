public class Ford extends Car{
    public Ford(int cylinders, String name) {
        super(cylinders, name);
    }
    

    @Override
    public String startEngine() {
        return "starting engine on Ford";
    }

    @Override
    public String accelerate() {
        return "accelerate on Ford";
    }

    @Override
    public String brake() {
        return "braking on Ford";
    }
}
