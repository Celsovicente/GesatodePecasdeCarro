import java.io.*;
import java.util.*;

public class Persistencia {

    private static final String PecaFile = "PecaFile.dat";
    private static final String VendaFile = "VendaFile.dat";

    public static void salvarPecas(List<PecaModelo> pecas) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(PecaFile))) {
            out.writeObject(pecas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PecaModelo> carregarPecas() {
        List<PecaModelo> pecas = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(PecaFile))) {
            pecas = (List<PecaModelo>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return pecas;
    }

    public static void salvarVendas(List<VendaModelo> vendas) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(VendaFile))) {
            out.writeObject(vendas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<VendaModelo> carregarVendas() {
        List<VendaModelo> vendas = new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(VendaFile))) {
            vendas = (List<VendaModelo>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return vendas;
    }
}
