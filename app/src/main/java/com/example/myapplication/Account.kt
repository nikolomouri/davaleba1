open class Account(val accountNumber: String, var ownerName: String) {
    private var balance: Double = 0.0
    fun getBalance(): Double {
        return balance
    }
    fun deposit(amount: Double) {
        if (amount > 0) {
            balance += amount
            println("Deposit of $amount successful. New balance: $balance")
        }
    }
    open fun withdraw(amount: Double) {
        if (amount > 0 && balance >= amount) {
            balance -= amount
        } else {
            println("Withdrawal failed. Insufficient funds or invalid amount.")
        }
    }
    fun printInfo(){
        println("Account Number: $accountNumber")
        println("Owner Name: $ownerName")
        println("Balance: $balance")
    }
}
class SavingsAccount(accountNumber: String, ownerName: String) : Account(accountNumber, ownerName) {
    override fun withdraw(amount: Double) {
        if ( amount < 501) {
            super.withdraw(amount)
        } else {
            println("limited by 500")
        }
    }
}
class VIPAccount(accountNumber: String, ownerName: String): Account(accountNumber, ownerName) {
    private var transactionFee: Double = 2.0
    override fun withdraw(amount: Double) {
        val totalAmount = amount + transactionFee
        if (super.getBalance() >= totalAmount) {
            super.withdraw(totalAmount)
            println("Withdrawal of $amount with a transaction fee of $transactionFee successful.")
        } else{
            println("Withdrawal failed.")
        }
    }
}
fun main() {
    val acc1 = SavingsAccount("S101", "გიორგი გ.")
    val acc2 = VIPAccount("V202", "მარიამი ა.")

    acc1.deposit(1000.0)
    acc1.withdraw(300.0)
    acc1.withdraw(600.0)
    acc1.printInfo()

    acc2.deposit(1000.0)
    acc2.withdraw(50.0)
    acc2.printInfo()

    val accounts: List<Account> = listOf(acc1, acc2)
    for (account in accounts) {
        account.deposit(50.0) // გამოიძახებს მშობლის მეთოდს
        account.printInfo()
    }
}