:: MongoDB :: Windows ::
========================

# Overview

# Resources

- [Install MongoDB Community Edition on Windows](https://docs.mongodb.com/manual/tutorial/install-mongodb-on-windows/)

## Tutorials

## Articles

- [Install, setup and start MongoDB on Windows](https://blog.ajduke.in/2013/04/10/install-setup-and-start-mongodb-on-windows/)
- [Install, Set Up and Start MongoDB on Windows](https://dzone.com/articles/install-set-and-start-mongodb)

## Tools

- [RockMongo](http://rockmongo.com/)
- [HumongouS.io](https://www.humongous.io/)
- [Robomongo](https://robomongo.org/)
- [3T MongoChef](http://3t.io/mongochef/)
- [Genghis](http://genghisapp.com/)
- [Mongo Admin](http://www.mongoadmin.org/)
- [Mongo Management Studio](http://mms.litixsoft.de/)
- [MongoBooster](https://mongobooster.com/)

# Steps

- Download [MongoDB Community Edition 3.4.1](http://www.mongodb.org/downloads), with SSL;
- Install MongoDB, using the downloaded msi, to ```C:\Hosting\MongoDB\3.4.1\```;
- Run MongoDB server ```mongod```.

## Automated Installation

To do an automated (unattended) installation then issue the following command on a Windows Command Prompt, opened on the folder that contains the downloaded MongoDB installation file:

```bash
msiexec.exe /q /i mongodb-win32-x86_64-2008plus-ssl-3.4.1-signed.msi ^
            INSTALLLOCATION="C:\Hosting\MongoDB\3.4.1\" ^
            ADDLOCAL="all"
```

## MongoDB Deamon

To start MongoDB server using a data folder other than ```C:\data\db\``` then issue the following command:

```bash
mkdir C:\Hosting\MongoDB\data
mongod --port 27017 --dbpath "C:\Hosting\MongoDB\data"
```

By default it runs on port 27017.

## Windows Service

To start MongoDB server as a Windows service then follow these steps:

- Create a configuration file, named mongod.cfg, on the MongoDB top folder, such as ```C:\Hosting\MongoDB\3.4.1\```;
- Create a folder to hold the logs, such as ```C:\Hosting\MongoDB\logs```;
- Install the MongoDB service;
- Start the MongoDB service.

### Configuration File

The following is the example configuration file:

```yaml
systemLog:
    destination: file
    path: C:\Hosting\MongoDB\logs\mongod.log
storage:
    dbPath: C:\Hosting\MongoDB\data
net:
   bindIp: 127.0.0.1
   port: 27017
```

### Install MongoDB service

To install the MongoDB server as a Windows service then issue one of the following commands:

```bash
mongod --config "C:\Hosting\MongoDB\3.4.1\mongod.cfg" --install

sc create MongoDB binPath= "\"C:\Hosting\MongoDB\3.4.1\bin\mongod.exe\" --service --config=\"C:\Hosting\MongoDB\3.4.1\mongod.cfg\"" DisplayName= "MongoDB" start= "auto"
```

**Note**: by default the service name is MongoDB. Also bare in mind that ```sc``` command requires a whitespace between the equal sign "=" and the value.

### Start / Stop MongoDB service

To start the MongoDB service then issue the following command:

```bash
net start MongoDB
```

To stop the MongoDB service then issue the following command:

```bash
net stop MongoDB
```

### Remove MongoDB service

To remove the MongoDB service then issue one of the following commands:

```bash
mongod --remove

sc delete MongoDB
```
