import java.util.Scanner;

public class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int img[][] = new int[image.length][image[0].length];
        for(int i = 0; i < image.length; i++)
            for(int j = 0; j < image[0].length; j++)
                img[i][j] = image[i][j];
        int inicolor = image[sr][sc];
        int vis[][] = new int[image.length][image[0].length];
        int dx[] = {-1, 0, +1, 0};
        int dy[] = {0, +1, 0, -1};
        
        dfs(sr, sc, dx, dy, vis, img, color, inicolor);
        return img;
    }

    public void dfs(int sr, int sc, int dx[], int dy[], int vis[][], int img[][], int color, int inicolor) {
        vis[sr][sc] = 1;
        img[sr][sc] = color;
        for(int i = 0; i < 4; i++) {
            int nr = sr + dx[i];
            int nc = sc + dy[i];
            if(nr >= 0 && nc >= 0 && nr < img.length && nc < img[0].length 
               && vis[nr][nc] == 0 && img[nr][nc] == inicolor) {
                dfs(nr, nc, dx, dy, vis, img, color, inicolor);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input image dimensions
        System.out.print("Enter number of rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number of columns: ");
        int cols = sc.nextInt();

        int[][] image = new int[rows][cols];
        System.out.println("Enter the image matrix row-wise (space separated):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                image[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter starting row (sr): ");
        int sr = sc.nextInt();
        System.out.print("Enter starting column (sc): ");
        int sc_col = sc.nextInt();  // renamed to avoid conflict with Scanner sc
        System.out.print("Enter new color: ");
        int color = sc.nextInt();

        Solution solution = new Solution();
        int[][] result = solution.floodFill(image, sr, sc_col, color);

        System.out.println("Flood filled image:");
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
