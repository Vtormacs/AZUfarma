package test;

import java.io.IOException;

public class teste {

    public static void main(String[] args) {
        // Caminho do arquivo que você quer abrir
        String filePath = "C:\\Users\\vitor\\Desktop\\quati_beta\\testeQuati.py";

        try {
            // Executando o comando para abrir o arquivo e manter o terminal aberto
            String command = "cmd /c start cmd /k \"python \"" + filePath + "\"\"";

            Process process = Runtime.getRuntime().exec(command);

            // Aguardando o término do processo (opcional)
            int exitCode = process.waitFor();
            System.out.println("Processo terminou com o código: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
