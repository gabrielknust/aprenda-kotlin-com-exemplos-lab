package desafio.Model

data class Usuario(private val nome: String) {
    val matricula: Int get() = hashCode()
    fun getNome(): String {
        return this.nome
    }
}