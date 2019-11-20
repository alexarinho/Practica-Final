package inicio;

import java.util.Scanner;

public class AplicacionCuentaBancaria {

	public static void main(String[] args) {
		Scanner leer = new Scanner(System.in);
		int opc = 0;
		
		CuentaBancaria cuenta = new CuentaBancaria();
	
		cuenta.pedirNombreTitular();
		cuenta.pedirCodigoCuenta();
		System.out.println(cuenta.calcularDigitosControl());
		
		Menu menu = new Menu();
		
		if(cuenta.calcularDigitosControl()==true) {
			menu.pintaMenu();
		}
				
	}
	
}
