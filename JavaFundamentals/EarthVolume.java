public class EarthVolume 
{
    public static void main(String[] args) 
   {
        double radiusKm = 6378;
        double radiusMiles = radiusKm / 1.6;
        double pi = Math.PI;

        double volumeKm = (4.0 / 3.0) * pi * Math.pow(radiusKm, 3);
        double volumeMiles = (4.0 / 3.0) * pi * Math.pow(radiusMiles, 3);

        System.out.println("The volume of earth in cubic kilometers is " + volumeKm +
                           " and cubic miles is " + volumeMiles);
    }
}
