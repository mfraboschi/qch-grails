package qch.usuario

class Grupo {
    String nombre
    Usuario creador

    static hasMany = [usuarios: Usuario]

    static belongsTo = Usuario
}
