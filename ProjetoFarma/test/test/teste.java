package test;
import java.io.IOException;

public class teste {

    public static void main(String[] args) {
        // Caminho do arquivo que você quer abrir
        String filePath = "C:\\Battlestate Games\\BsgLauncher\\BsgLauncher.exe";

        try {
            // Executando o comando apropriado para abrir o arquivo
            String command = "cmd.exe /c start \"\" \"" + filePath + "\"";

            Process process = Runtime.getRuntime().exec(command);

            // Aguardando o término do processo (opcional)
            int exitCode = process.waitFor();
            System.out.println("Processo terminou com o código: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
