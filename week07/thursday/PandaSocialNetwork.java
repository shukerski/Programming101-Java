package com.week07.thursday;

import java.util.HashMap;
import java.util.HashSet;

public class PandaSocialNetwork {
	
	private HashMap<Panda, HashSet<Panda>> network;
	
	public void addPanda(Panda panda) {
		if(!network.containsKey(panda)) {
			network.put(panda, new HashSet<Panda>());
		}
	}
	
	public boolean hasPanda(Panda panda) {
		return network.containsKey(panda);
	}
	
	public void makeFriends(Panda panda1, Panda panda2) {
		if(!hasPanda(panda1)) {
			addPanda(panda1);
		}

		if(!hasPanda(panda2)) {
			addPanda(panda2);
		}
		
		network.get(panda1).add(panda2);
		network.get(panda2).add(panda1);
	}
	
	public boolean areFriends(Panda panda1, Panda panda2) {
		return network.get(panda1).contains(panda2);
	}
	
	public HashSet friendsOf(Panda panda) {
		return network.get(panda);
	}
	
//	With BFS which return the path. The answer is path.length - 1
//	TODO
	public int connectionLevel(Panda panda1, Panda panda2) {
		return 0;
	}
	
	public boolean areConnected(Panda panda1, Panda panda2) {
		return connectionLevel(panda1, panda2) != -1;
	}
	
	
	
	
}
