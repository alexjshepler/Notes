public class DiceRollem {
    public static void main(String args[]) {
        Dice d1 = new Dice();
        Dice d2 = new Dice();
        Dice d3 = new Dice();
        Dice d4 = new Dice();
        Dice d5 = new Dice();

        int t = 0;
        for (int i = 0; i < 1000; i++) {
            int[] die = { d1.roll(), d2.roll(), d3.roll(), d4.roll(), d5.roll() };

            if(die[0] == die[1] && die[1] == die[2] && die[2] == die[3] && die[3] == die[4]){
                t++;
                System.out.println("Roll number " + i + " all dice show " + die[0] + ".");
            }
        }
        System.out.println("A total of " + t + " tosses were the same.");
    }
}