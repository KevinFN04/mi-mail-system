
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
    //Variable para guardar los mensajes recibidos.
    private int mailsRecibidos;
    //Variable para guardar los mensajes Spam.
    private int mailsSpam;
    //variable que indica si el ultimo mensaje es spam.
    private boolean spam;

    private int caracteres;

    private String userlrg;

    /**
     * Constructor for objects of class MailClient
     */
    public MailClient(String user, MailServer server)
    {
        this.server = server;
        this.user = user;
        this.lastMail = null;
        this.spam = false;
    }

    /**
     * Recoge el siguiente mensaje del servidor.
     */
    public MailItem getNextMailItem()
    {
        spam = false;
        MailItem email = server.getNextMailItem(user);
        if (email.getMessage().contains("Regalo") || email.getMessage().contains("Promoción")){
            spam = true;
        }

        if(email.getMessage().contains("Trabajo")){
            spam = false;
        }       

        if (spam == true){
            email = null;
            mailsSpam = mailsSpam + 1;
            mailsRecibidos = mailsRecibidos +1;
        }   

        if(email != null){
            if(lastMail == null || email.getMessage().length() > lastMail.getMessage().length()){
                caracteres = email.getMessage().length();
                userlrg = email.getFrom();            
            }
            lastMail = email;
            mailsRecibidos = mailsRecibidos +1;
        }

        return email;
    }

    /**
     * Imprime el siguiente mensaje.
     */
    public void printNextMailItem()
    {
        MailItem mensaje1 = getNextMailItem();
        if (mensaje1 == null && spam == false){
            System.out.println("No tienes correo nuevo.");
        }
        else if(mensaje1 == null && spam == true){
            System.out.println("¡Has recibido spam!");
            mailsRecibidos = +1;
            mailsSpam = +1;
        }
        else{
            mensaje1.print();            
            mailsRecibidos = +1;
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

    /**
     * Metodo para imprimir el ultimo mensaje las veces que quieras.
     */
    public void showStats()
    {
        System.out.println("Mensajes recibidos: " + mailsRecibidos);
        System.out.println("Mensajes de Spam: " + mailsSpam);
        float porcentajeSpam = (mailsSpam * mailsRecibidos) / 100;
        System.out.println("Porcentaje de Spam: " + porcentajeSpam);
        System.out.println("Mensaje mas largo enviado por: " + userlrg + " con el numero de caracteres de: " + caracteres);
    }

}
