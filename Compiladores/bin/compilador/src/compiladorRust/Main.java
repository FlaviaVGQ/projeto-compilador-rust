package compiladorRust;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("TesteLexico.txt");

            // Cria o parser com base na entrada do arquivo
            RustGrammar parser = new RustGrammar(reader);

            try {
                // Inicia a análise sintática
                parser.RUN();  // RUN -> Program -> valida toda a gramática
                System.out.println("\n✅ Código pode ser compilado (nenhum erro sintático encontrado).");

            } catch (ParseException e) {
                System.out.println("\n❌ Erro de compilação!");
                System.out.println("Mensagem: " + e.getMessage());
                System.out.println("Código não pode ser compilado.");
            }

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}