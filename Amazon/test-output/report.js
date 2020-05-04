$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/java/amazon/feature/amazonregistration.feature");
formatter.feature({
  "line": 2,
  "name": "Amazon Checkout",
  "description": "",
  "id": "amazon-checkout",
  "keyword": "Feature",
  "tags": [
    {
      "line": 1,
      "name": "@Sanity"
    }
  ]
});
formatter.before({
  "duration": 7829520777,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "User opens browser and navigates to Application URL",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "user should see the amazon logo",
  "keyword": "Then "
});
formatter.match({
  "location": "checkoutstepdefinition.i_should_see_the_amazon_logo()"
});
formatter.result({
  "duration": 164371669,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Only registered user should be able to checkout after adding items to basket",
  "description": "",
  "id": "amazon-checkout;only-registered-user-should-be-able-to-checkout-after-adding-items-to-basket",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "User searches and adds the available cheapest price to the basket",
  "rows": [
    {
      "cells": [
        "Item"
      ],
      "line": 9
    },
    {
      "cells": [
        "Snickers"
      ],
      "line": 10
    },
    {
      "cells": [
        "Skittles"
      ],
      "line": 11
    }
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "User verifies the basket is calculated correctly",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "User try to checkout",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "User is getting redirected to SignIn Page",
  "keyword": "Then "
});
formatter.match({
  "location": "checkoutstepdefinition.user_searches_for_Cheapest_Snickers_and_Skittles(DataTable)"
});
formatter.result({
  "duration": 125241608062,
  "status": "passed"
});
formatter.match({
  "location": "checkoutstepdefinition.user_verifies_the_basket_is_calculated_correctly()"
});
formatter.result({
  "duration": 198705900,
  "status": "passed"
});
formatter.match({
  "location": "checkoutstepdefinition.user_try_to_checkout()"
});
formatter.result({
  "duration": 1003968604,
  "status": "passed"
});
formatter.match({
  "location": "checkoutstepdefinition.user_is_getting_redirected_to_SignIn_Page()"
});
formatter.result({
  "duration": 30401082,
  "status": "passed"
});
formatter.after({
  "duration": 853047829,
  "status": "passed"
});
});