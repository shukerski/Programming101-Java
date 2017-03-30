package com.week07.thursday;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class PandaSocialNetwork {
	
	private HashMap<Panda, HashSet<Panda>> network;
	
	public PandaSocialNetwork() {
		network = new HashMap<>();
	}
	
	public void addPanda(Panda panda) {
		if(!network.containsKey(panda)) {
			network.put(panda, new HashSet<>());
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
		return network.get(panda1).contains(panda2); // the relationship is two-ways by definition, so no need to check if panda2 is friends with panda1
	}
	
	public HashSet<Panda> friendsOf(Panda panda) {
		try {
			return network.get(panda);
		} catch (NullPointerException e) {
			System.out.println("This particular panda is not in the network.");
			return null;
		}
	}
	
	// BFS
	public int connectionLevel(Panda panda1, Panda panda2) {
		Queue<Panda> queue = new LinkedList<>();
		int level = 0;
		
		if(areFriends(panda1, panda2)) {
			return 1;
		}
		
		queue.add(panda1);
		
		while(!queue.isEmpty()) {
			if(queue.contains(panda2)) {
				return level;
			}
			level++;			
			for(int i = 0; i < queue.size(); i++) {
				queue.addAll(network.get(queue.poll()));
			}
		}
		return -1;
		
	}
	
	public boolean areConnected(Panda panda1, Panda panda2) {
		return connectionLevel(panda1, panda2) != -1;
	}
	
	// Using some Java 8 stuff
	public long howManyGenderInNetwork(int level, Panda panda, String gender) {
		Queue<Panda> queue = new LinkedList<>();
		int l = 0;		
		queue.add(panda);
		
		while(l < level) {
			l++;			
			for(int i = 0; i < queue.size(); i++) {
				queue.addAll(network.get(queue.poll()));
			}
		}
		
		return queue.stream().filter(p -> p.getGender().equals(gender)).count();
	}
}
