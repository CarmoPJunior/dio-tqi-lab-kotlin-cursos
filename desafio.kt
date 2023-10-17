// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 0)

data class Formacao(val nome: String, val nivel: Nivel, val conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {

    val inscritos = mutableListOf<Usuario>()  

    fun matricular(usuario: Usuario) {       
        inscritos.add(usuario)       
        println("Aluno ${usuario.nome}, matriculado(a) na Formação $nome!")
    }    
    
    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
        println("Conteúdo '${conteudo.nome}', adicionado à Formação $nome!")
    }

    fun listarInscritos() {        
        println("Inscritos na formação $nome :")        
        this.inscritos.forEachIndexed { index, inscrito ->
            println("${index + 1}. ${inscrito.nome} ")
    	}
    }

    fun detalhesFormacao() {
        println()
        println("Formação: $nome")
        println("Nível: $nivel")
        println("Conteúdos da Formação:")    
        this.conteudos.forEachIndexed { index, conteudo ->
            println("${index + 1}. ${conteudo.nome} - Duração: ${conteudo.duracao} min")  
        }
        println("Alunos matriculados:")    
        this.inscritos.forEachIndexed { index, inscrito ->
            println("${index + 1}. ${inscrito.nome}")  
        }
    }


}

fun main() {        
    // Criando alguns usuários e conteúdos educacionais de exemplo
    val usuario1 = Usuario("Paula Oliveira")
    val usuario2 = Usuario("Carla Santos")
    val usuario3 = Usuario("Aline Santos")
    val usuario4 = Usuario("Ivan Alves")    

    // Cria as formações e Seus Conteúdos 
    val formacaoJava = Formacao("Java", Nivel.INTERMEDIARIO)
    val conteudo1 = ConteudoEducacional("Java Intermediário", 360)
    formacaoJava.adicionarConteudo(conteudo1)
        
    val formacaoKotlin = Formacao("Kotlin", Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Kotlin Básico", 180)
    formacaoKotlin.adicionarConteudo(conteudo2)

    // Matricula os alunos
    formacaoJava.matricular(usuario1)
    formacaoJava.matricular(usuario2)
    formacaoKotlin.matricular(usuario3)
    formacaoKotlin.matricular(usuario4)

    // Exibe os detalhes da Formação
    formacaoKotlin.detalhesFormacao()
    formacaoJava.detalhesFormacao()
}

