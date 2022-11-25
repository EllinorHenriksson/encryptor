# Encryptor and Hasher
Two applications, one to encrypt/decrypt messages, and one to hash strings.

## Encryptor
### Start the application
Run the application by changing the ```application``` property in the ```build.gradle``` file to the following:

```
application {
    // Define the main class for the application.
    mainClass = 'encryptor.controller.App'
}
```

Then, enter ```./gradlew run -q --console=plain>``` in the terminal.

### How to use the application
Follow the instructions in the console.

## Hasher
### Start the application
Run the application by changing the ```application``` property in the ```build.gradle``` file to the following:

```
application {
    // Define the main class for the application.
    mainClass = 'hasher.controller.App'
}
```

Then, enter ```./gradlew run -q --console=plain>``` in the terminal.

### How to use the application
When the application is run, it tests the hash function and outputs the results to the terminal. (The latest test results have been manually stored in the ```test-results``` folder, in [uniformity.md](./test-results/uniformity.md) and [randomness.md](./test-results/randomness.md).)
