fun main(){
    cek_nama_hari()
    cek_khodam()
}

fun cek_nama_hari(){
    val hari = 4

    val namaHari = when (hari) {
        1 -> "Senin"
        2 -> "Selasa"
        3 -> "Rabu"
        4 -> "Kamis"
        5 -> "Jumat"
        6 -> "Sabtu"
        7 -> "Minggu"
        else -> "input hari salah"
    }

    println("Hari ini adalah hari $namaHari")
}

fun cek_khodam(){
    val khodam ="Januari"

    when (khodam) {
        "Januari", "Februari", "Maret" -> println ("Khodam anda adalah harimau")
        "April", "Mei", "Juni" -> println("Khodam anda adalah Ular")
        "Juli", "Agustus", "September" -> println("Khodam anda adalah Garuda")
        "Oktober", "November", "Desember" -> println("Khodam anda adalah Naga")
        else -> println ("Anda Tidak Punya Khodam")
    }
}