class Main {
    public static void main(String[] args) {
        char[][] chars = {{'O', 'X', 'X'} , {'O', 'X', 'O'} , {'X', 'O', 'X'}};
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                if(j == 2)
                    System.out.print(chars[i][j]);
                else
                    System.out.print(chars[i][j] + " ");
            }
            System.out.println();
        }
    }
}