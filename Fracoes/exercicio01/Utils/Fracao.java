package Utils;

public class Fracao {
	private int numerador;
	private int denominador;
	
	public Fracao(){
		this.numerador = 0;
		this.denominador = 1;
	}
	
	public Fracao(int n){
		this.numerador = n;
		this.denominador = 1;
	}
	
	public Fracao(int numerador, int denominador) {
		if(numerador>0 && denominador>0){
			this.numerador = numerador;
			this.denominador = denominador;
		}else{
			this.numerador = 0;
			this.denominador = 1;
		}
	}
	
	public void simplicar(){
		int number = mdc(this.numerador, this.denominador);
		this.numerador /= number;
		this.denominador /= number;
	}
	
	public static Fracao Somar(Fracao f1, Fracao f2){
		if(f1.denominador != f2.denominador&&(f1 != null && f2 != null)){
			int number = mmc(f1.denominador, f2.denominador);
			f1.numerador = f1.numerador * (f1.denominador/number);
			f2.numerador = f2.numerador * (f2.denominador/number);
			return new Fracao(f1.numerador+f2.numerador, number);
		}
		return new Fracao(f1.numerador+f2.numerador, f1.denominador);
	}
	
	public static Fracao Subtrair(Fracao f1, Fracao f2){
		if(f1.denominador != f2.denominador&&(f1 != null && f2 != null)){
			int number = mmc(f1.denominador, f2.denominador);
			f1.numerador = f1.numerador * (f1.denominador/number);
			f2.numerador = f2.numerador * (f2.denominador/number);
			return new Fracao(f1.numerador+f2.numerador, number);
		}
		return new Fracao((f1.numerador-f2.numerador)*(-1), f1.denominador);
	}
	public static Fracao multiplicar(Fracao f1, Fracao f2){
		if(f1 != null && f2 != null){
			return new Fracao(f1.numerador*f2.numerador, f1.denominador * f2.denominador);
		}else{
			return null;
		}
	}
	public static Fracao dividir(Fracao f1, Fracao f2){
		if(f1 != null && f2 != null){
			return new Fracao(f1.numerador*f2.denominador, f1.denominador * f2.numerador);
		}else{
			return null;
		}
	}
	
	public double decimal(){
		return Double.valueOf(this.numerador) / Double.valueOf(this.denominador);
	}
	
	public static Fracao minima(Fracao f1, Fracao f2){
		if(f1.decimal()<f2.decimal()){
			return f1;
		}
		return f2;
	}
	
	public boolean equivale(Fracao f){
		if(this.decimal()==f.decimal()){
			return true;
		}
		return false;
	}

	public int getNumerador() {
		return numerador;
	}

	public int getDenominador() {
		return denominador;
	}
	
	public static int mmc(int m, int n){
		return  m*n/mmc(m,n);
	}

	public static int mdc(int m, int n){
		int r = n % m;
		
		while(r!=0){
			n = m;
			m = r;
			r = n % m;
		}
		return m;
	}

	@Override
	public String toString() {
		return numerador + "/" + denominador;
	}
	
	
}
