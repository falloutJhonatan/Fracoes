package app;

import java.util.ArrayList;

import Utils.Fracao;
import Utils.IOTools;

public class TesteFracao {

	public static void main(String[] args) {
		int op,tamanho;
		boolean menu2=false,menu1=false;
		Fracao[] f;
		tamanho = IOTools.getInt("Digite o tamanho do array: ");
		f = new Fracao[tamanho];
		do{
			do{
				String menu =	"---     Menu     ---"+
								"\n 1  - fazer nova fracao"+
								"\n 0  - ir para segundo menu ou sair"+
								"\nQual a opcao: ";
				op = IOTools.getInt(menu);
				switch(op){
				case 1:
					int n,m;
					n = IOTools.getInt("Numerador: ");
					m = IOTools.getInt("Denominador: ");
					if(!entrada(f, new Fracao(n,m))){
						IOTools.showMessage("vetor cheio!");
					}
					menu2 = true;
					break;
				case 0:
					break;
				default:
					IOTools.showMessage("Opcao ivalida!");
					break;
				}
			}while(op != 0);
			
			while(menu2 == true){
				String menu =	"---     Menu2     ---"+
						"\n 1  - somar"+
						"\n 2  - Subtrair"+
						"\n 3  - Multiplicar"+
						"\n 4  - Dividir"+
						"\n 5  - simplificar"+
						"\n 6  - menor fracao"+
						"\n 7  - ver todos"+
						"\n 8  - ver decimal"+
						"\n 9  - ver se dois sao iguais"+
						"\n 0  - Sair"+
						"\nQual a opcao: ";
				op = IOTools.getInt(menu);
				switch(op){
				case 1:
					int indice01 = IOTools.getInt(mostrar(f)+"digite o indice do primeiro: ");
					int indice02 = IOTools.getInt(mostrar(f)+"digite o indice do segundo: ");
					IOTools.showMessage(Fracao.Somar(f[indice01], f[indice02]).toString());
					break;
				case 2:
					indice01 = IOTools.getInt(mostrar(f)+"digite o indice do primeiro: ");
					indice02 = IOTools.getInt(mostrar(f)+"digite o indice do segundo: ");
					IOTools.showMessage(Fracao.Subtrair(f[indice01], f[indice02]).toString());
					break;
				case 3:
					indice01 = IOTools.getInt(mostrar(f)+"digite o indice do primeiro: ");
					indice02 = IOTools.getInt(mostrar(f)+"digite o indice do segundo: ");
					IOTools.showMessage(Fracao.multiplicar(f[indice01], f[indice02]).toString());
					break;
				case 4:
					indice01 = IOTools.getInt(mostrar(f)+"digite o indice do primeiro: ");
					indice02 = IOTools.getInt(mostrar(f)+"digite o indice do segundo: ");
					IOTools.showMessage(Fracao.dividir(f[indice01], f[indice02]).toString());
					break;
				case 5:
					int indice = IOTools.getInt(mostrar(f)+"digite o indice: ");
					f[indice].simplicar();
					break;
				case 6:
					indice01 = IOTools.getInt(mostrar(f)+"digite o indice do primeiro: ");
					indice02 = IOTools.getInt(mostrar(f)+"digite o indice do segundo: ");
					IOTools.showMessage(Fracao.minima(f[indice01], f[indice02]).toString());
					break;
				case 7:
					IOTools.showMessage(mostrar(f));
					break;
				case 8:
					indice = IOTools.getInt(mostrar(f)+"digite o indice: ");
					IOTools.showMessage(f[indice].decimal()+"");
					break;
				case 9:
					indice01 = IOTools.getInt(mostrar(f)+"digite o indice do primeiro: ");
					indice02 = IOTools.getInt(mostrar(f)+"digite o indice do segundo: ");
					IOTools.showMessage(f[indice01].equivale(f[indice02]) ? "sao iguais\n":"sao diferentes\n");
					break;
				case 0:
					menu1 = false;
					menu2 = false;
					break;
				default:
					IOTools.showMessage("Opcao ivalida!");
					break;
				}
			}
		}while(menu1 == true);
		
		IOTools.showMessage("Fim.");
	}
	public static boolean entrada(Fracao[] fracao, Fracao f){
		for(int i=0;i<fracao.length;i++){
			if(fracao[i] == null){
				fracao[i] = f;
				return true;
			}
		}
		return false;
	}
	public static String mostrar(Fracao[] f){
		String msg="";
		for(int i=0;i<f.length;i++){
			if(f[i] != null){
				msg += i + " -  " + f[i].toString()+"\n";
			}
		}
		return msg;
	}
}
