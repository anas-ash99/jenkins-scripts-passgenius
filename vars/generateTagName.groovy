import java.util.Random

def call(int length = 8){

    String characters = '0123456789abcdefghijklmnopqrstuvwxyz'
    Random random = new Random()
    StringBuilder tagName = new StringBuilder()

    for (int i = 0; i < length; i++) {
        int index = random.nextInt(characters.length())
        tagName.append(characters.charAt(index))
    }

    return tagName.toString()
}
