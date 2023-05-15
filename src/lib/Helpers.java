package lib;

// Todos os métodos são estáticos, então não é necessário instanciar a classe
public class Helpers {
  // Método para limpar o terminal do windows
  public static void clear() {
    try {
      if (System.getProperty("os.name").contains("Windows")) {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
        System.out.print("\033\143");
      }
    } catch (Exception e) {
      System.out.println("Erro ao limpar o terminal.\nMensagem de erro: " + e.getMessage());
    }
  }
}