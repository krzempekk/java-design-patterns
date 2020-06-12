package adapter;

public class Main {
    public static void main(String[] args){
        RoundHole hole = new RoundHole(5);
        RoundPeg rpeg = new RoundPeg(5);
        System.out.println("RoundHole with radius 5:");
        System.out.println("\tRoundPeg with radius 5 fits? " + hole.fits(rpeg));

        SquarePeg smallSqpeg = new SquarePeg(5);
        SquarePeg lagreSqpeg = new SquarePeg(10);
        // line below won't compile because of incompatible types
        // hole.fits(smallSqpeg);

        SquarePegAdapter smallSqpegAdapter = new SquarePegAdapter(smallSqpeg);
        SquarePegAdapter largeSqpegAdapter = new SquarePegAdapter(lagreSqpeg);

        System.out.println("\tAdapted SquarePeg with width 5 fits? " + hole.fits(smallSqpegAdapter));
        System.out.println("\tAdapted SquarePeg with width 10 fits? " + hole.fits(largeSqpegAdapter));
    }
}
