/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blockchain;

import java.util.LinkedList;

/**
 *
 * @author JIT
 */
public class PeerQueue <T>{
    private LinkedList<T> queue;
	
	public T peek(){
		return queue.peek();
	}
	
	public T poll(){
		return queue.poll();
	}
	
	public void add(T t){
		queue.add(t);
		
	}
	
	public PeerQueue(){
		queue = new LinkedList<T>();
	}

}
