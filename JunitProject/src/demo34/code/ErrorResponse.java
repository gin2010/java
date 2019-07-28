package demo34.code;
/**
 * Response that is returned in case of an error.
 * 
 * @version $Id: ErrorResponse.java 553 2010-03-06 12:29:58Z paranoid12 $
 */
public class ErrorResponse
    implements Response
{
    private Request originalRequest;

    private Exception originalException;

    public ErrorResponse( Request request, Exception exception )
    {
        this.originalRequest = request;
        this.originalException = exception;
    }

    public Request getOriginalRequest()
    {
        return this.originalRequest;
    }

    public Exception getOriginalException()
    {
        return this.originalException;
    }
}
