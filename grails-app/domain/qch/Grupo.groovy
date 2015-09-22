package qch

class Grupo {
    String nombre
    Usuario creador
    static hasMany = [usuarios: Usuario]
}
