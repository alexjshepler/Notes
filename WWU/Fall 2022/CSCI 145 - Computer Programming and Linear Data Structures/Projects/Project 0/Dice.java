public class Dice {
    public int roll(){
        return new java.util.Random().nextInt(7) + 1;
    }
}