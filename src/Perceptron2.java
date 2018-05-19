import java.util.Random;

public class Perceptron2 {
	static int biasindex = 2;
	
	public static void main(String[] args) {
		Random rnd = new Random();
		Masters file = new Masters();
		double TreinamentoIn[][] = file.chamada("C:/Users/jeans/eclipse/jee-neon/workspace/RedesNeurais_2/src/in_FN.txt");
		double TreinamentoOut[][] = file.chamada("C:/Users/jeans/eclipse/jee-neon/workspace/RedesNeurais_2/src/out_FN.txt");
		
		double w[] = new double[4];
		w[0] = 1; 
		w[1] = 0;
		w[2] = 1;
		w[3] = 0;
		
		//System.out.println("W "+w[0]+" "+w[1]+" "+w[2]);
		for(int i = 0; i < TreinamentoIn.length;i++) {
			double r1 = neuronio(TreinamentoIn[i],w);
			double r2 = neuronio(TreinamentoIn[i],w);
			double r3 = neuronio(TreinamentoIn[i],w);
			//System.out.println("In "+TreinamentoIn[i][0]+","+TreinamentoIn[i][1]+","+TreinamentoIn[i][2]+" = "+r+" [E="+(TreinamentoOut[i][0]-r+"]"));
			System.out.println("In "+TreinamentoIn[i][0]+" [E="+(TreinamentoOut[i][0]+"]"+" | "+TreinamentoIn[i][1]+ "[E="+ TreinamentoOut[i][1]+"]"+" | "+TreinamentoIn[i][2]+ "[E="+ TreinamentoOut[i][2]+"]"));
		}
		
		for(int epoca = 0; epoca < 100; epoca++ ) {
			double dw[] = new double[4];
			for(int j = 0; j < TreinamentoIn.length;j++) {
				double r = neuronio(TreinamentoIn[j],w);
				double e = TreinamentoOut[j][0] - r;
				for(int i = 0; i < TreinamentoIn[j].length;i++) {
					dw[i] += TreinamentoIn[j][i]*e*0.1;
				}
				dw[biasindex] += 1*e*0.1;
			}
			for(int i = 0; i < TreinamentoIn[0].length;i++) {
				w[i] += dw[i];
			}
			w[biasindex] += dw[biasindex];
			//System.out.println("W "+w[0]+" "+w[1]);
		}
		System.out.println("----------------TREINOU-------------------");
		System.out.println("W "+w[0]+" "+w[1]+" "+w[2]);
		for(int i = 0; i < TreinamentoIn.length;i++) {
			double r = neuronio(TreinamentoIn[i],w);
			//System.out.println("In "+TreinamentoIn[i][0]+","+TreinamentoIn[i][1]+","+TreinamentoIn[i][2]+" = "+r+" [E="+(TreinamentoOut[i][0]-r+"]"));
		}
		
	}
	
	public static double neuronio(double in[],double w[]) {
		double soma = 0;
		for(int i = 0; i < in.length;i++) {
			soma += in[i]*w[i];
		}
		soma += 1*w[biasindex];
		if(soma>0) {
			return 1;
		}else {
			return 0;
		}
	}
}
