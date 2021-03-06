# PathSearch

This is a pathsearch service, access to current dir get every folders and files. GUI allows user input the name of the folder or file, output will be the path of files or folders that have most likely same name.

## Requirements
- Docker
- JavaFX
- Java 11
- Make

## How To Use
- Cd to PathSearch folder
```bash
cd PathSearch
```
- Use make command to start docker server
```bash
make docker-up
```
- Use maven package to execute
```bash
mvn package exec:java
```

## GUI

- **Default GUI**

![Search for file or folder path, type in the text field and click search buttom](https://upload.cc/i1/2022/04/05/REhAeW.png)

**Search for file or folder path, type in the text field and click search buttom**

- **Example**

![](https://upload.cc/i1/2022/04/05/niBqZe.png)

**Output the path that matches the name(substring) that type in**

## Tech Stack
- Java
- JavaFX
- Docker
- MySQL
- Makefile
- Maven