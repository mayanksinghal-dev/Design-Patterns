package ProxyPattern;

/**
 * Proxy pattern is used to act a firewall/middleware between the client and a resource. Proxy acts as the representative of the resource, we can access resource if proxy allows.
 * 3 Types of proxy - They all work and code same, its just different based on intent. Only there names are different based on intent, but they all work same internally.
 *  - Virtual - We're having an expensive service which is rarely used, but there objects are created more often. Which leads to performance and memory cost. So we create object only when user actually requests.
 *  - Protection - We're having a restrict/premium feature which should be accessed only upon verification of request. So we verify the request in proxy and allow only if verified.
 *  - Remote - When resource is on different server on the internet. So without letting the client know about the connection, proxy does the lazy loading to make the connection only when requested or when used for the first time and by connecting to the server and fetching the response.
 *  -x-
 *  In all these cases, client neither know nor care about the object created. It expects that the proxy is the resource and it is returning the result. But BTS, proxy is just
 *  middleware between client and resource.
 */

interface Proxy{
    void execute();
}

/**
 * Virtual Proxy
 */
class ImageProxy implements Proxy{
    RealImage ri = null;

    public void execute(){
        if(ri==null){
            ri = new RealImage();
        }
        ri.getRealImage();
    }
}

class RealImage{
    RealImage(){
        //expensive operation when object created
    }
    void getRealImage(){
        System.out.println("Got Real Image");
    }
}

/**
 * Protection Proxy
 */
class PDFProxy implements Proxy{
    AccessPdf pdf = null;

    public void execute(){
        if(pdf==null){
            pdf = new AccessPdf();
        }
        pdf.access();
    }
}

class AccessPdf{
    AccessPdf(){
        //expensive operation when object created
    }
    void access(){
        System.out.println("Unlock PDF");
    }
}

/**
 * Remote Proxy
 */
class DatabaseProxy implements Proxy{
    Database db = null;

    public void execute(){
        if(db==null){
            db = new Database();
        }
        db.connect();
    }
}

class Database{
    Database(){
        //expensive operation when object created
    }
    void connect(){
        System.out.println("Connect database");
    }
}
public class ProxyPattern {
    public static void main(String[] args){
        Proxy p1 = new ImageProxy(); //Virtual Proxy
        Proxy p2 = new PDFProxy(); //Protection Proxy
        Proxy p3 = new DatabaseProxy(); //Remote Proxy
        p1.execute();
        p2.execute();
        p3.execute();
    }
}
