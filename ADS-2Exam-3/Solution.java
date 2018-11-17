import java.util.*;                                                                                                         
public class Solution {
	// Don't modify this method.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String cases = scan.nextLine();
		switch (cases) {
		case "loadDictionary":
			// input000.txt and output000.txt
			BinarySearchST<String, Integer> hash = loadDictionary("/Files/t9.csv");
			while (scan.hasNextLine()) {
				String key = scan.nextLine();
				System.out.println(hash.get(key));
			}
			break;
		case "getAllPrefixes":
			// input001.txt and output001.txt
			T9 t9 = new T9(loadDictionary("/Files/t9.csv"));
			while (scan.hasNextLine()) {
				String prefix = scan.nextLine();
				for (String each : t9.getAllWords(prefix)) {
					System.out.println(each);
				}
			}
			break;
		case "potentialWords":
			// input002.txt and output002.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			int count = 0;
			while (scan.hasNextLine()) {
				String t9Signature = scan.nextLine();
				for (String each : t9.potentialWords(t9Signature)) {
					count++;
					System.out.println(each);
				}
			}
			if (count == 0) {
				System.out.println("No valid words found.");
			}
			break;

		case "topK":
			// input003.txt and output003.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			Bag<String> bag = new Bag<String>();
			int k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				bag.add(line);
			}
			for (String each : t9.getSuggestions(bag, k)) {
				System.out.println(each);
			}

			break;

		case "t9Signature":
			// input004.txt and output004.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			bag = new Bag<String>();
			k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				for (String each : t9.t9(line, k)) {
					System.out.println(each);
				}
			}
			break;

		default:
			break;

		}
	}

	// Don't modify this method.
	public static String[] toReadFile(String file) {
		In in = new In(file);
		return in.readAllStrings();
	}

	public static BinarySearchST<String, Integer> loadDictionary(String file) {
		BinarySearchST<String, Integer>  st = new BinarySearchST<String, Integer>();
		// your code goes here
		String[] dictionary = toReadFile(file);
		for (int i = 0; i < dictionary.length; i++) {
			for (String word : dictionary[i].split(" ")) {
				if (st.contains(word.toLowerCase())) {
					st.put(word.toLowerCase(), st.get(word.toLowerCase()) + 1);
				} else {
					st.put(word.toLowerCase(), 1);
				}
			}
		}
		return st;
	}
}

class T9 {
	TST<Integer> tst;
	BinarySearchST<String, Integer> bst;
	public T9(BinarySearchST<String, Integer> st) {
		// your code goes here
		bst = st;
		tst = new TST<Integer>();
		for (String key : bst.keys()) {
			tst.put(key, bst.get(key));
		}
	}

	// get all the prefixes that match with given prefix.
	public Iterable<String> getAllWords(String prefix) {
		// your code goes here
		return tst.keysWithPrefix(prefix);
	}

	public Iterable<String> potentialWords(String t9Signature) {
		// your code goes here
		TreeSet<String> set = new TreeSet<String>();
        for (String word : tst.keys()) {
            String[] tokens1 = word.split("");
            String format = "";
            for (String str : tokens1) {
                if (str.equals("a")
                    || str.equals("b") || str.equals("c")) {
                    format += "2";
                } else if (str.equals("d")
                    || str.equals("e") || str.equals("f")) {
                    format += "3";
                } else if (str.equals("g")
                    || str.equals("h") || str.equals("i")) {
                    format += "4";
                } else if (str.equals("j")
                    || str.equals("k") || str.equals("l")) {
                    format += "5";
                } else if (str.equals("m")
                    || str.equals("n") || str.equals("o")) {
                    format += "6";
                } else if (str.equals("p") || str.equals("q")
                    || str.equals("r") || str.equals("s")) {
                    format += "7";
                } else if (str.equals("t")
                    || str.equals("u") || str.equals("v")) {
                    format += "8";
                } else if (str.equals("w") || str.equals("x")
                    || str.equals("y") || str.equals("z")) {
                    format += "9";
                }
            }
            if (format.equals(t9Signature)) {
                set.add(word);
            }
        }
        return set;
	}

	// return all possibilities(words), find top k with highest frequency.
	public Iterable<String> getSuggestions(Iterable<String> words, int k) {
		// your code goes here
		MaxPQ<Integer> pq = new MaxPQ<Integer>();
        for (String word : words) {
            pq.insert(tst.get(word));
        }
        TreeSet<String> set = new TreeSet<String>();
        for (int i = 0; i < k; i++) {
            int frequency = pq.delMax();
            for (String word : words) {
                if (frequency == tst.get(word)) {
                    set.add(word);
                }
            }
        }
        return set;		
	}

	// final output
	// Don't modify this method.
	public Iterable<String> t9(String t9Signature, int k) {
		return getSuggestions(potentialWords(t9Signature), k);
	}
}







