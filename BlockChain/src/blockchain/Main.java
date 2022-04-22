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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BlockChain blockchain = new BlockChain();
        blockchain.addTransaction("Basecoin->Ruaa->10");
        blockchain.addTransaction("Ruaa->Jood->10");
        blockchain.addTransaction("Ruaa->Saba->10");
        blockchain.mine();
        blockchain.addTransaction("Basecoin->Ruaa->5");
        blockchain.addTransaction("Ruaa->Luay->10");
        blockchain.mine();
        blockchain.view();
    }
}
