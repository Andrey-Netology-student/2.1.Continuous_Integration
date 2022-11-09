// Задача №2. Разная комиссия
fun main(args: Array<String>) {
    var pastTransfers: Double = 0.0
    var card = 1 //vkPay
    var amount = 0

    while (true) { //Чтобы можно было сделать несколько переводов и превысить лимит
        println("Выберите тип карты/счёта:\n1-vkPay\n2-MasterCard\n3-Maestro\n4-Visa\n5-Мир") //Это для удобства пользователя
        card = Integer.valueOf(readLine())

        println("Введите сумму перевода или 0 для выхода: ")
        amount = Integer.valueOf(readLine()) //Принимает сумму перевода

        if (amount == 0) { //После ввода 0 - выход из цикла
            break
        }

        val commission: Double = calculateCommission(pastTransfers, card, amount)
        pastTransfers += amount - commission //Без учёта комиссии за переводы
        println("Комиссия за перевод " + commission + "рублей")
    }
}

fun calculateCommission(pastTransfers: Double, card: Int, amount: Int): Double {
    var tax: Double = 0.0
    if (card == 1) { //vkPay
        if (amount > 15_000 || pastTransfers > 40_000) {
            println("Лимит переводов превышен!")
        } else {
            tax = 0.0
        }

    } else if (card == 2 || card == 3) { //MasterCard и Maestro
        var mTax = amount * 0.006 + 20 //Комиссия для MasterCard и Maestro
        if (amount > 150_000 || pastTransfers > 600_000) {
            println("Лимит переводов превышен!")
        } else if (pastTransfers > 75000 || amount > 75000) {
            tax = mTax
        } else {
            tax = 0.0
        }

    } else if (card == 4 || card == 5) { //Visa и Мир
        var vTax = amount * 0.0075 //Комиссия для Visa и Мир
        if (amount > 150_000 || pastTransfers > 600_000) {
            println("Лимит переводов превышен!")
        } else if (vTax < 35) {
            tax = 35.0 // 35.0
        } else {
            tax = vTax
        }
    }
    return tax
}
//gradle test jacocoTestReport