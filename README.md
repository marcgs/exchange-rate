[![Build Status](https://travis-ci.org/marcgs/exchange-rate.svg?branch=master)](https://travis-ci.org/marcgs/exchange-rate)


# exchange-rate

 Simple REST API endpoint to get the conversion rate for Euro to any other currency provided by ECB for any of the past 90 days.
 
# Run locally

* Build and run the application with `mvn spring-boot:run`
* Access the API by running `curl localhost:8080/api/euroxref` or `curl localhost:8080/api/euroxref/<days_in_the_past_from_today>`

 
