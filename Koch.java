public class Koch {

    public static void main(String[] args) {
        if (args.length > 0) {
            snowFlake(Integer.parseInt(args[0]));
        }
    }

    public static void curve(int n, double x1, double y1, double x2, double y2) {
        if (n == 0) {
            StdDraw.line(x1, y1, x2, y2);
            return;
        }

        double xa = x1 + (x2 - x1) / 3.0;
        double ya = y1 + (y2 - y1) / 3.0;
        double xb = x1 + 2.0 * (x2 - x1) / 3.0;
        double yb = y1 + 2.0 * (y2 - y1) / 3.0;

        double x3 = 0.5 * (x1 + x2) - (Math.sqrt(3) / 6.0) * (y2 - y1);
        double y3 = (Math.sqrt(3) / 6.0) * (x2 - x1) + 0.5 * (y1 + y2);

        curve(n - 1, x1, y1, xa, ya);
        curve(n - 1, xa, ya, x3, y3);
        curve(n - 1, x3, y3, xb, yb);
        curve(n - 1, xb, yb, x2, y2);
    }

    public static void snowFlake(int n) {
        StdDraw.setYscale(0, 1.1);
        StdDraw.setXscale(0, 1.1);
        
        double x1 = 0.2, y1 = 0.2;
        double x2 = 0.8, y2 = 0.2;
        double x3 = 0.5, y3 = 0.2 + (0.6 * Math.sqrt(3) / 2);

        curve(n, x1, y1, x2, y2);
        curve(n, x2, y2, x3, y3);
        curve(n, x3, y3, x1, y1);
    }
}