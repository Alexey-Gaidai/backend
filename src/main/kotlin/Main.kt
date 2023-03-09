import lab1.BinaryTree
import lab1.Contact
import lab1.MobilePhone

fun main(args: Array<String>) {
    val tree = BinaryTree()
    tree.insert(5)
    tree.insert(3)
    tree.insert(7)
    tree.insert(1)
    tree.insert(4)
    tree.insert(6)
    tree.insert(8)
    tree.printTree()

    val phoneBook = MobilePhone("+7(960)-123-45-67")
    phoneBook.addNewContact(Contact("Ivan", "+7(960)-900-11-32"))
    phoneBook.addNewContact(Contact("Petr", "+7(943)-123-45-67"))
    phoneBook.addNewContact(Contact("Sidor", "+7(951)-321-99-00"))
    phoneBook.printContacts()
    phoneBook.removeContact(Contact("Ivan", "+7(960)-900-11-32"))
    phoneBook.printContacts()
    phoneBook.updateContact(Contact("Petr", "+7(943)-123-45-67"), Contact("Petr2", "+7(943)-123-45-68"))
    phoneBook.printContacts()
    println(phoneBook.findContact("Sidor"))
}