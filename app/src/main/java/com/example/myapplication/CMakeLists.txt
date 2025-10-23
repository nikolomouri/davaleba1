დავალება 1

ნაწილი I: საბაზისო კლასის შექმნა (ენკაპსულაცია და მემკვიდრეობის საფუძვლები)
შექმენით ღია (open) კლასი Account:
● თვისებები (Properties):
● accountNumber (უნიკალური ნომერი) - უნდა იყოს val (read-only).
● ownerName: String (მფლობელი).
● private var balance: Double (ბალანსი). გამოიყენეთ private (ენკაპსულაცია).
კონსტრუქტორი: უნდა იღებდეს accountNumber და ownerName. საწყისი ბალანსი 0.0.მეთოდები
(Methods):
● fun getBalance(): Double: ბალანსის დასაბრუნებლად.
● fun deposit(amount: Double):
● თუ თანხა >0, გაზარდეთ ბალანსი და დაბეჭდეთ შეტყობინება.
open fun withdraw(amount: Double):
● თუ თანხა >0 და balance >= amount, შეამცირეთ ბალანსი.
● წინააღმდეგ შემთხვევაში, დაბეჭდეთ შეტყობინება, რომ ოპერაცია ვერ შესრულდა.
fun printInfo(): ბეჭდავს ანგარიშის ძირითად ინფორმაციას.
ნაწილი II: სპეციალიზებული კლასები (მემკვიდრეობის გამოყენება)
შექმენით ორი კლასი, რომლებიც მემკვიდრეობით იღებენ Account-ს:SavingsAccount (შემნახველი
ანგარიში):
● გადატვირთეთ (override) მეთოდი withdraw(amount: Double):
● გამოიყენეთ მშობლის ლოგიკა (super.withdraw(amount)), მაგრამ დაამატეთ ერთი წესი:
● წესი: შემნახველი ანგარიშიდან გამოტანა დასაშვებია მხოლოდ იმ შემთხვევაში, თუ გამოტანილი
თანხა არ აღემატება 500-ს ერთ ტრანზაქციაში.
● თუ თანხა $ > 500$, დაბეჭდეთ შეტყობინება ლიმიტის შესახებ და არ გამოიძახოთ
super.withdraw().
VIPAccount (VIP ანგარიში):
● დამატებითი თვისება: transactionFee: Double (გამოტანის საკომისიო, ნაგულისხმევი 2.0).
● გადატვირთეთ (override) მეთოდი withdraw(amount: Double):
● გამოთვალეთ საერთო თანხა: totalAmount = amount + transactionFee.
● თუ balance >= totalAmount, შეამცირეთ ბალანსი totalAmount-ით.
● წინააღმდეგ შემთხვევაში, დაბეჭდეთ შეტყობინება, რომ ოპერაცია ვერ შესრულდა.

ნაწილი III: ტესტირება და პოლიმორფიზმის დემონსტრირება
შექმენით main ფუნქცია:შექმენით ობიექტები:
● val acc1 = SavingsAccount("S101", "გიორგი გ.")
● val acc2 = VIPAccount("V202", "მარიამი ა.")
ტესტირება:
● acc1 (Savings):
● deposit(1000.0)
● withdraw(300.0) (უნდა იმუშაოს)
● withdraw(600.0) (არ უნდა იმუშაოს ლიმიტის გამო)
acc2 (VIP):
● deposit(1000.0)
● withdraw(50.0) (უნდა გამოაკლოს $50 + $2 = 52)
● printInfo()
პოლიმორფიზმი (სურვილისამებრ, ბონუსად):
● შექმენით სია: val accounts: List<Account> = listOf(acc1, acc2)
● გამოიყენეთ ციკლი:Kotlinfor (account in accounts) {
account.deposit(50.0) // გამოიძახებს მშობლის მეთოდს
account.printInfo()
}