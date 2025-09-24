Feature: User Management

Scenario: Verify if name of already created user populates in the list on User Managment page

Given Application url is launched
And User is logged into the system
When  User clicks on PIM menu
And  User clicks on Add button
And  Creates and user with valid details
When User clicks in Admin menu
And Click on Add button on user management  page
When User selects role as ESS
And Enters name as Employe name
Then Populated list must contain newly created users name   



