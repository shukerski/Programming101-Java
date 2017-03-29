package com.week15.friday;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {
	public static class Fork {
		private final int id;
		Lock pick = new ReentrantLock(); // Making sure that a fork can be picked up only by 1 philosopher at a time

		public Fork(int id) {
			this.id = id;
		}

		public boolean pickUp(Philosopher p) throws InterruptedException {
			if (pick.tryLock(10, TimeUnit.MILLISECONDS)) {
				System.out.println(p + " picked up " + this);
				return true;
			}
			return false;
		}

		public void putDown(Philosopher p) {
			pick.unlock();
			System.out.println(p + " put down " + this);
		}

		@Override
		public String toString() {
			return "Fork " + id;
		}
	}

	public static class Philosopher implements Runnable {
		private final int id;
		private final Fork leftFork;
		private final Fork rightFork;
		volatile boolean isFull = false;
		private Random random = ThreadLocalRandom.current(); // Randomizing the eating and thinking time
		private int numberOfTimesIAte = 0;

		public Philosopher(int id, Fork leftFork, Fork rightFork) {
			this.id = id;
			this.leftFork = leftFork;
			this.rightFork = rightFork;
		}

		@Override
		public void run() {
			try {
				while (!isFull) {
					think();
					if (leftFork.pickUp(this)) {
						if (rightFork.pickUp(this)) {
							eat();
							rightFork.putDown(this);
						}
						leftFork.putDown(this);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		private void think() throws InterruptedException {
			System.out.println(this + " is thinking..");
			Thread.sleep(random.nextInt(1000));
		}

		private void eat() throws InterruptedException {
			System.out.println(this + " is eating..");
			numberOfTimesIAte++;
			Thread.sleep(random.nextInt(1000));
		}

		public int getNumberOfTimesIAte() {
			return numberOfTimesIAte;
		}

		@Override
		public String toString() {
			return "Philosopher " + id;
		}
	}

	private static final int NUMBER_OF_PHILOSOPHERS = 5;

	public static void main(String args[]) throws InterruptedException {
		ExecutorService executorService = null;

		Philosopher[] philosophers = null;
		try {

			philosophers = new Philosopher[NUMBER_OF_PHILOSOPHERS];

			Fork[] forks = new Fork[NUMBER_OF_PHILOSOPHERS];
			for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
				forks[i] = new Fork(i);
			}

			executorService = Executors.newFixedThreadPool(NUMBER_OF_PHILOSOPHERS);

			for (int i = 0; i < NUMBER_OF_PHILOSOPHERS; i++) {
				philosophers[i] = new Philosopher(i, forks[i], forks[(i + 1) % NUMBER_OF_PHILOSOPHERS]);
				executorService.execute(philosophers[i]);
			}

			Thread.sleep(10000);

			// Stopping the philosophers by making them full - comment to go on forever
			for (Philosopher philosopher : philosophers) {
				// if(philosopher.getNumberOfTimesIAte() > 0) {
				philosopher.isFull = true;
				// }
			}

		} finally {
			executorService.shutdown();

			// Waiting for all threads to finish
			while (!executorService.isTerminated()) {
				Thread.sleep(1000);
			}

			// Checking how many times each philosopher ate
			System.out.println();
			System.out.println("The philosophers ate: ");
			for (Philosopher philosopher : philosophers) {
				System.out.println(philosopher + " ate " + philosopher.getNumberOfTimesIAte() + " times.");
			}
		}
	}
}
