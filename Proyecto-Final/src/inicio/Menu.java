package inicio;

import java.util.Scanner;

public class Menu {
	
	public int pintaMenu() {
		Scanner leer= new Scanner(System.in);
		int opc=0;
		do {
			System.out.println("MENU DE LA CUENTA BANCARIA");
			System.out.println("1. Ver el número de cuenta completo");
			System.out.println("2. Ver el titular de la cuenta");
			System.out.println("3. Ver el código de la entidad");
			System.out.println("4. Ver el código de la oficina");
			System.out.println("5. Ver el número de la cuenta");
			System.out.println("6. Ver los digitos de control de la cuenta");
			System.out.println("7. Realizar un ingreso. (Solicitar cantidad)");
			System.out.println("8. Retirar efectivo (Solicitar cantidad)");
			System.out.println("9. Consultar saldo");
			System.out.println("10. Salir de la aplicación");
			opc = leer.nextInt();
		}while(opc<1 || opc>10);
		return opc;
	}
}
