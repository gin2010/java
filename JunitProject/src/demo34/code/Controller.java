package demo34.code;

/**
 * A controller interface.
 * 
 * @version $Id: Controller.java 553 2010-03-06 12:29:58Z paranoid12 $
 */
public interface Controller
{
    Response processRequest( Request request );

    void addHandler( Request request, RequestHandler requestHandler );
}
