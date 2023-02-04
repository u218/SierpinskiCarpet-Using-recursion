package Practical_20;
class SierpinskiCarpet {
    //    Creating 2d Array to store the carpet
    static String[][] Carpet;
    //to store the diminsion size we create the diminsion_size
    static int diminsion_size;
    //main function
    public static void main(String[] args) {
        System.out.println("Carpet  created and initialized with stars");
        SierpinskiCarpet board = new SierpinskiCarpet(27);
        print(27);

        System.out.println("Conversion of carpet into Sierpinski carpet");
        create(Carpet, 0, 0, 27);
        print(27);
    }

    // this function will make 2d size of array and will intialize it with stars
    public SierpinskiCarpet(int stars) {

        this.diminsion_size = stars;
        Carpet = new String[diminsion_size][diminsion_size];
        for (int i = 0; i < diminsion_size; i++) {
            for (int j = 0; j < diminsion_size; j++) {
                this.Carpet[i][j] = " * ";
            }
        }
    }



    // this will make the block in the center
    public static void create(String[][] Carpet, int x, int y, int Size) {

        makeEmpty(Size, x, y);

        // if currentSize is smaller then 1 it will return
        if (Size <= 1) {
            return;
        }

        // loops will iterate through all the blocks
        for (int i = 0; i < Size; i += Size / 3) {
            for (int j = 0; j < Size; j += Size / 3) {
                // recursive function to move to the 3n-1x3n-1 block
                create(Carpet, i + y, j + x, Size / 3);
            }
        }
    }

    //this function will crete the block in the middle to crete perfect carpet
    public static void makeEmpty(int Size, int k, int l) {

        for (int i = l + Size / 3; i <= l + 2 * (Size / 3) - 1; i++) {
            for (int j = k + Size / 3; j <= k + 2 * (Size / 3) - 1; j++) {
                Carpet[i][j] = "   ";
            }
        }
    }
    // here am using the string builder function to make it more efficient
    public static void print(int size) {

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                output.append(Carpet[i][j]);
            }
            output.append("\n");
        }
        System.out.print(output);
    }


}