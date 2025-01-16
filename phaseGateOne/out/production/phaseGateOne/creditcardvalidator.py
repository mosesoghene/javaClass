def is_valid_length(card_number):
    length = len(card_number);
    return length >= 13 and length <= 16;
  

def determine_crad_type(card_number):
    if (card_number[0] == "4"):
        return "Visa Card";
    elif (card_number[0] == "5"):
        return "MasterCard";
    elif (card_number[0] == "3" and card_number[1] == "7"):
        return "American Express Card";
    elif (card_number[0] == "6"):
        return "Discover Card";

    return "Invalid Card Type";
  
  
def double_even_total(card_number):
    total = 0;
    for i in range(len(card_number) - 2, 0, -2):
        digit = int(card_number[i]);
        digit_doubled = digit * 2;
        total += (digit_doubled // 10 + digit_doubled % 10) if digit_doubled > 9 else digit_doubled;

    return total;

    
    
def odd_total(card_number):
    total = 0;
    for i in  range(len(card_number) - 1, 0, -2):
        total += int(card_number[i]);
    
    return total;
  
  
def is_valid_card(card_number):
    double_even_total = double_even_total(card_number);
    odd_total = odd_total(card_number);
    totalSum = double_even_total + odd_total;

    return totalSum % 10 == 0;
  
 

card_number = input("Enter credit card number: ");

if (is_valid_length(card_number)):
    card_type = determine_crad_type(card_number);
    is_valid = is_valid_card(card_number);


    print("*******************************************************");
    print(f"**Card Type: {card_type}", );
    print(f"**Card Number: {card_number}", );
    print(f"**Card Length: {len(card_number)}", );
    print(f"**Card Validity: {'Valid' if is_valid else 'Invalid'}");
    print("*******************************************************");
else:
    print("Invalid card number length. Must be between 13 and 16 digits.");



  
