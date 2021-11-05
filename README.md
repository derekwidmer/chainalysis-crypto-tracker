# Chainalysis Cryptocurrency Tracker
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

## Questionnaire 
**1. Are there any sub-optimal choices( or short cuts taken due to limited time ) in your implementation?**

I would say that my backend could provide a connection to a database to store historical data. As of right now, I am only storing 20 of the latest values in the program's memory. If I were to expand this to include more data, I would be able to create features around displaying that historical data in a useful way.

Additionally, I intended originally to include a line chart in the frontend of the last 20 prices (collected on a 5 second interval), which is reflected in how I stored my data with a LocalDateTime value included in each price object. However, I was unable to add this feature within the allotted time.


**2. Is any part of it over-designed? ( It is fine to over-design to showcase your skills as long as you are clear about it)**

I spent a good amount of time on the frontend making sure that it was responsive for both web and mobile, and I was very precise with my css. I did this just to show my skill in creating a good-looking frontend. 

Additionally, the prompt doesn't state that previous data should be stored or displayed, so the fact that I am holding previous values in storage for change-over-time comparisons is more than what was asked for.

**3. If you have to scale your solution to 100 users/second traffic what changes would you make, if any?**

I would have to separate the scheduled API calls and data storage from the main application which has the controller responding to REST API requests, and then have more instances of this responding to requests. However, all instances would be pointing towards the same database with the data collected on a schedule by one server.

**4. What are some other enhancements you would have made, if you had more time to do this implementation**

I would have loved to add in the line charts to help the user track the change in price over time, with the prices of the two exchanges plotted against each other. I would also love to add a database in the backend to store historical data, allowing the user to view prices over different time scales, such as a day, week, month or year.

One of the biggest things I would love to add is the ability to customize the exchanges that prices are pulled from as well as the Cryptocurrencies that are being compared. For different Cryptocurrencies, I would have to make routes in my controller that accepted a crypto symbol and then used that to build API calls to the exchanges. When it comes to different exchanges however, it would be more difficult. This is because each exchange returns data in a unique shape, and the way I capture data in my backend requires a model of that shape in order to store the data. I would therefore need to create a different model per exchange.
