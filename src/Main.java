import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

public class Main {

    private static FuncionarioList funcionarios = new FuncionarioList();

    public static void main(String[] args) {

        // 3.1 - Adiciona todos os funcionários em ordem
        funcionarios.addFuncionario( "Maria", LocalDate.of( 2000, Month.OCTOBER, 18 ), "Operador", new BigDecimal( "2009.44" ) );
        funcionarios.addFuncionario( "João", LocalDate.of( 1990, Month.MAY, 12 ), "Operador", new BigDecimal( "2284.38" ) );
        funcionarios.addFuncionario( "Caio", LocalDate.of( 1961, Month.MAY, 2 ), "Coordenador", new BigDecimal( "9836.14" ) );
        funcionarios.addFuncionario( "Miguel", LocalDate.of( 1988, Month.OCTOBER, 14 ), "Diretor", new BigDecimal( "19119.88" ) );
        funcionarios.addFuncionario( "Alice", LocalDate.of( 1995, Month.JANUARY, 5 ), "Recepcionista", new BigDecimal( "2234.68" ) );
        funcionarios.addFuncionario( "Heitor", LocalDate.of( 1999, Month.NOVEMBER, 19 ), "Operador", new BigDecimal( "1582.72" ) );
        funcionarios.addFuncionario( "Arthur", LocalDate.of( 1993, Month.MARCH, 31 ), "Contador", new BigDecimal( "4071.84" ) );
        funcionarios.addFuncionario( "Laura", LocalDate.of( 1994, Month.JULY, 8 ), "Gerente", new BigDecimal( "3017.45" ) );
        funcionarios.addFuncionario( "Heloísa", LocalDate.of( 2003, Month.MAY, 24 ), "Eletricista", new BigDecimal( "1606.85" ) );
        funcionarios.addFuncionario( "Helena", LocalDate.of( 1996, Month.SEPTEMBER, 2 ), "Gerente", new BigDecimal( "2799.93" ) );
        // Descomente para ver a inserção
        // System.out.println(funcionarios);

        // 3.2 - Remove João
        funcionarios.removeFuncionario( funcionarios.getFuncionarioPorNome( "João" ) );
        // Descomente para ver a remoção
        // System.out.println( funcionarios );

        // 3.3 - Imprime todos os funcionários
        System.out.println( funcionarios );

        // 3.4 - Aumento de 10% 
        funcionarios.darAumentoTodos( new BigDecimal( "0.10" ) );
        // Descomente para ver o aumento
        // System.out.println( funcionarios );

        // 3.5 e 3.6 - Agrupar por função e exibir
        funcionarios.imprimeMapaAgrupado();
        System.out.println();

        // 3.7 - Não existe

        // 3.8 - Imprime por mês de aniversário
        System.out.println( "Aniversariantes do mês 10: " );
        funcionarios.imprimePorAniversarioMes( 10 );
        System.out.println( "Aniversariantes do mês 12: " );
        funcionarios.imprimePorAniversarioMes( 12 );
        System.out.println();

        // 3.9 - Imprime funcionário mais velho
        funcionarios.imprimeMaisVelho();
        System.out.println();

        // 3.10 - Ordem alfabética
        System.out.println( "Ordem alfabética:" );
        funcionarios.imprimeOrdemAlfabetica();


        // 3.11 - Total de salário
        funcionarios.imprimeTotalSalario();

        // 3.12 - Salário mínimo por funcionário
        funcionarios.imprimeSalarioMinimo();

    }

}
