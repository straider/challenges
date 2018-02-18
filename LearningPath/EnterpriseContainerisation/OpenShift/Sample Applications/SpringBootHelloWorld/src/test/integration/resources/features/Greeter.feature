Feature: Basic Greeter

  As A greeting service
  I Want to delegate handling greeting messages and their formats
  So That I can focus on the request and response instead of internal logic.

  Scenario Outline: Greet by using default format
    Given the default greeting format
    When a request to speak to <someone> is issued
    Then the response is <message>

    Examples:
      | someone     | message             |
      |             | Hello, World!       |
      | José        | Hello, José!        |
      | José Carlos | Hello, José Carlos! |

  Scenario Outline: Greet using a specific format
    Given the <greeting> is specific
    When a request to speak to <someone> is issued
    Then the response is <message>

    Examples:
      | greeting  | someone     | message               |
      |           |             | Hello, World!         |
      |           | José        | Hello, José!          |
      | Hi        | José Carlos | Hi, José Carlos!      |
      | Greetings | earthling   | Greetings, earthling! |
