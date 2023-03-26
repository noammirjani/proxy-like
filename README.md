
# Project Title

Proxy-like Functionality for Controlling URL Resource Downloads.
This console-based application allows users to test proxy-like functions for controlling the downloading of URL resources from the web. The program offers several options for denying access to specific types of resources, including blocked sites, images, HTML documents, and resources containing cookies.

## Authors

- [@Noam Mirjani]()  Noammir@edu.hac.ac.il
- [@Ariel Amon]()    Arielam@edu.hac.ac.il


## Installation

```bash

  git clone https://github.com/Solange-s-Courses/ex2-java-neviim-ex2_ariel_amon_noam_mirjani.git


```


## Usage

The program implements several console commands that allow users to manage blocked sites and control downloads:

b <url>: Blocks a URL and adds it to the list of blocked URLs saved to the file.

u <url>: Unblocks a URL and updates the list.

p: Prints the current list of blocked sites alphabetically ordered.

q: Exits the program.

d <-options> <url> <out>: Downloads the contents of the given URL to a file, applying the specified denying options.Download options can be defined in any order, and redundant options. possible flags:
i: Blocks images
c: Blocks HTTP cookies
h: Blocks HTML documents
b: Denies access to blocked sites.


## Design patterns
The program is designed using several design patterns to improve code structure and maintainability.
The Command pattern was chosen for implementing the menu commands as it provides a clear separation between the commands and their implementation, making it easier to modify and extend the program's functionality without affecting other parts of the code.

The Singleton pattern was used for the file manager class to ensure that all file operations are centralized and managed by a single instance of the class, improving code maintainability and reducing the risk of errors.

The Decorator pattern was chosen to implement the download options as it allows for flexible and dynamic addition of functionality to the download process. By using the decorator pattern, the program can add or remove download options easily, without modifying the core functionality of the program. Additionally, it enables the program to check the validity of the URL based on the user flags and provide an appropriate response, improving the user experience.