package TemplatePattern;

/**
 * Template pattern is used to define a strict template to execute set of tasks in particular fashion/manner. During a feature, if we have to perform steps in a
 * particular order, then template pattern design that order and restrict the feature to execute in that order only.
 */

abstract class ModelTemplate{
    protected abstract void fetchData();
    protected abstract void preProcess();
    protected abstract void trainModel();
    public final void execute(){
        fetchData();
        preProcess();
        trainModel();
    }
}

class NLPModel extends ModelTemplate{
    protected void fetchData(){
        System.out.println("fetching data");
    }
    protected void preProcess(){
        System.out.println("preProcess data");
    }
    protected void trainModel(){
        System.out.println("trainModel data");
    }
}
class DataModel extends ModelTemplate{
    protected void fetchData(){
        System.out.println("fetching data");
    }
    protected void preProcess(){
        System.out.println("preProcess data");
    }
    protected void trainModel(){
        System.out.println("trainModel data");
    }
}

public class TemplatePattern {
    public static void main(String[] args){
        ModelTemplate mt1 = new NLPModel();
        ModelTemplate mt2 = new DataModel();
        mt1.execute();
        mt2.execute();
    }
}

