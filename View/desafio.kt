// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)
package desafio.view
import desafio.Control.*
import desafio.Model.*

fun main() {
    var indice: Int = 0
    var index: Int = 0
    var nome: String
    val teste = Usuario("Pedro")
    var lista = mutableListOf<ConteudoEducacional>(
        ConteudoEducacional("Aula 1 - Kotlin", 20),
        ConteudoEducacional("Aula 2 - Kotlin")
    )
    var position: Int
    val formacaoKotlin = Formacao("Kotlin", lista, nivel = Nivel.BASICO)
    val formacoes = mutableListOf<Formacao>(formacaoKotlin)
    formacaoKotlin.matricular(teste)
    formacaoKotlin.listarInscritos()
    while (indice != 9) {
        println("Informe a opção desejada:")
        println("1 -> Adicionar formação")
        println("2 -> Adicionar usuário a uma formação")
        println("3 -> Adicionar um conteúdo a uma formação")
        println("4 -> Listar formações")
        println("5 -> Listar usuários de uma formação")
        println("6 -> Listar conteúdos de uma formação")
        println("9 -> Sair")
        indice = readln().toInt()
        when (indice) {
            1 -> {
                print("Informe o nome da formação:")
                nome = readln()
                index = verificaAdicional("Deseja adicionar conteúdos a essa formação?")
                if(index==1){
                    formacoes.add(Formacao(nome, criaConteudos(), escolheNivel()))
                }else{
                    formacoes.add(Formacao(nome, mutableListOf<ConteudoEducacional>(), escolheNivel()))
                }
            }
            2 -> {
                println("Informe a formação onde o usuário será matriculado:")
                listaFormacoes(formacoes)
                position= readln().toInt()-1
                do {
                    print("Informe o nome do usuário:")
                    nome = readln()
                    formacoes[position].matricular(Usuario(nome))
                }while (verificaAdicional("Deseja adicionar mais usuários a essa formação?") == 1)
            }
            3 -> {
                println("Informe a formação onde o conteúdo será adicionado:")
                listaFormacoes(formacoes)
                position = readln().toInt()-1
                lista = criaConteudos()
                lista.forEach {
                    formacoes[position].conteudos.add(it)
                }
            }
            4 ->{
                listaFormacoes(formacoes)
            }
            5-> {
                println("Informe a formação:")
                listaFormacoes(formacoes)
                position = readln().toInt() - 1
                formacoes[position].inscritos.forEach {
                    println("Usuário de matricula ${it.key} e nome ${it.value.getNome()}")
                }
            }
            6-> {
                println("Informe a formação:")
                listaFormacoes(formacoes)
                position = readln().toInt() - 1
                formacoes[position].conteudos.forEach {
                    println("Conteudo de nome ${it.nome} e duracao ${it.duracao}")
                }
            }
        }
    }
    print("Informe a opção desejada:")
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}
