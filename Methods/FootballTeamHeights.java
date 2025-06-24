import java.util.Random;

public class FootballTeamHeights {

    
    public static int[] generateHeights(int size) {
        Random rand = new Random();
        int[] heights = new int[size];
        for (int i = 0; i < size; i++) {
            heights[i] = rand.nextInt(101) + 150; // 0-100 + 150 = 150 to 250
        }
        return heights;
    }

    
    public static int sumHeights(int[] heights) {
        int sum = 0;
        for (int h : heights) {
            sum += h;
        }
        return sum;
    }

    
    public static double meanHeight(int[] heights) {
        return (double) sumHeights(heights) / heights.length;
    }

    
    public static int shortestHeight(int[] heights) {
        int min = heights[0];
        for (int h : heights) {
            if (h < min) min = h;
        }
        return min;
    }

    
    public static int tallestHeight(int[] heights) {
        int max = heights[0];
        for (int h : heights) {
            if (h > max) max = h;
        }
        return max;
    }

    
    public static void main(String[] args) {
        int[] heights = generateHeights(11);

        System.out.println("Player Heights (cm):");
        for (int i = 0; i < heights.length; i++) {
            System.out.printf("Player %2d: %3d cm\n", i + 1, heights[i]);
        }

        System.out.println("-----------------------------");
        System.out.println("Shortest Height: " + shortestHeight(heights) + " cm");
        System.out.println("Tallest Height:  " + tallestHeight(heights) + " cm");
        System.out.printf("Mean Height:     %.2f cm\n", meanHeight(heights));
    }
}
