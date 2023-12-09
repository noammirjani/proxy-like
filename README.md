# Proxy-like Functionality for Controlling URL Resource Downloads

## Table of Contents

- [Introduction](#introduction)
- [Authors](#authors)
- [Installation](#installation)
- [Usage](#usage)
- [Design Patterns](#design-patterns)
- [Contributing](#contributing)
- [License](#license)

## Introduction

This console-based Java application provides proxy-like functionality to control the downloading of URL resources from the web. It offers options to deny access to specific types of resources such as blocked sites, images, HTML documents, and resources containing cookies.

## Authors

- [@Noam Mirjani](mailto:Noammir@edu.hac.ac.il)
- [@Ariel Amon](mailto:Arielam@edu.hac.ac.il)

## Installation

Clone the repository using:
```bash
git clone https://github.com/noammirjani/proxy-like.git
```
Compile the Java files using:
```bash 
javac Main.java
```
Run the program using:
``` bash
java Main
```

# Usage

The program implements various console commands:

- **b:** Blocks a URL and adds it to the list of blocked URLs saved to a file.
- **u:** Unblocks a URL and updates the list.
- **p:** Prints the current list of blocked sites alphabetically ordered.
- **q:** Exits the program.
- **d <-options>:** Downloads the contents of the given URL to a file, applying specified denying options. Download options can be defined in any order, and redundant options include:
    - **i:** Blocks images
    - **c:** Blocks HTTP cookies
    - **h:** Blocks HTML documents
    - **b:** Denies access to blocked sites
## Design Patterns

The program utilizes various design patterns for improved code structure and maintainability:

- **Command Pattern:** Implemented for menu commands, providing clear separation between commands and their implementation.
- **Singleton Pattern:** Used for the file manager class to centralize and manage file operations within a single instance, enhancing maintainability and reducing error risks.
- **Decorator Pattern:** Employed for download options, allowing flexible addition and removal of functionality to the download process. It enables easy modification based on user flags and provides a better user experience by checking URL validity appropriately.

## Contributing

Include guidelines for others to contribute to the project, like pull request procedures, code formatting, etc.

## Dependencies

This program does not require any external dependencies beyond the JDK.

## Acknowledgements
This program was developed as part of the Web Development course at HAC.

Feel free to adjust the JDK version or add any specific commands needed for your Java application to compile and run. Additionally, you can expand on dependencies or any further instructions required for users to execute your program successfully.

