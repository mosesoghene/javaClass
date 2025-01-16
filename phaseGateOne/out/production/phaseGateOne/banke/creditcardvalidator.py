def isValidLength(cardNumber):
    length = len(cardNumber);
    return length >= 13 and length <= 16;
  

def determineCardType(cardNumber):
    if (cardNumber[0] == "4"):
        return "Visa Card";
    elif (cardNumber[0] == "5"):
        return "MasterCard";
    elif (cardNumber[0] == "3" and cardNumber[1] == "7"):
        return "American Express Card";
    elif (cardNumber[0] == "6"):
        return "Discover Card";

    return "Invalid Card Type";
  
  
def sumOfDoubleEvenPlace(cardNumber):
    total = 0;
    for i in range(len(cardNumber) - 2, 0, -2):
        digit = int(cardNumber[i]);
        doubledDigit = digit * 2;
        total += (doubledDigit // 10 + doubledDigit % 10) if doubledDigit > 9 else doubledDigit;

    return total;

    
    
def sumOfOddPlace(cardNumber):
    total = 0;
    for i in  range(len(cardNumber) - 1, 0, -2):
        total += int(cardNumber[i]);
    
    return total;
  
  
def isValidCard(cardNumber):
    sumOfDoubleEven = sumOfDoubleEvenPlace(cardNumber);
    sumOfOdd = sumOfOddPlace(cardNumber);
    totalSum = sumOfDoubleEven + sumOfOdd;

    return totalSum % 10 == 0;
  
 

cardNumber = input("Enter credit card number: ");

if (isValidLength(cardNumber)):
    cardType = determineCardType(cardNumber);
    isValid = isValidCard(cardNumber);


    print("*******************************************************");
    print(f"**Card Type: {cardType}", );
    print(f"**Card Number: {cardNumber}", );
    print(f"**Card Length: {len(cardNumber)}", );
    print(f"**Card Validity: {'Valid' if isValid else 'Invalid'}");
    print("*******************************************************");
else:
    print("Invalid card number length. Must be between 13 and 16 digits.");



  
