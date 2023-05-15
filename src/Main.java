// import java.util.List;

public class Main {
    public static void main(String[] args) {
        FuncionarioDao dao = new FuncionarioDao();

        // Funcionario pedro = new Funcionario();
        // pedro.setId(3L);
        // pedro.setName("Pedro Affonso Lopes Dias");
        // pedro.setAge(19);
        // pedro.setCity("Oslo");
        // dao.insert(pedro);

        Funcionario matteo = new Funcionario();
        matteo.setId(4L);
        matteo.setName("Matteo Del Vecchio");
        matteo.setAge(22);
        matteo.setCity("Florence");
        dao.insert(matteo);

        dao.query();
        // dao.getLista().forEach(funcionario -> {
        // System.out.println(
        // "ID: " + funcionario.getId()
        // + "\nNAME: " + funcionario.getName()
        // + "\nAGE: " + funcionario.getAge()
        // + "\nCITY: " + funcionario.getCity()
        // + "\n--------------------------");
        // });
        // List<Funcionario> funcionarios = dao.getLista();
        // for(Funcionario funcionario: funcionarios){
        // System.out.println(
        // "ID: " + funcionario.getId()
        // + "\nNAME: " + funcionario.getName()
        // + "\nAGE: " + funcionario.getAge()
        // + "\nCITY: " + funcionario.getCity()
        // + "\n--------------------------");
        // }
    }
}
