
/**
 *
 */
public class MailItem
{
    
    private String from;
    
    private String to;
    
    private String message;

    /**
     * Constructor for objects of class MailItem
     */
    public MailItem(String from1, String to1, String message1)
    {
        from = from1;
        to = to1;
        message = message1;
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
        System.out.println("Message: " + message);
    }
}
