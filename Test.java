public class Test
{
	/** 
	 * Metodo que prueba el segundo apartado de la actividad
	 * 0170.
	 */
	public void test1()
	{
		MailServer gmail = new MailServer();
		MailClient cliente1 = new MailClient("pepe@gmail.com", gmail);
		MailClient cliente2 = new MailClient("pepe@gmail.com", gmail);
		
		System.out.println("Probando que funciona el metodo getNextMailItemAndSendAutomaticRespond");
		System.out.println("##########################");
		cliente1.sendMailItem("maria@gmail.com","Hola","Hola Maria");
		cliente2.getNextMailItemAndSendAutomaticRespond();
		cliente1.printNextMailItem();
		
		System.out.println();
		System.out.println("Probando cuando no hemos mandando ningun correo");
		System.out.println("##########################");
		cliente2.getNextMailItemAndSendAutomaticRespond();
		cliente1.printNextMailItem();
	}
	
		public void test2()
	{
		MailServer gmail = new MailServer();
		MailClient cliente1 = new MailClient("pepe@gmail.com", gmail);
		MailClient cliente2 = new MailClient("pepe@gmail.com", gmail);
		
		System.out.println("Mostramos el ultimo email cuando NO se ha recibido aun ninguno");
		System.out.println("##########################");
		cliente2.printLastMessage();
		
		System.out.println("Mostramos el ultimo email cuando SI se ha recibido aun ninguno");
		System.out.println("##########################");		
		cliente1.sendMailItem("maria@gmail.com","Hola","Hola Maria");
		cliente2.printNextMailItem();
		cliente2.printLastMessage();		
		cliente2.printNextMailItem();
		cliente2.printLastMessage();		
	}
}

