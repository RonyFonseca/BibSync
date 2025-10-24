package factory;

public class BibFactory {
    public static Factory criarBib(String tipo){
        switch (tipo.toLowerCase()){
            case "ieee":
                return new FactoryIEEE();
            case "mdpi":
                return new FactoryMDPI();
            default:
                System.out.println("Base de dados desconhecida!");
        }
        return null;
    }
}
