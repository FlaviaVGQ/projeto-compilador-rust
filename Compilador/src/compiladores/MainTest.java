package compiladores;

import java.io.BufferedReader; // Importação adicionada
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader; // Importação adicionada

public class MainTest {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\jvas\\git\\repository-compiladores\\Compilador\\src\\compiladores\\codigoTeste.txt"; // Variável para o caminho do arquivo
        try {
            // --- Começo: Código para ler e imprimir o conteúdo do arquivo ---
            System.out.println("Conteúdo do arquivo " + filePath + ":\n--- INÍCIO DO ARQUIVO ---");
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
            System.out.println("--- FIM DO ARQUIVO ---\n");
            // --- Fim: Código para ler e imprimir o conteúdo do arquivo ---

            InputStream input = new FileInputStream(filePath); // Usando a variável
            RustGrammar parser = new RustGrammar(input);
            parser.Program();
            System.out.println("Código válido!");
        } catch (Exception e) {
            System.out.println("Erro de sintaxe: " + e.getMessage());
        }
    }
}
