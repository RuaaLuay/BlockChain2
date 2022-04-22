/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author JIT
 */
public class Block {
    private int index;
    private Header header;
    private int transactions_count;
    private List<String> transactions;
    private String hash;
    

    public Block(int index, Header header, List<String> transactions) {
        this.index = index;
        this.header = header;
        this.transactions_count = transactions.size();
        this.transactions = transactions;
        this.hash = calculateHash();
    }

    public Block(int index, Header header, int transactions_count) {
        this.index = index;
        this.header = header;
        this.transactions_count = transactions_count;
        transactions = new ArrayList<>();
    }
    
    
    public String calculateHash(){
        String calculatedhash
            = Crypt.sha256(
                this.getHeader().getPrevious_hash()
                + Long.toString(this.getHeader().getTimestamp())
                + this.getHeader().getMerkle_root()+this.getHeader().getNonce()
                        +this.getHeader().getVersion()+this.getHeader().getDifficulty());
   
        return calculatedhash;
    }
    
    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public int getTransactions_count() {
        return transactions_count;
    }

    public void setTransactions_count(int transactions_count) {
        this.transactions_count = transactions_count;
    }

    public String getTransactions() {
        String t="";
        for (int i = 0; i < transactions.size(); i++) {
            t =t+"\n\t"+ transactions.get(i);
        }
        return t;
    }

    public void setTransactions(List<String> transactions) {
        for (int i = 0; i < transactions.size(); i++) {
            this.transactions.add(i, transactions.get(i));
        }
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    
    
    
}
