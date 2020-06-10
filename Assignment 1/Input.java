//input class, read in file, tokenize, create grid
package assignment1;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.StringTokenizer;

public class Input{
	int acc;
	//counts the number of games 1-3
	List<String> file;
	StringTokenizer tokenizer;

	//Disclaimer: input (readin file) file howto was found on stack overflow *https://stackoverflow.com/questions/26133085/reading-lines-from-a-file-in-java*
	public Input() {
		acc = 0;
		try {
			file = Files.readAllLines(Paths.get("C:\\Users\\subwa\\OneDrive\\Documents\\Java CSC 300\\workspace\\assignment1\\src\\assignment1\\input.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int[][] read() {
		int[][] Grid = new int[25][25];
		//create Grid
		tokenizer = new StringTokenizer(file.get(acc), "(");
		int tokacc = 0;
		//count tokens
		while (tokenizer.hasMoreTokens()) 
		{
			String tok = tokenizer.nextToken();
			int comma = tok.indexOf(",");
			//need to index by comma due to how input file is formatted
			int R = Integer.parseInt(tok.substring(0, comma));
			int C = Integer.parseInt(tok.substring(comma+1, tok.length()-1));
			
			if (tokacc == 0){
				Grid[R][C] = 1;
			}
			else if (tokacc == 4){
				Grid[R][C] = 2;
			}
			else if (tokacc == 5){
				Grid[R][C] = 3;
			}
			else if (tokacc == 7){
				Grid[R][C] = 4;
			}
			else Grid[R][C] = 5;
			tokacc++;
		}
		acc++;
		return Grid;
	}
}
