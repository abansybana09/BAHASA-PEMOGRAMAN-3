fun main() {
    print("Masukkan nilai siswa: ")
    val nilai = readLine()!!.toInt()

    val grade = if (nilai in 80..100) {
        "A"
    } else if (nilai in 60..79) {
        "B"
    } else if (nilai in 50..59) {
        "C"
    } else {
        "D"
    }
    println("Nilai akhir siswa adalah: $grade")
}
