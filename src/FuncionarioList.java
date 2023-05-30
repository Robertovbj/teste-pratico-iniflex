import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Locale;

public class FuncionarioList {
    
    private List<Funcionario> funcionariosList;

    public FuncionarioList() {

        funcionariosList = new ArrayList<>();

    }

    // Adiciona um novo funcionário na lista
    public void addFuncionario( String nome, LocalDate dataNascimento, String funcao, BigDecimal salario ) {

        Funcionario funcionario = new Funcionario( nome, dataNascimento, funcao, salario );
        funcionariosList.add( funcionario );

    }

    // Remover um funcinário da lista
    public void removeFuncionario( Funcionario funcionario ) {

        funcionariosList.remove( funcionario );

    }

    // Retorna um funcionário buscado por nome; retorna o primeiro encontrado
    public Funcionario getFuncionarioPorNome( String nome ) {

        for (Funcionario funcionario : funcionariosList) {
            
            if ( funcionario.getNome().equals( nome ) ) {   
                return funcionario;
            }

        }
        return null;

    }

    private Map<String, List<Funcionario>> agruparMapa() {

        Map<String, List<Funcionario>> group = new HashMap<>();

        for (Funcionario funcionario : funcionariosList) {

            String funcao = funcionario.getFuncao();

            if (group.containsKey(funcao)) {

                group.get(funcao).add(funcionario);

            } else {

                List<Funcionario> lista = new ArrayList<>();
                lista.add(funcionario);
                group.put(funcao, lista);

            }

        }

        return group;

    }

    public void imprimeMapaAgrupado() {

        Map<String, List<Funcionario>> mapa = agruparMapa();

        for ( Map.Entry<String, List<Funcionario>> entry : mapa.entrySet() ) {
            
            System.out.println("Função: " + entry.getKey());
            for ( Funcionario funcionario : entry.getValue() ) {
                
                System.out.println( "\t" + funcionario.getNome() );

            }

        }

    }

    // Ajusta o salário conforme o aumento em porcentagem para todos os usuários. Para um aumento de 10%, use 0.10.
    public void darAumentoTodos( BigDecimal porcentagem ) {

        for (Funcionario funcionario : funcionariosList) {

            funcionario.darAumento( porcentagem );
        
        }

    }

    // Imprime o nome de todos aqueles que nasceram no mês fornecido
    public void imprimePorAniversarioMes( int mes ){

        int i = 0;

        for (Funcionario funcionario : funcionariosList) {
            
            if ( funcionario.getDataNascimento().getMonthValue() == mes ) {
                System.out.println( funcionario.getNome() );
                i++;
            }

        }

        if ( i == 0 ) System.out.println( "Nenhum aniversariante no mês " + mes );

    }

    // Imprime o nome e data de nascimento do funcionário mais velho
    public void imprimeMaisVelho(){

        LocalDate dataMaisAntiga = LocalDate.now();
        Funcionario maisVelho = null;

        for (Funcionario funcionario : funcionariosList) {
            
            LocalDate dataNascimento = funcionario.getDataNascimento();

            if( dataNascimento.isBefore( dataMaisAntiga ) ) {

                dataMaisAntiga = dataNascimento;
                maisVelho = funcionario;

            }

        }

        System.out.println( "O funcionário mais velho é " + maisVelho.getNome() + " nascido em " + dataMaisAntiga.format( DateTimeFormatter.ofPattern( "dd/MM/yyyy" ) ) );
        
    }

    public void imprimeOrdemAlfabetica() {

        Collections.sort( funcionariosList, ( f1, f2 ) -> f1.getNome().compareTo( f2.getNome() ) );
        System.out.println( this.toString() );

    }

    // Soma e imprime o valor de todos os salários juntos
    public void imprimeTotalSalario() {

        BigDecimal total = new BigDecimal( "0" );
        for (Funcionario funcionario : funcionariosList) {
            
            total = total.add( funcionario.getSalario() );

        }

        System.out.println( "Sálario total: " + formatDecimal( total ) + "\n");

    }

    // Imprime quantos salários mínimos cada funcionário recebe
    public void imprimeSalarioMinimo() {

        BigDecimal salarioMinimo = new BigDecimal( "1212.00" );
        for (Funcionario funcionario : funcionariosList) {
            
            System.out.println( funcionario.getNome() + " recebe " + formatDecimal( funcionario.getSalario().divide( salarioMinimo, 2, RoundingMode.HALF_UP ) ) + " salários mínimos." );

        }

    }

    public String toString() {

        StringBuilder builder = new StringBuilder();

        for (Funcionario funcionario : funcionariosList) {
            builder.append(funcionario);
            builder.append("\n");
        }

        return builder.toString();

    }

    // Configura a formatação do número para "#.###,##", usando a formatação Alemã
    private String formatDecimal( BigDecimal decimal ) {
        
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMANY);
        DecimalFormat df = (DecimalFormat)nf;

        return df.format( decimal );
    }

}
