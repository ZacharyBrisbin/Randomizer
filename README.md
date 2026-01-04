# 🎲 Randomizer

**Randomizer** is a utility that reads data from a CSV file and generates a randomized list based on the file’s contents. Each row in the CSV may contain **one or multiple items**, and all items are included in the randomization process.

This makes it useful for randomized selections, ordering, team assignments, name draws, or any scenario requiring fair randomness from structured CSV input.

---

## 🧠 How It Works

1. Accepts a **CSV file** as input  
2. Reads each row and extracts **all items on that line**  
3. Combines all items into a single list  
4. Randomizes the list  
5. Outputs the randomized result

---

## 📁 CSV Format

Each row in the CSV can contain **one or more items**, separated by commas.

### Single item  per row

```csv
Alice
Bob
Charlie
Dana
```

### Multiple items per row
```csv
Alice, Bob
Charlie, Dana
Evan, Frank
```

🚀 Usage

### Requirements
* Java JDK 8 or newer
* A valid CSV file

### Go into the correct folder
```bash
cd "wherever you have the folder"/src/gui
```

### Compile
```bash
javac randomizergui.java
```

### Run
```bash
java randomizergui
```

📤 Example Output
```text
Dana
Alice
Frank
Charlie
Bob
Evan
```
🔒 File Handling

The CSV file is read using Java’s try-with-resources statement, which ensures the file is automatically closed after processing.

This prevents file locks and resource leaks on all supported platforms.

🛠️ Possible Enhancements

Future improvements could include:

Ignoring CSV headers

Seeded randomness for reproducible results

Outputting results to a file

Selecting a subset of items

Grouped or chunked randomization

📜 License

This project is licensed under the MIT License.
See the LICENSE file for details.

✨ Author

Zachary Brisbin
GitHub: https://github.com/ZacharyBrisbin


