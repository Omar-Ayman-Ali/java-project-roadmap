# 11 · Payment Gateway

**Unlocked by:** Week 7 (Interfaces) · **Difficulty:** ★★★★☆ · **Time:** ~5-6 hours

## Goal
A checkout system that accepts any payment method through one interface, so adding a new method never requires changing the checkout code.

## Concepts you'll practice
- `interface` as a contract, and `implements`
- A class can implement **many** interfaces (the answer to "no multiple inheritance")
- Programming to an interface: `PaymentMethod p = new CreditCard(...)`
- Interface vs abstract class (decide when to use which, then write it down)
- `default` methods in interfaces

## Requirements
- [ ] `interface PaymentMethod { boolean pay(double amount); String describe(); }`
- [ ] Implementations: `CreditCard`, `PayPal`, `WalletBalance`, and `CashOnDelivery`.
- [ ] `Checkout` class takes a `PaymentMethod` and an order total. It must **not** import or mention concrete payment classes.
- [ ] A second interface, `Refundable`, implemented by only some methods.
- [ ] `instanceof` check (or pattern) to offer refunds only on `Refundable` methods.
- [ ] Failure handling with custom exceptions from project 10.
- [ ] UML showing interfaces (dashed arrow with hollow triangle for realisation).

## Milestones
1. `PaymentMethod` + two implementations.
2. `Checkout` using only the interface.
3. Add a third and fourth method without touching `Checkout`.
4. `Refundable` and the instanceof branch.
5. `default` method for a shared receipt format.

## Stretch goals
- Fee strategies (flat, percentage) as another interface.
- Unit-test-style `main` that runs every method through the same checkout.

## Done when
- [ ] You can add a new payment method by creating one file and changing nothing else
- [ ] You can explain interface vs abstract class in two sentences
- [ ] `Checkout.java` has no mention of any concrete payment class
