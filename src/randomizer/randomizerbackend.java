package randomizer;

import java.io.*;
import java.util.*;

public class RandomizerBackend {
	private List<String> randomList = new ArrayList<>();
	private List<String> randomize = new ArrayList<>();

	private BufferedReader br;
	private String line;

	private int random;
	private String item = "";

	public RandomizerBackend(List<String> gameList) {
		this.randomList = gameList;
	}

	public List<String> getInfo(File file) {
		try {
			br = new BufferedReader(new FileReader(file));
			line = br.readLine();
			while (line != null) {
				randomList.add(line);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return randomList;
	}

	public String setRandomAmount(int amount, List<String> randomized) {
		randomize.clear();
		item = "";
		for (int i = 0; i < amount; i++) {
			random = (int) (Math.random() * ((3178 - 1) + 1)) + 1;
			randomize.add(randomized.get(random));
		}
		for (String r : randomize) {
			item += r + "\n";
		}
		return item;
	}

	public String search(String search, List<String> gamers) {
		if (gamers.contains(search)) {
			return search;
		} else {
			return "";
		}

	}

}
