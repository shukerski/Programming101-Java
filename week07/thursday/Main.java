package com.week07.thursday;

public class Main {

	public static void main(String[] args) {
		PandaSocialNetwork network = new PandaSocialNetwork();
		Panda ivo = new Panda("Ivo", "ivo@pandamail.com", "male");
		Panda rado = new Panda("Rado", "rado@pandamail.com", "male");
		Panda tony = new Panda("Tony", "tony@pandamail.com", "female");

		network.addPanda(ivo);
		network.addPanda(rado);
		network.addPanda(tony);

		network.makeFriends(ivo, rado);
		network.makeFriends(rado, tony);

		System.out.println(network.connectionLevel(ivo, rado) == 1);
		System.out.println(network.connectionLevel(ivo, tony) == 2);
		System.out.println(network.howManyGenderInNetwork(1, rado, "female") == 1);

	}

}
