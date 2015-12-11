
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
    //Variable que guarda si el mensaje es spam o no.
    private boolean spamMail;

    /**
     * Constructor for objects of class MailClient
     */
    public MailClient(String user, MailServer server)
    {
        this.server = server;
        this.user = user;
        this.lastMail = null;
        this.spamMail = false;
    }

    /**
     * Recoge el siguiente mensaje del servidor.
     */
    public MailItem getNextMailItem()
    {
        MailItem email = server.getNextMailItem(user);
        if(email.getMessage().contains("Trabajo")){
            lastMail = email;
        }
        else if (email.getMessage().contains("Regalo") || email.getMessage().contains("Promoción")){
            email = null;
        }
        else if (email != null) {
            lastMail = email;
        }
        return email;
    }

    /**
     * Imprime el siguiente mensaje.
     */
    public void printNextMailItem()
    {
        MailItem mensaje1 = server.getNextMailItem(user);
        if (mensaje1 == null){
            System.out.println("No tienes correo nuevo.");
        }
        else if(mensaje1.getMessage().contains("Trabajo")){
            mensaje1.print();
        }
        else if (mensaje1.getMessage().contains("Regalo") || mensaje1.getMessage().contains("Promoción")){
            System.out.println("¡Has recibido Spam!");
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
            sendMailItem(para, asunto, mensaje);
            //MailItem newMessage = new MailItem(user, para, mensaje, asunto);
            //server.post(newMessage);
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
            System.out.println ("No hay mensajes para mostrar.");
        }
    }

}
