import junit.framework.TestCase
import org.junit.Test

import org.junit.Assert.*

class CommissionKtTest {

    @Test
    fun testVKFirst() {
        val pastTransfers: Double = 0.0 //Все переменные - val (чтобы знать, при каком значении ломается программа)
        val card = 1 //vkPay
        val amount = 1000

        val commission: Double = calculateCommission(pastTransfers, card, amount)

        TestCase.assertEquals(0.0, commission)
    }

    @Test
    fun testVKSecond() {
        val pastTransfers: Double = 40_001.0 //Все переменные - val (чтобы знать, при каком значении ломается программа)
        val card = 1 //vkPay
        val amount = 15_000

        val commission: Double = calculateCommission(pastTransfers, card, amount)

        TestCase.assertEquals(0.0, commission)
    }

    @Test
    fun testMasterCard() {
        val pastTransfers: Double = 600.0 //Все переменные - val (чтобы знать, при каком значении ломается программа)
        val card = 2 //МастерКард
        val amount = 1

        val commission: Double = calculateCommission(pastTransfers, card, amount)

        TestCase.assertEquals(0.0, commission)
    }

    @Test
    fun testMaestroOverLimit() {
        val pastTransfers: Double = 600_001.0 //Все переменные - val (чтобы знать, при каком значении ломается программа)
        val card = 3 //Маэстро
        val amount = 150_001

        val commission: Double = calculateCommission(pastTransfers, card, amount)

        TestCase.assertEquals(0.0, commission)
    }

    @Test
    fun testMaestro() {
        val pastTransfers: Double = 76_000.0 //Все переменные - val (чтобы знать, при каком значении ломается программа)
        val card = 3 //Маэстро
        val amount = 76_000

        val commission: Double = calculateCommission(pastTransfers, card, amount)

        TestCase.assertEquals(476.0, commission)
    }


    @Test
    fun testVisa() {
        val pastTransfers: Double = 500_000.0 //Все переменные - val (чтобы знать, при каком значении ломается программа)
        val card = 4 //Виза
        val amount = 140_000

        val commission: Double = calculateCommission(pastTransfers, card, amount)

        TestCase.assertEquals(1050.0, commission)
    }

    @Test
    fun testMirOverLimit() {
        val pastTransfers: Double = 1_000_000.0 //Все переменные - val (чтобы знать, при каком значении ломается программа)
        val card = 5 //Мир
        val amount = 1

        val commission: Double = calculateCommission(pastTransfers, card, amount)

        TestCase.assertEquals(0.0, commission)
    }

    @Test
    fun testMir() {
        val pastTransfers: Double = 0.0 //Все переменные - val (чтобы знать, при каком значении ломается программа)
        val card = 5 //Мир
        val amount = 1

        val commission: Double = calculateCommission(pastTransfers, card, amount)

        TestCase.assertEquals(35.0, commission)
    }
}