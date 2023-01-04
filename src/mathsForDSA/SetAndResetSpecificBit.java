package mathsForDSA;

/*
1) Find the i'th bit.
2) Set the i'th bit.
3) Reset the i'th bit.
4) Find the position of the right most set bit.
 */
public class SetAndResetSpecificBit {
    public static void main(String[] args) {
        //that is how we represent binary number
        int n = 0B10110;
        int i =5;
        System.out.println(find(n,i));
        System.out.println(setBit(n,i));
        System.out.println(resetBin(n,i));
    }
    /*
    To find the i'th bit, we and it with its mask,
    A mask is the binary number which gives the i'th bit,
    example:
    1001010101001
    mask for 4'th bit will be 1000
    to get the mask, left shift 1 (n-1) times!
     */
    public static String find(int n,int i){
        int bin = n & (1<<(i-1));
        return Integer.toBinaryString(bin);
    }
    /*
    Setting a bit, means making the bit "1"
     */
    public static String setBit(int n,int i){
        int bin = n | (1<<(i-1));
        return Integer.toBinaryString(bin);
    }

    /*
    Resetting a bit, means making the bit "0"
     */
    public static String resetBin(int n, int i){
        // taking the compliment of the mask, and doing,
        // "and" with the number to reset the bit
        int bin = n & ((1<<(i-1)) ^ 1);
        return Integer.toBinaryString(bin);
    }

}
