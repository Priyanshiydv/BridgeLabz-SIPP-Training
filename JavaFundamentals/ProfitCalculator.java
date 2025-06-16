public class ProfitCalculator 
{
    public static void main(String[] args) 
    {
        int cP = 129;
        int sP = 191;

        int profit = sP - cP;
        double profitPercentage = (profit * 100.0) / cP;

        System.out.println(
            "The Cost Price is INR " + cP + " and the Selling Price is INR " + sP + "\n" +
            "The Profit is INR " + profit + " and the Profit Percentage is " + profitPercentage);
    }
}
