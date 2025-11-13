package factory;

public class BibFactory {
    public static Factory criarBib(String tipo, String arquivo){
        switch (tipo.toLowerCase()){
            case "ieee":
                return new FactoryIEEE(arquivo);
            case "mdpi":
                return new FactoryMDPI(arquivo);
            default:
                System.out.println("Base de dados desconhecida!");
        }
        return null;
    }
}
