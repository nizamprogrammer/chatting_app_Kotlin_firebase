// Initialize Firebase Realtime Database
val database = FirebaseDatabase.getInstance().reference

// Function to send a message
fun sendMessage(text: String) {
    val message = Message(text, System.currentTimeMillis())
    database.child("messages").push().setValue(message)
}

// Class to represent a message
data class Message(val text: String, val timestamp: Long)

// Read messages from Firebase Realtime Database
database.child("messages").addChildEventListener(object: ChildEventListener {
    override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String?) {
        val message = dataSnapshot.getValue(Message::class.java)
        // Do something with the message
    }

    // Other override functions for other events (e.g. message changed, deleted)
})
