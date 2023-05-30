import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class Funcionario extends Pessoa {

    private String funcao;
    private BigDecimal salario;

    public Funcionario( String nome, LocalDate dataNascimento, String funcao, BigDecimal salario ) {

        super(nome, dataNascimento);
        this.funcao = funcao;
        this.salario = salario;

    }

    public String getFuncao() {

        return funcao;

    }

    public BigDecimal getSalario() {

        return salario;

    }

    // Dá um aumento em porcentagem para o funcionário. Para um aumento de 10%, o valor deve ser 0.10.
    public void darAumento( BigDecimal porcentagem ) {

        this.salario = this.salario.multiply( porcentagem.add( new BigDecimal( "1" ) ) );

    }

    // Exibe todas as informações do funcionário
    public String toString() {
        
        return super.toString() + " | Salário: " + formatSalario() + " | Função: " + funcao; 

    }

    // Configura a formatação do número para "#.###,##", usando a formatação Alemã
    private String formatSalario() {
        
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMANY);
        DecimalFormat df = (DecimalFormat)nf;

        return df.format( this.salario );
    }

}
