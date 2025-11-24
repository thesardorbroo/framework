# Commons (common codes as library)

## Overview
- [Installation](#installation)
  - [Maven](#maven)
- [Tools](#tools)
  - [Automated CRUD](#automated-crud)
  - [Properties printer](#properties-printer)
- Contributing
  - Deploying

## Installation

### Maven
There are few steps for downloading `.jar` from GitHub package registry
- Declaring `server` tag in `settings.xml`
- Declaring `repository` and `dependency` tags in `pom.xml` of project
- Executing command for downloading the `.jar` from GitHub package registry

### Declaring `server` tag in `settings.xml`
```xml
    <!-- Server ID must be unique in settings.xml -->
    <!-- This server ID must be same with ID which is declared in repository tag in pom.xml -->
    <server>
      <id>server-id</id>
      <username>YOUR_GITHUB_USERNAME</username>
      <!-- Use a Personal Access Token (PAT) here, not your GitHub password -->
      <password>YOUR_PERSONAL_ACCESS_TOKEN</password>
    </server>
```

> [!TIP]
> You can use `settings.xml` file without changing default `settings.xml` of Maven

### Declaring `repository` and `dependency` tags to `pom.xml` file of project
```xml
    <repositories>
        <repository>
            <id>server-id</id>
            <!-- OWNER is the GitHub username or organization that hosts the package -->
            <!-- REPOSITORY is the repository name on GitHub (not the package name) -->
            <url>https://maven.pkg.github.com/thesardorbroo/framework</url>
            <releases><enabled>true</enabled></releases>
            <snapshots><enabled>false</enabled></snapshots>
        </repository>
    </repositories>

    <dependencies>
        <dependency>
            <groupId>uz.sardorbroo</groupId>
            <artifactId>commons</artifactId>
            <version>1.0.0</version>
        </dependency>
    </dependencies>
```

### Executing command
Command installs `.jar` from GitHub package registry
```bash
mvn clean install
```

> [!TIP]
> use `-s` flag for specifying `settings.xml` file
> ```bash
> mvn clean install -s <path to settings.xml>
> ```

## Tools
- Automated CRUD
- Properties printer

### Automated CRUD

### Properties printer
- Usage
- Customizing

Tool prints properties class which has annotated with `@ConfigurationProperties` and `@Configuration` annotation.

### Usage
Add property to `application.yml` for enabling tool. 
```yml
logging:
  level:
    <package name>: info

printer:
  enabled: true # takes boolean [true | false]
  type: info # takes string [info | debug | trace]

scanner:
  enabled: true # takes boolean [true | false]
  base: <package name>
```

### Customizing