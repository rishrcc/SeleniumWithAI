Feature: RCP

  @CarteDebitDiffereProduct @PCE-4638
  Scenario Outline: Verify that <product> details and description are correctly displayed for an RCP customer

    Given I am logged in with <icon> user on weak authentication
    And I am seeing my first name from <fullname> on dashboard
    And I should see <product> on the side menu
    When I click on product from the side menu matching <product>
    Then I should see <product> as title

    Examples:
      | icon | product            | fullname   |
      | RCP  | Ma carte Boulanger | Qsitfnxuuq |

  @CarteDebitDiffereProductHeaders @PCE-4638
  Scenario Outline: Verify that the headers are present and that information about the sections are displayed correctly for <product>

    Given I am logged in with <icon> user on weak authentication
    When I click on product from the side menu matching <product>
    Then I should be able to see the correct headers displayed on the screen
    And I should be able to see the correct infoheader after clicking on the information icon

    Examples:
      | icon | product            |
      | RCP  | Ma carte Boulanger |

  @CarteDebitDiffereOptionsHeaders @PCE-4638
  Scenario Outline: Verify that the options are present and that information about the options are displayed correctly for <product>

    Given I am logged in with <icon> user on weak authentication
    And I click on product from the side menu matching <product>
    When I click on options menu
    Then I should be able to see the correct options headers displayed on the screen

    Examples:
      | icon | product            |
      | RCP  | Ma carte Boulanger |

  @CarteDebitDiffereOptions @Retour @PCE-4638
  Scenario Outline: Verify that the return button on options page is working correctly

    Given I am logged in with <icon> user on weak authentication
    And I click on product from the side menu matching <product>
    And I click on options menu
    When I click on retour button
    Then I should see <product> as title

    Examples:
      | icon | product            |
      | RCP  | Ma carte Boulanger |

  @CarteDebitDiffereOptions @ConfirmationMobile @PCE-4638 @Skip
  Scenario Outline: Verify that the pop up for mobile app qr code is displayed

    Given I am logged in with <icon> user on weak authentication
    And I click on product from the side menu matching <product>
    And I click on options menu
    When I click on Confirmation mobile
    Then I should see a popup to download the mobile app

    Examples:
      | icon | product            |
      | RCP  | Ma carte Boulanger |

  @CarteDebitDiffereOptions @FaireOpposition @PCE-4638
  Scenario Outline: Verify that the first step of opposition is displayed when user clicks on Faire opposition link

    Given I am logged in with <icon> user on weak authentication
    And I click on product from the side menu matching <product>
    And I click on options menu
    When I click on Faire opposition
    Then I should see on faire opposition screen the name of cart owner <name> and correct card number <card_number>

    Examples:
      | icon | product            | name                       | card_number         |
      | RCP  | Ma carte Boulanger | M. QSITFNXUUQ FPMAGJMJYIFP | 503202*********2982 |

  @CarteDebitDiffereOptions @PaiementADistance @PCE-4638
  Scenario Outline: Verify that the correct information are displayed when user clicks on Paiement A Distance link

    Given I am logged in with <icon> user on weak authentication
    And I click on product from the side menu matching <product>
    And I click on options menu
    When I click on paiement a distance
    Then I should see on paiement a distance page the name of cart owner <name> and correct card number <card_number>

    Examples:
      | icon | product            | name                       | card_number         |
      | RCP  | Ma carte Boulanger | M. QSITFNXUUQ FPMAGJMJYIFP | 503202*********2982 |


  @CarteDebitDiffereOptions @PaiementSansContact @PCE-4638
  Scenario Outline: Verify that the correct information are displayed when user clicks on Paiement Sans Contact link

    Given I am logged in with <icon> user on weak authentication
    And I click on product from the side menu matching <product>
    And I click on options menu
    When I click on paiement sans contact
    Then I should see on paiement sans contact page the name of cart owner <name> and correct card number <card_number>

    Examples:
      | icon | product            | name                       | card_number         |
      | RCP  | Ma carte Boulanger | M. QSITFNXUUQ FPMAGJMJYIFP | 503202*********2982 |

  @CarteDebitDiffereOptions @Verouiller @PCE-4638 @Test
  Scenario Outline: Verify that the correct information are displayed when user clicks on Verouiller ma carte bancaire link

    Given I am logged in with <icon> user on weak authentication
    And I click on product from the side menu matching <product>
    And I click on options menu
    When I click on verouiller ma carte bancaire
    Then I should see on verouiller ma carte bancaire page the name of cart owner <name> and correct card number <card_number>

    Examples:
      | icon | product            | name                       | card_number         |
      | RCP  | Ma carte Boulanger | M. QSITFNXUUQ FPMAGJMJYIFP | 503202*********2982 |