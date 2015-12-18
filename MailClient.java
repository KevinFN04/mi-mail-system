
/**
 * Write a description of class MailClient here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MailClient
{
    //Variable que guarda el servidor.
    private MailServer server;
    //Variable que guarda el usuario.
    private String user;
    //Variable que guarda el ultimo mensaje.
    private MailItem lastMail;

    /**
     * Constructor for objects of class MailClient
     */
    public MailClient(String user, MailServer server)
    {
        this.server = new MailServer();
        this.server = server;
        this.user = user;
    }

    /**
     * Recoge el siguiente mensaje del servidor.
     */
    public MailItem getNextMailItem()
    {
        MailItem mensaje3 = server.getNextMailItem(user);
        lastMail = mensaje3;
        return lastMail;
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
    public void sendMailItem(String para, String asunto, String mensaje)
    {
        MailItem newMessage = new MailItem(user, para, mensaje, asunto);
        server.post(newMessage);
    }
    
    /**
     * Muestra cuantos correos tienes en el servidor.
     */
    public void printHowManyMailItems()
    {
        System.out.println ("Tienes " + server.howManyMailItems(user) + " Mensajes nuevos.");
    }
    
    /**
     * Devuelve un mensaje automaticamente al remitente.
     */
    public void getNextMailItemAndSendAutomaticRespond()
    {
        MailItem mensaje2 = getNextMailItem();
        if (mensaje2 != null){
            String para = mensaje2.getFrom();
            String mensaje = "Ahora mismo no me encuentro en la oficina. \n" + mensaje2.getMessage();
            String asunto = "RE:" + mensaje2.getSubject();
            MailItem newMessage = new MailItem(user, para, mensaje, asunto);
            server.post(newMessage);
        }
        else {
            System.out.println ("No hay mensajes nuevos.");
        }
    }
    
    /**
     * Metodo para imprimir el ultimo mensaje las veces que quieras.
     */
    public void printLastMessage()
    {
        if (lastMail != null){
            lastMail.print();
        }
        else {
            System.out.println ("No hay mensajes nuevos.");
        }
    }
    
}
