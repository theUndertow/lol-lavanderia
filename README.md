# lol-lavanderia-online

Desenvolvimento de um sistema de controle de lavanderia denominado como lol

## external dependencies:

MySQL 5.7.25 Community Server (GPL)

Mozilla Firefox 66.0.3

## netbeans clone process:

Team -> Git -> Clone...

## build and run:

Right click on project -> Build with dependencies

Right click on project -> Clean and Build

Right click on project -> Run

## Create a new user
```sql 
    CREATE USER 'dac'@'localhost' IDENTIFIED BY 'dac';
```

## Grant all privileges to this user
```sql
    GRANT ALL PRIVILEGES ON * . * TO 'dac'@'localhost';
```