Feature: Impayés - Consultation des pages produits

  @UnpaidSchedule @Pre-contentieux @PCE-4734
  Scenario Outline: Verify that after logging in with existing unpaid users of type gestion specifique pre-contentieux, the details of the unpaid scheduled are correctly displayed

    Given I am logged in with an existing unpaid user of type gestion specifique pre-contentieux
    And I see label for unpaid products
    And I see the product <subtitle> is marked as unpaid on the side menu
    When I click on product from the side menu matching <subtitle>
    And I should see actions verifier mes coordonnees and verifier mes informations bancaires
    And I should see that amount paid in the message displayed matches the total amount unpaid

    Examples:
      | subtitle        |
      | chez ALINEA.COM |