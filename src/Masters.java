import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Masters {
	
	public static void main(String[] args) {
		new Masters().chamada("C:/Users/jeans/eclipse/jee-neon/workspace/RedesNeurais_2/src/out_FN.txt");
	}
	
	public double[][] chamada(String path) {
		return criaMatriz(loadArquivo(path));
	}

	private List<String> loadArquivo(String path) {
		
		List<String> conteudo = new ArrayList<String>();
		try {
			//"C:/Users/jeans/eclipse/jee-neon/workspace/RedesNeurais_2/src/out_FN.txt"
			BufferedReader in = new BufferedReader(new FileReader(path));
			String str;
			while ((str = in.readLine()) != null) {
				conteudo.add(str);
			}
			in.close();
		} catch (IOException ioe) {
			System.out.println(ioe);
		}
		return conteudo;
	}

	private double[][] criaMatriz(List<String> conteudo) {
		// pelo conteudo pego o n° dfe linhas para a matriz
		int linha = conteudo.size();
		int coluna = 3;
		
		double[][] matriz = new double[linha][coluna];
		
		int j = 0;
		
		for (Iterator iterator = conteudo.iterator(); iterator.hasNext();) {
			
			String linhas = (String) iterator.next();
			
			String[] tokens = linhas.split(";");
			for (int i = 0; i < tokens.length; i++) {
				String s = tokens[i];
				matriz[j][i] = Double.parseDouble(s);
			}
			j++;
			
		}
		
		for (int i = 0; i < linha; i++) {
			for (int d = 0; d < coluna; d++) {
				//System.out.print(matriz[i][d]+"-");
			}
			//System.out.println();
		}
		return matriz;
	}
}