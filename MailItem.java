
/**
 *
 */
public class MailItem
{
    //Variable que guarda el emisor.
    private String from;
    //Variable que guarda el destinatario.
    private String to;
    //Variable que guarda el mensaje.
    private String message;
    //Variable que guarda el asunto.
    private String subject;

    /**
     * Constructor for objects of class MailItem
     */
    public MailItem(String from, String to, String message, String subject)
    {
        this.from = from;
        this.to = to;
        this.message = message;
        this.subject = subject;
    }

    /**
     * Metodo que devuelve el emisor.
     */
    public String getFrom()
    {
        return from;
    }
    
     /**
     * Metodo que devuelve el receptor.
     */
    public String getTo()
    {
        return to;
    }
    
    /**
     * Metodo que devuelve el asunto.
     */
    public String getSubject()
    {
        return subject;
    }
    
    /**
     * Metodo que devuelve el mensaje.
     */
    public String getMessage()
    {
        return message;
    }
    
    /**
     * Metodo que imprime el mensaje con emisor y destinatario.
     */
    public void print()
    {
        System.out.println("From: " + from);
        System.out.println("To: " + to);
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
    }
}
