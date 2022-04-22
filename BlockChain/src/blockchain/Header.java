/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

/**
 *
 * @author JIT
 */
public class Header {
    private int version;
    private String previous_hash;
    private String merkle_root;
    private long timestamp;
    private int difficulty;
    private int nonce;

    public Header(String previous_hash) {
        this.version = 1;
        this.previous_hash = previous_hash;
        this.merkle_root = "0";
        this.timestamp = System.currentTimeMillis()/1000;
        this.difficulty = 2;
        this.nonce = 1;
    }

    public Header(int version, String previous_hash, String merkle_root, long timestamp, int difficulty) {
        this.version = version;
        this.previous_hash = previous_hash;
        this.merkle_root = merkle_root;
        this.timestamp = timestamp;
        this.difficulty = difficulty;
    }
    

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getPrevious_hash() {
        return previous_hash;
    }

    public void setPrevious_hash(String previous_hash) {
        this.previous_hash = previous_hash;
    }

    public String getMerkle_root() {
        return merkle_root;
    }

    public void setMerkle_root(String merkle_root) {
        this.merkle_root = merkle_root;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getNonce() {
        return nonce;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    @Override
    public String toString() {
        return "{" + "version=" + version + ", \n\t previous_hash=" + previous_hash + ",\n\t merkle_root=" + merkle_root + ",\n\t timestamp=" + timestamp + ",\n\t difficulty=" + difficulty + ",\n\t nonce=" + nonce + '}';
    }
    
    
}
