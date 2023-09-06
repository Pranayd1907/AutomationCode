
Feature: Should contain a button to navigate to support page

  Scenario: Should contain a button to navigate to support page
    Given URL has given
    When I click on support Reques button 
    Then I should redirect on support 
    When I choose any one value from Support
    And click on support Reqres
    Then Page should redirect on stripe checkout And user click on browser back button
    When user scroll page and click on upgrade button
    Then facility to provide option for subscribe
    
