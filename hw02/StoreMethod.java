package ESOF322;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class StoreMethod {
	public static void main(String args[]) {
		int[] info = {1,2,3,4,5,6,7};
		Scanner input = new Scanner(System.in);
		SwitchStrategy thing = new SwitchStrategy(new noSQL());
		thing.change(info);
		String in = "";
		
		//Allows user to change storage strategy at will
		while(!in.equals("q")) {
			System.out.println("Which strategy do you want to use, Relational, noSQL, or Graph? Q will terminate the program: ");
			in = input.next().toLowerCase();
			if(in.equals("nosql")) {
				thing = new SwitchStrategy(new noSQL());
				thing.change(info);}
			else if(in.equals("relational")) {
				thing = new SwitchStrategy(new Relational());
				thing.change(info);
			}
			else if(in.equals("graph")) {
				thing = new SwitchStrategy(new Graph());
				thing.change(info);
			}
		}
	}
}

interface Strategy{
	public void store(int[] information);
}

class noSQL implements Strategy {
	public void store(int[] information) {
		//Uses document store
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("stored1.txt", "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		writer.println(information.toString());
		writer.close();
		System.out.println("The information was stored using noSQL");
	}
}

class Relational implements Strategy {
	public void store(int[] information) {
		// Uses table store
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("stored2.txt", "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		writer.println(Arrays.toString(information));
		writer.close();
		System.out.println("The information was stored using Relational db");
	}
	
}

class Graph implements Strategy {
	public void store(int[] information) {
		//Uses node store
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("stored3.txt", "UTF-8");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		writer.println(information.toString());
		writer.close();
		System.out.println("The information was stored using Graph");
	}

}

class SwitchStrategy{
	//function to switch which storage strategy is used
	private final Strategy strategy;
	
	public SwitchStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public void change(int[] information) {
		strategy.store(information);
	}
	
}
