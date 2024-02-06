package desafio.Control
import desafio.Model.*

fun listaFormacoes(formacoes: List<Formacao>) {
    var index: Int = 1
    formacoes.map {
        println("$index - Formação de nome: ${it.nome} e nivel: ${it.nivel}")
        index++
    }
}

fun escolheNivel():Nivel{
    println("Escolha o nivel da formação")
    var index: Int = 1
    Nivel.entries.forEach(){
        println("$index - ${it.name}")
        index++
    }
    val position = readln().toInt()
    return Nivel.entries[position-1]
}

fun criaConteudos(): MutableList<ConteudoEducacional> {
    val lista: MutableList<ConteudoEducacional> = mutableListOf()
    var index: Int? = 1
    var nome: String
    var duracao: Int?
    do {
        print("Informe o nome do Conteúdo Educacional:")
        nome = readln()
        print("Informe a duracao do Conteúdo Educacional(Valor padrão = 60 minutos):")
        try {
            duracao = readlnOrNull()?.toInt()
            lista.add(ConteudoEducacional(nome, duracao))
        }catch (e: Throwable) {
            lista.add(ConteudoEducacional(nome))
        }
    }while (verificaAdicional("Deseja adicionar mais conteúdos a essa formação?") == 1)
    return lista
}

fun verificaAdicional(text:String): Int{
    println(text)
    println("1 - Sim")
    println("2 - Não")
    var index: Int = readln().toInt()
    while (index !in 1..2){
        println("Caractere inválido, tente novamente")
        println("1 - Sim")
        println("2 - Não")
        index = readln().toInt()
    }
    return index
}