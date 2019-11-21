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
			do {
				opc = menu.pintaMenu();
				switch (opc) {
				case 1:
					System.out.println(cuenta.numCuentaCompleto());
					break;

				case 2:
					System.out.println("El titular es: " + cuenta.getTitular());
					break;
					
				case 3:
					System.out.println("El codigo de la entidad es: " + cuenta.getCodEntidad());
					break;
					
				case 4:
					System.out.println("El codigo de la oficina es: " + cuenta.getCodOficina());
					break;
				case 5:
					System.out.println("El numero de la cuenta es: " + cuenta.getNumCuenta());
					break;
				case 6:
					System.out.println("Los digitos de control son: " + cuenta.getControl());
					break;
				case 7:
					cuenta.hacerIngreso();
					break;
				case 8:
					cuenta.retirarEfectivo();
					break;
				case 9:
					System.out.println("Tu saldo es: " + cuenta.getSaldo());
					break;
				case 10:
					System.out.println("Adios");
					break;
				}
			}while(opc!=10 || opc<10);
			
			
		}
				
	}
	
}
