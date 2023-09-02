Feature: GoogleTestcases
  Scenario Outline: searching for a new keyword in google
    Given open google website
    When  write a "<keyword>" in search engine
    And  remove the "<keyword>" from search box
    And rewrite a "<keyword2>" again and search with it
    Then number of results should be displayed
    Examples:
      | keyword | keyword2 |
      | foodics | food     |

    Scenario Outline: check redirection to the second page from search result
      Given  open google website
      When write a "<keyword>" in search engine
#      And scroll down to the next page and click on it
#      And scroll down to page three
      Then the number of search result in page two is equal to search result in page three

      Examples:
        | keyword |
        | foodics |

      Scenario Outline: check if there different suggestions displayed at the end of the page
        Given  open google website
        When write a "<keyword>" in search engine
        Then scroll down to different suggestions displayed at the end of the page

        Examples:
          | keyword |
          | foodics |

