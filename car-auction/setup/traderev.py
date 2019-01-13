import requests;

print "Welcome to the Car Auction System"
print "------------------------------------------------------------------------------------------------------ Enter ^+C to exit anytime"

while True:
    resp = requests.get('http://localhost:8080/vehicles/')
    if resp.status_code != 200:
        print "Error: There seems to be a problem with the System."
    print "Below are the Cars available for auction - "
    for vehicle in resp.json():
        print('{} : {} - {}'.format(vehicle['id'], vehicle['type'], vehicle['name']))
    print "------------------------------------------------------------------------------------------------------ Enter ^+C to exit"
    vehicleID = input('Enter Vehicle ID:\n')

    print(" Vehicle selected : {}".format(vehicleID))
    print "------------------------------------------------------------------------------------------------------"
    action = input('Enter: \n1. Record bid on Vehicle \n2. Display Winning Bid on Vehicle:\n3. List all bids for the vehicle:\n')
    print "------------------------------------------------------------------------------------------------------"
    if action == 1:
        userId = input('Enter user id:\n')
        bidAmount = input('Enter bid amount: \n')
        bid= {"bidAmount": bidAmount, "userId" : userId}
        resp = requests.post('http://localhost:8080/vehicles/{}/bid'.format(vehicleID), json=bid)
        if resp.status_code != 200:
            print "Error: There seems to be a problem with the System."
        else:
            print "Bid recorded successfully"
            print "------------------------------------------------------------------------------------------------------"
    elif action == 2:
        resp = requests.get('http://localhost:8080/vehicles/{}/winningbid'.format(vehicleID))
        if resp.status_code != 200:
            print "Error: There seems to be a problem with the System."
        else:
            print "Winning bid for vehicle {} is {} by {}".format(vehicleID, resp.json()['bidAmount'], resp.json()['user']['username'])
            print "------------------------------------------------------------------------------------------------------"
    elif action == 3:
        resp = requests.get('http://localhost:8080/vehicles/{}/bids'.format(vehicleID))
        if resp.status_code != 200:
            print "Error: There seems to be a problem with the System."
        else:
            print "Below are the Bids available for this car - "
            for bid in resp.json():
                print('Vehicle - {} : Amount - {} : User - {} : Time - {}'.format(bid['vehicle']['id'], bid['bidAmount'], bid['user']['id'], bid['bidTime']))
                print "------------------------------------------------------------------------------------------------------"