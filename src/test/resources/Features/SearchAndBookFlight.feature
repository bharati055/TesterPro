#Author: Vikas Bharati
#Feature Description : Our website users should be able search flight to book.
Feature: Our website users should be able search flight to book

  @P1 @regression @smoke @searchFlight
  Scenario Outline: [TestID-01] User enters departure, destination city code and selects todays date to search for flights
    Given User has launched search flight page
    And User enters <departure> in Departure field
    And User enters <destination> in Destination field
    And User selects <date> in Date field
    When clicks on Search for flight button
    Then user can see the flight searched
    And closes browser

    Examples: 
      | departure | destination | date  | ExpectedFlightStatus |
      | CGN       | BER         | today | on time              |
