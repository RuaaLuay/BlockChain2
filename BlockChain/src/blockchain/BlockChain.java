/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author JIT
 */
public class BlockChain {

    private List<String> unconfirmed_transactions = null;
    private List<Block> chain;

    public BlockChain() {
        try {
            unconfirmed_transactions = new ArrayList<>();
            chain = new ArrayList<>();
            this.addGensisBlock();
            Scanner in = new Scanner(new File("chain.txt"));
            in.next();
            while (in.hasNextLine()) {
                while (in.nextLine()!=" -------------------------------------------------------------------------------") {
                   for(int i=0; i<5;i++){
                    String arr[] = in.nextLine().split(":");
                    int index = Integer.parseInt(arr[2]);
                    
                } 
                    
                }
                
                
            }
        } catch (FileNotFoundException ex) {
            System.err.println("File Not Found !");
        }
        
    }

    private Block lastBlock() {
        return chain.get(chain.size() - 1);
    }

    private boolean addBlock(Block block, String hash) {
        String previousHash;
        if (chain.size() == 0) {
            previousHash = "0";
        } else {
            previousHash = lastBlock().getHash();
        }
        if (!previousHash.equals(block.getHeader().getPrevious_hash())) {
            return false;
        }
        if (!isValidProof(block, hash)) {
            return false;
        }
        block.setHash(hash);
        chain.add(block);
        return true;
    }

    public void addTransaction(String transaction) {
        unconfirmed_transactions.add(transaction);
    }

    private boolean isValidProof(Block block, String hash) {
        return (hash.substring(0, 2).equalsIgnoreCase("00") && hash.equals(block.calculateHash()));
    }

    private String proofOfWork(Block block) {
        block.getHeader().setNonce(0);
        String computedHash = block.calculateHash();
        while (!computedHash.startsWith("00")) {
            block.getHeader().setNonce(block.getHeader().getNonce() + 1);
            computedHash = block.calculateHash();
        }
        return computedHash;
    }

    private void addGensisBlock() {
        this.addTransaction("Basecoin -> Ruaa -> 1000");
        this.mine();
    }

    public boolean mine() {
        Block block;
        if (unconfirmed_transactions.size() == 0) {
            return false;
        } else {
            if (chain.size() == 0) {
                Header header = new Header(1, "0", "0", System.currentTimeMillis() / 1000, 2);
                block = new Block(0, header, unconfirmed_transactions.size());
                block.setTransactions(unconfirmed_transactions);
            } else {
                Block lastBlock = lastBlock();
                Header header = new Header(1, lastBlock.getHash(), "0", System.currentTimeMillis() / 1000, 2);
                block = new Block(lastBlock.getIndex() + 1, header, unconfirmed_transactions.size());
                block.setTransactions(unconfirmed_transactions);
            }
            String hash = proofOfWork(block);
            addBlock(block, hash);
            try {
                PrintWriter P = new PrintWriter(new FileWriter("chain.txt"));
                String x = toview();
                P.append(x);
                P.close();
                System.out.println("Saved in File");
            } catch (IOException e) {
                System.out.println("Data cannot Saved in file");
            }
            unconfirmed_transactions.clear();
            return true;
        }
    }

    public void view() {
        for (int i = 0; i < chain.size(); i++) {
            System.out.println("[Index: " + chain.get(i).getIndex() + "\n Header:" + chain.get(i).getHeader().toString() + "\n Transactions count:" + chain.get(i).getTransactions_count() + "\n Transactions: "
                    + chain.get(i).getTransactions() + "\n Hash: " + chain.get(i).getHash() + "]");
            System.out.println("-------------------------------------------------------------------------------");
        }
    }
    public String toview() {
        String s ="";
        for (int i = 0; i < chain.size(); i++) {
            s+="[Index: " + chain.get(i).getIndex() + "\n Header:" + chain.get(i).getHeader().toString() + "\n Transactions count:" + chain.get(i).getTransactions_count() + "\n Transactions: "
                    + chain.get(i).getTransactions() + "\n Hash: " + chain.get(i).getHash() + "]\n -------------------------------------------------------------------------------\n";
        }
        return s;
    }

}
