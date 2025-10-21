fun main () {
    cek_login()
}

fun cek_login() {
    val username = "admin"
    val password = "1234"

    if (username =="admin" && password == "1234") {
        println("Anda berhasil masuk")
    } else {
        println("kombinasi username dan password anda salah")
    }
}