package com.passgenius

import java.security.SecureRandom

class VersionUpdater {

    static String updateVersion(String version) {
        def matcher = version =~ /v(\d+)\.(\d+)\.(\d+)/

        if (!matcher.matches()) {
            throw new IllegalArgumentException("Invalid version format. Must be in the format vX.Y.Z")
        }

        // Parse the version parts
        def major = matcher[0][1].toInteger()
        def minor = matcher[0][2].toInteger()
        def patch = matcher[0][3].toInteger()

        // Automatically increment the patch version by default
        patch++

        // Handle overflow cases, where patch or minor needs to reset
        if (patch >= 10) {  // Adjust to your needs, like 10 versions per minor
            patch = 0
            minor++
        }

        if (minor >= 10) {  // Adjust to your needs, like 10 minor versions per major
            minor = 0
            major++
        }

        // Return the updated version in the vX.Y.Z format
        return "v${major}.${minor}.${patch}"
    }

    static String generateVersion(int length = 8) {
        // Define the characters to use in the random version
        String characters = '0123456789abcdefghijklmnopqrstuvwxyz'
        SecureRandom random = new SecureRandom()
        StringBuilder version = new StringBuilder()

        // Generate a random string of specified length
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length())
            version.append(characters.charAt(index))
        }

        return version.toString()
    }
}

