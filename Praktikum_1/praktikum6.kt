fun main() {
    println("Loopting For")
    cetak_angka_for()
    println("Looping while")
    cetak_angka_while()
    println("Looping do-while")
    cetak_angka_do_while()
}

fun cetak_angka_for () {
    var i=1
    println("Print angka 1-5 dengan for")
    for (i in 1..5) {
        println(i)
    }
}

fun cetak_angka_while () {
    var i=1
    println("Print angka dengan while 1 sampai 5")
    while(i<=5) {
        println(i)
        i++
    }
}

fun cetak_angka_do_while () {
    var i=1
    println("Print angka dengan do while 1 sampai 5")
    do {
        println(i)
        i++
    }while(i<=5)
}