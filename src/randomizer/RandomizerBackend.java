package randomizer;

import java.io.*;
import java.util.*;

public class RandomizerBackend {
	private List<String> randomList = new ArrayList<>();
	private List<String> randomize = new ArrayList<>();

	private BufferedReader br;
	private String line;

	private int random;

	public RandomizerBackend(List<String> list) {
		this.randomList = list;
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

	public String setRandomAmount(int amount, List<String> list) {
		        randomize.clear();
        StringBuilder result = new StringBuilder();

        if (list.isEmpty()) {
            return "";
        }

        Random rand = new Random();
        for (int i = 0; i < amount; i++) {
            int index = rand.nextInt(list.size()); // safe index
            randomize.add(list.get(index));
        }

        for (String item : randomize) {
            result.append(item).append("\n");
        }

        return result.toString();
	}

	public String search(String search, List<String> list) {
		if (list.contains(search)) {
			return search;
		} else {
			return "";
		}

	}

}
