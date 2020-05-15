public class FloodFill {
    public static void floodFill_Recursive(int[][] image, int i, int j, int sourceColor, int newColor) {
        if (i >= image.length || i < 0 || j >= image[i].length || j < 0) return;
        if (image[i][j] != sourceColor) return;

        image[i][j] = newColor;
        floodFill_Recursive(image, i + 1, j, sourceColor, newColor);
        floodFill_Recursive(image, i - 1, j, sourceColor, newColor);
        floodFill_Recursive(image, i, j + 1, sourceColor, newColor);
        floodFill_Recursive(image, i, j - 1, sourceColor, newColor);
    }


    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor)
            return image;

        floodFill_Recursive(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    public static void main(String[] args) {
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1, sc = 1, newColor = 2;

        Helper.printMatrix(floodFill(image, sr, sc, newColor));
    }
}
