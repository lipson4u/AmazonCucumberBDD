@Sanity
Feature: Amazon Checkout
Background: User opens browser and navigates to Application URL
Then user should see the amazon logo

Scenario: Only registered user should be able to checkout after adding items to basket

Then User searches and adds the available cheapest price to the basket
|Item|
|Snickers|
|Skittles|
Then User verifies the basket is calculated correctly
When User try to checkout
Then User is getting redirected to SignIn Page
