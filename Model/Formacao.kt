package desafio.Model

class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional>) {
    val inscritos = mutableMapOf<Int, Usuario>()

    fun matricular(usuario: Usuario) {
        this.inscritos[usuario.matricula] = usuario
        with(usuario) {
            println("Usuário de nome: ${this.getNome()} e matricula: $matricula foi registrado com sucesso")
        }
    }

    fun adicionarConteudo(conteudo: ConteudoEducacional) {
        conteudos.add(conteudo)
    }

    fun listarInscritos() {
        inscritos.map {
            println("Usuario de matricula ${it.key} e nome ${it.value.getNome()}")
        }
    }
}