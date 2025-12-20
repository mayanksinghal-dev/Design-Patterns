package VisitorPattern;

/**
 * Allows to add new operations to existing classes without changing the structure. Separates operations from the object it operates.
 * It is used when we have multiple new operations, to avoid breaking OCP, We externalise what's changing and keep unchanging methods.
 *
 */

interface Visitor{
    void visit(TextDocument d);
    void visit(ImageDocument d);
    void visit(VideoDocument d);
}

interface Document{
    void accept(Visitor v);
}

class TextDocument implements Document{
    String name = "Text";
    public void accept(Visitor v){
        v.visit(this);
    }
}
class ImageDocument implements Document{
    String name = "Image";
    public void accept(Visitor v){
        v.visit(this);
    }
}
class VideoDocument implements Document{
    String name = "Video";
    public void accept(Visitor v){
        v.visit(this);
    }
}

class ScanDoc implements Visitor{
    public void visit(TextDocument d){
        System.out.println("scan "+d.name);
    }
    public void visit(ImageDocument d){
        System.out.println("scan "+d.name);
    }
    public void visit(VideoDocument d){
        System.out.println("scan "+d.name);
    }
}

class CompressDoc implements Visitor{
    public void visit(TextDocument d){
        System.out.println("Compress "+d.name);
    }
    public void visit(ImageDocument d){
        System.out.println("Compress "+d.name);
    }
    public void visit(VideoDocument d){
        System.out.println("Compress "+d.name);
    }
}

public class VisitorPattern {
    public static void main(String[] args){
        Visitor scan = new ScanDoc();
        Visitor compress = new CompressDoc();
        Document text = new TextDocument();

        text.accept(scan);
        text.accept(compress);
    }


}
