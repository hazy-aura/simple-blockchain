
import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class SimpleBlockchain {
	
	public static int difficulty = 6;
    public static ArrayList<Block> blockchain = new ArrayList<Block>(); 
    
    public static void main(String args[]){
        Block genesisBlock = new Block("Genesis Block", "0"); 
        blockchain.add(genesisBlock);
        System.out.println("Mining Block 1... ");
        blockchain.get(0).mineBlock(difficulty);

        Block secondBlock = new Block("Second Block", blockchain.get(blockchain.size()-1).hash);
        blockchain.add(secondBlock);
        System.out.println("Mining Block 2... ");
        blockchain.get(1).mineBlock(difficulty);


        Block thirdBlock = new Block("Third Block",  blockchain.get(blockchain.size()-1).hash);
        blockchain.add(thirdBlock);
        System.out.println("Mining Block 3... ");
        blockchain.get(2).mineBlock(difficulty);


        Block fourthBlock = new Block("Fourth Block",  blockchain.get(blockchain.size()-1).hash);
        blockchain.add(fourthBlock);
        System.out.println("Mining Block 4... ");
        blockchain.get(3).mineBlock(difficulty);
        
        System.out.println("Blockchain is Valid: " + isChainValid());


        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("The block chain: ");
        System.out.println(blockchainJson);
    
    }

    public static Boolean isChainValid(){
        Block currBlock;
        Block prevBlock;
        String hashTarget = new String(new char[difficulty]).replace('\0', '0');

        for(int i=1; i<blockchain.size(); i++){
            currBlock = blockchain.get(i);
            prevBlock = blockchain.get(i-1);
            
            if(!currBlock.hash.equals(currBlock.calculateHash())){
                System.out.println("Current Hashes not equal");
                return false;
            }

            if(!prevBlock.hash.equals(currBlock.prevHash)){
                System.out.println("Previous Hashes not equal");
                return false;
            }
            
            if(!currBlock.hash.substring( 0, difficulty).equals(hashTarget)) {
				System.out.println("This block hasn't been mined");
				return false;
			}

        }
        return true;
    }
    
}
