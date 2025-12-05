package miniNubank;

import java.io.*;

public class Serializacao {

public static void salvarBanco(NubankBanco banco, String nomeArquivo) {
try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
oos.writeObject(banco);
System.out.println("Banco salvo com sucesso!");
} catch (Exception e) {
System.out.println("Erro ao salvar: " + e.getMessage());
}
}

public static NubankBanco carregarBanco(String nomeArquivo) {
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
NubankBanco banco = (NubankBanco) ois.readObject();
System.out.println("Banco carregado com sucesso!");
return banco;
} catch (FileNotFoundException e) {
System.out.println("Arquivo não encontrado, criando novo banco.");
return new NubankBanco();
} catch (Exception e) {
System.out.println("Erro ao carregar: " + e.getMessage());
return new NubankBanco();
}
}
}







