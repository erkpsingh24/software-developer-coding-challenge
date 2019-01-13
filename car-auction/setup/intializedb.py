import requests


print "Initialising Database with some testing values"
user1 = {"username" : "user 1"};
user2 = {"username" : "user 2"};
user3 = {"username" : "user 3"};
user4 = {"username" : "user 4"};
user5 = {"username" : "user 5"};
requests.post('http://localhost:8080/users', json=user1)
requests.post('http://localhost:8080/users', json=user2)
requests.post('http://localhost:8080/users', json=user3)
requests.post('http://localhost:8080/users', json=user4)
requests.post('http://localhost:8080/users', json=user5)


vehicle1 = {"type": "Truck", "name" : "one more truck" }
vehicle2 = {"type": "Bike", "name" : "fast bike" }
vehicle3 = {"type": "Car", "name" : "Sports car" }
vehicle4 = {"type": "Car", "name" : "Sedan" }
requests.post('http://localhost:8080/vehicles', json=vehicle1)
requests.post('http://localhost:8080/vehicles', json=vehicle2)
requests.post('http://localhost:8080/vehicles', json=vehicle3)
requests.post('http://localhost:8080/vehicles', json=vehicle4)


print "DB successfully populated! Run traderev.py to start!"
