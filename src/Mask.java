public class Mask {
    public final int[][] gx;
    public final int[][] gy;

    public Mask() {
        this.gx = new int[][]{{-1, 0, 1}, {-2, 0, 2}, {-1, 0, 1}};
        this.gy = new int[][]{{1, 2, 1}, {0, 0, 0}, {-1, -2, -1}};
    }
}
