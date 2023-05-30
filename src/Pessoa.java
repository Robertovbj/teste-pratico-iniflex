import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {

    private String nome;
    private LocalDate dataNascimento;

    public Pessoa( String nome, LocalDate dataNascimento ) {

        this.nome = nome;
        this.dataNascimento = dataNascimento;

    }

    public String getNome() {

        return nome;

    }

    public LocalDate getDataNascimento() {

        return dataNascimento;

    }

    public String toString() {

        return "Nome: " + this.getNome() + " | Data de Nascimento: " + this.getDataNascimento().format( DateTimeFormatter.ofPattern( "dd/MM/yyyy" ) );

    }

}
