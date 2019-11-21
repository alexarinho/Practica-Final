package inicio;

import java.util.Scanner;

public class CuentaBancaria {
	
	private String titular;
	private String numCuenta;
	private String codEntidad;
	private String codOficina;
	private double saldo;
	private String control;
	
	
	public CuentaBancaria() {
		titular = "";
		numCuenta = "";
		codEntidad = "";
		codOficina = "";
		saldo=0;
		control="";
		
	}
	public CuentaBancaria(String titular) {
		this.titular = titular;
		numCuenta = "";
		codEntidad = "";
		codOficina = "";
		saldo = 0;
		control="";
		
	}
	public CuentaBancaria(String titular, String numCuenta) {
		this.titular = titular;
		this.numCuenta=numCuenta;
		codEntidad = "";
		codOficina = "";
		saldo = 0;
		control ="";
		
	}
	
	public void pedirNombreTitular() {
		Scanner leer = new Scanner(System.in);
		
		boolean nombre = false;
		
		do {
			System.out.println("Dime tu nombre de titular: (No puede superar los 18 caracteres)");
			titular = leer.nextLine();
			if(titular.length()<=18) {
				System.out.println("Nombre correcto");
				nombre = true;
			} else {
				System.out.println("Error al escribir el numero de cuenta");
				nombre = false;
			}
		}while(nombre == false);
		
	}
	public void pedirCodigoCuenta() {
		do {
			Scanner leer = new Scanner(System.in);
			System.out.println("Dime tu CCC por partes:");
			System.out.println("Codigo entidad: (4 digitos)");
			codEntidad = leer.nextLine();
			System.out.println("Codigo oficina: (4 digitos)");
			codOficina = leer.nextLine();
			System.out.println("Digito de control: (2 digitos)");
			control = leer.nextLine();
			System.out.println("Nº de cuenta: (10 digitos)");
			numCuenta = leer.nextLine();
			
			if(numCuenta.length()>10) {
				System.out.println("Numero de cuenta incorrecto");
			}
			if(codEntidad.length()>4) {
				System.out.println("Codigo Entidad incorrecto");
			}
			if(codOficina.length()>4) {
				System.out.println("Codigo Oficina incorrecto");
			}
		}while(numCuenta.length()>10 || (codEntidad.length()>4) || (codOficina.length()>4));
	}
	
	public boolean calcularDigitosControl() {
		int num1=0, num2=0, numTotal=0;
		int dig1=0;
		int resto1=0;	
		
		num1 = Integer.valueOf(this.codEntidad.substring(0, 1)) * 4;
		num1 += Integer.valueOf(this.codEntidad.substring(1, 2)) * 8;
		num1 += Integer.valueOf(this.codEntidad.substring(2, 3)) * 5;
		num1 += Integer.valueOf(this.codEntidad.substring(3, 4)) * 10;
		
		num2 = Integer.valueOf(this.codOficina.substring(0, 1)) * 9;
		num2 += Integer.valueOf(this.codOficina.substring(1, 2)) * 7;
		num2 += Integer.valueOf(this.codOficina.substring(2, 3)) * 3;
		num2 += Integer.valueOf(this.codOficina.substring(3, 4)) * 6;
		
		numTotal= num1 + num2;
		resto1 = numTotal%11;
		
		dig1=11-resto1;
		
		if(dig1==10) {
			dig1=1;
		}else if(dig1==11){
			dig1=0;
		}
		
		int numsCuenta=0;
		int dig2=0;
		int resto2=0;
		
		numsCuenta = Integer.valueOf(this.numCuenta.substring(0, 1)) * 1;
		numsCuenta += Integer.valueOf(this.numCuenta.substring(1, 2)) * 2;
		numsCuenta += Integer.valueOf(this.numCuenta.substring(2, 3)) * 4;
		numsCuenta += Integer.valueOf(this.numCuenta.substring(3, 4)) * 8;
		numsCuenta += Integer.valueOf(this.numCuenta.substring(4, 5)) * 5;
		numsCuenta += Integer.valueOf(this.numCuenta.substring(5, 6)) * 10;
		numsCuenta += Integer.valueOf(this.numCuenta.substring(6, 7)) * 9;
		numsCuenta += Integer.valueOf(this.numCuenta.substring(7, 8)) * 7;
		numsCuenta += Integer.valueOf(this.numCuenta.substring(8, 9)) * 3;
		numsCuenta += Integer.valueOf(this.numCuenta.substring(9, 10)) * 6;
		
		resto2 = numsCuenta%11;
		
		dig2=11-resto2;
		if(dig2==10) {
			dig2=1;
		}else if(dig2==11) {
			dig2=0;
		}
		
		
		String codTotal="";
		
		codTotal = Integer.toString(dig1)+Integer.toString(dig2);
		
		
		if(codTotal.equalsIgnoreCase(this.control)) {
			return true;
		} else {
			return false;
		}
		
	}
	public String numCuentaCompleto() {
		String completo ="";
		completo = codEntidad + "-" + codOficina + "-" + control + "-" + numCuenta;
		return completo;
	}
	
	
	public void setSaldo(double saldo) {
		this.saldo=saldo;
		Scanner leer = new Scanner(System.in);
		System.out.println("Dime un saldo para meter en tu cuenta");
		saldo= leer.nextDouble();
		
	}
	
	public void hacerIngreso() {
		double ingreso = 0;
		Scanner leer = new Scanner(System.in);
		System.out.println("Dime una cantidad para ingresar a tu cuenta");
		ingreso = leer.nextDouble();
		
		boolean numero = false;
		do {
			if(ingreso>0) {
				saldo += ingreso;
				numero = true;
			}else {
				System.out.println("Cantidad incorrecta, vuelva a ingresar una cantidad correcta");
				numero = false;
			}
		}while(numero = false);
		
	}
	
	public void retirarEfectivo() {
		double retiro=0;
		Scanner leer = new Scanner(System.in);
		System.out.println("Dime una cantidad de dinero para retirar de tu cuenta");
		retiro = leer.nextDouble();
		boolean cantidad = false;
		
		do {
			if(retiro <= saldo || retiro >0) {
				System.out.println("Has sacado "+retiro+" euros de tu cuenta"); 
				saldo-=retiro;
				cantidad = true;
			} else {
				System.out.println("Cantidad para retirar incorrecta");
				cantidad = false;
			}
		}while(cantidad == false);
		
	}
	
	
	public String getTitular() {
		return titular;
	}
	
	public String getCodEntidad() {
		return codEntidad;
	}
	
	public String getCodOficina() {
		return codOficina;
	}
	public double getSaldo() {
		return saldo;
	}
	
	public String getNumCuenta() {
		return numCuenta;
	}
	
	public String getControl() {
		return control;
	}
	public String toString() {
		return "CuentaBancaria [titular=" + titular + ", numCuenta=" + numCuenta + ", codEntidad=" + codEntidad
				+ ", codOficina=" + codOficina + ", saldo=" + saldo + ", control=" + control + "]";
	}
	
	
}
