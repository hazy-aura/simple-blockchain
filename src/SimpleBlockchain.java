import java.util.ArrayList;
import com.google.gson.GsonBuilder;

public class SimpleBlockchain {
    public static ArrayList<Block> blockchain = new ArrayList<Block>(); 
    public static void main(String args[]){
        Block genesisBlock = new Block("Genesis Block", "0"); 
        blockchain.add(genesisBlock);

        Block secondBlock = new Block("Second Block", blockchain.get(blockchain.size()-1).hash);
        blockchain.add(secondBlock);

        Block thirdBlock = new Block("Third Block",  blockchain.get(blockchain.size()-1).hash);
        blockchain.add(thirdBlock);

        Block fourthBlock = new Block("Fourth Block",  blockchain.get(blockchain.size()-1).hash);
        blockchain.add(fourthBlock);

        String blockchainJson = new GsonBuilder().setPrettyPrinting().create().toJson(blockchain);
        System.out.println("The block chain: ");
        System.out.println(blockchainJson);
    
    }

    public static Boolean isChainValid(){
        Block currBlock;
        Block prevBlock;

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

        }
        return true;
    }
    
}
