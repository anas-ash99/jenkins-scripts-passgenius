import java.util.Random

def call(int length = 8){
    // Define the characters to use in the random version
    String characters = '0123456789abcdefghijklmnopqrstuvwxyz'
    Random random = new Random()
    StringBuilder version = new StringBuilder()

    // Generate a random string of specified length
    for (int i = 0; i < length; i++) {
        int index = random.nextInt(characters.length())
        version.append(characters.charAt(index))
    }

    return version.toString()
}
