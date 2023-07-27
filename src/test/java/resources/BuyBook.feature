Feature: Checkout for a customer.
  They are searching for the book, add it to cart, proceeding to checkout and pay for it.

  Scenario: Proceed to checkout, fill all the details
    Given I am a new customer and I open the "Home page"
    And I search for "Пришвидшений курс Python"
    And I select the product with title "Пришвидшений курс Python"
    And I click "Add to basket" button for the given needed product and close the book info page
    And I click on the basket icon on "Search Results Page"
    And I am filling the details:
      | name       | test          |
      | secondName | test          |
      | phone      | 0123356885    |
      | email      | test@test.com |
      | country    | Україна       |
      | city       | Київ          |
      | address    | 22220         |
    And I press the "Continue to payment" button
    Then I feel my card details and press pay button
      | cardNumber | 1111111111111111 |
      | mm         | 11               |
      | yy         | 11               |
      | cvv        | 111              |