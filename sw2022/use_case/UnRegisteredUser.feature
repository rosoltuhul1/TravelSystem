Feature: Unregister user
 Scenario: successful unregister
 Given a user with ID "1234567" , name "Rosol" , email "rosol@gmail.com" , address "Rr street" ,postal code "H3H2T5" , and city "Nablus" id registered in the touristSystem
 And  admin is logged in
 When  try to unregister the user 
 Then the user is out of the touristSystem
 
Scenario: user has registered trips
Given a user with ID "1234567" , name "Rosol" , email "rosol@gmail.com" , address "Rr street" ,postal code "H3H2T5" , and city "Nablus" id registered in the touristSystem
 And  admin is logged in
 And user has registered trip
 When  try to unregister the user
 Then the user sould still in the touristSystem
 
 Scenario: user has fine unpaid 
Given a user with ID "1234567" , name "Rosol" , email "rosol@gmail.com" , address "Rr street" ,postal code "H3H2T5" , and city "Nablus" id registered in the touristSystem
 And  admin is logged in
 And user has fine unpaid
 When try to unregister the user
 Then the user sould still in the touristSystem
 