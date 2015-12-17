
/**
 * Write a description of class MailClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailClient
{
    
    private MailServer server;
    
    private String user;
    

    /**
     * Constructor for objects of class MailClient
     */
    public MailClient(String usuario, MailServer servidor1)
    {
        server = new MailServer();
        server = servidor1;
        user = usuario;
    }

    /**
     * Recoge el siguiente mensaje del servidor.
     */
    public MailItem getNextMailItem()
    {
        return server.getNextMailItem(user);
    }
    
    /**
     * Imprime el siguiente mensaje.
     */
    public void printNextMailItem()
    {
        MailItem mensaje1 = getNextMailItem();
        if (mensaje1 == null){
            System.out.println("No tienes correo nuevo.");
        }
        else{
            mensaje1.print();
        }
    }
    
    /**
     * Envia un mensaje a un destinatario mediante el servidor.
     */
    public void sendMailItem(String para, String mensaje)
    {
        MailItem newMessage = new MailItem(user, para, mensaje);
        server.post(newMessage);
    }
}
