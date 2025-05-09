public class SimpleBlockchain {
    public static void main(String args[]){
        Block genesisBlock = new Block("Genesis Block", "0");
        System.out.println("Hash for block 1 : " + genesisBlock.hash);

        Block secondBlock = new Block("Second Block", genesisBlock.hash);
        System.out.println("Hash for block 2 : " + secondBlock.hash);

        Block thirdBlock = new Block("Third Block", secondBlock.hash);
        System.out.println("Hash for block 3 : " + thirdBlock.hash);

        Block fourthBlock = new Block("Fourth Block", thirdBlock.hash);
        System.out.println("Hash for block 4 : " + fourthBlock.hash);
    }
}
