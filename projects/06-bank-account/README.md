# 06 · Bank Account

**Unlocked by:** L01 (encapsulation) + L02 (access modifiers, `static`, `final`) · **Difficulty:** ★★★☆☆ · **Time:** ~4 hours

## Goal
A `BankAccount` class that cannot be put into an invalid state, driven from a console menu.

## Concepts you'll practice
- Encapsulation: `private` fields + `public` methods that validate
- The access modifier matrix (private / package-local / protected / public)
- `static` fields shared by all objects vs per-instance fields
- `final` constants (must be set at declaration or in the constructor)

## Requirements
- [ ] `private double balance`, `private final int accountNumber`, `private String owner`.
- [ ] `deposit(double)` rejects amounts <= 0. `withdraw(double)` rejects overdrafts.
- [ ] `static int totalAccounts` increments in the constructor, and `static double totalMoneyInBank` tracks the sum.
- [ ] `public static final double MIN_OPENING_BALANCE = 100.0;` enforced in the constructor.
- [ ] Account numbers are generated automatically (hint: `static` counter).
- [ ] `transfer(BankAccount to, double amount)`.
- [ ] Console menu to open accounts, deposit, withdraw, transfer, show all.

## Milestones
1. Account with private balance, deposit and getter.
2. Validation in deposit/withdraw.
3. `final` account number + static counter.
4. Static totals, and check they stay correct after transfers.
5. Menu driver.

## Stretch goals
- Transaction history in a fixed-size array (last 10 transactions).
- Reproduce the L02 trace: two objects, one `static`, one instance counter. Predict the output *before* running.

## Done when
- [ ] No outside code can set `balance` directly
- [ ] You can explain why `accountNumber` can't have a setter
- [ ] You can predict `p1.localId`, `p2.localId` and `Person.globalId` for the L02 example without running it
- [ ] Static fields are accessed as `BankAccount.totalAccounts`, not through an instance

## Hints
- Make failing operations return a `boolean` (or a message) so the caller can react. Exceptions come in project 10.
