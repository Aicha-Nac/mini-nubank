package miniNubank;

import java.io.*;

public class Serializacao {

    private static final String ARQUIVO = "banco.dat";

    public static void salvarBanco(NubankBanco banco) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(banco);
            System.out.println("[Serializacao] Banco salvo em " + ARQUIVO);
        } catch (Exception e) {
            System.out.println("[Serializacao] Erro ao salvar banco: " + e.getMessage());
        }
    }

    public static NubankBanco carregarBanco() {
        File f = new File(ARQUIVO);
        if (!f.exists()) {
            System.out.println("[Serializacao] Arquivo não encontrado. Criando novo banco vazio.");
            return NubankBanco.novoBancoVazio();
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARQUIVO))) {
            Object o = ois.readObject();
            if (o instanceof NubankBanco) {
                System.out.println("[Serializacao] Banco carregado com sucesso.");
                return (NubankBanco) o;
            } else {
                System.out.println("[Serializacao] Arquivo não contém NubankBanco válido.");
                return NubankBanco.novoBancoVazio();
            }
        } catch (Exception e) {
            System.out.println("[Serializacao] Erro ao carregar banco: " + e.getMessage());
            return NubankBanco.novoBancoVazio();
        }
    }
}
