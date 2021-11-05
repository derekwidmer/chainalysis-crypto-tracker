# Chainalysis Crytocurrency Tracker
This project was built as a technical assessment for the Chainalysis interview process. It tracks the buy and sell prices of Bitcoin and Ethereum on different exchanges and makes a recommendation on which exchange to buy/sell on.

The frontend is built with React using Bootstrap and SASS. The backend is built with Spring Boot.

## How to Run and Build
### Frontend

To build and run this project, you will need:
- [Node/npm](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm "Node/npm")
- [Yarn](https://classic.yarnpkg.com/en/docs/install#mac-stable "Yarn")
- [serve](https://www.npmjs.com/package/serve "serve")

1.  Navigate to the cryptoapp-frontend directory
2. Run:
```console
npm run build
serve -s build -l 3000
```

### Backend
To build and run the backend, you will need:
- [Java JDK 17](https://www.oracle.com/java/technologies/downloads/ "Java JDK 17")
- [Maven](https://maven.apache.org/install.html "Maven")
1. Navigate to the cryptoapp-backend directory.
2. Run:
```console
maven package
java -jar target/cryptoapp-backend-0.0.1-SNAPSHOT.jar
```

