@TestUI
Feature: Assignment Test

  Background: Open Application
    When User is on the home Page
    When User click on consent button
    Then User can see the home page

  Scenario Outline: Verify user is able to calculate tax correctly
    When User select "<country>" country from the drop down
    When user select "<VatRate>" vat rate
    When User enter "<AmountToEntered>" in "<AmountType>" input box
    Then verify Pie chart is displayed correctly
    And Verify User can see "<ExpectedPriceValueOnPieChart>" price on pie chart
    And Verify user can see "<ExpectedVATRateOnPieChart>" VAt on pie chart

    Examples: 
      | country   | VatRate | AmountToEntered | AmountType        | ExpectedPriceValueOnPieChart | ExpectedVATRateOnPieChart |
      | Argentina | 10.5%   |             500 | Value-Added Tax   | 90.5%                        | 9.5%                      |
      | Ukraine   | 20%     |             300 | Price without VAT | 83.3%                        | 16.7%                     |
      | Austria   | 13%     |             200 | Price incl. VAT   | 88.5%                        | 11.5%                     |

  Scenario Outline: Verify Pie chart not displayed when User enter negative value, Special Characters, or number greater than expected
    When User select "<country>" country from the drop down
    When user select "<VatRate>" vat rate
    When User enter "<AmountToEntered>" in "<AmountType>" input box
    Then Verify Pie chart is not displayed

    Examples: 
      | country        | VatRate | AmountToEntered | AmountType        |
      | Argentina      | 2.5%    |             -10 | Value-Added Tax   |
      | Ukraine        | 2.5%    | /%$$            | Price without VAT |
      | United Kingdom | 2.5%    | a               | Price incl. VAT   |
      | United Kingdom | 2.5%    | 999.999.999     | Price incl. VAT   |
