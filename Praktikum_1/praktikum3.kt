fun ucapkan_salam(){
    println("assalamualaikum.. selamat pagi semuanya")
}

fun salam(nama: String){
    println("halo $nama, selamat datang di praktikum kotlin")
}   

fun kali(a: Int, b: Int): Int {
    return a * b
}

fun tambah(a: Int, b: Int) = a+b
fun bagi (a:Float, b:Float) : Unit {
    println ("Pembagian antara $a dan $b adalah ${a/b}")
}
fun kurang (a:Int, b:Int ) {
    println("Pengurangan antara $a dan $b adalah ${a-b}")
}

fun main () {
    println("Fungsi standar kotlin")
    ucapkan_salam()
    salam("Aban")

    print("hasil perkalian antara 3 dan 10 adalah = ")
    println(kali(3,10))
    println("Hasil pertambahan dari 20 tambah 10 adalah = ${tambah(20,10)}")
    bagi(20f, 4f)
    kurang(13,9)
}