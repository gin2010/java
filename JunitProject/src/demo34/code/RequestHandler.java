package demo34.code;
/**
 * The request-handler interface.
 * 
 * @version $Id: RequestHandler.java 553 2010-03-06 12:29:58Z paranoid12 $
 */
public interface RequestHandler
{
    Response process( Request request ) throws Exception;
}
