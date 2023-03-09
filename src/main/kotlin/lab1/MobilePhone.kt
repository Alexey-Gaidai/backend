package lab1

class MobilePhone(private val myNumber: String) {
    private val myContacts: MutableList<Contact> = mutableListOf()

    fun addNewContact(contact: Contact): Boolean {
        return if (findContact(contact) >= 0) {
            false
        } else {
            myContacts.add(contact)
            true
        }
    }

    fun updateContact(oldContact: Contact, newContact: Contact): Boolean {
        val foundPosition = findContact(oldContact)
        return if (foundPosition < 0) {
            false
        } else {
            myContacts[foundPosition] = newContact
            true
        }
    }

    fun removeContact(contact: Contact): Boolean {
        val foundPosition = findContact(contact)
        return if (foundPosition < 0) {
            false
        } else {
            myContacts.removeAt(foundPosition)
            true
        }
    }

    private fun findContact(contact: Contact): Int {
        return myContacts.indexOf(contact)
    }

    fun findContact(name: String): Contact? {
        for (i in myContacts.indices) {
            if (myContacts[i].name == name) {
                return myContacts[i]
            }
        }
        return null
    }

    fun printContacts() {
        println("Contact List")
        for (i in myContacts.indices) {
            println("${i + 1}. ${myContacts[i].name} -> ${myContacts[i].phone}")
        }
    }
}

data class Contact(val name: String, val phone: String)